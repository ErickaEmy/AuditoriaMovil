package o6;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import o6.a;
import o6.f;
/* loaded from: classes.dex */
public final class r {
    public static final a.y y = new zn();

    /* renamed from: n3  reason: collision with root package name */
    public static final o6.a<Boolean> f12197n3 = new gv();

    /* renamed from: zn  reason: collision with root package name */
    public static final o6.a<Byte> f12200zn = new v();

    /* renamed from: gv  reason: collision with root package name */
    public static final o6.a<Character> f12195gv = new a();

    /* renamed from: v  reason: collision with root package name */
    public static final o6.a<Double> f12199v = new fb();

    /* renamed from: a  reason: collision with root package name */
    public static final o6.a<Float> f12192a = new s();

    /* renamed from: fb  reason: collision with root package name */
    public static final o6.a<Integer> f12194fb = new c5();

    /* renamed from: s  reason: collision with root package name */
    public static final o6.a<Long> f12198s = new i9();

    /* renamed from: c5  reason: collision with root package name */
    public static final o6.a<Short> f12193c5 = new f();

    /* renamed from: i9  reason: collision with root package name */
    public static final o6.a<String> f12196i9 = new y();

    /* loaded from: classes.dex */
    public class a extends o6.a<Character> {
        @Override // o6.a
        /* renamed from: c5 */
        public void a(w wVar, Character ch) throws IOException {
            wVar.j(ch.toString());
        }

        @Override // o6.a
        /* renamed from: s */
        public Character n3(o6.f fVar) throws IOException {
            String b2 = fVar.b();
            if (b2.length() <= 1) {
                return Character.valueOf(b2.charAt(0));
            }
            throw new o6.s(String.format("Expected %s but was %s at path %s", "a char", '\"' + b2 + '\"', fVar.getPath()));
        }

        public String toString() {
            return "JsonAdapter(Character)";
        }
    }

    /* loaded from: classes.dex */
    public class c5 extends o6.a<Integer> {
        @Override // o6.a
        /* renamed from: c5 */
        public void a(w wVar, Integer num) throws IOException {
            wVar.yt(num.intValue());
        }

        @Override // o6.a
        /* renamed from: s */
        public Integer n3(o6.f fVar) throws IOException {
            return Integer.valueOf(fVar.ta());
        }

        public String toString() {
            return "JsonAdapter(Integer)";
        }
    }

    /* loaded from: classes.dex */
    public class f extends o6.a<Short> {
        @Override // o6.a
        /* renamed from: c5 */
        public void a(w wVar, Short sh) throws IOException {
            wVar.yt(sh.intValue());
        }

        @Override // o6.a
        /* renamed from: s */
        public Short n3(o6.f fVar) throws IOException {
            return Short.valueOf((short) r.y(fVar, "a short", -32768, 32767));
        }

        public String toString() {
            return "JsonAdapter(Short)";
        }
    }

    /* loaded from: classes.dex */
    public class fb extends o6.a<Double> {
        @Override // o6.a
        /* renamed from: c5 */
        public void a(w wVar, Double d2) throws IOException {
            wVar.k5(d2.doubleValue());
        }

        @Override // o6.a
        /* renamed from: s */
        public Double n3(o6.f fVar) throws IOException {
            return Double.valueOf(fVar.x4());
        }

        public String toString() {
            return "JsonAdapter(Double)";
        }
    }

    /* loaded from: classes.dex */
    public class gv extends o6.a<Boolean> {
        @Override // o6.a
        /* renamed from: c5 */
        public void a(w wVar, Boolean bool) throws IOException {
            wVar.jz(bool.booleanValue());
        }

        @Override // o6.a
        /* renamed from: s */
        public Boolean n3(o6.f fVar) throws IOException {
            return Boolean.valueOf(fVar.r());
        }

        public String toString() {
            return "JsonAdapter(Boolean)";
        }
    }

    /* loaded from: classes.dex */
    public class i9 extends o6.a<Long> {
        @Override // o6.a
        /* renamed from: c5 */
        public void a(w wVar, Long l2) throws IOException {
            wVar.yt(l2.longValue());
        }

        @Override // o6.a
        /* renamed from: s */
        public Long n3(o6.f fVar) throws IOException {
            return Long.valueOf(fVar.d());
        }

        public String toString() {
            return "JsonAdapter(Long)";
        }
    }

    /* loaded from: classes.dex */
    public static /* synthetic */ class n3 {
        public static final /* synthetic */ int[] y;

        static {
            int[] iArr = new int[f.n3.values().length];
            y = iArr;
            try {
                iArr[f.n3.BEGIN_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                y[f.n3.BEGIN_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                y[f.n3.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                y[f.n3.NUMBER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                y[f.n3.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                y[f.n3.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* loaded from: classes.dex */
    public class s extends o6.a<Float> {
        @Override // o6.a
        /* renamed from: c5 */
        public void a(w wVar, Float f4) throws IOException {
            f4.getClass();
            wVar.j5(f4);
        }

        @Override // o6.a
        /* renamed from: s */
        public Float n3(o6.f fVar) throws IOException {
            float x42 = (float) fVar.x4();
            if (!fVar.co() && Float.isInfinite(x42)) {
                throw new o6.s("JSON forbids NaN and infinities: " + x42 + " at path " + fVar.getPath());
            }
            return Float.valueOf(x42);
        }

        public String toString() {
            return "JsonAdapter(Float)";
        }
    }

    /* loaded from: classes.dex */
    public static final class t<T extends Enum<T>> extends o6.a<T> {

        /* renamed from: gv  reason: collision with root package name */
        public final f.y f12201gv;

        /* renamed from: n3  reason: collision with root package name */
        public final String[] f12202n3;
        public final Class<T> y;

        /* renamed from: zn  reason: collision with root package name */
        public final T[] f12203zn;

        public t(Class<T> cls) {
            this.y = cls;
            try {
                T[] enumConstants = cls.getEnumConstants();
                this.f12203zn = enumConstants;
                this.f12202n3 = new String[enumConstants.length];
                int i = 0;
                while (true) {
                    T[] tArr = this.f12203zn;
                    if (i < tArr.length) {
                        String name = tArr[i].name();
                        this.f12202n3[i] = p6.n3.t(name, cls.getField(name));
                        i++;
                    } else {
                        this.f12201gv = f.y.y(this.f12202n3);
                        return;
                    }
                }
            } catch (NoSuchFieldException e2) {
                throw new AssertionError("Missing field in " + cls.getName(), e2);
            }
        }

        @Override // o6.a
        /* renamed from: c5 */
        public void a(w wVar, T t2) throws IOException {
            wVar.j(this.f12202n3[t2.ordinal()]);
        }

        @Override // o6.a
        /* renamed from: s */
        public T n3(o6.f fVar) throws IOException {
            int dm2 = fVar.dm(this.f12201gv);
            if (dm2 != -1) {
                return this.f12203zn[dm2];
            }
            String path = fVar.getPath();
            String b2 = fVar.b();
            throw new o6.s("Expected one of " + Arrays.asList(this.f12202n3) + " but was " + b2 + " at path " + path);
        }

        public String toString() {
            return "JsonAdapter(" + this.y.getName() + ")";
        }
    }

    /* loaded from: classes.dex */
    public static final class tl extends o6.a<Object> {

        /* renamed from: a  reason: collision with root package name */
        public final o6.a<Boolean> f12204a;

        /* renamed from: gv  reason: collision with root package name */
        public final o6.a<String> f12205gv;

        /* renamed from: n3  reason: collision with root package name */
        public final o6.a<List> f12206n3;

        /* renamed from: v  reason: collision with root package name */
        public final o6.a<Double> f12207v;
        public final co y;

        /* renamed from: zn  reason: collision with root package name */
        public final o6.a<Map> f12208zn;

        public tl(co coVar) {
            this.y = coVar;
            this.f12206n3 = coVar.zn(List.class);
            this.f12208zn = coVar.zn(Map.class);
            this.f12205gv = coVar.zn(String.class);
            this.f12207v = coVar.zn(Double.class);
            this.f12204a = coVar.zn(Boolean.class);
        }

        @Override // o6.a
        public void a(w wVar, Object obj) throws IOException {
            Class<?> cls = obj.getClass();
            if (cls == Object.class) {
                wVar.v();
                wVar.mt();
                return;
            }
            this.y.v(s(cls), p6.n3.y).a(wVar, obj);
        }

        @Override // o6.a
        public Object n3(o6.f fVar) throws IOException {
            switch (n3.y[fVar.yt().ordinal()]) {
                case 1:
                    return this.f12206n3.n3(fVar);
                case 2:
                    return this.f12208zn.n3(fVar);
                case 3:
                    return this.f12205gv.n3(fVar);
                case 4:
                    return this.f12207v.n3(fVar);
                case 5:
                    return this.f12204a.n3(fVar);
                case 6:
                    return fVar.ud();
                default:
                    throw new IllegalStateException("Expected a value but was " + fVar.yt() + " at path " + fVar.getPath());
            }
        }

        public final Class<?> s(Class<?> cls) {
            if (Map.class.isAssignableFrom(cls)) {
                return Map.class;
            }
            if (Collection.class.isAssignableFrom(cls)) {
                return Collection.class;
            }
            return cls;
        }

        public String toString() {
            return "JsonAdapter(Object)";
        }
    }

    /* loaded from: classes.dex */
    public class v extends o6.a<Byte> {
        @Override // o6.a
        /* renamed from: c5 */
        public void a(w wVar, Byte b2) throws IOException {
            wVar.yt(b2.intValue() & 255);
        }

        @Override // o6.a
        /* renamed from: s */
        public Byte n3(o6.f fVar) throws IOException {
            return Byte.valueOf((byte) r.y(fVar, "a byte", -128, 255));
        }

        public String toString() {
            return "JsonAdapter(Byte)";
        }
    }

    /* loaded from: classes.dex */
    public class y extends o6.a<String> {
        @Override // o6.a
        /* renamed from: c5 */
        public void a(w wVar, String str) throws IOException {
            wVar.j(str);
        }

        @Override // o6.a
        /* renamed from: s */
        public String n3(o6.f fVar) throws IOException {
            return fVar.b();
        }

        public String toString() {
            return "JsonAdapter(String)";
        }
    }

    /* loaded from: classes.dex */
    public class zn implements a.y {
        @Override // o6.a.y
        public o6.a<?> y(Type type, Set<? extends Annotation> set, co coVar) {
            if (!set.isEmpty()) {
                return null;
            }
            if (type == Boolean.TYPE) {
                return r.f12197n3;
            }
            if (type == Byte.TYPE) {
                return r.f12200zn;
            }
            if (type == Character.TYPE) {
                return r.f12195gv;
            }
            if (type == Double.TYPE) {
                return r.f12199v;
            }
            if (type == Float.TYPE) {
                return r.f12192a;
            }
            if (type == Integer.TYPE) {
                return r.f12194fb;
            }
            if (type == Long.TYPE) {
                return r.f12198s;
            }
            if (type == Short.TYPE) {
                return r.f12193c5;
            }
            if (type == Boolean.class) {
                return r.f12197n3.gv();
            }
            if (type == Byte.class) {
                return r.f12200zn.gv();
            }
            if (type == Character.class) {
                return r.f12195gv.gv();
            }
            if (type == Double.class) {
                return r.f12199v.gv();
            }
            if (type == Float.class) {
                return r.f12192a.gv();
            }
            if (type == Integer.class) {
                return r.f12194fb.gv();
            }
            if (type == Long.class) {
                return r.f12198s.gv();
            }
            if (type == Short.class) {
                return r.f12193c5.gv();
            }
            if (type == String.class) {
                return r.f12196i9.gv();
            }
            if (type == Object.class) {
                return new tl(coVar).gv();
            }
            Class<?> fb2 = x4.fb(type);
            o6.a<?> gv2 = p6.n3.gv(coVar, type, fb2);
            if (gv2 != null) {
                return gv2;
            }
            if (!fb2.isEnum()) {
                return null;
            }
            return new t(fb2).gv();
        }
    }

    public static int y(o6.f fVar, String str, int i, int i5) throws IOException {
        int ta2 = fVar.ta();
        if (ta2 >= i && ta2 <= i5) {
            return ta2;
        }
        throw new o6.s(String.format("Expected %s but was %s at path %s", str, Integer.valueOf(ta2), fVar.getPath()));
    }
}
