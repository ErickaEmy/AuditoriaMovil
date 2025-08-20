package io.ktor.client.engine.okhttp;

import io.ktor.client.request.HttpRequestData;
import io.ktor.utils.io.WriterScope;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import okio.BufferedSource;
/* compiled from: OkHttpEngine.kt */
/* loaded from: classes.dex */
final class OkHttpEngineKt$toChannel$1 extends SuspendLambda implements Function2 {
    final /* synthetic */ CoroutineContext $context;
    final /* synthetic */ HttpRequestData $requestData;
    final /* synthetic */ BufferedSource $this_toChannel;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OkHttpEngineKt$toChannel$1(BufferedSource bufferedSource, CoroutineContext coroutineContext, HttpRequestData httpRequestData, Continuation continuation) {
        super(2, continuation);
        this.$this_toChannel = bufferedSource;
        this.$context = coroutineContext;
        this.$requestData = httpRequestData;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        OkHttpEngineKt$toChannel$1 okHttpEngineKt$toChannel$1 = new OkHttpEngineKt$toChannel$1(this.$this_toChannel, this.$context, this.$requestData, continuation);
        okHttpEngineKt$toChannel$1.L$0 = obj;
        return okHttpEngineKt$toChannel$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(WriterScope writerScope, Continuation continuation) {
        return ((OkHttpEngineKt$toChannel$1) create(writerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0054 A[Catch: all -> 0x002b, TryCatch #2 {all -> 0x002b, blocks: (B:6:0x0026, B:24:0x0087, B:14:0x004e, B:16:0x0054, B:18:0x005a, B:20:0x005e, B:25:0x008f, B:13:0x0044), top: B:45:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0093 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r8v5, types: [java.io.Closeable] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0085 -> B:24:0x0087). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r20) {
        /*
            r19 = this;
            r1 = r19
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r1.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L37
            if (r2 != r4) goto L2f
            java.lang.Object r2 = r1.L$5
            kotlin.jvm.internal.Ref$IntRef r2 = (kotlin.jvm.internal.Ref$IntRef) r2
            java.lang.Object r5 = r1.L$4
            okio.BufferedSource r5 = (okio.BufferedSource) r5
            java.lang.Object r6 = r1.L$3
            io.ktor.client.request.HttpRequestData r6 = (io.ktor.client.request.HttpRequestData) r6
            java.lang.Object r7 = r1.L$2
            kotlin.coroutines.CoroutineContext r7 = (kotlin.coroutines.CoroutineContext) r7
            java.lang.Object r8 = r1.L$1
            java.io.Closeable r8 = (java.io.Closeable) r8
            java.lang.Object r9 = r1.L$0
            io.ktor.utils.io.WriterScope r9 = (io.ktor.utils.io.WriterScope) r9
            kotlin.ResultKt.throwOnFailure(r20)     // Catch: java.lang.Throwable -> L2b
            r15 = r1
            goto L87
        L2b:
            r0 = move-exception
            r2 = r0
            goto L9a
        L2f:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L37:
            kotlin.ResultKt.throwOnFailure(r20)
            java.lang.Object r2 = r1.L$0
            io.ktor.utils.io.WriterScope r2 = (io.ktor.utils.io.WriterScope) r2
            okio.BufferedSource r8 = r1.$this_toChannel
            kotlin.coroutines.CoroutineContext r5 = r1.$context
            io.ktor.client.request.HttpRequestData r6 = r1.$requestData
            kotlin.jvm.internal.Ref$IntRef r7 = new kotlin.jvm.internal.Ref$IntRef     // Catch: java.lang.Throwable -> L2b
            r7.<init>()     // Catch: java.lang.Throwable -> L2b
            r15 = r1
            r9 = r2
            r2 = r7
            r7 = r5
            r5 = r8
        L4e:
            boolean r10 = r5.isOpen()     // Catch: java.lang.Throwable -> L2b
            if (r10 == 0) goto L8f
            boolean r10 = kotlinx.coroutines.JobKt.isActive(r7)     // Catch: java.lang.Throwable -> L2b
            if (r10 == 0) goto L8f
            int r10 = r2.element     // Catch: java.lang.Throwable -> L2b
            if (r10 < 0) goto L8f
            io.ktor.utils.io.ByteWriteChannel r10 = r9.getChannel()     // Catch: java.lang.Throwable -> L2b
            r11 = 0
            io.ktor.client.engine.okhttp.OkHttpEngineKt$toChannel$1$1$1 r12 = new io.ktor.client.engine.okhttp.OkHttpEngineKt$toChannel$1$1$1     // Catch: java.lang.Throwable -> L2b
            r12.<init>()     // Catch: java.lang.Throwable -> L2b
            r14 = 1
            r16 = 0
            r15.L$0 = r9     // Catch: java.lang.Throwable -> L2b
            r15.L$1 = r8     // Catch: java.lang.Throwable -> L2b
            r15.L$2 = r7     // Catch: java.lang.Throwable -> L2b
            r15.L$3 = r6     // Catch: java.lang.Throwable -> L2b
            r15.L$4 = r5     // Catch: java.lang.Throwable -> L2b
            r15.L$5 = r2     // Catch: java.lang.Throwable -> L2b
            r15.label = r4     // Catch: java.lang.Throwable -> L2b
            r13 = r15
            r17 = r15
            r15 = r16
            java.lang.Object r10 = io.ktor.utils.io.ByteWriteChannel.DefaultImpls.write$default(r10, r11, r12, r13, r14, r15)     // Catch: java.lang.Throwable -> L2b
            if (r10 != r0) goto L85
            return r0
        L85:
            r15 = r17
        L87:
            io.ktor.utils.io.ByteWriteChannel r10 = r9.getChannel()     // Catch: java.lang.Throwable -> L2b
            r10.flush()     // Catch: java.lang.Throwable -> L2b
            goto L4e
        L8f:
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L2b
            if (r8 == 0) goto Laa
            r8.close()     // Catch: java.lang.Throwable -> L97
            goto Laa
        L97:
            r0 = move-exception
            r3 = r0
            goto Laa
        L9a:
            if (r8 == 0) goto La5
            r8.close()     // Catch: java.lang.Throwable -> La0
            goto La5
        La0:
            r0 = move-exception
            r4 = r0
            kotlin.ExceptionsKt.addSuppressed(r2, r4)
        La5:
            r18 = r3
            r3 = r2
            r2 = r18
        Laa:
            if (r3 != 0) goto Lb2
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        Lb2:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.engine.okhttp.OkHttpEngineKt$toChannel$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
