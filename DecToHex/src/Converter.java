import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class Converter extends JFrame {

    private final JTextField jTF;
    private final JTextField jTFBin;
    private final JTextField jTFOct;
    private final JTextField jTFHex;
    private final JTextField jTFPark;
    long num;

    public Converter() {
        setTitle("Dec TO Hex");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        JLabel jLInput = new JLabel("Input number: ");
        jLInput.setHorizontalAlignment(SwingConstants.LEFT);
        jLInput.setFont(new Font("Arial", Font.BOLD, 12));
        jLInput.setBounds(10, 37, 414, 24);
        getContentPane().add(jLInput);

        jTF = new JTextField();
        jTF.addActionListener(e -> {
            Scanner sc = new Scanner(System.in);
            num = sc.nextLong();
        });
        jTF.setBounds(100, 37, 150, 20);
        jTF.setHorizontalAlignment(SwingConstants.CENTER);
        jTF.setColumns(10);
        getContentPane().add(jTF);

        JLabel jLChoose = new JLabel("Choose system coding: ");
        jLChoose.setHorizontalAlignment(SwingConstants.CENTER);
        jLChoose.setFont(new Font("Calibri", Font.ITALIC, 15));
        jLChoose.setBounds(50, 90, 240, 24);
        getContentPane().add(jLChoose);

        JRadioButton jRBin = new JRadioButton();
        jRBin.setHorizontalAlignment(SwingConstants.LEFT);
        jRBin.setText("BIN");
        jRBin.setBounds(10, 120, 80, 50);
        getContentPane().add(jRBin);
        jRBin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String numText = jTF.getText();
                long number = Long.parseUnsignedLong(numText);
                numText = Long.toBinaryString(number);
                jTFBin.setText(numText);

            }
        });

        JRadioButton jROct = new JRadioButton();
        jROct.setHorizontalAlignment(SwingConstants.LEFT);
        jROct.setText("OCT");
        jROct.setBounds(10, 150, 80, 50);
        getContentPane().add(jROct);
        jROct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String numText = jTF.getText();
                long number = Long.parseUnsignedLong(numText);
                numText = Long.toOctalString(number);
                jTFOct.setText(numText);
            }
        });

        JRadioButton jRHex = new JRadioButton();
        jRHex.setHorizontalAlignment(SwingConstants.LEFT);
        jRHex.setText("HEX");
        jRHex.setBounds(10, 180, 80, 50);
        getContentPane().add(jRHex);
        jRHex.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String numText = jTF.getText();
                long number = Long.parseUnsignedLong(numText);
                numText = Long.toHexString(number).toUpperCase();
                jTFHex.setText(numText);
            }
        });

        JRadioButton jRPark = new JRadioButton();
        jRPark.setHorizontalAlignment(SwingConstants.LEFT);
        jRPark.setText("EMI");
        jRPark.setBounds(10, 210, 80, 50);
        getContentPane().add(jRPark);

        jTFBin = new JTextField();
        jTFBin.setBounds(100, 135, 200, 20);
        jTFBin.setHorizontalAlignment(SwingConstants.CENTER);
        jTFBin.setColumns(20);
        getContentPane().add(jTFBin);

        jTFOct = new JTextField();
        jTFOct.setBounds(100, 165, 200, 20);
        jTFOct.setHorizontalAlignment(SwingConstants.CENTER);
        jTFOct.setColumns(20);
        getContentPane().add(jTFOct);

        jTFHex = new JTextField();
        jTFHex.setBounds(100, 195, 200, 20);
        jTFHex.setHorizontalAlignment(SwingConstants.CENTER);
        jTFHex.setColumns(20);
        getContentPane().add(jTFHex);

        jTFPark = new JTextField();
        jTFPark.setBounds(100, 225, 200, 20);
        jTFPark.setHorizontalAlignment(SwingConstants.CENTER);
        jTFPark.setColumns(20);
        getContentPane().add(jTFPark);

        JButton btnClear = new JButton("Clear");
        btnClear.setBounds(270, 37, 80, 20);
        btnClear.addActionListener(e -> {
            jTF.setText(null);
            jTFBin.setText(null);
            jTFOct.setText(null);
            jTFHex.setText(null);
        });
        getContentPane().add(btnClear);
    }

    public static void main(String[] args) {
        Converter conv = new Converter();
        conv.setSize(400, 300);
        conv.setVisible(true);
        conv.setResizable(false);
    }
}