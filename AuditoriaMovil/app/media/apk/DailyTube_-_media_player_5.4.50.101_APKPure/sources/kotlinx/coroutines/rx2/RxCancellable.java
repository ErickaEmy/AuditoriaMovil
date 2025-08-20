package kotlinx.coroutines.rx2;

import jb1.zn;
import kotlinx.coroutines.Job;
/* loaded from: classes.dex */
public final class RxCancellable implements zn {
    private final Job job;

    public RxCancellable(Job job) {
        this.job = job;
    }

    public void cancel() {
        Job.DefaultImpls.cancel$default(this.job, null, 1, null);
    }
}
