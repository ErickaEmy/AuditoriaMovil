package m1;

import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import java.io.IOException;
import m1.s;
/* loaded from: classes.dex */
public final class p extends gf {
    final boolean isRecoverable;
    @Nullable
    public final af.fh mediaPeriodId;
    @Nullable
    public final m rendererFormat;
    public final int rendererFormatSupport;
    public final int rendererIndex;
    @Nullable
    public final String rendererName;
    public final int type;

    /* renamed from: w  reason: collision with root package name */
    public static final s.y<p> f11117w = new s.y() { // from class: m1.w
        @Override // m1.s.y
        public final s fromBundle(Bundle bundle) {
            return p.t(bundle);
        }
    };

    /* renamed from: p  reason: collision with root package name */
    public static final String f11115p = v5.j5.g3(1001);

    /* renamed from: co  reason: collision with root package name */
    public static final String f11112co = v5.j5.g3(1002);

    /* renamed from: z  reason: collision with root package name */
    public static final String f11118z = v5.j5.g3(1003);

    /* renamed from: r  reason: collision with root package name */
    public static final String f11116r = v5.j5.g3(1004);

    /* renamed from: f3  reason: collision with root package name */
    public static final String f11113f3 = v5.j5.g3(1005);

    /* renamed from: n  reason: collision with root package name */
    public static final String f11114n = v5.j5.g3(1006);

    public p(int i, Throwable th, int i5) {
        this(i, th, null, i5, null, -1, null, 4, false);
    }

    public static p co(IOException iOException, int i) {
        return new p(0, iOException, i);
    }

    public static p mt(Throwable th, String str, int i, @Nullable m mVar, int i5, boolean z2, int i6) {
        int i8;
        if (mVar == null) {
            i8 = 4;
        } else {
            i8 = i5;
        }
        return new p(1, th, null, i6, str, i, mVar, i8, z2);
    }

    @Deprecated
    public static p r(RuntimeException runtimeException) {
        return x4(runtimeException, 1000);
    }

    public static /* synthetic */ p t(Bundle bundle) {
        return new p(bundle);
    }

    public static String ta(int i, @Nullable String str, @Nullable String str2, int i5, @Nullable m mVar, int i6) {
        String str3;
        if (i != 0) {
            if (i != 1) {
                if (i != 3) {
                    str3 = "Unexpected runtime error";
                } else {
                    str3 = "Remote error";
                }
            } else {
                str3 = str2 + " error, index=" + i5 + ", format=" + mVar + ", format_supported=" + v5.j5.f7(i6);
            }
        } else {
            str3 = "Source error";
        }
        if (!TextUtils.isEmpty(str)) {
            return str3 + ": " + str;
        }
        return str3;
    }

    public static p x4(RuntimeException runtimeException, int i) {
        return new p(2, runtimeException, i);
    }

    public IOException d() {
        boolean z2;
        if (this.type == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        v5.y.fb(z2);
        return (IOException) v5.y.v(getCause());
    }

    @CheckResult
    public p p(@Nullable af.fh fhVar) {
        return new p((String) v5.j5.i9(getMessage()), getCause(), this.errorCode, this.type, this.rendererName, this.rendererIndex, this.rendererFormat, this.rendererFormatSupport, fhVar, this.timestampMs, this.isRecoverable);
    }

    @Override // m1.gf, m1.s
    public Bundle toBundle() {
        Bundle bundle = super.toBundle();
        bundle.putInt(f11115p, this.type);
        bundle.putString(f11112co, this.rendererName);
        bundle.putInt(f11118z, this.rendererIndex);
        m mVar = this.rendererFormat;
        if (mVar != null) {
            bundle.putBundle(f11116r, mVar.toBundle());
        }
        bundle.putInt(f11113f3, this.rendererFormatSupport);
        bundle.putBoolean(f11114n, this.isRecoverable);
        return bundle;
    }

    public p(int i, @Nullable Throwable th, @Nullable String str, int i5, @Nullable String str2, int i6, @Nullable m mVar, int i8, boolean z2) {
        this(ta(i, str, str2, i6, mVar, i8), th, i5, i, str2, i6, mVar, i8, null, SystemClock.elapsedRealtime(), z2);
    }

    public p(Bundle bundle) {
        super(bundle);
        this.type = bundle.getInt(f11115p, 2);
        this.rendererName = bundle.getString(f11112co);
        this.rendererIndex = bundle.getInt(f11118z, -1);
        Bundle bundle2 = bundle.getBundle(f11116r);
        this.rendererFormat = bundle2 == null ? null : m.f10917gq.fromBundle(bundle2);
        this.rendererFormatSupport = bundle.getInt(f11113f3, 4);
        this.isRecoverable = bundle.getBoolean(f11114n, false);
        this.mediaPeriodId = null;
    }

    public p(String str, @Nullable Throwable th, int i, int i5, @Nullable String str2, int i6, @Nullable m mVar, int i8, @Nullable af.fh fhVar, long j2, boolean z2) {
        super(str, th, i, j2);
        boolean z3 = false;
        v5.y.y(!z2 || i5 == 1);
        v5.y.y((th != null || i5 == 3) ? true : true);
        this.type = i5;
        this.rendererName = str2;
        this.rendererIndex = i6;
        this.rendererFormat = mVar;
        this.rendererFormatSupport = i8;
        this.mediaPeriodId = fhVar;
        this.isRecoverable = z2;
    }
}
