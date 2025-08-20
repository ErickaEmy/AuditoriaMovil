package androidx.compose.foundation.text;

import androidx.compose.foundation.FocusableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.text.selection.MouseSelectionObserver;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusChangedModifierKt;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusRequesterModifierKt;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: TextFieldGestureModifiers.kt */
/* loaded from: classes.dex */
public abstract class TextFieldGestureModifiersKt {
    public static final Modifier longPressDragGestureFilter(Modifier modifier, TextDragObserver observer, boolean z) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(observer, "observer");
        return z ? SuspendingPointerInputFilterKt.pointerInput(modifier, observer, new TextFieldGestureModifiersKt$longPressDragGestureFilter$1(observer, null)) : modifier;
    }

    public static final Modifier textFieldFocusModifier(Modifier modifier, boolean z, FocusRequester focusRequester, MutableInteractionSource mutableInteractionSource, Function1 onFocusChanged) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(focusRequester, "focusRequester");
        Intrinsics.checkNotNullParameter(onFocusChanged, "onFocusChanged");
        return FocusableKt.focusable(FocusChangedModifierKt.onFocusChanged(FocusRequesterModifierKt.focusRequester(modifier, focusRequester), onFocusChanged), z, mutableInteractionSource);
    }

    public static final Modifier mouseDragGestureDetector(Modifier modifier, MouseSelectionObserver observer, boolean z) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(observer, "observer");
        return z ? SuspendingPointerInputFilterKt.pointerInput(Modifier.Companion, observer, new TextFieldGestureModifiersKt$mouseDragGestureDetector$1(observer, null)) : modifier;
    }
}
