package u4;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
/* loaded from: classes.dex */
public class zn<V extends View> extends CoordinatorLayout.zn<V> {

    /* renamed from: n3  reason: collision with root package name */
    public int f14049n3;
    public gv y;

    /* renamed from: zn  reason: collision with root package name */
    public int f14050zn;

    public zn() {
    }

    public void d(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v2, int i) {
        coordinatorLayout.ud(v2, i);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.zn
    public boolean t(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v2, int i) {
        d(coordinatorLayout, v2, i);
        if (this.y == null) {
            this.y = new gv(v2);
        }
        this.y.zn();
        this.y.y();
        int i5 = this.f14049n3;
        if (i5 != 0) {
            this.y.v(i5);
            this.f14049n3 = 0;
        }
        int i6 = this.f14050zn;
        if (i6 != 0) {
            this.y.gv(i6);
            this.f14050zn = 0;
            return true;
        }
        return true;
    }

    public int ta() {
        gv gvVar = this.y;
        if (gvVar != null) {
            return gvVar.n3();
        }
        return 0;
    }

    public boolean z6(int i) {
        gv gvVar = this.y;
        if (gvVar != null) {
            return gvVar.v(i);
        }
        this.f14049n3 = i;
        return false;
    }

    public zn(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
