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
public class AgAraYuzuFahrenheit implements IAgAraYuzu{
    ISubject publisher;
    
    public AgAraYuzuFahrenheit(ISubject publisher)
    {
        this.publisher = publisher;
    }
    
    
    @Override
    public int sicaklikGonder() {
        int sicaklik = MerkeziIslemBirimi.getObj().sicaklikGoruntule();
        double fahrenheit = (sicaklik * 1.8) + 32;
        publisher.notify("Ortam Sıcaklığı: " + fahrenheit + " fahrenheit.");
        return (int)fahrenheit;
    }

    @Override
    public String kapandiBildirimi() {
        return MerkeziIslemBirimi.getObj().sogutucuKapatIstegi();
    }

    @Override
    public String acildiBildirimi() {
        return MerkeziIslemBirimi.getObj().sogutucuAcIstegi();
    }
    
}
