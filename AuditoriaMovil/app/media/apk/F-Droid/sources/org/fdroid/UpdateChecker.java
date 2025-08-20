package org.fdroid;

import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import androidx.core.content.pm.PackageInfoCompat;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.SetsKt__SetsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.fdroid.index.IndexUtils;
import org.fdroid.index.v2.PackageVersion;
/* compiled from: UpdateChecker.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004JU\u0010\u0005\u001a\u0004\u0018\u0001H\u0006\"\b\b\u0000\u0010\u0006*\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t2\u0012\b\u0002\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u000e¢\u0006\u0002\u0010\u0010Jy\u0010\u0011\u001a\u0004\u0018\u0001H\u0006\"\b\b\u0000\u0010\u0006*\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\t2\u0018\b\u0002\u0010\u0012\u001a\u0012\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0013\u0018\u00010\u000e2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t2\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0012\b\u0002\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u000e¢\u0006\u0002\u0010\u0019J]\u0010\u0011\u001a\u0004\u0018\u0001H\u0006\"\b\b\u0000\u0010\u0006*\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\t2\u0006\u0010\u001a\u001a\u00020\u001b2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t2\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0012\b\u0002\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u000e¢\u0006\u0002\u0010\u001cJ0\u0010\u001d\u001a\u00020\u00182\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001e2\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t2\b\u0010 \u001a\u0004\u0018\u00010\u000fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!²\u0006\u001c\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0013\"\b\b\u0000\u0010\u0006*\u00020\u0007X\u008a\u0084\u0002"}, d2 = {"Lorg/fdroid/UpdateChecker;", "", "compatibilityChecker", "Lorg/fdroid/CompatibilityChecker;", "(Lorg/fdroid/CompatibilityChecker;)V", "getSuggestedVersion", "T", "Lorg/fdroid/index/v2/PackageVersion;", "versions", "", "preferredSigner", "", "releaseChannels", "preferencesGetter", "Lkotlin/Function0;", "Lorg/fdroid/PackagePreference;", "(Ljava/util/List;Ljava/lang/String;Ljava/util/List;Lkotlin/jvm/functions/Function0;)Lorg/fdroid/index/v2/PackageVersion;", "getUpdate", "allowedSignersGetter", "", "installedVersionCode", "", "allowedReleaseChannels", "includeKnownVulnerabilities", "", "(Ljava/util/List;Lkotlin/jvm/functions/Function0;JLjava/util/List;ZLkotlin/jvm/functions/Function0;)Lorg/fdroid/index/v2/PackageVersion;", "packageInfo", "Landroid/content/pm/PackageInfo;", "(Ljava/util/List;Landroid/content/pm/PackageInfo;Ljava/util/List;ZLkotlin/jvm/functions/Function0;)Lorg/fdroid/index/v2/PackageVersion;", "hasAllowedReleaseChannel", "", "versionReleaseChannels", "packagePreference", "index_release", "allowedSigners"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class UpdateChecker {
    private final CompatibilityChecker compatibilityChecker;

    public UpdateChecker(CompatibilityChecker compatibilityChecker) {
        Intrinsics.checkNotNullParameter(compatibilityChecker, "compatibilityChecker");
        this.compatibilityChecker = compatibilityChecker;
    }

    public static /* synthetic */ PackageVersion getUpdate$default(UpdateChecker updateChecker, List list, PackageInfo packageInfo, List list2, boolean z, Function0 function0, int i, Object obj) {
        List list3 = (i & 4) != 0 ? null : list2;
        if ((i & 8) != 0) {
            z = false;
        }
        return updateChecker.getUpdate(list, packageInfo, list3, z, (i & 16) != 0 ? null : function0);
    }

    public final <T extends PackageVersion> T getUpdate(List<? extends T> versions, final PackageInfo packageInfo, List<String> list, boolean z, Function0 function0) {
        Intrinsics.checkNotNullParameter(versions, "versions");
        Intrinsics.checkNotNullParameter(packageInfo, "packageInfo");
        return (T) getUpdate(versions, new Function0() { // from class: org.fdroid.UpdateChecker$getUpdate$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Set invoke() {
                Set set;
                Signature[] signatureArr = packageInfo.signatures;
                if (signatureArr != null) {
                    ArrayList arrayList = new ArrayList(signatureArr.length);
                    for (Signature signature : signatureArr) {
                        IndexUtils indexUtils = IndexUtils.INSTANCE;
                        byte[] byteArray = signature.toByteArray();
                        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(...)");
                        arrayList.add(indexUtils.getPackageSigner(byteArray));
                    }
                    set = CollectionsKt___CollectionsKt.toSet(arrayList);
                    return set;
                }
                return null;
            }
        }, PackageInfoCompat.getLongVersionCode(packageInfo), list, z, function0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PackageVersion getSuggestedVersion$default(UpdateChecker updateChecker, List list, String str, List list2, Function0 function0, int i, Object obj) {
        if ((i & 4) != 0) {
            list2 = null;
        }
        if ((i & 8) != 0) {
            function0 = null;
        }
        return updateChecker.getSuggestedVersion(list, str, list2, function0);
    }

    public final <T extends PackageVersion> T getSuggestedVersion(List<? extends T> versions, final String str, List<String> list, Function0 function0) {
        Intrinsics.checkNotNullParameter(versions, "versions");
        return (T) getUpdate$default(this, versions, str != null ? new Function0() { // from class: org.fdroid.UpdateChecker$getSuggestedVersion$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Set invoke() {
                Set of;
                of = SetsKt__SetsJVMKt.setOf(str);
                return of;
            }
        } : null, 0L, list, false, function0, 20, null);
    }

    public static /* synthetic */ PackageVersion getUpdate$default(UpdateChecker updateChecker, List list, Function0 function0, long j, List list2, boolean z, Function0 function02, int i, Object obj) {
        return updateChecker.getUpdate(list, (i & 2) != 0 ? null : function0, (i & 4) != 0 ? 0L : j, (i & 8) != 0 ? null : list2, (i & 16) != 0 ? false : z, (i & 32) == 0 ? function02 : null);
    }

    private static final Set<String> getUpdate$lambda$1(Lazy lazy) {
        return (Set) lazy.getValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0070, code lost:
        r3 = kotlin.collections.CollectionsKt___CollectionsKt.toMutableSet(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00b2, code lost:
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final <T extends org.fdroid.index.v2.PackageVersion> T getUpdate(java.util.List<? extends T> r8, final kotlin.jvm.functions.Function0 r9, long r10, java.util.List<java.lang.String> r12, boolean r13, kotlin.jvm.functions.Function0 r14) {
        /*
            r7 = this;
            java.lang.String r0 = "versions"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            org.fdroid.UpdateChecker$getUpdate$allowedSigners$2 r0 = new org.fdroid.UpdateChecker$getUpdate$allowedSigners$2
            r0.<init>()
            kotlin.Lazy r9 = kotlin.LazyKt.lazy(r0)
            java.util.Iterator r8 = r8.iterator()
        L12:
            boolean r0 = r8.hasNext()
            r1 = 0
            if (r0 == 0) goto Lb3
            java.lang.Object r0 = r8.next()
            org.fdroid.index.v2.PackageVersion r0 = (org.fdroid.index.v2.PackageVersion) r0
            if (r13 == 0) goto L30
            long r2 = r0.getVersionCode()
            int r2 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1))
            if (r2 != 0) goto L30
            boolean r2 = r0.getHasKnownVulnerability()
            if (r2 == 0) goto L30
            return r0
        L30:
            long r2 = r0.getVersionCode()
            int r2 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1))
            if (r2 > 0) goto L39
            return r1
        L39:
            org.fdroid.index.v2.SignerV2 r2 = r0.getSigner()
            if (r2 == 0) goto L47
            boolean r2 = r2.getHasMultipleSigners()
            r3 = 1
            if (r2 != r3) goto L47
            goto L12
        L47:
            org.fdroid.CompatibilityChecker r2 = r7.compatibilityChecker
            org.fdroid.index.v2.PackageManifest r3 = r0.getPackageManifest()
            boolean r2 = r2.isCompatible(r3)
            if (r2 == 0) goto L12
            if (r14 == 0) goto L5c
            java.lang.Object r2 = r14.invoke()
            org.fdroid.PackagePreference r2 = (org.fdroid.PackagePreference) r2
            goto L5d
        L5c:
            r2 = r1
        L5d:
            if (r2 == 0) goto L64
            long r3 = r2.getIgnoreVersionCodeUpdate()
            goto L66
        L64:
            r3 = 0
        L66:
            long r5 = r0.getVersionCode()
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 >= 0) goto L12
            if (r12 == 0) goto L76
            java.util.Set r3 = kotlin.collections.CollectionsKt.toMutableSet(r12)
            if (r3 != 0) goto L7b
        L76:
            java.util.LinkedHashSet r3 = new java.util.LinkedHashSet
            r3.<init>()
        L7b:
            java.util.List r4 = r0.getReleaseChannels()
            boolean r2 = r7.hasAllowedReleaseChannel(r3, r4, r2)
            if (r2 == 0) goto L12
            org.fdroid.index.v2.SignerV2 r2 = r0.getSigner()
            if (r2 == 0) goto L95
            java.util.List r2 = r2.getSha256()
            if (r2 == 0) goto L95
            java.util.Set r1 = kotlin.collections.CollectionsKt.toSet(r2)
        L95:
            if (r1 == 0) goto Lb2
            java.util.Set r2 = getUpdate$lambda$1(r9)
            if (r2 == 0) goto Lb2
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Set r2 = getUpdate$lambda$1(r9)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.Set r1 = kotlin.collections.CollectionsKt.intersect(r1, r2)
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L12
        Lb2:
            return r0
        Lb3:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.fdroid.UpdateChecker.getUpdate(java.util.List, kotlin.jvm.functions.Function0, long, java.util.List, boolean, kotlin.jvm.functions.Function0):org.fdroid.index.v2.PackageVersion");
    }

    private final boolean hasAllowedReleaseChannel(Set<String> set, List<String> list, PackagePreference packagePreference) {
        Set intersect;
        if (list != null && !list.isEmpty()) {
            List<String> releaseChannels = packagePreference != null ? packagePreference.getReleaseChannels() : null;
            if (releaseChannels != null && !releaseChannels.isEmpty()) {
                set.addAll(releaseChannels);
            }
            if (set.isEmpty()) {
                return false;
            }
            intersect = CollectionsKt___CollectionsKt.intersect(set, list);
            if (intersect.isEmpty()) {
                return false;
            }
        }
        return true;
    }
}
