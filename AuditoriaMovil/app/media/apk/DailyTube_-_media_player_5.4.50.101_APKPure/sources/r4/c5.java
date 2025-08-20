package r4;

import android.net.Uri;
import v5.j5;
/* loaded from: classes.dex */
public final class c5 {
    public static kx.p y(int i) {
        return new kx.p(Uri.parse(j5.rz("%s:%d", "rtp://0.0.0.0", Integer.valueOf(i))));
    }
}
