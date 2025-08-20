package androidx.compose.ui.semantics;

import ch.qos.logback.core.CoreConstants;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SemanticsProperties.kt */
/* loaded from: classes.dex */
public final class ScrollAxisRange {
    private final Function0 maxValue;
    private final boolean reverseScrolling;
    private final Function0 value;

    public final Function0 getMaxValue() {
        return this.maxValue;
    }

    public final boolean getReverseScrolling() {
        return this.reverseScrolling;
    }

    public final Function0 getValue() {
        return this.value;
    }

    public ScrollAxisRange(Function0 value, Function0 maxValue, boolean z) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(maxValue, "maxValue");
        this.value = value;
        this.maxValue = maxValue;
        this.reverseScrolling = z;
    }

    public String toString() {
        return "ScrollAxisRange(value=" + ((Number) this.value.invoke()).floatValue() + ", maxValue=" + ((Number) this.maxValue.invoke()).floatValue() + ", reverseScrolling=" + this.reverseScrolling + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }
}
