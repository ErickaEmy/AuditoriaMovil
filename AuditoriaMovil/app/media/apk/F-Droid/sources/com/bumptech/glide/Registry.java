package com.bumptech.glide;

import androidx.core.util.Pools$Pool;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.data.DataRewinderRegistry;
import com.bumptech.glide.load.engine.DecodePath;
import com.bumptech.glide.load.engine.LoadPath;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.ModelLoaderRegistry;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.load.resource.transcode.TranscoderRegistry;
import com.bumptech.glide.provider.EncoderRegistry;
import com.bumptech.glide.provider.ImageHeaderParserRegistry;
import com.bumptech.glide.provider.LoadPathCache;
import com.bumptech.glide.provider.ModelToResourceClassCache;
import com.bumptech.glide.provider.ResourceDecoderRegistry;
import com.bumptech.glide.provider.ResourceEncoderRegistry;
import com.bumptech.glide.util.pool.FactoryPools;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class Registry {
    private final DataRewinderRegistry dataRewinderRegistry;
    private final ResourceDecoderRegistry decoderRegistry;
    private final EncoderRegistry encoderRegistry;
    private final ImageHeaderParserRegistry imageHeaderParserRegistry;
    private final ModelLoaderRegistry modelLoaderRegistry;
    private final ResourceEncoderRegistry resourceEncoderRegistry;
    private final Pools$Pool throwableListPool;
    private final TranscoderRegistry transcoderRegistry;
    private final ModelToResourceClassCache modelToResourceClassCache = new ModelToResourceClassCache();
    private final LoadPathCache loadPathCache = new LoadPathCache();

    public Registry() {
        Pools$Pool threadSafeList = FactoryPools.threadSafeList();
        this.throwableListPool = threadSafeList;
        this.modelLoaderRegistry = new ModelLoaderRegistry(threadSafeList);
        this.encoderRegistry = new EncoderRegistry();
        this.decoderRegistry = new ResourceDecoderRegistry();
        this.resourceEncoderRegistry = new ResourceEncoderRegistry();
        this.dataRewinderRegistry = new DataRewinderRegistry();
        this.transcoderRegistry = new TranscoderRegistry();
        this.imageHeaderParserRegistry = new ImageHeaderParserRegistry();
        setResourceDecoderBucketPriorityList(Arrays.asList("Animation", "Bitmap", "BitmapDrawable"));
    }

    public Registry append(Class cls, Encoder encoder) {
        this.encoderRegistry.append(cls, encoder);
        return this;
    }

    public Registry append(Class cls, Class cls2, ResourceDecoder resourceDecoder) {
        append("legacy_append", cls, cls2, resourceDecoder);
        return this;
    }

    public Registry append(String str, Class cls, Class cls2, ResourceDecoder resourceDecoder) {
        this.decoderRegistry.append(str, resourceDecoder, cls, cls2);
        return this;
    }

    public final Registry setResourceDecoderBucketPriorityList(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        arrayList.add("legacy_prepend_all");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add((String) it.next());
        }
        arrayList.add("legacy_append");
        this.decoderRegistry.setBucketPriorityList(arrayList);
        return this;
    }

    public Registry append(Class cls, ResourceEncoder resourceEncoder) {
        this.resourceEncoderRegistry.append(cls, resourceEncoder);
        return this;
    }

    public Registry register(DataRewinder.Factory factory) {
        this.dataRewinderRegistry.register(factory);
        return this;
    }

    public Registry register(Class cls, Class cls2, ResourceTranscoder resourceTranscoder) {
        this.transcoderRegistry.register(cls, cls2, resourceTranscoder);
        return this;
    }

    public Registry register(ImageHeaderParser imageHeaderParser) {
        this.imageHeaderParserRegistry.add(imageHeaderParser);
        return this;
    }

    public Registry append(Class cls, Class cls2, ModelLoaderFactory modelLoaderFactory) {
        this.modelLoaderRegistry.append(cls, cls2, modelLoaderFactory);
        return this;
    }

    public LoadPath getLoadPath(Class cls, Class cls2, Class cls3) {
        LoadPath loadPath = this.loadPathCache.get(cls, cls2, cls3);
        if (this.loadPathCache.isEmptyLoadPath(loadPath)) {
            return null;
        }
        if (loadPath == null) {
            List decodePaths = getDecodePaths(cls, cls2, cls3);
            loadPath = decodePaths.isEmpty() ? null : new LoadPath(cls, cls2, cls3, decodePaths, this.throwableListPool);
            this.loadPathCache.put(cls, cls2, cls3, loadPath);
        }
        return loadPath;
    }

    private List getDecodePaths(Class cls, Class cls2, Class cls3) {
        ArrayList arrayList = new ArrayList();
        for (Class cls4 : this.decoderRegistry.getResourceClasses(cls, cls2)) {
            for (Class cls5 : this.transcoderRegistry.getTranscodeClasses(cls4, cls3)) {
                arrayList.add(new DecodePath(cls, cls4, cls5, this.decoderRegistry.getDecoders(cls, cls4), this.transcoderRegistry.get(cls4, cls5), this.throwableListPool));
            }
        }
        return arrayList;
    }

    public List getRegisteredResourceClasses(Class cls, Class cls2, Class cls3) {
        List list = this.modelToResourceClassCache.get(cls, cls2, cls3);
        if (list == null) {
            list = new ArrayList();
            for (Class cls4 : this.modelLoaderRegistry.getDataClasses(cls)) {
                for (Class cls5 : this.decoderRegistry.getResourceClasses(cls4, cls2)) {
                    if (!this.transcoderRegistry.getTranscodeClasses(cls5, cls3).isEmpty() && !list.contains(cls5)) {
                        list.add(cls5);
                    }
                }
            }
            this.modelToResourceClassCache.put(cls, cls2, cls3, Collections.unmodifiableList(list));
        }
        return list;
    }

    public boolean isResourceEncoderAvailable(Resource resource) {
        return this.resourceEncoderRegistry.get(resource.getResourceClass()) != null;
    }

    public ResourceEncoder getResultEncoder(Resource resource) {
        ResourceEncoder resourceEncoder = this.resourceEncoderRegistry.get(resource.getResourceClass());
        if (resourceEncoder != null) {
            return resourceEncoder;
        }
        throw new NoResultEncoderAvailableException(resource.getResourceClass());
    }

    public Encoder getSourceEncoder(Object obj) {
        Encoder encoder = this.encoderRegistry.getEncoder(obj.getClass());
        if (encoder != null) {
            return encoder;
        }
        throw new NoSourceEncoderAvailableException(obj.getClass());
    }

    public DataRewinder getRewinder(Object obj) {
        return this.dataRewinderRegistry.build(obj);
    }

    public List getModelLoaders(Object obj) {
        return this.modelLoaderRegistry.getModelLoaders(obj);
    }

    public List getImageHeaderParsers() {
        List parsers = this.imageHeaderParserRegistry.getParsers();
        if (parsers.isEmpty()) {
            throw new NoImageHeaderParserException();
        }
        return parsers;
    }

    /* loaded from: classes.dex */
    public static class NoModelLoaderAvailableException extends MissingComponentException {
        public NoModelLoaderAvailableException(Object obj) {
            super("Failed to find any ModelLoaders registered for model class: " + obj.getClass());
        }

        public NoModelLoaderAvailableException(Object obj, List list) {
            super("Found ModelLoaders for model class: " + list + ", but none that handle this specific model instance: " + obj);
        }

        public NoModelLoaderAvailableException(Class cls, Class cls2) {
            super("Failed to find any ModelLoaders for model: " + cls + " and data: " + cls2);
        }
    }

    /* loaded from: classes.dex */
    public static class NoResultEncoderAvailableException extends MissingComponentException {
        public NoResultEncoderAvailableException(Class cls) {
            super("Failed to find result encoder for resource class: " + cls + ", you may need to consider registering a new Encoder for the requested type or DiskCacheStrategy.DATA/DiskCacheStrategy.NONE if caching your transformed resource is unnecessary.");
        }
    }

    /* loaded from: classes.dex */
    public static class NoSourceEncoderAvailableException extends MissingComponentException {
        public NoSourceEncoderAvailableException(Class cls) {
            super("Failed to find source encoder for data class: " + cls);
        }
    }

    /* loaded from: classes.dex */
    public static class MissingComponentException extends RuntimeException {
        public MissingComponentException(String str) {
            super(str);
        }
    }

    /* loaded from: classes.dex */
    public static final class NoImageHeaderParserException extends MissingComponentException {
        public NoImageHeaderParserException() {
            super("Failed to find image header parser.");
        }
    }
}
