package androidx.compose.ui.text.font;

import androidx.compose.runtime.State;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: FontFamilyResolver.kt */
/* loaded from: classes.dex */
public interface TypefaceResult extends State {
    boolean getCacheable();

    /* compiled from: FontFamilyResolver.kt */
    /* loaded from: classes.dex */
    public static final class Immutable implements TypefaceResult {
        private final boolean cacheable;
        private final Object value;

        @Override // androidx.compose.ui.text.font.TypefaceResult
        public boolean getCacheable() {
            return this.cacheable;
        }

        @Override // androidx.compose.runtime.State
        public Object getValue() {
            return this.value;
        }

        public Immutable(Object value, boolean z) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
            this.cacheable = z;
        }

        public /* synthetic */ Immutable(Object obj, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(obj, (i & 2) != 0 ? true : z);
        }
    }

    /* compiled from: FontFamilyResolver.kt */
    /* loaded from: classes.dex */
    public static final class Async implements TypefaceResult, State {
        private final AsyncFontListLoader current;

        @Override // androidx.compose.runtime.State
        public Object getValue() {
            return this.current.getValue();
        }

        public Async(AsyncFontListLoader current) {
            Intrinsics.checkNotNullParameter(current, "current");
            this.current = current;
        }

        @Override // androidx.compose.ui.text.font.TypefaceResult
        public boolean getCacheable() {
            return this.current.getCacheable$ui_text_release();
        }
    }
}
