package org.fdroid.download;

import io.ktor.client.engine.HttpClientEngineFactory;
import kotlin.Metadata;
import okhttp3.Dns;
/* compiled from: HttpManager.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\u0006\u0012\u0002\b\u00030\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0000\u001a\u001a\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086@¢\u0006\u0002\u0010\t\u001a\u001a\u0010\n\u001a\u00020\u000b*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086@¢\u0006\u0002\u0010\t¨\u0006\f"}, d2 = {"getHttpClientEngineFactory", "Lio/ktor/client/engine/HttpClientEngineFactory;", "customDns", "Lokhttp3/Dns;", "getDigestInputStream", "Lorg/fdroid/fdroid/DigestInputStream;", "Lorg/fdroid/download/HttpManager;", "request", "Lorg/fdroid/download/DownloadRequest;", "(Lorg/fdroid/download/HttpManager;Lorg/fdroid/download/DownloadRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getInputStream", "Ljava/io/InputStream;", "download_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class HttpManagerKt {
    public static final HttpClientEngineFactory getHttpClientEngineFactory(Dns dns) {
        return new HttpManagerKt$getHttpClientEngineFactory$1(dns);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object getInputStream(org.fdroid.download.HttpManager r8, org.fdroid.download.DownloadRequest r9, kotlin.coroutines.Continuation r10) {
        /*
            boolean r0 = r10 instanceof org.fdroid.download.HttpManagerKt$getInputStream$1
            if (r0 == 0) goto L14
            r0 = r10
            org.fdroid.download.HttpManagerKt$getInputStream$1 r0 = (org.fdroid.download.HttpManagerKt$getInputStream$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.label = r1
        L12:
            r4 = r0
            goto L1a
        L14:
            org.fdroid.download.HttpManagerKt$getInputStream$1 r0 = new org.fdroid.download.HttpManagerKt$getInputStream$1
            r0.<init>(r10)
            goto L12
        L1a:
            java.lang.Object r10 = r4.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.label
            r7 = 1
            if (r1 == 0) goto L33
            if (r1 != r7) goto L2b
            kotlin.ResultKt.throwOnFailure(r10)
            goto L44
        L2b:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L33:
            kotlin.ResultKt.throwOnFailure(r10)
            r3 = 0
            r5 = 2
            r6 = 0
            r4.label = r7
            r1 = r8
            r2 = r9
            java.lang.Object r10 = org.fdroid.download.HttpManager.getChannel$download_release$default(r1, r2, r3, r4, r5, r6)
            if (r10 != r0) goto L44
            return r0
        L44:
            io.ktor.utils.io.ByteReadChannel r10 = (io.ktor.utils.io.ByteReadChannel) r10
            r8 = 0
            java.io.InputStream r8 = io.ktor.utils.io.jvm.javaio.BlockingKt.toInputStream$default(r10, r8, r7, r8)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: org.fdroid.download.HttpManagerKt.getInputStream(org.fdroid.download.HttpManager, org.fdroid.download.DownloadRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0037  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object getDigestInputStream(org.fdroid.download.HttpManager r9, org.fdroid.download.DownloadRequest r10, kotlin.coroutines.Continuation r11) {
        /*
            boolean r0 = r11 instanceof org.fdroid.download.HttpManagerKt$getDigestInputStream$1
            if (r0 == 0) goto L14
            r0 = r11
            org.fdroid.download.HttpManagerKt$getDigestInputStream$1 r0 = (org.fdroid.download.HttpManagerKt$getDigestInputStream$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.label = r1
        L12:
            r4 = r0
            goto L1a
        L14:
            org.fdroid.download.HttpManagerKt$getDigestInputStream$1 r0 = new org.fdroid.download.HttpManagerKt$getDigestInputStream$1
            r0.<init>(r11)
            goto L12
        L1a:
            java.lang.Object r11 = r4.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.label
            r7 = 1
            if (r1 == 0) goto L37
            if (r1 != r7) goto L2f
            java.lang.Object r9 = r4.L$0
            java.security.MessageDigest r9 = (java.security.MessageDigest) r9
            kotlin.ResultKt.throwOnFailure(r11)
            goto L53
        L2f:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L37:
            kotlin.ResultKt.throwOnFailure(r11)
            java.lang.String r11 = "SHA-256"
            java.security.MessageDigest r11 = java.security.MessageDigest.getInstance(r11)
            r3 = 0
            r5 = 2
            r6 = 0
            r4.L$0 = r11
            r4.label = r7
            r1 = r9
            r2 = r10
            java.lang.Object r9 = org.fdroid.download.HttpManager.getChannel$download_release$default(r1, r2, r3, r4, r5, r6)
            if (r9 != r0) goto L50
            return r0
        L50:
            r8 = r11
            r11 = r9
            r9 = r8
        L53:
            io.ktor.utils.io.ByteReadChannel r11 = (io.ktor.utils.io.ByteReadChannel) r11
            r10 = 0
            java.io.InputStream r10 = io.ktor.utils.io.jvm.javaio.BlockingKt.toInputStream$default(r11, r10, r7, r10)
            org.fdroid.fdroid.DigestInputStream r11 = new org.fdroid.fdroid.DigestInputStream
            kotlin.jvm.internal.Intrinsics.checkNotNull(r9)
            r11.<init>(r10, r9)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: org.fdroid.download.HttpManagerKt.getDigestInputStream(org.fdroid.download.HttpManager, org.fdroid.download.DownloadRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
