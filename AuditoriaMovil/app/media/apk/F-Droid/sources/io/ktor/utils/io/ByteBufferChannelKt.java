package io.ktor.utils.io;
/* compiled from: ByteBufferChannel.kt */
/* loaded from: classes.dex */
public abstract class ByteBufferChannelKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Void rethrowClosed(Throwable th) {
        Throwable th2;
        try {
            th2 = ExceptionUtilsJvmKt.tryCopyException(th, th);
        } catch (Throwable unused) {
            th2 = null;
        }
        if (th2 == null) {
            throw th;
        }
        throw th2;
    }
}
