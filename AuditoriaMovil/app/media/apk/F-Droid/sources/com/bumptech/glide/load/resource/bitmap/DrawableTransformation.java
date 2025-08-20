package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.security.MessageDigest;
/* loaded from: classes.dex */
public class DrawableTransformation implements Transformation {
    private final boolean isRequired;
    private final Transformation wrapped;

    public Transformation asBitmapDrawable() {
        return this;
    }

    public DrawableTransformation(Transformation transformation, boolean z) {
        this.wrapped = transformation;
        this.isRequired = z;
    }

    @Override // com.bumptech.glide.load.Transformation
    public Resource transform(Context context, Resource resource, int i, int i2) {
        BitmapPool bitmapPool = Glide.get(context).getBitmapPool();
        Drawable drawable = (Drawable) resource.get();
        Resource convert = DrawableToBitmapConverter.convert(bitmapPool, drawable, i, i2);
        if (convert != null) {
            Resource transform = this.wrapped.transform(context, convert, i, i2);
            if (transform.equals(convert)) {
                transform.recycle();
                return resource;
            }
            return newDrawableResource(context, transform);
        } else if (this.isRequired) {
            throw new IllegalArgumentException("Unable to convert " + drawable + " to a Bitmap");
        } else {
            return resource;
        }
    }

    private Resource newDrawableResource(Context context, Resource resource) {
        return LazyBitmapDrawableResource.obtain(context.getResources(), resource);
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (obj instanceof DrawableTransformation) {
            return this.wrapped.equals(((DrawableTransformation) obj).wrapped);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return this.wrapped.hashCode();
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        this.wrapped.updateDiskCacheKey(messageDigest);
    }
}
