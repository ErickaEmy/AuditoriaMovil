package yg;

import android.adservices.measurement.DeletionRequest;
import android.adservices.measurement.MeasurementManager;
import android.adservices.measurement.WebSourceRegistrationRequest;
import android.adservices.measurement.WebTriggerRegistrationRequest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.view.InputEvent;
import b.wz;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
/* loaded from: classes.dex */
public abstract class zn {
    public static final n3 y = new n3(null);

    /* loaded from: classes.dex */
    public static final class n3 {
        public /* synthetic */ n3(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @SuppressLint({"NewApi", "ClassVerificationFailure"})
        public final zn y(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (ra.y.y.y() >= 5) {
                return new y(context);
            }
            return null;
        }

        public n3() {
        }
    }

    public abstract Object a(v vVar, Continuation<? super Unit> continuation);

    public abstract Object gv(Uri uri, Continuation<? super Unit> continuation);

    public abstract Object n3(Continuation<? super Integer> continuation);

    public abstract Object v(gv gvVar, Continuation<? super Unit> continuation);

    public abstract Object y(yg.y yVar, Continuation<? super Unit> continuation);

    public abstract Object zn(Uri uri, InputEvent inputEvent, Continuation<? super Unit> continuation);

    @SuppressLint({"NewApi", "ClassVerificationFailure"})
    /* loaded from: classes.dex */
    public static final class y extends zn {

        /* renamed from: n3  reason: collision with root package name */
        public final MeasurementManager f15341n3;

        public y(MeasurementManager mMeasurementManager) {
            Intrinsics.checkNotNullParameter(mMeasurementManager, "mMeasurementManager");
            this.f15341n3 = mMeasurementManager;
        }

        @Override // yg.zn
        public Object a(v vVar, Continuation<? super Unit> continuation) {
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
            cancellableContinuationImpl.initCancellability();
            this.f15341n3.registerWebTrigger(tl(vVar), new yg.n3(), wz.y(cancellableContinuationImpl));
            Object result = cancellableContinuationImpl.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return result;
            }
            return Unit.INSTANCE;
        }

        public final DeletionRequest f(yg.y yVar) {
            new DeletionRequest.Builder();
            throw null;
        }

        @Override // yg.zn
        public Object gv(Uri uri, Continuation<? super Unit> continuation) {
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
            cancellableContinuationImpl.initCancellability();
            this.f15341n3.registerTrigger(uri, new yg.n3(), wz.y(cancellableContinuationImpl));
            Object result = cancellableContinuationImpl.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return result;
            }
            return Unit.INSTANCE;
        }

        @Override // yg.zn
        public Object n3(Continuation<? super Integer> continuation) {
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
            cancellableContinuationImpl.initCancellability();
            this.f15341n3.getMeasurementApiStatus(new yg.n3(), wz.y(cancellableContinuationImpl));
            Object result = cancellableContinuationImpl.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return result;
        }

        public final WebSourceRegistrationRequest t(gv gvVar) {
            throw null;
        }

        public final WebTriggerRegistrationRequest tl(v vVar) {
            throw null;
        }

        @Override // yg.zn
        public Object v(gv gvVar, Continuation<? super Unit> continuation) {
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
            cancellableContinuationImpl.initCancellability();
            this.f15341n3.registerWebSource(t(gvVar), new yg.n3(), wz.y(cancellableContinuationImpl));
            Object result = cancellableContinuationImpl.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return result;
            }
            return Unit.INSTANCE;
        }

        @Override // yg.zn
        public Object y(yg.y yVar, Continuation<? super Unit> continuation) {
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
            cancellableContinuationImpl.initCancellability();
            this.f15341n3.deleteRegistrations(f(yVar), new yg.n3(), wz.y(cancellableContinuationImpl));
            Object result = cancellableContinuationImpl.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return result;
            }
            return Unit.INSTANCE;
        }

        @Override // yg.zn
        public Object zn(Uri uri, InputEvent inputEvent, Continuation<? super Unit> continuation) {
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
            cancellableContinuationImpl.initCancellability();
            this.f15341n3.registerSource(uri, inputEvent, new yg.n3(), wz.y(cancellableContinuationImpl));
            Object result = cancellableContinuationImpl.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return result;
            }
            return Unit.INSTANCE;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public y(android.content.Context r2) {
            /*
                r1 = this;
                java.lang.String r0 = "context"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
                java.lang.Class<android.adservices.measurement.MeasurementManager> r0 = android.adservices.measurement.MeasurementManager.class
                java.lang.Object r2 = r2.getSystemService(r0)
                java.lang.String r0 = "context.getSystemService…:class.java\n            )"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r0)
                android.adservices.measurement.MeasurementManager r2 = (android.adservices.measurement.MeasurementManager) r2
                r1.<init>(r2)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: yg.zn.y.<init>(android.content.Context):void");
        }
    }
}
