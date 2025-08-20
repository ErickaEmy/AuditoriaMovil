package io.ktor.utils.io;

import kotlinx.coroutines.CoroutineScope;
/* compiled from: Coroutines.kt */
/* loaded from: classes.dex */
public interface WriterScope extends CoroutineScope {
    ByteWriteChannel getChannel();
}
