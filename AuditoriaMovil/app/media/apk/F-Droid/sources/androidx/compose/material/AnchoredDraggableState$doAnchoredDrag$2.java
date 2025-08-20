package androidx.compose.material;

import androidx.compose.foundation.MutatePriority;
import java.util.Iterator;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AnchoredDraggable.kt */
/* loaded from: classes.dex */
public final class AnchoredDraggableState$doAnchoredDrag$2 extends SuspendLambda implements Function2 {
    final /* synthetic */ Function3 $block;
    final /* synthetic */ MutatePriority $dragPriority;
    final /* synthetic */ Object $targetValue;
    int label;
    final /* synthetic */ AnchoredDraggableState this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnchoredDraggableState$doAnchoredDrag$2(Object obj, AnchoredDraggableState anchoredDraggableState, MutatePriority mutatePriority, Function3 function3, Continuation continuation) {
        super(2, continuation);
        this.$targetValue = obj;
        this.this$0 = anchoredDraggableState;
        this.$dragPriority = mutatePriority;
        this.$block = function3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new AnchoredDraggableState$doAnchoredDrag$2(this.$targetValue, this.this$0, this.$dragPriority, this.$block, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((AnchoredDraggableState$doAnchoredDrag$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Finally extract failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        Object obj2;
        Object key;
        InternalMutatorMutex internalMutatorMutex;
        Object obj3;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (this.$targetValue == null || this.this$0.getAnchors$material_release().containsKey(this.$targetValue)) {
                    internalMutatorMutex = this.this$0.dragMutex;
                    MutatePriority mutatePriority = this.$dragPriority;
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$targetValue, this.this$0, this.$block, null);
                    this.label = 1;
                    if (internalMutatorMutex.mutate(mutatePriority, anonymousClass1, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (((Boolean) this.this$0.getConfirmValueChange$material_release().invoke(this.$targetValue)).booleanValue()) {
                        this.this$0.setCurrentValue(this.$targetValue);
                    }
                    return Unit.INSTANCE;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                ResultKt.throwOnFailure(obj);
            }
            if (this.$targetValue != null) {
                this.this$0.setAnimationTarget(null);
            }
            AnchoredDraggableState anchoredDraggableState = this.this$0;
            Iterator it = this.this$0.getAnchors$material_release().entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj3 = null;
                    break;
                }
                obj3 = it.next();
                if (Math.abs(((Number) ((Map.Entry) obj3).getValue()).floatValue() - anchoredDraggableState.getOffset()) < 0.5f) {
                    break;
                }
            }
            Map.Entry entry = (Map.Entry) obj3;
            key = entry != null ? entry.getKey() : null;
            if (key != null && ((Boolean) this.this$0.getConfirmValueChange$material_release().invoke(key)).booleanValue()) {
                this.this$0.setCurrentValue(key);
            }
            return Unit.INSTANCE;
        } catch (Throwable th) {
            if (this.$targetValue != null) {
                this.this$0.setAnimationTarget(null);
            }
            AnchoredDraggableState anchoredDraggableState2 = this.this$0;
            Iterator it2 = this.this$0.getAnchors$material_release().entrySet().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    obj2 = null;
                    break;
                }
                obj2 = it2.next();
                if (Math.abs(((Number) ((Map.Entry) obj2).getValue()).floatValue() - anchoredDraggableState2.getOffset()) < 0.5f) {
                    break;
                }
            }
            Map.Entry entry2 = (Map.Entry) obj2;
            key = entry2 != null ? entry2.getKey() : null;
            if (key != null && ((Boolean) this.this$0.getConfirmValueChange$material_release().invoke(key)).booleanValue()) {
                this.this$0.setCurrentValue(key);
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AnchoredDraggable.kt */
    /* renamed from: androidx.compose.material.AnchoredDraggableState$doAnchoredDrag$2$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function1 {
        final /* synthetic */ Function3 $block;
        final /* synthetic */ Object $targetValue;
        int label;
        final /* synthetic */ AnchoredDraggableState this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Object obj, AnchoredDraggableState anchoredDraggableState, Function3 function3, Continuation continuation) {
            super(1, continuation);
            this.$targetValue = obj;
            this.this$0 = anchoredDraggableState;
            this.$block = function3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return new AnonymousClass1(this.$targetValue, this.this$0, this.$block, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            AnchoredDragScope anchoredDragScope;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Object obj2 = this.$targetValue;
                if (obj2 != null) {
                    this.this$0.setAnimationTarget(obj2);
                }
                Function3 function3 = this.$block;
                anchoredDragScope = this.this$0.anchoredDragScope;
                Map anchors$material_release = this.this$0.getAnchors$material_release();
                this.label = 1;
                if (function3.invoke(anchoredDragScope, anchors$material_release, this) == coroutine_suspended) {
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
}
