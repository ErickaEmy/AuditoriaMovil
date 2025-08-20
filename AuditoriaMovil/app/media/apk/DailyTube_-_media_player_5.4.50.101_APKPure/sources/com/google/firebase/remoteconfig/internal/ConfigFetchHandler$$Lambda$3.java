package com.google.firebase.remoteconfig.internal;

import com.google.android.gms.tasks.Continuation;
import java.util.Date;
/* loaded from: classes.dex */
public final /* synthetic */ class ConfigFetchHandler$$Lambda$3 implements Continuation {
    private final ConfigFetchHandler arg$1;
    private final Date arg$2;

    private ConfigFetchHandler$$Lambda$3(ConfigFetchHandler configFetchHandler, Date date) {
        this.arg$1 = configFetchHandler;
        this.arg$2 = date;
    }

    public static Continuation lambdaFactory$(ConfigFetchHandler configFetchHandler, Date date) {
        return new ConfigFetchHandler$$Lambda$3(configFetchHandler, date);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: com.google.firebase.remoteconfig.internal.ConfigFetchHandler.lambda$fetchIfCacheExpiredAndNotThrottled$2(com.google.firebase.remoteconfig.internal.ConfigFetchHandler, java.util.Date, com.google.android.gms.tasks.Task):com.google.android.gms.tasks.Task
        	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:76)
        	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:51)
        Caused by: java.lang.NullPointerException
        	at jadx.core.dex.instructions.args.RegisterArg.sameRegAndSVar(RegisterArg.java:173)
        	at jadx.core.dex.instructions.args.InsnArg.isSameVar(InsnArg.java:269)
        	at jadx.core.dex.visitors.MarkMethodsForInline.isSyntheticAccessPattern(MarkMethodsForInline.java:118)
        	at jadx.core.dex.visitors.MarkMethodsForInline.inlineMth(MarkMethodsForInline.java:86)
        	at jadx.core.dex.visitors.MarkMethodsForInline.process(MarkMethodsForInline.java:53)
        	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:65)
        	... 1 more
        */
    @Override // com.google.android.gms.tasks.Continuation
    public java.lang.Object then(com.google.android.gms.tasks.Task r3) {
        /*
            r2 = this;
            com.google.firebase.remoteconfig.internal.ConfigFetchHandler r0 = r2.arg$1
            java.util.Date r1 = r2.arg$2
            com.google.android.gms.tasks.Task r3 = com.google.firebase.remoteconfig.internal.ConfigFetchHandler.lambda$fetchIfCacheExpiredAndNotThrottled$2(r0, r1, r3)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.remoteconfig.internal.ConfigFetchHandler$$Lambda$3.then(com.google.android.gms.tasks.Task):java.lang.Object");
    }
}
