package com.google.android.gms.common;

import android.util.Log;
import androidx.annotation.NonNull;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class zzx {
    private static final zzx zze = new zzx(true, 3, 1, null, null);
    final boolean zza;
    final String zzb;
    final Throwable zzc;
    final int zzd;

    private zzx(boolean z2, int i, int i5, String str, Throwable th) {
        this.zza = z2;
        this.zzd = i;
        this.zzb = str;
        this.zzc = th;
    }

    @Deprecated
    public static zzx zzb() {
        return zze;
    }

    public static zzx zzc(@NonNull String str) {
        return new zzx(false, 1, 5, str, null);
    }

    public static zzx zzd(@NonNull String str, @NonNull Throwable th) {
        return new zzx(false, 1, 5, str, th);
    }

    public static zzx zzf(int i) {
        return new zzx(true, i, 1, null, null);
    }

    public static zzx zzg(int i, int i5, @NonNull String str, Throwable th) {
        return new zzx(false, i, i5, str, th);
    }

    public String zza() {
        return this.zzb;
    }

    public final void zze() {
        if (!this.zza && Log.isLoggable("GoogleCertificatesRslt", 3)) {
            if (this.zzc != null) {
                Log.d("GoogleCertificatesRslt", zza(), this.zzc);
            } else {
                Log.d("GoogleCertificatesRslt", zza());
            }
        }
    }

    public /* synthetic */ zzx(boolean z2, int i, int i5, String str, Throwable th, zzw zzwVar) {
        this(false, 1, 5, null, null);
    }
}
