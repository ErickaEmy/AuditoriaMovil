package androidx.compose.ui.unit;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import kotlin.math.MathKt__MathJVMKt;
/* compiled from: Density.kt */
/* loaded from: classes.dex */
public interface Density {
    float getDensity();

    float getFontScale();

    /* renamed from: roundToPx-0680j_4 */
    int mo150roundToPx0680j_4(float f);

    /* renamed from: toDp-u2uoSUM */
    float mo151toDpu2uoSUM(float f);

    /* renamed from: toDp-u2uoSUM */
    float mo152toDpu2uoSUM(int i);

    /* renamed from: toDpSize-k-rfVVM */
    long mo153toDpSizekrfVVM(long j);

    /* renamed from: toPx--R2X_6o */
    float mo154toPxR2X_6o(long j);

    /* renamed from: toPx-0680j_4 */
    float mo155toPx0680j_4(float f);

    /* renamed from: toSize-XkaWNTQ */
    long mo156toSizeXkaWNTQ(long j);

    /* renamed from: toSp-kPz2Gy4 */
    long mo157toSpkPz2Gy4(float f);

    /* compiled from: Density.kt */
    /* renamed from: androidx.compose.ui.unit.Density$-CC  reason: invalid class name */
    /* loaded from: classes.dex */
    public abstract /* synthetic */ class CC {
        /* renamed from: $default$toPx-0680j_4  reason: not valid java name */
        public static float m1892$default$toPx0680j_4(Density density, float f) {
            return f * density.getDensity();
        }

        /* renamed from: $default$roundToPx-0680j_4  reason: not valid java name */
        public static int m1887$default$roundToPx0680j_4(Density density, float f) {
            int roundToInt;
            float mo155toPx0680j_4 = density.mo155toPx0680j_4(f);
            if (Float.isInfinite(mo155toPx0680j_4)) {
                return Integer.MAX_VALUE;
            }
            roundToInt = MathKt__MathJVMKt.roundToInt(mo155toPx0680j_4);
            return roundToInt;
        }

        /* renamed from: $default$toPx--R2X_6o  reason: not valid java name */
        public static float m1891$default$toPxR2X_6o(Density density, long j) {
            if (!TextUnitType.m1976equalsimpl0(TextUnit.m1963getTypeUIouoOA(j), TextUnitType.Companion.m1981getSpUIouoOA())) {
                throw new IllegalStateException("Only Sp can convert to Px".toString());
            }
            return TextUnit.m1964getValueimpl(j) * density.getFontScale() * density.getDensity();
        }

        /* renamed from: $default$toSize-XkaWNTQ  reason: not valid java name */
        public static long m1893$default$toSizeXkaWNTQ(Density density, long j) {
            if (j != DpSize.Companion.m1927getUnspecifiedMYxV2XQ()) {
                return SizeKt.Size(density.mo155toPx0680j_4(DpSize.m1923getWidthD9Ej5fM(j)), density.mo155toPx0680j_4(DpSize.m1922getHeightD9Ej5fM(j)));
            }
            return Size.Companion.m750getUnspecifiedNHjbRc();
        }

        /* renamed from: $default$toDpSize-k-rfVVM  reason: not valid java name */
        public static long m1890$default$toDpSizekrfVVM(Density density, long j) {
            if (j != Size.Companion.m750getUnspecifiedNHjbRc()) {
                return DpKt.m1907DpSizeYgX7TsA(density.mo151toDpu2uoSUM(Size.m745getWidthimpl(j)), density.mo151toDpu2uoSUM(Size.m743getHeightimpl(j)));
            }
            return DpSize.Companion.m1927getUnspecifiedMYxV2XQ();
        }
    }
}
