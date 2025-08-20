package androidx.core.graphics.drawable;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.versionedparcelable.CustomVersionedParcelable;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;
import vl.s;
/* loaded from: classes.dex */
public class IconCompat extends CustomVersionedParcelable {

    /* renamed from: f  reason: collision with root package name */
    public static final PorterDuff.Mode f2328f = PorterDuff.Mode.SRC_IN;

    /* renamed from: a  reason: collision with root package name */
    public int f2329a;
    @Nullable

    /* renamed from: c5  reason: collision with root package name */
    public String f2330c5;
    @Nullable

    /* renamed from: fb  reason: collision with root package name */
    public ColorStateList f2331fb;
    @Nullable

    /* renamed from: gv  reason: collision with root package name */
    public Parcelable f2332gv;
    @Nullable

    /* renamed from: i9  reason: collision with root package name */
    public String f2333i9;

    /* renamed from: n3  reason: collision with root package name */
    public Object f2334n3;

    /* renamed from: s  reason: collision with root package name */
    public PorterDuff.Mode f2335s;

    /* renamed from: v  reason: collision with root package name */
    public int f2336v;
    public int y;
    @Nullable

    /* renamed from: zn  reason: collision with root package name */
    public byte[] f2337zn;

    /* loaded from: classes.dex */
    public static class gv {
        public static Icon y(Uri uri) {
            return Icon.createWithAdaptiveBitmapContentUri(uri);
        }
    }

    /* loaded from: classes.dex */
    public static class n3 {
        public static Icon n3(Bitmap bitmap) {
            return Icon.createWithAdaptiveBitmap(bitmap);
        }

        public static Drawable y(Drawable drawable, Drawable drawable2) {
            return new AdaptiveIconDrawable(drawable, drawable2);
        }
    }

    /* loaded from: classes.dex */
    public static class y {
        public static Drawable a(Icon icon, Context context) {
            return icon.loadDrawable(context);
        }

        public static Icon fb(IconCompat iconCompat, Context context) {
            Icon createWithBitmap;
            switch (iconCompat.y) {
                case -1:
                    return (Icon) iconCompat.f2334n3;
                case 0:
                default:
                    throw new IllegalArgumentException("Unknown type");
                case 1:
                    createWithBitmap = Icon.createWithBitmap((Bitmap) iconCompat.f2334n3);
                    break;
                case 2:
                    createWithBitmap = Icon.createWithResource(iconCompat.wz(), iconCompat.f2336v);
                    break;
                case 3:
                    createWithBitmap = Icon.createWithData((byte[]) iconCompat.f2334n3, iconCompat.f2336v, iconCompat.f2329a);
                    break;
                case 4:
                    createWithBitmap = Icon.createWithContentUri((String) iconCompat.f2334n3);
                    break;
                case 5:
                    if (Build.VERSION.SDK_INT >= 26) {
                        createWithBitmap = n3.n3((Bitmap) iconCompat.f2334n3);
                        break;
                    } else {
                        createWithBitmap = Icon.createWithBitmap(IconCompat.zn((Bitmap) iconCompat.f2334n3, false));
                        break;
                    }
                case 6:
                    int i = Build.VERSION.SDK_INT;
                    if (i >= 30) {
                        createWithBitmap = gv.y(iconCompat.w());
                        break;
                    } else if (context != null) {
                        InputStream p2 = iconCompat.p(context);
                        if (p2 != null) {
                            if (i >= 26) {
                                createWithBitmap = n3.n3(BitmapFactory.decodeStream(p2));
                                break;
                            } else {
                                createWithBitmap = Icon.createWithBitmap(IconCompat.zn(BitmapFactory.decodeStream(p2), false));
                                break;
                            }
                        } else {
                            throw new IllegalStateException("Cannot load adaptive icon from uri: " + iconCompat.w());
                        }
                    } else {
                        throw new IllegalArgumentException("Context is required to resolve the file uri of the icon: " + iconCompat.w());
                    }
            }
            ColorStateList colorStateList = iconCompat.f2331fb;
            if (colorStateList != null) {
                createWithBitmap.setTintList(colorStateList);
            }
            PorterDuff.Mode mode = iconCompat.f2335s;
            if (mode != IconCompat.f2328f) {
                createWithBitmap.setTintMode(mode);
            }
            return createWithBitmap;
        }

        public static int gv(@NonNull Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return zn.zn(obj);
            }
            try {
                return ((Integer) obj.getClass().getMethod("getType", null).invoke(obj, null)).intValue();
            } catch (IllegalAccessException e2) {
                Log.e("IconCompat", "Unable to get icon type " + obj, e2);
                return -1;
            } catch (NoSuchMethodException e3) {
                Log.e("IconCompat", "Unable to get icon type " + obj, e3);
                return -1;
            } catch (InvocationTargetException e5) {
                Log.e("IconCompat", "Unable to get icon type " + obj, e5);
                return -1;
            }
        }

        public static int n3(@NonNull Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return zn.y(obj);
            }
            try {
                return ((Integer) obj.getClass().getMethod("getResId", null).invoke(obj, null)).intValue();
            } catch (IllegalAccessException e2) {
                Log.e("IconCompat", "Unable to get icon resource", e2);
                return 0;
            } catch (NoSuchMethodException e3) {
                Log.e("IconCompat", "Unable to get icon resource", e3);
                return 0;
            } catch (InvocationTargetException e5) {
                Log.e("IconCompat", "Unable to get icon resource", e5);
                return 0;
            }
        }

        @Nullable
        public static Uri v(@NonNull Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return zn.gv(obj);
            }
            try {
                return (Uri) obj.getClass().getMethod("getUri", null).invoke(obj, null);
            } catch (IllegalAccessException e2) {
                Log.e("IconCompat", "Unable to get icon uri", e2);
                return null;
            } catch (NoSuchMethodException e3) {
                Log.e("IconCompat", "Unable to get icon uri", e3);
                return null;
            } catch (InvocationTargetException e5) {
                Log.e("IconCompat", "Unable to get icon uri", e5);
                return null;
            }
        }

        public static IconCompat y(@NonNull Object obj) {
            s.fb(obj);
            int gv2 = gv(obj);
            if (gv2 != 2) {
                if (gv2 != 4) {
                    if (gv2 != 6) {
                        IconCompat iconCompat = new IconCompat(-1);
                        iconCompat.f2334n3 = obj;
                        return iconCompat;
                    }
                    return IconCompat.v(v(obj));
                }
                return IconCompat.s(v(obj));
            }
            return IconCompat.f(null, zn(obj), n3(obj));
        }

        @Nullable
        public static String zn(@NonNull Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return zn.n3(obj);
            }
            try {
                return (String) obj.getClass().getMethod("getResPackage", null).invoke(obj, null);
            } catch (IllegalAccessException e2) {
                Log.e("IconCompat", "Unable to get icon package", e2);
                return null;
            } catch (NoSuchMethodException e3) {
                Log.e("IconCompat", "Unable to get icon package", e3);
                return null;
            } catch (InvocationTargetException e5) {
                Log.e("IconCompat", "Unable to get icon package", e5);
                return null;
            }
        }
    }

    /* loaded from: classes.dex */
    public static class zn {
        public static Uri gv(Object obj) {
            return ((Icon) obj).getUri();
        }

        public static String n3(Object obj) {
            return ((Icon) obj).getResPackage();
        }

        public static int y(Object obj) {
            return ((Icon) obj).getResId();
        }

        public static int zn(Object obj) {
            return ((Icon) obj).getType();
        }
    }

    public IconCompat() {
        this.y = -1;
        this.f2335s = f2328f;
    }

    @NonNull
    public static IconCompat a(@NonNull String str) {
        vl.zn.zn(str);
        IconCompat iconCompat = new IconCompat(6);
        iconCompat.f2334n3 = str;
        return iconCompat;
    }

    @NonNull
    public static IconCompat c5(@NonNull String str) {
        vl.zn.zn(str);
        IconCompat iconCompat = new IconCompat(4);
        iconCompat.f2334n3 = str;
        return iconCompat;
    }

    @NonNull
    public static IconCompat f(@Nullable Resources resources, @NonNull String str, int i) {
        vl.zn.zn(str);
        if (i != 0) {
            IconCompat iconCompat = new IconCompat(2);
            iconCompat.f2336v = i;
            if (resources != null) {
                try {
                    iconCompat.f2334n3 = resources.getResourceName(i);
                } catch (Resources.NotFoundException unused) {
                    throw new IllegalArgumentException("Icon resource cannot be found");
                }
            } else {
                iconCompat.f2334n3 = str;
            }
            iconCompat.f2333i9 = str;
            return iconCompat;
        }
        throw new IllegalArgumentException("Drawable resource ID must not be 0");
    }

    @NonNull
    public static IconCompat fb(@NonNull Bitmap bitmap) {
        vl.zn.zn(bitmap);
        IconCompat iconCompat = new IconCompat(1);
        iconCompat.f2334n3 = bitmap;
        return iconCompat;
    }

    @NonNull
    public static IconCompat gv(@NonNull Bitmap bitmap) {
        vl.zn.zn(bitmap);
        IconCompat iconCompat = new IconCompat(5);
        iconCompat.f2334n3 = bitmap;
        return iconCompat;
    }

    public static String i4(int i) {
        switch (i) {
            case 1:
                return "BITMAP";
            case 2:
                return "RESOURCE";
            case 3:
                return "DATA";
            case 4:
                return "URI";
            case 5:
                return "BITMAP_MASKABLE";
            case 6:
                return "URI_MASKABLE";
            default:
                return "UNKNOWN";
        }
    }

    @NonNull
    public static IconCompat i9(@NonNull Context context, int i) {
        vl.zn.zn(context);
        return f(context.getResources(), context.getPackageName(), i);
    }

    @Nullable
    public static IconCompat n3(@NonNull Icon icon) {
        if (y.gv(icon) == 2 && y.n3(icon) == 0) {
            return null;
        }
        return y.y(icon);
    }

    @NonNull
    public static IconCompat s(@NonNull Uri uri) {
        vl.zn.zn(uri);
        return c5(uri.toString());
    }

    @NonNull
    public static IconCompat v(@NonNull Uri uri) {
        vl.zn.zn(uri);
        return a(uri.toString());
    }

    @Nullable
    public static IconCompat y(@NonNull Icon icon) {
        return y.y(icon);
    }

    public static Bitmap zn(Bitmap bitmap, boolean z2) {
        int min = (int) (Math.min(bitmap.getWidth(), bitmap.getHeight()) * 0.6666667f);
        Bitmap createBitmap = Bitmap.createBitmap(min, min, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(3);
        float f4 = min;
        float f6 = 0.5f * f4;
        float f9 = 0.9166667f * f6;
        if (z2) {
            float f10 = 0.010416667f * f4;
            paint.setColor(0);
            paint.setShadowLayer(f10, 0.0f, f4 * 0.020833334f, 1023410176);
            canvas.drawCircle(f6, f6, f9, paint);
            paint.setShadowLayer(f10, 0.0f, 0.0f, 503316480);
            canvas.drawCircle(f6, f6, f9, paint);
            paint.clearShadowLayer();
        }
        paint.setColor(-16777216);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        Matrix matrix = new Matrix();
        matrix.setTranslate((-(bitmap.getWidth() - min)) / 2.0f, (-(bitmap.getHeight() - min)) / 2.0f);
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        canvas.drawCircle(f6, f6, f9, paint);
        canvas.setBitmap(null);
        return createBitmap;
    }

    public void co(boolean z2) {
        this.f2330c5 = this.f2335s.name();
        switch (this.y) {
            case -1:
                if (!z2) {
                    this.f2332gv = (Parcelable) this.f2334n3;
                    return;
                }
                throw new IllegalArgumentException("Can't serialize Icon created with IconCompat#createFromIcon");
            case 0:
            default:
                return;
            case 1:
            case 5:
                if (z2) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    ((Bitmap) this.f2334n3).compress(Bitmap.CompressFormat.PNG, 90, byteArrayOutputStream);
                    this.f2337zn = byteArrayOutputStream.toByteArray();
                    return;
                }
                this.f2332gv = (Parcelable) this.f2334n3;
                return;
            case 2:
                this.f2337zn = ((String) this.f2334n3).getBytes(Charset.forName("UTF-16"));
                return;
            case 3:
                this.f2337zn = (byte[]) this.f2334n3;
                return;
            case 4:
            case 6:
                this.f2337zn = this.f2334n3.toString().getBytes(Charset.forName("UTF-16"));
                return;
        }
    }

    public void mt() {
        this.f2335s = PorterDuff.Mode.valueOf(this.f2330c5);
        switch (this.y) {
            case -1:
                Parcelable parcelable = this.f2332gv;
                if (parcelable != null) {
                    this.f2334n3 = parcelable;
                    return;
                }
                throw new IllegalArgumentException("Invalid icon");
            case 0:
            default:
                return;
            case 1:
            case 5:
                Parcelable parcelable2 = this.f2332gv;
                if (parcelable2 != null) {
                    this.f2334n3 = parcelable2;
                    return;
                }
                byte[] bArr = this.f2337zn;
                this.f2334n3 = bArr;
                this.y = 3;
                this.f2336v = 0;
                this.f2329a = bArr.length;
                return;
            case 2:
            case 4:
            case 6:
                String str = new String(this.f2337zn, Charset.forName("UTF-16"));
                this.f2334n3 = str;
                if (this.y == 2 && this.f2333i9 == null) {
                    this.f2333i9 = str.split(":", -1)[0];
                    return;
                }
                return;
            case 3:
                this.f2334n3 = this.f2337zn;
                return;
        }
    }

    @Nullable
    public InputStream p(@NonNull Context context) {
        Uri w4 = w();
        String scheme = w4.getScheme();
        if (!"content".equals(scheme) && !"file".equals(scheme)) {
            try {
                return new FileInputStream(new File((String) this.f2334n3));
            } catch (FileNotFoundException e2) {
                Log.w("IconCompat", "Unable to load image from path: " + w4, e2);
                return null;
            }
        }
        try {
            return context.getContentResolver().openInputStream(w4);
        } catch (Exception e3) {
            Log.w("IconCompat", "Unable to load image from URI: " + w4, e3);
            return null;
        }
    }

    @NonNull
    @Deprecated
    public Icon r() {
        return x4(null);
    }

    @Nullable
    public Bitmap t() {
        int i = this.y;
        if (i == -1 && Build.VERSION.SDK_INT >= 23) {
            Object obj = this.f2334n3;
            if (obj instanceof Bitmap) {
                return (Bitmap) obj;
            }
            return null;
        } else if (i == 1) {
            return (Bitmap) this.f2334n3;
        } else {
            if (i == 5) {
                return zn((Bitmap) this.f2334n3, true);
            }
            throw new IllegalStateException("called getBitmap() on " + this);
        }
    }

    public int tl() {
        int i = this.y;
        if (i == -1 && Build.VERSION.SDK_INT >= 23) {
            return y.n3(this.f2334n3);
        }
        if (i == 2) {
            return this.f2336v;
        }
        throw new IllegalStateException("called getResId() on " + this);
    }

    @NonNull
    public String toString() {
        if (this.y == -1) {
            return String.valueOf(this.f2334n3);
        }
        StringBuilder sb = new StringBuilder("Icon(typ=");
        sb.append(i4(this.y));
        switch (this.y) {
            case 1:
            case 5:
                sb.append(" size=");
                sb.append(((Bitmap) this.f2334n3).getWidth());
                sb.append("x");
                sb.append(((Bitmap) this.f2334n3).getHeight());
                break;
            case 2:
                sb.append(" pkg=");
                sb.append(this.f2333i9);
                sb.append(" id=");
                sb.append(String.format("0x%08x", Integer.valueOf(tl())));
                break;
            case 3:
                sb.append(" len=");
                sb.append(this.f2336v);
                if (this.f2329a != 0) {
                    sb.append(" off=");
                    sb.append(this.f2329a);
                    break;
                }
                break;
            case 4:
            case 6:
                sb.append(" uri=");
                sb.append(this.f2334n3);
                break;
        }
        if (this.f2331fb != null) {
            sb.append(" tint=");
            sb.append(this.f2331fb);
        }
        if (this.f2335s != f2328f) {
            sb.append(" mode=");
            sb.append(this.f2335s);
        }
        sb.append(")");
        return sb.toString();
    }

    @NonNull
    public Uri w() {
        int i = this.y;
        if (i == -1 && Build.VERSION.SDK_INT >= 23) {
            return y.v(this.f2334n3);
        }
        if (i != 4 && i != 6) {
            throw new IllegalStateException("called getUri() on " + this);
        }
        return Uri.parse((String) this.f2334n3);
    }

    @NonNull
    public String wz() {
        int i = this.y;
        if (i == -1 && Build.VERSION.SDK_INT >= 23) {
            return y.zn(this.f2334n3);
        }
        if (i == 2) {
            String str = this.f2333i9;
            if (str != null && !TextUtils.isEmpty(str)) {
                return this.f2333i9;
            }
            return ((String) this.f2334n3).split(":", -1)[0];
        }
        throw new IllegalStateException("called getResPackage() on " + this);
    }

    @NonNull
    public Icon x4(@Nullable Context context) {
        if (Build.VERSION.SDK_INT >= 23) {
            return y.fb(this, context);
        }
        throw new UnsupportedOperationException("This method is only supported on API level 23+");
    }

    public int xc() {
        int i = this.y;
        if (i == -1 && Build.VERSION.SDK_INT >= 23) {
            return y.gv(this.f2334n3);
        }
        return i;
    }

    @NonNull
    public Bundle z() {
        Bundle bundle = new Bundle();
        switch (this.y) {
            case -1:
                bundle.putParcelable("obj", (Parcelable) this.f2334n3);
                break;
            case 0:
            default:
                throw new IllegalArgumentException("Invalid icon");
            case 1:
            case 5:
                bundle.putParcelable("obj", (Bitmap) this.f2334n3);
                break;
            case 2:
            case 4:
            case 6:
                bundle.putString("obj", (String) this.f2334n3);
                break;
            case 3:
                bundle.putByteArray("obj", (byte[]) this.f2334n3);
                break;
        }
        bundle.putInt("type", this.y);
        bundle.putInt("int1", this.f2336v);
        bundle.putInt("int2", this.f2329a);
        bundle.putString("string1", this.f2333i9);
        ColorStateList colorStateList = this.f2331fb;
        if (colorStateList != null) {
            bundle.putParcelable("tint_list", colorStateList);
        }
        PorterDuff.Mode mode = this.f2335s;
        if (mode != f2328f) {
            bundle.putString("tint_mode", mode.name());
        }
        return bundle;
    }

    public IconCompat(int i) {
        this.f2335s = f2328f;
        this.y = i;
    }
}
