package qx;

import androidx.annotation.Nullable;
import e4.f;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import v5.rz;
/* loaded from: classes.dex */
public final class gv extends v {

    /* renamed from: gv  reason: collision with root package name */
    public long[] f12997gv;

    /* renamed from: n3  reason: collision with root package name */
    public long f12998n3;

    /* renamed from: zn  reason: collision with root package name */
    public long[] f12999zn;

    public gv() {
        super(new f());
        this.f12998n3 = -9223372036854775807L;
        this.f12999zn = new long[0];
        this.f12997gv = new long[0];
    }

    public static Date c5(rz rzVar) {
        Date date = new Date((long) i9(rzVar).doubleValue());
        rzVar.ut(2);
        return date;
    }

    public static HashMap<String, Object> f(rz rzVar) {
        int b2 = rzVar.b();
        HashMap<String, Object> hashMap = new HashMap<>(b2);
        for (int i = 0; i < b2; i++) {
            String wz2 = wz(rzVar);
            Object s2 = s(rzVar, xc(rzVar));
            if (s2 != null) {
                hashMap.put(wz2, s2);
            }
        }
        return hashMap;
    }

    public static Boolean fb(rz rzVar) {
        boolean z2 = true;
        if (rzVar.ej() != 1) {
            z2 = false;
        }
        return Boolean.valueOf(z2);
    }

    public static Double i9(rz rzVar) {
        return Double.valueOf(Double.longBitsToDouble(rzVar.d0()));
    }

    @Nullable
    public static Object s(rz rzVar, int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 8) {
                            if (i != 10) {
                                if (i != 11) {
                                    return null;
                                }
                                return c5(rzVar);
                            }
                            return tl(rzVar);
                        }
                        return f(rzVar);
                    }
                    return t(rzVar);
                }
                return wz(rzVar);
            }
            return fb(rzVar);
        }
        return i9(rzVar);
    }

    public static HashMap<String, Object> t(rz rzVar) {
        HashMap<String, Object> hashMap = new HashMap<>();
        while (true) {
            String wz2 = wz(rzVar);
            int xc2 = xc(rzVar);
            if (xc2 == 9) {
                return hashMap;
            }
            Object s2 = s(rzVar, xc2);
            if (s2 != null) {
                hashMap.put(wz2, s2);
            }
        }
    }

    public static ArrayList<Object> tl(rz rzVar) {
        int b2 = rzVar.b();
        ArrayList<Object> arrayList = new ArrayList<>(b2);
        for (int i = 0; i < b2; i++) {
            Object s2 = s(rzVar, xc(rzVar));
            if (s2 != null) {
                arrayList.add(s2);
            }
        }
        return arrayList;
    }

    public static String wz(rz rzVar) {
        int yt2 = rzVar.yt();
        int a2 = rzVar.a();
        rzVar.ut(yt2);
        return new String(rzVar.v(), a2, yt2);
    }

    public static int xc(rz rzVar) {
        return rzVar.ej();
    }

    public long[] a() {
        return this.f12999zn;
    }

    public long gv() {
        return this.f12998n3;
    }

    @Override // qx.v
    public boolean n3(rz rzVar) {
        return true;
    }

    public long[] v() {
        return this.f12997gv;
    }

    @Override // qx.v
    public boolean zn(rz rzVar, long j2) {
        if (xc(rzVar) != 2 || !"onMetaData".equals(wz(rzVar)) || rzVar.y() == 0 || xc(rzVar) != 8) {
            return false;
        }
        HashMap<String, Object> f4 = f(rzVar);
        Object obj = f4.get("duration");
        if (obj instanceof Double) {
            double doubleValue = ((Double) obj).doubleValue();
            if (doubleValue > 0.0d) {
                this.f12998n3 = (long) (doubleValue * 1000000.0d);
            }
        }
        Object obj2 = f4.get("keyframes");
        if (obj2 instanceof Map) {
            Map map = (Map) obj2;
            Object obj3 = map.get("filepositions");
            Object obj4 = map.get("times");
            if ((obj3 instanceof List) && (obj4 instanceof List)) {
                List list = (List) obj3;
                List list2 = (List) obj4;
                int size = list2.size();
                this.f12999zn = new long[size];
                this.f12997gv = new long[size];
                for (int i = 0; i < size; i++) {
                    Object obj5 = list.get(i);
                    Object obj6 = list2.get(i);
                    if ((obj6 instanceof Double) && (obj5 instanceof Double)) {
                        this.f12999zn[i] = (long) (((Double) obj6).doubleValue() * 1000000.0d);
                        this.f12997gv[i] = ((Double) obj5).longValue();
                    } else {
                        this.f12999zn = new long[0];
                        this.f12997gv = new long[0];
                        break;
                    }
                }
            }
        }
        return false;
    }
}
