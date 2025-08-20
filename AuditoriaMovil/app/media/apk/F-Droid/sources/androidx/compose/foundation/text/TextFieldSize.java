package androidx.compose.foundation.text;

import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TextFieldSize.kt */
/* loaded from: classes.dex */
public final class TextFieldSize {
    private Density density;
    private FontFamily.Resolver fontFamilyResolver;
    private LayoutDirection layoutDirection;
    private long minSize;
    private TextStyle resolvedStyle;
    private Object typeface;

    /* renamed from: getMinSize-YbymL2g  reason: not valid java name */
    public final long m349getMinSizeYbymL2g() {
        return this.minSize;
    }

    public TextFieldSize(LayoutDirection layoutDirection, Density density, FontFamily.Resolver fontFamilyResolver, TextStyle resolvedStyle, Object typeface) {
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(fontFamilyResolver, "fontFamilyResolver");
        Intrinsics.checkNotNullParameter(resolvedStyle, "resolvedStyle");
        Intrinsics.checkNotNullParameter(typeface, "typeface");
        this.layoutDirection = layoutDirection;
        this.density = density;
        this.fontFamilyResolver = fontFamilyResolver;
        this.resolvedStyle = resolvedStyle;
        this.typeface = typeface;
        this.minSize = m348computeMinSizeYbymL2g();
    }

    public final void update(LayoutDirection layoutDirection, Density density, FontFamily.Resolver fontFamilyResolver, TextStyle resolvedStyle, Object typeface) {
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(fontFamilyResolver, "fontFamilyResolver");
        Intrinsics.checkNotNullParameter(resolvedStyle, "resolvedStyle");
        Intrinsics.checkNotNullParameter(typeface, "typeface");
        if (layoutDirection == this.layoutDirection && Intrinsics.areEqual(density, this.density) && Intrinsics.areEqual(fontFamilyResolver, this.fontFamilyResolver) && Intrinsics.areEqual(resolvedStyle, this.resolvedStyle) && Intrinsics.areEqual(typeface, this.typeface)) {
            return;
        }
        this.layoutDirection = layoutDirection;
        this.density = density;
        this.fontFamilyResolver = fontFamilyResolver;
        this.resolvedStyle = resolvedStyle;
        this.typeface = typeface;
        this.minSize = m348computeMinSizeYbymL2g();
    }

    /* renamed from: computeMinSize-YbymL2g  reason: not valid java name */
    private final long m348computeMinSizeYbymL2g() {
        return TextFieldDelegateKt.computeSizeForDefaultText$default(this.resolvedStyle, this.density, this.fontFamilyResolver, null, 0, 24, null);
    }
}
