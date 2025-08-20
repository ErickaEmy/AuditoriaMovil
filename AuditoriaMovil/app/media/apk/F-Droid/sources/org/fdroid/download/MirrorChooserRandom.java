package org.fdroid.download;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: MirrorChooser.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lorg/fdroid/download/MirrorChooserRandom;", "Lorg/fdroid/download/MirrorChooserImpl;", "()V", "orderMirrors", "", "Lorg/fdroid/download/Mirror;", "downloadRequest", "Lorg/fdroid/download/DownloadRequest;", "download_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MirrorChooserRandom extends MirrorChooserImpl {
    @Override // org.fdroid.download.MirrorChooser
    public List<Mirror> orderMirrors(final DownloadRequest downloadRequest) {
        List<Mirror> mutableList;
        Intrinsics.checkNotNullParameter(downloadRequest, "downloadRequest");
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) downloadRequest.getMirrors());
        Collections.shuffle(mutableList);
        if (downloadRequest.getTryFirstMirror() != null && mutableList.size() > 1) {
            CollectionsKt__MutableCollectionsJVMKt.sortWith(mutableList, new Comparator() { // from class: org.fdroid.download.MirrorChooserRandom$orderMirrors$lambda$2$$inlined$sortBy$1
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    int compareValues;
                    compareValues = ComparisonsKt__ComparisonsKt.compareValues(Integer.valueOf(!Intrinsics.areEqual((Mirror) t, DownloadRequest.this.getTryFirstMirror()) ? 1 : 0), Integer.valueOf(!Intrinsics.areEqual((Mirror) t2, DownloadRequest.this.getTryFirstMirror()) ? 1 : 0));
                    return compareValues;
                }
            });
        }
        return mutableList;
    }
}
