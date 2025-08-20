package kx;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import kx.tl;
import kx.x4;
/* loaded from: classes.dex */
public final class r implements tl {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public tl f10090a;
    @Nullable

    /* renamed from: c5  reason: collision with root package name */
    public tl f10091c5;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public tl f10092f;
    @Nullable

    /* renamed from: fb  reason: collision with root package name */
    public tl f10093fb;
    @Nullable

    /* renamed from: gv  reason: collision with root package name */
    public tl f10094gv;
    @Nullable

    /* renamed from: i9  reason: collision with root package name */
    public tl f10095i9;

    /* renamed from: n3  reason: collision with root package name */
    public final List<o> f10096n3 = new ArrayList();
    @Nullable

    /* renamed from: s  reason: collision with root package name */
    public tl f10097s;
    @Nullable

    /* renamed from: v  reason: collision with root package name */
    public tl f10098v;
    public final Context y;

    /* renamed from: zn  reason: collision with root package name */
    public final tl f10099zn;

    /* loaded from: classes.dex */
    public static final class y implements tl.y {

        /* renamed from: n3  reason: collision with root package name */
        public final tl.y f10100n3;
        public final Context y;
        @Nullable

        /* renamed from: zn  reason: collision with root package name */
        public o f10101zn;

        public y(Context context) {
            this(context, new x4.n3());
        }

        @Override // kx.tl.y
        /* renamed from: n3 */
        public r y() {
            r rVar = new r(this.y, this.f10100n3.y());
            o oVar = this.f10101zn;
            if (oVar != null) {
                rVar.i9(oVar);
            }
            return rVar;
        }

        public y zn(@Nullable o oVar) {
            this.f10101zn = oVar;
            return this;
        }

        public y(Context context, tl.y yVar) {
            this.y = context.getApplicationContext();
            this.f10100n3 = yVar;
        }
    }

    public r(Context context, tl tlVar) {
        this.y = context.getApplicationContext();
        this.f10099zn = (tl) v5.y.v(tlVar);
    }

    public final void a(tl tlVar) {
        for (int i = 0; i < this.f10096n3.size(); i++) {
            tlVar.i9(this.f10096n3.get(i));
        }
    }

    public final void c(@Nullable tl tlVar, o oVar) {
        if (tlVar != null) {
            tlVar.i9(oVar);
        }
    }

    public final tl c5() {
        if (this.f10098v == null) {
            zn znVar = new zn(this.y);
            this.f10098v = znVar;
            a(znVar);
        }
        return this.f10098v;
    }

    @Override // kx.tl
    public void close() throws IOException {
        tl tlVar = this.f10092f;
        if (tlVar != null) {
            try {
                tlVar.close();
            } finally {
                this.f10092f = null;
            }
        }
    }

    public final tl f3() {
        if (this.f10093fb == null) {
            try {
                tl tlVar = (tl) Class.forName("com.google.android.exoplayer2.ext.rtmp.RtmpDataSource").getConstructor(null).newInstance(null);
                this.f10093fb = tlVar;
                a(tlVar);
            } catch (ClassNotFoundException unused) {
                v5.r.c5("DefaultDataSource", "Attempting to play RTMP stream without depending on the RTMP extension");
            } catch (Exception e2) {
                throw new RuntimeException("Error instantiating RTMP extension", e2);
            }
            if (this.f10093fb == null) {
                this.f10093fb = this.f10099zn;
            }
        }
        return this.f10093fb;
    }

    @Override // kx.tl
    public Map<String, List<String>> fb() {
        tl tlVar = this.f10092f;
        if (tlVar == null) {
            return Collections.emptyMap();
        }
        return tlVar.fb();
    }

    public final tl i4() {
        if (this.f10095i9 == null) {
            x xVar = new x(this.y);
            this.f10095i9 = xVar;
            a(xVar);
        }
        return this.f10095i9;
    }

    @Override // kx.tl
    public void i9(o oVar) {
        v5.y.v(oVar);
        this.f10099zn.i9(oVar);
        this.f10096n3.add(oVar);
        c(this.f10094gv, oVar);
        c(this.f10098v, oVar);
        c(this.f10090a, oVar);
        c(this.f10093fb, oVar);
        c(this.f10097s, oVar);
        c(this.f10091c5, oVar);
        c(this.f10095i9, oVar);
    }

    public final tl mt() {
        if (this.f10090a == null) {
            s sVar = new s(this.y);
            this.f10090a = sVar;
            a(sVar);
        }
        return this.f10090a;
    }

    public final tl n() {
        if (this.f10097s == null) {
            j jVar = new j();
            this.f10097s = jVar;
            a(jVar);
        }
        return this.f10097s;
    }

    @Override // kx.tl
    @Nullable
    public Uri n3() {
        tl tlVar = this.f10092f;
        if (tlVar == null) {
            return null;
        }
        return tlVar.n3();
    }

    public final tl r() {
        if (this.f10091c5 == null) {
            i9 i9Var = new i9();
            this.f10091c5 = i9Var;
            a(i9Var);
        }
        return this.f10091c5;
    }

    @Override // kx.c5
    public int read(byte[] bArr, int i, int i5) throws IOException {
        return ((tl) v5.y.v(this.f10092f)).read(bArr, i, i5);
    }

    public final tl x4() {
        if (this.f10094gv == null) {
            c cVar = new c();
            this.f10094gv = cVar;
            a(cVar);
        }
        return this.f10094gv;
    }

    @Override // kx.tl
    public long y(p pVar) throws IOException {
        boolean z2;
        if (this.f10092f == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        v5.y.fb(z2);
        String scheme = pVar.y.getScheme();
        if (v5.j5.y4(pVar.y)) {
            String path = pVar.y.getPath();
            if (path != null && path.startsWith("/android_asset/")) {
                this.f10092f = c5();
            } else {
                this.f10092f = x4();
            }
        } else if ("asset".equals(scheme)) {
            this.f10092f = c5();
        } else if ("content".equals(scheme)) {
            this.f10092f = mt();
        } else if ("rtmp".equals(scheme)) {
            this.f10092f = f3();
        } else if ("udp".equals(scheme)) {
            this.f10092f = n();
        } else if ("data".equals(scheme)) {
            this.f10092f = r();
        } else if (!"rawresource".equals(scheme) && !"android.resource".equals(scheme)) {
            this.f10092f = this.f10099zn;
        } else {
            this.f10092f = i4();
        }
        return this.f10092f.y(pVar);
    }
}
