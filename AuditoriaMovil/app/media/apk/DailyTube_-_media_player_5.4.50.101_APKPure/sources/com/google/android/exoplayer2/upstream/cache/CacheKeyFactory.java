package com.google.android.exoplayer2.upstream.cache;

import kx.p;
/* loaded from: classes.dex */
public interface CacheKeyFactory {
    public static final CacheKeyFactory DEFAULT = new CacheKeyFactory() { // from class: di.fb
        @Override // com.google.android.exoplayer2.upstream.cache.CacheKeyFactory
        public final String buildCacheKey(kx.p pVar) {
            return s.y(pVar);
        }
    };

    String buildCacheKey(p pVar);
}
