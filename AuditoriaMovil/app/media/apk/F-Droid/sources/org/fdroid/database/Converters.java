package org.fdroid.database;

import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.joran.action.Action;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import org.bouncycastle.i18n.TextBundle;
import org.fdroid.index.IndexParser;
import org.fdroid.index.v2.FileV2;
/* compiled from: Converters.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0006H\u0007J&\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005j\u0004\u0018\u0001`\u000e2\b\u0010\f\u001a\u0004\u0018\u00010\u0006H\u0007J&\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0004\u0018\u0001`\u00102\b\u0010\f\u001a\u0004\u0018\u00010\u0006H\u0007J0\u0010\u0011\u001a \u0012\u0004\u0012\u00020\u0006\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005j\u0002`\u0010\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u0006H\u0007J\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u00062\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000bH\u0007J&\u0010\u0014\u001a\u0004\u0018\u00010\u00062\u001a\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005j\u0004\u0018\u0001`\u000eH\u0007J&\u0010\u0016\u001a\u0004\u0018\u00010\u00062\u001a\u0010\u0013\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0004\u0018\u0001`\u0010H\u0007J0\u0010\u0017\u001a\u0004\u0018\u00010\u00062$\u0010\u0013\u001a \u0012\u0004\u0012\u00020\u0006\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005j\u0002`\u0010\u0018\u00010\u0005H\u0007R \u0010\u0003\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R,\u0010\t\u001a \u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00050\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lorg/fdroid/database/Converters;", "", "()V", "localizedFileV2Serializer", "Lkotlinx/serialization/KSerializer;", "", "", "Lorg/fdroid/index/v2/FileV2;", "localizedTextV2Serializer", "mapOfLocalizedTextV2Serializer", "fromStringToListString", "", Action.VALUE_ATTRIBUTE, "fromStringToLocalizedFileV2", "Lorg/fdroid/index/v2/LocalizedFileV2;", "fromStringToLocalizedTextV2", "Lorg/fdroid/index/v2/LocalizedTextV2;", "fromStringToMapOfLocalizedTextV2", "listStringToString", TextBundle.TEXT_ENTRY, "localizedFileV2toString", Action.FILE_ATTRIBUTE, "localizedTextV2toString", "mapOfLocalizedTextV2toString", "database_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class Converters {
    public static final Converters INSTANCE = new Converters();
    private static final KSerializer localizedFileV2Serializer;
    private static final KSerializer localizedTextV2Serializer;
    private static final KSerializer mapOfLocalizedTextV2Serializer;

    private Converters() {
    }

    static {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        KSerializer MapSerializer = BuiltinSerializersKt.MapSerializer(BuiltinSerializersKt.serializer(stringCompanionObject), BuiltinSerializersKt.serializer(stringCompanionObject));
        localizedTextV2Serializer = MapSerializer;
        localizedFileV2Serializer = BuiltinSerializersKt.MapSerializer(BuiltinSerializersKt.serializer(stringCompanionObject), FileV2.Companion.serializer());
        mapOfLocalizedTextV2Serializer = BuiltinSerializersKt.MapSerializer(BuiltinSerializersKt.serializer(stringCompanionObject), MapSerializer);
    }

    public final Map<String, String> fromStringToLocalizedTextV2(String str) {
        if (str != null) {
            return (Map) IndexParser.getJson().decodeFromString(localizedTextV2Serializer, str);
        }
        return null;
    }

    public final String localizedTextV2toString(Map<String, String> map) {
        if (map != null) {
            return IndexParser.getJson().encodeToString(localizedTextV2Serializer, map);
        }
        return null;
    }

    public final Map<String, FileV2> fromStringToLocalizedFileV2(String str) {
        if (str != null) {
            return (Map) IndexParser.getJson().decodeFromString(localizedFileV2Serializer, str);
        }
        return null;
    }

    public final String localizedFileV2toString(Map<String, FileV2> map) {
        if (map != null) {
            return IndexParser.getJson().encodeToString(localizedFileV2Serializer, map);
        }
        return null;
    }

    public final Map<String, Map<String, String>> fromStringToMapOfLocalizedTextV2(String str) {
        if (str != null) {
            return (Map) IndexParser.getJson().decodeFromString(mapOfLocalizedTextV2Serializer, str);
        }
        return null;
    }

    public final String mapOfLocalizedTextV2toString(Map<String, ? extends Map<String, String>> map) {
        if (map != null) {
            return IndexParser.getJson().encodeToString(mapOfLocalizedTextV2Serializer, map);
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0002, code lost:
        r8 = kotlin.text.StringsKt__StringsKt.split$default((java.lang.CharSequence) r8, new char[]{ch.qos.logback.core.CoreConstants.COMMA_CHAR}, false, 0, 6, (java.lang.Object) null);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<java.lang.String> fromStringToListString(java.lang.String r8) {
        /*
            r7 = this;
            if (r8 == 0) goto L35
            r0 = 1
            char[] r2 = new char[r0]
            r0 = 0
            r1 = 44
            r2[r0] = r1
            r3 = 0
            r4 = 0
            r5 = 6
            r6 = 0
            r1 = r8
            java.util.List r8 = kotlin.text.StringsKt.split$default(r1, r2, r3, r4, r5, r6)
            if (r8 == 0) goto L35
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r8 = r8.iterator()
        L1e:
            boolean r1 = r8.hasNext()
            if (r1 == 0) goto L39
            java.lang.Object r1 = r8.next()
            r2 = r1
            java.lang.String r2 = (java.lang.String) r2
            int r2 = r2.length()
            if (r2 <= 0) goto L1e
            r0.add(r1)
            goto L1e
        L35:
            java.util.List r0 = kotlin.collections.CollectionsKt.emptyList()
        L39:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.fdroid.database.Converters.fromStringToListString(java.lang.String):java.util.List");
    }

    public final String listStringToString(List<String> list) {
        String joinToString$default;
        if (list == null || list.isEmpty()) {
            return null;
        }
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(list, ",", ",", ",", 0, null, new Function1() { // from class: org.fdroid.database.Converters$listStringToString$1
            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(String it) {
                String replace$default;
                Intrinsics.checkNotNullParameter(it, "it");
                replace$default = StringsKt__StringsJVMKt.replace$default(it, (char) CoreConstants.COMMA_CHAR, '_', false, 4, (Object) null);
                return replace$default;
            }
        }, 24, null);
        return joinToString$default;
    }
}
