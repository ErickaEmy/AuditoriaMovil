package w0;
/* loaded from: classes.dex */
public final class zn {
    public static String a(String str) {
        int length = str.length();
        int i = 0;
        while (i < length) {
            if (zn(str.charAt(i))) {
                char[] charArray = str.toCharArray();
                while (i < length) {
                    char c2 = charArray[i];
                    if (zn(c2)) {
                        charArray[i] = (char) (c2 ^ ' ');
                    }
                    i++;
                }
                return String.valueOf(charArray);
            }
            i++;
        }
        return str;
    }

    public static boolean gv(char c2) {
        if (c2 >= 'A' && c2 <= 'Z') {
            return true;
        }
        return false;
    }

    public static int n3(char c2) {
        return (char) ((c2 | ' ') - 97);
    }

    public static String v(String str) {
        int length = str.length();
        int i = 0;
        while (i < length) {
            if (gv(str.charAt(i))) {
                char[] charArray = str.toCharArray();
                while (i < length) {
                    char c2 = charArray[i];
                    if (gv(c2)) {
                        charArray[i] = (char) (c2 ^ ' ');
                    }
                    i++;
                }
                return String.valueOf(charArray);
            }
            i++;
        }
        return str;
    }

    public static boolean y(CharSequence charSequence, CharSequence charSequence2) {
        int n32;
        int length = charSequence.length();
        if (charSequence == charSequence2) {
            return true;
        }
        if (length != charSequence2.length()) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            char charAt = charSequence.charAt(i);
            char charAt2 = charSequence2.charAt(i);
            if (charAt != charAt2 && ((n32 = n3(charAt)) >= 26 || n32 != n3(charAt2))) {
                return false;
            }
        }
        return true;
    }

    public static boolean zn(char c2) {
        if (c2 >= 'a' && c2 <= 'z') {
            return true;
        }
        return false;
    }
}
