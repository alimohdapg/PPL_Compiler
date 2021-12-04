package language;

import org.antlr.v4.runtime.*;

public class task2 {

    // takes an s-expression from System.in as input and prints out the s-expression with the main function as the
    // first function if no errors were found, if the s-expression is semantically invalid an exception is thrown
    // and is subsequently printed out
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
            // semantically valid
            System.out.println(typeChecker.visitAndPrint(tree));
        } catch (TypeException ex) {
            // semantically invalid
            System.out.println(ex.report());
        }
    }
}