package sq;

import java.net.URLEncoder;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* loaded from: classes.dex */
public final class gv {
    public static final String n3(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        String encode = URLEncoder.encode(str, "UTF-8");
        Intrinsics.checkNotNullExpressionValue(encode, "encode(...)");
        return StringsKt.replace$default(encode, "+", "%20", false, 4, (Object) null);
    }

    public static final String y(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return zn.y.n3().y(str);
    }
}
