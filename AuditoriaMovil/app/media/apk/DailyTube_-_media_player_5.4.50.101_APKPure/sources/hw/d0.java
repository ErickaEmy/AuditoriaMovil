package hw;

import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.Sequence;
/* loaded from: classes.dex */
public final class d0 {

    /* loaded from: classes.dex */
    public static final class n3 implements Iterator<View>, KMappedMarker {

        /* renamed from: v  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f8937v;
        public int y;

        public n3(ViewGroup viewGroup) {
            this.f8937v = viewGroup;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.y < this.f8937v.getChildCount()) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        public void remove() {
            ViewGroup viewGroup = this.f8937v;
            int i = this.y - 1;
            this.y = i;
            viewGroup.removeViewAt(i);
        }

        @Override // java.util.Iterator
        /* renamed from: y */
        public View next() {
            ViewGroup viewGroup = this.f8937v;
            int i = this.y;
            this.y = i + 1;
            View childAt = viewGroup.getChildAt(i);
            if (childAt != null) {
                return childAt;
            }
            throw new IndexOutOfBoundsException();
        }
    }

    /* loaded from: classes.dex */
    public static final class y implements Sequence<View> {
        public final /* synthetic */ ViewGroup y;

        public y(ViewGroup viewGroup) {
            this.y = viewGroup;
        }

        @Override // kotlin.sequences.Sequence
        public Iterator<View> iterator() {
            return d0.n3(this.y);
        }
    }

    public static final Iterator<View> n3(ViewGroup viewGroup) {
        return new n3(viewGroup);
    }

    public static final Sequence<View> y(ViewGroup viewGroup) {
        return new y(viewGroup);
    }
}
