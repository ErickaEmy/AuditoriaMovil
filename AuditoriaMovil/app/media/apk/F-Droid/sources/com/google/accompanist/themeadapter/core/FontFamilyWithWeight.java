package com.google.accompanist.themeadapter.core;

import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontWeight;
import ch.qos.logback.core.CoreConstants;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ResourceUtils.kt */
/* loaded from: classes.dex */
public final class FontFamilyWithWeight {
    private final FontFamily fontFamily;
    private final FontWeight weight;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FontFamilyWithWeight) {
            FontFamilyWithWeight fontFamilyWithWeight = (FontFamilyWithWeight) obj;
            return Intrinsics.areEqual(this.fontFamily, fontFamilyWithWeight.fontFamily) && Intrinsics.areEqual(this.weight, fontFamilyWithWeight.weight);
        }
        return false;
    }

    public final FontFamily getFontFamily() {
        return this.fontFamily;
    }

    public final FontWeight getWeight() {
        return this.weight;
    }

    public int hashCode() {
        return (this.fontFamily.hashCode() * 31) + this.weight.hashCode();
    }

    public String toString() {
        return "FontFamilyWithWeight(fontFamily=" + this.fontFamily + ", weight=" + this.weight + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public FontFamilyWithWeight(FontFamily fontFamily, FontWeight weight) {
        Intrinsics.checkNotNullParameter(fontFamily, "fontFamily");
        Intrinsics.checkNotNullParameter(weight, "weight");
        this.fontFamily = fontFamily;
        this.weight = weight;
    }

    public /* synthetic */ FontFamilyWithWeight(FontFamily fontFamily, FontWeight fontWeight, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(fontFamily, (i & 2) != 0 ? FontWeight.Companion.getNormal() : fontWeight);
    }
}
