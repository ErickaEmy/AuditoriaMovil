package kx;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import androidx.annotation.Nullable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes.dex */
public final class zn extends fb {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public Uri f10193a;

    /* renamed from: c5  reason: collision with root package name */
    public boolean f10194c5;
    @Nullable

    /* renamed from: fb  reason: collision with root package name */
    public InputStream f10195fb;

    /* renamed from: s  reason: collision with root package name */
    public long f10196s;

    /* renamed from: v  reason: collision with root package name */
    public final AssetManager f10197v;

    /* loaded from: classes.dex */
    public static final class y extends wz {
        public y(@Nullable Throwable th, int i) {
            super(th, i);
        }
    }

    public zn(Context context) {
        super(false);
        this.f10197v = context.getAssets();
    }

    @Override // kx.tl
    public void close() throws y {
        this.f10193a = null;
        try {
            try {
                InputStream inputStream = this.f10195fb;
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e2) {
                throw new y(e2, 2000);
            }
        } finally {
            this.f10195fb = null;
            if (this.f10194c5) {
                this.f10194c5 = false;
                r();
            }
        }
    }

    @Override // kx.tl
    @Nullable
    public Uri n3() {
        return this.f10193a;
    }

    @Override // kx.c5
    public int read(byte[] bArr, int i, int i5) throws y {
        if (i5 == 0) {
            return 0;
        }
        long j2 = this.f10196s;
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
        int read = ((InputStream) v5.j5.i9(this.f10195fb)).read(bArr, i, i5);
        if (read == -1) {
            return -1;
        }
        long j4 = this.f10196s;
        if (j4 != -1) {
            this.f10196s = j4 - read;
        }
        mt(read);
        return read;
    }

    @Override // kx.tl
    public long y(p pVar) throws y {
        int i;
        try {
            Uri uri = pVar.y;
            this.f10193a = uri;
            String str = (String) v5.y.v(uri.getPath());
            if (str.startsWith("/android_asset/")) {
                str = str.substring(15);
            } else if (str.startsWith("/")) {
                str = str.substring(1);
            }
            x4(pVar);
            InputStream open = this.f10197v.open(str, 1);
            this.f10195fb = open;
            if (open.skip(pVar.f10071fb) >= pVar.f10071fb) {
                long j2 = pVar.f10075s;
                if (j2 != -1) {
                    this.f10196s = j2;
                } else {
                    long available = this.f10195fb.available();
                    this.f10196s = available;
                    if (available == 2147483647L) {
                        this.f10196s = -1L;
                    }
                }
                this.f10194c5 = true;
                i4(pVar);
                return this.f10196s;
            }
            throw new y(null, 2008);
        } catch (y e2) {
            throw e2;
        } catch (IOException e3) {
            if (e3 instanceof FileNotFoundException) {
                i = 2005;
            } else {
                i = 2000;
            }
            throw new y(e3, i);
        }
    }
}
