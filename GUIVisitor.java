package OOP.ec22954.MP;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintStream;
import java.io.InputStream;
import java.util.Scanner;

class GUIVisitor implements Visitor {

    JFrame db = new JFrame();

    private JPanel MainPanel;
    JButton Accept_btn; // Not Inside ComboBox
    private JButton A_btn;
    private JButton B_btn;
    private JButton C_btn;
    private JButton D_btn;

    JComboBox ListBox;
    private JTextField InputTextField;
    private JButton Input_btn;

    private JLabel Current_Gold;



    static enum Semaphore {WAITING,ACCEPT, REJECT};
    private JTextArea TellText;
    private JScrollPane scrollpane;
    JPanel buttonPanel = new JPanel();

    Semaphore CLICK_ACCEPT = Semaphore.WAITING;

    private PrintStream out;
    private Scanner in;
    private int purse;
    private Item[] items;
    private int next;

    protected int yesno = 0;
    protected String chosen;
    protected String InputText;
    protected boolean submitIsClicked;
    protected boolean inputIsClicked;

    public void resetBs(){
        A_btn.setEnabled(false);
        B_btn.setEnabled(false);
        C_btn.setEnabled(false);
        D_btn.setEnabled(false);
        yesno = 0;
    }

    public void turnOnBs(){
        A_btn.setEnabled(true);
        B_btn.setEnabled(true);
        C_btn.setEnabled(true);
        D_btn.setEnabled(true);
    }




    public GUIVisitor (PrintStream ps, InputStream is) {

        Accept_btn.setEnabled(false);
        buttonPanel.setLayout(new FlowLayout());

        Accept_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                CLICK_ACCEPT = Semaphore.ACCEPT;
            }
        });

        A_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                B_btn.setEnabled(false);
                C_btn.setEnabled(false);
                D_btn.setEnabled(false);

                yesno = 1;
            }
        });

        B_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                A_btn.setEnabled(false);
                C_btn.setEnabled(false);
                D_btn.setEnabled(false);
                yesno = 2;
            }
        });

        C_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                A_btn.setEnabled(false);
                B_btn.setEnabled(false);
                D_btn.setEnabled(false);
               yesno = 3;
            }
        });

        D_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                A_btn.setEnabled(false);
                B_btn.setEnabled(false);
                C_btn.setEnabled(false);
                yesno = 4;
            }
        });


        // Have to extend the window to view the buttons
        // - Accept Button Layout
        db.getContentPane().add(MainPanel);
        scrollpane.setViewportView(TellText);
        scrollpane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        // Other Button Layouts:

        db.setTitle("GUIVisitor by ec22954");
        db.setSize(1000, 800);
        db.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        db.setVisible(true);


        out = ps;
        in = new Scanner(is);
        purse = 0;
        items = new Item[1000];
        next = 0;

        Input_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                InputText = InputTextField.getText();
                inputIsClicked = true;
            }
        });
    }


    private static final char[] yOrN = { 'y', 'n'};

    public void tell(String m) {

        TellText.append(m); // Code to be added
    }

    public String getInputText(){
        inputIsClicked = false;
        Input_btn.setEnabled(true);
        InputTextField.setEnabled(true);

        while(!inputIsClicked) {
            db.repaint();
        }
        String s = InputText;
        tell("\n" + s);
        InputText = "";
        inputIsClicked = true;
        Input_btn.setEnabled(false);
        InputTextField.setEnabled(false);
        InputTextField.setText("");
        return s;
    }

    // full set of options, took hours :(
    public char getChoice(String d, char[] a) {

        tell(d);
        if(a[0] == 'a' && a[1] == 'b' && a[2] == 'c') {
            while (yesno == 0){
                turnOnBs();
            }

            if (yesno == 1){
                resetBs();
                return 'a';
            }
            else if (yesno == 2){
                resetBs();
                return 'b';
            }
            else if (yesno == 3){
                resetBs();
                return 'c';
            }
            else if (yesno == 4){
                resetBs();
                return 'd';
            }
            else{
                resetBs();
                return '?';
            }
        }
        if(a[0] == 'a' && a[1] == 'b' && a[2] == 'c') {
            while (yesno == 0){
                turnOnBs();
                D_btn.setEnabled(false);
            }

            if (yesno == 1){
                resetBs();
                return 'a';
            }
            else if (yesno == 2){
                resetBs();
                return 'b';
            }
            else if (yesno == 3){
                resetBs();
                return 'c';
            }
            else{
                resetBs();
                return '?';
            }
        }
        if(a[0] == 'a' && a[1] == 'b') {
            while (yesno == 0){
                turnOnBs();
                C_btn.setEnabled(false);
                D_btn.setEnabled(false);
            }

            if (yesno == 1){
                resetBs();
                return 'a';
            }
            else if (yesno == 2){
                resetBs();
                return 'b';
            }
            else{
                resetBs();
                return '?';
            }
        }
        else if (a.length !=0) {
            submitIsClicked = false;
            Accept_btn.setEnabled(true);
            ListBox.setEnabled(true);

            for (int i = 0; i < a.length; i ++) {
                ListBox.addItem(a[i]);
            }
            while(!submitIsClicked){
                db.repaint();
            }

            char chosenChar = chosen.charAt(0);
            ListBox.setEnabled(false);
            Accept_btn.setEnabled(false);
            boolean found = false;
            int i = 0;

            do{
                if (chosenChar == a[i]){
                    found = true;
                }
                i ++;
            }while(!found || (i != a.length));

            chosen = null;
            submitIsClicked = false;
            if (found){
                tell("/" + chosenChar);
                return chosenChar;
            }
            else{
                return '?';
            }


        }



        if (!in.hasNextLine()) {
            tell("'No line' error");
            return '?';
        }
        String t = in.nextLine();
        if (t.length() > 0)
            return t.charAt(0);
        else {
            if (a.length > 0) {
                tell("Returning " + a[0]);
                return a[0];
            } else {
                tell("Returning '?'");
                return '?';
            }
        }
    }

    public boolean giveItem(Item x) {
        tell("\n You have: \n");
        for (int i=0;i<next;i++) tell( items[i] + ",");
        Accept_btn.setText("\n Accept "+x.name + "? \n");
        if (next >= items.length) {
            tell("\n But you have no space and must decline. \n");
            return false;
        }

        // Waiting for press of button
        CLICK_ACCEPT = Semaphore.WAITING;
        Accept_btn.setEnabled(true);
        while (CLICK_ACCEPT == Semaphore.WAITING) {
            db.repaint();
        }
        ListBox.addItem(x + "\n");
        Accept_btn.setEnabled(false);


        if (CLICK_ACCEPT == Semaphore.ACCEPT) {
            items[next] = x;
            next++;
            return true;
        } else return false;
    }

    public boolean hasIdenticalItem(Item x) {
        for (int i=0; i<next;i++)
            if (x == items[i])
                return true;
        return false;
    }

    public boolean hasEqualItem(Item x) {
        for (int i=0; i<next;i++)
            if (x.equals(items[i]))
                return true;
        return false;
    }

    public void giveGold(int n) {
        tell("You are given "+n+" gold pieces.");
        purse += n;
        tell("You now have "+purse+" pieces of gold.");
        Current_Gold.setText("Gold: " + purse);
    }

    public int takeGold(int n) {

        if (n<0) {
            tell("A scammer tried to put you in debt to the tune off "+(-n)+"pieces of gold,");
            tell("but you didn't fall for it and returned the 'loan'.");
            return 0;
        }

        int t = 0;
        if (n > purse) t = purse;
        else t = n;

        tell(t+" pieces of gold are taken from you.");
        purse -= t;
        tell("You now have "+purse+" pieces of gold.");
        Current_Gold.setText(("Gold: " + purse));

        return t;
    }
}
