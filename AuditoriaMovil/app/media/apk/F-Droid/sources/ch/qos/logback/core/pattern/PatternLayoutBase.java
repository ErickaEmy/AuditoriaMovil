package ch.qos.logback.core.pattern;

import ch.qos.logback.core.Context;
import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.LayoutBase;
import ch.qos.logback.core.pattern.parser.Parser;
import ch.qos.logback.core.spi.ScanException;
import ch.qos.logback.core.status.ErrorStatus;
import ch.qos.logback.core.status.StatusManager;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public abstract class PatternLayoutBase extends LayoutBase {
    static final int INTIAL_STRING_BUILDER_SIZE = 256;
    Converter head;
    Map<String, String> instanceConverterMap = new HashMap();
    protected boolean outputPatternAsHeader = false;
    String pattern;
    protected PostCompileProcessor postCompileProcessor;

    @Override // ch.qos.logback.core.LayoutBase, ch.qos.logback.core.Layout
    public abstract /* synthetic */ String doLayout(Object obj);

    public abstract Map<String, String> getDefaultConverterMap();

    public Map<String, String> getEffectiveConverterMap() {
        Map map;
        HashMap hashMap = new HashMap();
        Map<String, String> defaultConverterMap = getDefaultConverterMap();
        if (defaultConverterMap != null) {
            hashMap.putAll(defaultConverterMap);
        }
        Context context = getContext();
        if (context != null && (map = (Map) context.getObject(CoreConstants.PATTERN_RULE_REGISTRY)) != null) {
            hashMap.putAll(map);
        }
        hashMap.putAll(this.instanceConverterMap);
        return hashMap;
    }

    public Map<String, String> getInstanceConverterMap() {
        return this.instanceConverterMap;
    }

    public String getPattern() {
        return this.pattern;
    }

    @Override // ch.qos.logback.core.LayoutBase, ch.qos.logback.core.Layout
    public String getPresentationHeader() {
        if (this.outputPatternAsHeader) {
            return getPresentationHeaderPrefix() + this.pattern;
        }
        return super.getPresentationHeader();
    }

    protected String getPresentationHeaderPrefix() {
        return "";
    }

    public boolean isOutputPatternAsHeader() {
        return this.outputPatternAsHeader;
    }

    protected void setContextForConverters(Converter converter) {
        ConverterUtil.setContextForConverters(getContext(), converter);
    }

    public void setOutputPatternAsHeader(boolean z) {
        this.outputPatternAsHeader = z;
    }

    public void setPattern(String str) {
        this.pattern = str;
    }

    public void setPostCompileProcessor(PostCompileProcessor postCompileProcessor) {
        this.postCompileProcessor = postCompileProcessor;
    }

    @Override // ch.qos.logback.core.LayoutBase, ch.qos.logback.core.Layout, ch.qos.logback.core.spi.LifeCycle
    public void start() {
        String str = this.pattern;
        if (str == null || str.length() == 0) {
            addError("Empty or null pattern.");
            return;
        }
        try {
            Parser parser = new Parser(this.pattern);
            if (getContext() != null) {
                parser.setContext(getContext());
            }
            Converter compile = parser.compile(parser.parse(), getEffectiveConverterMap());
            this.head = compile;
            PostCompileProcessor postCompileProcessor = this.postCompileProcessor;
            if (postCompileProcessor != null) {
                postCompileProcessor.process(this.context, compile);
            }
            ConverterUtil.setContextForConverters(getContext(), this.head);
            ConverterUtil.startConverters(this.head);
            super.start();
        } catch (ScanException e) {
            StatusManager statusManager = getContext().getStatusManager();
            statusManager.add(new ErrorStatus("Failed to parse pattern \"" + getPattern() + "\".", this, e));
        }
    }

    public String toString() {
        return getClass().getName() + "(\"" + getPattern() + "\")";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String writeLoopOnConverters(Object obj) {
        StringBuilder sb = new StringBuilder(256);
        for (Converter converter = this.head; converter != null; converter = converter.getNext()) {
            converter.write(sb, obj);
        }
        return sb.toString();
    }
}
