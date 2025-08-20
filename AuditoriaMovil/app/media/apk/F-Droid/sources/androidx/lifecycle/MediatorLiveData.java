package androidx.lifecycle;

import androidx.arch.core.internal.SafeIterableMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class MediatorLiveData extends MutableLiveData {
    private SafeIterableMap mSources = new SafeIterableMap();

    public void addSource(LiveData liveData, Observer observer) {
        if (liveData == null) {
            throw new NullPointerException("source cannot be null");
        }
        Source source = new Source(liveData, observer);
        Source source2 = (Source) this.mSources.putIfAbsent(liveData, source);
        if (source2 != null && source2.mObserver != observer) {
            throw new IllegalArgumentException("This source was already added with the different observer");
        }
        if (source2 == null && hasActiveObservers()) {
            source.plug();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.LiveData
    public void onActive() {
        Iterator it = this.mSources.iterator();
        while (it.hasNext()) {
            ((Source) ((Map.Entry) it.next()).getValue()).plug();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.LiveData
    public void onInactive() {
        Iterator it = this.mSources.iterator();
        while (it.hasNext()) {
            ((Source) ((Map.Entry) it.next()).getValue()).unplug();
        }
    }

    /* loaded from: classes.dex */
    private static class Source implements Observer {
        final LiveData mLiveData;
        final Observer mObserver;
        int mVersion = -1;

        Source(LiveData liveData, Observer observer) {
            this.mLiveData = liveData;
            this.mObserver = observer;
        }

        void plug() {
            this.mLiveData.observeForever(this);
        }

        void unplug() {
            this.mLiveData.removeObserver(this);
        }

        @Override // androidx.lifecycle.Observer
        public void onChanged(Object obj) {
            if (this.mVersion != this.mLiveData.getVersion()) {
                this.mVersion = this.mLiveData.getVersion();
                this.mObserver.onChanged(obj);
            }
        }
    }
}
