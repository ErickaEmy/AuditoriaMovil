package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import hw.i4;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class zn extends xc {

    /* renamed from: co  reason: collision with root package name */
    public static TimeInterpolator f3332co;

    /* renamed from: s  reason: collision with root package name */
    public ArrayList<RecyclerView.ta> f3338s = new ArrayList<>();

    /* renamed from: c5  reason: collision with root package name */
    public ArrayList<RecyclerView.ta> f3333c5 = new ArrayList<>();

    /* renamed from: i9  reason: collision with root package name */
    public ArrayList<i9> f3335i9 = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<c5> f3334f = new ArrayList<>();

    /* renamed from: t  reason: collision with root package name */
    public ArrayList<ArrayList<RecyclerView.ta>> f3339t = new ArrayList<>();

    /* renamed from: tl  reason: collision with root package name */
    public ArrayList<ArrayList<i9>> f3340tl = new ArrayList<>();

    /* renamed from: wz  reason: collision with root package name */
    public ArrayList<ArrayList<c5>> f3342wz = new ArrayList<>();

    /* renamed from: xc  reason: collision with root package name */
    public ArrayList<RecyclerView.ta> f3343xc = new ArrayList<>();

    /* renamed from: w  reason: collision with root package name */
    public ArrayList<RecyclerView.ta> f3341w = new ArrayList<>();

    /* renamed from: p  reason: collision with root package name */
    public ArrayList<RecyclerView.ta> f3337p = new ArrayList<>();

    /* renamed from: mt  reason: collision with root package name */
    public ArrayList<RecyclerView.ta> f3336mt = new ArrayList<>();

    /* loaded from: classes.dex */
    public class a extends AnimatorListenerAdapter {

        /* renamed from: gv  reason: collision with root package name */
        public final /* synthetic */ int f3345gv;

        /* renamed from: n3  reason: collision with root package name */
        public final /* synthetic */ int f3346n3;

        /* renamed from: v  reason: collision with root package name */
        public final /* synthetic */ ViewPropertyAnimator f3347v;
        public final /* synthetic */ RecyclerView.ta y;

        /* renamed from: zn  reason: collision with root package name */
        public final /* synthetic */ View f3348zn;

        public a(RecyclerView.ta taVar, int i, View view, int i5, ViewPropertyAnimator viewPropertyAnimator) {
            this.y = taVar;
            this.f3346n3 = i;
            this.f3348zn = view;
            this.f3345gv = i5;
            this.f3347v = viewPropertyAnimator;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (this.f3346n3 != 0) {
                this.f3348zn.setTranslationX(0.0f);
            }
            if (this.f3345gv != 0) {
                this.f3348zn.setTranslationY(0.0f);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f3347v.setListener(null);
            zn.this.ud(this.y);
            zn.this.f3341w.remove(this.y);
            zn.this.jz();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            zn.this.a8(this.y);
        }
    }

    /* loaded from: classes.dex */
    public class fb extends AnimatorListenerAdapter {

        /* renamed from: n3  reason: collision with root package name */
        public final /* synthetic */ ViewPropertyAnimator f3355n3;
        public final /* synthetic */ c5 y;

        /* renamed from: zn  reason: collision with root package name */
        public final /* synthetic */ View f3356zn;

        public fb(c5 c5Var, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.y = c5Var;
            this.f3355n3 = viewPropertyAnimator;
            this.f3356zn = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f3355n3.setListener(null);
            this.f3356zn.setAlpha(1.0f);
            this.f3356zn.setTranslationX(0.0f);
            this.f3356zn.setTranslationY(0.0f);
            zn.this.z6(this.y.y, true);
            zn.this.f3336mt.remove(this.y.y);
            zn.this.jz();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            zn.this.ej(this.y.y, true);
        }
    }

    /* loaded from: classes.dex */
    public class gv extends AnimatorListenerAdapter {

        /* renamed from: n3  reason: collision with root package name */
        public final /* synthetic */ ViewPropertyAnimator f3358n3;
        public final /* synthetic */ RecyclerView.ta y;

        /* renamed from: zn  reason: collision with root package name */
        public final /* synthetic */ View f3359zn;

        public gv(RecyclerView.ta taVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.y = taVar;
            this.f3358n3 = viewPropertyAnimator;
            this.f3359zn = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f3358n3.setListener(null);
            this.f3359zn.setAlpha(1.0f);
            zn.this.x(this.y);
            zn.this.f3337p.remove(this.y);
            zn.this.jz();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            zn.this.b(this.y);
        }
    }

    /* loaded from: classes.dex */
    public static class i9 {

        /* renamed from: gv  reason: collision with root package name */
        public int f3360gv;

        /* renamed from: n3  reason: collision with root package name */
        public int f3361n3;

        /* renamed from: v  reason: collision with root package name */
        public int f3362v;
        public RecyclerView.ta y;

        /* renamed from: zn  reason: collision with root package name */
        public int f3363zn;

        public i9(RecyclerView.ta taVar, int i, int i5, int i6, int i8) {
            this.y = taVar;
            this.f3361n3 = i;
            this.f3363zn = i5;
            this.f3360gv = i6;
            this.f3362v = i8;
        }
    }

    /* loaded from: classes.dex */
    public class n3 implements Runnable {
        public final /* synthetic */ ArrayList y;

        public n3(ArrayList arrayList) {
            this.y = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.y.iterator();
            while (it.hasNext()) {
                zn.this.q9((c5) it.next());
            }
            this.y.clear();
            zn.this.f3342wz.remove(this.y);
        }
    }

    /* loaded from: classes.dex */
    public class s extends AnimatorListenerAdapter {

        /* renamed from: n3  reason: collision with root package name */
        public final /* synthetic */ ViewPropertyAnimator f3366n3;
        public final /* synthetic */ c5 y;

        /* renamed from: zn  reason: collision with root package name */
        public final /* synthetic */ View f3367zn;

        public s(c5 c5Var, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.y = c5Var;
            this.f3366n3 = viewPropertyAnimator;
            this.f3367zn = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f3366n3.setListener(null);
            this.f3367zn.setAlpha(1.0f);
            this.f3367zn.setTranslationX(0.0f);
            this.f3367zn.setTranslationY(0.0f);
            zn.this.z6(this.y.f3351n3, false);
            zn.this.f3336mt.remove(this.y.f3351n3);
            zn.this.jz();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            zn.this.ej(this.y.f3351n3, false);
        }
    }

    /* loaded from: classes.dex */
    public class v extends AnimatorListenerAdapter {

        /* renamed from: n3  reason: collision with root package name */
        public final /* synthetic */ View f3369n3;
        public final /* synthetic */ RecyclerView.ta y;

        /* renamed from: zn  reason: collision with root package name */
        public final /* synthetic */ ViewPropertyAnimator f3370zn;

        public v(RecyclerView.ta taVar, View view, ViewPropertyAnimator viewPropertyAnimator) {
            this.y = taVar;
            this.f3369n3 = view;
            this.f3370zn = viewPropertyAnimator;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f3369n3.setAlpha(1.0f);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f3370zn.setListener(null);
            zn.this.ta(this.y);
            zn.this.f3343xc.remove(this.y);
            zn.this.jz();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            zn.this.d(this.y);
        }
    }

    /* loaded from: classes.dex */
    public class y implements Runnable {
        public final /* synthetic */ ArrayList y;

        public y(ArrayList arrayList) {
            this.y = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.y.iterator();
            while (it.hasNext()) {
                i9 i9Var = (i9) it.next();
                zn.this.k(i9Var.y, i9Var.f3361n3, i9Var.f3363zn, i9Var.f3360gv, i9Var.f3362v);
            }
            this.y.clear();
            zn.this.f3340tl.remove(this.y);
        }
    }

    /* renamed from: androidx.recyclerview.widget.zn$zn  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0027zn implements Runnable {
        public final /* synthetic */ ArrayList y;

        public RunnableC0027zn(ArrayList arrayList) {
            this.y = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.y.iterator();
            while (it.hasNext()) {
                zn.this.ut((RecyclerView.ta) it.next());
            }
            this.y.clear();
            zn.this.f3339t.remove(this.y);
        }
    }

    @Override // androidx.recyclerview.widget.xc
    public boolean d0(RecyclerView.ta taVar) {
        dm(taVar);
        taVar.itemView.setAlpha(0.0f);
        this.f3333c5.add(taVar);
        return true;
    }

    public final void dm(RecyclerView.ta taVar) {
        if (f3332co == null) {
            f3332co = new ValueAnimator().getInterpolator();
        }
        taVar.itemView.animate().setInterpolator(f3332co);
        i9(taVar);
    }

    public void en(List<RecyclerView.ta> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            list.get(size).itemView.animate().cancel();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.tl
    public void f() {
        int size = this.f3335i9.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            i9 i9Var = this.f3335i9.get(size);
            View view = i9Var.y.itemView;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            ud(i9Var.y);
            this.f3335i9.remove(size);
        }
        for (int size2 = this.f3338s.size() - 1; size2 >= 0; size2--) {
            x(this.f3338s.get(size2));
            this.f3338s.remove(size2);
        }
        int size3 = this.f3333c5.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            RecyclerView.ta taVar = this.f3333c5.get(size3);
            taVar.itemView.setAlpha(1.0f);
            ta(taVar);
            this.f3333c5.remove(size3);
        }
        for (int size4 = this.f3334f.size() - 1; size4 >= 0; size4--) {
            y5(this.f3334f.get(size4));
        }
        this.f3334f.clear();
        if (!w()) {
            return;
        }
        for (int size5 = this.f3340tl.size() - 1; size5 >= 0; size5--) {
            ArrayList<i9> arrayList = this.f3340tl.get(size5);
            for (int size6 = arrayList.size() - 1; size6 >= 0; size6--) {
                i9 i9Var2 = arrayList.get(size6);
                View view2 = i9Var2.y.itemView;
                view2.setTranslationY(0.0f);
                view2.setTranslationX(0.0f);
                ud(i9Var2.y);
                arrayList.remove(size6);
                if (arrayList.isEmpty()) {
                    this.f3340tl.remove(arrayList);
                }
            }
        }
        for (int size7 = this.f3339t.size() - 1; size7 >= 0; size7--) {
            ArrayList<RecyclerView.ta> arrayList2 = this.f3339t.get(size7);
            for (int size8 = arrayList2.size() - 1; size8 >= 0; size8--) {
                RecyclerView.ta taVar2 = arrayList2.get(size8);
                taVar2.itemView.setAlpha(1.0f);
                ta(taVar2);
                arrayList2.remove(size8);
                if (arrayList2.isEmpty()) {
                    this.f3339t.remove(arrayList2);
                }
            }
        }
        for (int size9 = this.f3342wz.size() - 1; size9 >= 0; size9--) {
            ArrayList<c5> arrayList3 = this.f3342wz.get(size9);
            for (int size10 = arrayList3.size() - 1; size10 >= 0; size10--) {
                y5(arrayList3.get(size10));
                if (arrayList3.isEmpty()) {
                    this.f3342wz.remove(arrayList3);
                }
            }
        }
        en(this.f3337p);
        en(this.f3341w);
        en(this.f3343xc);
        en(this.f3336mt);
        c5();
    }

    public final void f7(RecyclerView.ta taVar) {
        View view = taVar.itemView;
        ViewPropertyAnimator animate = view.animate();
        this.f3337p.add(taVar);
        animate.setDuration(xc()).alpha(0.0f).setListener(new gv(taVar, animate, view)).start();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.tl
    public boolean fb(@NonNull RecyclerView.ta taVar, @NonNull List<Object> list) {
        if (list.isEmpty() && !super.fb(taVar, list)) {
            return false;
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.xc
    public boolean fh(RecyclerView.ta taVar, RecyclerView.ta taVar2, int i, int i5, int i6, int i8) {
        if (taVar == taVar2) {
            return rz(taVar, i, i5, i6, i8);
        }
        float translationX = taVar.itemView.getTranslationX();
        float translationY = taVar.itemView.getTranslationY();
        float alpha = taVar.itemView.getAlpha();
        dm(taVar);
        int i10 = (int) ((i6 - i) - translationX);
        int i11 = (int) ((i8 - i5) - translationY);
        taVar.itemView.setTranslationX(translationX);
        taVar.itemView.setTranslationY(translationY);
        taVar.itemView.setAlpha(alpha);
        if (taVar2 != null) {
            dm(taVar2);
            taVar2.itemView.setTranslationX(-i10);
            taVar2.itemView.setTranslationY(-i11);
            taVar2.itemView.setAlpha(0.0f);
        }
        this.f3334f.add(new c5(taVar, taVar2, i, i5, i6, i8));
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.tl
    public void i9(RecyclerView.ta taVar) {
        View view = taVar.itemView;
        view.animate().cancel();
        int size = this.f3335i9.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            } else if (this.f3335i9.get(size).y == taVar) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                ud(taVar);
                this.f3335i9.remove(size);
            }
        }
        u(this.f3334f, taVar);
        if (this.f3338s.remove(taVar)) {
            view.setAlpha(1.0f);
            x(taVar);
        }
        if (this.f3333c5.remove(taVar)) {
            view.setAlpha(1.0f);
            ta(taVar);
        }
        for (int size2 = this.f3342wz.size() - 1; size2 >= 0; size2--) {
            ArrayList<c5> arrayList = this.f3342wz.get(size2);
            u(arrayList, taVar);
            if (arrayList.isEmpty()) {
                this.f3342wz.remove(size2);
            }
        }
        for (int size3 = this.f3340tl.size() - 1; size3 >= 0; size3--) {
            ArrayList<i9> arrayList2 = this.f3340tl.get(size3);
            int size4 = arrayList2.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                } else if (arrayList2.get(size4).y == taVar) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    ud(taVar);
                    arrayList2.remove(size4);
                    if (arrayList2.isEmpty()) {
                        this.f3340tl.remove(size3);
                    }
                } else {
                    size4--;
                }
            }
        }
        for (int size5 = this.f3339t.size() - 1; size5 >= 0; size5--) {
            ArrayList<RecyclerView.ta> arrayList3 = this.f3339t.get(size5);
            if (arrayList3.remove(taVar)) {
                view.setAlpha(1.0f);
                ta(taVar);
                if (arrayList3.isEmpty()) {
                    this.f3339t.remove(size5);
                }
            }
        }
        this.f3337p.remove(taVar);
        this.f3343xc.remove(taVar);
        this.f3336mt.remove(taVar);
        this.f3341w.remove(taVar);
        jz();
    }

    public void jz() {
        if (!w()) {
            c5();
        }
    }

    public void k(RecyclerView.ta taVar, int i, int i5, int i6, int i8) {
        View view = taVar.itemView;
        int i10 = i6 - i;
        int i11 = i8 - i5;
        if (i10 != 0) {
            view.animate().translationX(0.0f);
        }
        if (i11 != 0) {
            view.animate().translationY(0.0f);
        }
        ViewPropertyAnimator animate = view.animate();
        this.f3341w.add(taVar);
        animate.setDuration(wz()).setListener(new a(taVar, i10, view, i11, animate)).start();
    }

    @Override // androidx.recyclerview.widget.xc
    public boolean mg(RecyclerView.ta taVar) {
        dm(taVar);
        this.f3338s.add(taVar);
        return true;
    }

    public void q9(c5 c5Var) {
        View view;
        RecyclerView.ta taVar = c5Var.y;
        View view2 = null;
        if (taVar == null) {
            view = null;
        } else {
            view = taVar.itemView;
        }
        RecyclerView.ta taVar2 = c5Var.f3351n3;
        if (taVar2 != null) {
            view2 = taVar2.itemView;
        }
        if (view != null) {
            ViewPropertyAnimator duration = view.animate().setDuration(tl());
            this.f3336mt.add(c5Var.y);
            duration.translationX(c5Var.f3352v - c5Var.f3353zn);
            duration.translationY(c5Var.f3349a - c5Var.f3350gv);
            duration.alpha(0.0f).setListener(new fb(c5Var, duration, view)).start();
        }
        if (view2 != null) {
            ViewPropertyAnimator animate = view2.animate();
            this.f3336mt.add(c5Var.f3351n3);
            animate.translationX(0.0f).translationY(0.0f).setDuration(tl()).alpha(1.0f).setListener(new s(c5Var, animate, view2)).start();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.tl
    public void r() {
        long j2;
        long j4;
        boolean isEmpty = this.f3338s.isEmpty();
        boolean isEmpty2 = this.f3335i9.isEmpty();
        boolean isEmpty3 = this.f3334f.isEmpty();
        boolean isEmpty4 = this.f3333c5.isEmpty();
        if (isEmpty && isEmpty2 && isEmpty4 && isEmpty3) {
            return;
        }
        Iterator<RecyclerView.ta> it = this.f3338s.iterator();
        while (it.hasNext()) {
            f7(it.next());
        }
        this.f3338s.clear();
        if (!isEmpty2) {
            ArrayList<i9> arrayList = new ArrayList<>();
            arrayList.addAll(this.f3335i9);
            this.f3340tl.add(arrayList);
            this.f3335i9.clear();
            y yVar = new y(arrayList);
            if (!isEmpty) {
                i4.ra(arrayList.get(0).y.itemView, yVar, xc());
            } else {
                yVar.run();
            }
        }
        if (!isEmpty3) {
            ArrayList<c5> arrayList2 = new ArrayList<>();
            arrayList2.addAll(this.f3334f);
            this.f3342wz.add(arrayList2);
            this.f3334f.clear();
            n3 n3Var = new n3(arrayList2);
            if (!isEmpty) {
                i4.ra(arrayList2.get(0).y.itemView, n3Var, xc());
            } else {
                n3Var.run();
            }
        }
        if (!isEmpty4) {
            ArrayList<RecyclerView.ta> arrayList3 = new ArrayList<>();
            arrayList3.addAll(this.f3333c5);
            this.f3339t.add(arrayList3);
            this.f3333c5.clear();
            RunnableC0027zn runnableC0027zn = new RunnableC0027zn(arrayList3);
            if (isEmpty && isEmpty2 && isEmpty3) {
                runnableC0027zn.run();
                return;
            }
            long j6 = 0;
            if (!isEmpty) {
                j2 = xc();
            } else {
                j2 = 0;
            }
            if (!isEmpty2) {
                j4 = wz();
            } else {
                j4 = 0;
            }
            if (!isEmpty3) {
                j6 = tl();
            }
            i4.ra(arrayList3.get(0).itemView, runnableC0027zn, j2 + Math.max(j4, j6));
        }
    }

    @Override // androidx.recyclerview.widget.xc
    public boolean rz(RecyclerView.ta taVar, int i, int i5, int i6, int i8) {
        View view = taVar.itemView;
        int translationX = i + ((int) view.getTranslationX());
        int translationY = i5 + ((int) taVar.itemView.getTranslationY());
        dm(taVar);
        int i10 = i6 - translationX;
        int i11 = i8 - translationY;
        if (i10 == 0 && i11 == 0) {
            ud(taVar);
            return false;
        }
        if (i10 != 0) {
            view.setTranslationX(-i10);
        }
        if (i11 != 0) {
            view.setTranslationY(-i11);
        }
        this.f3335i9.add(new i9(taVar, translationX, translationY, i6, i8));
        return true;
    }

    public final void u(List<c5> list, RecyclerView.ta taVar) {
        for (int size = list.size() - 1; size >= 0; size--) {
            c5 c5Var = list.get(size);
            if (xg(c5Var, taVar) && c5Var.y == null && c5Var.f3351n3 == null) {
                list.remove(c5Var);
            }
        }
    }

    public void ut(RecyclerView.ta taVar) {
        View view = taVar.itemView;
        ViewPropertyAnimator animate = view.animate();
        this.f3343xc.add(taVar);
        animate.alpha(1.0f).setDuration(t()).setListener(new v(taVar, view, animate)).start();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.tl
    public boolean w() {
        if (this.f3333c5.isEmpty() && this.f3334f.isEmpty() && this.f3335i9.isEmpty() && this.f3338s.isEmpty() && this.f3341w.isEmpty() && this.f3337p.isEmpty() && this.f3343xc.isEmpty() && this.f3336mt.isEmpty() && this.f3340tl.isEmpty() && this.f3339t.isEmpty() && this.f3342wz.isEmpty()) {
            return false;
        }
        return true;
    }

    public final boolean xg(c5 c5Var, RecyclerView.ta taVar) {
        boolean z2 = false;
        if (c5Var.f3351n3 == taVar) {
            c5Var.f3351n3 = null;
        } else if (c5Var.y != taVar) {
            return false;
        } else {
            c5Var.y = null;
            z2 = true;
        }
        taVar.itemView.setAlpha(1.0f);
        taVar.itemView.setTranslationX(0.0f);
        taVar.itemView.setTranslationY(0.0f);
        z6(taVar, z2);
        return true;
    }

    public final void y5(c5 c5Var) {
        RecyclerView.ta taVar = c5Var.y;
        if (taVar != null) {
            xg(c5Var, taVar);
        }
        RecyclerView.ta taVar2 = c5Var.f3351n3;
        if (taVar2 != null) {
            xg(c5Var, taVar2);
        }
    }

    /* loaded from: classes.dex */
    public static class c5 {

        /* renamed from: a  reason: collision with root package name */
        public int f3349a;

        /* renamed from: gv  reason: collision with root package name */
        public int f3350gv;

        /* renamed from: n3  reason: collision with root package name */
        public RecyclerView.ta f3351n3;

        /* renamed from: v  reason: collision with root package name */
        public int f3352v;
        public RecyclerView.ta y;

        /* renamed from: zn  reason: collision with root package name */
        public int f3353zn;

        public c5(RecyclerView.ta taVar, RecyclerView.ta taVar2) {
            this.y = taVar;
            this.f3351n3 = taVar2;
        }

        public String toString() {
            return "ChangeInfo{oldHolder=" + this.y + ", newHolder=" + this.f3351n3 + ", fromX=" + this.f3353zn + ", fromY=" + this.f3350gv + ", toX=" + this.f3352v + ", toY=" + this.f3349a + '}';
        }

        public c5(RecyclerView.ta taVar, RecyclerView.ta taVar2, int i, int i5, int i6, int i8) {
            this(taVar, taVar2);
            this.f3353zn = i;
            this.f3350gv = i5;
            this.f3352v = i6;
            this.f3349a = i8;
        }
    }
}
