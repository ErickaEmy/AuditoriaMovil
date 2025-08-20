package org.fdroid.download;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MirrorChooser.kt */
/* loaded from: classes2.dex */
public final class MirrorChooserImpl$mirrorRequest$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MirrorChooserImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MirrorChooserImpl$mirrorRequest$1(MirrorChooserImpl mirrorChooserImpl, Continuation continuation) {
        super(continuation);
        this.this$0 = mirrorChooserImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return MirrorChooserImpl.mirrorRequest$suspendImpl(this.this$0, null, null, this);
    }
}
