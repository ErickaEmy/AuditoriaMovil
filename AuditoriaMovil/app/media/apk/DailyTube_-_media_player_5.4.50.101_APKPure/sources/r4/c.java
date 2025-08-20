package r4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import m1.ne;
import r4.n;
import r4.y;
/* loaded from: classes.dex */
public final class c {
    public static final Pattern y = Pattern.compile("([a-z])=\\s?(.+)");

    /* renamed from: n3  reason: collision with root package name */
    public static final Pattern f13045n3 = Pattern.compile("([\\x21\\x23-\\x27\\x2a\\x2b\\x2d\\x2e\\x30-\\x39\\x41-\\x5a\\x5e-\\x7e]+)(?::(.*))?");

    /* renamed from: zn  reason: collision with root package name */
    public static final Pattern f13046zn = Pattern.compile("(\\S+)\\s(\\S+)\\s(\\S+)\\s(\\S+)");

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x01a0, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static r4.n n3(java.lang.String r12) throws m1.ne {
        /*
            Method dump skipped, instructions count: 560
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: r4.c.n3(java.lang.String):r4.n");
    }

    public static void y(n.n3 n3Var, y.n3 n3Var2) throws ne {
        try {
            n3Var.wz(n3Var2.i9());
        } catch (IllegalArgumentException | IllegalStateException e2) {
            throw ne.v(null, e2);
        }
    }

    public static y.n3 zn(String str) throws ne {
        Matcher matcher = f13046zn.matcher(str);
        if (matcher.matches()) {
            String str2 = (String) v5.y.v(matcher.group(1));
            String str3 = (String) v5.y.v(matcher.group(2));
            try {
                return new y.n3(str2, Integer.parseInt(str3), (String) v5.y.v(matcher.group(3)), Integer.parseInt((String) v5.y.v(matcher.group(4))));
            } catch (NumberFormatException e2) {
                throw ne.v("Malformed SDP media description line: " + str, e2);
            }
        }
        throw ne.v("Malformed SDP media description line: " + str, null);
    }
}
