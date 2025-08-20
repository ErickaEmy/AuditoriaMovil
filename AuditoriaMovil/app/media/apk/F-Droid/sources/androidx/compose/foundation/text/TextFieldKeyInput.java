package androidx.compose.foundation.text;

import android.view.KeyEvent;
import androidx.compose.foundation.text.selection.TextFieldPreparedSelection;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.foundation.text.selection.TextPreparedSelectionState;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.CommitTextCommand;
import androidx.compose.ui.text.input.DeleteSurroundingTextCommand;
import androidx.compose.ui.text.input.EditCommand;
import androidx.compose.ui.text.input.EditProcessor;
import androidx.compose.ui.text.input.FinishComposingTextCommand;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import java.util.Collection;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$BooleanRef;
import org.bouncycastle.asn1.eac.EACTags;
/* compiled from: TextFieldKeyInput.kt */
/* loaded from: classes.dex */
public final class TextFieldKeyInput {
    private final boolean editable;
    private final int imeAction;
    private final DeadKeyCombiner keyCombiner;
    private final KeyMapping keyMapping;
    private final OffsetMapping offsetMapping;
    private final Function1 onValueChange;
    private final TextPreparedSelectionState preparedSelectionState;
    private final TextFieldSelectionManager selectionManager;
    private final boolean singleLine;
    private final TextFieldState state;
    private final UndoManager undoManager;
    private final TextFieldValue value;

    public /* synthetic */ TextFieldKeyInput(TextFieldState textFieldState, TextFieldSelectionManager textFieldSelectionManager, TextFieldValue textFieldValue, boolean z, boolean z2, TextPreparedSelectionState textPreparedSelectionState, OffsetMapping offsetMapping, UndoManager undoManager, DeadKeyCombiner deadKeyCombiner, KeyMapping keyMapping, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(textFieldState, textFieldSelectionManager, textFieldValue, z, z2, textPreparedSelectionState, offsetMapping, undoManager, deadKeyCombiner, keyMapping, function1, i);
    }

    public final TextFieldSelectionManager getSelectionManager() {
        return this.selectionManager;
    }

    public final boolean getSingleLine() {
        return this.singleLine;
    }

    public final TextFieldState getState() {
        return this.state;
    }

    public final UndoManager getUndoManager() {
        return this.undoManager;
    }

    private TextFieldKeyInput(TextFieldState state, TextFieldSelectionManager selectionManager, TextFieldValue value, boolean z, boolean z2, TextPreparedSelectionState preparedSelectionState, OffsetMapping offsetMapping, UndoManager undoManager, DeadKeyCombiner keyCombiner, KeyMapping keyMapping, Function1 onValueChange, int i) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(selectionManager, "selectionManager");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(preparedSelectionState, "preparedSelectionState");
        Intrinsics.checkNotNullParameter(offsetMapping, "offsetMapping");
        Intrinsics.checkNotNullParameter(keyCombiner, "keyCombiner");
        Intrinsics.checkNotNullParameter(keyMapping, "keyMapping");
        Intrinsics.checkNotNullParameter(onValueChange, "onValueChange");
        this.state = state;
        this.selectionManager = selectionManager;
        this.value = value;
        this.editable = z;
        this.singleLine = z2;
        this.preparedSelectionState = preparedSelectionState;
        this.offsetMapping = offsetMapping;
        this.undoManager = undoManager;
        this.keyCombiner = keyCombiner;
        this.keyMapping = keyMapping;
        this.onValueChange = onValueChange;
        this.imeAction = i;
    }

    public /* synthetic */ TextFieldKeyInput(TextFieldState textFieldState, TextFieldSelectionManager textFieldSelectionManager, TextFieldValue textFieldValue, boolean z, boolean z2, TextPreparedSelectionState textPreparedSelectionState, OffsetMapping offsetMapping, UndoManager undoManager, DeadKeyCombiner deadKeyCombiner, KeyMapping keyMapping, Function1 function1, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(textFieldState, textFieldSelectionManager, (i2 & 4) != 0 ? new TextFieldValue((String) null, 0L, (TextRange) null, 7, (DefaultConstructorMarker) null) : textFieldValue, (i2 & 8) != 0 ? true : z, (i2 & 16) != 0 ? false : z2, textPreparedSelectionState, (i2 & 64) != 0 ? OffsetMapping.Companion.getIdentity() : offsetMapping, (i2 & 128) != 0 ? null : undoManager, deadKeyCombiner, (i2 & 512) != 0 ? KeyMapping_androidKt.getPlatformDefaultKeyMapping() : keyMapping, (i2 & 1024) != 0 ? new Function1() { // from class: androidx.compose.foundation.text.TextFieldKeyInput.1
            public final void invoke(TextFieldValue it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((TextFieldValue) obj);
                return Unit.INSTANCE;
            }
        } : function1, i, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void apply(List list) {
        List mutableList;
        EditProcessor processor = this.state.getProcessor();
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) list);
        mutableList.add(0, new FinishComposingTextCommand());
        this.onValueChange.invoke(processor.apply(mutableList));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void apply(EditCommand editCommand) {
        List listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(editCommand);
        apply(listOf);
    }

    /* renamed from: typedCommand-ZmokQxo  reason: not valid java name */
    private final CommitTextCommand m339typedCommandZmokQxo(KeyEvent keyEvent) {
        Integer m288consumeZmokQxo;
        if (TextFieldKeyInput_androidKt.m343isTypedEventZmokQxo(keyEvent) && (m288consumeZmokQxo = this.keyCombiner.m288consumeZmokQxo(keyEvent)) != null) {
            String sb = StringHelpers_jvmKt.appendCodePointX(new StringBuilder(), m288consumeZmokQxo.intValue()).toString();
            Intrinsics.checkNotNullExpressionValue(sb, "StringBuilder().appendCo…ntX(codePoint).toString()");
            return new CommitTextCommand(sb, 1);
        }
        return null;
    }

    /* renamed from: process-ZmokQxo  reason: not valid java name */
    public final boolean m340processZmokQxo(KeyEvent event) {
        final KeyCommand mo290mapZmokQxo;
        Intrinsics.checkNotNullParameter(event, "event");
        CommitTextCommand m339typedCommandZmokQxo = m339typedCommandZmokQxo(event);
        if (m339typedCommandZmokQxo != null) {
            if (this.editable) {
                apply(m339typedCommandZmokQxo);
                this.preparedSelectionState.resetCachedX();
                return true;
            }
            return false;
        } else if (KeyEventType.m1139equalsimpl0(KeyEvent_androidKt.m1144getTypeZmokQxo(event), KeyEventType.Companion.m1140getKeyDownCS__XNY()) && (mo290mapZmokQxo = this.keyMapping.mo290mapZmokQxo(event)) != null && (!mo290mapZmokQxo.getEditsText() || this.editable)) {
            final Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
            ref$BooleanRef.element = true;
            commandExecutionContext(new Function1() { // from class: androidx.compose.foundation.text.TextFieldKeyInput$process$2

                /* compiled from: TextFieldKeyInput.kt */
                /* loaded from: classes.dex */
                public /* synthetic */ class WhenMappings {
                    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                    static {
                        int[] iArr = new int[KeyCommand.values().length];
                        try {
                            iArr[KeyCommand.COPY.ordinal()] = 1;
                        } catch (NoSuchFieldError unused) {
                        }
                        try {
                            iArr[KeyCommand.PASTE.ordinal()] = 2;
                        } catch (NoSuchFieldError unused2) {
                        }
                        try {
                            iArr[KeyCommand.CUT.ordinal()] = 3;
                        } catch (NoSuchFieldError unused3) {
                        }
                        try {
                            iArr[KeyCommand.LEFT_CHAR.ordinal()] = 4;
                        } catch (NoSuchFieldError unused4) {
                        }
                        try {
                            iArr[KeyCommand.RIGHT_CHAR.ordinal()] = 5;
                        } catch (NoSuchFieldError unused5) {
                        }
                        try {
                            iArr[KeyCommand.LEFT_WORD.ordinal()] = 6;
                        } catch (NoSuchFieldError unused6) {
                        }
                        try {
                            iArr[KeyCommand.RIGHT_WORD.ordinal()] = 7;
                        } catch (NoSuchFieldError unused7) {
                        }
                        try {
                            iArr[KeyCommand.PREV_PARAGRAPH.ordinal()] = 8;
                        } catch (NoSuchFieldError unused8) {
                        }
                        try {
                            iArr[KeyCommand.NEXT_PARAGRAPH.ordinal()] = 9;
                        } catch (NoSuchFieldError unused9) {
                        }
                        try {
                            iArr[KeyCommand.UP.ordinal()] = 10;
                        } catch (NoSuchFieldError unused10) {
                        }
                        try {
                            iArr[KeyCommand.DOWN.ordinal()] = 11;
                        } catch (NoSuchFieldError unused11) {
                        }
                        try {
                            iArr[KeyCommand.PAGE_UP.ordinal()] = 12;
                        } catch (NoSuchFieldError unused12) {
                        }
                        try {
                            iArr[KeyCommand.PAGE_DOWN.ordinal()] = 13;
                        } catch (NoSuchFieldError unused13) {
                        }
                        try {
                            iArr[KeyCommand.LINE_START.ordinal()] = 14;
                        } catch (NoSuchFieldError unused14) {
                        }
                        try {
                            iArr[KeyCommand.LINE_END.ordinal()] = 15;
                        } catch (NoSuchFieldError unused15) {
                        }
                        try {
                            iArr[KeyCommand.LINE_LEFT.ordinal()] = 16;
                        } catch (NoSuchFieldError unused16) {
                        }
                        try {
                            iArr[KeyCommand.LINE_RIGHT.ordinal()] = 17;
                        } catch (NoSuchFieldError unused17) {
                        }
                        try {
                            iArr[KeyCommand.HOME.ordinal()] = 18;
                        } catch (NoSuchFieldError unused18) {
                        }
                        try {
                            iArr[KeyCommand.END.ordinal()] = 19;
                        } catch (NoSuchFieldError unused19) {
                        }
                        try {
                            iArr[KeyCommand.DELETE_PREV_CHAR.ordinal()] = 20;
                        } catch (NoSuchFieldError unused20) {
                        }
                        try {
                            iArr[KeyCommand.DELETE_NEXT_CHAR.ordinal()] = 21;
                        } catch (NoSuchFieldError unused21) {
                        }
                        try {
                            iArr[KeyCommand.DELETE_PREV_WORD.ordinal()] = 22;
                        } catch (NoSuchFieldError unused22) {
                        }
                        try {
                            iArr[KeyCommand.DELETE_NEXT_WORD.ordinal()] = 23;
                        } catch (NoSuchFieldError unused23) {
                        }
                        try {
                            iArr[KeyCommand.DELETE_FROM_LINE_START.ordinal()] = 24;
                        } catch (NoSuchFieldError unused24) {
                        }
                        try {
                            iArr[KeyCommand.DELETE_TO_LINE_END.ordinal()] = 25;
                        } catch (NoSuchFieldError unused25) {
                        }
                        try {
                            iArr[KeyCommand.NEW_LINE.ordinal()] = 26;
                        } catch (NoSuchFieldError unused26) {
                        }
                        try {
                            iArr[KeyCommand.TAB.ordinal()] = 27;
                        } catch (NoSuchFieldError unused27) {
                        }
                        try {
                            iArr[KeyCommand.SELECT_ALL.ordinal()] = 28;
                        } catch (NoSuchFieldError unused28) {
                        }
                        try {
                            iArr[KeyCommand.SELECT_LEFT_CHAR.ordinal()] = 29;
                        } catch (NoSuchFieldError unused29) {
                        }
                        try {
                            iArr[KeyCommand.SELECT_RIGHT_CHAR.ordinal()] = 30;
                        } catch (NoSuchFieldError unused30) {
                        }
                        try {
                            iArr[KeyCommand.SELECT_LEFT_WORD.ordinal()] = 31;
                        } catch (NoSuchFieldError unused31) {
                        }
                        try {
                            iArr[KeyCommand.SELECT_RIGHT_WORD.ordinal()] = 32;
                        } catch (NoSuchFieldError unused32) {
                        }
                        try {
                            iArr[KeyCommand.SELECT_PREV_PARAGRAPH.ordinal()] = 33;
                        } catch (NoSuchFieldError unused33) {
                        }
                        try {
                            iArr[KeyCommand.SELECT_NEXT_PARAGRAPH.ordinal()] = 34;
                        } catch (NoSuchFieldError unused34) {
                        }
                        try {
                            iArr[KeyCommand.SELECT_LINE_START.ordinal()] = 35;
                        } catch (NoSuchFieldError unused35) {
                        }
                        try {
                            iArr[KeyCommand.SELECT_LINE_END.ordinal()] = 36;
                        } catch (NoSuchFieldError unused36) {
                        }
                        try {
                            iArr[KeyCommand.SELECT_LINE_LEFT.ordinal()] = 37;
                        } catch (NoSuchFieldError unused37) {
                        }
                        try {
                            iArr[KeyCommand.SELECT_LINE_RIGHT.ordinal()] = 38;
                        } catch (NoSuchFieldError unused38) {
                        }
                        try {
                            iArr[KeyCommand.SELECT_UP.ordinal()] = 39;
                        } catch (NoSuchFieldError unused39) {
                        }
                        try {
                            iArr[KeyCommand.SELECT_DOWN.ordinal()] = 40;
                        } catch (NoSuchFieldError unused40) {
                        }
                        try {
                            iArr[KeyCommand.SELECT_PAGE_UP.ordinal()] = 41;
                        } catch (NoSuchFieldError unused41) {
                        }
                        try {
                            iArr[KeyCommand.SELECT_PAGE_DOWN.ordinal()] = 42;
                        } catch (NoSuchFieldError unused42) {
                        }
                        try {
                            iArr[KeyCommand.SELECT_HOME.ordinal()] = 43;
                        } catch (NoSuchFieldError unused43) {
                        }
                        try {
                            iArr[KeyCommand.SELECT_END.ordinal()] = 44;
                        } catch (NoSuchFieldError unused44) {
                        }
                        try {
                            iArr[KeyCommand.DESELECT.ordinal()] = 45;
                        } catch (NoSuchFieldError unused45) {
                        }
                        try {
                            iArr[KeyCommand.UNDO.ordinal()] = 46;
                        } catch (NoSuchFieldError unused46) {
                        }
                        try {
                            iArr[KeyCommand.REDO.ordinal()] = 47;
                        } catch (NoSuchFieldError unused47) {
                        }
                        try {
                            iArr[KeyCommand.CHARACTER_PALETTE.ordinal()] = 48;
                        } catch (NoSuchFieldError unused48) {
                        }
                        $EnumSwitchMapping$0 = iArr;
                    }
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((TextFieldPreparedSelection) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(TextFieldPreparedSelection commandExecutionContext) {
                    int i;
                    TextFieldValue undo;
                    Function1 function1;
                    TextFieldValue redo;
                    Function1 function12;
                    Intrinsics.checkNotNullParameter(commandExecutionContext, "$this$commandExecutionContext");
                    switch (WhenMappings.$EnumSwitchMapping$0[KeyCommand.this.ordinal()]) {
                        case 1:
                            this.getSelectionManager().copy$foundation_release(false);
                            return;
                        case 2:
                            this.getSelectionManager().paste$foundation_release();
                            return;
                        case 3:
                            this.getSelectionManager().cut$foundation_release();
                            return;
                        case 4:
                            commandExecutionContext.collapseLeftOr(new Function1() { // from class: androidx.compose.foundation.text.TextFieldKeyInput$process$2.1
                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke((TextFieldPreparedSelection) obj);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(TextFieldPreparedSelection collapseLeftOr) {
                                    Intrinsics.checkNotNullParameter(collapseLeftOr, "$this$collapseLeftOr");
                                    collapseLeftOr.moveCursorLeft();
                                }
                            });
                            return;
                        case 5:
                            commandExecutionContext.collapseRightOr(new Function1() { // from class: androidx.compose.foundation.text.TextFieldKeyInput$process$2.2
                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke((TextFieldPreparedSelection) obj);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(TextFieldPreparedSelection collapseRightOr) {
                                    Intrinsics.checkNotNullParameter(collapseRightOr, "$this$collapseRightOr");
                                    collapseRightOr.moveCursorRight();
                                }
                            });
                            return;
                        case 6:
                            commandExecutionContext.moveCursorLeftByWord();
                            return;
                        case 7:
                            commandExecutionContext.moveCursorRightByWord();
                            return;
                        case 8:
                            commandExecutionContext.moveCursorPrevByParagraph();
                            return;
                        case 9:
                            commandExecutionContext.moveCursorNextByParagraph();
                            return;
                        case 10:
                            commandExecutionContext.moveCursorUpByLine();
                            return;
                        case 11:
                            commandExecutionContext.moveCursorDownByLine();
                            return;
                        case 12:
                            commandExecutionContext.moveCursorUpByPage();
                            return;
                        case 13:
                            commandExecutionContext.moveCursorDownByPage();
                            return;
                        case 14:
                            commandExecutionContext.moveCursorToLineStart();
                            return;
                        case 15:
                            commandExecutionContext.moveCursorToLineEnd();
                            return;
                        case 16:
                            commandExecutionContext.moveCursorToLineLeftSide();
                            return;
                        case 17:
                            commandExecutionContext.moveCursorToLineRightSide();
                            return;
                        case 18:
                            commandExecutionContext.moveCursorToHome();
                            return;
                        case 19:
                            commandExecutionContext.moveCursorToEnd();
                            return;
                        case 20:
                            List deleteIfSelectedOr = commandExecutionContext.deleteIfSelectedOr(new Function1() { // from class: androidx.compose.foundation.text.TextFieldKeyInput$process$2.3
                                @Override // kotlin.jvm.functions.Function1
                                public final EditCommand invoke(TextFieldPreparedSelection deleteIfSelectedOr2) {
                                    Intrinsics.checkNotNullParameter(deleteIfSelectedOr2, "$this$deleteIfSelectedOr");
                                    return new DeleteSurroundingTextCommand(TextRange.m1580getEndimpl(deleteIfSelectedOr2.m388getSelectiond9O1mEE()) - deleteIfSelectedOr2.getPrecedingCharacterIndex(), 0);
                                }
                            });
                            if (deleteIfSelectedOr != null) {
                                this.apply(deleteIfSelectedOr);
                                return;
                            }
                            return;
                        case 21:
                            List deleteIfSelectedOr2 = commandExecutionContext.deleteIfSelectedOr(new Function1() { // from class: androidx.compose.foundation.text.TextFieldKeyInput$process$2.4
                                @Override // kotlin.jvm.functions.Function1
                                public final EditCommand invoke(TextFieldPreparedSelection deleteIfSelectedOr3) {
                                    Intrinsics.checkNotNullParameter(deleteIfSelectedOr3, "$this$deleteIfSelectedOr");
                                    int nextCharacterIndex = deleteIfSelectedOr3.getNextCharacterIndex();
                                    if (nextCharacterIndex != -1) {
                                        return new DeleteSurroundingTextCommand(0, nextCharacterIndex - TextRange.m1580getEndimpl(deleteIfSelectedOr3.m388getSelectiond9O1mEE()));
                                    }
                                    return null;
                                }
                            });
                            if (deleteIfSelectedOr2 != null) {
                                this.apply(deleteIfSelectedOr2);
                                return;
                            }
                            return;
                        case 22:
                            List deleteIfSelectedOr3 = commandExecutionContext.deleteIfSelectedOr(new Function1() { // from class: androidx.compose.foundation.text.TextFieldKeyInput$process$2.5
                                @Override // kotlin.jvm.functions.Function1
                                public final EditCommand invoke(TextFieldPreparedSelection deleteIfSelectedOr4) {
                                    Intrinsics.checkNotNullParameter(deleteIfSelectedOr4, "$this$deleteIfSelectedOr");
                                    Integer previousWordOffset = deleteIfSelectedOr4.getPreviousWordOffset();
                                    if (previousWordOffset != null) {
                                        return new DeleteSurroundingTextCommand(TextRange.m1580getEndimpl(deleteIfSelectedOr4.m388getSelectiond9O1mEE()) - previousWordOffset.intValue(), 0);
                                    }
                                    return null;
                                }
                            });
                            if (deleteIfSelectedOr3 != null) {
                                this.apply(deleteIfSelectedOr3);
                                return;
                            }
                            return;
                        case 23:
                            List deleteIfSelectedOr4 = commandExecutionContext.deleteIfSelectedOr(new Function1() { // from class: androidx.compose.foundation.text.TextFieldKeyInput$process$2.6
                                @Override // kotlin.jvm.functions.Function1
                                public final EditCommand invoke(TextFieldPreparedSelection deleteIfSelectedOr5) {
                                    Intrinsics.checkNotNullParameter(deleteIfSelectedOr5, "$this$deleteIfSelectedOr");
                                    Integer nextWordOffset = deleteIfSelectedOr5.getNextWordOffset();
                                    if (nextWordOffset != null) {
                                        return new DeleteSurroundingTextCommand(0, nextWordOffset.intValue() - TextRange.m1580getEndimpl(deleteIfSelectedOr5.m388getSelectiond9O1mEE()));
                                    }
                                    return null;
                                }
                            });
                            if (deleteIfSelectedOr4 != null) {
                                this.apply(deleteIfSelectedOr4);
                                return;
                            }
                            return;
                        case 24:
                            List deleteIfSelectedOr5 = commandExecutionContext.deleteIfSelectedOr(new Function1() { // from class: androidx.compose.foundation.text.TextFieldKeyInput$process$2.7
                                @Override // kotlin.jvm.functions.Function1
                                public final EditCommand invoke(TextFieldPreparedSelection deleteIfSelectedOr6) {
                                    Intrinsics.checkNotNullParameter(deleteIfSelectedOr6, "$this$deleteIfSelectedOr");
                                    Integer lineStartByOffset = deleteIfSelectedOr6.getLineStartByOffset();
                                    if (lineStartByOffset != null) {
                                        return new DeleteSurroundingTextCommand(TextRange.m1580getEndimpl(deleteIfSelectedOr6.m388getSelectiond9O1mEE()) - lineStartByOffset.intValue(), 0);
                                    }
                                    return null;
                                }
                            });
                            if (deleteIfSelectedOr5 != null) {
                                this.apply(deleteIfSelectedOr5);
                                return;
                            }
                            return;
                        case 25:
                            List deleteIfSelectedOr6 = commandExecutionContext.deleteIfSelectedOr(new Function1() { // from class: androidx.compose.foundation.text.TextFieldKeyInput$process$2.8
                                @Override // kotlin.jvm.functions.Function1
                                public final EditCommand invoke(TextFieldPreparedSelection deleteIfSelectedOr7) {
                                    Intrinsics.checkNotNullParameter(deleteIfSelectedOr7, "$this$deleteIfSelectedOr");
                                    Integer lineEndByOffset = deleteIfSelectedOr7.getLineEndByOffset();
                                    if (lineEndByOffset != null) {
                                        return new DeleteSurroundingTextCommand(0, lineEndByOffset.intValue() - TextRange.m1580getEndimpl(deleteIfSelectedOr7.m388getSelectiond9O1mEE()));
                                    }
                                    return null;
                                }
                            });
                            if (deleteIfSelectedOr6 != null) {
                                this.apply(deleteIfSelectedOr6);
                                return;
                            }
                            return;
                        case 26:
                            if (!this.getSingleLine()) {
                                this.apply(new CommitTextCommand("\n", 1));
                                return;
                            }
                            Function1 onImeActionPerformed = this.getState().getOnImeActionPerformed();
                            i = this.imeAction;
                            onImeActionPerformed.invoke(ImeAction.m1675boximpl(i));
                            return;
                        case 27:
                            if (!this.getSingleLine()) {
                                this.apply(new CommitTextCommand("\t", 1));
                                return;
                            } else {
                                ref$BooleanRef.element = false;
                                return;
                            }
                        case 28:
                            commandExecutionContext.selectAll();
                            return;
                        case 29:
                            ((TextFieldPreparedSelection) commandExecutionContext.moveCursorLeft()).selectMovement();
                            return;
                        case 30:
                            ((TextFieldPreparedSelection) commandExecutionContext.moveCursorRight()).selectMovement();
                            return;
                        case 31:
                            ((TextFieldPreparedSelection) commandExecutionContext.moveCursorLeftByWord()).selectMovement();
                            return;
                        case 32:
                            ((TextFieldPreparedSelection) commandExecutionContext.moveCursorRightByWord()).selectMovement();
                            return;
                        case 33:
                            ((TextFieldPreparedSelection) commandExecutionContext.moveCursorPrevByParagraph()).selectMovement();
                            return;
                        case 34:
                            ((TextFieldPreparedSelection) commandExecutionContext.moveCursorNextByParagraph()).selectMovement();
                            return;
                        case 35:
                            ((TextFieldPreparedSelection) commandExecutionContext.moveCursorToLineStart()).selectMovement();
                            return;
                        case EACTags.APPLICATION_EXPIRATION_DATE /* 36 */:
                            ((TextFieldPreparedSelection) commandExecutionContext.moveCursorToLineEnd()).selectMovement();
                            return;
                        case EACTags.APPLICATION_EFFECTIVE_DATE /* 37 */:
                            ((TextFieldPreparedSelection) commandExecutionContext.moveCursorToLineLeftSide()).selectMovement();
                            return;
                        case EACTags.CARD_EFFECTIVE_DATE /* 38 */:
                            ((TextFieldPreparedSelection) commandExecutionContext.moveCursorToLineRightSide()).selectMovement();
                            return;
                        case EACTags.INTERCHANGE_CONTROL /* 39 */:
                            ((TextFieldPreparedSelection) commandExecutionContext.moveCursorUpByLine()).selectMovement();
                            return;
                        case 40:
                            ((TextFieldPreparedSelection) commandExecutionContext.moveCursorDownByLine()).selectMovement();
                            return;
                        case EACTags.INTERCHANGE_PROFILE /* 41 */:
                            commandExecutionContext.moveCursorUpByPage().selectMovement();
                            return;
                        case EACTags.CURRENCY_CODE /* 42 */:
                            commandExecutionContext.moveCursorDownByPage().selectMovement();
                            return;
                        case EACTags.DATE_OF_BIRTH /* 43 */:
                            ((TextFieldPreparedSelection) commandExecutionContext.moveCursorToHome()).selectMovement();
                            return;
                        case EACTags.CARDHOLDER_NATIONALITY /* 44 */:
                            ((TextFieldPreparedSelection) commandExecutionContext.moveCursorToEnd()).selectMovement();
                            return;
                        case EACTags.LANGUAGE_PREFERENCES /* 45 */:
                            commandExecutionContext.deselect();
                            return;
                        case 46:
                            UndoManager undoManager = this.getUndoManager();
                            if (undoManager != null) {
                                undoManager.makeSnapshot(commandExecutionContext.getValue());
                            }
                            UndoManager undoManager2 = this.getUndoManager();
                            if (undoManager2 == null || (undo = undoManager2.undo()) == null) {
                                return;
                            }
                            function1 = this.onValueChange;
                            function1.invoke(undo);
                            return;
                        case EACTags.PIN_USAGE_POLICY /* 47 */:
                            UndoManager undoManager3 = this.getUndoManager();
                            if (undoManager3 == null || (redo = undoManager3.redo()) == null) {
                                return;
                            }
                            function12 = this.onValueChange;
                            function12.invoke(redo);
                            return;
                        case 48:
                            KeyEventHelpers_androidKt.showCharacterPalette();
                            return;
                        default:
                            return;
                    }
                }
            });
            UndoManager undoManager = this.undoManager;
            if (undoManager != null) {
                undoManager.forceNextSnapshot();
            }
            return ref$BooleanRef.element;
        } else {
            return false;
        }
    }

    private final void commandExecutionContext(Function1 function1) {
        TextFieldPreparedSelection textFieldPreparedSelection = new TextFieldPreparedSelection(this.value, this.offsetMapping, this.state.getLayoutResult(), this.preparedSelectionState);
        function1.invoke(textFieldPreparedSelection);
        if (TextRange.m1578equalsimpl0(textFieldPreparedSelection.m388getSelectiond9O1mEE(), this.value.m1718getSelectiond9O1mEE()) && Intrinsics.areEqual(textFieldPreparedSelection.getAnnotatedString(), this.value.getAnnotatedString())) {
            return;
        }
        this.onValueChange.invoke(textFieldPreparedSelection.getValue());
    }
}
