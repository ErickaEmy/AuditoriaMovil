package z6;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import d.v;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;
import k5.fb;
/* loaded from: classes.dex */
public class a extends i9 {

    /* renamed from: gv  reason: collision with root package name */
    public static final Method f15650gv;

    /* renamed from: n3  reason: collision with root package name */
    public static final Class<?> f15651n3;

    /* renamed from: v  reason: collision with root package name */
    public static final Method f15652v;

    /* renamed from: zn  reason: collision with root package name */
    public static final Constructor<?> f15653zn;

    static {
        Method method;
        Class<?> cls;
        Method method2;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(null);
            Class<?> cls2 = Integer.TYPE;
            method2 = cls.getMethod("addFontWeightStyle", ByteBuffer.class, cls2, List.class, cls2, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e2) {
            Log.e("TypefaceCompatApi24Impl", e2.getClass().getName(), e2);
            method = null;
            cls = null;
            method2 = null;
        }
        f15653zn = constructor;
        f15651n3 = cls;
        f15650gv = method2;
        f15652v = method;
    }

    private static Typeface c5(Object obj) {
        try {
            Object newInstance = Array.newInstance(f15651n3, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) f15652v.invoke(null, newInstance);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    private static Object f() {
        try {
            return f15653zn.newInstance(null);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    public static boolean i9() {
        Method method = f15650gv;
        if (method == null) {
            Log.w("TypefaceCompatApi24Impl", "Unable to collect necessary private methods.Fallback to legacy implementation.");
        }
        if (method != null) {
            return true;
        }
        return false;
    }

    public static boolean s(Object obj, ByteBuffer byteBuffer, int i, int i5, boolean z2) {
        try {
            return ((Boolean) f15650gv.invoke(obj, byteBuffer, Integer.valueOf(i), null, Integer.valueOf(i5), Boolean.valueOf(z2))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    @Override // z6.i9
    @Nullable
    public Typeface n3(Context context, @Nullable CancellationSignal cancellationSignal, @NonNull fb.n3[] n3VarArr, int i) {
        Object f4 = f();
        if (f4 == null) {
            return null;
        }
        z.s sVar = new z.s();
        for (fb.n3 n3Var : n3VarArr) {
            Uri gv2 = n3Var.gv();
            ByteBuffer byteBuffer = (ByteBuffer) sVar.get(gv2);
            if (byteBuffer == null) {
                byteBuffer = f.a(context, cancellationSignal, gv2);
                sVar.put(gv2, byteBuffer);
            }
            if (byteBuffer == null || !s(f4, byteBuffer, n3Var.zn(), n3Var.v(), n3Var.a())) {
                return null;
            }
        }
        Typeface c52 = c5(f4);
        if (c52 == null) {
            return null;
        }
        return Typeface.create(c52, i);
    }

    @Override // z6.i9
    @Nullable
    public Typeface y(Context context, v.zn znVar, Resources resources, int i) {
        v.gv[] y;
        Object f4 = f();
        if (f4 == null) {
            return null;
        }
        for (v.gv gvVar : znVar.y()) {
            ByteBuffer n32 = f.n3(context, resources, gvVar.n3());
            if (n32 == null || !s(f4, n32, gvVar.zn(), gvVar.v(), gvVar.a())) {
                return null;
            }
        }
        return c5(f4);
    }
}
