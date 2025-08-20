package org.bouncycastle.cert.ocsp;

import java.util.Date;
import org.bouncycastle.asn1.ASN1GeneralizedTime;
import org.bouncycastle.asn1.ocsp.RevokedInfo;
import org.bouncycastle.asn1.x509.CRLReason;
/* loaded from: classes2.dex */
public class RevokedStatus implements CertificateStatus {

    /* renamed from: info  reason: collision with root package name */
    RevokedInfo f40info;

    public RevokedStatus(Date date, int i) {
        this.f40info = new RevokedInfo(new ASN1GeneralizedTime(date), CRLReason.lookup(i));
    }

    public RevokedStatus(RevokedInfo revokedInfo) {
        this.f40info = revokedInfo;
    }

    public int getRevocationReason() {
        if (this.f40info.getRevocationReason() != null) {
            return this.f40info.getRevocationReason().getValue().intValue();
        }
        throw new IllegalStateException("attempt to get a reason where none is available");
    }

    public Date getRevocationTime() {
        return OCSPUtils.extractDate(this.f40info.getRevocationTime());
    }

    public boolean hasRevocationReason() {
        return this.f40info.getRevocationReason() != null;
    }
}
