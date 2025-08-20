package androidx.compose.ui.input;

import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: InputModeManager.kt */
/* loaded from: classes.dex */
public final class InputMode {
    private final int value;
    public static final Companion Companion = new Companion(null);
    private static final int Touch = m1105constructorimpl(1);
    private static final int Keyboard = m1105constructorimpl(2);

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ InputMode m1104boximpl(int i) {
        return new InputMode(i);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m1105constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m1106equalsimpl(int i, Object obj) {
        return (obj instanceof InputMode) && i == ((InputMode) obj).m1110unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m1107equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m1108hashCodeimpl(int i) {
        return i;
    }

    public boolean equals(Object obj) {
        return m1106equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m1108hashCodeimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m1110unboximpl() {
        return this.value;
    }

    private /* synthetic */ InputMode(int i) {
        this.value = i;
    }

    public String toString() {
        return m1109toStringimpl(this.value);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m1109toStringimpl(int i) {
        return m1107equalsimpl0(i, Touch) ? "Touch" : m1107equalsimpl0(i, Keyboard) ? "Keyboard" : "Error";
    }

    /* compiled from: InputModeManager.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getTouch-aOaMEAU  reason: not valid java name */
        public final int m1112getTouchaOaMEAU() {
            return InputMode.Touch;
        }

        /* renamed from: getKeyboard-aOaMEAU  reason: not valid java name */
        public final int m1111getKeyboardaOaMEAU() {
            return InputMode.Keyboard;
        }
    }
}
