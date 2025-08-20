package ch.qos.logback.core.pattern;

import ch.qos.logback.core.Context;
/* loaded from: classes.dex */
public interface PostCompileProcessor {
    void process(Context context, Converter converter);
}
