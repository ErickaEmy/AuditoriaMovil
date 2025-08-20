package kc1;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class s {

    /* renamed from: n3  reason: collision with root package name */
    public final String f9912n3;
    public final Map<String, String> y;

    public s(String scheme, Map<String, String> authParams) {
        String str;
        Intrinsics.checkNotNullParameter(scheme, "scheme");
        Intrinsics.checkNotNullParameter(authParams, "authParams");
        this.f9912n3 = scheme;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, String> entry : authParams.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (key != null) {
                Locale US = Locale.US;
                Intrinsics.checkNotNullExpressionValue(US, "US");
                str = key.toLowerCase(US);
                Intrinsics.checkNotNullExpressionValue(str, "(this as java.lang.String).toLowerCase(locale)");
            } else {
                str = null;
            }
            linkedHashMap.put(str, value);
        }
        Map<String, String> unmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        Intrinsics.checkNotNullExpressionValue(unmodifiableMap, "unmodifiableMap<String?, String>(newAuthParams)");
        this.y = unmodifiableMap;
    }

    public boolean equals(Object obj) {
        if (obj instanceof s) {
            s sVar = (s) obj;
            if (Intrinsics.areEqual(sVar.f9912n3, this.f9912n3) && Intrinsics.areEqual(sVar.y, this.y)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((899 + this.f9912n3.hashCode()) * 31) + this.y.hashCode();
    }

    public final String n3() {
        return this.y.get("realm");
    }

    public String toString() {
        return this.f9912n3 + " authParams=" + this.y;
    }

    public final Charset y() {
        String str = this.y.get("charset");
        if (str != null) {
            try {
                Charset forName = Charset.forName(str);
                Intrinsics.checkNotNullExpressionValue(forName, "Charset.forName(charset)");
                return forName;
            } catch (Exception unused) {
            }
        }
        Charset ISO_8859_1 = StandardCharsets.ISO_8859_1;
        Intrinsics.checkNotNullExpressionValue(ISO_8859_1, "ISO_8859_1");
        return ISO_8859_1;
    }

    public final String zn() {
        return this.f9912n3;
    }
}
