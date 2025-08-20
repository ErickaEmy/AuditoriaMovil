package ha;

import androidx.annotation.Nullable;
import e4.ta;
import v5.r;
/* loaded from: classes.dex */
public final class w {

    /* renamed from: gv  reason: collision with root package name */
    public final int f8900gv;
    @Nullable

    /* renamed from: n3  reason: collision with root package name */
    public final String f8901n3;
    @Nullable

    /* renamed from: v  reason: collision with root package name */
    public final byte[] f8902v;
    public final boolean y;

    /* renamed from: zn  reason: collision with root package name */
    public final ta.y f8903zn;

    public w(boolean z2, @Nullable String str, int i, byte[] bArr, int i5, int i6, @Nullable byte[] bArr2) {
        boolean z3;
        if (i == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        v5.y.y((bArr2 == null) ^ z3);
        this.y = z2;
        this.f8901n3 = str;
        this.f8900gv = i;
        this.f8902v = bArr2;
        this.f8903zn = new ta.y(y(str), bArr, i5, i6);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int y(@Nullable String str) {
        if (str == null) {
            return 1;
        }
        char c2 = 65535;
        switch (str.hashCode()) {
            case 3046605:
                if (str.equals("cbc1")) {
                    c2 = 0;
                    break;
                }
                break;
            case 3046671:
                if (str.equals("cbcs")) {
                    c2 = 1;
                    break;
                }
                break;
            case 3049879:
                if (str.equals("cenc")) {
                    c2 = 2;
                    break;
                }
                break;
            case 3049895:
                if (str.equals("cens")) {
                    c2 = 3;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
            case 1:
                return 2;
            case 2:
            case 3:
                break;
            default:
                r.c5("TrackEncryptionBox", "Unsupported protection scheme type '" + str + "'. Assuming AES-CTR crypto mode.");
                break;
        }
        return 1;
    }
}
