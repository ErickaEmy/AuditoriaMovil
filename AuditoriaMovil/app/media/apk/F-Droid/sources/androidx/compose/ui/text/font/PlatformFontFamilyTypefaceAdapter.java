package androidx.compose.ui.text.font;

import android.graphics.Typeface;
import androidx.compose.ui.text.font.TypefaceResult;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: PlatformFontFamilyTypefaceAdapter.android.kt */
/* loaded from: classes.dex */
public final class PlatformFontFamilyTypefaceAdapter {
    private final PlatformTypefaces platformTypefaceResolver = PlatformTypefacesKt.PlatformTypefaces();

    public TypefaceResult resolve(TypefaceRequest typefaceRequest, PlatformFontLoader platformFontLoader, Function1 onAsyncCompletion, Function1 createDefaultTypeface) {
        Typeface mo1663createDefaultFO1MlWM;
        Intrinsics.checkNotNullParameter(typefaceRequest, "typefaceRequest");
        Intrinsics.checkNotNullParameter(platformFontLoader, "platformFontLoader");
        Intrinsics.checkNotNullParameter(onAsyncCompletion, "onAsyncCompletion");
        Intrinsics.checkNotNullParameter(createDefaultTypeface, "createDefaultTypeface");
        FontFamily fontFamily = typefaceRequest.getFontFamily();
        if (fontFamily == null || (fontFamily instanceof DefaultFontFamily)) {
            mo1663createDefaultFO1MlWM = this.platformTypefaceResolver.mo1663createDefaultFO1MlWM(typefaceRequest.getFontWeight(), typefaceRequest.m1670getFontStyle_LCdwA());
        } else if (!(fontFamily instanceof GenericFontFamily)) {
            return null;
        } else {
            mo1663createDefaultFO1MlWM = this.platformTypefaceResolver.mo1664createNamedRetOiIg((GenericFontFamily) typefaceRequest.getFontFamily(), typefaceRequest.getFontWeight(), typefaceRequest.m1670getFontStyle_LCdwA());
        }
        return new TypefaceResult.Immutable(mo1663createDefaultFO1MlWM, false, 2, null);
    }
}
