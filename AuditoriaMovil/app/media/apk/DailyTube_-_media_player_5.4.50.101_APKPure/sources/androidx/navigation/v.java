package androidx.navigation;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.gv;
import java.util.Iterator;
import java.util.NoSuchElementException;
/* loaded from: classes.dex */
public class v extends gv implements Iterable<gv> {

    /* renamed from: f3  reason: collision with root package name */
    public String f3006f3;

    /* renamed from: r  reason: collision with root package name */
    public int f3007r;

    /* renamed from: z  reason: collision with root package name */
    public final z.c5<gv> f3008z;

    /* loaded from: classes.dex */
    public class y implements Iterator<gv> {

        /* renamed from: v  reason: collision with root package name */
        public boolean f3010v;
        public int y = -1;

        public y() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.y + 1 < v.this.f3008z.tl()) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.f3010v) {
                v.this.f3008z.wz(this.y).co(null);
                v.this.f3008z.t(this.y);
                this.y--;
                this.f3010v = false;
                return;
            }
            throw new IllegalStateException("You must call next() before you can remove an element");
        }

        @Override // java.util.Iterator
        /* renamed from: y */
        public gv next() {
            if (hasNext()) {
                this.f3010v = true;
                z.c5<gv> c5Var = v.this.f3008z;
                int i = this.y + 1;
                this.y = i;
                return c5Var.wz(i);
            }
            throw new NoSuchElementException();
        }
    }

    public v(@NonNull c5<? extends v> c5Var) {
        super(c5Var);
        this.f3008z = new z.c5<>();
    }

    public final void c(int i) {
        if (i != f()) {
            this.f3007r = i;
            this.f3006f3 = null;
            return;
        }
        throw new IllegalArgumentException("Start destination " + i + " cannot use the same id as the graph " + this);
    }

    @Override // androidx.navigation.gv
    @NonNull
    public String c5() {
        if (f() != 0) {
            return super.c5();
        }
        return "the root navigation";
    }

    @NonNull
    public String f3() {
        if (this.f3006f3 == null) {
            this.f3006f3 = Integer.toString(this.f3007r);
        }
        return this.f3006f3;
    }

    @Nullable
    public final gv i4(int i, boolean z2) {
        gv fb2 = this.f3008z.fb(i);
        if (fb2 == null) {
            if (z2 && tl() != null) {
                return tl().x4(i);
            }
            return null;
        }
        return fb2;
    }

    @Override // java.lang.Iterable
    @NonNull
    public final Iterator<gv> iterator() {
        return new y();
    }

    public final int n() {
        return this.f3007r;
    }

    public final void r(@NonNull gv gvVar) {
        int f4 = gvVar.f();
        if (f4 != 0) {
            if (f4 != f()) {
                gv fb2 = this.f3008z.fb(f4);
                if (fb2 == gvVar) {
                    return;
                }
                if (gvVar.tl() == null) {
                    if (fb2 != null) {
                        fb2.co(null);
                    }
                    gvVar.co(this);
                    this.f3008z.f(gvVar.f(), gvVar);
                    return;
                }
                throw new IllegalStateException("Destination already has a parent set. Call NavGraph.remove() to remove the previous parent.");
            }
            throw new IllegalArgumentException("Destination " + gvVar + " cannot have the same id as graph " + this);
        }
        throw new IllegalArgumentException("Destinations must have an id. Call setId() or include an android:id in your navigation XML.");
    }

    @Override // androidx.navigation.gv
    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(" startDestination=");
        gv x42 = x4(n());
        if (x42 == null) {
            String str = this.f3006f3;
            if (str == null) {
                sb.append("0x");
                sb.append(Integer.toHexString(this.f3007r));
            } else {
                sb.append(str);
            }
        } else {
            sb.append("{");
            sb.append(x42.toString());
            sb.append("}");
        }
        return sb.toString();
    }

    @Override // androidx.navigation.gv
    @Nullable
    public gv.y wz(@NonNull lc.c5 c5Var) {
        gv.y wz2 = super.wz(c5Var);
        Iterator<gv> it = iterator();
        while (it.hasNext()) {
            gv.y wz3 = it.next().wz(c5Var);
            if (wz3 != null && (wz2 == null || wz3.compareTo(wz2) > 0)) {
                wz2 = wz3;
            }
        }
        return wz2;
    }

    @Nullable
    public final gv x4(int i) {
        return i4(i, true);
    }

    @Override // androidx.navigation.gv
    public void xc(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        super.xc(context, attributeSet);
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, androidx.navigation.common.R$styleable.f2724n);
        c(obtainAttributes.getResourceId(androidx.navigation.common.R$styleable.f2712c, 0));
        this.f3006f3 = gv.i9(context, this.f3007r);
        obtainAttributes.recycle();
    }
}
