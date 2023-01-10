package SymbolTable;

import java.util.List;

public class SymbolTable {
	
	/*tabela simbola za "language scope"
	u ovom slucaju tu pripadaju samo tipovi*/
	private SymbolNode types;
	
	/* tabela simbola za oblast vazenja programa */
	private SymbolNode variables;
	private SymbolNode functions;
	
	public SymbolTable( )
	{
		types = new Type( "unknown", Type.UNKNOWN, null);
		types = new Type( "char", Type.CHARACTER, types );
		types = new Type( "integer", Type.INTEGER, types );
		types = new Type( "real", Type.REAL , types );
		types = new Type( "bool", Type.BOOL , types );
		types= new Type("func",Type.FUNCTION,types);
		variables = null;
	}
	
	public boolean addVar( String name, Type type )
	{
		Variable existing = this.getVar( name );
		if ( existing != null )
			return false;
		variables = new Variable( name, type, variables );
		return true;
	}
	
	public Variable getVar( String name )
	{
		SymbolNode current = variables;
		while ( current != null && 
				current.name.compareTo( name ) != 0 )
			current = current.next;
		return ( Variable ) current;
	}
	
	public Type getType(String typeName)
	{
		SymbolNode current = types;
		while ( current != null && 
				current.name.compareTo( typeName ) != 0 )
			current = current.next;
		return ( Type ) current;
	}




	public SymbolNode getVariables()
	{
		return variables;
	}


	public Function getFunction(String name){
		SymbolNode current = functions;
		while ( current != null &&
				current.name.compareTo( name ) != 0 )
			current = current.next;
		return ( Function ) current;
	}
	public boolean addFunction(String name, Type type, List<String> sss)
	{
		Function existing = this.getFunction( name );
		if ( existing != null )
			return false;
		Function f = new Function( name, type,functions );
		f.setArgs(sss);
		functions=f;
		return true;
	}
	public boolean checkFArgs(Function f,List<String> args){
		if(f.getArgs().size()==args.size())
			return true;
		 return false;
	}

}
