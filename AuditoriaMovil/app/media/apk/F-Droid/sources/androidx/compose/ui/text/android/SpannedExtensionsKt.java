package androidx.compose.ui.text.android;

import android.text.Spanned;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SpannedExtensions.kt */
/* loaded from: classes.dex */
public abstract class SpannedExtensionsKt {
    public static final boolean hasSpan(Spanned spanned, Class clazz) {
        Intrinsics.checkNotNullParameter(spanned, "<this>");
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        return spanned.nextSpanTransition(-1, spanned.length(), clazz) != spanned.length();
    }

    public static final boolean hasSpan(Spanned spanned, Class clazz, int i, int i2) {
        Intrinsics.checkNotNullParameter(spanned, "<this>");
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        return spanned.nextSpanTransition(i - 1, i2, clazz) != i2;
    }
}
