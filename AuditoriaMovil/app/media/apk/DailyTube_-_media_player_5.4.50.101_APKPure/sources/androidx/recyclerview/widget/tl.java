package androidx.recyclerview.widget;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import hw.i4;
import java.util.Map;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public class tl extends hw.y {

    /* renamed from: gv  reason: collision with root package name */
    public final RecyclerView f3282gv;

    /* renamed from: v  reason: collision with root package name */
    public final y f3283v;

    /* loaded from: classes.dex */
    public static class y extends hw.y {

        /* renamed from: gv  reason: collision with root package name */
        public final tl f3284gv;

        /* renamed from: v  reason: collision with root package name */
        public Map<View, hw.y> f3285v = new WeakHashMap();

        public y(@NonNull tl tlVar) {
            this.f3284gv = tlVar;
        }

        @Override // hw.y
        public void a(@NonNull View view, @NonNull AccessibilityEvent accessibilityEvent) {
            hw.y yVar = this.f3285v.get(view);
            if (yVar != null) {
                yVar.a(view, accessibilityEvent);
            } else {
                super.a(view, accessibilityEvent);
            }
        }

        @Override // hw.y
        public boolean c5(@NonNull ViewGroup viewGroup, @NonNull View view, @NonNull AccessibilityEvent accessibilityEvent) {
            hw.y yVar = this.f3285v.get(viewGroup);
            if (yVar != null) {
                return yVar.c5(viewGroup, view, accessibilityEvent);
            }
            return super.c5(viewGroup, view, accessibilityEvent);
        }

        @Override // hw.y
        public void fb(View view, j5.zn znVar) {
            if (!this.f3284gv.xc() && this.f3284gv.f3282gv.getLayoutManager() != null) {
                this.f3284gv.f3282gv.getLayoutManager().yk(view, znVar);
                hw.y yVar = this.f3285v.get(view);
                if (yVar != null) {
                    yVar.fb(view, znVar);
                    return;
                } else {
                    super.fb(view, znVar);
                    return;
                }
            }
            super.fb(view, znVar);
        }

        @Override // hw.y
        public boolean i9(View view, int i, Bundle bundle) {
            if (!this.f3284gv.xc() && this.f3284gv.f3282gv.getLayoutManager() != null) {
                hw.y yVar = this.f3285v.get(view);
                if (yVar != null) {
                    if (yVar.i9(view, i, bundle)) {
                        return true;
                    }
                } else if (super.i9(view, i, bundle)) {
                    return true;
                }
                return this.f3284gv.f3282gv.getLayoutManager().r6(view, i, bundle);
            }
            return super.i9(view, i, bundle);
        }

        @Override // hw.y
        @Nullable
        public j5.gv n3(@NonNull View view) {
            hw.y yVar = this.f3285v.get(view);
            if (yVar != null) {
                return yVar.n3(view);
            }
            return super.n3(view);
        }

        @Override // hw.y
        public void s(@NonNull View view, @NonNull AccessibilityEvent accessibilityEvent) {
            hw.y yVar = this.f3285v.get(view);
            if (yVar != null) {
                yVar.s(view, accessibilityEvent);
            } else {
                super.s(view, accessibilityEvent);
            }
        }

        @Override // hw.y
        public void t(@NonNull View view, int i) {
            hw.y yVar = this.f3285v.get(view);
            if (yVar != null) {
                yVar.t(view, i);
            } else {
                super.t(view, i);
            }
        }

        @Override // hw.y
        public void tl(@NonNull View view, @NonNull AccessibilityEvent accessibilityEvent) {
            hw.y yVar = this.f3285v.get(view);
            if (yVar != null) {
                yVar.tl(view, accessibilityEvent);
            } else {
                super.tl(view, accessibilityEvent);
            }
        }

        public hw.y wz(View view) {
            return this.f3285v.remove(view);
        }

        public void xc(View view) {
            hw.y wz2 = i4.wz(view);
            if (wz2 != null && wz2 != this) {
                this.f3285v.put(view, wz2);
            }
        }

        @Override // hw.y
        public boolean y(@NonNull View view, @NonNull AccessibilityEvent accessibilityEvent) {
            hw.y yVar = this.f3285v.get(view);
            if (yVar != null) {
                return yVar.y(view, accessibilityEvent);
            }
            return super.y(view, accessibilityEvent);
        }
    }

    public tl(@NonNull RecyclerView recyclerView) {
        this.f3282gv = recyclerView;
        hw.y wz2 = wz();
        if (wz2 != null && (wz2 instanceof y)) {
            this.f3283v = (y) wz2;
        } else {
            this.f3283v = new y(this);
        }
    }

    @Override // hw.y
    public void a(View view, AccessibilityEvent accessibilityEvent) {
        super.a(view, accessibilityEvent);
        if ((view instanceof RecyclerView) && !xc()) {
            RecyclerView recyclerView = (RecyclerView) view;
            if (recyclerView.getLayoutManager() != null) {
                recyclerView.getLayoutManager().le(accessibilityEvent);
            }
        }
    }

    @Override // hw.y
    public void fb(View view, j5.zn znVar) {
        super.fb(view, znVar);
        if (!xc() && this.f3282gv.getLayoutManager() != null) {
            this.f3282gv.getLayoutManager().ix(znVar);
        }
    }

    @Override // hw.y
    public boolean i9(View view, int i, Bundle bundle) {
        if (super.i9(view, i, bundle)) {
            return true;
        }
        if (!xc() && this.f3282gv.getLayoutManager() != null) {
            return this.f3282gv.getLayoutManager().h(i, bundle);
        }
        return false;
    }

    @NonNull
    public hw.y wz() {
        return this.f3283v;
    }

    public boolean xc() {
        return this.f3282gv.hasPendingAdapterUpdates();
    }
}
