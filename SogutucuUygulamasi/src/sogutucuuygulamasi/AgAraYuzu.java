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
public class AgAraYuzu implements IAgAraYuzu{   
    ISubject publisher;
    
    public AgAraYuzu(ISubject publisher)
    {
        this.publisher = publisher;
    }
    
    @Override
    public int sicaklikGonder() {
        int sicaklik = MerkeziIslemBirimi.getObj().sicaklikGoruntule();
        publisher.notify("Ortam Sıcaklığı: " + sicaklik + " derece");
        return sicaklik;
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
