package v5;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public final class vl {
    public static String gv(@Nullable String str, @Nullable String str2) {
        int i;
        StringBuilder sb = new StringBuilder();
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        int[] y = y(str2);
        if (y[0] != -1) {
            sb.append(str2);
            zn(sb, y[1], y[2]);
            return sb.toString();
        }
        int[] y2 = y(str);
        if (y[3] == 0) {
            sb.append((CharSequence) str, 0, y2[3]);
            sb.append(str2);
            return sb.toString();
        } else if (y[2] == 0) {
            sb.append((CharSequence) str, 0, y2[2]);
            sb.append(str2);
            return sb.toString();
        } else {
            int i5 = y[1];
            if (i5 != 0) {
                int i6 = y2[0] + 1;
                sb.append((CharSequence) str, 0, i6);
                sb.append(str2);
                return zn(sb, y[1] + i6, i6 + y[2]);
            } else if (str2.charAt(i5) == '/') {
                sb.append((CharSequence) str, 0, y2[1]);
                sb.append(str2);
                int i8 = y2[1];
                return zn(sb, i8, y[2] + i8);
            } else {
                int i10 = y2[0] + 2;
                int i11 = y2[1];
                if (i10 < i11 && i11 == y2[2]) {
                    sb.append((CharSequence) str, 0, i11);
                    sb.append('/');
                    sb.append(str2);
                    int i12 = y2[1];
                    return zn(sb, i12, y[2] + i12 + 1);
                }
                int lastIndexOf = str.lastIndexOf(47, y2[2] - 1);
                if (lastIndexOf == -1) {
                    i = y2[1];
                } else {
                    i = lastIndexOf + 1;
                }
                sb.append((CharSequence) str, 0, i);
                sb.append(str2);
                return zn(sb, y2[1], i + y[2]);
            }
        }
    }

    public static boolean n3(@Nullable String str) {
        if (str == null || y(str)[0] == -1) {
            return false;
        }
        return true;
    }

    public static Uri v(@Nullable String str, @Nullable String str2) {
        return Uri.parse(gv(str, str2));
    }

    public static int[] y(String str) {
        int i;
        int[] iArr = new int[4];
        if (TextUtils.isEmpty(str)) {
            iArr[0] = -1;
            return iArr;
        }
        int length = str.length();
        int indexOf = str.indexOf(35);
        if (indexOf != -1) {
            length = indexOf;
        }
        int indexOf2 = str.indexOf(63);
        if (indexOf2 == -1 || indexOf2 > length) {
            indexOf2 = length;
        }
        int indexOf3 = str.indexOf(47);
        if (indexOf3 == -1 || indexOf3 > indexOf2) {
            indexOf3 = indexOf2;
        }
        int indexOf4 = str.indexOf(58);
        if (indexOf4 > indexOf3) {
            indexOf4 = -1;
        }
        int i5 = indexOf4 + 2;
        if (i5 < indexOf2 && str.charAt(indexOf4 + 1) == '/' && str.charAt(i5) == '/') {
            i = str.indexOf(47, indexOf4 + 3);
            if (i == -1 || i > indexOf2) {
                i = indexOf2;
            }
        } else {
            i = indexOf4 + 1;
        }
        iArr[0] = indexOf4;
        iArr[1] = i;
        iArr[2] = indexOf2;
        iArr[3] = length;
        return iArr;
    }

    public static String zn(StringBuilder sb, int i, int i5) {
        int i6;
        int i8;
        int i10;
        if (i >= i5) {
            return sb.toString();
        }
        if (sb.charAt(i) == '/') {
            i++;
        }
        int i11 = i;
        int i12 = i11;
        while (i11 <= i5) {
            if (i11 == i5) {
                i6 = i11;
            } else if (sb.charAt(i11) == '/') {
                i6 = i11 + 1;
            } else {
                i11++;
            }
            int i13 = i12 + 1;
            if (i11 == i13 && sb.charAt(i12) == '.') {
                sb.delete(i12, i6);
                i5 -= i6 - i12;
            } else {
                if (i11 == i12 + 2 && sb.charAt(i12) == '.' && sb.charAt(i13) == '.') {
                    i8 = sb.lastIndexOf("/", i12 - 2) + 1;
                    if (i8 > i) {
                        i10 = i8;
                    } else {
                        i10 = i;
                    }
                    sb.delete(i10, i6);
                    i5 -= i6 - i10;
                } else {
                    i8 = i11 + 1;
                }
                i12 = i8;
            }
            i11 = i12;
        }
        return sb.toString();
    }
}
