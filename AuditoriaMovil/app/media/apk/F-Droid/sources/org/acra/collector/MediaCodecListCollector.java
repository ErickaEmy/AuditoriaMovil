package org.acra.collector;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.util.SparseArray;
import ch.qos.logback.core.CoreConstants;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.acra.ReportField;
import org.acra.builder.ReportBuilder;
import org.acra.collector.Collector;
import org.acra.config.CoreConfiguration;
import org.acra.data.CrashReportData;
import org.acra.plugins.Plugin;
import org.fdroid.fdroid.nearby.peers.BonjourPeer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: MediaCodecListCollector.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0017\u0018\u0000 )2\u00020\u0001:\u0002()B\u0005¢\u0006\u0002\u0010\u0002J0\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0005H\u0013J\b\u0010\"\u001a\u00020\u001eH\u0013J\u0012\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010\u001f\u001a\u00020 H\u0013J\b\u0010%\u001a\u00020\u0012H\u0012J(\u0010&\u001a\u00020'2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u001aH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0092\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0092\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0092\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0092\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0092\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0092\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0092\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0092\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006*"}, d2 = {"Lorg/acra/collector/MediaCodecListCollector;", "Lorg/acra/collector/BaseReportFieldCollector;", "()V", "mAACProfileValues", "Landroid/util/SparseArray;", "", "mAVCLevelValues", "mAVCProfileValues", "mColorFormatValues", "mH263LevelValues", "mH263ProfileValues", "mMPEG4LevelValues", "mMPEG4ProfileValues", "order", "Lorg/acra/collector/Collector$Order;", "getOrder", "()Lorg/acra/collector/Collector$Order;", "collect", "", "reportField", "Lorg/acra/ReportField;", CoreConstants.CONTEXT_SCOPE_VALUE, "Landroid/content/Context;", "config", "Lorg/acra/config/CoreConfiguration;", "reportBuilder", "Lorg/acra/builder/ReportBuilder;", "target", "Lorg/acra/data/CrashReportData;", "collectCapabilitiesForType", "Lorg/json/JSONObject;", "codecInfo", "Landroid/media/MediaCodecInfo;", BonjourPeer.TYPE, "collectMediaCodecList", "identifyCodecType", "Lorg/acra/collector/MediaCodecListCollector$CodecType;", "prepare", "shouldCollect", "", "CodecType", "Companion", "acra-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public class MediaCodecListCollector extends BaseReportFieldCollector {
    private static final String COLOR_FORMAT_PREFIX = "COLOR_";
    private final SparseArray<String> mAACProfileValues;
    private final SparseArray<String> mAVCLevelValues;
    private final SparseArray<String> mAVCProfileValues;
    private final SparseArray<String> mColorFormatValues;
    private final SparseArray<String> mH263LevelValues;
    private final SparseArray<String> mH263ProfileValues;
    private final SparseArray<String> mMPEG4LevelValues;
    private final SparseArray<String> mMPEG4ProfileValues;
    public static final Companion Companion = new Companion(null);
    private static final String[] MPEG4_TYPES = {"mp4", "mpeg4", "MP4", "MPEG4"};
    private static final String[] AVC_TYPES = {"avc", "h264", "AVC", "H264"};
    private static final String[] H263_TYPES = {"h263", "H263"};
    private static final String[] AAC_TYPES = {"aac", "AAC"};

    /* compiled from: MediaCodecListCollector.kt */
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: MediaCodecListCollector.kt */
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CodecType.values().length];
            try {
                iArr[CodecType.AVC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CodecType.H263.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CodecType.MPEG4.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[CodecType.AAC.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // org.acra.collector.BaseReportFieldCollector, org.acra.collector.Collector, org.acra.plugins.Plugin
    public /* bridge */ /* synthetic */ boolean enabled(CoreConfiguration coreConfiguration) {
        return Plugin.CC.$default$enabled(this, coreConfiguration);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: MediaCodecListCollector.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lorg/acra/collector/MediaCodecListCollector$CodecType;", "", "(Ljava/lang/String;I)V", "AVC", "H263", "MPEG4", "AAC", "acra-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class CodecType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ CodecType[] $VALUES;
        public static final CodecType AVC = new CodecType("AVC", 0);
        public static final CodecType H263 = new CodecType("H263", 1);
        public static final CodecType MPEG4 = new CodecType("MPEG4", 2);
        public static final CodecType AAC = new CodecType("AAC", 3);

        private static final /* synthetic */ CodecType[] $values() {
            return new CodecType[]{AVC, H263, MPEG4, AAC};
        }

        public static EnumEntries getEntries() {
            return $ENTRIES;
        }

        public static CodecType valueOf(String str) {
            return (CodecType) Enum.valueOf(CodecType.class, str);
        }

        public static CodecType[] values() {
            return (CodecType[]) $VALUES.clone();
        }

        private CodecType(String str, int i) {
        }

        static {
            CodecType[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }
    }

    public MediaCodecListCollector() {
        super(ReportField.MEDIA_CODEC_LIST);
        this.mColorFormatValues = new SparseArray<>();
        this.mAVCLevelValues = new SparseArray<>();
        this.mAVCProfileValues = new SparseArray<>();
        this.mH263LevelValues = new SparseArray<>();
        this.mH263ProfileValues = new SparseArray<>();
        this.mMPEG4LevelValues = new SparseArray<>();
        this.mMPEG4ProfileValues = new SparseArray<>();
        this.mAACProfileValues = new SparseArray<>();
    }

    @Override // org.acra.collector.BaseReportFieldCollector, org.acra.collector.Collector
    public Collector.Order getOrder() {
        return Collector.Order.LATE;
    }

    @Override // org.acra.collector.BaseReportFieldCollector
    public void collect(ReportField reportField, Context context, CoreConfiguration config, ReportBuilder reportBuilder, CrashReportData target) throws JSONException {
        Intrinsics.checkNotNullParameter(reportField, "reportField");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(reportBuilder, "reportBuilder");
        Intrinsics.checkNotNullParameter(target, "target");
        target.put(ReportField.MEDIA_CODEC_LIST, collectMediaCodecList());
    }

    @Override // org.acra.collector.BaseReportFieldCollector
    public boolean shouldCollect(Context context, CoreConfiguration config, ReportField collect, ReportBuilder reportBuilder) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(collect, "collect");
        Intrinsics.checkNotNullParameter(reportBuilder, "reportBuilder");
        return super.shouldCollect(context, config, collect, reportBuilder);
    }

    private void prepare() {
        boolean startsWith$default;
        boolean startsWith$default2;
        boolean startsWith$default3;
        boolean startsWith$default4;
        boolean startsWith$default5;
        boolean startsWith$default6;
        boolean startsWith$default7;
        boolean startsWith$default8;
        try {
            Field[] fields = Class.forName("android.media.MediaCodecInfo$CodecCapabilities").getFields();
            Intrinsics.checkNotNullExpressionValue(fields, "getFields(...)");
            for (Field field : fields) {
                if (Modifier.isStatic(field.getModifiers()) && Modifier.isFinal(field.getModifiers())) {
                    String name = field.getName();
                    Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                    startsWith$default8 = StringsKt__StringsJVMKt.startsWith$default(name, COLOR_FORMAT_PREFIX, false, 2, null);
                    if (startsWith$default8) {
                        this.mColorFormatValues.put(field.getInt(null), field.getName());
                    }
                }
            }
            Field[] fields2 = Class.forName("android.media.MediaCodecInfo$CodecProfileLevel").getFields();
            Intrinsics.checkNotNullExpressionValue(fields2, "getFields(...)");
            for (Field field2 : fields2) {
                if (Modifier.isStatic(field2.getModifiers()) && Modifier.isFinal(field2.getModifiers())) {
                    String name2 = field2.getName();
                    Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
                    startsWith$default = StringsKt__StringsJVMKt.startsWith$default(name2, "AVCLevel", false, 2, null);
                    if (startsWith$default) {
                        this.mAVCLevelValues.put(field2.getInt(null), field2.getName());
                    } else {
                        String name3 = field2.getName();
                        Intrinsics.checkNotNullExpressionValue(name3, "getName(...)");
                        startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(name3, "AVCProfile", false, 2, null);
                        if (startsWith$default2) {
                            this.mAVCProfileValues.put(field2.getInt(null), field2.getName());
                        } else {
                            String name4 = field2.getName();
                            Intrinsics.checkNotNullExpressionValue(name4, "getName(...)");
                            startsWith$default3 = StringsKt__StringsJVMKt.startsWith$default(name4, "H263Level", false, 2, null);
                            if (startsWith$default3) {
                                this.mH263LevelValues.put(field2.getInt(null), field2.getName());
                            } else {
                                String name5 = field2.getName();
                                Intrinsics.checkNotNullExpressionValue(name5, "getName(...)");
                                startsWith$default4 = StringsKt__StringsJVMKt.startsWith$default(name5, "H263Profile", false, 2, null);
                                if (startsWith$default4) {
                                    this.mH263ProfileValues.put(field2.getInt(null), field2.getName());
                                } else {
                                    String name6 = field2.getName();
                                    Intrinsics.checkNotNullExpressionValue(name6, "getName(...)");
                                    startsWith$default5 = StringsKt__StringsJVMKt.startsWith$default(name6, "MPEG4Level", false, 2, null);
                                    if (startsWith$default5) {
                                        this.mMPEG4LevelValues.put(field2.getInt(null), field2.getName());
                                    } else {
                                        String name7 = field2.getName();
                                        Intrinsics.checkNotNullExpressionValue(name7, "getName(...)");
                                        startsWith$default6 = StringsKt__StringsJVMKt.startsWith$default(name7, "MPEG4Profile", false, 2, null);
                                        if (startsWith$default6) {
                                            this.mMPEG4ProfileValues.put(field2.getInt(null), field2.getName());
                                        } else {
                                            String name8 = field2.getName();
                                            Intrinsics.checkNotNullExpressionValue(name8, "getName(...)");
                                            startsWith$default7 = StringsKt__StringsJVMKt.startsWith$default(name8, "AAC", false, 2, null);
                                            if (startsWith$default7) {
                                                this.mAACProfileValues.put(field2.getInt(null), field2.getName());
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | SecurityException unused) {
        }
    }

    @TargetApi(16)
    private JSONObject collectMediaCodecList() throws JSONException {
        prepare();
        MediaCodecInfo[] codecInfos = new MediaCodecList(1).getCodecInfos();
        Intrinsics.checkNotNull(codecInfos);
        JSONObject jSONObject = new JSONObject();
        int length = codecInfos.length;
        for (int i = 0; i < length; i++) {
            MediaCodecInfo mediaCodecInfo = codecInfos[i];
            JSONObject jSONObject2 = new JSONObject();
            Intrinsics.checkNotNull(mediaCodecInfo);
            String[] supportedTypes = mediaCodecInfo.getSupportedTypes();
            jSONObject2.put("name", mediaCodecInfo.getName()).put("isEncoder", mediaCodecInfo.isEncoder());
            JSONObject jSONObject3 = new JSONObject();
            Intrinsics.checkNotNull(supportedTypes);
            for (String str : supportedTypes) {
                Intrinsics.checkNotNull(str);
                jSONObject3.put(str, collectCapabilitiesForType(mediaCodecInfo, str));
            }
            jSONObject2.put("supportedTypes", jSONObject3);
            jSONObject.put(String.valueOf(i), jSONObject2);
        }
        return jSONObject;
    }

    @TargetApi(16)
    private JSONObject collectCapabilitiesForType(MediaCodecInfo mediaCodecInfo, String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(str);
        int[] iArr = capabilitiesForType.colorFormats;
        Intrinsics.checkNotNull(iArr);
        int i = 0;
        if (!(iArr.length == 0)) {
            JSONArray jSONArray = new JSONArray();
            for (int i2 : iArr) {
                jSONArray.put(this.mColorFormatValues.get(i2));
            }
            jSONObject.put("colorFormats", jSONArray);
        }
        CodecType identifyCodecType = identifyCodecType(mediaCodecInfo);
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr = capabilitiesForType.profileLevels;
        Intrinsics.checkNotNull(codecProfileLevelArr);
        if (!(codecProfileLevelArr.length == 0)) {
            JSONArray jSONArray2 = new JSONArray();
            int length = codecProfileLevelArr.length;
            while (true) {
                if (i >= length) {
                    break;
                }
                MediaCodecInfo.CodecProfileLevel codecProfileLevel = codecProfileLevelArr[i];
                int i3 = codecProfileLevel.profile;
                int i4 = codecProfileLevel.level;
                if (identifyCodecType == null) {
                    jSONArray2.put(i3 + 45 + i4);
                    break;
                }
                int i5 = WhenMappings.$EnumSwitchMapping$0[identifyCodecType.ordinal()];
                if (i5 == 1) {
                    String str2 = this.mAVCProfileValues.get(i3);
                    String str3 = this.mAVCLevelValues.get(i4);
                    jSONArray2.put(i3 + ((Object) str2) + "-" + ((Object) str3));
                } else if (i5 == 2) {
                    String str4 = this.mH263ProfileValues.get(i3);
                    String str5 = this.mH263LevelValues.get(i4);
                    jSONArray2.put(((Object) str4) + "-" + ((Object) str5));
                } else if (i5 == 3) {
                    String str6 = this.mMPEG4ProfileValues.get(i3);
                    String str7 = this.mMPEG4LevelValues.get(i4);
                    jSONArray2.put(((Object) str6) + "-" + ((Object) str7));
                } else if (i5 == 4) {
                    jSONArray2.put(this.mAACProfileValues.get(i3));
                }
                i++;
            }
            jSONObject.put("profileLevels", jSONArray2);
        }
        return jSONObject;
    }

    @TargetApi(16)
    private CodecType identifyCodecType(MediaCodecInfo mediaCodecInfo) {
        boolean contains$default;
        boolean contains$default2;
        boolean contains$default3;
        boolean contains$default4;
        String name = mediaCodecInfo.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        for (String str : AVC_TYPES) {
            contains$default4 = StringsKt__StringsKt.contains$default((CharSequence) name, (CharSequence) str, false, 2, (Object) null);
            if (contains$default4) {
                return CodecType.AVC;
            }
        }
        for (String str2 : H263_TYPES) {
            contains$default3 = StringsKt__StringsKt.contains$default((CharSequence) name, (CharSequence) str2, false, 2, (Object) null);
            if (contains$default3) {
                return CodecType.H263;
            }
        }
        for (String str3 : MPEG4_TYPES) {
            contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) name, (CharSequence) str3, false, 2, (Object) null);
            if (contains$default2) {
                return CodecType.MPEG4;
            }
        }
        for (String str4 : AAC_TYPES) {
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) name, (CharSequence) str4, false, 2, (Object) null);
            if (contains$default) {
                return CodecType.AAC;
            }
        }
        return null;
    }
}
