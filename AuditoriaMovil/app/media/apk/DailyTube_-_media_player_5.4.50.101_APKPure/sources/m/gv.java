package m;

import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class gv {
    public static final String[] y = new String[0];

    public static final StringBuilder n3() {
        return new StringBuilder();
    }

    public static final void y(StringBuilder builder, int i) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        for (int i5 = 0; i5 < i; i5++) {
            builder.append("?");
            if (i5 < i - 1) {
                builder.append(",");
            }
        }
    }
}
