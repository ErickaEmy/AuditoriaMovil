package com.google.gson.internal;
/* loaded from: classes.dex */
public final class JavaVersion {
    public static final int y = y();

    public static int getMajorJavaVersion() {
        return y;
    }

    public static int gv(String str) {
        try {
            String[] split = str.split("[._]");
            int parseInt = Integer.parseInt(split[0]);
            if (parseInt == 1 && split.length > 1) {
                return Integer.parseInt(split[1]);
            }
            return parseInt;
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public static boolean isJava9OrLater() {
        if (y >= 9) {
            return true;
        }
        return false;
    }

    public static int n3(String str) {
        try {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                char charAt = str.charAt(i);
                if (!Character.isDigit(charAt)) {
                    break;
                }
                sb.append(charAt);
            }
            return Integer.parseInt(sb.toString());
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public static int y() {
        return zn(System.getProperty("java.version"));
    }

    public static int zn(String str) {
        int gv2 = gv(str);
        if (gv2 == -1) {
            gv2 = n3(str);
        }
        if (gv2 == -1) {
            return 6;
        }
        return gv2;
    }
}
