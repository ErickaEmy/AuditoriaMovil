package io.ktor.websocket;

import ch.qos.logback.core.CoreConstants;
import io.ktor.utils.io.core.ByteReadPacket;
import io.ktor.utils.io.core.StringsKt;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DisposableHandle;
/* compiled from: Frame.kt */
/* loaded from: classes.dex */
public abstract class Frame {
    public static final Companion Companion = new Companion(null);
    private static final byte[] Empty = new byte[0];
    private final ByteBuffer buffer;
    private final byte[] data;
    private final DisposableHandle disposableHandle;
    private final boolean fin;
    private final FrameType frameType;
    private final boolean rsv1;
    private final boolean rsv2;
    private final boolean rsv3;

    /* compiled from: Frame.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ Frame(boolean z, FrameType frameType, byte[] bArr, DisposableHandle disposableHandle, boolean z2, boolean z3, boolean z4, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, frameType, bArr, disposableHandle, z2, z3, z4);
    }

    public final byte[] getData() {
        return this.data;
    }

    /* compiled from: Frame.kt */
    /* loaded from: classes.dex */
    public static final class Close extends Frame {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public Close(io.ktor.websocket.CloseReason r9) {
            /*
                r8 = this;
                java.lang.String r0 = "reason"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
                io.ktor.utils.io.core.BytePacketBuilder r0 = new io.ktor.utils.io.core.BytePacketBuilder
                r1 = 0
                r2 = 1
                r0.<init>(r1, r2, r1)
                short r1 = r9.getCode()     // Catch: java.lang.Throwable -> L29
                io.ktor.utils.io.core.OutputPrimitivesKt.writeShort(r0, r1)     // Catch: java.lang.Throwable -> L29
                java.lang.String r2 = r9.getMessage()     // Catch: java.lang.Throwable -> L29
                r3 = 0
                r4 = 0
                r5 = 0
                r6 = 14
                r7 = 0
                r1 = r0
                io.ktor.utils.io.core.StringsKt.writeText$default(r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L29
                io.ktor.utils.io.core.ByteReadPacket r9 = r0.build()     // Catch: java.lang.Throwable -> L29
                r8.<init>(r9)
                return
            L29:
                r9 = move-exception
                r0.release()
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.Frame.Close.<init>(io.ktor.websocket.CloseReason):void");
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Close(byte[] data) {
            super(true, FrameType.CLOSE, data, NonDisposableHandle.INSTANCE, false, false, false, null);
            Intrinsics.checkNotNullParameter(data, "data");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Close(ByteReadPacket packet) {
            this(StringsKt.readBytes$default(packet, 0, 1, null));
            Intrinsics.checkNotNullParameter(packet, "packet");
        }
    }

    private Frame(boolean z, FrameType frameType, byte[] bArr, DisposableHandle disposableHandle, boolean z2, boolean z3, boolean z4) {
        this.fin = z;
        this.frameType = frameType;
        this.data = bArr;
        this.disposableHandle = disposableHandle;
        this.rsv1 = z2;
        this.rsv2 = z3;
        this.rsv3 = z4;
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        Intrinsics.checkNotNullExpressionValue(wrap, "wrap(data)");
        this.buffer = wrap;
    }

    /* compiled from: Frame.kt */
    /* loaded from: classes.dex */
    public static final class Binary extends Frame {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Binary(boolean z, byte[] data, boolean z2, boolean z3, boolean z4) {
            super(z, FrameType.BINARY, data, NonDisposableHandle.INSTANCE, z2, z3, z4, null);
            Intrinsics.checkNotNullParameter(data, "data");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Binary(boolean z, byte[] data) {
            this(z, data, false, false, false);
            Intrinsics.checkNotNullParameter(data, "data");
        }
    }

    /* compiled from: Frame.kt */
    /* loaded from: classes.dex */
    public static final class Text extends Frame {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Text(boolean z, byte[] data, boolean z2, boolean z3, boolean z4) {
            super(z, FrameType.TEXT, data, NonDisposableHandle.INSTANCE, z2, z3, z4, null);
            Intrinsics.checkNotNullParameter(data, "data");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Text(boolean z, byte[] data) {
            this(z, data, false, false, false);
            Intrinsics.checkNotNullParameter(data, "data");
        }
    }

    public String toString() {
        return "Frame " + this.frameType + " (fin=" + this.fin + ", buffer len = " + this.data.length + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }
}
