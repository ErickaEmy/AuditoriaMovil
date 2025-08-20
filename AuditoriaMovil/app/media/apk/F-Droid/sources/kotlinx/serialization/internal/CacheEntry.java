package kotlinx.serialization.internal;

import kotlinx.serialization.KSerializer;
/* compiled from: Caching.kt */
/* loaded from: classes2.dex */
final class CacheEntry {
    public final KSerializer serializer;

    public CacheEntry(KSerializer kSerializer) {
        this.serializer = kSerializer;
    }
}
