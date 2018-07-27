grammar DML;

program         : (command | query)*;

// parser rules for query parsing
query           : relname ASSIGN expr ';' ;

expr            : selection
                | projection
                | renaming
                | union
                | difference
                | product
                | natjoin
                | atomexpr
                ;

selection       : 'select' LPAREN condition RPAREN atomexpr;
condition       : conjunction ( BOOLOR conjunction )*;
conjunction     : comparison ( BOOLAND comparison )*;
comparison      : operand op operand | LPAREN condition RPAREN;

op              : EQUALS
                | NOTEQUAL
                | LESS
                | GREATER
                | LESSOREQ
                | GREATEROREQ;

operand         : attrname | literal;
projection      : 'project' LPAREN attrlist RPAREN atomexpr;
renaming        : 'rename' LPAREN attrlist RPAREN atomexpr;
attrlist        : attrname ( COMMA attrname )*;
union           : atomexpr PLUS atomexpr;
difference      : atomexpr MINUS atomexpr;
product         : atomexpr MULTIPLY atomexpr;
natjoin         : atomexpr AND atomexpr;

atomexpr        : relname | LPAREN expr RPAREN;

attrname        : identifier;
relname         : identifier;
identifier      : ALPHA (ALPHA | DIGIT)* ;
literal         : QUOTE ? ( ALPHA* | DIGIT* ) QUOTE ? ;

// parser rules for command parsing
command         : (opencmd
                | closecmd
                | writecmd
                | exitcmd
                | showcmd
                | createcmd
                | updatecmd
                | insertcmd
                | deletecmd) ';'
                ;

opencmd         : OPEN relname;
closecmd        : CLOSE relname;
writecmd        : WRITE relname;
exitcmd         : EXIT;
showcmd         : SHOW atomexpr;
createcmd       : CREATE TABLE relname LPAREN typedAttributeList RPAREN PRIMARYKEY LPAREN attrlist RPAREN;
updatecmd       : UPDATE relname SET attrname EQUALS literal (COMMA attrname EQUALS literal)* WHERE condition;
insertcmd       : INSERTINTO relname VALUESFROM LPAREN literal (COMMA literal)* RPAREN
                | INSERTINTO relname VALUESFROM RELATION expr
                ;
deletecmd       : DELETEFROM relname WHERE condition;


typedAttributeList  : attrname type ( COMMA attrname type )*;

type                : VARCHAR LPAREN DIGIT RPAREN | INTEGER;

// lexer rules
VARCHAR     : 'VARCHAR';
INTEGER     : 'INTEGER';
TABLE       : 'TABLE';
OPEN        : 'OPEN';
CLOSE       : 'CLOSE';
WRITE       : 'WRITE';
EXIT        : 'EXIT';
SHOW        : 'SHOW';
CREATE      : 'CREATE';
UPDATE      : 'UPDATE';
INSERTINTO  : 'INSERT INTO';
DELETEFROM  : 'DELETE FROM';
VALUESFROM  : 'VALUES FROM';
RELATION    : 'RELATION';
SET         : 'SET';
WHERE       : 'WHERE';
PRIMARYKEY  : 'PRIMARY KEY';

PLUS        : '+';
ASSIGN      : '<-';
MINUS       : '-';
MULTIPLY    : '*';
AND         : '&';
LPAREN      : '(';
RPAREN      : ')';
COMMA       : ',';
QUOTE       : '"';

BOOLAND     : '&&';
BOOLOR      : '||';
EQUALS      : '==';
NOTEQUAL    : '!=';
GREATER     : '>';
LESS        : '<';
GREATEROREQ : '>=';
LESSOREQ    : '<=';

ALPHA       : [a-zA-Z_]+;
DIGIT       : '-'?[0-9]+;
DOUBLE      : '-'?[0-9]+'.'[0-9]+;
WHITESPACE  : [ \t\n\r]+ -> skip;