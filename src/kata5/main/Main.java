package kata5.main;

import java.util.List;
import kata5.model.DataBase;
import kata5.view.HistogramDisplay;
import kata5.model.Histogram;
import kata5.view.MailHistogramBuilder;
import kata5.view.MailListReaderBD;

public class Main {
    
    private static String fileName = new String("emails.txt");
    private static List<String> mailList;
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
        DataBase bd = new DataBase("PEOPLE.db");
        mailList = new MailListReaderBD().read(bd);
    }

    private static void process() {
        histo = new MailHistogramBuilder().build(mailList); 
    }
}