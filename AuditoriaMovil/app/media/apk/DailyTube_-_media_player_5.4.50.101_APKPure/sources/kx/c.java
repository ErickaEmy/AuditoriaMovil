package kx;

import android.net.Uri;
import android.system.ErrnoException;
import android.system.OsConstants;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import kx.tl;
/* loaded from: classes.dex */
public final class c extends fb {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public Uri f10020a;

    /* renamed from: fb  reason: collision with root package name */
    public long f10021fb;

    /* renamed from: s  reason: collision with root package name */
    public boolean f10022s;
    @Nullable

    /* renamed from: v  reason: collision with root package name */
    public RandomAccessFile f10023v;

    /* loaded from: classes.dex */
    public static final class n3 implements tl.y {
        @Nullable
        public o y;

        @Override // kx.tl.y
        /* renamed from: n3 */
        public c y() {
            c cVar = new c();
            o oVar = this.y;
            if (oVar != null) {
                cVar.i9(oVar);
            }
            return cVar;
        }
    }

    /* loaded from: classes.dex */
    public static final class y {
        /* JADX INFO: Access modifiers changed from: private */
        public static boolean n3(@Nullable Throwable th) {
            if ((th instanceof ErrnoException) && ((ErrnoException) th).errno == OsConstants.EACCES) {
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    public static class zn extends wz {
        public zn(Throwable th, int i) {
            super(th, i);
        }

        public zn(@Nullable String str, @Nullable Throwable th, int i) {
            super(str, th, i);
        }
    }

    public c() {
        super(false);
    }

    public static RandomAccessFile f3(Uri uri) throws zn {
        int i = 2006;
        try {
            return new RandomAccessFile((String) v5.y.v(uri.getPath()), "r");
        } catch (FileNotFoundException e2) {
            if (TextUtils.isEmpty(uri.getQuery()) && TextUtils.isEmpty(uri.getFragment())) {
                throw new zn(e2, (v5.j5.y < 21 || !y.n3(e2.getCause())) ? 2005 : 2005);
            }
            throw new zn(String.format("uri has query and/or fragment, which are not supported. Did you call Uri.parse() on a string containing '?' or '#'? Use Uri.fromFile(new File(path)) to avoid this. path=%s,query=%s,fragment=%s", uri.getPath(), uri.getQuery(), uri.getFragment()), e2, 1004);
        } catch (SecurityException e3) {
            throw new zn(e3, 2006);
        } catch (RuntimeException e5) {
            throw new zn(e5, 2000);
        }
    }

    @Override // kx.tl
    public void close() throws zn {
        this.f10020a = null;
        try {
            try {
                RandomAccessFile randomAccessFile = this.f10023v;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
            } catch (IOException e2) {
                throw new zn(e2, 2000);
            }
        } finally {
            this.f10023v = null;
            if (this.f10022s) {
                this.f10022s = false;
                r();
            }
        }
    }

    @Override // kx.tl
    @Nullable
    public Uri n3() {
        return this.f10020a;
    }

    @Override // kx.c5
    public int read(byte[] bArr, int i, int i5) throws zn {
        if (i5 == 0) {
            return 0;
        }
        if (this.f10021fb == 0) {
            return -1;
        }
        try {
            int read = ((RandomAccessFile) v5.j5.i9(this.f10023v)).read(bArr, i, (int) Math.min(this.f10021fb, i5));
            if (read > 0) {
                this.f10021fb -= read;
                mt(read);
            }
            return read;
        } catch (IOException e2) {
            throw new zn(e2, 2000);
        }
    }

    @Override // kx.tl
    public long y(p pVar) throws zn {
        Uri uri = pVar.y;
        this.f10020a = uri;
        x4(pVar);
        RandomAccessFile f32 = f3(uri);
        this.f10023v = f32;
        try {
            f32.seek(pVar.f10071fb);
            long j2 = pVar.f10075s;
            if (j2 == -1) {
                j2 = this.f10023v.length() - pVar.f10071fb;
            }
            this.f10021fb = j2;
            if (j2 >= 0) {
                this.f10022s = true;
                i4(pVar);
                return this.f10021fb;
            }
            throw new zn(null, null, 2008);
        } catch (IOException e2) {
            throw new zn(e2, 2000);
        }
    }
}
