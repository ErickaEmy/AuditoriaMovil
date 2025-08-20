package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.content.ContextWrapper;
import java.util.concurrent.atomic.AtomicReference;
/* renamed from: com.facebook.ads.redexgen.X.7f  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C04447f extends ContextWrapper {
    public final InterfaceC04457h A00;
    public final AtomicReference<String> A01;

    public C04447f(Context context, InterfaceC04457h interfaceC04457h) {
        super(context.getApplicationContext());
        this.A01 = new AtomicReference<>();
        this.A00 = interfaceC04457h;
    }

    public final InterfaceC04256g A00() {
        return this.A00.A6L();
    }

    public final C1115Ym A01() {
        return this.A00.A7r(this);
    }

    public final C7g A02() {
        return this.A00.A6A(this);
    }

    public final InterfaceC04467i A03() {
        return this.A00.A6v(this);
    }

    public final C7k A04() {
        return this.A00.A7q(this);
    }

    public final InterfaceC04487l A05() {
        return this.A00.A86();
    }

    public final InterfaceC04567w A06() {
        return this.A00.A6j(this);
    }

    public final AnonymousClass89 A07() {
        return this.A00.A6l(this);
    }

    public final C04628c A08() {
        return this.A00.A7y();
    }

    public final J2 A09() {
        return this.A00.A5u(A01());
    }

    public final JE A0A() {
        return this.A00.A7s(A01());
    }

    public final String A0B() {
        return this.A01.get();
    }

    public final void A0C(String str) {
        this.A01.set(str);
    }
}
