package androidx.compose.ui.semantics;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SemanticsProperties.kt */
/* loaded from: classes.dex */
public final class SemanticsProperties {
    public static final SemanticsProperties INSTANCE = new SemanticsProperties();
    private static final SemanticsPropertyKey ContentDescription = new SemanticsPropertyKey("ContentDescription", new Function2() { // from class: androidx.compose.ui.semantics.SemanticsProperties$ContentDescription$1
        /* JADX WARN: Code restructure failed: missing block: B:4:0x0007, code lost:
            r2 = kotlin.collections.CollectionsKt___CollectionsKt.toMutableList((java.util.Collection) r2);
         */
        @Override // kotlin.jvm.functions.Function2
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.util.List invoke(java.util.List r2, java.util.List r3) {
            /*
                r1 = this;
                java.lang.String r0 = "childValue"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                if (r2 == 0) goto L11
                java.util.List r2 = kotlin.collections.CollectionsKt.toMutableList(r2)
                if (r2 == 0) goto L11
                r2.addAll(r3)
                r3 = r2
            L11:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.semantics.SemanticsProperties$ContentDescription$1.invoke(java.util.List, java.util.List):java.util.List");
        }
    });
    private static final SemanticsPropertyKey StateDescription = new SemanticsPropertyKey("StateDescription", null, 2, null);
    private static final SemanticsPropertyKey ProgressBarRangeInfo = new SemanticsPropertyKey("ProgressBarRangeInfo", null, 2, null);
    private static final SemanticsPropertyKey PaneTitle = new SemanticsPropertyKey("PaneTitle", new Function2() { // from class: androidx.compose.ui.semantics.SemanticsProperties$PaneTitle$1
        @Override // kotlin.jvm.functions.Function2
        public final String invoke(String str, String str2) {
            Intrinsics.checkNotNullParameter(str2, "<anonymous parameter 1>");
            throw new IllegalStateException("merge function called on unmergeable property PaneTitle.");
        }
    });
    private static final SemanticsPropertyKey SelectableGroup = new SemanticsPropertyKey("SelectableGroup", null, 2, null);
    private static final SemanticsPropertyKey CollectionInfo = new SemanticsPropertyKey("CollectionInfo", null, 2, null);
    private static final SemanticsPropertyKey CollectionItemInfo = new SemanticsPropertyKey("CollectionItemInfo", null, 2, null);
    private static final SemanticsPropertyKey Heading = new SemanticsPropertyKey("Heading", null, 2, null);
    private static final SemanticsPropertyKey Disabled = new SemanticsPropertyKey("Disabled", null, 2, null);
    private static final SemanticsPropertyKey LiveRegion = new SemanticsPropertyKey("LiveRegion", null, 2, null);
    private static final SemanticsPropertyKey Focused = new SemanticsPropertyKey("Focused", null, 2, null);
    private static final SemanticsPropertyKey IsTraversalGroup = new SemanticsPropertyKey("IsTraversalGroup", null, 2, null);
    private static final SemanticsPropertyKey InvisibleToUser = new SemanticsPropertyKey("InvisibleToUser", new Function2() { // from class: androidx.compose.ui.semantics.SemanticsProperties$InvisibleToUser$1
        @Override // kotlin.jvm.functions.Function2
        public final Unit invoke(Unit unit, Unit unit2) {
            Intrinsics.checkNotNullParameter(unit2, "<anonymous parameter 1>");
            return unit;
        }
    });
    private static final SemanticsPropertyKey TraversalIndex = new SemanticsPropertyKey("TraversalIndex", new Function2() { // from class: androidx.compose.ui.semantics.SemanticsProperties$TraversalIndex$1
        public final Float invoke(Float f, float f2) {
            return f;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return invoke((Float) obj, ((Number) obj2).floatValue());
        }
    });
    private static final SemanticsPropertyKey HorizontalScrollAxisRange = new SemanticsPropertyKey("HorizontalScrollAxisRange", null, 2, null);
    private static final SemanticsPropertyKey VerticalScrollAxisRange = new SemanticsPropertyKey("VerticalScrollAxisRange", null, 2, null);
    private static final SemanticsPropertyKey IsPopup = new SemanticsPropertyKey("IsPopup", new Function2() { // from class: androidx.compose.ui.semantics.SemanticsProperties$IsPopup$1
        @Override // kotlin.jvm.functions.Function2
        public final Unit invoke(Unit unit, Unit unit2) {
            Intrinsics.checkNotNullParameter(unit2, "<anonymous parameter 1>");
            throw new IllegalStateException("merge function called on unmergeable property IsPopup. A popup should not be a child of a clickable/focusable node.");
        }
    });
    private static final SemanticsPropertyKey IsDialog = new SemanticsPropertyKey("IsDialog", new Function2() { // from class: androidx.compose.ui.semantics.SemanticsProperties$IsDialog$1
        @Override // kotlin.jvm.functions.Function2
        public final Unit invoke(Unit unit, Unit unit2) {
            Intrinsics.checkNotNullParameter(unit2, "<anonymous parameter 1>");
            throw new IllegalStateException("merge function called on unmergeable property IsDialog. A dialog should not be a child of a clickable/focusable node.");
        }
    });
    private static final SemanticsPropertyKey Role = new SemanticsPropertyKey("Role", new Function2() { // from class: androidx.compose.ui.semantics.SemanticsProperties$Role$1
        /* renamed from: invoke-qtA-w6s  reason: not valid java name */
        public final Role m1492invokeqtAw6s(Role role, int i) {
            return role;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return m1492invokeqtAw6s((Role) obj, ((Role) obj2).m1481unboximpl());
        }
    });
    private static final SemanticsPropertyKey TestTag = new SemanticsPropertyKey("TestTag", new Function2() { // from class: androidx.compose.ui.semantics.SemanticsProperties$TestTag$1
        @Override // kotlin.jvm.functions.Function2
        public final String invoke(String str, String str2) {
            Intrinsics.checkNotNullParameter(str2, "<anonymous parameter 1>");
            return str;
        }
    });
    private static final SemanticsPropertyKey Text = new SemanticsPropertyKey("Text", new Function2() { // from class: androidx.compose.ui.semantics.SemanticsProperties$Text$1
        /* JADX WARN: Code restructure failed: missing block: B:4:0x0007, code lost:
            r2 = kotlin.collections.CollectionsKt___CollectionsKt.toMutableList((java.util.Collection) r2);
         */
        @Override // kotlin.jvm.functions.Function2
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.util.List invoke(java.util.List r2, java.util.List r3) {
            /*
                r1 = this;
                java.lang.String r0 = "childValue"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                if (r2 == 0) goto L11
                java.util.List r2 = kotlin.collections.CollectionsKt.toMutableList(r2)
                if (r2 == 0) goto L11
                r2.addAll(r3)
                r3 = r2
            L11:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.semantics.SemanticsProperties$Text$1.invoke(java.util.List, java.util.List):java.util.List");
        }
    });
    private static final SemanticsPropertyKey EditableText = new SemanticsPropertyKey("EditableText", null, 2, null);
    private static final SemanticsPropertyKey TextSelectionRange = new SemanticsPropertyKey("TextSelectionRange", null, 2, null);
    private static final SemanticsPropertyKey ImeAction = new SemanticsPropertyKey("ImeAction", null, 2, null);
    private static final SemanticsPropertyKey Selected = new SemanticsPropertyKey("Selected", null, 2, null);
    private static final SemanticsPropertyKey ToggleableState = new SemanticsPropertyKey("ToggleableState", null, 2, null);
    private static final SemanticsPropertyKey Password = new SemanticsPropertyKey("Password", null, 2, null);
    private static final SemanticsPropertyKey Error = new SemanticsPropertyKey("Error", null, 2, null);
    private static final SemanticsPropertyKey IndexForKey = new SemanticsPropertyKey("IndexForKey", null, 2, null);

    private SemanticsProperties() {
    }

    public final SemanticsPropertyKey getCollectionInfo() {
        return CollectionInfo;
    }

    public final SemanticsPropertyKey getCollectionItemInfo() {
        return CollectionItemInfo;
    }

    public final SemanticsPropertyKey getContentDescription() {
        return ContentDescription;
    }

    public final SemanticsPropertyKey getDisabled() {
        return Disabled;
    }

    public final SemanticsPropertyKey getEditableText() {
        return EditableText;
    }

    public final SemanticsPropertyKey getError() {
        return Error;
    }

    public final SemanticsPropertyKey getFocused() {
        return Focused;
    }

    public final SemanticsPropertyKey getHeading() {
        return Heading;
    }

    public final SemanticsPropertyKey getHorizontalScrollAxisRange() {
        return HorizontalScrollAxisRange;
    }

    public final SemanticsPropertyKey getImeAction() {
        return ImeAction;
    }

    public final SemanticsPropertyKey getIndexForKey() {
        return IndexForKey;
    }

    public final SemanticsPropertyKey getInvisibleToUser() {
        return InvisibleToUser;
    }

    public final SemanticsPropertyKey getIsPopup() {
        return IsPopup;
    }

    public final SemanticsPropertyKey getIsTraversalGroup() {
        return IsTraversalGroup;
    }

    public final SemanticsPropertyKey getLiveRegion() {
        return LiveRegion;
    }

    public final SemanticsPropertyKey getPaneTitle() {
        return PaneTitle;
    }

    public final SemanticsPropertyKey getPassword() {
        return Password;
    }

    public final SemanticsPropertyKey getProgressBarRangeInfo() {
        return ProgressBarRangeInfo;
    }

    public final SemanticsPropertyKey getRole() {
        return Role;
    }

    public final SemanticsPropertyKey getSelectableGroup() {
        return SelectableGroup;
    }

    public final SemanticsPropertyKey getSelected() {
        return Selected;
    }

    public final SemanticsPropertyKey getStateDescription() {
        return StateDescription;
    }

    public final SemanticsPropertyKey getTestTag() {
        return TestTag;
    }

    public final SemanticsPropertyKey getText() {
        return Text;
    }

    public final SemanticsPropertyKey getTextSelectionRange() {
        return TextSelectionRange;
    }

    public final SemanticsPropertyKey getToggleableState() {
        return ToggleableState;
    }

    public final SemanticsPropertyKey getTraversalIndex() {
        return TraversalIndex;
    }

    public final SemanticsPropertyKey getVerticalScrollAxisRange() {
        return VerticalScrollAxisRange;
    }
}
