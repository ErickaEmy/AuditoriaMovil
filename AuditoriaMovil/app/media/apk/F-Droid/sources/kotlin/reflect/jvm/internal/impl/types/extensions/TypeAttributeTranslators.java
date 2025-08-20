package kotlin.reflect.jvm.internal.impl.types.extensions;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: TypeAttributeTranslators.kt */
/* loaded from: classes2.dex */
public final class TypeAttributeTranslators {
    private final List translators;

    public final List getTranslators() {
        return this.translators;
    }

    public TypeAttributeTranslators(List translators) {
        Intrinsics.checkNotNullParameter(translators, "translators");
        this.translators = translators;
    }
}
