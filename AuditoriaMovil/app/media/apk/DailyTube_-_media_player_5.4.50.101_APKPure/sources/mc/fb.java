package mc;

import android.graphics.Canvas;
import android.graphics.Picture;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class fb {

    /* renamed from: fb  reason: collision with root package name */
    public static boolean f11419fb = true;
    public d y;

    /* renamed from: n3  reason: collision with root package name */
    public String f11422n3 = "";

    /* renamed from: zn  reason: collision with root package name */
    public String f11424zn = "";

    /* renamed from: gv  reason: collision with root package name */
    public float f11421gv = 96.0f;

    /* renamed from: v  reason: collision with root package name */
    public n3$mt f11423v = new n3$mt();

    /* renamed from: a  reason: collision with root package name */
    public Map<String, b> f11420a = new HashMap();

    /* loaded from: classes.dex */
    public interface a8 {
        List<yt> n3();

        void s(yt ytVar) throws i9;
    }

    /* loaded from: classes.dex */
    public static abstract class b extends yt {

        /* renamed from: a  reason: collision with root package name */
        public ta f11425a;

        /* renamed from: fb  reason: collision with root package name */
        public List<String> f11426fb;

        /* renamed from: gv  reason: collision with root package name */
        public Boolean f11427gv;

        /* renamed from: v  reason: collision with root package name */
        public ta f11428v;

        /* renamed from: zn  reason: collision with root package name */
        public String f11429zn;

        public String toString() {
            return wz();
        }
    }

    /* loaded from: classes.dex */
    public static class d extends qn {

        /* renamed from: co  reason: collision with root package name */
        public w f11430co;

        /* renamed from: mt  reason: collision with root package name */
        public w f11431mt;

        /* renamed from: p  reason: collision with root package name */
        public w f11432p;

        /* renamed from: r  reason: collision with root package name */
        public String f11433r;

        /* renamed from: z  reason: collision with root package name */
        public w f11434z;

        @Override // mc.fb.yt
        public String wz() {
            return "svg";
        }
    }

    /* loaded from: classes.dex */
    public static abstract class ej extends x implements a8, z6 {

        /* renamed from: c5  reason: collision with root package name */
        public List<yt> f11435c5 = new ArrayList();

        /* renamed from: i9  reason: collision with root package name */
        public Set<String> f11437i9 = null;

        /* renamed from: f  reason: collision with root package name */
        public String f11436f = null;

        /* renamed from: t  reason: collision with root package name */
        public Set<String> f11438t = null;

        /* renamed from: tl  reason: collision with root package name */
        public Set<String> f11439tl = null;

        /* renamed from: wz  reason: collision with root package name */
        public Set<String> f11440wz = null;

        @Override // mc.fb.z6
        public void a(Set<String> set) {
            this.f11437i9 = set;
        }

        @Override // mc.fb.z6
        public void c5(Set<String> set) {
            this.f11439tl = set;
        }

        @Override // mc.fb.z6
        public void fb(Set<String> set) {
            this.f11438t = set;
        }

        @Override // mc.fb.z6
        public Set<String> getRequiredFeatures() {
            return this.f11437i9;
        }

        @Override // mc.fb.z6
        public void gv(Set<String> set) {
            this.f11440wz = set;
        }

        @Override // mc.fb.z6
        public void i9(String str) {
            this.f11436f = str;
        }

        @Override // mc.fb.a8
        public List<yt> n3() {
            return this.f11435c5;
        }

        @Override // mc.fb.a8
        public void s(yt ytVar) throws i9 {
            this.f11435c5.add(ytVar);
        }

        @Override // mc.fb.z6
        public Set<String> t() {
            return this.f11439tl;
        }

        @Override // mc.fb.z6
        public Set<String> tl() {
            return this.f11440wz;
        }

        @Override // mc.fb.z6
        public Set<String> y() {
            return null;
        }

        @Override // mc.fb.z6
        public String zn() {
            return this.f11436f;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class hw extends ej {

        /* renamed from: xc  reason: collision with root package name */
        public v f11441xc;
    }

    /* loaded from: classes.dex */
    public static abstract class qn extends hw {

        /* renamed from: w  reason: collision with root package name */
        public n3 f11445w;
    }

    /* loaded from: classes.dex */
    public static abstract class x extends b {

        /* renamed from: s  reason: collision with root package name */
        public n3 f11447s;
    }

    /* loaded from: classes.dex */
    public enum xg {
        px,
        em,
        ex,
        in,
        cm,
        mm,
        pt,
        pc,
        percent
    }

    /* loaded from: classes.dex */
    public static class yt {

        /* renamed from: n3  reason: collision with root package name */
        public a8 f11457n3;
        public fb y;

        public String wz() {
            return "";
        }
    }

    /* loaded from: classes.dex */
    public interface z6 {
        void a(Set<String> set);

        void c5(Set<String> set);

        void fb(Set<String> set);

        Set<String> getRequiredFeatures();

        void gv(Set<String> set);

        void i9(String str);

        Set<String> t();

        Set<String> tl();

        Set<String> y();

        String zn();
    }

    public static c5 fb() {
        return null;
    }

    public static fb s(InputStream inputStream) throws i9 {
        return new f().c(inputStream, f11419fb);
    }

    public final b a(a8 a8Var, String str) {
        b a2;
        b bVar = (b) a8Var;
        if (str.equals(bVar.f11429zn)) {
            return bVar;
        }
        for (yt ytVar : a8Var.n3()) {
            if (ytVar instanceof b) {
                b bVar2 = (b) ytVar;
                if (str.equals(bVar2.f11429zn)) {
                    return bVar2;
                }
                if ((ytVar instanceof a8) && (a2 = a((a8) ytVar, str)) != null) {
                    return a2;
                }
            }
        }
        return null;
    }

    public d c5() {
        return this.y;
    }

    public Picture f() {
        return tl(null);
    }

    public List<n3$w> gv() {
        return this.f11423v.zn();
    }

    public boolean i9() {
        return !this.f11423v.gv();
    }

    public void n3() {
        this.f11423v.v(n3$r.RenderOptions);
    }

    public void p(String str) {
        this.f11422n3 = str;
    }

    public Picture t(int i, int i5, a aVar) {
        Picture picture = new Picture();
        Canvas beginRecording = picture.beginRecording(i, i5);
        if (aVar == null || aVar.f11406a == null) {
            if (aVar == null) {
                aVar = new a();
            } else {
                aVar = new a(aVar);
            }
            aVar.fb(0.0f, 0.0f, i, i5);
        }
        new s(beginRecording, this.f11421gv).ad(this, aVar);
        picture.endRecording();
        return picture;
    }

    public Picture tl(a aVar) {
        n3 n3Var;
        w wVar;
        if (aVar != null && aVar.v()) {
            n3Var = aVar.f11407gv;
        } else {
            n3Var = this.y.f11445w;
        }
        if (aVar != null && aVar.a()) {
            return t((int) Math.ceil(aVar.f11406a.n3()), (int) Math.ceil(aVar.f11406a.zn()), aVar);
        }
        d dVar = this.y;
        w wVar2 = dVar.f11430co;
        if (wVar2 != null) {
            xg xgVar = wVar2.f11446v;
            xg xgVar2 = xg.percent;
            if (xgVar != xgVar2 && (wVar = dVar.f11434z) != null && wVar.f11446v != xgVar2) {
                return t((int) Math.ceil(wVar2.zn(this.f11421gv)), (int) Math.ceil(this.y.f11434z.zn(this.f11421gv)), aVar);
            }
        }
        if (wVar2 != null && n3Var != null) {
            float zn2 = wVar2.zn(this.f11421gv);
            return t((int) Math.ceil(zn2), (int) Math.ceil((n3Var.f11442gv * zn2) / n3Var.f11444zn), aVar);
        }
        w wVar3 = dVar.f11434z;
        if (wVar3 != null && n3Var != null) {
            float zn3 = wVar3.zn(this.f11421gv);
            return t((int) Math.ceil((n3Var.f11444zn * zn3) / n3Var.f11442gv), (int) Math.ceil(zn3), aVar);
        }
        return t(512, 512, aVar);
    }

    public b v(String str) {
        if (str != null && str.length() != 0) {
            if (str.equals(this.y.f11429zn)) {
                return this.y;
            }
            if (this.f11420a.containsKey(str)) {
                return this.f11420a.get(str);
            }
            b a2 = a(this.y, str);
            this.f11420a.put(str, a2);
            return a2;
        }
        return null;
    }

    public void w(d dVar) {
        this.y = dVar;
    }

    public yt wz(String str) {
        if (str == null) {
            return null;
        }
        String zn2 = zn(str);
        if (zn2.length() <= 1 || !zn2.startsWith("#")) {
            return null;
        }
        return v(zn2.substring(1));
    }

    public void xc(String str) {
        this.f11424zn = str;
    }

    public void y(n3$mt n3_mt) {
        this.f11423v.n3(n3_mt);
    }

    public final String zn(String str) {
        if (str.startsWith("\"") && str.endsWith("\"")) {
            str = str.substring(1, str.length() - 1).replace("\\\"", "\"");
        } else if (str.startsWith("'") && str.endsWith("'")) {
            str = str.substring(1, str.length() - 1).replace("\\'", "'");
        }
        return str.replace("\\\n", "").replace("\\A", "\n");
    }

    /* loaded from: classes.dex */
    public static class w implements Cloneable {

        /* renamed from: v  reason: collision with root package name */
        public xg f11446v;
        public float y;

        public w(float f4, xg xgVar) {
            this.y = f4;
            this.f11446v = xgVar;
        }

        public float a(s sVar, float f4) {
            if (this.f11446v == xg.percent) {
                return (this.y * f4) / 100.0f;
            }
            return fb(sVar);
        }

        public boolean c5() {
            if (this.y < 0.0f) {
                return true;
            }
            return false;
        }

        public float fb(s sVar) {
            switch (y.y[this.f11446v.ordinal()]) {
                case 1:
                    return this.y;
                case 2:
                    return this.y * sVar.j5();
                case 3:
                    return this.y * sVar.qn();
                case 4:
                    return this.y * sVar.j();
                case 5:
                    return (this.y * sVar.j()) / 2.54f;
                case 6:
                    return (this.y * sVar.j()) / 25.4f;
                case 7:
                    return (this.y * sVar.j()) / 72.0f;
                case 8:
                    return (this.y * sVar.j()) / 6.0f;
                case 9:
                    n3 o2 = sVar.o();
                    if (o2 == null) {
                        return this.y;
                    }
                    return (this.y * o2.f11444zn) / 100.0f;
                default:
                    return this.y;
            }
        }

        public float gv(s sVar) {
            if (this.f11446v == xg.percent) {
                n3 o2 = sVar.o();
                if (o2 == null) {
                    return this.y;
                }
                float f4 = o2.f11444zn;
                float f6 = o2.f11442gv;
                if (f4 == f6) {
                    return (this.y * f4) / 100.0f;
                }
                return (this.y * ((float) (Math.sqrt((f4 * f4) + (f6 * f6)) / 1.414213562373095d))) / 100.0f;
            }
            return fb(sVar);
        }

        public boolean i9() {
            if (this.y == 0.0f) {
                return true;
            }
            return false;
        }

        public float n3() {
            return this.y;
        }

        public float s(s sVar) {
            if (this.f11446v == xg.percent) {
                n3 o2 = sVar.o();
                if (o2 == null) {
                    return this.y;
                }
                return (this.y * o2.f11442gv) / 100.0f;
            }
            return fb(sVar);
        }

        public String toString() {
            return String.valueOf(this.y) + this.f11446v;
        }

        public float zn(float f4) {
            int i = y.y[this.f11446v.ordinal()];
            if (i != 1) {
                switch (i) {
                    case 4:
                        return this.y * f4;
                    case 5:
                        return (this.y * f4) / 2.54f;
                    case 6:
                        return (this.y * f4) / 25.4f;
                    case 7:
                        return (this.y * f4) / 72.0f;
                    case 8:
                        return (this.y * f4) / 6.0f;
                    default:
                        return this.y;
                }
            }
            return this.y;
        }

        public w(float f4) {
            this.y = f4;
            this.f11446v = xg.px;
        }
    }

    /* loaded from: classes.dex */
    public static class n3 {

        /* renamed from: gv  reason: collision with root package name */
        public float f11442gv;

        /* renamed from: n3  reason: collision with root package name */
        public float f11443n3;
        public float y;

        /* renamed from: zn  reason: collision with root package name */
        public float f11444zn;

        public n3(float f4, float f6, float f9, float f10) {
            this.y = f4;
            this.f11443n3 = f6;
            this.f11444zn = f9;
            this.f11442gv = f10;
        }

        public static n3 y(float f4, float f6, float f9, float f10) {
            return new n3(f4, f6, f9 - f4, f10 - f6);
        }

        public void gv(n3 n3Var) {
            float f4 = n3Var.y;
            if (f4 < this.y) {
                this.y = f4;
            }
            float f6 = n3Var.f11443n3;
            if (f6 < this.f11443n3) {
                this.f11443n3 = f6;
            }
            if (n3Var.n3() > n3()) {
                this.f11444zn = n3Var.n3() - this.y;
            }
            if (n3Var.zn() > zn()) {
                this.f11442gv = n3Var.zn() - this.f11443n3;
            }
        }

        public float n3() {
            return this.y + this.f11444zn;
        }

        public String toString() {
            return "[" + this.y + " " + this.f11443n3 + " " + this.f11444zn + " " + this.f11442gv + "]";
        }

        public float zn() {
            return this.f11443n3 + this.f11442gv;
        }

        public n3(n3 n3Var) {
            this.y = n3Var.y;
            this.f11443n3 = n3Var.f11443n3;
            this.f11444zn = n3Var.f11444zn;
            this.f11442gv = n3Var.f11442gv;
        }
    }
}
