package io.ktor.utils.io;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
/* compiled from: ByteReadChannelJVM.kt */
/* loaded from: classes.dex */
public abstract class ByteReadChannelJVMKt {
    public static final Object copyTo(ByteReadChannel byteReadChannel, ByteWriteChannel byteWriteChannel, long j, Continuation continuation) {
        if (byteReadChannel != byteWriteChannel) {
            if (j == 0) {
                return Boxing.boxLong(0L);
            }
            if ((byteReadChannel instanceof ByteBufferChannel) && (byteWriteChannel instanceof ByteBufferChannel)) {
                return ((ByteBufferChannel) byteWriteChannel).copyDirect$ktor_io((ByteBufferChannel) byteReadChannel, j, null, continuation);
            }
            return copyToImpl(byteReadChannel, byteWriteChannel, j, continuation);
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0097 A[Catch: all -> 0x00ff, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x00ff, blocks: (B:37:0x00f5, B:39:0x00fb, B:25:0x0097), top: B:56:0x00f5 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00d0 A[Catch: all -> 0x004f, TRY_LEAVE, TryCatch #2 {all -> 0x004f, blocks: (B:13:0x0040, B:29:0x00c7, B:31:0x00d0, B:46:0x010f, B:20:0x006e), top: B:58:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00f5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x00e7 -> B:35:0x00f1). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object copyToImpl(io.ktor.utils.io.ByteReadChannel r21, io.ktor.utils.io.ByteWriteChannel r22, long r23, kotlin.coroutines.Continuation r25) {
        /*
            Method dump skipped, instructions count: 300
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteReadChannelJVMKt.copyToImpl(io.ktor.utils.io.ByteReadChannel, io.ktor.utils.io.ByteWriteChannel, long, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
