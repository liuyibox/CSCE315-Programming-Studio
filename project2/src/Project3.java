/**
 * Created by ellie on 6/27/2017.
 */

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import java.io.*;

import java.util.Scanner;
import java.util.Vector;

public class Project3 {

    public static Database db;

    public static void main(String args[]) throws Exception
    {
        //Sequence of code partially adapted from http://students.cse.tamu.edu/dxiao/csce315summer17/ANTLR/
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a file name that contains database commands: ");
        String fileName = scanner.next();

        try(BufferedReader br = new BufferedReader(new FileReader((fileName)))) {
            File file = new File(fileName);
            FileInputStream fis = null;
            if (!file.exists() || file.isDirectory()) {
                throw new Exception("Command file doesn't exist.");
            }

            String line = br.readLine();
            while (br.readLine() != null) {
                fis = new FileInputStream(file);
                ANTLRInputStream input = new ANTLRInputStream(fis);
                DMLLexer lexer = new DMLLexer(input);
                CommonTokenStream tokens = new CommonTokenStream(lexer);
                DMLParser parser = new DMLParser(tokens);

                Project3.db = new Database();

                ParseTree tree = parser.program();
                ParseTreeVisitor ptv = new ParseTreeVisitor();

                ptv.visit(tree);
            }
        }
    }

}
