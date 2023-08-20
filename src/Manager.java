import java.util.ArrayList;


public class Manager extends Record
{
    Manager(int id, String name, int salary) {
        super(id, name, salary);
    }

    public int getCoffeeBeanPacks() {
        return coffeeBeanPacks;
    }

    public void setCoffeeBeanPacks(int coffeeBeanPacks) {
        this.coffeeBeanPacks = coffeeBeanPacks;
    }

    public int getMilkPacks() {
        return milkPacks;
    }

    public void setMilkPacks(int milkPacks) {
        this.milkPacks = milkPacks;
    }

    public int getPaperCups() {
        return paperCups;
    }

    public void setPaperCups(int paperCups) {
        this.paperCups = paperCups;
    }

    static int dept;
    static int profit = 0;

    public Manager(int coffeeBeanPacks, int milkPacks, int paperCups) {
        super(coffeeBeanPacks, milkPacks, paperCups);
    }


    public int calculateProperty() {
        return profit - dept;
    }

    public void calculateInventory() {
        int weighOfCoffeeBean = coffeeBeanPacks * Cafe.COFFEE_BEANS_PER_CUP;
        int volumeOfMilk = milkPacks * Cafe.MILK_PER_CUP;
        System.out.println(
                "Inventory\n" +
                        "Coffee bean - " + weighOfCoffeeBean + "g\n" +
                        "Milk - " + volumeOfMilk + "ml\n" +
                        "Paper cup - " + paperCups + "cups\n"
        );
    }


    public void processOrder(ArrayList<Customer> customers) {  // order available by inventory
        for (Customer customer : customers) {
            if (customer instanceof Member) {
                if (customer.getMenu().ingredients.length > 2) { // ingredients are coffee bean, milk, paper cup
                    if (coffeeBeanPacks >= 1 && milkPacks >= 1 && paperCups >= 1) {
                        this.setCoffeeBeanPacks(coffeeBeanPacks - 1);
                        this.setMilkPacks(milkPacks - 1);
                        this.setPaperCups(paperCups - 1);

                        profit = profit + customer.getMenu().price - 1;
                        System.out.println(customer.toString());
                    }
                    else {
                        System.out.println("Not enough inventory -> Order failed");
                    }
                }
                else { // ingredients are coffee bean, paper cup
                    if (coffeeBeanPacks >= 1 && paperCups >= 1) {
                        this.setCoffeeBeanPacks(coffeeBeanPacks - 1);
                        this.setPaperCups(paperCups - 1);


                        profit = profit + customer.getMenu().price - 1;
                        System.out.println(customer.toString());
                    }
                    else {
                        System.out.println("Not enough inventory -> Order failed");
                    }
                }
            }
            else {
                if (customer.getMenu().ingredients.length > 2) { // ingredients are coffee bean, milk, paper cup
                    if (coffeeBeanPacks >= 1 && milkPacks >= 1 && paperCups >= 1) {
                        this.setCoffeeBeanPacks(coffeeBeanPacks - 1);
                        this.setMilkPacks(milkPacks - 1);
                        this.setPaperCups(paperCups - 1);

                        profit = profit + customer.getMenu().price;
                        System.out.println(customer.toString());
                    }
                    else {
                        System.out.println("Not enough inventory -> Order failed");
                    }
                }
                else { // ingredients are coffee bean, paper cup
                    if (coffeeBeanPacks >= 1 && paperCups >= 1) {
                        this.setCoffeeBeanPacks(coffeeBeanPacks - 1);
                        this.setPaperCups(paperCups - 1);

                        profit = profit + customer.getMenu().price;
                        System.out.println(customer.toString());
                    }
                    else {
                        System.out.println("Not enough inventory -> Order failed");
                    }
                }
            }
        }

    }

    public Record find(int id) {
        return super.find(id);
    }

    public void show() {
        System.out.println(super.toString());
    }

    public void giveSalary() {
        super.giveSalary();
    }

    @Override
    public String toString() {
        return "Current profit is " + profit + "$\n"
                + "Current dept is " + dept + "$\n" +
                "Current Staff" + "\n" +
                "Staff Number: " + records.size() + "\n" +
                "Current inventory" + "\n"
                + "Coffee bean: " + coffeeBeanPacks * Cafe.COFFEE_BEANS_PER_CUP + "gram\n"
                + "Milk: " + milkPacks * Cafe.MILK_PER_CUP + "ml\n"
                + "Paper cups: " + paperCups + "cups";
    }
}
