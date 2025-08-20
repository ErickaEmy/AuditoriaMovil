package ch.qos.logback.core.pattern;

import ch.qos.logback.core.Context;
import ch.qos.logback.core.spi.ContextAware;
/* loaded from: classes.dex */
public class ConverterUtil {
    public static <E> Converter findTail(Converter converter) {
        while (converter != null) {
            Converter next = converter.getNext();
            if (next == null) {
                break;
            }
            converter = next;
        }
        return converter;
    }

    public static <E> void setContextForConverters(Context context, Converter converter) {
        while (converter != null) {
            if (converter instanceof ContextAware) {
                ((ContextAware) converter).setContext(context);
            }
            converter = converter.getNext();
        }
    }

    public static <E> void startConverters(Converter converter) {
        CompositeConverter compositeConverter;
        while (converter != null) {
            if (converter instanceof CompositeConverter) {
                CompositeConverter compositeConverter2 = (CompositeConverter) converter;
                startConverters(compositeConverter2.childConverter);
                compositeConverter = compositeConverter2;
            } else if (converter instanceof DynamicConverter) {
                compositeConverter = (DynamicConverter) converter;
            } else {
                converter = converter.getNext();
            }
            compositeConverter.start();
            converter = converter.getNext();
        }
    }
}
