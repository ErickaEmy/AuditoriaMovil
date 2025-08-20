package kellinwood.security.zipsigner;

import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class ProgressHelper {
    private int progressTotalItems = 0;
    private int progressCurrentItem = 0;
    private ProgressEvent progressEvent = new ProgressEvent();
    private ArrayList<ProgressListener> listeners = new ArrayList<>();

    public int getProgressCurrentItem() {
        return this.progressCurrentItem;
    }

    public int getProgressTotalItems() {
        return this.progressTotalItems;
    }

    public void initProgress() {
        this.progressTotalItems = 10000;
        this.progressCurrentItem = 0;
    }

    public void setProgressCurrentItem(int i) {
        this.progressCurrentItem = i;
    }

    public void setProgressTotalItems(int i) {
        this.progressTotalItems = i;
    }

    public void progress(int i, String str) {
        int i2 = this.progressCurrentItem + 1;
        this.progressCurrentItem = i2;
        int i3 = this.progressTotalItems;
        int i4 = i3 == 0 ? 0 : (i2 * 100) / i3;
        Iterator<ProgressListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            this.progressEvent.setMessage(str);
            this.progressEvent.setPercentDone(i4);
            this.progressEvent.setPriority(i);
            it.next().onProgress(this.progressEvent);
        }
    }

    public synchronized void addProgressListener(ProgressListener progressListener) {
        ArrayList<ProgressListener> arrayList = (ArrayList) this.listeners.clone();
        arrayList.add(progressListener);
        this.listeners = arrayList;
    }

    public synchronized void removeProgressListener(ProgressListener progressListener) {
        ArrayList<ProgressListener> arrayList = (ArrayList) this.listeners.clone();
        arrayList.remove(progressListener);
        this.listeners = arrayList;
    }
}
