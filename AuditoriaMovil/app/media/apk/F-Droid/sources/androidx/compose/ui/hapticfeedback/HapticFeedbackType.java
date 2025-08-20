package androidx.compose.ui.hapticfeedback;

import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: HapticFeedbackType.kt */
/* loaded from: classes.dex */
public abstract class HapticFeedbackType {
    public static final Companion Companion = new Companion(null);

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m1098constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m1099equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* compiled from: HapticFeedbackType.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getLongPress-5zf0vsI  reason: not valid java name */
        public final int m1100getLongPress5zf0vsI() {
            return PlatformHapticFeedbackType.INSTANCE.m1102getLongPress5zf0vsI();
        }

        /* renamed from: getTextHandleMove-5zf0vsI  reason: not valid java name */
        public final int m1101getTextHandleMove5zf0vsI() {
            return PlatformHapticFeedbackType.INSTANCE.m1103getTextHandleMove5zf0vsI();
        }
    }
}
