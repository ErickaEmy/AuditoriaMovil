package io.ktor.websocket;

import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: FrameType.kt */
/* loaded from: classes.dex */
public enum FrameType {
    TEXT(false, 1),
    BINARY(false, 2),
    CLOSE(true, 8),
    PING(true, 9),
    PONG(true, 10);
    
    public static final Companion Companion = new Companion(null);
    private static final FrameType[] byOpcodeArray;
    private static final int maxOpcode;
    private final boolean controlFrame;
    private final int opcode;

    /* compiled from: FrameType.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    FrameType(boolean z, int i) {
        this.controlFrame = z;
        this.opcode = i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0095, code lost:
        r10 = null;
     */
    static {
        /*
            io.ktor.websocket.FrameType r0 = new io.ktor.websocket.FrameType
            java.lang.String r1 = "TEXT"
            r2 = 0
            r3 = 1
            r0.<init>(r2, r3)
            io.ktor.websocket.FrameType.TEXT = r0
            io.ktor.websocket.FrameType r0 = new io.ktor.websocket.FrameType
            java.lang.String r1 = "BINARY"
            r4 = 2
            r0.<init>(r2, r4)
            io.ktor.websocket.FrameType.BINARY = r0
            io.ktor.websocket.FrameType r0 = new io.ktor.websocket.FrameType
            java.lang.String r1 = "CLOSE"
            r5 = 8
            r0.<init>(r3, r5)
            io.ktor.websocket.FrameType.CLOSE = r0
            io.ktor.websocket.FrameType r0 = new io.ktor.websocket.FrameType
            r1 = 3
            r4 = 9
            java.lang.String r5 = "PING"
            r0.<init>(r3, r4)
            io.ktor.websocket.FrameType.PING = r0
            io.ktor.websocket.FrameType r0 = new io.ktor.websocket.FrameType
            r1 = 4
            r4 = 10
            java.lang.String r5 = "PONG"
            r0.<init>(r3, r4)
            io.ktor.websocket.FrameType.PONG = r0
            io.ktor.websocket.FrameType[] r0 = $values()
            io.ktor.websocket.FrameType.$VALUES = r0
            io.ktor.websocket.FrameType$Companion r0 = new io.ktor.websocket.FrameType$Companion
            r1 = 0
            r0.<init>(r1)
            io.ktor.websocket.FrameType.Companion = r0
            io.ktor.websocket.FrameType[] r0 = values()
            int r4 = r0.length
            if (r4 != 0) goto L4f
            r4 = r1
            goto L76
        L4f:
            r4 = r0[r2]
            int r5 = kotlin.collections.ArraysKt.getLastIndex(r0)
            if (r5 != 0) goto L58
            goto L76
        L58:
            int r6 = r4.opcode
            kotlin.ranges.IntRange r7 = new kotlin.ranges.IntRange
            r7.<init>(r3, r5)
            kotlin.collections.IntIterator r5 = r7.iterator()
        L63:
            boolean r7 = r5.hasNext()
            if (r7 == 0) goto L76
            int r7 = r5.nextInt()
            r7 = r0[r7]
            int r8 = r7.opcode
            if (r6 >= r8) goto L63
            r4 = r7
            r6 = r8
            goto L63
        L76:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            int r0 = r4.opcode
            io.ktor.websocket.FrameType.maxOpcode = r0
            int r0 = r0 + r3
            io.ktor.websocket.FrameType[] r4 = new io.ktor.websocket.FrameType[r0]
            r5 = r2
        L81:
            if (r5 >= r0) goto La4
            io.ktor.websocket.FrameType[] r6 = values()
            int r7 = r6.length
            r10 = r1
            r8 = r2
            r9 = r8
        L8b:
            if (r8 >= r7) goto L9c
            r11 = r6[r8]
            int r12 = r11.opcode
            if (r12 != r5) goto L99
            if (r9 == 0) goto L97
        L95:
            r10 = r1
            goto L9f
        L97:
            r9 = r3
            r10 = r11
        L99:
            int r8 = r8 + 1
            goto L8b
        L9c:
            if (r9 != 0) goto L9f
            goto L95
        L9f:
            r4[r5] = r10
            int r5 = r5 + 1
            goto L81
        La4:
            io.ktor.websocket.FrameType.byOpcodeArray = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.FrameType.<clinit>():void");
    }
}
