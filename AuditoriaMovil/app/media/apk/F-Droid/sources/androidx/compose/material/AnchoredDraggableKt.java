package androidx.compose.material;

import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.Modifier;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: AnchoredDraggable.kt */
/* loaded from: classes.dex */
public abstract class AnchoredDraggableKt {
    public static /* synthetic */ Modifier anchoredDraggable$default(Modifier modifier, AnchoredDraggableState anchoredDraggableState, Orientation orientation, boolean z, boolean z2, MutableInteractionSource mutableInteractionSource, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        boolean z3 = z;
        if ((i & 8) != 0) {
            z2 = false;
        }
        boolean z4 = z2;
        if ((i & 16) != 0) {
            mutableInteractionSource = null;
        }
        return anchoredDraggable(modifier, anchoredDraggableState, orientation, z3, z4, mutableInteractionSource);
    }

    public static final Modifier anchoredDraggable(Modifier modifier, AnchoredDraggableState state, Orientation orientation, boolean z, boolean z2, MutableInteractionSource mutableInteractionSource) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        return DraggableKt.draggable$default(modifier, state.getDraggableState$material_release(), orientation, z, mutableInteractionSource, state.isAnimationRunning(), null, new AnchoredDraggableKt$anchoredDraggable$1(state, null), z2, 32, null);
    }

    public static /* synthetic */ Object animateTo$default(AnchoredDraggableState anchoredDraggableState, Object obj, float f, Continuation continuation, int i, Object obj2) {
        if ((i & 2) != 0) {
            f = anchoredDraggableState.getLastVelocity();
        }
        return animateTo(anchoredDraggableState, obj, f, continuation);
    }

    public static final Object animateTo(AnchoredDraggableState anchoredDraggableState, Object obj, float f, Continuation continuation) {
        Object coroutine_suspended;
        Object anchoredDrag$default = AnchoredDraggableState.anchoredDrag$default(anchoredDraggableState, obj, null, new AnchoredDraggableKt$animateTo$2(obj, anchoredDraggableState, f, null), continuation, 2, null);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return anchoredDrag$default == coroutine_suspended ? anchoredDrag$default : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object closestAnchor(Map map, float f, boolean z) {
        if (!(!map.isEmpty())) {
            throw new IllegalArgumentException("The anchors were empty when trying to find the closest anchor".toString());
        }
        Iterator it = map.entrySet().iterator();
        if (it.hasNext()) {
            Object next = it.next();
            if (!it.hasNext()) {
                return ((Map.Entry) next).getKey();
            }
            float floatValue = ((Number) ((Map.Entry) next).getValue()).floatValue();
            float f2 = z ? floatValue - f : f - floatValue;
            if (f2 < 0.0f) {
                f2 = Float.POSITIVE_INFINITY;
            }
            do {
                Object next2 = it.next();
                float floatValue2 = ((Number) ((Map.Entry) next2).getValue()).floatValue();
                float f3 = z ? floatValue2 - f : f - floatValue2;
                if (f3 < 0.0f) {
                    f3 = Float.POSITIVE_INFINITY;
                }
                if (Float.compare(f2, f3) > 0) {
                    next = next2;
                    f2 = f3;
                }
            } while (it.hasNext());
            return ((Map.Entry) next).getKey();
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Float minOrNull(Map map) {
        Iterator it = map.entrySet().iterator();
        if (it.hasNext()) {
            float floatValue = ((Number) ((Map.Entry) it.next()).getValue()).floatValue();
            while (it.hasNext()) {
                floatValue = Math.min(floatValue, ((Number) ((Map.Entry) it.next()).getValue()).floatValue());
            }
            return Float.valueOf(floatValue);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Float maxOrNull(Map map) {
        Iterator it = map.entrySet().iterator();
        if (it.hasNext()) {
            float floatValue = ((Number) ((Map.Entry) it.next()).getValue()).floatValue();
            while (it.hasNext()) {
                floatValue = Math.max(floatValue, ((Number) ((Map.Entry) it.next()).getValue()).floatValue());
            }
            return Float.valueOf(floatValue);
        }
        return null;
    }
}
