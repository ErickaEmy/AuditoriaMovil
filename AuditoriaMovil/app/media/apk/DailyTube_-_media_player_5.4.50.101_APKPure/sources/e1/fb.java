package e1;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import w0.xc;
/* loaded from: classes.dex */
public abstract class fb<T> extends zn<T> implements Serializable {
    private static final long serialVersionUID = 3637540370352322684L;
    private final Type runtimeType;

    /* loaded from: classes.dex */
    public static final class y<T> extends fb<T> {
        private static final long serialVersionUID = 0;

        public y(Type type) {
            super(type, null);
        }
    }

    public /* synthetic */ fb(Type type, a aVar) {
        this(type);
    }

    public static fb<?> v(Type type) {
        return new y(type);
    }

    public boolean equals(Object obj) {
        if (obj instanceof fb) {
            return this.runtimeType.equals(((fb) obj).runtimeType);
        }
        return false;
    }

    public final Type gv() {
        return this.runtimeType;
    }

    public int hashCode() {
        return this.runtimeType.hashCode();
    }

    public String toString() {
        return c5.p(this.runtimeType);
    }

    public Object writeReplace() {
        return v(new v().gv(this.runtimeType));
    }

    public fb() {
        Type y2 = y();
        this.runtimeType = y2;
        xc.x4(!(y2 instanceof TypeVariable), "Cannot construct a TypeToken for a type variable.\nYou probably meant to call new TypeToken<%s>(getClass()) that can resolve the type variable for you.\nIf you do need to create a TypeToken of a type variable, please use TypeToken.of() instead.", y2);
    }

    public fb(Type type) {
        this.runtimeType = (Type) xc.wz(type);
    }
}
