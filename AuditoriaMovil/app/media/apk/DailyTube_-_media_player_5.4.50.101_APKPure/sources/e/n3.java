package e;

import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.Deferred;
import r.zn;
/* loaded from: classes.dex */
public final class n3 {

    /* loaded from: classes.dex */
    public static final class y extends Lambda implements Function1<Throwable, Unit> {
        final /* synthetic */ zn.y<T> $completer;
        final /* synthetic */ Deferred<T> $this_asListenableFuture;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public y(zn.y<T> yVar, Deferred<? extends T> deferred) {
            super(1);
            this.$completer = yVar;
            this.$this_asListenableFuture = deferred;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            invoke2(th);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable th) {
            if (th != null) {
                if (th instanceof CancellationException) {
                    this.$completer.zn();
                    return;
                } else {
                    this.$completer.v(th);
                    return;
                }
            }
            this.$completer.n3(this.$this_asListenableFuture.getCompleted());
        }
    }

    public static final Object gv(Deferred this_asListenableFuture, Object obj, zn.y completer) {
        Intrinsics.checkNotNullParameter(this_asListenableFuture, "$this_asListenableFuture");
        Intrinsics.checkNotNullParameter(completer, "completer");
        this_asListenableFuture.invokeOnCompletion(new y(completer, this_asListenableFuture));
        return obj;
    }

    public static final <T> f1.zn<T> n3(final Deferred<? extends T> deferred, final Object obj) {
        Intrinsics.checkNotNullParameter(deferred, "<this>");
        f1.zn<T> y2 = zn.y(new zn.InterfaceC0192zn() { // from class: e.y
            @Override // r.zn.InterfaceC0192zn
            public final Object y(zn.y yVar) {
                Object gv2;
                gv2 = n3.gv(Deferred.this, obj, yVar);
                return gv2;
            }
        });
        Intrinsics.checkNotNullExpressionValue(y2, "getFuture { completer ->…        }\n    }\n    tag\n}");
        return y2;
    }

    public static /* synthetic */ f1.zn zn(Deferred deferred, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = "Deferred.asListenableFuture";
        }
        return n3(deferred, obj);
    }
}
