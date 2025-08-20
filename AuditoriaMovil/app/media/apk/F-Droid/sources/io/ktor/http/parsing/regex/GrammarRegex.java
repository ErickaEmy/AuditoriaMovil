package io.ktor.http.parsing.regex;

import ch.qos.logback.core.CoreConstants;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RegexParserGenerator.kt */
/* loaded from: classes.dex */
public final class GrammarRegex {
    private final int groupsCount;
    private final String regex;

    public final int getGroupsCount() {
        return this.groupsCount;
    }

    public final String getRegex() {
        return this.regex;
    }

    public GrammarRegex(String regexRaw, int i, boolean z) {
        Intrinsics.checkNotNullParameter(regexRaw, "regexRaw");
        if (z) {
            regexRaw = CoreConstants.LEFT_PARENTHESIS_CHAR + regexRaw + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }
        this.regex = regexRaw;
        this.groupsCount = z ? i + 1 : i;
    }

    public /* synthetic */ GrammarRegex(String str, int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i2 & 2) != 0 ? 0 : i, (i2 & 4) != 0 ? false : z);
    }
}
