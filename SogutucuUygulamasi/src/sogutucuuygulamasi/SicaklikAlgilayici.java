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

import java.util.Random;
        
public final class SicaklikAlgilayici implements ISicaklikAlgilayici {
    
    private static final SicaklikAlgilayici obj = new SicaklikAlgilayici();
    private static int sicaklik;
    private SicaklikAlgilayici() {
        sicaklik = sicaklikOlc();
    }
    
    public static SicaklikAlgilayici getObj()
    {
        return obj;
    }
    
    @Override
    public int sicaklikOlc() 
    {
        Random sicaklik = new Random();
        
        int ortamSicakligi = (sicaklik.nextInt(32) + 8);
        
        return ortamSicakligi;
    }
    
    public int getSicaklik()
    {
        return sicaklik;
    }
}
