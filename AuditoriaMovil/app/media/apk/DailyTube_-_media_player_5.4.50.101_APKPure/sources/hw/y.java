package hw;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.R$id;
import j5.zn;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public class y {

    /* renamed from: zn  reason: collision with root package name */
    public static final View.AccessibilityDelegate f8998zn = new View.AccessibilityDelegate();

    /* renamed from: n3  reason: collision with root package name */
    public final View.AccessibilityDelegate f8999n3;
    public final View.AccessibilityDelegate y;

    /* loaded from: classes.dex */
    public static class n3 {
        public static boolean n3(View.AccessibilityDelegate accessibilityDelegate, View view, int i, Bundle bundle) {
            return accessibilityDelegate.performAccessibilityAction(view, i, bundle);
        }

        public static AccessibilityNodeProvider y(View.AccessibilityDelegate accessibilityDelegate, View view) {
            return accessibilityDelegate.getAccessibilityNodeProvider(view);
        }
    }

    /* renamed from: hw.y$y  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0110y extends View.AccessibilityDelegate {
        public final y y;

        public C0110y(y yVar) {
            this.y = yVar;
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            return this.y.y(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
            j5.gv n32 = this.y.n3(view);
            if (n32 != null) {
                return (AccessibilityNodeProvider) n32.v();
            }
            return null;
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.y.a(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            j5.zn w22 = j5.zn.w2(accessibilityNodeInfo);
            w22.xb(i4.en(view));
            w22.u0(i4.oz(view));
            w22.pz(i4.mt(view));
            w22.l(i4.k5(view));
            this.y.fb(view, w22);
            w22.a(accessibilityNodeInfo.getText(), view);
            List<zn.y> zn2 = y.zn(view);
            for (int i = 0; i < zn2.size(); i++) {
                w22.n3(zn2.get(i));
            }
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.y.s(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return this.y.c5(viewGroup, view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            return this.y.i9(view, i, bundle);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEvent(View view, int i) {
            this.y.t(view, i);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
            this.y.tl(view, accessibilityEvent);
        }
    }

    public y() {
        this(f8998zn);
    }

    public static List<zn.y> zn(View view) {
        List<zn.y> list = (List) view.getTag(R$id.f2103ej);
        if (list == null) {
            return Collections.emptyList();
        }
        return list;
    }

    public void a(@NonNull View view, @NonNull AccessibilityEvent accessibilityEvent) {
        this.y.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public boolean c5(@NonNull ViewGroup viewGroup, @NonNull View view, @NonNull AccessibilityEvent accessibilityEvent) {
        return this.y.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public final boolean f(int i, View view) {
        WeakReference weakReference;
        SparseArray sparseArray = (SparseArray) view.getTag(R$id.f2127ud);
        if (sparseArray != null && (weakReference = (WeakReference) sparseArray.get(i)) != null) {
            ClickableSpan clickableSpan = (ClickableSpan) weakReference.get();
            if (v(clickableSpan, view)) {
                clickableSpan.onClick(view);
                return true;
            }
            return false;
        }
        return false;
    }

    public void fb(@NonNull View view, @NonNull j5.zn znVar) {
        this.y.onInitializeAccessibilityNodeInfo(view, znVar.w9());
    }

    public View.AccessibilityDelegate gv() {
        return this.f8999n3;
    }

    public boolean i9(@NonNull View view, int i, @Nullable Bundle bundle) {
        List<zn.y> zn2 = zn(view);
        boolean z2 = false;
        int i5 = 0;
        while (true) {
            if (i5 >= zn2.size()) {
                break;
            }
            zn.y yVar = zn2.get(i5);
            if (yVar.n3() == i) {
                z2 = yVar.gv(view, bundle);
                break;
            }
            i5++;
        }
        if (!z2) {
            z2 = n3.n3(this.y, view, i, bundle);
        }
        if (!z2 && i == R$id.y && bundle != null) {
            return f(bundle.getInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", -1), view);
        }
        return z2;
    }

    @Nullable
    public j5.gv n3(@NonNull View view) {
        AccessibilityNodeProvider y = n3.y(this.y, view);
        if (y != null) {
            return new j5.gv(y);
        }
        return null;
    }

    public void s(@NonNull View view, @NonNull AccessibilityEvent accessibilityEvent) {
        this.y.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public void t(@NonNull View view, int i) {
        this.y.sendAccessibilityEvent(view, i);
    }

    public void tl(@NonNull View view, @NonNull AccessibilityEvent accessibilityEvent) {
        this.y.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }

    public final boolean v(ClickableSpan clickableSpan, View view) {
        if (clickableSpan != null) {
            ClickableSpan[] mt2 = j5.zn.mt(view.createAccessibilityNodeInfo().getText());
            for (int i = 0; mt2 != null && i < mt2.length; i++) {
                if (clickableSpan.equals(mt2[i])) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean y(@NonNull View view, @NonNull AccessibilityEvent accessibilityEvent) {
        return this.y.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public y(@NonNull View.AccessibilityDelegate accessibilityDelegate) {
        this.y = accessibilityDelegate;
        this.f8999n3 = new C0110y(this);
    }
}
