package f3;
/* loaded from: classes.dex */
public class fb<T> implements a<T> {

    /* renamed from: n3  reason: collision with root package name */
    public int f7791n3;
    public final Object[] y;

    public fb(int i) {
        if (i > 0) {
            this.y = new Object[i];
            return;
        }
        throw new IllegalArgumentException("The max pool size must be > 0");
    }

    @Override // f3.a
    public T n3() {
        int i = this.f7791n3;
        if (i <= 0) {
            return null;
        }
        int i5 = i - 1;
        Object[] objArr = this.y;
        T t2 = (T) objArr[i5];
        objArr[i5] = null;
        this.f7791n3 = i - 1;
        return t2;
    }

    @Override // f3.a
    public boolean y(T t2) {
        int i = this.f7791n3;
        Object[] objArr = this.y;
        if (i < objArr.length) {
            objArr[i] = t2;
            this.f7791n3 = i + 1;
            return true;
        }
        return false;
    }

    @Override // f3.a
    public void zn(T[] tArr, int i) {
        if (i > tArr.length) {
            i = tArr.length;
        }
        for (int i5 = 0; i5 < i; i5++) {
            T t2 = tArr[i5];
            int i6 = this.f7791n3;
            Object[] objArr = this.y;
            if (i6 < objArr.length) {
                objArr[i6] = t2;
                this.f7791n3 = i6 + 1;
            }
        }
    }
}
