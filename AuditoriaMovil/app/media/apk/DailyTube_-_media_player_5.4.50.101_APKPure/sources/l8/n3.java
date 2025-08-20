package l8;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class n3 {

    /* renamed from: c5  reason: collision with root package name */
    public static final String f10252c5 = "l8.n3";

    /* renamed from: a  reason: collision with root package name */
    public final ViewGroup.LayoutParams f10253a;

    /* renamed from: fb  reason: collision with root package name */
    public int f10254fb;

    /* renamed from: gv  reason: collision with root package name */
    public View f10255gv;

    /* renamed from: n3  reason: collision with root package name */
    public View f10256n3;

    /* renamed from: s  reason: collision with root package name */
    public final int f10257s;

    /* renamed from: v  reason: collision with root package name */
    public ViewGroup f10258v;
    public final View y;

    /* renamed from: zn  reason: collision with root package name */
    public int f10259zn = -1;

    public n3(View view) {
        this.y = view;
        this.f10253a = view.getLayoutParams();
        this.f10255gv = view;
        this.f10257s = view.getId();
    }

    public void gv() {
        ViewGroup viewGroup = this.f10258v;
        if (viewGroup != null) {
            viewGroup.removeView(this.f10255gv);
            this.f10258v.addView(this.y, this.f10254fb, this.f10253a);
            this.f10255gv = this.y;
            this.f10256n3 = null;
            this.f10259zn = -1;
        }
    }

    public final boolean n3() {
        if (this.f10258v == null) {
            ViewGroup viewGroup = (ViewGroup) this.y.getParent();
            this.f10258v = viewGroup;
            if (viewGroup == null) {
                Log.e(f10252c5, "the source view have not attach to any view");
                return false;
            }
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (this.y == this.f10258v.getChildAt(i)) {
                    this.f10254fb = i;
                    return true;
                }
            }
            return true;
        }
        return true;
    }

    public View y() {
        return this.f10256n3;
    }

    public void zn(View view) {
        if (this.f10255gv == view) {
            return;
        }
        if (view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        if (n3()) {
            this.f10256n3 = view;
            this.f10258v.removeView(this.f10255gv);
            this.f10256n3.setId(this.f10257s);
            this.f10258v.addView(this.f10256n3, this.f10254fb, this.f10253a);
            this.f10255gv = this.f10256n3;
        }
    }
}
