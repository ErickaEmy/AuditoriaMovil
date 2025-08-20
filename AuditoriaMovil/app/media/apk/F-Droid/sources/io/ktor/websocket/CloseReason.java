package io.ktor.websocket;

import ch.qos.logback.core.CoreConstants;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
/* compiled from: CloseReason.kt */
/* loaded from: classes.dex */
public final class CloseReason {
    private final short code;
    private final String message;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CloseReason) {
            CloseReason closeReason = (CloseReason) obj;
            return this.code == closeReason.code && Intrinsics.areEqual(this.message, closeReason.message);
        }
        return false;
    }

    public final short getCode() {
        return this.code;
    }

    public final String getMessage() {
        return this.message;
    }

    public int hashCode() {
        return (this.code * 31) + this.message.hashCode();
    }

    public CloseReason(short s, String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        this.code = s;
        this.message = message;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CloseReason(Codes code, String message) {
        this(code.getCode(), message);
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(message, "message");
    }

    public final Codes getKnownReason() {
        return Codes.Companion.byCode(this.code);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CloseReason(reason=");
        Object knownReason = getKnownReason();
        if (knownReason == null) {
            knownReason = Short.valueOf(this.code);
        }
        sb.append(knownReason);
        sb.append(", message=");
        sb.append(this.message);
        sb.append(CoreConstants.RIGHT_PARENTHESIS_CHAR);
        return sb.toString();
    }

    /* compiled from: CloseReason.kt */
    /* loaded from: classes.dex */
    public enum Codes {
        NORMAL(1000),
        GOING_AWAY(1001),
        PROTOCOL_ERROR(1002),
        CANNOT_ACCEPT(1003),
        CLOSED_ABNORMALLY(1006),
        NOT_CONSISTENT(1007),
        VIOLATED_POLICY(1008),
        TOO_BIG(1009),
        NO_EXTENSION(1010),
        INTERNAL_ERROR(1011),
        SERVICE_RESTART(1012),
        TRY_AGAIN_LATER(1013);
        
        public static final Companion Companion = new Companion(null);
        public static final Codes UNEXPECTED_CONDITION;
        private static final Map byCodeMap;
        private final short code;

        public final short getCode() {
            return this.code;
        }

        Codes(short s) {
            this.code = s;
        }

        static {
            int mapCapacity;
            int coerceAtLeast;
            Codes[] values = values();
            mapCapacity = MapsKt__MapsJVMKt.mapCapacity(values.length);
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
            LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
            for (Codes codes : values) {
                linkedHashMap.put(Short.valueOf(codes.code), codes);
            }
            byCodeMap = linkedHashMap;
            UNEXPECTED_CONDITION = INTERNAL_ERROR;
        }

        /* compiled from: CloseReason.kt */
        /* loaded from: classes.dex */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final Codes byCode(short s) {
                return (Codes) Codes.byCodeMap.get(Short.valueOf(s));
            }
        }
    }
}
