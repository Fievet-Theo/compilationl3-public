package fg;
import util.graph.*;
import nasm.*;
import util.intset.*;
import java.io.*;
import java.util.*;

public class FgSolution{
    int iterNum = 0;
    public Nasm nasm;
    Fg fg;
    public Map< NasmInst, IntSet> use;
    public Map< NasmInst, IntSet> def;
    public Map< NasmInst, IntSet> in;
    public Map< NasmInst, IntSet> out;
    private Map<NasmOperand, Integer> operand2int;
    
    public FgSolution(Nasm nasm, Fg fg){
	this.nasm = nasm;
	this.fg = fg;
	this.use = new HashMap< NasmInst, IntSet>();
	this.def = new HashMap< NasmInst, IntSet>();
	this.in =  new HashMap< NasmInst, IntSet>();
	this.out = new HashMap< NasmInst, IntSet>();
	this.operand2int = new HashMap<>();
		for (NasmInst nasmInst : nasm.listeInst) {
			this.use.put(nasmInst, new IntSet(nasm.listeInst.size()));
			this.def.put(nasmInst, new IntSet(nasm.listeInst.size()));
			def(nasmInst);
			use(nasmInst);
		}
    }
    
    public void affiche(String baseFileName){
	String fileName;
	PrintStream out = System.out;
	
	if (baseFileName != null){
	    try {
		baseFileName = baseFileName;
		fileName = baseFileName + ".fgs";
		out = new PrintStream(fileName);
	    }
	    
	    catch (IOException e) {
		System.err.println("Error: " + e.getMessage());
	    }
	}
	
	out.println("iter num = " + iterNum);
	for(NasmInst nasmInst : this.nasm.listeInst){
	    out.println("use = "+ this.use.get(nasmInst) + " def = "+ this.def.get(nasmInst) + "\tin = " + this.in.get(nasmInst) + "\t \tout = " + this.out.get(nasmInst) + "\t \t" + nasmInst);
	}
    }

	private void use(NasmInst inst) {
		if (inst.srcUse && inst.source instanceof NasmRegister && ((NasmRegister)inst.source).color != Nasm.REG_EBP && ((NasmRegister)inst.source).color != Nasm.REG_ESP) {
			this.use.get(inst).add(operand2int.get(inst.source));
		}
		if (inst.destUse && inst.destination instanceof NasmRegister && ((NasmRegister)inst.destination).color != Nasm.REG_EBP && ((NasmRegister)inst.destination).color != Nasm.REG_ESP) {
			this.use.get(inst).add(operand2int.get(inst.destination));
		}
	}

	private void def(NasmInst inst) {
		if (inst.srcDef && inst.source instanceof NasmRegister && ((NasmRegister)inst.source).color != Nasm.REG_EBP && ((NasmRegister)inst.source).color != Nasm.REG_ESP) {
			int num;
			if (operand2int.containsKey(inst.source))
				num = operand2int.get(inst.source);
			else
				num = iterNum++;
			operand2int.put(inst.source, num);
			this.def.get(inst).add(num);
		}
		if (inst.destDef && inst.destination instanceof NasmRegister && ((NasmRegister)inst.destination).color != Nasm.REG_EBP && ((NasmRegister)inst.destination).color != Nasm.REG_ESP) {
			int num;
			if (operand2int.containsKey(inst.destination))
				num = operand2int.get(inst.destination);
			else
				num = iterNum++;
			operand2int.put(inst.destination, num);
			this.def.get(inst).add(num);
		}
	}

//	public Void visit(NasmAdd inst){
//		System.out.println("adddadddadad");
//		//use(inst);
//		//def(inst);
//		return null;
//	}
//	public Void visit(NasmCall inst){
//		System.out.println("caaal");
//		//use(inst);
//		//def(inst);
//		return null;
//	}
//	public Void visit(NasmDiv inst){
//		//use(inst);
//		//def(inst);
//		return null;
//	}
//	public Void visit(NasmJe inst){
//		System.out.println("je");
//		//use(inst);
//		//def(inst);
//		return null;
//	}
//	public Void visit(NasmJle inst){
//		//use(inst);
//		//def(inst);
//		return null;
//	}
//	public Void visit(NasmJne inst){
//		//use(inst);
//		//def(inst);
//		return null;
//	}
//	public Void visit(NasmMul inst){
//		//use(inst);
//		//def(inst);
//		return null;
//	}
//	public Void visit(NasmOr inst){
//		//use(inst);
//		//def(inst);
//		return null;
//	}
//	public Void visit(NasmCmp inst){
//		System.out.println("cmp");
//		//use(inst);
//		//def(inst);
//		return null;
//	}
//	public Void visit(NasmInst inst){
//		System.out.println("inst");
//		//use(inst);
//		//def(inst);
//		return null;
//	}
//	public Void visit(NasmJge inst){
//		//use(inst);
//		//def(inst);
//		return null;
//	}
//	public Void visit(NasmJl inst){
//		//use(inst);
//		//def(inst);
//		return null;
//	}
//	public Void visit(NasmNot inst){
//		//use(inst);
//		//def(inst);
//		return null;
//	}
//	public Void visit(NasmPop inst){
//		System.out.println("pop");
//		//use(inst);
//		//def(inst);
//		return null;
//	}
//	public Void visit(NasmRet inst){
//		System.out.println("ret");
//		//use(inst);
//		//def(inst);
//		return null;
//	}
//	public Void visit(NasmXor inst){
//		//use(inst);
//		//def(inst);
//		return null;
//	}
//	public Void visit(NasmAnd inst){
//		//use(inst);
//		//def(inst);
//		return null;
//	}
//	public Void visit(NasmJg inst){
//		//use(inst);
//		//def(inst);
//		return null;
//	}
//	public Void visit(NasmJmp inst){
//		System.out.println("jmp");
//		//use(inst);
//		//def(inst);
//		return null;
//	}
//	public Void visit(NasmMov inst){
//		System.out.println("mov");
//		//use(inst);
//		//def(inst);
//		return null;
//	}
//	public Void visit(NasmPush inst){
//		System.out.println("push");
//		//use(inst);
//		//def(inst);
//		return null;
//	}
//	public Void visit(NasmSub inst){
//		System.out.println("sub");
//		//use(inst);
//		//def(inst);
//		return null;
//	}
//	public Void visit(NasmEmpty inst){
//		System.out.println("empty");
//		//use(inst);
//		//def(inst);
//		return null;
//	}
//
//	public Void visit(NasmAddress operand){return null;}
//	public Void visit(NasmConstant operand){return null;}
//	public Void visit(NasmLabel operand){return null;}
//	public Void visit(NasmRegister operand){return null;}
}

    
