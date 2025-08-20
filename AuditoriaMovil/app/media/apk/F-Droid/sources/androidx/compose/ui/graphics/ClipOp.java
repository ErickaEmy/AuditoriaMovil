package androidx.compose.ui.graphics;

import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: ClipOp.kt */
/* loaded from: classes.dex */
public abstract class ClipOp {
    public static final Companion Companion = new Companion(null);
    private static final int Difference = m837constructorimpl(0);
    private static final int Intersect = m837constructorimpl(1);

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m837constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m838equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* compiled from: ClipOp.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getDifference-rtfAjoo  reason: not valid java name */
        public final int m839getDifferencertfAjoo() {
            return ClipOp.Difference;
        }

        /* renamed from: getIntersect-rtfAjoo  reason: not valid java name */
        public final int m840getIntersectrtfAjoo() {
            return ClipOp.Intersect;
        }
    }
}
