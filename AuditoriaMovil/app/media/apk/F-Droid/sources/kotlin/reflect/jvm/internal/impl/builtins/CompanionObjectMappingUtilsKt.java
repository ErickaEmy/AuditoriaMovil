package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.Set;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
/* compiled from: CompanionObjectMappingUtils.kt */
/* loaded from: classes2.dex */
public abstract class CompanionObjectMappingUtilsKt {
    public static final boolean isMappedIntrinsicCompanionObject(CompanionObjectMapping companionObjectMapping, ClassDescriptor classDescriptor) {
        boolean contains;
        Intrinsics.checkNotNullParameter(companionObjectMapping, "<this>");
        Intrinsics.checkNotNullParameter(classDescriptor, "classDescriptor");
        if (DescriptorUtils.isCompanionObject(classDescriptor)) {
            Set classIds = companionObjectMapping.getClassIds();
            ClassId classId = DescriptorUtilsKt.getClassId(classDescriptor);
            contains = CollectionsKt___CollectionsKt.contains(classIds, classId != null ? classId.getOuterClassId() : null);
            if (contains) {
                return true;
            }
        }
        return false;
    }
}
