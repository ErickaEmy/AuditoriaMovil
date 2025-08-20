package androidx.compose.ui.graphics.colorspace;

import androidx.compose.ui.graphics.ColorKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.bouncycastle.asn1.cmc.BodyPartID;
/* compiled from: Oklab.kt */
/* loaded from: classes.dex */
public final class Oklab extends ColorSpace {
    public static final Companion Companion = new Companion(null);
    private static final float[] InverseM1;
    private static final float[] InverseM2;
    private static final float[] M1;
    private static final float[] M2;

    /* compiled from: Oklab.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float getMaxValue(int i) {
        return i == 0 ? 1.0f : 0.5f;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float getMinValue(int i) {
        return i == 0 ? 0.0f : -0.5f;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Oklab(String name, int i) {
        super(name, ColorModel.Companion.m999getLabxdoWZVw(), i, null);
        Intrinsics.checkNotNullParameter(name, "name");
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public long toXy$ui_graphics_release(float f, float f2, float f3) {
        float coerceIn;
        float coerceIn2;
        float coerceIn3;
        coerceIn = RangesKt___RangesKt.coerceIn(f, 0.0f, 1.0f);
        coerceIn2 = RangesKt___RangesKt.coerceIn(f2, -0.5f, 0.5f);
        coerceIn3 = RangesKt___RangesKt.coerceIn(f3, -0.5f, 0.5f);
        float[] fArr = InverseM2;
        float mul3x3Float3_0 = ColorSpaceKt.mul3x3Float3_0(fArr, coerceIn, coerceIn2, coerceIn3);
        float mul3x3Float3_1 = ColorSpaceKt.mul3x3Float3_1(fArr, coerceIn, coerceIn2, coerceIn3);
        float mul3x3Float3_2 = ColorSpaceKt.mul3x3Float3_2(fArr, coerceIn, coerceIn2, coerceIn3);
        float f4 = mul3x3Float3_0 * mul3x3Float3_0 * mul3x3Float3_0;
        float f5 = mul3x3Float3_1 * mul3x3Float3_1 * mul3x3Float3_1;
        float f6 = mul3x3Float3_2 * mul3x3Float3_2 * mul3x3Float3_2;
        float[] fArr2 = InverseM1;
        return (Float.floatToIntBits(ColorSpaceKt.mul3x3Float3_0(fArr2, f4, f5, f6)) << 32) | (Float.floatToIntBits(ColorSpaceKt.mul3x3Float3_1(fArr2, f4, f5, f6)) & BodyPartID.bodyIdMax);
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float toZ$ui_graphics_release(float f, float f2, float f3) {
        float coerceIn;
        float coerceIn2;
        float coerceIn3;
        coerceIn = RangesKt___RangesKt.coerceIn(f, 0.0f, 1.0f);
        coerceIn2 = RangesKt___RangesKt.coerceIn(f2, -0.5f, 0.5f);
        coerceIn3 = RangesKt___RangesKt.coerceIn(f3, -0.5f, 0.5f);
        float[] fArr = InverseM2;
        float mul3x3Float3_0 = ColorSpaceKt.mul3x3Float3_0(fArr, coerceIn, coerceIn2, coerceIn3);
        float mul3x3Float3_1 = ColorSpaceKt.mul3x3Float3_1(fArr, coerceIn, coerceIn2, coerceIn3);
        float mul3x3Float3_2 = ColorSpaceKt.mul3x3Float3_2(fArr, coerceIn, coerceIn2, coerceIn3);
        float f4 = mul3x3Float3_2 * mul3x3Float3_2 * mul3x3Float3_2;
        return ColorSpaceKt.mul3x3Float3_2(InverseM1, mul3x3Float3_0 * mul3x3Float3_0 * mul3x3Float3_0, mul3x3Float3_1 * mul3x3Float3_1 * mul3x3Float3_1, f4);
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    /* renamed from: xyzaToColor-JlNiLsg$ui_graphics_release */
    public long mo1003xyzaToColorJlNiLsg$ui_graphics_release(float f, float f2, float f3, float f4, ColorSpace colorSpace) {
        Intrinsics.checkNotNullParameter(colorSpace, "colorSpace");
        float[] fArr = M1;
        float mul3x3Float3_0 = ColorSpaceKt.mul3x3Float3_0(fArr, f, f2, f3);
        float mul3x3Float3_1 = ColorSpaceKt.mul3x3Float3_1(fArr, f, f2, f3);
        float mul3x3Float3_2 = ColorSpaceKt.mul3x3Float3_2(fArr, f, f2, f3);
        double d = 0.33333334f;
        float signum = Math.signum(mul3x3Float3_0) * ((float) Math.pow(Math.abs(mul3x3Float3_0), d));
        float signum2 = Math.signum(mul3x3Float3_1) * ((float) Math.pow(Math.abs(mul3x3Float3_1), d));
        float signum3 = Math.signum(mul3x3Float3_2) * ((float) Math.pow(Math.abs(mul3x3Float3_2), d));
        float[] fArr2 = M2;
        return ColorKt.Color(ColorSpaceKt.mul3x3Float3_0(fArr2, signum, signum2, signum3), ColorSpaceKt.mul3x3Float3_1(fArr2, signum, signum2, signum3), ColorSpaceKt.mul3x3Float3_2(fArr2, signum, signum2, signum3), f4, colorSpace);
    }

    static {
        float[] transform$ui_graphics_release = Adaptation.Companion.getBradford().getTransform$ui_graphics_release();
        Illuminant illuminant = Illuminant.INSTANCE;
        float[] mul3x3 = ColorSpaceKt.mul3x3(new float[]{0.818933f, 0.032984544f, 0.0482003f, 0.36186674f, 0.9293119f, 0.26436627f, -0.12885971f, 0.03614564f, 0.6338517f}, ColorSpaceKt.chromaticAdaptation(transform$ui_graphics_release, illuminant.getD50().toXyz$ui_graphics_release(), illuminant.getD65().toXyz$ui_graphics_release()));
        M1 = mul3x3;
        float[] fArr = {0.21045426f, 1.9779985f, 0.025904037f, 0.7936178f, -2.4285922f, 0.78277177f, -0.004072047f, 0.4505937f, -0.80867577f};
        M2 = fArr;
        InverseM1 = ColorSpaceKt.inverse3x3(mul3x3);
        InverseM2 = ColorSpaceKt.inverse3x3(fArr);
    }
}
