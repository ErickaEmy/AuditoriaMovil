package org.fdroid.download;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mu.KLogger;
import mu.KotlinLogging;
import org.fdroid.IndexFile;
import org.fdroid.fdroid.HashUtilsKt;
import org.fdroid.fdroid.ProgressListener;
/* compiled from: Downloader.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000 52\u00020\u0001:\u00015B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0015\u001a\u00020\u0016J\b\u0010\u0017\u001a\u00020\u0016H&J\u0018\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u0016H&J\u0016\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u0010H\u0084@¢\u0006\u0002\u0010 J\u0010\u0010!\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u0010H\u0004J\u001e\u0010\"\u001a\u00020\u00162\u0006\u0010#\u001a\u00020\u00102\u0006\u0010$\u001a\u00020%H\u0094@¢\u0006\u0002\u0010&J\u0010\u0010'\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020\u0010H$J\b\u0010(\u001a\u00020\u0010H'J \u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020*2\u0006\u0010-\u001a\u00020*H\u0002J\u000e\u0010.\u001a\u00020\u00162\u0006\u0010/\u001a\u00020\u0014J\b\u00100\u001a\u00020\u0016H\u0002J\b\u00101\u001a\u00020*H$J\u0014\u00102\u001a\u00020\u0016*\u00020\u00052\u0006\u00103\u001a\u000204H\u0002R&\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0004\u001a\u00020\u00058\u0004X\u0085\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lorg/fdroid/download/Downloader;", "", "indexFile", "Lorg/fdroid/IndexFile;", "outputFile", "Ljava/io/File;", "(Lorg/fdroid/IndexFile;Ljava/io/File;)V", "cacheTag", "", "getCacheTag$annotations", "()V", "getCacheTag", "()Ljava/lang/String;", "setCacheTag", "(Ljava/lang/String;)V", "cancelled", "", "getIndexFile", "()Lorg/fdroid/IndexFile;", "progressListener", "Lorg/fdroid/fdroid/ProgressListener;", "cancelDownload", "", "close", "copyInputToOutputStream", "input", "Ljava/io/InputStream;", "output", "Ljava/io/OutputStream;", "download", "downloadFromBytesReceiver", "isResume", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "downloadFromStream", "getBytes", "resumable", "receiver", "Lorg/fdroid/download/BytesReceiver;", "(ZLorg/fdroid/download/BytesReceiver;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getInputStream", "hasChanged", "reportProgress", "", "lastTimeReported", "bytesRead", "bytesTotal", "setListener", "listener", "throwExceptionIfInterrupted", "totalDownloadSize", "initDigest", "messageDigest", "Ljava/security/MessageDigest;", "Companion", "download_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class Downloader {
    public static final Companion Companion = new Companion(null);
    private static final KLogger log = KotlinLogging.INSTANCE.logger(new Function0() { // from class: org.fdroid.download.Downloader$Companion$log$1
        /* renamed from: invoke  reason: collision with other method in class */
        public final void m2373invoke() {
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            m2373invoke();
            return Unit.INSTANCE;
        }
    });
    private String cacheTag;
    private volatile boolean cancelled;
    private final IndexFile indexFile;
    protected final File outputFile;
    private volatile ProgressListener progressListener;

    /* compiled from: Downloader.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lorg/fdroid/download/Downloader$Companion;", "", "()V", "log", "Lmu/KLogger;", "download_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static /* synthetic */ void getCacheTag$annotations() {
    }

    public final void cancelDownload() {
        this.cancelled = true;
    }

    public abstract void close();

    public abstract void download() throws IOException, InterruptedException, NotFoundException;

    protected Object getBytes(boolean z, BytesReceiver bytesReceiver, Continuation continuation) {
        return getBytes$suspendImpl(this, z, bytesReceiver, continuation);
    }

    public final String getCacheTag() {
        return this.cacheTag;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final IndexFile getIndexFile() {
        return this.indexFile;
    }

    protected abstract InputStream getInputStream(boolean z) throws IOException, NotFoundException;

    public abstract boolean hasChanged();

    public final void setCacheTag(String str) {
        this.cacheTag = str;
    }

    public final void setListener(ProgressListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.progressListener = listener;
    }

    protected abstract long totalDownloadSize();

    public Downloader(IndexFile indexFile, File outputFile) {
        Intrinsics.checkNotNullParameter(indexFile, "indexFile");
        Intrinsics.checkNotNullParameter(outputFile, "outputFile");
        this.indexFile = indexFile;
        this.outputFile = outputFile;
    }

    static /* synthetic */ Object getBytes$suspendImpl(Downloader downloader, boolean z, BytesReceiver bytesReceiver, Continuation continuation) {
        throw new NotImplementedError(null, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void downloadFromStream(boolean z) throws IOException, InterruptedException {
        log.debug(new Function0() { // from class: org.fdroid.download.Downloader$downloadFromStream$1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return "Downloading from stream";
            }
        });
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(this.outputFile, z);
            InputStream inputStream = getInputStream(z);
            try {
                throwExceptionIfInterrupted();
                copyInputToOutputStream(inputStream, fileOutputStream);
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(inputStream, null);
                CloseableKt.closeFinally(fileOutputStream, null);
                throwExceptionIfInterrupted();
            } finally {
            }
        } finally {
            close();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0054  */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.io.Closeable] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object downloadFromBytesReceiver(boolean r20, kotlin.coroutines.Continuation r21) throws java.lang.InterruptedException, java.io.IOException, org.fdroid.download.NoResumeException, org.fdroid.download.NotFoundException {
        /*
            Method dump skipped, instructions count: 265
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.fdroid.download.Downloader.downloadFromBytesReceiver(boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void copyInputToOutputStream(InputStream inputStream, OutputStream outputStream) throws IOException, InterruptedException {
        MessageDigest messageDigest = this.indexFile.getSha256() == null ? null : MessageDigest.getInstance("SHA-256");
        try {
            long length = this.outputFile.length();
            if (length > 0 && messageDigest != null) {
                initDigest(this.outputFile, messageDigest);
            }
            long j = totalDownloadSize();
            byte[] bArr = new byte[8192];
            int read = inputStream.read(bArr);
            long j2 = 0;
            long j3 = length;
            while (read >= 0) {
                throwExceptionIfInterrupted();
                try {
                    outputStream.write(bArr, 0, read);
                    if (messageDigest != null) {
                        messageDigest.update(bArr, 0, read);
                    }
                    long j4 = j3 + read;
                    j2 = reportProgress(j2, j4, j);
                    read = inputStream.read(bArr);
                    j3 = j4;
                } catch (Throwable th) {
                    th = th;
                    outputStream.flush();
                    this.progressListener = null;
                    throw th;
                }
            }
            String sha256 = this.indexFile.getSha256();
            if (sha256 != null && !HashUtilsKt.isMatching(messageDigest, sha256)) {
                throw new IOException("Hash not matching");
            }
            reportProgress(0L, j3, j);
            outputStream.flush();
            this.progressListener = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long reportProgress(long j, final long j2, final long j3) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - j > 100) {
            log.debug(new Function0() { // from class: org.fdroid.download.Downloader$reportProgress$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    long j4 = j2;
                    long j5 = j3;
                    return "onProgress: " + j4 + "/" + j5;
                }
            });
            ProgressListener progressListener = this.progressListener;
            if (progressListener != null) {
                progressListener.onProgress(j2, j3);
            }
            return currentTimeMillis;
        }
        return j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void throwExceptionIfInterrupted() throws InterruptedException {
        if (this.cancelled) {
            log.info(new Function0() { // from class: org.fdroid.download.Downloader$throwExceptionIfInterrupted$1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return "Received interrupt, cancelling download";
                }
            });
            Thread.currentThread().interrupt();
            throw new InterruptedException();
        }
    }

    private final void initDigest(File file, MessageDigest messageDigest) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            byte[] bArr = new byte[8192];
            for (int read = fileInputStream.read(bArr); read >= 0; read = fileInputStream.read(bArr)) {
                messageDigest.update(bArr, 0, read);
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(fileInputStream, null);
        } finally {
        }
    }
}
