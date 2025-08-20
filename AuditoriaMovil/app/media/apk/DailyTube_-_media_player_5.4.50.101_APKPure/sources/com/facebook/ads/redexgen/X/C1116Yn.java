package com.facebook.ads.redexgen.X;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import com.facebook.ads.internal.context.Repairable;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicReference;
/* renamed from: com.facebook.ads.redexgen.X.Yn  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1116Yn extends C04447f {
    public static String[] A06 = {"X2XwTp9cKPrsKt8nnsNrr4kzY8H6fo9U", "SYDx4pa2oLtOnCxt4l9slcAsJVX17", "Ktbncp6BUHUyG8VpVa87zDZ4pVgXb", "697llskWaiD0", "zjkPaZGeICZRQbBHOdPJm8zqRs5ofq42", "OjtN7hHvLZrci2lMJuqCcc7IsxYWRGMj", "Pfr7ktMWLkOUKtldLLax33ooDo", "AIe8uS1x9EYXvM4HhYe86uhhSayJeZWe"};
    public WeakReference<Activity> A00;
    public WeakHashMap<Repairable, Boolean> A01;
    public final C04417c A02;
    public final AtomicReference<Object> A03;
    public final AtomicReference<Object> A04;
    public final AtomicReference<C0S> A05;

    public C1116Yn(Activity activity, InterfaceC04457h interfaceC04457h, C0S c0s) {
        super(activity.getApplicationContext(), interfaceC04457h);
        this.A01 = new WeakHashMap<>();
        AtomicReference<C0S> atomicReference = new AtomicReference<>();
        this.A05 = atomicReference;
        this.A03 = new AtomicReference<>();
        this.A02 = new C04417c();
        this.A04 = new AtomicReference<>();
        atomicReference.set(c0s);
        this.A00 = new WeakReference<>(activity);
    }

    public C1116Yn(Context context, InterfaceC04457h interfaceC04457h, C0S c0s) {
        super(context.getApplicationContext(), interfaceC04457h);
        this.A01 = new WeakHashMap<>();
        AtomicReference<C0S> atomicReference = new AtomicReference<>();
        this.A05 = atomicReference;
        this.A03 = new AtomicReference<>();
        this.A02 = new C04417c();
        this.A04 = new AtomicReference<>();
        atomicReference.set(c0s);
        Activity A00 = A00(context);
        if (A00 != null) {
            this.A00 = new WeakReference<>(A00);
        } else {
            this.A00 = new WeakReference<>(null);
        }
    }

    public static Activity A00(Context context) {
        while (true) {
            boolean z2 = context instanceof ContextWrapper;
            if (A06[3].length() != 12) {
                throw new RuntimeException();
            }
            A06[6] = "yJQbBA22nGzLcakEAa6nG1va8g";
            if (z2) {
                if (context instanceof Activity) {
                    return (Activity) context;
                }
                if ((context instanceof C1116Yn) && ((C1116Yn) context).A0D() != null) {
                    return ((C1116Yn) context).A0D();
                }
                context = ((ContextWrapper) context).getBaseContext();
            } else {
                return null;
            }
        }
    }

    public final Activity A0D() {
        return this.A00.get();
    }

    public C0S A0E() {
        C0S funnel = this.A05.get();
        if (funnel == null) {
            return new C1251bb();
        }
        return funnel;
    }

    public final C04417c A0F() {
        return this.A02;
    }

    public final Object A0G() {
        return this.A03.get();
    }

    public final Object A0H() {
        return this.A04.get();
    }

    public final void A0I(Activity activity) {
        this.A00 = new WeakReference<>(activity);
    }

    public final void A0J(C0S c0s) {
        this.A05.set(c0s);
    }

    public final void A0K(C1116Yn c1116Yn) {
        c1116Yn.A01.putAll(this.A01);
        this.A01 = c1116Yn.A01;
    }

    public final void A0L(Repairable repairable) {
        this.A01.put(repairable, true);
    }

    public final void A0M(Object obj) {
        this.A03.set(obj);
    }

    public final void A0N(Object obj) {
        this.A04.set(obj);
    }

    public final void A0O(Throwable th) {
        for (Map.Entry<Repairable, Boolean> entry : this.A01.entrySet()) {
            if (A06[3].length() != 12) {
                throw new RuntimeException();
            }
            A06[7] = "uNK1zxgBt2FFcnYPdsvApaChXeSIkfOy";
            entry.getKey().repair(th);
        }
    }
}
