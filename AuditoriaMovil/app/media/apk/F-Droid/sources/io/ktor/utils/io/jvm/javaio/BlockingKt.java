package io.ktor.utils.io.jvm.javaio;

import io.ktor.utils.io.ByteReadChannel;
import java.io.InputStream;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/* compiled from: Blocking.kt */
/* loaded from: classes.dex */
public abstract class BlockingKt {
    private static final Lazy ADAPTER_LOGGER$delegate;
    private static final Object CloseToken;
    private static final Object FlushToken;

    public static final /* synthetic */ Logger access$getADAPTER_LOGGER() {
        return getADAPTER_LOGGER();
    }

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: io.ktor.utils.io.jvm.javaio.BlockingKt$ADAPTER_LOGGER$2
            @Override // kotlin.jvm.functions.Function0
            public final Logger invoke() {
                return LoggerFactory.getLogger(BlockingAdapter.class);
            }
        });
        ADAPTER_LOGGER$delegate = lazy;
        CloseToken = new Object();
        FlushToken = new Object();
    }

    public static final Logger getADAPTER_LOGGER() {
        return (Logger) ADAPTER_LOGGER$delegate.getValue();
    }

    public static final InputStream toInputStream(ByteReadChannel byteReadChannel, Job job) {
        Intrinsics.checkNotNullParameter(byteReadChannel, "<this>");
        return new InputAdapter(job, byteReadChannel);
    }

    public static /* synthetic */ InputStream toInputStream$default(ByteReadChannel byteReadChannel, Job job, int i, Object obj) {
        if ((i & 1) != 0) {
            job = null;
        }
        return toInputStream(byteReadChannel, job);
    }
}
