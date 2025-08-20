package androidx.compose.ui.graphics;

import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: PathOperation.kt */
/* loaded from: classes.dex */
public abstract class PathOperation {
    public static final Companion Companion = new Companion(null);
    private static final int Difference = m942constructorimpl(0);
    private static final int Intersect = m942constructorimpl(1);
    private static final int Union = m942constructorimpl(2);
    private static final int Xor = m942constructorimpl(3);
    private static final int ReverseDifference = m942constructorimpl(4);

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m942constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m943equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* compiled from: PathOperation.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getDifference-b3I0S0c  reason: not valid java name */
        public final int m944getDifferenceb3I0S0c() {
            return PathOperation.Difference;
        }

        /* renamed from: getIntersect-b3I0S0c  reason: not valid java name */
        public final int m945getIntersectb3I0S0c() {
            return PathOperation.Intersect;
        }

        /* renamed from: getUnion-b3I0S0c  reason: not valid java name */
        public final int m947getUnionb3I0S0c() {
            return PathOperation.Union;
        }

        /* renamed from: getReverseDifference-b3I0S0c  reason: not valid java name */
        public final int m946getReverseDifferenceb3I0S0c() {
            return PathOperation.ReverseDifference;
        }
    }
}
