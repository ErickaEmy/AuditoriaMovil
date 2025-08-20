package a7;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes.dex */
public class f extends RecyclerView.ta {

    /* renamed from: gv  reason: collision with root package name */
    public View.OnClickListener f24gv;

    /* renamed from: n3  reason: collision with root package name */
    public wz f25n3;

    /* renamed from: v  reason: collision with root package name */
    public View.OnLongClickListener f26v;
    public t y;

    /* renamed from: zn  reason: collision with root package name */
    public xc f27zn;

    /* loaded from: classes.dex */
    public class n3 implements View.OnLongClickListener {
        public n3() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(@NonNull View view) {
            if (f.this.f27zn != null && f.this.getAdapterPosition() != -1) {
                return f.this.f27zn.y(f.this.gv(), view);
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    public class y implements View.OnClickListener {
        public y() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(@NonNull View view) {
            if (f.this.f25n3 != null && f.this.getAdapterPosition() != -1) {
                f.this.f25n3.y(f.this.gv(), view);
            }
        }
    }

    public f(@NonNull View view) {
        super(view);
        this.f24gv = new y();
        this.f26v = new n3();
    }

    public void a() {
        if (this.f25n3 != null && this.y.en()) {
            this.itemView.setOnClickListener(null);
        }
        if (this.f27zn != null && this.y.u()) {
            this.itemView.setOnLongClickListener(null);
        }
        this.y = null;
        this.f25n3 = null;
        this.f27zn = null;
    }

    public t gv() {
        return this.y;
    }

    public View v() {
        return this.itemView;
    }

    public void zn(@NonNull t tVar, @Nullable wz wzVar, @Nullable xc xcVar) {
        this.y = tVar;
        if (wzVar != null && tVar.en()) {
            this.itemView.setOnClickListener(this.f24gv);
            this.f25n3 = wzVar;
        }
        if (xcVar != null && tVar.u()) {
            this.itemView.setOnLongClickListener(this.f26v);
            this.f27zn = xcVar;
        }
    }
}
