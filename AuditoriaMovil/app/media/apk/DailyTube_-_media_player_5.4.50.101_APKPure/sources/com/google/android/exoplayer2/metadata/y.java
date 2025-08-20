package com.google.android.exoplayer2.metadata;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.Metadata;
import hd.gv;
import hd.n3;
import hd.v;
import hd.zn;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import m1.a;
import m1.g;
import m1.hk;
import m1.m;
import v5.j5;
/* loaded from: classes.dex */
public final class y extends a implements Handler.Callback {

    /* renamed from: b  reason: collision with root package name */
    public boolean f4319b;

    /* renamed from: c  reason: collision with root package name */
    public final zn f4320c;

    /* renamed from: d  reason: collision with root package name */
    public final gv f4321d;

    /* renamed from: d0  reason: collision with root package name */
    public final v f4322d0;

    /* renamed from: ej  reason: collision with root package name */
    public final boolean f4323ej;
    @Nullable

    /* renamed from: fh  reason: collision with root package name */
    public final Handler f4324fh;

    /* renamed from: j  reason: collision with root package name */
    public long f4325j;

    /* renamed from: j5  reason: collision with root package name */
    public boolean f4326j5;
    @Nullable

    /* renamed from: o  reason: collision with root package name */
    public Metadata f4327o;

    /* renamed from: qn  reason: collision with root package name */
    public long f4328qn;
    @Nullable

    /* renamed from: x  reason: collision with root package name */
    public n3 f4329x;

    public y(v vVar, @Nullable Looper looper) {
        this(vVar, looper, zn.y);
    }

    @Override // m1.zq
    public boolean a() {
        return this.f4326j5;
    }

    @Override // m1.a
    public void b(m[] mVarArr, long j2, long j4) {
        this.f4329x = this.f4320c.y(mVarArr[0]);
        Metadata metadata = this.f4327o;
        if (metadata != null) {
            this.f4327o = metadata.zn((metadata.f4218v + this.f4325j) - j4);
        }
        this.f4325j = j4;
    }

    @Override // m1.a
    public void d() {
        this.f4327o = null;
        this.f4329x = null;
        this.f4325j = -9223372036854775807L;
    }

    @Override // m1.a
    public void ej(long j2, boolean z2) {
        this.f4327o = null;
        this.f4319b = false;
        this.f4326j5 = false;
    }

    @Override // m1.zq, m1.k3
    public String getName() {
        return "MetadataRenderer";
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 0) {
            o((Metadata) message.obj);
            return true;
        }
        throw new IllegalStateException();
    }

    public final void hw(Metadata metadata, List<Metadata.Entry> list) {
        for (int i = 0; i < metadata.v(); i++) {
            m co2 = metadata.gv(i).co();
            if (co2 != null && this.f4320c.n3(co2)) {
                n3 y = this.f4320c.y(co2);
                byte[] bArr = (byte[]) v5.y.v(metadata.gv(i).w2());
                this.f4321d.a();
                this.f4321d.mt(bArr.length);
                ((ByteBuffer) j5.i9(this.f4321d.f56fb)).put(bArr);
                this.f4321d.co();
                Metadata y2 = y.y(this.f4321d);
                if (y2 != null) {
                    hw(y2, list);
                }
            } else {
                list.add(metadata.gv(i));
            }
        }
    }

    @Override // m1.zq
    public boolean isReady() {
        return true;
    }

    public final boolean j(long j2) {
        boolean z2;
        Metadata metadata = this.f4327o;
        if (metadata != null && (this.f4323ej || metadata.f4218v <= j5(j2))) {
            qn(this.f4327o);
            this.f4327o = null;
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.f4319b && this.f4327o == null) {
            this.f4326j5 = true;
        }
        return z2;
    }

    public final long j5(long j2) {
        boolean z2;
        boolean z3 = false;
        if (j2 != -9223372036854775807L) {
            z2 = true;
        } else {
            z2 = false;
        }
        v5.y.fb(z2);
        if (this.f4325j != -9223372036854775807L) {
            z3 = true;
        }
        v5.y.fb(z3);
        return j2 - this.f4325j;
    }

    @Override // m1.k3
    public int n3(m mVar) {
        int i;
        if (this.f4320c.n3(mVar)) {
            if (mVar.f10971y5 == 0) {
                i = 4;
            } else {
                i = 2;
            }
            return hk.y(i);
        }
        return hk.y(0);
    }

    public final void o(Metadata metadata) {
        this.f4322d0.onMetadata(metadata);
    }

    public final void oz() {
        if (!this.f4319b && this.f4327o == null) {
            this.f4321d.a();
            g d02 = d0();
            int k52 = k5(d02, this.f4321d, 0);
            if (k52 == -4) {
                if (this.f4321d.t()) {
                    this.f4319b = true;
                    return;
                }
                gv gvVar = this.f4321d;
                gvVar.f8923co = this.f4328qn;
                gvVar.co();
                Metadata y = ((n3) j5.i9(this.f4329x)).y(this.f4321d);
                if (y != null) {
                    ArrayList arrayList = new ArrayList(y.v());
                    hw(y, arrayList);
                    if (!arrayList.isEmpty()) {
                        this.f4327o = new Metadata(j5(this.f4321d.f55f), arrayList);
                    }
                }
            } else if (k52 == -5) {
                this.f4328qn = ((m) v5.y.v(d02.f10757n3)).f10951fh;
            }
        }
    }

    public final void qn(Metadata metadata) {
        Handler handler = this.f4324fh;
        if (handler != null) {
            handler.obtainMessage(0, metadata).sendToTarget();
        } else {
            o(metadata);
        }
    }

    @Override // m1.zq
    public void z(long j2, long j4) {
        boolean z2 = true;
        while (z2) {
            oz();
            z2 = j(j2);
        }
    }

    public y(v vVar, @Nullable Looper looper, zn znVar) {
        this(vVar, looper, znVar, false);
    }

    public y(v vVar, @Nullable Looper looper, zn znVar, boolean z2) {
        super(5);
        this.f4322d0 = (v) v5.y.v(vVar);
        this.f4324fh = looper == null ? null : j5.x4(looper, this);
        this.f4320c = (zn) v5.y.v(znVar);
        this.f4323ej = z2;
        this.f4321d = new gv();
        this.f4325j = -9223372036854775807L;
    }
}
