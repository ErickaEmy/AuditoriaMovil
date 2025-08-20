package io.ktor.http;

import io.ktor.util.StringValues;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Parameters.kt */
/* loaded from: classes.dex */
public interface Parameters extends StringValues {
    public static final Companion Companion = Companion.$$INSTANCE;

    /* compiled from: Parameters.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final Parameters Empty = EmptyParameters.INSTANCE;

        private Companion() {
        }

        public final Parameters getEmpty() {
            return Empty;
        }
    }

    /* compiled from: Parameters.kt */
    /* loaded from: classes.dex */
    public static final class DefaultImpls {
        public static void forEach(Parameters parameters, Function2 body) {
            Intrinsics.checkNotNullParameter(body, "body");
            StringValues.DefaultImpls.forEach(parameters, body);
        }
    }
}
