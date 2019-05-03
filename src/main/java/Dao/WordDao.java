package Dao;

import javax.swing.text.Utilities;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class WordDao {

    public static String getWord(){

        Connection conn;
        Statement stmt;
        String str = null;

        try{

            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:mysql://localhost/tp2Threads","root","");
            String sql;
            sql = "Select * from words";

            stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            List<String> words = new ArrayList<>();

            while (rs.next()){

                String word = new String(rs.getString("word"));
                words.add(word);

            }

            //str = words.get(Utilities.getRandom().nextInt(words.size())).getWord();



        }catch(SQLException se){

            System.out.println("error sql");
            se.printStackTrace();
        }catch(Exception e){

            System.out.println("error classforname");
            e.printStackTrace();
        }finally{
            return str;
        }


    }
}
