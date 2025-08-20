package kotlinx.coroutines;
/* loaded from: classes.dex */
public class JobImpl extends JobSupport implements CompletableJob {
    private final boolean handlesException;

    public JobImpl(Job job) {
        super(true);
        initParentJob(job);
        this.handlesException = handlesException();
    }

    private final boolean handlesException() {
        ChildHandleNode childHandleNode;
        JobSupport job;
        ChildHandleNode childHandleNode2;
        ChildHandle parentHandle$kotlinx_coroutines_core = getParentHandle$kotlinx_coroutines_core();
        if (parentHandle$kotlinx_coroutines_core instanceof ChildHandleNode) {
            childHandleNode = (ChildHandleNode) parentHandle$kotlinx_coroutines_core;
        } else {
            childHandleNode = null;
        }
        if (childHandleNode != null && (job = childHandleNode.getJob()) != null) {
            while (!job.getHandlesException$kotlinx_coroutines_core()) {
                ChildHandle parentHandle$kotlinx_coroutines_core2 = job.getParentHandle$kotlinx_coroutines_core();
                if (parentHandle$kotlinx_coroutines_core2 instanceof ChildHandleNode) {
                    childHandleNode2 = (ChildHandleNode) parentHandle$kotlinx_coroutines_core2;
                } else {
                    childHandleNode2 = null;
                }
                if (childHandleNode2 != null) {
                    job = childHandleNode2.getJob();
                    if (job == null) {
                    }
                }
            }
            return true;
        }
        return false;
    }

    @Override // kotlinx.coroutines.JobSupport
    public boolean getHandlesException$kotlinx_coroutines_core() {
        return this.handlesException;
    }

    @Override // kotlinx.coroutines.JobSupport
    public boolean getOnCancelComplete$kotlinx_coroutines_core() {
        return true;
    }
}
