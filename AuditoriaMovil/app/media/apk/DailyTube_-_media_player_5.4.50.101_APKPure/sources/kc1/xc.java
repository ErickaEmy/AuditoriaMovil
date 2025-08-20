package kc1;

import java.nio.charset.Charset;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class xc {
    public static final xc y = new xc();

    public static final String y(String username, String password, Charset charset) {
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(password, "password");
        Intrinsics.checkNotNullParameter(charset, "charset");
        String y2 = zc1.s.fb.zn(username + ':' + password, charset).y();
        return "Basic " + y2;
    }
}
