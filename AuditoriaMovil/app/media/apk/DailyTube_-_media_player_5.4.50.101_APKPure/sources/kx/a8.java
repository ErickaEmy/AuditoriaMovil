package kx;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public final class a8 implements tl {

    /* renamed from: n3  reason: collision with root package name */
    public final v5.ta f10015n3;
    public final tl y;

    /* renamed from: zn  reason: collision with root package name */
    public final int f10016zn;

    public a8(tl tlVar, v5.ta taVar, int i) {
        this.y = (tl) v5.y.v(tlVar);
        this.f10015n3 = (v5.ta) v5.y.v(taVar);
        this.f10016zn = i;
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

    @Override // kx.tl
    @Nullable
    public Uri n3() {
        return this.y.n3();
    }

    @Override // kx.c5
    public int read(byte[] bArr, int i, int i5) throws IOException {
        this.f10015n3.n3(this.f10016zn);
        return this.y.read(bArr, i, i5);
    }

    @Override // kx.tl
    public long y(p pVar) throws IOException {
        this.f10015n3.n3(this.f10016zn);
        return this.y.y(pVar);
    }
}
