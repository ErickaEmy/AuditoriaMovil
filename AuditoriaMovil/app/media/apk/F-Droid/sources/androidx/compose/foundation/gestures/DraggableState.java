package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
/* compiled from: Draggable.kt */
/* loaded from: classes.dex */
public interface DraggableState {
    Object drag(MutatePriority mutatePriority, Function2 function2, Continuation continuation);
}
