package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
/* compiled from: Substitutable.kt */
/* loaded from: classes2.dex */
public interface Substitutable {
    DeclarationDescriptorNonRoot substitute(TypeSubstitutor typeSubstitutor);
}
