package j0;

import android.content.Context;
import android.util.Log;
import java.util.List;
import java.util.concurrent.Executor;
import m0.a;
import m0.y;
/* loaded from: classes.dex */
public final class co implements n0.a8 {

    /* renamed from: gv  reason: collision with root package name */
    public final Executor f9352gv;

    /* renamed from: n3  reason: collision with root package name */
    public final a f9353n3;

    /* renamed from: v  reason: collision with root package name */
    public final m0.co f9354v;
    public final Context y;

    /* renamed from: zn  reason: collision with root package name */
    public final r f9355zn;

    public co(Context context, Executor executor, r rVar, a aVar, m0.co coVar, byte[] bArr) {
        this.y = context;
        this.f9353n3 = aVar;
        this.f9355zn = rVar;
        this.f9352gv = executor;
        this.f9354v = coVar;
    }

    public static /* bridge */ /* synthetic */ void gv(co coVar, n0.ej ejVar) {
        try {
            if (!y.a(y5.y(coVar.y))) {
                Log.e("SplitCompat", "Emulating splits failed.");
                ejVar.zzb(-12);
                return;
            }
            ejVar.zza();
        } catch (Exception e2) {
            Log.e("SplitCompat", "Error emulating splits.", e2);
            ejVar.zzb(-12);
        }
    }

    public static /* bridge */ /* synthetic */ void zn(co coVar, List list, n0.ej ejVar) {
        Integer v2 = coVar.v(list);
        if (v2 == null) {
            return;
        }
        if (v2.intValue() == 0) {
            ejVar.zzc();
        } else {
            ejVar.zzb(v2.intValue());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:74:0x011d A[Catch: Exception -> 0x0119, TRY_LEAVE, TryCatch #5 {Exception -> 0x0119, blocks: (B:3:0x0004, B:74:0x011d, B:5:0x0016, B:11:0x0022, B:12:0x0026, B:14:0x002d, B:16:0x0055, B:23:0x006b, B:25:0x0077, B:36:0x0098, B:43:0x00a5, B:21:0x0065, B:44:0x00a6, B:46:0x00b2, B:48:0x00ba, B:50:0x00c2, B:51:0x00d0, B:53:0x00d4, B:66:0x010b, B:56:0x00e6, B:60:0x00f0, B:62:0x00f8, B:64:0x00ff, B:65:0x0105), top: B:87:0x0004 }] */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Integer v(java.util.List r14) {
        /*
            Method dump skipped, instructions count: 299
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j0.co.v(java.util.List):java.lang.Integer");
    }

    @Override // n0.a8
    public final void y(List list, n0.ej ejVar) {
        if (y.fb()) {
            this.f9352gv.execute(new mt(this, list, ejVar));
            return;
        }
        throw new IllegalStateException("Ingestion should only be called in SplitCompat mode.");
    }
}
