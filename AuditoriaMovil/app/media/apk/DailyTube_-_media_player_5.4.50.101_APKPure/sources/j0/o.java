package j0;

import java.lang.reflect.Field;
/* loaded from: classes.dex */
public class o {

    /* renamed from: n3  reason: collision with root package name */
    public final Field f9358n3;
    public final Object y;

    /* renamed from: zn  reason: collision with root package name */
    public final Class f9359zn;

    public o(Object obj, Field field, Class cls) {
        this.y = obj;
        this.f9358n3 = field;
        this.f9359zn = cls;
    }

    public final Field n3() {
        return this.f9358n3;
    }

    public final Object y() {
        try {
            return this.f9359zn.cast(this.f9358n3.get(this.y));
        } catch (Exception e2) {
            throw new oz(String.format("Failed to get value of field %s of type %s on object of type %s", this.f9358n3.getName(), this.y.getClass().getName(), this.f9359zn.getName()), e2);
        }
    }

    public final void zn(Object obj) {
        try {
            this.f9358n3.set(this.y, obj);
        } catch (Exception e2) {
            throw new oz(String.format("Failed to set value of field %s of type %s on object of type %s", this.f9358n3.getName(), this.y.getClass().getName(), this.f9359zn.getName()), e2);
        }
    }
}
