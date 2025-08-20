package io.ktor.http;

import kotlin.text.StringsKt__StringsKt;
/* compiled from: HttpHeaders.kt */
/* loaded from: classes.dex */
public abstract class HttpHeadersKt {
    public static final /* synthetic */ boolean access$isDelimiter(char c) {
        return isDelimiter(c);
    }

    public static final boolean isDelimiter(char c) {
        boolean contains$default;
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) "\"(),/:;<=>?@[\\]{}", c, false, 2, (Object) null);
        return contains$default;
    }
}
