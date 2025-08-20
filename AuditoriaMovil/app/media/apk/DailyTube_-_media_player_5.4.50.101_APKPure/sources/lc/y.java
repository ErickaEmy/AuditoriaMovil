package lc;

import android.app.Activity;
import androidx.navigation.NavController;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class y {
    public static final NavController y(Activity findNavController, int i) {
        Intrinsics.checkParameterIsNotNull(findNavController, "$this$findNavController");
        NavController y = t.y(findNavController, i);
        Intrinsics.checkExpressionValueIsNotNull(y, "Navigation.findNavController(this, viewId)");
        return y;
    }
}
