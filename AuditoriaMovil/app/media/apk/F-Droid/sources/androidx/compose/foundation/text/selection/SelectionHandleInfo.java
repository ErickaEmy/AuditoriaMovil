package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.Handle;
import androidx.compose.ui.geometry.Offset;
import ch.qos.logback.core.CoreConstants;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SelectionHandles.kt */
/* loaded from: classes.dex */
public final class SelectionHandleInfo {
    private final Handle handle;
    private final long position;

    public /* synthetic */ SelectionHandleInfo(Handle handle, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(handle, j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SelectionHandleInfo) {
            SelectionHandleInfo selectionHandleInfo = (SelectionHandleInfo) obj;
            return this.handle == selectionHandleInfo.handle && Offset.m706equalsimpl0(this.position, selectionHandleInfo.position);
        }
        return false;
    }

    public int hashCode() {
        return (this.handle.hashCode() * 31) + Offset.m711hashCodeimpl(this.position);
    }

    public String toString() {
        return "SelectionHandleInfo(handle=" + this.handle + ", position=" + ((Object) Offset.m716toStringimpl(this.position)) + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    private SelectionHandleInfo(Handle handle, long j) {
        Intrinsics.checkNotNullParameter(handle, "handle");
        this.handle = handle;
        this.position = j;
    }
}
