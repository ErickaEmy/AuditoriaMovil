package androidx.compose.foundation.lazy;

import androidx.compose.foundation.lazy.layout.LazyLayoutAnimateItemModifierNode;
import androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
/* compiled from: LazyListItemPlacementAnimator.kt */
/* loaded from: classes.dex */
public final class LazyListItemPlacementAnimator {
    private int firstVisibleIndex;
    private final Set activeKeys = new LinkedHashSet();
    private LazyLayoutKeyIndexMap keyIndexMap = LazyLayoutKeyIndexMap.Empty;
    private final LinkedHashSet movingAwayKeys = new LinkedHashSet();
    private final List movingInFromStartBound = new ArrayList();
    private final List movingInFromEndBound = new ArrayList();
    private final List movingAwayToStartBound = new ArrayList();
    private final List movingAwayToEndBound = new ArrayList();

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0276, code lost:
        r18.movingInFromStartBound.clear();
        r18.movingInFromEndBound.clear();
        r18.movingAwayToStartBound.clear();
        r18.movingAwayToEndBound.clear();
        r18.movingAwayKeys.clear();
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x028f, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x003a, code lost:
        r6 = r18.firstVisibleIndex;
        r8 = kotlin.collections.CollectionsKt___CollectionsKt.firstOrNull(r22);
        r8 = (androidx.compose.foundation.lazy.LazyListMeasuredItem) r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0042, code lost:
        if (r8 == null) goto L126;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0044, code lost:
        r8 = r8.getIndex();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0049, code lost:
        r8 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x004a, code lost:
        r18.firstVisibleIndex = r8;
        r8 = r18.keyIndexMap;
        r18.keyIndexMap = r23.getKeyIndexMap();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0054, code lost:
        if (r24 == false) goto L125;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0056, code lost:
        r9 = r21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0058, code lost:
        r9 = r20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0059, code lost:
        if (r24 == false) goto L124;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x005b, code lost:
        r10 = androidx.compose.ui.unit.IntOffsetKt.IntOffset(0, r19);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0060, code lost:
        r10 = androidx.compose.ui.unit.IntOffsetKt.IntOffset(r19, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0064, code lost:
        r18.movingAwayKeys.addAll(r18.activeKeys);
        r1 = r22.size();
        r12 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0073, code lost:
        if (r12 >= r1) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0075, code lost:
        r14 = (androidx.compose.foundation.lazy.LazyListMeasuredItem) r4.get(r12);
        r18.movingAwayKeys.remove(r14.getKey());
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0088, code lost:
        if (getHasAnimations(r14) == false) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0094, code lost:
        if (r18.activeKeys.contains(r14.getKey()) != false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0096, code lost:
        r18.activeKeys.add(r14.getKey());
        r7 = r8.getIndex(r14.getKey());
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a9, code lost:
        if (r7 == (-1)) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00af, code lost:
        if (r14.getIndex() == r7) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00b1, code lost:
        if (r7 >= r6) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00b3, code lost:
        r18.movingInFromStartBound.add(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00b8, code lost:
        r19 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00bc, code lost:
        r18.movingInFromEndBound.add(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00c2, code lost:
        r15 = r14.m249getOffsetBjo55l4(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00cb, code lost:
        if (r14.isVertical() == false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00cd, code lost:
        r13 = androidx.compose.ui.unit.IntOffset.m1938getYimpl(r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00d2, code lost:
        r13 = androidx.compose.ui.unit.IntOffset.m1937getXimpl(r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00d6, code lost:
        initializeNode(r14, r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00da, code lost:
        r13 = r14.getPlaceablesCount();
        r15 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00e0, code lost:
        if (r15 >= r13) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00e2, code lost:
        r7 = getNode(r14.getParentData(r15));
        r19 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00ec, code lost:
        if (r7 == null) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00fc, code lost:
        if (androidx.compose.ui.unit.IntOffset.m1936equalsimpl0(r7.m256getRawOffsetnOccac(), androidx.compose.foundation.lazy.layout.LazyLayoutAnimateItemModifierNode.Companion.m258getNotInitializednOccac()) != false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00fe, code lost:
        r1 = r7.m256getRawOffsetnOccac();
        r7.m257setRawOffsetgyyYBs(androidx.compose.ui.unit.IntOffsetKt.IntOffset(androidx.compose.ui.unit.IntOffset.m1937getXimpl(r1) + androidx.compose.ui.unit.IntOffset.m1937getXimpl(r10), androidx.compose.ui.unit.IntOffset.m1938getYimpl(r1) + androidx.compose.ui.unit.IntOffset.m1938getYimpl(r10)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x011b, code lost:
        r15 = r15 + 1;
        r1 = r19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0127, code lost:
        r19 = r1;
        startAnimationsIfNeeded(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x012d, code lost:
        r19 = r1;
        r18.activeKeys.remove(r14.getKey());
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0138, code lost:
        r12 = r12 + 1;
        r1 = r19;
        r4 = r22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0145, code lost:
        r1 = r18.movingInFromStartBound;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x014c, code lost:
        if (r1.size() <= 1) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x014e, code lost:
        kotlin.collections.CollectionsKt__MutableCollectionsJVMKt.sortWith(r1, new androidx.compose.foundation.lazy.LazyListItemPlacementAnimator$onMeasured$$inlined$sortByDescending$1(r8));
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0156, code lost:
        r1 = r18.movingInFromStartBound;
        r2 = r1.size();
        r4 = 0;
        r6 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x015e, code lost:
        if (r4 >= r2) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0160, code lost:
        r7 = (androidx.compose.foundation.lazy.LazyListMeasuredItem) r1.get(r4);
        r6 = r6 + r7.getSize();
        initializeNode(r7, 0 - r6);
        startAnimationsIfNeeded(r7);
        r4 = r4 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0176, code lost:
        r1 = r18.movingInFromEndBound;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x017c, code lost:
        if (r1.size() <= 1) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x017e, code lost:
        kotlin.collections.CollectionsKt__MutableCollectionsJVMKt.sortWith(r1, new androidx.compose.foundation.lazy.LazyListItemPlacementAnimator$onMeasured$$inlined$sortBy$1(r8));
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0186, code lost:
        r1 = r18.movingInFromEndBound;
        r2 = r1.size();
        r4 = 0;
        r6 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x018e, code lost:
        if (r4 >= r2) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0190, code lost:
        r7 = (androidx.compose.foundation.lazy.LazyListMeasuredItem) r1.get(r4);
        r10 = r9 + r6;
        r6 = r6 + r7.getSize();
        initializeNode(r7, r10);
        startAnimationsIfNeeded(r7);
        r4 = r4 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x01a6, code lost:
        r1 = r18.movingAwayKeys.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x01b0, code lost:
        if (r1.hasNext() == false) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x01b2, code lost:
        r2 = r1.next();
        r4 = r18.keyIndexMap.getIndex(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x01bc, code lost:
        if (r4 != (-1)) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x01be, code lost:
        r18.activeKeys.remove(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x01c4, code lost:
        r6 = r23.getAndMeasure(r4);
        r7 = r6.getPlaceablesCount();
        r10 = 0;
        r11 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x01ce, code lost:
        if (r10 >= r7) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x01d0, code lost:
        r12 = getNode(r6.getParentData(r10));
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x01d8, code lost:
        if (r12 == null) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x01de, code lost:
        if (r12.isAnimationInProgress() != true) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x01e0, code lost:
        r11 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x01e1, code lost:
        r10 = r10 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01e4, code lost:
        if (r11 != false) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x01ea, code lost:
        if (r4 != r8.getIndex(r2)) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x01ec, code lost:
        r18.activeKeys.remove(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x01f4, code lost:
        if (r4 >= r18.firstVisibleIndex) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x01f6, code lost:
        r18.movingAwayToStartBound.add(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x01fc, code lost:
        r18.movingAwayToEndBound.add(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0202, code lost:
        r1 = r18.movingAwayToStartBound;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0208, code lost:
        if (r1.size() <= 1) goto L110;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x020a, code lost:
        kotlin.collections.CollectionsKt__MutableCollectionsJVMKt.sortWith(r1, new androidx.compose.foundation.lazy.LazyListItemPlacementAnimator$onMeasured$$inlined$sortByDescending$2(r18));
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0212, code lost:
        r1 = r18.movingAwayToStartBound;
        r2 = r1.size();
        r4 = 0;
        r5 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x021a, code lost:
        if (r4 >= r2) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x021c, code lost:
        r6 = (androidx.compose.foundation.lazy.LazyListMeasuredItem) r1.get(r4);
        r5 = r5 + r6.getSize();
        r6.position(0 - r5, r20, r21);
        r22.add(r6);
        startAnimationsIfNeeded(r6);
        r4 = r4 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x023b, code lost:
        r1 = r18.movingAwayToEndBound;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0247, code lost:
        if (r1.size() <= 1) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0249, code lost:
        kotlin.collections.CollectionsKt__MutableCollectionsJVMKt.sortWith(r1, new androidx.compose.foundation.lazy.LazyListItemPlacementAnimator$onMeasured$$inlined$sortBy$2(r18));
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0251, code lost:
        r1 = r18.movingAwayToEndBound;
        r2 = r1.size();
        r3 = 0;
        r16 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x025a, code lost:
        if (r3 >= r2) goto L120;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x025c, code lost:
        r4 = (androidx.compose.foundation.lazy.LazyListMeasuredItem) r1.get(r3);
        r5 = r9 + r16;
        r16 = r16 + r4.getSize();
        r4.position(r5, r20, r21);
        r22.add(r4);
        startAnimationsIfNeeded(r4);
        r3 = r3 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onMeasured(int r19, int r20, int r21, java.util.List r22, androidx.compose.foundation.lazy.LazyListMeasuredItemProvider r23, boolean r24) {
        /*
            Method dump skipped, instructions count: 656
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.LazyListItemPlacementAnimator.onMeasured(int, int, int, java.util.List, androidx.compose.foundation.lazy.LazyListMeasuredItemProvider, boolean):void");
    }

    public final void reset() {
        this.activeKeys.clear();
        this.keyIndexMap = LazyLayoutKeyIndexMap.Empty;
        this.firstVisibleIndex = -1;
    }

    private final void initializeNode(LazyListMeasuredItem lazyListMeasuredItem, int i) {
        long m1934copyiSbpLlY$default;
        long m249getOffsetBjo55l4 = lazyListMeasuredItem.m249getOffsetBjo55l4(0);
        if (lazyListMeasuredItem.isVertical()) {
            m1934copyiSbpLlY$default = IntOffset.m1934copyiSbpLlY$default(m249getOffsetBjo55l4, 0, i, 1, null);
        } else {
            m1934copyiSbpLlY$default = IntOffset.m1934copyiSbpLlY$default(m249getOffsetBjo55l4, i, 0, 2, null);
        }
        int placeablesCount = lazyListMeasuredItem.getPlaceablesCount();
        for (int i2 = 0; i2 < placeablesCount; i2++) {
            LazyLayoutAnimateItemModifierNode node = getNode(lazyListMeasuredItem.getParentData(i2));
            if (node != null) {
                long m249getOffsetBjo55l42 = lazyListMeasuredItem.m249getOffsetBjo55l4(i2);
                long IntOffset = IntOffsetKt.IntOffset(IntOffset.m1937getXimpl(m249getOffsetBjo55l42) - IntOffset.m1937getXimpl(m249getOffsetBjo55l4), IntOffset.m1938getYimpl(m249getOffsetBjo55l42) - IntOffset.m1938getYimpl(m249getOffsetBjo55l4));
                node.m257setRawOffsetgyyYBs(IntOffsetKt.IntOffset(IntOffset.m1937getXimpl(m1934copyiSbpLlY$default) + IntOffset.m1937getXimpl(IntOffset), IntOffset.m1938getYimpl(m1934copyiSbpLlY$default) + IntOffset.m1938getYimpl(IntOffset)));
            }
        }
    }

    private final LazyLayoutAnimateItemModifierNode getNode(Object obj) {
        if (obj instanceof LazyLayoutAnimateItemModifierNode) {
            return (LazyLayoutAnimateItemModifierNode) obj;
        }
        return null;
    }

    private final boolean getHasAnimations(LazyListMeasuredItem lazyListMeasuredItem) {
        int placeablesCount = lazyListMeasuredItem.getPlaceablesCount();
        for (int i = 0; i < placeablesCount; i++) {
            if (getNode(lazyListMeasuredItem.getParentData(i)) != null) {
                return true;
            }
        }
        return false;
    }

    private final void startAnimationsIfNeeded(LazyListMeasuredItem lazyListMeasuredItem) {
        int placeablesCount = lazyListMeasuredItem.getPlaceablesCount();
        for (int i = 0; i < placeablesCount; i++) {
            LazyLayoutAnimateItemModifierNode node = getNode(lazyListMeasuredItem.getParentData(i));
            if (node != null) {
                long m249getOffsetBjo55l4 = lazyListMeasuredItem.m249getOffsetBjo55l4(i);
                long m256getRawOffsetnOccac = node.m256getRawOffsetnOccac();
                if (!IntOffset.m1936equalsimpl0(m256getRawOffsetnOccac, LazyLayoutAnimateItemModifierNode.Companion.m258getNotInitializednOccac()) && !IntOffset.m1936equalsimpl0(m256getRawOffsetnOccac, m249getOffsetBjo55l4)) {
                    node.m254animatePlacementDeltagyyYBs(IntOffsetKt.IntOffset(IntOffset.m1937getXimpl(m249getOffsetBjo55l4) - IntOffset.m1937getXimpl(m256getRawOffsetnOccac), IntOffset.m1938getYimpl(m249getOffsetBjo55l4) - IntOffset.m1938getYimpl(m256getRawOffsetnOccac)));
                }
                node.m257setRawOffsetgyyYBs(m249getOffsetBjo55l4);
            }
        }
    }
}
