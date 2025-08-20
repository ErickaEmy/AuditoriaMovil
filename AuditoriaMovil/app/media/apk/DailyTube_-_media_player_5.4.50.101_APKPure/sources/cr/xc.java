package cr;

import android.animation.TimeInterpolator;
import android.util.AndroidRuntimeException;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cr.f;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class xc extends f {

    /* renamed from: o4  reason: collision with root package name */
    public int f6816o4;

    /* renamed from: dm  reason: collision with root package name */
    public ArrayList<f> f6814dm = new ArrayList<>();

    /* renamed from: ct  reason: collision with root package name */
    public boolean f6813ct = true;

    /* renamed from: rs  reason: collision with root package name */
    public boolean f6817rs = false;

    /* renamed from: eb  reason: collision with root package name */
    public int f6815eb = 0;

    /* loaded from: classes.dex */
    public static class n3 extends t {
        public xc y;

        public n3(xc xcVar) {
            this.y = xcVar;
        }

        @Override // cr.t, cr.f.fb
        public void gv(@NonNull f fVar) {
            xc xcVar = this.y;
            if (!xcVar.f6817rs) {
                xcVar.dm();
                this.y.f6817rs = true;
            }
        }

        @Override // cr.f.fb
        public void zn(@NonNull f fVar) {
            xc xcVar = this.y;
            int i = xcVar.f6816o4 - 1;
            xcVar.f6816o4 = i;
            if (i == 0) {
                xcVar.f6817rs = false;
                xcVar.p();
            }
            fVar.j(this);
        }
    }

    /* loaded from: classes.dex */
    public class y extends t {
        public final /* synthetic */ f y;

        public y(f fVar) {
            this.y = fVar;
        }

        @Override // cr.f.fb
        public void zn(@NonNull f fVar) {
            this.y.k();
            fVar.j(this);
        }
    }

    @Override // cr.f
    @NonNull
    /* renamed from: ap */
    public xc f7(long j2) {
        ArrayList<f> arrayList;
        super.f7(j2);
        if (this.f6740fb >= 0 && (arrayList = this.f6814dm) != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                this.f6814dm.get(i).f7(j2);
            }
        }
        return this;
    }

    @Override // cr.f
    public void cancel() {
        super.cancel();
        int size = this.f6814dm.size();
        for (int i = 0; i < size; i++) {
            this.f6814dm.get(i).cancel();
        }
    }

    @Override // cr.f
    public String ct(String str) {
        String ct2 = super.ct(str);
        for (int i = 0; i < this.f6814dm.size(); i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(ct2);
            sb.append("\n");
            sb.append(this.f6814dm.get(i).ct(str + "  "));
            ct2 = sb.toString();
        }
        return ct2;
    }

    @Override // cr.f
    @NonNull
    /* renamed from: e */
    public xc j(@NonNull f.fb fbVar) {
        return (xc) super.j(fbVar);
    }

    @NonNull
    public xc eb(@NonNull f fVar) {
        lc(fVar);
        long j2 = this.f6740fb;
        if (j2 >= 0) {
            fVar.f7(j2);
        }
        if ((this.f6815eb & 1) != 0) {
            fVar.jz(i4());
        }
        if ((this.f6815eb & 2) != 0) {
            d0();
            fVar.y5(null);
        }
        if ((this.f6815eb & 4) != 0) {
            fVar.u(c());
        }
        if ((this.f6815eb & 8) != 0) {
            fVar.en(x4());
        }
        return this;
    }

    @Override // cr.f
    public void en(f.a aVar) {
        super.en(aVar);
        this.f6815eb |= 8;
        int size = this.f6814dm.size();
        for (int i = 0; i < size; i++) {
            this.f6814dm.get(i).en(aVar);
        }
    }

    @Override // cr.f
    public void f(@NonNull p pVar) {
        if (x(pVar.f6778n3)) {
            Iterator<f> it = this.f6814dm.iterator();
            while (it.hasNext()) {
                f next = it.next();
                if (next.x(pVar.f6778n3)) {
                    next.f(pVar);
                    pVar.f6779zn.add(next);
                }
            }
        }
    }

    @Override // cr.f
    public void i9(p pVar) {
        super.i9(pVar);
        int size = this.f6814dm.size();
        for (int i = 0; i < size; i++) {
            this.f6814dm.get(i).i9(pVar);
        }
    }

    @Override // cr.f
    public void k() {
        if (this.f6814dm.isEmpty()) {
            dm();
            p();
            return;
        }
        rb();
        if (!this.f6813ct) {
            for (int i = 1; i < this.f6814dm.size(); i++) {
                this.f6814dm.get(i - 1).n3(new y(this.f6814dm.get(i)));
            }
            f fVar = this.f6814dm.get(0);
            if (fVar != null) {
                fVar.k();
                return;
            }
            return;
        }
        Iterator<f> it = this.f6814dm.iterator();
        while (it.hasNext()) {
            it.next().k();
        }
    }

    @Override // cr.f
    @NonNull
    /* renamed from: kp */
    public xc xg(long j2) {
        return (xc) super.xg(j2);
    }

    public final void lc(@NonNull f fVar) {
        this.f6814dm.add(fVar);
        fVar.f6735ej = this;
    }

    @Override // cr.f
    @NonNull
    public f mt(@NonNull View view, boolean z2) {
        for (int i = 0; i < this.f6814dm.size(); i++) {
            this.f6814dm.get(i).mt(view, z2);
        }
        return super.mt(view, z2);
    }

    @Nullable
    public f nf(int i) {
        if (i >= 0 && i < this.f6814dm.size()) {
            return this.f6814dm.get(i);
        }
        return null;
    }

    @Override // cr.f
    @NonNull
    /* renamed from: o4 */
    public xc n3(@NonNull f.fb fbVar) {
        return (xc) super.n3(fbVar);
    }

    @Override // cr.f
    public void qn(View view) {
        super.qn(view);
        int size = this.f6814dm.size();
        for (int i = 0; i < size; i++) {
            this.f6814dm.get(i).qn(view);
        }
    }

    public int ra() {
        return this.f6814dm.size();
    }

    public final void rb() {
        n3 n3Var = new n3(this);
        Iterator<f> it = this.f6814dm.iterator();
        while (it.hasNext()) {
            it.next().n3(n3Var);
        }
        this.f6816o4 = this.f6814dm.size();
    }

    @Override // cr.f
    @NonNull
    /* renamed from: rs */
    public xc zn(@NonNull View view) {
        for (int i = 0; i < this.f6814dm.size(); i++) {
            this.f6814dm.get(i).zn(view);
        }
        return (xc) super.zn(view);
    }

    @Override // cr.f
    public void s(@NonNull p pVar) {
        if (x(pVar.f6778n3)) {
            Iterator<f> it = this.f6814dm.iterator();
            while (it.hasNext()) {
                f next = it.next();
                if (next.x(pVar.f6778n3)) {
                    next.s(pVar);
                    pVar.f6779zn.add(next);
                }
            }
        }
    }

    @Override // cr.f
    @NonNull
    /* renamed from: s8 */
    public xc oz(@NonNull View view) {
        for (int i = 0; i < this.f6814dm.size(); i++) {
            this.f6814dm.get(i).oz(view);
        }
        return (xc) super.oz(view);
    }

    @Override // cr.f
    public void u(fb fbVar) {
        super.u(fbVar);
        this.f6815eb |= 4;
        if (this.f6814dm != null) {
            for (int i = 0; i < this.f6814dm.size(); i++) {
                this.f6814dm.get(i).u(fbVar);
            }
        }
    }

    @Override // cr.f
    public void ut(View view) {
        super.ut(view);
        int size = this.f6814dm.size();
        for (int i = 0; i < size; i++) {
            this.f6814dm.get(i).ut(view);
        }
    }

    @Override // cr.f
    public void w(ViewGroup viewGroup, mt mtVar, mt mtVar2, ArrayList<p> arrayList, ArrayList<p> arrayList2) {
        long rz2 = rz();
        int size = this.f6814dm.size();
        for (int i = 0; i < size; i++) {
            f fVar = this.f6814dm.get(i);
            if (rz2 > 0 && (this.f6813ct || i == 0)) {
                long rz3 = fVar.rz();
                if (rz3 > 0) {
                    fVar.xg(rz3 + rz2);
                } else {
                    fVar.xg(rz2);
                }
            }
            fVar.w(viewGroup, mtVar, mtVar2, arrayList, arrayList2);
        }
    }

    @Override // cr.f
    /* renamed from: wz */
    public f clone() {
        xc xcVar = (xc) super.clone();
        xcVar.f6814dm = new ArrayList<>();
        int size = this.f6814dm.size();
        for (int i = 0; i < size; i++) {
            xcVar.lc(this.f6814dm.get(i).clone());
        }
        return xcVar;
    }

    @Override // cr.f
    public void y5(wz wzVar) {
        super.y5(wzVar);
        this.f6815eb |= 2;
        int size = this.f6814dm.size();
        for (int i = 0; i < size; i++) {
            this.f6814dm.get(i).y5(wzVar);
        }
    }

    @NonNull
    public xc yc(int i) {
        if (i != 0) {
            if (i == 1) {
                this.f6813ct = false;
            } else {
                throw new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: " + i);
            }
        } else {
            this.f6813ct = true;
        }
        return this;
    }

    @Override // cr.f
    @NonNull
    /* renamed from: yg */
    public xc jz(@Nullable TimeInterpolator timeInterpolator) {
        this.f6815eb |= 1;
        ArrayList<f> arrayList = this.f6814dm;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                this.f6814dm.get(i).jz(timeInterpolator);
            }
        }
        return (xc) super.jz(timeInterpolator);
    }
}
