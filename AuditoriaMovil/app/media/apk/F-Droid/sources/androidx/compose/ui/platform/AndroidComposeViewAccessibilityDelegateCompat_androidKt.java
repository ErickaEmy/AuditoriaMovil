package androidx.compose.ui.platform;

import android.graphics.Region;
import android.view.View;
import androidx.appcompat.app.ToolbarActionBar$$ExternalSyntheticThrowCCEIfNotNull0;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutInfo;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat;
import androidx.compose.ui.semantics.AccessibilityAction;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsConfigurationKt;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.semantics.SemanticsOwner;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
/* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
/* loaded from: classes.dex */
public abstract class AndroidComposeViewAccessibilityDelegateCompat_androidKt {
    public static final OpenEndRange rangeUntil(float f, float f2) {
        return new OpenEndFloatRange(f, f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean overlaps(OpenEndRange openEndRange, OpenEndRange openEndRange2) {
        return (openEndRange.isEmpty() || openEndRange2.isEmpty() || Math.max(((Number) openEndRange.getStart()).floatValue(), ((Number) openEndRange2.getStart()).floatValue()) >= Math.min(((Number) openEndRange.getEndExclusive()).floatValue(), ((Number) openEndRange2.getEndExclusive()).floatValue())) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LayoutNode findClosestParentNode(LayoutNode layoutNode, Function1 function1) {
        for (LayoutNode parent$ui_release = layoutNode.getParent$ui_release(); parent$ui_release != null; parent$ui_release = parent$ui_release.getParent$ui_release()) {
            if (((Boolean) function1.invoke(parent$ui_release)).booleanValue()) {
                return parent$ui_release;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean enabled(SemanticsNode semanticsNode) {
        return SemanticsConfigurationKt.getOrNull(semanticsNode.getConfig(), SemanticsProperties.INSTANCE.getDisabled()) == null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isVisible(SemanticsNode semanticsNode) {
        return (semanticsNode.isTransparent$ui_release() || semanticsNode.getUnmergedConfig$ui_release().contains(SemanticsProperties.INSTANCE.getInvisibleToUser())) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean propertiesDeleted(SemanticsNode semanticsNode, AndroidComposeViewAccessibilityDelegateCompat.SemanticsNodeCopy semanticsNodeCopy) {
        Iterator it = semanticsNodeCopy.getUnmergedConfig().iterator();
        while (it.hasNext()) {
            if (!semanticsNode.getConfig().contains((SemanticsPropertyKey) ((Map.Entry) it.next()).getKey())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean hasPaneTitle(SemanticsNode semanticsNode) {
        return semanticsNode.getConfig().contains(SemanticsProperties.INSTANCE.getPaneTitle());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isPassword(SemanticsNode semanticsNode) {
        return semanticsNode.getConfig().contains(SemanticsProperties.INSTANCE.getPassword());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isTextField(SemanticsNode semanticsNode) {
        return semanticsNode.getUnmergedConfig$ui_release().contains(SemanticsActions.INSTANCE.getSetText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isRtl(SemanticsNode semanticsNode) {
        return semanticsNode.getLayoutInfo().getLayoutDirection() == LayoutDirection.Rtl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean isTraversalGroup(SemanticsNode semanticsNode) {
        return (Boolean) SemanticsConfigurationKt.getOrNull(semanticsNode.getConfig(), SemanticsProperties.INSTANCE.getIsTraversalGroup());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float getGetTraversalIndex(SemanticsNode semanticsNode) {
        SemanticsConfiguration config = semanticsNode.getConfig();
        SemanticsProperties semanticsProperties = SemanticsProperties.INSTANCE;
        if (config.contains(semanticsProperties.getTraversalIndex())) {
            return ((Number) semanticsNode.getConfig().get(semanticsProperties.getTraversalIndex())).floatValue();
        }
        return 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String getInfoContentDescriptionOrNull(SemanticsNode semanticsNode) {
        Object firstOrNull;
        List list = (List) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getContentDescription());
        if (list != null) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull(list);
            return (String) firstOrNull;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean excludeLineAndPageGranularities(SemanticsNode semanticsNode) {
        SemanticsConfiguration collapsedSemantics$ui_release;
        if (!isTextField(semanticsNode) || Intrinsics.areEqual(SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getFocused()), Boolean.TRUE)) {
            LayoutNode findClosestParentNode = findClosestParentNode(semanticsNode.getLayoutNode$ui_release(), new Function1() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat_androidKt$excludeLineAndPageGranularities$ancestor$1
                /* JADX WARN: Code restructure failed: missing block: B:7:0x001c, code lost:
                    if (r3.contains(androidx.compose.ui.semantics.SemanticsActions.INSTANCE.getSetText()) != false) goto L7;
                 */
                @Override // kotlin.jvm.functions.Function1
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Boolean invoke(androidx.compose.ui.node.LayoutNode r3) {
                    /*
                        r2 = this;
                        java.lang.String r0 = "it"
                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                        androidx.compose.ui.semantics.SemanticsConfiguration r3 = r3.getCollapsedSemantics$ui_release()
                        if (r3 == 0) goto L1f
                        boolean r0 = r3.isMergingSemanticsOfDescendants()
                        r1 = 1
                        if (r0 != r1) goto L1f
                        androidx.compose.ui.semantics.SemanticsActions r0 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
                        androidx.compose.ui.semantics.SemanticsPropertyKey r0 = r0.getSetText()
                        boolean r3 = r3.contains(r0)
                        if (r3 == 0) goto L1f
                        goto L20
                    L1f:
                        r1 = 0
                    L20:
                        java.lang.Boolean r3 = java.lang.Boolean.valueOf(r1)
                        return r3
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat_androidKt$excludeLineAndPageGranularities$ancestor$1.invoke(androidx.compose.ui.node.LayoutNode):java.lang.Boolean");
                }
            });
            return findClosestParentNode != null && ((collapsedSemantics$ui_release = findClosestParentNode.getCollapsedSemantics$ui_release()) == null || !Intrinsics.areEqual(SemanticsConfigurationKt.getOrNull(collapsedSemantics$ui_release, SemanticsProperties.INSTANCE.getFocused()), Boolean.TRUE));
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean accessibilityEquals(AccessibilityAction accessibilityAction, Object obj) {
        if (accessibilityAction == obj) {
            return true;
        }
        if (obj instanceof AccessibilityAction) {
            AccessibilityAction accessibilityAction2 = (AccessibilityAction) obj;
            if (Intrinsics.areEqual(accessibilityAction.getLabel(), accessibilityAction2.getLabel())) {
                if (accessibilityAction.getAction() != null || accessibilityAction2.getAction() == null) {
                    return accessibilityAction.getAction() == null || accessibilityAction2.getAction() != null;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public static final Map getAllUncoveredSemanticsNodesToMap(SemanticsOwner semanticsOwner) {
        int roundToInt;
        int roundToInt2;
        int roundToInt3;
        int roundToInt4;
        Intrinsics.checkNotNullParameter(semanticsOwner, "<this>");
        SemanticsNode unmergedRootSemanticsNode = semanticsOwner.getUnmergedRootSemanticsNode();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (unmergedRootSemanticsNode.getLayoutNode$ui_release().isPlaced() && unmergedRootSemanticsNode.getLayoutNode$ui_release().isAttached()) {
            Region region = new Region();
            Rect boundsInRoot = unmergedRootSemanticsNode.getBoundsInRoot();
            roundToInt = MathKt__MathJVMKt.roundToInt(boundsInRoot.getLeft());
            roundToInt2 = MathKt__MathJVMKt.roundToInt(boundsInRoot.getTop());
            roundToInt3 = MathKt__MathJVMKt.roundToInt(boundsInRoot.getRight());
            roundToInt4 = MathKt__MathJVMKt.roundToInt(boundsInRoot.getBottom());
            region.set(new android.graphics.Rect(roundToInt, roundToInt2, roundToInt3, roundToInt4));
            getAllUncoveredSemanticsNodesToMap$findAllSemanticNodesRecursive(region, unmergedRootSemanticsNode, linkedHashMap, unmergedRootSemanticsNode);
        }
        return linkedHashMap;
    }

    private static final void getAllUncoveredSemanticsNodesToMap$findAllSemanticNodesRecursive(Region region, SemanticsNode semanticsNode, Map map, SemanticsNode semanticsNode2) {
        int roundToInt;
        int roundToInt2;
        int roundToInt3;
        int roundToInt4;
        Rect rect;
        int roundToInt5;
        int roundToInt6;
        int roundToInt7;
        int roundToInt8;
        LayoutInfo layoutInfo;
        boolean z = (semanticsNode2.getLayoutNode$ui_release().isPlaced() && semanticsNode2.getLayoutNode$ui_release().isAttached()) ? false : true;
        if (!region.isEmpty() || semanticsNode2.getId() == semanticsNode.getId()) {
            if (!z || semanticsNode2.isFake$ui_release()) {
                Rect touchBoundsInRoot = semanticsNode2.getTouchBoundsInRoot();
                roundToInt = MathKt__MathJVMKt.roundToInt(touchBoundsInRoot.getLeft());
                roundToInt2 = MathKt__MathJVMKt.roundToInt(touchBoundsInRoot.getTop());
                roundToInt3 = MathKt__MathJVMKt.roundToInt(touchBoundsInRoot.getRight());
                roundToInt4 = MathKt__MathJVMKt.roundToInt(touchBoundsInRoot.getBottom());
                android.graphics.Rect rect2 = new android.graphics.Rect(roundToInt, roundToInt2, roundToInt3, roundToInt4);
                Region region2 = new Region();
                region2.set(rect2);
                int id = semanticsNode2.getId() == semanticsNode.getId() ? -1 : semanticsNode2.getId();
                if (region2.op(region, region2, Region.Op.INTERSECT)) {
                    Integer valueOf = Integer.valueOf(id);
                    android.graphics.Rect bounds = region2.getBounds();
                    Intrinsics.checkNotNullExpressionValue(bounds, "region.bounds");
                    map.put(valueOf, new SemanticsNodeWithAdjustedBounds(semanticsNode2, bounds));
                    List replacedChildren$ui_release = semanticsNode2.getReplacedChildren$ui_release();
                    for (int size = replacedChildren$ui_release.size() - 1; -1 < size; size--) {
                        getAllUncoveredSemanticsNodesToMap$findAllSemanticNodesRecursive(region, semanticsNode, map, (SemanticsNode) replacedChildren$ui_release.get(size));
                    }
                    region.op(rect2, region, Region.Op.REVERSE_DIFFERENCE);
                } else if (!semanticsNode2.isFake$ui_release()) {
                    if (id == -1) {
                        Integer valueOf2 = Integer.valueOf(id);
                        android.graphics.Rect bounds2 = region2.getBounds();
                        Intrinsics.checkNotNullExpressionValue(bounds2, "region.bounds");
                        map.put(valueOf2, new SemanticsNodeWithAdjustedBounds(semanticsNode2, bounds2));
                    }
                } else {
                    SemanticsNode parent = semanticsNode2.getParent();
                    if (parent != null && (layoutInfo = parent.getLayoutInfo()) != null && layoutInfo.isPlaced()) {
                        rect = parent.getBoundsInRoot();
                    } else {
                        rect = new Rect(0.0f, 0.0f, 10.0f, 10.0f);
                    }
                    Integer valueOf3 = Integer.valueOf(id);
                    roundToInt5 = MathKt__MathJVMKt.roundToInt(rect.getLeft());
                    roundToInt6 = MathKt__MathJVMKt.roundToInt(rect.getTop());
                    roundToInt7 = MathKt__MathJVMKt.roundToInt(rect.getRight());
                    roundToInt8 = MathKt__MathJVMKt.roundToInt(rect.getBottom());
                    map.put(valueOf3, new SemanticsNodeWithAdjustedBounds(semanticsNode2, new android.graphics.Rect(roundToInt5, roundToInt6, roundToInt7, roundToInt8)));
                }
            }
        }
    }

    public static final ScrollObservationScope findById(List list, int i) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (((ScrollObservationScope) list.get(i2)).getSemanticsNodeId() == i) {
                return (ScrollObservationScope) list.get(i2);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: toLegacyClassName-V4PA4sw  reason: not valid java name */
    public static final String m1419toLegacyClassNameV4PA4sw(int i) {
        Role.Companion companion = Role.Companion;
        if (Role.m1478equalsimpl0(i, companion.m1482getButtono7Vup1c())) {
            return "android.widget.Button";
        }
        if (Role.m1478equalsimpl0(i, companion.m1483getCheckboxo7Vup1c())) {
            return "android.widget.CheckBox";
        }
        if (Role.m1478equalsimpl0(i, companion.m1486getRadioButtono7Vup1c())) {
            return "android.widget.RadioButton";
        }
        if (Role.m1478equalsimpl0(i, companion.m1485getImageo7Vup1c())) {
            return "android.widget.ImageView";
        }
        if (Role.m1478equalsimpl0(i, companion.m1484getDropdownListo7Vup1c())) {
            return "android.widget.Spinner";
        }
        return null;
    }

    public static final View semanticsIdToView(AndroidViewsHandler androidViewsHandler, int i) {
        Object obj;
        Intrinsics.checkNotNullParameter(androidViewsHandler, "<this>");
        Set<Map.Entry<LayoutNode, Object>> entrySet = androidViewsHandler.getLayoutNodeToHolder().entrySet();
        Intrinsics.checkNotNullExpressionValue(entrySet, "layoutNodeToHolder.entries");
        Iterator<T> it = entrySet.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((LayoutNode) ((Map.Entry) obj).getKey()).getSemanticsId() == i) {
                break;
            }
        }
        Map.Entry entry = (Map.Entry) obj;
        if (entry != null) {
            ToolbarActionBar$$ExternalSyntheticThrowCCEIfNotNull0.m(entry.getValue());
        }
        return null;
    }
}
