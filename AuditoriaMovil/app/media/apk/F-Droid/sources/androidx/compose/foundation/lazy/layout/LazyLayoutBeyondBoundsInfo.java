package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.collection.MutableVector;
import ch.qos.logback.core.CoreConstants;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: LazyLayoutBeyondBoundsInfo.kt */
/* loaded from: classes.dex */
public final class LazyLayoutBeyondBoundsInfo {
    private final MutableVector beyondBoundsItems = new MutableVector(new Interval[16], 0);

    public final Interval addInterval(int i, int i2) {
        Interval interval = new Interval(i, i2);
        this.beyondBoundsItems.add(interval);
        return interval;
    }

    public final void removeInterval(Interval interval) {
        Intrinsics.checkNotNullParameter(interval, "interval");
        this.beyondBoundsItems.remove(interval);
    }

    public final boolean hasIntervals() {
        return this.beyondBoundsItems.isNotEmpty();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int getStart() {
        /*
            r6 = this;
            androidx.compose.runtime.collection.MutableVector r0 = r6.beyondBoundsItems
            java.lang.Object r0 = r0.first()
            androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsInfo$Interval r0 = (androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsInfo.Interval) r0
            int r0 = r0.getStart()
            androidx.compose.runtime.collection.MutableVector r1 = r6.beyondBoundsItems
            int r2 = r1.getSize()
            if (r2 <= 0) goto L2b
            java.lang.Object[] r1 = r1.getContent()
            r3 = 0
        L19:
            r4 = r1[r3]
            androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsInfo$Interval r4 = (androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsInfo.Interval) r4
            int r5 = r4.getStart()
            if (r5 >= r0) goto L27
            int r0 = r4.getStart()
        L27:
            int r3 = r3 + 1
            if (r3 < r2) goto L19
        L2b:
            if (r0 < 0) goto L2e
            return r0
        L2e:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Failed requirement."
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsInfo.getStart():int");
    }

    public final int getEnd() {
        int end = ((Interval) this.beyondBoundsItems.first()).getEnd();
        MutableVector mutableVector = this.beyondBoundsItems;
        int size = mutableVector.getSize();
        if (size > 0) {
            Object[] content = mutableVector.getContent();
            int i = 0;
            do {
                Interval interval = (Interval) content[i];
                if (interval.getEnd() > end) {
                    end = interval.getEnd();
                }
                i++;
            } while (i < size);
            return end;
        }
        return end;
    }

    /* compiled from: LazyLayoutBeyondBoundsInfo.kt */
    /* loaded from: classes.dex */
    public static final class Interval {
        private final int end;
        private final int start;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Interval) {
                Interval interval = (Interval) obj;
                return this.start == interval.start && this.end == interval.end;
            }
            return false;
        }

        public final int getEnd() {
            return this.end;
        }

        public final int getStart() {
            return this.start;
        }

        public int hashCode() {
            return (this.start * 31) + this.end;
        }

        public String toString() {
            return "Interval(start=" + this.start + ", end=" + this.end + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public Interval(int i, int i2) {
            this.start = i;
            this.end = i2;
            if (i < 0) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (i2 < i) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
        }
    }
}
