package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import ch.qos.logback.core.CoreConstants;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.text.StringsKt__StringsJVMKt;
/* compiled from: JvmNameResolverBase.kt */
/* loaded from: classes2.dex */
public abstract class JvmNameResolverBase implements NameResolver {
    public static final Companion Companion = new Companion(null);
    private static final List PREDEFINED_STRINGS;
    private static final Map PREDEFINED_STRINGS_MAP;

    /* renamed from: kotlin  reason: collision with root package name */
    private static final String f37kotlin;
    private final Set localNameIndices;
    private final List records;
    private final String[] strings;

    /* compiled from: JvmNameResolverBase.kt */
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: JvmNameResolverBase.kt */
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[JvmProtoBuf.StringTableTypes.Record.Operation.values().length];
            try {
                iArr[JvmProtoBuf.StringTableTypes.Record.Operation.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[JvmProtoBuf.StringTableTypes.Record.Operation.INTERNAL_TO_CLASS_ID.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[JvmProtoBuf.StringTableTypes.Record.Operation.DESC_TO_CLASS_ID.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public JvmNameResolverBase(String[] strings, Set localNameIndices, List records) {
        Intrinsics.checkNotNullParameter(strings, "strings");
        Intrinsics.checkNotNullParameter(localNameIndices, "localNameIndices");
        Intrinsics.checkNotNullParameter(records, "records");
        this.strings = strings;
        this.localNameIndices = localNameIndices;
        this.records = records;
    }

    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver
    public String getString(int i) {
        String str;
        JvmProtoBuf.StringTableTypes.Record record = (JvmProtoBuf.StringTableTypes.Record) this.records.get(i);
        if (record.hasString()) {
            str = record.getString();
        } else {
            if (record.hasPredefinedIndex()) {
                List list = PREDEFINED_STRINGS;
                int size = list.size();
                int predefinedIndex = record.getPredefinedIndex();
                if (predefinedIndex >= 0 && predefinedIndex < size) {
                    str = (String) list.get(record.getPredefinedIndex());
                }
            }
            str = this.strings[i];
        }
        if (record.getSubstringIndexCount() >= 2) {
            List substringIndexList = record.getSubstringIndexList();
            Intrinsics.checkNotNull(substringIndexList);
            Integer num = (Integer) substringIndexList.get(0);
            Integer num2 = (Integer) substringIndexList.get(1);
            Intrinsics.checkNotNull(num);
            if (num.intValue() >= 0) {
                int intValue = num.intValue();
                Intrinsics.checkNotNull(num2);
                if (intValue <= num2.intValue() && num2.intValue() <= str.length()) {
                    Intrinsics.checkNotNull(str);
                    str = str.substring(num.intValue(), num2.intValue());
                    Intrinsics.checkNotNullExpressionValue(str, "substring(...)");
                }
            }
        }
        String str2 = str;
        if (record.getReplaceCharCount() >= 2) {
            List replaceCharList = record.getReplaceCharList();
            Intrinsics.checkNotNull(replaceCharList);
            Intrinsics.checkNotNull(str2);
            str2 = StringsKt__StringsJVMKt.replace$default(str2, (char) ((Integer) replaceCharList.get(0)).intValue(), (char) ((Integer) replaceCharList.get(1)).intValue(), false, 4, (Object) null);
        }
        String str3 = str2;
        JvmProtoBuf.StringTableTypes.Record.Operation operation = record.getOperation();
        if (operation == null) {
            operation = JvmProtoBuf.StringTableTypes.Record.Operation.NONE;
        }
        int i2 = WhenMappings.$EnumSwitchMapping$0[operation.ordinal()];
        if (i2 == 2) {
            Intrinsics.checkNotNull(str3);
            str3 = StringsKt__StringsJVMKt.replace$default(str3, (char) CoreConstants.DOLLAR, (char) CoreConstants.DOT, false, 4, (Object) null);
        } else if (i2 == 3) {
            if (str3.length() >= 2) {
                Intrinsics.checkNotNull(str3);
                str3 = str3.substring(1, str3.length() - 1);
                Intrinsics.checkNotNullExpressionValue(str3, "substring(...)");
            }
            String str4 = str3;
            Intrinsics.checkNotNull(str4);
            str3 = StringsKt__StringsJVMKt.replace$default(str4, (char) CoreConstants.DOLLAR, (char) CoreConstants.DOT, false, 4, (Object) null);
        }
        Intrinsics.checkNotNull(str3);
        return str3;
    }

    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver
    public String getQualifiedClassName(int i) {
        return getString(i);
    }

    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver
    public boolean isLocalClassName(int i) {
        return this.localNameIndices.contains(Integer.valueOf(i));
    }

    static {
        List listOf;
        String joinToString$default;
        List listOf2;
        Iterable<IndexedValue> withIndex;
        int collectionSizeOrDefault;
        int mapCapacity;
        int coerceAtLeast;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Character[]{'k', 'o', 't', 'l', 'i', 'n'});
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(listOf, "", null, null, 0, null, null, 62, null);
        f37kotlin = joinToString$default;
        listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{joinToString$default + "/Any", joinToString$default + "/Nothing", joinToString$default + "/Unit", joinToString$default + "/Throwable", joinToString$default + "/Number", joinToString$default + "/Byte", joinToString$default + "/Double", joinToString$default + "/Float", joinToString$default + "/Int", joinToString$default + "/Long", joinToString$default + "/Short", joinToString$default + "/Boolean", joinToString$default + "/Char", joinToString$default + "/CharSequence", joinToString$default + "/String", joinToString$default + "/Comparable", joinToString$default + "/Enum", joinToString$default + "/Array", joinToString$default + "/ByteArray", joinToString$default + "/DoubleArray", joinToString$default + "/FloatArray", joinToString$default + "/IntArray", joinToString$default + "/LongArray", joinToString$default + "/ShortArray", joinToString$default + "/BooleanArray", joinToString$default + "/CharArray", joinToString$default + "/Cloneable", joinToString$default + "/Annotation", joinToString$default + "/collections/Iterable", joinToString$default + "/collections/MutableIterable", joinToString$default + "/collections/Collection", joinToString$default + "/collections/MutableCollection", joinToString$default + "/collections/List", joinToString$default + "/collections/MutableList", joinToString$default + "/collections/Set", joinToString$default + "/collections/MutableSet", joinToString$default + "/collections/Map", joinToString$default + "/collections/MutableMap", joinToString$default + "/collections/Map.Entry", joinToString$default + "/collections/MutableMap.MutableEntry", joinToString$default + "/collections/Iterator", joinToString$default + "/collections/MutableIterator", joinToString$default + "/collections/ListIterator", joinToString$default + "/collections/MutableListIterator"});
        PREDEFINED_STRINGS = listOf2;
        withIndex = CollectionsKt___CollectionsKt.withIndex(listOf2);
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(withIndex, 10);
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault);
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
        for (IndexedValue indexedValue : withIndex) {
            linkedHashMap.put((String) indexedValue.getValue(), Integer.valueOf(indexedValue.getIndex()));
        }
        PREDEFINED_STRINGS_MAP = linkedHashMap;
    }
}
