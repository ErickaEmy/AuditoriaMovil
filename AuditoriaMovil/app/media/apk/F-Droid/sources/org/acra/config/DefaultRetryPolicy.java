package org.acra.config;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DefaultRetryPolicy.kt */
/* loaded from: classes2.dex */
public final class DefaultRetryPolicy implements RetryPolicy {
    @Override // org.acra.config.RetryPolicy
    public boolean shouldRetrySend(List senders, List failedSenders) {
        Intrinsics.checkNotNullParameter(senders, "senders");
        Intrinsics.checkNotNullParameter(failedSenders, "failedSenders");
        return senders.size() == failedSenders.size() && (senders.isEmpty() ^ true);
    }
}
