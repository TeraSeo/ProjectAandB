import java.util.Scanner;


public class Member implements Customer{


    Scanner sc = new Scanner(System.in);
    Menu menu;
    boolean sugar;


    @Override
    public Menu getMenu() {
        return menu;
    }


    public Member() {


    }


    public Member(Menu menu, boolean sugar) {
        this.menu = menu;
        this.sugar = sugar;
    }


    @Override
    public Menu selectMenu() {
        System.out.print("menu (Latte - 4$\n FlatWhite - 4$\n Cappuccino - 4$\n LongBlack - 3$\n Espresso - 3$): ");
        String menu = sc.next();
        for (Menu m : Menu.values()) {
            if (m.name.equals(menu)) {
                return m;
            }
        }
        System.out.println("Invalid choice. Please select a valid menu item.");
        return selectMenu(); // Recursive call if an invalid choice is made
    }


    @Override
    public boolean withSugar() {
        System.out.print("With sugar? (true or false) ");
        return sc.nextBoolean();
    }


    @Override
    public String toString() {
        return menu.toString() + " with sugar("+ sugar +") has been ordered (Member -> 1$ discount)";
    }


}
