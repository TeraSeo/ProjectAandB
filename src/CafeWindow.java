import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CafeWindow extends JFrame{

    private SettingPagePanel settingPagePanel = new SettingPagePanel();

    JLabel deptL, staffNumL, staffIdL, staffNameL, staffSalaryL, coffeeBeanPacksL, milkPacksL, paperCupsL;
    JTextField deptT, staffNumT, staffIdT, staffNameT, staffSalaryT, coffeeBeanPacksT, milkPacksT, paperCupsT;
    JButton staffNumB;

    CafeWindow() {
        super("Cafe Window");
        cafeSettingGUI();
    }

    public void cafeSettingGUI() {
        buildSettingPage();
        setupSettingPage();
        setVisible(true);
    }

    public static void main(String[] args) {
        CafeWindow cafeGUI = new CafeWindow();
    }

    private void setupSettingPage() {
        setSize(280, 600);
        setLocation(500, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    private void buildSettingPage() {
        add(settingPagePanel);
    }

    public class SettingPagePanel extends JPanel implements ActionListener {

        public SettingPagePanel() {

            deptL = new JLabel("Dept");
            staffNumL = new JLabel("Staff Num");
            staffIdL = new JLabel("Staff ID");
            staffNameL = new JLabel("Staff Name");
            staffSalaryL = new JLabel("Staff Salary");
            coffeeBeanPacksL = new JLabel("Coffee Bean Packs");
            milkPacksL = new JLabel("Milk Packs");
            paperCupsL = new JLabel("Paper Cups");

            deptT = new JTextField(20);
            staffNumT = new JTextField(10);
            staffIdT = new JTextField(20);
            staffNameT = new JTextField(20);
            staffSalaryT = new JTextField(20);
            coffeeBeanPacksT = new JTextField(20);
            milkPacksT = new JTextField(20);
            paperCupsT = new JTextField(20);

            staffNumB = new JButton("Staff Num");

            add(deptL);
            add(deptT);

            add(coffeeBeanPacksL);
            add(coffeeBeanPacksT);

            add(milkPacksL);
            add(milkPacksT);

            add(paperCupsL);
            add(paperCupsT);

//            add(staffNumL);
            add(staffNumT);
            add(staffNumB);

            add(staffIdL);
            add(staffIdT);

            add(staffNameL);
            add(staffNameT);

            add(staffSalaryL);
            add(staffSalaryT);

        }

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

}
