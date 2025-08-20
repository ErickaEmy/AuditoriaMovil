package f1;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes.dex */
public class n3 extends Number implements Serializable {
    private static final long serialVersionUID = 0;
    public transient AtomicLong y;

    public n3(double d2) {
        this.y = new AtomicLong(Double.doubleToRawLongBits(d2));
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.y = new AtomicLong();
        gv(objectInputStream.readDouble());
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeDouble(y());
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return y();
    }

    @Override // java.lang.Number
    public float floatValue() {
        return (float) y();
    }

    public final void gv(double d2) {
        this.y.set(Double.doubleToRawLongBits(d2));
    }

    @Override // java.lang.Number
    public int intValue() {
        return (int) y();
    }

    @Override // java.lang.Number
    public long longValue() {
        return (long) y();
    }

    public String toString() {
        return Double.toString(y());
    }

    public final double y() {
        return Double.longBitsToDouble(this.y.get());
    }
}
