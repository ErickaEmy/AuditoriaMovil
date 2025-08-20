package com.bumptech.glide.load.engine;

import androidx.core.util.Pools$Pool;
import ch.qos.logback.core.CoreConstants;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.engine.DecodePath;
import com.bumptech.glide.util.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes.dex */
public class LoadPath {
    private final Class dataClass;
    private final List decodePaths;
    private final String failureMessage;
    private final Pools$Pool listPool;

    public LoadPath(Class cls, Class cls2, Class cls3, List list, Pools$Pool pools$Pool) {
        this.dataClass = cls;
        this.listPool = pools$Pool;
        this.decodePaths = (List) Preconditions.checkNotEmpty(list);
        this.failureMessage = "Failed LoadPath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    public Resource load(DataRewinder dataRewinder, Options options, int i, int i2, DecodePath.DecodeCallback decodeCallback) {
        List list = (List) Preconditions.checkNotNull(this.listPool.acquire());
        try {
            return loadWithExceptionList(dataRewinder, options, i, i2, decodeCallback, list);
        } finally {
            this.listPool.release(list);
        }
    }

    private Resource loadWithExceptionList(DataRewinder dataRewinder, Options options, int i, int i2, DecodePath.DecodeCallback decodeCallback, List list) {
        int size = this.decodePaths.size();
        Resource resource = null;
        for (int i3 = 0; i3 < size; i3++) {
            try {
                resource = ((DecodePath) this.decodePaths.get(i3)).decode(dataRewinder, i, i2, options, decodeCallback);
            } catch (GlideException e) {
                list.add(e);
            }
            if (resource != null) {
                break;
            }
        }
        if (resource != null) {
            return resource;
        }
        throw new GlideException(this.failureMessage, new ArrayList(list));
    }

    public String toString() {
        return "LoadPath{decodePaths=" + Arrays.toString(this.decodePaths.toArray()) + CoreConstants.CURLY_RIGHT;
    }
}
