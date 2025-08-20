package cr;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class tl {
    public static f y = new n3();

    /* renamed from: n3  reason: collision with root package name */
    public static ThreadLocal<WeakReference<z.y<ViewGroup, ArrayList<f>>>> f6795n3 = new ThreadLocal<>();

    /* renamed from: zn  reason: collision with root package name */
    public static ArrayList<ViewGroup> f6796zn = new ArrayList<>();

    public static void gv(ViewGroup viewGroup, f fVar) {
        if (fVar != null && viewGroup != null) {
            y yVar = new y(fVar, viewGroup);
            viewGroup.addOnAttachStateChangeListener(yVar);
            viewGroup.getViewTreeObserver().addOnPreDrawListener(yVar);
        }
    }

    public static void n3(@NonNull ViewGroup viewGroup, @Nullable f fVar) {
        if (!f6796zn.contains(viewGroup) && hw.i4.q9(viewGroup)) {
            f6796zn.add(viewGroup);
            if (fVar == null) {
                fVar = y;
            }
            f clone = fVar.clone();
            v(viewGroup, clone);
            i9.zn(viewGroup, null);
            gv(viewGroup, clone);
        }
    }

    public static void v(ViewGroup viewGroup, f fVar) {
        ArrayList<f> arrayList = zn().get(viewGroup);
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<f> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().qn(viewGroup);
            }
        }
        if (fVar != null) {
            fVar.t(viewGroup, true);
        }
        i9 n32 = i9.n3(viewGroup);
        if (n32 != null) {
            n32.y();
        }
    }

    public static void y(@NonNull ViewGroup viewGroup) {
        n3(viewGroup, null);
    }

    public static z.y<ViewGroup, ArrayList<f>> zn() {
        z.y<ViewGroup, ArrayList<f>> yVar;
        WeakReference<z.y<ViewGroup, ArrayList<f>>> weakReference = f6795n3.get();
        if (weakReference != null && (yVar = weakReference.get()) != null) {
            return yVar;
        }
        z.y<ViewGroup, ArrayList<f>> yVar2 = new z.y<>();
        f6795n3.set(new WeakReference<>(yVar2));
        return yVar2;
    }

    /* loaded from: classes.dex */
    public static class y implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

        /* renamed from: v  reason: collision with root package name */
        public ViewGroup f6797v;
        public f y;

        /* renamed from: cr.tl$y$y  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0072y extends t {
            public final /* synthetic */ z.y y;

            public C0072y(z.y yVar) {
                this.y = yVar;
            }

            @Override // cr.f.fb
            public void zn(@NonNull f fVar) {
                ((ArrayList) this.y.get(y.this.f6797v)).remove(fVar);
                fVar.j(this);
            }
        }

        public y(f fVar, ViewGroup viewGroup) {
            this.y = fVar;
            this.f6797v = viewGroup;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            y();
            if (!tl.f6796zn.remove(this.f6797v)) {
                return true;
            }
            z.y<ViewGroup, ArrayList<f>> zn2 = tl.zn();
            ArrayList<f> arrayList = zn2.get(this.f6797v);
            ArrayList arrayList2 = null;
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                zn2.put(this.f6797v, arrayList);
            } else if (arrayList.size() > 0) {
                arrayList2 = new ArrayList(arrayList);
            }
            arrayList.add(this.y);
            this.y.n3(new C0072y(zn2));
            this.y.t(this.f6797v, false);
            if (arrayList2 != null) {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    ((f) it.next()).ut(this.f6797v);
                }
            }
            this.y.o(this.f6797v);
            return true;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            y();
            tl.f6796zn.remove(this.f6797v);
            ArrayList<f> arrayList = tl.zn().get(this.f6797v);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<f> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().ut(this.f6797v);
                }
            }
            this.y.tl(true);
        }

        public final void y() {
            this.f6797v.getViewTreeObserver().removeOnPreDrawListener(this);
            this.f6797v.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }
    }
}
