package org.acra.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.acra.config.ConfigUtils;
import org.acra.config.DialogConfiguration;
import org.acra.prefs.SharedPreferencesFactory;
/* compiled from: CrashReportDialog.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0017\u0018\u0000 .2\u00020\u00012\u00020\u0002:\u0001.B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0014J\u0012\u0010\u001b\u001a\u00020\u00182\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0014J\u0012\u0010\u001e\u001a\u00020\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0014J\n\u0010\u001f\u001a\u0004\u0018\u00010\u001aH\u0014J\u0012\u0010 \u001a\u00020\u00152\b\u0010!\u001a\u0004\u0018\u00010\"H\u0014J\n\u0010#\u001a\u0004\u0018\u00010\u001aH\u0014J\u0012\u0010$\u001a\u00020\u00152\b\u0010%\u001a\u0004\u0018\u00010\"H\u0014J\b\u0010&\u001a\u00020\u001aH\u0014J\b\u0010'\u001a\u00020\u000fH\u0014J\u0018\u0010(\u001a\u00020\u00182\u0006\u0010\u0004\u001a\u00020)2\u0006\u0010*\u001a\u00020\u000fH\u0016J\u0012\u0010+\u001a\u00020\u00182\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0014J\u0010\u0010,\u001a\u00020\u00182\u0006\u0010-\u001a\u00020\u001dH\u0015R\u001a\u0010\u0004\u001a\u00020\u0005X\u0094.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0092.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0092.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0092\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0092.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0092.¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0092\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0015X\u0092\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lorg/acra/dialog/CrashReportDialog;", "Landroid/app/Activity;", "Landroid/content/DialogInterface$OnClickListener;", "()V", "dialog", "Landroid/app/AlertDialog;", "getDialog", "()Landroid/app/AlertDialog;", "setDialog", "(Landroid/app/AlertDialog;)V", "dialogConfiguration", "Lorg/acra/config/DialogConfiguration;", "helper", "Lorg/acra/dialog/CrashReportDialogHelper;", "padding", "", "scrollable", "Landroid/widget/LinearLayout;", "sharedPreferencesFactory", "Lorg/acra/prefs/SharedPreferencesFactory;", "userCommentView", "Landroid/widget/EditText;", "userEmailView", "addViewToDialog", "", "v", "Landroid/view/View;", "buildAndShowDialog", "savedInstanceState", "Landroid/os/Bundle;", "buildCustomView", "getCommentLabel", "getCommentPrompt", "savedComment", "", "getEmailLabel", "getEmailPrompt", "savedEmail", "getMainView", "loadPaddingFromTheme", "onClick", "Landroid/content/DialogInterface;", "which", "onCreate", "onSaveInstanceState", "outState", "Companion", "acra-dialog_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public class CrashReportDialog extends Activity implements DialogInterface.OnClickListener {
    public static final Companion Companion = new Companion(null);
    protected AlertDialog dialog;
    private DialogConfiguration dialogConfiguration;
    private CrashReportDialogHelper helper;
    private int padding;
    private LinearLayout scrollable;
    private SharedPreferencesFactory sharedPreferencesFactory;
    private EditText userCommentView;
    private EditText userEmailView;

    /* compiled from: CrashReportDialog.kt */
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    protected void setDialog(AlertDialog alertDialog) {
        Intrinsics.checkNotNullParameter(alertDialog, "<set-?>");
        this.dialog = alertDialog;
    }

    protected AlertDialog getDialog() {
        AlertDialog alertDialog = this.dialog;
        if (alertDialog != null) {
            return alertDialog;
        }
        Intrinsics.throwUninitializedPropertyAccessException("dialog");
        return null;
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            Intent intent = getIntent();
            Intrinsics.checkNotNullExpressionValue(intent, "getIntent(...)");
            this.helper = new CrashReportDialogHelper(this, intent);
            LinearLayout linearLayout = new LinearLayout(this);
            this.scrollable = linearLayout;
            linearLayout.setOrientation(1);
            Context applicationContext = getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
            CrashReportDialogHelper crashReportDialogHelper = this.helper;
            DialogConfiguration dialogConfiguration = null;
            if (crashReportDialogHelper == null) {
                Intrinsics.throwUninitializedPropertyAccessException("helper");
                crashReportDialogHelper = null;
            }
            this.sharedPreferencesFactory = new SharedPreferencesFactory(applicationContext, crashReportDialogHelper.getConfig());
            CrashReportDialogHelper crashReportDialogHelper2 = this.helper;
            if (crashReportDialogHelper2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("helper");
                crashReportDialogHelper2 = null;
            }
            DialogConfiguration dialogConfiguration2 = (DialogConfiguration) ConfigUtils.getPluginConfiguration(crashReportDialogHelper2.getConfig(), DialogConfiguration.class);
            this.dialogConfiguration = dialogConfiguration2;
            if (dialogConfiguration2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dialogConfiguration");
            } else {
                dialogConfiguration = dialogConfiguration2;
            }
            Integer resTheme = dialogConfiguration.getResTheme();
            if (resTheme != null) {
                setTheme(resTheme.intValue());
            }
            this.padding = loadPaddingFromTheme();
            buildAndShowDialog(bundle);
        } catch (IllegalArgumentException unused) {
            finish();
        }
    }

    protected void buildAndShowDialog(Bundle bundle) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        DialogConfiguration dialogConfiguration = this.dialogConfiguration;
        DialogConfiguration dialogConfiguration2 = null;
        if (dialogConfiguration == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialogConfiguration");
            dialogConfiguration = null;
        }
        String title = dialogConfiguration.getTitle();
        if (title != null) {
            if (title.length() <= 0) {
                title = null;
            }
            if (title != null) {
                builder.setTitle(title);
            }
        }
        DialogConfiguration dialogConfiguration3 = this.dialogConfiguration;
        if (dialogConfiguration3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialogConfiguration");
            dialogConfiguration3 = null;
        }
        Integer resIcon = dialogConfiguration3.getResIcon();
        if (resIcon != null) {
            builder.setIcon(resIcon.intValue());
        }
        AlertDialog.Builder view = builder.setView(buildCustomView(bundle));
        DialogConfiguration dialogConfiguration4 = this.dialogConfiguration;
        if (dialogConfiguration4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialogConfiguration");
            dialogConfiguration4 = null;
        }
        String positiveButtonText = dialogConfiguration4.getPositiveButtonText();
        if (positiveButtonText == null) {
            positiveButtonText = getString(17039370);
            Intrinsics.checkNotNullExpressionValue(positiveButtonText, "getString(...)");
        }
        AlertDialog.Builder positiveButton = view.setPositiveButton(positiveButtonText, this);
        DialogConfiguration dialogConfiguration5 = this.dialogConfiguration;
        if (dialogConfiguration5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialogConfiguration");
        } else {
            dialogConfiguration2 = dialogConfiguration5;
        }
        String negativeButtonText = dialogConfiguration2.getNegativeButtonText();
        if (negativeButtonText == null) {
            negativeButtonText = getString(17039360);
            Intrinsics.checkNotNullExpressionValue(negativeButtonText, "getString(...)");
        }
        positiveButton.setNegativeButton(negativeButtonText, this);
        AlertDialog create = builder.create();
        Intrinsics.checkNotNullExpressionValue(create, "create(...)");
        setDialog(create);
        getDialog().setCanceledOnTouchOutside(false);
        getDialog().setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: org.acra.dialog.CrashReportDialog$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                CrashReportDialog.buildAndShowDialog$lambda$4(CrashReportDialog.this, dialogInterface);
            }
        });
        getDialog().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void buildAndShowDialog$lambda$4(CrashReportDialog this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.finish();
    }

    protected View buildCustomView(Bundle bundle) {
        ScrollView scrollView = new ScrollView(this);
        int i = this.padding;
        scrollView.setPadding(i, i, i, i);
        scrollView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        scrollView.setFocusable(true);
        scrollView.setFocusableInTouchMode(true);
        LinearLayout linearLayout = this.scrollable;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scrollable");
            linearLayout = null;
        }
        scrollView.addView(linearLayout);
        addViewToDialog(getMainView());
        View commentLabel = getCommentLabel();
        if (commentLabel != null) {
            commentLabel.setPadding(commentLabel.getPaddingLeft(), this.padding, commentLabel.getPaddingRight(), commentLabel.getPaddingBottom());
            addViewToDialog(commentLabel);
            EditText commentPrompt = getCommentPrompt(bundle != null ? bundle.getString("comment") : null);
            addViewToDialog(commentPrompt);
            this.userCommentView = commentPrompt;
        }
        View emailLabel = getEmailLabel();
        if (emailLabel != null) {
            emailLabel.setPadding(emailLabel.getPaddingLeft(), this.padding, emailLabel.getPaddingRight(), emailLabel.getPaddingBottom());
            addViewToDialog(emailLabel);
            EditText emailPrompt = getEmailPrompt(bundle != null ? bundle.getString("email") : null);
            addViewToDialog(emailPrompt);
            this.userEmailView = emailPrompt;
        }
        return scrollView;
    }

    protected void addViewToDialog(View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        LinearLayout linearLayout = this.scrollable;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scrollable");
            linearLayout = null;
        }
        linearLayout.addView(v);
    }

    protected View getMainView() {
        TextView textView = new TextView(this);
        DialogConfiguration dialogConfiguration = this.dialogConfiguration;
        if (dialogConfiguration == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialogConfiguration");
            dialogConfiguration = null;
        }
        String text = dialogConfiguration.getText();
        if (text != null) {
            String str = text.length() > 0 ? text : null;
            if (str != null) {
                textView.setText(str);
            }
        }
        return textView;
    }

    protected View getCommentLabel() {
        DialogConfiguration dialogConfiguration = this.dialogConfiguration;
        if (dialogConfiguration == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialogConfiguration");
            dialogConfiguration = null;
        }
        String commentPrompt = dialogConfiguration.getCommentPrompt();
        if (commentPrompt != null) {
            if (commentPrompt.length() <= 0) {
                commentPrompt = null;
            }
            if (commentPrompt != null) {
                TextView textView = new TextView(this);
                textView.setText(commentPrompt);
                return textView;
            }
            return null;
        }
        return null;
    }

    protected EditText getCommentPrompt(CharSequence charSequence) {
        EditText editText = new EditText(this);
        editText.setLines(2);
        if (charSequence != null) {
            editText.setText(charSequence);
        }
        return editText;
    }

    protected View getEmailLabel() {
        DialogConfiguration dialogConfiguration = this.dialogConfiguration;
        if (dialogConfiguration == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialogConfiguration");
            dialogConfiguration = null;
        }
        String emailPrompt = dialogConfiguration.getEmailPrompt();
        if (emailPrompt != null) {
            if (emailPrompt.length() <= 0) {
                emailPrompt = null;
            }
            if (emailPrompt != null) {
                TextView textView = new TextView(this);
                textView.setText(emailPrompt);
                return textView;
            }
            return null;
        }
        return null;
    }

    protected EditText getEmailPrompt(CharSequence charSequence) {
        EditText editText = new EditText(this);
        editText.setSingleLine();
        editText.setInputType(33);
        if (charSequence == null) {
            SharedPreferencesFactory sharedPreferencesFactory = this.sharedPreferencesFactory;
            if (sharedPreferencesFactory == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sharedPreferencesFactory");
                sharedPreferencesFactory = null;
            }
            charSequence = sharedPreferencesFactory.create().getString("acra.user.email", "");
        }
        editText.setText(charSequence);
        return editText;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialog, int i) {
        String string;
        Editable text;
        Editable text2;
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        CrashReportDialogHelper crashReportDialogHelper = null;
        if (i == -1) {
            EditText editText = this.userCommentView;
            String str = (editText == null || (text2 = editText.getText()) == null || (str = text2.toString()) == null) ? "" : "";
            SharedPreferencesFactory sharedPreferencesFactory = this.sharedPreferencesFactory;
            if (sharedPreferencesFactory == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sharedPreferencesFactory");
                sharedPreferencesFactory = null;
            }
            SharedPreferences create = sharedPreferencesFactory.create();
            EditText editText2 = this.userEmailView;
            if (editText2 == null || (text = editText2.getText()) == null || (string = text.toString()) == null) {
                string = create.getString("acra.user.email", "");
                Intrinsics.checkNotNull(string);
            } else {
                create.edit().putString("acra.user.email", string).apply();
            }
            CrashReportDialogHelper crashReportDialogHelper2 = this.helper;
            if (crashReportDialogHelper2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("helper");
            } else {
                crashReportDialogHelper = crashReportDialogHelper2;
            }
            crashReportDialogHelper.sendCrash(str, string);
        } else {
            CrashReportDialogHelper crashReportDialogHelper3 = this.helper;
            if (crashReportDialogHelper3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("helper");
            } else {
                crashReportDialogHelper = crashReportDialogHelper3;
            }
            crashReportDialogHelper.cancelReports();
        }
        finish();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle outState) {
        Editable text;
        Editable text2;
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        EditText editText = this.userCommentView;
        if (editText != null && (text2 = editText.getText()) != null) {
            outState.putString("comment", text2.toString());
        }
        EditText editText2 = this.userEmailView;
        if (editText2 == null || (text = editText2.getText()) == null) {
            return;
        }
        outState.putString("email", text.toString());
    }

    protected int loadPaddingFromTheme() {
        TypedValue typedValue = new TypedValue();
        if (getTheme().resolveAttribute(16843987, typedValue, true)) {
            return TypedValue.complexToDimensionPixelSize(typedValue.data, getResources().getDisplayMetrics());
        }
        return 10;
    }
}
