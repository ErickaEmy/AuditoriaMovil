package c;

import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class zn extends w {

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<w> f3968f;

    /* renamed from: t  reason: collision with root package name */
    public int f3969t;

    public zn(n.v vVar, int i) {
        super(vVar);
        this.f3968f = new ArrayList<>();
        this.f3940a = i;
        p();
    }

    @Override // c.w
    public void a() {
        this.f3948zn = null;
        Iterator<w> it = this.f3968f.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    public final n.v co() {
        for (int size = this.f3968f.size() - 1; size >= 0; size--) {
            w wVar = this.f3968f.get(size);
            if (wVar.f3945n3.j5() != 8) {
                return wVar.f3945n3;
            }
        }
        return null;
    }

    @Override // c.w
    public void gv() {
        Iterator<w> it = this.f3968f.iterator();
        while (it.hasNext()) {
            it.next().gv();
        }
        int size = this.f3968f.size();
        if (size < 1) {
            return;
        }
        n.v vVar = this.f3968f.get(0).f3945n3;
        n.v vVar2 = this.f3968f.get(size - 1).f3945n3;
        if (this.f3940a == 0) {
            n.gv gvVar = vVar.f11700ej;
            n.gv gvVar2 = vVar2.f11687a8;
            a c52 = c5(gvVar, 0);
            int v2 = gvVar.v();
            n.v mt2 = mt();
            if (mt2 != null) {
                v2 = mt2.f11700ej.v();
            }
            if (c52 != null) {
                n3(this.f3946s, c52, v2);
            }
            a c53 = c5(gvVar2, 0);
            int v3 = gvVar2.v();
            n.v co2 = co();
            if (co2 != null) {
                v3 = co2.f11687a8.v();
            }
            if (c53 != null) {
                n3(this.f3941c5, c53, -v3);
            }
        } else {
            n.gv gvVar3 = vVar.f11747ud;
            n.gv gvVar4 = vVar2.f11753x;
            a c54 = c5(gvVar3, 1);
            int v4 = gvVar3.v();
            n.v mt3 = mt();
            if (mt3 != null) {
                v4 = mt3.f11747ud.v();
            }
            if (c54 != null) {
                n3(this.f3946s, c54, v4);
            }
            a c55 = c5(gvVar4, 1);
            int v6 = gvVar4.v();
            n.v co3 = co();
            if (co3 != null) {
                v6 = co3.f11753x.v();
            }
            if (c55 != null) {
                n3(this.f3941c5, c55, -v6);
            }
        }
        this.f3946s.y = this;
        this.f3941c5.y = this;
    }

    @Override // c.w
    public long i9() {
        int size = this.f3968f.size();
        long j2 = 0;
        for (int i = 0; i < size; i++) {
            w wVar = this.f3968f.get(i);
            j2 = j2 + wVar.f3946s.f3891a + wVar.i9() + wVar.f3941c5.f3891a;
        }
        return j2;
    }

    public final n.v mt() {
        for (int i = 0; i < this.f3968f.size(); i++) {
            w wVar = this.f3968f.get(i);
            if (wVar.f3945n3.j5() != 8) {
                return wVar.f3945n3;
            }
        }
        return null;
    }

    public final void p() {
        n.v vVar;
        int yt2;
        n.v vVar2 = this.f3945n3;
        n.v a82 = vVar2.a8(this.f3940a);
        while (true) {
            n.v vVar3 = a82;
            vVar = vVar2;
            vVar2 = vVar3;
            if (vVar2 == null) {
                break;
            }
            a82 = vVar2.a8(this.f3940a);
        }
        this.f3945n3 = vVar;
        this.f3968f.add(vVar.b(this.f3940a));
        n.v ej2 = vVar.ej(this.f3940a);
        while (ej2 != null) {
            this.f3968f.add(ej2.b(this.f3940a));
            ej2 = ej2.ej(this.f3940a);
        }
        Iterator<w> it = this.f3968f.iterator();
        while (it.hasNext()) {
            w next = it.next();
            int i = this.f3940a;
            if (i == 0) {
                next.f3945n3.f11764zn = this;
            } else if (i == 1) {
                next.f3945n3.f11709gv = this;
            }
        }
        if (this.f3940a == 0 && ((n.a) this.f3945n3.ud()).gn() && this.f3968f.size() > 1) {
            ArrayList<w> arrayList = this.f3968f;
            this.f3945n3 = arrayList.get(arrayList.size() - 1).f3945n3;
        }
        if (this.f3940a == 0) {
            yt2 = this.f3945n3.f3();
        } else {
            yt2 = this.f3945n3.yt();
        }
        this.f3969t = yt2;
    }

    @Override // c.w
    public boolean tl() {
        int size = this.f3968f.size();
        for (int i = 0; i < size; i++) {
            if (!this.f3968f.get(i).tl()) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        String str;
        Iterator<w> it;
        StringBuilder sb = new StringBuilder();
        sb.append("ChainRun ");
        if (this.f3940a == 0) {
            str = "horizontal : ";
        } else {
            str = "vertical : ";
        }
        sb.append(str);
        String sb2 = sb.toString();
        while (this.f3968f.iterator().hasNext()) {
            sb2 = ((sb2 + "<") + it.next()) + "> ";
        }
        return sb2;
    }

    @Override // c.w
    public void v() {
        for (int i = 0; i < this.f3968f.size(); i++) {
            this.f3968f.get(i).v();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:110:0x01ae, code lost:
        if (r1 != r7) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x01d4, code lost:
        if (r1 != r7) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x01d6, code lost:
        r13 = r13 + 1;
        r7 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x01d9, code lost:
        r9.f3947v.gv(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:279:0x0418, code lost:
        r7 = r7 - r10;
     */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00eb  */
    @Override // c.w, c.gv
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void y(c.gv r26) {
        /*
            Method dump skipped, instructions count: 1088
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c.zn.y(c.gv):void");
    }
}
