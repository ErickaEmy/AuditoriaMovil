package androidx.compose.ui.layout;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: BeyondBoundsLayout.kt */
/* loaded from: classes.dex */
public interface BeyondBoundsLayout {

    /* compiled from: BeyondBoundsLayout.kt */
    /* loaded from: classes.dex */
    public interface BeyondBoundsScope {
        boolean getHasMoreContent();
    }

    /* renamed from: layout-o7g1Pn8 */
    Object mo264layouto7g1Pn8(int i, Function1 function1);

    /* compiled from: BeyondBoundsLayout.kt */
    /* loaded from: classes.dex */
    public static final class LayoutDirection {
        public static final Companion Companion = new Companion(null);
        private static final int Before = m1233constructorimpl(1);
        private static final int After = m1233constructorimpl(2);
        private static final int Left = m1233constructorimpl(3);
        private static final int Right = m1233constructorimpl(4);
        private static final int Above = m1233constructorimpl(5);
        private static final int Below = m1233constructorimpl(6);

        /* renamed from: constructor-impl  reason: not valid java name */
        public static int m1233constructorimpl(int i) {
            return i;
        }

        /* renamed from: equals-impl0  reason: not valid java name */
        public static final boolean m1234equalsimpl0(int i, int i2) {
            return i == i2;
        }

        /* compiled from: BeyondBoundsLayout.kt */
        /* loaded from: classes.dex */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* renamed from: getBefore-hoxUOeE  reason: not valid java name */
            public final int m1237getBeforehoxUOeE() {
                return LayoutDirection.Before;
            }

            /* renamed from: getAfter-hoxUOeE  reason: not valid java name */
            public final int m1236getAfterhoxUOeE() {
                return LayoutDirection.After;
            }

            /* renamed from: getLeft-hoxUOeE  reason: not valid java name */
            public final int m1239getLefthoxUOeE() {
                return LayoutDirection.Left;
            }

            /* renamed from: getRight-hoxUOeE  reason: not valid java name */
            public final int m1240getRighthoxUOeE() {
                return LayoutDirection.Right;
            }

            /* renamed from: getAbove-hoxUOeE  reason: not valid java name */
            public final int m1235getAbovehoxUOeE() {
                return LayoutDirection.Above;
            }

            /* renamed from: getBelow-hoxUOeE  reason: not valid java name */
            public final int m1238getBelowhoxUOeE() {
                return LayoutDirection.Below;
            }
        }
    }
}
