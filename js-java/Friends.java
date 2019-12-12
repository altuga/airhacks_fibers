import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Value;

public class Friends {

    public static void main(String[] args) {
        final Context context = Context.create("js");
        final Value lambda = context.eval("js", "((message) => { return 'hello: ' + message;})");
        Value result = lambda.execute("hello from java");
        System.out.println(result);
    }
    
}