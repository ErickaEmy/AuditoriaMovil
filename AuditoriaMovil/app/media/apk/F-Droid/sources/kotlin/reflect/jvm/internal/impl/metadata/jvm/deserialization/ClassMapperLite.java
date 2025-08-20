package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import ch.qos.logback.core.CoreConstants;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.bouncycastle.pqc.math.linearalgebra.Matrix;
/* compiled from: ClassMapperLite.kt */
/* loaded from: classes2.dex */
public final class ClassMapperLite {
    public static final ClassMapperLite INSTANCE = new ClassMapperLite();

    /* renamed from: kotlin  reason: collision with root package name */
    private static final String f36kotlin;
    private static final Map map;

    private ClassMapperLite() {
    }

    static {
        List listOf;
        String joinToString$default;
        List listOf2;
        List<String> listOf3;
        List<String> listOf4;
        List<String> listOf5;
        int i;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Character[]{'k', 'o', 't', 'l', 'i', 'n'});
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(listOf, "", null, null, 0, null, null, 62, null);
        f36kotlin = joinToString$default;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"Boolean", "Z", "Char", "C", "Byte", "B", "Short", "S", "Int", "I", "Float", "F", "Long", "J", "Double", "D"});
        int progressionLastElement = ProgressionUtilKt.getProgressionLastElement(0, listOf2.size() - 1, 2);
        if (progressionLastElement >= 0) {
            int i2 = 0;
            while (true) {
                StringBuilder sb = new StringBuilder();
                String str = f36kotlin;
                sb.append(str);
                sb.append('/');
                sb.append((String) listOf2.get(i2));
                linkedHashMap.put(sb.toString(), listOf2.get(i2 + 1));
                linkedHashMap.put(str + '/' + ((String) listOf2.get(i2)) + "Array", '[' + ((String) listOf2.get(i)));
                if (i2 == progressionLastElement) {
                    break;
                }
                i2 += 2;
            }
        }
        linkedHashMap.put(f36kotlin + "/Unit", "V");
        map$lambda$0$add(linkedHashMap, "Any", "java/lang/Object");
        map$lambda$0$add(linkedHashMap, "Nothing", "java/lang/Void");
        map$lambda$0$add(linkedHashMap, "Annotation", "java/lang/annotation/Annotation");
        listOf3 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"String", "CharSequence", "Throwable", "Cloneable", "Number", "Comparable", "Enum"});
        for (String str2 : listOf3) {
            map$lambda$0$add(linkedHashMap, str2, "java/lang/" + str2);
        }
        listOf4 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"Iterator", "Collection", "List", "Set", "Map", "ListIterator"});
        for (String str3 : listOf4) {
            map$lambda$0$add(linkedHashMap, "collections/" + str3, "java/util/" + str3);
            map$lambda$0$add(linkedHashMap, "collections/Mutable" + str3, "java/util/" + str3);
        }
        map$lambda$0$add(linkedHashMap, "collections/Iterable", "java/lang/Iterable");
        map$lambda$0$add(linkedHashMap, "collections/MutableIterable", "java/lang/Iterable");
        map$lambda$0$add(linkedHashMap, "collections/Map.Entry", "java/util/Map$Entry");
        map$lambda$0$add(linkedHashMap, "collections/MutableMap.MutableEntry", "java/util/Map$Entry");
        for (int i3 = 0; i3 < 23; i3++) {
            StringBuilder sb2 = new StringBuilder();
            String str4 = f36kotlin;
            sb2.append(str4);
            sb2.append("/jvm/functions/Function");
            sb2.append(i3);
            map$lambda$0$add(linkedHashMap, "Function" + i3, sb2.toString());
            map$lambda$0$add(linkedHashMap, "reflect/KFunction" + i3, str4 + "/reflect/KFunction");
        }
        listOf5 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"Char", "Byte", "Short", "Int", "Float", "Long", "Double", "String", "Enum"});
        for (String str5 : listOf5) {
            map$lambda$0$add(linkedHashMap, str5 + ".Companion", f36kotlin + "/jvm/internal/" + str5 + "CompanionObject");
        }
        map = linkedHashMap;
    }

    private static final void map$lambda$0$add(Map map2, String str, String str2) {
        map2.put(f36kotlin + '/' + str, Matrix.MATRIX_TYPE_RANDOM_LT + str2 + ';');
    }

    public static final String mapClass(String classId) {
        String replace$default;
        Intrinsics.checkNotNullParameter(classId, "classId");
        String str = (String) map.get(classId);
        if (str == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(Matrix.MATRIX_TYPE_RANDOM_LT);
            replace$default = StringsKt__StringsJVMKt.replace$default(classId, (char) CoreConstants.DOT, (char) CoreConstants.DOLLAR, false, 4, (Object) null);
            sb.append(replace$default);
            sb.append(';');
            return sb.toString();
        }
        return str;
    }
}
