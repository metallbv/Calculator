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

        buttonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String temp = display.getText();
                display.setText(temp.substring(0, temp.length() - 1));
            }
        });

        buttonSum.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doOpeation(operation);
                operation = "+";
            }
        });

        buttonMul.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doOpeation(operation);
                operation = "*";
            }
        });

        buttonDivide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doOpeation(operation);
                operation = "/";
            }
        });

        buttonSub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doOpeation(operation);
                operation = "-";
            }
        });

        buttonStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int secondValue = Integer.valueOf(display.getText());
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
                operation = "";
            }
        });

        setLayout(new BorderLayout());
        add(display, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(buttonStart, BorderLayout.SOUTH);
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
        System.out.println("Write an expresion");
        Scanner scanner = new Scanner(System.in);
        String expresion = scanner.nextLine();
        System.out.println(inPolishNotation(expresion));
        System.out.println(eval(expresion));
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

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // Если натыкаемся на открывающуюся скобку
            if(c == '(') {
                // Добавляем открывающуюся скобку в контейнер
                // символов
                someOpers.add('(');

            }

            // Если натыкаемся на закрывающуюся скобку
            else if (c == ')') {

                // Смотрим - пока последний символ контейнера
                // символов не открывающаяся скобка -
                // Выполняем метод, который учит считать
                // программу, передавая ему в параметрах
                // наш контейнер с числами и последний
                // символ в контейнере символов, причем
                // удаляя его опосля
                // Например:
                //
                // Числовой Контейнер:   { 2, 2 }
                // Символьный Контейнер: { (, + }
                //
                // Передаем letGo({2,2},'+');
                //
                // На выходе:
                //
                // Числовой Контейнер:   { 4 }
                // Символьный Контейнер: { ( }
                while(someOpers.getLast() != '(') {
                    letGo(someInts, someOpers.removeLast());
                }

                // После while - удаляем последний символ
                // из Символьного Контейнера. Если смотреть
                // пример - это открывающаяся скобка
                someOpers.removeLast();

            }

            // Так же, во время цикла мы проверяем каждый символ
            // на предмет - а не оператор ли он часом?
            // Если же да, то
            // ПОКА массив символов непустой и приоритет
            // последнего символа в контейнере символов
            // больше или равен приоритету текущего -
            // "учим" программу считать, передавая в параметрах
            // контейнер с числами и последний символ из
            // контейнера символов, удаляя его опосля
            // Например:
            //
            // Наш символ: +
            // Числовой Контейнер:   { 2, 2 }
            // Символьный Контейнер: { * }
            //
            // Согласно условию:
            //                    СК         не пустой
            //                    Приоритет  '*' > '+'
            //
            // Передаем letGo({2,2},'*');
            //
            // На выходе:
            //
            // Числовой Контейнер:   { 4 }
            // Символьный Контейнер: { + }
            // Кривой пример, конечно, но смысл должен быть ясен
            else if (isOperator(c)) {
                while(!someOpers.isEmpty() &&
                        priority(someOpers.getLast()) >= priority(c)) {

                    letGo(someInts, someOpers.removeLast());

                }

                // Если while не выполняется - добавляем
                // символ в контейнер символов
                someOpers.add(c);
            }

            // Если же ничего из вышеперечисленного не произошло,
            // то мы ожидаем число
            else {

                // Так как мы можем получить не только простые
                // числа (1, 5, 9), но и - 11, 344, 53432 и т.д.,
                // нам нужна локальная строка
                String operand = "";

                // После чего, ПОКА
                // текущее i меньше размера строки и
                // позиция от i в строке - число, -
                // мы составляем строку числа из символов,
                // увеличивая i на 1 каждый раз, когда символ
                // записался, чтобы проверять строку дальше
                while(i < s.length() &&
                        Character.isDigit(s.charAt(i))) {

                    operand += s.charAt(i++);

                }

                // Если while не выполнился или закончился -
                // отнимаем у i единицу (т.к. i++ отработала
                // лишний раз, и добавляем нашу
                // распарсенную в числовой манер строку,
                // которую мы составили из чисел в
                // Числовой Контейнер
                --i;
                someInts.add(Integer.parseInt(operand));

            }
        }

        // После цикла,
        // ПОКА контейнер символов НЕ пустой, -
        // "учим" считать программу, передавая ей наш контейнер
        // чисел и контейнер символов. Обычно, этот while
        // отрабатывает в конце, что логично, т.к. мы
        // предусмотрели все условия и на момент
        // окончания цикла у нас только остатки
        // например, если бы у нас было:
        // (2+2)*(4+5)
        // на момент этого while, у нас бы осталось:
        // КЧ: { 4,9 }
        // КС: { * }
        while(!someOpers.isEmpty()) {

            letGo(someInts, someOpers.removeLast());

        }

        // В конце мы возвращаем наше получившееся значение из
        // Контейнера чисел. Глядя на последний пример -
        // получится 36
        return someInts.get(0);

    }

    static void letGo(LinkedList<Integer> st, char oper) {

        // Инициализируем и объявляем две переменные
        // Первая берет последнее значение из переданного
        // связанного листа в параметре, запоминает и удаляет
        // его из списка
        int someOne = st.removeLast();

        // Тоже самое делаем со второй переменной
        int someTwo = st.removeLast();

        // Пишем switch (можно if, но он длиннее по коду),
        // который учит переданный символ во 2 параметре
        // считать относительно своему предназначению
        switch(oper) {
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
