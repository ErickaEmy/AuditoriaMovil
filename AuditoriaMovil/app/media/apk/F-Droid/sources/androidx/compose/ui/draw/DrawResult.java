package androidx.compose.ui.draw;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DrawModifier.kt */
/* loaded from: classes.dex */
public final class DrawResult {
    private Function1 block;

    public final Function1 getBlock$ui_release() {
        return this.block;
    }

    public DrawResult(Function1 block) {
        Intrinsics.checkNotNullParameter(block, "block");
        this.block = block;
    }
}
