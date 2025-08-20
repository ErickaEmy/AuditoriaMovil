package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Arrays;
import java.util.HashMap;
import n.s;
/* loaded from: classes.dex */
public abstract class n3 extends View {

    /* renamed from: f  reason: collision with root package name */
    public boolean f1914f;

    /* renamed from: fb  reason: collision with root package name */
    public Context f1915fb;

    /* renamed from: p  reason: collision with root package name */
    public HashMap<Integer, String> f1916p;

    /* renamed from: s  reason: collision with root package name */
    public s f1917s;

    /* renamed from: t  reason: collision with root package name */
    public String f1918t;

    /* renamed from: v  reason: collision with root package name */
    public int f1919v;

    /* renamed from: w  reason: collision with root package name */
    public String f1920w;
    public int[] y;

    public n3(Context context) {
        super(context);
        this.y = new int[32];
        this.f1916p = new HashMap<>();
        this.f1915fb = context;
        s(null);
    }

    public final int a(ConstraintLayout constraintLayout, String str) {
        Resources resources;
        String str2;
        if (str == null || constraintLayout == null || (resources = this.f1915fb.getResources()) == null) {
            return 0;
        }
        int childCount = constraintLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = constraintLayout.getChildAt(i);
            if (childAt.getId() != -1) {
                try {
                    str2 = resources.getResourceEntryName(childAt.getId());
                } catch (Resources.NotFoundException unused) {
                    str2 = null;
                }
                if (str.equals(str2)) {
                    return childAt.getId();
                }
            }
        }
        return 0;
    }

    public void f(ConstraintLayout constraintLayout) {
    }

    public final int fb(String str) {
        ConstraintLayout constraintLayout;
        if (getParent() instanceof ConstraintLayout) {
            constraintLayout = (ConstraintLayout) getParent();
        } else {
            constraintLayout = null;
        }
        int i = 0;
        if (isInEditMode() && constraintLayout != null) {
            Object fb2 = constraintLayout.fb(0, str);
            if (fb2 instanceof Integer) {
                i = ((Integer) fb2).intValue();
            }
        }
        if (i == 0 && constraintLayout != null) {
            i = a(constraintLayout, str);
        }
        if (i == 0) {
            try {
                i = R$id.class.getField(str).getInt(null);
            } catch (Exception unused) {
            }
        }
        if (i == 0) {
            return this.f1915fb.getResources().getIdentifier(str, "id", this.f1915fb.getPackageName());
        }
        return i;
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.y, this.f1919v);
    }

    public void gv() {
        ViewParent parent = getParent();
        if (parent != null && (parent instanceof ConstraintLayout)) {
            v((ConstraintLayout) parent);
        }
    }

    public void i9(ConstraintLayout constraintLayout) {
    }

    public final void n3(int i) {
        if (i == getId()) {
            return;
        }
        int i5 = this.f1919v + 1;
        int[] iArr = this.y;
        if (i5 > iArr.length) {
            this.y = Arrays.copyOf(iArr, iArr.length * 2);
        }
        int[] iArr2 = this.y;
        int i6 = this.f1919v;
        iArr2[i6] = i;
        this.f1919v = i6 + 1;
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String str = this.f1918t;
        if (str != null) {
            setIds(str);
        }
        String str2 = this.f1920w;
        if (str2 != null) {
            setReferenceTags(str2);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
    }

    @Override // android.view.View
    public void onMeasure(int i, int i5) {
        if (this.f1914f) {
            super.onMeasure(i, i5);
        } else {
            setMeasuredDimension(0, 0);
        }
    }

    public void s(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.f1867vn);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R$styleable.mh) {
                    String string = obtainStyledAttributes.getString(index);
                    this.f1918t = string;
                    setIds(string);
                } else if (index == R$styleable.n7) {
                    String string2 = obtainStyledAttributes.getString(index);
                    this.f1920w = string2;
                    setReferenceTags(string2);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public void setIds(String str) {
        this.f1918t = str;
        if (str == null) {
            return;
        }
        int i = 0;
        this.f1919v = 0;
        while (true) {
            int indexOf = str.indexOf(44, i);
            if (indexOf == -1) {
                y(str.substring(i));
                return;
            } else {
                y(str.substring(i, indexOf));
                i = indexOf + 1;
            }
        }
    }

    public void setReferenceTags(String str) {
        this.f1920w = str;
        if (str == null) {
            return;
        }
        int i = 0;
        this.f1919v = 0;
        while (true) {
            int indexOf = str.indexOf(44, i);
            if (indexOf == -1) {
                zn(str.substring(i));
                return;
            } else {
                zn(str.substring(i, indexOf));
                i = indexOf + 1;
            }
        }
    }

    public void setReferencedIds(int[] iArr) {
        this.f1918t = null;
        this.f1919v = 0;
        for (int i : iArr) {
            n3(i);
        }
    }

    @Override // android.view.View
    public void setTag(int i, Object obj) {
        super.setTag(i, obj);
        if (obj == null && this.f1918t == null) {
            n3(i);
        }
    }

    public void t(ConstraintLayout constraintLayout) {
    }

    public void tl(ConstraintLayout constraintLayout) {
        String str;
        int a2;
        if (isInEditMode()) {
            setIds(this.f1918t);
        }
        s sVar = this.f1917s;
        if (sVar == null) {
            return;
        }
        sVar.zn();
        for (int i = 0; i < this.f1919v; i++) {
            int i5 = this.y[i];
            View c52 = constraintLayout.c5(i5);
            if (c52 == null && (a2 = a(constraintLayout, (str = this.f1916p.get(Integer.valueOf(i5))))) != 0) {
                this.y[i] = a2;
                this.f1916p.put(Integer.valueOf(a2), str);
                c52 = constraintLayout.c5(a2);
            }
            if (c52 != null) {
                this.f1917s.n3(constraintLayout.i9(c52));
            }
        }
        this.f1917s.y(constraintLayout.f1618fb);
    }

    public void v(ConstraintLayout constraintLayout) {
        int visibility = getVisibility();
        float elevation = getElevation();
        for (int i = 0; i < this.f1919v; i++) {
            View c52 = constraintLayout.c5(this.y[i]);
            if (c52 != null) {
                c52.setVisibility(visibility);
                if (elevation > 0.0f) {
                    c52.setTranslationZ(c52.getTranslationZ() + elevation);
                }
            }
        }
    }

    public void wz() {
        if (this.f1917s == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.n3) {
            ((ConstraintLayout.n3) layoutParams).f1678s8 = (n.v) this.f1917s;
        }
    }

    public final void y(String str) {
        if (str == null || str.length() == 0 || this.f1915fb == null) {
            return;
        }
        String trim = str.trim();
        if (getParent() instanceof ConstraintLayout) {
            ConstraintLayout constraintLayout = (ConstraintLayout) getParent();
        }
        int fb2 = fb(trim);
        if (fb2 != 0) {
            this.f1916p.put(Integer.valueOf(fb2), trim);
            n3(fb2);
            return;
        }
        Log.w("ConstraintHelper", "Could not find id of \"" + trim + "\"");
    }

    public final void zn(String str) {
        ConstraintLayout constraintLayout;
        if (str == null || str.length() == 0 || this.f1915fb == null) {
            return;
        }
        String trim = str.trim();
        if (getParent() instanceof ConstraintLayout) {
            constraintLayout = (ConstraintLayout) getParent();
        } else {
            constraintLayout = null;
        }
        if (constraintLayout == null) {
            Log.w("ConstraintHelper", "Parent not a ConstraintLayout");
            return;
        }
        int childCount = constraintLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = constraintLayout.getChildAt(i);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            if ((layoutParams instanceof ConstraintLayout.n3) && trim.equals(((ConstraintLayout.n3) layoutParams).f1684ut)) {
                if (childAt.getId() == -1) {
                    Log.w("ConstraintHelper", "to use ConstraintTag view " + childAt.getClass().getSimpleName() + " must have an ID");
                } else {
                    n3(childAt.getId());
                }
            }
        }
    }

    public n3(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.y = new int[32];
        this.f1916p = new HashMap<>();
        this.f1915fb = context;
        s(attributeSet);
    }

    public void c5(n.v vVar, boolean z2) {
    }
}
