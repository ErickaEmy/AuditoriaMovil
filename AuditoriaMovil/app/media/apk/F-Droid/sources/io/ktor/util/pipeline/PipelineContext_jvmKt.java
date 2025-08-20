package io.ktor.util.pipeline;

import kotlin.jvm.internal.Intrinsics;
/* compiled from: PipelineContext.jvm.kt */
/* loaded from: classes.dex */
public abstract class PipelineContext_jvmKt {
    private static final boolean DISABLE_SFG = Intrinsics.areEqual(System.getProperty("io.ktor.internal.disable.sfg"), "true");

    public static final boolean getDISABLE_SFG() {
        return DISABLE_SFG;
    }
}
