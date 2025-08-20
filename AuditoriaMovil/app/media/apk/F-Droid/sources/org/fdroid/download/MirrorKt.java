package org.fdroid.download;

import ch.qos.logback.core.CoreConstants;
import io.ktor.http.Url;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.fdroid.fdroid.Preferences;
/* compiled from: Mirror.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u0003H\u0000\u001a\f\u0010\u0004\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0005"}, d2 = {"isLocal", "", "Lio/ktor/http/Url;", "Lorg/fdroid/download/Mirror;", "isOnion", "download_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MirrorKt {
    public static final boolean isLocal(Mirror mirror) {
        return mirror != null && mirror.isLocal();
    }

    public static final boolean isOnion(Url url) {
        boolean endsWith$default;
        Intrinsics.checkNotNullParameter(url, "<this>");
        endsWith$default = StringsKt__StringsJVMKt.endsWith$default(url.getHost(), ".onion", false, 2, null);
        return endsWith$default;
    }

    public static final boolean isLocal(Url url) {
        boolean startsWith$default;
        boolean startsWith$default2;
        boolean startsWith$default3;
        boolean startsWith$default4;
        String substring;
        boolean endsWith$default;
        String trimEnd;
        Integer intOrNull;
        int intValue;
        Intrinsics.checkNotNullParameter(url, "<this>");
        if (new Regex("[0-9.]{7,15}").matches(url.getHost())) {
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(url.getHost(), "172.", false, 2, null);
            if (startsWith$default) {
                substring = StringsKt__StringsKt.substring(url.getHost(), new IntRange(4, 6));
                endsWith$default = StringsKt__StringsKt.endsWith$default((CharSequence) substring, (char) CoreConstants.DOT, false, 2, (Object) null);
                if (endsWith$default) {
                    trimEnd = StringsKt__StringsKt.trimEnd(substring, CoreConstants.DOT);
                    intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(trimEnd);
                    return intOrNull != null && 16 <= (intValue = intOrNull.intValue()) && intValue < 32;
                }
                return false;
            }
            startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(url.getHost(), "169.254.", false, 2, null);
            if (!startsWith$default2) {
                startsWith$default3 = StringsKt__StringsJVMKt.startsWith$default(url.getHost(), "10.", false, 2, null);
                if (!startsWith$default3) {
                    startsWith$default4 = StringsKt__StringsJVMKt.startsWith$default(url.getHost(), "192.168.", false, 2, null);
                    if (!startsWith$default4 && !Intrinsics.areEqual(url.getHost(), Preferences.DEFAULT_PROXY_HOST)) {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }
}
