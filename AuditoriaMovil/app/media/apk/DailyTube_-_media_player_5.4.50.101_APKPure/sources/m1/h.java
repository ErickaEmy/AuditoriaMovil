package m1;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public final class h extends y {

    /* renamed from: c  reason: collision with root package name */
    public final Object[] f10777c;

    /* renamed from: co  reason: collision with root package name */
    public final int f10778co;

    /* renamed from: d0  reason: collision with root package name */
    public final HashMap<Object, Integer> f10779d0;

    /* renamed from: f3  reason: collision with root package name */
    public final int[] f10780f3;

    /* renamed from: n  reason: collision with root package name */
    public final hy[] f10781n;

    /* renamed from: r  reason: collision with root package name */
    public final int[] f10782r;

    /* renamed from: z  reason: collision with root package name */
    public final int f10783z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(Collection<? extends oa> collection, af.u uVar) {
        super(false, uVar);
        int i = 0;
        int size = collection.size();
        this.f10782r = new int[size];
        this.f10780f3 = new int[size];
        this.f10781n = new hy[size];
        this.f10777c = new Object[size];
        this.f10779d0 = new HashMap<>();
        int i5 = 0;
        int i6 = 0;
        for (oa oaVar : collection) {
            this.f10781n[i6] = oaVar.n3();
            this.f10780f3[i6] = i;
            this.f10782r[i6] = i5;
            i += this.f10781n[i6].z();
            i5 += this.f10781n[i6].tl();
            this.f10777c[i6] = oaVar.y();
            this.f10779d0.put(this.f10777c[i6], Integer.valueOf(i6));
            i6++;
        }
        this.f10778co = i;
        this.f10783z = i5;
    }

    @Override // m1.y
    public hy ej(int i) {
        return this.f10781n[i];
    }

    @Override // m1.y
    public int f3(int i) {
        return v5.j5.s(this.f10782r, i + 1, false, false);
    }

    @Override // m1.y
    public Object fh(int i) {
        return this.f10777c[i];
    }

    @Override // m1.y
    public int i4(Object obj) {
        Integer num = this.f10779d0.get(obj);
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    @Override // m1.y
    public int mg(int i) {
        return this.f10782r[i];
    }

    @Override // m1.y
    public int n(int i) {
        return v5.j5.s(this.f10780f3, i + 1, false, false);
    }

    @Override // m1.y
    public int ta(int i) {
        return this.f10780f3[i];
    }

    @Override // m1.hy
    public int tl() {
        return this.f10783z;
    }

    public List<hy> ud() {
        return Arrays.asList(this.f10781n);
    }

    @Override // m1.hy
    public int z() {
        return this.f10778co;
    }
}
