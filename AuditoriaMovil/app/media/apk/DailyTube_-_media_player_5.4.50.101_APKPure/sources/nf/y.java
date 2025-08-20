package nf;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class y {
    public static final NavController y(Fragment findNavController) {
        Intrinsics.checkParameterIsNotNull(findNavController, "$this$findNavController");
        NavController cp = NavHostFragment.cp(findNavController);
        Intrinsics.checkExpressionValueIsNotNull(cp, "NavHostFragment.findNavController(this)");
        return cp;
    }
}
