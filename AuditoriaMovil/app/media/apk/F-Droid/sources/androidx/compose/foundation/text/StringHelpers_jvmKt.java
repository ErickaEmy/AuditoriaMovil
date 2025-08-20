package androidx.compose.foundation.text;

import kotlin.jvm.internal.Intrinsics;
/* compiled from: StringHelpers.jvm.kt */
/* loaded from: classes.dex */
public abstract class StringHelpers_jvmKt {
    public static final StringBuilder appendCodePointX(StringBuilder sb, int i) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        StringBuilder appendCodePointX = sb.appendCodePoint(i);
        Intrinsics.checkNotNullExpressionValue(appendCodePointX, "appendCodePointX");
        return appendCodePointX;
    }
}
