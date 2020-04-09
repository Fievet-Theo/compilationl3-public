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
			useAndDef(nasmInst);
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

    private void useAndDef(NasmInst inst) {
		setUseAndDef(inst, inst.source);
		if (inst.source instanceof NasmAddress) {
			setUseAndDef(inst, ((NasmAddress) inst.source).base);
			setUseAndDef(inst, ((NasmAddress) inst.source).offset);
		}

		setUseAndDef(inst, inst.destination);
		if (inst.destination instanceof NasmAddress) {
			setUseAndDef(inst, ((NasmAddress) inst.destination).base);
			setUseAndDef(inst, ((NasmAddress) inst.destination).offset);
		}
	}

	private void setUseAndDef (NasmInst inst, NasmOperand operand) {
		if (operand instanceof NasmRegister && ((NasmRegister) operand).color != Nasm.REG_EBP && ((NasmRegister) operand).color != Nasm.REG_ESP) {
			if (inst.destDef) {
				this.def.get(inst).add(((NasmRegister) operand).val);
			}
			if (inst.destUse) {
				this.use.get(inst).add(((NasmRegister) operand).val);
			}
		}
	}
}

    
