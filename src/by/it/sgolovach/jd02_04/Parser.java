package by.it.sgolovach.jd02_04;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {

    List<String> priority =
            new ArrayList<>(Arrays.asList("=", "+", "-", "*", "/"));

    List<String> operations;
    List<String> operands;

    private int getNumOperation() {
        // = + + * / - -
        int curnum = -1;
        int prior = -1;
        for (int i = 0; i < operations.size(); i++) {
            String op = operations.get(i);
            int p = priority.indexOf(op);
            if (p > prior) {
                curnum = i;
                prior = p;
            }
        }
        return curnum;
    }

    Var calcExpression(String expression) throws CalcException {
        char[] exp = expression.toCharArray();
        int a = 0;
        int b = 0;
        for (char c : exp) {
            if (c == '(') a++;
            if (c == ')') b++;
        }
        if (a == b) {
            for (int i = 0; i < a; i++) {
                Pattern p = Pattern.compile(Patterns.EXPRESSION);
                Matcher m = p.matcher(expression);
                String expres = "";
                m.find();
                expres = m.group();
                String expres1 = expres.replaceAll("[\\(\\)]", "");
                Var expres2 = calc(expres1);
                expression = expression.replaceFirst(Patterns.EXPRESSION, expres2.toString());
            }
        } else throw new CalcException("Не верное выражение");

        Var result = calc(expression);

        return result;
    }


    Var calc(String expression) throws CalcException {
        operands = new ArrayList<>(
                Arrays.asList(expression.split(Patterns.OPERATION))
        );
        operations = new ArrayList<>();
        Pattern p = Pattern.compile(Patterns.OPERATION);
        Matcher m = p.matcher(expression);
        while (m.find()) {
            operations.add(m.group());
        }
        while (operations.size() > 0) {
            int index = getNumOperation();
            String op = operations.remove(index);
            String oLeft = operands.get(index);
            String oRight = operands.remove(index + 1);
            operands.set(index, calcOneOperation(oLeft, op, oRight).toString());
        }
        return Var.createVar(operands.get(0));
    }

    private Var calcOneOperation(String strVarLeft, String operaton, String strVarRight) throws CalcException {
        Var two = Var.createVar(strVarRight);
        if (operaton.equals("=") && strVarLeft.matches(Patterns.VARNAME))
            return Var.saveVar(strVarLeft, two);
        Var one = Var.createVar(strVarLeft);
        switch (operaton) {
            case "+":
                return one.add(two);
            case "-":
                return one.sub(two);
            case "*":
                return one.mul(two);
            case "/":
                return one.div(two);
        }
        throw new CalcException("Нет такой операции");
    }

}