package org.apache.commons.io;

import ch.qos.logback.classic.spi.CallerData;
import ch.qos.logback.core.CoreConstants;
import java.io.File;
import java.util.ArrayList;
import java.util.Stack;
/* loaded from: classes2.dex */
public abstract class FilenameUtils {
    private static final char OTHER_SEPARATOR;
    public static final String EXTENSION_SEPARATOR_STR = Character.toString(CoreConstants.DOT);
    private static final char SYSTEM_SEPARATOR = File.separatorChar;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isSystemWindows() {
        return SYSTEM_SEPARATOR == '\\';
    }

    static {
        if (isSystemWindows()) {
            OTHER_SEPARATOR = '/';
        } else {
            OTHER_SEPARATOR = CoreConstants.ESCAPE_CHAR;
        }
    }

    public static int indexOfLastSeparator(String str) {
        if (str == null) {
            return -1;
        }
        return Math.max(str.lastIndexOf(47), str.lastIndexOf(92));
    }

    public static int indexOfExtension(String str) {
        int lastIndexOf;
        if (str != null && indexOfLastSeparator(str) <= (lastIndexOf = str.lastIndexOf(46))) {
            return lastIndexOf;
        }
        return -1;
    }

    public static String getExtension(String str) {
        if (str == null) {
            return null;
        }
        int indexOfExtension = indexOfExtension(str);
        return indexOfExtension == -1 ? "" : str.substring(indexOfExtension + 1);
    }

    public static boolean wildcardMatch(String str, String str2, IOCase iOCase) {
        if (str == null && str2 == null) {
            return true;
        }
        if (str == null || str2 == null) {
            return false;
        }
        if (iOCase == null) {
            iOCase = IOCase.SENSITIVE;
        }
        String[] splitOnTokens = splitOnTokens(str2);
        Stack stack = new Stack();
        boolean z = false;
        int i = 0;
        int i2 = 0;
        do {
            if (stack.size() > 0) {
                int[] iArr = (int[]) stack.pop();
                i2 = iArr[0];
                i = iArr[1];
                z = true;
            }
            while (i2 < splitOnTokens.length) {
                if (splitOnTokens[i2].equals(CallerData.NA)) {
                    i++;
                    if (i > str.length()) {
                        break;
                    }
                    z = false;
                    i2++;
                } else if (splitOnTokens[i2].equals("*")) {
                    if (i2 == splitOnTokens.length - 1) {
                        i = str.length();
                    }
                    z = true;
                    i2++;
                } else {
                    if (z) {
                        i = iOCase.checkIndexOf(str, i, splitOnTokens[i2]);
                        if (i == -1) {
                            break;
                        }
                        int checkIndexOf = iOCase.checkIndexOf(str, i + 1, splitOnTokens[i2]);
                        if (checkIndexOf >= 0) {
                            stack.push(new int[]{i2, checkIndexOf});
                        }
                        i += splitOnTokens[i2].length();
                        z = false;
                    } else {
                        if (!iOCase.checkRegionMatches(str, i, splitOnTokens[i2])) {
                            break;
                        }
                        i += splitOnTokens[i2].length();
                        z = false;
                    }
                    i2++;
                }
            }
            if (i2 == splitOnTokens.length && i == str.length()) {
                return true;
            }
        } while (stack.size() > 0);
        return false;
    }

    static String[] splitOnTokens(String str) {
        if (str.indexOf(63) == -1 && str.indexOf(42) == -1) {
            return new String[]{str};
        }
        char[] charArray = str.toCharArray();
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        int length = charArray.length;
        int i = 0;
        char c = 0;
        while (i < length) {
            char c2 = charArray[i];
            if (c2 == '?' || c2 == '*') {
                if (sb.length() != 0) {
                    arrayList.add(sb.toString());
                    sb.setLength(0);
                }
                if (c2 == '?') {
                    arrayList.add(CallerData.NA);
                } else if (c != '*') {
                    arrayList.add("*");
                }
            } else {
                sb.append(c2);
            }
            i++;
            c = c2;
        }
        if (sb.length() != 0) {
            arrayList.add(sb.toString());
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }
}
