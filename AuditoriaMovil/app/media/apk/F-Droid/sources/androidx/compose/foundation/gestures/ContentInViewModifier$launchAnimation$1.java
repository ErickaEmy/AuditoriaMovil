package androidx.compose.foundation.gestures;

import androidx.compose.foundation.gestures.ScrollableState;
import ch.qos.logback.core.CoreConstants;
import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.JobKt__JobKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ContentInViewModifier.kt */
/* loaded from: classes.dex */
public final class ContentInViewModifier$launchAnimation$1 extends SuspendLambda implements Function2 {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ContentInViewModifier this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContentInViewModifier$launchAnimation$1(ContentInViewModifier contentInViewModifier, Continuation continuation) {
        super(2, continuation);
        this.this$0 = contentInViewModifier;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        ContentInViewModifier$launchAnimation$1 contentInViewModifier$launchAnimation$1 = new ContentInViewModifier$launchAnimation$1(this.this$0, continuation);
        contentInViewModifier$launchAnimation$1.L$0 = obj;
        return contentInViewModifier$launchAnimation$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((ContentInViewModifier$launchAnimation$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        ScrollableState scrollableState;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    Job job = JobKt.getJob(((CoroutineScope) this.L$0).getCoroutineContext());
                    this.this$0.isAnimationRunning = true;
                    scrollableState = this.this$0.scrollState;
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, job, null);
                    this.label = 1;
                    if (ScrollableState.CC.scroll$default(scrollableState, null, anonymousClass1, this, 1, null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    ResultKt.throwOnFailure(obj);
                }
                this.this$0.bringIntoViewRequests.resumeAndRemoveAll();
                this.this$0.isAnimationRunning = false;
                this.this$0.bringIntoViewRequests.cancelAndRemoveAll(null);
                this.this$0.trackingFocusedChild = false;
                return Unit.INSTANCE;
            } catch (CancellationException e) {
                throw e;
            }
        } catch (Throwable th) {
            this.this$0.isAnimationRunning = false;
            this.this$0.bringIntoViewRequests.cancelAndRemoveAll(null);
            this.this$0.trackingFocusedChild = false;
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ContentInViewModifier.kt */
    /* renamed from: androidx.compose.foundation.gestures.ContentInViewModifier$launchAnimation$1$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2 {
        final /* synthetic */ Job $animationJob;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ ContentInViewModifier this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ContentInViewModifier contentInViewModifier, Job job, Continuation continuation) {
            super(2, continuation);
            this.this$0 = contentInViewModifier;
            this.$animationJob = job;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$animationJob, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ScrollScope scrollScope, Continuation continuation) {
            return ((AnonymousClass1) create(scrollScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            UpdatableAnimationState updatableAnimationState;
            float calculateScrollDelta;
            UpdatableAnimationState updatableAnimationState2;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final ScrollScope scrollScope = (ScrollScope) this.L$0;
                updatableAnimationState = this.this$0.animationState;
                calculateScrollDelta = this.this$0.calculateScrollDelta();
                updatableAnimationState.setValue(calculateScrollDelta);
                updatableAnimationState2 = this.this$0.animationState;
                final ContentInViewModifier contentInViewModifier = this.this$0;
                final Job job = this.$animationJob;
                Function1 function1 = new Function1() { // from class: androidx.compose.foundation.gestures.ContentInViewModifier.launchAnimation.1.1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                        invoke(((Number) obj2).floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(float f) {
                        boolean z;
                        z = ContentInViewModifier.this.reverseDirection;
                        float f2 = z ? 1.0f : -1.0f;
                        float scrollBy = f2 * scrollScope.scrollBy(f2 * f);
                        if (scrollBy < f) {
                            Job job2 = job;
                            JobKt__JobKt.cancel$default(job2, "Scroll animation cancelled because scroll was not consumed (" + scrollBy + " < " + f + CoreConstants.RIGHT_PARENTHESIS_CHAR, null, 2, null);
                        }
                    }
                };
                final ContentInViewModifier contentInViewModifier2 = this.this$0;
                Function0 function0 = new Function0() { // from class: androidx.compose.foundation.gestures.ContentInViewModifier.launchAnimation.1.1.2
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m126invoke();
                        return Unit.INSTANCE;
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:13:0x005f, code lost:
                        r2 = r1.getFocusedChildBounds();
                     */
                    /* JADX WARN: Incorrect condition in loop: B:4:0x0011 */
                    /* renamed from: invoke  reason: collision with other method in class */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public final void m126invoke() {
                        /*
                            r9 = this;
                            androidx.compose.foundation.gestures.ContentInViewModifier r0 = androidx.compose.foundation.gestures.ContentInViewModifier.this
                            androidx.compose.foundation.gestures.BringIntoViewRequestPriorityQueue r0 = androidx.compose.foundation.gestures.ContentInViewModifier.access$getBringIntoViewRequests$p(r0)
                            androidx.compose.foundation.gestures.ContentInViewModifier r7 = androidx.compose.foundation.gestures.ContentInViewModifier.this
                        L8:
                            androidx.compose.runtime.collection.MutableVector r1 = androidx.compose.foundation.gestures.BringIntoViewRequestPriorityQueue.access$getRequests$p(r0)
                            boolean r1 = r1.isNotEmpty()
                            r8 = 1
                            if (r1 == 0) goto L57
                            androidx.compose.runtime.collection.MutableVector r1 = androidx.compose.foundation.gestures.BringIntoViewRequestPriorityQueue.access$getRequests$p(r0)
                            java.lang.Object r1 = r1.last()
                            androidx.compose.foundation.gestures.ContentInViewModifier$Request r1 = (androidx.compose.foundation.gestures.ContentInViewModifier.Request) r1
                            kotlin.jvm.functions.Function0 r1 = r1.getCurrentBounds()
                            java.lang.Object r1 = r1.invoke()
                            r2 = r1
                            androidx.compose.ui.geometry.Rect r2 = (androidx.compose.ui.geometry.Rect) r2
                            if (r2 != 0) goto L2b
                            goto L36
                        L2b:
                            r3 = 0
                            r5 = 1
                            r6 = 0
                            r1 = r7
                            boolean r1 = androidx.compose.foundation.gestures.ContentInViewModifier.m123isMaxVisibleO0kMr_c$default(r1, r2, r3, r5, r6)
                            if (r1 == 0) goto L57
                        L36:
                            androidx.compose.runtime.collection.MutableVector r1 = androidx.compose.foundation.gestures.BringIntoViewRequestPriorityQueue.access$getRequests$p(r0)
                            androidx.compose.runtime.collection.MutableVector r2 = androidx.compose.foundation.gestures.BringIntoViewRequestPriorityQueue.access$getRequests$p(r0)
                            int r2 = r2.getSize()
                            int r2 = r2 - r8
                            java.lang.Object r1 = r1.removeAt(r2)
                            androidx.compose.foundation.gestures.ContentInViewModifier$Request r1 = (androidx.compose.foundation.gestures.ContentInViewModifier.Request) r1
                            kotlinx.coroutines.CancellableContinuation r1 = r1.getContinuation()
                            kotlin.Unit r2 = kotlin.Unit.INSTANCE
                            java.lang.Object r2 = kotlin.Result.m2081constructorimpl(r2)
                            r1.resumeWith(r2)
                            goto L8
                        L57:
                            androidx.compose.foundation.gestures.ContentInViewModifier r0 = androidx.compose.foundation.gestures.ContentInViewModifier.this
                            boolean r0 = androidx.compose.foundation.gestures.ContentInViewModifier.access$getTrackingFocusedChild$p(r0)
                            if (r0 == 0) goto L79
                            androidx.compose.foundation.gestures.ContentInViewModifier r0 = androidx.compose.foundation.gestures.ContentInViewModifier.this
                            androidx.compose.ui.geometry.Rect r2 = androidx.compose.foundation.gestures.ContentInViewModifier.access$getFocusedChildBounds(r0)
                            if (r2 == 0) goto L79
                            androidx.compose.foundation.gestures.ContentInViewModifier r1 = androidx.compose.foundation.gestures.ContentInViewModifier.this
                            r3 = 0
                            r5 = 1
                            r6 = 0
                            boolean r0 = androidx.compose.foundation.gestures.ContentInViewModifier.m123isMaxVisibleO0kMr_c$default(r1, r2, r3, r5, r6)
                            if (r0 != r8) goto L79
                            androidx.compose.foundation.gestures.ContentInViewModifier r0 = androidx.compose.foundation.gestures.ContentInViewModifier.this
                            r1 = 0
                            androidx.compose.foundation.gestures.ContentInViewModifier.access$setTrackingFocusedChild$p(r0, r1)
                        L79:
                            androidx.compose.foundation.gestures.ContentInViewModifier r0 = androidx.compose.foundation.gestures.ContentInViewModifier.this
                            androidx.compose.foundation.gestures.UpdatableAnimationState r0 = androidx.compose.foundation.gestures.ContentInViewModifier.access$getAnimationState$p(r0)
                            androidx.compose.foundation.gestures.ContentInViewModifier r1 = androidx.compose.foundation.gestures.ContentInViewModifier.this
                            float r1 = androidx.compose.foundation.gestures.ContentInViewModifier.access$calculateScrollDelta(r1)
                            r0.setValue(r1)
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ContentInViewModifier$launchAnimation$1.AnonymousClass1.AnonymousClass2.m126invoke():void");
                    }
                };
                this.label = 1;
                if (updatableAnimationState2.animateToZero(function1, function0, this) == coroutine_suspended) {
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
