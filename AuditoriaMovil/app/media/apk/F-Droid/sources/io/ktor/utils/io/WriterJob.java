package io.ktor.utils.io;

import kotlinx.coroutines.Job;
/* compiled from: Coroutines.kt */
/* loaded from: classes.dex */
public interface WriterJob extends Job {
    ByteReadChannel getChannel();
}
