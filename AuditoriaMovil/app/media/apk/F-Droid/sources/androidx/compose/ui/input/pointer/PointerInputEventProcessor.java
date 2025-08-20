package androidx.compose.ui.input.pointer;

import androidx.compose.ui.node.HitTestResult;
import androidx.compose.ui.node.LayoutNode;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: PointerInputEventProcessor.kt */
/* loaded from: classes.dex */
public final class PointerInputEventProcessor {
    private final HitPathTracker hitPathTracker;
    private final HitTestResult hitResult;
    private boolean isProcessing;
    private final PointerInputChangeEventProducer pointerInputChangeEventProducer;
    private final LayoutNode root;

    public PointerInputEventProcessor(LayoutNode root) {
        Intrinsics.checkNotNullParameter(root, "root");
        this.root = root;
        this.hitPathTracker = new HitPathTracker(root.getCoordinates());
        this.pointerInputChangeEventProducer = new PointerInputChangeEventProducer();
        this.hitResult = new HitTestResult();
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0048 A[Catch: all -> 0x003b, TryCatch #0 {all -> 0x003b, blocks: (B:7:0x001b, B:9:0x0031, B:23:0x005d, B:24:0x006b, B:26:0x0071, B:28:0x0079, B:30:0x007f, B:32:0x00a6, B:33:0x00b7, B:48:0x0100, B:36:0x00cc, B:38:0x00da, B:41:0x00e4, B:42:0x00e8, B:44:0x00ee, B:46:0x00fa, B:14:0x003e, B:15:0x0042, B:17:0x0048, B:19:0x0054), top: B:53:0x001b }] */
    /* renamed from: process-BIzXfog  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int m1206processBIzXfog(androidx.compose.ui.input.pointer.PointerInputEvent r18, androidx.compose.ui.input.pointer.PositionCalculator r19, boolean r20) {
        /*
            Method dump skipped, instructions count: 266
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.pointer.PointerInputEventProcessor.m1206processBIzXfog(androidx.compose.ui.input.pointer.PointerInputEvent, androidx.compose.ui.input.pointer.PositionCalculator, boolean):int");
    }

    public final void processCancel() {
        if (this.isProcessing) {
            return;
        }
        this.pointerInputChangeEventProducer.clear();
        this.hitPathTracker.processCancel();
    }
}
