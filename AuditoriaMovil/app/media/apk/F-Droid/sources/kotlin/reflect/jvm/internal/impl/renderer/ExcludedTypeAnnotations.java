package kotlin.reflect.jvm.internal.impl.renderer;

import java.util.Set;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.reflect.jvm.internal.impl.name.FqName;
/* compiled from: DescriptorRenderer.kt */
/* loaded from: classes2.dex */
public final class ExcludedTypeAnnotations {
    public static final ExcludedTypeAnnotations INSTANCE = new ExcludedTypeAnnotations();
    private static final Set internalAnnotationsForResolve;

    private ExcludedTypeAnnotations() {
    }

    public final Set getInternalAnnotationsForResolve() {
        return internalAnnotationsForResolve;
    }

    static {
        Set of;
        of = SetsKt__SetsKt.setOf((Object[]) new FqName[]{new FqName("kotlin.internal.NoInfer"), new FqName("kotlin.internal.Exact")});
        internalAnnotationsForResolve = of;
    }
}
