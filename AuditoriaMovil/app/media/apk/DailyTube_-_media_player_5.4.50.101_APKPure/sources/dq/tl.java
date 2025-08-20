package dq;

import android.net.Uri;
import androidx.annotation.Nullable;
import dq.wz;
import java.util.Collections;
import java.util.List;
import m1.m;
import z0.x4;
/* loaded from: classes.dex */
public abstract class tl {

    /* renamed from: a  reason: collision with root package name */
    public final List<fb> f7382a;

    /* renamed from: fb  reason: collision with root package name */
    public final List<fb> f7383fb;

    /* renamed from: gv  reason: collision with root package name */
    public final long f7384gv;

    /* renamed from: n3  reason: collision with root package name */
    public final m f7385n3;

    /* renamed from: s  reason: collision with root package name */
    public final t f7386s;

    /* renamed from: v  reason: collision with root package name */
    public final List<fb> f7387v;
    public final long y;

    /* renamed from: zn  reason: collision with root package name */
    public final x4<dq.n3> f7388zn;

    /* loaded from: classes.dex */
    public static class zn extends tl {

        /* renamed from: c5  reason: collision with root package name */
        public final Uri f7390c5;
        @Nullable

        /* renamed from: f  reason: collision with root package name */
        public final String f7391f;

        /* renamed from: i9  reason: collision with root package name */
        public final long f7392i9;
        @Nullable

        /* renamed from: t  reason: collision with root package name */
        public final t f7393t;
        @Nullable

        /* renamed from: tl  reason: collision with root package name */
        public final w f7394tl;

        public zn(long j2, m mVar, List<dq.n3> list, wz.v vVar, @Nullable List<fb> list2, List<fb> list3, List<fb> list4, @Nullable String str, long j4) {
            super(j2, mVar, list, vVar, list2, list3, list4);
            w wVar;
            this.f7390c5 = Uri.parse(list.get(0).y);
            t zn2 = vVar.zn();
            this.f7393t = zn2;
            this.f7391f = str;
            this.f7392i9 = j4;
            if (zn2 != null) {
                wVar = null;
            } else {
                wVar = new w(new t(null, 0L, j4));
            }
            this.f7394tl = wVar;
        }

        public static zn p(long j2, m mVar, String str, long j4, long j6, long j7, long j8, List<fb> list, @Nullable String str2, long j9) {
            return new zn(j2, mVar, x4.o(new dq.n3(str)), new wz.v(new t(null, j4, (j6 - j4) + 1), 1L, 0L, j7, (j8 - j7) + 1), list, x4.j5(), x4.j5(), str2, j9);
        }

        @Override // dq.tl
        @Nullable
        public String f() {
            return this.f7391f;
        }

        @Override // dq.tl
        @Nullable
        public zr.s t() {
            return this.f7394tl;
        }

        @Override // dq.tl
        @Nullable
        public t tl() {
            return this.f7393t;
        }
    }

    public static tl w(long j2, m mVar, List<dq.n3> list, wz wzVar, @Nullable List<fb> list2, List<fb> list3, List<fb> list4, @Nullable String str) {
        if (wzVar instanceof wz.v) {
            return new zn(j2, mVar, list, (wz.v) wzVar, list2, list3, list4, str, -1L);
        }
        if (wzVar instanceof wz.y) {
            return new n3(j2, mVar, list, (wz.y) wzVar, list2, list3, list4);
        }
        throw new IllegalArgumentException("segmentBase must be of type SingleSegmentBase or MultiSegmentBase");
    }

    public static tl xc(long j2, m mVar, List<dq.n3> list, wz wzVar) {
        return w(j2, mVar, list, wzVar, null, x4.j5(), x4.j5(), null);
    }

    @Nullable
    public abstract String f();

    @Nullable
    public abstract zr.s t();

    @Nullable
    public abstract t tl();

    @Nullable
    public t wz() {
        return this.f7386s;
    }

    public tl(long j2, m mVar, List<dq.n3> list, wz wzVar, @Nullable List<fb> list2, List<fb> list3, List<fb> list4) {
        List<fb> unmodifiableList;
        v5.y.y(!list.isEmpty());
        this.y = j2;
        this.f7385n3 = mVar;
        this.f7388zn = x4.d(list);
        if (list2 == null) {
            unmodifiableList = Collections.emptyList();
        } else {
            unmodifiableList = Collections.unmodifiableList(list2);
        }
        this.f7387v = unmodifiableList;
        this.f7382a = list3;
        this.f7383fb = list4;
        this.f7386s = wzVar.y(this);
        this.f7384gv = wzVar.n3();
    }

    /* loaded from: classes.dex */
    public static class n3 extends tl implements zr.s {

        /* renamed from: c5  reason: collision with root package name */
        public final wz.y f7389c5;

        public n3(long j2, m mVar, List<dq.n3> list, wz.y yVar, @Nullable List<fb> list2, List<fb> list3, List<fb> list4) {
            super(j2, mVar, list, yVar, list2, list3, list4);
            this.f7389c5 = yVar;
        }

        @Override // zr.s
        public long a(long j2, long j4) {
            return this.f7389c5.c5(j2, j4);
        }

        @Override // zr.s
        public long c5() {
            return this.f7389c5.v();
        }

        @Override // dq.tl
        @Nullable
        public String f() {
            return null;
        }

        @Override // zr.s
        public long fb(long j2) {
            return this.f7389c5.fb(j2);
        }

        @Override // zr.s
        public long gv(long j2, long j4) {
            return this.f7389c5.a(j2, j4);
        }

        @Override // zr.s
        public long i9(long j2, long j4) {
            return this.f7389c5.zn(j2, j4);
        }

        @Override // zr.s
        public long n3(long j2) {
            return this.f7389c5.i9(j2);
        }

        @Override // zr.s
        public boolean s() {
            return this.f7389c5.t();
        }

        @Override // dq.tl
        @Nullable
        public t tl() {
            return null;
        }

        @Override // zr.s
        public t v(long j2) {
            return this.f7389c5.f(this, j2);
        }

        @Override // zr.s
        public long y(long j2, long j4) {
            return this.f7389c5.s(j2, j4);
        }

        @Override // zr.s
        public long zn(long j2, long j4) {
            return this.f7389c5.gv(j2, j4);
        }

        @Override // dq.tl
        public zr.s t() {
            return this;
        }
    }
}
