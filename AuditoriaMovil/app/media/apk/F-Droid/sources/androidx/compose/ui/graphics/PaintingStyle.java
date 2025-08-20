package androidx.compose.ui.graphics;

import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: PaintingStyle.kt */
/* loaded from: classes.dex */
public abstract class PaintingStyle {
    public static final Companion Companion = new Companion(null);
    private static final int Fill = m928constructorimpl(0);
    private static final int Stroke = m928constructorimpl(1);

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m928constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m929equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* compiled from: PaintingStyle.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getFill-TiuSbCo  reason: not valid java name */
        public final int m930getFillTiuSbCo() {
            return PaintingStyle.Fill;
        }

        /* renamed from: getStroke-TiuSbCo  reason: not valid java name */
        public final int m931getStrokeTiuSbCo() {
            return PaintingStyle.Stroke;
        }
    }
}
