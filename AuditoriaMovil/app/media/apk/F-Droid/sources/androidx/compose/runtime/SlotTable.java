package androidx.compose.runtime;

import androidx.compose.runtime.tooling.CompositionData;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.KotlinNothingValueException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
/* compiled from: SlotTable.kt */
/* loaded from: classes.dex */
public final class SlotTable implements CompositionData, Iterable, KMappedMarker {
    private int groupsSize;
    private int readers;
    private int slotsSize;
    private int version;
    private boolean writer;
    private int[] groups = new int[0];
    private Object[] slots = new Object[0];
    private ArrayList anchors = new ArrayList();

    public final ArrayList getAnchors$runtime_release() {
        return this.anchors;
    }

    public final int[] getGroups() {
        return this.groups;
    }

    public final int getGroupsSize() {
        return this.groupsSize;
    }

    public final Object[] getSlots() {
        return this.slots;
    }

    public final int getSlotsSize() {
        return this.slotsSize;
    }

    public final int getVersion$runtime_release() {
        return this.version;
    }

    public final boolean getWriter$runtime_release() {
        return this.writer;
    }

    public boolean isEmpty() {
        return this.groupsSize == 0;
    }

    public final void setTo$runtime_release(int[] groups, int i, Object[] slots, int i2, ArrayList anchors) {
        Intrinsics.checkNotNullParameter(groups, "groups");
        Intrinsics.checkNotNullParameter(slots, "slots");
        Intrinsics.checkNotNullParameter(anchors, "anchors");
        this.groups = groups;
        this.groupsSize = i;
        this.slots = slots;
        this.slotsSize = i2;
        this.anchors = anchors;
    }

    public final SlotReader openReader() {
        if (this.writer) {
            throw new IllegalStateException("Cannot read while a writer is pending".toString());
        }
        this.readers++;
        return new SlotReader(this);
    }

    public final SlotWriter openWriter() {
        if (!(!this.writer)) {
            ComposerKt.composeRuntimeError("Cannot start a writer when another writer is pending".toString());
            throw new KotlinNothingValueException();
        }
        if (this.readers <= 0) {
            this.writer = true;
            this.version++;
            return new SlotWriter(this);
        }
        ComposerKt.composeRuntimeError("Cannot start a writer when a reader is pending".toString());
        throw new KotlinNothingValueException();
    }

    public final int anchorIndex(Anchor anchor) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        if (!this.writer) {
            if (!anchor.getValid()) {
                throw new IllegalArgumentException("Anchor refers to a group that was removed".toString());
            }
            return anchor.getLocation$runtime_release();
        }
        ComposerKt.composeRuntimeError("Use active SlotWriter to determine anchor location instead".toString());
        throw new KotlinNothingValueException();
    }

    public final boolean ownsAnchor(Anchor anchor) {
        int access$search;
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        return anchor.getValid() && (access$search = SlotTableKt.access$search(this.anchors, anchor.getLocation$runtime_release(), this.groupsSize)) >= 0 && Intrinsics.areEqual(this.anchors.get(access$search), anchor);
    }

    public final boolean groupContainsAnchor(int i, Anchor anchor) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        if (!(!this.writer)) {
            ComposerKt.composeRuntimeError("Writer is active".toString());
            throw new KotlinNothingValueException();
        }
        if (i >= 0 && i < this.groupsSize) {
            if (ownsAnchor(anchor)) {
                int access$groupSize = SlotTableKt.access$groupSize(this.groups, i) + i;
                int location$runtime_release = anchor.getLocation$runtime_release();
                if (i <= location$runtime_release && location$runtime_release < access$groupSize) {
                    return true;
                }
            }
            return false;
        }
        ComposerKt.composeRuntimeError("Invalid group index".toString());
        throw new KotlinNothingValueException();
    }

    public final void close$runtime_release(SlotReader reader) {
        Intrinsics.checkNotNullParameter(reader, "reader");
        if (reader.getTable$runtime_release() == this && this.readers > 0) {
            this.readers--;
        } else {
            ComposerKt.composeRuntimeError("Unexpected reader close()".toString());
            throw new KotlinNothingValueException();
        }
    }

    public final void close$runtime_release(SlotWriter writer, int[] groups, int i, Object[] slots, int i2, ArrayList anchors) {
        Intrinsics.checkNotNullParameter(writer, "writer");
        Intrinsics.checkNotNullParameter(groups, "groups");
        Intrinsics.checkNotNullParameter(slots, "slots");
        Intrinsics.checkNotNullParameter(anchors, "anchors");
        if (writer.getTable$runtime_release() != this || !this.writer) {
            throw new IllegalArgumentException("Unexpected writer close()".toString());
        }
        this.writer = false;
        setTo$runtime_release(groups, i, slots, i2, anchors);
    }

    public final boolean containsMark() {
        return this.groupsSize > 0 && SlotTableKt.access$containsMark(this.groups, 0);
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return new GroupIterator(this, 0, this.groupsSize);
    }

    public final Anchor anchor(int i) {
        int i2;
        if (!(!this.writer)) {
            ComposerKt.composeRuntimeError("use active SlotWriter to create an anchor location instead ".toString());
            throw new KotlinNothingValueException();
        } else if (i < 0 || i >= (i2 = this.groupsSize)) {
            throw new IllegalArgumentException("Parameter index is out of range".toString());
        } else {
            ArrayList arrayList = this.anchors;
            int access$search = SlotTableKt.access$search(arrayList, i, i2);
            if (access$search < 0) {
                Anchor anchor = new Anchor(i);
                arrayList.add(-(access$search + 1), anchor);
                return anchor;
            }
            Object obj = arrayList.get(access$search);
            Intrinsics.checkNotNullExpressionValue(obj, "get(location)");
            return (Anchor) obj;
        }
    }
}
