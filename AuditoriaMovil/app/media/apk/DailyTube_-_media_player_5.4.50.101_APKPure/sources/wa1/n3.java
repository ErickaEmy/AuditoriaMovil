package wa1;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import androidx.appcompat.app.AppCompatActivity;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class n3 {
    public static final AppCompatActivity n3(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        if (context instanceof AppCompatActivity) {
            return (AppCompatActivity) context;
        }
        if (context instanceof ContextWrapper) {
            Context baseContext = ((ContextWrapper) context).getBaseContext();
            Intrinsics.checkNotNullExpressionValue(baseContext, "getBaseContext(...)");
            return n3(baseContext);
        }
        return null;
    }

    public static final Activity y(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            Context baseContext = ((ContextWrapper) context).getBaseContext();
            Intrinsics.checkNotNullExpressionValue(baseContext, "getBaseContext(...)");
            return y(baseContext);
        }
        return null;
    }

    public static final Application zn(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        if (context instanceof Application) {
            return (Application) context;
        }
        if (context instanceof Activity) {
            return ((Activity) context).getApplication();
        }
        if (context instanceof ContextWrapper) {
            Context baseContext = ((ContextWrapper) context).getBaseContext();
            Intrinsics.checkNotNullExpressionValue(baseContext, "getBaseContext(...)");
            return zn(baseContext);
        }
        return null;
    }
}
