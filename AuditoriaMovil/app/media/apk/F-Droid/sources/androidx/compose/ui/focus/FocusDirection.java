package androidx.compose.ui.focus;

import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: FocusDirection.kt */
/* loaded from: classes.dex */
public final class FocusDirection {
    private static final int Enter;
    private static final int Exit;
    private static final int In;
    private static final int Out;
    private final int value;
    public static final Companion Companion = new Companion(null);
    private static final int Next = m648constructorimpl(1);
    private static final int Previous = m648constructorimpl(2);
    private static final int Left = m648constructorimpl(3);
    private static final int Right = m648constructorimpl(4);
    private static final int Up = m648constructorimpl(5);
    private static final int Down = m648constructorimpl(6);

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ FocusDirection m647boximpl(int i) {
        return new FocusDirection(i);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m648constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m649equalsimpl(int i, Object obj) {
        return (obj instanceof FocusDirection) && i == ((FocusDirection) obj).m653unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m650equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m651hashCodeimpl(int i) {
        return i;
    }

    public boolean equals(Object obj) {
        return m649equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m651hashCodeimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m653unboximpl() {
        return this.value;
    }

    private /* synthetic */ FocusDirection(int i) {
        this.value = i;
    }

    public String toString() {
        return m652toStringimpl(this.value);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m652toStringimpl(int i) {
        return m650equalsimpl0(i, Next) ? "Next" : m650equalsimpl0(i, Previous) ? "Previous" : m650equalsimpl0(i, Left) ? "Left" : m650equalsimpl0(i, Right) ? "Right" : m650equalsimpl0(i, Up) ? "Up" : m650equalsimpl0(i, Down) ? "Down" : m650equalsimpl0(i, Enter) ? "Enter" : m650equalsimpl0(i, Exit) ? "Exit" : "Invalid FocusDirection";
    }

    /* compiled from: FocusDirection.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getNext-dhqQ-8s  reason: not valid java name */
        public final int m658getNextdhqQ8s() {
            return FocusDirection.Next;
        }

        /* renamed from: getPrevious-dhqQ-8s  reason: not valid java name */
        public final int m659getPreviousdhqQ8s() {
            return FocusDirection.Previous;
        }

        /* renamed from: getLeft-dhqQ-8s  reason: not valid java name */
        public final int m657getLeftdhqQ8s() {
            return FocusDirection.Left;
        }

        /* renamed from: getRight-dhqQ-8s  reason: not valid java name */
        public final int m660getRightdhqQ8s() {
            return FocusDirection.Right;
        }

        /* renamed from: getUp-dhqQ-8s  reason: not valid java name */
        public final int m661getUpdhqQ8s() {
            return FocusDirection.Up;
        }

        /* renamed from: getDown-dhqQ-8s  reason: not valid java name */
        public final int m654getDowndhqQ8s() {
            return FocusDirection.Down;
        }

        /* renamed from: getEnter-dhqQ-8s  reason: not valid java name */
        public final int m655getEnterdhqQ8s() {
            return FocusDirection.Enter;
        }

        /* renamed from: getExit-dhqQ-8s  reason: not valid java name */
        public final int m656getExitdhqQ8s() {
            return FocusDirection.Exit;
        }
    }

    static {
        int m648constructorimpl = m648constructorimpl(7);
        Enter = m648constructorimpl;
        int m648constructorimpl2 = m648constructorimpl(8);
        Exit = m648constructorimpl2;
        In = m648constructorimpl;
        Out = m648constructorimpl2;
    }
}
