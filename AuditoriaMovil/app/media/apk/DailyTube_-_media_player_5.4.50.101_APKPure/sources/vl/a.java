package vl;

import androidx.annotation.NonNull;
/* loaded from: classes.dex */
public class a<T> implements v<T> {

    /* renamed from: n3  reason: collision with root package name */
    public int f14454n3;
    public final Object[] y;

    public a(int i) {
        if (i > 0) {
            this.y = new Object[i];
            return;
        }
        throw new IllegalArgumentException("The max pool size must be > 0");
    }

    @Override // vl.v
    public T n3() {
        int i = this.f14454n3;
        if (i <= 0) {
            return null;
        }
        int i5 = i - 1;
        Object[] objArr = this.y;
        T t2 = (T) objArr[i5];
        objArr[i5] = null;
        this.f14454n3 = i - 1;
        return t2;
    }

    @Override // vl.v
    public boolean y(@NonNull T t2) {
        if (!zn(t2)) {
            int i = this.f14454n3;
            Object[] objArr = this.y;
            if (i < objArr.length) {
                objArr[i] = t2;
                this.f14454n3 = i + 1;
                return true;
            }
            return false;
        }
        throw new IllegalStateException("Already in the pool!");
    }

    public final boolean zn(@NonNull T t2) {
        for (int i = 0; i < this.f14454n3; i++) {
            if (this.y[i] == t2) {
                return true;
            }
        }
        return false;
    }
}
