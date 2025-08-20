package f8;

import java.util.UUID;
import v5.j5;
/* loaded from: classes.dex */
public final class i4 implements a9.n3 {

    /* renamed from: gv  reason: collision with root package name */
    public static final boolean f7905gv;

    /* renamed from: n3  reason: collision with root package name */
    public final byte[] f7906n3;
    public final UUID y;

    /* renamed from: zn  reason: collision with root package name */
    public final boolean f7907zn;

    static {
        boolean z2;
        if ("Amazon".equals(j5.f14370zn)) {
            String str = j5.f14361gv;
            if ("AFTM".equals(str) || "AFTB".equals(str)) {
                z2 = true;
                f7905gv = z2;
            }
        }
        z2 = false;
        f7905gv = z2;
    }

    public i4(UUID uuid, byte[] bArr, boolean z2) {
        this.y = uuid;
        this.f7906n3 = bArr;
        this.f7907zn = z2;
    }
}
