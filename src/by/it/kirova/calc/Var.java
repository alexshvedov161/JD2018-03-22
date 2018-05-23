package by.it.kirova.calc;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import static by.it.kirova.calc.ConsoleRunner.rm;

public abstract class Var implements Operation {

    private static Map<String, Var> variables = new HashMap<>();

    public static Var saveVar(String nameVar, Var valueVar) throws CalcException {
        //Var put = variables.put(nameVar, valueVar);
        variables.put(nameVar, valueVar);
        try (PrintWriter printer = new PrintWriter(new FileWriter(Util.getPathVarsTxt()))) {
            for (Map.Entry<String, Var> entry : variables.entrySet()) {
                printer.println(entry.getKey() + "=" + entry.getValue());
            }
        } catch (IOException e) {
            throw new CalcException(rm.get(Messages.COULDNTSAVEVAR) + nameVar + "=" + valueVar, e);
        }
        return valueVar;
    }

    static Var createVar(String strVar) throws CalcException {
        VarFactory.Creator creator = null;
        strVar = strVar.replaceAll("\\s+", "").trim();
        if (strVar.matches(Patterns.SCALAR))
            creator = new VarFactory.CreatorScalar();
        if (strVar.matches(Patterns.VECTOR))
            creator = new VarFactory.CreatorVector();
        if (strVar.matches(Patterns.MATRIX))
            creator = new VarFactory.CreatorMatrix();
        if (strVar.matches(Patterns.VARNAME))
            return variables.get(strVar);
        if (creator == null)
            throw new CalcException(rm.get(Messages.PROCESSINGERROR) + strVar);
        return creator.parse(strVar);
    }

    public static void printvar() {
        for (Map.Entry<String, Var> entry : variables.entrySet()) {
            String key = entry.getKey();
            Var value = entry.getValue();
            printvarImpl(key, value);
        }
    }

    public static void sortvar() {
        SortedSet<String> sortedKeys = new TreeSet<>(ALPHABETICAL_ORDER);
        sortedKeys.addAll(variables.keySet());
        for (String key : sortedKeys) {
            Var value = variables.get(key);
//            System.out.print(key + "=");
//            Printer.print(value);
            printvarImpl(key, value);
        }
    }

    private static void printvarImpl(String key, Var value) {
        String message = value == null ?
                key + " is null" :
                key + "=" + value;
        Logger.getLogger().println(message, Logger.MessageType.CALC_OUTPUT);
    }

    private static Comparator<String> ALPHABETICAL_ORDER =
            (String str1, String str2) -> {
                int res = String.CASE_INSENSITIVE_ORDER.compare(str1, str2);
                if (res == 0) {
                    res = str1.compareTo(str2);
                }
                return res;
            };

    @Override
    public String toString() {
        return rm.get(Messages.CLASSABSTRACTVAR);
    }

    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException(rm.get(Messages.ADD) + this + "+" + other + rm.get(Messages.IMPOSSIBLE));
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException(rm.get(Messages.SUB) + this + "-" + other + rm.get(Messages.IMPOSSIBLE));
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException(rm.get(Messages.MUL) + this + "*" + other + rm.get(Messages.IMPOSSIBLE));
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException(rm.get(Messages.DIV) + this + "/" + other + rm.get(Messages.IMPOSSIBLE));
    }
}
