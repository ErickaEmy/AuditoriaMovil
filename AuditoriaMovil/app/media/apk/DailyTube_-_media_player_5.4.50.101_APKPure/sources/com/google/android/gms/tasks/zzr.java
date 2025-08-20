package com.google.android.gms.tasks;

import androidx.annotation.NonNull;
import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes.dex */
final class zzr<TResult> {
    private final Object zza = new Object();
    private Queue<zzq<TResult>> zzb;
    private boolean zzc;

    public final void zza(@NonNull zzq<TResult> zzqVar) {
        synchronized (this.zza) {
            try {
                if (this.zzb == null) {
                    this.zzb = new ArrayDeque();
                }
                this.zzb.add(zzqVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzb(@NonNull Task<TResult> task) {
        zzq<TResult> poll;
        synchronized (this.zza) {
            if (this.zzb != null && !this.zzc) {
                this.zzc = true;
                while (true) {
                    synchronized (this.zza) {
                        try {
                            poll = this.zzb.poll();
                            if (poll == null) {
                                this.zzc = false;
                                return;
                            }
                        } finally {
                        }
                    }
                    poll.zzd(task);
                }
            }
        }
    }
}
