package Interfaces;

/**
 *
 *
 * @author Daniel
 */
public interface SubjectInterface{

    public void registerObserver(ObserverInterface observer);
    public void notifyObserver();
}
