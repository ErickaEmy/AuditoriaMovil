package org.fdroid.fdroid;

import java.io.FilterInputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DigestInputStream.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\fH\u0016J \u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\fH\u0016J\b\u0010\u0014\u001a\u00020\nH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lorg/fdroid/fdroid/DigestInputStream;", "Ljava/io/FilterInputStream;", "inputStream", "Ljava/io/InputStream;", "messageDigest", "Ljava/security/MessageDigest;", "(Ljava/io/InputStream;Ljava/security/MessageDigest;)V", "getDigestHex", "", "mark", "", "readlimit", "", "markSupported", "", "read", "b", "", "off", "len", "reset", "download_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DigestInputStream extends FilterInputStream {
    private final MessageDigest messageDigest;

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i) {
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DigestInputStream(InputStream inputStream, MessageDigest messageDigest) {
        super(inputStream);
        Intrinsics.checkNotNullParameter(inputStream, "inputStream");
        Intrinsics.checkNotNullParameter(messageDigest, "messageDigest");
        this.messageDigest = messageDigest;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() {
        int read = ((FilterInputStream) this).in.read();
        if (read != -1) {
            this.messageDigest.update((byte) read);
        }
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] b, int i, int i2) {
        Intrinsics.checkNotNullParameter(b, "b");
        int read = ((FilterInputStream) this).in.read(b, i, i2);
        if (read != -1) {
            this.messageDigest.update(b, i, read);
        }
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() {
        throw new NotImplementedError(null, 1, null);
    }

    public final String getDigestHex() {
        byte[] digest = this.messageDigest.digest();
        Intrinsics.checkNotNullExpressionValue(digest, "digest(...)");
        return HashUtilsKt.toHex(digest);
    }
}
