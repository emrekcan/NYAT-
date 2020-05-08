/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sogutucuuygulamasi;

/**
 *
 * @author emree
 */

import java.sql.*;

public class SogutucuBilgiSistemi {
    /*private final String kullaniciAdi;
    private final int sifre;


    public SogutucuBilgiSistemi() {
        this.kullaniciAdi = "admin";
        this.sifre = 1234;
    }*/
    
    public boolean kullaniciDogrula(String kullaniciAdi, int sifre) throws SQLException
    {
        try
        {   /***** Bağlantı kurulumu *****/
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sogutucuSistemi",
                    "postgres", "1");
            if (conn != null)
                System.out.println("Veritabanına bağlandı!");
            else
                System.out.println("Bağlantı girişimi başarısız!");


            String sql= "SELECT \"kullaniciAdi\", \"sifre\"  FROM \"kullanici\"";

            /***** Sorgu çalıştırma *****/
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            /***** Bağlantı sonlandırma *****/
            conn.close();

            String ad;
            int pass;

            while(rs.next())
            {
                /***** Kayda ait alan değerlerini değişkene ata *****/
                ad  = rs.getString("kullaniciAdi");
                pass = rs.getInt("sifre");
                if(kullaniciAdi.equals(ad) && sifre == pass)
                    return true;
                else
                    return false;
            }
            
            /***** Kaynakları serbest bırak *****/
            rs.close();
            stmt.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return false;
    }
}
