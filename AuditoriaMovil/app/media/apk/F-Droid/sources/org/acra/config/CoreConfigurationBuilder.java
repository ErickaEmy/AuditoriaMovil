package org.acra.config;

import java.lang.reflect.Constructor;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ObservableProperty;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import org.acra.ReportField;
import org.acra.data.StringFormat;
import org.acra.file.Directory;
import org.acra.plugins.PluginLoader;
/* compiled from: CoreConfigurationDsl.kt */
/* loaded from: classes2.dex */
public final class CoreConfigurationBuilder {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(CoreConfigurationBuilder.class, "sharedPreferencesName", "getSharedPreferencesName()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(CoreConfigurationBuilder.class, "includeDropBoxSystemTags", "getIncludeDropBoxSystemTags()Ljava/lang/Boolean;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(CoreConfigurationBuilder.class, "additionalDropBoxTags", "getAdditionalDropBoxTags()Ljava/util/List;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(CoreConfigurationBuilder.class, "dropboxCollectionMinutes", "getDropboxCollectionMinutes()Ljava/lang/Integer;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(CoreConfigurationBuilder.class, "logcatArguments", "getLogcatArguments()Ljava/util/List;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(CoreConfigurationBuilder.class, "reportContent", "getReportContent()Ljava/util/List;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(CoreConfigurationBuilder.class, "deleteUnapprovedReportsOnApplicationStart", "getDeleteUnapprovedReportsOnApplicationStart()Ljava/lang/Boolean;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(CoreConfigurationBuilder.class, "alsoReportToAndroidFramework", "getAlsoReportToAndroidFramework()Ljava/lang/Boolean;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(CoreConfigurationBuilder.class, "additionalSharedPreferences", "getAdditionalSharedPreferences()Ljava/util/List;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(CoreConfigurationBuilder.class, "logcatFilterByPid", "getLogcatFilterByPid()Ljava/lang/Boolean;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(CoreConfigurationBuilder.class, "logcatReadNonBlocking", "getLogcatReadNonBlocking()Ljava/lang/Boolean;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(CoreConfigurationBuilder.class, "sendReportsInDevMode", "getSendReportsInDevMode()Ljava/lang/Boolean;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(CoreConfigurationBuilder.class, "excludeMatchingSharedPreferencesKeys", "getExcludeMatchingSharedPreferencesKeys()Ljava/util/List;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(CoreConfigurationBuilder.class, "excludeMatchingSettingsKeys", "getExcludeMatchingSettingsKeys()Ljava/util/List;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(CoreConfigurationBuilder.class, "buildConfigClass", "getBuildConfigClass()Ljava/lang/Class;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(CoreConfigurationBuilder.class, "applicationLogFile", "getApplicationLogFile()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(CoreConfigurationBuilder.class, "applicationLogFileLines", "getApplicationLogFileLines()Ljava/lang/Integer;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(CoreConfigurationBuilder.class, "applicationLogFileDir", "getApplicationLogFileDir()Lorg/acra/file/Directory;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(CoreConfigurationBuilder.class, "retryPolicyClass", "getRetryPolicyClass()Ljava/lang/Class;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(CoreConfigurationBuilder.class, "stopServicesOnCrash", "getStopServicesOnCrash()Ljava/lang/Boolean;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(CoreConfigurationBuilder.class, "attachmentUris", "getAttachmentUris()Ljava/util/List;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(CoreConfigurationBuilder.class, "attachmentUriProvider", "getAttachmentUriProvider()Ljava/lang/Class;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(CoreConfigurationBuilder.class, "reportSendSuccessToast", "getReportSendSuccessToast()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(CoreConfigurationBuilder.class, "reportSendFailureToast", "getReportSendFailureToast()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(CoreConfigurationBuilder.class, "reportFormat", "getReportFormat()Lorg/acra/data/StringFormat;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(CoreConfigurationBuilder.class, "parallel", "getParallel()Ljava/lang/Boolean;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(CoreConfigurationBuilder.class, "pluginLoader", "getPluginLoader()Lorg/acra/plugins/PluginLoader;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(CoreConfigurationBuilder.class, "pluginConfigurations", "getPluginConfigurations()Ljava/util/List;", 0))};
    private int _defaultsBitField0 = -1;
    private final ReadWriteProperty additionalDropBoxTags$delegate;
    private final ReadWriteProperty additionalSharedPreferences$delegate;
    private final ReadWriteProperty alsoReportToAndroidFramework$delegate;
    private final ReadWriteProperty applicationLogFile$delegate;
    private final ReadWriteProperty applicationLogFileDir$delegate;
    private final ReadWriteProperty applicationLogFileLines$delegate;
    private final ReadWriteProperty attachmentUriProvider$delegate;
    private final ReadWriteProperty attachmentUris$delegate;
    private final ReadWriteProperty buildConfigClass$delegate;
    private final ReadWriteProperty deleteUnapprovedReportsOnApplicationStart$delegate;
    private final ReadWriteProperty dropboxCollectionMinutes$delegate;
    private final ReadWriteProperty excludeMatchingSettingsKeys$delegate;
    private final ReadWriteProperty excludeMatchingSharedPreferencesKeys$delegate;
    private final ReadWriteProperty includeDropBoxSystemTags$delegate;
    private final ReadWriteProperty logcatArguments$delegate;
    private final ReadWriteProperty logcatFilterByPid$delegate;
    private final ReadWriteProperty logcatReadNonBlocking$delegate;
    private final ReadWriteProperty parallel$delegate;
    private final ReadWriteProperty pluginConfigurations$delegate;
    private final ReadWriteProperty pluginLoader$delegate;
    private final ReadWriteProperty reportContent$delegate;
    private final ReadWriteProperty reportFormat$delegate;
    private final ReadWriteProperty reportSendFailureToast$delegate;
    private final ReadWriteProperty reportSendSuccessToast$delegate;
    private final ReadWriteProperty retryPolicyClass$delegate;
    private final ReadWriteProperty sendReportsInDevMode$delegate;
    private final ReadWriteProperty sharedPreferencesName$delegate;
    private final ReadWriteProperty stopServicesOnCrash$delegate;

    public CoreConfigurationBuilder() {
        Delegates delegates = Delegates.INSTANCE;
        this.sharedPreferencesName$delegate = new ObservableProperty(null) { // from class: org.acra.config.CoreConfigurationBuilder$special$$inlined$observable$1
            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(KProperty property, Object obj, Object obj2) {
                int i;
                Intrinsics.checkNotNullParameter(property, "property");
                String str = (String) obj2;
                String str2 = (String) obj;
                CoreConfigurationBuilder coreConfigurationBuilder = this;
                i = coreConfigurationBuilder._defaultsBitField0;
                coreConfigurationBuilder._defaultsBitField0 = i & (-2);
            }
        };
        this.includeDropBoxSystemTags$delegate = new ObservableProperty(null) { // from class: org.acra.config.CoreConfigurationBuilder$special$$inlined$observable$2
            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(KProperty property, Object obj, Object obj2) {
                int i;
                Intrinsics.checkNotNullParameter(property, "property");
                Boolean bool = (Boolean) obj2;
                Boolean bool2 = (Boolean) obj;
                CoreConfigurationBuilder coreConfigurationBuilder = this;
                i = coreConfigurationBuilder._defaultsBitField0;
                coreConfigurationBuilder._defaultsBitField0 = i & (-3);
            }
        };
        this.additionalDropBoxTags$delegate = new ObservableProperty(null) { // from class: org.acra.config.CoreConfigurationBuilder$special$$inlined$observable$3
            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(KProperty property, Object obj, Object obj2) {
                int i;
                Intrinsics.checkNotNullParameter(property, "property");
                List list = (List) obj2;
                List list2 = (List) obj;
                CoreConfigurationBuilder coreConfigurationBuilder = this;
                i = coreConfigurationBuilder._defaultsBitField0;
                coreConfigurationBuilder._defaultsBitField0 = i & (-5);
            }
        };
        this.dropboxCollectionMinutes$delegate = new ObservableProperty(null) { // from class: org.acra.config.CoreConfigurationBuilder$special$$inlined$observable$4
            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(KProperty property, Object obj, Object obj2) {
                int i;
                Intrinsics.checkNotNullParameter(property, "property");
                Integer num = (Integer) obj2;
                Integer num2 = (Integer) obj;
                CoreConfigurationBuilder coreConfigurationBuilder = this;
                i = coreConfigurationBuilder._defaultsBitField0;
                coreConfigurationBuilder._defaultsBitField0 = i & (-9);
            }
        };
        this.logcatArguments$delegate = new ObservableProperty(null) { // from class: org.acra.config.CoreConfigurationBuilder$special$$inlined$observable$5
            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(KProperty property, Object obj, Object obj2) {
                int i;
                Intrinsics.checkNotNullParameter(property, "property");
                List list = (List) obj2;
                List list2 = (List) obj;
                CoreConfigurationBuilder coreConfigurationBuilder = this;
                i = coreConfigurationBuilder._defaultsBitField0;
                coreConfigurationBuilder._defaultsBitField0 = i & (-17);
            }
        };
        this.reportContent$delegate = new ObservableProperty(null) { // from class: org.acra.config.CoreConfigurationBuilder$special$$inlined$observable$6
            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(KProperty property, Object obj, Object obj2) {
                int i;
                Intrinsics.checkNotNullParameter(property, "property");
                List list = (List) obj2;
                List list2 = (List) obj;
                CoreConfigurationBuilder coreConfigurationBuilder = this;
                i = coreConfigurationBuilder._defaultsBitField0;
                coreConfigurationBuilder._defaultsBitField0 = i & (-33);
            }
        };
        this.deleteUnapprovedReportsOnApplicationStart$delegate = new ObservableProperty(null) { // from class: org.acra.config.CoreConfigurationBuilder$special$$inlined$observable$7
            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(KProperty property, Object obj, Object obj2) {
                int i;
                Intrinsics.checkNotNullParameter(property, "property");
                Boolean bool = (Boolean) obj2;
                Boolean bool2 = (Boolean) obj;
                CoreConfigurationBuilder coreConfigurationBuilder = this;
                i = coreConfigurationBuilder._defaultsBitField0;
                coreConfigurationBuilder._defaultsBitField0 = i & (-65);
            }
        };
        this.alsoReportToAndroidFramework$delegate = new ObservableProperty(null) { // from class: org.acra.config.CoreConfigurationBuilder$special$$inlined$observable$8
            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(KProperty property, Object obj, Object obj2) {
                int i;
                Intrinsics.checkNotNullParameter(property, "property");
                Boolean bool = (Boolean) obj2;
                Boolean bool2 = (Boolean) obj;
                CoreConfigurationBuilder coreConfigurationBuilder = this;
                i = coreConfigurationBuilder._defaultsBitField0;
                coreConfigurationBuilder._defaultsBitField0 = i & (-129);
            }
        };
        this.additionalSharedPreferences$delegate = new ObservableProperty(null) { // from class: org.acra.config.CoreConfigurationBuilder$special$$inlined$observable$9
            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(KProperty property, Object obj, Object obj2) {
                int i;
                Intrinsics.checkNotNullParameter(property, "property");
                List list = (List) obj2;
                List list2 = (List) obj;
                CoreConfigurationBuilder coreConfigurationBuilder = this;
                i = coreConfigurationBuilder._defaultsBitField0;
                coreConfigurationBuilder._defaultsBitField0 = i & (-257);
            }
        };
        this.logcatFilterByPid$delegate = new ObservableProperty(null) { // from class: org.acra.config.CoreConfigurationBuilder$special$$inlined$observable$10
            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(KProperty property, Object obj, Object obj2) {
                int i;
                Intrinsics.checkNotNullParameter(property, "property");
                Boolean bool = (Boolean) obj2;
                Boolean bool2 = (Boolean) obj;
                CoreConfigurationBuilder coreConfigurationBuilder = this;
                i = coreConfigurationBuilder._defaultsBitField0;
                coreConfigurationBuilder._defaultsBitField0 = i & (-513);
            }
        };
        this.logcatReadNonBlocking$delegate = new ObservableProperty(null) { // from class: org.acra.config.CoreConfigurationBuilder$special$$inlined$observable$11
            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(KProperty property, Object obj, Object obj2) {
                int i;
                Intrinsics.checkNotNullParameter(property, "property");
                Boolean bool = (Boolean) obj2;
                Boolean bool2 = (Boolean) obj;
                CoreConfigurationBuilder coreConfigurationBuilder = this;
                i = coreConfigurationBuilder._defaultsBitField0;
                coreConfigurationBuilder._defaultsBitField0 = i & (-1025);
            }
        };
        this.sendReportsInDevMode$delegate = new ObservableProperty(null) { // from class: org.acra.config.CoreConfigurationBuilder$special$$inlined$observable$12
            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(KProperty property, Object obj, Object obj2) {
                int i;
                Intrinsics.checkNotNullParameter(property, "property");
                Boolean bool = (Boolean) obj2;
                Boolean bool2 = (Boolean) obj;
                CoreConfigurationBuilder coreConfigurationBuilder = this;
                i = coreConfigurationBuilder._defaultsBitField0;
                coreConfigurationBuilder._defaultsBitField0 = i & (-2049);
            }
        };
        this.excludeMatchingSharedPreferencesKeys$delegate = new ObservableProperty(null) { // from class: org.acra.config.CoreConfigurationBuilder$special$$inlined$observable$13
            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(KProperty property, Object obj, Object obj2) {
                int i;
                Intrinsics.checkNotNullParameter(property, "property");
                List list = (List) obj2;
                List list2 = (List) obj;
                CoreConfigurationBuilder coreConfigurationBuilder = this;
                i = coreConfigurationBuilder._defaultsBitField0;
                coreConfigurationBuilder._defaultsBitField0 = i & (-4097);
            }
        };
        this.excludeMatchingSettingsKeys$delegate = new ObservableProperty(null) { // from class: org.acra.config.CoreConfigurationBuilder$special$$inlined$observable$14
            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(KProperty property, Object obj, Object obj2) {
                int i;
                Intrinsics.checkNotNullParameter(property, "property");
                List list = (List) obj2;
                List list2 = (List) obj;
                CoreConfigurationBuilder coreConfigurationBuilder = this;
                i = coreConfigurationBuilder._defaultsBitField0;
                coreConfigurationBuilder._defaultsBitField0 = i & (-8193);
            }
        };
        this.buildConfigClass$delegate = new ObservableProperty(null) { // from class: org.acra.config.CoreConfigurationBuilder$special$$inlined$observable$15
            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(KProperty property, Object obj, Object obj2) {
                int i;
                Intrinsics.checkNotNullParameter(property, "property");
                Class cls = (Class) obj2;
                Class cls2 = (Class) obj;
                CoreConfigurationBuilder coreConfigurationBuilder = this;
                i = coreConfigurationBuilder._defaultsBitField0;
                coreConfigurationBuilder._defaultsBitField0 = i & (-16385);
            }
        };
        this.applicationLogFile$delegate = new ObservableProperty(null) { // from class: org.acra.config.CoreConfigurationBuilder$special$$inlined$observable$16
            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(KProperty property, Object obj, Object obj2) {
                int i;
                Intrinsics.checkNotNullParameter(property, "property");
                String str = (String) obj2;
                String str2 = (String) obj;
                CoreConfigurationBuilder coreConfigurationBuilder = this;
                i = coreConfigurationBuilder._defaultsBitField0;
                coreConfigurationBuilder._defaultsBitField0 = i & (-32769);
            }
        };
        this.applicationLogFileLines$delegate = new ObservableProperty(null) { // from class: org.acra.config.CoreConfigurationBuilder$special$$inlined$observable$17
            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(KProperty property, Object obj, Object obj2) {
                int i;
                Intrinsics.checkNotNullParameter(property, "property");
                Integer num = (Integer) obj2;
                Integer num2 = (Integer) obj;
                CoreConfigurationBuilder coreConfigurationBuilder = this;
                i = coreConfigurationBuilder._defaultsBitField0;
                coreConfigurationBuilder._defaultsBitField0 = i & (-65537);
            }
        };
        this.applicationLogFileDir$delegate = new ObservableProperty(null) { // from class: org.acra.config.CoreConfigurationBuilder$special$$inlined$observable$18
            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(KProperty property, Object obj, Object obj2) {
                int i;
                Intrinsics.checkNotNullParameter(property, "property");
                Directory directory = (Directory) obj2;
                Directory directory2 = (Directory) obj;
                CoreConfigurationBuilder coreConfigurationBuilder = this;
                i = coreConfigurationBuilder._defaultsBitField0;
                coreConfigurationBuilder._defaultsBitField0 = i & (-131073);
            }
        };
        this.retryPolicyClass$delegate = new ObservableProperty(null) { // from class: org.acra.config.CoreConfigurationBuilder$special$$inlined$observable$19
            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(KProperty property, Object obj, Object obj2) {
                int i;
                Intrinsics.checkNotNullParameter(property, "property");
                Class cls = (Class) obj2;
                Class cls2 = (Class) obj;
                CoreConfigurationBuilder coreConfigurationBuilder = this;
                i = coreConfigurationBuilder._defaultsBitField0;
                coreConfigurationBuilder._defaultsBitField0 = i & (-262145);
            }
        };
        this.stopServicesOnCrash$delegate = new ObservableProperty(null) { // from class: org.acra.config.CoreConfigurationBuilder$special$$inlined$observable$20
            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(KProperty property, Object obj, Object obj2) {
                int i;
                Intrinsics.checkNotNullParameter(property, "property");
                Boolean bool = (Boolean) obj2;
                Boolean bool2 = (Boolean) obj;
                CoreConfigurationBuilder coreConfigurationBuilder = this;
                i = coreConfigurationBuilder._defaultsBitField0;
                coreConfigurationBuilder._defaultsBitField0 = i & (-524289);
            }
        };
        this.attachmentUris$delegate = new ObservableProperty(null) { // from class: org.acra.config.CoreConfigurationBuilder$special$$inlined$observable$21
            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(KProperty property, Object obj, Object obj2) {
                int i;
                Intrinsics.checkNotNullParameter(property, "property");
                List list = (List) obj2;
                List list2 = (List) obj;
                CoreConfigurationBuilder coreConfigurationBuilder = this;
                i = coreConfigurationBuilder._defaultsBitField0;
                coreConfigurationBuilder._defaultsBitField0 = i & (-1048577);
            }
        };
        this.attachmentUriProvider$delegate = new ObservableProperty(null) { // from class: org.acra.config.CoreConfigurationBuilder$special$$inlined$observable$22
            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(KProperty property, Object obj, Object obj2) {
                int i;
                Intrinsics.checkNotNullParameter(property, "property");
                Class cls = (Class) obj2;
                Class cls2 = (Class) obj;
                CoreConfigurationBuilder coreConfigurationBuilder = this;
                i = coreConfigurationBuilder._defaultsBitField0;
                coreConfigurationBuilder._defaultsBitField0 = i & (-2097153);
            }
        };
        this.reportSendSuccessToast$delegate = new ObservableProperty(null) { // from class: org.acra.config.CoreConfigurationBuilder$special$$inlined$observable$23
            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(KProperty property, Object obj, Object obj2) {
                int i;
                Intrinsics.checkNotNullParameter(property, "property");
                String str = (String) obj2;
                String str2 = (String) obj;
                CoreConfigurationBuilder coreConfigurationBuilder = this;
                i = coreConfigurationBuilder._defaultsBitField0;
                coreConfigurationBuilder._defaultsBitField0 = i & (-4194305);
            }
        };
        this.reportSendFailureToast$delegate = new ObservableProperty(null) { // from class: org.acra.config.CoreConfigurationBuilder$special$$inlined$observable$24
            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(KProperty property, Object obj, Object obj2) {
                int i;
                Intrinsics.checkNotNullParameter(property, "property");
                String str = (String) obj2;
                String str2 = (String) obj;
                CoreConfigurationBuilder coreConfigurationBuilder = this;
                i = coreConfigurationBuilder._defaultsBitField0;
                coreConfigurationBuilder._defaultsBitField0 = i & (-8388609);
            }
        };
        this.reportFormat$delegate = new ObservableProperty(null) { // from class: org.acra.config.CoreConfigurationBuilder$special$$inlined$observable$25
            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(KProperty property, Object obj, Object obj2) {
                int i;
                Intrinsics.checkNotNullParameter(property, "property");
                StringFormat stringFormat = (StringFormat) obj2;
                StringFormat stringFormat2 = (StringFormat) obj;
                CoreConfigurationBuilder coreConfigurationBuilder = this;
                i = coreConfigurationBuilder._defaultsBitField0;
                coreConfigurationBuilder._defaultsBitField0 = i & (-16777217);
            }
        };
        this.parallel$delegate = new ObservableProperty(null) { // from class: org.acra.config.CoreConfigurationBuilder$special$$inlined$observable$26
            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(KProperty property, Object obj, Object obj2) {
                int i;
                Intrinsics.checkNotNullParameter(property, "property");
                Boolean bool = (Boolean) obj2;
                Boolean bool2 = (Boolean) obj;
                CoreConfigurationBuilder coreConfigurationBuilder = this;
                i = coreConfigurationBuilder._defaultsBitField0;
                coreConfigurationBuilder._defaultsBitField0 = i & (-33554433);
            }
        };
        this.pluginLoader$delegate = new ObservableProperty(null) { // from class: org.acra.config.CoreConfigurationBuilder$special$$inlined$observable$27
            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(KProperty property, Object obj, Object obj2) {
                int i;
                Intrinsics.checkNotNullParameter(property, "property");
                PluginLoader pluginLoader = (PluginLoader) obj2;
                PluginLoader pluginLoader2 = (PluginLoader) obj;
                CoreConfigurationBuilder coreConfigurationBuilder = this;
                i = coreConfigurationBuilder._defaultsBitField0;
                coreConfigurationBuilder._defaultsBitField0 = i & (-67108865);
            }
        };
        this.pluginConfigurations$delegate = new ObservableProperty(null) { // from class: org.acra.config.CoreConfigurationBuilder$special$$inlined$observable$28
            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(KProperty property, Object obj, Object obj2) {
                int i;
                Intrinsics.checkNotNullParameter(property, "property");
                List list = (List) obj2;
                List list2 = (List) obj;
                CoreConfigurationBuilder coreConfigurationBuilder = this;
                i = coreConfigurationBuilder._defaultsBitField0;
                coreConfigurationBuilder._defaultsBitField0 = i & (-134217729);
            }
        };
    }

    public final String getSharedPreferencesName() {
        return (String) this.sharedPreferencesName$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final Boolean getIncludeDropBoxSystemTags() {
        return (Boolean) this.includeDropBoxSystemTags$delegate.getValue(this, $$delegatedProperties[1]);
    }

    public final List getAdditionalDropBoxTags() {
        return (List) this.additionalDropBoxTags$delegate.getValue(this, $$delegatedProperties[2]);
    }

    public final Integer getDropboxCollectionMinutes() {
        return (Integer) this.dropboxCollectionMinutes$delegate.getValue(this, $$delegatedProperties[3]);
    }

    public final List getLogcatArguments() {
        return (List) this.logcatArguments$delegate.getValue(this, $$delegatedProperties[4]);
    }

    public final List getReportContent() {
        return (List) this.reportContent$delegate.getValue(this, $$delegatedProperties[5]);
    }

    public final void setReportContent(List list) {
        this.reportContent$delegate.setValue(this, $$delegatedProperties[5], list);
    }

    public final Boolean getDeleteUnapprovedReportsOnApplicationStart() {
        return (Boolean) this.deleteUnapprovedReportsOnApplicationStart$delegate.getValue(this, $$delegatedProperties[6]);
    }

    public final Boolean getAlsoReportToAndroidFramework() {
        return (Boolean) this.alsoReportToAndroidFramework$delegate.getValue(this, $$delegatedProperties[7]);
    }

    public final List getAdditionalSharedPreferences() {
        return (List) this.additionalSharedPreferences$delegate.getValue(this, $$delegatedProperties[8]);
    }

    public final Boolean getLogcatFilterByPid() {
        return (Boolean) this.logcatFilterByPid$delegate.getValue(this, $$delegatedProperties[9]);
    }

    public final Boolean getLogcatReadNonBlocking() {
        return (Boolean) this.logcatReadNonBlocking$delegate.getValue(this, $$delegatedProperties[10]);
    }

    public final Boolean getSendReportsInDevMode() {
        return (Boolean) this.sendReportsInDevMode$delegate.getValue(this, $$delegatedProperties[11]);
    }

    public final List getExcludeMatchingSharedPreferencesKeys() {
        return (List) this.excludeMatchingSharedPreferencesKeys$delegate.getValue(this, $$delegatedProperties[12]);
    }

    public final List getExcludeMatchingSettingsKeys() {
        return (List) this.excludeMatchingSettingsKeys$delegate.getValue(this, $$delegatedProperties[13]);
    }

    public final Class getBuildConfigClass() {
        return (Class) this.buildConfigClass$delegate.getValue(this, $$delegatedProperties[14]);
    }

    public final String getApplicationLogFile() {
        return (String) this.applicationLogFile$delegate.getValue(this, $$delegatedProperties[15]);
    }

    public final Integer getApplicationLogFileLines() {
        return (Integer) this.applicationLogFileLines$delegate.getValue(this, $$delegatedProperties[16]);
    }

    public final Directory getApplicationLogFileDir() {
        return (Directory) this.applicationLogFileDir$delegate.getValue(this, $$delegatedProperties[17]);
    }

    public final Class getRetryPolicyClass() {
        return (Class) this.retryPolicyClass$delegate.getValue(this, $$delegatedProperties[18]);
    }

    public final Boolean getStopServicesOnCrash() {
        return (Boolean) this.stopServicesOnCrash$delegate.getValue(this, $$delegatedProperties[19]);
    }

    public final List getAttachmentUris() {
        return (List) this.attachmentUris$delegate.getValue(this, $$delegatedProperties[20]);
    }

    public final Class getAttachmentUriProvider() {
        return (Class) this.attachmentUriProvider$delegate.getValue(this, $$delegatedProperties[21]);
    }

    public final String getReportSendSuccessToast() {
        return (String) this.reportSendSuccessToast$delegate.getValue(this, $$delegatedProperties[22]);
    }

    public final String getReportSendFailureToast() {
        return (String) this.reportSendFailureToast$delegate.getValue(this, $$delegatedProperties[23]);
    }

    public final StringFormat getReportFormat() {
        return (StringFormat) this.reportFormat$delegate.getValue(this, $$delegatedProperties[24]);
    }

    public final Boolean getParallel() {
        return (Boolean) this.parallel$delegate.getValue(this, $$delegatedProperties[25]);
    }

    public final PluginLoader getPluginLoader() {
        return (PluginLoader) this.pluginLoader$delegate.getValue(this, $$delegatedProperties[26]);
    }

    public final List getPluginConfigurations() {
        return (List) this.pluginConfigurations$delegate.getValue(this, $$delegatedProperties[27]);
    }

    public final void setPluginConfigurations(List list) {
        this.pluginConfigurations$delegate.setValue(this, $$delegatedProperties[27], list);
    }

    public final CoreConfigurationBuilder withReportContent(ReportField... reportContent) {
        List list;
        Intrinsics.checkNotNullParameter(reportContent, "reportContent");
        list = ArraysKt___ArraysKt.toList(reportContent);
        setReportContent(list);
        return this;
    }

    public final CoreConfigurationBuilder withPluginConfigurations(Configuration... pluginConfigurations) {
        List list;
        Intrinsics.checkNotNullParameter(pluginConfigurations, "pluginConfigurations");
        list = ArraysKt___ArraysKt.toList(pluginConfigurations);
        setPluginConfigurations(list);
        return this;
    }

    public final CoreConfiguration build() {
        Class cls = Boolean.TYPE;
        Class cls2 = Integer.TYPE;
        Constructor constructor = CoreConfiguration.class.getConstructor(String.class, cls, List.class, cls2, List.class, List.class, cls, cls, List.class, cls, cls, cls, List.class, List.class, Class.class, String.class, cls2, Directory.class, Class.class, cls, List.class, Class.class, String.class, String.class, StringFormat.class, cls, PluginLoader.class, List.class, cls2, DefaultConstructorMarker.class);
        Object[] objArr = new Object[30];
        objArr[0] = getSharedPreferencesName();
        Boolean includeDropBoxSystemTags = getIncludeDropBoxSystemTags();
        objArr[1] = Boolean.valueOf(includeDropBoxSystemTags != null ? includeDropBoxSystemTags.booleanValue() : false);
        objArr[2] = getAdditionalDropBoxTags();
        Integer dropboxCollectionMinutes = getDropboxCollectionMinutes();
        objArr[3] = Integer.valueOf(dropboxCollectionMinutes != null ? dropboxCollectionMinutes.intValue() : 0);
        objArr[4] = getLogcatArguments();
        objArr[5] = getReportContent();
        Boolean deleteUnapprovedReportsOnApplicationStart = getDeleteUnapprovedReportsOnApplicationStart();
        objArr[6] = Boolean.valueOf(deleteUnapprovedReportsOnApplicationStart != null ? deleteUnapprovedReportsOnApplicationStart.booleanValue() : false);
        Boolean alsoReportToAndroidFramework = getAlsoReportToAndroidFramework();
        objArr[7] = Boolean.valueOf(alsoReportToAndroidFramework != null ? alsoReportToAndroidFramework.booleanValue() : false);
        objArr[8] = getAdditionalSharedPreferences();
        Boolean logcatFilterByPid = getLogcatFilterByPid();
        objArr[9] = Boolean.valueOf(logcatFilterByPid != null ? logcatFilterByPid.booleanValue() : false);
        Boolean logcatReadNonBlocking = getLogcatReadNonBlocking();
        objArr[10] = Boolean.valueOf(logcatReadNonBlocking != null ? logcatReadNonBlocking.booleanValue() : false);
        Boolean sendReportsInDevMode = getSendReportsInDevMode();
        objArr[11] = Boolean.valueOf(sendReportsInDevMode != null ? sendReportsInDevMode.booleanValue() : false);
        objArr[12] = getExcludeMatchingSharedPreferencesKeys();
        objArr[13] = getExcludeMatchingSettingsKeys();
        objArr[14] = getBuildConfigClass();
        objArr[15] = getApplicationLogFile();
        Integer applicationLogFileLines = getApplicationLogFileLines();
        objArr[16] = Integer.valueOf(applicationLogFileLines != null ? applicationLogFileLines.intValue() : 0);
        objArr[17] = getApplicationLogFileDir();
        objArr[18] = getRetryPolicyClass();
        Boolean stopServicesOnCrash = getStopServicesOnCrash();
        objArr[19] = Boolean.valueOf(stopServicesOnCrash != null ? stopServicesOnCrash.booleanValue() : false);
        objArr[20] = getAttachmentUris();
        objArr[21] = getAttachmentUriProvider();
        objArr[22] = getReportSendSuccessToast();
        objArr[23] = getReportSendFailureToast();
        objArr[24] = getReportFormat();
        Boolean parallel = getParallel();
        objArr[25] = Boolean.valueOf(parallel != null ? parallel.booleanValue() : false);
        objArr[26] = getPluginLoader();
        objArr[27] = getPluginConfigurations();
        objArr[28] = Integer.valueOf(this._defaultsBitField0);
        objArr[29] = null;
        Object newInstance = constructor.newInstance(objArr);
        Intrinsics.checkNotNullExpressionValue(newInstance, "newInstance(...)");
        return (CoreConfiguration) newInstance;
    }
}
