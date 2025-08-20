package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.utils.SmartSet;
/* compiled from: overridingUtils.kt */
/* loaded from: classes2.dex */
public abstract class OverridingUtilsKt {
    public static final Collection selectMostSpecificInEachOverridableGroup(Collection collection, Function1 descriptorByHandle) {
        Object first;
        Object single;
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(descriptorByHandle, "descriptorByHandle");
        if (collection.size() <= 1) {
            return collection;
        }
        LinkedList linkedList = new LinkedList(collection);
        SmartSet create = SmartSet.Companion.create();
        while (!linkedList.isEmpty()) {
            first = CollectionsKt___CollectionsKt.first((List) linkedList);
            final SmartSet create2 = SmartSet.Companion.create();
            Collection extractMembersOverridableInBothWays = OverridingUtil.extractMembersOverridableInBothWays(first, linkedList, descriptorByHandle, new Function1() { // from class: kotlin.reflect.jvm.internal.impl.resolve.OverridingUtilsKt$selectMostSpecificInEachOverridableGroup$overridableGroup$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    m2221invoke(obj);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: collision with other method in class */
                public final void m2221invoke(Object obj) {
                    SmartSet smartSet = SmartSet.this;
                    Intrinsics.checkNotNull(obj);
                    smartSet.add(obj);
                }
            });
            Intrinsics.checkNotNullExpressionValue(extractMembersOverridableInBothWays, "extractMembersOverridableInBothWays(...)");
            if (extractMembersOverridableInBothWays.size() == 1 && create2.isEmpty()) {
                single = CollectionsKt___CollectionsKt.single(extractMembersOverridableInBothWays);
                Intrinsics.checkNotNullExpressionValue(single, "single(...)");
                create.add(single);
            } else {
                Object selectMostSpecificMember = OverridingUtil.selectMostSpecificMember(extractMembersOverridableInBothWays, descriptorByHandle);
                Intrinsics.checkNotNullExpressionValue(selectMostSpecificMember, "selectMostSpecificMember(...)");
                CallableDescriptor callableDescriptor = (CallableDescriptor) descriptorByHandle.invoke(selectMostSpecificMember);
                for (Object obj : extractMembersOverridableInBothWays) {
                    Intrinsics.checkNotNull(obj);
                    if (!OverridingUtil.isMoreSpecific(callableDescriptor, (CallableDescriptor) descriptorByHandle.invoke(obj))) {
                        create2.add(obj);
                    }
                }
                if (!create2.isEmpty()) {
                    create.addAll(create2);
                }
                create.add(selectMostSpecificMember);
            }
        }
        return create;
    }
}
