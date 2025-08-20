package io.ktor.http;

import ch.qos.logback.core.CoreConstants;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: HttpHeaderValueParser.kt */
/* loaded from: classes.dex */
public final class HeaderValue {
    private final List params;
    private final double quality;
    private final String value;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof HeaderValue) {
            HeaderValue headerValue = (HeaderValue) obj;
            return Intrinsics.areEqual(this.value, headerValue.value) && Intrinsics.areEqual(this.params, headerValue.params);
        }
        return false;
    }

    public final List getParams() {
        return this.params;
    }

    public final String getValue() {
        return this.value;
    }

    public int hashCode() {
        return (this.value.hashCode() * 31) + this.params.hashCode();
    }

    public String toString() {
        return "HeaderValue(value=" + this.value + ", params=" + this.params + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x003d, code lost:
        r8 = kotlin.text.StringsKt__StringNumberConversionsJVMKt.toDoubleOrNull(r8);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public HeaderValue(java.lang.String r8, java.util.List r9) {
        /*
            r7 = this;
            java.lang.String r0 = "value"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "params"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            r7.<init>()
            r7.value = r8
            r7.params = r9
            java.util.Iterator r8 = r9.iterator()
        L15:
            boolean r9 = r8.hasNext()
            r0 = 0
            if (r9 == 0) goto L30
            java.lang.Object r9 = r8.next()
            r1 = r9
            io.ktor.http.HeaderValueParam r1 = (io.ktor.http.HeaderValueParam) r1
            java.lang.String r1 = r1.getName()
            java.lang.String r2 = "q"
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r2)
            if (r1 == 0) goto L15
            goto L31
        L30:
            r9 = r0
        L31:
            io.ktor.http.HeaderValueParam r9 = (io.ktor.http.HeaderValueParam) r9
            r1 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            if (r9 == 0) goto L58
            java.lang.String r8 = r9.getValue()
            if (r8 == 0) goto L58
            java.lang.Double r8 = kotlin.text.StringsKt.toDoubleOrNull(r8)
            if (r8 == 0) goto L58
            double r3 = r8.doubleValue()
            r5 = 0
            int r9 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r9 > 0) goto L52
            int r9 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r9 > 0) goto L52
            r0 = r8
        L52:
            if (r0 == 0) goto L58
            double r1 = r0.doubleValue()
        L58:
            r7.quality = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.HeaderValue.<init>(java.lang.String, java.util.List):void");
    }
}
