package com.facebook.ads.redexgen.X;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: assets/audience_network.dex */
public final class HW {
    public final Map<String, Object> A01 = new HashMap();
    public final List<String> A00 = new ArrayList();

    private HW A00(String str, Object obj) {
        this.A01.put((String) AbstractC0672Ha.A01(str), AbstractC0672Ha.A01(obj));
        this.A00.remove(str);
        return this;
    }

    public final HW A01(String str) {
        this.A00.add(str);
        this.A01.remove(str);
        return this;
    }

    public final HW A02(String str, long j2) {
        return A00(str, Long.valueOf(j2));
    }

    public final HW A03(String str, String str2) {
        return A00(str, str2);
    }

    public final List<String> A04() {
        return Collections.unmodifiableList(new ArrayList(this.A00));
    }

    public final Map<String, Object> A05() {
        HashMap hashMap = new HashMap(this.A01);
        for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
            Object value = entry.getValue();
            if (value instanceof byte[]) {
                byte[] bArr = (byte[]) value;
                entry.setValue(Arrays.copyOf(bArr, bArr.length));
            }
        }
        return Collections.unmodifiableMap(hashMap);
    }
}
