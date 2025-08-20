package io.ktor.util.pipeline;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: PhaseContent.kt */
/* loaded from: classes.dex */
public final class PhaseContent {
    public static final Companion Companion = new Companion(null);
    private static final List SharedArrayList = new ArrayList();
    private List interceptors;
    private final PipelinePhase phase;
    private final PipelinePhaseRelation relation;
    private boolean shared;

    /* compiled from: PhaseContent.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final PipelinePhase getPhase() {
        return this.phase;
    }

    public final PipelinePhaseRelation getRelation() {
        return this.relation;
    }

    public final List sharedInterceptors() {
        this.shared = true;
        return this.interceptors;
    }

    public PhaseContent(PipelinePhase phase, PipelinePhaseRelation relation, List interceptors) {
        Intrinsics.checkNotNullParameter(phase, "phase");
        Intrinsics.checkNotNullParameter(relation, "relation");
        Intrinsics.checkNotNullParameter(interceptors, "interceptors");
        this.phase = phase;
        this.relation = relation;
        this.interceptors = interceptors;
        this.shared = true;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public PhaseContent(io.ktor.util.pipeline.PipelinePhase r3, io.ktor.util.pipeline.PipelinePhaseRelation r4) {
        /*
            r2 = this;
            java.lang.String r0 = "phase"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "relation"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.util.List r0 = io.ktor.util.pipeline.PhaseContent.SharedArrayList
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.collections.MutableList<kotlin.Function3<io.ktor.util.pipeline.PipelineContext<TSubject of io.ktor.util.pipeline.PhaseContent, Call of io.ktor.util.pipeline.PhaseContent>, TSubject of io.ktor.util.pipeline.PhaseContent, kotlin.coroutines.Continuation<kotlin.Unit>, kotlin.Any?>{ io.ktor.util.pipeline.PipelineKt.PipelineInterceptorFunction<TSubject of io.ktor.util.pipeline.PhaseContent, Call of io.ktor.util.pipeline.PhaseContent> }>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r1)
            java.util.List r1 = kotlin.jvm.internal.TypeIntrinsics.asMutableList(r0)
            r2.<init>(r3, r4, r1)
            boolean r3 = r0.isEmpty()
            if (r3 == 0) goto L1f
            return
        L1f:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.String r4 = "The shared empty array list has been modified"
            java.lang.String r4 = r4.toString()
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.util.pipeline.PhaseContent.<init>(io.ktor.util.pipeline.PipelinePhase, io.ktor.util.pipeline.PipelinePhaseRelation):void");
    }

    public final boolean isEmpty() {
        return this.interceptors.isEmpty();
    }

    public final int getSize() {
        return this.interceptors.size();
    }

    public final void addInterceptor(Function3 interceptor) {
        Intrinsics.checkNotNullParameter(interceptor, "interceptor");
        if (this.shared) {
            copyInterceptors();
        }
        this.interceptors.add(interceptor);
    }

    public final void addTo(List destination) {
        Intrinsics.checkNotNullParameter(destination, "destination");
        List list = this.interceptors;
        if (destination instanceof ArrayList) {
            ((ArrayList) destination).ensureCapacity(destination.size() + list.size());
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            destination.add(list.get(i));
        }
    }

    public final List copiedInterceptors() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.interceptors);
        return arrayList;
    }

    public String toString() {
        return "Phase `" + this.phase.getName() + "`, " + getSize() + " handlers";
    }

    private final void copyInterceptors() {
        this.interceptors = copiedInterceptors();
        this.shared = false;
    }
}
