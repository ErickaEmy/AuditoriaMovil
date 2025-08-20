package ch.qos.logback.classic.joran.action;

import ch.qos.logback.core.joran.action.AbstractIncludeAction;
import ch.qos.logback.core.joran.spi.ActionException;
import ch.qos.logback.core.joran.spi.InterpretationContext;
import ch.qos.logback.core.joran.spi.JoranException;
import java.io.FileNotFoundException;
import java.net.URL;
import java.net.UnknownHostException;
import org.xml.sax.Attributes;
/* loaded from: classes.dex */
public class ConditionalIncludeAction extends AbstractIncludeAction {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class State {
        private URL url;

        State() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public URL getUrl() {
            return this.url;
        }

        void setUrl(URL url) {
            this.url = url;
        }
    }

    private URL peekPath(InterpretationContext interpretationContext) {
        URL url;
        if (interpretationContext.isEmpty()) {
            return null;
        }
        Object peekObject = interpretationContext.peekObject();
        if (!(peekObject instanceof State) || (url = ((State) peekObject).getUrl()) == null) {
            return null;
        }
        return url;
    }

    private URL pushPath(InterpretationContext interpretationContext, URL url) {
        State state = new State();
        state.setUrl(url);
        interpretationContext.pushObject(state);
        return url;
    }

    @Override // ch.qos.logback.core.joran.action.AbstractIncludeAction, ch.qos.logback.core.joran.action.Action
    public void begin(InterpretationContext interpretationContext, String str, Attributes attributes) throws ActionException {
        if (peekPath(interpretationContext) != null) {
            return;
        }
        super.begin(interpretationContext, str, attributes);
    }

    @Override // ch.qos.logback.core.joran.action.AbstractIncludeAction
    protected void handleError(String str, Exception exc) {
        if (exc == null || (exc instanceof FileNotFoundException) || (exc instanceof UnknownHostException)) {
            addInfo(str);
        } else {
            addWarn(str, exc);
        }
    }

    @Override // ch.qos.logback.core.joran.action.AbstractIncludeAction
    protected void processInclude(InterpretationContext interpretationContext, URL url) throws JoranException {
        pushPath(interpretationContext, url);
    }
}
