package com.hjq.permissions;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import f2.y;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
/* loaded from: classes.dex */
public final class PermissionFragment extends Fragment implements Runnable {
    private static final List<Integer> REQUEST_CODE_ARRAY = new ArrayList();
    @Nullable
    private OnPermissionCallback mCallBack;
    private boolean mDangerousRequest;
    @Nullable
    private IPermissionInterceptor mInterceptor;
    private boolean mRequestFlag;
    private int mScreenOrientation;
    private boolean mSpecialRequest;

    public static void launch(@NonNull Activity activity, @NonNull ArrayList<String> arrayList, @NonNull IPermissionInterceptor iPermissionInterceptor, @Nullable OnPermissionCallback onPermissionCallback) {
        int nextInt;
        List<Integer> list;
        PermissionFragment permissionFragment = new PermissionFragment();
        Bundle bundle = new Bundle();
        do {
            nextInt = new Random().nextInt((int) Math.pow(2.0d, 8.0d));
            list = REQUEST_CODE_ARRAY;
        } while (list.contains(Integer.valueOf(nextInt)));
        list.add(Integer.valueOf(nextInt));
        bundle.putInt("request_code", nextInt);
        bundle.putStringArrayList("request_permissions", arrayList);
        permissionFragment.setArguments(bundle);
        permissionFragment.setRetainInstance(true);
        permissionFragment.setRequestFlag(true);
        permissionFragment.setCallBack(onPermissionCallback);
        permissionFragment.setInterceptor(iPermissionInterceptor);
        permissionFragment.attachActivity(activity);
    }

    public void attachActivity(@NonNull Activity activity) {
        activity.getFragmentManager().beginTransaction().add(this, toString()).commitAllowingStateLoss();
    }

    public void detachActivity(@NonNull Activity activity) {
        activity.getFragmentManager().beginTransaction().remove(this).commitAllowingStateLoss();
    }

    @Override // android.app.Fragment
    public void onActivityResult(int i, int i5, @Nullable Intent intent) {
        ArrayList<String> stringArrayList;
        Activity activity = getActivity();
        Bundle arguments = getArguments();
        if (activity != null && arguments != null && !this.mDangerousRequest && i == arguments.getInt("request_code") && (stringArrayList = arguments.getStringArrayList("request_permissions")) != null && !stringArrayList.isEmpty()) {
            this.mDangerousRequest = true;
            PermissionUtils.postActivityResult(stringArrayList, this);
        }
    }

    @Override // android.app.Fragment
    @SuppressLint({"SourceLockedOrientationActivity"})
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity = getActivity();
        if (activity == null) {
            return;
        }
        int requestedOrientation = activity.getRequestedOrientation();
        this.mScreenOrientation = requestedOrientation;
        if (requestedOrientation != -1) {
            return;
        }
        PermissionUtils.lockActivityOrientation(activity);
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.mCallBack = null;
    }

    @Override // android.app.Fragment
    public void onDetach() {
        super.onDetach();
        Activity activity = getActivity();
        if (activity != null && this.mScreenOrientation == -1 && activity.getRequestedOrientation() != -1) {
            activity.setRequestedOrientation(-1);
        }
    }

    @Override // android.app.Fragment
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (strArr.length != 0 && iArr.length != 0) {
            Bundle arguments = getArguments();
            Activity activity = getActivity();
            if (activity != null && arguments != null && this.mInterceptor != null && i == arguments.getInt("request_code")) {
                OnPermissionCallback onPermissionCallback = this.mCallBack;
                this.mCallBack = null;
                IPermissionInterceptor iPermissionInterceptor = this.mInterceptor;
                this.mInterceptor = null;
                PermissionUtils.optimizePermissionResults(activity, strArr, iArr);
                ArrayList asArrayList = PermissionUtils.asArrayList(strArr);
                REQUEST_CODE_ARRAY.remove(Integer.valueOf(i));
                detachActivity(activity);
                List<String> grantedPermissions = PermissionApi.getGrantedPermissions(asArrayList, iArr);
                if (grantedPermissions.size() == asArrayList.size()) {
                    iPermissionInterceptor.grantedPermissionRequest(activity, asArrayList, grantedPermissions, true, onPermissionCallback);
                    iPermissionInterceptor.finishPermissionRequest(activity, asArrayList, false, onPermissionCallback);
                    return;
                }
                List<String> deniedPermissions = PermissionApi.getDeniedPermissions(asArrayList, iArr);
                iPermissionInterceptor.deniedPermissionRequest(activity, asArrayList, deniedPermissions, PermissionApi.isPermissionPermanentDenied(activity, deniedPermissions), onPermissionCallback);
                if (!grantedPermissions.isEmpty()) {
                    iPermissionInterceptor.grantedPermissionRequest(activity, asArrayList, grantedPermissions, false, onPermissionCallback);
                }
                iPermissionInterceptor.finishPermissionRequest(activity, asArrayList, false, onPermissionCallback);
            }
        }
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        if (!this.mRequestFlag) {
            detachActivity(getActivity());
        } else if (this.mSpecialRequest) {
        } else {
            this.mSpecialRequest = true;
            requestSpecialPermission();
        }
    }

    public void requestDangerousPermission() {
        int i;
        Activity activity = getActivity();
        Bundle arguments = getArguments();
        if (activity != null && arguments != null) {
            int i5 = arguments.getInt("request_code");
            ArrayList<String> stringArrayList = arguments.getStringArrayList("request_permissions");
            if (stringArrayList != null && !stringArrayList.isEmpty()) {
                if (!AndroidVersion.isAndroid6()) {
                    int size = stringArrayList.size();
                    int[] iArr = new int[size];
                    for (int i6 = 0; i6 < size; i6++) {
                        if (PermissionApi.isGrantedPermission(activity, stringArrayList.get(i6))) {
                            i = 0;
                        } else {
                            i = -1;
                        }
                        iArr[i6] = i;
                    }
                    onRequestPermissionsResult(i5, (String[]) stringArrayList.toArray(new String[0]), iArr);
                } else if (AndroidVersion.isAndroid13() && stringArrayList.size() >= 2 && PermissionUtils.containsPermission(stringArrayList, Permission.BODY_SENSORS_BACKGROUND)) {
                    ArrayList<String> arrayList = new ArrayList<>(stringArrayList);
                    arrayList.remove(Permission.BODY_SENSORS_BACKGROUND);
                    splitTwiceRequestPermission(activity, stringArrayList, arrayList, i5);
                } else if (AndroidVersion.isAndroid10() && stringArrayList.size() >= 2 && PermissionUtils.containsPermission(stringArrayList, Permission.ACCESS_BACKGROUND_LOCATION)) {
                    ArrayList<String> arrayList2 = new ArrayList<>(stringArrayList);
                    arrayList2.remove(Permission.ACCESS_BACKGROUND_LOCATION);
                    splitTwiceRequestPermission(activity, stringArrayList, arrayList2, i5);
                } else if (AndroidVersion.isAndroid10() && PermissionUtils.containsPermission(stringArrayList, Permission.ACCESS_MEDIA_LOCATION) && PermissionUtils.containsPermission(stringArrayList, Permission.READ_EXTERNAL_STORAGE)) {
                    ArrayList<String> arrayList3 = new ArrayList<>(stringArrayList);
                    arrayList3.remove(Permission.ACCESS_MEDIA_LOCATION);
                    splitTwiceRequestPermission(activity, stringArrayList, arrayList3, i5);
                } else {
                    requestPermissions((String[]) stringArrayList.toArray(new String[stringArrayList.size() - 1]), i5);
                }
            }
        }
    }

    public void requestSpecialPermission() {
        Bundle arguments = getArguments();
        Activity activity = getActivity();
        if (arguments != null && activity != null) {
            boolean z2 = false;
            for (String str : arguments.getStringArrayList("request_permissions")) {
                if (PermissionApi.isSpecialPermission(str) && !PermissionApi.isGrantedPermission(activity, str) && (AndroidVersion.isAndroid11() || !PermissionUtils.equalsPermission(str, Permission.MANAGE_EXTERNAL_STORAGE))) {
                    startActivityForResult(PermissionUtils.getSmartPermissionIntent(activity, PermissionUtils.asArrayList(str)), getArguments().getInt("request_code"));
                    z2 = true;
                }
            }
            if (z2) {
                return;
            }
            requestDangerousPermission();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!isAdded()) {
            return;
        }
        requestDangerousPermission();
    }

    public void setCallBack(@Nullable OnPermissionCallback onPermissionCallback) {
        this.mCallBack = onPermissionCallback;
    }

    public void setInterceptor(IPermissionInterceptor iPermissionInterceptor) {
        this.mInterceptor = iPermissionInterceptor;
    }

    public void setRequestFlag(boolean z2) {
        this.mRequestFlag = z2;
    }

    public void splitTwiceRequestPermission(@NonNull final Activity activity, @NonNull final ArrayList<String> arrayList, @NonNull ArrayList<String> arrayList2, final int i) {
        final ArrayList arrayList3 = new ArrayList(arrayList);
        Iterator<String> it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList3.remove(it.next());
        }
        launch(activity, arrayList2, new IPermissionInterceptor() { // from class: com.hjq.permissions.PermissionFragment.1
            @Override // com.hjq.permissions.IPermissionInterceptor
            public /* synthetic */ void deniedPermissionRequest(Activity activity2, List list, List list2, boolean z2, OnPermissionCallback onPermissionCallback) {
                y.y(this, activity2, list, list2, z2, onPermissionCallback);
            }

            @Override // com.hjq.permissions.IPermissionInterceptor
            public /* synthetic */ void finishPermissionRequest(Activity activity2, List list, boolean z2, OnPermissionCallback onPermissionCallback) {
                y.n3(this, activity2, list, z2, onPermissionCallback);
            }

            @Override // com.hjq.permissions.IPermissionInterceptor
            public /* synthetic */ void grantedPermissionRequest(Activity activity2, List list, List list2, boolean z2, OnPermissionCallback onPermissionCallback) {
                y.zn(this, activity2, list, list2, z2, onPermissionCallback);
            }

            @Override // com.hjq.permissions.IPermissionInterceptor
            public /* synthetic */ void launchPermissionRequest(Activity activity2, List list, OnPermissionCallback onPermissionCallback) {
                y.gv(this, activity2, list, onPermissionCallback);
            }
        }, new OnPermissionCallback() { // from class: com.hjq.permissions.PermissionFragment.2
            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$onGranted$0(Activity activity2, ArrayList arrayList4, ArrayList arrayList5, int i5) {
                PermissionFragment.launch(activity2, arrayList4, new 1(this), new 2(this, arrayList5, i5, arrayList4));
            }

            @Override // com.hjq.permissions.OnPermissionCallback
            public void onDenied(@NonNull List<String> list, boolean z2) {
                if (!PermissionFragment.this.isAdded()) {
                    return;
                }
                int[] iArr = new int[arrayList.size()];
                Arrays.fill(iArr, -1);
                PermissionFragment.this.onRequestPermissionsResult(i, (String[]) arrayList.toArray(new String[0]), iArr);
            }

            @Override // com.hjq.permissions.OnPermissionCallback
            public void onGranted(@NonNull List<String> list, boolean z2) {
                long j2;
                if (z2 && PermissionFragment.this.isAdded()) {
                    if (AndroidVersion.isAndroid13()) {
                        j2 = 150;
                    } else {
                        j2 = 0;
                    }
                    PermissionUtils.postDelayed(new y(this, activity, arrayList3, arrayList, i), j2);
                }
            }
        });
    }
}
