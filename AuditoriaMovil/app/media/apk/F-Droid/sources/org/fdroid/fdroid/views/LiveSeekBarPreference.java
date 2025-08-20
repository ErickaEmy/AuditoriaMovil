package org.fdroid.fdroid.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.preference.PreferenceViewHolder;
import androidx.preference.SeekBarPreference;
import org.fdroid.fdroid.R;
/* loaded from: classes2.dex */
public class LiveSeekBarPreference extends SeekBarPreference {
    private SeekBarLiveUpdater seekBarLiveUpdater;
    private boolean trackingTouch;
    private int value;

    /* loaded from: classes2.dex */
    public interface SeekBarLiveUpdater {
        String seekBarUpdated(int i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setSeekBarLiveUpdater(SeekBarLiveUpdater seekBarLiveUpdater) {
        this.seekBarLiveUpdater = seekBarLiveUpdater;
    }

    public LiveSeekBarPreference(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.value = -1;
    }

    public LiveSeekBarPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.value = -1;
    }

    public LiveSeekBarPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.value = -1;
    }

    public LiveSeekBarPreference(Context context) {
        super(context);
        this.value = -1;
    }

    @Override // androidx.preference.SeekBarPreference, androidx.preference.Preference
    public void onBindViewHolder(final PreferenceViewHolder preferenceViewHolder) {
        super.onBindViewHolder(preferenceViewHolder);
        preferenceViewHolder.findViewById(R.id.seekbar_value).setVisibility(8);
        SeekBarForegroundThumb seekBarForegroundThumb = (SeekBarForegroundThumb) preferenceViewHolder.itemView.findViewById(R.id.seekbar);
        seekBarForegroundThumb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: org.fdroid.fdroid.views.LiveSeekBarPreference.1
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                LiveSeekBarPreference.this.value = i;
                if (LiveSeekBarPreference.this.seekBarLiveUpdater != null) {
                    String seekBarUpdated = LiveSeekBarPreference.this.seekBarLiveUpdater.seekBarUpdated(LiveSeekBarPreference.this.value);
                    TextView textView = (TextView) preferenceViewHolder.itemView.findViewById(16908304);
                    if (textView != null) {
                        textView.setText(seekBarUpdated);
                    }
                }
                if (!z || LiveSeekBarPreference.this.trackingTouch) {
                    return;
                }
                LiveSeekBarPreference liveSeekBarPreference = LiveSeekBarPreference.this;
                liveSeekBarPreference.persistInt(liveSeekBarPreference.value);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                LiveSeekBarPreference.this.trackingTouch = true;
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                LiveSeekBarPreference.this.trackingTouch = false;
                LiveSeekBarPreference liveSeekBarPreference = LiveSeekBarPreference.this;
                liveSeekBarPreference.persistInt(liveSeekBarPreference.value);
            }
        });
        seekBarForegroundThumb.setProgress(this.value);
        if (isEnabled()) {
            seekBarForegroundThumb.setAlpha(1.0f);
        } else {
            seekBarForegroundThumb.setAlpha(0.3f);
        }
    }

    @Override // androidx.preference.SeekBarPreference
    public void setValue(int i) {
        super.setValue(i);
        this.value = i;
    }

    @Override // androidx.preference.SeekBarPreference
    public int getValue() {
        if (this.value == -1) {
            this.value = super.getValue();
        }
        return this.value;
    }
}
