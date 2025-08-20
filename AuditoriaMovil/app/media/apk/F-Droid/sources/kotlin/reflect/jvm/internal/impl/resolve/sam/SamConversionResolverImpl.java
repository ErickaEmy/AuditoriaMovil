package kotlin.reflect.jvm.internal.impl.resolve.sam;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.storage.CacheWithNullableValues;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
/* compiled from: SamConversionResolverImpl.kt */
/* loaded from: classes2.dex */
public final class SamConversionResolverImpl implements SamConversionResolver {
    private final CacheWithNullableValues functionTypesForSamInterfaces;
    private final Iterable samWithReceiverResolvers;

    public SamConversionResolverImpl(StorageManager storageManager, Iterable samWithReceiverResolvers) {
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics.checkNotNullParameter(samWithReceiverResolvers, "samWithReceiverResolvers");
        this.samWithReceiverResolvers = samWithReceiverResolvers;
        this.functionTypesForSamInterfaces = storageManager.createCacheWithNullableValues();
    }
}
