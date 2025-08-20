package androidx.compose.ui.text.font;

import ch.qos.logback.core.CoreConstants;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Font.kt */
/* loaded from: classes.dex */
public final class ResourceFont implements Font {
    private final int loadingStrategy;
    private final int resId;
    private final int style;
    private final FontVariation$Settings variationSettings;
    private final FontWeight weight;

    public /* synthetic */ ResourceFont(int i, FontWeight fontWeight, int i2, FontVariation$Settings fontVariation$Settings, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, fontWeight, i2, fontVariation$Settings, i3);
    }

    @Override // androidx.compose.ui.text.font.Font
    /* renamed from: getLoadingStrategy-PKNRLFQ */
    public int mo1624getLoadingStrategyPKNRLFQ() {
        return this.loadingStrategy;
    }

    public final int getResId() {
        return this.resId;
    }

    @Override // androidx.compose.ui.text.font.Font
    /* renamed from: getStyle-_-LCdwA */
    public int mo1625getStyle_LCdwA() {
        return this.style;
    }

    public final FontVariation$Settings getVariationSettings() {
        return this.variationSettings;
    }

    @Override // androidx.compose.ui.text.font.Font
    public FontWeight getWeight() {
        return this.weight;
    }

    private ResourceFont(int i, FontWeight weight, int i2, FontVariation$Settings variationSettings, int i3) {
        Intrinsics.checkNotNullParameter(weight, "weight");
        Intrinsics.checkNotNullParameter(variationSettings, "variationSettings");
        this.resId = i;
        this.weight = weight;
        this.style = i2;
        this.variationSettings = variationSettings;
        this.loadingStrategy = i3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ResourceFont) {
            ResourceFont resourceFont = (ResourceFont) obj;
            return this.resId == resourceFont.resId && Intrinsics.areEqual(getWeight(), resourceFont.getWeight()) && FontStyle.m1641equalsimpl0(mo1625getStyle_LCdwA(), resourceFont.mo1625getStyle_LCdwA()) && Intrinsics.areEqual(this.variationSettings, resourceFont.variationSettings) && FontLoadingStrategy.m1631equalsimpl0(mo1624getLoadingStrategyPKNRLFQ(), resourceFont.mo1624getLoadingStrategyPKNRLFQ());
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.resId * 31) + getWeight().hashCode()) * 31) + FontStyle.m1642hashCodeimpl(mo1625getStyle_LCdwA())) * 31) + FontLoadingStrategy.m1632hashCodeimpl(mo1624getLoadingStrategyPKNRLFQ())) * 31) + this.variationSettings.hashCode();
    }

    public String toString() {
        return "ResourceFont(resId=" + this.resId + ", weight=" + getWeight() + ", style=" + ((Object) FontStyle.m1643toStringimpl(mo1625getStyle_LCdwA())) + ", loadingStrategy=" + ((Object) FontLoadingStrategy.m1633toStringimpl(mo1624getLoadingStrategyPKNRLFQ())) + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }
}
