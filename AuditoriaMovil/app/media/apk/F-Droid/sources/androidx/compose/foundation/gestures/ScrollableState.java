package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
/* compiled from: ScrollableState.kt */
/* loaded from: classes.dex */
public interface ScrollableState {
    float dispatchRawDelta(float f);

    boolean getCanScrollBackward();

    boolean getCanScrollForward();

    boolean isScrollInProgress();

    Object scroll(MutatePriority mutatePriority, Function2 function2, Continuation continuation);

    /* compiled from: ScrollableState.kt */
    /* renamed from: androidx.compose.foundation.gestures.ScrollableState$-CC  reason: invalid class name */
    /* loaded from: classes.dex */
    public abstract /* synthetic */ class CC {
        public static boolean $default$getCanScrollBackward(ScrollableState scrollableState) {
            return true;
        }

        public static boolean $default$getCanScrollForward(ScrollableState scrollableState) {
            return true;
        }

        public static /* synthetic */ Object scroll$default(ScrollableState scrollableState, MutatePriority mutatePriority, Function2 function2, Continuation continuation, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    mutatePriority = MutatePriority.Default;
                }
                return scrollableState.scroll(mutatePriority, function2, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: scroll");
        }
    }
}
