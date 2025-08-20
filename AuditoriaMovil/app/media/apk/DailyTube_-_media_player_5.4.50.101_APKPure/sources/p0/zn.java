package p0;

import e4.i4;
import e4.tl;
/* loaded from: classes.dex */
public final class zn extends i4 {

    /* renamed from: n3  reason: collision with root package name */
    public final long f12385n3;

    public zn(tl tlVar, long j2) {
        super(tlVar);
        boolean z2;
        if (tlVar.getPosition() >= j2) {
            z2 = true;
        } else {
            z2 = false;
        }
        v5.y.y(z2);
        this.f12385n3 = j2;
    }

    @Override // e4.i4, e4.tl
    public long getLength() {
        return super.getLength() - this.f12385n3;
    }

    @Override // e4.i4, e4.tl
    public long getPosition() {
        return super.getPosition() - this.f12385n3;
    }

    @Override // e4.i4, e4.tl
    public long t() {
        return super.t() - this.f12385n3;
    }
}
