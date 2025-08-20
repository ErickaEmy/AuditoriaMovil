package com.facebook.ads.redexgen.X;

import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.uv.v7.R;
/* renamed from: com.facebook.ads.redexgen.X.Mb  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0796Mb extends LinearLayout {
    public static String[] A07 = {"RdKbZKE5ShqjtspsYuId0BpVT", "jFs6Ox2yxsj", "", "O0DGVMIkWcl", "ZjYxtVw01iwSMNXN0b17Jtyc9gHU9Z2d", "b1LSaO6GQJOSELIr8C99", "", "wukZGaaSm"};
    public static final int A08 = (int) (LD.A02 * 15.0f);
    public static final int A09 = (int) (LD.A02 * 10.0f);
    public static final int A0A = (int) (LD.A02 * 44.0f);
    public int A00;
    public boolean A01;
    public final ImageView A02;
    public final LinearLayout A03;
    public final TextView A04;
    public final C1116Yn A05;
    public final C0840Nt A06;

    public C0796Mb(C1116Yn c1116Yn, int i) {
        super(c1116Yn);
        this.A01 = false;
        this.A05 = c1116Yn;
        ImageView imageView = new ImageView(c1116Yn);
        this.A02 = imageView;
        int i5 = A09;
        imageView.setPadding(i5, i5, i5, i5);
        C0840Nt c0840Nt = new C0840Nt(c1116Yn);
        this.A06 = c0840Nt;
        c0840Nt.setProgress(0.0f);
        c0840Nt.setPadding(i5, i5, i5, i5);
        this.A04 = new TextView(c1116Yn);
        setOrientation(0);
        this.A03 = new LinearLayout(c1116Yn);
        this.A00 = i;
        A00();
    }

    private void A00() {
        setToolbarActionMode(this.A00);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        setGravity(17);
        int i = A0A;
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i, i);
        AbstractC0783Lo.A0X(this.A04, true, 16);
        this.A04.setTextColor(-1);
        this.A04.setVisibility(8);
        this.A03.addView(this.A02, layoutParams2);
        this.A03.addView(this.A06, layoutParams2);
        addView(this.A03, layoutParams);
        LinearLayout.LayoutParams actionTextLayoutParams = new LinearLayout.LayoutParams(-2, -2);
        actionTextLayoutParams.gravity = 17;
        addView(this.A04, actionTextLayoutParams);
    }

    private void A01() {
        int i;
        C0840Nt c0840Nt = this.A06;
        int i5 = this.A00;
        int i6 = 8;
        if (i5 == 2 || i5 == 6) {
            i = this.A01 ? 4 : 0;
        } else {
            i = 8;
        }
        c0840Nt.setVisibility(i);
        ImageView imageView = this.A02;
        int i8 = this.A00;
        if (i8 == 5) {
            i6 = 4;
        } else if (i8 != 2 && i8 != 6) {
            i6 = 0;
        }
        imageView.setVisibility(i6);
    }

    public final void A02(C1P c1p, boolean z2, boolean z3) {
        int A04 = c1p.A04(z2);
        C0840Nt c0840Nt = this.A06;
        int accentColor = AbstractC03322p.A01(A04, 77);
        c0840Nt.A02(accentColor, A04, R.styleable.AppCompatTheme_textColorAlertDialogListItem);
        this.A02.setColorFilter(A04);
        if (z3) {
            TextView textView = this.A04;
            int accentColor2 = AbstractC03322p.A01(-1, R.styleable.AppCompatTheme_textColorAlertDialogListItem);
            textView.setTextColor(accentColor2);
            return;
        }
        this.A04.setTextColor(A04);
    }

    public final boolean A03() {
        return !this.A04.getText().toString().isEmpty();
    }

    public final boolean A04() {
        int i = this.A00;
        return (i == 2 || i == 4) ? false : true;
    }

    public int getToolbarActionMode() {
        return this.A00;
    }

    public void setActionClickListener(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void setInitialUnskippableSeconds(int i) {
        if (i > 0) {
            setToolbarActionMode(2);
        }
    }

    public void setProgress(float f4) {
        this.A06.setProgressWithAnimation(f4);
    }

    public void setProgressClickListener(View.OnClickListener onClickListener) {
        this.A06.setOnClickListener(onClickListener);
    }

    public void setProgressImage(EnumC0791Lw enumC0791Lw) {
        this.A06.setImage(enumC0791Lw);
    }

    public void setProgressImmediate(float f4) {
        this.A06.clearAnimation();
        this.A06.setProgress(f4);
    }

    public void setProgressSpinnerInvisible(boolean z2) {
        this.A01 = z2;
        A01();
    }

    public void setToolbarActionMode(int i) {
        EnumC0791Lw enumC0791Lw;
        this.A05.A0E().ADK(i);
        this.A00 = i;
        A01();
        setVisibility(0);
        if (Build.VERSION.SDK_INT >= 16) {
            this.A02.setImageAlpha(255);
        }
        ImageView imageView = this.A02;
        int i5 = A09;
        imageView.setPadding(i5, i5, i5, i5);
        switch (i) {
            case 0:
                enumC0791Lw = EnumC0791Lw.CROSS;
                break;
            case 1:
                enumC0791Lw = EnumC0791Lw.SKIP_ARROW;
                break;
            case 2:
            default:
                enumC0791Lw = EnumC0791Lw.CROSS;
                break;
            case 3:
                enumC0791Lw = EnumC0791Lw.MINIMIZE_ARROW;
                break;
            case 4:
                enumC0791Lw = EnumC0791Lw.CROSS;
                this.A02.setVisibility(8);
                setVisibility(8);
                break;
            case 5:
                enumC0791Lw = EnumC0791Lw.CROSS;
                break;
            case 6:
                enumC0791Lw = EnumC0791Lw.CROSS;
                break;
            case 7:
                enumC0791Lw = EnumC0791Lw.CROSS;
                if (Build.VERSION.SDK_INT >= 16) {
                    this.A02.setImageAlpha(R.styleable.AppCompatTheme_textColorAlertDialogListItem);
                }
                ImageView imageView2 = this.A02;
                if (A07[4].charAt(13) == 'C') {
                    throw new RuntimeException();
                }
                String[] strArr = A07;
                strArr[6] = "";
                strArr[2] = "";
                int i6 = A08;
                imageView2.setPadding(i6, i6, i6, i6);
                break;
        }
        this.A02.setImageBitmap(AbstractC0792Lx.A01(enumC0791Lw));
        if (i == 1) {
            AbstractC0783Lo.A0G(1005, this.A02);
        } else {
            AbstractC0783Lo.A0G(1002, this.A02);
        }
    }

    public void setToolbarMessage(String str) {
        this.A04.setText(str);
        this.A04.setVisibility(TextUtils.isEmpty(str) ? 8 : 0);
    }

    public void setToolbarMessageEnabled(boolean z2) {
        this.A04.setVisibility(z2 ? 0 : 4);
    }
}
