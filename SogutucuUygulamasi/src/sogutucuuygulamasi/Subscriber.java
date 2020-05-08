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
public class Subscriber implements IObserver{

    @Override
    public void guncelle(String m) {
        System.out.println("Admine gelen mesaj --->" + m);
    }
    
}
