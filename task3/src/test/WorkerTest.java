import language.SExpressionsLexer;
import language.SExpressionsParser;
import language.Worker;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.jupiter.api.Test;
import rars.AssemblyException;
import rars.SimulationException;
import rars.api.Options;
import rars.api.Program;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import static org.junit.jupiter.api.Assertions.*;

public class WorkerTest {

    public String helper(String s) throws IOException {
        CharStream input = CharStreams.fromStream(new ByteArrayInputStream(s.getBytes(StandardCharsets.UTF_8)));
        SExpressionsLexer lexer = new SExpressionsLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        SExpressionsParser parser = new SExpressionsParser(tokens);
        SExpressionsParser.ProgContext tree = parser.prog();
        Worker worker = new Worker(tree);
        String assemblyInput = worker.getOutput();

        Options op = new Options();
        op.startAtMain = true;
        op.maxSteps = 1000000;

        Program p = new Program(op);

        try {
            p.assembleString(assemblyInput);
        } catch (AssemblyException ae){
            throw new RuntimeException(ae);
        }

        p.setup(null, "");
        // Potentially set memory or registers here
        StringBuilder output = new StringBuilder();
        try {
            output.append(p.simulate());
        } catch (SimulationException se){
            throw new RuntimeException(se);
        }
        // check any final register or memory state
        output.append("\n").append(p.getRegisterValue("a0"));
        return output.toString();
    }

    @Test
    public void test1() throws IOException{
        assertEquals("NORMAL_TERMINATION\n" +
                     "0", helper("""
                [
                  [FunDecl,
                    Idfr("main"),
                    IntType,
                    [],
                    [
                      [FunInvoc,
                        Idfr("fun"),
                        [IntLit(1),
                          IntLit(2),
                          IntLit(3)]
                      ]
                    ]
                  ],
                  [FunDecl,
                    Idfr("fun"),
                    IntType,
                    [
                      [Idfr("x"), IntType],
                      [Idfr("y"), IntType],
                      [Idfr("z"), IntType]
                    ],
                    [
                      [IfStmt,
                        [BinOpExpr,
                          Eq,
                          Idfr("x"),
                          Idfr("y")],
                        [Idfr("z")],
                        [IntLit(0)]
                      ]
                    ]
                  ]
                ]
                """));
    }

    @Test
    public void test2() throws IOException {
        assertEquals("NORMAL_TERMINATION\n" +
                     "55", helper("""
                [
                  [FunDecl,
                    Idfr("main"),
                    IntType,
                    [],
                    [
                      [FunInvoc,
                        Idfr("fibo"),
                        [IntLit(10)]
                      ]
                    ]
                  ],
                  [FunDecl,
                    Idfr("fibo"),
                    IntType,
                    [
                      [Idfr("n"), IntType]
                    ],
                    [
                      [IfStmt,
                        [BinOpExpr,
                          Less,
                          Idfr("n"),
                          IntLit(2)],
                        [Idfr("n")],
                        [
                          [BinOpExpr,
                            Plus,
                            [FunInvoc,
                              Idfr("fibo"),
                              [
                                [BinOpExpr,
                                  Minus,
                                  Idfr("n"),
                                  IntLit(1)]
                              ]
                            ],
                            [FunInvoc,
                              Idfr("fibo"),
                              [
                                [BinOpExpr,
                                  Minus,
                                  Idfr("n"),
                                  IntLit(2)]
                              ]
                            ]
                          ]
                        ]
                      ]
                    ]
                  ]
                ]
                """));
    }

    @Test
    public void test3() throws IOException{
        assertEquals("NORMAL_TERMINATION\n" +
                     "1337", helper("""
                  [
                  [FunDecl,
                    Idfr("main"),
                    IntType,
                    [],
                    [
                      [FunInvoc,
                        Idfr("doLoop"),
                        [IntLit(0), IntLit(5)]
                      ],
                      IntLit(1337)]
                  ],
                  [FunDecl,
                    Idfr("doLoop"),
                    UnitType,
                    [
                      [Idfr("i"), IntType],
                      [Idfr("a"), IntType]
                    ],
                    [
                      [WhileLoop,
                        [BinOpExpr,
                          LessEq,
                          Idfr("i"),
                          IntLit(100)],
                        [
                          [Asgmt,
                            Idfr("a"),
                            [BinOpExpr,
                              Plus,
                              Idfr("a"),
                              Idfr("i")]
                          ],
                          [Asgmt,
                            Idfr("i"),
                            [BinOpExpr,
                              Plus,
                              Idfr("i"),
                              IntLit(1)]
                          ]
                        ]
                      ]
                    ]
                  ]
                ]
                """));
    }

    @Test
    public void test4() throws IOException {
        assertEquals("NORMAL_TERMINATION\n" +
                     "3628800", helper("""
                [
                  [FunDecl,
                    Idfr("main"),
                    IntType,
                    [],
                    [
                      [FunInvoc,
                        Idfr("fact"),
                        [IntLit(10)]
                      ]
                    ]
                  ],
                  [FunDecl,
                    Idfr("fact"),
                    IntType,
                    [
                      [Idfr("n"), IntType]
                    ],
                    [
                      [IfStmt,
                        [BinOpExpr,
                          Eq,
                          Idfr("n"),
                          IntLit(0)],
                        [IntLit(1)],
                        [
                          [BinOpExpr,
                            Times,
                            Idfr("n"),
                            [FunInvoc,
                              Idfr("fact"),
                              [
                                [BinOpExpr,
                                  Minus,
                                  Idfr("n"),
                                  IntLit(1)]
                              ]
                            ]
                          ]
                        ]
                      ]
                    ]
                  ]
                ]
                """));
    }

    @Test
    public void test5() throws IOException{
        assertEquals("NORMAL_TERMINATION\n" +
                     "20", helper("""
                [
                  [FunDecl,
                    Idfr("main"),
                    IntType,
                    [],
                    [
                      [FunInvoc,
                        Idfr("fact"),
                        [IntLit(20)]
                      ]
                    ]
                  ],
                  [FunDecl,
                    Idfr("fact"),
                    IntType,
                    [
                      [Idfr("n"), IntType]
                    ],
                    [
                      [IfStmt,
                        [BinOpExpr,
                          And,
                          [BinOpExpr,
                            Gtr,
                            Idfr("n"),
                            IntLit(5)],
                          [BinOpExpr,
                            LessEq,
                            Idfr("n"),
                            IntLit(20)]
                        ],
                        [Idfr("n")],
                        [IntLit(0)]
                      ]
                    ]
                  ]
                ]
                """));
    }

    @Test
    public void test6() throws IOException{
        assertEquals("NORMAL_TERMINATION\n" +
                     "6", helper("""
                [
                  [FunDecl,
                    Idfr("main"),
                    IntType,
                    [],
                    [
                      [FunInvoc,
                        Idfr("fact"),
                        [IntLit(6)]
                      ]
                    ]
                  ],
                  [FunDecl,
                    Idfr("fact"),
                    IntType,
                    [
                      [Idfr("n"), IntType]
                    ],
                    [
                      [IfStmt,
                        [BinOpExpr,
                          And,
                          [BinOpExpr,
                            Gtr,
                            Idfr("n"),
                            IntLit(5)],
                          [BinOpExpr,
                            LessEq,
                            Idfr("n"),
                            IntLit(20)]
                        ],
                        [Idfr("n")],
                        [IntLit(0)]
                      ]
                    ]
                  ]
                ]
                """));
    }

    @Test
    public void test7() throws IOException{
        assertEquals("NORMAL_TERMINATION\n" +
                     "0", helper("""
                [
                  [FunDecl,
                    Idfr("main"),
                    IntType,
                    [],
                    [
                      [FunInvoc,
                        Idfr("fact"),
                        [IntLit(21)]
                      ]
                    ]
                  ],
                  [FunDecl,
                    Idfr("fact"),
                    IntType,
                    [
                      [Idfr("n"), IntType]
                    ],
                    [
                      [IfStmt,
                        [BinOpExpr,
                          And,
                          [BinOpExpr,
                            Gtr,
                            Idfr("n"),
                            IntLit(5)],
                          [BinOpExpr,
                            LessEq,
                            Idfr("n"),
                            IntLit(20)]
                        ],
                        [Idfr("n")],
                        [IntLit(0)]
                      ]
                    ]
                  ]
                ]
                """));
    }

    @Test
    public void test8() throws IOException{
        assertEquals("NORMAL_TERMINATION\n" +
                     "0", helper("""
                [
                  [FunDecl,
                    Idfr("main"),
                    IntType,
                    [],
                    [
                      [FunInvoc,
                        Idfr("fact"),
                        [IntLit(5)]
                      ]
                    ]
                  ],
                  [FunDecl,
                    Idfr("fact"),
                    IntType,
                    [
                      [Idfr("n"), IntType]
                    ],
                    [
                      [IfStmt,
                        [BinOpExpr,
                          And,
                          [BinOpExpr,
                            Gtr,
                            Idfr("n"),
                            IntLit(5)],
                          [BinOpExpr,
                            LessEq,
                            Idfr("n"),
                            IntLit(20)]
                        ],
                        [Idfr("n")],
                        [IntLit(0)]
                      ]
                    ]
                  ]
                ]
                """));
    }
}
