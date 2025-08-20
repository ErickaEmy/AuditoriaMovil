package androidx.compose.ui.text.font;

import android.graphics.Typeface;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: AndroidFontUtils.android.kt */
/* loaded from: classes.dex */
public final class TypefaceHelperMethodsApi28 {
    public static final TypefaceHelperMethodsApi28 INSTANCE = new TypefaceHelperMethodsApi28();

    private TypefaceHelperMethodsApi28() {
    }

    public final Typeface create(Typeface typeface, int i, boolean z) {
        Typeface create;
        Intrinsics.checkNotNullParameter(typeface, "typeface");
        create = Typeface.create(typeface, i, z);
        Intrinsics.checkNotNullExpressionValue(create, "create(typeface, finalFontWeight, finalFontStyle)");
        return create;
    }
}
