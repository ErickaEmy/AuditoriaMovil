package io.ktor.util.pipeline;

import io.ktor.util.Attributes;
import io.ktor.util.AttributesJvmKt;
import io.ktor.util.pipeline.PipelinePhaseRelation;
import java.util.Arrays;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
/* compiled from: Pipeline.kt */
/* loaded from: classes.dex */
public abstract class Pipeline {
    private volatile /* synthetic */ Object _interceptors;
    private final Attributes attributes;
    private boolean interceptorsListShared;
    private PipelinePhase interceptorsListSharedPhase;
    private int interceptorsQuantity;
    private final List phasesRaw;

    private final void setInterceptors(List list) {
        this._interceptors = list;
    }

    public void afterIntercepted() {
    }

    public abstract boolean getDevelopmentMode();

    public Pipeline(PipelinePhase... phases) {
        List mutableListOf;
        Intrinsics.checkNotNullParameter(phases, "phases");
        this.attributes = AttributesJvmKt.Attributes(true);
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(Arrays.copyOf(phases, phases.length));
        this.phasesRaw = mutableListOf;
        this._interceptors = null;
    }

    private final List getInterceptors() {
        return (List) this._interceptors;
    }

    public final Object execute(Object obj, Object obj2, Continuation continuation) {
        return createContext(obj, obj2, continuation.getContext()).execute$ktor_utils(obj2, continuation);
    }

    public final void insertPhaseAfter(PipelinePhase reference, PipelinePhase phase) {
        int lastIndex;
        PipelinePhaseRelation relation;
        PipelinePhase relativeTo;
        Intrinsics.checkNotNullParameter(reference, "reference");
        Intrinsics.checkNotNullParameter(phase, "phase");
        if (hasPhase(phase)) {
            return;
        }
        int findPhaseIndex = findPhaseIndex(reference);
        if (findPhaseIndex == -1) {
            throw new InvalidPhaseException("Phase " + reference + " was not registered for this pipeline");
        }
        int i = findPhaseIndex + 1;
        lastIndex = CollectionsKt__CollectionsKt.getLastIndex(this.phasesRaw);
        if (i <= lastIndex) {
            while (true) {
                Object obj = this.phasesRaw.get(i);
                PhaseContent phaseContent = obj instanceof PhaseContent ? (PhaseContent) obj : null;
                if (phaseContent != null && (relation = phaseContent.getRelation()) != null) {
                    PipelinePhaseRelation.After after = relation instanceof PipelinePhaseRelation.After ? (PipelinePhaseRelation.After) relation : null;
                    if (after != null && (relativeTo = after.getRelativeTo()) != null && Intrinsics.areEqual(relativeTo, reference)) {
                        findPhaseIndex = i;
                    }
                    if (i == lastIndex) {
                        break;
                    }
                    i++;
                } else {
                    break;
                }
            }
        }
        this.phasesRaw.add(findPhaseIndex + 1, new PhaseContent(phase, new PipelinePhaseRelation.After(reference)));
    }

    public final void insertPhaseBefore(PipelinePhase reference, PipelinePhase phase) {
        Intrinsics.checkNotNullParameter(reference, "reference");
        Intrinsics.checkNotNullParameter(phase, "phase");
        if (hasPhase(phase)) {
            return;
        }
        int findPhaseIndex = findPhaseIndex(reference);
        if (findPhaseIndex == -1) {
            throw new InvalidPhaseException("Phase " + reference + " was not registered for this pipeline");
        }
        this.phasesRaw.add(findPhaseIndex, new PhaseContent(phase, new PipelinePhaseRelation.Before(reference)));
    }

    public final void intercept(PipelinePhase phase, Function3 block) {
        Intrinsics.checkNotNullParameter(phase, "phase");
        Intrinsics.checkNotNullParameter(block, "block");
        PhaseContent findPhase = findPhase(phase);
        if (findPhase == null) {
            throw new InvalidPhaseException("Phase " + phase + " was not registered for this pipeline");
        }
        Function3 function3 = (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(block, 3);
        if (tryAddToPhaseFastPath(phase, block)) {
            this.interceptorsQuantity++;
            return;
        }
        findPhase.addInterceptor(block);
        this.interceptorsQuantity++;
        resetInterceptorsList();
        afterIntercepted();
    }

    private final PipelineContext createContext(Object obj, Object obj2, CoroutineContext coroutineContext) {
        return PipelineContextKt.pipelineContextFor(obj, sharedInterceptorsList(), obj2, coroutineContext, getDevelopmentMode());
    }

    private final PhaseContent findPhase(PipelinePhase pipelinePhase) {
        List list = this.phasesRaw;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Object obj = list.get(i);
            if (obj == pipelinePhase) {
                PhaseContent phaseContent = new PhaseContent(pipelinePhase, PipelinePhaseRelation.Last.INSTANCE);
                list.set(i, phaseContent);
                return phaseContent;
            }
            if (obj instanceof PhaseContent) {
                PhaseContent phaseContent2 = (PhaseContent) obj;
                if (phaseContent2.getPhase() == pipelinePhase) {
                    return phaseContent2;
                }
            }
        }
        return null;
    }

    private final int findPhaseIndex(PipelinePhase pipelinePhase) {
        List list = this.phasesRaw;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Object obj = list.get(i);
            if (obj == pipelinePhase || ((obj instanceof PhaseContent) && ((PhaseContent) obj).getPhase() == pipelinePhase)) {
                return i;
            }
        }
        return -1;
    }

    private final boolean hasPhase(PipelinePhase pipelinePhase) {
        List list = this.phasesRaw;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Object obj = list.get(i);
            if (obj == pipelinePhase) {
                return true;
            }
            if ((obj instanceof PhaseContent) && ((PhaseContent) obj).getPhase() == pipelinePhase) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0017, code lost:
        r0 = kotlin.collections.CollectionsKt__CollectionsKt.getLastIndex(r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.util.List cacheInterceptors() {
        /*
            r7 = this;
            int r0 = r7.interceptorsQuantity
            if (r0 != 0) goto L10
            java.util.List r0 = kotlin.collections.CollectionsKt.emptyList()
            r7.notSharedInterceptorsList(r0)
            java.util.List r0 = kotlin.collections.CollectionsKt.emptyList()
            return r0
        L10:
            java.util.List r1 = r7.phasesRaw
            r2 = 0
            r3 = 0
            r4 = 1
            if (r0 != r4) goto L40
            int r0 = kotlin.collections.CollectionsKt.getLastIndex(r1)
            if (r0 < 0) goto L40
            r4 = r3
        L1e:
            java.lang.Object r5 = r1.get(r4)
            boolean r6 = r5 instanceof io.ktor.util.pipeline.PhaseContent
            if (r6 == 0) goto L29
            io.ktor.util.pipeline.PhaseContent r5 = (io.ktor.util.pipeline.PhaseContent) r5
            goto L2a
        L29:
            r5 = r2
        L2a:
            if (r5 != 0) goto L2d
            goto L3b
        L2d:
            boolean r6 = r5.isEmpty()
            if (r6 != 0) goto L3b
            java.util.List r0 = r5.sharedInterceptors()
            r7.setInterceptorsListFromPhase(r5)
            return r0
        L3b:
            if (r4 == r0) goto L40
            int r4 = r4 + 1
            goto L1e
        L40:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            int r4 = kotlin.collections.CollectionsKt.getLastIndex(r1)
            if (r4 < 0) goto L62
        L4b:
            java.lang.Object r5 = r1.get(r3)
            boolean r6 = r5 instanceof io.ktor.util.pipeline.PhaseContent
            if (r6 == 0) goto L56
            io.ktor.util.pipeline.PhaseContent r5 = (io.ktor.util.pipeline.PhaseContent) r5
            goto L57
        L56:
            r5 = r2
        L57:
            if (r5 != 0) goto L5a
            goto L5d
        L5a:
            r5.addTo(r0)
        L5d:
            if (r3 == r4) goto L62
            int r3 = r3 + 1
            goto L4b
        L62:
            r7.notSharedInterceptorsList(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.util.pipeline.Pipeline.cacheInterceptors():java.util.List");
    }

    private final List sharedInterceptorsList() {
        if (getInterceptors() == null) {
            cacheInterceptors();
        }
        this.interceptorsListShared = true;
        List interceptors = getInterceptors();
        Intrinsics.checkNotNull(interceptors);
        return interceptors;
    }

    private final void resetInterceptorsList() {
        setInterceptors(null);
        this.interceptorsListShared = false;
        this.interceptorsListSharedPhase = null;
    }

    private final void notSharedInterceptorsList(List list) {
        setInterceptors(list);
        this.interceptorsListShared = false;
        this.interceptorsListSharedPhase = null;
    }

    private final void setInterceptorsListFromPhase(PhaseContent phaseContent) {
        setInterceptors(phaseContent.sharedInterceptors());
        this.interceptorsListShared = false;
        this.interceptorsListSharedPhase = phaseContent.getPhase();
    }

    private final boolean tryAddToPhaseFastPath(PipelinePhase pipelinePhase, Function3 function3) {
        Object last;
        int lastIndex;
        List interceptors = getInterceptors();
        if (this.phasesRaw.isEmpty() || interceptors == null || this.interceptorsListShared || !TypeIntrinsics.isMutableList(interceptors)) {
            return false;
        }
        if (Intrinsics.areEqual(this.interceptorsListSharedPhase, pipelinePhase)) {
            interceptors.add(function3);
            return true;
        }
        last = CollectionsKt___CollectionsKt.last(this.phasesRaw);
        if (!Intrinsics.areEqual(pipelinePhase, last)) {
            int findPhaseIndex = findPhaseIndex(pipelinePhase);
            lastIndex = CollectionsKt__CollectionsKt.getLastIndex(this.phasesRaw);
            if (findPhaseIndex != lastIndex) {
                return false;
            }
        }
        PhaseContent findPhase = findPhase(pipelinePhase);
        Intrinsics.checkNotNull(findPhase);
        findPhase.addInterceptor(function3);
        interceptors.add(function3);
        return true;
    }
}
