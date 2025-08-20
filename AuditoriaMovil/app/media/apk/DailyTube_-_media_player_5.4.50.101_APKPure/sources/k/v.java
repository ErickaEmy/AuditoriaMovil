package k;

import android.widget.RatingBar;
/* loaded from: classes.dex */
public class v {

    /* loaded from: classes.dex */
    public class y implements RatingBar.OnRatingBarChangeListener {

        /* renamed from: n3  reason: collision with root package name */
        public final /* synthetic */ q9.v f9564n3;
        public final /* synthetic */ RatingBar.OnRatingBarChangeListener y;

        public y(RatingBar.OnRatingBarChangeListener onRatingBarChangeListener, q9.v vVar) {
            this.y = onRatingBarChangeListener;
            this.f9564n3 = vVar;
        }

        @Override // android.widget.RatingBar.OnRatingBarChangeListener
        public void onRatingChanged(RatingBar ratingBar, float f4, boolean z2) {
            RatingBar.OnRatingBarChangeListener onRatingBarChangeListener = this.y;
            if (onRatingBarChangeListener != null) {
                onRatingBarChangeListener.onRatingChanged(ratingBar, f4, z2);
            }
            this.f9564n3.y();
        }
    }

    public static void n3(RatingBar ratingBar, float f4) {
        if (ratingBar.getRating() != f4) {
            ratingBar.setRating(f4);
        }
    }

    public static void y(RatingBar ratingBar, RatingBar.OnRatingBarChangeListener onRatingBarChangeListener, q9.v vVar) {
        if (vVar == null) {
            ratingBar.setOnRatingBarChangeListener(onRatingBarChangeListener);
        } else {
            ratingBar.setOnRatingBarChangeListener(new y(onRatingBarChangeListener, vVar));
        }
    }
}
