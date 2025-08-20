package org.fdroid.fdroid.views.repos;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AddRepoActivity.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public /* synthetic */ class AddRepoActivity$onCreate$2$1$2$1 extends FunctionReferenceImpl implements Function1 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public AddRepoActivity$onCreate$2$1$2$1(Object obj) {
        super(1, obj, AddRepoActivity.class, "onFetchRepo", "onFetchRepo(Ljava/lang/String;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(String p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((AddRepoActivity) this.receiver).onFetchRepo(p0);
    }
}
