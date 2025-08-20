package cr;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.graphics.Path;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public abstract class f implements Cloneable {

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<p> f6730b;

    /* renamed from: en  reason: collision with root package name */
    public z.y<String, String> f6736en;

    /* renamed from: f7  reason: collision with root package name */
    public a f6739f7;

    /* renamed from: j5  reason: collision with root package name */
    public ArrayList<p> f6743j5;

    /* renamed from: u  reason: collision with root package name */
    public static final int[] f6727u = {2, 1, 3, 4};

    /* renamed from: y5  reason: collision with root package name */
    public static final cr.fb f6729y5 = new y();

    /* renamed from: xg  reason: collision with root package name */
    public static ThreadLocal<z.y<Animator, gv>> f6728xg = new ThreadLocal<>();
    public String y = getClass().getName();

    /* renamed from: v  reason: collision with root package name */
    public long f6756v = -1;

    /* renamed from: fb  reason: collision with root package name */
    public long f6740fb = -1;

    /* renamed from: s  reason: collision with root package name */
    public TimeInterpolator f6753s = null;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<Integer> f6737f = new ArrayList<>();

    /* renamed from: t  reason: collision with root package name */
    public ArrayList<View> f6754t = new ArrayList<>();

    /* renamed from: w  reason: collision with root package name */
    public ArrayList<String> f6757w = null;

    /* renamed from: p  reason: collision with root package name */
    public ArrayList<Class<?>> f6749p = null;

    /* renamed from: co  reason: collision with root package name */
    public ArrayList<Integer> f6732co = null;

    /* renamed from: z  reason: collision with root package name */
    public ArrayList<View> f6759z = null;

    /* renamed from: r  reason: collision with root package name */
    public ArrayList<Class<?>> f6752r = null;

    /* renamed from: f3  reason: collision with root package name */
    public ArrayList<String> f6738f3 = null;

    /* renamed from: n  reason: collision with root package name */
    public ArrayList<Integer> f6746n = null;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<View> f6731c = null;

    /* renamed from: d0  reason: collision with root package name */
    public ArrayList<Class<?>> f6734d0 = null;

    /* renamed from: fh  reason: collision with root package name */
    public mt f6741fh = new mt();

    /* renamed from: d  reason: collision with root package name */
    public mt f6733d = new mt();

    /* renamed from: ej  reason: collision with root package name */
    public xc f6735ej = null;

    /* renamed from: x  reason: collision with root package name */
    public int[] f6758x = f6727u;

    /* renamed from: qn  reason: collision with root package name */
    public boolean f6751qn = false;

    /* renamed from: o  reason: collision with root package name */
    public ArrayList<Animator> f6747o = new ArrayList<>();

    /* renamed from: j  reason: collision with root package name */
    public int f6742j = 0;

    /* renamed from: oz  reason: collision with root package name */
    public boolean f6748oz = false;

    /* renamed from: ut  reason: collision with root package name */
    public boolean f6755ut = false;

    /* renamed from: q9  reason: collision with root package name */
    public ArrayList<fb> f6750q9 = null;

    /* renamed from: k  reason: collision with root package name */
    public ArrayList<Animator> f6745k = new ArrayList<>();

    /* renamed from: jz  reason: collision with root package name */
    public cr.fb f6744jz = f6729y5;

    /* loaded from: classes.dex */
    public static abstract class a {
    }

    /* loaded from: classes.dex */
    public interface fb {
        void gv(@NonNull f fVar);

        void n3(@NonNull f fVar);

        void v(@NonNull f fVar);

        void y(@NonNull f fVar);

        void zn(@NonNull f fVar);
    }

    /* loaded from: classes.dex */
    public static class gv {

        /* renamed from: gv  reason: collision with root package name */
        public z6 f6760gv;

        /* renamed from: n3  reason: collision with root package name */
        public String f6761n3;

        /* renamed from: v  reason: collision with root package name */
        public f f6762v;
        public View y;

        /* renamed from: zn  reason: collision with root package name */
        public p f6763zn;

        public gv(View view, String str, f fVar, z6 z6Var, p pVar) {
            this.y = view;
            this.f6761n3 = str;
            this.f6763zn = pVar;
            this.f6760gv = z6Var;
            this.f6762v = fVar;
        }
    }

    /* loaded from: classes.dex */
    public class n3 extends AnimatorListenerAdapter {
        public final /* synthetic */ z.y y;

        public n3(z.y yVar) {
            this.y = yVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.y.remove(animator);
            f.this.f6747o.remove(animator);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            f.this.f6747o.add(animator);
        }
    }

    /* loaded from: classes.dex */
    public static class v {
        public static <T> ArrayList<T> n3(ArrayList<T> arrayList, T t2) {
            if (arrayList != null) {
                arrayList.remove(t2);
                if (arrayList.isEmpty()) {
                    return null;
                }
                return arrayList;
            }
            return arrayList;
        }

        public static <T> ArrayList<T> y(ArrayList<T> arrayList, T t2) {
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            if (!arrayList.contains(t2)) {
                arrayList.add(t2);
            }
            return arrayList;
        }
    }

    /* loaded from: classes.dex */
    public class y extends cr.fb {
        @Override // cr.fb
        public Path y(float f4, float f6, float f9, float f10) {
            Path path = new Path();
            path.moveTo(f4, f6);
            path.lineTo(f9, f10);
            return path;
        }
    }

    /* loaded from: classes.dex */
    public class zn extends AnimatorListenerAdapter {
        public zn() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            f.this.p();
            animator.removeListener(this);
        }
    }

    public static void a(mt mtVar, View view, p pVar) {
        mtVar.y.put(view, pVar);
        int id = view.getId();
        if (id >= 0) {
            if (mtVar.f6775n3.indexOfKey(id) >= 0) {
                mtVar.f6775n3.put(id, null);
            } else {
                mtVar.f6775n3.put(id, view);
            }
        }
        String yt2 = hw.i4.yt(view);
        if (yt2 != null) {
            if (mtVar.f6774gv.containsKey(yt2)) {
                mtVar.f6774gv.put(yt2, null);
            } else {
                mtVar.f6774gv.put(yt2, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                if (mtVar.f6776zn.i9(itemIdAtPosition) >= 0) {
                    View s2 = mtVar.f6776zn.s(itemIdAtPosition);
                    if (s2 != null) {
                        hw.i4.cr(s2, false);
                        mtVar.f6776zn.tl(itemIdAtPosition, null);
                        return;
                    }
                    return;
                }
                hw.i4.cr(view, true);
                mtVar.f6776zn.tl(itemIdAtPosition, view);
            }
        }
    }

    public static boolean b(p pVar, p pVar2, String str) {
        Object obj = pVar.y.get(str);
        Object obj2 = pVar2.y.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj != null && obj2 != null) {
            return !obj.equals(obj2);
        }
        return true;
    }

    public static z.y<Animator, gv> fh() {
        z.y<Animator, gv> yVar = f6728xg.get();
        if (yVar == null) {
            z.y<Animator, gv> yVar2 = new z.y<>();
            f6728xg.set(yVar2);
            return yVar2;
        }
        return yVar;
    }

    public boolean a8(@Nullable p pVar, @Nullable p pVar2) {
        if (pVar == null || pVar2 == null) {
            return false;
        }
        String[] ej2 = ej();
        if (ej2 != null) {
            for (String str : ej2) {
                if (!b(pVar, pVar2, str)) {
                }
            }
            return false;
        }
        for (String str2 : pVar.y.keySet()) {
            if (b(pVar, pVar2, str2)) {
            }
        }
        return false;
        return true;
    }

    @NonNull
    public cr.fb c() {
        return this.f6744jz;
    }

    public final void c5(View view, boolean z2) {
        if (view == null) {
            return;
        }
        int id = view.getId();
        ArrayList<Integer> arrayList = this.f6732co;
        if (arrayList != null && arrayList.contains(Integer.valueOf(id))) {
            return;
        }
        ArrayList<View> arrayList2 = this.f6759z;
        if (arrayList2 != null && arrayList2.contains(view)) {
            return;
        }
        ArrayList<Class<?>> arrayList3 = this.f6752r;
        if (arrayList3 != null) {
            int size = arrayList3.size();
            for (int i = 0; i < size; i++) {
                if (this.f6752r.get(i).isInstance(view)) {
                    return;
                }
            }
        }
        if (view.getParent() instanceof ViewGroup) {
            p pVar = new p(view);
            if (z2) {
                f(pVar);
            } else {
                s(pVar);
            }
            pVar.f6779zn.add(this);
            i9(pVar);
            if (z2) {
                a(this.f6741fh, view, pVar);
            } else {
                a(this.f6733d, view, pVar);
            }
        }
        if (view instanceof ViewGroup) {
            ArrayList<Integer> arrayList4 = this.f6746n;
            if (arrayList4 != null && arrayList4.contains(Integer.valueOf(id))) {
                return;
            }
            ArrayList<View> arrayList5 = this.f6731c;
            if (arrayList5 != null && arrayList5.contains(view)) {
                return;
            }
            ArrayList<Class<?>> arrayList6 = this.f6734d0;
            if (arrayList6 != null) {
                int size2 = arrayList6.size();
                for (int i5 = 0; i5 < size2; i5++) {
                    if (this.f6734d0.get(i5).isInstance(view)) {
                        return;
                    }
                }
            }
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i6 = 0; i6 < viewGroup.getChildCount(); i6++) {
                c5(viewGroup.getChildAt(i6), z2);
            }
        }
    }

    public void cancel() {
        for (int size = this.f6747o.size() - 1; size >= 0; size--) {
            this.f6747o.get(size).cancel();
        }
        ArrayList<fb> arrayList = this.f6750q9;
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList arrayList2 = (ArrayList) this.f6750q9.clone();
            int size2 = arrayList2.size();
            for (int i = 0; i < size2; i++) {
                ((fb) arrayList2.get(i)).n3(this);
            }
        }
    }

    public final ArrayList<View> co(ArrayList<View> arrayList, View view, boolean z2) {
        if (view != null) {
            if (z2) {
                return v.y(arrayList, view);
            }
            return v.n3(arrayList, view);
        }
        return arrayList;
    }

    public String ct(String str) {
        String str2 = str + getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + ": ";
        if (this.f6740fb != -1) {
            str2 = str2 + "dur(" + this.f6740fb + ") ";
        }
        if (this.f6756v != -1) {
            str2 = str2 + "dly(" + this.f6756v + ") ";
        }
        if (this.f6753s != null) {
            str2 = str2 + "interp(" + this.f6753s + ") ";
        }
        if (this.f6737f.size() > 0 || this.f6754t.size() > 0) {
            String str3 = str2 + "tgts(";
            if (this.f6737f.size() > 0) {
                for (int i = 0; i < this.f6737f.size(); i++) {
                    if (i > 0) {
                        str3 = str3 + ", ";
                    }
                    str3 = str3 + this.f6737f.get(i);
                }
            }
            if (this.f6754t.size() > 0) {
                for (int i5 = 0; i5 < this.f6754t.size(); i5++) {
                    if (i5 > 0) {
                        str3 = str3 + ", ";
                    }
                    str3 = str3 + this.f6754t.get(i5);
                }
            }
            return str3 + ")";
        }
        return str2;
    }

    @Nullable
    public List<Class<?>> d() {
        return this.f6749p;
    }

    @Nullable
    public wz d0() {
        return null;
    }

    public void dm() {
        if (this.f6742j == 0) {
            ArrayList<fb> arrayList = this.f6750q9;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.f6750q9.clone();
                int size = arrayList2.size();
                for (int i = 0; i < size; i++) {
                    ((fb) arrayList2.get(i)).gv(this);
                }
            }
            this.f6755ut = false;
        }
        this.f6742j++;
    }

    @Nullable
    public String[] ej() {
        return null;
    }

    public void en(@Nullable a aVar) {
        this.f6739f7 = aVar;
    }

    public abstract void f(@NonNull p pVar);

    public p f3(View view, boolean z2) {
        ArrayList<p> arrayList;
        ArrayList<p> arrayList2;
        xc xcVar = this.f6735ej;
        if (xcVar != null) {
            return xcVar.f3(view, z2);
        }
        if (z2) {
            arrayList = this.f6730b;
        } else {
            arrayList = this.f6743j5;
        }
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        int i = 0;
        while (true) {
            if (i < size) {
                p pVar = arrayList.get(i);
                if (pVar == null) {
                    return null;
                }
                if (pVar.f6778n3 == view) {
                    break;
                }
                i++;
            } else {
                i = -1;
                break;
            }
        }
        if (i < 0) {
            return null;
        }
        if (z2) {
            arrayList2 = this.f6743j5;
        } else {
            arrayList2 = this.f6730b;
        }
        return arrayList2.get(i);
    }

    @NonNull
    public f f7(long j2) {
        this.f6740fb = j2;
        return this;
    }

    public void fb(Animator animator) {
        if (animator == null) {
            p();
            return;
        }
        if (z() >= 0) {
            animator.setDuration(z());
        }
        if (rz() >= 0) {
            animator.setStartDelay(rz() + animator.getStartDelay());
        }
        if (i4() != null) {
            animator.setInterpolator(i4());
        }
        animator.addListener(new zn());
        animator.start();
    }

    public final void gv(z.y<View, p> yVar, z.y<View, p> yVar2) {
        for (int i = 0; i < yVar.size(); i++) {
            p xc2 = yVar.xc(i);
            if (x(xc2.f6778n3)) {
                this.f6730b.add(xc2);
                this.f6743j5.add(null);
            }
        }
        for (int i5 = 0; i5 < yVar2.size(); i5++) {
            p xc3 = yVar2.xc(i5);
            if (x(xc3.f6778n3)) {
                this.f6743j5.add(xc3);
                this.f6730b.add(null);
            }
        }
    }

    public final void hw(z.y<View, p> yVar, z.y<View, p> yVar2, z.y<String, View> yVar3, z.y<String, View> yVar4) {
        View view;
        int size = yVar3.size();
        for (int i = 0; i < size; i++) {
            View xc2 = yVar3.xc(i);
            if (xc2 != null && x(xc2) && (view = yVar4.get(yVar3.f(i))) != null && x(view)) {
                p pVar = yVar.get(xc2);
                p pVar2 = yVar2.get(view);
                if (pVar != null && pVar2 != null) {
                    this.f6730b.add(pVar);
                    this.f6743j5.add(pVar2);
                    yVar.remove(xc2);
                    yVar2.remove(view);
                }
            }
        }
    }

    @Nullable
    public TimeInterpolator i4() {
        return this.f6753s;
    }

    @NonNull
    public f j(@NonNull fb fbVar) {
        ArrayList<fb> arrayList = this.f6750q9;
        if (arrayList == null) {
            return this;
        }
        arrayList.remove(fbVar);
        if (this.f6750q9.size() == 0) {
            this.f6750q9 = null;
        }
        return this;
    }

    public final void j5(mt mtVar, mt mtVar2) {
        z.y<View, p> yVar = new z.y<>(mtVar.y);
        z.y<View, p> yVar2 = new z.y<>(mtVar2.y);
        int i = 0;
        while (true) {
            int[] iArr = this.f6758x;
            if (i < iArr.length) {
                int i5 = iArr[i];
                if (i5 != 1) {
                    if (i5 != 2) {
                        if (i5 != 3) {
                            if (i5 == 4) {
                                vl(yVar, yVar2, mtVar.f6776zn, mtVar2.f6776zn);
                            }
                        } else {
                            k5(yVar, yVar2, mtVar.f6775n3, mtVar2.f6775n3);
                        }
                    } else {
                        hw(yVar, yVar2, mtVar.f6774gv, mtVar2.f6774gv);
                    }
                } else {
                    yt(yVar, yVar2);
                }
                i++;
            } else {
                gv(yVar, yVar2);
                return;
            }
        }
    }

    @NonNull
    public f jz(@Nullable TimeInterpolator timeInterpolator) {
        this.f6753s = timeInterpolator;
        return this;
    }

    public void k() {
        dm();
        z.y<Animator, gv> fh2 = fh();
        Iterator<Animator> it = this.f6745k.iterator();
        while (it.hasNext()) {
            Animator next = it.next();
            if (fh2.containsKey(next)) {
                dm();
                q9(next, fh2);
            }
        }
        this.f6745k.clear();
        p();
    }

    public final void k5(z.y<View, p> yVar, z.y<View, p> yVar2, SparseArray<View> sparseArray, SparseArray<View> sparseArray2) {
        View view;
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            View valueAt = sparseArray.valueAt(i);
            if (valueAt != null && x(valueAt) && (view = sparseArray2.get(sparseArray.keyAt(i))) != null && x(view)) {
                p pVar = yVar.get(valueAt);
                p pVar2 = yVar2.get(view);
                if (pVar != null && pVar2 != null) {
                    this.f6730b.add(pVar);
                    this.f6743j5.add(pVar2);
                    yVar.remove(valueAt);
                    yVar2.remove(view);
                }
            }
        }
    }

    @NonNull
    public List<Integer> mg() {
        return this.f6737f;
    }

    @NonNull
    public f mt(@NonNull View view, boolean z2) {
        this.f6759z = co(this.f6759z, view, z2);
        return this;
    }

    @NonNull
    public String n() {
        return this.y;
    }

    @NonNull
    public f n3(@NonNull fb fbVar) {
        if (this.f6750q9 == null) {
            this.f6750q9 = new ArrayList<>();
        }
        this.f6750q9.add(fbVar);
        return this;
    }

    public void o(ViewGroup viewGroup) {
        gv gvVar;
        this.f6730b = new ArrayList<>();
        this.f6743j5 = new ArrayList<>();
        j5(this.f6741fh, this.f6733d);
        z.y<Animator, gv> fh2 = fh();
        int size = fh2.size();
        z6 gv2 = f3.gv(viewGroup);
        for (int i = size - 1; i >= 0; i--) {
            Animator f4 = fh2.f(i);
            if (f4 != null && (gvVar = fh2.get(f4)) != null && gvVar.y != null && gv2.equals(gvVar.f6760gv)) {
                p pVar = gvVar.f6763zn;
                View view = gvVar.y;
                p ud2 = ud(view, true);
                p f32 = f3(view, true);
                if (ud2 == null && f32 == null) {
                    f32 = this.f6733d.y.get(view);
                }
                if ((ud2 != null || f32 != null) && gvVar.f6762v.a8(pVar, f32)) {
                    if (!f4.isRunning() && !f4.isStarted()) {
                        fh2.remove(f4);
                    } else {
                        f4.cancel();
                    }
                }
            }
        }
        w(viewGroup, this.f6741fh, this.f6733d, this.f6730b, this.f6743j5);
        k();
    }

    @NonNull
    public f oz(@NonNull View view) {
        this.f6754t.remove(view);
        return this;
    }

    public void p() {
        int i = this.f6742j - 1;
        this.f6742j = i;
        if (i == 0) {
            ArrayList<fb> arrayList = this.f6750q9;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.f6750q9.clone();
                int size = arrayList2.size();
                for (int i5 = 0; i5 < size; i5++) {
                    ((fb) arrayList2.get(i5)).zn(this);
                }
            }
            for (int i6 = 0; i6 < this.f6741fh.f6776zn.w(); i6++) {
                View p2 = this.f6741fh.f6776zn.p(i6);
                if (p2 != null) {
                    hw.i4.cr(p2, false);
                }
            }
            for (int i8 = 0; i8 < this.f6733d.f6776zn.w(); i8++) {
                View p3 = this.f6733d.f6776zn.p(i8);
                if (p3 != null) {
                    hw.i4.cr(p3, false);
                }
            }
            this.f6755ut = true;
        }
    }

    public final void q9(Animator animator, z.y<Animator, gv> yVar) {
        if (animator != null) {
            animator.addListener(new n3(yVar));
            fb(animator);
        }
    }

    public void qn(View view) {
        if (!this.f6755ut) {
            for (int size = this.f6747o.size() - 1; size >= 0; size--) {
                cr.y.n3(this.f6747o.get(size));
            }
            ArrayList<fb> arrayList = this.f6750q9;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.f6750q9.clone();
                int size2 = arrayList2.size();
                for (int i = 0; i < size2; i++) {
                    ((fb) arrayList2.get(i)).v(this);
                }
            }
            this.f6748oz = true;
        }
    }

    public long rz() {
        return this.f6756v;
    }

    public abstract void s(@NonNull p pVar);

    public void t(ViewGroup viewGroup, boolean z2) {
        ArrayList<String> arrayList;
        ArrayList<Class<?>> arrayList2;
        z.y<String, String> yVar;
        tl(z2);
        if ((this.f6737f.size() <= 0 && this.f6754t.size() <= 0) || (((arrayList = this.f6757w) != null && !arrayList.isEmpty()) || ((arrayList2 = this.f6749p) != null && !arrayList2.isEmpty()))) {
            c5(viewGroup, z2);
        } else {
            for (int i = 0; i < this.f6737f.size(); i++) {
                View findViewById = viewGroup.findViewById(this.f6737f.get(i).intValue());
                if (findViewById != null) {
                    p pVar = new p(findViewById);
                    if (z2) {
                        f(pVar);
                    } else {
                        s(pVar);
                    }
                    pVar.f6779zn.add(this);
                    i9(pVar);
                    if (z2) {
                        a(this.f6741fh, findViewById, pVar);
                    } else {
                        a(this.f6733d, findViewById, pVar);
                    }
                }
            }
            for (int i5 = 0; i5 < this.f6754t.size(); i5++) {
                View view = this.f6754t.get(i5);
                p pVar2 = new p(view);
                if (z2) {
                    f(pVar2);
                } else {
                    s(pVar2);
                }
                pVar2.f6779zn.add(this);
                i9(pVar2);
                if (z2) {
                    a(this.f6741fh, view, pVar2);
                } else {
                    a(this.f6733d, view, pVar2);
                }
            }
        }
        if (!z2 && (yVar = this.f6736en) != null) {
            int size = yVar.size();
            ArrayList arrayList3 = new ArrayList(size);
            for (int i6 = 0; i6 < size; i6++) {
                arrayList3.add(this.f6741fh.f6774gv.remove(this.f6736en.f(i6)));
            }
            for (int i8 = 0; i8 < size; i8++) {
                View view2 = (View) arrayList3.get(i8);
                if (view2 != null) {
                    this.f6741fh.f6774gv.put(this.f6736en.xc(i8), view2);
                }
            }
        }
    }

    @Nullable
    public List<String> ta() {
        return this.f6757w;
    }

    public void tl(boolean z2) {
        if (z2) {
            this.f6741fh.y.clear();
            this.f6741fh.f6775n3.clear();
            this.f6741fh.f6776zn.zn();
            return;
        }
        this.f6733d.y.clear();
        this.f6733d.f6775n3.clear();
        this.f6733d.f6776zn.zn();
    }

    public String toString() {
        return ct("");
    }

    public void u(@Nullable cr.fb fbVar) {
        if (fbVar == null) {
            this.f6744jz = f6729y5;
        } else {
            this.f6744jz = fbVar;
        }
    }

    @Nullable
    public p ud(@NonNull View view, boolean z2) {
        mt mtVar;
        xc xcVar = this.f6735ej;
        if (xcVar != null) {
            return xcVar.ud(view, z2);
        }
        if (z2) {
            mtVar = this.f6741fh;
        } else {
            mtVar = this.f6733d;
        }
        return mtVar.y.get(view);
    }

    public void ut(View view) {
        if (this.f6748oz) {
            if (!this.f6755ut) {
                for (int size = this.f6747o.size() - 1; size >= 0; size--) {
                    cr.y.zn(this.f6747o.get(size));
                }
                ArrayList<fb> arrayList = this.f6750q9;
                if (arrayList != null && arrayList.size() > 0) {
                    ArrayList arrayList2 = (ArrayList) this.f6750q9.clone();
                    int size2 = arrayList2.size();
                    for (int i = 0; i < size2; i++) {
                        ((fb) arrayList2.get(i)).y(this);
                    }
                }
            }
            this.f6748oz = false;
        }
    }

    public final void vl(z.y<View, p> yVar, z.y<View, p> yVar2, z.v<View> vVar, z.v<View> vVar2) {
        View s2;
        int w4 = vVar.w();
        for (int i = 0; i < w4; i++) {
            View p2 = vVar.p(i);
            if (p2 != null && x(p2) && (s2 = vVar2.s(vVar.t(i))) != null && x(s2)) {
                p pVar = yVar.get(p2);
                p pVar2 = yVar2.get(s2);
                if (pVar != null && pVar2 != null) {
                    this.f6730b.add(pVar);
                    this.f6743j5.add(pVar2);
                    yVar.remove(p2);
                    yVar2.remove(s2);
                }
            }
        }
    }

    public void w(ViewGroup viewGroup, mt mtVar, mt mtVar2, ArrayList<p> arrayList, ArrayList<p> arrayList2) {
        View view;
        Animator animator;
        p pVar;
        int i;
        Animator animator2;
        p pVar2;
        z.y<Animator, gv> fh2 = fh();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            p pVar3 = arrayList.get(i5);
            p pVar4 = arrayList2.get(i5);
            if (pVar3 != null && !pVar3.f6779zn.contains(this)) {
                pVar3 = null;
            }
            if (pVar4 != null && !pVar4.f6779zn.contains(this)) {
                pVar4 = null;
            }
            if ((pVar3 != null || pVar4 != null) && (pVar3 == null || pVar4 == null || a8(pVar3, pVar4))) {
                Animator xc2 = xc(viewGroup, pVar3, pVar4);
                if (xc2 != null) {
                    if (pVar4 != null) {
                        View view2 = pVar4.f6778n3;
                        String[] ej2 = ej();
                        if (ej2 != null && ej2.length > 0) {
                            pVar2 = new p(view2);
                            p pVar5 = mtVar2.y.get(view2);
                            if (pVar5 != null) {
                                int i6 = 0;
                                while (i6 < ej2.length) {
                                    Map<String, Object> map = pVar2.y;
                                    Animator animator3 = xc2;
                                    String str = ej2[i6];
                                    map.put(str, pVar5.y.get(str));
                                    i6++;
                                    xc2 = animator3;
                                    ej2 = ej2;
                                }
                            }
                            Animator animator4 = xc2;
                            int size2 = fh2.size();
                            int i8 = 0;
                            while (true) {
                                if (i8 < size2) {
                                    gv gvVar = fh2.get(fh2.f(i8));
                                    if (gvVar.f6763zn != null && gvVar.y == view2 && gvVar.f6761n3.equals(n()) && gvVar.f6763zn.equals(pVar2)) {
                                        animator2 = null;
                                        break;
                                    }
                                    i8++;
                                } else {
                                    animator2 = animator4;
                                    break;
                                }
                            }
                        } else {
                            animator2 = xc2;
                            pVar2 = null;
                        }
                        view = view2;
                        animator = animator2;
                        pVar = pVar2;
                    } else {
                        view = pVar3.f6778n3;
                        animator = xc2;
                        pVar = null;
                    }
                    if (animator != null) {
                        i = size;
                        fh2.put(animator, new gv(view, n(), this, f3.gv(viewGroup), pVar));
                        this.f6745k.add(animator);
                        i5++;
                        size = i;
                    }
                    i = size;
                    i5++;
                    size = i;
                }
            }
            i = size;
            i5++;
            size = i;
        }
        if (sparseIntArray.size() != 0) {
            for (int i10 = 0; i10 < sparseIntArray.size(); i10++) {
                Animator animator5 = this.f6745k.get(sparseIntArray.keyAt(i10));
                animator5.setStartDelay((sparseIntArray.valueAt(i10) - Long.MAX_VALUE) + animator5.getStartDelay());
            }
        }
    }

    @Override // 
    /* renamed from: wz */
    public f clone() {
        try {
            f fVar = (f) super.clone();
            fVar.f6745k = new ArrayList<>();
            fVar.f6741fh = new mt();
            fVar.f6733d = new mt();
            fVar.f6730b = null;
            fVar.f6743j5 = null;
            return fVar;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public boolean x(View view) {
        ArrayList<Class<?>> arrayList;
        ArrayList<String> arrayList2;
        int id = view.getId();
        ArrayList<Integer> arrayList3 = this.f6732co;
        if (arrayList3 != null && arrayList3.contains(Integer.valueOf(id))) {
            return false;
        }
        ArrayList<View> arrayList4 = this.f6759z;
        if (arrayList4 != null && arrayList4.contains(view)) {
            return false;
        }
        ArrayList<Class<?>> arrayList5 = this.f6752r;
        if (arrayList5 != null) {
            int size = arrayList5.size();
            for (int i = 0; i < size; i++) {
                if (this.f6752r.get(i).isInstance(view)) {
                    return false;
                }
            }
        }
        if (this.f6738f3 != null && hw.i4.yt(view) != null && this.f6738f3.contains(hw.i4.yt(view))) {
            return false;
        }
        if ((this.f6737f.size() == 0 && this.f6754t.size() == 0 && (((arrayList = this.f6749p) == null || arrayList.isEmpty()) && ((arrayList2 = this.f6757w) == null || arrayList2.isEmpty()))) || this.f6737f.contains(Integer.valueOf(id)) || this.f6754t.contains(view)) {
            return true;
        }
        ArrayList<String> arrayList6 = this.f6757w;
        if (arrayList6 != null && arrayList6.contains(hw.i4.yt(view))) {
            return true;
        }
        if (this.f6749p != null) {
            for (int i5 = 0; i5 < this.f6749p.size(); i5++) {
                if (this.f6749p.get(i5).isInstance(view)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Nullable
    public a x4() {
        return this.f6739f7;
    }

    @Nullable
    public Animator xc(@NonNull ViewGroup viewGroup, @Nullable p pVar, @Nullable p pVar2) {
        return null;
    }

    @NonNull
    public f xg(long j2) {
        this.f6756v = j2;
        return this;
    }

    public final void yt(z.y<View, p> yVar, z.y<View, p> yVar2) {
        p remove;
        for (int size = yVar.size() - 1; size >= 0; size--) {
            View f4 = yVar.f(size);
            if (f4 != null && x(f4) && (remove = yVar2.remove(f4)) != null && x(remove.f6778n3)) {
                this.f6730b.add(yVar.tl(size));
                this.f6743j5.add(remove);
            }
        }
    }

    public long z() {
        return this.f6740fb;
    }

    @NonNull
    public List<View> z6() {
        return this.f6754t;
    }

    @NonNull
    public f zn(@NonNull View view) {
        this.f6754t.add(view);
        return this;
    }

    public void i9(p pVar) {
    }

    public void y5(@Nullable wz wzVar) {
    }
}
