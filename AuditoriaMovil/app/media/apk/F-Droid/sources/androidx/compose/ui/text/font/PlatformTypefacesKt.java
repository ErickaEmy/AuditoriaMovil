package androidx.compose.ui.text.font;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: PlatformTypefaces.kt */
/* loaded from: classes.dex */
public abstract class PlatformTypefacesKt {
    public static final PlatformTypefaces PlatformTypefaces() {
        if (Build.VERSION.SDK_INT >= 28) {
            return new PlatformTypefacesApi28();
        }
        return new PlatformTypefacesApi();
    }

    public static final Typeface setFontVariationSettings(Typeface typeface, FontVariation$Settings variationSettings, Context context) {
        Intrinsics.checkNotNullParameter(variationSettings, "variationSettings");
        Intrinsics.checkNotNullParameter(context, "context");
        return Build.VERSION.SDK_INT >= 26 ? TypefaceCompatApi26.INSTANCE.setFontVariationSettings(typeface, variationSettings, context) : typeface;
    }

    public static final String getWeightSuffixForFallbackFamilyName(String name, FontWeight fontWeight) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(fontWeight, "fontWeight");
        int weight = fontWeight.getWeight() / 100;
        if (weight >= 0 && weight < 2) {
            return name + "-thin";
        } else if (2 <= weight && weight < 4) {
            return name + "-light";
        } else if (weight == 4) {
            return name;
        } else {
            if (weight == 5) {
                return name + "-medium";
            } else if ((6 > weight || weight >= 8) && 8 <= weight && weight < 11) {
                return name + "-black";
            } else {
                return name;
            }
        }
    }
}
