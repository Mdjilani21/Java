package project1;

/**
 * Created by Bayzid on 05/05/2017.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class BankService {


    private JFrame Welcome;
    private JFrame Adminloginframe;
    private JPanel panelMain;
    private JPanel MainMenu;
    private JButton Adminlogin;
    private JPanel Adminloginpannel;
    private JFrame CustomerLoginframe;
    private JButton Customerlogin;
    private JPanel Customerloginpannel;
    private JButton signinButton;
    private JFrame signinframe;
    private JPanel signinpanel;
    private JLabel snid;
    private JTextField snid1;
    private JLabel snpassword;
    private JPasswordField snpassword1;
    private JButton signinok;
    private JFrame signinenterframe;
    private JPanel signinenterpanel;
    private JButton Depositbutton;
    private JFrame Deposittframe;
    private JPanel Deposittpanel;
    private JButton Withdrawbutton;
    private JFrame Withdrawframe;
    private JPanel Withdrawpanel;
    private JButton Accountinfobutton;
    private JFrame Accountinfoframe;
    private JPanel Accountinfopanel;
    private JButton createAccountButton;
    private JFrame crateAccountframe;
    private JPanel createAccountpanel;
    private JLabel caname;
    private JTextField caname1;
    private JLabel capassword;
    private JPasswordField capassword1;
    private JLabel cainbalance;
    private JTextField cainbalance1;
    private JButton Create;
    private JButton BalanceTransefer;
    private JFrame BalanceTransferFrame;
    private JPanel BalanceTransferPanle;
    private JButton Transfer;
    private JLabel Trnsfracid;
    private JTextField Trnsfracid1;
    private JLabel amount;
    private JTextField amount1;
    private JButton Back;
    private JButton Signout;
    private JButton Exit;

    private String account;
    private boolean flag = false;
    private String localId;
    private String localPassword;



    public BankService()

    {
        gui();
    }

    public void gui(){

        {
            Welcome = new JFrame("ATM BOOTH");
            Welcome.setVisible(true);
            Welcome.setSize(600,600);
            Welcome.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            Welcome.setLocationRelativeTo(null);

            MainMenu = new JPanel(new GridBagLayout());

            Customerlogin = new JButton("Customer Login");
            Customerlogin.addActionListener((ActionEvent e)->{
                showLoginSection();

            });


            GridBagConstraints c = new GridBagConstraints();
            c.insets = new Insets(10,10,10,10);
            c.gridx = 0;
            c.gridy = 1;

            MainMenu.add(Customerlogin,c);

            //Welcome.add(MainMenu);


//            panelMain = new JPanel();

            Adminlogin = new JButton("Admin Login");

            Adminlogin.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    showAdminSection();

                }
            });


            Exit = new JButton("Exit");
            Exit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);

                }
            });


            c.gridx = 0;
            c.gridy = 2;
            MainMenu.add(Adminlogin,c);

            c.gridx = 0;
            c.gridy = 3;
            MainMenu.add(Exit,c);

            Welcome.add(MainMenu);
        }

    }

    private void showLoginSection() {
        Adminloginframe = new JFrame("Customer Login Page");
        Adminloginframe.setVisible(true);
        Welcome.setVisible(false);
        Adminloginframe.setSize(400,400);
        Adminloginframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Adminloginframe.setLocationRelativeTo(null);

        Adminloginpannel = new JPanel(new GridBagLayout());

        signinButton = new JButton("Sign In");

        signinButton.addActionListener((ActionEvent e)->{
            showSignInSection();
        });

        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(10,10,10,10);
        c.gridx = 0;
        c.gridy = 1;

        Adminloginpannel.add(signinButton,c);


        BalanceTransefer = new JButton("Balance Transfer");

        BalanceTransefer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                showBalanceTransferSection();
            }
        });

        c.gridx = 0;
        c.gridy = 2;

        Adminloginpannel.add(BalanceTransefer,c);

        Back = new JButton("Back");
        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Adminloginframe.dispose();
                Welcome.setVisible(true);
            }
        });

        c.gridx = 0;
        c.gridy = 3;

        Adminloginpannel.add(Back,c);


        Exit = new JButton("Exit");
        Exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //System.exit(0);
                Adminloginframe.dispose();

            }
        });

        c.gridx = 0;
        c.gridy = 4;

        Adminloginpannel.add(Exit,c);

        Adminloginframe.add(Adminloginpannel);
    }

    private void showSignInSection() {
        signinframe = new JFrame("SignIn Page");
        signinframe.setVisible(true);
        Adminloginframe.setVisible(false);
        signinframe.setSize(250, 280);
        signinframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        signinframe.setLocationRelativeTo(null);

        signinpanel = new JPanel();


        snid = new JLabel("ID");
        snid1 = new JTextField();
        snid1.setColumns(15);

        snpassword = new JLabel("Password");
        snpassword1 = new JPasswordField();
        snpassword1.setColumns(13);

        signinok = new JButton("Enter");

        signinok.addActionListener((ActionEvent e)->{

            validateSignInInformation();

            if (snid1.getText().equals("") || String.valueOf((snpassword1.getPassword())).equals("")) {
                JOptionPane.showMessageDialog(null, "Invalid Input");
            }

            else if (flag)
            {

                showSigninAccountPageSection();

            }

            else {
                JOptionPane.showMessageDialog(null, "Wrong Username and Password!!");
            }
        });


        signinpanel.add(snid);
        signinpanel.add(snid1);
        signinpanel.add(snpassword);
        signinpanel.add(snpassword1);
        signinpanel.add(signinok);

        Back = new JButton("Back");
        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                signinframe.dispose();
                Adminloginframe.setVisible(true);
            }
        });

//        c.gridx = 0;
//        c.gridy = 2;

        signinpanel.add(Back);

        signinframe.add(signinpanel);
    }

    private void showSigninAccountPageSection() {
        signinenterframe = new JFrame("Signin Account Page");
        signinenterframe.setVisible(true);
        signinframe.setVisible(false);
        signinenterframe.setSize(400, 400);
        signinenterframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        signinenterframe.setLocationRelativeTo(null);

        signinenterpanel = new JPanel(new GridBagLayout());


        Depositbutton = new JButton("Deposit");
        Depositbutton.addActionListener((ActionEvent d)->{
            showDepositeSection();
        });


        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(10, 10, 10, 10);
        c.gridx = 0;
        c.gridy = 1;

        signinenterpanel.add(Depositbutton, c);
        signinenterframe.add(signinenterpanel);


        Withdrawbutton = new JButton("Withdraw");
        Withdrawbutton.addActionListener((ActionEvent w)->{
            showWithdrawSection();

        });

        c.gridx = 0;
        c.gridy = 2;

        signinenterpanel.add(Withdrawbutton, c);
        signinenterframe.add(signinenterpanel);


        Accountinfobutton = new JButton("Account Information");
        Accountinfobutton.addActionListener((ActionEvent a)->{
            showAccountInformationSection();

        });


        c.gridx = 0;
        c.gridy = 3;


        signinenterpanel.add(Accountinfobutton, c);
        signinenterframe.add(signinenterpanel);

        Signout = new JButton("SignOut");
        Signout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                signinenterframe.dispose();
                Adminloginframe.setVisible(true);
            }
        });

        c.gridx = 0;
        c.gridy = 4;

        signinenterpanel.add(Signout,c);
        signinenterframe.add(signinenterpanel);
    }

    private void validateSignInInformation() {
        localId = snid1.getText();
        localPassword = String.valueOf(snpassword1.getPassword());
        int balance = 0;
        //System.out.println("ID: "+localId+"Pass: "+localPassword);
        try {
            FileReader fin = new FileReader("Account.txt");
            BufferedReader br = new BufferedReader(fin);
            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println(/*"Line: "+*/line);
                String[] word = line.split("\\s");

//                                            System.out.println("ID: "+word[0]
//                                            );
//                                            System.out.println("Password: "
//                                                    +word[1]);
//                                            System.out.println("Balance: "
//                                                    +word[2]);

                if (localId.equals(word[0]) && localPassword.equals(word[1])) {
                    flag = true;
                    //break;
                }
            }
            br.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    private void showAdminSection() {
        CustomerLoginframe = new JFrame("Admin Page");
        CustomerLoginframe.setVisible(true);
        Welcome.setVisible(false);
        CustomerLoginframe.setSize(400, 500);
        CustomerLoginframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        CustomerLoginframe.setLocationRelativeTo(null);

        Customerloginpannel = new JPanel(new GridBagLayout());

        createAccountButton = new JButton("Create Account");

        createAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                showAccountCreationSection();

            }
        });

        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(10,10,10,10);
        c.gridx = 0;
        c.gridy = 1;
        Customerloginpannel.add(createAccountButton,c);

        Back = new JButton("Back");
        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CustomerLoginframe.dispose();
                Welcome.setVisible(true);
            }
        });

        c.gridx = 0;
        c.gridy = 2;

        Customerloginpannel.add(Back,c);


        Exit = new JButton("Exit");
        Exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Adminloginframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                //System.exit(0);
                CustomerLoginframe.dispose();
            }
        });

        c.gridx = 0;
        c.gridy = 3;

        Customerloginpannel.add(Exit,c);
        CustomerLoginframe.add(Customerloginpannel);
    }

    private void showAccountCreationSection() {
        crateAccountframe = new JFrame("Create New Account Page");
        crateAccountframe.setVisible(true);
        CustomerLoginframe.setVisible(false);
        crateAccountframe.setSize(250, 280);
        crateAccountframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        crateAccountframe.setLocationRelativeTo(null);

        createAccountpanel = new JPanel();

        caname = new JLabel("Account Holder Name");
        caname1 = new JTextField();
        caname1.setColumns(15);
        capassword = new JLabel("Account Holder Password");
        capassword1 = new JPasswordField();
        capassword1.setColumns(13);
        cainbalance = new JLabel("Enter Initial Balance");
        cainbalance1 = new JTextField();
        cainbalance1.setColumns(15);

        Create = new JButton("Create");
        Create.addActionListener((ActionEvent e)->{
            if (caname1.getText().equals("") || capassword1.getText().equals("") || cainbalance1.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Invalid Input");
            }

            else
            {
                account = caname1.getText();
                insertAccountInfo();

                account = capassword1.getText();
                insertAccountInfo();

                account = cainbalance1.getText();
                insertAccountInfo();
                /*try {
                    FileWriter fout = new FileWriter("Account.txt", true);
                    BufferedWriter bout = new BufferedWriter(fout);
                    bout.write(account);
                    bout.write("\n");
                    bout.close();
                    fout.close();
                } catch (Exception ae) {
                    ae.printStackTrace();
                }*/
                JOptionPane.showMessageDialog(null, "Welcome to Our World! Your Account has been Created");

                Welcome.setVisible(true);
                //System.exit(0);
                crateAccountframe.dispose();

            }
        });


        createAccountpanel.add(caname);
        createAccountpanel.add(caname1);
        createAccountpanel.add(capassword);
        createAccountpanel.add(capassword1);
        createAccountpanel.add(cainbalance);
        createAccountpanel.add(cainbalance1);
        createAccountpanel.add(Create);

        Back = new JButton("Back");
        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crateAccountframe.dispose();
                CustomerLoginframe.setVisible(true);
            }
        });

//        c.gridx = 0;
//        c.gridy = 2;

        createAccountpanel.add(Back);

        crateAccountframe.add(createAccountpanel);
    }

    private void insertAccountInfo() {
        try {
            FileWriter fout = new FileWriter("Account.txt", true);
            BufferedWriter bout = new BufferedWriter(fout);
            bout.write(account);
            bout.write("\t");
            bout.close();
            fout.close();
        } catch (Exception ae) {
            ae.printStackTrace();
        }
    }

    private void showBalanceTransferSection() {
        BalanceTransferFrame = new JFrame("Balance Transfer Page");
        BalanceTransferFrame.setVisible(true);
        Adminloginframe.setVisible(false);
        BalanceTransferFrame.setSize(250, 280);
        BalanceTransferFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BalanceTransferFrame.setLocationRelativeTo(null);

        BalanceTransferPanle = new JPanel();


        snid = new JLabel("Previous Account ID");
        //snid.setSize(100,100);
        snid1 = new JTextField();
        snid1.setColumns(15);

        snpassword = new JLabel("Previous Account Password");
        snpassword1 = new JPasswordField();
        snpassword1.setColumns(13);

        Trnsfracid = new JLabel("Transfer Account ID");
        //snid.setSize(100,100);
        Trnsfracid1 = new JTextField();
        Trnsfracid1.setColumns(15);

        amount = new JLabel("Transfer Amount");
        amount1 = new JTextField();
        amount1.setColumns(15);

        Transfer = new JButton("Transfer");
        Transfer.addActionListener((ActionEvent e)->{
            if (snid1.getText().equals("") || snpassword1.getText().equals("") || Trnsfracid1.getText().equals("") || amount1.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "Invalid Input");
            }

            else
            {

            }
        });


        BalanceTransferPanle.add(snid);
        BalanceTransferPanle.add(snid1);
        BalanceTransferPanle.add(snpassword);
        BalanceTransferPanle.add(snpassword1);
        BalanceTransferPanle.add(Trnsfracid);
        BalanceTransferPanle.add(Trnsfracid1);
        BalanceTransferPanle.add(amount);
        BalanceTransferPanle.add(amount1);

        BalanceTransferPanle.add(Transfer);

        Back = new JButton("Back");
        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BalanceTransferFrame.dispose();
                Adminloginframe.setVisible(true);
            }
        });

//        c.gridx = 0;
//        c.gridy = 2;

        BalanceTransferPanle.add(Back);

        BalanceTransferFrame.add(BalanceTransferPanle);
    }

    private void showAccountInformationSection() {
        try {

            FileReader fr = new FileReader("Account.txt");
            BufferedReader br = new BufferedReader(fr);

            String line;

            while ((line = br.readLine()) != null) {
                String[] word = line.split("\\s+");

                if (localId.equals(word[0]) && localPassword.equals(word[1]))
                {
                    JOptionPane.showMessageDialog(null,"ID name: "+word[0]+"\n"+"ID Password: "+word[1]+"\n"+"Balance: "+word[2]);
                    signinenterframe.dispose();
                    signinenterframe.setVisible(true);
                }

            }
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }


        Accountinfopanel = new JPanel();

        Accountinfoframe.add(Accountinfopanel);
    }

    private void showWithdrawSection() {
        Withdrawframe = new JFrame("Withdraw Page");
        Withdrawframe.setVisible(true);
        signinenterframe.setVisible(false);
        Withdrawframe.setSize(250, 280);
        Withdrawframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Withdrawframe.setLocationRelativeTo(null);

        Withdrawpanel = new JPanel();

        amount = new JLabel("Withdraw Amount");
        amount1 = new JTextField();
        amount1.setColumns(15);

        signinok = new JButton(" OK ");

        signinok.addActionListener((ActionEvent e)->{
            if (amount1.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null,"Invalid Input");
            }
            else
            {
                insertWithdrawInformation();
            }
        });


        Withdrawpanel.add(amount);
        Withdrawpanel.add(amount1);
        Withdrawpanel.add(signinok);

        Withdrawframe.add(Withdrawpanel);
    }

    private void insertWithdrawInformation() {
        int a = Integer.parseInt(amount1.getText());
        System.out.println("Amount Entered: "+a);
        BufferedWriter bw = null;
        BufferedReader br = null;
        String tempFile = "Account.txt";
        try {
            br = new BufferedReader(new FileReader("Account.txt"));
            bw = new BufferedWriter(new FileWriter(tempFile,true));
            String line;
            //String tempString = null;
            while((line = br.readLine())!= null){
                System.out.println(/*"Line: "+*/line);
                String[] word = line.split("\\s+");
//                                                                    System.out.println("ID: "+word[0]);
//                                                                    System.out.println("Password: "+word[1]);
//                                                                    System.out.println("Balance: "+word[2]);

                if (localId.equals(word[0]) && localPassword.equals(word[1])) {
                    int tempAmount = Integer.parseInt(word[2])-a;
                    line = line.replace(word[2],String.valueOf(tempAmount));
                    JOptionPane.showMessageDialog(null,"Withdraw Completed");
                    Withdrawframe.setVisible(false);
                    signinenterframe.setVisible(true);
                }
                line = line+"\n";
                System.out.print(line);
                //bw.write("\nUpdated\n");
                //bw.append(line);
                bw.write(line);
            }

            br.close();
            bw.close();
            File oldFile = new File("Account.txt");
            //oldFile.delete();
            File newFile = new File(tempFile);
            newFile.renameTo(oldFile);

        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    private void showDepositeSection() {
        Deposittframe = new JFrame("Deposit Page");
        Deposittframe.setVisible(true);
        signinenterframe.setVisible(false);
        Deposittframe.setSize(250, 280);
        Deposittframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Deposittframe.setLocationRelativeTo(null);

        Deposittpanel = new JPanel();

        amount = new JLabel("Deposit Amount");
        amount1 = new JTextField();
        amount1.setColumns(15);

        signinok = new JButton(" OK ");
        signinok.addActionListener((ActionEvent e)->{
            if (amount1.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null,"Invalid Input");
            }
            else
            {
                insertDepositveInformation();
            }

        });


        Deposittpanel.add(amount);
        Deposittpanel.add(amount1);
        Deposittpanel.add(signinok);

        Deposittframe.add(Deposittpanel);
    }

    private void insertDepositveInformation() {
        int a = Integer.parseInt(amount1.getText());
        System.out.println("Amount Entered: "+a);
        BufferedWriter bw = null;
        BufferedReader br = null;
        String tempFile = "Account.txt";
        try {
            br = new BufferedReader(new FileReader("Account.txt"));
            bw = new BufferedWriter(new FileWriter(tempFile,true));
            String line;
            //String tempString = null;
            while((line = br.readLine())!= null){
                System.out.println(/*"Line: "+*/line);
                String[] word = line.split("\\s+");
//                                                                    System.out.println("ID: "+word[0]);
//                                                                    System.out.println("Password: "+word[1]);
//                                                                    System.out.println("Balance: "+word[2]);

                if (localId.equals(word[0]) && localPassword.equals(word[1])) {
                    int tempAmount = Integer.parseInt(word[2])+a;
                    line = line.replace(word[2],String.valueOf(tempAmount));
                    JOptionPane.showMessageDialog(null,"Deposit Completed");
                    Deposittframe.setVisible(false);
                    signinenterframe.setVisible(true);
                }
                line = line+"\n";
                System.out.print(line);
                //bw.append(line);;
                bw.write(line);
            }

            br.close();
            bw.close();
            File oldFile = new File("Account.txt");
            //oldFile.delete();
            File newFile = new File(tempFile);
            newFile.renameTo(oldFile);

        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }




}
