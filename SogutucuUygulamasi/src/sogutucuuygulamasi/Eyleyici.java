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
public class Eyleyici implements IEyleyici { 
    //singleton pattern
    private static final Eyleyici obj = new Eyleyici();
    
    private Eyleyici() {}
    
    public static Eyleyici getObj()
    {
        return obj;
    }
    
    @Override
    public String sogutucuAc()
    {
        return ("Sogutucu Başlatıldı...");
    }

    @Override
    public String sogutucKapat() 
    {
        return ("Sogutucu Durduruldu...");
    }

 
}
