package io.ktor.util;

import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
/* compiled from: Text.kt */
/* loaded from: classes.dex */
public final class CaseInsensitiveString {
    private final String content;
    private final int hash;

    public final String getContent() {
        return this.content;
    }

    public int hashCode() {
        return this.hash;
    }

    public String toString() {
        return this.content;
    }

    public CaseInsensitiveString(String content) {
        Intrinsics.checkNotNullParameter(content, "content");
        this.content = content;
        String lowerCase = content.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        this.hash = lowerCase.hashCode();
    }

    public boolean equals(Object obj) {
        String str;
        boolean equals;
        CaseInsensitiveString caseInsensitiveString = obj instanceof CaseInsensitiveString ? (CaseInsensitiveString) obj : null;
        if (caseInsensitiveString == null || (str = caseInsensitiveString.content) == null) {
            return false;
        }
        equals = StringsKt__StringsJVMKt.equals(str, this.content, true);
        return equals;
    }
}
