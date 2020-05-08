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
import static java.lang.System.exit;
import java.sql.SQLException;
import java.util.Scanner;

public class SogutucuCihazı {
    private final IAgAraYuzu araYuz;
    private final IAgAraYuzu araYuzf;
    private final SogutucuBilgiSistemi sistem;
    Subscriber admin;
    Publisher p;
    private final Scanner input;
    
    //menü işlemlerib
    private static final int SOGUTUCU_BASLAT = 1;
    private static final int SOGUTUCU_DURDUR= 2;
    private static final int SICAKLIK_GORUNTULE = 3;
    private static final int SOGUTUCU_AC = 1;
    private static final int CIKIS = 2;
    
    public SogutucuCihazı()
    {                        
        sistem = new SogutucuBilgiSistemi();
        admin = new Subscriber();
        p = new Publisher();
        p.attach(admin);
        araYuz = new AgAraYuzu(p);
        araYuzf = new AgAraYuzuFahrenheit(p);
        input = new Scanner(System.in);
    }
    
    public void basla() throws SQLException
    {   
        secimIslemi();
    }
    
    private void secimIslemi() throws SQLException
    {
        int secim;
        secim = anaMenu();
        if(secim == SOGUTUCU_AC)
        {
            if(login())
            {
                System.out.println("Başarılı bir şekilde giriş yapıldı...");
                do{
                    int secim2 = menu();
                    switch (secim2) {
                        case SOGUTUCU_BASLAT:
                            System.out.println(araYuz.acildiBildirimi());
                            durumKontrol(secim2);
                            break;
                        case SOGUTUCU_DURDUR:
                            System.out.println(araYuz.kapandiBildirimi());
                            durumKontrol(secim2);
                            secimIslemi();
                            break;
                        case SICAKLIK_GORUNTULE:
                            System.out.println("Cihaz üzerinde gözüken mesaj --> Ortam Sıcaklığı : " + araYuzf.sicaklikGonder() + " fahrenheit");//open-closed ilkesi örneği
                            System.out.println("Cihaz üzerinde gözüken mesaj --> Ortam Sıcaklığı : " + araYuz.sicaklikGonder() + " derece");//open-closed ilkesi örneği
                            break;
                        default:
                            break;
                    }
                }while(secim != 2);
            }
            else
            {  
                System.out.println("Çıkış yapılıyor...");
            }
            exit(0);
        }
        else if(secim == CIKIS)
        {
            System.out.println("Sistemden çıkış yapıldı...");
            exit(0);
        }
    }
    private int anaMenu()
    {
        Scanner giris = new Scanner(System.in);
        
        System.out.println("******************************************");
        System.out.println("Ana Menü");
        System.out.println("1-Sogutucu Ac");
        System.out.println("2-Cikis");
        System.out.println("Seciminiz:");
        System.out.println("******************************************");
        
        return giris.nextInt();
    }
    private int menu()
    {
        Scanner giris = new Scanner(System.in);
        
        System.out.println("******************************************");
        System.out.println("Menü");
        System.out.println("1-Sogutucu Baslat");
        System.out.println("2-Sogutucu Durdur");
        System.out.println("3-Sıcaklık Görüntüle");
        System.out.println("Seciminiz:");
        System.out.println("******************************************");
        
        return giris.nextInt();
    }
    private boolean login() throws SQLException
    {       
        String kullaniciAdi;
        int sifre;
        for(int i = 1; i <= 3; i++)
        {
            System.out.println("Kullanici adinizi giriniz...");
            kullaniciAdi = input.next();
            System.out.println("Sifrenizi Giriniz...");
            sifre = input.nextInt();
            if(kullaniciDogrulama(kullaniciAdi, sifre))
                return true;
            else
                System.out.println("Yanlış kullanıcı adı veya şifre. Lütfen kontrol ediniz...");
        }
        
        return false;
    }
    private boolean kullaniciDogrulama(String kullaniciAdi, int sifre) throws SQLException
    {
        return sistem.kullaniciDogrula(kullaniciAdi, sifre);
    }
    
    private void durumKontrol(int secim)
    {
        if(secim == 1)
            System.out.println("Algılama ve Kontrol Durumuna Geçildi...");
        else if(secim == 2)
            System.out.println("Cihaz kapalı durumdadır.");
        else if(secim == 3)
            System.out.println("Algılama ve Kontrol Durumuna Geçildi...");
    }
}
