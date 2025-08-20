package sd;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import j.zn;
import wz.xc;
/* loaded from: classes.dex */
public class y extends xc {

    /* renamed from: t  reason: collision with root package name */
    public static final int f13853t = R$style.o5;

    /* renamed from: w  reason: collision with root package name */
    public static final int[][] f13854w = {new int[]{16842910, 16842912}, new int[]{16842910, -16842912}, new int[]{-16842910, 16842912}, new int[]{-16842910, -16842912}};

    /* renamed from: f  reason: collision with root package name */
    public boolean f13855f;
    @Nullable

    /* renamed from: s  reason: collision with root package name */
    public ColorStateList f13856s;

    public y(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.f5080c);
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.f13856s == null) {
            int gv2 = td.y.gv(this, R$attr.f5081c5);
            int gv3 = td.y.gv(this, R$attr.y5);
            int gv4 = td.y.gv(this, R$attr.uh);
            int[][] iArr = f13854w;
            int[] iArr2 = new int[iArr.length];
            iArr2[0] = td.y.fb(gv4, gv2, 1.0f);
            iArr2[1] = td.y.fb(gv4, gv3, 0.54f);
            iArr2[2] = td.y.fb(gv4, gv3, 0.38f);
            iArr2[3] = td.y.fb(gv4, gv3, 0.38f);
            this.f13856s = new ColorStateList(iArr, iArr2);
        }
        return this.f13856s;
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f13855f && zn.n3(this) == null) {
            setUseMaterialThemeColors(true);
        }
    }

    public void setUseMaterialThemeColors(boolean z2) {
        this.f13855f = z2;
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
    public y(@androidx.annotation.NonNull android.content.Context r8, @androidx.annotation.Nullable android.util.AttributeSet r9, int r10) {
        /*
            r7 = this;
            int r4 = sd.y.f13853t
            android.content.Context r8 = c0.y.zn(r8, r9, r10, r4)
            r7.<init>(r8, r9, r10)
            android.content.Context r8 = r7.getContext()
            int[] r2 = com.google.android.material.R$styleable.zv
            r6 = 0
            int[] r5 = new int[r6]
            r0 = r8
            r1 = r9
            r3 = r10
            android.content.res.TypedArray r9 = ur.i9.s(r0, r1, r2, r3, r4, r5)
            int r10 = com.google.android.material.R$styleable.xe
            boolean r0 = r9.hasValue(r10)
            if (r0 == 0) goto L28
            android.content.res.ColorStateList r8 = pv.zn.y(r8, r9, r10)
            j.zn.zn(r7, r8)
        L28:
            int r8 = com.google.android.material.R$styleable.ex
            boolean r8 = r9.getBoolean(r8, r6)
            r7.f13855f = r8
            r9.recycle()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: sd.y.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}
