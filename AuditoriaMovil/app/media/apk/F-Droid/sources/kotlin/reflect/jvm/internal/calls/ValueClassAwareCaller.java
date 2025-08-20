package kotlin.reflect.jvm.internal.calls;

import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.reflect.jvm.internal.KDeclarationContainerImpl;
import kotlin.reflect.jvm.internal.UtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutionKt;
import kotlin.text.StringsKt__StringsKt;
/* compiled from: ValueClassAwareCaller.kt */
/* loaded from: classes2.dex */
public final class ValueClassAwareCaller implements Caller {
    private final Caller caller;
    private final BoxUnboxData data;
    private final boolean hasMfvcParameters;
    private final boolean isDefault;
    private final Member member;
    private final IntRange[] slices;

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    /* renamed from: getMember */
    public Member mo2185getMember() {
        return this.member;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x00a5, code lost:
        r13 = kotlin.reflect.jvm.internal.calls.ValueClassAwareCallerKt.toInlineClass(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00d4, code lost:
        if ((r12 instanceof kotlin.reflect.jvm.internal.calls.BoundCaller) != false) goto L86;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public ValueClassAwareCaller(kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor r11, kotlin.reflect.jvm.internal.calls.Caller r12, boolean r13) {
        /*
            Method dump skipped, instructions count: 538
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.calls.ValueClassAwareCaller.<init>(kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, kotlin.reflect.jvm.internal.calls.Caller, boolean):void");
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    public Type getReturnType() {
        return this.caller.getReturnType();
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    public List getParameterTypes() {
        return this.caller.getParameterTypes();
    }

    /* compiled from: ValueClassAwareCaller.kt */
    /* loaded from: classes2.dex */
    private static final class BoxUnboxData {
        private final IntRange argumentRange;
        private final Method box;
        private final List[] unboxParameters;

        public final IntRange getArgumentRange() {
            return this.argumentRange;
        }

        public final Method getBox() {
            return this.box;
        }

        public final List[] getUnboxParameters() {
            return this.unboxParameters;
        }

        public BoxUnboxData(IntRange argumentRange, List[] unboxParameters, Method method) {
            Intrinsics.checkNotNullParameter(argumentRange, "argumentRange");
            Intrinsics.checkNotNullParameter(unboxParameters, "unboxParameters");
            this.argumentRange = argumentRange;
            this.unboxParameters = unboxParameters;
            this.box = method;
        }
    }

    private static final int data$lambda$3$typeSize(KotlinType kotlinType) {
        List mfvcUnboxMethods = ValueClassAwareCallerKt.getMfvcUnboxMethods(TypeSubstitutionKt.asSimpleType(kotlinType));
        if (mfvcUnboxMethods != null) {
            return mfvcUnboxMethods.size();
        }
        return 1;
    }

    public final IntRange getRealSlicesOfParameters(int i) {
        Object last;
        IntRange intRange;
        if (i >= 0) {
            IntRange[] intRangeArr = this.slices;
            if (i < intRangeArr.length) {
                return intRangeArr[i];
            }
        }
        IntRange[] intRangeArr2 = this.slices;
        if (intRangeArr2.length == 0) {
            intRange = new IntRange(i, i);
        } else {
            last = ArraysKt___ArraysKt.last(intRangeArr2);
            int length = (i - intRangeArr2.length) + ((IntRange) last).getLast() + 1;
            intRange = new IntRange(length, length);
        }
        return intRange;
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    public Object call(Object[] args) {
        Object coroutine_suspended;
        Object invoke;
        Object obj;
        Method method;
        Object single;
        List createListBuilder;
        int lastIndex;
        List build;
        Object defaultPrimitiveValue;
        Intrinsics.checkNotNullParameter(args, "args");
        IntRange argumentRange = this.data.getArgumentRange();
        List[] unboxParameters = this.data.getUnboxParameters();
        Method box = this.data.getBox();
        if (!argumentRange.isEmpty()) {
            if (this.hasMfvcParameters) {
                createListBuilder = CollectionsKt__CollectionsJVMKt.createListBuilder(args.length);
                int first = argumentRange.getFirst();
                for (int i = 0; i < first; i++) {
                    createListBuilder.add(args[i]);
                }
                int first2 = argumentRange.getFirst();
                int last = argumentRange.getLast();
                if (first2 <= last) {
                    while (true) {
                        List<Method> list = unboxParameters[first2];
                        Object obj2 = args[first2];
                        if (list == null) {
                            createListBuilder.add(obj2);
                        } else {
                            for (Method method2 : list) {
                                if (obj2 != null) {
                                    defaultPrimitiveValue = method2.invoke(obj2, new Object[0]);
                                } else {
                                    Class<?> returnType = method2.getReturnType();
                                    Intrinsics.checkNotNullExpressionValue(returnType, "getReturnType(...)");
                                    defaultPrimitiveValue = UtilKt.defaultPrimitiveValue(returnType);
                                }
                                createListBuilder.add(defaultPrimitiveValue);
                            }
                        }
                        if (first2 == last) {
                            break;
                        }
                        first2++;
                    }
                }
                int last2 = argumentRange.getLast() + 1;
                lastIndex = ArraysKt___ArraysKt.getLastIndex(args);
                if (last2 <= lastIndex) {
                    while (true) {
                        createListBuilder.add(args[last2]);
                        if (last2 == lastIndex) {
                            break;
                        }
                        last2++;
                    }
                }
                build = CollectionsKt__CollectionsJVMKt.build(createListBuilder);
                args = build.toArray(new Object[0]);
            } else {
                int length = args.length;
                Object[] objArr = new Object[length];
                for (int i2 = 0; i2 < length; i2++) {
                    int first3 = argumentRange.getFirst();
                    if (i2 <= argumentRange.getLast() && first3 <= i2) {
                        List list2 = unboxParameters[i2];
                        if (list2 != null) {
                            single = CollectionsKt___CollectionsKt.single(list2);
                            method = (Method) single;
                        } else {
                            method = null;
                        }
                        obj = args[i2];
                        if (method != null) {
                            if (obj != null) {
                                obj = method.invoke(obj, new Object[0]);
                            } else {
                                Class<?> returnType2 = method.getReturnType();
                                Intrinsics.checkNotNullExpressionValue(returnType2, "getReturnType(...)");
                                obj = UtilKt.defaultPrimitiveValue(returnType2);
                            }
                        }
                    } else {
                        obj = args[i2];
                    }
                    objArr[i2] = obj;
                }
                args = objArr;
            }
        }
        Object call = this.caller.call(args);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return (call == coroutine_suspended || box == null || (invoke = box.invoke(null, call)) == null) ? call : invoke;
    }

    /* compiled from: ValueClassAwareCaller.kt */
    /* loaded from: classes2.dex */
    public static final class MultiFieldValueClassPrimaryConstructorCaller implements Caller {
        private final Method boxMethod;
        private final Method constructorImpl;
        private final List originalParametersGroups;
        private final List parameterTypes;
        private final List parameterUnboxMethods;

        public Void getMember() {
            return null;
        }

        public final List getOriginalParametersGroups() {
            return this.originalParametersGroups;
        }

        @Override // kotlin.reflect.jvm.internal.calls.Caller
        public List getParameterTypes() {
            return this.parameterTypes;
        }

        public MultiFieldValueClassPrimaryConstructorCaller(FunctionDescriptor descriptor, KDeclarationContainerImpl container, String constructorDesc, List originalParameters) {
            String removeSuffix;
            int collectionSizeOrDefault;
            int collectionSizeOrDefault2;
            List flatten;
            Collection listOf;
            int collectionSizeOrDefault3;
            List valueClassUnboxMethods;
            Intrinsics.checkNotNullParameter(descriptor, "descriptor");
            Intrinsics.checkNotNullParameter(container, "container");
            Intrinsics.checkNotNullParameter(constructorDesc, "constructorDesc");
            Intrinsics.checkNotNullParameter(originalParameters, "originalParameters");
            Method findMethodBySignature = container.findMethodBySignature("constructor-impl", constructorDesc);
            Intrinsics.checkNotNull(findMethodBySignature);
            this.constructorImpl = findMethodBySignature;
            StringBuilder sb = new StringBuilder();
            removeSuffix = StringsKt__StringsKt.removeSuffix(constructorDesc, "V");
            sb.append(removeSuffix);
            sb.append(ReflectClassUtilKt.getDesc(container.getJClass()));
            Method findMethodBySignature2 = container.findMethodBySignature("box-impl", sb.toString());
            Intrinsics.checkNotNull(findMethodBySignature2);
            this.boxMethod = findMethodBySignature2;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(originalParameters, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator it = originalParameters.iterator();
            while (it.hasNext()) {
                KotlinType type = ((ParameterDescriptor) it.next()).getType();
                Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
                valueClassUnboxMethods = ValueClassAwareCallerKt.getValueClassUnboxMethods(TypeSubstitutionKt.asSimpleType(type), descriptor);
                arrayList.add(valueClassUnboxMethods);
            }
            this.parameterUnboxMethods = arrayList;
            collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(originalParameters, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
            int i = 0;
            for (Object obj : originalParameters) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                ClassifierDescriptor mo2222getDeclarationDescriptor = ((ParameterDescriptor) obj).getType().getConstructor().mo2222getDeclarationDescriptor();
                Intrinsics.checkNotNull(mo2222getDeclarationDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                ClassDescriptor classDescriptor = (ClassDescriptor) mo2222getDeclarationDescriptor;
                List<Method> list = (List) this.parameterUnboxMethods.get(i);
                if (list != null) {
                    collectionSizeOrDefault3 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                    listOf = new ArrayList(collectionSizeOrDefault3);
                    for (Method method : list) {
                        listOf.add(method.getReturnType());
                    }
                } else {
                    Class javaClass = UtilKt.toJavaClass(classDescriptor);
                    Intrinsics.checkNotNull(javaClass);
                    listOf = CollectionsKt__CollectionsJVMKt.listOf(javaClass);
                }
                arrayList2.add(listOf);
                i = i2;
            }
            this.originalParametersGroups = arrayList2;
            flatten = CollectionsKt__IterablesKt.flatten(arrayList2);
            this.parameterTypes = flatten;
        }

        @Override // kotlin.reflect.jvm.internal.calls.Caller
        /* renamed from: getMember */
        public /* bridge */ /* synthetic */ Member mo2185getMember() {
            return (Member) getMember();
        }

        @Override // kotlin.reflect.jvm.internal.calls.Caller
        public Type getReturnType() {
            Class<?> returnType = this.boxMethod.getReturnType();
            Intrinsics.checkNotNullExpressionValue(returnType, "getReturnType(...)");
            return returnType;
        }

        @Override // kotlin.reflect.jvm.internal.calls.Caller
        public Object call(Object[] args) {
            List<Pair> zip;
            Collection listOf;
            int collectionSizeOrDefault;
            Intrinsics.checkNotNullParameter(args, "args");
            zip = ArraysKt___ArraysKt.zip(args, this.parameterUnboxMethods);
            ArrayList arrayList = new ArrayList();
            for (Pair pair : zip) {
                Object component1 = pair.component1();
                List<Method> list = (List) pair.component2();
                if (list == null) {
                    listOf = CollectionsKt__CollectionsJVMKt.listOf(component1);
                } else {
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                    listOf = new ArrayList(collectionSizeOrDefault);
                    for (Method method : list) {
                        listOf.add(method.invoke(component1, new Object[0]));
                    }
                }
                CollectionsKt__MutableCollectionsKt.addAll(arrayList, listOf);
            }
            Object[] array = arrayList.toArray(new Object[0]);
            this.constructorImpl.invoke(null, Arrays.copyOf(array, array.length));
            return this.boxMethod.invoke(null, Arrays.copyOf(array, array.length));
        }
    }
}
