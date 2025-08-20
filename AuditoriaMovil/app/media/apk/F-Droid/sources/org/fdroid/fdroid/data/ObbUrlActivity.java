package org.fdroid.fdroid.data;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import org.fdroid.fdroid.Utils;
/* loaded from: classes2.dex */
public class ObbUrlActivity extends AppCompatActivity {
    public static final String ACTION_GET_OBB_MAIN_URL = "org.fdroid.fdroid.action.GET_OBB_MAIN_URL";
    public static final String ACTION_GET_OBB_PATCH_URL = "org.fdroid.fdroid.action.GET_OBB_PATCH_URL";
    public static final String EXTRA_SHA256 = "org.fdroid.fdroid.extra.SHA256";
    public static final String TAG = "ObbUrlActivity";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        ComponentName callingActivity = getCallingActivity();
        setResult(0);
        if (intent != null && callingActivity != null) {
            intent.getAction();
            String packageName = callingActivity.getPackageName();
            Utils.debugLog(TAG, "got null APK for " + packageName);
        }
        finish();
    }
}
