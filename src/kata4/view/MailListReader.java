package kata4.view;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kata4.model.Histogram;
import kata4.model.Mail;

public class MailListReader {
    
    public List<Mail> read(String fileName){
        
        List<Mail> mails = new ArrayList<Mail>();
                
        try{
            BufferedReader bf = new BufferedReader(new FileReader(new File(fileName)));
            while(true){
                String line = bf.readLine();
                if(line == null) break;
                if(Mail.isMail(line)){
                    mails.add(new Mail(line));
                }
            }
        }catch(FileNotFoundException e){
            System.out.println("Fallo de FileNotFoundException");
        }catch (IOException ex) {
            System.out.println("Fallo de IOException");
        }
        
        //System.out.println(mails.get(0));
        
        return mails;
        
    }
    
}
