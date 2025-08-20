package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import java.util.Arrays;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__IndentKt;
/* compiled from: Matrix.kt */
/* loaded from: classes.dex */
public final class Matrix {
    public static final Companion Companion = new Companion(null);
    private final float[] values;

    /* compiled from: Matrix.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ Matrix m909boximpl(float[] fArr) {
        return new Matrix(fArr);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static float[] m910constructorimpl(float[] values) {
        Intrinsics.checkNotNullParameter(values, "values");
        return values;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m912equalsimpl(float[] fArr, Object obj) {
        return (obj instanceof Matrix) && Intrinsics.areEqual(fArr, ((Matrix) obj).m922unboximpl());
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m913hashCodeimpl(float[] fArr) {
        return Arrays.hashCode(fArr);
    }

    public boolean equals(Object obj) {
        return m912equalsimpl(this.values, obj);
    }

    public int hashCode() {
        return m913hashCodeimpl(this.values);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ float[] m922unboximpl() {
        return this.values;
    }

    private /* synthetic */ Matrix(float[] fArr) {
        this.values = fArr;
    }

    /* renamed from: constructor-impl$default  reason: not valid java name */
    public static /* synthetic */ float[] m911constructorimpl$default(float[] fArr, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 1) != 0) {
            fArr = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
        }
        return m910constructorimpl(fArr);
    }

    /* renamed from: scale-impl  reason: not valid java name */
    public static final void m918scaleimpl(float[] fArr, float f, float f2, float f3) {
        fArr[0] = fArr[0] * f;
        fArr[1] = fArr[1] * f;
        fArr[2] = fArr[2] * f;
        fArr[3] = fArr[3] * f;
        fArr[4] = fArr[4] * f2;
        fArr[5] = fArr[5] * f2;
        fArr[6] = fArr[6] * f2;
        fArr[7] = fArr[7] * f2;
        fArr[8] = fArr[8] * f3;
        fArr[9] = fArr[9] * f3;
        fArr[10] = fArr[10] * f3;
        fArr[11] = fArr[11] * f3;
    }

    /* renamed from: translate-impl  reason: not valid java name */
    public static final void m920translateimpl(float[] fArr, float f, float f2, float f3) {
        float f4 = (fArr[0] * f) + (fArr[4] * f2) + (fArr[8] * f3) + fArr[12];
        float f5 = (fArr[1] * f) + (fArr[5] * f2) + (fArr[9] * f3) + fArr[13];
        float f6 = (fArr[2] * f) + (fArr[6] * f2) + (fArr[10] * f3) + fArr[14];
        fArr[12] = f4;
        fArr[13] = f5;
        fArr[14] = f6;
        fArr[15] = (fArr[3] * f) + (fArr[7] * f2) + (fArr[11] * f3) + fArr[15];
    }

    /* renamed from: reset-impl  reason: not valid java name */
    public static final void m916resetimpl(float[] fArr) {
        int i = 0;
        while (i < 4) {
            int i2 = 0;
            while (i2 < 4) {
                fArr[(i2 * 4) + i] = i == i2 ? 1.0f : 0.0f;
                i2++;
            }
            i++;
        }
    }

    /* renamed from: map-MK-Hz9U  reason: not valid java name */
    public static final long m914mapMKHz9U(float[] fArr, long j) {
        float m709getXimpl = Offset.m709getXimpl(j);
        float m710getYimpl = Offset.m710getYimpl(j);
        float f = 1 / (((fArr[3] * m709getXimpl) + (fArr[7] * m710getYimpl)) + fArr[15]);
        f = (Float.isInfinite(f) || Float.isNaN(f)) ? 0.0f : 0.0f;
        return OffsetKt.Offset(((fArr[0] * m709getXimpl) + (fArr[4] * m710getYimpl) + fArr[12]) * f, f * ((fArr[1] * m709getXimpl) + (fArr[5] * m710getYimpl) + fArr[13]));
    }

    /* renamed from: map-impl  reason: not valid java name */
    public static final void m915mapimpl(float[] fArr, MutableRect rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        long m914mapMKHz9U = m914mapMKHz9U(fArr, OffsetKt.Offset(rect.getLeft(), rect.getTop()));
        long m914mapMKHz9U2 = m914mapMKHz9U(fArr, OffsetKt.Offset(rect.getLeft(), rect.getBottom()));
        long m914mapMKHz9U3 = m914mapMKHz9U(fArr, OffsetKt.Offset(rect.getRight(), rect.getTop()));
        long m914mapMKHz9U4 = m914mapMKHz9U(fArr, OffsetKt.Offset(rect.getRight(), rect.getBottom()));
        rect.setLeft(Math.min(Math.min(Offset.m709getXimpl(m914mapMKHz9U), Offset.m709getXimpl(m914mapMKHz9U2)), Math.min(Offset.m709getXimpl(m914mapMKHz9U3), Offset.m709getXimpl(m914mapMKHz9U4))));
        rect.setTop(Math.min(Math.min(Offset.m710getYimpl(m914mapMKHz9U), Offset.m710getYimpl(m914mapMKHz9U2)), Math.min(Offset.m710getYimpl(m914mapMKHz9U3), Offset.m710getYimpl(m914mapMKHz9U4))));
        rect.setRight(Math.max(Math.max(Offset.m709getXimpl(m914mapMKHz9U), Offset.m709getXimpl(m914mapMKHz9U2)), Math.max(Offset.m709getXimpl(m914mapMKHz9U3), Offset.m709getXimpl(m914mapMKHz9U4))));
        rect.setBottom(Math.max(Math.max(Offset.m710getYimpl(m914mapMKHz9U), Offset.m710getYimpl(m914mapMKHz9U2)), Math.max(Offset.m710getYimpl(m914mapMKHz9U3), Offset.m710getYimpl(m914mapMKHz9U4))));
    }

    public String toString() {
        return m919toStringimpl(this.values);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m919toStringimpl(float[] fArr) {
        String trimIndent;
        trimIndent = StringsKt__IndentKt.trimIndent("\n            |" + fArr[0] + ' ' + fArr[1] + ' ' + fArr[2] + ' ' + fArr[3] + "|\n            |" + fArr[4] + ' ' + fArr[5] + ' ' + fArr[6] + ' ' + fArr[7] + "|\n            |" + fArr[8] + ' ' + fArr[9] + ' ' + fArr[10] + ' ' + fArr[11] + "|\n            |" + fArr[12] + ' ' + fArr[13] + ' ' + fArr[14] + ' ' + fArr[15] + "|\n        ");
        return trimIndent;
    }

    /* renamed from: rotateZ-impl  reason: not valid java name */
    public static final void m917rotateZimpl(float[] fArr, float f) {
        double d = (f * 3.141592653589793d) / 180.0d;
        float cos = (float) Math.cos(d);
        float sin = (float) Math.sin(d);
        float f2 = fArr[0];
        float f3 = fArr[4];
        float f4 = -sin;
        float f5 = fArr[1];
        float f6 = fArr[5];
        float f7 = fArr[2];
        float f8 = fArr[6];
        float f9 = fArr[3];
        float f10 = fArr[7];
        fArr[0] = (cos * f2) + (sin * f3);
        fArr[1] = (cos * f5) + (sin * f6);
        fArr[2] = (cos * f7) + (sin * f8);
        fArr[3] = (cos * f9) + (sin * f10);
        fArr[4] = (f2 * f4) + (f3 * cos);
        fArr[5] = (f5 * f4) + (f6 * cos);
        fArr[6] = (f7 * f4) + (f8 * cos);
        fArr[7] = (f4 * f9) + (cos * f10);
    }

    /* renamed from: translate-impl$default  reason: not valid java name */
    public static /* synthetic */ void m921translateimpl$default(float[] fArr, float f, float f2, float f3, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        if ((i & 2) != 0) {
            f2 = 0.0f;
        }
        if ((i & 4) != 0) {
            f3 = 0.0f;
        }
        m920translateimpl(fArr, f, f2, f3);
    }
}
