package kotlin.reflect.jvm.internal.impl.resolve.jvm;

import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.name.Name;
/* compiled from: SyntheticJavaPartsProvider.kt */
/* loaded from: classes2.dex */
public interface SyntheticJavaPartsProvider {
    public static final Companion Companion = Companion.$$INSTANCE;

    void generateConstructors(LazyJavaResolverContext lazyJavaResolverContext, ClassDescriptor classDescriptor, List list);

    void generateMethods(LazyJavaResolverContext lazyJavaResolverContext, ClassDescriptor classDescriptor, Name name, Collection collection);

    void generateNestedClass(LazyJavaResolverContext lazyJavaResolverContext, ClassDescriptor classDescriptor, Name name, List list);

    void generateStaticFunctions(LazyJavaResolverContext lazyJavaResolverContext, ClassDescriptor classDescriptor, Name name, Collection collection);

    List getMethodNames(LazyJavaResolverContext lazyJavaResolverContext, ClassDescriptor classDescriptor);

    List getNestedClassNames(LazyJavaResolverContext lazyJavaResolverContext, ClassDescriptor classDescriptor);

    List getStaticFunctionNames(LazyJavaResolverContext lazyJavaResolverContext, ClassDescriptor classDescriptor);

    PropertyDescriptorImpl modifyField(LazyJavaResolverContext lazyJavaResolverContext, ClassDescriptor classDescriptor, PropertyDescriptorImpl propertyDescriptorImpl);

    /* compiled from: SyntheticJavaPartsProvider.kt */
    /* loaded from: classes2.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final CompositeSyntheticJavaPartsProvider EMPTY;

        private Companion() {
        }

        public final CompositeSyntheticJavaPartsProvider getEMPTY() {
            return EMPTY;
        }

        static {
            List emptyList;
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            EMPTY = new CompositeSyntheticJavaPartsProvider(emptyList);
        }
    }
}
