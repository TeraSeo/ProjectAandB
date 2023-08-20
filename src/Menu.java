import java.util.ArrayList;

public enum Menu {

    LATTE("Latte", 4, new String[]{"Coffee bean", "Milk", "Paper cup"}),
    FLATWHITE("FlatWhite", 4, new String[]{"Coffee bean", "Milk", "Paper cup"}),
    CAP("Cappuccino", 4, new String[]{"Coffee bean", "Milk", "Paper cup"}),
    LONGBLACK("LongBlack", 3, new String[]{"Coffee bean", "Paper cup"}),
    ESPRESSO("Espresso", 3, new String[]{"Coffee bean", "Paper cup"});

    public String name;
    public int price;
    public String[] ingredients;

    Menu(String name, int price, String[] ingredients) {
        this.name = name;
        this.price = price;
        this.ingredients = ingredients;
    }
}
