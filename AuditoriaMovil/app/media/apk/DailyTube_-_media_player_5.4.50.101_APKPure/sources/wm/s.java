package wm;

import q.gv;
/* loaded from: classes.dex */
public class s {

    /* renamed from: gv  reason: collision with root package name */
    public final boolean f14542gv;

    /* renamed from: n3  reason: collision with root package name */
    public final q.s f14543n3;
    public final y y;

    /* renamed from: zn  reason: collision with root package name */
    public final gv f14544zn;

    /* loaded from: classes.dex */
    public enum y {
        MASK_MODE_ADD,
        MASK_MODE_SUBTRACT,
        MASK_MODE_INTERSECT,
        MASK_MODE_NONE
    }

    public s(y yVar, q.s sVar, gv gvVar, boolean z2) {
        this.y = yVar;
        this.f14543n3 = sVar;
        this.f14544zn = gvVar;
        this.f14542gv = z2;
    }

    public boolean gv() {
        return this.f14542gv;
    }

    public q.s n3() {
        return this.f14543n3;
    }

    public y y() {
        return this.y;
    }

    public gv zn() {
        return this.f14544zn;
    }
}
