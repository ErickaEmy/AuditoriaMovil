package wa1;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.Window;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class i9 {
    public static final boolean n3(View view) {
        Window window;
        View decorView;
        Intrinsics.checkNotNullParameter(view, "<this>");
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        Activity y = n3.y(context);
        if (y == null || (window = y.getWindow()) == null || (decorView = window.getDecorView()) == null || decorView.getLayoutDirection() != 1) {
            return false;
        }
        return true;
    }

    public static final void y(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setVisibility(8);
    }

    public static final void zn(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setVisibility(0);
    }
}
