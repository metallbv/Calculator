import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by v.babiak on 17.05.2016.
 */
public class CalcFrame extends JFrame {

    JTextArea display = new JTextArea();
    JPanel buttonPanel = new JPanel(new GridLayout(3, 5));
    JButton button0 = new JButton("0");
    JButton button1 = new JButton("1");
    JButton button2 = new JButton("2");
    JButton button3 = new JButton("3");
    JButton button4 = new JButton("4");
    JButton button5 = new JButton("5");
    JButton button6 = new JButton("6");
    JButton button7 = new JButton("7");
    JButton button8 = new JButton("8");
    JButton button9 = new JButton("9");
    JButton buttonSum = new JButton("+");
    JButton buttonBack = new JButton("C");
    JButton buttonDivide = new JButton("/");
    JButton buttonSub = new JButton("-");
    JButton buttonMul = new JButton("*");
    JButton buttonStart = new JButton("=");
    JButton buttonSpace = new JButton("Space");
    JButton buttonLeftBracket = new JButton("(");
    JButton buttonRightBracket = new JButton(")");
    int firstValue = 0;
    String operation = "";

    CalcFrame() {
        setBounds(300, 300, 300, 300);

        button0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText(display.getText() + "0");
            }
        });

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText(display.getText() + "1");
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText(display.getText() + "2");
            }
        });

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText(display.getText() + "3");
            }
        });

        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText(display.getText() + "4");
            }
        });

        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText(display.getText() + "5");
            }
        });

        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText(display.getText() + "6");
            }
        });

        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText(display.getText() + "7");
            }
        });

        button8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText(display.getText() + "8");
            }
        });

        button9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText(display.getText() + "9");
            }
        });

        buttonSpace.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText(display.getText() + " ");
            }
        });

        buttonLeftBracket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText(display.getText() + "(");
            }
        });

        buttonRightBracket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText(display.getText() + ")");
            }
        });

        buttonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String temp = display.getText();
                if (temp.length() > 0) {
                    display.setText(temp.substring(0, temp.length() - 1));
                }
            }
        });

        buttonSum.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*doOpeation(operation);
                operation = "+";*/
                display.setText(display.getText() + "+");
            }
        });

        buttonMul.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*doOpeation(operation);
                operation = "*";*/
                display.setText(display.getText() + "*");
            }
        });

        buttonDivide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*doOpeation(operation);
                operation = "/";*/
                display.setText(display.getText() + "/");
            }
        });

        buttonSub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*doOpeation(operation);
                operation = "-";*/
                display.setText(display.getText() + "-");
            }
        });

        buttonStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*int secondValue = Integer.valueOf(display.getText());
                if ("+".equals(operation)) {
                    display.setText((firstValue + secondValue) + "");
                }
                if ("-".equals(operation)) {
                    display.setText((firstValue - secondValue) + "");
                }
                if ("*".equals(operation)) {
                    display.setText((firstValue * secondValue) + "");
                }
                if ("/".equals(operation)) {
                    display.setText((firstValue / secondValue) + "");
                }
                firstValue = 0;
                operation = "";*/
                display.setText(String.valueOf(eval(display.getText())));
            }
        });

        setLayout(new BorderLayout());
        add(display, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(buttonSpace, BorderLayout.SOUTH);
        //add(buttonStart, BorderLayout.SOUTH);
        buttonPanel.add(button0);
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);
        buttonPanel.add(button4);
        buttonPanel.add(button5);
        buttonPanel.add(button6);
        buttonPanel.add(button7);
        buttonPanel.add(button8);
        buttonPanel.add(button9);
        buttonPanel.add(buttonSum);
        buttonPanel.add(buttonSub);
        buttonPanel.add(buttonMul);
        buttonPanel.add(buttonDivide);
        buttonPanel.add(buttonBack);
        buttonPanel.add(buttonLeftBracket);
        buttonPanel.add(buttonRightBracket);
        buttonPanel.add(buttonStart);
        setVisible(true);
    }

    public void doOpeation(String operation) {

        if (operation != "") {
            int secondValue = Integer.valueOf(display.getText());
            if ("+".equals(operation)) {
                firstValue += secondValue;
            }
            if ("-".equals(operation)) {
                firstValue -= secondValue;
            }
            if ("*".equals(operation)) {
                firstValue *= secondValue;
            }
            if ("/".equals(operation)) {
                firstValue /= secondValue;
            }
        } else {
            firstValue = Integer.valueOf(display.getText());
        }

        display.setText("");

    }

    private static int priority(final char operator) {
        int resultPriority;
        switch (operator) {
            case '^':
                resultPriority = 4;
                break;
            case '*':
            case '/':
                resultPriority = 3;
                break;
            case '-':
            case '+':
                resultPriority = 2;
                break;
            case '(':
                resultPriority = 1;
                break;
            default:
                resultPriority = 0;
        }
        return resultPriority;
    }

    public static void main(String[] args) {
        /*System.out.println("Write an expresion");
        Scanner scanner = new Scanner(System.in);
        String expresion = scanner.nextLine();
        //System.out.println(inPolishNotation(expresion));
        System.out.println(eval(expresion));*/
        new CalcFrame();
    }

    public static String inPolishNotation(String expression) {
        expression = "(" + expression;
        expression += ")";
        String rezNotation = "";
        final Stack stack = new Stack();
        final Stack outString = new Stack();

        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == ')') {
                while (String.valueOf(stack.peek()).charAt(0) != '(') {
                    outString.push(stack.pop());
                }

                stack.pop();
            }
            if (expression.charAt(i) == '(') {
                stack.push('(');
            }

            if ((expression.charAt(i) == '+') || (expression.charAt(i) == '-')
                    || (expression.charAt(i) == '/') || (expression.charAt(i) == '*')
                    || (expression.charAt(i) == '^')) {
                if (stack.size() == 0) {
                    stack.push(expression.charAt(i));
                } else if (priority(expression.charAt(i)) > priority(String
                        .valueOf(stack.peek()).charAt(0))) {
                    stack.push(expression.charAt(i));
                } else {
                    while ((stack.size() != 0)
                            && (priority(String.valueOf(stack.peek()).charAt(0)) >= priority(expression
                            .charAt(i)))) {
                        outString.push(stack.pop());
                    }
                    stack.push(expression.charAt(i));
                }
            } else if (expression.charAt(i) != '(' && expression.charAt(i) != ')')
                outString.push(expression.charAt(i));
        }
        for (int j = 0; j < outString.size(); j++) {
            rezNotation = rezNotation + String.valueOf(outString.get(j));
        }
        return rezNotation;
    }

    static int eval(String s) {

        LinkedList<Integer> someInts = new LinkedList<Integer>();
        LinkedList<Character> someOpers = new LinkedList<Character>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                someOpers.add('(');

            } else if (c == ')') {
                // проверим вдруг не правильно расставили кавычки
                try {
                    while (someOpers.getLast() != '(') {
                        letGo(someInts, someOpers.removeLast());
                        if (someOpers.isEmpty()) {
                            throw new IncorrectString("missing '('");
                        }
                    }
                    someOpers.removeLast();
                } catch (IncorrectString ex) {
                    System.out.println(ex.getMessage());
                }


            } else if (isOperator(c)) {
                while (!someOpers.isEmpty() &&
                        priority(someOpers.getLast()) >= priority(c)) {

                    letGo(someInts, someOpers.removeLast());

                }
                someOpers.add(c);

            } else if (c != ' ') {
                String operand = "";
                while (i < s.length() &&
                        Character.isDigit(s.charAt(i))) {

                    operand += s.charAt(i++);

                }
                --i;
                someInts.add(Integer.parseInt(operand));

            }
        }

        while (!someOpers.isEmpty()) {

            letGo(someInts, someOpers.removeLast());

        }

        return someInts.get(0);

    }

    static void letGo(LinkedList<Integer> st, char oper) {

        int someOne = st.removeLast();
        int someTwo = st.removeLast();

        switch (oper) {
            case '+':
                st.add(someTwo + someOne);
                break;
            case '-':
                st.add(someTwo - someOne);
                break;
            case '*':
                st.add(someTwo * someOne);
                break;
            case '/':
                st.add(someTwo / someOne);
                break;
            default:
                System.out.println("Oops");
        }
    }

    static boolean isOperator(char c) {

        return c == '+' || c == '-' || c == '*' || c == '/';

    }

}
