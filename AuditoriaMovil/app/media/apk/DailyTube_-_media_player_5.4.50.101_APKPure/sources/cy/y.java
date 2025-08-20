package cy;

import android.animation.LayoutTransition;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
/* loaded from: classes.dex */
public final class y {

    /* renamed from: n3  reason: collision with root package name */
    public static final ViewGroup.MarginLayoutParams f6908n3;
    public LinearLayoutManager y;

    /* renamed from: cy.y$y  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0077y implements Comparator<int[]> {
        public C0077y() {
        }

        @Override // java.util.Comparator
        /* renamed from: y */
        public int compare(int[] iArr, int[] iArr2) {
            return iArr[0] - iArr2[0];
        }
    }

    static {
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -1);
        f6908n3 = marginLayoutParams;
        marginLayoutParams.setMargins(0, 0, 0, 0);
    }

    public y(@NonNull LinearLayoutManager linearLayoutManager) {
        this.y = linearLayoutManager;
    }

    public static boolean zn(View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            LayoutTransition layoutTransition = viewGroup.getLayoutTransition();
            if (layoutTransition != null && layoutTransition.isChangingLayout()) {
                return true;
            }
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (zn(viewGroup.getChildAt(i))) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean gv() {
        if ((!y() || this.y.oz() <= 1) && n3()) {
            return true;
        }
        return false;
    }

    public final boolean n3() {
        int oz2 = this.y.oz();
        for (int i = 0; i < oz2; i++) {
            if (zn(this.y.j(i))) {
                return true;
            }
        }
        return false;
    }

    public final boolean y() {
        boolean z2;
        ViewGroup.MarginLayoutParams marginLayoutParams;
        int top;
        int i;
        int bottom;
        int i5;
        int oz2 = this.y.oz();
        if (oz2 == 0) {
            return true;
        }
        if (this.y.j4() == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        int[][] iArr = (int[][]) Array.newInstance(Integer.TYPE, oz2, 2);
        for (int i6 = 0; i6 < oz2; i6++) {
            View j2 = this.y.j(i6);
            if (j2 != null) {
                ViewGroup.LayoutParams layoutParams = j2.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                } else {
                    marginLayoutParams = f6908n3;
                }
                int[] iArr2 = iArr[i6];
                if (z2) {
                    top = j2.getLeft();
                    i = marginLayoutParams.leftMargin;
                } else {
                    top = j2.getTop();
                    i = marginLayoutParams.topMargin;
                }
                iArr2[0] = top - i;
                int[] iArr3 = iArr[i6];
                if (z2) {
                    bottom = j2.getRight();
                    i5 = marginLayoutParams.rightMargin;
                } else {
                    bottom = j2.getBottom();
                    i5 = marginLayoutParams.bottomMargin;
                }
                iArr3[1] = bottom + i5;
            } else {
                throw new IllegalStateException("null view contained in the view hierarchy");
            }
        }
        Arrays.sort(iArr, new C0077y());
        for (int i8 = 1; i8 < oz2; i8++) {
            if (iArr[i8 - 1][1] != iArr[i8][0]) {
                return false;
            }
        }
        int[] iArr4 = iArr[0];
        int i10 = iArr4[1];
        int i11 = iArr4[0];
        int i12 = i10 - i11;
        if (i11 <= 0 && iArr[oz2 - 1][1] >= i12) {
            return true;
        }
        return false;
    }
}
