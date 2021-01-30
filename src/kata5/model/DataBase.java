package kata5.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DataBase {
    
    private Connection conn = null;
    private String url = "";
    
    public DataBase(String url){
        this.url = "jdbc:sqlite:" + url;
    }

    public void connect() {
        try {
            // creamos una conexión a la BD
            conn = DriverManager.getConnection(url);
            System.out.println("Connexión a SQLite establecida");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void selectAllPersons(String table){
        String sql = "SELECT * FROM PEOPLE";
        try (Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            // Bucle sobre el conjunto de registros.
            while (rs.next()) {
                System.out.println(rs.getString("first_name") + "\t" +
                rs.getString("last_name") + "\t" +
                rs.getString("city") + "\t");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (NullPointerException e){
            System.out.println("La conexión no ha sido establecida, primero conecte con la base de datos");
        }
    }
    
    public List<String> selectAllEmails(){
        List<String> mails = new ArrayList<>();
        String sql = "SELECT * FROM MAIL";
        try (Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            // Bucle sobre el conjunto de registros.
            while (rs.next()) {
                mails.add(rs.getString("mail"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (NullPointerException e){
            System.out.println("La conexión no ha sido establecida, primero conecte con la base de datos");
        }
        
        return mails;
    }
    
    public void createNewTable(String table){
        String sql = "CREATE TABLE IF NOT EXISTS " + table + " (\n"
                    + " id integer PRIMARY KEY AUTOINCREMENT,\n"
                    + " mail text NOT NULL);";
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabla creada");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (NullPointerException e){
            System.out.println("La conexión no ha sido establecida, primero conecte con la base de datos");
        }
    }
    
    public void insertEmail(String email){
        String sql = "INSERT INTO MAIL(mail) VALUES(?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, email);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (NullPointerException e){
            System.out.println("La conexión no ha sido establecida, primero conecte con la base de datos");
        }
    }
    
}