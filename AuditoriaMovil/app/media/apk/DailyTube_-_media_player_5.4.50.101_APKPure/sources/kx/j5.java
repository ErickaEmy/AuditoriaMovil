package kx;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public final class j5 implements tl {

    /* renamed from: n3  reason: collision with root package name */
    public long f10053n3;
    public final tl y;

    /* renamed from: zn  reason: collision with root package name */
    public Uri f10054zn = Uri.EMPTY;

    /* renamed from: gv  reason: collision with root package name */
    public Map<String, List<String>> f10052gv = Collections.emptyMap();

    public j5(tl tlVar) {
        this.y = (tl) v5.y.v(tlVar);
    }

    public long a() {
        return this.f10053n3;
    }

    public Uri c5() {
        return this.f10054zn;
    }

    @Override // kx.tl
    public void close() throws IOException {
        this.y.close();
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

    public Map<String, List<String>> mt() {
        return this.f10052gv;
    }

    @Override // kx.tl
    @Nullable
    public Uri n3() {
        return this.y.n3();
    }

    public void r() {
        this.f10053n3 = 0L;
    }

    @Override // kx.c5
    public int read(byte[] bArr, int i, int i5) throws IOException {
        int read = this.y.read(bArr, i, i5);
        if (read != -1) {
            this.f10053n3 += read;
        }
        return read;
    }

    @Override // kx.tl
    public long y(p pVar) throws IOException {
        this.f10054zn = pVar.y;
        this.f10052gv = Collections.emptyMap();
        long y = this.y.y(pVar);
        this.f10054zn = (Uri) v5.y.v(n3());
        this.f10052gv = fb();
        return y;
    }
}
