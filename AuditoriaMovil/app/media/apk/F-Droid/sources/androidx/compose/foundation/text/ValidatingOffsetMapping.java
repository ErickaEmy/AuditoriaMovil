package androidx.compose.foundation.text;

import androidx.compose.ui.text.input.OffsetMapping;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ValidatingOffsetMapping.kt */
/* loaded from: classes.dex */
final class ValidatingOffsetMapping implements OffsetMapping {
    private final OffsetMapping delegate;
    private final int originalLength;
    private final int transformedLength;

    public ValidatingOffsetMapping(OffsetMapping delegate, int i, int i2) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
        this.originalLength = i;
        this.transformedLength = i2;
    }

    @Override // androidx.compose.ui.text.input.OffsetMapping
    public int originalToTransformed(int i) {
        int originalToTransformed = this.delegate.originalToTransformed(i);
        if (originalToTransformed < 0 || originalToTransformed > this.transformedLength) {
            throw new IllegalStateException(("OffsetMapping.originalToTransformed returned invalid mapping: " + i + " -> " + originalToTransformed + " is not in range of transformed text [0, " + this.transformedLength + ']').toString());
        }
        return originalToTransformed;
    }

    @Override // androidx.compose.ui.text.input.OffsetMapping
    public int transformedToOriginal(int i) {
        int transformedToOriginal = this.delegate.transformedToOriginal(i);
        if (transformedToOriginal < 0 || transformedToOriginal > this.originalLength) {
            throw new IllegalStateException(("OffsetMapping.transformedToOriginal returned invalid mapping: " + i + " -> " + transformedToOriginal + " is not in range of original text [0, " + this.originalLength + ']').toString());
        }
        return transformedToOriginal;
    }
}
