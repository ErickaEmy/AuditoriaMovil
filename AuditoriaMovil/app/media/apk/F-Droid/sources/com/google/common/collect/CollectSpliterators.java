package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.CollectSpliterators;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Function;
/* loaded from: classes.dex */
abstract class CollectSpliterators {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static Spliterator map(Spliterator spliterator, Function function) {
        Preconditions.checkNotNull(spliterator);
        Preconditions.checkNotNull(function);
        return new AnonymousClass1(spliterator, function);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.common.collect.CollectSpliterators$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass1 implements Spliterator {
        final /* synthetic */ Spliterator val$fromSpliterator;
        final /* synthetic */ Function val$function;

        AnonymousClass1(Spliterator spliterator, Function function) {
            this.val$fromSpliterator = spliterator;
            this.val$function = function;
        }

        @Override // java.util.Spliterator
        public boolean tryAdvance(final Consumer consumer) {
            boolean tryAdvance;
            Spliterator spliterator = this.val$fromSpliterator;
            final Function function = this.val$function;
            tryAdvance = spliterator.tryAdvance(new Consumer() { // from class: com.google.common.collect.CollectSpliterators$1$$ExternalSyntheticLambda8
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    CollectSpliterators.AnonymousClass1.lambda$tryAdvance$0(consumer, function, obj);
                }
            });
            return tryAdvance;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$tryAdvance$0(Consumer consumer, Function function, Object obj) {
            Object apply;
            apply = function.apply(obj);
            consumer.accept(apply);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$forEachRemaining$1(Consumer consumer, Function function, Object obj) {
            Object apply;
            apply = function.apply(obj);
            consumer.accept(apply);
        }

        @Override // java.util.Spliterator
        public void forEachRemaining(final Consumer consumer) {
            Spliterator spliterator = this.val$fromSpliterator;
            final Function function = this.val$function;
            spliterator.forEachRemaining(new Consumer() { // from class: com.google.common.collect.CollectSpliterators$1$$ExternalSyntheticLambda7
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    CollectSpliterators.AnonymousClass1.lambda$forEachRemaining$1(consumer, function, obj);
                }
            });
        }

        @Override // java.util.Spliterator
        public Spliterator trySplit() {
            Spliterator trySplit;
            trySplit = this.val$fromSpliterator.trySplit();
            if (trySplit != null) {
                return CollectSpliterators.map(trySplit, this.val$function);
            }
            return null;
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            long estimateSize;
            estimateSize = this.val$fromSpliterator.estimateSize();
            return estimateSize;
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            int characteristics;
            characteristics = this.val$fromSpliterator.characteristics();
            return characteristics & (-262);
        }
    }
}
