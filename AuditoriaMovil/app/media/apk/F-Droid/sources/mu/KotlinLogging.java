package mu;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mu.internal.KLoggerFactory;
import mu.internal.KLoggerNameResolver;
import mu.internal.LocationAwareKLogger;
import mu.internal.LocationIgnorantKLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.spi.LocationAwareLogger;
/* compiled from: KotlinLogging.kt */
/* loaded from: classes2.dex */
public final class KotlinLogging {
    public static final KotlinLogging INSTANCE = new KotlinLogging();

    private KotlinLogging() {
    }

    public final KLogger logger(Function0 func) {
        boolean contains$default;
        boolean contains$default2;
        Intrinsics.checkNotNullParameter(func, "func");
        KLoggerFactory kLoggerFactory = KLoggerFactory.INSTANCE;
        KLoggerNameResolver kLoggerNameResolver = KLoggerNameResolver.INSTANCE;
        String slicedName = func.getClass().getName();
        Intrinsics.checkNotNullExpressionValue(slicedName, "name");
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) slicedName, (CharSequence) "Kt$", false, 2, (Object) null);
        if (contains$default) {
            slicedName = StringsKt__StringsKt.substringBefore$default(slicedName, "Kt$", (String) null, 2, (Object) null);
        } else {
            contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) slicedName, (CharSequence) "$", false, 2, (Object) null);
            if (contains$default2) {
                slicedName = StringsKt__StringsKt.substringBefore$default(slicedName, "$", (String) null, 2, (Object) null);
            }
        }
        Intrinsics.checkNotNullExpressionValue(slicedName, "slicedName");
        Logger logger = LoggerFactory.getLogger(slicedName);
        Intrinsics.checkNotNullExpressionValue(logger, "LoggerFactory.getLogger(name)");
        if (logger instanceof LocationAwareLogger) {
            return new LocationAwareKLogger((LocationAwareLogger) logger);
        }
        return new LocationIgnorantKLogger(logger);
    }
}
