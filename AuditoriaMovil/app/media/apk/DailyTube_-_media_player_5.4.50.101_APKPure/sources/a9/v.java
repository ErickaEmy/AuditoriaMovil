package a9;

import v5.j5;
/* loaded from: classes.dex */
public final class v {

    /* renamed from: a  reason: collision with root package name */
    public int f76a;

    /* renamed from: c5  reason: collision with root package name */
    public int f77c5;

    /* renamed from: f  reason: collision with root package name */
    public long f78f;

    /* renamed from: fb  reason: collision with root package name */
    public int f79fb;

    /* renamed from: gv  reason: collision with root package name */
    public int f80gv;

    /* renamed from: i9  reason: collision with root package name */
    public int f81i9;

    /* renamed from: n3  reason: collision with root package name */
    public int f82n3;

    /* renamed from: s  reason: collision with root package name */
    public int f83s;

    /* renamed from: t  reason: collision with root package name */
    public int f84t;

    /* renamed from: v  reason: collision with root package name */
    public int f85v;
    public int y;

    /* renamed from: zn  reason: collision with root package name */
    public int f86zn;

    public final void n3(long j2, int i) {
        this.f78f += j2;
        this.f84t += i;
    }

    public String toString() {
        return j5.rz("DecoderCounters {\n decoderInits=%s,\n decoderReleases=%s\n queuedInputBuffers=%s\n skippedInputBuffers=%s\n renderedOutputBuffers=%s\n skippedOutputBuffers=%s\n droppedBuffers=%s\n droppedInputBuffers=%s\n maxConsecutiveDroppedBuffers=%s\n droppedToKeyframeEvents=%s\n totalVideoFrameProcessingOffsetUs=%s\n videoFrameProcessingOffsetCount=%s\n}", Integer.valueOf(this.y), Integer.valueOf(this.f82n3), Integer.valueOf(this.f86zn), Integer.valueOf(this.f80gv), Integer.valueOf(this.f85v), Integer.valueOf(this.f76a), Integer.valueOf(this.f79fb), Integer.valueOf(this.f83s), Integer.valueOf(this.f77c5), Integer.valueOf(this.f81i9), Long.valueOf(this.f78f), Integer.valueOf(this.f84t));
    }

    public void y(long j2) {
        n3(j2, 1);
    }

    public synchronized void zn() {
    }
}
