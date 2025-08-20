package z6;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import androidx.annotation.NonNull;
import d.v;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import k5.fb;
/* loaded from: classes.dex */
public class v extends i9 {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f15666a;

    /* renamed from: gv  reason: collision with root package name */
    public static Method f15667gv;

    /* renamed from: n3  reason: collision with root package name */
    public static Class<?> f15668n3;

    /* renamed from: v  reason: collision with root package name */
    public static Method f15669v;

    /* renamed from: zn  reason: collision with root package name */
    public static Constructor<?> f15670zn;

    private static Typeface c5(Object obj) {
        f();
        try {
            Object newInstance = Array.newInstance(f15668n3, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) f15669v.invoke(null, newInstance);
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static void f() {
        Method method;
        Class<?> cls;
        Method method2;
        if (f15666a) {
            return;
        }
        f15666a = true;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(null);
            method2 = cls.getMethod("addFontWeightStyle", String.class, Integer.TYPE, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e2) {
            Log.e("TypefaceCompatApi21Impl", e2.getClass().getName(), e2);
            method = null;
            cls = null;
            method2 = null;
        }
        f15670zn = constructor;
        f15668n3 = cls;
        f15667gv = method2;
        f15669v = method;
    }

    public static boolean s(Object obj, String str, int i, boolean z2) {
        f();
        try {
            return ((Boolean) f15667gv.invoke(obj, str, Integer.valueOf(i), Boolean.valueOf(z2))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    private static Object t() {
        f();
        try {
            return f15670zn.newInstance(null);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    public final File i9(@NonNull ParcelFileDescriptor parcelFileDescriptor) {
        try {
            String readlink = Os.readlink("/proc/self/fd/" + parcelFileDescriptor.getFd());
            if (OsConstants.S_ISREG(Os.stat(readlink).st_mode)) {
                return new File(readlink);
            }
        } catch (ErrnoException unused) {
        }
        return null;
    }

    @Override // z6.i9
    public Typeface n3(Context context, CancellationSignal cancellationSignal, @NonNull fb.n3[] n3VarArr, int i) {
        if (n3VarArr.length < 1) {
            return null;
        }
        fb.n3 fb2 = fb(n3VarArr, i);
        try {
            ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(fb2.gv(), "r", cancellationSignal);
            if (openFileDescriptor == null) {
                if (openFileDescriptor != null) {
                    openFileDescriptor.close();
                }
                return null;
            }
            File i92 = i9(openFileDescriptor);
            if (i92 != null && i92.canRead()) {
                Typeface createFromFile = Typeface.createFromFile(i92);
                openFileDescriptor.close();
                return createFromFile;
            }
            FileInputStream fileInputStream = new FileInputStream(openFileDescriptor.getFileDescriptor());
            Typeface zn2 = super.zn(context, fileInputStream);
            fileInputStream.close();
            openFileDescriptor.close();
            return zn2;
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // z6.i9
    public Typeface y(Context context, v.zn znVar, Resources resources, int i) {
        v.gv[] y;
        Object t2 = t();
        for (v.gv gvVar : znVar.y()) {
            File v2 = f.v(context);
            if (v2 == null) {
                return null;
            }
            try {
                if (!f.zn(v2, resources, gvVar.n3())) {
                    return null;
                }
                if (!s(t2, v2.getPath(), gvVar.v(), gvVar.a())) {
                    return null;
                }
                v2.delete();
            } catch (RuntimeException unused) {
                return null;
            } finally {
                v2.delete();
            }
        }
        return c5(t2);
    }
}
