package oz;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public abstract class zn extends y {

    /* renamed from: co  reason: collision with root package name */
    public int f12365co;

    /* renamed from: r  reason: collision with root package name */
    public LayoutInflater f12366r;

    /* renamed from: z  reason: collision with root package name */
    public int f12367z;

    @Deprecated
    public zn(Context context, int i, Cursor cursor, boolean z2) {
        super(context, cursor, z2);
        this.f12367z = i;
        this.f12365co = i;
        this.f12366r = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    @Override // oz.y
    public View fb(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f12366r.inflate(this.f12367z, viewGroup, false);
    }

    @Override // oz.y
    public View s(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f12366r.inflate(this.f12365co, viewGroup, false);
    }
}
