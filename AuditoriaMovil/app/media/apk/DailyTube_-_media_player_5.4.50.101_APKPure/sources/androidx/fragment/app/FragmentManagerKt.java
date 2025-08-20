package androidx.fragment.app;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class FragmentManagerKt {
    public static final void commit(FragmentManager commit, boolean z2, Function1<? super FragmentTransaction, Unit> body) {
        Intrinsics.checkNotNullParameter(commit, "$this$commit");
        Intrinsics.checkNotNullParameter(body, "body");
        FragmentTransaction beginTransaction = commit.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "beginTransaction()");
        body.invoke(beginTransaction);
        if (z2) {
            beginTransaction.commitAllowingStateLoss();
        } else {
            beginTransaction.commit();
        }
    }

    public static /* synthetic */ void commit$default(FragmentManager commit, boolean z2, Function1 body, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = false;
        }
        Intrinsics.checkNotNullParameter(commit, "$this$commit");
        Intrinsics.checkNotNullParameter(body, "body");
        FragmentTransaction beginTransaction = commit.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "beginTransaction()");
        body.invoke(beginTransaction);
        if (z2) {
            beginTransaction.commitAllowingStateLoss();
        } else {
            beginTransaction.commit();
        }
    }

    public static final void commitNow(FragmentManager commitNow, boolean z2, Function1<? super FragmentTransaction, Unit> body) {
        Intrinsics.checkNotNullParameter(commitNow, "$this$commitNow");
        Intrinsics.checkNotNullParameter(body, "body");
        FragmentTransaction beginTransaction = commitNow.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "beginTransaction()");
        body.invoke(beginTransaction);
        if (z2) {
            beginTransaction.commitNowAllowingStateLoss();
        } else {
            beginTransaction.commitNow();
        }
    }

    public static /* synthetic */ void commitNow$default(FragmentManager commitNow, boolean z2, Function1 body, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = false;
        }
        Intrinsics.checkNotNullParameter(commitNow, "$this$commitNow");
        Intrinsics.checkNotNullParameter(body, "body");
        FragmentTransaction beginTransaction = commitNow.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "beginTransaction()");
        body.invoke(beginTransaction);
        if (z2) {
            beginTransaction.commitNowAllowingStateLoss();
        } else {
            beginTransaction.commitNow();
        }
    }

    public static final void transaction(FragmentManager transaction, boolean z2, boolean z3, Function1<? super FragmentTransaction, Unit> body) {
        Intrinsics.checkNotNullParameter(transaction, "$this$transaction");
        Intrinsics.checkNotNullParameter(body, "body");
        FragmentTransaction beginTransaction = transaction.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "beginTransaction()");
        body.invoke(beginTransaction);
        if (z2) {
            if (z3) {
                beginTransaction.commitNowAllowingStateLoss();
            } else {
                beginTransaction.commitNow();
            }
        } else if (z3) {
            beginTransaction.commitAllowingStateLoss();
        } else {
            beginTransaction.commit();
        }
    }

    public static /* synthetic */ void transaction$default(FragmentManager transaction, boolean z2, boolean z3, Function1 body, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = false;
        }
        if ((i & 2) != 0) {
            z3 = false;
        }
        Intrinsics.checkNotNullParameter(transaction, "$this$transaction");
        Intrinsics.checkNotNullParameter(body, "body");
        FragmentTransaction beginTransaction = transaction.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "beginTransaction()");
        body.invoke(beginTransaction);
        if (z2) {
            if (z3) {
                beginTransaction.commitNowAllowingStateLoss();
            } else {
                beginTransaction.commitNow();
            }
        } else if (z3) {
            beginTransaction.commitAllowingStateLoss();
        } else {
            beginTransaction.commit();
        }
    }
}
