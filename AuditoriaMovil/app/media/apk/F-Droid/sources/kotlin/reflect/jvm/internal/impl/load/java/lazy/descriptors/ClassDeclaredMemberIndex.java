package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaLoadingKt;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaRecordComponent;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
/* compiled from: DeclaredMemberIndex.kt */
/* loaded from: classes2.dex */
public class ClassDeclaredMemberIndex implements DeclaredMemberIndex {
    private final Map components;
    private final Map fields;
    private final JavaClass jClass;
    private final Function1 memberFilter;
    private final Function1 methodFilter;
    private final Map methods;

    public ClassDeclaredMemberIndex(JavaClass jClass, Function1 memberFilter) {
        Sequence asSequence;
        Sequence filter;
        Sequence asSequence2;
        Sequence filter2;
        int collectionSizeOrDefault;
        int mapCapacity;
        int coerceAtLeast;
        Intrinsics.checkNotNullParameter(jClass, "jClass");
        Intrinsics.checkNotNullParameter(memberFilter, "memberFilter");
        this.jClass = jClass;
        this.memberFilter = memberFilter;
        Function1 function1 = new Function1() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.ClassDeclaredMemberIndex$methodFilter$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(JavaMethod m) {
                Function1 function12;
                Intrinsics.checkNotNullParameter(m, "m");
                function12 = ClassDeclaredMemberIndex.this.memberFilter;
                return Boolean.valueOf(((Boolean) function12.invoke(m)).booleanValue() && !JavaLoadingKt.isObjectMethodInInterface(m));
            }
        };
        this.methodFilter = function1;
        asSequence = CollectionsKt___CollectionsKt.asSequence(jClass.getMethods());
        filter = SequencesKt___SequencesKt.filter(asSequence, function1);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : filter) {
            Name name = ((JavaMethod) obj).getName();
            Object obj2 = linkedHashMap.get(name);
            if (obj2 == null) {
                obj2 = new ArrayList();
                linkedHashMap.put(name, obj2);
            }
            ((List) obj2).add(obj);
        }
        this.methods = linkedHashMap;
        asSequence2 = CollectionsKt___CollectionsKt.asSequence(this.jClass.getFields());
        filter2 = SequencesKt___SequencesKt.filter(asSequence2, this.memberFilter);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Object obj3 : filter2) {
            linkedHashMap2.put(((JavaField) obj3).getName(), obj3);
        }
        this.fields = linkedHashMap2;
        Function1 function12 = this.memberFilter;
        ArrayList arrayList = new ArrayList();
        for (Object obj4 : this.jClass.getRecordComponents()) {
            if (((Boolean) function12.invoke(obj4)).booleanValue()) {
                arrayList.add(obj4);
            }
        }
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault);
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
        LinkedHashMap linkedHashMap3 = new LinkedHashMap(coerceAtLeast);
        for (Object obj5 : arrayList) {
            linkedHashMap3.put(((JavaRecordComponent) obj5).getName(), obj5);
        }
        this.components = linkedHashMap3;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
    public Collection findMethodsByName(Name name) {
        List emptyList;
        Intrinsics.checkNotNullParameter(name, "name");
        List list = (List) this.methods.get(name);
        if (list != null) {
            return list;
        }
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        return emptyList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
    public Set getMethodNames() {
        Sequence asSequence;
        Sequence<JavaMethod> filter;
        asSequence = CollectionsKt___CollectionsKt.asSequence(this.jClass.getMethods());
        filter = SequencesKt___SequencesKt.filter(asSequence, this.methodFilter);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (JavaMethod javaMethod : filter) {
            linkedHashSet.add(javaMethod.getName());
        }
        return linkedHashSet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
    public JavaField findFieldByName(Name name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return (JavaField) this.fields.get(name);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
    public Set getFieldNames() {
        Sequence asSequence;
        Sequence<JavaField> filter;
        asSequence = CollectionsKt___CollectionsKt.asSequence(this.jClass.getFields());
        filter = SequencesKt___SequencesKt.filter(asSequence, this.memberFilter);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (JavaField javaField : filter) {
            linkedHashSet.add(javaField.getName());
        }
        return linkedHashSet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
    public Set getRecordComponentNames() {
        return this.components.keySet();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
    public JavaRecordComponent findRecordComponentByName(Name name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return (JavaRecordComponent) this.components.get(name);
    }
}
