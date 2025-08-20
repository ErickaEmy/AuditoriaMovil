package org.fdroid.download;

import java.net.InetAddress;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Dns;
/* compiled from: HttpManager.kt */
/* loaded from: classes2.dex */
final class NoDns implements Dns {
    @Override // okhttp3.Dns
    public List lookup(String hostname) {
        List listOf;
        Intrinsics.checkNotNullParameter(hostname, "hostname");
        listOf = CollectionsKt__CollectionsJVMKt.listOf(InetAddress.getByAddress(hostname, new byte[4]));
        return listOf;
    }
}
