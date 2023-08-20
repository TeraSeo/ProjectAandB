import java.util.ArrayList;
import java.util.Scanner;

public class Record {

    static ArrayList<Record> records = new ArrayList<>();
    protected int id;
    protected String name;
    protected int salary;

    protected int coffeeBeanPacks;
    protected int milkPacks;
    protected int paperCups;

    Record(int id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    Record(int coffeeBeanPacks, int milkPacks, int paperCups) {
        this.coffeeBeanPacks = coffeeBeanPacks;
        this.milkPacks = milkPacks;
        this.paperCups = paperCups;
    }

    protected Record find(int id) {
        for (Record record : records) {
            if (record.id == id) {
                return record;
            }
        }
        System.out.println("Invalid ID");
        Scanner sc = new Scanner(System.in);
        System.out.print("Staff ID: ");
        return find(sc.nextInt());
    }

    protected void giveSalary() {
        int wholeSalary = 0;
        for (Record record : records) {
            wholeSalary += record.salary;
        }
        Manager.dept = Manager.dept + wholeSalary;
        System.out.println("whole salary: " + wholeSalary + "$");
    }

    protected void show() {
        System.out.println(id);
    }

    @Override
    public String toString() {
        return  "ID: " + id +
                "\nName: " + name +
                "\nSalary: " + salary +"$";
    }
}
