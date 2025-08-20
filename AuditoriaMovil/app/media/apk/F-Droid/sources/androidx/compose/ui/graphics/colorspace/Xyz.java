package androidx.compose.ui.graphics.colorspace;

import androidx.compose.ui.graphics.ColorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.bouncycastle.asn1.cmc.BodyPartID;
/* compiled from: Xyz.kt */
/* loaded from: classes.dex */
public final class Xyz extends ColorSpace {
    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float getMaxValue(int i) {
        return 2.0f;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float getMinValue(int i) {
        return -2.0f;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Xyz(String name, int i) {
        super(name, ColorModel.Companion.m1001getXyzxdoWZVw(), i, null);
        Intrinsics.checkNotNullParameter(name, "name");
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public long toXy$ui_graphics_release(float f, float f2, float f3) {
        float clamp = clamp(f);
        float clamp2 = clamp(f2);
        return (Float.floatToIntBits(clamp2) & BodyPartID.bodyIdMax) | (Float.floatToIntBits(clamp) << 32);
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float toZ$ui_graphics_release(float f, float f2, float f3) {
        return clamp(f3);
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    /* renamed from: xyzaToColor-JlNiLsg$ui_graphics_release */
    public long mo1003xyzaToColorJlNiLsg$ui_graphics_release(float f, float f2, float f3, float f4, ColorSpace colorSpace) {
        Intrinsics.checkNotNullParameter(colorSpace, "colorSpace");
        return ColorKt.Color(clamp(f), clamp(f2), clamp(f3), f4, colorSpace);
    }

    private final float clamp(float f) {
        float coerceIn;
        coerceIn = RangesKt___RangesKt.coerceIn(f, -2.0f, 2.0f);
        return coerceIn;
    }
}
