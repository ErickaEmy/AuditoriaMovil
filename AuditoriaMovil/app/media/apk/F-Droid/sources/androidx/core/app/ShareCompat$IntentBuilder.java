package androidx.core.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import org.bouncycastle.asn1.cmp.PKIFailureInfo;
/* loaded from: classes.dex */
public class ShareCompat$IntentBuilder {
    private ArrayList mBccAddresses;
    private ArrayList mCcAddresses;
    private CharSequence mChooserTitle;
    private final Context mContext;
    private final Intent mIntent;
    private ArrayList mStreams;
    private ArrayList mToAddresses;

    public ShareCompat$IntentBuilder setChooserTitle(CharSequence charSequence) {
        this.mChooserTitle = charSequence;
        return this;
    }

    public static ShareCompat$IntentBuilder from(Activity activity) {
        return new ShareCompat$IntentBuilder(activity);
    }

    public ShareCompat$IntentBuilder(Context context) {
        Activity activity;
        this.mContext = (Context) Preconditions.checkNotNull(context);
        Intent action = new Intent().setAction("android.intent.action.SEND");
        this.mIntent = action;
        action.putExtra("androidx.core.app.EXTRA_CALLING_PACKAGE", context.getPackageName());
        action.putExtra("android.support.v4.app.EXTRA_CALLING_PACKAGE", context.getPackageName());
        action.addFlags(PKIFailureInfo.signerNotTrusted);
        while (true) {
            if (!(context instanceof ContextWrapper)) {
                activity = null;
                break;
            } else if (context instanceof Activity) {
                activity = (Activity) context;
                break;
            } else {
                context = ((ContextWrapper) context).getBaseContext();
            }
        }
        if (activity != null) {
            ComponentName componentName = activity.getComponentName();
            this.mIntent.putExtra("androidx.core.app.EXTRA_CALLING_ACTIVITY", componentName);
            this.mIntent.putExtra("android.support.v4.app.EXTRA_CALLING_ACTIVITY", componentName);
        }
    }

    public Intent getIntent() {
        ArrayList arrayList = this.mToAddresses;
        if (arrayList != null) {
            combineArrayExtra("android.intent.extra.EMAIL", arrayList);
            this.mToAddresses = null;
        }
        ArrayList arrayList2 = this.mCcAddresses;
        if (arrayList2 != null) {
            combineArrayExtra("android.intent.extra.CC", arrayList2);
            this.mCcAddresses = null;
        }
        ArrayList arrayList3 = this.mBccAddresses;
        if (arrayList3 != null) {
            combineArrayExtra("android.intent.extra.BCC", arrayList3);
            this.mBccAddresses = null;
        }
        ArrayList arrayList4 = this.mStreams;
        if (arrayList4 == null || arrayList4.size() <= 1) {
            this.mIntent.setAction("android.intent.action.SEND");
            ArrayList arrayList5 = this.mStreams;
            if (arrayList5 != null && !arrayList5.isEmpty()) {
                this.mIntent.putExtra("android.intent.extra.STREAM", (Parcelable) this.mStreams.get(0));
                ShareCompat$Api16Impl.migrateExtraStreamToClipData(this.mIntent, this.mStreams);
            } else {
                this.mIntent.removeExtra("android.intent.extra.STREAM");
                ShareCompat$Api16Impl.removeClipData(this.mIntent);
            }
        } else {
            this.mIntent.setAction("android.intent.action.SEND_MULTIPLE");
            this.mIntent.putParcelableArrayListExtra("android.intent.extra.STREAM", this.mStreams);
            ShareCompat$Api16Impl.migrateExtraStreamToClipData(this.mIntent, this.mStreams);
        }
        return this.mIntent;
    }

    private void combineArrayExtra(String str, ArrayList arrayList) {
        String[] stringArrayExtra = this.mIntent.getStringArrayExtra(str);
        int length = stringArrayExtra != null ? stringArrayExtra.length : 0;
        String[] strArr = new String[arrayList.size() + length];
        arrayList.toArray(strArr);
        if (stringArrayExtra != null) {
            System.arraycopy(stringArrayExtra, 0, strArr, arrayList.size(), length);
        }
        this.mIntent.putExtra(str, strArr);
    }

    public ShareCompat$IntentBuilder setChooserTitle(int i) {
        return setChooserTitle(this.mContext.getText(i));
    }

    public ShareCompat$IntentBuilder setType(String str) {
        this.mIntent.setType(str);
        return this;
    }

    public ShareCompat$IntentBuilder setText(CharSequence charSequence) {
        this.mIntent.putExtra("android.intent.extra.TEXT", charSequence);
        return this;
    }

    public ShareCompat$IntentBuilder setStream(Uri uri) {
        this.mStreams = null;
        if (uri != null) {
            addStream(uri);
        }
        return this;
    }

    public ShareCompat$IntentBuilder addStream(Uri uri) {
        if (this.mStreams == null) {
            this.mStreams = new ArrayList();
        }
        this.mStreams.add(uri);
        return this;
    }

    public ShareCompat$IntentBuilder setSubject(String str) {
        this.mIntent.putExtra("android.intent.extra.SUBJECT", str);
        return this;
    }
}
