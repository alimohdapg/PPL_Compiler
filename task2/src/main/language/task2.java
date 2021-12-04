package language;

import org.antlr.v4.runtime.*;

public class task2 {

    //
    public static void main(String[] args) throws Exception {
        // create a CharStream that reads from standard input
        CharStream input = CharStreams.fromStream(System.in);
        // create a lexer that feeds off of input CharStream
        SExpressionsLexer lexer = new SExpressionsLexer(input);
        // create a buffer of tokens pulled from the lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        // create a parser that feeds off the tokens buffer
        SExpressionsParser parser = new SExpressionsParser(tokens);
        // begin parsing at prog rule
        SExpressionsParser.ProgContext tree = parser.prog();
        SExpressionsAnalyser typeChecker = new SExpressionsAnalyser();
        try {
            System.out.println(typeChecker.visitAndPrint(tree));
        } catch (TypeException ex) {
            System.out.println(ex.report());
        }
    }
}