package com.google.android.gms.common.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
@KeepForSdk
/* loaded from: classes.dex */
public final class HexDumpUtils {
    @Nullable
    @ResultIgnorabilityUnspecified
    @KeepForSdk
    public static String dump(@NonNull byte[] bArr, int i, int i5, boolean z2) {
        int length;
        int i6;
        if (bArr != null && (length = bArr.length) != 0 && i >= 0 && i5 > 0 && i + i5 <= length) {
            if (z2) {
                i6 = 75;
            } else {
                i6 = 57;
            }
            StringBuilder sb = new StringBuilder(i6 * ((i5 + 15) / 16));
            int i8 = i5;
            int i10 = 0;
            int i11 = 0;
            while (i8 > 0) {
                if (i10 == 0) {
                    if (i5 < 65536) {
                        sb.append(String.format("%04X:", Integer.valueOf(i)));
                    } else {
                        sb.append(String.format("%08X:", Integer.valueOf(i)));
                    }
                    i11 = i;
                } else if (i10 == 8) {
                    sb.append(" -");
                }
                sb.append(String.format(" %02X", Integer.valueOf(bArr[i] & 255)));
                i8--;
                i10++;
                if (z2 && (i10 == 16 || i8 == 0)) {
                    int i12 = 16 - i10;
                    if (i12 > 0) {
                        for (int i13 = 0; i13 < i12; i13++) {
                            sb.append("   ");
                        }
                    }
                    if (i12 >= 8) {
                        sb.append("  ");
                    }
                    sb.append("  ");
                    for (int i14 = 0; i14 < i10; i14++) {
                        char c2 = (char) bArr[i11 + i14];
                        if (c2 < ' ' || c2 > '~') {
                            c2 = '.';
                        }
                        sb.append(c2);
                    }
                }
                if (i10 == 16 || i8 == 0) {
                    sb.append('\n');
                    i10 = 0;
                }
                i++;
            }
            return sb.toString();
        }
        return null;
    }
}
