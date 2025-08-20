package kotlinx.serialization;

import kotlinx.serialization.descriptors.SerialDescriptor;
/* compiled from: KSerializer.kt */
/* loaded from: classes2.dex */
public interface KSerializer extends SerializationStrategy, DeserializationStrategy {
    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    SerialDescriptor getDescriptor();
}
