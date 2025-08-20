package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
/* compiled from: Annotations.kt */
/* loaded from: classes2.dex */
public final class CompositeAnnotations implements Annotations {
    private final List delegates;

    public CompositeAnnotations(List delegates) {
        Intrinsics.checkNotNullParameter(delegates, "delegates");
        this.delegates = delegates;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public CompositeAnnotations(kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations... r2) {
        /*
            r1 = this;
            java.lang.String r0 = "delegates"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.util.List r2 = kotlin.collections.ArraysKt.toList(r2)
            r1.<init>(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.descriptors.annotations.CompositeAnnotations.<init>(kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations[]):void");
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    public boolean hasAnnotation(FqName fqName) {
        Sequence<Annotations> asSequence;
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        asSequence = CollectionsKt___CollectionsKt.asSequence(this.delegates);
        for (Annotations annotations : asSequence) {
            if (annotations.hasAnnotation(fqName)) {
                return true;
            }
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    /* renamed from: findAnnotation */
    public AnnotationDescriptor mo2188findAnnotation(final FqName fqName) {
        Sequence asSequence;
        Sequence mapNotNull;
        Object firstOrNull;
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        asSequence = CollectionsKt___CollectionsKt.asSequence(this.delegates);
        mapNotNull = SequencesKt___SequencesKt.mapNotNull(asSequence, new Function1() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.annotations.CompositeAnnotations$findAnnotation$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final AnnotationDescriptor invoke(Annotations it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.mo2188findAnnotation(FqName.this);
            }
        });
        firstOrNull = SequencesKt___SequencesKt.firstOrNull(mapNotNull);
        return (AnnotationDescriptor) firstOrNull;
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        Sequence asSequence;
        Sequence flatMap;
        asSequence = CollectionsKt___CollectionsKt.asSequence(this.delegates);
        flatMap = SequencesKt___SequencesKt.flatMap(asSequence, new Function1() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.annotations.CompositeAnnotations$iterator$1
            @Override // kotlin.jvm.functions.Function1
            public final Sequence invoke(Annotations it) {
                Sequence asSequence2;
                Intrinsics.checkNotNullParameter(it, "it");
                asSequence2 = CollectionsKt___CollectionsKt.asSequence(it);
                return asSequence2;
            }
        });
        return flatMap.iterator();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    public boolean isEmpty() {
        List<Annotations> list = this.delegates;
        if ((list instanceof Collection) && list.isEmpty()) {
            return true;
        }
        for (Annotations annotations : list) {
            if (!annotations.isEmpty()) {
                return false;
            }
        }
        return true;
    }
}
