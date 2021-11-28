grammar Language;

@header {
    package language;
}

//Parser Rules:
wholeprog
    : prog EOF
    ;

prog
	: dec                               # DecOnly
	| dec prog                          # DecProg
	; // add 'EOF' and regenerate carefully

dec
	: type Idfr '('vardec')' block
	;

vardec
	: /* epsilon */                         # NoParam
	| vardecne                              # YesParam
	;

vardecne
    : type Idfr                             # Param
    | vardecne',' type Idfr                 # AnotherParam
    ;

block
    : '{' ene '}'
    ;

ene
	: exp                                   # OneExp
	| exp ';' ene                           # AnotherExp
	;

exp
	: Idfr                                  # Identifier
	| IntLit                                # IntLiteral
	| Idfr Assign exp                       # Assign
	| '('exp binop exp')'                   # AddMinTimDiv
	| Idfr '('args')'                       # FuncCall
	| block                                 # AnotherBlock
	| 'if' exp 'then' block 'else' block    # IfElse
	| 'while' exp 'do' block                # WhileLoop
	| 'repeat' block 'until' exp            # RepeatLoop
	| 'skip'                                # Skip
	;

args
	: /* epsilon */                         # NoArg
	| argsne                                # YesArg
	;

argsne
    : exp                                   # ExpArg
    | argsne',' exp                         # ArgAnotherExp
    ;

binop
	: '=='                                  // # Eq
	| '<'                                   // # Less
	| '>'                                   // # Gtr
	| '<='                                  // # LessEq
	| '>='                                  // # GtrEq
	| '+'                                   // # Plus
	| '-'                                   // # Minus
	| '*'                                   // # Times
	| '/'                                   // # Div
	| '&&'                                  // # And
	| '||'                                  // # Or
	| '^^'                                  // # Xor
	;

type
	: 'int'
	| 'bool'
	| 'unit'
	;

// Lexer Rules:
Skip
    : 'skip' ;

While
    : 'while' ;

Do
    : 'do' ;

If
    : 'if' ;

Then
	: 'then' ;

Else
    : 'else' ;

Repeat
    : 'repeat' ;

Until
    : 'until' ;

IntType
    : 'int' ;

BoolType
	: 'bool' ;

UnitType
    : 'unit' ;

Idfr
    : [a-z][A-Za-z0-9_]* ;

IntLit
    : '0'
    | [1-9][0-9]* ;

LParen
	: '(' ;

Comma
	: ',' ;

RParen
    : ')' ;

LBrace
	: '{' ;

Semicolon
	: ';' ;

RBrace
	: '}' ;

Assign
	: ':=' ;

Less
	: '<' ;

LessEq
	: '<=' ;

Plus
	: '+' ;

Minus
	: '-' ;

And
	: '&&' ;

Xor
	: '^^' ;

Eq
	: '==' ;

Gtr
	: '>' ;

GtrEq
	: '>=' ;

Times
	: '*' ;

Div
 	: '/' ;

Or
	: '||' ;

WS
    : [ \n\r\t]+ -> skip ;
