package org.fdroid.repo;

import android.net.Uri;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.fdroid.database.Repository;
import org.fdroid.index.RepoUriBuilder;
/* compiled from: RepoAdder.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"REPO_ID", "", "defaultRepoUriBuilder", "Lorg/fdroid/index/RepoUriBuilder;", "getDefaultRepoUriBuilder", "()Lorg/fdroid/index/RepoUriBuilder;", "database_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class RepoAdderKt {
    public static final long REPO_ID = 0;
    private static final RepoUriBuilder defaultRepoUriBuilder = new RepoUriBuilder() { // from class: org.fdroid.repo.RepoAdderKt$$ExternalSyntheticLambda0
        @Override // org.fdroid.index.RepoUriBuilder
        public final Uri getUri(Repository repository, String[] strArr) {
            Uri defaultRepoUriBuilder$lambda$1;
            defaultRepoUriBuilder$lambda$1 = RepoAdderKt.defaultRepoUriBuilder$lambda$1(repository, strArr);
            return defaultRepoUriBuilder$lambda$1;
        }
    };

    public static final RepoUriBuilder getDefaultRepoUriBuilder() {
        return defaultRepoUriBuilder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Uri defaultRepoUriBuilder$lambda$1(Repository repo, String[] pathElements) {
        Intrinsics.checkNotNullParameter(repo, "repo");
        Intrinsics.checkNotNullParameter(pathElements, "pathElements");
        Uri.Builder buildUpon = Uri.parse(repo.getAddress()).buildUpon();
        for (String str : pathElements) {
            buildUpon.appendEncodedPath(str);
        }
        Uri build = buildUpon.build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        return build;
    }
}
