package io.ktor.utils.io;

import io.ktor.utils.io.core.Buffer;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
/* compiled from: ByteWriteChannel.kt */
/* loaded from: classes.dex */
public interface ByteWriteChannel {
    boolean close(Throwable th);

    void flush();

    boolean getAutoFlush();

    Object write(int i, Function1 function1, Continuation continuation);

    Object writeFully(Buffer buffer, Continuation continuation);

    Object writeFully(byte[] bArr, int i, int i2, Continuation continuation);

    /* compiled from: ByteWriteChannel.kt */
    /* loaded from: classes.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ Object write$default(ByteWriteChannel byteWriteChannel, int i, Function1 function1, Continuation continuation, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 1) != 0) {
                    i = 1;
                }
                return byteWriteChannel.write(i, function1, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: write");
        }
    }
}
