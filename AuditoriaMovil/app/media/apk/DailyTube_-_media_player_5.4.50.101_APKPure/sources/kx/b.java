package kx;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import kx.tl;
/* loaded from: classes.dex */
public final class b implements tl {

    /* renamed from: n3  reason: collision with root package name */
    public final n3 f10017n3;
    public final tl y;

    /* renamed from: zn  reason: collision with root package name */
    public boolean f10018zn;

    /* loaded from: classes.dex */
    public interface n3 {
        p n3(p pVar) throws IOException;

        Uri y(Uri uri);
    }

    /* loaded from: classes.dex */
    public static final class y implements tl.y {

        /* renamed from: n3  reason: collision with root package name */
        public final n3 f10019n3;
        public final tl.y y;

        public y(tl.y yVar, n3 n3Var) {
            this.y = yVar;
            this.f10019n3 = n3Var;
        }

        @Override // kx.tl.y
        /* renamed from: n3 */
        public b y() {
            return new b(this.y.y(), this.f10019n3);
        }
    }

    public b(tl tlVar, n3 n3Var) {
        this.y = tlVar;
        this.f10017n3 = n3Var;
    }

    @Override // kx.tl
    public void close() throws IOException {
        if (this.f10018zn) {
            this.f10018zn = false;
            this.y.close();
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
        Uri n32 = this.y.n3();
        if (n32 == null) {
            return null;
        }
        return this.f10017n3.y(n32);
    }

    @Override // kx.c5
    public int read(byte[] bArr, int i, int i5) throws IOException {
        return this.y.read(bArr, i, i5);
    }

    @Override // kx.tl
    public long y(p pVar) throws IOException {
        p n32 = this.f10017n3.n3(pVar);
        this.f10018zn = true;
        return this.y.y(n32);
    }
}
