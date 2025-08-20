package org.fdroid.index.v1;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: IndexV1StreamProcessor.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\b¨\u0006\t"}, d2 = {"Lorg/fdroid/index/v1/OldIndexException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "isSameTimestamp", "", "msg", "", "(ZLjava/lang/String;)V", "()Z", "index_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class OldIndexException extends Exception {
    private final boolean isSameTimestamp;

    public final boolean isSameTimestamp() {
        return this.isSameTimestamp;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OldIndexException(boolean z, String msg) {
        super(msg);
        Intrinsics.checkNotNullParameter(msg, "msg");
        this.isSameTimestamp = z;
    }
}
