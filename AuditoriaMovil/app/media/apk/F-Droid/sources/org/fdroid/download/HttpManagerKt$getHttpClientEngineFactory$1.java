package org.fdroid.download;

import io.ktor.client.engine.HttpClientEngine;
import io.ktor.client.engine.HttpClientEngineFactory;
import io.ktor.client.engine.okhttp.OkHttp;
import io.ktor.client.engine.okhttp.OkHttpConfig;
import java.util.List;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSessionContext;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import okhttp3.ConnectionSpec;
import okhttp3.Dns;
import okhttp3.OkHttpClient;
import okhttp3.internal.tls.OkHostnameVerifier;
/* compiled from: HttpManager.kt */
@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u0003H\u0016R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"org/fdroid/download/HttpManagerKt$getHttpClientEngineFactory$1", "Lio/ktor/client/engine/HttpClientEngineFactory;", "Lio/ktor/client/engine/okhttp/OkHttpConfig;", "Lkotlin/Function1;", "", "block", "Lio/ktor/client/engine/HttpClientEngine;", "create", "", "Lokhttp3/ConnectionSpec;", "connectionSpecs", "Ljava/util/List;", "download_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes2.dex */
public final class HttpManagerKt$getHttpClientEngineFactory$1 implements HttpClientEngineFactory {
    final /* synthetic */ Dns $customDns;
    private final List<ConnectionSpec> connectionSpecs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HttpManagerKt$getHttpClientEngineFactory$1(Dns dns) {
        List<ConnectionSpec> listOf;
        this.$customDns = dns;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new ConnectionSpec[]{ConnectionSpec.RESTRICTED_TLS, ConnectionSpec.MODERN_TLS, ConnectionSpec.CLEARTEXT});
        this.connectionSpecs = listOf;
    }

    @Override // io.ktor.client.engine.HttpClientEngineFactory
    public HttpClientEngine create(final Function1 block) {
        Intrinsics.checkNotNullParameter(block, "block");
        OkHttp okHttp = OkHttp.INSTANCE;
        final Dns dns = this.$customDns;
        return okHttp.create(new Function1() { // from class: org.fdroid.download.HttpManagerKt$getHttpClientEngineFactory$1$create$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((OkHttpConfig) obj);
                return Unit.INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: HttpManager.kt */
            /* renamed from: org.fdroid.download.HttpManagerKt$getHttpClientEngineFactory$1$create$1$1  reason: invalid class name */
            /* loaded from: classes2.dex */
            public static final class AnonymousClass1 extends Lambda implements Function1 {
                final /* synthetic */ Dns $customDns;
                final /* synthetic */ OkHttpConfig $this_create;
                final /* synthetic */ HttpManagerKt$getHttpClientEngineFactory$1 this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(OkHttpConfig okHttpConfig, Dns dns, HttpManagerKt$getHttpClientEngineFactory$1 httpManagerKt$getHttpClientEngineFactory$1) {
                    super(1);
                    this.$this_create = okHttpConfig;
                    this.$customDns = dns;
                    this.this$0 = httpManagerKt$getHttpClientEngineFactory$1;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((OkHttpClient.Builder) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(OkHttpClient.Builder config) {
                    List list;
                    Intrinsics.checkNotNullParameter(config, "$this$config");
                    if (ProxyKt.isTor(this.$this_create.getProxy())) {
                        config.dns(new NoDns());
                    } else {
                        Dns dns = this.$customDns;
                        if (dns != null) {
                            config.dns(dns);
                        }
                    }
                    config.hostnameVerifier(
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0026: INVOKE  
                          (r2v0 'config' okhttp3.OkHttpClient$Builder)
                          (wrap: javax.net.ssl.HostnameVerifier : 0x0023: CONSTRUCTOR  (r0v5 javax.net.ssl.HostnameVerifier A[REMOVE]) =  call: org.fdroid.download.HttpManagerKt$getHttpClientEngineFactory$1$create$1$1$$ExternalSyntheticLambda0.<init>():void type: CONSTRUCTOR)
                         type: VIRTUAL call: okhttp3.OkHttpClient.Builder.hostnameVerifier(javax.net.ssl.HostnameVerifier):okhttp3.OkHttpClient$Builder in method: org.fdroid.download.HttpManagerKt$getHttpClientEngineFactory$1$create$1.1.invoke(okhttp3.OkHttpClient$Builder):void, file: classes2.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:309)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:272)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:91)
                        	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:296)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:275)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:377)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:306)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:272)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: org.fdroid.download.HttpManagerKt$getHttpClientEngineFactory$1$create$1$1$$ExternalSyntheticLambda0, state: NOT_LOADED
                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:302)
                        	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:769)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:718)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:417)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:144)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1097)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:872)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:421)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:302)
                        	... 15 more
                        */
                    /*
                        this = this;
                        java.lang.String r0 = "$this$config"
                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
                        io.ktor.client.engine.okhttp.OkHttpConfig r0 = r1.$this_create
                        java.net.Proxy r0 = r0.getProxy()
                        boolean r0 = org.fdroid.download.ProxyKt.isTor(r0)
                        if (r0 == 0) goto L1a
                        org.fdroid.download.NoDns r0 = new org.fdroid.download.NoDns
                        r0.<init>()
                        r2.dns(r0)
                        goto L21
                    L1a:
                        okhttp3.Dns r0 = r1.$customDns
                        if (r0 == 0) goto L21
                        r2.dns(r0)
                    L21:
                        org.fdroid.download.HttpManagerKt$getHttpClientEngineFactory$1$create$1$1$$ExternalSyntheticLambda0 r0 = new org.fdroid.download.HttpManagerKt$getHttpClientEngineFactory$1$create$1$1$$ExternalSyntheticLambda0
                        r0.<init>()
                        r2.hostnameVerifier(r0)
                        org.fdroid.download.HttpManagerKt$getHttpClientEngineFactory$1 r0 = r1.this$0
                        java.util.List r0 = org.fdroid.download.HttpManagerKt$getHttpClientEngineFactory$1.access$getConnectionSpecs$p(r0)
                        r2.connectionSpecs(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.fdroid.download.HttpManagerKt$getHttpClientEngineFactory$1$create$1.AnonymousClass1.invoke(okhttp3.OkHttpClient$Builder):void");
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final boolean invoke$lambda$0(String str, SSLSession sSLSession) {
                    SSLSessionContext sessionContext = sSLSession != null ? sSLSession.getSessionContext() : null;
                    if (sessionContext != null) {
                        sessionContext.setSessionTimeout(10);
                    }
                    OkHostnameVerifier okHostnameVerifier = OkHostnameVerifier.INSTANCE;
                    Intrinsics.checkNotNull(str);
                    Intrinsics.checkNotNull(sSLSession);
                    return okHostnameVerifier.verify(str, sSLSession);
                }
            }

            public final void invoke(OkHttpConfig create) {
                Intrinsics.checkNotNullParameter(create, "$this$create");
                Function1.this.invoke(create);
                create.config(new AnonymousClass1(create, dns, this));
            }
        });
    }
}
