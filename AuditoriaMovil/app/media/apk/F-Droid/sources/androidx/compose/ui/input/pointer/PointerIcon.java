package androidx.compose.ui.input.pointer;
/* compiled from: PointerIcon.kt */
/* loaded from: classes.dex */
public interface PointerIcon {
    public static final Companion Companion = Companion.$$INSTANCE;

    /* compiled from: PointerIcon.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final PointerIcon Default = PointerIcon_androidKt.getPointerIconDefault();
        private static final PointerIcon Crosshair = PointerIcon_androidKt.getPointerIconCrosshair();
        private static final PointerIcon Text = PointerIcon_androidKt.getPointerIconText();
        private static final PointerIcon Hand = PointerIcon_androidKt.getPointerIconHand();

        private Companion() {
        }

        public final PointerIcon getDefault() {
            return Default;
        }
    }
}
