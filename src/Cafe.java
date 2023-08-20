import java.util.ArrayList;
import java.util.Scanner;

public class Cafe {

    public static final int MILK_PER_CUP = 200; // in ml
    public static final int COFFEE_BEANS_PER_CUP = 20; // in g
    int staffNumber;
    int coffeeBeanPacks;
    int milkPacks;
    int paperCups;
    int customerNum;
    ArrayList<Customer> customers = new ArrayList<>();
    String option = "";
    Manager manager;
    Scanner sc = new Scanner(System.in);

    Cafe() {
        cafeSetting();

        while(!option.equals("11")) {

            System.out.println();
            System.out.println(
                    "1 - orderMenu\n" +
                            "2 - checkInventory\n" +  // inventory gram  //
                            "3 - addInventory\n" +
                            "4 - checkDept\n" +   //
                            "5 - checkProfit\n" + //
                            "6 - checkProperty\n" + //
                            "7 - giveSalary\n" +
                            "8 - cafe status\n" +
                            "9 - checkRecipe\n" +
                            "10 - showStaffInfo\n" +
                            "11 - quit"
            );


            System.out.print("Which option do you want? ");
            option = sc.next();
            System.out.println();


            switch (option) {
                case "1":
                    orderMenu();
                    break;
                case "2":
                    checkInventory();
                    break;
                case "3":
                    addInventory();
                    break;
                case "4":
                    checkDept();
                    break;
                case "5":
                    checkProfit();
                    break;
                case "6":
                    checkProperty();
                    break;
                case "7":
                    giveSalary();
                    break;
                case "8":
                    System.out.println(manager.toString());
                    break;
                case "9":
                    checkRecipe();
                    break;
                case "10":
                    showStaffInfo();
                    break;
                case "11":
                    break;
            }
        }
    }

    void cafeSetting() {
        System.out.println("Cafe information");


        System.out.print("How much dept does cafe have? ");
        Manager.dept = sc.nextInt();


        System.out.print("How many staffs? ");
        staffNumber = sc.nextInt();

        Record.records = new ArrayList<>();
        for (int i = 0; i < staffNumber; i++) {

            System.out.print("Staff ID? ");
            int staffId = sc.nextInt();

            System.out.print("Staff Name? ");
            String staffName = sc.next();

            System.out.print("Staff salary? ");
            int staffSalary = sc.nextInt();

            Record record = new Manager(staffId, staffName, staffSalary);
            Record.records.add(record);
        }

        System.out.println("\nCafe Inventory\n");
        System.out.println();
        System.out.println("Price of 1 coffee bean pack(" + COFFEE_BEANS_PER_CUP + "g) is 1$");
        System.out.print("How many coffee bean Packs? ");  // all coffee need 20g beans
        coffeeBeanPacks = sc.nextInt();


        System.out.println();
        System.out.println("Price of 1 milk pack(" + MILK_PER_CUP + "ml) is 1$");
        System.out.print("How many milk Packs? ");  // latte, flat white and cap need 200ml milk
        milkPacks = sc.nextInt();


        System.out.println();
        System.out.println("Price of 1 paper cup is 1$");
        System.out.print("How many paper cups? ");
        paperCups = sc.nextInt();

        Manager.dept = Manager.dept + coffeeBeanPacks + milkPacks + paperCups;

        manager = new Manager(coffeeBeanPacks, milkPacks, paperCups);
    }


    void orderMenu() {
        System.out.print("How many customers? ");
        customerNum = sc.nextInt();
        for (int i = 0; i < customerNum; i++) {
            System.out.print("Member?(true or false) ");
            boolean isMember = sc.nextBoolean();
            Customer customer;
            if (isMember) {
                customer = new Member();
                Menu menu = customer.selectMenu();
                boolean sugar = customer.withSugar();
                customer = new Member(menu, sugar);
            }
            else {
                customer = new NonMember();
                Menu menu = customer.selectMenu();
                boolean sugar = customer.withSugar();
                customer = new NonMember(menu, sugar);
            }
            customers.add(customer);
        }
        manager.processOrder(customers);
        customers = new ArrayList<>();
    }


    void checkInventory() {
        manager.calculateInventory();
    }

    void addInventory() {
        System.out.println();
        System.out.println("Add Inventory");
        System.out.println();
        System.out.println("Price of 1 coffee bean pack(20g) is 1$");
        System.out.print("How many more coffee bean packs(20g)? ");  // all coffee need 20g beans
        int addedCoffeeBeanPacks = sc.nextInt();
        manager.setCoffeeBeanPacks(addedCoffeeBeanPacks + manager.getCoffeeBeanPacks());

        System.out.println();
        System.out.println("Price of milk per 200ml is 1$");
        System.out.print("How many more milk packs(200ml)? ");  // latte, flat white and cap need 200ml milk
        int addedMilkPacks = sc.nextInt();
        manager.setMilkPacks(addedMilkPacks + manager.getMilkPacks());


        System.out.println();
        System.out.println("Price of 1 paper cup is 1$");
        System.out.print("How many more paper cups? ");
        int addedPaperCups = sc.nextInt();
        manager.setPaperCups(addedPaperCups + manager.getPaperCups());

        Manager.dept = Manager.dept + addedCoffeeBeanPacks + addedMilkPacks + addedPaperCups;
    }

    void checkDept() {
        System.out.println("Dept: " + Manager.dept + "$");
    }


    void checkProfit() {
        System.out.println("Profit: " + Manager.profit + "$");
    }


    void giveSalary() {
        System.out.println();
        manager.giveSalary();
    }
    void checkProperty() {
        System.out.println();
        System.out.println("Current property is " + manager.calculateProperty() + "$");
    }
    void checkRecipe() {
        System.out.println();
        System.out.println(this.toString());
    }

    void showStaffInfo() {
        System.out.print("Staff ID: ");
        int id = sc.nextInt();

        Record record = manager.find(id);
        record.show();
    }

    @Override
    public String toString() {
        return "Latte, FlatWhite, Cappuccino: Milk " + MILK_PER_CUP + "ml CoffeeBeans: " + COFFEE_BEANS_PER_CUP + "g" + "\n"
                + "LongBlack, Espresso: coffeeBean " + COFFEE_BEANS_PER_CUP + "g";
    }
}
