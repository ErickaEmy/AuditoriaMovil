package androidx.navigation;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.activity.OnBackPressedDispatcher;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.v;
import androidx.navigation.c5;
import androidx.navigation.gv;
import androidx.navigation.s;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import rz.wz;
import y5.b;
import y5.co;
import y5.mt;
/* loaded from: classes.dex */
public class NavController {

    /* renamed from: a  reason: collision with root package name */
    public Parcelable[] f2678a;

    /* renamed from: c5  reason: collision with root package name */
    public co f2679c5;

    /* renamed from: fb  reason: collision with root package name */
    public boolean f2681fb;

    /* renamed from: gv  reason: collision with root package name */
    public v f2682gv;

    /* renamed from: i9  reason: collision with root package name */
    public lc.s f2683i9;

    /* renamed from: n3  reason: collision with root package name */
    public Activity f2684n3;

    /* renamed from: v  reason: collision with root package name */
    public Bundle f2688v;
    public final Context y;

    /* renamed from: zn  reason: collision with root package name */
    public fb f2691zn;

    /* renamed from: s  reason: collision with root package name */
    public final Deque<lc.fb> f2685s = new ArrayDeque();

    /* renamed from: f  reason: collision with root package name */
    public i9 f2680f = new i9();

    /* renamed from: t  reason: collision with root package name */
    public final CopyOnWriteArrayList<n3> f2686t = new CopyOnWriteArrayList<>();

    /* renamed from: tl  reason: collision with root package name */
    public final mt f2687tl = new androidx.lifecycle.a() { // from class: androidx.navigation.NavController.1
        @Override // androidx.lifecycle.a
        public void onStateChanged(@NonNull co coVar, @NonNull v.n3 n3Var) {
            NavController navController = NavController.this;
            if (navController.f2682gv != null) {
                for (lc.fb fbVar : navController.f2685s) {
                    fbVar.v(n3Var);
                }
            }
        }
    };

    /* renamed from: wz  reason: collision with root package name */
    public final gv.gv f2689wz = new y(false);

    /* renamed from: xc  reason: collision with root package name */
    public boolean f2690xc = true;

    /* loaded from: classes.dex */
    public interface n3 {
        void y(@NonNull NavController navController, @NonNull gv gvVar, @Nullable Bundle bundle);
    }

    /* loaded from: classes.dex */
    public class y extends gv.gv {
        public y(boolean z2) {
            super(z2);
        }

        @Override // gv.gv
        public void handleOnBackPressed() {
            NavController.this.mt();
        }
    }

    public NavController(@NonNull Context context) {
        this.y = context;
        while (true) {
            if (!(context instanceof ContextWrapper)) {
                break;
            } else if (context instanceof Activity) {
                this.f2684n3 = (Activity) context;
                break;
            } else {
                context = ((ContextWrapper) context).getBaseContext();
            }
        }
        i9 i9Var = this.f2680f;
        i9Var.y(new a(i9Var));
        this.f2680f.y(new androidx.navigation.y(this.y));
    }

    @Nullable
    public lc.fb a() {
        if (this.f2685s.isEmpty()) {
            return null;
        }
        return this.f2685s.getLast();
    }

    public void c(@NonNull v vVar, @Nullable Bundle bundle) {
        v vVar2 = this.f2682gv;
        if (vVar2 != null) {
            z(vVar2.f(), true);
        }
        this.f2682gv = vVar;
        p(bundle);
    }

    @NonNull
    public fb c5() {
        if (this.f2691zn == null) {
            this.f2691zn = new fb(this.y, this.f2680f);
        }
        return this.f2691zn;
    }

    public boolean co(int i, boolean z2) {
        if (z(i, z2) && y()) {
            return true;
        }
        return false;
    }

    public void d0(@NonNull co coVar) {
        if (coVar == this.f2679c5) {
            return;
        }
        this.f2679c5 = coVar;
        coVar.getLifecycle().y(this.f2687tl);
    }

    public boolean f(@Nullable Intent intent) {
        int[] iArr;
        Bundle bundle;
        gv.y wz2;
        gv x42;
        v vVar;
        if (intent == null) {
            return false;
        }
        Bundle extras = intent.getExtras();
        if (extras != null) {
            iArr = extras.getIntArray("android-support-nav:controller:deepLinkIds");
        } else {
            iArr = null;
        }
        Bundle bundle2 = new Bundle();
        if (extras != null) {
            bundle = extras.getBundle("android-support-nav:controller:deepLinkExtras");
        } else {
            bundle = null;
        }
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
        if ((iArr == null || iArr.length == 0) && intent.getData() != null && (wz2 = this.f2682gv.wz(new lc.c5(intent))) != null) {
            gv n32 = wz2.n3();
            int[] gv2 = n32.gv();
            bundle2.putAll(n32.zn(wz2.zn()));
            iArr = gv2;
        }
        if (iArr == null || iArr.length == 0 || gv(iArr) != null) {
            return false;
        }
        bundle2.putParcelable("android-support-nav:controller:deepLinkIntent", intent);
        int flags = intent.getFlags();
        int i = 268435456 & flags;
        if (i != 0 && (flags & 32768) == 0) {
            intent.addFlags(32768);
            wz.v(this.y).n3(intent).fb();
            Activity activity = this.f2684n3;
            if (activity != null) {
                activity.finish();
                this.f2684n3.overridePendingTransition(0, 0);
            }
            return true;
        } else if (i != 0) {
            if (!this.f2685s.isEmpty()) {
                z(this.f2682gv.f(), true);
            }
            int i5 = 0;
            while (i5 < iArr.length) {
                int i6 = i5 + 1;
                int i8 = iArr[i5];
                gv zn2 = zn(i8);
                if (zn2 != null) {
                    w(zn2, bundle2, new s.y().n3(0).zn(0).y(), null);
                    i5 = i6;
                } else {
                    throw new IllegalStateException("Deep Linking failed: destination " + gv.i9(this.y, i8) + " cannot be found from the current destination " + fb());
                }
            }
            return true;
        } else {
            v vVar2 = this.f2682gv;
            for (int i10 = 0; i10 < iArr.length; i10++) {
                int i11 = iArr[i10];
                if (i10 == 0) {
                    x42 = this.f2682gv;
                } else {
                    x42 = vVar2.x4(i11);
                }
                if (x42 != null) {
                    if (i10 != iArr.length - 1) {
                        while (true) {
                            vVar = (v) x42;
                            if (!(vVar.x4(vVar.n()) instanceof v)) {
                                break;
                            }
                            x42 = vVar.x4(vVar.n());
                        }
                        vVar2 = vVar;
                    } else {
                        w(x42, x42.zn(bundle2), new s.y().fb(this.f2682gv.f(), true).n3(0).zn(0).y(), null);
                    }
                } else {
                    throw new IllegalStateException("Deep Linking failed: destination " + gv.i9(this.y, i11) + " cannot be found in graph " + vVar2);
                }
            }
            this.f2681fb = true;
            return true;
        }
    }

    public void f3(int i, @Nullable Bundle bundle) {
        c(c5().zn(i), bundle);
    }

    @Nullable
    public gv fb() {
        lc.fb a2 = a();
        if (a2 != null) {
            return a2.n3();
        }
        return null;
    }

    public void fh(@NonNull OnBackPressedDispatcher onBackPressedDispatcher) {
        if (this.f2679c5 != null) {
            this.f2689wz.remove();
            onBackPressedDispatcher.n3(this.f2679c5, this.f2689wz);
            this.f2679c5.getLifecycle().zn(this.f2687tl);
            this.f2679c5.getLifecycle().y(this.f2687tl);
            return;
        }
        throw new IllegalStateException("You must call setLifecycleOwner() before calling setOnBackPressedDispatcher()");
    }

    @Nullable
    public final String gv(@NonNull int[] iArr) {
        v vVar;
        v vVar2 = this.f2682gv;
        int i = 0;
        while (true) {
            gv gvVar = null;
            if (i >= iArr.length) {
                return null;
            }
            int i5 = iArr[i];
            if (i == 0) {
                if (this.f2682gv.f() == i5) {
                    gvVar = this.f2682gv;
                }
            } else {
                gvVar = vVar2.x4(i5);
            }
            if (gvVar == null) {
                return gv.i9(this.y, i5);
            }
            if (i != iArr.length - 1) {
                while (true) {
                    vVar = (v) gvVar;
                    if (!(vVar.x4(vVar.n()) instanceof v)) {
                        break;
                    }
                    gvVar = vVar.x4(vVar.n());
                }
                vVar2 = vVar;
            }
            i++;
        }
    }

    public void i4(int i) {
        f3(i, null);
    }

    @NonNull
    public i9 i9() {
        return this.f2680f;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x000b, code lost:
        if (s() > 1) goto L5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void mg() {
        /*
            r3 = this;
            gv.gv r0 = r3.f2689wz
            boolean r1 = r3.f2690xc
            if (r1 == 0) goto Le
            int r1 = r3.s()
            r2 = 1
            if (r1 <= r2) goto Le
            goto Lf
        Le:
            r2 = 0
        Lf:
            r0.setEnabled(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavController.mg():void");
    }

    public boolean mt() {
        if (this.f2685s.isEmpty()) {
            return false;
        }
        return co(fb().f(), true);
    }

    public void n(@NonNull v vVar) {
        c(vVar, null);
    }

    public void n3(boolean z2) {
        this.f2690xc = z2;
        mg();
    }

    public final void p(@Nullable Bundle bundle) {
        Activity activity;
        ArrayList<String> stringArrayList;
        Bundle bundle2 = this.f2688v;
        if (bundle2 != null && (stringArrayList = bundle2.getStringArrayList("android-support-nav:controller:navigatorState:names")) != null) {
            Iterator<String> it = stringArrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                c5 v2 = this.f2680f.v(next);
                Bundle bundle3 = this.f2688v.getBundle(next);
                if (bundle3 != null) {
                    v2.zn(bundle3);
                }
            }
        }
        Parcelable[] parcelableArr = this.f2678a;
        if (parcelableArr != null) {
            for (Parcelable parcelable : parcelableArr) {
                NavBackStackEntryState navBackStackEntryState = (NavBackStackEntryState) parcelable;
                gv zn2 = zn(navBackStackEntryState.n3());
                if (zn2 != null) {
                    Bundle y2 = navBackStackEntryState.y();
                    if (y2 != null) {
                        y2.setClassLoader(this.y.getClassLoader());
                    }
                    this.f2685s.add(new lc.fb(this.y, zn2, y2, this.f2679c5, this.f2683i9, navBackStackEntryState.gv(), navBackStackEntryState.zn()));
                } else {
                    throw new IllegalStateException("Restoring the Navigation back stack failed: destination " + gv.i9(this.y, navBackStackEntryState.n3()) + " cannot be found from the current destination " + fb());
                }
            }
            mg();
            this.f2678a = null;
        }
        if (this.f2682gv != null && this.f2685s.isEmpty()) {
            if (this.f2681fb || (activity = this.f2684n3) == null || !f(activity.getIntent())) {
                w(this.f2682gv, bundle, null, null);
                return;
            }
            return;
        }
        y();
    }

    public void r(@Nullable Bundle bundle) {
        if (bundle == null) {
            return;
        }
        bundle.setClassLoader(this.y.getClassLoader());
        this.f2688v = bundle.getBundle("android-support-nav:controller:navigatorState");
        this.f2678a = bundle.getParcelableArray("android-support-nav:controller:backStack");
        this.f2681fb = bundle.getBoolean("android-support-nav:controller:deepLinkHandled");
    }

    public void rz(@NonNull b bVar) {
        if (this.f2683i9 == lc.s.el(bVar)) {
            return;
        }
        if (this.f2685s.isEmpty()) {
            this.f2683i9 = lc.s.el(bVar);
            return;
        }
        throw new IllegalStateException("ViewModelStore should be set before setGraph call");
    }

    public final int s() {
        int i = 0;
        for (lc.fb fbVar : this.f2685s) {
            if (!(fbVar.n3() instanceof v)) {
                i++;
            }
        }
        return i;
    }

    public void t(int i) {
        tl(i, null);
    }

    public void tl(int i, @Nullable Bundle bundle) {
        wz(i, bundle, null);
    }

    @NonNull
    public Deque<lc.fb> v() {
        return this.f2685s;
    }

    public final void w(@NonNull gv gvVar, @Nullable Bundle bundle, @Nullable s sVar, @Nullable c5.y yVar) {
        boolean z2;
        v n32;
        gv n33;
        boolean z3 = false;
        if (sVar != null && sVar.v() != -1) {
            z2 = z(sVar.v(), sVar.a());
        } else {
            z2 = false;
        }
        c5 v2 = this.f2680f.v(gvVar.t());
        Bundle zn2 = gvVar.zn(bundle);
        gv n34 = v2.n3(gvVar, zn2, sVar, yVar);
        if (n34 != null) {
            if (!(n34 instanceof lc.n3)) {
                while (!this.f2685s.isEmpty() && (this.f2685s.peekLast().n3() instanceof lc.n3) && z(this.f2685s.peekLast().n3().f(), true)) {
                }
            }
            ArrayDeque arrayDeque = new ArrayDeque();
            if (gvVar instanceof v) {
                v vVar = n34;
                while (true) {
                    v tl2 = vVar.tl();
                    if (tl2 != null) {
                        arrayDeque.addFirst(new lc.fb(this.y, tl2, zn2, this.f2679c5, this.f2683i9));
                        if (!this.f2685s.isEmpty() && this.f2685s.getLast().n3() == tl2) {
                            z(tl2.f(), true);
                        }
                    }
                    if (tl2 == null || tl2 == gvVar) {
                        break;
                    }
                    vVar = tl2;
                }
            }
            if (arrayDeque.isEmpty()) {
                n32 = n34;
            } else {
                n32 = ((lc.fb) arrayDeque.getFirst()).n3();
            }
            while (n32 != null && zn(n32.f()) == null) {
                n32 = n32.tl();
                if (n32 != null) {
                    arrayDeque.addFirst(new lc.fb(this.y, n32, zn2, this.f2679c5, this.f2683i9));
                }
            }
            if (arrayDeque.isEmpty()) {
                n33 = n34;
            } else {
                n33 = ((lc.fb) arrayDeque.getLast()).n3();
            }
            while (!this.f2685s.isEmpty() && (this.f2685s.getLast().n3() instanceof v) && ((v) this.f2685s.getLast().n3()).i4(n33.f(), false) == null && z(this.f2685s.getLast().n3().f(), true)) {
            }
            this.f2685s.addAll(arrayDeque);
            if (this.f2685s.isEmpty() || this.f2685s.getFirst().n3() != this.f2682gv) {
                this.f2685s.addFirst(new lc.fb(this.y, this.f2682gv, zn2, this.f2679c5, this.f2683i9));
            }
            this.f2685s.add(new lc.fb(this.y, n34, n34.zn(zn2), this.f2679c5, this.f2683i9));
        } else if (sVar != null && sVar.fb()) {
            lc.fb peekLast = this.f2685s.peekLast();
            if (peekLast != null) {
                peekLast.a(zn2);
            }
            z3 = true;
        }
        mg();
        if (z2 || n34 != null || z3) {
            y();
        }
    }

    public void wz(int i, @Nullable Bundle bundle, @Nullable s sVar) {
        xc(i, bundle, sVar, null);
    }

    @Nullable
    public Bundle x4() {
        Bundle bundle;
        ArrayList<String> arrayList = new ArrayList<>();
        Bundle bundle2 = new Bundle();
        for (Map.Entry<String, c5<? extends gv>> entry : this.f2680f.a().entrySet()) {
            String key = entry.getKey();
            Bundle gv2 = entry.getValue().gv();
            if (gv2 != null) {
                arrayList.add(key);
                bundle2.putBundle(key, gv2);
            }
        }
        if (!arrayList.isEmpty()) {
            bundle = new Bundle();
            bundle2.putStringArrayList("android-support-nav:controller:navigatorState:names", arrayList);
            bundle.putBundle("android-support-nav:controller:navigatorState", bundle2);
        } else {
            bundle = null;
        }
        if (!this.f2685s.isEmpty()) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            Parcelable[] parcelableArr = new Parcelable[this.f2685s.size()];
            int i = 0;
            for (lc.fb fbVar : this.f2685s) {
                parcelableArr[i] = new NavBackStackEntryState(fbVar);
                i++;
            }
            bundle.putParcelableArray("android-support-nav:controller:backStack", parcelableArr);
        }
        if (this.f2681fb) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android-support-nav:controller:deepLinkHandled", this.f2681fb);
        }
        return bundle;
    }

    public void xc(int i, @Nullable Bundle bundle, @Nullable s sVar, @Nullable c5.y yVar) {
        gv n32;
        int i5;
        if (this.f2685s.isEmpty()) {
            n32 = this.f2682gv;
        } else {
            n32 = this.f2685s.getLast().n3();
        }
        if (n32 != null) {
            lc.zn v2 = n32.v(i);
            Bundle bundle2 = null;
            if (v2 != null) {
                if (sVar == null) {
                    sVar = v2.zn();
                }
                i5 = v2.n3();
                Bundle y2 = v2.y();
                if (y2 != null) {
                    bundle2 = new Bundle();
                    bundle2.putAll(y2);
                }
            } else {
                i5 = i;
            }
            if (bundle != null) {
                if (bundle2 == null) {
                    bundle2 = new Bundle();
                }
                bundle2.putAll(bundle);
            }
            if (i5 == 0 && sVar != null && sVar.v() != -1) {
                co(sVar.v(), sVar.a());
                return;
            } else if (i5 != 0) {
                gv zn2 = zn(i5);
                if (zn2 == null) {
                    String i92 = gv.i9(this.y, i5);
                    if (v2 != null) {
                        throw new IllegalArgumentException("Navigation destination " + i92 + " referenced from action " + gv.i9(this.y, i) + " cannot be found from the current destination " + n32);
                    }
                    throw new IllegalArgumentException("Navigation action/destination " + i92 + " cannot be found from the current destination " + n32);
                }
                w(zn2, bundle2, sVar, yVar);
                return;
            } else {
                throw new IllegalArgumentException("Destination id == 0 can only be used in conjunction with a valid navOptions.popUpTo");
            }
        }
        throw new IllegalStateException("no current navigation node");
    }

    public final boolean y() {
        gv gvVar;
        while (!this.f2685s.isEmpty() && (this.f2685s.peekLast().n3() instanceof v) && z(this.f2685s.peekLast().n3().f(), true)) {
        }
        if (!this.f2685s.isEmpty()) {
            gv n32 = this.f2685s.peekLast().n3();
            if (n32 instanceof lc.n3) {
                Iterator<lc.fb> descendingIterator = this.f2685s.descendingIterator();
                while (descendingIterator.hasNext()) {
                    gvVar = descendingIterator.next().n3();
                    if (!(gvVar instanceof v) && !(gvVar instanceof lc.n3)) {
                        break;
                    }
                }
            }
            gvVar = null;
            HashMap hashMap = new HashMap();
            Iterator<lc.fb> descendingIterator2 = this.f2685s.descendingIterator();
            while (descendingIterator2.hasNext()) {
                lc.fb next = descendingIterator2.next();
                v.zn zn2 = next.zn();
                gv n33 = next.n3();
                if (n32 != null && n33.f() == n32.f()) {
                    v.zn znVar = v.zn.RESUMED;
                    if (zn2 != znVar) {
                        hashMap.put(next, znVar);
                    }
                    n32 = n32.tl();
                } else if (gvVar != null && n33.f() == gvVar.f()) {
                    if (zn2 == v.zn.RESUMED) {
                        next.c5(v.zn.STARTED);
                    } else {
                        v.zn znVar2 = v.zn.STARTED;
                        if (zn2 != znVar2) {
                            hashMap.put(next, znVar2);
                        }
                    }
                    gvVar = gvVar.tl();
                } else {
                    next.c5(v.zn.CREATED);
                }
            }
            for (lc.fb fbVar : this.f2685s) {
                v.zn znVar3 = (v.zn) hashMap.get(fbVar);
                if (znVar3 != null) {
                    fbVar.c5(znVar3);
                } else {
                    fbVar.i9();
                }
            }
            lc.fb peekLast = this.f2685s.peekLast();
            Iterator<n3> it = this.f2686t.iterator();
            while (it.hasNext()) {
                it.next().y(this, peekLast.n3(), peekLast.y());
            }
            return true;
        }
        return false;
    }

    public boolean z(int i, boolean z2) {
        boolean z3 = false;
        if (this.f2685s.isEmpty()) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<lc.fb> descendingIterator = this.f2685s.descendingIterator();
        while (descendingIterator.hasNext()) {
            gv n32 = descendingIterator.next().n3();
            c5 v2 = this.f2680f.v(n32.t());
            if (z2 || n32.f() != i) {
                arrayList.add(v2);
            }
            if (n32.f() == i) {
                Iterator it = arrayList.iterator();
                while (it.hasNext() && ((c5) it.next()).v()) {
                    lc.fb removeLast = this.f2685s.removeLast();
                    if (removeLast.getLifecycle().n3().y(v.zn.CREATED)) {
                        removeLast.c5(v.zn.DESTROYED);
                    }
                    lc.s sVar = this.f2683i9;
                    if (sVar != null) {
                        sVar.st(removeLast.f10292t);
                    }
                    z3 = true;
                }
                mg();
                return z3;
            }
        }
        gv.i9(this.y, i);
        return false;
    }

    public gv zn(int i) {
        v n32;
        v tl2;
        v vVar = this.f2682gv;
        if (vVar == null) {
            return null;
        }
        if (vVar.f() == i) {
            return this.f2682gv;
        }
        if (this.f2685s.isEmpty()) {
            n32 = this.f2682gv;
        } else {
            n32 = this.f2685s.getLast().n3();
        }
        if (n32 instanceof v) {
            tl2 = n32;
        } else {
            tl2 = n32.tl();
        }
        return tl2.x4(i);
    }
}
