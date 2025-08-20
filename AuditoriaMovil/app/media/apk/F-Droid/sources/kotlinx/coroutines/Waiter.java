package kotlinx.coroutines;

import kotlinx.coroutines.internal.Segment;
/* compiled from: Waiter.kt */
/* loaded from: classes2.dex */
public interface Waiter {
    void invokeOnCancellation(Segment segment, int i);
}
