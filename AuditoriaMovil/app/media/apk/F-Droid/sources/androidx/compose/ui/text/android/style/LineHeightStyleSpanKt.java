package androidx.compose.ui.text.android.style;

import android.graphics.Paint;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: LineHeightStyleSpan.kt */
/* loaded from: classes.dex */
public abstract class LineHeightStyleSpanKt {
    public static final int lineHeight(Paint.FontMetricsInt fontMetricsInt) {
        Intrinsics.checkNotNullParameter(fontMetricsInt, "<this>");
        return fontMetricsInt.descent - fontMetricsInt.ascent;
    }
}
