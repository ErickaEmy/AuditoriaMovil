package ch.qos.logback.core.pattern;
/* loaded from: classes.dex */
public class IdentityCompositeConverter extends CompositeConverter {
    @Override // ch.qos.logback.core.pattern.CompositeConverter
    protected String transform(Object obj, String str) {
        return str;
    }
}
