package af;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public final class x4 implements kx.tl {

    /* renamed from: gv  reason: collision with root package name */
    public final byte[] f407gv;

    /* renamed from: n3  reason: collision with root package name */
    public final int f408n3;

    /* renamed from: v  reason: collision with root package name */
    public int f409v;
    public final kx.tl y;

    /* renamed from: zn  reason: collision with root package name */
    public final y f410zn;

    /* loaded from: classes.dex */
    public interface y {
        void y(v5.rz rzVar);
    }

    public x4(kx.tl tlVar, int i, y yVar) {
        boolean z2;
        if (i > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        v5.y.y(z2);
        this.y = tlVar;
        this.f408n3 = i;
        this.f410zn = yVar;
        this.f407gv = new byte[1];
        this.f409v = i;
    }

    public final boolean a() throws IOException {
        if (this.y.read(this.f407gv, 0, 1) == -1) {
            return false;
        }
        int i = (this.f407gv[0] & 255) << 4;
        if (i == 0) {
            return true;
        }
        byte[] bArr = new byte[i];
        int i5 = i;
        int i6 = 0;
        while (i5 > 0) {
            int read = this.y.read(bArr, i6, i5);
            if (read == -1) {
                return false;
            }
            i6 += read;
            i5 -= read;
        }
        while (i > 0 && bArr[i - 1] == 0) {
            i--;
        }
        if (i > 0) {
            this.f410zn.y(new v5.rz(bArr, i));
        }
        return true;
    }

    @Override // kx.tl
    public void close() {
        throw new UnsupportedOperationException();
    }

    @Override // kx.tl
    public Map<String, List<String>> fb() {
        return this.y.fb();
    }

    @Override // kx.tl
    public void i9(kx.o oVar) {
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
        if (this.f409v == 0) {
            if (!a()) {
                return -1;
            }
            this.f409v = this.f408n3;
        }
        int read = this.y.read(bArr, i, Math.min(this.f409v, i5));
        if (read != -1) {
            this.f409v -= read;
        }
        return read;
    }

    @Override // kx.tl
    public long y(kx.p pVar) {
        throw new UnsupportedOperationException();
    }
}
