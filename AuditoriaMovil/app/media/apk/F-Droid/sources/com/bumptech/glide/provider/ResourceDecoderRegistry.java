package com.bumptech.glide.provider;

import com.bumptech.glide.load.ResourceDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class ResourceDecoderRegistry {
    private final List bucketPriorityList = new ArrayList();
    private final Map decoders = new HashMap();

    public synchronized void setBucketPriorityList(List list) {
        try {
            ArrayList<String> arrayList = new ArrayList(this.bucketPriorityList);
            this.bucketPriorityList.clear();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                this.bucketPriorityList.add((String) it.next());
            }
            for (String str : arrayList) {
                if (!list.contains(str)) {
                    this.bucketPriorityList.add(str);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized List getDecoders(Class cls, Class cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (String str : this.bucketPriorityList) {
            List<Entry> list = (List) this.decoders.get(str);
            if (list != null) {
                for (Entry entry : list) {
                    if (entry.handles(cls, cls2)) {
                        arrayList.add(entry.decoder);
                    }
                }
            }
        }
        return arrayList;
    }

    public synchronized List getResourceClasses(Class cls, Class cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (String str : this.bucketPriorityList) {
            List<Entry> list = (List) this.decoders.get(str);
            if (list != null) {
                for (Entry entry : list) {
                    if (entry.handles(cls, cls2) && !arrayList.contains(entry.resourceClass)) {
                        arrayList.add(entry.resourceClass);
                    }
                }
            }
        }
        return arrayList;
    }

    public synchronized void append(String str, ResourceDecoder resourceDecoder, Class cls, Class cls2) {
        getOrAddEntryList(str).add(new Entry(cls, cls2, resourceDecoder));
    }

    private synchronized List getOrAddEntryList(String str) {
        List list;
        try {
            if (!this.bucketPriorityList.contains(str)) {
                this.bucketPriorityList.add(str);
            }
            list = (List) this.decoders.get(str);
            if (list == null) {
                list = new ArrayList();
                this.decoders.put(str, list);
            }
        } catch (Throwable th) {
            throw th;
        }
        return list;
    }

    /* loaded from: classes.dex */
    private static class Entry {
        private final Class dataClass;
        final ResourceDecoder decoder;
        final Class resourceClass;

        public Entry(Class cls, Class cls2, ResourceDecoder resourceDecoder) {
            this.dataClass = cls;
            this.resourceClass = cls2;
            this.decoder = resourceDecoder;
        }

        public boolean handles(Class cls, Class cls2) {
            return this.dataClass.isAssignableFrom(cls) && cls2.isAssignableFrom(this.resourceClass);
        }
    }
}
