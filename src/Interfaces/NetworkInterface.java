/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.net.Socket;

/**
 *
 * @author Daniel
 */
public interface NetworkInterface {
    public void setSocket(Socket s);
    public void setObserver(ObserverInterface observer);
}
