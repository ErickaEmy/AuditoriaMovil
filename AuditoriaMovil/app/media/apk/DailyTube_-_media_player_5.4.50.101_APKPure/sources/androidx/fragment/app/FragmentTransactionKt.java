package androidx.fragment.app;

import android.os.Bundle;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class FragmentTransactionKt {
    public static final /* synthetic */ <F extends Fragment> FragmentTransaction add(FragmentTransaction add, int i, String str, Bundle bundle) {
        Intrinsics.checkNotNullParameter(add, "$this$add");
        Intrinsics.reifiedOperationMarker(4, "F");
        FragmentTransaction add2 = add.add(i, Fragment.class, bundle, str);
        Intrinsics.checkNotNullExpressionValue(add2, "add(containerViewId, F::class.java, args, tag)");
        return add2;
    }

    public static /* synthetic */ FragmentTransaction add$default(FragmentTransaction add, int i, String str, Bundle bundle, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            str = null;
        }
        if ((i5 & 4) != 0) {
            bundle = null;
        }
        Intrinsics.checkNotNullParameter(add, "$this$add");
        Intrinsics.reifiedOperationMarker(4, "F");
        FragmentTransaction add2 = add.add(i, Fragment.class, bundle, str);
        Intrinsics.checkNotNullExpressionValue(add2, "add(containerViewId, F::class.java, args, tag)");
        return add2;
    }

    public static final /* synthetic */ <F extends Fragment> FragmentTransaction replace(FragmentTransaction replace, int i, String str, Bundle bundle) {
        Intrinsics.checkNotNullParameter(replace, "$this$replace");
        Intrinsics.reifiedOperationMarker(4, "F");
        FragmentTransaction replace2 = replace.replace(i, Fragment.class, bundle, str);
        Intrinsics.checkNotNullExpressionValue(replace2, "replace(containerViewId, F::class.java, args, tag)");
        return replace2;
    }

    public static /* synthetic */ FragmentTransaction replace$default(FragmentTransaction replace, int i, String str, Bundle bundle, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            str = null;
        }
        if ((i5 & 4) != 0) {
            bundle = null;
        }
        Intrinsics.checkNotNullParameter(replace, "$this$replace");
        Intrinsics.reifiedOperationMarker(4, "F");
        FragmentTransaction replace2 = replace.replace(i, Fragment.class, bundle, str);
        Intrinsics.checkNotNullExpressionValue(replace2, "replace(containerViewId, F::class.java, args, tag)");
        return replace2;
    }

    public static final /* synthetic */ <F extends Fragment> FragmentTransaction add(FragmentTransaction add, String tag, Bundle bundle) {
        Intrinsics.checkNotNullParameter(add, "$this$add");
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.reifiedOperationMarker(4, "F");
        FragmentTransaction add2 = add.add(Fragment.class, bundle, tag);
        Intrinsics.checkNotNullExpressionValue(add2, "add(F::class.java, args, tag)");
        return add2;
    }

    public static /* synthetic */ FragmentTransaction add$default(FragmentTransaction add, String tag, Bundle bundle, int i, Object obj) {
        if ((i & 2) != 0) {
            bundle = null;
        }
        Intrinsics.checkNotNullParameter(add, "$this$add");
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.reifiedOperationMarker(4, "F");
        FragmentTransaction add2 = add.add(Fragment.class, bundle, tag);
        Intrinsics.checkNotNullExpressionValue(add2, "add(F::class.java, args, tag)");
        return add2;
    }
}
