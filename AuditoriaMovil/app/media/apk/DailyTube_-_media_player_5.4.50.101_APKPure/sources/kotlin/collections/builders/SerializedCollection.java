package kotlin.collections.builders;

import java.io.Externalizable;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class SerializedCollection implements Externalizable {
    public static final Companion Companion = new Companion(null);
    private static final long serialVersionUID = 0;
    private Collection<?> collection;
    private final int tag;

    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public SerializedCollection(Collection<?> collection, int i) {
        Intrinsics.checkNotNullParameter(collection, "collection");
        this.collection = collection;
        this.tag = i;
    }

    private final Object readResolve() {
        return this.collection;
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput input) {
        List build;
        Intrinsics.checkNotNullParameter(input, "input");
        byte readByte = input.readByte();
        int i = readByte & 1;
        if ((readByte & (-2)) == 0) {
            int readInt = input.readInt();
            if (readInt >= 0) {
                int i5 = 0;
                if (i != 0) {
                    if (i == 1) {
                        Set createSetBuilder = SetsKt.createSetBuilder(readInt);
                        while (i5 < readInt) {
                            createSetBuilder.add(input.readObject());
                            i5++;
                        }
                        build = SetsKt.build(createSetBuilder);
                    } else {
                        throw new InvalidObjectException("Unsupported collection type tag: " + i + '.');
                    }
                } else {
                    List createListBuilder = CollectionsKt.createListBuilder(readInt);
                    while (i5 < readInt) {
                        createListBuilder.add(input.readObject());
                        i5++;
                    }
                    build = CollectionsKt.build(createListBuilder);
                }
                this.collection = build;
                return;
            }
            throw new InvalidObjectException("Illegal size value: " + readInt + '.');
        }
        throw new InvalidObjectException("Unsupported flags value: " + ((int) readByte) + '.');
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput output) {
        Intrinsics.checkNotNullParameter(output, "output");
        output.writeByte(this.tag);
        output.writeInt(this.collection.size());
        Iterator<?> it = this.collection.iterator();
        while (it.hasNext()) {
            output.writeObject(it.next());
        }
    }

    public SerializedCollection() {
        this(CollectionsKt.emptyList(), 0);
    }
}
