package hw;

import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import androidx.annotation.NonNull;
/* loaded from: classes.dex */
public final class fh {

    /* loaded from: classes.dex */
    public static class y {
        public static boolean a(ViewParent viewParent, View view, View view2, int i) {
            return viewParent.onStartNestedScroll(view, view2, i);
        }

        public static void fb(ViewParent viewParent, View view) {
            viewParent.onStopNestedScroll(view);
        }

        public static void gv(ViewParent viewParent, View view, int i, int i5, int i6, int i8) {
            viewParent.onNestedScroll(view, i, i5, i6, i8);
        }

        public static boolean n3(ViewParent viewParent, View view, float f4, float f6) {
            return viewParent.onNestedPreFling(view, f4, f6);
        }

        public static void v(ViewParent viewParent, View view, View view2, int i) {
            viewParent.onNestedScrollAccepted(view, view2, i);
        }

        public static boolean y(ViewParent viewParent, View view, float f4, float f6, boolean z2) {
            return viewParent.onNestedFling(view, f4, f6, z2);
        }

        public static void zn(ViewParent viewParent, View view, int i, int i5, int[] iArr) {
            viewParent.onNestedPreScroll(view, i, i5, iArr);
        }
    }

    public static boolean a(@NonNull ViewParent viewParent, @NonNull View view, @NonNull View view2, int i, int i5) {
        if (viewParent instanceof tl) {
            return ((tl) viewParent).xc(view, view2, i, i5);
        }
        if (i5 == 0) {
            try {
                return y.a(viewParent, view, view2, i);
            } catch (AbstractMethodError e2) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onStartNestedScroll", e2);
                return false;
            }
        }
        return false;
    }

    public static void fb(@NonNull ViewParent viewParent, @NonNull View view, int i) {
        if (viewParent instanceof tl) {
            ((tl) viewParent).i9(view, i);
        } else if (i == 0) {
            try {
                y.fb(viewParent, view);
            } catch (AbstractMethodError e2) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onStopNestedScroll", e2);
            }
        }
    }

    public static void gv(@NonNull ViewParent viewParent, @NonNull View view, int i, int i5, int i6, int i8, int i10, @NonNull int[] iArr) {
        if (viewParent instanceof wz) {
            ((wz) viewParent).tl(view, i, i5, i6, i8, i10, iArr);
            return;
        }
        iArr[0] = iArr[0] + i6;
        iArr[1] = iArr[1] + i8;
        if (viewParent instanceof tl) {
            ((tl) viewParent).wz(view, i, i5, i6, i8, i10);
        } else if (i10 == 0) {
            try {
                y.gv(viewParent, view, i, i5, i6, i8);
            } catch (AbstractMethodError e2) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedScroll", e2);
            }
        }
    }

    public static boolean n3(@NonNull ViewParent viewParent, @NonNull View view, float f4, float f6) {
        try {
            return y.n3(viewParent, view, f4, f6);
        } catch (AbstractMethodError e2) {
            Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedPreFling", e2);
            return false;
        }
    }

    public static void v(@NonNull ViewParent viewParent, @NonNull View view, @NonNull View view2, int i, int i5) {
        if (viewParent instanceof tl) {
            ((tl) viewParent).c5(view, view2, i, i5);
        } else if (i5 == 0) {
            try {
                y.v(viewParent, view, view2, i);
            } catch (AbstractMethodError e2) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedScrollAccepted", e2);
            }
        }
    }

    public static boolean y(@NonNull ViewParent viewParent, @NonNull View view, float f4, float f6, boolean z2) {
        try {
            return y.y(viewParent, view, f4, f6, z2);
        } catch (AbstractMethodError e2) {
            Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedFling", e2);
            return false;
        }
    }

    public static void zn(@NonNull ViewParent viewParent, @NonNull View view, int i, int i5, @NonNull int[] iArr, int i6) {
        if (viewParent instanceof tl) {
            ((tl) viewParent).f(view, i, i5, iArr, i6);
        } else if (i6 == 0) {
            try {
                y.zn(viewParent, view, i, i5, iArr);
            } catch (AbstractMethodError e2) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedPreScroll", e2);
            }
        }
    }
}
