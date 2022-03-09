import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Menu menu = new Menu();
        while (true) {
            menu.printMenu();
            try {
                System.out.println("Выберите пункт меню:");
                Scanner sc = new Scanner(System.in);
                int menu_item = sc.nextInt();
                menu.checkMenuItem(menu_item);
//                menu.checkMenuItem(5);
                System.out.print("Нажми Enter, чтобы перейти в меню");
                if ((char) System.in.read() == '\n') {
                    continue;
                }
            } catch (Exception e) {
                System.out.println("Введите число!");
            }
        }
    }
}
