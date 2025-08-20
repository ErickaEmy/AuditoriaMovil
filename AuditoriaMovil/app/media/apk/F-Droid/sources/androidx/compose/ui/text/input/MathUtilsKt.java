package androidx.compose.ui.text.input;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: MathUtils.kt */
/* loaded from: classes.dex */
public abstract class MathUtilsKt {
    public static final int subtractExactOrElse(int i, int i2, Function0 defaultValue) {
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        int i3 = i - i2;
        return ((i ^ i3) & (i2 ^ i)) < 0 ? ((Number) defaultValue.invoke()).intValue() : i3;
    }
}
