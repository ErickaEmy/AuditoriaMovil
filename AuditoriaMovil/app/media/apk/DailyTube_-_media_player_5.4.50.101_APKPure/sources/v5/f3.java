package v5;

import android.media.MediaFormat;
import androidx.annotation.Nullable;
import java.nio.ByteBuffer;
import java.util.List;
/* loaded from: classes.dex */
public final class f3 {
    public static void gv(MediaFormat mediaFormat, String str, int i) {
        if (i != -1) {
            mediaFormat.setInteger(str, i);
        }
    }

    public static void n3(MediaFormat mediaFormat, @Nullable wn.zn znVar) {
        if (znVar != null) {
            gv(mediaFormat, "color-transfer", znVar.f14660fb);
            gv(mediaFormat, "color-standard", znVar.y);
            gv(mediaFormat, "color-range", znVar.f14662v);
            y(mediaFormat, "hdr-static-info", znVar.f14661s);
        }
    }

    public static void v(MediaFormat mediaFormat, List<byte[]> list) {
        for (int i = 0; i < list.size(); i++) {
            mediaFormat.setByteBuffer("csd-" + i, ByteBuffer.wrap(list.get(i)));
        }
    }

    public static void y(MediaFormat mediaFormat, String str, @Nullable byte[] bArr) {
        if (bArr != null) {
            mediaFormat.setByteBuffer(str, ByteBuffer.wrap(bArr));
        }
    }

    public static void zn(MediaFormat mediaFormat, String str, float f4) {
        if (f4 != -1.0f) {
            mediaFormat.setFloat(str, f4);
        }
    }
}
