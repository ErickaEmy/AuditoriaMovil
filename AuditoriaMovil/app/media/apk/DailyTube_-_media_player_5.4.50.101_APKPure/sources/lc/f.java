package lc;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.Serializable;
/* loaded from: classes.dex */
public abstract class f<T> {
    public final boolean y;
    @NonNull

    /* renamed from: n3  reason: collision with root package name */
    public static final f<Integer> f10277n3 = new zn(false);
    @NonNull

    /* renamed from: zn  reason: collision with root package name */
    public static final f<Integer> f10281zn = new gv(false);
    @NonNull

    /* renamed from: gv  reason: collision with root package name */
    public static final f<int[]> f10275gv = new v(true);
    @NonNull

    /* renamed from: v  reason: collision with root package name */
    public static final f<Long> f10280v = new a(false);
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public static final f<long[]> f10271a = new fb(true);
    @NonNull

    /* renamed from: fb  reason: collision with root package name */
    public static final f<Float> f10274fb = new s(false);
    @NonNull

    /* renamed from: s  reason: collision with root package name */
    public static final f<float[]> f10278s = new c5(true);
    @NonNull

    /* renamed from: c5  reason: collision with root package name */
    public static final f<Boolean> f10272c5 = new i9(false);
    @NonNull

    /* renamed from: i9  reason: collision with root package name */
    public static final f<boolean[]> f10276i9 = new C0146f(true);
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public static final f<String> f10273f = new y(true);
    @NonNull

    /* renamed from: t  reason: collision with root package name */
    public static final f<String[]> f10279t = new n3(true);

    /* loaded from: classes.dex */
    public class a extends f<Long> {
        public a(boolean z2) {
            super(z2);
        }

        @Override // lc.f
        @NonNull
        /* renamed from: f */
        public Long s(@NonNull String str) {
            if (str.endsWith("L")) {
                str = str.substring(0, str.length() - 1);
            }
            if (str.startsWith("0x")) {
                return Long.valueOf(Long.parseLong(str.substring(2), 16));
            }
            return Long.valueOf(Long.parseLong(str));
        }

        @Override // lc.f
        /* renamed from: i9 */
        public Long n3(@NonNull Bundle bundle, @NonNull String str) {
            return (Long) bundle.get(str);
        }

        @Override // lc.f
        /* renamed from: t */
        public void c5(@NonNull Bundle bundle, @NonNull String str, @NonNull Long l2) {
            bundle.putLong(str, l2.longValue());
        }

        @Override // lc.f
        @NonNull
        public String zn() {
            return "long";
        }
    }

    /* loaded from: classes.dex */
    public class c5 extends f<float[]> {
        public c5(boolean z2) {
            super(z2);
        }

        @Override // lc.f
        @NonNull
        /* renamed from: f */
        public float[] s(@NonNull String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        @Override // lc.f
        /* renamed from: i9 */
        public float[] n3(@NonNull Bundle bundle, @NonNull String str) {
            return (float[]) bundle.get(str);
        }

        @Override // lc.f
        /* renamed from: t */
        public void c5(@NonNull Bundle bundle, @NonNull String str, @Nullable float[] fArr) {
            bundle.putFloatArray(str, fArr);
        }

        @Override // lc.f
        @NonNull
        public String zn() {
            return "float[]";
        }
    }

    /* renamed from: lc.f$f  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0146f extends f<boolean[]> {
        public C0146f(boolean z2) {
            super(z2);
        }

        @Override // lc.f
        @NonNull
        /* renamed from: f */
        public boolean[] s(@NonNull String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        @Override // lc.f
        /* renamed from: i9 */
        public boolean[] n3(@NonNull Bundle bundle, @NonNull String str) {
            return (boolean[]) bundle.get(str);
        }

        @Override // lc.f
        /* renamed from: t */
        public void c5(@NonNull Bundle bundle, @NonNull String str, @Nullable boolean[] zArr) {
            bundle.putBooleanArray(str, zArr);
        }

        @Override // lc.f
        @NonNull
        public String zn() {
            return "boolean[]";
        }
    }

    /* loaded from: classes.dex */
    public class fb extends f<long[]> {
        public fb(boolean z2) {
            super(z2);
        }

        @Override // lc.f
        @NonNull
        /* renamed from: f */
        public long[] s(@NonNull String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        @Override // lc.f
        /* renamed from: i9 */
        public long[] n3(@NonNull Bundle bundle, @NonNull String str) {
            return (long[]) bundle.get(str);
        }

        @Override // lc.f
        /* renamed from: t */
        public void c5(@NonNull Bundle bundle, @NonNull String str, @Nullable long[] jArr) {
            bundle.putLongArray(str, jArr);
        }

        @Override // lc.f
        @NonNull
        public String zn() {
            return "long[]";
        }
    }

    /* loaded from: classes.dex */
    public class gv extends f<Integer> {
        public gv(boolean z2) {
            super(z2);
        }

        @Override // lc.f
        @NonNull
        /* renamed from: f */
        public Integer s(@NonNull String str) {
            if (str.startsWith("0x")) {
                return Integer.valueOf(Integer.parseInt(str.substring(2), 16));
            }
            return Integer.valueOf(Integer.parseInt(str));
        }

        @Override // lc.f
        /* renamed from: i9 */
        public Integer n3(@NonNull Bundle bundle, @NonNull String str) {
            return (Integer) bundle.get(str);
        }

        @Override // lc.f
        /* renamed from: t */
        public void c5(@NonNull Bundle bundle, @NonNull String str, @NonNull Integer num) {
            bundle.putInt(str, num.intValue());
        }

        @Override // lc.f
        @NonNull
        public String zn() {
            return "reference";
        }
    }

    /* loaded from: classes.dex */
    public class i9 extends f<Boolean> {
        public i9(boolean z2) {
            super(z2);
        }

        @Override // lc.f
        @NonNull
        /* renamed from: f */
        public Boolean s(@NonNull String str) {
            if ("true".equals(str)) {
                return Boolean.TRUE;
            }
            if ("false".equals(str)) {
                return Boolean.FALSE;
            }
            throw new IllegalArgumentException("A boolean NavType only accepts \"true\" or \"false\" values.");
        }

        @Override // lc.f
        /* renamed from: i9 */
        public Boolean n3(@NonNull Bundle bundle, @NonNull String str) {
            return (Boolean) bundle.get(str);
        }

        @Override // lc.f
        /* renamed from: t */
        public void c5(@NonNull Bundle bundle, @NonNull String str, @NonNull Boolean bool) {
            bundle.putBoolean(str, bool.booleanValue());
        }

        @Override // lc.f
        @NonNull
        public String zn() {
            return "boolean";
        }
    }

    /* loaded from: classes.dex */
    public class n3 extends f<String[]> {
        public n3(boolean z2) {
            super(z2);
        }

        @Override // lc.f
        @NonNull
        /* renamed from: f */
        public String[] s(@NonNull String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        @Override // lc.f
        /* renamed from: i9 */
        public String[] n3(@NonNull Bundle bundle, @NonNull String str) {
            return (String[]) bundle.get(str);
        }

        @Override // lc.f
        /* renamed from: t */
        public void c5(@NonNull Bundle bundle, @NonNull String str, @Nullable String[] strArr) {
            bundle.putStringArray(str, strArr);
        }

        @Override // lc.f
        @NonNull
        public String zn() {
            return "string[]";
        }
    }

    /* loaded from: classes.dex */
    public class s extends f<Float> {
        public s(boolean z2) {
            super(z2);
        }

        @Override // lc.f
        @NonNull
        /* renamed from: f */
        public Float s(@NonNull String str) {
            return Float.valueOf(Float.parseFloat(str));
        }

        @Override // lc.f
        /* renamed from: i9 */
        public Float n3(@NonNull Bundle bundle, @NonNull String str) {
            return (Float) bundle.get(str);
        }

        @Override // lc.f
        /* renamed from: t */
        public void c5(@NonNull Bundle bundle, @NonNull String str, @NonNull Float f4) {
            bundle.putFloat(str, f4.floatValue());
        }

        @Override // lc.f
        @NonNull
        public String zn() {
            return "float";
        }
    }

    /* loaded from: classes.dex */
    public static final class t<D extends Enum> extends w<D> {
        @NonNull

        /* renamed from: wz  reason: collision with root package name */
        public final Class<D> f10282wz;

        public t(@NonNull Class<D> cls) {
            super(false, cls);
            if (cls.isEnum()) {
                this.f10282wz = cls;
                return;
            }
            throw new IllegalArgumentException(cls + " is not an Enum type.");
        }

        @Override // lc.f.w, lc.f
        @NonNull
        /* renamed from: tl */
        public D s(@NonNull String str) {
            D[] enumConstants;
            for (D d2 : this.f10282wz.getEnumConstants()) {
                if (d2.name().equals(str)) {
                    return d2;
                }
            }
            throw new IllegalArgumentException("Enum value " + str + " not found for type " + this.f10282wz.getName() + ".");
        }

        @Override // lc.f.w, lc.f
        @NonNull
        public String zn() {
            return this.f10282wz.getName();
        }
    }

    /* loaded from: classes.dex */
    public static final class tl<D extends Parcelable> extends f<D[]> {
        @NonNull

        /* renamed from: tl  reason: collision with root package name */
        public final Class<D[]> f10283tl;

        public tl(@NonNull Class<D> cls) {
            super(true);
            if (Parcelable.class.isAssignableFrom(cls)) {
                try {
                    this.f10283tl = (Class<D[]>) Class.forName("[L" + cls.getName() + ";");
                    return;
                } catch (ClassNotFoundException e2) {
                    throw new RuntimeException(e2);
                }
            }
            throw new IllegalArgumentException(cls + " does not implement Parcelable.");
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && tl.class == obj.getClass()) {
                return this.f10283tl.equals(((tl) obj).f10283tl);
            }
            return false;
        }

        @Override // lc.f
        @NonNull
        /* renamed from: f */
        public D[] s(@NonNull String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        public int hashCode() {
            return this.f10283tl.hashCode();
        }

        @Override // lc.f
        @Nullable
        /* renamed from: i9 */
        public D[] n3(@NonNull Bundle bundle, @NonNull String str) {
            return (D[]) ((Parcelable[]) bundle.get(str));
        }

        @Override // lc.f
        /* renamed from: t */
        public void c5(@NonNull Bundle bundle, @NonNull String str, @Nullable D[] dArr) {
            this.f10283tl.cast(dArr);
            bundle.putParcelableArray(str, dArr);
        }

        @Override // lc.f
        @NonNull
        public String zn() {
            return this.f10283tl.getName();
        }
    }

    /* loaded from: classes.dex */
    public class v extends f<int[]> {
        public v(boolean z2) {
            super(z2);
        }

        @Override // lc.f
        @NonNull
        /* renamed from: f */
        public int[] s(@NonNull String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        @Override // lc.f
        /* renamed from: i9 */
        public int[] n3(@NonNull Bundle bundle, @NonNull String str) {
            return (int[]) bundle.get(str);
        }

        @Override // lc.f
        /* renamed from: t */
        public void c5(@NonNull Bundle bundle, @NonNull String str, @Nullable int[] iArr) {
            bundle.putIntArray(str, iArr);
        }

        @Override // lc.f
        @NonNull
        public String zn() {
            return "integer[]";
        }
    }

    /* loaded from: classes.dex */
    public static final class wz<D> extends f<D> {
        @NonNull

        /* renamed from: tl  reason: collision with root package name */
        public final Class<D> f10285tl;

        public wz(@NonNull Class<D> cls) {
            super(true);
            if (!Parcelable.class.isAssignableFrom(cls) && !Serializable.class.isAssignableFrom(cls)) {
                throw new IllegalArgumentException(cls + " does not implement Parcelable or Serializable.");
            }
            this.f10285tl = cls;
        }

        @Override // lc.f
        public void c5(@NonNull Bundle bundle, @NonNull String str, @Nullable D d2) {
            this.f10285tl.cast(d2);
            if (d2 != null && !(d2 instanceof Parcelable)) {
                if (d2 instanceof Serializable) {
                    bundle.putSerializable(str, (Serializable) d2);
                    return;
                }
                return;
            }
            bundle.putParcelable(str, (Parcelable) d2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && wz.class == obj.getClass()) {
                return this.f10285tl.equals(((wz) obj).f10285tl);
            }
            return false;
        }

        public int hashCode() {
            return this.f10285tl.hashCode();
        }

        @Override // lc.f
        @Nullable
        public D n3(@NonNull Bundle bundle, @NonNull String str) {
            return (D) bundle.get(str);
        }

        @Override // lc.f
        @NonNull
        public D s(@NonNull String str) {
            throw new UnsupportedOperationException("Parcelables don't support default values.");
        }

        @Override // lc.f
        @NonNull
        public String zn() {
            return this.f10285tl.getName();
        }
    }

    /* loaded from: classes.dex */
    public static final class xc<D extends Serializable> extends f<D[]> {
        @NonNull

        /* renamed from: tl  reason: collision with root package name */
        public final Class<D[]> f10286tl;

        public xc(@NonNull Class<D> cls) {
            super(true);
            if (Serializable.class.isAssignableFrom(cls)) {
                try {
                    this.f10286tl = (Class<D[]>) Class.forName("[L" + cls.getName() + ";");
                    return;
                } catch (ClassNotFoundException e2) {
                    throw new RuntimeException(e2);
                }
            }
            throw new IllegalArgumentException(cls + " does not implement Serializable.");
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && xc.class == obj.getClass()) {
                return this.f10286tl.equals(((xc) obj).f10286tl);
            }
            return false;
        }

        @Override // lc.f
        @NonNull
        /* renamed from: f */
        public D[] s(@NonNull String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        public int hashCode() {
            return this.f10286tl.hashCode();
        }

        @Override // lc.f
        @Nullable
        /* renamed from: i9 */
        public D[] n3(@NonNull Bundle bundle, @NonNull String str) {
            return (D[]) ((Serializable[]) bundle.get(str));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // lc.f
        /* renamed from: t */
        public void c5(@NonNull Bundle bundle, @NonNull String str, @Nullable D[] dArr) {
            this.f10286tl.cast(dArr);
            bundle.putSerializable(str, dArr);
        }

        @Override // lc.f
        @NonNull
        public String zn() {
            return this.f10286tl.getName();
        }
    }

    /* loaded from: classes.dex */
    public class zn extends f<Integer> {
        public zn(boolean z2) {
            super(z2);
        }

        @Override // lc.f
        @NonNull
        /* renamed from: f */
        public Integer s(@NonNull String str) {
            if (str.startsWith("0x")) {
                return Integer.valueOf(Integer.parseInt(str.substring(2), 16));
            }
            return Integer.valueOf(Integer.parseInt(str));
        }

        @Override // lc.f
        /* renamed from: i9 */
        public Integer n3(@NonNull Bundle bundle, @NonNull String str) {
            return (Integer) bundle.get(str);
        }

        @Override // lc.f
        /* renamed from: t */
        public void c5(@NonNull Bundle bundle, @NonNull String str, @NonNull Integer num) {
            bundle.putInt(str, num.intValue());
        }

        @Override // lc.f
        @NonNull
        public String zn() {
            return "integer";
        }
    }

    public f(boolean z2) {
        this.y = z2;
    }

    @NonNull
    public static f gv(@NonNull String str) {
        try {
            try {
                try {
                    try {
                        f<Integer> fVar = f10277n3;
                        fVar.s(str);
                        return fVar;
                    } catch (IllegalArgumentException unused) {
                        f<Boolean> fVar2 = f10272c5;
                        fVar2.s(str);
                        return fVar2;
                    }
                } catch (IllegalArgumentException unused2) {
                    f<Float> fVar3 = f10274fb;
                    fVar3.s(str);
                    return fVar3;
                }
            } catch (IllegalArgumentException unused3) {
                f<Long> fVar4 = f10280v;
                fVar4.s(str);
                return fVar4;
            }
        } catch (IllegalArgumentException unused4) {
            return f10273f;
        }
    }

    @NonNull
    public static f v(@Nullable Object obj) {
        if (obj instanceof Integer) {
            return f10277n3;
        }
        if (obj instanceof int[]) {
            return f10275gv;
        }
        if (obj instanceof Long) {
            return f10280v;
        }
        if (obj instanceof long[]) {
            return f10271a;
        }
        if (obj instanceof Float) {
            return f10274fb;
        }
        if (obj instanceof float[]) {
            return f10278s;
        }
        if (obj instanceof Boolean) {
            return f10272c5;
        }
        if (obj instanceof boolean[]) {
            return f10276i9;
        }
        if (!(obj instanceof String) && obj != null) {
            if (obj instanceof String[]) {
                return f10279t;
            }
            if (obj.getClass().isArray() && Parcelable.class.isAssignableFrom(obj.getClass().getComponentType())) {
                return new tl(obj.getClass().getComponentType());
            }
            if (obj.getClass().isArray() && Serializable.class.isAssignableFrom(obj.getClass().getComponentType())) {
                return new xc(obj.getClass().getComponentType());
            }
            if (obj instanceof Parcelable) {
                return new wz(obj.getClass());
            }
            if (obj instanceof Enum) {
                return new t(obj.getClass());
            }
            if (obj instanceof Serializable) {
                return new w(obj.getClass());
            }
            throw new IllegalArgumentException("Object of type " + obj.getClass().getName() + " is not supported for navigation arguments.");
        }
        return f10273f;
    }

    @NonNull
    public static f<?> y(@Nullable String str, @Nullable String str2) {
        String str3;
        f<Integer> fVar = f10277n3;
        if (fVar.zn().equals(str)) {
            return fVar;
        }
        f fVar2 = f10275gv;
        if (fVar2.zn().equals(str)) {
            return fVar2;
        }
        f<Long> fVar3 = f10280v;
        if (fVar3.zn().equals(str)) {
            return fVar3;
        }
        f fVar4 = f10271a;
        if (fVar4.zn().equals(str)) {
            return fVar4;
        }
        f<Boolean> fVar5 = f10272c5;
        if (fVar5.zn().equals(str)) {
            return fVar5;
        }
        f fVar6 = f10276i9;
        if (fVar6.zn().equals(str)) {
            return fVar6;
        }
        f<String> fVar7 = f10273f;
        if (fVar7.zn().equals(str)) {
            return fVar7;
        }
        f fVar8 = f10279t;
        if (fVar8.zn().equals(str)) {
            return fVar8;
        }
        f<Float> fVar9 = f10274fb;
        if (fVar9.zn().equals(str)) {
            return fVar9;
        }
        f fVar10 = f10278s;
        if (fVar10.zn().equals(str)) {
            return fVar10;
        }
        f<Integer> fVar11 = f10281zn;
        if (fVar11.zn().equals(str)) {
            return fVar11;
        }
        if (str != null && !str.isEmpty()) {
            try {
                if (str.startsWith(".") && str2 != null) {
                    str3 = str2 + str;
                } else {
                    str3 = str;
                }
                if (str.endsWith("[]")) {
                    str3 = str3.substring(0, str3.length() - 2);
                    Class<?> cls = Class.forName(str3);
                    if (Parcelable.class.isAssignableFrom(cls)) {
                        return new tl(cls);
                    }
                    if (Serializable.class.isAssignableFrom(cls)) {
                        return new xc(cls);
                    }
                } else {
                    Class<?> cls2 = Class.forName(str3);
                    if (Parcelable.class.isAssignableFrom(cls2)) {
                        return new wz(cls2);
                    }
                    if (Enum.class.isAssignableFrom(cls2)) {
                        return new t(cls2);
                    }
                    if (Serializable.class.isAssignableFrom(cls2)) {
                        return new w(cls2);
                    }
                }
                throw new IllegalArgumentException(str3 + " is not Serializable or Parcelable.");
            } catch (ClassNotFoundException e2) {
                throw new RuntimeException(e2);
            }
        }
        return fVar7;
    }

    public boolean a() {
        return this.y;
    }

    public abstract void c5(@NonNull Bundle bundle, @NonNull String str, @Nullable T t2);

    @NonNull
    public T fb(@NonNull Bundle bundle, @NonNull String str, @NonNull String str2) {
        T s2 = s(str2);
        c5(bundle, str, s2);
        return s2;
    }

    @Nullable
    public abstract T n3(@NonNull Bundle bundle, @NonNull String str);

    @NonNull
    public abstract T s(@NonNull String str);

    @NonNull
    public String toString() {
        return zn();
    }

    @NonNull
    public abstract String zn();

    /* loaded from: classes.dex */
    public static class w<D extends Serializable> extends f<D> {
        @NonNull

        /* renamed from: tl  reason: collision with root package name */
        public final Class<D> f10284tl;

        public w(@NonNull Class<D> cls) {
            super(true);
            if (Serializable.class.isAssignableFrom(cls)) {
                if (!cls.isEnum()) {
                    this.f10284tl = cls;
                    return;
                }
                throw new IllegalArgumentException(cls + " is an Enum. You should use EnumType instead.");
            }
            throw new IllegalArgumentException(cls + " does not implement Serializable.");
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof w)) {
                return false;
            }
            return this.f10284tl.equals(((w) obj).f10284tl);
        }

        @Override // lc.f
        @NonNull
        /* renamed from: f */
        public D s(@NonNull String str) {
            throw new UnsupportedOperationException("Serializables don't support default values.");
        }

        public int hashCode() {
            return this.f10284tl.hashCode();
        }

        @Override // lc.f
        @Nullable
        /* renamed from: i9 */
        public D n3(@NonNull Bundle bundle, @NonNull String str) {
            return (D) bundle.get(str);
        }

        @Override // lc.f
        /* renamed from: t */
        public void c5(@NonNull Bundle bundle, @NonNull String str, @Nullable D d2) {
            this.f10284tl.cast(d2);
            bundle.putSerializable(str, d2);
        }

        @Override // lc.f
        @NonNull
        public String zn() {
            return this.f10284tl.getName();
        }

        public w(boolean z2, @NonNull Class<D> cls) {
            super(z2);
            if (Serializable.class.isAssignableFrom(cls)) {
                this.f10284tl = cls;
                return;
            }
            throw new IllegalArgumentException(cls + " does not implement Serializable.");
        }
    }

    /* loaded from: classes.dex */
    public class y extends f<String> {
        public y(boolean z2) {
            super(z2);
        }

        @Override // lc.f
        /* renamed from: i9 */
        public String n3(@NonNull Bundle bundle, @NonNull String str) {
            return (String) bundle.get(str);
        }

        @Override // lc.f
        /* renamed from: t */
        public void c5(@NonNull Bundle bundle, @NonNull String str, @Nullable String str2) {
            bundle.putString(str, str2);
        }

        @Override // lc.f
        @NonNull
        public String zn() {
            return "string";
        }

        @Override // lc.f
        @NonNull
        /* renamed from: f */
        public String s(@NonNull String str) {
            return str;
        }
    }
}
