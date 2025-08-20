package kotlinx.coroutines.flow;

import java.util.List;
import kotlin.collections.CollectionsKt;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import yc.gv;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class StartedWhileSubscribed implements SharingStarted {
    private final long replayExpiration;
    private final long stopTimeout;

    public StartedWhileSubscribed(long j2, long j4) {
        this.stopTimeout = j2;
        this.replayExpiration = j4;
        if (j2 >= 0) {
            if (j4 >= 0) {
                return;
            }
            throw new IllegalArgumentException(("replayExpiration(" + j4 + " ms) cannot be negative").toString());
        }
        throw new IllegalArgumentException(("stopTimeout(" + j2 + " ms) cannot be negative").toString());
    }

    @Override // kotlinx.coroutines.flow.SharingStarted
    public Flow<SharingCommand> command(StateFlow<Integer> stateFlow) {
        return FlowKt.distinctUntilChanged(FlowKt.dropWhile(FlowKt.transformLatest(stateFlow, new StartedWhileSubscribed$command$1(this, null)), new StartedWhileSubscribed$command$2(null)));
    }

    public boolean equals(Object obj) {
        if (obj instanceof StartedWhileSubscribed) {
            StartedWhileSubscribed startedWhileSubscribed = (StartedWhileSubscribed) obj;
            if (this.stopTimeout == startedWhileSubscribed.stopTimeout && this.replayExpiration == startedWhileSubscribed.replayExpiration) {
                return true;
            }
        }
        return false;
    }

    @IgnoreJRERequirement
    public int hashCode() {
        return (gv.y(this.stopTimeout) * 31) + gv.y(this.replayExpiration);
    }

    public String toString() {
        List createListBuilder = CollectionsKt.createListBuilder(2);
        if (this.stopTimeout > 0) {
            createListBuilder.add("stopTimeout=" + this.stopTimeout + "ms");
        }
        if (this.replayExpiration < Long.MAX_VALUE) {
            createListBuilder.add("replayExpiration=" + this.replayExpiration + "ms");
        }
        List build = CollectionsKt.build(createListBuilder);
        return "SharingStarted.WhileSubscribed(" + CollectionsKt.joinToString$default(build, null, null, null, 0, null, null, 63, null) + ')';
    }
}
