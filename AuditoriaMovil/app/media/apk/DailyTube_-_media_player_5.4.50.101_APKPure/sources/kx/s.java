package kx;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.Nullable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileChannel;
/* loaded from: classes.dex */
public final class s extends fb {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public Uri f10102a;

    /* renamed from: c5  reason: collision with root package name */
    public long f10103c5;
    @Nullable

    /* renamed from: fb  reason: collision with root package name */
    public AssetFileDescriptor f10104fb;

    /* renamed from: i9  reason: collision with root package name */
    public boolean f10105i9;
    @Nullable

    /* renamed from: s  reason: collision with root package name */
    public FileInputStream f10106s;

    /* renamed from: v  reason: collision with root package name */
    public final ContentResolver f10107v;

    /* loaded from: classes.dex */
    public static class y extends wz {
        public y(@Nullable IOException iOException, int i) {
            super(iOException, i);
        }
    }

    public s(Context context) {
        super(false);
        this.f10107v = context.getContentResolver();
    }

    @Override // kx.tl
    public void close() throws y {
        this.f10102a = null;
        try {
            try {
                FileInputStream fileInputStream = this.f10106s;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                this.f10106s = null;
                try {
                    try {
                        AssetFileDescriptor assetFileDescriptor = this.f10104fb;
                        if (assetFileDescriptor != null) {
                            assetFileDescriptor.close();
                        }
                    } catch (IOException e2) {
                        throw new y(e2, 2000);
                    }
                } finally {
                    this.f10104fb = null;
                    if (this.f10105i9) {
                        this.f10105i9 = false;
                        r();
                    }
                }
            } catch (IOException e3) {
                throw new y(e3, 2000);
            }
        } catch (Throwable th) {
            this.f10106s = null;
            try {
                try {
                    AssetFileDescriptor assetFileDescriptor2 = this.f10104fb;
                    if (assetFileDescriptor2 != null) {
                        assetFileDescriptor2.close();
                    }
                    this.f10104fb = null;
                    if (this.f10105i9) {
                        this.f10105i9 = false;
                        r();
                    }
                    throw th;
                } catch (IOException e5) {
                    throw new y(e5, 2000);
                }
            } finally {
                this.f10104fb = null;
                if (this.f10105i9) {
                    this.f10105i9 = false;
                    r();
                }
            }
        }
    }

    @Override // kx.tl
    @Nullable
    public Uri n3() {
        return this.f10102a;
    }

    @Override // kx.c5
    public int read(byte[] bArr, int i, int i5) throws y {
        if (i5 == 0) {
            return 0;
        }
        long j2 = this.f10103c5;
        if (j2 == 0) {
            return -1;
        }
        if (j2 != -1) {
            try {
                i5 = (int) Math.min(j2, i5);
            } catch (IOException e2) {
                throw new y(e2, 2000);
            }
        }
        int read = ((FileInputStream) v5.j5.i9(this.f10106s)).read(bArr, i, i5);
        if (read == -1) {
            return -1;
        }
        long j4 = this.f10103c5;
        if (j4 != -1) {
            this.f10103c5 = j4 - read;
        }
        mt(read);
        return read;
    }

    @Override // kx.tl
    public long y(p pVar) throws y {
        AssetFileDescriptor openAssetFileDescriptor;
        int i = 2000;
        try {
            Uri uri = pVar.y;
            this.f10102a = uri;
            x4(pVar);
            if ("content".equals(pVar.y.getScheme())) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("android.provider.extra.ACCEPT_ORIGINAL_MEDIA_FORMAT", true);
                openAssetFileDescriptor = this.f10107v.openTypedAssetFileDescriptor(uri, "*/*", bundle);
            } else {
                openAssetFileDescriptor = this.f10107v.openAssetFileDescriptor(uri, "r");
            }
            this.f10104fb = openAssetFileDescriptor;
            if (openAssetFileDescriptor != null) {
                long length = openAssetFileDescriptor.getLength();
                FileInputStream fileInputStream = new FileInputStream(openAssetFileDescriptor.getFileDescriptor());
                this.f10106s = fileInputStream;
                int i5 = (length > (-1L) ? 1 : (length == (-1L) ? 0 : -1));
                if (i5 != 0 && pVar.f10071fb > length) {
                    throw new y(null, 2008);
                }
                long startOffset = openAssetFileDescriptor.getStartOffset();
                long skip = fileInputStream.skip(pVar.f10071fb + startOffset) - startOffset;
                if (skip == pVar.f10071fb) {
                    if (i5 == 0) {
                        FileChannel channel = fileInputStream.getChannel();
                        long size = channel.size();
                        if (size == 0) {
                            this.f10103c5 = -1L;
                        } else {
                            long position = size - channel.position();
                            this.f10103c5 = position;
                            if (position < 0) {
                                throw new y(null, 2008);
                            }
                        }
                    } else {
                        long j2 = length - skip;
                        this.f10103c5 = j2;
                        if (j2 < 0) {
                            throw new y(null, 2008);
                        }
                    }
                    long j4 = pVar.f10075s;
                    if (j4 != -1) {
                        long j6 = this.f10103c5;
                        if (j6 != -1) {
                            j4 = Math.min(j6, j4);
                        }
                        this.f10103c5 = j4;
                    }
                    this.f10105i9 = true;
                    i4(pVar);
                    long j7 = pVar.f10075s;
                    if (j7 == -1) {
                        return this.f10103c5;
                    }
                    return j7;
                }
                throw new y(null, 2008);
            }
            throw new y(new IOException("Could not open file descriptor for: " + uri), 2000);
        } catch (y e2) {
            throw e2;
        } catch (IOException e3) {
            if (e3 instanceof FileNotFoundException) {
                i = 2005;
            }
            throw new y(e3, i);
        }
    }
}
