package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
/* loaded from: classes.dex */
public class Barrier extends n3 {

    /* renamed from: co  reason: collision with root package name */
    public int f1607co;

    /* renamed from: r  reason: collision with root package name */
    public n.y f1608r;

    /* renamed from: z  reason: collision with root package name */
    public int f1609z;

    public Barrier(Context context) {
        super(context);
        super.setVisibility(8);
    }

    @Override // androidx.constraintlayout.widget.n3
    public void c5(n.v vVar, boolean z2) {
        w(vVar, this.f1607co, z2);
    }

    public int getMargin() {
        return this.f1608r.nd();
    }

    public int getType() {
        return this.f1607co;
    }

    @Override // androidx.constraintlayout.widget.n3
    public void s(AttributeSet attributeSet) {
        super.s(attributeSet);
        this.f1608r = new n.y();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.f1867vn);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R$styleable.f1715br) {
                    setType(obtainStyledAttributes.getInt(index, 0));
                } else if (index == R$styleable.fc) {
                    this.f1608r.fc(obtainStyledAttributes.getBoolean(index, true));
                } else if (index == R$styleable.f1860uo) {
                    this.f1608r.uo(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.f1917s = this.f1608r;
        wz();
    }

    public void setAllowsGoneWidget(boolean z2) {
        this.f1608r.fc(z2);
    }

    public void setDpMargin(int i) {
        n.y yVar = this.f1608r;
        yVar.uo((int) ((i * getResources().getDisplayMetrics().density) + 0.5f));
    }

    public void setMargin(int i) {
        this.f1608r.uo(i);
    }

    public void setType(int i) {
        this.f1607co = i;
    }

    public final void w(n.v vVar, int i, boolean z2) {
        this.f1609z = i;
        if (z2) {
            int i5 = this.f1607co;
            if (i5 == 5) {
                this.f1609z = 1;
            } else if (i5 == 6) {
                this.f1609z = 0;
            }
        } else {
            int i6 = this.f1607co;
            if (i6 == 5) {
                this.f1609z = 0;
            } else if (i6 == 6) {
                this.f1609z = 1;
            }
        }
        if (vVar instanceof n.y) {
            ((n.y) vVar).br(this.f1609z);
        }
    }

    public boolean xc() {
        return this.f1608r.q();
    }

    public Barrier(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setVisibility(8);
    }
}
