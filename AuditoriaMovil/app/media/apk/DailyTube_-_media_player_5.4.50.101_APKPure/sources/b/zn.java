package b;

import android.os.Bundle;
import android.util.Size;
import android.util.SizeF;
/* loaded from: classes.dex */
public final class zn {
    public static final zn y = new zn();

    public static final void n3(Bundle bundle, String str, SizeF sizeF) {
        bundle.putSizeF(str, sizeF);
    }

    public static final void y(Bundle bundle, String str, Size size) {
        bundle.putSize(str, size);
    }
}
