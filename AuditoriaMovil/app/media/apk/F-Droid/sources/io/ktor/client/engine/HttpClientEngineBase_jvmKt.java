package io.ktor.client.engine;

import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
/* compiled from: HttpClientEngineBase.jvm.kt */
/* loaded from: classes.dex */
public abstract class HttpClientEngineBase_jvmKt {
    public static final CoroutineDispatcher ioDispatcher() {
        return Dispatchers.getIO();
    }
}
