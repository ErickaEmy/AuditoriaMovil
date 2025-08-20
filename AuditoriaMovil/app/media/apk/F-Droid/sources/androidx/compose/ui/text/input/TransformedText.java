package androidx.compose.ui.text.input;

import androidx.compose.ui.text.AnnotatedString;
import ch.qos.logback.core.CoreConstants;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: VisualTransformation.kt */
/* loaded from: classes.dex */
public final class TransformedText {
    private final OffsetMapping offsetMapping;
    private final AnnotatedString text;

    public final OffsetMapping getOffsetMapping() {
        return this.offsetMapping;
    }

    public final AnnotatedString getText() {
        return this.text;
    }

    public TransformedText(AnnotatedString text, OffsetMapping offsetMapping) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(offsetMapping, "offsetMapping");
        this.text = text;
        this.offsetMapping = offsetMapping;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TransformedText) {
            TransformedText transformedText = (TransformedText) obj;
            return Intrinsics.areEqual(this.text, transformedText.text) && Intrinsics.areEqual(this.offsetMapping, transformedText.offsetMapping);
        }
        return false;
    }

    public int hashCode() {
        return (this.text.hashCode() * 31) + this.offsetMapping.hashCode();
    }

    public String toString() {
        return "TransformedText(text=" + ((Object) this.text) + ", offsetMapping=" + this.offsetMapping + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }
}
