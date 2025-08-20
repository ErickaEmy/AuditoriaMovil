package androidx.compose.ui.input.pointer;

import androidx.compose.ui.unit.Density;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
/* compiled from: SuspendingPointerInputFilter.kt */
/* loaded from: classes.dex */
public interface PointerInputScope extends Density {
    Object awaitPointerEventScope(Function2 function2, Continuation continuation);

    /* renamed from: getSize-YbymL2g  reason: not valid java name */
    long mo1207getSizeYbymL2g();
}
