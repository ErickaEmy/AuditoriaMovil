package androidx.compose.foundation.text;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: KeyboardActions.kt */
/* loaded from: classes.dex */
public final class KeyboardActions {
    public static final Companion Companion = new Companion(null);
    private static final KeyboardActions Default = new KeyboardActions(null, null, null, null, null, null, 63, null);
    private final Function1 onDone;
    private final Function1 onGo;
    private final Function1 onNext;
    private final Function1 onPrevious;
    private final Function1 onSearch;
    private final Function1 onSend;

    public final Function1 getOnDone() {
        return this.onDone;
    }

    public final Function1 getOnGo() {
        return this.onGo;
    }

    public final Function1 getOnNext() {
        return this.onNext;
    }

    public final Function1 getOnPrevious() {
        return this.onPrevious;
    }

    public final Function1 getOnSearch() {
        return this.onSearch;
    }

    public final Function1 getOnSend() {
        return this.onSend;
    }

    public KeyboardActions(Function1 function1, Function1 function12, Function1 function13, Function1 function14, Function1 function15, Function1 function16) {
        this.onDone = function1;
        this.onGo = function12;
        this.onNext = function13;
        this.onPrevious = function14;
        this.onSearch = function15;
        this.onSend = function16;
    }

    public /* synthetic */ KeyboardActions(Function1 function1, Function1 function12, Function1 function13, Function1 function14, Function1 function15, Function1 function16, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : function1, (i & 2) != 0 ? null : function12, (i & 4) != 0 ? null : function13, (i & 8) != 0 ? null : function14, (i & 16) != 0 ? null : function15, (i & 32) != 0 ? null : function16);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof KeyboardActions) {
            KeyboardActions keyboardActions = (KeyboardActions) obj;
            return Intrinsics.areEqual(this.onDone, keyboardActions.onDone) && Intrinsics.areEqual(this.onGo, keyboardActions.onGo) && Intrinsics.areEqual(this.onNext, keyboardActions.onNext) && Intrinsics.areEqual(this.onPrevious, keyboardActions.onPrevious) && Intrinsics.areEqual(this.onSearch, keyboardActions.onSearch) && Intrinsics.areEqual(this.onSend, keyboardActions.onSend);
        }
        return false;
    }

    public int hashCode() {
        Function1 function1 = this.onDone;
        int hashCode = (function1 != null ? function1.hashCode() : 0) * 31;
        Function1 function12 = this.onGo;
        int hashCode2 = (hashCode + (function12 != null ? function12.hashCode() : 0)) * 31;
        Function1 function13 = this.onNext;
        int hashCode3 = (hashCode2 + (function13 != null ? function13.hashCode() : 0)) * 31;
        Function1 function14 = this.onPrevious;
        int hashCode4 = (hashCode3 + (function14 != null ? function14.hashCode() : 0)) * 31;
        Function1 function15 = this.onSearch;
        int hashCode5 = (hashCode4 + (function15 != null ? function15.hashCode() : 0)) * 31;
        Function1 function16 = this.onSend;
        return hashCode5 + (function16 != null ? function16.hashCode() : 0);
    }

    /* compiled from: KeyboardActions.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KeyboardActions getDefault() {
            return KeyboardActions.Default;
        }
    }
}
