package qg;

import androidx.fragment.app.Fragment;
import java.util.LinkedHashSet;
/* loaded from: classes.dex */
public abstract class s<S> extends Fragment {

    /* renamed from: fb  reason: collision with root package name */
    public final LinkedHashSet<fb<S>> f12827fb = new LinkedHashSet<>();

    public void cp() {
        this.f12827fb.clear();
    }

    public boolean ja(fb<S> fbVar) {
        return this.f12827fb.add(fbVar);
    }
}
