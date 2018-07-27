import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class Project3 {

    public static void main(String args[]) throws Exception
    {
        //Sequence of code partially adapted from http://students.cse.tamu.edu/dxiao/csce315summer17/ANTLR/
        CharStream input = CharStreams.fromStream(System.in);
        DMLLexer lexer = new DMLLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        DMLParser parser = new DMLParser(tokens);

        ParseTree tree = parser.program();
        System.out.println(tree.toStringTree(parser));


    }


}
