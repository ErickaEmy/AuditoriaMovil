package ch.qos.logback.core.pattern.parser;

import ch.qos.logback.core.pattern.CompositeConverter;
import ch.qos.logback.core.pattern.Converter;
import ch.qos.logback.core.pattern.DynamicConverter;
import ch.qos.logback.core.pattern.LiteralConverter;
import ch.qos.logback.core.spi.ContextAwareBase;
import ch.qos.logback.core.status.ErrorStatus;
import ch.qos.logback.core.util.OptionHelper;
import java.util.Map;
/* loaded from: classes.dex */
class Compiler extends ContextAwareBase {
    final Map<String, String> converterMap;
    Converter head;
    Converter tail;
    final Node top;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Compiler(Node node, Map<String, String> map) {
        this.top = node;
        this.converterMap = map;
    }

    private void addToList(Converter converter) {
        if (this.head == null) {
            this.tail = converter;
            this.head = converter;
            return;
        }
        this.tail.setNext(converter);
        this.tail = converter;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [ch.qos.logback.core.pattern.parser.Node] */
    /* JADX WARN: Type inference failed for: r0v2, types: [ch.qos.logback.core.pattern.parser.Node] */
    /* JADX WARN: Type inference failed for: r0v4, types: [ch.qos.logback.core.pattern.parser.Node] */
    public Converter compile() {
        Converter converter;
        this.tail = null;
        this.head = null;
        for (?? r0 = this.top; r0 != null; r0 = r0.next) {
            int i = r0.type;
            if (i != 0) {
                if (i == 1) {
                    SimpleKeywordNode simpleKeywordNode = r0;
                    DynamicConverter createConverter = createConverter(simpleKeywordNode);
                    if (createConverter != null) {
                        createConverter.setFormattingInfo(simpleKeywordNode.getFormatInfo());
                        createConverter.setOptionList(simpleKeywordNode.getOptions());
                        converter = createConverter;
                    } else {
                        Converter literalConverter = new LiteralConverter("%PARSER_ERROR[" + simpleKeywordNode.getValue() + "]");
                        addStatus(new ErrorStatus("[" + simpleKeywordNode.getValue() + "] is not a valid conversion word", this));
                        converter = literalConverter;
                    }
                } else if (i == 2) {
                    CompositeNode compositeNode = r0;
                    CompositeConverter createCompositeConverter = createCompositeConverter(compositeNode);
                    if (createCompositeConverter == null) {
                        addError("Failed to create converter for [%" + compositeNode.getValue() + "] keyword");
                        converter = new LiteralConverter("%PARSER_ERROR[" + compositeNode.getValue() + "]");
                    } else {
                        createCompositeConverter.setFormattingInfo(compositeNode.getFormatInfo());
                        createCompositeConverter.setOptionList(compositeNode.getOptions());
                        Compiler compiler = new Compiler(compositeNode.getChildNode(), this.converterMap);
                        compiler.setContext(this.context);
                        createCompositeConverter.setChildConverter(compiler.compile());
                        converter = createCompositeConverter;
                    }
                }
                addToList(converter);
            } else {
                addToList(new LiteralConverter((String) r0.getValue()));
            }
        }
        return this.head;
    }

    CompositeConverter createCompositeConverter(CompositeNode compositeNode) {
        String str = (String) compositeNode.getValue();
        String str2 = this.converterMap.get(str);
        if (str2 == null) {
            addError("There is no conversion class registered for composite conversion word [" + str + "]");
            return null;
        }
        try {
            return (CompositeConverter) OptionHelper.instantiateByClassName(str2, CompositeConverter.class, this.context);
        } catch (Exception e) {
            addError("Failed to instantiate converter class [" + str2 + "] as a composite converter for keyword [" + str + "]", e);
            return null;
        }
    }

    DynamicConverter createConverter(SimpleKeywordNode simpleKeywordNode) {
        String str = (String) simpleKeywordNode.getValue();
        String str2 = this.converterMap.get(str);
        if (str2 == null) {
            addError("There is no conversion class registered for conversion word [" + str + "]");
            return null;
        }
        try {
            return (DynamicConverter) OptionHelper.instantiateByClassName(str2, DynamicConverter.class, this.context);
        } catch (Exception e) {
            addError("Failed to instantiate converter class [" + str2 + "] for keyword [" + str + "]", e);
            return null;
        }
    }
}
