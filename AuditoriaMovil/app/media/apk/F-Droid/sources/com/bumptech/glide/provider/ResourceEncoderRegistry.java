package com.bumptech.glide.provider;

import com.bumptech.glide.load.ResourceEncoder;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ResourceEncoderRegistry {
    private final List encoders = new ArrayList();

    public synchronized void append(Class cls, ResourceEncoder resourceEncoder) {
        this.encoders.add(new Entry(cls, resourceEncoder));
    }

    public synchronized ResourceEncoder get(Class cls) {
        int size = this.encoders.size();
        for (int i = 0; i < size; i++) {
            Entry entry = (Entry) this.encoders.get(i);
            if (entry.handles(cls)) {
                return entry.encoder;
            }
        }
        return null;
    }

    /* loaded from: classes.dex */
    private static final class Entry {
        final ResourceEncoder encoder;
        private final Class resourceClass;

        Entry(Class cls, ResourceEncoder resourceEncoder) {
            this.resourceClass = cls;
            this.encoder = resourceEncoder;
        }

        boolean handles(Class cls) {
            return this.resourceClass.isAssignableFrom(cls);
        }
    }
}
