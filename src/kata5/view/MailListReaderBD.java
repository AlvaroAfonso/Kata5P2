/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kata5.view;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import kata5.model.DataBase;
import kata5.model.Mail;

/**
 *
 * @author alvaroafonsolopez
 */
public class MailListReaderBD {
 
    public List<String> read(DataBase bd){
        
        bd.connect();


        List<String> mails = new ArrayList<>();
        
        for (String mail : bd.selectAllEmails()) {
            if(Mail.isMail(mail)){
                mails.add(mail);
            }
        }
        
        return mails;
        
    }
    
}
