package androidx.compose.ui.input.pointer;

import androidx.compose.ui.Modifier;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SuspendingPointerInputFilter.kt */
/* loaded from: classes.dex */
public abstract class SuspendingPointerInputFilterKt {
    private static final PointerEvent EmptyPointerEvent = new PointerEvent(CollectionsKt.emptyList());

    public static final Modifier pointerInput(Modifier modifier, Object obj, Function2 block) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        return modifier.then(new SuspendPointerInputElement(obj, null, null, block, 6, null));
    }

    public static final SuspendingPointerInputModifierNode SuspendingPointerInputModifierNode(Function2 pointerInputHandler) {
        Intrinsics.checkNotNullParameter(pointerInputHandler, "pointerInputHandler");
        return new SuspendingPointerInputModifierNodeImpl(pointerInputHandler);
    }
}
