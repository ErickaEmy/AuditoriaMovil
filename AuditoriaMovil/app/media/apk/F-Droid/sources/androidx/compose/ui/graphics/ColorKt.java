package androidx.compose.ui.graphics;

import androidx.compose.ui.graphics.colorspace.ColorModel;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import androidx.compose.ui.graphics.colorspace.DoubleFunction;
import androidx.compose.ui.graphics.colorspace.Rgb;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.ULong;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.asn1.cmc.BodyPartID;
/* compiled from: Color.kt */
/* loaded from: classes.dex */
public abstract class ColorKt {
    private static final float saturate(float f) {
        float f2 = 0.0f;
        if (f > 0.0f) {
            f2 = 1.0f;
            if (f < 1.0f) {
                return f;
            }
        }
        return f2;
    }

    public static final long Color(float f, float f2, float f3, float f4, ColorSpace colorSpace) {
        Intrinsics.checkNotNullParameter(colorSpace, "colorSpace");
        float minValue = colorSpace.getMinValue(0);
        if (f <= colorSpace.getMaxValue(0) && minValue <= f) {
            float minValue2 = colorSpace.getMinValue(1);
            if (f2 <= colorSpace.getMaxValue(1) && minValue2 <= f2) {
                float minValue3 = colorSpace.getMinValue(2);
                if (f3 <= colorSpace.getMaxValue(2) && minValue3 <= f3 && 0.0f <= f4 && f4 <= 1.0f) {
                    if (colorSpace.isSrgb()) {
                        return Color.m846constructorimpl(ULong.m2135constructorimpl(ULong.m2135constructorimpl(ULong.m2135constructorimpl((((((int) ((f * 255.0f) + 0.5f)) << 16) | (((int) ((f4 * 255.0f) + 0.5f)) << 24)) | (((int) ((f2 * 255.0f) + 0.5f)) << 8)) | ((int) ((f3 * 255.0f) + 0.5f))) & BodyPartID.bodyIdMax) << 32));
                    } else if (colorSpace.getComponentCount() != 3) {
                        throw new IllegalArgumentException("Color only works with ColorSpaces with 3 components".toString());
                    } else {
                        int id$ui_graphics_release = colorSpace.getId$ui_graphics_release();
                        if (id$ui_graphics_release == -1) {
                            throw new IllegalArgumentException("Unknown color space, please use a color space in ColorSpaces".toString());
                        }
                        short m885constructorimpl = Float16.m885constructorimpl(f);
                        short m885constructorimpl2 = Float16.m885constructorimpl(f2);
                        short m885constructorimpl3 = Float16.m885constructorimpl(f3);
                        return Color.m846constructorimpl(ULong.m2135constructorimpl(ULong.m2135constructorimpl(ULong.m2135constructorimpl(ULong.m2135constructorimpl(ULong.m2135constructorimpl(ULong.m2135constructorimpl(ULong.m2135constructorimpl(m885constructorimpl2) & 65535) << 32) | ULong.m2135constructorimpl(ULong.m2135constructorimpl(ULong.m2135constructorimpl(m885constructorimpl) & 65535) << 48)) | ULong.m2135constructorimpl(ULong.m2135constructorimpl(ULong.m2135constructorimpl(m885constructorimpl3) & 65535) << 16)) | ULong.m2135constructorimpl(ULong.m2135constructorimpl(ULong.m2135constructorimpl((int) ((Math.max(0.0f, Math.min(f4, 1.0f)) * 1023.0f) + 0.5f)) & 1023) << 6)) | ULong.m2135constructorimpl(ULong.m2135constructorimpl(id$ui_graphics_release) & 63)));
                    }
                }
            }
        }
        throw new IllegalArgumentException(("red = " + f + ", green = " + f2 + ", blue = " + f3 + ", alpha = " + f4 + " outside the range for " + colorSpace).toString());
    }

    public static final long Color(int i) {
        return Color.m846constructorimpl(ULong.m2135constructorimpl(ULong.m2135constructorimpl(i) << 32));
    }

    public static final long Color(long j) {
        return Color.m846constructorimpl(ULong.m2135constructorimpl(ULong.m2135constructorimpl(ULong.m2135constructorimpl(j) & BodyPartID.bodyIdMax) << 32));
    }

    /* renamed from: lerp-jxsXWHM  reason: not valid java name */
    public static final long m869lerpjxsXWHM(long j, long j2, float f) {
        ColorSpace oklab = ColorSpaces.INSTANCE.getOklab();
        long m847convertvNxB06k = Color.m847convertvNxB06k(j, oklab);
        long m847convertvNxB06k2 = Color.m847convertvNxB06k(j2, oklab);
        float m852getAlphaimpl = Color.m852getAlphaimpl(m847convertvNxB06k);
        float m856getRedimpl = Color.m856getRedimpl(m847convertvNxB06k);
        float m855getGreenimpl = Color.m855getGreenimpl(m847convertvNxB06k);
        float m853getBlueimpl = Color.m853getBlueimpl(m847convertvNxB06k);
        float m852getAlphaimpl2 = Color.m852getAlphaimpl(m847convertvNxB06k2);
        float m856getRedimpl2 = Color.m856getRedimpl(m847convertvNxB06k2);
        float m855getGreenimpl2 = Color.m855getGreenimpl(m847convertvNxB06k2);
        float m853getBlueimpl2 = Color.m853getBlueimpl(m847convertvNxB06k2);
        return Color.m847convertvNxB06k(Color(MathHelpersKt.lerp(m856getRedimpl, m856getRedimpl2, f), MathHelpersKt.lerp(m855getGreenimpl, m855getGreenimpl2, f), MathHelpersKt.lerp(m853getBlueimpl, m853getBlueimpl2, f), MathHelpersKt.lerp(m852getAlphaimpl, m852getAlphaimpl2, f), oklab), Color.m854getColorSpaceimpl(j2));
    }

    /* renamed from: compositeOver--OWjLjI  reason: not valid java name */
    public static final long m868compositeOverOWjLjI(long j, long j2) {
        long m847convertvNxB06k = Color.m847convertvNxB06k(j, Color.m854getColorSpaceimpl(j2));
        float m852getAlphaimpl = Color.m852getAlphaimpl(j2);
        float m852getAlphaimpl2 = Color.m852getAlphaimpl(m847convertvNxB06k);
        float f = 1.0f - m852getAlphaimpl2;
        float f2 = (m852getAlphaimpl * f) + m852getAlphaimpl2;
        int i = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
        return Color(i == 0 ? 0.0f : ((Color.m856getRedimpl(m847convertvNxB06k) * m852getAlphaimpl2) + ((Color.m856getRedimpl(j2) * m852getAlphaimpl) * f)) / f2, i == 0 ? 0.0f : ((Color.m855getGreenimpl(m847convertvNxB06k) * m852getAlphaimpl2) + ((Color.m855getGreenimpl(j2) * m852getAlphaimpl) * f)) / f2, i != 0 ? ((Color.m853getBlueimpl(m847convertvNxB06k) * m852getAlphaimpl2) + ((Color.m853getBlueimpl(j2) * m852getAlphaimpl) * f)) / f2 : 0.0f, f2, Color.m854getColorSpaceimpl(j2));
    }

    /* renamed from: luminance-8_81llA  reason: not valid java name */
    public static final float m870luminance8_81llA(long j) {
        ColorSpace m854getColorSpaceimpl = Color.m854getColorSpaceimpl(j);
        if (!ColorModel.m995equalsimpl0(m854getColorSpaceimpl.m1002getModelxdoWZVw(), ColorModel.Companion.m1000getRgbxdoWZVw())) {
            throw new IllegalArgumentException(("The specified color must be encoded in an RGB color space. The supplied color space is " + ((Object) ColorModel.m998toStringimpl(m854getColorSpaceimpl.m1002getModelxdoWZVw()))).toString());
        }
        Intrinsics.checkNotNull(m854getColorSpaceimpl, "null cannot be cast to non-null type androidx.compose.ui.graphics.colorspace.Rgb");
        DoubleFunction eotfFunc$ui_graphics_release = ((Rgb) m854getColorSpaceimpl).getEotfFunc$ui_graphics_release();
        return saturate((float) ((eotfFunc$ui_graphics_release.invoke(Color.m856getRedimpl(j)) * 0.2126d) + (eotfFunc$ui_graphics_release.invoke(Color.m855getGreenimpl(j)) * 0.7152d) + (eotfFunc$ui_graphics_release.invoke(Color.m853getBlueimpl(j)) * 0.0722d)));
    }

    /* renamed from: toArgb-8_81llA  reason: not valid java name */
    public static final int m871toArgb8_81llA(long j) {
        return (int) ULong.m2135constructorimpl(Color.m847convertvNxB06k(j, ColorSpaces.INSTANCE.getSrgb()) >>> 32);
    }
}
