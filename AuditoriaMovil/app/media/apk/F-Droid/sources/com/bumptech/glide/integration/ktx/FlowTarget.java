package com.bumptech.glide.integration.ktx;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import java.util.ArrayList;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ProducerScope;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Flows.kt */
/* loaded from: classes.dex */
public final class FlowTarget implements Target, RequestListener {
    private volatile Request currentRequest;
    private volatile Object lastResource;
    private volatile Size resolvedSize;
    private final ProducerScope scope;
    private final ResolvableGlideSize size;
    private final List sizeReadyCallbacks;

    @Override // com.bumptech.glide.request.target.Target
    public Request getRequest() {
        return this.currentRequest;
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onDestroy() {
    }

    @Override // com.bumptech.glide.request.RequestListener
    public boolean onResourceReady(Object resource, Object obj, Target target, DataSource dataSource, boolean z) {
        Intrinsics.checkNotNullParameter(resource, "resource");
        return false;
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStart() {
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStop() {
    }

    @Override // com.bumptech.glide.request.target.Target
    public void setRequest(Request request) {
        this.currentRequest = request;
    }

    public FlowTarget(ProducerScope scope, ResolvableGlideSize size) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(size, "size");
        this.scope = scope;
        this.size = size;
        this.sizeReadyCallbacks = new ArrayList();
        if (size instanceof ImmediateGlideSize) {
            this.resolvedSize = ((ImmediateGlideSize) size).getSize();
        } else if (size instanceof AsyncGlideSize) {
            BuildersKt__Builders_commonKt.launch$default(scope, null, null, new AnonymousClass1(null), 3, null);
        }
    }

    /* compiled from: Flows.kt */
    /* renamed from: com.bumptech.glide.integration.ktx.FlowTarget$1  reason: invalid class name */
    /* loaded from: classes.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2 {
        private /* synthetic */ Object L$0;
        int label;

        AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            CoroutineScope coroutineScope;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
                Function1 asyncSize = ((AsyncGlideSize) FlowTarget.this.size).getAsyncSize();
                this.L$0 = coroutineScope2;
                this.label = 1;
                Object invoke = asyncSize.invoke(this);
                if (invoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
                coroutineScope = coroutineScope2;
                obj = invoke;
            } else if (i == 1) {
                coroutineScope = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Size size = (Size) obj;
            Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            FlowTarget flowTarget = FlowTarget.this;
            synchronized (coroutineScope) {
                flowTarget.resolvedSize = size;
                ref$ObjectRef.element = new ArrayList(flowTarget.sizeReadyCallbacks);
                flowTarget.sizeReadyCallbacks.clear();
                Unit unit = Unit.INSTANCE;
            }
            for (SizeReadyCallback sizeReadyCallback : (Iterable) ref$ObjectRef.element) {
                sizeReadyCallback.onSizeReady(size.getWidth(), size.getHeight());
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onLoadStarted(Drawable drawable) {
        this.lastResource = null;
        this.scope.mo2270trySendJP2dKIU(new Placeholder(Status.RUNNING, drawable));
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onLoadFailed(Drawable drawable) {
        this.scope.mo2270trySendJP2dKIU(new Placeholder(Status.FAILED, drawable));
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onResourceReady(Object resource, Transition transition) {
        Intrinsics.checkNotNullParameter(resource, "resource");
        this.lastResource = resource;
        ProducerScope producerScope = this.scope;
        Request request = this.currentRequest;
        producerScope.mo2270trySendJP2dKIU(new Resource((request == null || !request.isComplete()) ? Status.RUNNING : Status.SUCCEEDED, resource));
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onLoadCleared(Drawable drawable) {
        this.lastResource = null;
        this.scope.mo2270trySendJP2dKIU(new Placeholder(Status.CLEARED, drawable));
    }

    @Override // com.bumptech.glide.request.target.Target
    public void getSize(SizeReadyCallback cb) {
        Intrinsics.checkNotNullParameter(cb, "cb");
        Size size = this.resolvedSize;
        if (size != null) {
            cb.onSizeReady(size.getWidth(), size.getHeight());
            return;
        }
        synchronized (this) {
            try {
                Size size2 = this.resolvedSize;
                if (size2 != null) {
                    cb.onSizeReady(size2.getWidth(), size2.getHeight());
                    Unit unit = Unit.INSTANCE;
                } else {
                    this.sizeReadyCallbacks.add(cb);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.bumptech.glide.request.target.Target
    public void removeCallback(SizeReadyCallback cb) {
        Intrinsics.checkNotNullParameter(cb, "cb");
        synchronized (this) {
            this.sizeReadyCallbacks.remove(cb);
        }
    }

    @Override // com.bumptech.glide.request.RequestListener
    public boolean onLoadFailed(GlideException glideException, Object obj, Target target, boolean z) {
        Object obj2 = this.lastResource;
        Request request = this.currentRequest;
        if (obj2 == null || request == null || request.isComplete() || request.isRunning()) {
            return false;
        }
        this.scope.getChannel().mo2270trySendJP2dKIU(new Resource(Status.FAILED, obj2));
        return false;
    }
}
