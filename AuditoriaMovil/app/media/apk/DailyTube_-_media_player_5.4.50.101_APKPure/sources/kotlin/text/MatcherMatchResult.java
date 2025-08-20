package kotlin.text;

import java.util.regex.Matcher;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
final class MatcherMatchResult implements MatchResult {
    private final MatchGroupCollection groups;
    private final CharSequence input;
    private final Matcher matcher;

    public MatcherMatchResult(Matcher matcher, CharSequence input) {
        Intrinsics.checkNotNullParameter(matcher, "matcher");
        Intrinsics.checkNotNullParameter(input, "input");
        this.matcher = matcher;
        this.input = input;
        this.groups = new MatcherMatchResult$groups$1(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final java.util.regex.MatchResult getMatchResult() {
        return this.matcher;
    }

    @Override // kotlin.text.MatchResult
    public String getValue() {
        String group = getMatchResult().group();
        Intrinsics.checkNotNullExpressionValue(group, "group(...)");
        return group;
    }
}
