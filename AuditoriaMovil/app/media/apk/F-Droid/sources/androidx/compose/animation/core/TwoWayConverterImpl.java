package androidx.compose.animation.core;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: VectorConverters.kt */
/* loaded from: classes.dex */
final class TwoWayConverterImpl implements TwoWayConverter {
    private final Function1 convertFromVector;
    private final Function1 convertToVector;

    @Override // androidx.compose.animation.core.TwoWayConverter
    public Function1 getConvertFromVector() {
        return this.convertFromVector;
    }

    @Override // androidx.compose.animation.core.TwoWayConverter
    public Function1 getConvertToVector() {
        return this.convertToVector;
    }

    public TwoWayConverterImpl(Function1 convertToVector, Function1 convertFromVector) {
        Intrinsics.checkNotNullParameter(convertToVector, "convertToVector");
        Intrinsics.checkNotNullParameter(convertFromVector, "convertFromVector");
        this.convertToVector = convertToVector;
        this.convertFromVector = convertFromVector;
    }
}
