package od1;

import androidx.lifecycle.wz;
import kotlin.jvm.internal.Intrinsics;
import y5.d;
import y5.ud;
/* loaded from: classes.dex */
public final class zn {
    public static final <T extends ud> wz.n3 y(be1.y yVar, n3<T> viewModelParameters) {
        Intrinsics.checkNotNullParameter(yVar, "<this>");
        Intrinsics.checkNotNullParameter(viewModelParameters, "viewModelParameters");
        if (viewModelParameters.gv() != null) {
            return new d(yVar, viewModelParameters);
        }
        return new pd1.y(yVar, viewModelParameters);
    }
}
