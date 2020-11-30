package kata4.main;

import java.util.List;
import kata4.view.HistogramDisplay;
import kata4.model.Histogram;
import kata4.model.Mail;
import kata4.view.MailHistogramBuilder;
import kata4.view.MailListReader;

public class Main {
    public static void main(String[] args) {
        
        String fileName = new String("emails.txt");
        List<Mail> mailList;
        Histogram<String> histo = new Histogram();
        
        mailList = new MailListReader().read(fileName);
        
        histo = new MailHistogramBuilder().build(mailList); 
        
        /*for(int i = 0; i < mailList.size(); i++){
            System.out.println(mailList.get(i).getDomain());
        }*/
        
        //System.out.println("HECHO");

        new HistogramDisplay(histo).execute();
    }
}