package io.ktor.http.parsing;

import kotlin.jvm.internal.Intrinsics;
/* compiled from: ParserDsl.kt */
/* loaded from: classes.dex */
public final class StringGrammar extends Grammar {
    private final String value;

    public final String getValue() {
        return this.value;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StringGrammar(String value) {
        super(null);
        Intrinsics.checkNotNullParameter(value, "value");
        this.value = value;
    }
}
