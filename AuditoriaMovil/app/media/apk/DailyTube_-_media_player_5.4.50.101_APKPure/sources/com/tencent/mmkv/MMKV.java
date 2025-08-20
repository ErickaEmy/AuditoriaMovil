package com.tencent.mmkv;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Parcelable;
import android.util.Log;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class MMKV implements SharedPreferences, SharedPreferences.Editor {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f6573a;

    /* renamed from: fb  reason: collision with root package name */
    public static final HashMap<String, Parcelable.Creator<?>> f6574fb;

    /* renamed from: gv  reason: collision with root package name */
    public static final Set<Long> f6575gv;

    /* renamed from: n3  reason: collision with root package name */
    public static final EnumMap<q6.y, Integer> f6576n3;

    /* renamed from: s  reason: collision with root package name */
    public static boolean f6577s;

    /* renamed from: v  reason: collision with root package name */
    public static String f6578v;
    public static final EnumMap<q6.n3, Integer> y;

    /* renamed from: zn  reason: collision with root package name */
    public static final q6.y[] f6579zn;
    private final long nativeHandle;

    /* loaded from: classes.dex */
    public interface n3 {
        void y(String str);
    }

    /* loaded from: classes.dex */
    public static /* synthetic */ class y {
        public static final /* synthetic */ int[] y;

        static {
            int[] iArr = new int[q6.y.values().length];
            y = iArr;
            try {
                iArr[q6.y.LevelDebug.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                y[q6.y.LevelWarning.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                y[q6.y.LevelError.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                y[q6.y.LevelNone.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                y[q6.y.LevelInfo.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    static {
        EnumMap<q6.n3, Integer> enumMap = new EnumMap<>(q6.n3.class);
        y = enumMap;
        enumMap.put((EnumMap<q6.n3, Integer>) q6.n3.OnErrorDiscard, (q6.n3) 0);
        enumMap.put((EnumMap<q6.n3, Integer>) q6.n3.OnErrorRecover, (q6.n3) 1);
        EnumMap<q6.y, Integer> enumMap2 = new EnumMap<>(q6.y.class);
        f6576n3 = enumMap2;
        q6.y yVar = q6.y.LevelDebug;
        enumMap2.put((EnumMap<q6.y, Integer>) yVar, (q6.y) 0);
        q6.y yVar2 = q6.y.LevelInfo;
        enumMap2.put((EnumMap<q6.y, Integer>) yVar2, (q6.y) 1);
        q6.y yVar3 = q6.y.LevelWarning;
        enumMap2.put((EnumMap<q6.y, Integer>) yVar3, (q6.y) 2);
        q6.y yVar4 = q6.y.LevelError;
        enumMap2.put((EnumMap<q6.y, Integer>) yVar4, (q6.y) 3);
        q6.y yVar5 = q6.y.LevelNone;
        enumMap2.put((EnumMap<q6.y, Integer>) yVar5, (q6.y) 4);
        f6579zn = new q6.y[]{yVar, yVar2, yVar3, yVar4, yVar5};
        f6575gv = new HashSet();
        f6578v = null;
        f6573a = true;
        f6574fb = new HashMap<>();
        f6577s = false;
    }

    public MMKV(long j2) {
        this.nativeHandle = j2;
    }

    private native long actualSize(long j2);

    private static native boolean checkProcessMode(long j2);

    private native boolean containsKey(long j2, String str);

    private native long count(long j2);

    private static native long createNB(int i);

    private native boolean decodeBool(long j2, String str, boolean z2);

    @Nullable
    private native byte[] decodeBytes(long j2, String str);

    private native double decodeDouble(long j2, String str, double d2);

    private native float decodeFloat(long j2, String str, float f4);

    private native int decodeInt(long j2, String str, int i);

    private native long decodeLong(long j2, String str, long j4);

    @Nullable
    private native String decodeString(long j2, String str, @Nullable String str2);

    @Nullable
    private native String[] decodeStringSet(long j2, String str);

    private static native void destroyNB(long j2, int i);

    private native boolean encodeBool(long j2, String str, boolean z2);

    private native boolean encodeBytes(long j2, String str, @Nullable byte[] bArr);

    private native boolean encodeDouble(long j2, String str, double d2);

    private native boolean encodeFloat(long j2, String str, float f4);

    private native boolean encodeInt(long j2, String str, int i);

    private native boolean encodeLong(long j2, String str, long j4);

    private native boolean encodeSet(long j2, String str, @Nullable String[] strArr);

    private native boolean encodeString(long j2, String str, @Nullable String str2);

    public static String f(String str, n3 n3Var, q6.y yVar) {
        if (n3Var != null) {
            n3Var.y("mmkv");
        } else {
            System.loadLibrary("mmkv");
        }
        jniInitialize(str, x4(yVar));
        f6578v = str;
        return str;
    }

    private static native long getDefaultMMKV(int i, @Nullable String str);

    private static native long getMMKVWithAshmemFD(String str, int i, int i5, @Nullable String str2);

    private static native long getMMKVWithID(String str, int i, @Nullable String str2, @Nullable String str3);

    private static native long getMMKVWithIDAndSize(String str, int i, int i5, @Nullable String str2);

    public static MMKV i4(String str) throws RuntimeException {
        if (f6578v != null) {
            return y(getMMKVWithID(str, 1, null, null), str, 1);
        }
        throw new IllegalStateException("You should Call MMKV.initialize() first.");
    }

    public static void i9() {
        synchronized (f6575gv) {
            f6573a = false;
        }
    }

    public static native boolean isFileValid(String str, @Nullable String str2);

    private static native void jniInitialize(String str, int i);

    private static void mmkvLogImp(int i, String str, int i5, String str2, String str3) {
        int i6 = y.y[f6579zn[i].ordinal()];
        if (i6 != 2) {
            if (i6 == 3) {
                Log.e("MMKV", str3);
                return;
            }
            return;
        }
        Log.w("MMKV", str3);
    }

    public static void n(q6.y yVar, String str) {
        int intValue;
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        StackTraceElement stackTraceElement = stackTrace[stackTrace.length - 1];
        Integer num = f6576n3.get(yVar);
        if (num == null) {
            intValue = 0;
        } else {
            intValue = num.intValue();
        }
        mmkvLogImp(intValue, stackTraceElement.getFileName(), stackTraceElement.getLineNumber(), stackTraceElement.getMethodName(), str);
    }

    private static void onContentChangedByOuterProcess(String str) {
    }

    public static native void onExit();

    private static int onMMKVCRCCheckFail(String str) {
        q6.n3 n3Var = q6.n3.OnErrorDiscard;
        q6.y yVar = q6.y.LevelInfo;
        n(yVar, "Recover strategic for " + str + " is " + n3Var);
        Integer num = y.get(n3Var);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    private static int onMMKVFileLengthError(String str) {
        q6.n3 n3Var = q6.n3.OnErrorDiscard;
        q6.y yVar = q6.y.LevelInfo;
        n(yVar, "Recover strategic for " + str + " is " + n3Var);
        Integer num = y.get(n3Var);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public static native int pageSize();

    public static String r(Context context, String str, n3 n3Var, q6.y yVar) {
        if ((context.getApplicationInfo().flags & 2) == 0) {
            i9();
        } else {
            t();
        }
        return f(str, n3Var, yVar);
    }

    private native void removeValueForKey(long j2, String str);

    private static native void setCallbackHandler(boolean z2, boolean z3);

    private static native void setLogLevel(int i);

    private static native void setWantsContentChangeNotify(boolean z2);

    private native void sync(boolean z2);

    public static void t() {
        synchronized (f6575gv) {
            f6573a = true;
        }
    }

    private native long totalSize(long j2);

    private native int valueSize(long j2, String str, boolean z2);

    public static native String version();

    private native int writeValueToNB(long j2, String str, long j4, int i);

    public static int x4(q6.y yVar) {
        int i = y.y[yVar.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        return 1;
                    }
                    return 4;
                }
                return 3;
            }
            return 2;
        }
        return 0;
    }

    public static MMKV y(long j2, String str, int i) throws RuntimeException {
        String str2;
        if (j2 != 0) {
            if (!f6573a) {
                return new MMKV(j2);
            }
            Set<Long> set = f6575gv;
            synchronized (set) {
                try {
                    if (!set.contains(Long.valueOf(j2))) {
                        if (!checkProcessMode(j2)) {
                            if (i == 1) {
                                str2 = "Opening a multi-process MMKV instance [" + str + "] with SINGLE_PROCESS_MODE!";
                            } else {
                                str2 = ("Opening an MMKV instance [" + str + "] with MULTI_PROCESS_MODE, ") + "while it's already been opened with SINGLE_PROCESS_MODE by someone somewhere else!";
                            }
                            throw new IllegalArgumentException(str2);
                        }
                        set.add(Long.valueOf(j2));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return new MMKV(j2);
        }
        throw new RuntimeException("Fail to create an MMKV instance [" + str + "] in JNI");
    }

    public static String z(Context context, String str) {
        return r(context, str, null, q6.y.LevelInfo);
    }

    public long a(String str, long j2) {
        return decodeLong(this.nativeHandle, str, j2);
    }

    @Nullable
    public native String[] allKeys();

    @Override // android.content.SharedPreferences.Editor
    @Deprecated
    public void apply() {
        sync(false);
    }

    public native int ashmemFD();

    public native int ashmemMetaFD();

    @Nullable
    public Set<String> c5(String str, @Nullable Set<String> set, Class<? extends Set> cls) {
        String[] decodeStringSet = decodeStringSet(this.nativeHandle, str);
        if (decodeStringSet == null) {
            return set;
        }
        try {
            Set<String> newInstance = cls.newInstance();
            newInstance.addAll(Arrays.asList(decodeStringSet));
            return newInstance;
        } catch (IllegalAccessException | InstantiationException unused) {
            return set;
        }
    }

    public native void checkContentChangedByOuterProcess();

    public native void checkReSetCryptKey(@Nullable String str);

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor clear() {
        clearAll();
        return this;
    }

    public native void clearAll();

    public native void clearMemoryCache();

    public native void close();

    public int co(SharedPreferences sharedPreferences) {
        Map<String, ?> all = sharedPreferences.getAll();
        if (all != null && all.size() > 0) {
            for (Map.Entry<String, ?> entry : all.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if (key != null && value != null) {
                    if (value instanceof Boolean) {
                        encodeBool(this.nativeHandle, key, ((Boolean) value).booleanValue());
                    } else if (value instanceof Integer) {
                        encodeInt(this.nativeHandle, key, ((Integer) value).intValue());
                    } else if (value instanceof Long) {
                        encodeLong(this.nativeHandle, key, ((Long) value).longValue());
                    } else if (value instanceof Float) {
                        encodeFloat(this.nativeHandle, key, ((Float) value).floatValue());
                    } else if (value instanceof Double) {
                        encodeDouble(this.nativeHandle, key, ((Double) value).doubleValue());
                    } else if (value instanceof String) {
                        encodeString(this.nativeHandle, key, (String) value);
                    } else if (value instanceof Set) {
                        p(key, (Set) value);
                    } else {
                        q6.y yVar = q6.y.LevelError;
                        n(yVar, "unknown type: " + value.getClass());
                    }
                }
            }
            return all.size();
        }
        return 0;
    }

    @Override // android.content.SharedPreferences.Editor
    @Deprecated
    public boolean commit() {
        sync(true);
        return true;
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        return n3(str);
    }

    @Nullable
    public native String cryptKey();

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return this;
    }

    public void f3(String str) {
        removeValueForKey(this.nativeHandle, str);
    }

    @Nullable
    public String fb(String str, @Nullable String str2) {
        return decodeString(this.nativeHandle, str, str2);
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        throw new UnsupportedOperationException("Intentionally Not Supported. Use allKeys() instead, getAll() not implement because type-erasure inside mmkv");
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z2) {
        return decodeBool(this.nativeHandle, str, z2);
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f4) {
        return decodeFloat(this.nativeHandle, str, f4);
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i) {
        return decodeInt(this.nativeHandle, str, i);
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j2) {
        return decodeLong(this.nativeHandle, str, j2);
    }

    @Override // android.content.SharedPreferences
    @Nullable
    public String getString(String str, @Nullable String str2) {
        return decodeString(this.nativeHandle, str, str2);
    }

    @Override // android.content.SharedPreferences
    @Nullable
    public Set<String> getStringSet(String str, @Nullable Set<String> set) {
        return s(str, set);
    }

    public float gv(String str, float f4) {
        return decodeFloat(this.nativeHandle, str, f4);
    }

    public native void lock();

    public native String mmapID();

    public boolean mt(String str, boolean z2) {
        return encodeBool(this.nativeHandle, str, z2);
    }

    public boolean n3(String str) {
        return containsKey(this.nativeHandle, str);
    }

    public boolean p(String str, @Nullable Set<String> set) {
        String[] strArr;
        long j2 = this.nativeHandle;
        if (set == null) {
            strArr = null;
        } else {
            strArr = (String[]) set.toArray(new String[0]);
        }
        return encodeSet(j2, str, strArr);
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putBoolean(String str, boolean z2) {
        encodeBool(this.nativeHandle, str, z2);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putFloat(String str, float f4) {
        encodeFloat(this.nativeHandle, str, f4);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putInt(String str, int i) {
        encodeInt(this.nativeHandle, str, i);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putLong(String str, long j2) {
        encodeLong(this.nativeHandle, str, j2);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putString(String str, @Nullable String str2) {
        encodeString(this.nativeHandle, str, str2);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putStringSet(String str, @Nullable Set<String> set) {
        p(str, set);
        return this;
    }

    public native boolean reKey(@Nullable String str);

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        throw new UnsupportedOperationException("Intentionally Not implement in MMKV");
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor remove(String str) {
        f3(str);
        return this;
    }

    public native void removeValuesForKeys(String[] strArr);

    @Nullable
    public Set<String> s(String str, @Nullable Set<String> set) {
        return c5(str, set, HashSet.class);
    }

    public boolean tl(String str, float f4) {
        return encodeFloat(this.nativeHandle, str, f4);
    }

    public native void trim();

    public native boolean tryLock();

    public native void unlock();

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        throw new UnsupportedOperationException("Intentionally Not implement in MMKV");
    }

    public int v(String str, int i) {
        return decodeInt(this.nativeHandle, str, i);
    }

    public boolean w(String str, @Nullable String str2) {
        return encodeString(this.nativeHandle, str, str2);
    }

    public boolean wz(String str, int i) {
        return encodeInt(this.nativeHandle, str, i);
    }

    public boolean xc(String str, long j2) {
        return encodeLong(this.nativeHandle, str, j2);
    }

    public boolean zn(String str, boolean z2) {
        return decodeBool(this.nativeHandle, str, z2);
    }
}
