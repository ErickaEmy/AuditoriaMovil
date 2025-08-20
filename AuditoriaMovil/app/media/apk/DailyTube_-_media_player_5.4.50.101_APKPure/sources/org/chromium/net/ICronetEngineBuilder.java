package org.chromium.net;

import java.util.Date;
import java.util.Set;
import org.chromium.net.CronetEngine;
/* loaded from: classes.dex */
public abstract class ICronetEngineBuilder {
    public abstract ICronetEngineBuilder addPublicKeyPins(String str, Set<byte[]> set, boolean z2, Date date);

    public abstract ICronetEngineBuilder addQuicHint(String str, int i, int i5);

    public abstract ExperimentalCronetEngine build();

    public ICronetEngineBuilder enableBrotli(boolean z2) {
        return this;
    }

    public abstract ICronetEngineBuilder enableHttp2(boolean z2);

    public abstract ICronetEngineBuilder enableHttpCache(int i, long j2);

    public ICronetEngineBuilder enableNetworkQualityEstimator(boolean z2) {
        return this;
    }

    public abstract ICronetEngineBuilder enablePublicKeyPinningBypassForLocalTrustAnchors(boolean z2);

    public abstract ICronetEngineBuilder enableQuic(boolean z2);

    public abstract ICronetEngineBuilder enableSdch(boolean z2);

    public abstract String getDefaultUserAgent();

    public abstract ICronetEngineBuilder setExperimentalOptions(String str);

    public abstract ICronetEngineBuilder setLibraryLoader(CronetEngine.Builder.LibraryLoader libraryLoader);

    public abstract ICronetEngineBuilder setStoragePath(String str);

    public ICronetEngineBuilder setThreadPriority(int i) {
        return this;
    }

    public abstract ICronetEngineBuilder setUserAgent(String str);
}
