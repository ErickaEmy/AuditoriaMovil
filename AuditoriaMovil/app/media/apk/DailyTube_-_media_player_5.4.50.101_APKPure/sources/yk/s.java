package yk;

import android.graphics.Rect;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import z.c5;
/* loaded from: classes.dex */
public class s {

    /* renamed from: a  reason: collision with root package name */
    public List<ne.s> f15397a;

    /* renamed from: c5  reason: collision with root package name */
    public List<nd.v> f15398c5;

    /* renamed from: f  reason: collision with root package name */
    public float f15399f;

    /* renamed from: fb  reason: collision with root package name */
    public c5<ne.gv> f15400fb;

    /* renamed from: gv  reason: collision with root package name */
    public Map<String, ta> f15401gv;

    /* renamed from: i9  reason: collision with root package name */
    public Rect f15402i9;

    /* renamed from: s  reason: collision with root package name */
    public z.v<nd.v> f15404s;

    /* renamed from: t  reason: collision with root package name */
    public float f15405t;

    /* renamed from: tl  reason: collision with root package name */
    public float f15406tl;

    /* renamed from: v  reason: collision with root package name */
    public Map<String, ne.zn> f15407v;

    /* renamed from: wz  reason: collision with root package name */
    public boolean f15408wz;

    /* renamed from: zn  reason: collision with root package name */
    public Map<String, List<nd.v>> f15410zn;
    public final yt y = new yt();

    /* renamed from: n3  reason: collision with root package name */
    public final HashSet<String> f15403n3 = new HashSet<>();

    /* renamed from: xc  reason: collision with root package name */
    public int f15409xc = 0;

    public float a() {
        return this.f15405t;
    }

    public float c5() {
        return this.f15406tl;
    }

    public void co(Rect rect, float f4, float f6, float f9, List<nd.v> list, z.v<nd.v> vVar, Map<String, List<nd.v>> map, Map<String, ta> map2, c5<ne.gv> c5Var, Map<String, ne.zn> map3, List<ne.s> list2) {
        this.f15402i9 = rect;
        this.f15399f = f4;
        this.f15405t = f6;
        this.f15406tl = f9;
        this.f15398c5 = list;
        this.f15404s = vVar;
        this.f15410zn = map;
        this.f15401gv = map2;
        this.f15400fb = c5Var;
        this.f15407v = map3;
        this.f15397a = list2;
    }

    public List<nd.v> f() {
        return this.f15398c5;
    }

    public Map<String, ne.zn> fb() {
        return this.f15407v;
    }

    public float gv() {
        return (v() / this.f15406tl) * 1000.0f;
    }

    public Map<String, ta> i9() {
        return this.f15401gv;
    }

    public void mt(int i) {
        this.f15409xc += i;
    }

    public Rect n3() {
        return this.f15402i9;
    }

    public boolean p() {
        return this.f15408wz;
    }

    public void r(boolean z2) {
        this.f15408wz = z2;
    }

    public float s(float f4) {
        return br.fb.c5(this.f15399f, this.f15405t, f4);
    }

    @Nullable
    public ne.s t(String str) {
        int size = this.f15397a.size();
        for (int i = 0; i < size; i++) {
            ne.s sVar = this.f15397a.get(i);
            if (sVar.y(str)) {
                return sVar;
            }
        }
        return null;
    }

    public int tl() {
        return this.f15409xc;
    }

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder("LottieComposition:\n");
        for (nd.v vVar : this.f15398c5) {
            sb.append(vVar.n("\t"));
        }
        return sb.toString();
    }

    public float v() {
        return this.f15405t - this.f15399f;
    }

    public float w() {
        return this.f15399f;
    }

    public yt wz() {
        return this.y;
    }

    public void x4(boolean z2) {
        this.y.n3(z2);
    }

    @Nullable
    public List<nd.v> xc(String str) {
        return this.f15410zn.get(str);
    }

    public void y(String str) {
        br.gv.zn(str);
        this.f15403n3.add(str);
    }

    public nd.v z(long j2) {
        return this.f15404s.s(j2);
    }

    public c5<ne.gv> zn() {
        return this.f15400fb;
    }
}
