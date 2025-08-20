package org.fdroid.index;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: JarIndexVerifier.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u000f\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB\u0019\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Lorg/fdroid/index/SigningException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "msg", "", "(Ljava/lang/String;)V", "e", "", "(Ljava/lang/Throwable;)V", "cause", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "index_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SigningException extends Exception {
    public SigningException(String str, Throwable th) {
        super(str, th);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SigningException(String msg) {
        this(msg, null);
        Intrinsics.checkNotNullParameter(msg, "msg");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SigningException(Throwable e) {
        this(null, e);
        Intrinsics.checkNotNullParameter(e, "e");
    }
}
