package androidx.compose.ui.text.platform;

import android.graphics.Typeface;
import android.text.style.TypefaceSpan;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: AndroidAccessibilitySpannableString.android.kt */
/* loaded from: classes.dex */
final class Api28Impl {
    public static final Api28Impl INSTANCE = new Api28Impl();

    private Api28Impl() {
    }

    public final TypefaceSpan createTypefaceSpan(Typeface typeface) {
        Intrinsics.checkNotNullParameter(typeface, "typeface");
        return new TypefaceSpan(typeface);
    }
}
