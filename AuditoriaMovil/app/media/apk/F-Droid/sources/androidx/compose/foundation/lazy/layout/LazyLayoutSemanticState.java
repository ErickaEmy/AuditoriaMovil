package androidx.compose.foundation.lazy.layout;

import androidx.compose.ui.semantics.CollectionInfo;
import kotlin.coroutines.Continuation;
/* compiled from: LazyLayoutSemantics.kt */
/* loaded from: classes.dex */
public interface LazyLayoutSemanticState {
    Object animateScrollBy(float f, Continuation continuation);

    CollectionInfo collectionInfo();

    boolean getCanScrollForward();

    float getCurrentPosition();

    Object scrollToItem(int i, Continuation continuation);
}
