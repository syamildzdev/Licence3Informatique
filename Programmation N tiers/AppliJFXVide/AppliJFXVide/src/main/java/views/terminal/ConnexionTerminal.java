package views.terminal;

import views.ConnexionInterface;

import java.util.Scanner;

public class ConnexionTerminal  implements ConnexionInterface{
    @Override
    public void show() {
        System.out.println("Saisir votre login !");
        //Scanner scanner = new Scanner();
        //primaryStage.show();
    }

    @Override
    public void showMessageErreur(String messageErreur) {

    }
}
