package androidx.compose.ui.input.pointer;

import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: PointerEvent.kt */
/* loaded from: classes.dex */
public abstract class PointerType {
    public static final Companion Companion = new Companion(null);
    private static final int Unknown = m1214constructorimpl(0);
    private static final int Touch = m1214constructorimpl(1);
    private static final int Mouse = m1214constructorimpl(2);
    private static final int Stylus = m1214constructorimpl(3);
    private static final int Eraser = m1214constructorimpl(4);

    /* renamed from: constructor-impl  reason: not valid java name */
    private static int m1214constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m1215equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m1216hashCodeimpl(int i) {
        return i;
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m1217toStringimpl(int i) {
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? "Unknown" : "Eraser" : "Stylus" : "Mouse" : "Touch";
    }

    /* compiled from: PointerEvent.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getUnknown-T8wyACA  reason: not valid java name */
        public final int m1222getUnknownT8wyACA() {
            return PointerType.Unknown;
        }

        /* renamed from: getTouch-T8wyACA  reason: not valid java name */
        public final int m1221getTouchT8wyACA() {
            return PointerType.Touch;
        }

        /* renamed from: getMouse-T8wyACA  reason: not valid java name */
        public final int m1219getMouseT8wyACA() {
            return PointerType.Mouse;
        }

        /* renamed from: getStylus-T8wyACA  reason: not valid java name */
        public final int m1220getStylusT8wyACA() {
            return PointerType.Stylus;
        }

        /* renamed from: getEraser-T8wyACA  reason: not valid java name */
        public final int m1218getEraserT8wyACA() {
            return PointerType.Eraser;
        }
    }
}
