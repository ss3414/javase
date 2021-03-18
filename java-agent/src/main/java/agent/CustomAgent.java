package agent;

import java.lang.instrument.Instrumentation;

public class CustomAgent {

    private static void print(Instrumentation instrumentation) {
        instrumentation.addTransformer(new CustomTransformer(), true);
        Class[] classes = instrumentation.getAllLoadedClasses();
        for (Class clazz : classes) {
            System.out.println("CustomAgent:" + clazz.getName());
        }
    }

    /* JVM参数 */
    public static void premain(String args, Instrumentation instrumentation) {
        System.out.println("JVM参数");
        print(instrumentation);
    }

    /* attach */
    public static void agentmain(String args, Instrumentation instrumentation) {
        System.out.println("attach");
        print(instrumentation);
    }

}
