package androidx.work.impl.constraints;

import androidx.work.Logger;
import androidx.work.impl.constraints.ConstraintsState;
import androidx.work.impl.constraints.controllers.ConstraintController;
import androidx.work.impl.model.WorkSpec;
import java.util.ArrayList;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.internal.CombineKt;
/* compiled from: WorkConstraintsTracker.kt */
/* loaded from: classes.dex */
public final class WorkConstraintsTracker {
    private final List controllers;

    public WorkConstraintsTracker(List controllers) {
        Intrinsics.checkNotNullParameter(controllers, "controllers");
        this.controllers = controllers;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public WorkConstraintsTracker(androidx.work.impl.constraints.trackers.Trackers r4) {
        /*
            r3 = this;
            java.lang.String r0 = "trackers"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            r0 = 7
            androidx.work.impl.constraints.controllers.ConstraintController[] r0 = new androidx.work.impl.constraints.controllers.ConstraintController[r0]
            androidx.work.impl.constraints.controllers.BatteryChargingController r1 = new androidx.work.impl.constraints.controllers.BatteryChargingController
            androidx.work.impl.constraints.trackers.ConstraintTracker r2 = r4.getBatteryChargingTracker()
            r1.<init>(r2)
            r2 = 0
            r0[r2] = r1
            androidx.work.impl.constraints.controllers.BatteryNotLowController r1 = new androidx.work.impl.constraints.controllers.BatteryNotLowController
            androidx.work.impl.constraints.trackers.BatteryNotLowTracker r2 = r4.getBatteryNotLowTracker()
            r1.<init>(r2)
            r2 = 1
            r0[r2] = r1
            androidx.work.impl.constraints.controllers.StorageNotLowController r1 = new androidx.work.impl.constraints.controllers.StorageNotLowController
            androidx.work.impl.constraints.trackers.ConstraintTracker r2 = r4.getStorageNotLowTracker()
            r1.<init>(r2)
            r2 = 2
            r0[r2] = r1
            androidx.work.impl.constraints.controllers.NetworkConnectedController r1 = new androidx.work.impl.constraints.controllers.NetworkConnectedController
            androidx.work.impl.constraints.trackers.ConstraintTracker r2 = r4.getNetworkStateTracker()
            r1.<init>(r2)
            r2 = 3
            r0[r2] = r1
            androidx.work.impl.constraints.controllers.NetworkUnmeteredController r1 = new androidx.work.impl.constraints.controllers.NetworkUnmeteredController
            androidx.work.impl.constraints.trackers.ConstraintTracker r2 = r4.getNetworkStateTracker()
            r1.<init>(r2)
            r2 = 4
            r0[r2] = r1
            androidx.work.impl.constraints.controllers.NetworkNotRoamingController r1 = new androidx.work.impl.constraints.controllers.NetworkNotRoamingController
            androidx.work.impl.constraints.trackers.ConstraintTracker r2 = r4.getNetworkStateTracker()
            r1.<init>(r2)
            r2 = 5
            r0[r2] = r1
            androidx.work.impl.constraints.controllers.NetworkMeteredController r1 = new androidx.work.impl.constraints.controllers.NetworkMeteredController
            androidx.work.impl.constraints.trackers.ConstraintTracker r4 = r4.getNetworkStateTracker()
            r1.<init>(r4)
            r4 = 6
            r0[r4] = r1
            java.util.List r4 = kotlin.collections.CollectionsKt.listOf(r0)
            r3.<init>(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.constraints.WorkConstraintsTracker.<init>(androidx.work.impl.constraints.trackers.Trackers):void");
    }

    public final boolean areAllConstraintsMet(WorkSpec workSpec) {
        String joinToString$default;
        Intrinsics.checkNotNullParameter(workSpec, "workSpec");
        List list = this.controllers;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((ConstraintController) obj).isConstrained(workSpec)) {
                arrayList.add(obj);
            }
        }
        if (!arrayList.isEmpty()) {
            Logger logger = Logger.get();
            String access$getTAG$p = WorkConstraintsTrackerKt.access$getTAG$p();
            StringBuilder sb = new StringBuilder();
            sb.append("Work ");
            sb.append(workSpec.id);
            sb.append(" constrained by ");
            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, null, null, null, 0, null, new Function1() { // from class: androidx.work.impl.constraints.WorkConstraintsTracker$areAllConstraintsMet$1
                @Override // kotlin.jvm.functions.Function1
                public final CharSequence invoke(ConstraintController it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    String simpleName = it.getClass().getSimpleName();
                    Intrinsics.checkNotNullExpressionValue(simpleName, "it.javaClass.simpleName");
                    return simpleName;
                }
            }, 31, null);
            sb.append(joinToString$default);
            logger.debug(access$getTAG$p, sb.toString());
        }
        return arrayList.isEmpty();
    }

    public final Flow track(WorkSpec spec) {
        int collectionSizeOrDefault;
        List list;
        Intrinsics.checkNotNullParameter(spec, "spec");
        List list2 = this.controllers;
        ArrayList<ConstraintController> arrayList = new ArrayList();
        for (Object obj : list2) {
            if (((ConstraintController) obj).hasConstraint(spec)) {
                arrayList.add(obj);
            }
        }
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        for (ConstraintController constraintController : arrayList) {
            arrayList2.add(constraintController.track());
        }
        list = CollectionsKt___CollectionsKt.toList(arrayList2);
        final Flow[] flowArr = (Flow[]) list.toArray(new Flow[0]);
        return FlowKt.distinctUntilChanged(new Flow() { // from class: androidx.work.impl.constraints.WorkConstraintsTracker$track$$inlined$combine$1
            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector, Continuation continuation) {
                Object coroutine_suspended;
                final Flow[] flowArr2 = flowArr;
                Object combineInternal = CombineKt.combineInternal(flowCollector, flowArr2, new Function0() { // from class: androidx.work.impl.constraints.WorkConstraintsTracker$track$$inlined$combine$1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object[] invoke() {
                        return new ConstraintsState[flowArr2.length];
                    }
                }, new AnonymousClass3(null), continuation);
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                return combineInternal == coroutine_suspended ? combineInternal : Unit.INSTANCE;
            }

            /* compiled from: Zip.kt */
            /* renamed from: androidx.work.impl.constraints.WorkConstraintsTracker$track$$inlined$combine$1$3  reason: invalid class name */
            /* loaded from: classes.dex */
            public static final class AnonymousClass3 extends SuspendLambda implements Function3 {
                private /* synthetic */ Object L$0;
                /* synthetic */ Object L$1;
                int label;

                public AnonymousClass3(Continuation continuation) {
                    super(3, continuation);
                }

                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(FlowCollector flowCollector, Object[] objArr, Continuation continuation) {
                    AnonymousClass3 anonymousClass3 = new AnonymousClass3(continuation);
                    anonymousClass3.L$0 = flowCollector;
                    anonymousClass3.L$1 = objArr;
                    return anonymousClass3.invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended;
                    ConstraintsState constraintsState;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        FlowCollector flowCollector = (FlowCollector) this.L$0;
                        ConstraintsState[] constraintsStateArr = (ConstraintsState[]) ((Object[]) this.L$1);
                        int length = constraintsStateArr.length;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= length) {
                                constraintsState = null;
                                break;
                            }
                            constraintsState = constraintsStateArr[i2];
                            if (!Intrinsics.areEqual(constraintsState, ConstraintsState.ConstraintsMet.INSTANCE)) {
                                break;
                            }
                            i2++;
                        }
                        if (constraintsState == null) {
                            constraintsState = ConstraintsState.ConstraintsMet.INSTANCE;
                        }
                        this.label = 1;
                        if (flowCollector.emit(constraintsState, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        ResultKt.throwOnFailure(obj);
                    }
                    return Unit.INSTANCE;
                }
            }
        });
    }
}
