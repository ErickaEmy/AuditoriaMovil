package javax.jmdns.impl.tasks;

import java.io.IOException;
import java.util.TimerTask;
import javax.jmdns.impl.DNSIncoming;
import javax.jmdns.impl.DNSOutgoing;
import javax.jmdns.impl.DNSQuestion;
import javax.jmdns.impl.DNSRecord;
import javax.jmdns.impl.JmDNSImpl;
/* loaded from: classes.dex */
public abstract class DNSTask extends TimerTask {
    private final JmDNSImpl _jmDNSImpl;

    public JmDNSImpl getDns() {
        return this._jmDNSImpl;
    }

    public abstract String getName();

    /* JADX INFO: Access modifiers changed from: protected */
    public DNSTask(JmDNSImpl jmDNSImpl) {
        this._jmDNSImpl = jmDNSImpl;
    }

    public String toString() {
        return getName();
    }

    public DNSOutgoing addQuestion(DNSOutgoing dNSOutgoing, DNSQuestion dNSQuestion) {
        try {
            dNSOutgoing.addQuestion(dNSQuestion);
            return dNSOutgoing;
        } catch (IOException unused) {
            int flags = dNSOutgoing.getFlags();
            boolean isMulticast = dNSOutgoing.isMulticast();
            int maxUDPPayload = dNSOutgoing.getMaxUDPPayload();
            int id = dNSOutgoing.getId();
            dNSOutgoing.setFlags(flags | 512);
            dNSOutgoing.setId(id);
            this._jmDNSImpl.send(dNSOutgoing);
            DNSOutgoing dNSOutgoing2 = new DNSOutgoing(flags, isMulticast, maxUDPPayload);
            dNSOutgoing2.addQuestion(dNSQuestion);
            return dNSOutgoing2;
        }
    }

    public DNSOutgoing addAnswer(DNSOutgoing dNSOutgoing, DNSIncoming dNSIncoming, DNSRecord dNSRecord) {
        try {
            dNSOutgoing.addAnswer(dNSIncoming, dNSRecord);
            return dNSOutgoing;
        } catch (IOException unused) {
            int flags = dNSOutgoing.getFlags();
            boolean isMulticast = dNSOutgoing.isMulticast();
            int maxUDPPayload = dNSOutgoing.getMaxUDPPayload();
            int id = dNSOutgoing.getId();
            dNSOutgoing.setFlags(flags | 512);
            dNSOutgoing.setId(id);
            this._jmDNSImpl.send(dNSOutgoing);
            DNSOutgoing dNSOutgoing2 = new DNSOutgoing(flags, isMulticast, maxUDPPayload);
            dNSOutgoing2.addAnswer(dNSIncoming, dNSRecord);
            return dNSOutgoing2;
        }
    }

    public DNSOutgoing addAnswer(DNSOutgoing dNSOutgoing, DNSRecord dNSRecord, long j) {
        try {
            dNSOutgoing.addAnswer(dNSRecord, j);
            return dNSOutgoing;
        } catch (IOException unused) {
            int flags = dNSOutgoing.getFlags();
            boolean isMulticast = dNSOutgoing.isMulticast();
            int maxUDPPayload = dNSOutgoing.getMaxUDPPayload();
            int id = dNSOutgoing.getId();
            dNSOutgoing.setFlags(flags | 512);
            dNSOutgoing.setId(id);
            this._jmDNSImpl.send(dNSOutgoing);
            DNSOutgoing dNSOutgoing2 = new DNSOutgoing(flags, isMulticast, maxUDPPayload);
            dNSOutgoing2.addAnswer(dNSRecord, j);
            return dNSOutgoing2;
        }
    }

    public DNSOutgoing addAuthoritativeAnswer(DNSOutgoing dNSOutgoing, DNSRecord dNSRecord) {
        try {
            dNSOutgoing.addAuthorativeAnswer(dNSRecord);
            return dNSOutgoing;
        } catch (IOException unused) {
            int flags = dNSOutgoing.getFlags();
            boolean isMulticast = dNSOutgoing.isMulticast();
            int maxUDPPayload = dNSOutgoing.getMaxUDPPayload();
            int id = dNSOutgoing.getId();
            dNSOutgoing.setFlags(flags | 512);
            dNSOutgoing.setId(id);
            this._jmDNSImpl.send(dNSOutgoing);
            DNSOutgoing dNSOutgoing2 = new DNSOutgoing(flags, isMulticast, maxUDPPayload);
            dNSOutgoing2.addAuthorativeAnswer(dNSRecord);
            return dNSOutgoing2;
        }
    }
}
