package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleCapability;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
/* compiled from: KotlinTypeRefiner.kt */
/* loaded from: classes2.dex */
public abstract class KotlinTypeRefinerKt {
    private static final ModuleCapability REFINER_CAPABILITY = new ModuleCapability("KotlinTypeRefiner");

    public static final ModuleCapability getREFINER_CAPABILITY() {
        return REFINER_CAPABILITY;
    }

    public static final List refineTypes(KotlinTypeRefiner kotlinTypeRefiner, Iterable types) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "<this>");
        Intrinsics.checkNotNullParameter(types, "types");
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(types, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator it = types.iterator();
        while (it.hasNext()) {
            arrayList.add(kotlinTypeRefiner.refineType((KotlinTypeMarker) ((KotlinType) it.next())));
        }
        return arrayList;
    }
}
