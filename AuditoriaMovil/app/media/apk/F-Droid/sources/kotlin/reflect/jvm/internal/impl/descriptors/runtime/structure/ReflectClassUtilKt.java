package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import ch.qos.logback.core.CoreConstants;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.functions.Function11;
import kotlin.jvm.functions.Function12;
import kotlin.jvm.functions.Function13;
import kotlin.jvm.functions.Function14;
import kotlin.jvm.functions.Function15;
import kotlin.jvm.functions.Function16;
import kotlin.jvm.functions.Function17;
import kotlin.jvm.functions.Function18;
import kotlin.jvm.functions.Function19;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function20;
import kotlin.jvm.functions.Function21;
import kotlin.jvm.functions.Function22;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.functions.Function9;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.text.StringsKt__StringsJVMKt;
import org.bouncycastle.pqc.math.linearalgebra.Matrix;
/* compiled from: reflectClassUtil.kt */
/* loaded from: classes2.dex */
public abstract class ReflectClassUtilKt {
    private static final Map FUNCTION_CLASSES;
    private static final List PRIMITIVE_CLASSES;
    private static final Map PRIMITIVE_TO_WRAPPER;
    private static final Map WRAPPER_TO_PRIMITIVE;

    public static final ClassLoader getSafeClassLoader(Class cls) {
        Intrinsics.checkNotNullParameter(cls, "<this>");
        ClassLoader classLoader = cls.getClassLoader();
        if (classLoader == null) {
            ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
            Intrinsics.checkNotNullExpressionValue(systemClassLoader, "getSystemClassLoader(...)");
            return systemClassLoader;
        }
        return classLoader;
    }

    public static final boolean isEnumClassOrSpecializedEnumEntryClass(Class cls) {
        Intrinsics.checkNotNullParameter(cls, "<this>");
        return Enum.class.isAssignableFrom(cls);
    }

    static {
        List<KClass> listOf;
        int collectionSizeOrDefault;
        Map map;
        int collectionSizeOrDefault2;
        Map map2;
        List listOf2;
        int collectionSizeOrDefault3;
        Map map3;
        int i = 0;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new KClass[]{Reflection.getOrCreateKotlinClass(Boolean.TYPE), Reflection.getOrCreateKotlinClass(Byte.TYPE), Reflection.getOrCreateKotlinClass(Character.TYPE), Reflection.getOrCreateKotlinClass(Double.TYPE), Reflection.getOrCreateKotlinClass(Float.TYPE), Reflection.getOrCreateKotlinClass(Integer.TYPE), Reflection.getOrCreateKotlinClass(Long.TYPE), Reflection.getOrCreateKotlinClass(Short.TYPE)});
        PRIMITIVE_CLASSES = listOf;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(listOf, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (KClass kClass : listOf) {
            arrayList.add(TuplesKt.to(JvmClassMappingKt.getJavaObjectType(kClass), JvmClassMappingKt.getJavaPrimitiveType(kClass)));
        }
        map = MapsKt__MapsKt.toMap(arrayList);
        WRAPPER_TO_PRIMITIVE = map;
        List<KClass> list = PRIMITIVE_CLASSES;
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
        for (KClass kClass2 : list) {
            arrayList2.add(TuplesKt.to(JvmClassMappingKt.getJavaPrimitiveType(kClass2), JvmClassMappingKt.getJavaObjectType(kClass2)));
        }
        map2 = MapsKt__MapsKt.toMap(arrayList2);
        PRIMITIVE_TO_WRAPPER = map2;
        listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new Class[]{Function0.class, Function1.class, Function2.class, Function3.class, Function4.class, Function5.class, Function6.class, Function7.class, Function8.class, Function9.class, Function10.class, Function11.class, Function12.class, Function13.class, Function14.class, Function15.class, Function16.class, Function17.class, Function18.class, Function19.class, Function20.class, Function21.class, Function22.class});
        collectionSizeOrDefault3 = CollectionsKt__IterablesKt.collectionSizeOrDefault(listOf2, 10);
        ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault3);
        for (Object obj : listOf2) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            arrayList3.add(TuplesKt.to((Class) obj, Integer.valueOf(i)));
            i = i2;
        }
        map3 = MapsKt__MapsKt.toMap(arrayList3);
        FUNCTION_CLASSES = map3;
    }

    public static final Class getPrimitiveByWrapper(Class cls) {
        Intrinsics.checkNotNullParameter(cls, "<this>");
        return (Class) WRAPPER_TO_PRIMITIVE.get(cls);
    }

    public static final Class getWrapperByPrimitive(Class cls) {
        Intrinsics.checkNotNullParameter(cls, "<this>");
        return (Class) PRIMITIVE_TO_WRAPPER.get(cls);
    }

    public static final ClassId getClassId(Class cls) {
        ClassId classId;
        ClassId classId2;
        Intrinsics.checkNotNullParameter(cls, "<this>");
        if (cls.isPrimitive()) {
            throw new IllegalArgumentException("Can't compute ClassId for primitive type: " + cls);
        } else if (cls.isArray()) {
            throw new IllegalArgumentException("Can't compute ClassId for array type: " + cls);
        } else {
            if (cls.getEnclosingMethod() == null && cls.getEnclosingConstructor() == null) {
                String simpleName = cls.getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
                if (simpleName.length() != 0) {
                    Class<?> declaringClass = cls.getDeclaringClass();
                    if (declaringClass == null || (classId2 = getClassId(declaringClass)) == null || (classId = classId2.createNestedClassId(Name.identifier(cls.getSimpleName()))) == null) {
                        classId = ClassId.topLevel(new FqName(cls.getName()));
                    }
                    Intrinsics.checkNotNull(classId);
                    return classId;
                }
            }
            FqName fqName = new FqName(cls.getName());
            return new ClassId(fqName.parent(), FqName.topLevel(fqName.shortName()), true);
        }
    }

    public static final String getDesc(Class cls) {
        String replace$default;
        String replace$default2;
        Intrinsics.checkNotNullParameter(cls, "<this>");
        if (cls.isPrimitive()) {
            String name = cls.getName();
            switch (name.hashCode()) {
                case -1325958191:
                    if (name.equals("double")) {
                        return "D";
                    }
                    break;
                case 104431:
                    if (name.equals("int")) {
                        return "I";
                    }
                    break;
                case 3039496:
                    if (name.equals("byte")) {
                        return "B";
                    }
                    break;
                case 3052374:
                    if (name.equals("char")) {
                        return "C";
                    }
                    break;
                case 3327612:
                    if (name.equals("long")) {
                        return "J";
                    }
                    break;
                case 3625364:
                    if (name.equals("void")) {
                        return "V";
                    }
                    break;
                case 64711720:
                    if (name.equals("boolean")) {
                        return "Z";
                    }
                    break;
                case 97526364:
                    if (name.equals("float")) {
                        return "F";
                    }
                    break;
                case 109413500:
                    if (name.equals("short")) {
                        return "S";
                    }
                    break;
            }
            throw new IllegalArgumentException("Unsupported primitive type: " + cls);
        } else if (cls.isArray()) {
            String name2 = cls.getName();
            Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
            replace$default2 = StringsKt__StringsJVMKt.replace$default(name2, (char) CoreConstants.DOT, '/', false, 4, (Object) null);
            return replace$default2;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(Matrix.MATRIX_TYPE_RANDOM_LT);
            String name3 = cls.getName();
            Intrinsics.checkNotNullExpressionValue(name3, "getName(...)");
            replace$default = StringsKt__StringsJVMKt.replace$default(name3, (char) CoreConstants.DOT, '/', false, 4, (Object) null);
            sb.append(replace$default);
            sb.append(';');
            return sb.toString();
        }
    }

    public static final List getParameterizedTypeArguments(Type type) {
        Sequence generateSequence;
        Sequence flatMap;
        List list;
        List list2;
        List emptyList;
        Intrinsics.checkNotNullParameter(type, "<this>");
        if (!(type instanceof ParameterizedType)) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        ParameterizedType parameterizedType = (ParameterizedType) type;
        if (parameterizedType.getOwnerType() == null) {
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            Intrinsics.checkNotNullExpressionValue(actualTypeArguments, "getActualTypeArguments(...)");
            list2 = ArraysKt___ArraysKt.toList(actualTypeArguments);
            return list2;
        }
        generateSequence = SequencesKt__SequencesKt.generateSequence(type, new Function1() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt$parameterizedTypeArguments$1
            @Override // kotlin.jvm.functions.Function1
            public final ParameterizedType invoke(ParameterizedType it) {
                Intrinsics.checkNotNullParameter(it, "it");
                Type ownerType = it.getOwnerType();
                if (ownerType instanceof ParameterizedType) {
                    return (ParameterizedType) ownerType;
                }
                return null;
            }
        });
        flatMap = SequencesKt___SequencesKt.flatMap(generateSequence, new Function1() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt$parameterizedTypeArguments$2
            @Override // kotlin.jvm.functions.Function1
            public final Sequence invoke(ParameterizedType it) {
                Sequence asSequence;
                Intrinsics.checkNotNullParameter(it, "it");
                Type[] actualTypeArguments2 = it.getActualTypeArguments();
                Intrinsics.checkNotNullExpressionValue(actualTypeArguments2, "getActualTypeArguments(...)");
                asSequence = ArraysKt___ArraysKt.asSequence(actualTypeArguments2);
                return asSequence;
            }
        });
        list = SequencesKt___SequencesKt.toList(flatMap);
        return list;
    }
}
