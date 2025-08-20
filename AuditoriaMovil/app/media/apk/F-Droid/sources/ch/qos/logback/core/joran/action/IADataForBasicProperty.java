package ch.qos.logback.core.joran.action;

import ch.qos.logback.core.joran.util.PropertySetter;
import ch.qos.logback.core.util.AggregationType;
/* loaded from: classes.dex */
class IADataForBasicProperty {
    final AggregationType aggregationType;
    boolean inError;
    final PropertySetter parentBean;
    final String propertyName;

    /* JADX INFO: Access modifiers changed from: package-private */
    public IADataForBasicProperty(PropertySetter propertySetter, AggregationType aggregationType, String str) {
        this.parentBean = propertySetter;
        this.aggregationType = aggregationType;
        this.propertyName = str;
    }
}
