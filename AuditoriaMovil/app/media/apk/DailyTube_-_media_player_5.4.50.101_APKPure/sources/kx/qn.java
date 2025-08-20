package kx;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public final class qn implements tl {

    /* renamed from: gv  reason: collision with root package name */
    public long f10087gv;

    /* renamed from: n3  reason: collision with root package name */
    public final f f10088n3;
    public final tl y;

    /* renamed from: zn  reason: collision with root package name */
    public boolean f10089zn;

    public qn(tl tlVar, f fVar) {
        this.y = (tl) v5.y.v(tlVar);
        this.f10088n3 = (f) v5.y.v(fVar);
    }

    @Override // kx.tl
    public void close() throws IOException {
        try {
            this.y.close();
        } finally {
            if (this.f10089zn) {
                this.f10089zn = false;
                this.f10088n3.close();
            }
        }
    }

    @Override // kx.tl
    public Map<String, List<String>> fb() {
        return this.y.fb();
    }

    @Override // kx.tl
    public void i9(o oVar) {
        v5.y.v(oVar);
        this.y.i9(oVar);
    }

    @Override // kx.tl
    @Nullable
    public Uri n3() {
        return this.y.n3();
    }

    @Override // kx.c5
    public int read(byte[] bArr, int i, int i5) throws IOException {
        if (this.f10087gv == 0) {
            return -1;
        }
        int read = this.y.read(bArr, i, i5);
        if (read > 0) {
            this.f10088n3.write(bArr, i, read);
            long j2 = this.f10087gv;
            if (j2 != -1) {
                this.f10087gv = j2 - read;
            }
        }
        return read;
    }

    @Override // kx.tl
    public long y(p pVar) throws IOException {
        long y = this.y.y(pVar);
        this.f10087gv = y;
        if (y == 0) {
            return 0L;
        }
        if (pVar.f10075s == -1 && y != -1) {
            pVar = pVar.a(0L, y);
        }
        this.f10089zn = true;
        this.f10088n3.y(pVar);
        return this.f10087gv;
    }
}
