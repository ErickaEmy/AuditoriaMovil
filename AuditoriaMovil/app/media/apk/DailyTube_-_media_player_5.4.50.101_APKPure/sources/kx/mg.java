package kx;

import androidx.annotation.Nullable;
import java.io.IOException;
/* loaded from: classes.dex */
public interface mg {

    /* loaded from: classes.dex */
    public static final class n3 {

        /* renamed from: n3  reason: collision with root package name */
        public final long f10055n3;
        public final int y;

        public n3(int i, long j2) {
            boolean z2;
            if (j2 >= 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            v5.y.y(z2);
            this.y = i;
            this.f10055n3 = j2;
        }
    }

    /* loaded from: classes.dex */
    public static final class y {

        /* renamed from: gv  reason: collision with root package name */
        public final int f10056gv;

        /* renamed from: n3  reason: collision with root package name */
        public final int f10057n3;
        public final int y;

        /* renamed from: zn  reason: collision with root package name */
        public final int f10058zn;

        public y(int i, int i5, int i6, int i8) {
            this.y = i;
            this.f10057n3 = i5;
            this.f10058zn = i6;
            this.f10056gv = i8;
        }

        public boolean y(int i) {
            if (i == 1) {
                if (this.y - this.f10057n3 <= 1) {
                    return false;
                }
            } else if (this.f10058zn - this.f10056gv <= 1) {
                return false;
            }
            return true;
        }
    }

    /* loaded from: classes.dex */
    public static final class zn {

        /* renamed from: gv  reason: collision with root package name */
        public final int f10059gv;

        /* renamed from: n3  reason: collision with root package name */
        public final af.c f10060n3;
        public final af.i4 y;

        /* renamed from: zn  reason: collision with root package name */
        public final IOException f10061zn;

        public zn(af.i4 i4Var, af.c cVar, IOException iOException, int i) {
            this.y = i4Var;
            this.f10060n3 = cVar;
            this.f10061zn = iOException;
            this.f10059gv = i;
        }
    }

    long gv(zn znVar);

    @Nullable
    n3 n3(y yVar, zn znVar);

    int y(int i);

    void zn(long j2);
}
