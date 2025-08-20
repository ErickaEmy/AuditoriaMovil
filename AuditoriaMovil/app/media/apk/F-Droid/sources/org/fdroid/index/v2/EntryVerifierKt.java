package org.fdroid.index.v2;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
/* compiled from: EntryVerifier.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0004"}, d2 = {"DATA_FILE_NAME", "", "FORBIDDEN_DIGESTS", "", "index_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class EntryVerifierKt {
    public static final String DATA_FILE_NAME = "entry.json";
    private static final List<String> FORBIDDEN_DIGESTS;

    static {
        List<String> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"MD5-Digest", "SHA1-Digest"});
        FORBIDDEN_DIGESTS = listOf;
    }
}
