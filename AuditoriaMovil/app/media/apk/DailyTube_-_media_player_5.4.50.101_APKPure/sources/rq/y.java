package rq;

import kotlin.Lazy;
import kotlin.LazyKt;
/* loaded from: classes.dex */
public final class y extends n3 {
    public static final y y = new y();

    /* renamed from: n3  reason: collision with root package name */
    public static final Lazy f13339n3 = LazyKt.lazy(y.y);

    public y() {
        super(null);
    }

    @Override // rq.n3
    public sq.n3 zn() {
        return (sq.n3) f13339n3.getValue();
    }
}
