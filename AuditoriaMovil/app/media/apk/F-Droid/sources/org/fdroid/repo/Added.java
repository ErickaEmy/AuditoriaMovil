package org.fdroid.repo;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.fdroid.database.Repository;
/* compiled from: RepoAdder.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lorg/fdroid/repo/Added;", "Lorg/fdroid/repo/AddRepoState;", "repo", "Lorg/fdroid/database/Repository;", "(Lorg/fdroid/database/Repository;)V", "getRepo", "()Lorg/fdroid/database/Repository;", "database_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class Added extends AddRepoState {
    private final Repository repo;

    public final Repository getRepo() {
        return this.repo;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Added(Repository repo) {
        super(null);
        Intrinsics.checkNotNullParameter(repo, "repo");
        this.repo = repo;
    }
}
