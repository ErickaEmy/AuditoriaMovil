package ch.qos.logback.classic.pattern;

import java.io.PrintStream;
/* loaded from: classes.dex */
public class TargetLengthBasedClassNameAbbreviator implements Abbreviator {
    final int targetLength;

    public TargetLengthBasedClassNameAbbreviator(int i) {
        this.targetLength = i;
    }

    static int computeDotIndexes(String str, int[] iArr) {
        int i = 0;
        int i2 = 0;
        while (true) {
            int indexOf = str.indexOf(46, i);
            if (indexOf == -1 || i2 >= 16) {
                break;
            }
            iArr[i2] = indexOf;
            i2++;
            i = indexOf + 1;
        }
        return i2;
    }

    static void printArray(String str, int[] iArr) {
        System.out.print(str);
        for (int i = 0; i < iArr.length; i++) {
            PrintStream printStream = System.out;
            if (i == 0) {
                printStream.print(iArr[i]);
            } else {
                printStream.print(", " + iArr[i]);
            }
        }
        System.out.println();
    }

    @Override // ch.qos.logback.classic.pattern.Abbreviator
    public String abbreviate(String str) {
        String substring;
        StringBuilder sb = new StringBuilder(this.targetLength);
        if (str != null) {
            if (str.length() < this.targetLength) {
                return str;
            }
            int[] iArr = new int[16];
            int[] iArr2 = new int[17];
            int computeDotIndexes = computeDotIndexes(str, iArr);
            if (computeDotIndexes == 0) {
                return str;
            }
            computeLengthArray(str, iArr, iArr2, computeDotIndexes);
            for (int i = 0; i <= computeDotIndexes; i++) {
                if (i == 0) {
                    substring = str.substring(0, iArr2[i] - 1);
                } else {
                    int i2 = iArr[i - 1];
                    substring = str.substring(i2, iArr2[i] + i2);
                }
                sb.append(substring);
            }
            return sb.toString();
        }
        throw new IllegalArgumentException("Class name may not be null");
    }

    void computeLengthArray(String str, int[] iArr, int[] iArr2, int i) {
        int length = str.length() - this.targetLength;
        int i2 = 0;
        while (i2 < i) {
            int i3 = (iArr[i2] - (i2 > 0 ? iArr[i2 - 1] : -1)) - 1;
            int i4 = (length <= 0 || i3 < 1) ? i3 : 1;
            length -= i3 - i4;
            iArr2[i2] = i4 + 1;
            i2++;
        }
        iArr2[i] = str.length() - iArr[i - 1];
    }
}
