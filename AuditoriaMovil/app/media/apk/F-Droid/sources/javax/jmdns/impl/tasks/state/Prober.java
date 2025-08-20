package javax.jmdns.impl.tasks.state;

import java.util.Timer;
import javax.jmdns.impl.DNSOutgoing;
import javax.jmdns.impl.DNSQuestion;
import javax.jmdns.impl.DNSRecord;
import javax.jmdns.impl.JmDNSImpl;
import javax.jmdns.impl.ServiceInfoImpl;
import javax.jmdns.impl.constants.DNSRecordClass;
import javax.jmdns.impl.constants.DNSRecordType;
import javax.jmdns.impl.constants.DNSState;
/* loaded from: classes.dex */
public class Prober extends DNSStateTask {
    @Override // javax.jmdns.impl.tasks.state.DNSStateTask
    public String getTaskDescription() {
        return "probing";
    }

    public Prober(JmDNSImpl jmDNSImpl) {
        super(jmDNSImpl, DNSStateTask.defaultTTL());
        DNSState dNSState = DNSState.PROBING_1;
        setTaskState(dNSState);
        associate(dNSState);
    }

    @Override // javax.jmdns.impl.tasks.DNSTask
    public String getName() {
        StringBuilder sb = new StringBuilder();
        sb.append("Prober(");
        sb.append(getDns() != null ? getDns().getName() : "");
        sb.append(")");
        return sb.toString();
    }

    @Override // javax.jmdns.impl.tasks.DNSTask
    public String toString() {
        return super.toString() + " state: " + getTaskState();
    }

    public void start(Timer timer) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - getDns().getLastThrottleIncrement() < 5000) {
            getDns().setThrottle(getDns().getThrottle() + 1);
        } else {
            getDns().setThrottle(1);
        }
        getDns().setLastThrottleIncrement(currentTimeMillis);
        if (getDns().isAnnounced() && getDns().getThrottle() < 10) {
            timer.schedule(this, JmDNSImpl.getRandom().nextInt(251), 250L);
        } else if (getDns().isCanceling() || getDns().isCanceled()) {
        } else {
            timer.schedule(this, 1000L, 1000L);
        }
    }

    @Override // java.util.TimerTask
    public boolean cancel() {
        removeAssociation();
        return super.cancel();
    }

    @Override // javax.jmdns.impl.tasks.state.DNSStateTask
    protected boolean checkRunCondition() {
        return (getDns().isCanceling() || getDns().isCanceled()) ? false : true;
    }

    @Override // javax.jmdns.impl.tasks.state.DNSStateTask
    protected DNSOutgoing createOugoing() {
        return new DNSOutgoing(0);
    }

    @Override // javax.jmdns.impl.tasks.state.DNSStateTask
    protected DNSOutgoing buildOutgoingForDNS(DNSOutgoing dNSOutgoing) {
        dNSOutgoing.addQuestion(DNSQuestion.newQuestion(getDns().getLocalHost().getName(), DNSRecordType.TYPE_ANY, DNSRecordClass.CLASS_IN, false));
        for (DNSRecord dNSRecord : getDns().getLocalHost().answers(DNSRecordClass.CLASS_ANY, false, getTTL())) {
            dNSOutgoing = addAuthoritativeAnswer(dNSOutgoing, dNSRecord);
        }
        return dNSOutgoing;
    }

    @Override // javax.jmdns.impl.tasks.state.DNSStateTask
    protected DNSOutgoing buildOutgoingForInfo(ServiceInfoImpl serviceInfoImpl, DNSOutgoing dNSOutgoing) {
        String qualifiedName = serviceInfoImpl.getQualifiedName();
        DNSRecordType dNSRecordType = DNSRecordType.TYPE_ANY;
        DNSRecordClass dNSRecordClass = DNSRecordClass.CLASS_IN;
        return addAuthoritativeAnswer(addQuestion(dNSOutgoing, DNSQuestion.newQuestion(qualifiedName, dNSRecordType, dNSRecordClass, false)), new DNSRecord.Service(serviceInfoImpl.getQualifiedName(), dNSRecordClass, false, getTTL(), serviceInfoImpl.getPriority(), serviceInfoImpl.getWeight(), serviceInfoImpl.getPort(), getDns().getLocalHost().getName()));
    }

    @Override // javax.jmdns.impl.tasks.state.DNSStateTask
    protected void recoverTask(Throwable th) {
        getDns().recover();
    }

    @Override // javax.jmdns.impl.tasks.state.DNSStateTask
    protected void advanceTask() {
        setTaskState(getTaskState().advance());
        if (getTaskState().isProbing()) {
            return;
        }
        cancel();
        getDns().startAnnouncer();
    }
}
