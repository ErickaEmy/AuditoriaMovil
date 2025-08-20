package androidx.compose.material;

import androidx.compose.animation.core.MutatorMutex$$ExternalSyntheticBackportWithForwarding0;
import androidx.compose.foundation.MutatePriority;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
/* compiled from: InternalMutatorMutex.kt */
/* loaded from: classes.dex */
public final class InternalMutatorMutex {
    private final AtomicReference currentMutator = new AtomicReference(null);
    private final Mutex mutex = MutexKt.Mutex$default(false, 1, null);

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: InternalMutatorMutex.kt */
    /* loaded from: classes.dex */
    public static final class Mutator {
        private final Job job;
        private final MutatePriority priority;

        public Mutator(MutatePriority priority, Job job) {
            Intrinsics.checkNotNullParameter(priority, "priority");
            Intrinsics.checkNotNullParameter(job, "job");
            this.priority = priority;
            this.job = job;
        }

        public final boolean canInterrupt(Mutator other) {
            Intrinsics.checkNotNullParameter(other, "other");
            return this.priority.compareTo(other.priority) >= 0;
        }

        public final void cancel() {
            Job.DefaultImpls.cancel$default(this.job, null, 1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void tryMutateOrCancel(Mutator mutator) {
        Mutator mutator2;
        do {
            mutator2 = (Mutator) this.currentMutator.get();
            if (mutator2 != null && !mutator.canInterrupt(mutator2)) {
                throw new CancellationException("Current mutation had a higher priority");
            }
        } while (!MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(this.currentMutator, mutator2, mutator));
        if (mutator2 != null) {
            mutator2.cancel();
        }
    }

    public final Object mutate(MutatePriority mutatePriority, Function1 function1, Continuation continuation) {
        return CoroutineScopeKt.coroutineScope(new InternalMutatorMutex$mutate$2(mutatePriority, this, function1, null), continuation);
    }

    public final boolean tryMutate(Function0 block) {
        Intrinsics.checkNotNullParameter(block, "block");
        boolean tryLock$default = Mutex.DefaultImpls.tryLock$default(this.mutex, null, 1, null);
        if (tryLock$default) {
            try {
                block.invoke();
            } finally {
                Mutex.DefaultImpls.unlock$default(this.mutex, null, 1, null);
            }
        }
        return tryLock$default;
    }
}
