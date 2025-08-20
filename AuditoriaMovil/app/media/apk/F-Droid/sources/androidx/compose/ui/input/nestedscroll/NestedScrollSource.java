package androidx.compose.ui.input.nestedscroll;

import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: NestedScrollModifier.kt */
/* loaded from: classes.dex */
public abstract class NestedScrollSource {
    public static final Companion Companion = new Companion(null);
    private static final int Drag = m1156constructorimpl(1);
    private static final int Fling = m1156constructorimpl(2);
    private static final int Relocate = m1156constructorimpl(3);

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m1156constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m1157equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* compiled from: NestedScrollModifier.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getDrag-WNlRxjI  reason: not valid java name */
        public final int m1158getDragWNlRxjI() {
            return NestedScrollSource.Drag;
        }

        /* renamed from: getFling-WNlRxjI  reason: not valid java name */
        public final int m1159getFlingWNlRxjI() {
            return NestedScrollSource.Fling;
        }
    }
}
