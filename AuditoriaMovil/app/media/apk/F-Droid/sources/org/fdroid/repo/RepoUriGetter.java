package org.fdroid.repo;

import android.net.Uri;
import ch.qos.logback.core.joran.action.Action;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.fdroid.fdroid.nearby.peers.BonjourPeer;
/* compiled from: RepoUriGetter.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\u000eB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\f\u001a\u0004\u0018\u00010\t*\u00020\u00042\u0006\u0010\r\u001a\u00020\tH\u0002¨\u0006\u000f"}, d2 = {"Lorg/fdroid/repo/RepoUriGetter;", "", "()V", "getFdroidLinkUri", "Landroid/net/Uri;", "uri", "getUri", "Lorg/fdroid/repo/RepoUriGetter$NormalizedUri;", "url", "", "isSwapUri", "", "getQueryParameterOrNull", Action.KEY_ATTRIBUTE, "NormalizedUri", "database_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class RepoUriGetter {
    public static final RepoUriGetter INSTANCE = new RepoUriGetter();

    private RepoUriGetter() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0066, code lost:
        if (r0 != false) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00ae, code lost:
        if (r0 == null) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0174, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r14, "archive") != false) goto L42;
     */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01b3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final org.fdroid.repo.RepoUriGetter.NormalizedUri getUri(java.lang.String r14) {
        /*
            Method dump skipped, instructions count: 476
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.fdroid.repo.RepoUriGetter.getUri(java.lang.String):org.fdroid.repo.RepoUriGetter$NormalizedUri");
    }

    public final boolean isSwapUri(Uri uri) {
        String str;
        Intrinsics.checkNotNullParameter(uri, "uri");
        String queryParameterOrNull = getQueryParameterOrNull(uri, "swap");
        if (queryParameterOrNull == null) {
            queryParameterOrNull = getQueryParameterOrNull(uri, "SWAP");
        }
        if (queryParameterOrNull != null) {
            String scheme = uri.getScheme();
            if (scheme != null) {
                str = scheme.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(str, "toLowerCase(...)");
            } else {
                str = null;
            }
            if (Intrinsics.areEqual(str, "http")) {
                return true;
            }
        }
        return false;
    }

    private final Uri getFdroidLinkUri(Uri uri) {
        Uri parse = Uri.parse(uri.getEncodedFragment());
        Intrinsics.checkNotNullExpressionValue(parse, "parse(...)");
        return parse;
    }

    private final String getQueryParameterOrNull(Uri uri, String str) {
        try {
            return uri.getQueryParameter(str);
        } catch (Exception unused) {
            return null;
        }
    }

    /* compiled from: RepoUriGetter.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J7\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001a"}, d2 = {"Lorg/fdroid/repo/RepoUriGetter$NormalizedUri;", "", "uri", "Landroid/net/Uri;", BonjourPeer.FINGERPRINT, "", "username", "password", "(Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getFingerprint", "()Ljava/lang/String;", "getPassword", "getUri", "()Landroid/net/Uri;", "getUsername", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "database_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class NormalizedUri {
        private final String fingerprint;
        private final String password;
        private final Uri uri;
        private final String username;

        public static /* synthetic */ NormalizedUri copy$default(NormalizedUri normalizedUri, Uri uri, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                uri = normalizedUri.uri;
            }
            if ((i & 2) != 0) {
                str = normalizedUri.fingerprint;
            }
            if ((i & 4) != 0) {
                str2 = normalizedUri.username;
            }
            if ((i & 8) != 0) {
                str3 = normalizedUri.password;
            }
            return normalizedUri.copy(uri, str, str2, str3);
        }

        public final Uri component1() {
            return this.uri;
        }

        public final String component2() {
            return this.fingerprint;
        }

        public final String component3() {
            return this.username;
        }

        public final String component4() {
            return this.password;
        }

        public final NormalizedUri copy(Uri uri, String str, String str2, String str3) {
            Intrinsics.checkNotNullParameter(uri, "uri");
            return new NormalizedUri(uri, str, str2, str3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof NormalizedUri) {
                NormalizedUri normalizedUri = (NormalizedUri) obj;
                return Intrinsics.areEqual(this.uri, normalizedUri.uri) && Intrinsics.areEqual(this.fingerprint, normalizedUri.fingerprint) && Intrinsics.areEqual(this.username, normalizedUri.username) && Intrinsics.areEqual(this.password, normalizedUri.password);
            }
            return false;
        }

        public final String getFingerprint() {
            return this.fingerprint;
        }

        public final String getPassword() {
            return this.password;
        }

        public final Uri getUri() {
            return this.uri;
        }

        public final String getUsername() {
            return this.username;
        }

        public int hashCode() {
            int hashCode = this.uri.hashCode() * 31;
            String str = this.fingerprint;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.username;
            int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.password;
            return hashCode3 + (str3 != null ? str3.hashCode() : 0);
        }

        public String toString() {
            Uri uri = this.uri;
            String str = this.fingerprint;
            String str2 = this.username;
            String str3 = this.password;
            return "NormalizedUri(uri=" + uri + ", fingerprint=" + str + ", username=" + str2 + ", password=" + str3 + ")";
        }

        public NormalizedUri(Uri uri, String str, String str2, String str3) {
            Intrinsics.checkNotNullParameter(uri, "uri");
            this.uri = uri;
            this.fingerprint = str;
            this.username = str2;
            this.password = str3;
        }

        public /* synthetic */ NormalizedUri(Uri uri, String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(uri, str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3);
        }
    }
}
