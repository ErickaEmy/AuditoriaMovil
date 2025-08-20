package androidx.compose.ui.focus;

import kotlin.jvm.functions.Function1;
/* compiled from: FocusProperties.kt */
/* loaded from: classes.dex */
public interface FocusProperties {
    boolean getCanFocus();

    FocusRequester getDown();

    FocusRequester getEnd();

    Function1 getEnter();

    Function1 getExit();

    FocusRequester getLeft();

    FocusRequester getNext();

    FocusRequester getPrevious();

    FocusRequester getRight();

    FocusRequester getStart();

    FocusRequester getUp();

    void setCanFocus(boolean z);

    /* compiled from: FocusProperties.kt */
    /* renamed from: androidx.compose.ui.focus.FocusProperties$-CC  reason: invalid class name */
    /* loaded from: classes.dex */
    public abstract /* synthetic */ class CC {
    }
}
