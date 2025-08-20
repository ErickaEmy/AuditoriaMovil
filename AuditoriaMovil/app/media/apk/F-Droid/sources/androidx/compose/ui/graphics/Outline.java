package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRect;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Outline.kt */
/* loaded from: classes.dex */
public abstract class Outline {
    private Outline() {
    }

    public /* synthetic */ Outline(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* compiled from: Outline.kt */
    /* loaded from: classes.dex */
    public static final class Rectangle extends Outline {
        private final Rect rect;

        public final Rect getRect() {
            return this.rect;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Rectangle(Rect rect) {
            super(null);
            Intrinsics.checkNotNullParameter(rect, "rect");
            this.rect = rect;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Rectangle) && Intrinsics.areEqual(this.rect, ((Rectangle) obj).rect);
        }

        public int hashCode() {
            return this.rect.hashCode();
        }
    }

    /* compiled from: Outline.kt */
    /* loaded from: classes.dex */
    public static final class Rounded extends Outline {
        private final RoundRect roundRect;
        private final Path roundRectPath;

        public final RoundRect getRoundRect() {
            return this.roundRect;
        }

        public final Path getRoundRectPath$ui_graphics_release() {
            return this.roundRectPath;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Rounded(RoundRect roundRect) {
            super(null);
            Intrinsics.checkNotNullParameter(roundRect, "roundRect");
            Path path = null;
            this.roundRect = roundRect;
            if (!OutlineKt.access$hasSameCornerRadius(roundRect)) {
                path = AndroidPath_androidKt.Path();
                path.addRoundRect(roundRect);
            }
            this.roundRectPath = path;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Rounded) && Intrinsics.areEqual(this.roundRect, ((Rounded) obj).roundRect);
        }

        public int hashCode() {
            return this.roundRect.hashCode();
        }
    }

    /* compiled from: Outline.kt */
    /* loaded from: classes.dex */
    public static final class Generic extends Outline {
        private final Path path;

        public final Path getPath() {
            return this.path;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Generic(Path path) {
            super(null);
            Intrinsics.checkNotNullParameter(path, "path");
            this.path = path;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Generic) && Intrinsics.areEqual(this.path, ((Generic) obj).path);
        }

        public int hashCode() {
            return this.path.hashCode();
        }
    }
}
