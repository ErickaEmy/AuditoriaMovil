package org.fdroid.download;

import io.ktor.client.plugins.ResponseException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Reflection;
import mu.KLogger;
import mu.KotlinLogging;
/* compiled from: MirrorChooser.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\b \u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u001c\u0010\b\u001a\u00020\u00072\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002JH\u0010\u0012\u001a\u00028\u0000\"\u0004\b\u0000\u0010\t2\u0006\u0010\u000b\u001a\u00020\n2(\u0010\u0011\u001a$\b\u0001\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00100\fH\u0096@¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lorg/fdroid/download/MirrorChooserImpl;", "Lorg/fdroid/download/MirrorChooser;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "e", "", "wasLastMirror", "", "throwOnLastMirror", "T", "Lorg/fdroid/download/DownloadRequest;", "downloadRequest", "Lkotlin/Function3;", "Lorg/fdroid/download/Mirror;", "Lio/ktor/http/Url;", "Lkotlin/coroutines/Continuation;", "", "request", "mirrorRequest", "(Lorg/fdroid/download/DownloadRequest;Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<init>", "()V", "Companion", "download_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes2.dex */
public abstract class MirrorChooserImpl implements MirrorChooser {
    public static final Companion Companion = new Companion(null);
    private static final KLogger log = KotlinLogging.INSTANCE.logger(new Function0() { // from class: org.fdroid.download.MirrorChooserImpl$Companion$log$1
        /* renamed from: invoke  reason: collision with other method in class */
        public final void m2380invoke() {
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            m2380invoke();
            return Unit.INSTANCE;
        }
    });

    @Override // org.fdroid.download.MirrorChooser
    public <T> Object mirrorRequest(DownloadRequest downloadRequest, Function3 function3, Continuation continuation) {
        return mirrorRequest$suspendImpl(this, downloadRequest, function3, continuation);
    }

    /* compiled from: MirrorChooser.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lorg/fdroid/download/MirrorChooserImpl$Companion;", "", "()V", "log", "Lmu/KLogger;", "getLog", "()Lmu/KLogger;", "download_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        protected final KLogger getLog() {
            return MirrorChooserImpl.log;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0185  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:59:0x011d -> B:70:0x0144). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:64:0x0132 -> B:87:0x0189). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:69:0x0140 -> B:87:0x0189). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ <T> java.lang.Object mirrorRequest$suspendImpl(org.fdroid.download.MirrorChooserImpl r15, org.fdroid.download.DownloadRequest r16, kotlin.jvm.functions.Function3 r17, kotlin.coroutines.Continuation r18) {
        /*
            Method dump skipped, instructions count: 416
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.fdroid.download.MirrorChooserImpl.mirrorRequest$suspendImpl(org.fdroid.download.MirrorChooserImpl, org.fdroid.download.DownloadRequest, kotlin.jvm.functions.Function3, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void throwOnLastMirror(final Exception exc, final boolean z) {
        log.info(new Function0() { // from class: org.fdroid.download.MirrorChooserImpl$throwOnLastMirror$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                String simpleName;
                Exception exc2 = exc;
                if (exc2 instanceof ResponseException) {
                    simpleName = ((ResponseException) exc2).getResponse().getStatus().toString();
                } else {
                    simpleName = Reflection.getOrCreateKotlinClass(exc2.getClass()).getSimpleName();
                    if (simpleName == null) {
                        simpleName = "";
                    }
                }
                if (z) {
                    return "Last mirror, rethrowing... (" + simpleName + ")";
                }
                return "Trying other mirror now... (" + simpleName + ")";
            }
        });
        if (z) {
            throw exc;
        }
    }
}
