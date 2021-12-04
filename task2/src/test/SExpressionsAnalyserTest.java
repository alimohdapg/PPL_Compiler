import language.SExpressionsAnalyser;
import language.SExpressionsLexer;
import language.SExpressionsParser;
import language.TypeException;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import static org.junit.jupiter.api.Assertions.*;

public class SExpressionsAnalyserTest {

    public String worker(String s) throws IOException {
        CharStream input = CharStreams.fromStream(new ByteArrayInputStream(s.getBytes(StandardCharsets.UTF_8)));
        SExpressionsLexer lexer = new SExpressionsLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        SExpressionsParser parser = new SExpressionsParser(tokens);
        SExpressionsParser.ProgContext tree = parser.prog();
        SExpressionsAnalyser typeChecker = new SExpressionsAnalyser();
        try {
            return typeChecker.visitAndPrint(tree);
        } catch (TypeException ex) {
            return ex.report();
        }
    }

    @Test
    public void test1() throws IOException {
        assertEquals(worker("""
                [
                  [FunDecl,
                    Idfr("fun"),
                    IntType,
                    [[Idfr("x"), IntType], [Idfr("y"), IntType], [Idfr("z"), IntType]],
                    [
                      [IfStmt,
                        [BinOpExpr,
                          Eq,
                          Idfr("x"),
                          Idfr("y")
                        ],
                        [
                          Idfr("z")
                        ],
                        [
                          IntLit(0)
                        ]
                      ]
                    ]
                  ],
                  [FunDecl,
                    Idfr("main"),
                    IntType,
                    [],
                    [
                      [FunInvoc,
                        Idfr("fun"),
                        [
                          IntLit(1),
                          IntLit(2),
                          IntLit(3)
                        ]
                      ]
                    ]
                  ],
                  [FunDecl,
                    Idfr("fun2"),
                    UnitType,
                    [],
                    [
                      Skip
                    ]
                  ]
                ]"""), """
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
                  ],
                  [FunDecl,
                    Idfr("fun2"),
                    UnitType,
                    [],
                    [Skip]
                  ]
                ]""");
    }

    @Test
    public void test2() throws IOException {
        assertEquals(worker("""
                [
                  [FunDecl,
                    Idfr("fun"),
                    IntType,
                    [[Idfr("x"), IntType], [Idfr("y"), IntType], [Idfr("z"), IntType]],
                    [
                      [IfStmt,
                        [BinOpExpr,
                          Eq,
                          Idfr("x"),
                          Idfr("y")
                        ],
                        [
                          Idfr("z")
                        ],
                        [
                          IntLit(0)
                        ]
                      ]
                    ]
                  ],
                  [FunDecl,
                    Idfr("main1"),
                    IntType,
                    [],
                    [
                      [FunInvoc,
                        Idfr("fun"),
                        [
                          IntLit(1),
                          IntLit(2),
                          IntLit(3)
                        ]
                      ]
                    ]
                  ],
                  [FunDecl,
                    Idfr("fun2"),
                    UnitType,
                    [],
                    [
                      Skip
                    ]
                  ]
                ]"""), """
                No main function declared:
                                
                                
                                
                ---
                                
                no further diagnostic messages available""");
    }

    @Test
    public void test3() throws IOException {
        assertEquals(worker("""
                [
                  [FunDecl,
                    Idfr("fun"),
                    IntType,
                    [[Idfr("x"), IntType], [Idfr("y"), IntType], [Idfr("z"), IntType]],
                    [
                      [IfStmt,
                        [BinOpExpr,
                          Eq,
                          Idfr("x"),
                          Idfr("y")
                        ],
                        [
                          Idfr("z")
                        ],
                        [
                          IntLit(0)
                        ]
                      ]
                    ]
                  ],
                  [FunDecl,
                    Idfr("main"),
                    BoolType,
                    [],
                    [
                      [FunInvoc,
                        Idfr("fun"),
                        [
                          IntLit(1),
                          IntLit(2),
                          IntLit(3)
                        ]
                      ]
                    ]
                  ],
                  [FunDecl,
                    Idfr("fun2"),
                    UnitType,
                    [],
                    [
                      Skip
                    ]
                  ]
                ]"""), """
                Error in the signature of the main function:
                                
                [...,
                  [31m[FunDecl,
                    Idfr("main"),
                    BoolType,
                    [],
                    [
                      [FunInvoc,
                        Idfr("fun"),
                        [IntLit(1),
                          IntLit(2),
                          IntLit(3)]
                      ]
                    ]
                  ][0m,
                  ...]
                                
                ---
                                
                [31m[FunDecl,
                  Idfr("main"),
                  BoolType,
                  [],
                  [
                    [FunInvoc,
                      Idfr("fun"),
                      [IntLit(1),
                        IntLit(2),
                        IntLit(3)]
                    ]
                  ]
                ][0m
                                
                has type BOOL""");
    }

    @Test
    public void test4() throws IOException {
        assertEquals(worker("""
                [
                  [FunDecl,
                    Idfr("fun"),
                    IntType,
                    [[Idfr("x"), IntType], [Idfr("y"), IntType], [Idfr("z"), IntType]],
                    [
                      [IfStmt,
                        [BinOpExpr,
                          Eq,
                          Idfr("x"),
                          Idfr("y")
                        ],
                        [
                          Idfr("z")
                        ],
                        [
                          IntLit(0)
                        ]
                      ]
                    ]
                  ],
                  [FunDecl,
                    Idfr("main"),
                    IntType,
                    [[Idfr("a"), BoolType], [Idfr("b"), IntType]],
                    [
                      [FunInvoc,
                        Idfr("fun"),
                        [
                          IntLit(1),
                          IntLit(2),
                          IntLit(3)
                        ]
                      ]
                    ]
                  ],
                  [FunDecl,
                    Idfr("fun2"),
                    UnitType,
                    [],
                    [
                      Skip
                    ]
                  ]
                ]"""), """
                Error in the signature of the main function:
                                
                [FunDecl,
                  Idfr("main"),
                  IntType,
                  [[31m[Idfr("a"), BoolType][0m,
                    ...],
                  ...]
                                
                ---
                                
                [31m[Idfr("a"), BoolType][0m
                                
                has type BOOL""");
    }

    @Test
    public void test5() throws IOException {
        assertEquals(worker("""
                [
                  [FunDecl,
                    Idfr("fun"),
                    IntType,
                    [[Idfr("x"), IntType], [Idfr("y"), IntType], [Idfr("z"), IntType]],
                    [
                      [IfStmt,
                        [BinOpExpr,
                          Eq,
                          Idfr("x"),
                          Idfr("y")
                        ],
                        [
                          Idfr("z")
                        ],
                        [
                          IntLit(0)
                        ]
                      ]
                    ]
                  ],
                  [FunDecl,
                    Idfr("main"),
                    IntType,
                    [],
                    [
                      [FunInvoc,
                        Idfr("fun"),
                        [
                          IntLit(1),
                          IntLit(2),
                          IntLit(3)
                        ]
                      ]
                    ]
                  ],
                  [FunDecl,
                    Idfr("fun"),
                    UnitType,
                    [],
                    [
                      Skip
                    ]
                  ]
                ]"""), """
                Duplicated function names:
                                
                [...,
                  ...,
                  [FunDecl,
                    [31mIdfr("fun")[0m,
                    UnitType,
                    [],
                    ...]
                ]
                                
                ---
                                
                [31mIdfr("fun")[0m
                                
                has type UNIT""");
    }

    @Test
    public void test6() throws IOException {
        assertEquals(worker("""
                [
                  [FunDecl,
                    Idfr("fun"),
                    IntType,
                    [[Idfr("x"), IntType], [Idfr("y"), IntType], [Idfr("y"), IntType]],
                    [
                      [IfStmt,
                        [BinOpExpr,
                          Eq,
                          Idfr("x"),
                          Idfr("y")
                        ],
                        [
                          IntLit(1)
                        ],
                        [
                          IntLit(0)
                        ]
                      ]
                    ]
                  ],
                  [FunDecl,
                    Idfr("main"),
                    IntType,
                    [],
                    [
                      [FunInvoc,
                        Idfr("fun"),
                        [
                          IntLit(1),
                          IntLit(2),
                          IntLit(3)
                        ]
                      ]
                    ]
                  ],
                  [FunDecl,
                    Idfr("fun2"),
                    UnitType,
                    [],
                    [
                      Skip
                    ]
                  ]
                ]"""), """
                Duplicated variable names:
                                
                [FunDecl,
                  Idfr("fun"),
                  IntType,
                  [...,
                    ...,
                    [[31mIdfr("y")[0m, IntType]
                  ],
                  ...]
                                
                ---
                                
                [31mIdfr("y")[0m
                                
                has type INT""");
    }

    @Test
    public void test7() throws IOException {
        assertEquals(worker("""
                [
                  [FunDecl,
                    Idfr("fun"),
                    IntType,
                    [[Idfr("x"), IntType], [Idfr("y"), IntType], [Idfr("z"), UnitType]],
                    [
                      [IfStmt,
                        [BinOpExpr,
                          Eq,
                          Idfr("x"),
                          Idfr("y")
                        ],
                        [
                          IntLit(1)
                        ],
                        [
                          IntLit(0)
                        ]
                      ]
                    ]
                  ],
                  [FunDecl,
                    Idfr("main"),
                    IntType,
                    [],
                    [
                      [FunInvoc,
                        Idfr("fun"),
                        [
                          IntLit(1),
                          IntLit(2),
                          IntLit(3)
                        ]
                      ]
                    ]
                  ],
                  [FunDecl,
                    Idfr("fun2"),
                    UnitType,
                    [],
                    [
                      Skip
                    ]
                  ]
                ]"""), """
                Variable of 'unit' type:
                                
                [FunDecl,
                  Idfr("fun"),
                  IntType,
                  [...,
                    ...,
                    [[31mIdfr("z")[0m, UnitType]
                  ],
                  ...]
                                
                ---
                                
                [31mIdfr("z")[0m
                                
                has type UNIT""");
    }

    @Test
    public void test8() throws IOException {
        assertEquals(worker("""
                [
                  [FunDecl,
                    Idfr("fun"),
                    IntType,
                    [[Idfr("x"), IntType], [Idfr("y"), IntType], [Idfr("z"), IntType]],
                    [
                      [IfStmt,
                        [BinOpExpr,
                          Eq,
                          Idfr("x"),
                          Idfr("y")
                        ],
                        [
                          Idfr("z")
                        ],
                        [
                          IntLit(0)
                        ]
                      ]
                    ]
                  ],
                  [FunDecl,
                    Idfr("main"),
                    IntType,
                    [],
                    [
                      [FunInvoc,
                        Idfr("fun3"),
                        [
                          IntLit(1),
                          IntLit(2),
                          IntLit(3)
                        ]
                      ]
                    ]
                  ],
                  [FunDecl,
                    Idfr("fun2"),
                    UnitType,
                    [],
                    [
                      Skip
                    ]
                  ]
                ]"""), """
                Unknown function name:
                                
                [FunDecl,
                  Idfr("main"),
                  IntType,
                  [],
                  [
                    [FunInvoc,
                      [31mIdfr("fun3")[0m,
                      ...]
                  ]
                ]
                                
                ---
                                
                [31mIdfr("fun3")[0m
                                
                has type UNKNOWN""");
    }

    @Test
    public void test9() throws IOException {
        assertEquals(worker("""
                [
                  [FunDecl,
                    Idfr("fun"),
                    IntType,
                    [[Idfr("x"), IntType], [Idfr("y"), IntType], [Idfr("z"), IntType]],
                    [
                      [IfStmt,
                        [BinOpExpr,
                          Eq,
                          Idfr("x"),
                          Idfr("y")
                        ],
                        [
                          Idfr("z")
                        ],
                        [
                          IntLit(0)
                        ]
                      ]
                    ]
                  ],
                  [FunDecl,
                    Idfr("main"),
                    IntType,
                    [],
                    [
                      [FunInvoc,
                        Idfr("fun"),
                        [
                          IntLit(1),
                          Idfr("a"),
                          IntLit(3)
                        ]
                      ]
                    ]
                  ],
                  [FunDecl,
                    Idfr("fun2"),
                    UnitType,
                    [],
                    [
                      Skip
                    ]
                  ]
                ]"""), """
                Unknown variable name:
                                
                [FunDecl,
                  Idfr("main"),
                  IntType,
                  [],
                  [
                    [FunInvoc,
                      Idfr("fun"),
                      [...,
                        [31mIdfr("a")[0m,
                        ...]
                    ]
                  ]
                ]
                                
                ---
                                
                [31mIdfr("a")[0m
                                
                has type UNKNOWN""");
    }

    @Test
    public void test10() throws IOException {
        assertEquals(worker("""
                [
                  [FunDecl,
                    Idfr("fun"),
                    IntType,
                    [[Idfr("x"), IntType], [Idfr("y"), IntType], [Idfr("z"), IntType]],
                    [
                      [IfStmt,
                        [BinOpExpr,
                          Eq,
                          Idfr("x"),
                          [BinOpExpr,
                            Eq,
                            IntLit(1),
                            IntLit(1)
                          ]
                        ],
                        [
                          Idfr("z")
                        ],
                        [
                          IntLit(0)
                        ]
                      ]
                    ]
                  ],
                  [FunDecl,
                    Idfr("main"),
                    IntType,
                    [],
                    [
                      [FunInvoc,
                        Idfr("fun"),
                        [
                          IntLit(1),
                          IntLit(2),
                          IntLit(3)
                        ]
                      ]
                    ]
                  ],
                  [FunDecl,
                    Idfr("fun2"),
                    UnitType,
                    [],
                    [
                      Skip
                    ]
                  ]
                ]"""), """
                Invalid operands in integer comparison:
                                
                [BinOpExpr,
                  Eq,
                  [31mIdfr("x")[0m,
                  [BinOpExpr,
                    Eq,
                    IntLit(1),
                    IntLit(1)]
                ]
                                
                and
                                
                [BinOpExpr,
                  Eq,
                  Idfr("x"),
                  [31m[BinOpExpr,
                    Eq,
                    IntLit(1),
                    IntLit(1)][0m]
                                
                ---
                                
                [31mIdfr("x")[0m
                                
                has type INT
                                
                ,
                                
                [31m[BinOpExpr,
                  Eq,
                  IntLit(1),
                  IntLit(1)][0m
                                
                has type BOOL""");
    }

    @Test
    public void test11() throws IOException {
        assertEquals(worker("""
                [
                  [FunDecl,
                    Idfr("fun"),
                    IntType,
                    [[Idfr("x"), IntType], [Idfr("y"), IntType], [Idfr("z"), IntType]],
                    [
                      [IfStmt,
                        [BinOpExpr,
                          Eq,
                          Idfr("x"),
                          Idfr("y")
                        ],
                        [
                          [BinOpExpr,
                            Plus,
                            Idfr("z"),
                            [BinOpExpr,
                              Eq,
                              IntLit(1),
                              IntLit(1)
                            ]
                          ]
                        ],
                        [
                          IntLit(0)
                        ]
                      ]
                    ]
                  ],
                  [FunDecl,
                    Idfr("main"),
                    IntType,
                    [],
                    [
                      [FunInvoc,
                        Idfr("fun"),
                        [
                          IntLit(1),
                          IntLit(2),
                          IntLit(3)
                        ]
                      ]
                    ]
                  ],
                  [FunDecl,
                    Idfr("fun2"),
                    UnitType,
                    [],
                    [
                      Skip
                    ]
                  ]
                ]"""), """
                Invalid operands in arithmetic expression:
                                
                [BinOpExpr,
                  Plus,
                  [31mIdfr("z")[0m,
                  [BinOpExpr,
                    Eq,
                    IntLit(1),
                    IntLit(1)]
                ]
                                
                and
                                
                [BinOpExpr,
                  Plus,
                  Idfr("z"),
                  [31m[BinOpExpr,
                    Eq,
                    IntLit(1),
                    IntLit(1)][0m]
                                
                ---
                                
                [31mIdfr("z")[0m
                                
                has type INT
                                
                ,
                                
                [31m[BinOpExpr,
                  Eq,
                  IntLit(1),
                  IntLit(1)][0m
                                
                has type BOOL""");
    }

    @Test
    public void test12() throws IOException {
        assertEquals(worker("""
                [
                  [FunDecl,
                    Idfr("fun"),
                    BoolType,
                    [[Idfr("x"), IntType], [Idfr("y"), IntType], [Idfr("z"), IntType]],
                    [
                      [IfStmt,
                        [BinOpExpr,
                          Eq,
                          Idfr("x"),
                          Idfr("y")
                        ],
                        [
                          [BinOpExpr,
                            And,
                            Idfr("z"),
                            [BinOpExpr,
                              Eq,
                              IntLit(1),
                              IntLit(1)
                            ]
                          ]
                        ],
                        [
                          [BinOpExpr,
                            Eq,
                            IntLit(1),
                            IntLit(1)
                          ]
                        ]
                      ]
                    ]
                  ],
                  [FunDecl,
                    Idfr("main"),
                    IntType,
                    [],
                    [
                      [FunInvoc,
                        Idfr("fun"),
                        [
                          IntLit(1),
                          IntLit(2),
                          IntLit(3)
                        ]
                      ],
                      IntLit(1)
                    ]
                  ],
                  [FunDecl,
                    Idfr("fun2"),
                    UnitType,
                    [],
                    [
                      Skip
                    ]
                  ]
                ]"""), """
                Invalid operands in Boolean expression:
                                
                [BinOpExpr,
                  And,
                  [31mIdfr("z")[0m,
                  [BinOpExpr,
                    Eq,
                    IntLit(1),
                    IntLit(1)]
                ]
                                
                and
                                
                [BinOpExpr,
                  And,
                  Idfr("z"),
                  [31m[BinOpExpr,
                    Eq,
                    IntLit(1),
                    IntLit(1)][0m]
                                
                ---
                                
                [31mIdfr("z")[0m
                                
                has type INT
                                
                ,
                                
                [31m[BinOpExpr,
                  Eq,
                  IntLit(1),
                  IntLit(1)][0m
                                
                has type BOOL""");
    }

    @Test
    public void test13() throws IOException {
        assertEquals(worker("""
                [
                  [FunDecl,
                    Idfr("fun"),
                    IntType,
                    [[Idfr("x"), IntType], [Idfr("y"), IntType], [Idfr("z"), IntType]],
                    [
                      [IfStmt,
                        [BinOpExpr,
                          Eq,
                          Idfr("x"),
                          Idfr("y")
                        ],
                        [
                          [BinOpExpr,
                            Eq,
                            IntLit(1),
                            IntLit(1)
                          ]
                        ],
                        [
                          IntLit(0)
                        ]
                      ],
                      IntLit(3)
                    ]
                  ],
                  [FunDecl,
                    Idfr("main"),
                    IntType,
                    [],
                    [
                      [FunInvoc,
                        Idfr("fun"),
                        [
                          IntLit(1),
                          IntLit(2),
                          IntLit(3)
                        ]
                      ]
                    ]
                  ],
                  [FunDecl,
                    Idfr("fun2"),
                    UnitType,
                    [],
                    [
                      Skip
                    ]
                  ]
                ]"""), """
                Mismatched expressions in if statement:
                                
                [IfStmt,
                  [BinOpExpr,
                    Eq,
                    Idfr("x"),
                    Idfr("y")],
                  [[31m[BinOpExpr,
                      Eq,
                      IntLit(1),
                      IntLit(1)][0m],
                  ...]
                                
                and
                                
                [IfStmt,
                  [BinOpExpr,
                    Eq,
                    Idfr("x"),
                    Idfr("y")],
                  ...,
                  [[31mIntLit(0)[0m]
                ]
                                
                ---
                                
                [31m[BinOpExpr,
                  Eq,
                  IntLit(1),
                  IntLit(1)][0m
                                
                has type BOOL
                                
                ,
                                
                [31mIntLit(0)[0m
                                
                has type INT""");
    }

    @Test
    public void test14() throws IOException {
        assertEquals(worker("""
                [
                  [FunDecl,
                    Idfr("fun"),
                    IntType,
                    [[Idfr("x"), IntType], [Idfr("y"), IntType], [Idfr("z"), IntType]],
                    [
                      [IfStmt,
                        Idfr("x"),
                        [
                          Idfr("z")
                        ],
                        [
                          IntLit(0)
                        ]
                      ]
                    ]
                  ],
                  [FunDecl,
                    Idfr("main"),
                    IntType,
                    [],
                    [
                      [FunInvoc,
                        Idfr("fun"),
                        [
                          IntLit(1),
                          IntLit(2),
                          IntLit(3)
                        ]
                      ]
                    ]
                  ],
                  [FunDecl,
                    Idfr("fun2"),
                    UnitType,
                    [],
                    [
                      Skip
                    ]
                  ]
                ]"""), """
                Invalid condition in if statement or loop:
                                
                [IfStmt,
                  [31mIdfr("x")[0m,
                  ...,
                  ...]
                                
                ---
                                
                [31mIdfr("x")[0m
                                
                has type INT""");
    }

    @Test
    public void test15() throws IOException {
        assertEquals(worker("""
                [
                  [FunDecl,
                    Idfr("fun"),
                    IntType,
                    [[Idfr("x"), IntType], [Idfr("y"), IntType], [Idfr("z"), IntType]],
                    [
                      [WhileLoop,
                        [BinOpExpr,
                          Eq,
                          Idfr("x"),
                          Idfr("y")
                        ],
                        [
                          IntLit(1),
                          [BinOpExpr,
                            Plus,
                            IntLit(1),
                            IntLit(3)
                          ],
                          Skip,
                          Idfr("z")
                        ]
                      ]
                    ]
                  ],
                  [FunDecl,
                    Idfr("main"),
                    IntType,
                    [],
                    [
                      [FunInvoc,
                        Idfr("fun"),
                        [
                          IntLit(1),
                          IntLit(2),
                          IntLit(3)
                        ]
                      ]
                    ]
                  ],
                  [FunDecl,
                    Idfr("fun2"),
                    UnitType,
                    [],
                    [
                      Skip
                    ]
                  ]
                ]"""), """
                Invalid final expression in loop body:
                                
                [WhileLoop,
                  [BinOpExpr,
                    Eq,
                    Idfr("x"),
                    Idfr("y")],
                  [...,
                    ...,
                    ...,
                    [31mIdfr("z")[0m]
                ]
                                
                ---
                                
                [31mIdfr("z")[0m
                                
                has type INT""");
    }

    @Test
    public void test16() throws IOException {
        assertEquals(worker("""
                [
                  [FunDecl,
                    Idfr("fun"),
                    IntType,
                    [[Idfr("x"), IntType], [Idfr("y"), IntType], [Idfr("z"), IntType]],
                    [
                      [IfStmt,
                        [BinOpExpr,
                          Eq,
                          Idfr("x"),
                          Idfr("y")
                        ],
                        [
                          Idfr("z")
                        ],
                        [
                          IntLit(0)
                        ]
                      ]
                    ]
                  ],
                  [FunDecl,
                    Idfr("main"),
                    IntType,
                    [],
                    [
                      [FunInvoc,
                        Idfr("fun"),
                        [
                          IntLit(1),
                          IntLit(2),
                          IntLit(3)
                        ]
                      ],
                      [BinOpExpr,
                        Eq,
                        IntLit(1),
                        IntLit(1)
                      ]
                    ]
                  ],
                  [FunDecl,
                    Idfr("fun2"),
                    UnitType,
                    [],
                    [
                      Skip
                    ]
                  ]
                ]"""), """
                Invalid return value type:
                                
                [FunDecl,
                  Idfr("main"),
                  IntType,
                  [],
                  [...,
                    [31m[BinOpExpr,
                      Eq,
                      IntLit(1),
                      IntLit(1)][0m]
                ]
                                
                ---
                                
                [31m[BinOpExpr,
                  Eq,
                  IntLit(1),
                  IntLit(1)][0m
                                
                has type BOOL""");
    }

    @Test
    public void test17() throws IOException {
        assertEquals(worker("""
                [
                  [FunDecl,
                    Idfr("fun"),
                    IntType,
                    [[Idfr("x"), IntType], [Idfr("y"), IntType], [Idfr("z"), IntType]],
                    [
                      [IfStmt,
                        [BinOpExpr,
                          Eq,
                          Idfr("x"),
                          Idfr("y")
                        ],
                        [
                          Idfr("z")
                        ],
                        [
                          [Asgmt,
                            Idfr("y"),
                            [BinOpExpr,
                              Eq,
                              IntLit(1),
                              IntLit(1)
                            ]
                          ],
                          IntLit(0)
                        ]
                      ]
                    ]
                  ],
                  [FunDecl,
                    Idfr("main"),
                    IntType,
                    [],
                    [
                      [FunInvoc,
                        Idfr("fun"),
                        [
                          IntLit(1),
                          IntLit(2),
                          IntLit(3)
                        ]
                      ]
                    ]
                  ],
                  [FunDecl,
                    Idfr("fun2"),
                    UnitType,
                    [],
                    [
                      Skip
                    ]
                  ]
                ]"""), """
                Incompatible types in assignment:
                                
                [Asgmt,
                  [31mIdfr("y")[0m,
                  [BinOpExpr,
                    Eq,
                    IntLit(1),
                    IntLit(1)]
                ]
                                
                and
                                
                [Asgmt,
                  Idfr("y"),
                  [31m[BinOpExpr,
                    Eq,
                    IntLit(1),
                    IntLit(1)][0m]
                                
                ---
                                
                [31mIdfr("y")[0m
                                
                has type INT
                                
                ,
                                
                [31m[BinOpExpr,
                  Eq,
                  IntLit(1),
                  IntLit(1)][0m
                                
                has type BOOL""");
    }

    @Test
    public void test18() throws IOException {
        assertEquals(worker("""
                [
                  [FunDecl,
                    Idfr("fun"),
                    IntType,
                    [[Idfr("x"), IntType], [Idfr("y"), IntType], [Idfr("z"), IntType]],
                    [
                      [IfStmt,
                        [BinOpExpr,
                          Eq,
                          Idfr("x"),
                          Idfr("y")
                        ],
                        [
                          Idfr("z")
                        ],
                        [
                          IntLit(0)
                        ]
                      ]
                    ]
                  ],
                  [FunDecl,
                    Idfr("main"),
                    IntType,
                    [],
                    [
                      [FunInvoc,
                        Idfr("fun"),
                        [
                          IntLit(1),
                          IntLit(2),
                          IntLit(3),
                          IntLit(4)
                        ]
                      ]
                    ]
                  ],
                  [FunDecl,
                    Idfr("fun2"),
                    UnitType,
                    [],
                    [
                      Skip
                    ]
                  ]
                ]"""), """
                Invalid # of arguments in invocation:
                                
                [FunInvoc,
                  Idfr("fun"),
                  [31m[IntLit(1),
                    IntLit(2),
                    IntLit(3),
                    IntLit(4)][0m]
                                
                ---
                                
                [31m[IntLit(1),
                  IntLit(2),
                  IntLit(3),
                  IntLit(4)][0m
                                
                has type UNKNOWN""");
    }

    @Test
    public void test19() throws IOException {
        assertEquals(worker("""
                [
                  [FunDecl,
                    Idfr("fun"),
                    IntType,
                    [[Idfr("x"), IntType], [Idfr("y"), IntType], [Idfr("z"), IntType]],
                    [
                      [IfStmt,
                        [BinOpExpr,
                          Eq,
                          Idfr("x"),
                          Idfr("y")
                        ],
                        [
                          Idfr("z")
                        ],
                        [
                          IntLit(0)
                        ]
                      ]
                    ]
                  ],
                  [FunDecl,
                    Idfr("main"),
                    IntType,
                    [],
                    [
                      [FunInvoc,
                        Idfr("fun"),
                        [
                          IntLit(1),
                          IntLit(2),
                          [BinOpExpr,
                            Eq,
                            IntLit(1),
                            IntLit(1)
                          ]
                        ]
                      ]
                    ]
                  ],
                  [FunDecl,
                    Idfr("fun2"),
                    UnitType,
                    [],
                    [
                      Skip
                    ]
                  ]
                ]"""), """
                Invalid argument in invocation:
                                
                [FunInvoc,
                  Idfr("fun"),
                  [...,
                    ...,
                    [31m[BinOpExpr,
                      Eq,
                      IntLit(1),
                      IntLit(1)][0m]
                ]
                                
                ---
                                
                [31m[BinOpExpr,
                  Eq,
                  IntLit(1),
                  IntLit(1)][0m
                                
                has type BOOL""");
    }
}
