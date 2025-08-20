package io.ktor.util;

import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.markers.KMappedMarker;
/* compiled from: DelegatingMutableSet.kt */
/* loaded from: classes.dex */
public final class DelegatingMutableSet$iterator$1 implements Iterator, KMappedMarker {
    private final Iterator delegateIterator;
    final /* synthetic */ DelegatingMutableSet this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DelegatingMutableSet$iterator$1(DelegatingMutableSet delegatingMutableSet) {
        Set set;
        this.this$0 = delegatingMutableSet;
        set = delegatingMutableSet.delegate;
        this.delegateIterator = set.iterator();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.delegateIterator.hasNext();
    }

    @Override // java.util.Iterator
    public Object next() {
        Function1 function1;
        function1 = this.this$0.convertTo;
        return function1.invoke(this.delegateIterator.next());
    }

    @Override // java.util.Iterator
    public void remove() {
        this.delegateIterator.remove();
    }
}
