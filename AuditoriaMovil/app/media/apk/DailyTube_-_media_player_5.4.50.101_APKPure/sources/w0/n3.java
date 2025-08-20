package w0;

import java.util.Iterator;
import java.util.NoSuchElementException;
/* loaded from: classes.dex */
public abstract class n3<T> implements Iterator<T> {

    /* renamed from: v  reason: collision with root package name */
    public T f14512v;
    public EnumC0243n3 y = EnumC0243n3.NOT_READY;

    /* renamed from: w0.n3$n3  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public enum EnumC0243n3 {
        READY,
        NOT_READY,
        DONE,
        FAILED
    }

    /* loaded from: classes.dex */
    public static /* synthetic */ class y {
        public static final /* synthetic */ int[] y;

        static {
            int[] iArr = new int[EnumC0243n3.values().length];
            y = iArr;
            try {
                iArr[EnumC0243n3.DONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                y[EnumC0243n3.READY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        boolean z2;
        if (this.y != EnumC0243n3.FAILED) {
            z2 = true;
        } else {
            z2 = false;
        }
        xc.co(z2);
        int i = y.y[this.y.ordinal()];
        if (i == 1) {
            return false;
        }
        if (i == 2) {
            return true;
        }
        return zn();
    }

    public final T n3() {
        this.y = EnumC0243n3.DONE;
        return null;
    }

    @Override // java.util.Iterator
    public final T next() {
        if (hasNext()) {
            this.y = EnumC0243n3.NOT_READY;
            T t2 = (T) i9.y(this.f14512v);
            this.f14512v = null;
            return t2;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public abstract T y();

    public final boolean zn() {
        this.y = EnumC0243n3.FAILED;
        this.f14512v = y();
        if (this.y != EnumC0243n3.DONE) {
            this.y = EnumC0243n3.READY;
            return true;
        }
        return false;
    }
}
