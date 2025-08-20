package androidx.fragment.app;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class ViewKt {
    public static final <F extends Fragment> F findFragment(View findFragment) {
        Intrinsics.checkNotNullParameter(findFragment, "$this$findFragment");
        F f4 = (F) FragmentManager.findFragment(findFragment);
        Intrinsics.checkNotNullExpressionValue(f4, "FragmentManager.findFragment(this)");
        return f4;
    }
}
