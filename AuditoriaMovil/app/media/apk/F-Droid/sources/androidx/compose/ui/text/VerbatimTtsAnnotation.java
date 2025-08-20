package androidx.compose.ui.text;

import ch.qos.logback.core.CoreConstants;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: TtsAnnotation.kt */
/* loaded from: classes.dex */
public final class VerbatimTtsAnnotation extends TtsAnnotation {
    private final String verbatim;

    public final String getVerbatim() {
        return this.verbatim;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VerbatimTtsAnnotation(String verbatim) {
        super(null);
        Intrinsics.checkNotNullParameter(verbatim, "verbatim");
        this.verbatim = verbatim;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof VerbatimTtsAnnotation) && Intrinsics.areEqual(this.verbatim, ((VerbatimTtsAnnotation) obj).verbatim);
    }

    public int hashCode() {
        return this.verbatim.hashCode();
    }

    public String toString() {
        return "VerbatimTtsAnnotation(verbatim=" + this.verbatim + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }
}
