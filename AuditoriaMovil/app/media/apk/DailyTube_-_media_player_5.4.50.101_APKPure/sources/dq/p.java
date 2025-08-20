package dq;

import java.util.Locale;
/* loaded from: classes.dex */
public final class p {

    /* renamed from: gv  reason: collision with root package name */
    public final int f7372gv;

    /* renamed from: n3  reason: collision with root package name */
    public final int[] f7373n3;
    public final String[] y;

    /* renamed from: zn  reason: collision with root package name */
    public final String[] f7374zn;

    public p(String[] strArr, int[] iArr, String[] strArr2, int i) {
        this.y = strArr;
        this.f7373n3 = iArr;
        this.f7374zn = strArr2;
        this.f7372gv = i;
    }

    public static p n3(String str) {
        String[] strArr = new String[5];
        int[] iArr = new int[4];
        String[] strArr2 = new String[4];
        return new p(strArr, iArr, strArr2, zn(str, strArr, iArr, strArr2));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int zn(String str, String[] strArr, int[] iArr, String[] strArr2) {
        String str2;
        char c2;
        strArr[0] = "";
        int i = 0;
        int i5 = 0;
        while (i < str.length()) {
            int indexOf = str.indexOf("$", i);
            if (indexOf == -1) {
                strArr[i5] = strArr[i5] + str.substring(i);
                i = str.length();
            } else if (indexOf != i) {
                strArr[i5] = strArr[i5] + str.substring(i, indexOf);
                i = indexOf;
            } else if (str.startsWith("$$", i)) {
                strArr[i5] = strArr[i5] + "$";
                i += 2;
            } else {
                int i6 = i + 1;
                int indexOf2 = str.indexOf("$", i6);
                String substring = str.substring(i6, indexOf2);
                if (substring.equals("RepresentationID")) {
                    iArr[i5] = 1;
                } else {
                    int indexOf3 = substring.indexOf("%0");
                    if (indexOf3 != -1) {
                        str2 = substring.substring(indexOf3);
                        if (!str2.endsWith("d") && !str2.endsWith("x") && !str2.endsWith("X")) {
                            str2 = str2 + "d";
                        }
                        substring = substring.substring(0, indexOf3);
                    } else {
                        str2 = "%01d";
                    }
                    substring.hashCode();
                    switch (substring.hashCode()) {
                        case -1950496919:
                            if (substring.equals("Number")) {
                                c2 = 0;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 2606829:
                            if (substring.equals("Time")) {
                                c2 = 1;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 38199441:
                            if (substring.equals("Bandwidth")) {
                                c2 = 2;
                                break;
                            }
                            c2 = 65535;
                            break;
                        default:
                            c2 = 65535;
                            break;
                    }
                    switch (c2) {
                        case 0:
                            iArr[i5] = 2;
                            break;
                        case 1:
                            iArr[i5] = 4;
                            break;
                        case 2:
                            iArr[i5] = 3;
                            break;
                        default:
                            throw new IllegalArgumentException("Invalid template: " + str);
                    }
                    strArr2[i5] = str2;
                }
                i5++;
                strArr[i5] = "";
                i = indexOf2 + 1;
            }
        }
        return i5;
    }

    public String y(String str, long j2, int i, long j4) {
        StringBuilder sb = new StringBuilder();
        int i5 = 0;
        while (true) {
            int i6 = this.f7372gv;
            if (i5 < i6) {
                sb.append(this.y[i5]);
                int i8 = this.f7373n3[i5];
                if (i8 == 1) {
                    sb.append(str);
                } else if (i8 == 2) {
                    sb.append(String.format(Locale.US, this.f7374zn[i5], Long.valueOf(j2)));
                } else if (i8 == 3) {
                    sb.append(String.format(Locale.US, this.f7374zn[i5], Integer.valueOf(i)));
                } else if (i8 == 4) {
                    sb.append(String.format(Locale.US, this.f7374zn[i5], Long.valueOf(j4)));
                }
                i5++;
            } else {
                sb.append(this.y[i6]);
                return sb.toString();
            }
        }
    }
}
