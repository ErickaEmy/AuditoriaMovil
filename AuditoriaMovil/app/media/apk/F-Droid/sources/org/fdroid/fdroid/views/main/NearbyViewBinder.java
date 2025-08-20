package org.fdroid.fdroid.views.main;

import android.content.Context;
import android.content.Intent;
import android.content.UriPermission;
import android.hardware.usb.UsbDevice;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.storage.StorageManager;
import android.os.storage.StorageVolume;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import java.io.File;
import java.util.List;
import org.fdroid.fdroid.R;
import org.fdroid.fdroid.Utils;
import org.fdroid.fdroid.nearby.SDCardScannerService;
import org.fdroid.fdroid.nearby.SwapService;
import org.fdroid.fdroid.nearby.TreeUriScannerIntentService;
/* loaded from: classes2.dex */
public class NearbyViewBinder {
    public static final String TAG = "NearbyViewBinder";
    private static File externalStorage;
    private static View swapView;

    /* JADX INFO: Access modifiers changed from: package-private */
    public NearbyViewBinder(final AppCompatActivity appCompatActivity, FrameLayout frameLayout) {
        View inflate = appCompatActivity.getLayoutInflater().inflate(R.layout.main_tab_nearby, (ViewGroup) frameLayout, true);
        swapView = inflate;
        ((TextView) inflate.findViewById(R.id.both_parties_need_fdroid_text)).setText(appCompatActivity.getString(R.string.nearby_splash__both_parties_need_fdroid, appCompatActivity.getString(R.string.app_name)));
        ((Button) swapView.findViewById(R.id.find_people_button)).setOnClickListener(new View.OnClickListener() { // from class: org.fdroid.fdroid.views.main.NearbyViewBinder$$ExternalSyntheticLambda12
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NearbyViewBinder.lambda$new$0(AppCompatActivity.this, view);
            }
        });
        updateExternalStorageViews(appCompatActivity);
        updateUsbOtg(appCompatActivity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$new$0(AppCompatActivity appCompatActivity, View view) {
        if (ContextCompat.checkSelfPermission(appCompatActivity, "android.permission.ACCESS_COARSE_LOCATION") != 0) {
            ActivityCompat.requestPermissions(appCompatActivity, new String[]{"android.permission.ACCESS_COARSE_LOCATION"}, 61199);
        } else {
            ContextCompat.startForegroundService(appCompatActivity, new Intent(appCompatActivity, SwapService.class));
        }
    }

    public static void updateExternalStorageViews(final AppCompatActivity appCompatActivity) {
        boolean isExternalStorageManager;
        View view = swapView;
        if (view == null || appCompatActivity == null) {
            return;
        }
        ImageView imageView = (ImageView) view.findViewById(R.id.image);
        TextView textView = (TextView) swapView.findViewById(R.id.read_external_storage_text);
        Button button = (Button) swapView.findViewById(R.id.request_read_external_storage_button);
        if (imageView == null || textView == null || button == null) {
            return;
        }
        File[] externalFilesDirs = appCompatActivity.getExternalFilesDirs("");
        if (externalFilesDirs != null) {
            for (File file : externalFilesDirs) {
                if (file != null && Environment.isExternalStorageRemovable(file)) {
                    String externalStorageState = Environment.getExternalStorageState(file);
                    if ("mounted_ro".equals(externalStorageState) || "mounted".equals(externalStorageState)) {
                        externalStorage = file.getParentFile().getParentFile().getParentFile().getParentFile();
                        break;
                    }
                }
            }
        }
        if (externalStorage != null) {
            imageView.setVisibility(8);
            textView.setVisibility(0);
            button.setVisibility(0);
            if (Build.VERSION.SDK_INT >= 30) {
                isExternalStorageManager = Environment.isExternalStorageManager();
                if (!isExternalStorageManager) {
                    textView.setText(R.string.nearby_splach__external_storage_permission_explainer);
                    button.setText(R.string.nearby_splace__external_storage_permission_button);
                    button.setOnClickListener(new View.OnClickListener() { // from class: org.fdroid.fdroid.views.main.NearbyViewBinder$$ExternalSyntheticLambda8
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            NearbyViewBinder.lambda$updateExternalStorageViews$1(AppCompatActivity.this, view2);
                        }
                    });
                    return;
                }
                textView.setText(R.string.nearby_splash__read_external_storage);
                button.setText(R.string.nearby_splash__request_permission);
                button.setOnClickListener(new View.OnClickListener() { // from class: org.fdroid.fdroid.views.main.NearbyViewBinder$$ExternalSyntheticLambda9
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        NearbyViewBinder.scanExternalStorageNow(AppCompatActivity.this);
                    }
                });
                return;
            }
            File file2 = externalStorage;
            if ((file2 == null || !file2.canRead()) && ContextCompat.checkSelfPermission(appCompatActivity, "android.permission.READ_EXTERNAL_STORAGE") != 0) {
                textView.setText(R.string.nearby_splach__external_storage_permission_explainer);
                button.setText(R.string.nearby_splace__external_storage_permission_button);
                button.setOnClickListener(new View.OnClickListener() { // from class: org.fdroid.fdroid.views.main.NearbyViewBinder$$ExternalSyntheticLambda10
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        NearbyViewBinder.lambda$updateExternalStorageViews$3(AppCompatActivity.this, view2);
                    }
                });
                return;
            }
            textView.setText(R.string.nearby_splash__read_external_storage);
            button.setText(R.string.nearby_splash__request_permission);
            button.setOnClickListener(new View.OnClickListener() { // from class: org.fdroid.fdroid.views.main.NearbyViewBinder$$ExternalSyntheticLambda11
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    NearbyViewBinder.scanExternalStorageNow(AppCompatActivity.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$updateExternalStorageViews$1(AppCompatActivity appCompatActivity, View view) {
        appCompatActivity.startActivity(new Intent("android.settings.MANAGE_APP_ALL_FILES_ACCESS_PERMISSION", Uri.parse(String.format("package:%s", appCompatActivity.getPackageName()))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$updateExternalStorageViews$3(AppCompatActivity appCompatActivity, View view) {
        ActivityCompat.requestPermissions(appCompatActivity, new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 45060);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void scanExternalStorageNow(AppCompatActivity appCompatActivity) {
        Toast.makeText(appCompatActivity, appCompatActivity.getString(R.string.scan_removable_storage_toast, externalStorage), 0).show();
        SDCardScannerService.scan(appCompatActivity);
    }

    public static void updateUsbOtg(final Context context) {
        List<Object> storageVolumes;
        boolean isRemovable;
        boolean isPrimary;
        final Intent intent;
        String uuid;
        String uuid2;
        String description;
        if (Build.VERSION.SDK_INT < 24) {
            return;
        }
        View view = swapView;
        if (view == null) {
            Utils.debugLog(TAG, "swapView == null");
            return;
        }
        TextView textView = (TextView) view.findViewById(R.id.storage_volume_text);
        Button button = (Button) swapView.findViewById(R.id.request_storage_volume_button);
        textView.setVisibility(8);
        button.setVisibility(8);
        storageVolumes = ((StorageManager) ContextCompat.getSystemService(context, StorageManager.class)).getStorageVolumes();
        for (Object obj : storageVolumes) {
            final StorageVolume m = NearbyViewBinder$$ExternalSyntheticApiModelOutline3.m(obj);
            isRemovable = m.isRemovable();
            if (isRemovable) {
                isPrimary = m.isPrimary();
                if (isPrimary) {
                    continue;
                } else {
                    Log.i(TAG, "StorageVolume: " + m);
                    if (Build.VERSION.SDK_INT < 29) {
                        intent = m.createAccessIntent(null);
                    } else {
                        intent = new Intent("android.intent.action.OPEN_DOCUMENT_TREE");
                        StringBuilder sb = new StringBuilder();
                        sb.append("content://com.android.externalstorage.documents/tree/");
                        uuid = m.getUuid();
                        sb.append(uuid);
                        sb.append("%3A/document/");
                        uuid2 = m.getUuid();
                        sb.append(uuid2);
                        sb.append("%3A");
                        intent.putExtra("android.provider.extra.INITIAL_URI", Uri.parse(sb.toString()));
                    }
                    if (intent == null) {
                        Utils.debugLog(TAG, "Got null Storage Volume access Intent");
                        return;
                    }
                    textView.setVisibility(0);
                    description = m.getDescription(context);
                    if (!TextUtils.isEmpty(description)) {
                        button.setText(description);
                        UsbDevice usbDevice = (UsbDevice) intent.getParcelableExtra("device");
                        if (usbDevice != null) {
                            Toast.makeText(context, String.format("%s (%s %s)", description, usbDevice.getManufacturerName(), usbDevice.getProductName()), 1).show();
                        }
                    }
                    button.setVisibility(0);
                    button.setOnClickListener(new View.OnClickListener() { // from class: org.fdroid.fdroid.views.main.NearbyViewBinder$$ExternalSyntheticLambda13
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            NearbyViewBinder.lambda$updateUsbOtg$5(context, m, intent, view2);
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$updateUsbOtg$5(Context context, StorageVolume storageVolume, Intent intent, View view) {
        AppCompatActivity appCompatActivity;
        String uuid;
        List<UriPermission> persistedUriPermissions = context.getContentResolver().getPersistedUriPermissions();
        if (persistedUriPermissions != null) {
            for (UriPermission uriPermission : persistedUriPermissions) {
                Uri uri = uriPermission.getUri();
                String path = uri.getPath();
                uuid = storageVolume.getUuid();
                if (path.equals(String.format("/tree/%s:", uuid))) {
                    intent.setData(uri);
                    TreeUriScannerIntentService.onActivityResult(context, intent);
                    return;
                }
            }
        }
        if (context instanceof AppCompatActivity) {
            appCompatActivity = (AppCompatActivity) context;
        } else {
            View view2 = swapView;
            appCompatActivity = (view2 == null || !(view2.getContext() instanceof AppCompatActivity)) ? null : (AppCompatActivity) swapView.getContext();
        }
        if (appCompatActivity != null) {
            appCompatActivity.startActivityForResult(intent, 16613);
            return;
        }
        Toast.makeText(context.getApplicationContext(), context.getString(R.string.scan_removable_storage_toast, externalStorage), 0).show();
        SDCardScannerService.scan(context);
    }
}
