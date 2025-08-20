package androidx.compose.material;

import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: Scaffold.kt */
/* loaded from: classes.dex */
public final class FabPosition {
    private final int value;
    public static final Companion Companion = new Companion(null);
    private static final int Center = m493constructorimpl(0);
    private static final int End = m493constructorimpl(1);

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ FabPosition m492boximpl(int i) {
        return new FabPosition(i);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m493constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m494equalsimpl(int i, Object obj) {
        return (obj instanceof FabPosition) && i == ((FabPosition) obj).m498unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m495equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m496hashCodeimpl(int i) {
        return i;
    }

    public boolean equals(Object obj) {
        return m494equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m496hashCodeimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m498unboximpl() {
        return this.value;
    }

    private /* synthetic */ FabPosition(int i) {
        this.value = i;
    }

    /* compiled from: Scaffold.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getEnd-5ygKITE  reason: not valid java name */
        public final int m499getEnd5ygKITE() {
            return FabPosition.End;
        }
    }

    public String toString() {
        return m497toStringimpl(this.value);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m497toStringimpl(int i) {
        return m495equalsimpl0(i, Center) ? "FabPosition.Center" : "FabPosition.End";
    }
}
