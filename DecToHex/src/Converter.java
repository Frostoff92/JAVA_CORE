import javax.swing.*;
import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import java.util.Scanner;

public class Converter extends JFrame {

    private final JTextField jTF;
    private final JRadioButton jRBin;
    private final JRadioButton jROct;
    private final JRadioButton jRHex;
    private final JTextField jTFBin;
    private final JTextField jTFOct;
    private final JTextField jTFHex;
    long num;

    public Converter()  {
        // Главное окно
        setTitle("Dec TO Hex");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        // Надпись, указывающая куда вставлять число, которое необходимо конвертировать
        JLabel jLInput = new JLabel("Input number: ");
        jLInput.setHorizontalAlignment(SwingConstants.LEFT);
        jLInput.setFont(new Font("Arial", Font.BOLD, 12));
        jLInput.setBounds(10,37,414,24);
        getContentPane().add(jLInput);
        // Поле для вставки числа, которое необходимо конвертировать
        jTF = new JTextField();
        jTF.addActionListener(e -> {
            Scanner sc = new Scanner(System.in);
            num = sc.nextLong();
        });
        jTF.setBounds(100,37,150,20);
        jTF.setHorizontalAlignment(SwingConstants.CENTER);
        jTF.setColumns(10);
        getContentPane().add(jTF);
        // Выбор системы счисления, в которую должно быть переведено число
        JLabel jLChoose = new JLabel("Choose system coding: ");
        jLChoose.setHorizontalAlignment(SwingConstants.CENTER);
        jLChoose.setFont(new Font("Calibri", Font.ITALIC, 15));
        jLChoose.setBounds(50,90,240,24);
        getContentPane().add(jLChoose);
        // При нажатии на кнопку число Пользователя конвертируется в 2-ичную систему
        jRBin = new JRadioButton();
        jRBin.setHorizontalAlignment(SwingConstants.LEFT);
        jRBin.setText("BIN");
        jRBin.setBounds(10,120,80,50);
        getContentPane().add(jRBin);
        jRBin.addActionListener(e -> convertNum());
        // При нажатии на кнопку число Пользователя конвертируется в 8-ичную систему
        jROct = new JRadioButton();
        jROct.setHorizontalAlignment(SwingConstants.LEFT);
        jROct.setText("OCT");
        jROct.setBounds(10,150,80,50);
        getContentPane().add(jROct);
        jROct.addActionListener(e -> convertNum());
        // При нажатии на кнопку число Пользователя конвертируется в 16-ичную систему
        jRHex = new JRadioButton();
        jRHex.setHorizontalAlignment(SwingConstants.LEFT);
        jRHex.setText("HEX");
        jRHex.setBounds(10,180,80,50);
        getContentPane().add(jRHex);
        jRHex.addActionListener(e -> convertNum());
        // Поле, где будет отражено число в 2-ичной системе
        jTFBin = new JTextField();
        jTFBin.setBounds(100,135,200,20);
        jTFBin.setHorizontalAlignment(SwingConstants.CENTER);
        jTFBin.setColumns(20);
        getContentPane().add(jTFBin);
        // Поле, где будет отражено число в 8-ичной системе
        jTFOct = new JTextField();
        jTFOct.setBounds(100,165,200,20);
        jTFOct.setHorizontalAlignment(SwingConstants.CENTER);
        jTFOct.setColumns(20);
        getContentPane().add(jTFOct);
        // Поле, где будет отражено число в 16-ичной системе
        jTFHex = new JTextField();
        jTFHex.setBounds(100,195,200,20);
        jTFHex.setHorizontalAlignment(SwingConstants.CENTER);
        jTFHex.setColumns(20);
        getContentPane().add(jTFHex);
        // При нажатии на кнопку очищаем поля
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
    // Для оптимизации кода описываем метод, при вызове которого число будет конвертировано в
    // в систему выбранную Пользователем
    public void convertNum() {
        String numText = jTF.getText();
        long number = Long.parseUnsignedLong(numText);
        if (jRBin.isSelected()) {
            numText = Long.toBinaryString(number);
            jTFBin.setText(numText);
        } else if (jROct.isSelected()) {
            numText = Long.toOctalString(number);
            jTFOct.setText(numText);
        } else jRHex.isSelected();
            numText = Long.toHexString(number).toUpperCase();
            jTFHex.setText(numText);
        }
    // Параметры окна
    public static void main(String[] args) {
        Converter conv = new Converter();
        conv.setSize(400,300);
        conv.setVisible(true);
        conv.setResizable(false);
    }
}
