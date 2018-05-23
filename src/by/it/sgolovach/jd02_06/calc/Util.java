package by.it.sgolovach.jd02_06.calc;

import java.io.File;

class Util {
    private static String getPath(Class<?> cl) {
        String path = System.getProperty("user.dir");
        path += File.separator + "src" + File.separator;
        path += cl.getName()
                .replace(cl.getSimpleName(), "")
                .replace(".", File.separator);
        return path;
    }

    private static String getPath(Class<?> cl, String filename) {
        return getPath(cl) + filename;
    }

    static String getPathVarsTxt() {
        return getPath(Util.class,"vars.txt");
    }
}
