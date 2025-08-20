package io.ktor.http;

import io.ktor.util.StringValues;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Headers.kt */
/* loaded from: classes.dex */
public interface Headers extends StringValues {
    public static final Companion Companion = Companion.$$INSTANCE;

    /* compiled from: Headers.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final Headers Empty = EmptyHeaders.INSTANCE;

        private Companion() {
        }

        public final Headers getEmpty() {
            return Empty;
        }
    }

    /* compiled from: Headers.kt */
    /* loaded from: classes.dex */
    public static final class DefaultImpls {
        public static void forEach(Headers headers, Function2 body) {
            Intrinsics.checkNotNullParameter(body, "body");
            StringValues.DefaultImpls.forEach(headers, body);
        }

        public static String get(Headers headers, String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            return StringValues.DefaultImpls.get(headers, name);
        }
    }
}
