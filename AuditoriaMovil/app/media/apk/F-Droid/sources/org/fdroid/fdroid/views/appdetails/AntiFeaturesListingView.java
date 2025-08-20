package org.fdroid.fdroid.views.appdetails;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.os.LocaleListCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import org.bouncycastle.asn1.cmp.PKIFailureInfo;
import org.fdroid.database.AntiFeature;
import org.fdroid.database.Repository;
import org.fdroid.fdroid.FDroidApp;
import org.fdroid.fdroid.R;
import org.fdroid.fdroid.data.App;
import org.fdroid.fdroid.views.appdetails.AntiFeaturesListingView;
/* loaded from: classes2.dex */
public class AntiFeaturesListingView extends RecyclerView {
    private static final String TAG = "AntiFeaturesListingView";

    public AntiFeaturesListingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setApp(App app) {
        setHasFixedSize(true);
        setLayoutManager(new LinearLayoutManager(getContext()));
        swapAdapter(new AnonymousClass1(app), false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: org.fdroid.fdroid.views.appdetails.AntiFeaturesListingView$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass1 extends RecyclerView.Adapter {
        final /* synthetic */ App val$app;

        AnonymousClass1(App app) {
            this.val$app = app;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public AntiFeatureItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new AntiFeatureItemViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.listitem_antifeaturelisting, viewGroup, false));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(AntiFeatureItemViewHolder antiFeatureItemViewHolder, int i) {
            final String str = this.val$app.antiFeatures[i];
            Repository repository = FDroidApp.getRepoManager(AntiFeaturesListingView.this.getContext()).getRepository(this.val$app.repoId);
            if (repository == null) {
                return;
            }
            LocaleListCompat localeListCompat = LocaleListCompat.getDefault();
            AntiFeature antiFeature = repository.getAntiFeatures().get(str);
            if (antiFeature == null) {
                Log.w(AntiFeaturesListingView.TAG, "Anti-feature not defined in repo: " + str);
                antiFeatureItemViewHolder.antiFeatureText.setText(AntiFeaturesListingView.getAntiFeatureDescriptionText(AntiFeaturesListingView.this.getContext(), str));
                Glide.with(AntiFeaturesListingView.this.getContext()).clear(antiFeatureItemViewHolder.antiFeatureIcon);
                antiFeatureItemViewHolder.antiFeatureIcon.setImageResource(AntiFeaturesListingView.antiFeatureIcon(AntiFeaturesListingView.this.getContext(), str));
            } else {
                String description = antiFeature.getDescription(localeListCompat);
                TextView textView = antiFeatureItemViewHolder.antiFeatureText;
                if (description == null) {
                    description = AntiFeaturesListingView.getAntiFeatureDescriptionText(AntiFeaturesListingView.this.getContext(), str);
                }
                textView.setText(description);
                int antiFeatureIcon = AntiFeaturesListingView.antiFeatureIcon(AntiFeaturesListingView.this.getContext(), str);
                ((RequestBuilder) ((RequestBuilder) this.val$app.loadWithGlide(AntiFeaturesListingView.this.getContext(), antiFeature.getIcon(localeListCompat)).fallback(antiFeatureIcon)).error(antiFeatureIcon)).into(antiFeatureItemViewHolder.antiFeatureIcon);
            }
            String str2 = this.val$app.antiFeatureReasons.get(str);
            if (str2 == null) {
                antiFeatureItemViewHolder.antiFeatureReason.setVisibility(8);
            } else {
                antiFeatureItemViewHolder.antiFeatureReason.setText(str2);
                antiFeatureItemViewHolder.antiFeatureReason.setVisibility(0);
            }
            antiFeatureItemViewHolder.entireView.setOnClickListener(new View.OnClickListener() { // from class: org.fdroid.fdroid.views.appdetails.AntiFeaturesListingView$1$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AntiFeaturesListingView.AnonymousClass1.this.lambda$onBindViewHolder$0(str, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$0(String str, View view) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setFlags(PKIFailureInfo.signerNotTrusted);
            intent.setData(Uri.parse("https://f-droid.org/docs/Anti-Features#" + str));
            AntiFeaturesListingView.this.getContext().startActivity(intent);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            String[] strArr;
            App app = this.val$app;
            if (app == null || (strArr = app.antiFeatures) == null) {
                return 0;
            }
            return strArr.length;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class AntiFeatureItemViewHolder extends RecyclerView.ViewHolder {
        private final ImageView antiFeatureIcon;
        private final TextView antiFeatureReason;
        private final TextView antiFeatureText;
        private final View entireView;

        AntiFeatureItemViewHolder(View view) {
            super(view);
            this.entireView = view;
            this.antiFeatureIcon = (ImageView) view.findViewById(R.id.anti_feature_icon);
            this.antiFeatureText = (TextView) view.findViewById(R.id.anti_feature_text);
            this.antiFeatureReason = (TextView) view.findViewById(R.id.anti_feature_reason);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getAntiFeatureDescriptionText(Context context, String str) {
        if (str.equals(context.getString(R.string.antiads_key))) {
            return context.getString(R.string.antiadslist);
        }
        if (str.equals(context.getString(R.string.antitrack_key))) {
            return context.getString(R.string.antitracklist);
        }
        if (str.equals(context.getString(R.string.antinonfreenet_key))) {
            return context.getString(R.string.antinonfreenetlist);
        }
        if (str.equals(context.getString(R.string.antitetherednet_key))) {
            return context.getString(R.string.antitetherednetlist);
        }
        if (str.equals(context.getString(R.string.antinonfreead_key))) {
            return context.getString(R.string.antinonfreeadlist);
        }
        if (str.equals(context.getString(R.string.antinonfreedep_key))) {
            return context.getString(R.string.antinonfreedeplist);
        }
        if (str.equals(context.getString(R.string.antiupstreamnonfree_key))) {
            return context.getString(R.string.antiupstreamnonfreelist);
        }
        if (str.equals(context.getString(R.string.antinonfreeassets_key))) {
            return context.getString(R.string.antinonfreeassetslist);
        }
        if (str.equals(context.getString(R.string.antidisabledalgorithm_key))) {
            return context.getString(R.string.antidisabledalgorithmlist);
        }
        if (str.equals(context.getString(R.string.antiknownvuln_key))) {
            return context.getString(R.string.antiknownvulnlist);
        }
        if (str.equals(context.getString(R.string.antinosource_key))) {
            return context.getString(R.string.antinosourcesince);
        }
        return str.equals(context.getString(R.string.antinsfw_key)) ? context.getString(R.string.antinsfwlist) : str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int antiFeatureIcon(Context context, String str) {
        return str.equals(context.getString(R.string.antiads_key)) ? R.drawable.ic_antifeature_ads : str.equals(context.getString(R.string.antitrack_key)) ? R.drawable.ic_antifeature_tracking : str.equals(context.getString(R.string.antinonfreenet_key)) ? R.drawable.ic_antifeature_nonfreenet : str.equals(context.getString(R.string.antitetherednet_key)) ? R.drawable.ic_antifeature_tetherednet : str.equals(context.getString(R.string.antinonfreead_key)) ? R.drawable.ic_antifeature_nonfreeadd : str.equals(context.getString(R.string.antinonfreedep_key)) ? R.drawable.ic_antifeature_nonfreedep : str.equals(context.getString(R.string.antiupstreamnonfree_key)) ? R.drawable.ic_antifeature_upstreamnonfree : str.equals(context.getString(R.string.antinonfreeassets_key)) ? R.drawable.ic_antifeature_nonfreeassets : str.equals(context.getString(R.string.antidisabledalgorithm_key)) ? R.drawable.ic_antifeature_disabledalgorithm : str.equals(context.getString(R.string.antiknownvuln_key)) ? R.drawable.ic_antifeature_knownvuln : str.equals(context.getString(R.string.antinosource_key)) ? R.drawable.ic_antifeature_nosourcesince : str.equals(context.getString(R.string.antinsfw_key)) ? R.drawable.ic_antifeature_nsfw : R.drawable.ic_cancel;
    }
}
