package qc1;

import kc1.i4;
import kc1.mg;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class s extends mg {

    /* renamed from: fb  reason: collision with root package name */
    public final zc1.fb f12801fb;

    /* renamed from: v  reason: collision with root package name */
    public final long f12802v;
    public final String y;

    public s(String str, long j2, zc1.fb source) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.y = str;
        this.f12802v = j2;
        this.f12801fb = source;
    }

    @Override // kc1.mg
    public long contentLength() {
        return this.f12802v;
    }

    @Override // kc1.mg
    public i4 contentType() {
        String str = this.y;
        if (str != null) {
            return i4.f9789fb.n3(str);
        }
        return null;
    }

    @Override // kc1.mg
    public zc1.fb source() {
        return this.f12801fb;
    }
}
