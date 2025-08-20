package androidx.compose.ui.semantics;

import kotlin.Function;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SemanticsProperties.kt */
/* loaded from: classes.dex */
public final class SemanticsActions {
    private static final SemanticsPropertyKey Collapse;
    private static final SemanticsPropertyKey CopyText;
    private static final SemanticsPropertyKey CustomActions;
    private static final SemanticsPropertyKey CutText;
    private static final SemanticsPropertyKey Dismiss;
    private static final SemanticsPropertyKey Expand;
    private static final SemanticsPropertyKey GetTextLayoutResult;
    public static final SemanticsActions INSTANCE = new SemanticsActions();
    private static final SemanticsPropertyKey InsertTextAtCursor;
    private static final SemanticsPropertyKey OnClick;
    private static final SemanticsPropertyKey OnLongClick;
    private static final SemanticsPropertyKey PageDown;
    private static final SemanticsPropertyKey PageLeft;
    private static final SemanticsPropertyKey PageRight;
    private static final SemanticsPropertyKey PageUp;
    private static final SemanticsPropertyKey PasteText;
    private static final SemanticsPropertyKey PerformImeAction;
    private static final SemanticsPropertyKey RequestFocus;
    private static final SemanticsPropertyKey ScrollBy;
    private static final SemanticsPropertyKey ScrollToIndex;
    private static final SemanticsPropertyKey SetProgress;
    private static final SemanticsPropertyKey SetSelection;
    private static final SemanticsPropertyKey SetText;

    private SemanticsActions() {
    }

    public final SemanticsPropertyKey getCollapse() {
        return Collapse;
    }

    public final SemanticsPropertyKey getCopyText() {
        return CopyText;
    }

    public final SemanticsPropertyKey getCustomActions() {
        return CustomActions;
    }

    public final SemanticsPropertyKey getCutText() {
        return CutText;
    }

    public final SemanticsPropertyKey getDismiss() {
        return Dismiss;
    }

    public final SemanticsPropertyKey getExpand() {
        return Expand;
    }

    public final SemanticsPropertyKey getGetTextLayoutResult() {
        return GetTextLayoutResult;
    }

    public final SemanticsPropertyKey getInsertTextAtCursor() {
        return InsertTextAtCursor;
    }

    public final SemanticsPropertyKey getOnClick() {
        return OnClick;
    }

    public final SemanticsPropertyKey getOnLongClick() {
        return OnLongClick;
    }

    public final SemanticsPropertyKey getPageDown() {
        return PageDown;
    }

    public final SemanticsPropertyKey getPageLeft() {
        return PageLeft;
    }

    public final SemanticsPropertyKey getPageRight() {
        return PageRight;
    }

    public final SemanticsPropertyKey getPageUp() {
        return PageUp;
    }

    public final SemanticsPropertyKey getPasteText() {
        return PasteText;
    }

    public final SemanticsPropertyKey getPerformImeAction() {
        return PerformImeAction;
    }

    public final SemanticsPropertyKey getRequestFocus() {
        return RequestFocus;
    }

    public final SemanticsPropertyKey getScrollBy() {
        return ScrollBy;
    }

    public final SemanticsPropertyKey getScrollToIndex() {
        return ScrollToIndex;
    }

    public final SemanticsPropertyKey getSetProgress() {
        return SetProgress;
    }

    public final SemanticsPropertyKey getSetSelection() {
        return SetSelection;
    }

    public final SemanticsPropertyKey getSetText() {
        return SetText;
    }

    static {
        SemanticsPropertiesKt$ActionPropertyKey$1 semanticsPropertiesKt$ActionPropertyKey$1 = new Function2() { // from class: androidx.compose.ui.semantics.SemanticsPropertiesKt$ActionPropertyKey$1
            @Override // kotlin.jvm.functions.Function2
            public final AccessibilityAction invoke(AccessibilityAction accessibilityAction, AccessibilityAction childValue) {
                String label;
                Function action;
                Intrinsics.checkNotNullParameter(childValue, "childValue");
                if (accessibilityAction == null || (label = accessibilityAction.getLabel()) == null) {
                    label = childValue.getLabel();
                }
                if (accessibilityAction == null || (action = accessibilityAction.getAction()) == null) {
                    action = childValue.getAction();
                }
                return new AccessibilityAction(label, action);
            }
        };
        GetTextLayoutResult = new SemanticsPropertyKey("GetTextLayoutResult", semanticsPropertiesKt$ActionPropertyKey$1);
        OnClick = new SemanticsPropertyKey("OnClick", semanticsPropertiesKt$ActionPropertyKey$1);
        OnLongClick = new SemanticsPropertyKey("OnLongClick", semanticsPropertiesKt$ActionPropertyKey$1);
        ScrollBy = new SemanticsPropertyKey("ScrollBy", semanticsPropertiesKt$ActionPropertyKey$1);
        ScrollToIndex = new SemanticsPropertyKey("ScrollToIndex", semanticsPropertiesKt$ActionPropertyKey$1);
        SetProgress = new SemanticsPropertyKey("SetProgress", semanticsPropertiesKt$ActionPropertyKey$1);
        SetSelection = new SemanticsPropertyKey("SetSelection", semanticsPropertiesKt$ActionPropertyKey$1);
        SetText = new SemanticsPropertyKey("SetText", semanticsPropertiesKt$ActionPropertyKey$1);
        InsertTextAtCursor = new SemanticsPropertyKey("InsertTextAtCursor", semanticsPropertiesKt$ActionPropertyKey$1);
        PerformImeAction = new SemanticsPropertyKey("PerformImeAction", semanticsPropertiesKt$ActionPropertyKey$1);
        CopyText = new SemanticsPropertyKey("CopyText", semanticsPropertiesKt$ActionPropertyKey$1);
        CutText = new SemanticsPropertyKey("CutText", semanticsPropertiesKt$ActionPropertyKey$1);
        PasteText = new SemanticsPropertyKey("PasteText", semanticsPropertiesKt$ActionPropertyKey$1);
        Expand = new SemanticsPropertyKey("Expand", semanticsPropertiesKt$ActionPropertyKey$1);
        Collapse = new SemanticsPropertyKey("Collapse", semanticsPropertiesKt$ActionPropertyKey$1);
        Dismiss = new SemanticsPropertyKey("Dismiss", semanticsPropertiesKt$ActionPropertyKey$1);
        RequestFocus = new SemanticsPropertyKey("RequestFocus", semanticsPropertiesKt$ActionPropertyKey$1);
        CustomActions = new SemanticsPropertyKey("CustomActions", null, 2, null);
        PageUp = new SemanticsPropertyKey("PageUp", semanticsPropertiesKt$ActionPropertyKey$1);
        PageLeft = new SemanticsPropertyKey("PageLeft", semanticsPropertiesKt$ActionPropertyKey$1);
        PageDown = new SemanticsPropertyKey("PageDown", semanticsPropertiesKt$ActionPropertyKey$1);
        PageRight = new SemanticsPropertyKey("PageRight", semanticsPropertiesKt$ActionPropertyKey$1);
    }
}
