package h3;

import android.media.MediaCodec;
import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public class tl extends a9.a {
    @Nullable
    public final wz codecInfo;
    @Nullable
    public final String diagnosticInfo;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public tl(java.lang.Throwable r4, @androidx.annotation.Nullable h3.wz r5) {
        /*
            r3 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Decoder failed: "
            r0.append(r1)
            r1 = 0
            if (r5 != 0) goto Lf
            r2 = r1
            goto L11
        Lf:
            java.lang.String r2 = r5.y
        L11:
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            r3.<init>(r0, r4)
            r3.codecInfo = r5
            int r5 = v5.j5.y
            r0 = 21
            if (r5 < r0) goto L27
            java.lang.String r1 = y(r4)
        L27:
            r3.diagnosticInfo = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: h3.tl.<init>(java.lang.Throwable, h3.wz):void");
    }

    @Nullable
    public static String y(Throwable th) {
        if (th instanceof MediaCodec.CodecException) {
            return ((MediaCodec.CodecException) th).getDiagnosticInfo();
        }
        return null;
    }
}
