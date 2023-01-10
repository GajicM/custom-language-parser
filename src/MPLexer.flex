// import section

import java_cup.runtime.*;

%%
// declaration section
%class MPLexer

%cup

%line
%column

%eofval{
	return new Symbol( sym.EOF );
%eofval}

%{
   public int getLine()
   {
      return yyline;
   }
%}


//states
%state COMMENT
//macros
slovo = [a-zA-Z]
cifra = [0-9]

%%
// rules section
<COMMENT> --	{ yybegin( YYINITIAL ); }
--			    { yybegin( COMMENT ); }
<COMMENT>.		{ ; }

[\t\r\n ]		{ ; }

//operators
\+				{ return new Symbol( sym.PLUS ); }
-               { return new Symbol( sym.MINUS ); }
\*				{ return new Symbol( sym.MUL );  }
\/              { return new Symbol( sym.DIV ); }
&&              { return new Symbol( sym.AND ); }
\|\|            { return new Symbol( sym.OR ); }
\<              { return new Symbol( sym.LESS ); }
\<=             { return new Symbol( sym.LESSEQ ); }
==              { return new Symbol( sym.EQEQ ); }
\>              { return new Symbol( sym.GREATER ); }
\>=             { return new Symbol( sym.GREATEREQ ); }
\{              { return new Symbol( sym.LEFTCURLY ); }
\}              { return new Symbol( sym.RIGHTCURLY ); }
\!=              { return new Symbol( sym.NOTEQUAL ); }

//separators
;				{ return new Symbol( sym.SEMI );	}
,				{ return new Symbol( sym.COMMA );	}

=				{ return new Symbol( sym.ASSIGN ); }
\(				{ return new Symbol( sym.LEFTPAR ); }
\)				{ return new Symbol( sym.RIGHTPAR ); }

//keywords
"main"          { return new Symbol( sym.MAIN );	}

"int"			{ return new Symbol( sym.INTEGER );	}
"char"			{ return new Symbol( sym.CHAR );	}
"real"			{ return new Symbol( sym.REAL );	}
"bool"		    { return new Symbol( sym.BOOL );	}
"while"			{ return new Symbol( sym.WHILE );	}
"read"			{ return new Symbol( sym.READ );	}
"write"			{ return new Symbol( sym.WRITE );	}
"return"        {return new Symbol(sym.RETURN);}
"if"            {return new Symbol(sym.IF); }
"then"          {return new Symbol(sym.THEN); }
//bools
"NO CAP"       { return new Symbol( sym.BOOLCONST, new Boolean( yytext() ) ); }
"CAP"          { return new Symbol( sym.BOOLCONST, new Boolean( yytext() ) ); }

//id-s
({slovo}| \_)({slovo}|{cifra}|\_)*	{ return new Symbol( sym.ID, yyline, yytext() ); }

//constants
{cifra}+        { return new Symbol( sym.INTCONST, new Integer( yytext() ) ); }

\'[^]\'			{ return new Symbol( sym.CHARCONST, new Character( yytext().charAt(1) ) ); }


{cifra}+\.({cifra}+)?(E[-\+]{cifra}+)?      { return new Symbol(sym.REALCONST, new Double(yytext())); }
\.{cifra}+(E[-\+]{cifra}+)?                 { return new Symbol(sym.REALCONST, new Double(yytext())); }


//error symbol
.		{ System.out.println( "ERROR: mojErr" + yytext() ); }

