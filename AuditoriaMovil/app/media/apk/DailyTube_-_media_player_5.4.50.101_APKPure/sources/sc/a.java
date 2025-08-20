package sc;

import androidx.core.app.NotificationCompat;
import e4.tl;
import java.io.IOException;
import v5.rz;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: n3  reason: collision with root package name */
    public int f13524n3;
    public final rz y = new rz(8);

    public boolean n3(tl tlVar) throws IOException {
        long y;
        int i;
        long length = tlVar.getLength();
        long j2 = 1024;
        int i5 = (length > (-1L) ? 1 : (length == (-1L) ? 0 : -1));
        if (i5 != 0 && length <= 1024) {
            j2 = length;
        }
        int i6 = (int) j2;
        tlVar.z(this.y.v(), 0, 4);
        long a82 = this.y.a8();
        this.f13524n3 = 4;
        while (a82 != 440786851) {
            int i8 = this.f13524n3 + 1;
            this.f13524n3 = i8;
            if (i8 == i6) {
                return false;
            }
            tlVar.z(this.y.v(), 0, 1);
            a82 = ((a82 << 8) & (-256)) | (this.y.v()[0] & 255);
        }
        long y2 = y(tlVar);
        long j4 = this.f13524n3;
        if (y2 == Long.MIN_VALUE) {
            return false;
        }
        if (i5 != 0 && j4 + y2 >= length) {
            return false;
        }
        while (true) {
            int i10 = this.f13524n3;
            long j6 = j4 + y2;
            if (i10 < j6) {
                if (y(tlVar) != Long.MIN_VALUE && (y(tlVar)) >= 0 && y <= 2147483647L) {
                    if (i != 0) {
                        int i11 = (int) y;
                        tlVar.wz(i11);
                        this.f13524n3 += i11;
                    }
                }
            } else if (i10 != j6) {
                return false;
            } else {
                return true;
            }
        }
    }

    public final long y(tl tlVar) throws IOException {
        int i = 0;
        tlVar.z(this.y.v(), 0, 1);
        int i5 = this.y.v()[0] & 255;
        if (i5 == 0) {
            return Long.MIN_VALUE;
        }
        int i6 = NotificationCompat.FLAG_HIGH_PRIORITY;
        int i8 = 0;
        while ((i5 & i6) == 0) {
            i6 >>= 1;
            i8++;
        }
        int i10 = i5 & (~i6);
        tlVar.z(this.y.v(), 1, i8);
        while (i < i8) {
            i++;
            i10 = (this.y.v()[i] & 255) + (i10 << 8);
        }
        this.f13524n3 += i8 + 1;
        return i10;
    }
}
