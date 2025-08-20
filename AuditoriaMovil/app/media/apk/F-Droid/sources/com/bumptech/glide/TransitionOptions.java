package com.bumptech.glide;

import com.bumptech.glide.request.transition.NoTransition;
import com.bumptech.glide.request.transition.TransitionFactory;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
/* loaded from: classes.dex */
public abstract class TransitionOptions implements Cloneable {
    private TransitionFactory transitionFactory = NoTransition.getFactory();

    private TransitionOptions self() {
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final TransitionFactory getTransitionFactory() {
        return this.transitionFactory;
    }

    public final TransitionOptions transition(TransitionFactory transitionFactory) {
        this.transitionFactory = (TransitionFactory) Preconditions.checkNotNull(transitionFactory);
        return self();
    }

    /* renamed from: clone */
    public final TransitionOptions m2027clone() {
        try {
            return (TransitionOptions) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof TransitionOptions) {
            return Util.bothNullOrEqual(this.transitionFactory, ((TransitionOptions) obj).transitionFactory);
        }
        return false;
    }

    public int hashCode() {
        TransitionFactory transitionFactory = this.transitionFactory;
        if (transitionFactory != null) {
            return transitionFactory.hashCode();
        }
        return 0;
    }
}
