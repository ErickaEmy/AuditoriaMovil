package kotlin.reflect.jvm.internal.impl.descriptors.deserialization;

import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
/* compiled from: AdditionalClassPartsProvider.kt */
/* loaded from: classes2.dex */
public interface AdditionalClassPartsProvider {
    Collection getConstructors(ClassDescriptor classDescriptor);

    Collection getFunctions(Name name, ClassDescriptor classDescriptor);

    Collection getFunctionsNames(ClassDescriptor classDescriptor);

    Collection getSupertypes(ClassDescriptor classDescriptor);

    /* compiled from: AdditionalClassPartsProvider.kt */
    /* loaded from: classes2.dex */
    public static final class None implements AdditionalClassPartsProvider {
        public static final None INSTANCE = new None();

        private None() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider
        public Collection getSupertypes(ClassDescriptor classDescriptor) {
            List emptyList;
            Intrinsics.checkNotNullParameter(classDescriptor, "classDescriptor");
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider
        public Collection getFunctions(Name name, ClassDescriptor classDescriptor) {
            List emptyList;
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(classDescriptor, "classDescriptor");
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider
        public Collection getFunctionsNames(ClassDescriptor classDescriptor) {
            List emptyList;
            Intrinsics.checkNotNullParameter(classDescriptor, "classDescriptor");
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider
        public Collection getConstructors(ClassDescriptor classDescriptor) {
            List emptyList;
            Intrinsics.checkNotNullParameter(classDescriptor, "classDescriptor");
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
    }
}
