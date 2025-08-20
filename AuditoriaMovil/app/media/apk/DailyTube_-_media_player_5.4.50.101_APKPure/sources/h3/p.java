package h3;

import h3.x4;
import java.util.List;
/* loaded from: classes.dex */
public interface p {
    public static final p y = new p() { // from class: h3.w
        @Override // h3.p
        public final List getDecoderInfos(String str, boolean z2, boolean z3) {
            return x4.co(str, z2, z3);
        }
    };

    List<wz> getDecoderInfos(String str, boolean z2, boolean z3) throws x4.zn;
}
