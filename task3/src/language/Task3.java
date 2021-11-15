/***
 * Excerpted from "The Definitive ANTLR 4 Reference",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit http://www.pragmaticprogrammer.com/titles/tpantlr2 for more book information.
 ***/
// import ANTLR's runtime libraries

package language;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;


public class Task3 {
    public static void main(String[] args) throws Exception {
        // create a CharStream that reads from standard input
        CharStream input = CharStreams.fromStream(System.in);

        // create a lexer that feeds off of input CharStream
        CalculatorLexer lexer = new CalculatorLexer(input);

        // create a buffer of tokens pulled from the lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // create a parser that feeds off the tokens buffer
        CalculatorParser parser = new CalculatorParser(tokens);

        ParseTree tree = parser.expr(); // begin parsing at prgm rule

        Worker worker = new Worker();
        worker.visit(tree);
        System.out.println(worker.getValue());
    }
}