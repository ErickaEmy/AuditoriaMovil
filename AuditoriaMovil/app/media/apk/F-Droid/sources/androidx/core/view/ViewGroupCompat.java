package androidx.core.view;

import android.view.ViewGroup;
/* loaded from: classes.dex */
public abstract class ViewGroupCompat {
    public static int getLayoutMode(ViewGroup viewGroup) {
        return Api18Impl.getLayoutMode(viewGroup);
    }

    public static boolean isTransitionGroup(ViewGroup viewGroup) {
        return Api21Impl.isTransitionGroup(viewGroup);
    }

    /* loaded from: classes.dex */
    static class Api18Impl {
        static int getLayoutMode(ViewGroup viewGroup) {
            return viewGroup.getLayoutMode();
        }

        static void setLayoutMode(ViewGroup viewGroup, int i) {
            viewGroup.setLayoutMode(i);
        }
    }

    /* loaded from: classes.dex */
    static class Api21Impl {
        static void setTransitionGroup(ViewGroup viewGroup, boolean z) {
            viewGroup.setTransitionGroup(z);
        }

        static boolean isTransitionGroup(ViewGroup viewGroup) {
            return viewGroup.isTransitionGroup();
        }

        static int getNestedScrollAxes(ViewGroup viewGroup) {
            return viewGroup.getNestedScrollAxes();
        }
    }
}
