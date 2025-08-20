package org.fdroid.repo;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.fdroid.database.MinimalApp;
import org.fdroid.database.Repository;
/* compiled from: RepoAdder.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\b\u0010\u0018\u001a\u00020\u0003H\u0016R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lorg/fdroid/repo/Fetching;", "Lorg/fdroid/repo/AddRepoState;", "fetchUrl", "", "receivedRepo", "Lorg/fdroid/database/Repository;", "apps", "", "Lorg/fdroid/database/MinimalApp;", "fetchResult", "Lorg/fdroid/repo/FetchResult;", "done", "", "(Ljava/lang/String;Lorg/fdroid/database/Repository;Ljava/util/List;Lorg/fdroid/repo/FetchResult;Z)V", "getApps", "()Ljava/util/List;", "getDone", "()Z", "getFetchResult", "()Lorg/fdroid/repo/FetchResult;", "getFetchUrl", "()Ljava/lang/String;", "getReceivedRepo", "()Lorg/fdroid/database/Repository;", "toString", "database_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class Fetching extends AddRepoState {
    private final List<MinimalApp> apps;
    private final boolean done;
    private final FetchResult fetchResult;
    private final String fetchUrl;
    private final Repository receivedRepo;

    public final List<MinimalApp> getApps() {
        return this.apps;
    }

    public final boolean getDone() {
        return this.done;
    }

    public final FetchResult getFetchResult() {
        return this.fetchResult;
    }

    public final String getFetchUrl() {
        return this.fetchUrl;
    }

    public final Repository getReceivedRepo() {
        return this.receivedRepo;
    }

    public /* synthetic */ Fetching(String str, Repository repository, List list, FetchResult fetchResult, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, repository, list, fetchResult, (i & 16) != 0 ? false : z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public Fetching(String fetchUrl, Repository repository, List<? extends MinimalApp> apps, FetchResult fetchResult, boolean z) {
        super(null);
        Intrinsics.checkNotNullParameter(fetchUrl, "fetchUrl");
        Intrinsics.checkNotNullParameter(apps, "apps");
        this.fetchUrl = fetchUrl;
        this.receivedRepo = repository;
        this.apps = apps;
        this.fetchResult = fetchResult;
        this.done = z;
    }

    public String toString() {
        String str = this.fetchUrl;
        Repository repository = this.receivedRepo;
        String address = repository != null ? repository.getAddress() : null;
        int size = this.apps.size();
        FetchResult fetchResult = this.fetchResult;
        boolean z = this.done;
        return "Fetching(fetchUrl=" + str + ", repo=" + address + ", apps=" + size + ", fetchResult=" + fetchResult + ", done=" + z + ")";
    }
}
