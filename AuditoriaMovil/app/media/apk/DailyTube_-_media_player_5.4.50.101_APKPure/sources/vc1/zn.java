package vc1;

import android.util.Log;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.logging.Level;
import java.util.logging.Logger;
import kc1.n;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* loaded from: classes.dex */
public final class zn {

    /* renamed from: n3  reason: collision with root package name */
    public static final Map<String, String> f14448n3;

    /* renamed from: zn  reason: collision with root package name */
    public static final zn f14449zn = new zn();
    public static final CopyOnWriteArraySet<Logger> y = new CopyOnWriteArraySet<>();

    static {
        String str;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Package r2 = n.class.getPackage();
        if (r2 != null) {
            str = r2.getName();
        } else {
            str = null;
        }
        if (str != null) {
            linkedHashMap.put(str, "OkHttp");
        }
        String name = n.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "OkHttpClient::class.java.name");
        linkedHashMap.put(name, "okhttp.OkHttpClient");
        String name2 = sc1.v.class.getName();
        Intrinsics.checkNotNullExpressionValue(name2, "Http2::class.java.name");
        linkedHashMap.put(name2, "okhttp.Http2");
        String name3 = oc1.v.class.getName();
        Intrinsics.checkNotNullExpressionValue(name3, "TaskRunner::class.java.name");
        linkedHashMap.put(name3, "okhttp.TaskRunner");
        linkedHashMap.put("okhttp3.mockwebserver.MockWebServer", "okhttp.MockWebServer");
        f14448n3 = MapsKt.toMap(linkedHashMap);
    }

    public final String gv(String str) {
        String str2 = f14448n3.get(str);
        if (str2 == null) {
            return StringsKt.take(str, 23);
        }
        return str2;
    }

    public final void n3() {
        for (Map.Entry<String, String> entry : f14448n3.entrySet()) {
            zn(entry.getKey(), entry.getValue());
        }
    }

    public final void y(String loggerName, int i, String message, Throwable th) {
        int min;
        Intrinsics.checkNotNullParameter(loggerName, "loggerName");
        Intrinsics.checkNotNullParameter(message, "message");
        String gv2 = gv(loggerName);
        if (Log.isLoggable(gv2, i)) {
            if (th != null) {
                message = message + "\n" + Log.getStackTraceString(th);
            }
            int length = message.length();
            int i5 = 0;
            while (i5 < length) {
                int indexOf$default = StringsKt.indexOf$default((CharSequence) message, '\n', i5, false, 4, (Object) null);
                if (indexOf$default == -1) {
                    indexOf$default = length;
                }
                while (true) {
                    min = Math.min(indexOf$default, i5 + 4000);
                    String substring = message.substring(i5, min);
                    Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    Log.println(i, gv2, substring);
                    if (min >= indexOf$default) {
                        break;
                    }
                    i5 = min;
                }
                i5 = min + 1;
            }
        }
    }

    public final void zn(String str, String str2) {
        Level level;
        Logger logger = Logger.getLogger(str);
        if (y.add(logger)) {
            Intrinsics.checkNotNullExpressionValue(logger, "logger");
            logger.setUseParentHandlers(false);
            if (Log.isLoggable(str2, 3)) {
                level = Level.FINE;
            } else if (Log.isLoggable(str2, 4)) {
                level = Level.INFO;
            } else {
                level = Level.WARNING;
            }
            logger.setLevel(level);
            logger.addHandler(gv.y);
        }
    }
}
