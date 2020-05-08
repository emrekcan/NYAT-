/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sogutucuuygulamasi;

import java.sql.SQLException;

/**
 *
 * @author emree
 */
public class SogutucuUygulamasi {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
       SogutucuCihazı cihaz = new SogutucuCihazı();
       cihaz.basla();
    }
    
}
