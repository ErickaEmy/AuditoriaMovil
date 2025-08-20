package cr;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.transition.R$id;
import cr.f;
/* loaded from: classes.dex */
public abstract class ta extends f {

    /* renamed from: ct  reason: collision with root package name */
    public static final String[] f6780ct = {"android:visibility:visibility", "android:visibility:parent"};

    /* renamed from: dm  reason: collision with root package name */
    public int f6781dm = 3;

    /* loaded from: classes.dex */
    public class y extends t {

        /* renamed from: n3  reason: collision with root package name */
        public final /* synthetic */ View f6788n3;
        public final /* synthetic */ ViewGroup y;

        /* renamed from: zn  reason: collision with root package name */
        public final /* synthetic */ View f6789zn;

        public y(ViewGroup viewGroup, View view, View view2) {
            this.y = viewGroup;
            this.f6788n3 = view;
            this.f6789zn = view2;
        }

        @Override // cr.t, cr.f.fb
        public void v(@NonNull f fVar) {
            r.y(this.y).gv(this.f6788n3);
        }

        @Override // cr.t, cr.f.fb
        public void y(@NonNull f fVar) {
            if (this.f6788n3.getParent() == null) {
                r.y(this.y).zn(this.f6788n3);
            } else {
                ta.this.cancel();
            }
        }

        @Override // cr.f.fb
        public void zn(@NonNull f fVar) {
            this.f6789zn.setTag(R$id.save_overlay_view, null);
            r.y(this.y).gv(this.f6788n3);
            fVar.j(this);
        }
    }

    /* loaded from: classes.dex */
    public static class zn {

        /* renamed from: a  reason: collision with root package name */
        public ViewGroup f6790a;

        /* renamed from: gv  reason: collision with root package name */
        public int f6791gv;

        /* renamed from: n3  reason: collision with root package name */
        public boolean f6792n3;

        /* renamed from: v  reason: collision with root package name */
        public ViewGroup f6793v;
        public boolean y;

        /* renamed from: zn  reason: collision with root package name */
        public int f6794zn;
    }

    private void o4(p pVar) {
        pVar.y.put("android:visibility:visibility", Integer.valueOf(pVar.f6778n3.getVisibility()));
        pVar.y.put("android:visibility:parent", pVar.f6778n3.getParent());
        int[] iArr = new int[2];
        pVar.f6778n3.getLocationOnScreen(iArr);
        pVar.y.put("android:visibility:screenLocation", iArr);
    }

    @Override // cr.f
    public boolean a8(@Nullable p pVar, @Nullable p pVar2) {
        if (pVar == null && pVar2 == null) {
            return false;
        }
        if (pVar != null && pVar2 != null && pVar2.y.containsKey("android:visibility:visibility") != pVar.y.containsKey("android:visibility:visibility")) {
            return false;
        }
        zn rs2 = rs(pVar, pVar2);
        if (!rs2.y) {
            return false;
        }
        if (rs2.f6794zn != 0 && rs2.f6791gv != 0) {
            return false;
        }
        return true;
    }

    public void e(int i) {
        if ((i & (-4)) == 0) {
            this.f6781dm = i;
            return;
        }
        throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
    }

    @Nullable
    public abstract Animator eb(ViewGroup viewGroup, View view, p pVar, p pVar2);

    @Override // cr.f
    @Nullable
    public String[] ej() {
        return f6780ct;
    }

    @Override // cr.f
    public void f(@NonNull p pVar) {
        o4(pVar);
    }

    @Nullable
    public Animator lc(ViewGroup viewGroup, p pVar, int i, p pVar2, int i5) {
        if ((this.f6781dm & 1) != 1 || pVar2 == null) {
            return null;
        }
        if (pVar == null) {
            View view = (View) pVar2.f6778n3.getParent();
            if (rs(f3(view, false), ud(view, false)).y) {
                return null;
            }
        }
        return eb(viewGroup, pVar2.f6778n3, pVar, pVar2);
    }

    @Nullable
    public abstract Animator nf(ViewGroup viewGroup, View view, p pVar, p pVar2);

    /* JADX WARN: Code restructure failed: missing block: B:43:0x008f, code lost:
        if (r17.f6751qn != false) goto L52;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004a  */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.animation.Animator ra(android.view.ViewGroup r18, cr.p r19, int r20, cr.p r21, int r22) {
        /*
            Method dump skipped, instructions count: 263
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cr.ta.ra(android.view.ViewGroup, cr.p, int, cr.p, int):android.animation.Animator");
    }

    public final zn rs(p pVar, p pVar2) {
        zn znVar = new zn();
        znVar.y = false;
        znVar.f6792n3 = false;
        if (pVar != null && pVar.y.containsKey("android:visibility:visibility")) {
            znVar.f6794zn = ((Integer) pVar.y.get("android:visibility:visibility")).intValue();
            znVar.f6793v = (ViewGroup) pVar.y.get("android:visibility:parent");
        } else {
            znVar.f6794zn = -1;
            znVar.f6793v = null;
        }
        if (pVar2 != null && pVar2.y.containsKey("android:visibility:visibility")) {
            znVar.f6791gv = ((Integer) pVar2.y.get("android:visibility:visibility")).intValue();
            znVar.f6790a = (ViewGroup) pVar2.y.get("android:visibility:parent");
        } else {
            znVar.f6791gv = -1;
            znVar.f6790a = null;
        }
        if (pVar != null && pVar2 != null) {
            int i = znVar.f6794zn;
            int i5 = znVar.f6791gv;
            if (i == i5 && znVar.f6793v == znVar.f6790a) {
                return znVar;
            }
            if (i != i5) {
                if (i == 0) {
                    znVar.f6792n3 = false;
                    znVar.y = true;
                } else if (i5 == 0) {
                    znVar.f6792n3 = true;
                    znVar.y = true;
                }
            } else if (znVar.f6790a == null) {
                znVar.f6792n3 = false;
                znVar.y = true;
            } else if (znVar.f6793v == null) {
                znVar.f6792n3 = true;
                znVar.y = true;
            }
        } else if (pVar == null && znVar.f6791gv == 0) {
            znVar.f6792n3 = true;
            znVar.y = true;
        } else if (pVar2 == null && znVar.f6794zn == 0) {
            znVar.f6792n3 = false;
            znVar.y = true;
        }
        return znVar;
    }

    @Override // cr.f
    public void s(@NonNull p pVar) {
        o4(pVar);
    }

    @Override // cr.f
    @Nullable
    public Animator xc(@NonNull ViewGroup viewGroup, @Nullable p pVar, @Nullable p pVar2) {
        zn rs2 = rs(pVar, pVar2);
        if (rs2.y) {
            if (rs2.f6793v != null || rs2.f6790a != null) {
                if (rs2.f6792n3) {
                    return lc(viewGroup, pVar, rs2.f6794zn, pVar2, rs2.f6791gv);
                }
                return ra(viewGroup, pVar, rs2.f6794zn, pVar2, rs2.f6791gv);
            }
            return null;
        }
        return null;
    }

    /* loaded from: classes.dex */
    public static class n3 extends AnimatorListenerAdapter implements f.fb {

        /* renamed from: a  reason: collision with root package name */
        public boolean f6782a;

        /* renamed from: gv  reason: collision with root package name */
        public final boolean f6783gv;

        /* renamed from: n3  reason: collision with root package name */
        public final int f6784n3;

        /* renamed from: v  reason: collision with root package name */
        public boolean f6785v;
        public final View y;

        /* renamed from: zn  reason: collision with root package name */
        public final ViewGroup f6786zn;

        public n3(View view, int i, boolean z2) {
            this.y = view;
            this.f6784n3 = i;
            this.f6786zn = (ViewGroup) view.getParent();
            this.f6783gv = z2;
            fb(true);
        }

        public final void a() {
            if (!this.f6782a) {
                f3.s(this.y, this.f6784n3);
                ViewGroup viewGroup = this.f6786zn;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
            fb(false);
        }

        public final void fb(boolean z2) {
            ViewGroup viewGroup;
            if (this.f6783gv && this.f6785v != z2 && (viewGroup = this.f6786zn) != null) {
                this.f6785v = z2;
                r.zn(viewGroup, z2);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f6782a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationPause(Animator animator) {
            if (!this.f6782a) {
                f3.s(this.y, this.f6784n3);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationResume(Animator animator) {
            if (!this.f6782a) {
                f3.s(this.y, 0);
            }
        }

        @Override // cr.f.fb
        public void v(@NonNull f fVar) {
            fb(false);
        }

        @Override // cr.f.fb
        public void y(@NonNull f fVar) {
            fb(true);
        }

        @Override // cr.f.fb
        public void zn(@NonNull f fVar) {
            a();
            fVar.j(this);
        }

        @Override // cr.f.fb
        public void gv(@NonNull f fVar) {
        }

        @Override // cr.f.fb
        public void n3(@NonNull f fVar) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }
}
