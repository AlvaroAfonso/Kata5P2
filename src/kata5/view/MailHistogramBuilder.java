package kata5.view;

import java.util.List;
import kata5.model.Histogram;
import kata5.model.Mail;

public class MailHistogramBuilder {
    public Histogram<String> build(List<Mail> mails){
        
        Histogram<String> histo = new Histogram<String>();
        
        for (Mail mail : mails) {
            histo.increment(mail.getDomain());
        }
        return histo;
    }
}
