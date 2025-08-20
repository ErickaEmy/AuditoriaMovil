package com.google.android.gms.internal.common;

import org.jspecify.nullness.NullMarked;
@NullMarked
/* loaded from: classes.dex */
public final class zzs {
    public static int zza(int i, int i5, String str) {
        String zza;
        if (i >= 0 && i < i5) {
            return i;
        }
        if (i >= 0) {
            if (i5 < 0) {
                throw new IllegalArgumentException("negative size: " + i5);
            }
            zza = zzy.zza("%s (%s) must be less than size (%s)", "index", Integer.valueOf(i), Integer.valueOf(i5));
        } else {
            zza = zzy.zza("%s (%s) must not be negative", "index", Integer.valueOf(i));
        }
        throw new IndexOutOfBoundsException(zza);
    }

    public static int zzb(int i, int i5, String str) {
        if (i >= 0 && i <= i5) {
            return i;
        }
        throw new IndexOutOfBoundsException(zzd(i, i5, "index"));
    }

    public static void zzc(int i, int i5, int i6) {
        String zzd;
        if (i >= 0 && i5 >= i && i5 <= i6) {
            return;
        }
        if (i >= 0 && i <= i6) {
            if (i5 >= 0 && i5 <= i6) {
                zzd = zzy.zza("end index (%s) must not be less than start index (%s)", Integer.valueOf(i5), Integer.valueOf(i));
            } else {
                zzd = zzd(i5, i6, "end index");
            }
        } else {
            zzd = zzd(i, i6, "start index");
        }
        throw new IndexOutOfBoundsException(zzd);
    }

    private static String zzd(int i, int i5, String str) {
        if (i < 0) {
            return zzy.zza("%s (%s) must not be negative", str, Integer.valueOf(i));
        }
        if (i5 >= 0) {
            return zzy.zza("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i5));
        }
        throw new IllegalArgumentException("negative size: " + i5);
    }
}
