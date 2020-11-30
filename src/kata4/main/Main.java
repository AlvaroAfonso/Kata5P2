package kata4.main;

import java.util.List;
import kata4.view.HistogramDisplay;
import kata4.model.Histogram;
import kata4.model.Mail;
import kata4.view.MailHistogramBuilder;
import kata4.view.MailListReader;

public class Main {
    
    private static String fileName = new String("emails.txt");
    private static List<Mail> mailList;
    private static Histogram<String> histo = new Histogram();
    
    public static void main(String[] args) {
        
        execute();

    }
    
    private static void execute(){
        input();
        process();
        output();
    }

    private static void output() {
        new HistogramDisplay(histo).execute();
}

    private static void input() {
        mailList = new MailListReader().read(fileName);
    }

    private static void process() {
        histo = new MailHistogramBuilder().build(mailList); 
    }
}