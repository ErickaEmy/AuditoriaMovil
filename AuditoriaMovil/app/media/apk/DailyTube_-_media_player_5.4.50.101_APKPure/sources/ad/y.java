package ad;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import hw.i4;
/* loaded from: classes.dex */
public final class y extends RecyclerView.ta {
    public y(@NonNull FrameLayout frameLayout) {
        super(frameLayout);
    }

    @NonNull
    public static y y(@NonNull ViewGroup viewGroup) {
        FrameLayout frameLayout = new FrameLayout(viewGroup.getContext());
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        frameLayout.setId(i4.tl());
        frameLayout.setSaveEnabled(false);
        return new y(frameLayout);
    }

    @NonNull
    public FrameLayout n3() {
        return (FrameLayout) this.itemView;
    }
}
