package di;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class xc {
    public final Map<String, Object> y = new HashMap();

    /* renamed from: n3  reason: collision with root package name */
    public final List<String> f7302n3 = new ArrayList();

    public static xc fb(xc xcVar, long j2) {
        return xcVar.v("exo_len", j2);
    }

    public static xc s(xc xcVar, @Nullable Uri uri) {
        if (uri == null) {
            return xcVar.gv("exo_redir");
        }
        return xcVar.a("exo_redir", uri.toString());
    }

    public xc a(String str, String str2) {
        return y(str, str2);
    }

    public xc gv(String str) {
        this.f7302n3.add(str);
        this.y.remove(str);
        return this;
    }

    public Map<String, Object> n3() {
        HashMap hashMap = new HashMap(this.y);
        for (Map.Entry entry : hashMap.entrySet()) {
            Object value = entry.getValue();
            if (value instanceof byte[]) {
                byte[] bArr = (byte[]) value;
                entry.setValue(Arrays.copyOf(bArr, bArr.length));
            }
        }
        return Collections.unmodifiableMap(hashMap);
    }

    public xc v(String str, long j2) {
        return y(str, Long.valueOf(j2));
    }

    public final xc y(String str, Object obj) {
        this.y.put((String) v5.y.v(str), v5.y.v(obj));
        this.f7302n3.remove(str);
        return this;
    }

    public List<String> zn() {
        return Collections.unmodifiableList(new ArrayList(this.f7302n3));
    }
}
