package c;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a implements gv {

    /* renamed from: a  reason: collision with root package name */
    public int f3891a;

    /* renamed from: c5  reason: collision with root package name */
    public fb f3892c5;

    /* renamed from: fb  reason: collision with root package name */
    public int f3894fb;

    /* renamed from: gv  reason: collision with root package name */
    public w f3895gv;

    /* renamed from: i9  reason: collision with root package name */
    public boolean f3896i9;

    /* renamed from: n3  reason: collision with root package name */
    public boolean f3897n3;
    public gv y;

    /* renamed from: zn  reason: collision with root package name */
    public boolean f3901zn;

    /* renamed from: v  reason: collision with root package name */
    public y f3900v = y.UNKNOWN;

    /* renamed from: s  reason: collision with root package name */
    public int f3898s = 1;

    /* renamed from: f  reason: collision with root package name */
    public List<gv> f3893f = new ArrayList();

    /* renamed from: t  reason: collision with root package name */
    public List<a> f3899t = new ArrayList();

    /* loaded from: classes.dex */
    public enum y {
        UNKNOWN,
        HORIZONTAL_DIMENSION,
        VERTICAL_DIMENSION,
        LEFT,
        RIGHT,
        TOP,
        BOTTOM,
        BASELINE
    }

    public a(w wVar) {
        this.f3895gv = wVar;
    }

    public void gv(int i) {
        if (this.f3896i9) {
            return;
        }
        this.f3896i9 = true;
        this.f3894fb = i;
        for (gv gvVar : this.f3893f) {
            gvVar.y(gvVar);
        }
    }

    public void n3(gv gvVar) {
        this.f3893f.add(gvVar);
        if (this.f3896i9) {
            gvVar.y(gvVar);
        }
    }

    public String toString() {
        Object obj;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f3895gv.f3945n3.mt());
        sb.append(":");
        sb.append(this.f3900v);
        sb.append("(");
        if (this.f3896i9) {
            obj = Integer.valueOf(this.f3894fb);
        } else {
            obj = "unresolved";
        }
        sb.append(obj);
        sb.append(") <t=");
        sb.append(this.f3899t.size());
        sb.append(":d=");
        sb.append(this.f3893f.size());
        sb.append(">");
        return sb.toString();
    }

    @Override // c.gv
    public void y(gv gvVar) {
        for (a aVar : this.f3899t) {
            if (!aVar.f3896i9) {
                return;
            }
        }
        this.f3901zn = true;
        gv gvVar2 = this.y;
        if (gvVar2 != null) {
            gvVar2.y(this);
        }
        if (this.f3897n3) {
            this.f3895gv.y(this);
            return;
        }
        a aVar2 = null;
        int i = 0;
        for (a aVar3 : this.f3899t) {
            if (!(aVar3 instanceof fb)) {
                i++;
                aVar2 = aVar3;
            }
        }
        if (aVar2 != null && i == 1 && aVar2.f3896i9) {
            fb fbVar = this.f3892c5;
            if (fbVar != null) {
                if (fbVar.f3896i9) {
                    this.f3891a = this.f3898s * fbVar.f3894fb;
                } else {
                    return;
                }
            }
            gv(aVar2.f3894fb + this.f3891a);
        }
        gv gvVar3 = this.y;
        if (gvVar3 != null) {
            gvVar3.y(this);
        }
    }

    public void zn() {
        this.f3899t.clear();
        this.f3893f.clear();
        this.f3896i9 = false;
        this.f3894fb = 0;
        this.f3901zn = false;
        this.f3897n3 = false;
    }
}
