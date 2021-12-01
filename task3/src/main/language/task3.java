package language;

import org.antlr.v4.runtime.*;

public class task3 {

    /**
     * Takes an s-expression from System.in as input and prints
     * out risc-v assembly code.
     *
     * @return Risc-V assembly code.
     */
    public static void main(String[] args) throws Exception {
        // create a CharStream that reads from standard input
        CharStream input = CharStreams.fromStream(System.in);

        // create a lexer that feeds off of input CharStream
        SExpressionsLexer lexer = new SExpressionsLexer(input);

        // create a buffer of tokens pulled from the lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // create a parser that feeds off the tokens buffer
        SExpressionsParser parser = new SExpressionsParser(tokens);
        SExpressionsParser.ProgContext tree = parser.prog(); // begin parsing at prog rule

        // constructs a worker object and generates the output assembly code through
        // traversing the ParseTree starting at ProgContext
        Worker worker = new Worker(tree);
        // worker.getOutput returns the generated risc-v assembly code
        String riscCode = worker.getOutput();
        System.out.println(riscCode);
    }
}