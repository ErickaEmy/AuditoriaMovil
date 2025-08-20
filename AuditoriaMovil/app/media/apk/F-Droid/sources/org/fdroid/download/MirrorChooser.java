package org.fdroid.download;

import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;
/* compiled from: MirrorChooser.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&JH\u0010\f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00072\u0006\u0010\u0003\u001a\u00020\u00022(\u0010\u000b\u001a$\b\u0001\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\bH¦@¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lorg/fdroid/download/MirrorChooser;", "", "Lorg/fdroid/download/DownloadRequest;", "downloadRequest", "", "Lorg/fdroid/download/Mirror;", "orderMirrors", "T", "Lkotlin/Function3;", "Lio/ktor/http/Url;", "Lkotlin/coroutines/Continuation;", "request", "mirrorRequest", "(Lorg/fdroid/download/DownloadRequest;Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "download_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes2.dex */
public interface MirrorChooser {
    <T> Object mirrorRequest(DownloadRequest downloadRequest, Function3 function3, Continuation continuation);

    List<Mirror> orderMirrors(DownloadRequest downloadRequest);
}
