package wz;

import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.appcompat.widget.SearchView;
import androidx.core.app.NotificationCompat;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public class a8 extends oz.zn implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public int f14665b;

    /* renamed from: c  reason: collision with root package name */
    public final Context f14666c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f14667d;

    /* renamed from: d0  reason: collision with root package name */
    public final WeakHashMap<String, Drawable.ConstantState> f14668d0;

    /* renamed from: ej  reason: collision with root package name */
    public int f14669ej;

    /* renamed from: f3  reason: collision with root package name */
    public final SearchView f14670f3;

    /* renamed from: fh  reason: collision with root package name */
    public final int f14671fh;

    /* renamed from: j  reason: collision with root package name */
    public int f14672j;

    /* renamed from: j5  reason: collision with root package name */
    public int f14673j5;

    /* renamed from: n  reason: collision with root package name */
    public final SearchableInfo f14674n;

    /* renamed from: o  reason: collision with root package name */
    public int f14675o;

    /* renamed from: oz  reason: collision with root package name */
    public int f14676oz;

    /* renamed from: qn  reason: collision with root package name */
    public int f14677qn;

    /* renamed from: x  reason: collision with root package name */
    public ColorStateList f14678x;

    /* loaded from: classes.dex */
    public static final class y {

        /* renamed from: gv  reason: collision with root package name */
        public final ImageView f14679gv;

        /* renamed from: n3  reason: collision with root package name */
        public final TextView f14680n3;

        /* renamed from: v  reason: collision with root package name */
        public final ImageView f14681v;
        public final TextView y;

        /* renamed from: zn  reason: collision with root package name */
        public final ImageView f14682zn;

        public y(View view) {
            this.y = (TextView) view.findViewById(16908308);
            this.f14680n3 = (TextView) view.findViewById(16908309);
            this.f14682zn = (ImageView) view.findViewById(16908295);
            this.f14679gv = (ImageView) view.findViewById(16908296);
            this.f14681v = (ImageView) view.findViewById(R$id.f752p);
        }
    }

    public a8(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap<String, Drawable.ConstantState> weakHashMap) {
        super(context, searchView.getSuggestionRowLayout(), null, true);
        this.f14667d = false;
        this.f14669ej = 1;
        this.f14665b = -1;
        this.f14673j5 = -1;
        this.f14677qn = -1;
        this.f14675o = -1;
        this.f14672j = -1;
        this.f14676oz = -1;
        this.f14670f3 = searchView;
        this.f14674n = searchableInfo;
        this.f14671fh = searchView.getSuggestionCommitIconResId();
        this.f14666c = context;
        this.f14668d0 = weakHashMap;
    }

    public static String f3(Cursor cursor, int i) {
        if (i == -1) {
            return null;
        }
        try {
            return cursor.getString(i);
        } catch (Exception e2) {
            Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", e2);
            return null;
        }
    }

    public static String xc(Cursor cursor, String str) {
        return f3(cursor, cursor.getColumnIndex(str));
    }

    public final void c(ImageView imageView, Drawable drawable, int i) {
        imageView.setImageDrawable(drawable);
        if (drawable == null) {
            imageView.setVisibility(i);
            return;
        }
        imageView.setVisibility(0);
        drawable.setVisible(false, false);
        drawable.setVisible(true, false);
    }

    public Drawable co(Uri uri) throws FileNotFoundException {
        int parseInt;
        String authority = uri.getAuthority();
        if (!TextUtils.isEmpty(authority)) {
            try {
                Resources resourcesForApplication = this.f14666c.getPackageManager().getResourcesForApplication(authority);
                List<String> pathSegments = uri.getPathSegments();
                if (pathSegments != null) {
                    int size = pathSegments.size();
                    if (size == 1) {
                        try {
                            parseInt = Integer.parseInt(pathSegments.get(0));
                        } catch (NumberFormatException unused) {
                            throw new FileNotFoundException("Single path segment is not a resource ID: " + uri);
                        }
                    } else if (size == 2) {
                        parseInt = resourcesForApplication.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
                    } else {
                        throw new FileNotFoundException("More than two path segments: " + uri);
                    }
                    if (parseInt != 0) {
                        return resourcesForApplication.getDrawable(parseInt);
                    }
                    throw new FileNotFoundException("No resource found for: " + uri);
                }
                throw new FileNotFoundException("No path: " + uri);
            } catch (PackageManager.NameNotFoundException unused2) {
                throw new FileNotFoundException("No package found for authority: " + uri);
            }
        }
        throw new FileNotFoundException("No authority: " + uri);
    }

    public final void d0(TextView textView, CharSequence charSequence) {
        textView.setText(charSequence);
        if (TextUtils.isEmpty(charSequence)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    public final Drawable f(String str) {
        Drawable.ConstantState constantState = this.f14668d0.get(str);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable();
    }

    public final void fh(String str, Drawable drawable) {
        if (drawable != null) {
            this.f14668d0.put(str, drawable.getConstantState());
        }
    }

    @Override // oz.y, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        try {
            return super.getDropDownView(i, view, viewGroup);
        } catch (RuntimeException e2) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e2);
            View fb2 = fb(this.f14666c, gv(), viewGroup);
            if (fb2 != null) {
                ((y) fb2.getTag()).y.setText(e2.toString());
            }
            return fb2;
        }
    }

    @Override // oz.y, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i, view, viewGroup);
        } catch (RuntimeException e2) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e2);
            View s2 = s(this.f14666c, gv(), viewGroup);
            if (s2 != null) {
                ((y) s2.getTag()).y.setText(e2.toString());
            }
            return s2;
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return false;
    }

    public Cursor i4(SearchableInfo searchableInfo, String str, int i) {
        String suggestAuthority;
        String[] strArr = null;
        if (searchableInfo == null || (suggestAuthority = searchableInfo.getSuggestAuthority()) == null) {
            return null;
        }
        Uri.Builder fragment = new Uri.Builder().scheme("content").authority(suggestAuthority).query("").fragment("");
        String suggestPath = searchableInfo.getSuggestPath();
        if (suggestPath != null) {
            fragment.appendEncodedPath(suggestPath);
        }
        fragment.appendPath("search_suggest_query");
        String suggestSelection = searchableInfo.getSuggestSelection();
        if (suggestSelection != null) {
            strArr = new String[]{str};
        } else {
            fragment.appendPath(str);
        }
        String[] strArr2 = strArr;
        if (i > 0) {
            fragment.appendQueryParameter("limit", String.valueOf(i));
        }
        return this.f14666c.getContentResolver().query(fragment.build(), null, suggestSelection, strArr2, null);
    }

    public void n(int i) {
        this.f14669ej = i;
    }

    @Override // oz.y, oz.n3.y
    public CharSequence n3(Cursor cursor) {
        String xc2;
        String xc3;
        if (cursor == null) {
            return null;
        }
        String xc4 = xc(cursor, "suggest_intent_query");
        if (xc4 != null) {
            return xc4;
        }
        if (this.f14674n.shouldRewriteQueryFromData() && (xc3 = xc(cursor, "suggest_intent_data")) != null) {
            return xc3;
        }
        if (!this.f14674n.shouldRewriteQueryFromText() || (xc2 = xc(cursor, "suggest_text_1")) == null) {
            return null;
        }
        return xc2;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        rz(gv());
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        rz(gv());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.f14670f3.oz((CharSequence) tag);
        }
    }

    public final Drawable p(Uri uri) {
        try {
            if ("android.resource".equals(uri.getScheme())) {
                try {
                    return co(uri);
                } catch (Resources.NotFoundException unused) {
                    throw new FileNotFoundException("Resource does not exist: " + uri);
                }
            }
            InputStream openInputStream = this.f14666c.getContentResolver().openInputStream(uri);
            if (openInputStream != null) {
                Drawable createFromStream = Drawable.createFromStream(openInputStream, null);
                try {
                    openInputStream.close();
                } catch (IOException e2) {
                    Log.e("SuggestionsAdapter", "Error closing icon stream for " + uri, e2);
                }
                return createFromStream;
            }
            throw new FileNotFoundException("Failed to open " + uri);
        } catch (FileNotFoundException e3) {
            Log.w("SuggestionsAdapter", "Icon not found: " + uri + ", " + e3.getMessage());
            return null;
        }
        Log.w("SuggestionsAdapter", "Icon not found: " + uri + ", " + e3.getMessage());
        return null;
    }

    public final Drawable r(Cursor cursor) {
        int i = this.f14675o;
        if (i == -1) {
            return null;
        }
        Drawable z2 = z(cursor.getString(i));
        if (z2 != null) {
            return z2;
        }
        return w();
    }

    public final void rz(Cursor cursor) {
        Bundle bundle;
        if (cursor != null) {
            bundle = cursor.getExtras();
        } else {
            bundle = null;
        }
        if (bundle != null) {
            bundle.getBoolean("in_progress");
        }
    }

    @Override // oz.zn, oz.y
    public View s(Context context, Cursor cursor, ViewGroup viewGroup) {
        View s2 = super.s(context, cursor, viewGroup);
        s2.setTag(new y(s2));
        ((ImageView) s2.findViewById(R$id.f752p)).setImageResource(this.f14671fh);
        return s2;
    }

    public final CharSequence t(CharSequence charSequence) {
        if (this.f14678x == null) {
            TypedValue typedValue = new TypedValue();
            this.f14666c.getTheme().resolveAttribute(R$attr.f641k5, typedValue, true);
            this.f14678x = this.f14666c.getResources().getColorStateList(typedValue.resourceId);
        }
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new TextAppearanceSpan(null, 0, 0, this.f14678x, null), 0, charSequence.length(), 33);
        return spannableString;
    }

    public final Drawable tl(ComponentName componentName) {
        PackageManager packageManager = this.f14666c.getPackageManager();
        try {
            ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, NotificationCompat.FLAG_HIGH_PRIORITY);
            int iconResource = activityInfo.getIconResource();
            if (iconResource == 0) {
                return null;
            }
            Drawable drawable = packageManager.getDrawable(componentName.getPackageName(), iconResource, activityInfo.applicationInfo);
            if (drawable == null) {
                Log.w("SuggestionsAdapter", "Invalid icon resource " + iconResource + " for " + componentName.flattenToShortString());
                return null;
            }
            return drawable;
        } catch (PackageManager.NameNotFoundException e2) {
            Log.w("SuggestionsAdapter", e2.toString());
            return null;
        }
    }

    @Override // oz.y
    public void v(View view, Context context, Cursor cursor) {
        int i;
        CharSequence f32;
        y yVar = (y) view.getTag();
        int i5 = this.f14676oz;
        if (i5 != -1) {
            i = cursor.getInt(i5);
        } else {
            i = 0;
        }
        if (yVar.y != null) {
            d0(yVar.y, f3(cursor, this.f14665b));
        }
        if (yVar.f14680n3 != null) {
            String f33 = f3(cursor, this.f14677qn);
            if (f33 != null) {
                f32 = t(f33);
            } else {
                f32 = f3(cursor, this.f14673j5);
            }
            if (TextUtils.isEmpty(f32)) {
                TextView textView = yVar.y;
                if (textView != null) {
                    textView.setSingleLine(false);
                    yVar.y.setMaxLines(2);
                }
            } else {
                TextView textView2 = yVar.y;
                if (textView2 != null) {
                    textView2.setSingleLine(true);
                    yVar.y.setMaxLines(1);
                }
            }
            d0(yVar.f14680n3, f32);
        }
        ImageView imageView = yVar.f14682zn;
        if (imageView != null) {
            c(imageView, r(cursor), 4);
        }
        ImageView imageView2 = yVar.f14679gv;
        if (imageView2 != null) {
            c(imageView2, x4(cursor), 8);
        }
        int i6 = this.f14669ej;
        if (i6 != 2 && (i6 != 1 || (i & 1) == 0)) {
            yVar.f14681v.setVisibility(8);
            return;
        }
        yVar.f14681v.setVisibility(0);
        yVar.f14681v.setTag(yVar.y.getText());
        yVar.f14681v.setOnClickListener(this);
    }

    public final Drawable w() {
        Drawable wz2 = wz(this.f14674n.getSearchActivity());
        if (wz2 != null) {
            return wz2;
        }
        return this.f14666c.getPackageManager().getDefaultActivityIcon();
    }

    public final Drawable wz(ComponentName componentName) {
        String flattenToShortString = componentName.flattenToShortString();
        Drawable.ConstantState constantState = null;
        if (this.f14668d0.containsKey(flattenToShortString)) {
            Drawable.ConstantState constantState2 = this.f14668d0.get(flattenToShortString);
            if (constantState2 == null) {
                return null;
            }
            return constantState2.newDrawable(this.f14666c.getResources());
        }
        Drawable tl2 = tl(componentName);
        if (tl2 != null) {
            constantState = tl2.getConstantState();
        }
        this.f14668d0.put(flattenToShortString, constantState);
        return tl2;
    }

    public final Drawable x4(Cursor cursor) {
        int i = this.f14672j;
        if (i == -1) {
            return null;
        }
        return z(cursor.getString(i));
    }

    @Override // oz.y, oz.n3.y
    public void y(Cursor cursor) {
        if (this.f14667d) {
            Log.w("SuggestionsAdapter", "Tried to change cursor after adapter was closed.");
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        try {
            super.y(cursor);
            if (cursor != null) {
                this.f14665b = cursor.getColumnIndex("suggest_text_1");
                this.f14673j5 = cursor.getColumnIndex("suggest_text_2");
                this.f14677qn = cursor.getColumnIndex("suggest_text_2_url");
                this.f14675o = cursor.getColumnIndex("suggest_icon_1");
                this.f14672j = cursor.getColumnIndex("suggest_icon_2");
                this.f14676oz = cursor.getColumnIndex("suggest_flags");
            }
        } catch (Exception e2) {
            Log.e("SuggestionsAdapter", "error changing cursor and caching columns", e2);
        }
    }

    public final Drawable z(String str) {
        if (str == null || str.isEmpty() || "0".equals(str)) {
            return null;
        }
        try {
            int parseInt = Integer.parseInt(str);
            String str2 = "android.resource://" + this.f14666c.getPackageName() + "/" + parseInt;
            Drawable f4 = f(str2);
            if (f4 != null) {
                return f4;
            }
            Drawable v2 = mg.y.v(this.f14666c, parseInt);
            fh(str2, v2);
            return v2;
        } catch (Resources.NotFoundException unused) {
            Log.w("SuggestionsAdapter", "Icon resource not found: " + str);
            return null;
        } catch (NumberFormatException unused2) {
            Drawable f6 = f(str);
            if (f6 != null) {
                return f6;
            }
            Drawable p2 = p(Uri.parse(str));
            fh(str, p2);
            return p2;
        }
    }

    @Override // oz.n3.y
    public Cursor zn(CharSequence charSequence) {
        String charSequence2;
        if (charSequence == null) {
            charSequence2 = "";
        } else {
            charSequence2 = charSequence.toString();
        }
        if (this.f14670f3.getVisibility() == 0 && this.f14670f3.getWindowVisibility() == 0) {
            try {
                Cursor i42 = i4(this.f14674n, charSequence2, 50);
                if (i42 != null) {
                    i42.getCount();
                    return i42;
                }
            } catch (RuntimeException e2) {
                Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", e2);
            }
        }
        return null;
    }
}
