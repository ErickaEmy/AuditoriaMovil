package androidx.compose.runtime;

import androidx.compose.runtime.collection.IdentityArraySet;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Composer.kt */
/* loaded from: classes.dex */
public final class Invalidation {
    private IdentityArraySet instances;
    private final int location;
    private final RecomposeScopeImpl scope;

    public final IdentityArraySet getInstances() {
        return this.instances;
    }

    public final int getLocation() {
        return this.location;
    }

    public final RecomposeScopeImpl getScope() {
        return this.scope;
    }

    public final void setInstances(IdentityArraySet identityArraySet) {
        this.instances = identityArraySet;
    }

    public Invalidation(RecomposeScopeImpl scope, int i, IdentityArraySet identityArraySet) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.scope = scope;
        this.location = i;
        this.instances = identityArraySet;
    }

    public final boolean isInvalid() {
        return this.scope.isInvalidFor(this.instances);
    }
}
