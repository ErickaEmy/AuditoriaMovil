package kotlin.reflect.jvm.internal.impl.resolve.constants;

import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
/* compiled from: PrimitiveTypeUtil.kt */
/* loaded from: classes2.dex */
public abstract class PrimitiveTypeUtilKt {
    public static final Collection getAllSignedLiteralTypes(ModuleDescriptor moduleDescriptor) {
        List listOf;
        Intrinsics.checkNotNullParameter(moduleDescriptor, "<this>");
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new SimpleType[]{moduleDescriptor.getBuiltIns().getIntType(), moduleDescriptor.getBuiltIns().getLongType(), moduleDescriptor.getBuiltIns().getByteType(), moduleDescriptor.getBuiltIns().getShortType()});
        return listOf;
    }
}
