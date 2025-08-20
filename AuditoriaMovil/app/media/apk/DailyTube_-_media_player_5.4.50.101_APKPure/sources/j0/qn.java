package j0;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.Collection;
/* loaded from: classes.dex */
public final class qn extends o {
    public qn(Object obj, Field field, Class cls) {
        super(obj, field, Array.newInstance(cls, 0).getClass());
    }

    public final Class a() {
        return n3().getType().getComponentType();
    }

    public final void gv(Collection collection) {
        int length;
        Object[] objArr = (Object[]) y();
        if (objArr == null) {
            length = 0;
        } else {
            length = objArr.length;
        }
        Object[] objArr2 = (Object[]) Array.newInstance(a(), collection.size() + length);
        if (objArr != null) {
            System.arraycopy(objArr, 0, objArr2, 0, objArr.length);
        }
        for (Object obj : collection) {
            objArr2[length] = obj;
            length++;
        }
        zn(objArr2);
    }

    public final void v(Collection collection) {
        int length;
        Object[] objArr = (Object[]) y();
        int i = 0;
        if (objArr == null) {
            length = 0;
        } else {
            length = objArr.length;
        }
        Object[] objArr2 = (Object[]) Array.newInstance(a(), length + collection.size());
        if (objArr != null) {
            System.arraycopy(objArr, 0, objArr2, collection.size(), objArr.length);
        }
        for (Object obj : collection) {
            objArr2[i] = obj;
            i++;
        }
        zn(objArr2);
    }
}
