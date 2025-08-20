package org.acra.config;

import java.lang.reflect.Constructor;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ObservableProperty;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
/* compiled from: MailSenderConfigurationDsl.kt */
/* loaded from: classes2.dex */
public final class MailSenderConfigurationBuilder {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(MailSenderConfigurationBuilder.class, "enabled", "getEnabled()Ljava/lang/Boolean;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(MailSenderConfigurationBuilder.class, "reportAsFile", "getReportAsFile()Ljava/lang/Boolean;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(MailSenderConfigurationBuilder.class, "reportFileName", "getReportFileName()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(MailSenderConfigurationBuilder.class, "subject", "getSubject()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(MailSenderConfigurationBuilder.class, "body", "getBody()Ljava/lang/String;", 0))};
    private int _defaultsBitField0 = -1;
    private final ReadWriteProperty body$delegate;
    private final ReadWriteProperty enabled$delegate;
    private String mailTo;
    private final ReadWriteProperty reportAsFile$delegate;
    private final ReadWriteProperty reportFileName$delegate;
    private final ReadWriteProperty subject$delegate;

    public final MailSenderConfigurationBuilder withMailTo(String mailTo) {
        Intrinsics.checkNotNullParameter(mailTo, "mailTo");
        this.mailTo = mailTo;
        return this;
    }

    public MailSenderConfigurationBuilder() {
        Delegates delegates = Delegates.INSTANCE;
        this.enabled$delegate = new ObservableProperty(null) { // from class: org.acra.config.MailSenderConfigurationBuilder$special$$inlined$observable$1
            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(KProperty property, Object obj, Object obj2) {
                int i;
                Intrinsics.checkNotNullParameter(property, "property");
                Boolean bool = (Boolean) obj2;
                Boolean bool2 = (Boolean) obj;
                MailSenderConfigurationBuilder mailSenderConfigurationBuilder = this;
                i = mailSenderConfigurationBuilder._defaultsBitField0;
                mailSenderConfigurationBuilder._defaultsBitField0 = i & (-2);
            }
        };
        this.reportAsFile$delegate = new ObservableProperty(null) { // from class: org.acra.config.MailSenderConfigurationBuilder$special$$inlined$observable$2
            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(KProperty property, Object obj, Object obj2) {
                int i;
                Intrinsics.checkNotNullParameter(property, "property");
                Boolean bool = (Boolean) obj2;
                Boolean bool2 = (Boolean) obj;
                MailSenderConfigurationBuilder mailSenderConfigurationBuilder = this;
                i = mailSenderConfigurationBuilder._defaultsBitField0;
                mailSenderConfigurationBuilder._defaultsBitField0 = i & (-5);
            }
        };
        this.reportFileName$delegate = new ObservableProperty(null) { // from class: org.acra.config.MailSenderConfigurationBuilder$special$$inlined$observable$3
            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(KProperty property, Object obj, Object obj2) {
                int i;
                Intrinsics.checkNotNullParameter(property, "property");
                String str = (String) obj2;
                String str2 = (String) obj;
                MailSenderConfigurationBuilder mailSenderConfigurationBuilder = this;
                i = mailSenderConfigurationBuilder._defaultsBitField0;
                mailSenderConfigurationBuilder._defaultsBitField0 = i & (-9);
            }
        };
        this.subject$delegate = new ObservableProperty(null) { // from class: org.acra.config.MailSenderConfigurationBuilder$special$$inlined$observable$4
            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(KProperty property, Object obj, Object obj2) {
                int i;
                Intrinsics.checkNotNullParameter(property, "property");
                String str = (String) obj2;
                String str2 = (String) obj;
                MailSenderConfigurationBuilder mailSenderConfigurationBuilder = this;
                i = mailSenderConfigurationBuilder._defaultsBitField0;
                mailSenderConfigurationBuilder._defaultsBitField0 = i & (-17);
            }
        };
        this.body$delegate = new ObservableProperty(null) { // from class: org.acra.config.MailSenderConfigurationBuilder$special$$inlined$observable$5
            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(KProperty property, Object obj, Object obj2) {
                int i;
                Intrinsics.checkNotNullParameter(property, "property");
                String str = (String) obj2;
                String str2 = (String) obj;
                MailSenderConfigurationBuilder mailSenderConfigurationBuilder = this;
                i = mailSenderConfigurationBuilder._defaultsBitField0;
                mailSenderConfigurationBuilder._defaultsBitField0 = i & (-33);
            }
        };
    }

    public final Boolean getEnabled() {
        return (Boolean) this.enabled$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final Boolean getReportAsFile() {
        return (Boolean) this.reportAsFile$delegate.getValue(this, $$delegatedProperties[1]);
    }

    public final String getReportFileName() {
        return (String) this.reportFileName$delegate.getValue(this, $$delegatedProperties[2]);
    }

    public final void setReportFileName(String str) {
        this.reportFileName$delegate.setValue(this, $$delegatedProperties[2], str);
    }

    public final String getSubject() {
        return (String) this.subject$delegate.getValue(this, $$delegatedProperties[3]);
    }

    public final void setSubject(String str) {
        this.subject$delegate.setValue(this, $$delegatedProperties[3], str);
    }

    public final String getBody() {
        return (String) this.body$delegate.getValue(this, $$delegatedProperties[4]);
    }

    public final MailSenderConfigurationBuilder withReportFileName(String reportFileName) {
        Intrinsics.checkNotNullParameter(reportFileName, "reportFileName");
        setReportFileName(reportFileName);
        return this;
    }

    public final MailSenderConfigurationBuilder withSubject(String str) {
        setSubject(str);
        return this;
    }

    public final MailSenderConfiguration build() {
        if (this.mailTo == null) {
            throw new IllegalStateException("mailTo must be assigned.".toString());
        }
        Class cls = Boolean.TYPE;
        Constructor constructor = MailSenderConfiguration.class.getConstructor(cls, String.class, cls, String.class, String.class, String.class, Integer.TYPE, DefaultConstructorMarker.class);
        Object[] objArr = new Object[8];
        Boolean enabled = getEnabled();
        objArr[0] = Boolean.valueOf(enabled != null ? enabled.booleanValue() : false);
        objArr[1] = this.mailTo;
        Boolean reportAsFile = getReportAsFile();
        objArr[2] = Boolean.valueOf(reportAsFile != null ? reportAsFile.booleanValue() : false);
        objArr[3] = getReportFileName();
        objArr[4] = getSubject();
        objArr[5] = getBody();
        objArr[6] = Integer.valueOf(this._defaultsBitField0);
        objArr[7] = null;
        Object newInstance = constructor.newInstance(objArr);
        Intrinsics.checkNotNullExpressionValue(newInstance, "newInstance(...)");
        return (MailSenderConfiguration) newInstance;
    }
}
