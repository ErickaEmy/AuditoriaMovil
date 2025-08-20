package kotlin.reflect.jvm.internal.impl.builtins.functions;

import androidx.appcompat.app.ToolbarActionBar$$ExternalSyntheticThrowCCEIfNotNull0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.BuiltInsPackageFragment;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKindExtractor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
/* compiled from: BuiltInFictitiousFunctionClassFactory.kt */
/* loaded from: classes2.dex */
public final class BuiltInFictitiousFunctionClassFactory implements ClassDescriptorFactory {
    private final ModuleDescriptor module;
    private final StorageManager storageManager;

    public BuiltInFictitiousFunctionClassFactory(StorageManager storageManager, ModuleDescriptor module) {
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics.checkNotNullParameter(module, "module");
        this.storageManager = storageManager;
        this.module = module;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory
    public boolean shouldCreateClass(FqName packageFqName, Name name) {
        boolean startsWith$default;
        boolean startsWith$default2;
        boolean startsWith$default3;
        boolean startsWith$default4;
        Intrinsics.checkNotNullParameter(packageFqName, "packageFqName");
        Intrinsics.checkNotNullParameter(name, "name");
        String asString = name.asString();
        Intrinsics.checkNotNullExpressionValue(asString, "asString(...)");
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(asString, "Function", false, 2, null);
        if (!startsWith$default) {
            startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(asString, "KFunction", false, 2, null);
            if (!startsWith$default2) {
                startsWith$default3 = StringsKt__StringsJVMKt.startsWith$default(asString, "SuspendFunction", false, 2, null);
                if (!startsWith$default3) {
                    startsWith$default4 = StringsKt__StringsJVMKt.startsWith$default(asString, "KSuspendFunction", false, 2, null);
                    if (!startsWith$default4) {
                        return false;
                    }
                }
            }
        }
        return FunctionTypeKindExtractor.Companion.getDefault().getFunctionalClassKindWithArity(packageFqName, asString) != null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory
    public ClassDescriptor createClass(ClassId classId) {
        boolean contains$default;
        Object firstOrNull;
        Object first;
        Intrinsics.checkNotNullParameter(classId, "classId");
        if (classId.isLocal() || classId.isNestedClass()) {
            return null;
        }
        String asString = classId.getRelativeClassName().asString();
        Intrinsics.checkNotNullExpressionValue(asString, "asString(...)");
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) asString, (CharSequence) "Function", false, 2, (Object) null);
        if (contains$default) {
            FqName packageFqName = classId.getPackageFqName();
            Intrinsics.checkNotNullExpressionValue(packageFqName, "getPackageFqName(...)");
            FunctionTypeKindExtractor.KindWithArity functionalClassKindWithArity = FunctionTypeKindExtractor.Companion.getDefault().getFunctionalClassKindWithArity(packageFqName, asString);
            if (functionalClassKindWithArity == null) {
                return null;
            }
            FunctionTypeKind component1 = functionalClassKindWithArity.component1();
            int component2 = functionalClassKindWithArity.component2();
            List fragments = this.module.getPackage(packageFqName).getFragments();
            ArrayList arrayList = new ArrayList();
            for (Object obj : fragments) {
                if (obj instanceof BuiltInsPackageFragment) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                it.next();
            }
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List) arrayList2);
            ToolbarActionBar$$ExternalSyntheticThrowCCEIfNotNull0.m(firstOrNull);
            first = CollectionsKt___CollectionsKt.first((List) arrayList);
            return new FunctionClassDescriptor(this.storageManager, (BuiltInsPackageFragment) first, component1, component2);
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory
    public Collection getAllContributedClassesIfPossible(FqName packageFqName) {
        Set emptySet;
        Intrinsics.checkNotNullParameter(packageFqName, "packageFqName");
        emptySet = SetsKt__SetsKt.emptySet();
        return emptySet;
    }
}
