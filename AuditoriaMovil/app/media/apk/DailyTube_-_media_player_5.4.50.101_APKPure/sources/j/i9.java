package j;

import android.widget.ListView;
import androidx.annotation.NonNull;
/* loaded from: classes.dex */
public class i9 extends y {

    /* renamed from: x  reason: collision with root package name */
    public final ListView f9314x;

    public i9(@NonNull ListView listView) {
        super(listView);
        this.f9314x = listView;
    }

    @Override // j.y
    public void i9(int i, int i5) {
        f.n3(this.f9314x, i5);
    }

    @Override // j.y
    public boolean n3(int i) {
        ListView listView = this.f9314x;
        int count = listView.getCount();
        if (count == 0) {
            return false;
        }
        int childCount = listView.getChildCount();
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        int i5 = firstVisiblePosition + childCount;
        if (i > 0) {
            if (i5 >= count && listView.getChildAt(childCount - 1).getBottom() <= listView.getHeight()) {
                return false;
            }
        } else if (i >= 0) {
            return false;
        } else {
            if (firstVisiblePosition <= 0 && listView.getChildAt(0).getTop() >= 0) {
                return false;
            }
        }
        return true;
    }

    @Override // j.y
    public boolean y(int i) {
        return false;
    }
}
