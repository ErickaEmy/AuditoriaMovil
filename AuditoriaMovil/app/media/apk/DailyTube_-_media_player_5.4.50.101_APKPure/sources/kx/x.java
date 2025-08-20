package kx;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;
/* loaded from: classes.dex */
public final class x extends fb {

    /* renamed from: a  reason: collision with root package name */
    public final String f10128a;
    @Nullable

    /* renamed from: c5  reason: collision with root package name */
    public InputStream f10129c5;

    /* renamed from: f  reason: collision with root package name */
    public boolean f10130f;
    @Nullable

    /* renamed from: fb  reason: collision with root package name */
    public Uri f10131fb;

    /* renamed from: i9  reason: collision with root package name */
    public long f10132i9;
    @Nullable

    /* renamed from: s  reason: collision with root package name */
    public AssetFileDescriptor f10133s;

    /* renamed from: v  reason: collision with root package name */
    public final Resources f10134v;

    /* loaded from: classes.dex */
    public static class y extends wz {
        public y(@Nullable String str, @Nullable Throwable th, int i) {
            super(str, th, i);
        }
    }

    public x(Context context) {
        super(false);
        this.f10134v = context.getResources();
        this.f10128a = context.getPackageName();
    }

    public static Uri buildRawResourceUri(int i) {
        return Uri.parse("rawresource:///" + i);
    }

    @Override // kx.tl
    public void close() throws y {
        this.f10131fb = null;
        try {
            try {
                InputStream inputStream = this.f10129c5;
                if (inputStream != null) {
                    inputStream.close();
                }
                this.f10129c5 = null;
                try {
                    try {
                        AssetFileDescriptor assetFileDescriptor = this.f10133s;
                        if (assetFileDescriptor != null) {
                            assetFileDescriptor.close();
                        }
                    } catch (IOException e2) {
                        throw new y(null, e2, 2000);
                    }
                } finally {
                    this.f10133s = null;
                    if (this.f10130f) {
                        this.f10130f = false;
                        r();
                    }
                }
            } catch (IOException e3) {
                throw new y(null, e3, 2000);
            }
        } catch (Throwable th) {
            this.f10129c5 = null;
            try {
                try {
                    AssetFileDescriptor assetFileDescriptor2 = this.f10133s;
                    if (assetFileDescriptor2 != null) {
                        assetFileDescriptor2.close();
                    }
                    this.f10133s = null;
                    if (this.f10130f) {
                        this.f10130f = false;
                        r();
                    }
                    throw th;
                } catch (IOException e5) {
                    throw new y(null, e5, 2000);
                }
            } finally {
                this.f10133s = null;
                if (this.f10130f) {
                    this.f10130f = false;
                    r();
                }
            }
        }
    }

    @Override // kx.tl
    @Nullable
    public Uri n3() {
        return this.f10131fb;
    }

    @Override // kx.c5
    public int read(byte[] bArr, int i, int i5) throws y {
        if (i5 == 0) {
            return 0;
        }
        long j2 = this.f10132i9;
        if (j2 == 0) {
            return -1;
        }
        if (j2 != -1) {
            try {
                i5 = (int) Math.min(j2, i5);
            } catch (IOException e2) {
                throw new y(null, e2, 2000);
            }
        }
        int read = ((InputStream) v5.j5.i9(this.f10129c5)).read(bArr, i, i5);
        if (read == -1) {
            if (this.f10132i9 == -1) {
                return -1;
            }
            throw new y("End of stream reached having not read sufficient data.", new EOFException(), 2000);
        }
        long j4 = this.f10132i9;
        if (j4 != -1) {
            this.f10132i9 = j4 - read;
        }
        mt(read);
        return read;
    }

    @Override // kx.tl
    public long y(p pVar) throws y {
        int parseInt;
        String str;
        Uri uri = pVar.y;
        this.f10131fb = uri;
        if (!TextUtils.equals("rawresource", uri.getScheme()) && (!TextUtils.equals("android.resource", uri.getScheme()) || uri.getPathSegments().size() != 1 || !((String) v5.y.v(uri.getLastPathSegment())).matches("\\d+"))) {
            if (TextUtils.equals("android.resource", uri.getScheme())) {
                String str2 = (String) v5.y.v(uri.getPath());
                if (str2.startsWith("/")) {
                    str2 = str2.substring(1);
                }
                String host = uri.getHost();
                StringBuilder sb = new StringBuilder();
                if (TextUtils.isEmpty(host)) {
                    str = "";
                } else {
                    str = host + ":";
                }
                sb.append(str);
                sb.append(str2);
                parseInt = this.f10134v.getIdentifier(sb.toString(), "raw", this.f10128a);
                if (parseInt == 0) {
                    throw new y("Resource not found.", null, 2005);
                }
            } else {
                throw new y("URI must either use scheme rawresource or android.resource", null, 1004);
            }
        } else {
            try {
                parseInt = Integer.parseInt((String) v5.y.v(uri.getLastPathSegment()));
            } catch (NumberFormatException unused) {
                throw new y("Resource identifier must be an integer.", null, 1004);
            }
        }
        x4(pVar);
        try {
            AssetFileDescriptor openRawResourceFd = this.f10134v.openRawResourceFd(parseInt);
            this.f10133s = openRawResourceFd;
            if (openRawResourceFd != null) {
                long length = openRawResourceFd.getLength();
                FileInputStream fileInputStream = new FileInputStream(openRawResourceFd.getFileDescriptor());
                this.f10129c5 = fileInputStream;
                int i = (length > (-1L) ? 1 : (length == (-1L) ? 0 : -1));
                if (i != 0) {
                    try {
                        if (pVar.f10071fb > length) {
                            throw new y(null, null, 2008);
                        }
                    } catch (y e2) {
                        throw e2;
                    } catch (IOException e3) {
                        throw new y(null, e3, 2000);
                    }
                }
                long startOffset = openRawResourceFd.getStartOffset();
                long skip = fileInputStream.skip(pVar.f10071fb + startOffset) - startOffset;
                if (skip == pVar.f10071fb) {
                    if (i == 0) {
                        FileChannel channel = fileInputStream.getChannel();
                        if (channel.size() == 0) {
                            this.f10132i9 = -1L;
                        } else {
                            long size = channel.size() - channel.position();
                            this.f10132i9 = size;
                            if (size < 0) {
                                throw new y(null, null, 2008);
                            }
                        }
                    } else {
                        long j2 = length - skip;
                        this.f10132i9 = j2;
                        if (j2 < 0) {
                            throw new wz(2008);
                        }
                    }
                    long j4 = pVar.f10075s;
                    if (j4 != -1) {
                        long j6 = this.f10132i9;
                        if (j6 != -1) {
                            j4 = Math.min(j6, j4);
                        }
                        this.f10132i9 = j4;
                    }
                    this.f10130f = true;
                    i4(pVar);
                    long j7 = pVar.f10075s;
                    if (j7 == -1) {
                        return this.f10132i9;
                    }
                    return j7;
                }
                throw new y(null, null, 2008);
            }
            throw new y("Resource is compressed: " + uri, null, 2000);
        } catch (Resources.NotFoundException e5) {
            throw new y(null, e5, 2005);
        }
    }
}
