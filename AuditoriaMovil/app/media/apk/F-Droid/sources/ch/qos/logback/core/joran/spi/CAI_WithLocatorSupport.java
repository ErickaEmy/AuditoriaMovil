package ch.qos.logback.core.joran.spi;

import ch.qos.logback.core.Context;
import ch.qos.logback.core.spi.ContextAwareImpl;
import org.xml.sax.Locator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class CAI_WithLocatorSupport extends ContextAwareImpl {
    /* JADX INFO: Access modifiers changed from: package-private */
    public CAI_WithLocatorSupport(Context context, Interpreter interpreter) {
        super(context, interpreter);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ch.qos.logback.core.spi.ContextAwareImpl
    public Object getOrigin() {
        Locator locator = ((Interpreter) super.getOrigin()).locator;
        if (locator == null) {
            return Interpreter.class.getName() + "@NA:NA";
        }
        return Interpreter.class.getName() + "@" + locator.getLineNumber() + ":" + locator.getColumnNumber();
    }
}
