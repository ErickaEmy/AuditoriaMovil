package io.ktor.utils.io.jvm.javaio;

import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.WriterScope;
import io.ktor.utils.io.pool.ObjectPool;
import java.io.InputStream;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
/* compiled from: Reading.kt */
/* loaded from: classes.dex */
final class ReadingKt$toByteReadChannel$2 extends SuspendLambda implements Function2 {
    final /* synthetic */ ObjectPool $pool;
    final /* synthetic */ InputStream $this_toByteReadChannel;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReadingKt$toByteReadChannel$2(ObjectPool objectPool, InputStream inputStream, Continuation continuation) {
        super(2, continuation);
        this.$pool = objectPool;
        this.$this_toByteReadChannel = inputStream;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        ReadingKt$toByteReadChannel$2 readingKt$toByteReadChannel$2 = new ReadingKt$toByteReadChannel$2(this.$pool, this.$this_toByteReadChannel, continuation);
        readingKt$toByteReadChannel$2.L$0 = obj;
        return readingKt$toByteReadChannel$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(WriterScope writerScope, Continuation continuation) {
        return ((ReadingKt$toByteReadChannel$2) create(writerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        byte[] bArr;
        WriterScope writerScope;
        Throwable th;
        ReadingKt$toByteReadChannel$2 readingKt$toByteReadChannel$2;
        InputStream inputStream;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            bArr = (byte[]) this.$pool.borrow();
            writerScope = (WriterScope) this.L$0;
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            bArr = (byte[]) this.L$1;
            writerScope = (WriterScope) this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th2) {
                th = th2;
                readingKt$toByteReadChannel$2 = this;
                try {
                    writerScope.getChannel().close(th);
                    readingKt$toByteReadChannel$2.$pool.recycle(bArr);
                    inputStream = readingKt$toByteReadChannel$2.$this_toByteReadChannel;
                    inputStream.close();
                    return Unit.INSTANCE;
                } catch (Throwable th3) {
                    readingKt$toByteReadChannel$2.$pool.recycle(bArr);
                    readingKt$toByteReadChannel$2.$this_toByteReadChannel.close();
                    throw th3;
                }
            }
        }
        while (true) {
            try {
                int read = this.$this_toByteReadChannel.read(bArr, 0, bArr.length);
                if (read < 0) {
                    this.$pool.recycle(bArr);
                    inputStream = this.$this_toByteReadChannel;
                    break;
                } else if (read != 0) {
                    ByteWriteChannel channel = writerScope.getChannel();
                    this.L$0 = writerScope;
                    this.L$1 = bArr;
                    this.label = 1;
                    if (channel.writeFully(bArr, 0, read, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } catch (Throwable th4) {
                readingKt$toByteReadChannel$2 = this;
                th = th4;
                writerScope.getChannel().close(th);
                readingKt$toByteReadChannel$2.$pool.recycle(bArr);
                inputStream = readingKt$toByteReadChannel$2.$this_toByteReadChannel;
                inputStream.close();
                return Unit.INSTANCE;
            }
        }
    }
}
