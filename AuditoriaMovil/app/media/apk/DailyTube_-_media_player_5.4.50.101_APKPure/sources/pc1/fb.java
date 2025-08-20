package pc1;

import java.net.Proxy;
/* loaded from: classes.dex */
public final /* synthetic */ class fb {
    public static final /* synthetic */ int[] y;

    static {
        int[] iArr = new int[Proxy.Type.values().length];
        y = iArr;
        iArr[Proxy.Type.DIRECT.ordinal()] = 1;
        iArr[Proxy.Type.HTTP.ordinal()] = 2;
    }
}
