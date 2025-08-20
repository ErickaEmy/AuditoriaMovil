package kotlinx.serialization.internal;

import java.util.Iterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.Decoder;
/* compiled from: CollectionSerializers.kt */
/* loaded from: classes2.dex */
public abstract class AbstractCollectionSerializer implements KSerializer {
    public /* synthetic */ AbstractCollectionSerializer(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    protected abstract Object builder();

    protected abstract int builderSize(Object obj);

    protected abstract void checkCapacity(Object obj, int i);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Iterator collectionIterator(Object obj);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int collectionSize(Object obj);

    protected abstract void readAll(CompositeDecoder compositeDecoder, Object obj, int i, int i2);

    protected abstract void readElement(CompositeDecoder compositeDecoder, int i, Object obj, boolean z);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Object toBuilder(Object obj);

    protected abstract Object toResult(Object obj);

    private AbstractCollectionSerializer() {
    }

    public final Object merge(Decoder decoder, Object obj) {
        Object builder;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        if (obj == null || (builder = toBuilder(obj)) == null) {
            builder = builder();
        }
        int builderSize = builderSize(builder);
        CompositeDecoder beginStructure = decoder.beginStructure(getDescriptor());
        if (!beginStructure.decodeSequentially()) {
            while (true) {
                int decodeElementIndex = beginStructure.decodeElementIndex(getDescriptor());
                if (decodeElementIndex == -1) {
                    break;
                }
                readElement$default(this, beginStructure, builderSize + decodeElementIndex, builder, false, 8, null);
            }
        } else {
            readAll(beginStructure, builder, builderSize, readSize(beginStructure, builder));
        }
        beginStructure.endStructure(getDescriptor());
        return toResult(builder);
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public Object deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        return merge(decoder, null);
    }

    private final int readSize(CompositeDecoder compositeDecoder, Object obj) {
        int decodeCollectionSize = compositeDecoder.decodeCollectionSize(getDescriptor());
        checkCapacity(obj, decodeCollectionSize);
        return decodeCollectionSize;
    }

    public static /* synthetic */ void readElement$default(AbstractCollectionSerializer abstractCollectionSerializer, CompositeDecoder compositeDecoder, int i, Object obj, boolean z, int i2, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: readElement");
        }
        if ((i2 & 8) != 0) {
            z = true;
        }
        abstractCollectionSerializer.readElement(compositeDecoder, i, obj, z);
    }
}
