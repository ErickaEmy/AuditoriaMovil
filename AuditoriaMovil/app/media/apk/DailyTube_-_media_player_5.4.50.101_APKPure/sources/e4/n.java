package e4;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.Metadata;
import ho.n3;
import java.io.EOFException;
import java.io.IOException;
/* loaded from: classes.dex */
public final class n {
    public final v5.rz y = new v5.rz(10);

    @Nullable
    public Metadata y(tl tlVar, @Nullable n3.y yVar) throws IOException {
        Metadata metadata = null;
        int i = 0;
        while (true) {
            try {
                tlVar.z(this.y.v(), 0, 10);
                this.y.oz(0);
                if (this.y.x() != 4801587) {
                    break;
                }
                this.y.ut(3);
                int z62 = this.y.z6();
                int i5 = z62 + 10;
                if (metadata == null) {
                    byte[] bArr = new byte[i5];
                    System.arraycopy(this.y.v(), 0, bArr, 0, 10);
                    tlVar.z(bArr, 10, z62);
                    metadata = new ho.n3(yVar).v(bArr, i5);
                } else {
                    tlVar.wz(z62);
                }
                i += i5;
            } catch (EOFException unused) {
            }
        }
        tlVar.s();
        tlVar.wz(i);
        return metadata;
    }
}
