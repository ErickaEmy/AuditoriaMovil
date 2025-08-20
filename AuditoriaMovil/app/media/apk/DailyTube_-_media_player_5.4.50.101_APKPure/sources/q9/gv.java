package q9;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBinderMapperImpl;
import androidx.databinding.ViewDataBinding;
/* loaded from: classes.dex */
public class gv {
    public static n3 y = new DataBinderMapperImpl();

    /* renamed from: n3  reason: collision with root package name */
    public static zn f12786n3 = null;

    @Nullable
    public static <T extends ViewDataBinding> T a(@NonNull View view) {
        while (view != null) {
            T t2 = (T) ViewDataBinding.pz(view);
            if (t2 != null) {
                return t2;
            }
            Object tag = view.getTag();
            if (tag instanceof String) {
                String str = (String) tag;
                if (str.startsWith("layout") && str.endsWith("_0")) {
                    char charAt = str.charAt(6);
                    int indexOf = str.indexOf(47, 7);
                    if (charAt == '/') {
                        if (indexOf == -1) {
                            return null;
                        }
                    } else if (charAt == '-' && indexOf != -1 && str.indexOf(47, indexOf + 1) == -1) {
                        return null;
                    }
                }
            }
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                view = (View) parent;
            } else {
                view = null;
            }
        }
        return null;
    }

    public static <T extends ViewDataBinding> T c5(@NonNull LayoutInflater layoutInflater, int i, @Nullable ViewGroup viewGroup, boolean z2) {
        return (T) i9(layoutInflater, i, viewGroup, z2, f12786n3);
    }

    public static <T extends ViewDataBinding> T f(@NonNull Activity activity, int i) {
        return (T) t(activity, i, f12786n3);
    }

    @Nullable
    public static <T extends ViewDataBinding> T fb(@NonNull View view) {
        return (T) ViewDataBinding.pz(view);
    }

    public static <T extends ViewDataBinding> T gv(zn znVar, View[] viewArr, int i) {
        return (T) y.zn(znVar, viewArr, i);
    }

    public static <T extends ViewDataBinding> T i9(@NonNull LayoutInflater layoutInflater, int i, @Nullable ViewGroup viewGroup, boolean z2, @Nullable zn znVar) {
        boolean z3;
        int i5 = 0;
        if (viewGroup != null && z2) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            i5 = viewGroup.getChildCount();
        }
        View inflate = layoutInflater.inflate(i, viewGroup, z2);
        if (z3) {
            return (T) v(znVar, viewGroup, i5, i);
        }
        return (T) zn(znVar, inflate, i);
    }

    @Nullable
    public static <T extends ViewDataBinding> T n3(@NonNull View view, zn znVar) {
        T t2 = (T) fb(view);
        if (t2 != null) {
            return t2;
        }
        Object tag = view.getTag();
        if (tag instanceof String) {
            int gv2 = y.gv((String) tag);
            if (gv2 != 0) {
                return (T) y.n3(znVar, view, gv2);
            }
            throw new IllegalArgumentException("View is not a binding layout. Tag: " + tag);
        }
        throw new IllegalArgumentException("View is not a binding layout");
    }

    @Nullable
    public static zn s() {
        return f12786n3;
    }

    public static <T extends ViewDataBinding> T t(@NonNull Activity activity, int i, @Nullable zn znVar) {
        activity.setContentView(i);
        return (T) v(znVar, (ViewGroup) activity.getWindow().getDecorView().findViewById(16908290), 0, i);
    }

    public static <T extends ViewDataBinding> T v(zn znVar, ViewGroup viewGroup, int i, int i5) {
        int childCount = viewGroup.getChildCount();
        int i6 = childCount - i;
        if (i6 == 1) {
            return (T) zn(znVar, viewGroup.getChildAt(childCount - 1), i5);
        }
        View[] viewArr = new View[i6];
        for (int i8 = 0; i8 < i6; i8++) {
            viewArr[i8] = viewGroup.getChildAt(i8 + i);
        }
        return (T) gv(znVar, viewArr, i5);
    }

    @Nullable
    public static <T extends ViewDataBinding> T y(@NonNull View view) {
        return (T) n3(view, f12786n3);
    }

    public static <T extends ViewDataBinding> T zn(zn znVar, View view, int i) {
        return (T) y.n3(znVar, view, i);
    }
}
