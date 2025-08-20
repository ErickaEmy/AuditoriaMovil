package androidx.work.impl;

import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecKt;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: StartStopToken.kt */
/* loaded from: classes.dex */
public final class StartStopTokens {
    private final Object lock = new Object();
    private final Map runs = new LinkedHashMap();

    public final StartStopToken tokenFor(WorkGenerationalId id) {
        StartStopToken startStopToken;
        Intrinsics.checkNotNullParameter(id, "id");
        synchronized (this.lock) {
            try {
                Map map = this.runs;
                Object obj = map.get(id);
                if (obj == null) {
                    obj = new StartStopToken(id);
                    map.put(id, obj);
                }
                startStopToken = (StartStopToken) obj;
            } catch (Throwable th) {
                throw th;
            }
        }
        return startStopToken;
    }

    public final StartStopToken remove(WorkGenerationalId id) {
        StartStopToken startStopToken;
        Intrinsics.checkNotNullParameter(id, "id");
        synchronized (this.lock) {
            startStopToken = (StartStopToken) this.runs.remove(id);
        }
        return startStopToken;
    }

    public final List remove(String workSpecId) {
        List list;
        Intrinsics.checkNotNullParameter(workSpecId, "workSpecId");
        synchronized (this.lock) {
            try {
                Map map = this.runs;
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Map.Entry entry : map.entrySet()) {
                    if (Intrinsics.areEqual(((WorkGenerationalId) entry.getKey()).getWorkSpecId(), workSpecId)) {
                        linkedHashMap.put(entry.getKey(), entry.getValue());
                    }
                }
                for (WorkGenerationalId workGenerationalId : linkedHashMap.keySet()) {
                    this.runs.remove(workGenerationalId);
                }
                list = CollectionsKt___CollectionsKt.toList(linkedHashMap.values());
            } catch (Throwable th) {
                throw th;
            }
        }
        return list;
    }

    public final boolean contains(WorkGenerationalId id) {
        boolean containsKey;
        Intrinsics.checkNotNullParameter(id, "id");
        synchronized (this.lock) {
            containsKey = this.runs.containsKey(id);
        }
        return containsKey;
    }

    public final StartStopToken tokenFor(WorkSpec spec) {
        Intrinsics.checkNotNullParameter(spec, "spec");
        return tokenFor(WorkSpecKt.generationalId(spec));
    }
}
