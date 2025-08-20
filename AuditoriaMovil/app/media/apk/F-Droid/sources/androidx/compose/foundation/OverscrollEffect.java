package androidx.compose.foundation;

import androidx.compose.ui.Modifier;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
/* compiled from: Overscroll.kt */
/* loaded from: classes.dex */
public interface OverscrollEffect {
    /* renamed from: applyToFling-BMRW4eQ */
    Object mo71applyToFlingBMRW4eQ(long j, Function2 function2, Continuation continuation);

    /* renamed from: applyToScroll-Rhakbz0 */
    long mo72applyToScrollRhakbz0(long j, int i, Function1 function1);

    Modifier getEffectModifier();

    boolean isInProgress();
}
