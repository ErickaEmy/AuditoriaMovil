package di;

import androidx.annotation.Nullable;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public final class w implements wz {

    /* renamed from: zn  reason: collision with root package name */
    public static final w f7300zn = new w(Collections.emptyMap());

    /* renamed from: n3  reason: collision with root package name */
    public final Map<String, byte[]> f7301n3;
    public int y;

    public w() {
        this(Collections.emptyMap());
    }

    public static void c5(HashMap<String, byte[]> hashMap, List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            hashMap.remove(list.get(i));
        }
    }

    public static byte[] fb(Object obj) {
        if (obj instanceof Long) {
            return ByteBuffer.allocate(8).putLong(((Long) obj).longValue()).array();
        }
        if (obj instanceof String) {
            return ((String) obj).getBytes(w0.v.f14523zn);
        }
        if (obj instanceof byte[]) {
            return (byte[]) obj;
        }
        throw new IllegalArgumentException();
    }

    public static Map<String, byte[]> gv(Map<String, byte[]> map, xc xcVar) {
        HashMap hashMap = new HashMap(map);
        c5(hashMap, xcVar.zn());
        zn(hashMap, xcVar.n3());
        return hashMap;
    }

    public static boolean s(Map<String, byte[]> map, Map<String, byte[]> map2) {
        if (map.size() != map2.size()) {
            return false;
        }
        for (Map.Entry<String, byte[]> entry : map.entrySet()) {
            if (!Arrays.equals(entry.getValue(), map2.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }

    public static void zn(HashMap<String, byte[]> hashMap, Map<String, Object> map) {
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            hashMap.put(entry.getKey(), fb(entry.getValue()));
        }
    }

    public Set<Map.Entry<String, byte[]>> a() {
        return this.f7301n3.entrySet();
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && w.class == obj.getClass()) {
            return s(this.f7301n3, ((w) obj).f7301n3);
        }
        return false;
    }

    public int hashCode() {
        if (this.y == 0) {
            int i = 0;
            for (Map.Entry<String, byte[]> entry : this.f7301n3.entrySet()) {
                i += Arrays.hashCode(entry.getValue()) ^ entry.getKey().hashCode();
            }
            this.y = i;
        }
        return this.y;
    }

    @Override // di.wz
    @Nullable
    public final String n3(String str, @Nullable String str2) {
        byte[] bArr = this.f7301n3.get(str);
        if (bArr != null) {
            return new String(bArr, w0.v.f14523zn);
        }
        return str2;
    }

    public w v(xc xcVar) {
        Map<String, byte[]> gv2 = gv(this.f7301n3, xcVar);
        if (s(this.f7301n3, gv2)) {
            return this;
        }
        return new w(gv2);
    }

    @Override // di.wz
    public final long y(String str, long j2) {
        byte[] bArr = this.f7301n3.get(str);
        if (bArr != null) {
            return ByteBuffer.wrap(bArr).getLong();
        }
        return j2;
    }

    public w(Map<String, byte[]> map) {
        this.f7301n3 = Collections.unmodifiableMap(map);
    }
}
