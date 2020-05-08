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
public class MerkeziIslemBirimi implements IMerkeziIslemBirimi{
    //singleton pattern ile nesne oluşturma
    private static final MerkeziIslemBirimi obj = new MerkeziIslemBirimi();
    
    private MerkeziIslemBirimi() {}
    
    public static MerkeziIslemBirimi getObj()
    {
        return obj;
    }
    //ağ arayüzünden gelen isteğe cevaplar
    @Override
    public int sicaklikGoruntule()//sicaklik görünteleme isteğine cevap
    {
        return SicaklikAlgilayici.getObj().sicaklikOlc(); //singleton pattern ile oluşturduğumuz nesne üzeriden fonksiyona erişiyoruz.
    }

    @Override
    public String sogutucuAcIstegi() //soğutucu aç isteğine cevap
    {
        return Eyleyici.getObj().sogutucuAc(); //singleton pattern ile oluşturduğumuz nesne üzeriden fonksiyona erişiyoruz.
    }

    @Override
    public String sogutucuKapatIstegi() //sogutucu kapat isteğine cevap
    {
        return Eyleyici.getObj().sogutucKapat(); //singleton pattern ile oluşturduğumuz nesne üzeriden fonksiyona erişiyoruz.
    }
    
}
