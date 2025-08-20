package io.ktor.client.plugins;

import io.ktor.util.logging.KtorSimpleLoggerJvmKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import org.slf4j.Logger;
/* compiled from: HttpRequestLifecycle.kt */
/* loaded from: classes.dex */
public abstract class HttpRequestLifecycleKt {
    private static final Logger LOGGER = KtorSimpleLoggerJvmKt.KtorSimpleLogger("io.ktor.client.plugins.HttpRequestLifecycle");

    /* JADX INFO: Access modifiers changed from: private */
    public static final void attachToClientEngineJob(final CompletableJob completableJob, Job job) {
        final DisposableHandle invokeOnCompletion = job.invokeOnCompletion(new Function1() { // from class: io.ktor.client.plugins.HttpRequestLifecycleKt$attachToClientEngineJob$handler$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Throwable th) {
                Logger logger;
                Logger logger2;
                if (th != null) {
                    logger2 = HttpRequestLifecycleKt.LOGGER;
                    logger2.trace("Cancelling request because engine Job failed with error: " + th);
                    JobKt.cancel(CompletableJob.this, "Engine failed", th);
                    return;
                }
                logger = HttpRequestLifecycleKt.LOGGER;
                logger.trace("Cancelling request because engine Job completed");
                CompletableJob.this.complete();
            }
        });
        completableJob.invokeOnCompletion(new Function1() { // from class: io.ktor.client.plugins.HttpRequestLifecycleKt$attachToClientEngineJob$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Throwable th) {
                DisposableHandle.this.dispose();
            }
        });
    }
}
