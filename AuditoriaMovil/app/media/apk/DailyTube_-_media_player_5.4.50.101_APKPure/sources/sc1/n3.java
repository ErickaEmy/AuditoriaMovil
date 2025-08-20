package sc1;

import kotlin.jvm.internal.DefaultConstructorMarker;
/* loaded from: classes.dex */
public enum n3 {
    NO_ERROR(0),
    PROTOCOL_ERROR(1),
    INTERNAL_ERROR(2),
    FLOW_CONTROL_ERROR(3),
    SETTINGS_TIMEOUT(4),
    STREAM_CLOSED(5),
    FRAME_SIZE_ERROR(6),
    REFUSED_STREAM(7),
    CANCEL(8),
    COMPRESSION_ERROR(9),
    CONNECT_ERROR(10),
    ENHANCE_YOUR_CALM(11),
    INADEQUATE_SECURITY(12),
    HTTP_1_1_REQUIRED(13);
    

    /* renamed from: fh  reason: collision with root package name */
    public static final y f13818fh = new y(null);
    private final int httpCode;

    /* loaded from: classes.dex */
    public static final class y {
        public y() {
        }

        public final n3 y(int i) {
            n3[] values;
            for (n3 n3Var : n3.values()) {
                if (n3Var.y() == i) {
                    return n3Var;
                }
            }
            return null;
        }

        public /* synthetic */ y(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    n3(int i) {
        this.httpCode = i;
    }

    public final int y() {
        return this.httpCode;
    }
}
