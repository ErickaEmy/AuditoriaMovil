package androidx.core.util;

import ch.qos.logback.core.CoreConstants;
/* loaded from: classes.dex */
public abstract class DebugUtils {
    public static void buildShortClassTag(Object obj, StringBuilder sb) {
        int lastIndexOf;
        if (obj == null) {
            sb.append("null");
            return;
        }
        String simpleName = obj.getClass().getSimpleName();
        if (simpleName.length() <= 0 && (lastIndexOf = (simpleName = obj.getClass().getName()).lastIndexOf(46)) > 0) {
            simpleName = simpleName.substring(lastIndexOf + 1);
        }
        sb.append(simpleName);
        sb.append(CoreConstants.CURLY_LEFT);
        sb.append(Integer.toHexString(System.identityHashCode(obj)));
    }
}
