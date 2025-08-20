package gq;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import l.co;
import l.f;
import l.wz;
import l.x4;
/* loaded from: classes.dex */
public class fb extends co {

    /* renamed from: i9  reason: collision with root package name */
    public static final String f8357i9 = f.a("WorkContinuationImpl");

    /* renamed from: a  reason: collision with root package name */
    public final List<String> f8358a;

    /* renamed from: c5  reason: collision with root package name */
    public wz f8359c5;

    /* renamed from: fb  reason: collision with root package name */
    public final List<fb> f8360fb;

    /* renamed from: gv  reason: collision with root package name */
    public final List<? extends x4> f8361gv;

    /* renamed from: n3  reason: collision with root package name */
    public final String f8362n3;

    /* renamed from: s  reason: collision with root package name */
    public boolean f8363s;

    /* renamed from: v  reason: collision with root package name */
    public final List<String> f8364v;
    public final c5 y;

    /* renamed from: zn  reason: collision with root package name */
    public final l.v f8365zn;

    public fb(@NonNull c5 c5Var, @NonNull List<? extends x4> list) {
        this(c5Var, null, l.v.KEEP, list, null);
    }

    public static boolean c5(@NonNull fb fbVar, @NonNull Set<String> set) {
        set.addAll(fbVar.zn());
        Set<String> t2 = t(fbVar);
        for (String str : set) {
            if (t2.contains(str)) {
                return true;
            }
        }
        List<fb> v2 = fbVar.v();
        if (v2 != null && !v2.isEmpty()) {
            for (fb fbVar2 : v2) {
                if (c5(fbVar2, set)) {
                    return true;
                }
            }
        }
        set.removeAll(fbVar.zn());
        return false;
    }

    @NonNull
    public static Set<String> t(fb fbVar) {
        HashSet hashSet = new HashSet();
        List<fb> v2 = fbVar.v();
        if (v2 != null && !v2.isEmpty()) {
            for (fb fbVar2 : v2) {
                hashSet.addAll(fbVar2.zn());
            }
        }
        return hashSet;
    }

    @NonNull
    public List<? extends x4> a() {
        return this.f8361gv;
    }

    public void f() {
        this.f8363s = true;
    }

    @NonNull
    public c5 fb() {
        return this.y;
    }

    @Nullable
    public String gv() {
        return this.f8362n3;
    }

    public boolean i9() {
        return this.f8363s;
    }

    public l.v n3() {
        return this.f8365zn;
    }

    public boolean s() {
        return c5(this, new HashSet());
    }

    public List<fb> v() {
        return this.f8360fb;
    }

    @NonNull
    public wz y() {
        if (!this.f8363s) {
            cs.n3 n3Var = new cs.n3(this);
            this.y.z().n3(n3Var);
            this.f8359c5 = n3Var.gv();
        } else {
            f.zn().s(f8357i9, String.format("Already enqueued work ids (%s)", TextUtils.join(", ", this.f8364v)), new Throwable[0]);
        }
        return this.f8359c5;
    }

    @NonNull
    public List<String> zn() {
        return this.f8364v;
    }

    public fb(@NonNull c5 c5Var, @Nullable String str, @NonNull l.v vVar, @NonNull List<? extends x4> list) {
        this(c5Var, str, vVar, list, null);
    }

    public fb(@NonNull c5 c5Var, @Nullable String str, @NonNull l.v vVar, @NonNull List<? extends x4> list, @Nullable List<fb> list2) {
        this.y = c5Var;
        this.f8362n3 = str;
        this.f8365zn = vVar;
        this.f8361gv = list;
        this.f8360fb = list2;
        this.f8364v = new ArrayList(list.size());
        this.f8358a = new ArrayList();
        if (list2 != null) {
            for (fb fbVar : list2) {
                this.f8358a.addAll(fbVar.f8358a);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            String y = list.get(i).y();
            this.f8364v.add(y);
            this.f8358a.add(y);
        }
    }
}
