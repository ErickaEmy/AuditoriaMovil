package androidx.compose.ui.input.pointer.util;

import androidx.compose.animation.FlingCalculator$FlingInfo$$ExternalSyntheticBackport0;
import ch.qos.logback.core.CoreConstants;
/* compiled from: VelocityTracker.kt */
/* loaded from: classes.dex */
public final class DataPointAtTime {
    private float dataPoint;
    private long time;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DataPointAtTime) {
            DataPointAtTime dataPointAtTime = (DataPointAtTime) obj;
            return this.time == dataPointAtTime.time && Float.compare(this.dataPoint, dataPointAtTime.dataPoint) == 0;
        }
        return false;
    }

    public final float getDataPoint() {
        return this.dataPoint;
    }

    public final long getTime() {
        return this.time;
    }

    public int hashCode() {
        return (FlingCalculator$FlingInfo$$ExternalSyntheticBackport0.m(this.time) * 31) + Float.floatToIntBits(this.dataPoint);
    }

    public final void setDataPoint(float f) {
        this.dataPoint = f;
    }

    public final void setTime(long j) {
        this.time = j;
    }

    public String toString() {
        return "DataPointAtTime(time=" + this.time + ", dataPoint=" + this.dataPoint + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public DataPointAtTime(long j, float f) {
        this.time = j;
        this.dataPoint = f;
    }
}
