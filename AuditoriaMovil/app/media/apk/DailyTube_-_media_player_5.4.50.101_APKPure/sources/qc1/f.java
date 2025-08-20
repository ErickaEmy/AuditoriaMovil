package qc1;

import java.io.IOException;
import java.net.ProtocolException;
import kc1.c;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* loaded from: classes.dex */
public final class f {

    /* renamed from: gv  reason: collision with root package name */
    public static final y f12789gv = new y(null);

    /* renamed from: n3  reason: collision with root package name */
    public final int f12790n3;
    public final c y;

    /* renamed from: zn  reason: collision with root package name */
    public final String f12791zn;

    /* loaded from: classes.dex */
    public static final class y {
        public y() {
        }

        public final f y(String statusLine) throws IOException {
            c cVar;
            int i;
            String str;
            Intrinsics.checkNotNullParameter(statusLine, "statusLine");
            if (StringsKt.startsWith$default(statusLine, "HTTP/1.", false, 2, (Object) null)) {
                i = 9;
                if (statusLine.length() >= 9 && statusLine.charAt(8) == ' ') {
                    int charAt = statusLine.charAt(7) - '0';
                    if (charAt == 0) {
                        cVar = c.HTTP_1_0;
                    } else if (charAt == 1) {
                        cVar = c.HTTP_1_1;
                    } else {
                        throw new ProtocolException("Unexpected status line: " + statusLine);
                    }
                } else {
                    throw new ProtocolException("Unexpected status line: " + statusLine);
                }
            } else if (StringsKt.startsWith$default(statusLine, "ICY ", false, 2, (Object) null)) {
                cVar = c.HTTP_1_0;
                i = 4;
            } else {
                throw new ProtocolException("Unexpected status line: " + statusLine);
            }
            int i5 = i + 3;
            if (statusLine.length() >= i5) {
                try {
                    String substring = statusLine.substring(i, i5);
                    Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    int parseInt = Integer.parseInt(substring);
                    if (statusLine.length() > i5) {
                        if (statusLine.charAt(i5) == ' ') {
                            str = statusLine.substring(i + 4);
                            Intrinsics.checkNotNullExpressionValue(str, "(this as java.lang.String).substring(startIndex)");
                        } else {
                            throw new ProtocolException("Unexpected status line: " + statusLine);
                        }
                    } else {
                        str = "";
                    }
                    return new f(cVar, parseInt, str);
                } catch (NumberFormatException unused) {
                    throw new ProtocolException("Unexpected status line: " + statusLine);
                }
            }
            throw new ProtocolException("Unexpected status line: " + statusLine);
        }

        public /* synthetic */ y(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public f(c protocol, int i, String message) {
        Intrinsics.checkNotNullParameter(protocol, "protocol");
        Intrinsics.checkNotNullParameter(message, "message");
        this.y = protocol;
        this.f12790n3 = i;
        this.f12791zn = message;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.y == c.HTTP_1_0) {
            sb.append("HTTP/1.0");
        } else {
            sb.append("HTTP/1.1");
        }
        sb.append(' ');
        sb.append(this.f12790n3);
        sb.append(' ');
        sb.append(this.f12791zn);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}
