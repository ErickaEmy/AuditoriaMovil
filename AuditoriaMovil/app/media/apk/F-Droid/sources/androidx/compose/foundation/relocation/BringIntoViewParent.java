package androidx.compose.foundation.relocation;

import androidx.compose.ui.layout.LayoutCoordinates;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
/* compiled from: BringIntoView.kt */
/* loaded from: classes.dex */
public interface BringIntoViewParent {
    Object bringChildIntoView(LayoutCoordinates layoutCoordinates, Function0 function0, Continuation continuation);
}
