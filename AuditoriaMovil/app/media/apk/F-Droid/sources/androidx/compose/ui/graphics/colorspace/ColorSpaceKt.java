package androidx.compose.ui.graphics.colorspace;

import androidx.compose.ui.graphics.colorspace.ColorModel;
import androidx.compose.ui.graphics.colorspace.Connector;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ColorSpace.kt */
/* loaded from: classes.dex */
public abstract class ColorSpaceKt {
    /* renamed from: connect-YBCOT_4$default */
    public static /* synthetic */ Connector m1005connectYBCOT_4$default(ColorSpace colorSpace, ColorSpace colorSpace2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            colorSpace2 = ColorSpaces.INSTANCE.getSrgb();
        }
        if ((i2 & 2) != 0) {
            i = RenderIntent.Companion.m1013getPerceptualuksYyKA();
        }
        return m1004connectYBCOT_4(colorSpace, colorSpace2, i);
    }

    /* renamed from: connect-YBCOT_4 */
    public static final Connector m1004connectYBCOT_4(ColorSpace connect, ColorSpace destination, int i) {
        Intrinsics.checkNotNullParameter(connect, "$this$connect");
        Intrinsics.checkNotNullParameter(destination, "destination");
        ColorSpaces colorSpaces = ColorSpaces.INSTANCE;
        if (connect == colorSpaces.getSrgb()) {
            if (destination == colorSpaces.getSrgb()) {
                return Connector.Companion.getSrgbIdentity$ui_graphics_release();
            }
            if (destination == colorSpaces.getOklab() && RenderIntent.m1011equalsimpl0(i, RenderIntent.Companion.m1013getPerceptualuksYyKA())) {
                return Connector.Companion.getSrgbToOklabPerceptual$ui_graphics_release();
            }
        } else if (connect == colorSpaces.getOklab() && destination == colorSpaces.getSrgb() && RenderIntent.m1011equalsimpl0(i, RenderIntent.Companion.m1013getPerceptualuksYyKA())) {
            return Connector.Companion.getOklabToSrgbPerceptual$ui_graphics_release();
        }
        if (connect == destination) {
            return Connector.Companion.identity$ui_graphics_release(connect);
        }
        long m1002getModelxdoWZVw = connect.m1002getModelxdoWZVw();
        ColorModel.Companion companion = ColorModel.Companion;
        if (ColorModel.m995equalsimpl0(m1002getModelxdoWZVw, companion.m1000getRgbxdoWZVw()) && ColorModel.m995equalsimpl0(destination.m1002getModelxdoWZVw(), companion.m1000getRgbxdoWZVw())) {
            return new Connector.RgbConnector((Rgb) connect, (Rgb) destination, i, null);
        }
        return new Connector(connect, destination, i, null);
    }

    public static /* synthetic */ ColorSpace adapt$default(ColorSpace colorSpace, WhitePoint whitePoint, Adaptation adaptation, int i, Object obj) {
        if ((i & 2) != 0) {
            adaptation = Adaptation.Companion.getBradford();
        }
        return adapt(colorSpace, whitePoint, adaptation);
    }

    public static final ColorSpace adapt(ColorSpace colorSpace, WhitePoint whitePoint, Adaptation adaptation) {
        Intrinsics.checkNotNullParameter(colorSpace, "<this>");
        Intrinsics.checkNotNullParameter(whitePoint, "whitePoint");
        Intrinsics.checkNotNullParameter(adaptation, "adaptation");
        if (ColorModel.m995equalsimpl0(colorSpace.m1002getModelxdoWZVw(), ColorModel.Companion.m1000getRgbxdoWZVw())) {
            Rgb rgb = (Rgb) colorSpace;
            if (compare(rgb.getWhitePoint(), whitePoint)) {
                return colorSpace;
            }
            return new Rgb(rgb, mul3x3(chromaticAdaptation(adaptation.getTransform$ui_graphics_release(), rgb.getWhitePoint().toXyz$ui_graphics_release(), whitePoint.toXyz$ui_graphics_release()), rgb.getTransform$ui_graphics_release()), whitePoint);
        }
        return colorSpace;
    }

    public static final double rcpResponse(double d, double d2, double d3, double d4, double d5, double d6) {
        return d >= d5 * d4 ? (Math.pow(d, 1.0d / d6) - d3) / d2 : d / d4;
    }

    public static final double response(double d, double d2, double d3, double d4, double d5, double d6) {
        return d >= d5 ? Math.pow((d2 * d) + d3, d6) : d * d4;
    }

    public static final double rcpResponse(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8) {
        return d >= d5 * d4 ? (Math.pow(d - d6, 1.0d / d8) - d3) / d2 : (d - d7) / d4;
    }

    public static final double response(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8) {
        return d >= d5 ? Math.pow((d2 * d) + d3, d8) + d6 : (d4 * d) + d7;
    }

    public static final double absRcpResponse(double d, double d2, double d3, double d4, double d5, double d6) {
        return Math.copySign(rcpResponse(d < 0.0d ? -d : d, d2, d3, d4, d5, d6), d);
    }

    public static final double absResponse(double d, double d2, double d3, double d4, double d5, double d6) {
        return Math.copySign(response(d < 0.0d ? -d : d, d2, d3, d4, d5, d6), d);
    }

    public static final boolean compare(WhitePoint a, WhitePoint b) {
        Intrinsics.checkNotNullParameter(a, "a");
        Intrinsics.checkNotNullParameter(b, "b");
        if (a == b) {
            return true;
        }
        return Math.abs(a.getX() - b.getX()) < 0.001f && Math.abs(a.getY() - b.getY()) < 0.001f;
    }

    public static final boolean compare(float[] a, float[] b) {
        Intrinsics.checkNotNullParameter(a, "a");
        Intrinsics.checkNotNullParameter(b, "b");
        if (a == b) {
            return true;
        }
        int length = a.length;
        for (int i = 0; i < length; i++) {
            if (Float.compare(a[i], b[i]) != 0 && Math.abs(a[i] - b[i]) > 0.001f) {
                return false;
            }
        }
        return true;
    }

    public static final float[] inverse3x3(float[] m) {
        Intrinsics.checkNotNullParameter(m, "m");
        float f = m[0];
        float f2 = m[3];
        float f3 = m[6];
        float f4 = m[1];
        float f5 = m[4];
        float f6 = m[7];
        float f7 = m[2];
        float f8 = m[5];
        float f9 = m[8];
        float f10 = (f5 * f9) - (f6 * f8);
        float f11 = (f6 * f7) - (f4 * f9);
        float f12 = (f4 * f8) - (f5 * f7);
        float f13 = (f * f10) + (f2 * f11) + (f3 * f12);
        float[] fArr = new float[m.length];
        fArr[0] = f10 / f13;
        fArr[1] = f11 / f13;
        fArr[2] = f12 / f13;
        fArr[3] = ((f3 * f8) - (f2 * f9)) / f13;
        fArr[4] = ((f9 * f) - (f3 * f7)) / f13;
        fArr[5] = ((f7 * f2) - (f8 * f)) / f13;
        fArr[6] = ((f2 * f6) - (f3 * f5)) / f13;
        fArr[7] = ((f3 * f4) - (f6 * f)) / f13;
        fArr[8] = ((f * f5) - (f2 * f4)) / f13;
        return fArr;
    }

    public static final float[] mul3x3(float[] lhs, float[] rhs) {
        Intrinsics.checkNotNullParameter(lhs, "lhs");
        Intrinsics.checkNotNullParameter(rhs, "rhs");
        float f = lhs[3];
        float f2 = rhs[1];
        float f3 = lhs[6];
        float f4 = rhs[2];
        float f5 = lhs[1];
        float f6 = rhs[0];
        float f7 = lhs[4];
        float f8 = lhs[7];
        float f9 = lhs[5];
        float f10 = lhs[8];
        float f11 = lhs[0];
        float f12 = rhs[4];
        float f13 = (rhs[3] * f11) + (f * f12);
        float f14 = rhs[5];
        float f15 = lhs[1];
        float f16 = rhs[3];
        float f17 = lhs[2];
        float f18 = f11 * rhs[6];
        float f19 = lhs[3];
        float f20 = rhs[7];
        float f21 = f18 + (f19 * f20);
        float f22 = rhs[8];
        float f23 = rhs[6];
        return new float[]{(lhs[0] * rhs[0]) + (f * f2) + (f3 * f4), (f5 * f6) + (f2 * f7) + (f8 * f4), (lhs[2] * f6) + (rhs[1] * f9) + (f4 * f10), f13 + (f3 * f14), (f15 * f16) + (f7 * f12) + (f8 * f14), (f16 * f17) + (f9 * rhs[4]) + (f14 * f10), f21 + (f3 * f22), (f15 * f23) + (lhs[4] * f20) + (f8 * f22), (f17 * f23) + (lhs[5] * rhs[7]) + (f10 * f22)};
    }

    public static final float[] mul3x3Float3(float[] lhs, float[] rhs) {
        Intrinsics.checkNotNullParameter(lhs, "lhs");
        Intrinsics.checkNotNullParameter(rhs, "rhs");
        float f = rhs[0];
        float f2 = rhs[1];
        float f3 = rhs[2];
        rhs[0] = (lhs[0] * f) + (lhs[3] * f2) + (lhs[6] * f3);
        rhs[1] = (lhs[1] * f) + (lhs[4] * f2) + (lhs[7] * f3);
        rhs[2] = (lhs[2] * f) + (lhs[5] * f2) + (lhs[8] * f3);
        return rhs;
    }

    public static final float mul3x3Float3_0(float[] lhs, float f, float f2, float f3) {
        Intrinsics.checkNotNullParameter(lhs, "lhs");
        return (lhs[0] * f) + (lhs[3] * f2) + (lhs[6] * f3);
    }

    public static final float mul3x3Float3_1(float[] lhs, float f, float f2, float f3) {
        Intrinsics.checkNotNullParameter(lhs, "lhs");
        return (lhs[1] * f) + (lhs[4] * f2) + (lhs[7] * f3);
    }

    public static final float mul3x3Float3_2(float[] lhs, float f, float f2, float f3) {
        Intrinsics.checkNotNullParameter(lhs, "lhs");
        return (lhs[2] * f) + (lhs[5] * f2) + (lhs[8] * f3);
    }

    public static final float[] mul3x3Diag(float[] lhs, float[] rhs) {
        Intrinsics.checkNotNullParameter(lhs, "lhs");
        Intrinsics.checkNotNullParameter(rhs, "rhs");
        float f = lhs[0];
        float f2 = lhs[1];
        float f3 = lhs[2];
        return new float[]{lhs[0] * rhs[0], lhs[1] * rhs[1], lhs[2] * rhs[2], rhs[3] * f, rhs[4] * f2, rhs[5] * f3, f * rhs[6], f2 * rhs[7], f3 * rhs[8]};
    }

    public static final float[] chromaticAdaptation(float[] matrix, float[] srcWhitePoint, float[] dstWhitePoint) {
        Intrinsics.checkNotNullParameter(matrix, "matrix");
        Intrinsics.checkNotNullParameter(srcWhitePoint, "srcWhitePoint");
        Intrinsics.checkNotNullParameter(dstWhitePoint, "dstWhitePoint");
        float[] mul3x3Float3 = mul3x3Float3(matrix, srcWhitePoint);
        float[] mul3x3Float32 = mul3x3Float3(matrix, dstWhitePoint);
        return mul3x3(inverse3x3(matrix), mul3x3Diag(new float[]{mul3x3Float32[0] / mul3x3Float3[0], mul3x3Float32[1] / mul3x3Float3[1], mul3x3Float32[2] / mul3x3Float3[2]}, matrix));
    }
}
