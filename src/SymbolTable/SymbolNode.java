package SymbolTable;

public class SymbolNode {
	public static final int TYPE = 0;
	public static final int VARIABLE = 1;
	public static final int FUNCTION= 2;
	public String name;
	public int kind;
	public Type type;
	public SymbolNode next;
	
	public SymbolNode( String symbolName, 
			int symbolKind, 
			Type symbolType, 
			SymbolNode nextSymbol)
	{
		name = symbolName;
		kind = symbolKind;
		type = symbolType;
		next = nextSymbol;
	}
	
}
