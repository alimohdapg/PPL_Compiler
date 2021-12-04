package language;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class task1 {

    // takes a syntactically valid program as input from System.in and prints out its corresponding s-expression
    public static void main(String[] args) throws Exception {
        // create a CharStream that reads from standard input
        CharStream input = CharStreams.fromStream(System.in);
        // create a lexer that feeds off of input CharStream
        LanguageLexer lexer = new LanguageLexer(input);
        // create a buffer of tokens pulled from the lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        // create a parser that feeds off the tokens buffer
        LanguageParser parser = new LanguageParser(tokens);
        // begin parsing at prog rule
        ParseTree tree = parser.prog();
        Worker worker = new Worker();
        // traverses the tree starting with prog
        worker.visit(tree);
        // retrieves the s-expression through worker.getValue() and prints out its "pretty version"
        // with easier to understand formatting
        System.out.println(G5035_S_Expression_PrettyPrinter.prettyPrint(worker.getValue()));
    }
}