package oc1;

import kotlin.jvm.functions.Function0;
/* loaded from: classes.dex */
public final class zn extends y {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f12259a;

    /* renamed from: fb  reason: collision with root package name */
    public final /* synthetic */ boolean f12260fb;

    /* renamed from: v  reason: collision with root package name */
    public final /* synthetic */ Function0 f12261v;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zn(Function0 function0, String str, boolean z2, String str2, boolean z3) {
        super(str2, z3);
        this.f12261v = function0;
        this.f12259a = str;
        this.f12260fb = z2;
    }

    @Override // oc1.y
    public long a() {
        this.f12261v.invoke();
        return -1L;
    }
}
