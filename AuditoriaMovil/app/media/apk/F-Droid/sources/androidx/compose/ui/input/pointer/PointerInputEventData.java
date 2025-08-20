package androidx.compose.ui.input.pointer;

import androidx.compose.animation.FlingCalculator$FlingInfo$$ExternalSyntheticBackport0;
import androidx.compose.ui.geometry.Offset;
import ch.qos.logback.core.CoreConstants;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: InternalPointerInput.kt */
/* loaded from: classes.dex */
public final class PointerInputEventData {
    private final boolean down;
    private final List historical;
    private final long id;
    private final boolean issuesEnterExit;
    private final long position;
    private final long positionOnScreen;
    private final float pressure;
    private final long scrollDelta;
    private final int type;
    private final long uptime;

    public /* synthetic */ PointerInputEventData(long j, long j2, long j3, long j4, boolean z, float f, int i, boolean z2, List list, long j5, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, z, f, i, z2, list, j5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PointerInputEventData) {
            PointerInputEventData pointerInputEventData = (PointerInputEventData) obj;
            return PointerId.m1188equalsimpl0(this.id, pointerInputEventData.id) && this.uptime == pointerInputEventData.uptime && Offset.m706equalsimpl0(this.positionOnScreen, pointerInputEventData.positionOnScreen) && Offset.m706equalsimpl0(this.position, pointerInputEventData.position) && this.down == pointerInputEventData.down && Float.compare(this.pressure, pointerInputEventData.pressure) == 0 && PointerType.m1215equalsimpl0(this.type, pointerInputEventData.type) && this.issuesEnterExit == pointerInputEventData.issuesEnterExit && Intrinsics.areEqual(this.historical, pointerInputEventData.historical) && Offset.m706equalsimpl0(this.scrollDelta, pointerInputEventData.scrollDelta);
        }
        return false;
    }

    public final boolean getDown() {
        return this.down;
    }

    public final List getHistorical() {
        return this.historical;
    }

    /* renamed from: getId-J3iCeTQ  reason: not valid java name */
    public final long m1201getIdJ3iCeTQ() {
        return this.id;
    }

    public final boolean getIssuesEnterExit() {
        return this.issuesEnterExit;
    }

    /* renamed from: getPosition-F1C5BW0  reason: not valid java name */
    public final long m1202getPositionF1C5BW0() {
        return this.position;
    }

    /* renamed from: getPositionOnScreen-F1C5BW0  reason: not valid java name */
    public final long m1203getPositionOnScreenF1C5BW0() {
        return this.positionOnScreen;
    }

    public final float getPressure() {
        return this.pressure;
    }

    /* renamed from: getScrollDelta-F1C5BW0  reason: not valid java name */
    public final long m1204getScrollDeltaF1C5BW0() {
        return this.scrollDelta;
    }

    /* renamed from: getType-T8wyACA  reason: not valid java name */
    public final int m1205getTypeT8wyACA() {
        return this.type;
    }

    public final long getUptime() {
        return this.uptime;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int m1189hashCodeimpl = ((((((PointerId.m1189hashCodeimpl(this.id) * 31) + FlingCalculator$FlingInfo$$ExternalSyntheticBackport0.m(this.uptime)) * 31) + Offset.m711hashCodeimpl(this.positionOnScreen)) * 31) + Offset.m711hashCodeimpl(this.position)) * 31;
        boolean z = this.down;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int floatToIntBits = (((((m1189hashCodeimpl + i) * 31) + Float.floatToIntBits(this.pressure)) * 31) + PointerType.m1216hashCodeimpl(this.type)) * 31;
        boolean z2 = this.issuesEnterExit;
        return ((((floatToIntBits + (z2 ? 1 : z2 ? 1 : 0)) * 31) + this.historical.hashCode()) * 31) + Offset.m711hashCodeimpl(this.scrollDelta);
    }

    public String toString() {
        return "PointerInputEventData(id=" + ((Object) PointerId.m1190toStringimpl(this.id)) + ", uptime=" + this.uptime + ", positionOnScreen=" + ((Object) Offset.m716toStringimpl(this.positionOnScreen)) + ", position=" + ((Object) Offset.m716toStringimpl(this.position)) + ", down=" + this.down + ", pressure=" + this.pressure + ", type=" + ((Object) PointerType.m1217toStringimpl(this.type)) + ", issuesEnterExit=" + this.issuesEnterExit + ", historical=" + this.historical + ", scrollDelta=" + ((Object) Offset.m716toStringimpl(this.scrollDelta)) + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    private PointerInputEventData(long j, long j2, long j3, long j4, boolean z, float f, int i, boolean z2, List historical, long j5) {
        Intrinsics.checkNotNullParameter(historical, "historical");
        this.id = j;
        this.uptime = j2;
        this.positionOnScreen = j3;
        this.position = j4;
        this.down = z;
        this.pressure = f;
        this.type = i;
        this.issuesEnterExit = z2;
        this.historical = historical;
        this.scrollDelta = j5;
    }
}
