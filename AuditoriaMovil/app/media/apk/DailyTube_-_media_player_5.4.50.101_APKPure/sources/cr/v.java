package cr;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransitionImpl;
import b.a;
import cr.f;
import java.util.ArrayList;
import java.util.List;
@SuppressLint({"RestrictedApi"})
/* loaded from: classes.dex */
public class v extends FragmentTransitionImpl {

    /* loaded from: classes.dex */
    public class a extends f.a {
        public final /* synthetic */ Rect y;

        public a(Rect rect) {
            this.y = rect;
        }
    }

    /* loaded from: classes.dex */
    public class gv implements a.n3 {
        public final /* synthetic */ f y;

        public gv(f fVar) {
            this.y = fVar;
        }

        @Override // b.a.n3
        public void onCancel() {
            this.y.cancel();
        }
    }

    /* loaded from: classes.dex */
    public class y extends f.a {
        public final /* synthetic */ Rect y;

        public y(Rect rect) {
            this.y = rect;
        }
    }

    /* loaded from: classes.dex */
    public class zn extends t {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ArrayList f6805a;

        /* renamed from: gv  reason: collision with root package name */
        public final /* synthetic */ ArrayList f6807gv;

        /* renamed from: n3  reason: collision with root package name */
        public final /* synthetic */ ArrayList f6808n3;

        /* renamed from: v  reason: collision with root package name */
        public final /* synthetic */ Object f6809v;
        public final /* synthetic */ Object y;

        /* renamed from: zn  reason: collision with root package name */
        public final /* synthetic */ Object f6810zn;

        public zn(Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2, Object obj3, ArrayList arrayList3) {
            this.y = obj;
            this.f6808n3 = arrayList;
            this.f6810zn = obj2;
            this.f6807gv = arrayList2;
            this.f6809v = obj3;
            this.f6805a = arrayList3;
        }

        @Override // cr.t, cr.f.fb
        public void gv(@NonNull f fVar) {
            Object obj = this.y;
            if (obj != null) {
                v.this.replaceTargets(obj, this.f6808n3, null);
            }
            Object obj2 = this.f6810zn;
            if (obj2 != null) {
                v.this.replaceTargets(obj2, this.f6807gv, null);
            }
            Object obj3 = this.f6809v;
            if (obj3 != null) {
                v.this.replaceTargets(obj3, this.f6805a, null);
            }
        }

        @Override // cr.f.fb
        public void zn(@NonNull f fVar) {
            fVar.j(this);
        }
    }

    public static boolean y(f fVar) {
        if (FragmentTransitionImpl.isNullOrEmpty(fVar.mg()) && FragmentTransitionImpl.isNullOrEmpty(fVar.ta()) && FragmentTransitionImpl.isNullOrEmpty(fVar.d())) {
            return false;
        }
        return true;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void addTarget(Object obj, View view) {
        if (obj != null) {
            ((f) obj).zn(view);
        }
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void addTargets(Object obj, ArrayList<View> arrayList) {
        f fVar = (f) obj;
        if (fVar == null) {
            return;
        }
        int i = 0;
        if (fVar instanceof xc) {
            xc xcVar = (xc) fVar;
            int ra2 = xcVar.ra();
            while (i < ra2) {
                addTargets(xcVar.nf(i), arrayList);
                i++;
            }
        } else if (!y(fVar) && FragmentTransitionImpl.isNullOrEmpty(fVar.z6())) {
            int size = arrayList.size();
            while (i < size) {
                fVar.zn(arrayList.get(i));
                i++;
            }
        }
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void beginDelayedTransition(ViewGroup viewGroup, Object obj) {
        tl.n3(viewGroup, (f) obj);
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public boolean canHandle(Object obj) {
        return obj instanceof f;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public Object cloneTransition(Object obj) {
        if (obj != null) {
            return ((f) obj).clone();
        }
        return null;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public Object mergeTransitionsInSequence(Object obj, Object obj2, Object obj3) {
        f fVar = (f) obj;
        f fVar2 = (f) obj2;
        f fVar3 = (f) obj3;
        if (fVar != null && fVar2 != null) {
            fVar = new xc().eb(fVar).eb(fVar2).yc(1);
        } else if (fVar == null) {
            if (fVar2 != null) {
                fVar = fVar2;
            } else {
                fVar = null;
            }
        }
        if (fVar3 != null) {
            xc xcVar = new xc();
            if (fVar != null) {
                xcVar.eb(fVar);
            }
            xcVar.eb(fVar3);
            return xcVar;
        }
        return fVar;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public Object mergeTransitionsTogether(Object obj, Object obj2, Object obj3) {
        xc xcVar = new xc();
        if (obj != null) {
            xcVar.eb((f) obj);
        }
        if (obj2 != null) {
            xcVar.eb((f) obj2);
        }
        if (obj3 != null) {
            xcVar.eb((f) obj3);
        }
        return xcVar;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void removeTarget(Object obj, View view) {
        if (obj != null) {
            ((f) obj).oz(view);
        }
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void replaceTargets(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        int size;
        f fVar = (f) obj;
        int i = 0;
        if (fVar instanceof xc) {
            xc xcVar = (xc) fVar;
            int ra2 = xcVar.ra();
            while (i < ra2) {
                replaceTargets(xcVar.nf(i), arrayList, arrayList2);
                i++;
            }
        } else if (!y(fVar)) {
            List<View> z62 = fVar.z6();
            if (z62.size() == arrayList.size() && z62.containsAll(arrayList)) {
                if (arrayList2 == null) {
                    size = 0;
                } else {
                    size = arrayList2.size();
                }
                while (i < size) {
                    fVar.zn(arrayList2.get(i));
                    i++;
                }
                for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                    fVar.oz(arrayList.get(size2));
                }
            }
        }
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void scheduleHideFragmentView(Object obj, View view, ArrayList<View> arrayList) {
        ((f) obj).n3(new n3(view, arrayList));
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void scheduleRemoveTargets(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3) {
        ((f) obj).n3(new zn(obj2, arrayList, obj3, arrayList2, obj4, arrayList3));
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void setEpicenter(Object obj, View view) {
        if (view != null) {
            Rect rect = new Rect();
            getBoundsOnScreen(view, rect);
            ((f) obj).en(new y(rect));
        }
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void setListenerForTransitionEnd(@NonNull Fragment fragment, @NonNull Object obj, @NonNull b.a aVar, @NonNull Runnable runnable) {
        f fVar = (f) obj;
        aVar.zn(new gv(fVar));
        fVar.n3(new C0073v(runnable));
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void setSharedElementTargets(Object obj, View view, ArrayList<View> arrayList) {
        xc xcVar = (xc) obj;
        List<View> z62 = xcVar.z6();
        z62.clear();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            FragmentTransitionImpl.bfsAddViewChildren(z62, arrayList.get(i));
        }
        z62.add(view);
        arrayList.add(view);
        addTargets(xcVar, arrayList);
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void swapSharedElementTargets(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        xc xcVar = (xc) obj;
        if (xcVar != null) {
            xcVar.z6().clear();
            xcVar.z6().addAll(arrayList2);
            replaceTargets(xcVar, arrayList, arrayList2);
        }
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public Object wrapTransitionInSet(Object obj) {
        if (obj == null) {
            return null;
        }
        xc xcVar = new xc();
        xcVar.eb((f) obj);
        return xcVar;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void setEpicenter(Object obj, Rect rect) {
        if (obj != null) {
            ((f) obj).en(new a(rect));
        }
    }

    /* loaded from: classes.dex */
    public class n3 implements f.fb {

        /* renamed from: n3  reason: collision with root package name */
        public final /* synthetic */ ArrayList f6801n3;
        public final /* synthetic */ View y;

        public n3(View view, ArrayList arrayList) {
            this.y = view;
            this.f6801n3 = arrayList;
        }

        @Override // cr.f.fb
        public void gv(@NonNull f fVar) {
            fVar.j(this);
            fVar.n3(this);
        }

        @Override // cr.f.fb
        public void zn(@NonNull f fVar) {
            fVar.j(this);
            this.y.setVisibility(8);
            int size = this.f6801n3.size();
            for (int i = 0; i < size; i++) {
                ((View) this.f6801n3.get(i)).setVisibility(0);
            }
        }

        @Override // cr.f.fb
        public void n3(@NonNull f fVar) {
        }

        @Override // cr.f.fb
        public void v(@NonNull f fVar) {
        }

        @Override // cr.f.fb
        public void y(@NonNull f fVar) {
        }
    }

    /* renamed from: cr.v$v  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0073v implements f.fb {
        public final /* synthetic */ Runnable y;

        public C0073v(Runnable runnable) {
            this.y = runnable;
        }

        @Override // cr.f.fb
        public void zn(@NonNull f fVar) {
            this.y.run();
        }

        @Override // cr.f.fb
        public void gv(@NonNull f fVar) {
        }

        @Override // cr.f.fb
        public void n3(@NonNull f fVar) {
        }

        @Override // cr.f.fb
        public void v(@NonNull f fVar) {
        }

        @Override // cr.f.fb
        public void y(@NonNull f fVar) {
        }
    }
}
