package androidx.compose.ui.graphics.colorspace;

import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: RenderIntent.kt */
/* loaded from: classes.dex */
public abstract class RenderIntent {
    public static final Companion Companion = new Companion(null);
    private static final int Perceptual = m1010constructorimpl(0);
    private static final int Relative = m1010constructorimpl(1);
    private static final int Saturation = m1010constructorimpl(2);
    private static final int Absolute = m1010constructorimpl(3);

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m1010constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m1011equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* compiled from: RenderIntent.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getPerceptual-uksYyKA  reason: not valid java name */
        public final int m1013getPerceptualuksYyKA() {
            return RenderIntent.Perceptual;
        }

        /* renamed from: getRelative-uksYyKA  reason: not valid java name */
        public final int m1014getRelativeuksYyKA() {
            return RenderIntent.Relative;
        }

        /* renamed from: getAbsolute-uksYyKA  reason: not valid java name */
        public final int m1012getAbsoluteuksYyKA() {
            return RenderIntent.Absolute;
        }
    }
}
