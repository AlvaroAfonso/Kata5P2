package kata5.view;

import java.util.List;
import kata5.model.Histogram;
import kata5.model.Mail;

public class MailHistogramBuilder {
    public Histogram<String> build(List<String> mails){
        
        Histogram<String> histo = new Histogram<>();
        
        for (String mail : mails) {
            Mail email = new Mail(mail);
            
            histo.increment(email.getDomain());
        }
        return histo;
    }
}
