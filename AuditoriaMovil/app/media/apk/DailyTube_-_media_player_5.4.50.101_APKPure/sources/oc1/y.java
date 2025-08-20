package oc1;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public abstract class y {

    /* renamed from: gv  reason: collision with root package name */
    public final boolean f12256gv;

    /* renamed from: n3  reason: collision with root package name */
    public long f12257n3;
    public gv y;

    /* renamed from: zn  reason: collision with root package name */
    public final String f12258zn;

    public y(String name, boolean z2) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.f12258zn = name;
        this.f12256gv = z2;
        this.f12257n3 = -1L;
    }

    public abstract long a();

    public final void fb(long j2) {
        this.f12257n3 = j2;
    }

    public final gv gv() {
        return this.y;
    }

    public final String n3() {
        return this.f12258zn;
    }

    public String toString() {
        return this.f12258zn;
    }

    public final void v(gv queue) {
        boolean z2;
        Intrinsics.checkNotNullParameter(queue, "queue");
        gv gvVar = this.y;
        if (gvVar == queue) {
            return;
        }
        if (gvVar == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            this.y = queue;
            return;
        }
        throw new IllegalStateException("task is in multiple queues");
    }

    public final boolean y() {
        return this.f12256gv;
    }

    public final long zn() {
        return this.f12257n3;
    }

    public /* synthetic */ y(String str, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? true : z2);
    }
}
