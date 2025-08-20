package di;

import androidx.annotation.Nullable;
import di.y;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import kx.f;
import v5.j5;
/* loaded from: classes.dex */
public final class n3 implements kx.f {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public File f7270a;

    /* renamed from: c5  reason: collision with root package name */
    public long f7271c5;
    @Nullable

    /* renamed from: fb  reason: collision with root package name */
    public OutputStream f7272fb;
    @Nullable

    /* renamed from: gv  reason: collision with root package name */
    public kx.p f7273gv;

    /* renamed from: i9  reason: collision with root package name */
    public co f7274i9;

    /* renamed from: n3  reason: collision with root package name */
    public final long f7275n3;

    /* renamed from: s  reason: collision with root package name */
    public long f7276s;

    /* renamed from: v  reason: collision with root package name */
    public long f7277v;
    public final di.y y;

    /* renamed from: zn  reason: collision with root package name */
    public final int f7278zn;

    /* renamed from: di.n3$n3  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0083n3 implements f.y {
        public di.y y;

        /* renamed from: n3  reason: collision with root package name */
        public long f7279n3 = 5242880;

        /* renamed from: zn  reason: collision with root package name */
        public int f7280zn = 20480;

        public C0083n3 n3(di.y yVar) {
            this.y = yVar;
            return this;
        }

        @Override // kx.f.y
        public kx.f y() {
            return new n3((di.y) v5.y.v(this.y), this.f7279n3, this.f7280zn);
        }

        public C0083n3 zn(long j2) {
            this.f7279n3 = j2;
            return this;
        }
    }

    /* loaded from: classes.dex */
    public static final class y extends y.C0084y {
        public y(IOException iOException) {
            super(iOException);
        }
    }

    public n3(di.y yVar, long j2, int i) {
        boolean z2;
        if (j2 <= 0 && j2 != -1) {
            z2 = false;
        } else {
            z2 = true;
        }
        v5.y.s(z2, "fragmentSize must be positive or C.LENGTH_UNSET.");
        int i5 = (j2 > (-1L) ? 1 : (j2 == (-1L) ? 0 : -1));
        if (i5 != 0 && j2 < 2097152) {
            v5.r.c5("CacheDataSink", "fragmentSize is below the minimum recommended value of 2097152. This may cause poor cache performance.");
        }
        this.y = (di.y) v5.y.v(yVar);
        this.f7275n3 = i5 == 0 ? Long.MAX_VALUE : j2;
        this.f7278zn = i;
    }

    @Override // kx.f
    public void close() throws y {
        if (this.f7273gv == null) {
            return;
        }
        try {
            n3();
        } catch (IOException e2) {
            throw new y(e2);
        }
    }

    public final void n3() throws IOException {
        OutputStream outputStream = this.f7272fb;
        if (outputStream == null) {
            return;
        }
        try {
            outputStream.flush();
            j5.wz(this.f7272fb);
            this.f7272fb = null;
            this.f7270a = null;
            this.y.i9((File) j5.i9(this.f7270a), this.f7276s);
        } catch (Throwable th) {
            j5.wz(this.f7272fb);
            this.f7272fb = null;
            this.f7270a = null;
            ((File) j5.i9(this.f7270a)).delete();
            throw th;
        }
    }

    @Override // kx.f
    public void write(byte[] bArr, int i, int i5) throws y {
        kx.p pVar = this.f7273gv;
        if (pVar == null) {
            return;
        }
        int i6 = 0;
        while (i6 < i5) {
            try {
                if (this.f7276s == this.f7277v) {
                    n3();
                    zn(pVar);
                }
                int min = (int) Math.min(i5 - i6, this.f7277v - this.f7276s);
                ((OutputStream) j5.i9(this.f7272fb)).write(bArr, i + i6, min);
                i6 += min;
                long j2 = min;
                this.f7276s += j2;
                this.f7271c5 += j2;
            } catch (IOException e2) {
                throw new y(e2);
            }
        }
    }

    @Override // kx.f
    public void y(kx.p pVar) throws y {
        long j2;
        v5.y.v(pVar.f10069c5);
        if (pVar.f10075s == -1 && pVar.gv(2)) {
            this.f7273gv = null;
            return;
        }
        this.f7273gv = pVar;
        if (pVar.gv(4)) {
            j2 = this.f7275n3;
        } else {
            j2 = Long.MAX_VALUE;
        }
        this.f7277v = j2;
        this.f7271c5 = 0L;
        try {
            zn(pVar);
        } catch (IOException e2) {
            throw new y(e2);
        }
    }

    public final void zn(kx.p pVar) throws IOException {
        long j2 = pVar.f10075s;
        long j4 = -1;
        if (j2 != -1) {
            j4 = Math.min(j2 - this.f7271c5, this.f7277v);
        }
        this.f7270a = this.y.y((String) j5.i9(pVar.f10069c5), pVar.f10071fb + this.f7271c5, j4);
        FileOutputStream fileOutputStream = new FileOutputStream(this.f7270a);
        if (this.f7278zn > 0) {
            co coVar = this.f7274i9;
            if (coVar == null) {
                this.f7274i9 = new co(fileOutputStream, this.f7278zn);
            } else {
                coVar.y(fileOutputStream);
            }
            this.f7272fb = this.f7274i9;
        } else {
            this.f7272fb = fileOutputStream;
        }
        this.f7276s = 0L;
    }
}
