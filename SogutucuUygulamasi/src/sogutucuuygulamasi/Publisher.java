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
import java.util.ArrayList;
import java.util.List;

public class Publisher implements ISubject{
    private List<IObserver> subscribers = new ArrayList<>();

    @Override
    public void attach(IObserver o) {
        subscribers.add(o);
    }

    @Override
    public void detach(IObserver o) {
        subscribers.remove(o);
    }

    @Override
    public void notify(String m) {
        subscribers.forEach((subscriber) -> {
            subscriber.guncelle(m);
        });
    }
}
