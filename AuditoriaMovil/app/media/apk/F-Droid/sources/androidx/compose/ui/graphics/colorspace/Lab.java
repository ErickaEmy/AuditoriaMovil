package androidx.compose.ui.graphics.colorspace;

import androidx.compose.ui.graphics.ColorKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.bouncycastle.asn1.cmc.BodyPartID;
/* compiled from: Lab.kt */
/* loaded from: classes.dex */
public final class Lab extends ColorSpace {
    public static final Companion Companion = new Companion(null);

    /* compiled from: Lab.kt */
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
        return i == 0 ? 100.0f : 128.0f;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float getMinValue(int i) {
        return i == 0 ? 0.0f : -128.0f;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Lab(String name, int i) {
        super(name, ColorModel.Companion.m999getLabxdoWZVw(), i, null);
        Intrinsics.checkNotNullParameter(name, "name");
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public long toXy$ui_graphics_release(float f, float f2, float f3) {
        float coerceIn;
        float coerceIn2;
        coerceIn = RangesKt___RangesKt.coerceIn(f, 0.0f, 100.0f);
        coerceIn2 = RangesKt___RangesKt.coerceIn(f, -128.0f, 128.0f);
        float f4 = (coerceIn + 16.0f) / 116.0f;
        float f5 = (coerceIn2 * 0.002f) + f4;
        float f6 = f5 > 0.20689656f ? f5 * f5 * f5 : (f5 - 0.13793103f) * 0.12841855f;
        float f7 = f4 > 0.20689656f ? f4 * f4 * f4 : (f4 - 0.13793103f) * 0.12841855f;
        Illuminant illuminant = Illuminant.INSTANCE;
        return (Float.floatToIntBits(f6 * illuminant.getD50Xyz$ui_graphics_release()[0]) << 32) | (Float.floatToIntBits(f7 * illuminant.getD50Xyz$ui_graphics_release()[1]) & BodyPartID.bodyIdMax);
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float toZ$ui_graphics_release(float f, float f2, float f3) {
        float coerceIn;
        float coerceIn2;
        coerceIn = RangesKt___RangesKt.coerceIn(f, 0.0f, 100.0f);
        coerceIn2 = RangesKt___RangesKt.coerceIn(f3, -128.0f, 128.0f);
        float f4 = ((coerceIn + 16.0f) / 116.0f) - (coerceIn2 * 0.005f);
        return (f4 > 0.20689656f ? f4 * f4 * f4 : 0.12841855f * (f4 - 0.13793103f)) * Illuminant.INSTANCE.getD50Xyz$ui_graphics_release()[2];
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    /* renamed from: xyzaToColor-JlNiLsg$ui_graphics_release */
    public long mo1003xyzaToColorJlNiLsg$ui_graphics_release(float f, float f2, float f3, float f4, ColorSpace colorSpace) {
        float coerceIn;
        float coerceIn2;
        float coerceIn3;
        Intrinsics.checkNotNullParameter(colorSpace, "colorSpace");
        Illuminant illuminant = Illuminant.INSTANCE;
        float f5 = f / illuminant.getD50Xyz$ui_graphics_release()[0];
        float f6 = f2 / illuminant.getD50Xyz$ui_graphics_release()[1];
        float f7 = f3 / illuminant.getD50Xyz$ui_graphics_release()[2];
        float pow = f5 > 0.008856452f ? (float) Math.pow(f5, 0.33333334f) : (f5 * 7.787037f) + 0.13793103f;
        float pow2 = f6 > 0.008856452f ? (float) Math.pow(f6, 0.33333334f) : (f6 * 7.787037f) + 0.13793103f;
        float pow3 = f7 > 0.008856452f ? (float) Math.pow(f7, 0.33333334f) : (f7 * 7.787037f) + 0.13793103f;
        coerceIn = RangesKt___RangesKt.coerceIn((116.0f * pow2) - 16.0f, 0.0f, 100.0f);
        coerceIn2 = RangesKt___RangesKt.coerceIn((pow - pow2) * 500.0f, -128.0f, 128.0f);
        coerceIn3 = RangesKt___RangesKt.coerceIn((pow2 - pow3) * 200.0f, -128.0f, 128.0f);
        return ColorKt.Color(coerceIn, coerceIn2, coerceIn3, f4, colorSpace);
    }
}
