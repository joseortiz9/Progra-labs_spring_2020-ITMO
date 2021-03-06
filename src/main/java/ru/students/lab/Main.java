package ru.students.lab;

/**
 * Класс для запуска клиента или сервера
 * @autor Хосе Ортис
 * @version 1.0
 */
public class Main {

    public static void main( String[] args) {
        String mode = System.getProperty("mode").toLowerCase();
        if (mode.equals("client"))
            ClientUIMain.main(args);
        else if (mode.equals("server"))
            ServerMain.main(args);
        else
            System.err.println("What are u trying to do? only write:\n-Dmode=client/-Dmode=server");
    }
}
