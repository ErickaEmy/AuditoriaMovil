package androidx.compose.foundation.gestures;

import androidx.compose.ui.unit.Density;
import kotlin.coroutines.Continuation;
/* compiled from: TapGestureDetector.kt */
/* loaded from: classes.dex */
public interface PressGestureScope extends Density {
    Object tryAwaitRelease(Continuation continuation);
}
