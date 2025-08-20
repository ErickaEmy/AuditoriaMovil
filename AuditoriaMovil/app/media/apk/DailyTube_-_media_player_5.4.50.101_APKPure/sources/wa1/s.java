package wa1;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.view.View;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class s {
    public static final void a(View view, int i) {
        Context context;
        Intrinsics.checkNotNullParameter(view, "<this>");
        Context context2 = view.getContext();
        if (context2 != null) {
            context = context2.getApplicationContext();
        } else {
            context = null;
        }
        v(i, 0, context);
    }

    public static final void c5(CharSequence text, int i, Context context) {
        Application zn2;
        Intrinsics.checkNotNullParameter(text, "text");
        if (context != null && (zn2 = n3.zn(context)) != null) {
            Toast.makeText(i9(zn2), text, i).show();
        }
    }

    public static final void fb(View view, CharSequence text) {
        Context context;
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(text, "text");
        Context context2 = view.getContext();
        if (context2 != null) {
            context = context2.getApplicationContext();
        } else {
            context = null;
        }
        c5(text, 0, context);
    }

    public static final Toast gv(Context context, CharSequence text, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(text, "text");
        Toast makeText = Toast.makeText(i9(context), text, i);
        Intrinsics.checkNotNullExpressionValue(makeText, "makeText(...)");
        return makeText;
    }

    public static final Context i9(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        if (!xa1.y.n3.y()) {
            return context;
        }
        if (context instanceof xa1.y) {
            return context;
        }
        return new xa1.y(context);
    }

    public static final void n3(View view, int i) {
        Context context;
        Intrinsics.checkNotNullParameter(view, "<this>");
        Context context2 = view.getContext();
        if (context2 != null) {
            context = context2.getApplicationContext();
        } else {
            context = null;
        }
        v(i, 1, context);
    }

    public static final void s(Fragment fragment, int i) {
        Context context;
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Context context2 = fragment.getContext();
        if (context2 != null) {
            context = context2.getApplicationContext();
        } else {
            context = null;
        }
        v(i, 0, context);
    }

    public static final void v(int i, int i5, Context context) {
        Application zn2;
        if (context != null && (zn2 = n3.zn(context)) != null) {
            Toast.makeText(i9(zn2), i, i5).show();
        }
    }

    public static final void y(Activity activity, int i) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        v(i, 1, activity.getApplicationContext());
    }

    public static final Toast zn(Context context, int i, int i5) {
        Intrinsics.checkNotNullParameter(context, "context");
        Toast makeText = Toast.makeText(i9(context), i, i5);
        Intrinsics.checkNotNullExpressionValue(makeText, "makeText(...)");
        return makeText;
    }
}
