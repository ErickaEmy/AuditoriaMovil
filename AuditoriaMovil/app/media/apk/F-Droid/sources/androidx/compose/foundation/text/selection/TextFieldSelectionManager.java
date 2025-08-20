package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.HandleState;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.foundation.text.TextFieldCursorKt;
import androidx.compose.foundation.text.TextFieldState;
import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.foundation.text.UndoManager;
import androidx.compose.foundation.text.ValidatingOffsetMappingKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.HapticFeedbackType;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.platform.ClipboardManager;
import androidx.compose.ui.platform.TextToolbar;
import androidx.compose.ui.platform.TextToolbarStatus;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TextFieldValueKt;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
/* compiled from: TextFieldSelectionManager.kt */
/* loaded from: classes.dex */
public final class TextFieldSelectionManager {
    private ClipboardManager clipboardManager;
    private final MutableState currentDragPosition$delegate;
    private Integer dragBeginOffsetInText;
    private long dragBeginPosition;
    private long dragTotalDistance;
    private final MutableState draggingHandle$delegate;
    private final MutableState editable$delegate;
    private FocusRequester focusRequester;
    private HapticFeedback hapticFeedBack;
    private final MouseSelectionObserver mouseSelectionObserver;
    private TextFieldValue oldValue;
    private TextFieldState state;
    private TextToolbar textToolbar;
    private final TextDragObserver touchSelectionObserver;
    private final UndoManager undoManager;
    private final MutableState value$delegate;
    private VisualTransformation visualTransformation;
    private OffsetMapping offsetMapping = ValidatingOffsetMappingKt.getValidatingEmptyOffsetMappingIdentity();
    private Function1 onValueChange = new Function1() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$onValueChange$1
        public final void invoke(TextFieldValue it) {
            Intrinsics.checkNotNullParameter(it, "it");
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((TextFieldValue) obj);
            return Unit.INSTANCE;
        }
    };

    public final FocusRequester getFocusRequester() {
        return this.focusRequester;
    }

    public final HapticFeedback getHapticFeedBack() {
        return this.hapticFeedBack;
    }

    public final MouseSelectionObserver getMouseSelectionObserver$foundation_release() {
        return this.mouseSelectionObserver;
    }

    public final OffsetMapping getOffsetMapping$foundation_release() {
        return this.offsetMapping;
    }

    public final Function1 getOnValueChange$foundation_release() {
        return this.onValueChange;
    }

    public final TextFieldState getState$foundation_release() {
        return this.state;
    }

    public final TextToolbar getTextToolbar() {
        return this.textToolbar;
    }

    public final TextDragObserver getTouchSelectionObserver$foundation_release() {
        return this.touchSelectionObserver;
    }

    public final void setClipboardManager$foundation_release(ClipboardManager clipboardManager) {
        this.clipboardManager = clipboardManager;
    }

    public final void setFocusRequester(FocusRequester focusRequester) {
        this.focusRequester = focusRequester;
    }

    public final void setHapticFeedBack(HapticFeedback hapticFeedback) {
        this.hapticFeedBack = hapticFeedback;
    }

    public final void setOffsetMapping$foundation_release(OffsetMapping offsetMapping) {
        Intrinsics.checkNotNullParameter(offsetMapping, "<set-?>");
        this.offsetMapping = offsetMapping;
    }

    public final void setOnValueChange$foundation_release(Function1 function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.onValueChange = function1;
    }

    public final void setState$foundation_release(TextFieldState textFieldState) {
        this.state = textFieldState;
    }

    public final void setTextToolbar(TextToolbar textToolbar) {
        this.textToolbar = textToolbar;
    }

    public final void setVisualTransformation$foundation_release(VisualTransformation visualTransformation) {
        Intrinsics.checkNotNullParameter(visualTransformation, "<set-?>");
        this.visualTransformation = visualTransformation;
    }

    public TextFieldSelectionManager(UndoManager undoManager) {
        MutableState mutableStateOf$default;
        MutableState mutableStateOf$default2;
        MutableState mutableStateOf$default3;
        MutableState mutableStateOf$default4;
        this.undoManager = undoManager;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new TextFieldValue((String) null, 0L, (TextRange) null, 7, (DefaultConstructorMarker) null), null, 2, null);
        this.value$delegate = mutableStateOf$default;
        this.visualTransformation = VisualTransformation.Companion.getNone();
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
        this.editable$delegate = mutableStateOf$default2;
        Offset.Companion companion = Offset.Companion;
        this.dragBeginPosition = companion.m721getZeroF1C5BW0();
        this.dragTotalDistance = companion.m721getZeroF1C5BW0();
        mutableStateOf$default3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.draggingHandle$delegate = mutableStateOf$default3;
        mutableStateOf$default4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.currentDragPosition$delegate = mutableStateOf$default4;
        this.oldValue = new TextFieldValue((String) null, 0L, (TextRange) null, 7, (DefaultConstructorMarker) null);
        this.touchSelectionObserver = new TextDragObserver() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$touchSelectionObserver$1
            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onCancel() {
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* renamed from: onDown-k-4lQ0M */
            public void mo330onDownk4lQ0M(long j) {
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onUp() {
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* renamed from: onStart-k-4lQ0M */
            public void mo332onStartk4lQ0M(long j) {
                TextFieldState state$foundation_release;
                TextLayoutResultProxy layoutResult;
                TextFieldValue m409createTextFieldValueFDrldGo;
                long j2;
                TextLayoutResultProxy layoutResult2;
                TextLayoutResultProxy layoutResult3;
                if (TextFieldSelectionManager.this.getDraggingHandle() != null) {
                    return;
                }
                TextFieldSelectionManager.this.setDraggingHandle(Handle.SelectionEnd);
                TextFieldSelectionManager.this.hideSelectionToolbar$foundation_release();
                TextFieldState state$foundation_release2 = TextFieldSelectionManager.this.getState$foundation_release();
                if ((state$foundation_release2 == null || (layoutResult3 = state$foundation_release2.getLayoutResult()) == null || !layoutResult3.m360isPositionOnTextk4lQ0M(j)) && (state$foundation_release = TextFieldSelectionManager.this.getState$foundation_release()) != null && (layoutResult = state$foundation_release.getLayoutResult()) != null) {
                    TextFieldSelectionManager textFieldSelectionManager = TextFieldSelectionManager.this;
                    int transformedToOriginal = textFieldSelectionManager.getOffsetMapping$foundation_release().transformedToOriginal(TextLayoutResultProxy.getLineEnd$default(layoutResult, layoutResult.getLineForVerticalPosition(Offset.m710getYimpl(j)), false, 2, null));
                    HapticFeedback hapticFeedBack = textFieldSelectionManager.getHapticFeedBack();
                    if (hapticFeedBack != null) {
                        hapticFeedBack.mo1097performHapticFeedbackCdsT49E(HapticFeedbackType.Companion.m1101getTextHandleMove5zf0vsI());
                    }
                    m409createTextFieldValueFDrldGo = textFieldSelectionManager.m409createTextFieldValueFDrldGo(textFieldSelectionManager.getValue$foundation_release().getAnnotatedString(), TextRangeKt.TextRange(transformedToOriginal, transformedToOriginal));
                    textFieldSelectionManager.enterSelectionMode$foundation_release();
                    textFieldSelectionManager.getOnValueChange$foundation_release().invoke(m409createTextFieldValueFDrldGo);
                } else if (TextFieldSelectionManager.this.getValue$foundation_release().getText().length() == 0) {
                } else {
                    TextFieldSelectionManager.this.enterSelectionMode$foundation_release();
                    TextFieldState state$foundation_release3 = TextFieldSelectionManager.this.getState$foundation_release();
                    if (state$foundation_release3 != null && (layoutResult2 = state$foundation_release3.getLayoutResult()) != null) {
                        TextFieldSelectionManager textFieldSelectionManager2 = TextFieldSelectionManager.this;
                        int m357getOffsetForPosition3MmeM6k$default = TextLayoutResultProxy.m357getOffsetForPosition3MmeM6k$default(layoutResult2, j, false, 2, null);
                        textFieldSelectionManager2.updateSelection(textFieldSelectionManager2.getValue$foundation_release(), m357getOffsetForPosition3MmeM6k$default, m357getOffsetForPosition3MmeM6k$default, false, SelectionAdjustment.Companion.getWord());
                        textFieldSelectionManager2.dragBeginOffsetInText = Integer.valueOf(m357getOffsetForPosition3MmeM6k$default);
                    }
                    TextFieldSelectionManager.this.dragBeginPosition = j;
                    TextFieldSelectionManager textFieldSelectionManager3 = TextFieldSelectionManager.this;
                    j2 = textFieldSelectionManager3.dragBeginPosition;
                    textFieldSelectionManager3.m411setCurrentDragPosition_kEHs6E(Offset.m698boximpl(j2));
                    TextFieldSelectionManager.this.dragTotalDistance = Offset.Companion.m721getZeroF1C5BW0();
                }
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* renamed from: onDrag-k-4lQ0M */
            public void mo331onDragk4lQ0M(long j) {
                long j2;
                TextLayoutResultProxy layoutResult;
                long j3;
                long j4;
                Integer num;
                long j5;
                int m359getOffsetForPosition3MmeM6k;
                if (TextFieldSelectionManager.this.getValue$foundation_release().getText().length() == 0) {
                    return;
                }
                TextFieldSelectionManager textFieldSelectionManager = TextFieldSelectionManager.this;
                j2 = textFieldSelectionManager.dragTotalDistance;
                textFieldSelectionManager.dragTotalDistance = Offset.m714plusMKHz9U(j2, j);
                TextFieldState state$foundation_release = TextFieldSelectionManager.this.getState$foundation_release();
                if (state$foundation_release != null && (layoutResult = state$foundation_release.getLayoutResult()) != null) {
                    TextFieldSelectionManager textFieldSelectionManager2 = TextFieldSelectionManager.this;
                    j3 = textFieldSelectionManager2.dragBeginPosition;
                    j4 = textFieldSelectionManager2.dragTotalDistance;
                    textFieldSelectionManager2.m411setCurrentDragPosition_kEHs6E(Offset.m698boximpl(Offset.m714plusMKHz9U(j3, j4)));
                    num = textFieldSelectionManager2.dragBeginOffsetInText;
                    if (num != null) {
                        m359getOffsetForPosition3MmeM6k = num.intValue();
                    } else {
                        j5 = textFieldSelectionManager2.dragBeginPosition;
                        m359getOffsetForPosition3MmeM6k = layoutResult.m359getOffsetForPosition3MmeM6k(j5, false);
                    }
                    int i = m359getOffsetForPosition3MmeM6k;
                    Offset m413getCurrentDragPosition_m7T9E = textFieldSelectionManager2.m413getCurrentDragPosition_m7T9E();
                    Intrinsics.checkNotNull(m413getCurrentDragPosition_m7T9E);
                    textFieldSelectionManager2.updateSelection(textFieldSelectionManager2.getValue$foundation_release(), i, layoutResult.m359getOffsetForPosition3MmeM6k(m413getCurrentDragPosition_m7T9E.m718unboximpl(), false), false, SelectionAdjustment.Companion.getWord());
                }
                TextFieldState state$foundation_release2 = TextFieldSelectionManager.this.getState$foundation_release();
                if (state$foundation_release2 == null) {
                    return;
                }
                state$foundation_release2.setShowFloatingToolbar(false);
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onStop() {
                TextFieldSelectionManager.this.setDraggingHandle(null);
                TextFieldSelectionManager.this.m411setCurrentDragPosition_kEHs6E(null);
                TextFieldState state$foundation_release = TextFieldSelectionManager.this.getState$foundation_release();
                if (state$foundation_release != null) {
                    state$foundation_release.setShowFloatingToolbar(true);
                }
                TextToolbar textToolbar = TextFieldSelectionManager.this.getTextToolbar();
                if ((textToolbar != null ? textToolbar.getStatus() : null) == TextToolbarStatus.Hidden) {
                    TextFieldSelectionManager.this.showSelectionToolbar$foundation_release();
                }
                TextFieldSelectionManager.this.dragBeginOffsetInText = null;
            }
        };
        this.mouseSelectionObserver = new MouseSelectionObserver() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$mouseSelectionObserver$1
            @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
            /* renamed from: onExtend-k-4lQ0M */
            public boolean mo391onExtendk4lQ0M(long j) {
                TextLayoutResultProxy layoutResult;
                TextFieldState state$foundation_release = TextFieldSelectionManager.this.getState$foundation_release();
                if (state$foundation_release == null || (layoutResult = state$foundation_release.getLayoutResult()) == null) {
                    return false;
                }
                TextFieldSelectionManager textFieldSelectionManager = TextFieldSelectionManager.this;
                textFieldSelectionManager.updateSelection(textFieldSelectionManager.getValue$foundation_release(), textFieldSelectionManager.getOffsetMapping$foundation_release().originalToTransformed(TextRange.m1585getStartimpl(textFieldSelectionManager.getValue$foundation_release().m1718getSelectiond9O1mEE())), TextLayoutResultProxy.m357getOffsetForPosition3MmeM6k$default(layoutResult, j, false, 2, null), false, SelectionAdjustment.Companion.getNone());
                return true;
            }

            @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
            /* renamed from: onExtendDrag-k-4lQ0M */
            public boolean mo392onExtendDragk4lQ0M(long j) {
                TextFieldState state$foundation_release;
                TextLayoutResultProxy layoutResult;
                if (TextFieldSelectionManager.this.getValue$foundation_release().getText().length() == 0 || (state$foundation_release = TextFieldSelectionManager.this.getState$foundation_release()) == null || (layoutResult = state$foundation_release.getLayoutResult()) == null) {
                    return false;
                }
                TextFieldSelectionManager textFieldSelectionManager = TextFieldSelectionManager.this;
                textFieldSelectionManager.updateSelection(textFieldSelectionManager.getValue$foundation_release(), textFieldSelectionManager.getOffsetMapping$foundation_release().originalToTransformed(TextRange.m1585getStartimpl(textFieldSelectionManager.getValue$foundation_release().m1718getSelectiond9O1mEE())), layoutResult.m359getOffsetForPosition3MmeM6k(j, false), false, SelectionAdjustment.Companion.getNone());
                return true;
            }

            @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
            /* renamed from: onStart-3MmeM6k */
            public boolean mo393onStart3MmeM6k(long j, SelectionAdjustment adjustment) {
                TextLayoutResultProxy layoutResult;
                long j2;
                Intrinsics.checkNotNullParameter(adjustment, "adjustment");
                FocusRequester focusRequester = TextFieldSelectionManager.this.getFocusRequester();
                if (focusRequester != null) {
                    focusRequester.requestFocus();
                }
                TextFieldSelectionManager.this.dragBeginPosition = j;
                TextFieldState state$foundation_release = TextFieldSelectionManager.this.getState$foundation_release();
                if (state$foundation_release == null || (layoutResult = state$foundation_release.getLayoutResult()) == null) {
                    return false;
                }
                TextFieldSelectionManager textFieldSelectionManager = TextFieldSelectionManager.this;
                textFieldSelectionManager.dragBeginOffsetInText = Integer.valueOf(TextLayoutResultProxy.m357getOffsetForPosition3MmeM6k$default(layoutResult, j, false, 2, null));
                j2 = textFieldSelectionManager.dragBeginPosition;
                int m357getOffsetForPosition3MmeM6k$default = TextLayoutResultProxy.m357getOffsetForPosition3MmeM6k$default(layoutResult, j2, false, 2, null);
                textFieldSelectionManager.updateSelection(textFieldSelectionManager.getValue$foundation_release(), m357getOffsetForPosition3MmeM6k$default, m357getOffsetForPosition3MmeM6k$default, false, adjustment);
                return true;
            }

            @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
            /* renamed from: onDrag-3MmeM6k */
            public boolean mo390onDrag3MmeM6k(long j, SelectionAdjustment adjustment) {
                TextFieldState state$foundation_release;
                TextLayoutResultProxy layoutResult;
                Integer num;
                Intrinsics.checkNotNullParameter(adjustment, "adjustment");
                if (TextFieldSelectionManager.this.getValue$foundation_release().getText().length() == 0 || (state$foundation_release = TextFieldSelectionManager.this.getState$foundation_release()) == null || (layoutResult = state$foundation_release.getLayoutResult()) == null) {
                    return false;
                }
                TextFieldSelectionManager textFieldSelectionManager = TextFieldSelectionManager.this;
                int m359getOffsetForPosition3MmeM6k = layoutResult.m359getOffsetForPosition3MmeM6k(j, false);
                TextFieldValue value$foundation_release = textFieldSelectionManager.getValue$foundation_release();
                num = textFieldSelectionManager.dragBeginOffsetInText;
                Intrinsics.checkNotNull(num);
                textFieldSelectionManager.updateSelection(value$foundation_release, num.intValue(), m359getOffsetForPosition3MmeM6k, false, adjustment);
                return true;
            }
        };
    }

    /* renamed from: getCurrentDragPosition-_m7T9-E  reason: not valid java name */
    public final Offset m413getCurrentDragPosition_m7T9E() {
        return (Offset) this.currentDragPosition$delegate.getValue();
    }

    public final Handle getDraggingHandle() {
        return (Handle) this.draggingHandle$delegate.getValue();
    }

    public final boolean getEditable() {
        return ((Boolean) this.editable$delegate.getValue()).booleanValue();
    }

    public final TextFieldValue getValue$foundation_release() {
        return (TextFieldValue) this.value$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setCurrentDragPosition-_kEHs6E  reason: not valid java name */
    public final void m411setCurrentDragPosition_kEHs6E(Offset offset) {
        this.currentDragPosition$delegate.setValue(offset);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setDraggingHandle(Handle handle) {
        this.draggingHandle$delegate.setValue(handle);
    }

    public final void setValue$foundation_release(TextFieldValue textFieldValue) {
        Intrinsics.checkNotNullParameter(textFieldValue, "<set-?>");
        this.value$delegate.setValue(textFieldValue);
    }

    public final void setEditable(boolean z) {
        this.editable$delegate.setValue(Boolean.valueOf(z));
    }

    public final TextDragObserver handleDragObserver$foundation_release(final boolean z) {
        return new TextDragObserver() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$handleDragObserver$1
            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onCancel() {
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* renamed from: onDown-k-4lQ0M */
            public void mo330onDownk4lQ0M(long j) {
                TextFieldSelectionManager.this.setDraggingHandle(z ? Handle.SelectionStart : Handle.SelectionEnd);
                TextFieldSelectionManager textFieldSelectionManager = TextFieldSelectionManager.this;
                textFieldSelectionManager.m411setCurrentDragPosition_kEHs6E(Offset.m698boximpl(SelectionHandlesKt.m399getAdjustedCoordinatesk4lQ0M(textFieldSelectionManager.m415getHandlePositiontuRUvjQ$foundation_release(z))));
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onUp() {
                TextFieldSelectionManager.this.setDraggingHandle(null);
                TextFieldSelectionManager.this.m411setCurrentDragPosition_kEHs6E(null);
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* renamed from: onStart-k-4lQ0M */
            public void mo332onStartk4lQ0M(long j) {
                long j2;
                TextFieldSelectionManager textFieldSelectionManager = TextFieldSelectionManager.this;
                textFieldSelectionManager.dragBeginPosition = SelectionHandlesKt.m399getAdjustedCoordinatesk4lQ0M(textFieldSelectionManager.m415getHandlePositiontuRUvjQ$foundation_release(z));
                TextFieldSelectionManager textFieldSelectionManager2 = TextFieldSelectionManager.this;
                j2 = textFieldSelectionManager2.dragBeginPosition;
                textFieldSelectionManager2.m411setCurrentDragPosition_kEHs6E(Offset.m698boximpl(j2));
                TextFieldSelectionManager.this.dragTotalDistance = Offset.Companion.m721getZeroF1C5BW0();
                TextFieldSelectionManager.this.setDraggingHandle(z ? Handle.SelectionStart : Handle.SelectionEnd);
                TextFieldState state$foundation_release = TextFieldSelectionManager.this.getState$foundation_release();
                if (state$foundation_release == null) {
                    return;
                }
                state$foundation_release.setShowFloatingToolbar(false);
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* renamed from: onDrag-k-4lQ0M */
            public void mo331onDragk4lQ0M(long j) {
                long j2;
                TextLayoutResultProxy layoutResult;
                TextLayoutResult value;
                long j3;
                long j4;
                int originalToTransformed;
                int m1570getOffsetForPositionk4lQ0M;
                TextFieldSelectionManager textFieldSelectionManager = TextFieldSelectionManager.this;
                j2 = textFieldSelectionManager.dragTotalDistance;
                textFieldSelectionManager.dragTotalDistance = Offset.m714plusMKHz9U(j2, j);
                TextFieldState state$foundation_release = TextFieldSelectionManager.this.getState$foundation_release();
                if (state$foundation_release != null && (layoutResult = state$foundation_release.getLayoutResult()) != null && (value = layoutResult.getValue()) != null) {
                    TextFieldSelectionManager textFieldSelectionManager2 = TextFieldSelectionManager.this;
                    boolean z2 = z;
                    j3 = textFieldSelectionManager2.dragBeginPosition;
                    j4 = textFieldSelectionManager2.dragTotalDistance;
                    textFieldSelectionManager2.m411setCurrentDragPosition_kEHs6E(Offset.m698boximpl(Offset.m714plusMKHz9U(j3, j4)));
                    if (z2) {
                        Offset m413getCurrentDragPosition_m7T9E = textFieldSelectionManager2.m413getCurrentDragPosition_m7T9E();
                        Intrinsics.checkNotNull(m413getCurrentDragPosition_m7T9E);
                        originalToTransformed = value.m1570getOffsetForPositionk4lQ0M(m413getCurrentDragPosition_m7T9E.m718unboximpl());
                    } else {
                        originalToTransformed = textFieldSelectionManager2.getOffsetMapping$foundation_release().originalToTransformed(TextRange.m1585getStartimpl(textFieldSelectionManager2.getValue$foundation_release().m1718getSelectiond9O1mEE()));
                    }
                    int i = originalToTransformed;
                    if (z2) {
                        m1570getOffsetForPositionk4lQ0M = textFieldSelectionManager2.getOffsetMapping$foundation_release().originalToTransformed(TextRange.m1580getEndimpl(textFieldSelectionManager2.getValue$foundation_release().m1718getSelectiond9O1mEE()));
                    } else {
                        Offset m413getCurrentDragPosition_m7T9E2 = textFieldSelectionManager2.m413getCurrentDragPosition_m7T9E();
                        Intrinsics.checkNotNull(m413getCurrentDragPosition_m7T9E2);
                        m1570getOffsetForPositionk4lQ0M = value.m1570getOffsetForPositionk4lQ0M(m413getCurrentDragPosition_m7T9E2.m718unboximpl());
                    }
                    textFieldSelectionManager2.updateSelection(textFieldSelectionManager2.getValue$foundation_release(), i, m1570getOffsetForPositionk4lQ0M, z2, SelectionAdjustment.Companion.getCharacter());
                }
                TextFieldState state$foundation_release2 = TextFieldSelectionManager.this.getState$foundation_release();
                if (state$foundation_release2 == null) {
                    return;
                }
                state$foundation_release2.setShowFloatingToolbar(false);
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onStop() {
                TextFieldSelectionManager.this.setDraggingHandle(null);
                TextFieldSelectionManager.this.m411setCurrentDragPosition_kEHs6E(null);
                TextFieldState state$foundation_release = TextFieldSelectionManager.this.getState$foundation_release();
                if (state$foundation_release != null) {
                    state$foundation_release.setShowFloatingToolbar(true);
                }
                TextToolbar textToolbar = TextFieldSelectionManager.this.getTextToolbar();
                if ((textToolbar != null ? textToolbar.getStatus() : null) == TextToolbarStatus.Hidden) {
                    TextFieldSelectionManager.this.showSelectionToolbar$foundation_release();
                }
            }
        };
    }

    public final TextDragObserver cursorDragObserver$foundation_release() {
        return new TextDragObserver() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$cursorDragObserver$1
            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onCancel() {
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* renamed from: onDown-k-4lQ0M */
            public void mo330onDownk4lQ0M(long j) {
                TextFieldSelectionManager.this.setDraggingHandle(Handle.Cursor);
                TextFieldSelectionManager textFieldSelectionManager = TextFieldSelectionManager.this;
                textFieldSelectionManager.m411setCurrentDragPosition_kEHs6E(Offset.m698boximpl(SelectionHandlesKt.m399getAdjustedCoordinatesk4lQ0M(textFieldSelectionManager.m415getHandlePositiontuRUvjQ$foundation_release(true))));
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onUp() {
                TextFieldSelectionManager.this.setDraggingHandle(null);
                TextFieldSelectionManager.this.m411setCurrentDragPosition_kEHs6E(null);
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* renamed from: onStart-k-4lQ0M */
            public void mo332onStartk4lQ0M(long j) {
                long j2;
                TextFieldSelectionManager textFieldSelectionManager = TextFieldSelectionManager.this;
                textFieldSelectionManager.dragBeginPosition = SelectionHandlesKt.m399getAdjustedCoordinatesk4lQ0M(textFieldSelectionManager.m415getHandlePositiontuRUvjQ$foundation_release(true));
                TextFieldSelectionManager textFieldSelectionManager2 = TextFieldSelectionManager.this;
                j2 = textFieldSelectionManager2.dragBeginPosition;
                textFieldSelectionManager2.m411setCurrentDragPosition_kEHs6E(Offset.m698boximpl(j2));
                TextFieldSelectionManager.this.dragTotalDistance = Offset.Companion.m721getZeroF1C5BW0();
                TextFieldSelectionManager.this.setDraggingHandle(Handle.Cursor);
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* renamed from: onDrag-k-4lQ0M */
            public void mo331onDragk4lQ0M(long j) {
                long j2;
                TextLayoutResultProxy layoutResult;
                TextLayoutResult value;
                long j3;
                long j4;
                TextFieldValue m409createTextFieldValueFDrldGo;
                TextFieldSelectionManager textFieldSelectionManager = TextFieldSelectionManager.this;
                j2 = textFieldSelectionManager.dragTotalDistance;
                textFieldSelectionManager.dragTotalDistance = Offset.m714plusMKHz9U(j2, j);
                TextFieldState state$foundation_release = TextFieldSelectionManager.this.getState$foundation_release();
                if (state$foundation_release == null || (layoutResult = state$foundation_release.getLayoutResult()) == null || (value = layoutResult.getValue()) == null) {
                    return;
                }
                TextFieldSelectionManager textFieldSelectionManager2 = TextFieldSelectionManager.this;
                j3 = textFieldSelectionManager2.dragBeginPosition;
                j4 = textFieldSelectionManager2.dragTotalDistance;
                textFieldSelectionManager2.m411setCurrentDragPosition_kEHs6E(Offset.m698boximpl(Offset.m714plusMKHz9U(j3, j4)));
                OffsetMapping offsetMapping$foundation_release = textFieldSelectionManager2.getOffsetMapping$foundation_release();
                Offset m413getCurrentDragPosition_m7T9E = textFieldSelectionManager2.m413getCurrentDragPosition_m7T9E();
                Intrinsics.checkNotNull(m413getCurrentDragPosition_m7T9E);
                int transformedToOriginal = offsetMapping$foundation_release.transformedToOriginal(value.m1570getOffsetForPositionk4lQ0M(m413getCurrentDragPosition_m7T9E.m718unboximpl()));
                long TextRange = TextRangeKt.TextRange(transformedToOriginal, transformedToOriginal);
                if (TextRange.m1578equalsimpl0(TextRange, textFieldSelectionManager2.getValue$foundation_release().m1718getSelectiond9O1mEE())) {
                    return;
                }
                HapticFeedback hapticFeedBack = textFieldSelectionManager2.getHapticFeedBack();
                if (hapticFeedBack != null) {
                    hapticFeedBack.mo1097performHapticFeedbackCdsT49E(HapticFeedbackType.Companion.m1101getTextHandleMove5zf0vsI());
                }
                Function1 onValueChange$foundation_release = textFieldSelectionManager2.getOnValueChange$foundation_release();
                m409createTextFieldValueFDrldGo = textFieldSelectionManager2.m409createTextFieldValueFDrldGo(textFieldSelectionManager2.getValue$foundation_release().getAnnotatedString(), TextRange);
                onValueChange$foundation_release.invoke(m409createTextFieldValueFDrldGo);
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onStop() {
                TextFieldSelectionManager.this.setDraggingHandle(null);
                TextFieldSelectionManager.this.m411setCurrentDragPosition_kEHs6E(null);
            }
        };
    }

    public final void enterSelectionMode$foundation_release() {
        FocusRequester focusRequester;
        TextFieldState textFieldState = this.state;
        if (textFieldState != null && !textFieldState.getHasFocus() && (focusRequester = this.focusRequester) != null) {
            focusRequester.requestFocus();
        }
        this.oldValue = getValue$foundation_release();
        TextFieldState textFieldState2 = this.state;
        if (textFieldState2 != null) {
            textFieldState2.setShowFloatingToolbar(true);
        }
        setHandleState(HandleState.Selection);
    }

    public final void exitSelectionMode$foundation_release() {
        TextFieldState textFieldState = this.state;
        if (textFieldState != null) {
            textFieldState.setShowFloatingToolbar(false);
        }
        setHandleState(HandleState.None);
    }

    /* renamed from: deselect-_kEHs6E$foundation_release$default  reason: not valid java name */
    public static /* synthetic */ void m410deselect_kEHs6E$foundation_release$default(TextFieldSelectionManager textFieldSelectionManager, Offset offset, int i, Object obj) {
        if ((i & 1) != 0) {
            offset = null;
        }
        textFieldSelectionManager.m412deselect_kEHs6E$foundation_release(offset);
    }

    /* renamed from: deselect-_kEHs6E$foundation_release  reason: not valid java name */
    public final void m412deselect_kEHs6E$foundation_release(Offset offset) {
        HandleState handleState;
        int m1582getMaximpl;
        if (!TextRange.m1579getCollapsedimpl(getValue$foundation_release().m1718getSelectiond9O1mEE())) {
            TextFieldState textFieldState = this.state;
            TextLayoutResultProxy layoutResult = textFieldState != null ? textFieldState.getLayoutResult() : null;
            if (offset != null && layoutResult != null) {
                m1582getMaximpl = this.offsetMapping.transformedToOriginal(TextLayoutResultProxy.m357getOffsetForPosition3MmeM6k$default(layoutResult, offset.m718unboximpl(), false, 2, null));
            } else {
                m1582getMaximpl = TextRange.m1582getMaximpl(getValue$foundation_release().m1718getSelectiond9O1mEE());
            }
            this.onValueChange.invoke(TextFieldValue.m1715copy3r_uNRQ$default(getValue$foundation_release(), null, TextRangeKt.TextRange(m1582getMaximpl), null, 5, null));
        }
        if (offset != null && getValue$foundation_release().getText().length() > 0) {
            handleState = HandleState.Cursor;
        } else {
            handleState = HandleState.None;
        }
        setHandleState(handleState);
        hideSelectionToolbar$foundation_release();
    }

    public static /* synthetic */ void copy$foundation_release$default(TextFieldSelectionManager textFieldSelectionManager, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        textFieldSelectionManager.copy$foundation_release(z);
    }

    public final void copy$foundation_release(boolean z) {
        if (TextRange.m1579getCollapsedimpl(getValue$foundation_release().m1718getSelectiond9O1mEE())) {
            return;
        }
        ClipboardManager clipboardManager = this.clipboardManager;
        if (clipboardManager != null) {
            clipboardManager.setText(TextFieldValueKt.getSelectedText(getValue$foundation_release()));
        }
        if (z) {
            int m1582getMaximpl = TextRange.m1582getMaximpl(getValue$foundation_release().m1718getSelectiond9O1mEE());
            this.onValueChange.invoke(m409createTextFieldValueFDrldGo(getValue$foundation_release().getAnnotatedString(), TextRangeKt.TextRange(m1582getMaximpl, m1582getMaximpl)));
            setHandleState(HandleState.None);
        }
    }

    public final void paste$foundation_release() {
        AnnotatedString text;
        ClipboardManager clipboardManager = this.clipboardManager;
        if (clipboardManager == null || (text = clipboardManager.getText()) == null) {
            return;
        }
        AnnotatedString plus = TextFieldValueKt.getTextBeforeSelection(getValue$foundation_release(), getValue$foundation_release().getText().length()).plus(text).plus(TextFieldValueKt.getTextAfterSelection(getValue$foundation_release(), getValue$foundation_release().getText().length()));
        int m1583getMinimpl = TextRange.m1583getMinimpl(getValue$foundation_release().m1718getSelectiond9O1mEE()) + text.length();
        this.onValueChange.invoke(m409createTextFieldValueFDrldGo(plus, TextRangeKt.TextRange(m1583getMinimpl, m1583getMinimpl)));
        setHandleState(HandleState.None);
        UndoManager undoManager = this.undoManager;
        if (undoManager != null) {
            undoManager.forceNextSnapshot();
        }
    }

    public final void cut$foundation_release() {
        if (TextRange.m1579getCollapsedimpl(getValue$foundation_release().m1718getSelectiond9O1mEE())) {
            return;
        }
        ClipboardManager clipboardManager = this.clipboardManager;
        if (clipboardManager != null) {
            clipboardManager.setText(TextFieldValueKt.getSelectedText(getValue$foundation_release()));
        }
        AnnotatedString plus = TextFieldValueKt.getTextBeforeSelection(getValue$foundation_release(), getValue$foundation_release().getText().length()).plus(TextFieldValueKt.getTextAfterSelection(getValue$foundation_release(), getValue$foundation_release().getText().length()));
        int m1583getMinimpl = TextRange.m1583getMinimpl(getValue$foundation_release().m1718getSelectiond9O1mEE());
        this.onValueChange.invoke(m409createTextFieldValueFDrldGo(plus, TextRangeKt.TextRange(m1583getMinimpl, m1583getMinimpl)));
        setHandleState(HandleState.None);
        UndoManager undoManager = this.undoManager;
        if (undoManager != null) {
            undoManager.forceNextSnapshot();
        }
    }

    public final void selectAll$foundation_release() {
        TextFieldValue m409createTextFieldValueFDrldGo = m409createTextFieldValueFDrldGo(getValue$foundation_release().getAnnotatedString(), TextRangeKt.TextRange(0, getValue$foundation_release().getText().length()));
        this.onValueChange.invoke(m409createTextFieldValueFDrldGo);
        this.oldValue = TextFieldValue.m1715copy3r_uNRQ$default(this.oldValue, null, m409createTextFieldValueFDrldGo.m1718getSelectiond9O1mEE(), null, 5, null);
        TextFieldState textFieldState = this.state;
        if (textFieldState == null) {
            return;
        }
        textFieldState.setShowFloatingToolbar(true);
    }

    /* renamed from: getHandlePosition-tuRUvjQ$foundation_release  reason: not valid java name */
    public final long m415getHandlePositiontuRUvjQ$foundation_release(boolean z) {
        long m1718getSelectiond9O1mEE = getValue$foundation_release().m1718getSelectiond9O1mEE();
        int m1585getStartimpl = z ? TextRange.m1585getStartimpl(m1718getSelectiond9O1mEE) : TextRange.m1580getEndimpl(m1718getSelectiond9O1mEE);
        TextFieldState textFieldState = this.state;
        TextLayoutResultProxy layoutResult = textFieldState != null ? textFieldState.getLayoutResult() : null;
        Intrinsics.checkNotNull(layoutResult);
        return TextSelectionDelegateKt.getSelectionHandleCoordinates(layoutResult.getValue(), this.offsetMapping.originalToTransformed(m1585getStartimpl), z, TextRange.m1584getReversedimpl(getValue$foundation_release().m1718getSelectiond9O1mEE()));
    }

    /* renamed from: getCursorPosition-tuRUvjQ$foundation_release  reason: not valid java name */
    public final long m414getCursorPositiontuRUvjQ$foundation_release(Density density) {
        int coerceIn;
        Intrinsics.checkNotNullParameter(density, "density");
        int originalToTransformed = this.offsetMapping.originalToTransformed(TextRange.m1585getStartimpl(getValue$foundation_release().m1718getSelectiond9O1mEE()));
        TextFieldState textFieldState = this.state;
        TextLayoutResultProxy layoutResult = textFieldState != null ? textFieldState.getLayoutResult() : null;
        Intrinsics.checkNotNull(layoutResult);
        TextLayoutResult value = layoutResult.getValue();
        coerceIn = RangesKt___RangesKt.coerceIn(originalToTransformed, 0, value.getLayoutInput().getText().length());
        Rect cursorRect = value.getCursorRect(coerceIn);
        return OffsetKt.Offset(cursorRect.getLeft() + (density.mo155toPx0680j_4(TextFieldCursorKt.getDefaultCursorThickness()) / 2), cursorRect.getBottom());
    }

    public final void showSelectionToolbar$foundation_release() {
        ClipboardManager clipboardManager;
        Function0 function0 = !TextRange.m1579getCollapsedimpl(getValue$foundation_release().m1718getSelectiond9O1mEE()) ? new Function0() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$showSelectionToolbar$copy$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m416invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: collision with other method in class */
            public final void m416invoke() {
                TextFieldSelectionManager.copy$foundation_release$default(TextFieldSelectionManager.this, false, 1, null);
                TextFieldSelectionManager.this.hideSelectionToolbar$foundation_release();
            }
        } : null;
        Function0 function02 = (TextRange.m1579getCollapsedimpl(getValue$foundation_release().m1718getSelectiond9O1mEE()) || !getEditable()) ? null : new Function0() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$showSelectionToolbar$cut$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m417invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: collision with other method in class */
            public final void m417invoke() {
                TextFieldSelectionManager.this.cut$foundation_release();
                TextFieldSelectionManager.this.hideSelectionToolbar$foundation_release();
            }
        };
        Function0 function03 = (getEditable() && (clipboardManager = this.clipboardManager) != null && clipboardManager.hasText()) ? new Function0() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$showSelectionToolbar$paste$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m418invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: collision with other method in class */
            public final void m418invoke() {
                TextFieldSelectionManager.this.paste$foundation_release();
                TextFieldSelectionManager.this.hideSelectionToolbar$foundation_release();
            }
        } : null;
        Function0 function04 = TextRange.m1581getLengthimpl(getValue$foundation_release().m1718getSelectiond9O1mEE()) != getValue$foundation_release().getText().length() ? new Function0() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$showSelectionToolbar$selectAll$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m419invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: collision with other method in class */
            public final void m419invoke() {
                TextFieldSelectionManager.this.selectAll$foundation_release();
            }
        } : null;
        TextToolbar textToolbar = this.textToolbar;
        if (textToolbar != null) {
            textToolbar.showMenu(getContentRect(), function0, function03, function02, function04);
        }
    }

    public final void hideSelectionToolbar$foundation_release() {
        TextToolbar textToolbar;
        TextToolbar textToolbar2 = this.textToolbar;
        if ((textToolbar2 != null ? textToolbar2.getStatus() : null) != TextToolbarStatus.Shown || (textToolbar = this.textToolbar) == null) {
            return;
        }
        textToolbar.hide();
    }

    public final boolean isTextChanged$foundation_release() {
        return !Intrinsics.areEqual(this.oldValue.getText(), getValue$foundation_release().getText());
    }

    private final Rect getContentRect() {
        float f;
        LayoutCoordinates layoutCoordinates;
        TextLayoutResult value;
        Rect cursorRect;
        LayoutCoordinates layoutCoordinates2;
        TextLayoutResult value2;
        Rect cursorRect2;
        LayoutCoordinates layoutCoordinates3;
        LayoutCoordinates layoutCoordinates4;
        TextFieldState textFieldState = this.state;
        if (textFieldState != null) {
            if (!(!textFieldState.isLayoutResultStale())) {
                textFieldState = null;
            }
            if (textFieldState != null) {
                int originalToTransformed = this.offsetMapping.originalToTransformed(TextRange.m1585getStartimpl(getValue$foundation_release().m1718getSelectiond9O1mEE()));
                int originalToTransformed2 = this.offsetMapping.originalToTransformed(TextRange.m1580getEndimpl(getValue$foundation_release().m1718getSelectiond9O1mEE()));
                TextFieldState textFieldState2 = this.state;
                long m721getZeroF1C5BW0 = (textFieldState2 == null || (layoutCoordinates4 = textFieldState2.getLayoutCoordinates()) == null) ? Offset.Companion.m721getZeroF1C5BW0() : layoutCoordinates4.mo1255localToRootMKHz9U(m415getHandlePositiontuRUvjQ$foundation_release(true));
                TextFieldState textFieldState3 = this.state;
                long m721getZeroF1C5BW02 = (textFieldState3 == null || (layoutCoordinates3 = textFieldState3.getLayoutCoordinates()) == null) ? Offset.Companion.m721getZeroF1C5BW0() : layoutCoordinates3.mo1255localToRootMKHz9U(m415getHandlePositiontuRUvjQ$foundation_release(false));
                TextFieldState textFieldState4 = this.state;
                float f2 = 0.0f;
                if (textFieldState4 == null || (layoutCoordinates2 = textFieldState4.getLayoutCoordinates()) == null) {
                    f = 0.0f;
                } else {
                    TextLayoutResultProxy layoutResult = textFieldState.getLayoutResult();
                    f = Offset.m710getYimpl(layoutCoordinates2.mo1255localToRootMKHz9U(OffsetKt.Offset(0.0f, (layoutResult == null || (value2 = layoutResult.getValue()) == null || (cursorRect2 = value2.getCursorRect(originalToTransformed)) == null) ? 0.0f : cursorRect2.getTop())));
                }
                TextFieldState textFieldState5 = this.state;
                if (textFieldState5 != null && (layoutCoordinates = textFieldState5.getLayoutCoordinates()) != null) {
                    TextLayoutResultProxy layoutResult2 = textFieldState.getLayoutResult();
                    f2 = Offset.m710getYimpl(layoutCoordinates.mo1255localToRootMKHz9U(OffsetKt.Offset(0.0f, (layoutResult2 == null || (value = layoutResult2.getValue()) == null || (cursorRect = value.getCursorRect(originalToTransformed2)) == null) ? 0.0f : cursorRect.getTop())));
                }
                return new Rect(Math.min(Offset.m709getXimpl(m721getZeroF1C5BW0), Offset.m709getXimpl(m721getZeroF1C5BW02)), Math.min(f, f2), Math.max(Offset.m709getXimpl(m721getZeroF1C5BW0), Offset.m709getXimpl(m721getZeroF1C5BW02)), Math.max(Offset.m710getYimpl(m721getZeroF1C5BW0), Offset.m710getYimpl(m721getZeroF1C5BW02)) + (Dp.m1897constructorimpl(25) * textFieldState.getTextDelegate().getDensity().getDensity()));
            }
        }
        return Rect.Companion.getZero();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateSelection(TextFieldValue textFieldValue, int i, int i2, boolean z, SelectionAdjustment selectionAdjustment) {
        TextLayoutResultProxy layoutResult;
        long TextRange = TextRangeKt.TextRange(this.offsetMapping.originalToTransformed(TextRange.m1585getStartimpl(textFieldValue.m1718getSelectiond9O1mEE())), this.offsetMapping.originalToTransformed(TextRange.m1580getEndimpl(textFieldValue.m1718getSelectiond9O1mEE())));
        TextFieldState textFieldState = this.state;
        long m406getTextFieldSelectionbb3KNj8 = TextFieldSelectionDelegateKt.m406getTextFieldSelectionbb3KNj8((textFieldState == null || (layoutResult = textFieldState.getLayoutResult()) == null) ? null : layoutResult.getValue(), i, i2, TextRange.m1579getCollapsedimpl(TextRange) ? null : TextRange.m1573boximpl(TextRange), z, selectionAdjustment);
        long TextRange2 = TextRangeKt.TextRange(this.offsetMapping.transformedToOriginal(TextRange.m1585getStartimpl(m406getTextFieldSelectionbb3KNj8)), this.offsetMapping.transformedToOriginal(TextRange.m1580getEndimpl(m406getTextFieldSelectionbb3KNj8)));
        if (TextRange.m1578equalsimpl0(TextRange2, textFieldValue.m1718getSelectiond9O1mEE())) {
            return;
        }
        HapticFeedback hapticFeedback = this.hapticFeedBack;
        if (hapticFeedback != null) {
            hapticFeedback.mo1097performHapticFeedbackCdsT49E(HapticFeedbackType.Companion.m1101getTextHandleMove5zf0vsI());
        }
        this.onValueChange.invoke(m409createTextFieldValueFDrldGo(textFieldValue.getAnnotatedString(), TextRange2));
        TextFieldState textFieldState2 = this.state;
        if (textFieldState2 != null) {
            textFieldState2.setShowSelectionHandleStart(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(this, true));
        }
        TextFieldState textFieldState3 = this.state;
        if (textFieldState3 == null) {
            return;
        }
        textFieldState3.setShowSelectionHandleEnd(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(this, false));
    }

    private final void setHandleState(HandleState handleState) {
        TextFieldState textFieldState = this.state;
        if (textFieldState != null) {
            textFieldState.setHandleState(handleState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: createTextFieldValue-FDrldGo  reason: not valid java name */
    public final TextFieldValue m409createTextFieldValueFDrldGo(AnnotatedString annotatedString, long j) {
        return new TextFieldValue(annotatedString, j, (TextRange) null, 4, (DefaultConstructorMarker) null);
    }
}
