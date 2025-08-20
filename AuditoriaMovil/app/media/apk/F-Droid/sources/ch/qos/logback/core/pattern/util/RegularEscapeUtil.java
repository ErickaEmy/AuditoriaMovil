package ch.qos.logback.core.pattern.util;
/* loaded from: classes.dex */
public class RegularEscapeUtil implements IEscapeUtil {
    public static String basicEscape(String str) {
        int length = str.length();
        StringBuilder sb = new StringBuilder(length);
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            char charAt = str.charAt(i);
            if (charAt == '\\') {
                i += 2;
                charAt = str.charAt(i2);
                if (charAt == 'n') {
                    charAt = '\n';
                } else if (charAt == 'r') {
                    charAt = '\r';
                } else if (charAt == 't') {
                    charAt = '\t';
                } else if (charAt == 'f') {
                    charAt = '\f';
                }
            } else {
                i = i2;
            }
            sb.append(charAt);
        }
        return sb.toString();
    }

    @Override // ch.qos.logback.core.pattern.util.IEscapeUtil
    public void escape(String str, StringBuffer stringBuffer, char c, int i) {
        char c2;
        if (str.indexOf(c) >= 0 || c == '\\') {
            stringBuffer.append(c);
        } else if (c != '_') {
            if (c == 'n') {
                c2 = '\n';
            } else if (c == 'r') {
                c2 = '\r';
            } else if (c != 't') {
                String formatEscapeCharsForListing = formatEscapeCharsForListing(str);
                throw new IllegalArgumentException("Illegal char '" + c + " at column " + i + ". Only \\\\, \\_" + formatEscapeCharsForListing + ", \\t, \\n, \\r combinations are allowed as escape characters.");
            } else {
                c2 = '\t';
            }
            stringBuffer.append(c2);
        }
    }

    String formatEscapeCharsForListing(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb.append(", \\");
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }
}
