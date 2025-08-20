package i9;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.StateSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import i9.n3;
@SuppressLint({"RestrictedAPI"})
/* loaded from: classes.dex */
public class gv extends n3 {

    /* renamed from: c  reason: collision with root package name */
    public boolean f9119c;

    /* renamed from: n  reason: collision with root package name */
    public y f9120n;

    /* loaded from: classes.dex */
    public static class y extends n3.gv {

        /* renamed from: a8  reason: collision with root package name */
        public int[][] f9121a8;

        public y(y yVar, gv gvVar, Resources resources) {
            super(yVar, gvVar, resources);
            if (yVar != null) {
                this.f9121a8 = yVar.f9121a8;
            } else {
                this.f9121a8 = new int[a()];
            }
        }

        public int c(int[] iArr, Drawable drawable) {
            int y = y(drawable);
            this.f9121a8[y] = iArr;
            return y;
        }

        public int d0(int[] iArr) {
            int[][] iArr2 = this.f9121a8;
            int s2 = s();
            for (int i = 0; i < s2; i++) {
                if (StateSet.stateSetMatches(iArr2[i], iArr)) {
                    return i;
                }
            }
            return -1;
        }

        @Override // i9.n3.gv
        public void mt() {
            int[] iArr;
            int[][] iArr2 = this.f9121a8;
            int[][] iArr3 = new int[iArr2.length];
            for (int length = iArr2.length - 1; length >= 0; length--) {
                int[] iArr4 = this.f9121a8[length];
                if (iArr4 != null) {
                    iArr = (int[]) iArr4.clone();
                } else {
                    iArr = null;
                }
                iArr3[length] = iArr;
            }
            this.f9121a8 = iArr3;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable() {
            return new gv(this, null);
        }

        @Override // i9.n3.gv
        public void xc(int i, int i5) {
            super.xc(i, i5);
            int[][] iArr = new int[i5];
            System.arraycopy(this.f9121a8, 0, iArr, 0, i);
            this.f9121a8 = iArr;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable(Resources resources) {
            return new gv(this, resources);
        }
    }

    public gv(y yVar, Resources resources) {
        s(new y(yVar, this, resources));
        onStateChange(getState());
    }

    @Override // i9.n3, android.graphics.drawable.Drawable
    public void applyTheme(@NonNull Resources.Theme theme) {
        super.applyTheme(theme);
        onStateChange(getState());
    }

    public int[] f(AttributeSet attributeSet) {
        int attributeCount = attributeSet.getAttributeCount();
        int[] iArr = new int[attributeCount];
        int i = 0;
        for (int i5 = 0; i5 < attributeCount; i5++) {
            int attributeNameResource = attributeSet.getAttributeNameResource(i5);
            if (attributeNameResource != 0 && attributeNameResource != 16842960 && attributeNameResource != 16843161) {
                int i6 = i + 1;
                if (!attributeSet.getAttributeBooleanValue(i5, false)) {
                    attributeNameResource = -attributeNameResource;
                }
                iArr[i] = attributeNameResource;
                i = i6;
            }
        }
        return StateSet.trimStateSet(iArr, i);
    }

    @Override // i9.n3
    /* renamed from: i9 */
    public y n3() {
        return new y(this.f9120n, this, null);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // i9.n3, android.graphics.drawable.Drawable
    @NonNull
    public Drawable mutate() {
        if (!this.f9119c && super.mutate() == this) {
            this.f9120n.mt();
            this.f9119c = true;
        }
        return this;
    }

    @Override // i9.n3, android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        boolean onStateChange = super.onStateChange(iArr);
        int d02 = this.f9120n.d0(iArr);
        if (d02 < 0) {
            d02 = this.f9120n.d0(StateSet.WILD_CARD);
        }
        if (!fb(d02) && !onStateChange) {
            return false;
        }
        return true;
    }

    @Override // i9.n3
    public void s(@NonNull n3.gv gvVar) {
        super.s(gvVar);
        if (gvVar instanceof y) {
            this.f9120n = (y) gvVar;
        }
    }

    public gv(@Nullable y yVar) {
        if (yVar != null) {
            s(yVar);
        }
    }
}
