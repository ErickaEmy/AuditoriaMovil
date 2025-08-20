package org.fdroid.fdroid.panic;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
/* loaded from: classes2.dex */
public class ExitActivity extends AppCompatActivity {
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        finishAndRemoveTask();
        System.exit(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void exitAndRemoveFromRecentApps(final AppCompatActivity appCompatActivity) {
        appCompatActivity.runOnUiThread(new Runnable() { // from class: org.fdroid.fdroid.panic.ExitActivity$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ExitActivity.lambda$exitAndRemoveFromRecentApps$0(AppCompatActivity.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$exitAndRemoveFromRecentApps$0(AppCompatActivity appCompatActivity) {
        Intent intent = new Intent(appCompatActivity, ExitActivity.class);
        intent.addFlags(276922368);
        appCompatActivity.startActivity(intent);
    }
}
