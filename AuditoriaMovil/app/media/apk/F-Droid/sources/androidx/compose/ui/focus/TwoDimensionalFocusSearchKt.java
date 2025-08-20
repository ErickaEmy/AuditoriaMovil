package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.BeyondBoundsLayout;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.NodeKind;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: TwoDimensionalFocusSearch.kt */
/* loaded from: classes.dex */
public abstract class TwoDimensionalFocusSearchKt {

    /* compiled from: TwoDimensionalFocusSearch.kt */
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FocusStateImpl.values().length];
            try {
                iArr[FocusStateImpl.ActiveParent.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FocusStateImpl.Active.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FocusStateImpl.Captured.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[FocusStateImpl.Inactive.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* renamed from: twoDimensionalFocusSearch--OM-vw8  reason: not valid java name */
    public static final Boolean m690twoDimensionalFocusSearchOMvw8(FocusTargetNode twoDimensionalFocusSearch, int i, Function1 onFound) {
        Intrinsics.checkNotNullParameter(twoDimensionalFocusSearch, "$this$twoDimensionalFocusSearch");
        Intrinsics.checkNotNullParameter(onFound, "onFound");
        FocusStateImpl focusState = twoDimensionalFocusSearch.getFocusState();
        int[] iArr = WhenMappings.$EnumSwitchMapping$0;
        int i2 = iArr[focusState.ordinal()];
        if (i2 != 1) {
            if (i2 == 2 || i2 == 3) {
                return Boolean.valueOf(m686findChildCorrespondingToFocusEnterOMvw8(twoDimensionalFocusSearch, i, onFound));
            }
            if (i2 == 4) {
                return twoDimensionalFocusSearch.fetchFocusProperties$ui_release().getCanFocus() ? (Boolean) onFound.invoke(twoDimensionalFocusSearch) : Boolean.FALSE;
            }
            throw new NoWhenBranchMatchedException();
        }
        FocusTargetNode activeChild = FocusTraversalKt.getActiveChild(twoDimensionalFocusSearch);
        if (activeChild == null) {
            throw new IllegalStateException("ActiveParent must have a focusedChild".toString());
        }
        int i3 = iArr[activeChild.getFocusState().ordinal()];
        if (i3 == 1) {
            Boolean m690twoDimensionalFocusSearchOMvw8 = m690twoDimensionalFocusSearchOMvw8(activeChild, i, onFound);
            return !Intrinsics.areEqual(m690twoDimensionalFocusSearchOMvw8, Boolean.FALSE) ? m690twoDimensionalFocusSearchOMvw8 : Boolean.valueOf(m687generateAndSearchChildren4C6V_qg(twoDimensionalFocusSearch, activeNode(activeChild), i, onFound));
        } else if (i3 == 2 || i3 == 3) {
            return Boolean.valueOf(m687generateAndSearchChildren4C6V_qg(twoDimensionalFocusSearch, activeChild, i, onFound));
        } else {
            if (i3 == 4) {
                throw new IllegalStateException("ActiveParent must have a focusedChild".toString());
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    private static final void collectAccessibleChildren(DelegatableNode delegatableNode, MutableVector mutableVector) {
        int m1386constructorimpl = NodeKind.m1386constructorimpl(1024);
        if (!delegatableNode.getNode().isAttached()) {
            throw new IllegalStateException("visitChildren called on an unattached node".toString());
        }
        MutableVector mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child$ui_release = delegatableNode.getNode().getChild$ui_release();
        if (child$ui_release == null) {
            DelegatableNodeKt.addLayoutNodeChildren(mutableVector2, delegatableNode.getNode());
        } else {
            mutableVector2.add(child$ui_release);
        }
        while (mutableVector2.isNotEmpty()) {
            Modifier.Node node = (Modifier.Node) mutableVector2.removeAt(mutableVector2.getSize() - 1);
            if ((node.getAggregateChildKindSet$ui_release() & m1386constructorimpl) == 0) {
                DelegatableNodeKt.addLayoutNodeChildren(mutableVector2, node);
            } else {
                while (true) {
                    if (node == null) {
                        break;
                    } else if ((node.getKindSet$ui_release() & m1386constructorimpl) != 0) {
                        MutableVector mutableVector3 = null;
                        while (node != null) {
                            if (!(node instanceof FocusTargetNode)) {
                                if ((node.getKindSet$ui_release() & m1386constructorimpl) != 0 && (node instanceof DelegatingNode)) {
                                    int i = 0;
                                    for (Modifier.Node delegate$ui_release = ((DelegatingNode) node).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                                        if ((delegate$ui_release.getKindSet$ui_release() & m1386constructorimpl) != 0) {
                                            i++;
                                            if (i == 1) {
                                                node = delegate$ui_release;
                                            } else {
                                                if (mutableVector3 == null) {
                                                    mutableVector3 = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                if (node != null) {
                                                    mutableVector3.add(node);
                                                    node = null;
                                                }
                                                mutableVector3.add(delegate$ui_release);
                                            }
                                        }
                                    }
                                    if (i == 1) {
                                    }
                                }
                            } else {
                                FocusTargetNode focusTargetNode = (FocusTargetNode) node;
                                if (focusTargetNode.isAttached()) {
                                    if (focusTargetNode.fetchFocusProperties$ui_release().getCanFocus()) {
                                        mutableVector.add(focusTargetNode);
                                    } else {
                                        collectAccessibleChildren(focusTargetNode, mutableVector);
                                    }
                                }
                            }
                            node = DelegatableNodeKt.pop(mutableVector3);
                        }
                    } else {
                        node = node.getChild$ui_release();
                    }
                }
            }
        }
    }

    /* renamed from: generateAndSearchChildren-4C6V_qg  reason: not valid java name */
    private static final boolean m687generateAndSearchChildren4C6V_qg(final FocusTargetNode focusTargetNode, final FocusTargetNode focusTargetNode2, final int i, final Function1 function1) {
        if (m689searchChildren4C6V_qg(focusTargetNode, focusTargetNode2, i, function1)) {
            return true;
        }
        Boolean bool = (Boolean) BeyondBoundsLayoutKt.m646searchBeyondBoundsOMvw8(focusTargetNode, i, new Function1() { // from class: androidx.compose.ui.focus.TwoDimensionalFocusSearchKt$generateAndSearchChildren$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(BeyondBoundsLayout.BeyondBoundsScope searchBeyondBounds) {
                boolean m689searchChildren4C6V_qg;
                Intrinsics.checkNotNullParameter(searchBeyondBounds, "$this$searchBeyondBounds");
                m689searchChildren4C6V_qg = TwoDimensionalFocusSearchKt.m689searchChildren4C6V_qg(FocusTargetNode.this, focusTargetNode2, i, function1);
                Boolean valueOf = Boolean.valueOf(m689searchChildren4C6V_qg);
                if (valueOf.booleanValue() || !searchBeyondBounds.getHasMoreContent()) {
                    return valueOf;
                }
                return null;
            }
        });
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    /* renamed from: findBestCandidate-4WY_MpI  reason: not valid java name */
    private static final FocusTargetNode m685findBestCandidate4WY_MpI(MutableVector mutableVector, Rect rect, int i) {
        Rect translate;
        FocusDirection.Companion companion = FocusDirection.Companion;
        if (FocusDirection.m650equalsimpl0(i, companion.m657getLeftdhqQ8s())) {
            translate = rect.translate(rect.getWidth() + 1, 0.0f);
        } else if (FocusDirection.m650equalsimpl0(i, companion.m660getRightdhqQ8s())) {
            translate = rect.translate(-(rect.getWidth() + 1), 0.0f);
        } else if (FocusDirection.m650equalsimpl0(i, companion.m661getUpdhqQ8s())) {
            translate = rect.translate(0.0f, rect.getHeight() + 1);
        } else if (!FocusDirection.m650equalsimpl0(i, companion.m654getDowndhqQ8s())) {
            throw new IllegalStateException("This function should only be used for 2-D focus search".toString());
        } else {
            translate = rect.translate(0.0f, -(rect.getHeight() + 1));
        }
        int size = mutableVector.getSize();
        FocusTargetNode focusTargetNode = null;
        if (size > 0) {
            Object[] content = mutableVector.getContent();
            int i2 = 0;
            do {
                FocusTargetNode focusTargetNode2 = (FocusTargetNode) content[i2];
                if (FocusTraversalKt.isEligibleForFocusSearch(focusTargetNode2)) {
                    Rect focusRect = FocusTraversalKt.focusRect(focusTargetNode2);
                    if (m688isBetterCandidateI7lrPNg(focusRect, translate, rect, i)) {
                        focusTargetNode = focusTargetNode2;
                        translate = focusRect;
                    }
                }
                i2++;
            } while (i2 < size);
            return focusTargetNode;
        }
        return focusTargetNode;
    }

    private static final boolean isBetterCandidate_I7lrPNg$isCandidate(Rect rect, int i, Rect rect2) {
        FocusDirection.Companion companion = FocusDirection.Companion;
        if (FocusDirection.m650equalsimpl0(i, companion.m657getLeftdhqQ8s())) {
            if ((rect2.getRight() <= rect.getRight() && rect2.getLeft() < rect.getRight()) || rect2.getLeft() <= rect.getLeft()) {
                return false;
            }
        } else if (FocusDirection.m650equalsimpl0(i, companion.m660getRightdhqQ8s())) {
            if ((rect2.getLeft() >= rect.getLeft() && rect2.getRight() > rect.getLeft()) || rect2.getRight() >= rect.getRight()) {
                return false;
            }
        } else if (FocusDirection.m650equalsimpl0(i, companion.m661getUpdhqQ8s())) {
            if ((rect2.getBottom() <= rect.getBottom() && rect2.getTop() < rect.getBottom()) || rect2.getTop() <= rect.getTop()) {
                return false;
            }
        } else if (!FocusDirection.m650equalsimpl0(i, companion.m654getDowndhqQ8s())) {
            throw new IllegalStateException("This function should only be used for 2-D focus search".toString());
        } else {
            if ((rect2.getTop() >= rect.getTop() && rect2.getBottom() > rect.getTop()) || rect2.getBottom() >= rect.getBottom()) {
                return false;
            }
        }
        return true;
    }

    private static final float isBetterCandidate_I7lrPNg$majorAxisDistance(Rect rect, int i, Rect rect2) {
        float top;
        float bottom;
        float top2;
        float bottom2;
        float f;
        FocusDirection.Companion companion = FocusDirection.Companion;
        if (!FocusDirection.m650equalsimpl0(i, companion.m657getLeftdhqQ8s())) {
            if (FocusDirection.m650equalsimpl0(i, companion.m660getRightdhqQ8s())) {
                top = rect.getLeft();
                bottom = rect2.getRight();
            } else if (FocusDirection.m650equalsimpl0(i, companion.m661getUpdhqQ8s())) {
                top2 = rect2.getTop();
                bottom2 = rect.getBottom();
            } else if (!FocusDirection.m650equalsimpl0(i, companion.m654getDowndhqQ8s())) {
                throw new IllegalStateException("This function should only be used for 2-D focus search".toString());
            } else {
                top = rect.getTop();
                bottom = rect2.getBottom();
            }
            f = top - bottom;
            return Math.max(0.0f, f);
        }
        top2 = rect2.getLeft();
        bottom2 = rect.getRight();
        f = top2 - bottom2;
        return Math.max(0.0f, f);
    }

    private static final float isBetterCandidate_I7lrPNg$minorAxisDistance(Rect rect, int i, Rect rect2) {
        float f;
        float top;
        float top2;
        float height;
        FocusDirection.Companion companion = FocusDirection.Companion;
        if (FocusDirection.m650equalsimpl0(i, companion.m657getLeftdhqQ8s()) || FocusDirection.m650equalsimpl0(i, companion.m660getRightdhqQ8s())) {
            f = 2;
            top = rect2.getTop() + (rect2.getHeight() / f);
            top2 = rect.getTop();
            height = rect.getHeight();
        } else if (!FocusDirection.m650equalsimpl0(i, companion.m661getUpdhqQ8s()) && !FocusDirection.m650equalsimpl0(i, companion.m654getDowndhqQ8s())) {
            throw new IllegalStateException("This function should only be used for 2-D focus search".toString());
        } else {
            f = 2;
            top = rect2.getLeft() + (rect2.getWidth() / f);
            top2 = rect.getLeft();
            height = rect.getWidth();
        }
        return top - (top2 + (height / f));
    }

    private static final long isBetterCandidate_I7lrPNg$weightedDistance(int i, Rect rect, Rect rect2) {
        long abs = Math.abs(isBetterCandidate_I7lrPNg$majorAxisDistance(rect2, i, rect));
        long abs2 = Math.abs(isBetterCandidate_I7lrPNg$minorAxisDistance(rect2, i, rect));
        return (13 * abs * abs) + (abs2 * abs2);
    }

    /* renamed from: isBetterCandidate-I7lrPNg  reason: not valid java name */
    private static final boolean m688isBetterCandidateI7lrPNg(Rect rect, Rect rect2, Rect rect3, int i) {
        if (isBetterCandidate_I7lrPNg$isCandidate(rect, i, rect3)) {
            return !isBetterCandidate_I7lrPNg$isCandidate(rect2, i, rect3) || m684beamBeatsI7lrPNg(rect3, rect, rect2, i) || (!m684beamBeatsI7lrPNg(rect3, rect2, rect, i) && isBetterCandidate_I7lrPNg$weightedDistance(i, rect3, rect) < isBetterCandidate_I7lrPNg$weightedDistance(i, rect3, rect2));
        }
        return false;
    }

    private static final boolean beamBeats_I7lrPNg$inSourceBeam(Rect rect, int i, Rect rect2) {
        FocusDirection.Companion companion = FocusDirection.Companion;
        if (FocusDirection.m650equalsimpl0(i, companion.m657getLeftdhqQ8s()) || FocusDirection.m650equalsimpl0(i, companion.m660getRightdhqQ8s())) {
            if (rect.getBottom() <= rect2.getTop() || rect.getTop() >= rect2.getBottom()) {
                return false;
            }
        } else if (!FocusDirection.m650equalsimpl0(i, companion.m661getUpdhqQ8s()) && !FocusDirection.m650equalsimpl0(i, companion.m654getDowndhqQ8s())) {
            throw new IllegalStateException("This function should only be used for 2-D focus search".toString());
        } else {
            if (rect.getRight() <= rect2.getLeft() || rect.getLeft() >= rect2.getRight()) {
                return false;
            }
        }
        return true;
    }

    private static final boolean beamBeats_I7lrPNg$isInDirectionOfSearch(Rect rect, int i, Rect rect2) {
        FocusDirection.Companion companion = FocusDirection.Companion;
        if (FocusDirection.m650equalsimpl0(i, companion.m657getLeftdhqQ8s())) {
            if (rect2.getLeft() < rect.getRight()) {
                return false;
            }
        } else if (FocusDirection.m650equalsimpl0(i, companion.m660getRightdhqQ8s())) {
            if (rect2.getRight() > rect.getLeft()) {
                return false;
            }
        } else if (FocusDirection.m650equalsimpl0(i, companion.m661getUpdhqQ8s())) {
            if (rect2.getTop() < rect.getBottom()) {
                return false;
            }
        } else if (!FocusDirection.m650equalsimpl0(i, companion.m654getDowndhqQ8s())) {
            throw new IllegalStateException("This function should only be used for 2-D focus search".toString());
        } else {
            if (rect2.getBottom() > rect.getTop()) {
                return false;
            }
        }
        return true;
    }

    private static final float beamBeats_I7lrPNg$majorAxisDistance$6(Rect rect, int i, Rect rect2) {
        float top;
        float bottom;
        float top2;
        float bottom2;
        float f;
        FocusDirection.Companion companion = FocusDirection.Companion;
        if (!FocusDirection.m650equalsimpl0(i, companion.m657getLeftdhqQ8s())) {
            if (FocusDirection.m650equalsimpl0(i, companion.m660getRightdhqQ8s())) {
                top = rect.getLeft();
                bottom = rect2.getRight();
            } else if (FocusDirection.m650equalsimpl0(i, companion.m661getUpdhqQ8s())) {
                top2 = rect2.getTop();
                bottom2 = rect.getBottom();
            } else if (!FocusDirection.m650equalsimpl0(i, companion.m654getDowndhqQ8s())) {
                throw new IllegalStateException("This function should only be used for 2-D focus search".toString());
            } else {
                top = rect.getTop();
                bottom = rect2.getBottom();
            }
            f = top - bottom;
            return Math.max(0.0f, f);
        }
        top2 = rect2.getLeft();
        bottom2 = rect.getRight();
        f = top2 - bottom2;
        return Math.max(0.0f, f);
    }

    private static final float beamBeats_I7lrPNg$majorAxisDistanceToFarEdge(Rect rect, int i, Rect rect2) {
        float bottom;
        float bottom2;
        float top;
        float top2;
        float f;
        FocusDirection.Companion companion = FocusDirection.Companion;
        if (!FocusDirection.m650equalsimpl0(i, companion.m657getLeftdhqQ8s())) {
            if (FocusDirection.m650equalsimpl0(i, companion.m660getRightdhqQ8s())) {
                bottom = rect.getRight();
                bottom2 = rect2.getRight();
            } else if (FocusDirection.m650equalsimpl0(i, companion.m661getUpdhqQ8s())) {
                top = rect2.getTop();
                top2 = rect.getTop();
            } else if (!FocusDirection.m650equalsimpl0(i, companion.m654getDowndhqQ8s())) {
                throw new IllegalStateException("This function should only be used for 2-D focus search".toString());
            } else {
                bottom = rect.getBottom();
                bottom2 = rect2.getBottom();
            }
            f = bottom - bottom2;
            return Math.max(1.0f, f);
        }
        top = rect2.getLeft();
        top2 = rect.getLeft();
        f = top - top2;
        return Math.max(1.0f, f);
    }

    /* renamed from: beamBeats-I7lrPNg  reason: not valid java name */
    private static final boolean m684beamBeatsI7lrPNg(Rect rect, Rect rect2, Rect rect3, int i) {
        if (beamBeats_I7lrPNg$inSourceBeam(rect3, i, rect) || !beamBeats_I7lrPNg$inSourceBeam(rect2, i, rect)) {
            return false;
        }
        if (beamBeats_I7lrPNg$isInDirectionOfSearch(rect3, i, rect)) {
            FocusDirection.Companion companion = FocusDirection.Companion;
            if (!FocusDirection.m650equalsimpl0(i, companion.m657getLeftdhqQ8s()) && !FocusDirection.m650equalsimpl0(i, companion.m660getRightdhqQ8s()) && beamBeats_I7lrPNg$majorAxisDistance$6(rect2, i, rect) >= beamBeats_I7lrPNg$majorAxisDistanceToFarEdge(rect3, i, rect)) {
                return false;
            }
        }
        return true;
    }

    private static final Rect topLeft(Rect rect) {
        return new Rect(rect.getLeft(), rect.getTop(), rect.getLeft(), rect.getTop());
    }

    private static final Rect bottomRight(Rect rect) {
        return new Rect(rect.getRight(), rect.getBottom(), rect.getRight(), rect.getBottom());
    }

    private static final FocusTargetNode activeNode(FocusTargetNode focusTargetNode) {
        if (focusTargetNode.getFocusState() != FocusStateImpl.ActiveParent) {
            throw new IllegalStateException("Check failed.".toString());
        }
        FocusTargetNode findActiveFocusNode = FocusTraversalKt.findActiveFocusNode(focusTargetNode);
        if (findActiveFocusNode != null) {
            return findActiveFocusNode;
        }
        throw new IllegalStateException("ActiveParent must have a focusedChild".toString());
    }

    /* renamed from: findChildCorrespondingToFocusEnter--OM-vw8  reason: not valid java name */
    public static final boolean m686findChildCorrespondingToFocusEnterOMvw8(FocusTargetNode findChildCorrespondingToFocusEnter, int i, Function1 onFound) {
        Rect rect;
        Intrinsics.checkNotNullParameter(findChildCorrespondingToFocusEnter, "$this$findChildCorrespondingToFocusEnter");
        Intrinsics.checkNotNullParameter(onFound, "onFound");
        MutableVector mutableVector = new MutableVector(new FocusTargetNode[16], 0);
        collectAccessibleChildren(findChildCorrespondingToFocusEnter, mutableVector);
        if (mutableVector.getSize() <= 1) {
            FocusTargetNode focusTargetNode = (FocusTargetNode) (mutableVector.isEmpty() ? null : mutableVector.getContent()[0]);
            if (focusTargetNode != null) {
                return ((Boolean) onFound.invoke(focusTargetNode)).booleanValue();
            }
            return false;
        }
        FocusDirection.Companion companion = FocusDirection.Companion;
        if (FocusDirection.m650equalsimpl0(i, companion.m655getEnterdhqQ8s())) {
            i = companion.m660getRightdhqQ8s();
        }
        if (FocusDirection.m650equalsimpl0(i, companion.m660getRightdhqQ8s()) || FocusDirection.m650equalsimpl0(i, companion.m654getDowndhqQ8s())) {
            rect = topLeft(FocusTraversalKt.focusRect(findChildCorrespondingToFocusEnter));
        } else if (!FocusDirection.m650equalsimpl0(i, companion.m657getLeftdhqQ8s()) && !FocusDirection.m650equalsimpl0(i, companion.m661getUpdhqQ8s())) {
            throw new IllegalStateException("This function should only be used for 2-D focus search".toString());
        } else {
            rect = bottomRight(FocusTraversalKt.focusRect(findChildCorrespondingToFocusEnter));
        }
        FocusTargetNode m685findBestCandidate4WY_MpI = m685findBestCandidate4WY_MpI(mutableVector, rect, i);
        if (m685findBestCandidate4WY_MpI != null) {
            return ((Boolean) onFound.invoke(m685findBestCandidate4WY_MpI)).booleanValue();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: searchChildren-4C6V_qg  reason: not valid java name */
    public static final boolean m689searchChildren4C6V_qg(FocusTargetNode focusTargetNode, FocusTargetNode focusTargetNode2, int i, Function1 function1) {
        FocusTargetNode m685findBestCandidate4WY_MpI;
        MutableVector mutableVector = new MutableVector(new FocusTargetNode[16], 0);
        int m1386constructorimpl = NodeKind.m1386constructorimpl(1024);
        if (!focusTargetNode.getNode().isAttached()) {
            throw new IllegalStateException("visitChildren called on an unattached node".toString());
        }
        MutableVector mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child$ui_release = focusTargetNode.getNode().getChild$ui_release();
        if (child$ui_release == null) {
            DelegatableNodeKt.addLayoutNodeChildren(mutableVector2, focusTargetNode.getNode());
        } else {
            mutableVector2.add(child$ui_release);
        }
        while (mutableVector2.isNotEmpty()) {
            Modifier.Node node = (Modifier.Node) mutableVector2.removeAt(mutableVector2.getSize() - 1);
            if ((node.getAggregateChildKindSet$ui_release() & m1386constructorimpl) == 0) {
                DelegatableNodeKt.addLayoutNodeChildren(mutableVector2, node);
            } else {
                while (true) {
                    if (node == null) {
                        break;
                    } else if ((node.getKindSet$ui_release() & m1386constructorimpl) != 0) {
                        MutableVector mutableVector3 = null;
                        while (node != null) {
                            if (node instanceof FocusTargetNode) {
                                mutableVector.add((FocusTargetNode) node);
                            } else if ((node.getKindSet$ui_release() & m1386constructorimpl) != 0 && (node instanceof DelegatingNode)) {
                                int i2 = 0;
                                for (Modifier.Node delegate$ui_release = ((DelegatingNode) node).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                                    if ((delegate$ui_release.getKindSet$ui_release() & m1386constructorimpl) != 0) {
                                        i2++;
                                        if (i2 == 1) {
                                            node = delegate$ui_release;
                                        } else {
                                            if (mutableVector3 == null) {
                                                mutableVector3 = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (node != null) {
                                                mutableVector3.add(node);
                                                node = null;
                                            }
                                            mutableVector3.add(delegate$ui_release);
                                        }
                                    }
                                }
                                if (i2 == 1) {
                                }
                            }
                            node = DelegatableNodeKt.pop(mutableVector3);
                        }
                    } else {
                        node = node.getChild$ui_release();
                    }
                }
            }
        }
        while (mutableVector.isNotEmpty() && (m685findBestCandidate4WY_MpI = m685findBestCandidate4WY_MpI(mutableVector, FocusTraversalKt.focusRect(focusTargetNode2), i)) != null) {
            if (m685findBestCandidate4WY_MpI.fetchFocusProperties$ui_release().getCanFocus()) {
                return ((Boolean) function1.invoke(m685findBestCandidate4WY_MpI)).booleanValue();
            }
            if (m687generateAndSearchChildren4C6V_qg(m685findBestCandidate4WY_MpI, focusTargetNode2, i, function1)) {
                return true;
            }
            mutableVector.remove(m685findBestCandidate4WY_MpI);
        }
        return false;
    }
}
