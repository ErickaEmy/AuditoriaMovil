package androidx.navigation;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class gv {

    /* renamed from: co  reason: collision with root package name */
    public static final HashMap<String, Class<?>> f2801co = new HashMap<>();

    /* renamed from: f  reason: collision with root package name */
    public CharSequence f2802f;

    /* renamed from: fb  reason: collision with root package name */
    public int f2803fb;

    /* renamed from: p  reason: collision with root package name */
    public HashMap<String, n3> f2804p;

    /* renamed from: s  reason: collision with root package name */
    public String f2805s;

    /* renamed from: t  reason: collision with root package name */
    public ArrayList<zn> f2806t;

    /* renamed from: v  reason: collision with root package name */
    public v f2807v;

    /* renamed from: w  reason: collision with root package name */
    public z.c5<lc.zn> f2808w;
    public final String y;

    /* loaded from: classes.dex */
    public static class y implements Comparable<y> {

        /* renamed from: f  reason: collision with root package name */
        public final int f2809f;

        /* renamed from: fb  reason: collision with root package name */
        public final boolean f2810fb;

        /* renamed from: s  reason: collision with root package name */
        public final boolean f2811s;
        @Nullable

        /* renamed from: v  reason: collision with root package name */
        public final Bundle f2812v;
        @NonNull
        public final gv y;

        public y(@NonNull gv gvVar, @Nullable Bundle bundle, boolean z2, boolean z3, int i) {
            this.y = gvVar;
            this.f2812v = bundle;
            this.f2810fb = z2;
            this.f2811s = z3;
            this.f2809f = i;
        }

        @NonNull
        public gv n3() {
            return this.y;
        }

        @Override // java.lang.Comparable
        /* renamed from: y */
        public int compareTo(@NonNull y yVar) {
            boolean z2 = this.f2810fb;
            if (z2 && !yVar.f2810fb) {
                return 1;
            }
            if (!z2 && yVar.f2810fb) {
                return -1;
            }
            Bundle bundle = this.f2812v;
            if (bundle != null && yVar.f2812v == null) {
                return 1;
            }
            if (bundle == null && yVar.f2812v != null) {
                return -1;
            }
            if (bundle != null) {
                int size = bundle.size() - yVar.f2812v.size();
                if (size > 0) {
                    return 1;
                }
                if (size < 0) {
                    return -1;
                }
            }
            boolean z3 = this.f2811s;
            if (z3 && !yVar.f2811s) {
                return 1;
            }
            if (!z3 && yVar.f2811s) {
                return -1;
            }
            return this.f2809f - yVar.f2809f;
        }

        @Nullable
        public Bundle zn() {
            return this.f2812v;
        }
    }

    public gv(@NonNull c5<? extends gv> c5Var) {
        this(i9.zn(c5Var.getClass()));
    }

    @NonNull
    public static String i9(@NonNull Context context, int i) {
        if (i <= 16777215) {
            return Integer.toString(i);
        }
        try {
            return context.getResources().getResourceName(i);
        } catch (Resources.NotFoundException unused) {
            return Integer.toString(i);
        }
    }

    @NonNull
    public String c5() {
        if (this.f2805s == null) {
            this.f2805s = Integer.toString(this.f2803fb);
        }
        return this.f2805s;
    }

    public final void co(v vVar) {
        this.f2807v = vVar;
    }

    public final int f() {
        return this.f2803fb;
    }

    @NonNull
    public final Map<String, n3> fb() {
        HashMap<String, n3> hashMap = this.f2804p;
        if (hashMap == null) {
            return Collections.emptyMap();
        }
        return Collections.unmodifiableMap(hashMap);
    }

    @NonNull
    public int[] gv() {
        ArrayDeque arrayDeque = new ArrayDeque();
        gv gvVar = this;
        while (true) {
            v tl2 = gvVar.tl();
            if (tl2 == null || tl2.n() != gvVar.f()) {
                arrayDeque.addFirst(gvVar);
            }
            if (tl2 == null) {
                break;
            }
            gvVar = tl2;
        }
        int[] iArr = new int[arrayDeque.size()];
        Iterator it = arrayDeque.iterator();
        int i = 0;
        while (it.hasNext()) {
            iArr[i] = ((gv) it.next()).f();
            i++;
        }
        return iArr;
    }

    public final void mt(@Nullable CharSequence charSequence) {
        this.f2802f = charSequence;
    }

    public final void n3(@NonNull zn znVar) {
        if (this.f2806t == null) {
            this.f2806t = new ArrayList<>();
        }
        this.f2806t.add(znVar);
    }

    public final void p(int i) {
        this.f2803fb = i;
        this.f2805s = null;
    }

    @NonNull
    public final String t() {
        return this.y;
    }

    @Nullable
    public final v tl() {
        return this.f2807v;
    }

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("(");
        String str = this.f2805s;
        if (str == null) {
            sb.append("0x");
            sb.append(Integer.toHexString(this.f2803fb));
        } else {
            sb.append(str);
        }
        sb.append(")");
        if (this.f2802f != null) {
            sb.append(" label=");
            sb.append(this.f2802f);
        }
        return sb.toString();
    }

    @Nullable
    public final lc.zn v(int i) {
        lc.zn fb2;
        z.c5<lc.zn> c5Var = this.f2808w;
        if (c5Var == null) {
            fb2 = null;
        } else {
            fb2 = c5Var.fb(i);
        }
        if (fb2 != null) {
            return fb2;
        }
        if (tl() == null) {
            return null;
        }
        return tl().v(i);
    }

    public final void w(int i, @NonNull lc.zn znVar) {
        if (z()) {
            if (i != 0) {
                if (this.f2808w == null) {
                    this.f2808w = new z.c5<>();
                }
                this.f2808w.f(i, znVar);
                return;
            }
            throw new IllegalArgumentException("Cannot have an action with actionId 0");
        }
        throw new UnsupportedOperationException("Cannot add action " + i + " to " + this + " as it does not support actions, indicating that it is a terminal destination in your navigation graph and will never trigger actions.");
    }

    @Nullable
    public y wz(@NonNull lc.c5 c5Var) {
        Bundle bundle;
        boolean z2;
        int i;
        ArrayList<zn> arrayList = this.f2806t;
        if (arrayList == null) {
            return null;
        }
        Iterator<zn> it = arrayList.iterator();
        y yVar = null;
        while (it.hasNext()) {
            zn next = it.next();
            Uri zn2 = c5Var.zn();
            if (zn2 != null) {
                bundle = next.zn(zn2, fb());
            } else {
                bundle = null;
            }
            String y2 = c5Var.y();
            if (y2 != null && y2.equals(next.n3())) {
                z2 = true;
            } else {
                z2 = false;
            }
            String n32 = c5Var.n3();
            if (n32 != null) {
                i = next.gv(n32);
            } else {
                i = -1;
            }
            if (bundle != null || z2 || i > -1) {
                y yVar2 = new y(this, bundle, next.v(), z2, i);
                if (yVar == null || yVar2.compareTo(yVar) > 0) {
                    yVar = yVar2;
                }
            }
        }
        return yVar;
    }

    public void xc(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, androidx.navigation.common.R$styleable.f2715d0);
        p(obtainAttributes.getResourceId(androidx.navigation.common.R$styleable.f2728rz, 0));
        this.f2805s = i9(context, this.f2803fb);
        mt(obtainAttributes.getText(androidx.navigation.common.R$styleable.f2719fh));
        obtainAttributes.recycle();
    }

    public final void y(@NonNull String str, @NonNull n3 n3Var) {
        if (this.f2804p == null) {
            this.f2804p = new HashMap<>();
        }
        this.f2804p.put(str, n3Var);
    }

    public boolean z() {
        return true;
    }

    @Nullable
    public Bundle zn(@Nullable Bundle bundle) {
        HashMap<String, n3> hashMap;
        if (bundle == null && ((hashMap = this.f2804p) == null || hashMap.isEmpty())) {
            return null;
        }
        Bundle bundle2 = new Bundle();
        HashMap<String, n3> hashMap2 = this.f2804p;
        if (hashMap2 != null) {
            for (Map.Entry<String, n3> entry : hashMap2.entrySet()) {
                entry.getValue().zn(entry.getKey(), bundle2);
            }
        }
        if (bundle != null) {
            bundle2.putAll(bundle);
            HashMap<String, n3> hashMap3 = this.f2804p;
            if (hashMap3 != null) {
                for (Map.Entry<String, n3> entry2 : hashMap3.entrySet()) {
                    if (!entry2.getValue().gv(entry2.getKey(), bundle2)) {
                        throw new IllegalArgumentException("Wrong argument type for '" + entry2.getKey() + "' in argument bundle. " + entry2.getValue().y().zn() + " expected.");
                    }
                }
            }
        }
        return bundle2;
    }

    public gv(@NonNull String str) {
        this.y = str;
    }
}
