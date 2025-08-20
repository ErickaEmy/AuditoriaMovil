package androidx.work;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import l.f;
/* loaded from: classes.dex */
public final class n3 {

    /* renamed from: n3  reason: collision with root package name */
    public static final String f3772n3 = f.a("Data");

    /* renamed from: zn  reason: collision with root package name */
    public static final n3 f3773zn = new y().y();
    public Map<String, Object> y;

    /* loaded from: classes.dex */
    public static final class y {
        public Map<String, Object> y = new HashMap();

        @NonNull
        public y gv(@NonNull Map<String, Object> map) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                n3(entry.getKey(), entry.getValue());
            }
            return this;
        }

        @NonNull
        public y n3(@NonNull String str, @Nullable Object obj) {
            if (obj == null) {
                this.y.put(str, null);
            } else {
                Class<?> cls = obj.getClass();
                if (cls != Boolean.class && cls != Byte.class && cls != Integer.class && cls != Long.class && cls != Float.class && cls != Double.class && cls != String.class && cls != Boolean[].class && cls != Byte[].class && cls != Integer[].class && cls != Long[].class && cls != Float[].class && cls != Double[].class && cls != String[].class) {
                    if (cls == boolean[].class) {
                        this.y.put(str, n3.y((boolean[]) obj));
                    } else if (cls == byte[].class) {
                        this.y.put(str, n3.n3((byte[]) obj));
                    } else if (cls == int[].class) {
                        this.y.put(str, n3.v((int[]) obj));
                    } else if (cls == long[].class) {
                        this.y.put(str, n3.a((long[]) obj));
                    } else if (cls == float[].class) {
                        this.y.put(str, n3.gv((float[]) obj));
                    } else if (cls == double[].class) {
                        this.y.put(str, n3.zn((double[]) obj));
                    } else {
                        throw new IllegalArgumentException(String.format("Key %s has invalid type %s", str, cls));
                    }
                } else {
                    this.y.put(str, obj);
                }
            }
            return this;
        }

        @NonNull
        public y v(@NonNull String str, @Nullable String str2) {
            this.y.put(str, str2);
            return this;
        }

        @NonNull
        public n3 y() {
            n3 n3Var = new n3(this.y);
            n3.f(n3Var);
            return n3Var;
        }

        @NonNull
        public y zn(@NonNull n3 n3Var) {
            gv(n3Var.y);
            return this;
        }
    }

    public n3() {
    }

    @NonNull
    public static Long[] a(@NonNull long[] jArr) {
        Long[] lArr = new Long[jArr.length];
        for (int i = 0; i < jArr.length; i++) {
            lArr[i] = Long.valueOf(jArr[i]);
        }
        return lArr;
    }

    @NonNull
    public static byte[] f(@NonNull n3 n3Var) {
        ObjectOutputStream objectOutputStream;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream2 = null;
        try {
            try {
                objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e2) {
            e = e2;
        }
        try {
            objectOutputStream.writeInt(n3Var.i9());
            for (Map.Entry<String, Object> entry : n3Var.y.entrySet()) {
                objectOutputStream.writeUTF(entry.getKey());
                objectOutputStream.writeObject(entry.getValue());
            }
            try {
                objectOutputStream.close();
            } catch (IOException e3) {
                Log.e(f3772n3, "Error in Data#toByteArray: ", e3);
            }
            try {
                byteArrayOutputStream.close();
            } catch (IOException e5) {
                Log.e(f3772n3, "Error in Data#toByteArray: ", e5);
            }
            if (byteArrayOutputStream.size() <= 10240) {
                return byteArrayOutputStream.toByteArray();
            }
            throw new IllegalStateException("Data cannot occupy more than 10240 bytes when serialized");
        } catch (IOException e6) {
            e = e6;
            objectOutputStream2 = objectOutputStream;
            Log.e(f3772n3, "Error in Data#toByteArray: ", e);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (objectOutputStream2 != null) {
                try {
                    objectOutputStream2.close();
                } catch (IOException e8) {
                    Log.e(f3772n3, "Error in Data#toByteArray: ", e8);
                }
            }
            try {
                byteArrayOutputStream.close();
            } catch (IOException e9) {
                Log.e(f3772n3, "Error in Data#toByteArray: ", e9);
            }
            return byteArray;
        } catch (Throwable th2) {
            th = th2;
            objectOutputStream2 = objectOutputStream;
            if (objectOutputStream2 != null) {
                try {
                    objectOutputStream2.close();
                } catch (IOException e10) {
                    Log.e(f3772n3, "Error in Data#toByteArray: ", e10);
                }
            }
            try {
                byteArrayOutputStream.close();
            } catch (IOException e11) {
                Log.e(f3772n3, "Error in Data#toByteArray: ", e11);
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x0058 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0040 -> B:37:0x0065). Please submit an issue!!! */
    @androidx.annotation.NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static androidx.work.n3 fb(@androidx.annotation.NonNull byte[] r7) {
        /*
            java.lang.String r0 = "Error in Data#fromByteArray: "
            int r1 = r7.length
            r2 = 10240(0x2800, float:1.4349E-41)
            if (r1 > r2) goto L82
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            java.io.ByteArrayInputStream r2 = new java.io.ByteArrayInputStream
            r2.<init>(r7)
            r7 = 0
            java.io.ObjectInputStream r3 = new java.io.ObjectInputStream     // Catch: java.lang.Throwable -> L46 java.lang.ClassNotFoundException -> L4a java.io.IOException -> L4f
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L46 java.lang.ClassNotFoundException -> L4a java.io.IOException -> L4f
            int r7 = r3.readInt()     // Catch: java.lang.Throwable -> L2b java.lang.ClassNotFoundException -> L2d java.io.IOException -> L2f
        L1b:
            if (r7 <= 0) goto L31
            java.lang.String r4 = r3.readUTF()     // Catch: java.lang.Throwable -> L2b java.lang.ClassNotFoundException -> L2d java.io.IOException -> L2f
            java.lang.Object r5 = r3.readObject()     // Catch: java.lang.Throwable -> L2b java.lang.ClassNotFoundException -> L2d java.io.IOException -> L2f
            r1.put(r4, r5)     // Catch: java.lang.Throwable -> L2b java.lang.ClassNotFoundException -> L2d java.io.IOException -> L2f
            int r7 = r7 + (-1)
            goto L1b
        L2b:
            r7 = move-exception
            goto L6b
        L2d:
            r7 = move-exception
            goto L51
        L2f:
            r7 = move-exception
            goto L51
        L31:
            r3.close()     // Catch: java.io.IOException -> L35
            goto L3b
        L35:
            r7 = move-exception
            java.lang.String r3 = androidx.work.n3.f3772n3
            android.util.Log.e(r3, r0, r7)
        L3b:
            r2.close()     // Catch: java.io.IOException -> L3f
            goto L65
        L3f:
            r7 = move-exception
            java.lang.String r2 = androidx.work.n3.f3772n3
            android.util.Log.e(r2, r0, r7)
            goto L65
        L46:
            r1 = move-exception
            r3 = r7
            r7 = r1
            goto L6b
        L4a:
            r3 = move-exception
        L4b:
            r6 = r3
            r3 = r7
            r7 = r6
            goto L51
        L4f:
            r3 = move-exception
            goto L4b
        L51:
            java.lang.String r4 = androidx.work.n3.f3772n3     // Catch: java.lang.Throwable -> L2b
            android.util.Log.e(r4, r0, r7)     // Catch: java.lang.Throwable -> L2b
            if (r3 == 0) goto L62
            r3.close()     // Catch: java.io.IOException -> L5c
            goto L62
        L5c:
            r7 = move-exception
            java.lang.String r3 = androidx.work.n3.f3772n3
            android.util.Log.e(r3, r0, r7)
        L62:
            r2.close()     // Catch: java.io.IOException -> L3f
        L65:
            androidx.work.n3 r7 = new androidx.work.n3
            r7.<init>(r1)
            return r7
        L6b:
            if (r3 == 0) goto L77
            r3.close()     // Catch: java.io.IOException -> L71
            goto L77
        L71:
            r1 = move-exception
            java.lang.String r3 = androidx.work.n3.f3772n3
            android.util.Log.e(r3, r0, r1)
        L77:
            r2.close()     // Catch: java.io.IOException -> L7b
            goto L81
        L7b:
            r1 = move-exception
            java.lang.String r2 = androidx.work.n3.f3772n3
            android.util.Log.e(r2, r0, r1)
        L81:
            throw r7
        L82:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "Data cannot occupy more than 10240 bytes when serialized"
            r7.<init>(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.n3.fb(byte[]):androidx.work.n3");
    }

    @NonNull
    public static Float[] gv(@NonNull float[] fArr) {
        Float[] fArr2 = new Float[fArr.length];
        for (int i = 0; i < fArr.length; i++) {
            fArr2[i] = Float.valueOf(fArr[i]);
        }
        return fArr2;
    }

    @NonNull
    public static Byte[] n3(@NonNull byte[] bArr) {
        Byte[] bArr2 = new Byte[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            bArr2[i] = Byte.valueOf(bArr[i]);
        }
        return bArr2;
    }

    @NonNull
    public static Integer[] v(@NonNull int[] iArr) {
        Integer[] numArr = new Integer[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            numArr[i] = Integer.valueOf(iArr[i]);
        }
        return numArr;
    }

    @NonNull
    public static Boolean[] y(@NonNull boolean[] zArr) {
        Boolean[] boolArr = new Boolean[zArr.length];
        for (int i = 0; i < zArr.length; i++) {
            boolArr[i] = Boolean.valueOf(zArr[i]);
        }
        return boolArr;
    }

    @NonNull
    public static Double[] zn(@NonNull double[] dArr) {
        Double[] dArr2 = new Double[dArr.length];
        for (int i = 0; i < dArr.length; i++) {
            dArr2[i] = Double.valueOf(dArr[i]);
        }
        return dArr2;
    }

    @Nullable
    public String c5(@NonNull String str) {
        Object obj = this.y.get(str);
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    public boolean equals(Object obj) {
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj == null || n3.class != obj.getClass()) {
            return false;
        }
        n3 n3Var = (n3) obj;
        Set<String> keySet = this.y.keySet();
        if (!keySet.equals(n3Var.y.keySet())) {
            return false;
        }
        for (String str : keySet) {
            Object obj2 = this.y.get(str);
            Object obj3 = n3Var.y.get(str);
            if (obj2 != null && obj3 != null) {
                if ((obj2 instanceof Object[]) && (obj3 instanceof Object[])) {
                    z2 = Arrays.deepEquals((Object[]) obj2, (Object[]) obj3);
                    continue;
                } else {
                    z2 = obj2.equals(obj3);
                    continue;
                }
            } else if (obj2 == obj3) {
                z2 = true;
                continue;
            } else {
                z2 = false;
                continue;
            }
            if (!z2) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        return this.y.hashCode() * 31;
    }

    public int i9() {
        return this.y.size();
    }

    @NonNull
    public Map<String, Object> s() {
        return Collections.unmodifiableMap(this.y);
    }

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder("Data {");
        if (!this.y.isEmpty()) {
            for (String str : this.y.keySet()) {
                sb.append(str);
                sb.append(" : ");
                Object obj = this.y.get(str);
                if (obj instanceof Object[]) {
                    sb.append(Arrays.toString((Object[]) obj));
                } else {
                    sb.append(obj);
                }
                sb.append(", ");
            }
        }
        sb.append("}");
        return sb.toString();
    }

    public n3(@NonNull n3 n3Var) {
        this.y = new HashMap(n3Var.y);
    }

    public n3(@NonNull Map<String, ?> map) {
        this.y = new HashMap(map);
    }
}
