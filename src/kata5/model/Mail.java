package kata5.model;

import java.util.regex.Pattern;

public class Mail {
    
    String mail;
    
    public Mail(String mail){
        this.mail = mail;
    }
    
    public String getDomain(){
        return mail.substring(mail.indexOf("@") + 1);
    }
    
    public static boolean isMail(String line){
        
        String emailRegex = "[^@]+@[^@]+\\.[a-zA-Z]{2,}";
        return Pattern.matches(emailRegex,line);
    }
}
