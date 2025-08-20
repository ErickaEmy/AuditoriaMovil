package androidx.work;

import androidx.annotation.NonNull;
import androidx.work.n3;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import l.c5;
/* loaded from: classes.dex */
public final class ArrayCreatingInputMerger extends c5 {
    public final Object a(Object obj) {
        Object newInstance = Array.newInstance(obj.getClass(), 1);
        Array.set(newInstance, 0, obj);
        return newInstance;
    }

    public final Object gv(Object obj, Object obj2) {
        int length = Array.getLength(obj);
        int length2 = Array.getLength(obj2);
        Object newInstance = Array.newInstance(obj.getClass().getComponentType(), length + length2);
        System.arraycopy(obj, 0, newInstance, 0, length);
        System.arraycopy(obj2, 0, newInstance, length, length2);
        return newInstance;
    }

    @Override // l.c5
    @NonNull
    public n3 n3(@NonNull List<n3> list) {
        n3.y yVar = new n3.y();
        HashMap hashMap = new HashMap();
        for (n3 n3Var : list) {
            for (Map.Entry<String, Object> entry : n3Var.s().entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                Class<?> cls = value.getClass();
                Object obj = hashMap.get(key);
                if (obj == null) {
                    if (!cls.isArray()) {
                        value = a(value);
                    }
                } else {
                    Class<?> cls2 = obj.getClass();
                    if (cls2.equals(cls)) {
                        if (cls2.isArray()) {
                            value = gv(obj, value);
                        } else {
                            value = v(obj, value);
                        }
                    } else if (cls2.isArray() && cls2.getComponentType().equals(cls)) {
                        value = zn(obj, value);
                    } else if (cls.isArray() && cls.getComponentType().equals(cls2)) {
                        value = zn(value, obj);
                    } else {
                        throw new IllegalArgumentException();
                    }
                }
                hashMap.put(key, value);
            }
        }
        yVar.gv(hashMap);
        return yVar.y();
    }

    public final Object v(Object obj, Object obj2) {
        Object newInstance = Array.newInstance(obj.getClass(), 2);
        Array.set(newInstance, 0, obj);
        Array.set(newInstance, 1, obj2);
        return newInstance;
    }

    public final Object zn(Object obj, Object obj2) {
        int length = Array.getLength(obj);
        Object newInstance = Array.newInstance(obj2.getClass(), length + 1);
        System.arraycopy(obj, 0, newInstance, 0, length);
        Array.set(newInstance, length, obj2);
        return newInstance;
    }
}
