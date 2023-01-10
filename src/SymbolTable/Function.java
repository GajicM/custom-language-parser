package SymbolTable;

import java.util.ArrayList;
import java.util.List;

public class Function extends SymbolNode{
    private List<String> args;

    public Function(String symbolName, Type symbolType, SymbolNode nextSymbol) {
        super(symbolName, FUNCTION, symbolType, nextSymbol);
        args=null;
    }

    public List<String> getArgs() {
        return args;
    }

    public void setArgs(List<String> args) {
        this.args = args;
    }
    public boolean addArg(String arg){
        if(args==null)
            args=new ArrayList<>();
       return args.add(arg);
    }
}
