package androidx.compose.ui.text.platform.extensions;

import android.text.style.TtsSpan;
import androidx.compose.ui.text.TtsAnnotation;
import androidx.compose.ui.text.VerbatimTtsAnnotation;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: TtsAnnotationExtensions.android.kt */
/* loaded from: classes.dex */
public abstract class TtsAnnotationExtensions_androidKt {
    public static final TtsSpan toSpan(TtsAnnotation ttsAnnotation) {
        Intrinsics.checkNotNullParameter(ttsAnnotation, "<this>");
        if (ttsAnnotation instanceof VerbatimTtsAnnotation) {
            return toSpan((VerbatimTtsAnnotation) ttsAnnotation);
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final TtsSpan toSpan(VerbatimTtsAnnotation verbatimTtsAnnotation) {
        Intrinsics.checkNotNullParameter(verbatimTtsAnnotation, "<this>");
        TtsSpan build = new TtsSpan.VerbatimBuilder(verbatimTtsAnnotation.getVerbatim()).build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return build;
    }
}
