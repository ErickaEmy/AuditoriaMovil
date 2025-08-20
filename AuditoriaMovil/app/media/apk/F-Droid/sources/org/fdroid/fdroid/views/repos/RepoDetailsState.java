package org.fdroid.fdroid.views.repos;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.fdroid.database.Repository;
/* compiled from: RepoDetailsViewModel.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\bJ&\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lorg/fdroid/fdroid/views/repos/RepoDetailsState;", "", "repo", "Lorg/fdroid/database/Repository;", "archiveEnabled", "", "(Lorg/fdroid/database/Repository;Ljava/lang/Boolean;)V", "getArchiveEnabled", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getRepo", "()Lorg/fdroid/database/Repository;", "component1", "component2", "copy", "(Lorg/fdroid/database/Repository;Ljava/lang/Boolean;)Lorg/fdroid/fdroid/views/repos/RepoDetailsState;", "equals", "other", "hashCode", "", "toString", "", "app_fullRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class RepoDetailsState {
    public static final int $stable = 8;
    private final Boolean archiveEnabled;
    private final Repository repo;

    public static /* synthetic */ RepoDetailsState copy$default(RepoDetailsState repoDetailsState, Repository repository, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            repository = repoDetailsState.repo;
        }
        if ((i & 2) != 0) {
            bool = repoDetailsState.archiveEnabled;
        }
        return repoDetailsState.copy(repository, bool);
    }

    public final Repository component1() {
        return this.repo;
    }

    public final Boolean component2() {
        return this.archiveEnabled;
    }

    public final RepoDetailsState copy(Repository repository, Boolean bool) {
        return new RepoDetailsState(repository, bool);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RepoDetailsState) {
            RepoDetailsState repoDetailsState = (RepoDetailsState) obj;
            return Intrinsics.areEqual(this.repo, repoDetailsState.repo) && Intrinsics.areEqual(this.archiveEnabled, repoDetailsState.archiveEnabled);
        }
        return false;
    }

    public final Boolean getArchiveEnabled() {
        return this.archiveEnabled;
    }

    public final Repository getRepo() {
        return this.repo;
    }

    public int hashCode() {
        Repository repository = this.repo;
        int hashCode = (repository == null ? 0 : repository.hashCode()) * 31;
        Boolean bool = this.archiveEnabled;
        return hashCode + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        Repository repository = this.repo;
        Boolean bool = this.archiveEnabled;
        return "RepoDetailsState(repo=" + repository + ", archiveEnabled=" + bool + ")";
    }

    public RepoDetailsState(Repository repository, Boolean bool) {
        this.repo = repository;
        this.archiveEnabled = bool;
    }

    public /* synthetic */ RepoDetailsState(Repository repository, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(repository, (i & 2) != 0 ? null : bool);
    }
}
