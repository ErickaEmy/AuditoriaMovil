package kotlin.text;

import java.nio.charset.Charset;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.i18n.LocalizedMessage;
/* compiled from: Charsets.kt */
/* loaded from: classes2.dex */
public final class Charsets {
    public static final Charsets INSTANCE = new Charsets();
    public static final Charset ISO_8859_1;
    public static final Charset US_ASCII;
    public static final Charset UTF_16;
    public static final Charset UTF_16BE;
    public static final Charset UTF_16LE;
    public static final Charset UTF_8;

    private Charsets() {
    }

    static {
        Charset forName = Charset.forName("UTF-8");
        Intrinsics.checkNotNullExpressionValue(forName, "forName(...)");
        UTF_8 = forName;
        Charset forName2 = Charset.forName("UTF-16");
        Intrinsics.checkNotNullExpressionValue(forName2, "forName(...)");
        UTF_16 = forName2;
        Charset forName3 = Charset.forName("UTF-16BE");
        Intrinsics.checkNotNullExpressionValue(forName3, "forName(...)");
        UTF_16BE = forName3;
        Charset forName4 = Charset.forName("UTF-16LE");
        Intrinsics.checkNotNullExpressionValue(forName4, "forName(...)");
        UTF_16LE = forName4;
        Charset forName5 = Charset.forName("US-ASCII");
        Intrinsics.checkNotNullExpressionValue(forName5, "forName(...)");
        US_ASCII = forName5;
        Charset forName6 = Charset.forName(LocalizedMessage.DEFAULT_ENCODING);
        Intrinsics.checkNotNullExpressionValue(forName6, "forName(...)");
        ISO_8859_1 = forName6;
    }
}
