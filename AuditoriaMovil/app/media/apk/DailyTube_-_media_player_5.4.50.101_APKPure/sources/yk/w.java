package yk;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.util.Base64;
import androidx.annotation.Nullable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
/* loaded from: classes.dex */
public class w {
    public static final Map<String, b<s>> y = new HashMap();

    /* renamed from: n3  reason: collision with root package name */
    public static final Set<k5> f15459n3 = new HashSet();

    /* renamed from: zn  reason: collision with root package name */
    public static final byte[] f15460zn = {80, 75, 3, 4};

    public static void a8(boolean z2) {
        ArrayList arrayList = new ArrayList(f15459n3);
        for (int i = 0; i < arrayList.size(); i++) {
            ((k5) arrayList.get(i)).y(z2);
        }
    }

    public static a8<s> c(Context context, ZipInputStream zipInputStream, @Nullable String str) {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        try {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            s sVar = null;
            while (nextEntry != null) {
                String name = nextEntry.getName();
                if (name.contains("__MACOSX")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().equalsIgnoreCase("manifest.json")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().contains(".json")) {
                    sVar = mt(fc.zn.b(zc1.p.gv(zc1.p.t(zipInputStream))), null, false).n3();
                } else {
                    if (!name.contains(".png") && !name.contains(".webp") && !name.contains(".jpg") && !name.contains(".jpeg")) {
                        if (!name.contains(".ttf") && !name.contains(".otf")) {
                            zipInputStream.closeEntry();
                        }
                        String[] split = name.split("/");
                        String str2 = split[split.length - 1];
                        String str3 = str2.split("\\.")[0];
                        File file = new File(context.getCacheDir(), str2);
                        new FileOutputStream(file);
                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        byte[] bArr = new byte[4096];
                        while (true) {
                            int read = zipInputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            fileOutputStream.write(bArr, 0, read);
                        }
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        Typeface createFromFile = Typeface.createFromFile(file);
                        if (!file.delete()) {
                            br.gv.zn("Failed to delete temp font file " + file.getAbsolutePath() + ".");
                        }
                        hashMap2.put(str3, createFromFile);
                    }
                    String[] split2 = name.split("/");
                    hashMap.put(split2[split2.length - 1], BitmapFactory.decodeStream(zipInputStream));
                }
                nextEntry = zipInputStream.getNextEntry();
            }
            if (sVar == null) {
                return new a8<>(new IllegalArgumentException("Unable to parse composition"));
            }
            for (Map.Entry entry : hashMap.entrySet()) {
                ta c52 = c5(sVar, (String) entry.getKey());
                if (c52 != null) {
                    c52.a(br.s.t((Bitmap) entry.getValue(), c52.v(), c52.zn()));
                }
            }
            for (Map.Entry entry2 : hashMap2.entrySet()) {
                boolean z2 = false;
                for (ne.zn znVar : sVar.fb().values()) {
                    if (znVar.y().equals(entry2.getKey())) {
                        znVar.v((Typeface) entry2.getValue());
                        z2 = true;
                    }
                }
                if (!z2) {
                    br.gv.zn("Parsed font for " + ((String) entry2.getKey()) + " however it was not found in the animation.");
                }
            }
            if (hashMap.isEmpty()) {
                for (Map.Entry<String, ta> entry3 : sVar.i9().entrySet()) {
                    ta value = entry3.getValue();
                    if (value == null) {
                        return null;
                    }
                    String n32 = value.n3();
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inScaled = true;
                    options.inDensity = 160;
                    if (n32.startsWith("data:") && n32.indexOf("base64,") > 0) {
                        try {
                            byte[] decode = Base64.decode(n32.substring(n32.indexOf(44) + 1), 0);
                            value.a(BitmapFactory.decodeByteArray(decode, 0, decode.length, options));
                        } catch (IllegalArgumentException e2) {
                            br.gv.gv("data URL did not have correct base64 format.", e2);
                            return null;
                        }
                    }
                }
            }
            for (Map.Entry<String, ta> entry4 : sVar.i9().entrySet()) {
                if (entry4.getValue().y() == null) {
                    return new a8<>(new IllegalStateException("There is no image for " + entry4.getValue().n3()));
                }
            }
            if (str != null) {
                ne.fb.n3().zn(str, sVar);
            }
            return new a8<>(sVar);
        } catch (IOException e3) {
            return new a8<>(e3);
        }
    }

    @Nullable
    public static ta c5(s sVar, String str) {
        for (ta taVar : sVar.i9().values()) {
            if (taVar.n3().equals(str)) {
                return taVar;
            }
        }
        return null;
    }

    public static b<s> co(Context context, int i) {
        return z(context, i, x(context, i));
    }

    public static boolean d0(Context context) {
        if ((context.getResources().getConfiguration().uiMode & 48) == 32) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ a8 ej(WeakReference weakReference, Context context, int i, String str) throws Exception {
        Context context2 = (Context) weakReference.get();
        if (context2 != null) {
            context = context2;
        }
        return x4(context, i, str);
    }

    public static b<s> f(Context context, String str, @Nullable String str2) {
        return s(str2, new f(context.getApplicationContext(), str, str2));
    }

    public static b<s> f3(Context context, String str, @Nullable String str2) {
        return s(str2, new c5(context, str, str2));
    }

    public static Boolean fh(zc1.fb fbVar) {
        try {
            zc1.fb peek = fbVar.peek();
            for (byte b2 : f15460zn) {
                if (peek.readByte() != b2) {
                    return Boolean.FALSE;
                }
            }
            peek.close();
            return Boolean.TRUE;
        } catch (Exception e2) {
            br.gv.n3("Failed to check zip file header", e2);
            return Boolean.FALSE;
        } catch (NoSuchMethodError unused) {
            return Boolean.FALSE;
        }
    }

    public static b<s> i4(Context context, String str) {
        return f3(context, str, "url_" + str);
    }

    public static b<s> i9(Context context, String str) {
        return f(context, str, "asset_" + str);
    }

    public static /* synthetic */ a8 mg(s sVar) throws Exception {
        return new a8(sVar);
    }

    public static a8<s> mt(fc.zn znVar, @Nullable String str, boolean z2) {
        try {
            try {
                s y2 = bv.i4.y(znVar);
                if (str != null) {
                    ne.fb.n3().zn(str, y2);
                }
                a8<s> a8Var = new a8<>(y2);
                if (z2) {
                    br.s.zn(znVar);
                }
                return a8Var;
            } catch (Exception e2) {
                a8<s> a8Var2 = new a8<>(e2);
                if (z2) {
                    br.s.zn(znVar);
                }
                return a8Var2;
            }
        } catch (Throwable th) {
            if (z2) {
                br.s.zn(znVar);
            }
            throw th;
        }
    }

    public static a8<s> n(@Nullable Context context, ZipInputStream zipInputStream, @Nullable String str) {
        try {
            return c(context, zipInputStream, str);
        } finally {
            br.s.zn(zipInputStream);
        }
    }

    public static a8<s> p(fc.zn znVar, @Nullable String str) {
        return mt(znVar, str, true);
    }

    public static a8<s> r(Context context, int i) {
        return x4(context, i, x(context, i));
    }

    public static /* synthetic */ void rz(String str, AtomicBoolean atomicBoolean, Throwable th) {
        Map<String, b<s>> map = y;
        map.remove(str);
        atomicBoolean.set(true);
        if (map.size() == 0) {
            a8(true);
        }
    }

    public static b<s> s(@Nullable String str, Callable<a8<s>> callable) {
        s y2;
        if (str == null) {
            y2 = null;
        } else {
            y2 = ne.fb.n3().y(str);
        }
        if (y2 != null) {
            return new b<>(new t(y2));
        }
        if (str != null) {
            Map<String, b<s>> map = y;
            if (map.containsKey(str)) {
                return map.get(str);
            }
        }
        b<s> bVar = new b<>(callable);
        if (str != null) {
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            bVar.gv(new tl(str, atomicBoolean));
            bVar.zn(new wz(str, atomicBoolean));
            if (!atomicBoolean.get()) {
                Map<String, b<s>> map2 = y;
                map2.put(str, bVar);
                if (map2.size() == 1) {
                    a8(false);
                }
            }
        }
        return bVar;
    }

    public static a8<s> t(Context context, String str) {
        return tl(context, str, "asset_" + str);
    }

    public static /* synthetic */ void ta(String str, AtomicBoolean atomicBoolean, s sVar) {
        Map<String, b<s>> map = y;
        map.remove(str);
        atomicBoolean.set(true);
        if (map.size() == 0) {
            a8(true);
        }
    }

    public static a8<s> tl(Context context, String str, @Nullable String str2) {
        try {
            if (!str.endsWith(".zip") && !str.endsWith(".lottie")) {
                return xc(context.getAssets().open(str), str2);
            }
            return n(context, new ZipInputStream(context.getAssets().open(str)), str2);
        } catch (IOException e2) {
            return new a8<>(e2);
        }
    }

    public static /* synthetic */ a8 ud(Context context, String str, String str2) throws Exception {
        a8 zn2 = zn.v(context).zn(context, str, str2);
        if (str2 != null && zn2.n3() != null) {
            ne.fb.n3().zn(str2, (s) zn2.n3());
        }
        return zn2;
    }

    public static a8<s> w(InputStream inputStream, @Nullable String str, boolean z2) {
        try {
            return p(fc.zn.b(zc1.p.gv(zc1.p.t(inputStream))), str);
        } finally {
            if (z2) {
                br.s.zn(inputStream);
            }
        }
    }

    public static b<s> wz(InputStream inputStream, @Nullable String str) {
        return s(str, new i9(inputStream, str));
    }

    public static String x(Context context, int i) {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("rawRes");
        if (d0(context)) {
            str = "_night_";
        } else {
            str = "_day_";
        }
        sb.append(str);
        sb.append(i);
        return sb.toString();
    }

    public static a8<s> x4(Context context, int i, @Nullable String str) {
        try {
            zc1.fb gv2 = zc1.p.gv(zc1.p.t(context.getResources().openRawResource(i)));
            if (fh(gv2).booleanValue()) {
                return n(context, new ZipInputStream(gv2.le()), str);
            }
            return xc(gv2.le(), str);
        } catch (Resources.NotFoundException e2) {
            return new a8<>(e2);
        }
    }

    public static a8<s> xc(InputStream inputStream, @Nullable String str) {
        return w(inputStream, str, true);
    }

    public static b<s> z(Context context, int i, @Nullable String str) {
        return s(str, new xc(new WeakReference(context), context.getApplicationContext(), i, str));
    }
}
