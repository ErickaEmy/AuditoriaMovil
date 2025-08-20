package tp;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.dvbsi.AppInfoTable;
import hd.a;
import hd.gv;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import v5.fh;
import w0.v;
/* loaded from: classes.dex */
public final class y extends a {
    @Nullable
    public static Metadata zn(fh fhVar) {
        fhVar.mt(12);
        int gv2 = (fhVar.gv() + fhVar.s(12)) - 4;
        fhVar.mt(44);
        fhVar.co(fhVar.s(12));
        fhVar.mt(16);
        ArrayList arrayList = new ArrayList();
        while (true) {
            String str = null;
            if (fhVar.gv() >= gv2) {
                break;
            }
            fhVar.mt(48);
            int s2 = fhVar.s(8);
            fhVar.mt(4);
            int gv3 = fhVar.gv() + fhVar.s(12);
            String str2 = null;
            while (fhVar.gv() < gv3) {
                int s3 = fhVar.s(8);
                int s4 = fhVar.s(8);
                int gv4 = fhVar.gv() + s4;
                if (s3 == 2) {
                    int s5 = fhVar.s(16);
                    fhVar.mt(8);
                    if (s5 != 3) {
                    }
                    while (fhVar.gv() < gv4) {
                        str = fhVar.t(fhVar.s(8), v.y);
                        int s7 = fhVar.s(8);
                        for (int i = 0; i < s7; i++) {
                            fhVar.co(fhVar.s(8));
                        }
                    }
                } else if (s3 == 21) {
                    str2 = fhVar.t(s4, v.y);
                }
                fhVar.w(gv4 * 8);
            }
            fhVar.w(gv3 * 8);
            if (str != null && str2 != null) {
                arrayList.add(new AppInfoTable(s2, str + str2));
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata(arrayList);
    }

    @Override // hd.a
    @Nullable
    public Metadata n3(gv gvVar, ByteBuffer byteBuffer) {
        if (byteBuffer.get() == 116) {
            return zn(new fh(byteBuffer.array(), byteBuffer.limit()));
        }
        return null;
    }
}
