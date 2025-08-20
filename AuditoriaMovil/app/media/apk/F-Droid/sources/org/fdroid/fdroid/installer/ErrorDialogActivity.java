package org.fdroid.fdroid.installer;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.TypedValue;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.FragmentActivity;
import org.fdroid.fdroid.R;
/* loaded from: classes2.dex */
public class ErrorDialogActivity extends FragmentActivity {
    public static final String EXTRA_MESSAGE = "message";
    public static final String EXTRA_TITLE = "title";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("title");
        String stringExtra2 = intent.getStringExtra(EXTRA_MESSAGE);
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AppThemeDialog);
        builder.setTitle(stringExtra);
        builder.setNeutralButton(R.string.ok, new DialogInterface.OnClickListener() { // from class: org.fdroid.fdroid.installer.ErrorDialogActivity$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                ErrorDialogActivity.this.lambda$onCreate$0(dialogInterface, i);
            }
        });
        builder.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: org.fdroid.fdroid.installer.ErrorDialogActivity$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                ErrorDialogActivity.this.lambda$onCreate$1(dialogInterface);
            }
        });
        TextView textView = new TextView(builder.getContext());
        textView.setText(stringExtra2);
        int round = Math.round(TypedValue.applyDimension(1, 16.0f, getResources().getDisplayMetrics()));
        textView.setPadding(round, round, round, 0);
        textView.setTextIsSelectable(true);
        builder.setView(textView);
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(DialogInterface dialogInterface, int i) {
        setResult(-1);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$1(DialogInterface dialogInterface) {
        setResult(0);
        finish();
    }
}
