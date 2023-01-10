package SymbolTable;

public class Type extends SymbolNode {
	public static final int INTEGER = 0;
	public static final int CHARACTER = 1;
	public static final int UNKNOWN = 2;
	public static final int REAL = 3;
	public static final int BOOL = 4;
	public int tkind;
	
	public Type ( String name, 
			int typeKind, 
			SymbolNode next)
	{
		super( name, TYPE, null, next );
		this.tkind = typeKind;
		this.type = this;
	}
}
