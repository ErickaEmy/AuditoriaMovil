package wz;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.os.Bundle;
import android.text.Selection;
import android.text.Spannable;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.view.inputmethod.InputContentInfo;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import hw.zn;
import o.n3;
/* loaded from: classes.dex */
public final class p {

    /* loaded from: classes.dex */
    public static final class n3 {
        public static boolean n3(@NonNull DragEvent dragEvent, @NonNull View view, @NonNull Activity activity) {
            activity.requestDragAndDropPermissions(dragEvent);
            hw.i4.eb(view, new zn.y(dragEvent.getClipData(), 3).y());
            return true;
        }

        public static boolean y(@NonNull DragEvent dragEvent, @NonNull TextView textView, @NonNull Activity activity) {
            activity.requestDragAndDropPermissions(dragEvent);
            int offsetForPosition = textView.getOffsetForPosition(dragEvent.getX(), dragEvent.getY());
            textView.beginBatchEdit();
            try {
                Selection.setSelection((Spannable) textView.getText(), offsetForPosition);
                hw.i4.eb(textView, new zn.y(dragEvent.getClipData(), 3).y());
                textView.endBatchEdit();
                return true;
            } catch (Throwable th) {
                textView.endBatchEdit();
                throw th;
            }
        }
    }

    /* loaded from: classes.dex */
    public class y implements n3.zn {
        public final /* synthetic */ View y;

        public y(View view) {
            this.y = view;
        }

        @Override // o.n3.zn
        public boolean y(o.zn znVar, int i, Bundle bundle) {
            if (Build.VERSION.SDK_INT >= 25 && (i & 1) != 0) {
                try {
                    znVar.gv();
                    InputContentInfo inputContentInfo = (InputContentInfo) znVar.v();
                    if (bundle == null) {
                        bundle = new Bundle();
                    } else {
                        bundle = new Bundle(bundle);
                    }
                    bundle.putParcelable("androidx.core.view.extra.INPUT_CONTENT_INFO", inputContentInfo);
                } catch (Exception e2) {
                    Log.w("ReceiveContent", "Can't insert content from IME; requestPermission() failed", e2);
                    return false;
                }
            }
            if (hw.i4.eb(this.y, new zn.y(new ClipData(znVar.n3(), new ClipData.Item(znVar.y())), 2).gv(znVar.zn()).n3(bundle).y()) != null) {
                return false;
            }
            return true;
        }
    }

    @Nullable
    public static Activity gv(@NonNull View view) {
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
        }
        return null;
    }

    public static boolean n3(@NonNull View view, @NonNull DragEvent dragEvent) {
        Activity gv2;
        if (Build.VERSION.SDK_INT < 24 || dragEvent.getLocalState() != null || hw.i4.ej(view) == null || (gv2 = gv(view)) == null) {
            return false;
        }
        if (dragEvent.getAction() == 1) {
            return !(view instanceof TextView);
        }
        if (dragEvent.getAction() == 3) {
            if (view instanceof TextView) {
                return n3.y(dragEvent, (TextView) view, gv2);
            }
            return n3.n3(dragEvent, view, gv2);
        }
        return false;
    }

    @NonNull
    public static n3.zn y(@NonNull View view) {
        return new y(view);
    }

    public static boolean zn(@NonNull TextView textView, int i) {
        ClipData primaryClip;
        int i5 = 0;
        if ((i != 16908322 && i != 16908337) || hw.i4.ej(textView) == null) {
            return false;
        }
        ClipboardManager clipboardManager = (ClipboardManager) textView.getContext().getSystemService("clipboard");
        if (clipboardManager == null) {
            primaryClip = null;
        } else {
            primaryClip = clipboardManager.getPrimaryClip();
        }
        if (primaryClip != null && primaryClip.getItemCount() > 0) {
            zn.y yVar = new zn.y(primaryClip, 1);
            if (i != 16908322) {
                i5 = 1;
            }
            hw.i4.eb(textView, yVar.zn(i5).y());
        }
        return true;
    }
}
