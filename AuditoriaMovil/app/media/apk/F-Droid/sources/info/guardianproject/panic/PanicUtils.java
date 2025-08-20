package info.guardianproject.panic;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
/* loaded from: classes.dex */
public abstract class PanicUtils {
    static final Intent TRIGGER_INTENT = new Intent("info.guardianproject.panic.action.TRIGGER");
    static final Intent CONNECT_INTENT = new Intent("info.guardianproject.panic.action.CONNECT");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getCallingPackageName(Activity activity) {
        ComponentName callingActivity = activity.getCallingActivity();
        if (callingActivity == null) {
            return null;
        }
        String packageName = callingActivity.getPackageName();
        if (TextUtils.isEmpty(packageName)) {
            Log.e(activity.getPackageName(), "Received blank Panic Intent! The Intent must be sent using startActivityForResult() and received without launchMode singleTask or singleInstance!");
        }
        return packageName;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean checkForIntentWithAction(Activity activity, String str) {
        Intent intent = activity.getIntent();
        if (intent == null) {
            return false;
        }
        return TextUtils.equals(intent.getAction(), str);
    }
}
