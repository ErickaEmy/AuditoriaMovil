package ft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import v5.j5;
/* loaded from: classes.dex */
public final class f implements qh.c5 {

    /* renamed from: fb  reason: collision with root package name */
    public final long[] f8243fb;

    /* renamed from: v  reason: collision with root package name */
    public final long[] f8244v;
    public final List<v> y;

    public f(List<v> list) {
        this.y = Collections.unmodifiableList(new ArrayList(list));
        this.f8244v = new long[list.size() * 2];
        for (int i = 0; i < list.size(); i++) {
            v vVar = list.get(i);
            int i5 = i * 2;
            long[] jArr = this.f8244v;
            jArr[i5] = vVar.f8263n3;
            jArr[i5 + 1] = vVar.f8264zn;
        }
        long[] jArr2 = this.f8244v;
        long[] copyOf = Arrays.copyOf(jArr2, jArr2.length);
        this.f8243fb = copyOf;
        Arrays.sort(copyOf);
    }

    public static /* synthetic */ int a(v vVar, v vVar2) {
        return Long.compare(vVar.f8263n3, vVar2.f8263n3);
    }

    @Override // qh.c5
    public int gv() {
        return this.f8243fb.length;
    }

    @Override // qh.c5
    public List<qh.n3> n3(long j2) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < this.y.size(); i++) {
            long[] jArr = this.f8244v;
            int i5 = i * 2;
            if (jArr[i5] <= j2 && j2 < jArr[i5 + 1]) {
                v vVar = this.y.get(i);
                qh.n3 n3Var = vVar.y;
                if (n3Var.f12867f == -3.4028235E38f) {
                    arrayList2.add(vVar);
                } else {
                    arrayList.add(n3Var);
                }
            }
        }
        Collections.sort(arrayList2, new Comparator() { // from class: ft.i9
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int a2;
                a2 = f.a((v) obj, (v) obj2);
                return a2;
            }
        });
        for (int i6 = 0; i6 < arrayList2.size(); i6++) {
            arrayList.add(((v) arrayList2.get(i6)).y.n3().s((-1) - i6, 1).y());
        }
        return arrayList;
    }

    @Override // qh.c5
    public int y(long j2) {
        int v2 = j5.v(this.f8243fb, j2, false, false);
        if (v2 >= this.f8243fb.length) {
            return -1;
        }
        return v2;
    }

    @Override // qh.c5
    public long zn(int i) {
        boolean z2;
        boolean z3 = false;
        if (i >= 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        v5.y.y(z2);
        if (i < this.f8243fb.length) {
            z3 = true;
        }
        v5.y.y(z3);
        return this.f8243fb[i];
    }
}
