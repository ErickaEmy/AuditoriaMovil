package kotlin;

import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DeepRecursive.kt */
/* loaded from: classes.dex */
public final class DeepRecursiveFunction {
    private final Function3 block;

    public final Function3 getBlock$kotlin_stdlib() {
        return this.block;
    }

    public DeepRecursiveFunction(Function3 block) {
        Intrinsics.checkNotNullParameter(block, "block");
        this.block = block;
    }
}
