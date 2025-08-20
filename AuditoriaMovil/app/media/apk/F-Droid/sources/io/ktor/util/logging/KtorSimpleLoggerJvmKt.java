package io.ktor.util.logging;

import kotlin.jvm.internal.Intrinsics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/* compiled from: KtorSimpleLoggerJvm.kt */
/* loaded from: classes.dex */
public abstract class KtorSimpleLoggerJvmKt {
    public static final Logger KtorSimpleLogger(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        Logger logger = LoggerFactory.getLogger(name);
        Intrinsics.checkNotNullExpressionValue(logger, "getLogger(name)");
        return logger;
    }
}
