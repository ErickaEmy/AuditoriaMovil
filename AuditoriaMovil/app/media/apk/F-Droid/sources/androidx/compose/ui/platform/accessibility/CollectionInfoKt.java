package androidx.compose.ui.platform.accessibility;

import androidx.appcompat.app.ToolbarActionBar$$ExternalSyntheticThrowCCEIfNotNull0;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.semantics.CollectionInfo;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsConfigurationKt;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: CollectionInfo.kt */
/* loaded from: classes.dex */
public abstract class CollectionInfoKt {
    public static final void setCollectionInfo(SemanticsNode node, AccessibilityNodeInfoCompat info2) {
        Intrinsics.checkNotNullParameter(node, "node");
        Intrinsics.checkNotNullParameter(info2, "info");
        SemanticsConfiguration config = node.getConfig();
        SemanticsProperties semanticsProperties = SemanticsProperties.INSTANCE;
        CollectionInfo collectionInfo = (CollectionInfo) SemanticsConfigurationKt.getOrNull(config, semanticsProperties.getCollectionInfo());
        if (collectionInfo != null) {
            info2.setCollectionInfo(toAccessibilityCollectionInfo(collectionInfo));
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (SemanticsConfigurationKt.getOrNull(node.getConfig(), semanticsProperties.getSelectableGroup()) != null) {
            List replacedChildren$ui_release = node.getReplacedChildren$ui_release();
            int size = replacedChildren$ui_release.size();
            for (int i = 0; i < size; i++) {
                SemanticsNode semanticsNode = (SemanticsNode) replacedChildren$ui_release.get(i);
                if (semanticsNode.getConfig().contains(SemanticsProperties.INSTANCE.getSelected())) {
                    arrayList.add(semanticsNode);
                }
            }
        }
        if (!arrayList.isEmpty()) {
            boolean calculateIfHorizontallyStacked = calculateIfHorizontallyStacked(arrayList);
            info2.setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(calculateIfHorizontallyStacked ? 1 : arrayList.size(), calculateIfHorizontallyStacked ? arrayList.size() : 1, false, 0));
        }
    }

    public static final void setCollectionItemInfo(SemanticsNode node, AccessibilityNodeInfoCompat info2) {
        Intrinsics.checkNotNullParameter(node, "node");
        Intrinsics.checkNotNullParameter(info2, "info");
        SemanticsConfiguration config = node.getConfig();
        SemanticsProperties semanticsProperties = SemanticsProperties.INSTANCE;
        ToolbarActionBar$$ExternalSyntheticThrowCCEIfNotNull0.m(SemanticsConfigurationKt.getOrNull(config, semanticsProperties.getCollectionItemInfo()));
        SemanticsNode parent = node.getParent();
        if (parent == null || SemanticsConfigurationKt.getOrNull(parent.getConfig(), semanticsProperties.getSelectableGroup()) == null) {
            return;
        }
        CollectionInfo collectionInfo = (CollectionInfo) SemanticsConfigurationKt.getOrNull(parent.getConfig(), semanticsProperties.getCollectionInfo());
        if ((collectionInfo == null || !isLazyCollection(collectionInfo)) && node.getConfig().contains(semanticsProperties.getSelected())) {
            ArrayList arrayList = new ArrayList();
            List replacedChildren$ui_release = parent.getReplacedChildren$ui_release();
            int size = replacedChildren$ui_release.size();
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                SemanticsNode semanticsNode = (SemanticsNode) replacedChildren$ui_release.get(i2);
                if (semanticsNode.getConfig().contains(SemanticsProperties.INSTANCE.getSelected())) {
                    arrayList.add(semanticsNode);
                    if (semanticsNode.getLayoutNode$ui_release().getPlaceOrder$ui_release() < node.getLayoutNode$ui_release().getPlaceOrder$ui_release()) {
                        i++;
                    }
                }
            }
            if (!arrayList.isEmpty()) {
                boolean calculateIfHorizontallyStacked = calculateIfHorizontallyStacked(arrayList);
                AccessibilityNodeInfoCompat.CollectionItemInfoCompat obtain = AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(calculateIfHorizontallyStacked ? 0 : i, 1, calculateIfHorizontallyStacked ? i : 0, 1, false, ((Boolean) node.getConfig().getOrElse(SemanticsProperties.INSTANCE.getSelected(), new Function0() { // from class: androidx.compose.ui.platform.accessibility.CollectionInfoKt$setCollectionItemInfo$itemInfo$1
                    @Override // kotlin.jvm.functions.Function0
                    public final Boolean invoke() {
                        return Boolean.FALSE;
                    }
                })).booleanValue());
                if (obtain != null) {
                    info2.setCollectionItemInfo(obtain);
                }
            }
        }
    }

    public static final boolean hasCollectionInfo(SemanticsNode semanticsNode) {
        Intrinsics.checkNotNullParameter(semanticsNode, "<this>");
        SemanticsConfiguration config = semanticsNode.getConfig();
        SemanticsProperties semanticsProperties = SemanticsProperties.INSTANCE;
        return (SemanticsConfigurationKt.getOrNull(config, semanticsProperties.getCollectionInfo()) == null && SemanticsConfigurationKt.getOrNull(semanticsNode.getConfig(), semanticsProperties.getSelectableGroup()) == null) ? false : true;
    }

    private static final boolean calculateIfHorizontallyStacked(List list) {
        List emptyList;
        Object first;
        int lastIndex;
        long m718unboximpl;
        Object first2;
        int lastIndex2;
        if (list.size() < 2) {
            return true;
        }
        if (list.size() == 0 || list.size() == 1) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        } else {
            emptyList = new ArrayList();
            Object obj = list.get(0);
            lastIndex2 = CollectionsKt__CollectionsKt.getLastIndex(list);
            int i = 0;
            while (i < lastIndex2) {
                i++;
                Object obj2 = list.get(i);
                SemanticsNode semanticsNode = (SemanticsNode) obj2;
                SemanticsNode semanticsNode2 = (SemanticsNode) obj;
                emptyList.add(Offset.m698boximpl(OffsetKt.Offset(Math.abs(Offset.m709getXimpl(semanticsNode2.getBoundsInRoot().m727getCenterF1C5BW0()) - Offset.m709getXimpl(semanticsNode.getBoundsInRoot().m727getCenterF1C5BW0())), Math.abs(Offset.m710getYimpl(semanticsNode2.getBoundsInRoot().m727getCenterF1C5BW0()) - Offset.m710getYimpl(semanticsNode.getBoundsInRoot().m727getCenterF1C5BW0())))));
                obj = obj2;
            }
        }
        if (emptyList.size() != 1) {
            if (emptyList.isEmpty()) {
                throw new UnsupportedOperationException("Empty collection can't be reduced.");
            }
            first = CollectionsKt___CollectionsKt.first(emptyList);
            lastIndex = CollectionsKt__CollectionsKt.getLastIndex(emptyList);
            if (1 <= lastIndex) {
                int i2 = 1;
                while (true) {
                    first = Offset.m698boximpl(Offset.m714plusMKHz9U(((Offset) first).m718unboximpl(), ((Offset) emptyList.get(i2)).m718unboximpl()));
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
            m718unboximpl = ((Offset) first).m718unboximpl();
        } else {
            first2 = CollectionsKt___CollectionsKt.first(emptyList);
            m718unboximpl = ((Offset) first2).m718unboximpl();
        }
        return Offset.m700component2impl(m718unboximpl) < Offset.m699component1impl(m718unboximpl);
    }

    private static final boolean isLazyCollection(CollectionInfo collectionInfo) {
        return collectionInfo.getRowCount() < 0 || collectionInfo.getColumnCount() < 0;
    }

    private static final AccessibilityNodeInfoCompat.CollectionInfoCompat toAccessibilityCollectionInfo(CollectionInfo collectionInfo) {
        return AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(collectionInfo.getRowCount(), collectionInfo.getColumnCount(), false, 0);
    }
}
