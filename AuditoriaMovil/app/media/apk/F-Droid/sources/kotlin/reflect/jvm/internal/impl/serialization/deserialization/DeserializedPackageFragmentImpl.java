package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.ArrayList;
import java.util.Collection;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$PackageFragment;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$QualifiedNameTable;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$StringTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolverImpl;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPackageMemberScope;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
/* compiled from: DeserializedPackageFragmentImpl.kt */
/* loaded from: classes2.dex */
public abstract class DeserializedPackageFragmentImpl extends DeserializedPackageFragment {
    private MemberScope _memberScope;
    private ProtoBuf$PackageFragment _proto;
    private final ProtoBasedClassDataFinder classDataFinder;
    private final DeserializedContainerSource containerSource;
    private final BinaryVersion metadataVersion;
    private final NameResolverImpl nameResolver;

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedPackageFragment
    public ProtoBasedClassDataFinder getClassDataFinder() {
        return this.classDataFinder;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeserializedPackageFragmentImpl(FqName fqName, StorageManager storageManager, ModuleDescriptor module, ProtoBuf$PackageFragment proto, BinaryVersion metadataVersion, DeserializedContainerSource deserializedContainerSource) {
        super(fqName, storageManager, module);
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics.checkNotNullParameter(module, "module");
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(metadataVersion, "metadataVersion");
        this.metadataVersion = metadataVersion;
        this.containerSource = deserializedContainerSource;
        ProtoBuf$StringTable strings = proto.getStrings();
        Intrinsics.checkNotNullExpressionValue(strings, "getStrings(...)");
        ProtoBuf$QualifiedNameTable qualifiedNames = proto.getQualifiedNames();
        Intrinsics.checkNotNullExpressionValue(qualifiedNames, "getQualifiedNames(...)");
        NameResolverImpl nameResolverImpl = new NameResolverImpl(strings, qualifiedNames);
        this.nameResolver = nameResolverImpl;
        this.classDataFinder = new ProtoBasedClassDataFinder(proto, nameResolverImpl, metadataVersion, new Function1() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedPackageFragmentImpl$classDataFinder$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final SourceElement invoke(ClassId it) {
                DeserializedContainerSource deserializedContainerSource2;
                Intrinsics.checkNotNullParameter(it, "it");
                deserializedContainerSource2 = DeserializedPackageFragmentImpl.this.containerSource;
                if (deserializedContainerSource2 != null) {
                    return deserializedContainerSource2;
                }
                SourceElement NO_SOURCE = SourceElement.NO_SOURCE;
                Intrinsics.checkNotNullExpressionValue(NO_SOURCE, "NO_SOURCE");
                return NO_SOURCE;
            }
        });
        this._proto = proto;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedPackageFragment
    public void initialize(DeserializationComponents components) {
        Intrinsics.checkNotNullParameter(components, "components");
        ProtoBuf$PackageFragment protoBuf$PackageFragment = this._proto;
        if (protoBuf$PackageFragment == null) {
            throw new IllegalStateException("Repeated call to DeserializedPackageFragmentImpl::initialize".toString());
        }
        this._proto = null;
        ProtoBuf$Package protoBuf$Package = protoBuf$PackageFragment.getPackage();
        Intrinsics.checkNotNullExpressionValue(protoBuf$Package, "getPackage(...)");
        NameResolverImpl nameResolverImpl = this.nameResolver;
        BinaryVersion binaryVersion = this.metadataVersion;
        DeserializedContainerSource deserializedContainerSource = this.containerSource;
        this._memberScope = new DeserializedPackageMemberScope(this, protoBuf$Package, nameResolverImpl, binaryVersion, deserializedContainerSource, components, "scope of " + this, new Function0() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedPackageFragmentImpl$initialize$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Collection invoke() {
                int collectionSizeOrDefault;
                ArrayList<ClassId> arrayList = new ArrayList();
                for (Object obj : DeserializedPackageFragmentImpl.this.getClassDataFinder().getAllClassIds()) {
                    ClassId classId = (ClassId) obj;
                    if (!classId.isNestedClass() && !ClassDeserializer.Companion.getBLACK_LIST().contains(classId)) {
                        arrayList.add(obj);
                    }
                }
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
                ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
                for (ClassId classId2 : arrayList) {
                    arrayList2.add(classId2.getShortClassName());
                }
                return arrayList2;
            }
        });
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor
    public MemberScope getMemberScope() {
        MemberScope memberScope = this._memberScope;
        if (memberScope == null) {
            Intrinsics.throwUninitializedPropertyAccessException("_memberScope");
            return null;
        }
        return memberScope;
    }
}
