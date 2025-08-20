package lf;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import j.zn;
import wz.a;
/* loaded from: classes.dex */
public class y extends a {

    /* renamed from: t  reason: collision with root package name */
    public static final int f10362t = R$style.f5107co;

    /* renamed from: w  reason: collision with root package name */
    public static final int[][] f10363w = {new int[]{16842910, 16842912}, new int[]{16842910, -16842912}, new int[]{-16842910, 16842912}, new int[]{-16842910, -16842912}};

    /* renamed from: f  reason: collision with root package name */
    public boolean f10364f;
    @Nullable

    /* renamed from: s  reason: collision with root package name */
    public ColorStateList f10365s;

    public y(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.f5078a);
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.f10365s == null) {
            int[][] iArr = f10363w;
            int[] iArr2 = new int[iArr.length];
            int gv2 = td.y.gv(this, R$attr.f5081c5);
            int gv3 = td.y.gv(this, R$attr.uh);
            int gv4 = td.y.gv(this, R$attr.y5);
            iArr2[0] = td.y.fb(gv3, gv2, 1.0f);
            iArr2[1] = td.y.fb(gv3, gv4, 0.54f);
            iArr2[2] = td.y.fb(gv3, gv4, 0.38f);
            iArr2[3] = td.y.fb(gv3, gv4, 0.38f);
            this.f10365s = new ColorStateList(iArr, iArr2);
        }
        return this.f10365s;
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f10364f && zn.n3(this) == null) {
            setUseMaterialThemeColors(true);
        }
    }

    public void setUseMaterialThemeColors(boolean z2) {
        this.f10364f = z2;
        if (z2) {
            zn.zn(this, getMaterialThemeColorsTintList());
        } else {
            zn.zn(this, null);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public y(android.content.Context r8, @androidx.annotation.Nullable android.util.AttributeSet r9, int r10) {
        /*
            r7 = this;
            int r4 = lf.y.f10362t
            android.content.Context r8 = c0.y.zn(r8, r9, r10, r4)
            r7.<init>(r8, r9, r10)
            android.content.Context r8 = r7.getContext()
            int[] r2 = com.google.android.material.R$styleable.s0
            r6 = 0
            int[] r5 = new int[r6]
            r0 = r8
            r1 = r9
            r3 = r10
            android.content.res.TypedArray r9 = ur.i9.s(r0, r1, r2, r3, r4, r5)
            int r10 = com.google.android.material.R$styleable.aj
            boolean r0 = r9.hasValue(r10)
            if (r0 == 0) goto L28
            android.content.res.ColorStateList r8 = pv.zn.y(r8, r9, r10)
            j.zn.zn(r7, r8)
        L28:
            int r8 = com.google.android.material.R$styleable.ah
            boolean r8 = r9.getBoolean(r8, r6)
            r7.f10364f = r8
            r9.recycle()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: lf.y.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}
