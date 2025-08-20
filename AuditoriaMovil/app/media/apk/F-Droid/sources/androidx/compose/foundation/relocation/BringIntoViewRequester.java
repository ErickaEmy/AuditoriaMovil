package androidx.compose.foundation.relocation;

import androidx.compose.ui.geometry.Rect;
import kotlin.coroutines.Continuation;
/* compiled from: BringIntoViewRequester.kt */
/* loaded from: classes.dex */
public interface BringIntoViewRequester {
    Object bringIntoView(Rect rect, Continuation continuation);

    /* compiled from: BringIntoViewRequester.kt */
    /* renamed from: androidx.compose.foundation.relocation.BringIntoViewRequester$-CC  reason: invalid class name */
    /* loaded from: classes.dex */
    public abstract /* synthetic */ class CC {
        public static /* synthetic */ Object bringIntoView$default(BringIntoViewRequester bringIntoViewRequester, Rect rect, Continuation continuation, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    rect = null;
                }
                return bringIntoViewRequester.bringIntoView(rect, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: bringIntoView");
        }
    }
}
