package com.hjq.permissions;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class PermissionPageFragment extends Fragment implements Runnable {
    @Nullable
    private OnPermissionPageCallback mCallBack;
    private boolean mRequestFlag;
    private boolean mStartActivityFlag;

    public static void beginRequest(@NonNull Activity activity, @NonNull ArrayList<String> arrayList, @Nullable OnPermissionPageCallback onPermissionPageCallback) {
        PermissionPageFragment permissionPageFragment = new PermissionPageFragment();
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("request_permissions", arrayList);
        permissionPageFragment.setArguments(bundle);
        permissionPageFragment.setRetainInstance(true);
        permissionPageFragment.setRequestFlag(true);
        permissionPageFragment.setCallBack(onPermissionPageCallback);
        permissionPageFragment.attachActivity(activity);
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
        if (i != 1025) {
            return;
        }
        Activity activity = getActivity();
        Bundle arguments = getArguments();
        if (activity != null && arguments != null && (stringArrayList = arguments.getStringArrayList("request_permissions")) != null && !stringArrayList.isEmpty()) {
            PermissionUtils.postActivityResult(stringArrayList, this);
        }
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        if (!this.mRequestFlag) {
            detachActivity(getActivity());
        } else if (this.mStartActivityFlag) {
        } else {
            this.mStartActivityFlag = true;
            Bundle arguments = getArguments();
            Activity activity = getActivity();
            if (arguments != null && activity != null) {
                startActivityForResult(PermissionUtils.getSmartPermissionIntent(getActivity(), arguments.getStringArrayList("request_permissions")), 1025);
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Activity activity;
        if (!isAdded() || (activity = getActivity()) == null) {
            return;
        }
        OnPermissionPageCallback onPermissionPageCallback = this.mCallBack;
        this.mCallBack = null;
        if (onPermissionPageCallback == null) {
            detachActivity(activity);
            return;
        }
        ArrayList<String> stringArrayList = getArguments().getStringArrayList("request_permissions");
        if (PermissionApi.getGrantedPermissions(activity, stringArrayList).size() == stringArrayList.size()) {
            onPermissionPageCallback.onGranted();
        } else {
            onPermissionPageCallback.onDenied();
        }
        detachActivity(activity);
    }

    public void setCallBack(@Nullable OnPermissionPageCallback onPermissionPageCallback) {
        this.mCallBack = onPermissionPageCallback;
    }

    public void setRequestFlag(boolean z2) {
        this.mRequestFlag = z2;
    }
}
