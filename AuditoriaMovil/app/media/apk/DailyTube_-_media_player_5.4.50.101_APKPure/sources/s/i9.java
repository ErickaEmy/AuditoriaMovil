package s;

import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import android.util.LongSparseArray;
import androidx.annotation.NonNull;
import java.lang.reflect.Field;
import java.util.Map;
/* loaded from: classes.dex */
public class i9 {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f13382a;

    /* renamed from: fb  reason: collision with root package name */
    public static Field f13383fb;

    /* renamed from: gv  reason: collision with root package name */
    public static boolean f13384gv;

    /* renamed from: n3  reason: collision with root package name */
    public static boolean f13385n3;

    /* renamed from: s  reason: collision with root package name */
    public static boolean f13386s;

    /* renamed from: v  reason: collision with root package name */
    public static Field f13387v;
    public static Field y;

    /* renamed from: zn  reason: collision with root package name */
    public static Class<?> f13388zn;

    public static void gv(@NonNull Resources resources) {
        Object obj;
        if (!f13386s) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mResourcesImpl");
                f13383fb = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e2) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mResourcesImpl field", e2);
            }
            f13386s = true;
        }
        Field field = f13383fb;
        if (field == null) {
            return;
        }
        Object obj2 = null;
        try {
            obj = field.get(resources);
        } catch (IllegalAccessException e3) {
            Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mResourcesImpl", e3);
            obj = null;
        }
        if (obj == null) {
            return;
        }
        if (!f13385n3) {
            try {
                Field declaredField2 = obj.getClass().getDeclaredField("mDrawableCache");
                y = declaredField2;
                declaredField2.setAccessible(true);
            } catch (NoSuchFieldException e5) {
                Log.e("ResourcesFlusher", "Could not retrieve ResourcesImpl#mDrawableCache field", e5);
            }
            f13385n3 = true;
        }
        Field field2 = y;
        if (field2 != null) {
            try {
                obj2 = field2.get(obj);
            } catch (IllegalAccessException e6) {
                Log.e("ResourcesFlusher", "Could not retrieve value from ResourcesImpl#mDrawableCache", e6);
            }
        }
        if (obj2 != null) {
            v(obj2);
        }
    }

    public static void n3(@NonNull Resources resources) {
        Map map;
        if (!f13385n3) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mDrawableCache");
                y = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e2) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", e2);
            }
            f13385n3 = true;
        }
        Field field = y;
        if (field != null) {
            try {
                map = (Map) field.get(resources);
            } catch (IllegalAccessException e3) {
                Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", e3);
                map = null;
            }
            if (map != null) {
                map.clear();
            }
        }
    }

    public static void v(@NonNull Object obj) {
        LongSparseArray longSparseArray;
        if (!f13384gv) {
            try {
                f13388zn = Class.forName("android.content.res.ThemedResourceCache");
            } catch (ClassNotFoundException e2) {
                Log.e("ResourcesFlusher", "Could not find ThemedResourceCache class", e2);
            }
            f13384gv = true;
        }
        Class<?> cls = f13388zn;
        if (cls == null) {
            return;
        }
        if (!f13382a) {
            try {
                Field declaredField = cls.getDeclaredField("mUnthemedEntries");
                f13387v = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e3) {
                Log.e("ResourcesFlusher", "Could not retrieve ThemedResourceCache#mUnthemedEntries field", e3);
            }
            f13382a = true;
        }
        Field field = f13387v;
        if (field == null) {
            return;
        }
        try {
            longSparseArray = (LongSparseArray) field.get(obj);
        } catch (IllegalAccessException e5) {
            Log.e("ResourcesFlusher", "Could not retrieve value from ThemedResourceCache#mUnthemedEntries", e5);
            longSparseArray = null;
        }
        if (longSparseArray != null) {
            longSparseArray.clear();
        }
    }

    public static void y(@NonNull Resources resources) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 28) {
            return;
        }
        if (i >= 24) {
            gv(resources);
        } else if (i >= 23) {
            zn(resources);
        } else {
            n3(resources);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x002f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void zn(@androidx.annotation.NonNull android.content.res.Resources r4) {
        /*
            boolean r0 = s.i9.f13385n3
            java.lang.String r1 = "ResourcesFlusher"
            if (r0 != 0) goto L1d
            r0 = 1
            java.lang.Class<android.content.res.Resources> r2 = android.content.res.Resources.class
            java.lang.String r3 = "mDrawableCache"
            java.lang.reflect.Field r2 = r2.getDeclaredField(r3)     // Catch: java.lang.NoSuchFieldException -> L15
            s.i9.y = r2     // Catch: java.lang.NoSuchFieldException -> L15
            r2.setAccessible(r0)     // Catch: java.lang.NoSuchFieldException -> L15
            goto L1b
        L15:
            r2 = move-exception
            java.lang.String r3 = "Could not retrieve Resources#mDrawableCache field"
            android.util.Log.e(r1, r3, r2)
        L1b:
            s.i9.f13385n3 = r0
        L1d:
            java.lang.reflect.Field r0 = s.i9.y
            if (r0 == 0) goto L2c
            java.lang.Object r4 = r0.get(r4)     // Catch: java.lang.IllegalAccessException -> L26
            goto L2d
        L26:
            r4 = move-exception
            java.lang.String r0 = "Could not retrieve value from Resources#mDrawableCache"
            android.util.Log.e(r1, r0, r4)
        L2c:
            r4 = 0
        L2d:
            if (r4 != 0) goto L30
            return
        L30:
            v(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: s.i9.zn(android.content.res.Resources):void");
    }
}
