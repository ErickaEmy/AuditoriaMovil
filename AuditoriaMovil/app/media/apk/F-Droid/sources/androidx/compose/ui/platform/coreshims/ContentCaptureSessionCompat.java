package androidx.compose.ui.platform.coreshims;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStructure;
import android.view.autofill.AutofillId;
import android.view.contentcapture.ContentCaptureSession;
import java.util.List;
import java.util.Objects;
/* loaded from: classes.dex */
public class ContentCaptureSessionCompat {
    private final View mView;
    private final Object mWrappedObj;

    /* loaded from: classes.dex */
    private static class Api34Impl {
        static void notifyViewsAppeared(ContentCaptureSession contentCaptureSession, List<ViewStructure> list) {
        }
    }

    public static ContentCaptureSessionCompat toContentCaptureSessionCompat(ContentCaptureSession contentCaptureSession, View view) {
        return new ContentCaptureSessionCompat(contentCaptureSession, view);
    }

    private ContentCaptureSessionCompat(ContentCaptureSession contentCaptureSession, View view) {
        this.mWrappedObj = contentCaptureSession;
        this.mView = view;
    }

    public AutofillId newAutofillId(long j) {
        if (Build.VERSION.SDK_INT >= 29) {
            ContentCaptureSession m = ContentCaptureSessionCompat$$ExternalSyntheticApiModelOutline0.m(this.mWrappedObj);
            AutofillIdCompat autofillId = ViewCompatShims.getAutofillId(this.mView);
            Objects.requireNonNull(autofillId);
            return Api29Impl.newAutofillId(m, autofillId.toAutofillId(), j);
        }
        return null;
    }

    public ViewStructureCompat newVirtualViewStructure(AutofillId autofillId, long j) {
        if (Build.VERSION.SDK_INT >= 29) {
            return ViewStructureCompat.toViewStructureCompat(Api29Impl.newVirtualViewStructure(ContentCaptureSessionCompat$$ExternalSyntheticApiModelOutline0.m(this.mWrappedObj), autofillId, j));
        }
        return null;
    }

    public void notifyViewsAppeared(List list) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 34) {
            Api34Impl.notifyViewsAppeared(ContentCaptureSessionCompat$$ExternalSyntheticApiModelOutline0.m(this.mWrappedObj), list);
        } else if (i >= 29) {
            ViewStructure newViewStructure = Api29Impl.newViewStructure(ContentCaptureSessionCompat$$ExternalSyntheticApiModelOutline0.m(this.mWrappedObj), this.mView);
            Api23Impl.getExtras(newViewStructure).putBoolean("TREAT_AS_VIEW_TREE_APPEARING", true);
            Api29Impl.notifyViewAppeared(ContentCaptureSessionCompat$$ExternalSyntheticApiModelOutline0.m(this.mWrappedObj), newViewStructure);
            for (int i2 = 0; i2 < list.size(); i2++) {
                Api29Impl.notifyViewAppeared(ContentCaptureSessionCompat$$ExternalSyntheticApiModelOutline0.m(this.mWrappedObj), (ViewStructure) list.get(i2));
            }
            ViewStructure newViewStructure2 = Api29Impl.newViewStructure(ContentCaptureSessionCompat$$ExternalSyntheticApiModelOutline0.m(this.mWrappedObj), this.mView);
            Api23Impl.getExtras(newViewStructure2).putBoolean("TREAT_AS_VIEW_TREE_APPEARED", true);
            Api29Impl.notifyViewAppeared(ContentCaptureSessionCompat$$ExternalSyntheticApiModelOutline0.m(this.mWrappedObj), newViewStructure2);
        }
    }

    public void notifyViewsDisappeared(long[] jArr) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 34) {
            ContentCaptureSession m = ContentCaptureSessionCompat$$ExternalSyntheticApiModelOutline0.m(this.mWrappedObj);
            AutofillIdCompat autofillId = ViewCompatShims.getAutofillId(this.mView);
            Objects.requireNonNull(autofillId);
            Api29Impl.notifyViewsDisappeared(m, autofillId.toAutofillId(), jArr);
        } else if (i >= 29) {
            ViewStructure newViewStructure = Api29Impl.newViewStructure(ContentCaptureSessionCompat$$ExternalSyntheticApiModelOutline0.m(this.mWrappedObj), this.mView);
            Api23Impl.getExtras(newViewStructure).putBoolean("TREAT_AS_VIEW_TREE_APPEARING", true);
            Api29Impl.notifyViewAppeared(ContentCaptureSessionCompat$$ExternalSyntheticApiModelOutline0.m(this.mWrappedObj), newViewStructure);
            ContentCaptureSession m2 = ContentCaptureSessionCompat$$ExternalSyntheticApiModelOutline0.m(this.mWrappedObj);
            AutofillIdCompat autofillId2 = ViewCompatShims.getAutofillId(this.mView);
            Objects.requireNonNull(autofillId2);
            Api29Impl.notifyViewsDisappeared(m2, autofillId2.toAutofillId(), jArr);
            ViewStructure newViewStructure2 = Api29Impl.newViewStructure(ContentCaptureSessionCompat$$ExternalSyntheticApiModelOutline0.m(this.mWrappedObj), this.mView);
            Api23Impl.getExtras(newViewStructure2).putBoolean("TREAT_AS_VIEW_TREE_APPEARED", true);
            Api29Impl.notifyViewAppeared(ContentCaptureSessionCompat$$ExternalSyntheticApiModelOutline0.m(this.mWrappedObj), newViewStructure2);
        }
    }

    public void notifyViewTextChanged(AutofillId autofillId, CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 29) {
            Api29Impl.notifyViewTextChanged(ContentCaptureSessionCompat$$ExternalSyntheticApiModelOutline0.m(this.mWrappedObj), autofillId, charSequence);
        }
    }

    /* loaded from: classes.dex */
    private static class Api29Impl {
        static void notifyViewsDisappeared(ContentCaptureSession contentCaptureSession, AutofillId autofillId, long[] jArr) {
            contentCaptureSession.notifyViewsDisappeared(autofillId, jArr);
        }

        static void notifyViewAppeared(ContentCaptureSession contentCaptureSession, ViewStructure viewStructure) {
            contentCaptureSession.notifyViewAppeared(viewStructure);
        }

        static ViewStructure newViewStructure(ContentCaptureSession contentCaptureSession, View view) {
            return contentCaptureSession.newViewStructure(view);
        }

        static ViewStructure newVirtualViewStructure(ContentCaptureSession contentCaptureSession, AutofillId autofillId, long j) {
            return contentCaptureSession.newVirtualViewStructure(autofillId, j);
        }

        static AutofillId newAutofillId(ContentCaptureSession contentCaptureSession, AutofillId autofillId, long j) {
            return contentCaptureSession.newAutofillId(autofillId, j);
        }

        public static void notifyViewTextChanged(ContentCaptureSession contentCaptureSession, AutofillId autofillId, CharSequence charSequence) {
            contentCaptureSession.notifyViewTextChanged(autofillId, charSequence);
        }
    }

    /* loaded from: classes.dex */
    private static class Api23Impl {
        static Bundle getExtras(ViewStructure viewStructure) {
            return viewStructure.getExtras();
        }
    }
}
