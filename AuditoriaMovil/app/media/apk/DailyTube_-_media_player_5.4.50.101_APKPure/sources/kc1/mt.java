package kc1;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import kc1.r;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class mt extends fh {

    /* renamed from: gv  reason: collision with root package name */
    public static final n3 f9799gv = new n3(null);

    /* renamed from: zn  reason: collision with root package name */
    public static final i4 f9800zn = i4.f9789fb.y("application/x-www-form-urlencoded");

    /* renamed from: n3  reason: collision with root package name */
    public final List<String> f9801n3;
    public final List<String> y;

    /* loaded from: classes.dex */
    public static final class n3 {
        public n3() {
        }

        public /* synthetic */ n3(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes.dex */
    public static final class y {

        /* renamed from: n3  reason: collision with root package name */
        public final List<String> f9802n3;
        public final List<String> y;

        /* renamed from: zn  reason: collision with root package name */
        public final Charset f9803zn;

        public y() {
            this(null, 1, null);
        }

        public final y n3(String name, String value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            r.n3 n3Var = r.f9869t;
            this.y.add(r.n3.n3(n3Var, name, 0, 0, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, false, this.f9803zn, 83, null));
            this.f9802n3.add(r.n3.n3(n3Var, value, 0, 0, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, false, this.f9803zn, 83, null));
            return this;
        }

        public final y y(String name, String value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            r.n3 n3Var = r.f9869t;
            this.y.add(r.n3.n3(n3Var, name, 0, 0, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, false, this.f9803zn, 91, null));
            this.f9802n3.add(r.n3.n3(n3Var, value, 0, 0, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, false, this.f9803zn, 91, null));
            return this;
        }

        public final mt zn() {
            return new mt(this.y, this.f9802n3);
        }

        public y(Charset charset) {
            this.f9803zn = charset;
            this.y = new ArrayList();
            this.f9802n3 = new ArrayList();
        }

        public /* synthetic */ y(Charset charset, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : charset);
        }
    }

    public mt(List<String> encodedNames, List<String> encodedValues) {
        Intrinsics.checkNotNullParameter(encodedNames, "encodedNames");
        Intrinsics.checkNotNullParameter(encodedValues, "encodedValues");
        this.y = lc1.n3.j5(encodedNames);
        this.f9801n3 = lc1.n3.j5(encodedValues);
    }

    public final long a(zc1.a aVar, boolean z2) {
        zc1.v zn2;
        if (z2) {
            zn2 = new zc1.v();
        } else {
            Intrinsics.checkNotNull(aVar);
            zn2 = aVar.zn();
        }
        int size = this.y.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                zn2.w2(38);
            }
            zn2.ne(this.y.get(i));
            zn2.w2(61);
            zn2.ne(this.f9801n3.get(i));
        }
        if (z2) {
            long m2 = zn2.m();
            zn2.s();
            return m2;
        }
        return 0L;
    }

    @Override // kc1.fh
    public long contentLength() {
        return a(null, true);
    }

    @Override // kc1.fh
    public i4 contentType() {
        return f9800zn;
    }

    public final int gv() {
        return this.y.size();
    }

    public final String n3(int i) {
        return this.f9801n3.get(i);
    }

    public final String v(int i) {
        return r.n3.s(r.f9869t, n3(i), 0, 0, true, 3, null);
    }

    @Override // kc1.fh
    public void writeTo(zc1.a sink) throws IOException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        a(sink, false);
    }

    public final String y(int i) {
        return this.y.get(i);
    }

    public final String zn(int i) {
        return r.n3.s(r.f9869t, y(i), 0, 0, true, 3, null);
    }
}
