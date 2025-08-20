package androidx.compose.ui.graphics;

import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: ImageBitmap.kt */
/* loaded from: classes.dex */
public final class ImageBitmapConfig {
    private final int value;
    public static final Companion Companion = new Companion(null);
    private static final int Argb8888 = m896constructorimpl(0);
    private static final int Alpha8 = m896constructorimpl(1);
    private static final int Rgb565 = m896constructorimpl(2);
    private static final int F16 = m896constructorimpl(3);
    private static final int Gpu = m896constructorimpl(4);

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ ImageBitmapConfig m895boximpl(int i) {
        return new ImageBitmapConfig(i);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m896constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m897equalsimpl(int i, Object obj) {
        return (obj instanceof ImageBitmapConfig) && i == ((ImageBitmapConfig) obj).m901unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m898equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m899hashCodeimpl(int i) {
        return i;
    }

    public boolean equals(Object obj) {
        return m897equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m899hashCodeimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m901unboximpl() {
        return this.value;
    }

    private /* synthetic */ ImageBitmapConfig(int i) {
        this.value = i;
    }

    /* compiled from: ImageBitmap.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getArgb8888-_sVssgQ  reason: not valid java name */
        public final int m903getArgb8888_sVssgQ() {
            return ImageBitmapConfig.Argb8888;
        }

        /* renamed from: getAlpha8-_sVssgQ  reason: not valid java name */
        public final int m902getAlpha8_sVssgQ() {
            return ImageBitmapConfig.Alpha8;
        }

        /* renamed from: getRgb565-_sVssgQ  reason: not valid java name */
        public final int m906getRgb565_sVssgQ() {
            return ImageBitmapConfig.Rgb565;
        }

        /* renamed from: getF16-_sVssgQ  reason: not valid java name */
        public final int m904getF16_sVssgQ() {
            return ImageBitmapConfig.F16;
        }

        /* renamed from: getGpu-_sVssgQ  reason: not valid java name */
        public final int m905getGpu_sVssgQ() {
            return ImageBitmapConfig.Gpu;
        }
    }

    public String toString() {
        return m900toStringimpl(this.value);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m900toStringimpl(int i) {
        return m898equalsimpl0(i, Argb8888) ? "Argb8888" : m898equalsimpl0(i, Alpha8) ? "Alpha8" : m898equalsimpl0(i, Rgb565) ? "Rgb565" : m898equalsimpl0(i, F16) ? "F16" : m898equalsimpl0(i, Gpu) ? "Gpu" : "Unknown";
    }
}
