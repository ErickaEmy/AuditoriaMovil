package org.fdroid.fdroid.net;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import okhttp3.Dns;
import org.fdroid.fdroid.Preferences;
/* loaded from: classes2.dex */
public class DnsWithCache implements Dns {
    private static final int DELAY_TIME = 1;
    private static final TimeUnit DELAY_UNIT = TimeUnit.SECONDS;
    private volatile boolean writeScheduled = false;
    private final Runnable delayedWrite = new Runnable() { // from class: org.fdroid.fdroid.net.DnsWithCache$$ExternalSyntheticLambda0
        @Override // java.lang.Runnable
        public final void run() {
            DnsWithCache.this.lambda$new$0();
        }
    };
    private final ScheduledExecutorService writeExecutor = Executors.newSingleThreadScheduledExecutor();
    private volatile HashMap<String, List<InetAddress>> cache = Preferences.get().getDnsCache();

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0() {
        Preferences.get().setDnsCache(this.cache);
        this.writeScheduled = false;
    }

    public void updateCacheAndPrefs(String str, List<InetAddress> list) {
        updateCache(str, list);
        if (this.writeScheduled) {
            return;
        }
        this.writeScheduled = true;
        this.writeExecutor.schedule(this.delayedWrite, 1L, DELAY_UNIT);
    }

    public void updateCache(String str, List<InetAddress> list) {
        if (this.cache == null) {
            this.cache = new HashMap<>();
        }
        this.cache.put(str, list);
    }

    @Override // okhttp3.Dns
    public List<InetAddress> lookup(String str) throws UnknownHostException {
        if (!Preferences.get().isDnsCacheEnabled() || this.cache == null || !this.cache.keySet().contains(str)) {
            List lookup = Dns.SYSTEM.lookup(str);
            updateCacheAndPrefs(str, lookup);
            return lookup;
        }
        return this.cache.get(str);
    }
}
