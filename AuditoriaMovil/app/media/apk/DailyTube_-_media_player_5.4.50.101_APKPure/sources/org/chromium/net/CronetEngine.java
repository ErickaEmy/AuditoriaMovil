package org.chromium.net;

import android.content.Context;
import android.util.Log;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandlerFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import org.chromium.net.UrlRequest;
/* loaded from: classes.dex */
public abstract class CronetEngine {
    private static final String TAG = "CronetEngine";

    /* loaded from: classes.dex */
    public static class Builder {
        protected final ICronetEngineBuilder mBuilderDelegate;

        /* loaded from: classes.dex */
        public static abstract class LibraryLoader {
            public abstract void loadLibrary(String str);
        }

        /* loaded from: classes.dex */
        public static class y implements Comparator<CronetProvider> {
            @Override // java.util.Comparator
            /* renamed from: y */
            public int compare(CronetProvider cronetProvider, CronetProvider cronetProvider2) {
                if ("Fallback-Cronet-Provider".equals(cronetProvider.getName())) {
                    return 1;
                }
                if ("Fallback-Cronet-Provider".equals(cronetProvider2.getName())) {
                    return -1;
                }
                return -Builder.compareVersions(cronetProvider.getVersion(), cronetProvider2.getVersion());
            }
        }

        public Builder(Context context) {
            this(createBuilderDelegate(context));
        }

        public static int compareVersions(String str, String str2) {
            if (str != null && str2 != null) {
                String[] split = str.split("\\.");
                String[] split2 = str2.split("\\.");
                for (int i = 0; i < split.length && i < split2.length; i++) {
                    try {
                        int parseInt = Integer.parseInt(split[i]);
                        int parseInt2 = Integer.parseInt(split2[i]);
                        if (parseInt != parseInt2) {
                            return Integer.signum(parseInt - parseInt2);
                        }
                    } catch (NumberFormatException e2) {
                        throw new IllegalArgumentException("Unable to convert version segments into integers: " + split[i] + " & " + split2[i], e2);
                    }
                }
                return Integer.signum(split.length - split2.length);
            }
            throw new IllegalArgumentException("The input values cannot be null");
        }

        private static ICronetEngineBuilder createBuilderDelegate(Context context) {
            Log.isLoggable(CronetEngine.TAG, 3);
            return getEnabledCronetProviders(context, new ArrayList(CronetProvider.getAllProviders(context))).get(0).createBuilder().mBuilderDelegate;
        }

        public static List<CronetProvider> getEnabledCronetProviders(Context context, List<CronetProvider> list) {
            if (list.size() != 0) {
                Iterator<CronetProvider> it = list.iterator();
                while (it.hasNext()) {
                    if (!it.next().isEnabled()) {
                        it.remove();
                    }
                }
                if (list.size() != 0) {
                    Collections.sort(list, new y());
                    return list;
                }
                throw new RuntimeException("All available Cronet providers are disabled. A provider should be enabled before it can be used.");
            }
            throw new RuntimeException("Unable to find any Cronet provider. Have you included all necessary jars?");
        }

        public Builder addPublicKeyPins(String str, Set<byte[]> set, boolean z2, Date date) {
            this.mBuilderDelegate.addPublicKeyPins(str, set, z2, date);
            return this;
        }

        public Builder addQuicHint(String str, int i, int i5) {
            this.mBuilderDelegate.addQuicHint(str, i, i5);
            return this;
        }

        public CronetEngine build() {
            return this.mBuilderDelegate.build();
        }

        public Builder enableBrotli(boolean z2) {
            this.mBuilderDelegate.enableBrotli(z2);
            return this;
        }

        public Builder enableHttp2(boolean z2) {
            this.mBuilderDelegate.enableHttp2(z2);
            return this;
        }

        public Builder enableHttpCache(int i, long j2) {
            this.mBuilderDelegate.enableHttpCache(i, j2);
            return this;
        }

        public Builder enablePublicKeyPinningBypassForLocalTrustAnchors(boolean z2) {
            this.mBuilderDelegate.enablePublicKeyPinningBypassForLocalTrustAnchors(z2);
            return this;
        }

        public Builder enableQuic(boolean z2) {
            this.mBuilderDelegate.enableQuic(z2);
            return this;
        }

        @Deprecated
        public Builder enableSdch(boolean z2) {
            return this;
        }

        public String getDefaultUserAgent() {
            return this.mBuilderDelegate.getDefaultUserAgent();
        }

        public Builder setLibraryLoader(LibraryLoader libraryLoader) {
            this.mBuilderDelegate.setLibraryLoader(libraryLoader);
            return this;
        }

        public Builder setStoragePath(String str) {
            this.mBuilderDelegate.setStoragePath(str);
            return this;
        }

        public Builder setUserAgent(String str) {
            this.mBuilderDelegate.setUserAgent(str);
            return this;
        }

        public Builder(ICronetEngineBuilder iCronetEngineBuilder) {
            this.mBuilderDelegate = iCronetEngineBuilder;
        }
    }

    public abstract URLStreamHandlerFactory createURLStreamHandlerFactory();

    public abstract byte[] getGlobalMetricsDeltas();

    public abstract String getVersionString();

    /* renamed from: newUrlRequestBuilder */
    public abstract UrlRequest.Builder mo114newUrlRequestBuilder(String str, UrlRequest.Callback callback, Executor executor);

    public abstract URLConnection openConnection(URL url) throws IOException;

    public abstract void shutdown();

    public abstract void startNetLogToFile(String str, boolean z2);

    public abstract void stopNetLog();
}
