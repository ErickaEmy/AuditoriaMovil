package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Exceptions.kt */
/* loaded from: classes2.dex */
public final class JobCancellationException extends CancellationException implements CopyableThrowable {
    public final transient Job job;

    @Override // kotlinx.coroutines.CopyableThrowable
    public JobCancellationException createCopy() {
        return null;
    }

    public JobCancellationException(String str, Throwable th, Job job) {
        super(str);
        this.job = job;
        if (th != null) {
            initCause(th);
        }
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return super.toString() + "; job=" + this.job;
    }

    public boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof JobCancellationException) {
                JobCancellationException jobCancellationException = (JobCancellationException) obj;
                if (!Intrinsics.areEqual(jobCancellationException.getMessage(), getMessage()) || !Intrinsics.areEqual(jobCancellationException.job, this.job) || !Intrinsics.areEqual(jobCancellationException.getCause(), getCause())) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String message = getMessage();
        Intrinsics.checkNotNull(message);
        int hashCode = ((message.hashCode() * 31) + this.job.hashCode()) * 31;
        Throwable cause = getCause();
        return hashCode + (cause != null ? cause.hashCode() : 0);
    }
}
