package org.fdroid.repo;

import androidx.compose.animation.FlingCalculator$FlingInfo$$ExternalSyntheticBackport0;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: RepoAdder.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0003\u0004\u0005\u0006\u0007B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0005\b\t\n\u000b\f¨\u0006\r"}, d2 = {"Lorg/fdroid/repo/FetchResult;", "", "()V", "IsExistingMirror", "IsExistingRepository", "IsNewMirror", "IsNewRepoAndNewMirror", "IsNewRepository", "Lorg/fdroid/repo/FetchResult$IsExistingMirror;", "Lorg/fdroid/repo/FetchResult$IsExistingRepository;", "Lorg/fdroid/repo/FetchResult$IsNewMirror;", "Lorg/fdroid/repo/FetchResult$IsNewRepoAndNewMirror;", "Lorg/fdroid/repo/FetchResult$IsNewRepository;", "database_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class FetchResult {
    private FetchResult() {
    }

    public /* synthetic */ FetchResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* compiled from: RepoAdder.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lorg/fdroid/repo/FetchResult$IsNewRepository;", "Lorg/fdroid/repo/FetchResult;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "database_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class IsNewRepository extends FetchResult {
        public static final IsNewRepository INSTANCE = new IsNewRepository();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof IsNewRepository) {
                IsNewRepository isNewRepository = (IsNewRepository) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 769177307;
        }

        public String toString() {
            return "IsNewRepository";
        }

        private IsNewRepository() {
            super(null);
        }
    }

    /* compiled from: RepoAdder.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lorg/fdroid/repo/FetchResult$IsNewRepoAndNewMirror;", "Lorg/fdroid/repo/FetchResult;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "database_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class IsNewRepoAndNewMirror extends FetchResult {
        public static final IsNewRepoAndNewMirror INSTANCE = new IsNewRepoAndNewMirror();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof IsNewRepoAndNewMirror) {
                IsNewRepoAndNewMirror isNewRepoAndNewMirror = (IsNewRepoAndNewMirror) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 980373707;
        }

        public String toString() {
            return "IsNewRepoAndNewMirror";
        }

        private IsNewRepoAndNewMirror() {
            super(null);
        }
    }

    /* compiled from: RepoAdder.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b\bJ\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lorg/fdroid/repo/FetchResult$IsNewMirror;", "Lorg/fdroid/repo/FetchResult;", "existingRepoId", "", "(J)V", "getExistingRepoId$database_release", "()J", "component1", "component1$database_release", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "database_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class IsNewMirror extends FetchResult {
        private final long existingRepoId;

        public static /* synthetic */ IsNewMirror copy$default(IsNewMirror isNewMirror, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                j = isNewMirror.existingRepoId;
            }
            return isNewMirror.copy(j);
        }

        public final long component1$database_release() {
            return this.existingRepoId;
        }

        public final IsNewMirror copy(long j) {
            return new IsNewMirror(j);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof IsNewMirror) && this.existingRepoId == ((IsNewMirror) obj).existingRepoId;
        }

        public final long getExistingRepoId$database_release() {
            return this.existingRepoId;
        }

        public int hashCode() {
            return FlingCalculator$FlingInfo$$ExternalSyntheticBackport0.m(this.existingRepoId);
        }

        public String toString() {
            long j = this.existingRepoId;
            return "IsNewMirror(existingRepoId=" + j + ")";
        }

        public IsNewMirror(long j) {
            super(null);
            this.existingRepoId = j;
        }
    }

    /* compiled from: RepoAdder.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lorg/fdroid/repo/FetchResult$IsExistingRepository;", "Lorg/fdroid/repo/FetchResult;", "existingRepoId", "", "(J)V", "getExistingRepoId", "()J", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "database_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class IsExistingRepository extends FetchResult {
        private final long existingRepoId;

        public static /* synthetic */ IsExistingRepository copy$default(IsExistingRepository isExistingRepository, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                j = isExistingRepository.existingRepoId;
            }
            return isExistingRepository.copy(j);
        }

        public final long component1() {
            return this.existingRepoId;
        }

        public final IsExistingRepository copy(long j) {
            return new IsExistingRepository(j);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof IsExistingRepository) && this.existingRepoId == ((IsExistingRepository) obj).existingRepoId;
        }

        public final long getExistingRepoId() {
            return this.existingRepoId;
        }

        public int hashCode() {
            return FlingCalculator$FlingInfo$$ExternalSyntheticBackport0.m(this.existingRepoId);
        }

        public String toString() {
            long j = this.existingRepoId;
            return "IsExistingRepository(existingRepoId=" + j + ")";
        }

        public IsExistingRepository(long j) {
            super(null);
            this.existingRepoId = j;
        }
    }

    /* compiled from: RepoAdder.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lorg/fdroid/repo/FetchResult$IsExistingMirror;", "Lorg/fdroid/repo/FetchResult;", "existingRepoId", "", "(J)V", "getExistingRepoId", "()J", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "database_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class IsExistingMirror extends FetchResult {
        private final long existingRepoId;

        public static /* synthetic */ IsExistingMirror copy$default(IsExistingMirror isExistingMirror, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                j = isExistingMirror.existingRepoId;
            }
            return isExistingMirror.copy(j);
        }

        public final long component1() {
            return this.existingRepoId;
        }

        public final IsExistingMirror copy(long j) {
            return new IsExistingMirror(j);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof IsExistingMirror) && this.existingRepoId == ((IsExistingMirror) obj).existingRepoId;
        }

        public final long getExistingRepoId() {
            return this.existingRepoId;
        }

        public int hashCode() {
            return FlingCalculator$FlingInfo$$ExternalSyntheticBackport0.m(this.existingRepoId);
        }

        public String toString() {
            long j = this.existingRepoId;
            return "IsExistingMirror(existingRepoId=" + j + ")";
        }

        public IsExistingMirror(long j) {
            super(null);
            this.existingRepoId = j;
        }
    }
}
