import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

/**
 * Created by Jay Vince Serato on November 01, 2016.
 */
public class Calculator extends JFrame{
    private JTextArea taResult;
    private JPanel Buttons;
    private JPanel View;
    private JButton btn6;
    private JButton btn3;
    private JButton btnDec;
    private JButton btnEqu;
    private JButton btnPlu;
    private JButton btnMin;
    private JButton btnMul;
    private JButton btnDiv;
    private JButton btn1;
    private JButton btnMag;
    private JButton btn8;
    private JButton btn5;
    private JButton btn2;
    private JButton btnPerc;
    private JButton btnClr;
    private JButton btn7;
    private JButton btn4;
    private JButton btn9;
    private JButton btn0;

    private BigDecimal former = new BigDecimal("0");
    private BigDecimal latter = new BigDecimal("0");

    private int operator;
    private boolean opPrev;
    private boolean equalled;

    public Calculator() {

        setLayout(new GridLayout(2, 1));
        add(View);
        add(Buttons);

        setTitle("Calculator");
        setSize(275, 300);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        btn0.addActionListener(new NumActionListener("0"));
        btn1.addActionListener(new NumActionListener("1"));
        btn2.addActionListener(new NumActionListener("2"));
        btn3.addActionListener(new NumActionListener("3"));
        btn4.addActionListener(new NumActionListener("4"));
        btn5.addActionListener(new NumActionListener("5"));
        btn6.addActionListener(new NumActionListener("6"));
        btn7.addActionListener(new NumActionListener("7"));
        btn8.addActionListener(new NumActionListener("8"));
        btn9.addActionListener(new NumActionListener("9"));
        btnDec.addActionListener(new NumActionListener("."));

        btnPlu.addActionListener(new OperActionListener(1));
        btnMin.addActionListener(new OperActionListener(2));
        btnMul.addActionListener(new OperActionListener(3));
        btnDiv.addActionListener(new OperActionListener(4));

        btnMag.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (taResult.getText().charAt(0) != '-' && !(taResult.getText().equals("0"))) {
                    taResult.setText("-" + taResult.getText());
                } else if (taResult.getText().charAt(0) == '-') {
                    char data[] = taResult.getText().toCharArray();
                    char newData[] = new char[data.length-1];
                    System.arraycopy(data, 1, newData, 0, data.length - 1);
                    taResult.setText(String.copyValueOf(newData));
                }
            }
        });

        btnPerc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (operator != 0 && !former.equals(new BigDecimal("0"))) {
                    switch (operator) {
                        case 1:
                            latter = new BigDecimal(taResult.getText());
                            former = (((former.add(latter)).divide(latter, 7, 5)).movePointRight(2)).stripTrailingZeros();
                            taResult.setText(former.toPlainString());
                            break;
                        case 2:
                            latter = new BigDecimal(taResult.getText());
                            former = (((former.subtract(latter)).divide(latter, 7, 5)).movePointRight(2)).stripTrailingZeros();
                            taResult.setText(former.toPlainString());
                            break;
                        case 3:
                            latter = new BigDecimal(taResult.getText());
                            former = (latter.movePointLeft(2)).multiply(former);
                            taResult.setText(former.toPlainString());
                            break;
                        case 4:
                            latter = new BigDecimal(taResult.getText());
                            former = (former.divide(latter.movePointLeft(2), 7, 5)).stripTrailingZeros();
                            taResult.setText(former.toPlainString());
                            break;
                        default:
                            break;

                    }
                    latter = null;
                    operator = 0;
                    opPrev = true;
                    equalled = true;
                }
            }
        });

        btnClr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                former = new BigDecimal(0);
                latter = new BigDecimal(0);
                taResult.setText("0");
            }
        });

        btnEqu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                applyAlgo();
                equalled = true;
            }
        });

    }

    private void applyAlgo() {
        latter = new BigDecimal(taResult.getText());
        switch (operator) {
            case 1:
                former = former.add(latter);
                taResult.setText(String.valueOf(former));
                break;
            case 2:
                former = former.subtract(latter);
                taResult.setText(String.valueOf(former));
                break;
            case 3:
                former = former.multiply(latter);
                taResult.setText(String.valueOf(former));
                break;
            case 4:
                former = former.divide(latter, 5);
                taResult.setText(String.valueOf(former));
                break;
            default:
                operator = 5;
                break;
        }
        latter = null;
        operator = 0;
        opPrev = true;
    }

    public static void main(String[] args) {
        new Calculator();
    }

    private class NumActionListener implements ActionListener {
        String s;

        public NumActionListener(String s) {
            this.s = s;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (taResult.getText().equals("0") || opPrev) {
                taResult.setText("");
            }
            taResult.append(s);
            opPrev = false;
        }
    }

    private class OperActionListener implements ActionListener {
        int s;

        public OperActionListener(int s) {
            this.s = s;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (former.equals(new BigDecimal("0")) || equalled) {
                former = new BigDecimal(taResult.getText());
            }
            else if (operator != 0) {
                applyAlgo();
            }
            opPrev = true;
            operator = s;
            equalled = false;
        }
    }
}
