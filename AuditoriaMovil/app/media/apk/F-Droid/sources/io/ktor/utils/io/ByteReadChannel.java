package io.ktor.utils.io;

import io.ktor.utils.io.core.internal.ChunkBuffer;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import org.fdroid.fdroid.Preferences;
/* compiled from: ByteReadChannelJVM.kt */
/* loaded from: classes.dex */
public interface ByteReadChannel {
    public static final Companion Companion = Companion.$$INSTANCE;

    boolean cancel(Throwable th);

    int getAvailableForRead();

    Throwable getClosedCause();

    boolean isClosedForRead();

    Object readAvailable(ChunkBuffer chunkBuffer, Continuation continuation);

    Object readAvailable(byte[] bArr, int i, int i2, Continuation continuation);

    Object readRemaining(long j, Continuation continuation);

    /* compiled from: ByteReadChannelJVM.kt */
    /* loaded from: classes.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ Object readRemaining$default(ByteReadChannel byteReadChannel, long j, Continuation continuation, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    j = Preferences.UPDATE_INTERVAL_DISABLED;
                }
                return byteReadChannel.readRemaining(j, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: readRemaining");
        }
    }

    /* compiled from: ByteReadChannelJVM.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final Lazy Empty$delegate = LazyKt.lazy(new Function0() { // from class: io.ktor.utils.io.ByteReadChannel$Companion$Empty$2
            @Override // kotlin.jvm.functions.Function0
            public final ByteChannel invoke() {
                ByteChannel ByteChannel$default = ByteChannelKt.ByteChannel$default(false, 1, null);
                ByteWriteChannelKt.close(ByteChannel$default);
                return ByteChannel$default;
            }
        });

        private Companion() {
        }

        public final ByteReadChannel getEmpty() {
            return (ByteReadChannel) Empty$delegate.getValue();
        }
    }
}
