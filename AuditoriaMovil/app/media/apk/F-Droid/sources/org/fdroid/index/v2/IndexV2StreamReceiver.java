package org.fdroid.index.v2;

import kotlin.Metadata;
/* compiled from: IndexV2StreamReceiver.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH&¨\u0006\r"}, d2 = {"Lorg/fdroid/index/v2/IndexV2StreamReceiver;", "", "onStreamEnded", "", "receive", "packageName", "", "p", "Lorg/fdroid/index/v2/PackageV2;", "repo", "Lorg/fdroid/index/v2/RepoV2;", "version", "", "index_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface IndexV2StreamReceiver {
    void onStreamEnded();

    void receive(String str, PackageV2 packageV2);

    void receive(RepoV2 repoV2, long j);
}
