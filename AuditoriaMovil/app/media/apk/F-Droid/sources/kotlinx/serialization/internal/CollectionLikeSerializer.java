package kotlinx.serialization.internal;

import java.util.Iterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder;
/* compiled from: CollectionSerializers.kt */
/* loaded from: classes2.dex */
public abstract class CollectionLikeSerializer extends AbstractCollectionSerializer {
    private final KSerializer elementSerializer;

    public /* synthetic */ CollectionLikeSerializer(KSerializer kSerializer, DefaultConstructorMarker defaultConstructorMarker) {
        this(kSerializer);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public abstract SerialDescriptor getDescriptor();

    protected abstract void insert(Object obj, int i, Object obj2);

    private CollectionLikeSerializer(KSerializer kSerializer) {
        super(null);
        this.elementSerializer = kSerializer;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, Object obj) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        int collectionSize = collectionSize(obj);
        SerialDescriptor descriptor = getDescriptor();
        CompositeEncoder beginCollection = encoder.beginCollection(descriptor, collectionSize);
        Iterator collectionIterator = collectionIterator(obj);
        for (int i = 0; i < collectionSize; i++) {
            beginCollection.encodeSerializableElement(getDescriptor(), i, this.elementSerializer, collectionIterator.next());
        }
        beginCollection.endStructure(descriptor);
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    protected final void readAll(CompositeDecoder decoder, Object obj, int i, int i2) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        if (i2 < 0) {
            throw new IllegalArgumentException("Size must be known in advance when using READ_ALL".toString());
        }
        for (int i3 = 0; i3 < i2; i3++) {
            readElement(decoder, i + i3, obj, false);
        }
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    protected void readElement(CompositeDecoder decoder, int i, Object obj, boolean z) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        insert(obj, i, CompositeDecoder.DefaultImpls.decodeSerializableElement$default(decoder, getDescriptor(), i, this.elementSerializer, null, 8, null));
    }
}
