package fg;
import nasm.*;
import util.graph.*;
import util.intset.IntSet;

import java.util.*;
import java.io.*;

public class Fg implements NasmVisitor <Void> {
    public Nasm nasm;
    public Graph graph;
    Map< NasmInst, Node> inst2Node;
    Map< Node, NasmInst> node2Inst;
    Map< String, NasmInst> label2Inst;

    public Fg(Nasm nasm){
	this.nasm = nasm;
	this.inst2Node = new HashMap< NasmInst, Node>();
	this.node2Inst = new HashMap< Node, NasmInst>();
	this.label2Inst = new HashMap< String, NasmInst>();
	this.graph = new Graph();
        for (NasmInst nasmInst : nasm.listeInst) {
            Node node = graph.newNode();
            inst2Node.put(nasmInst, node);
            node2Inst.put(node, nasmInst);
            if((nasmInst.label != null) && (label2Inst.get(nasmInst.label.toString()) == null))
                label2Inst.put(nasmInst.label.toString(), nasmInst);
            //nasmInst.accept(this);
        }
        for (NasmInst nasmInst : nasm.listeInst) {
            nasmInst.accept(this);
        }
    }

    public void affiche(String baseFileName){
	String fileName;
	PrintStream out = System.out;

	if (baseFileName != null){
	    try {
		baseFileName = baseFileName;
		fileName = baseFileName + ".fg";
		out = new PrintStream(fileName);
	    }
	    
	    catch (IOException e) {
		System.err.println("Error: " + e.getMessage());
	    }
	}
	
	for(NasmInst nasmInst : nasm.listeInst){
	    Node n = this.inst2Node.get(nasmInst);
	    out.print(n + " : ( ");
	    for(NodeList q=n.succ(); q!=null; q=q.tail) {
		out.print(q.head.toString());
		out.print(" ");
	    }
	    out.println(")\t" + nasmInst);
	}
    }

    private void addEdgeSuivant(NasmInst inst) {
        Node from = inst2Node.get(inst);
        if (from.label()+1 == nasm.listeInst.size())
            return;
        NasmInst nasmInst = nasm.listeInst.get(from.label()+1);
        Node to = inst2Node.get(nasmInst);
        graph.addEdge(from, to);
    }

    private void addEdgeJump(NasmInst inst) {
        if (!label2Inst.containsKey(inst.address.toString()))
            return;
        Node from = inst2Node.get(inst);
        NasmInst nasmInst = label2Inst.get(inst.address.toString());
        Node to = inst2Node.get(nasmInst);
        graph.addEdge(from, to);
    }
    
    public Void visit(NasmAdd inst){
        addEdgeSuivant(inst);
        return null;
    }
    public Void visit(NasmCall inst){
        addEdgeJump(inst);
        return null;
    }
    public Void visit(NasmDiv inst){
        addEdgeSuivant(inst);
        return null;
    }
    public Void visit(NasmJe inst){
        addEdgeJump(inst);
        addEdgeSuivant(inst);
        return null;
    }
    public Void visit(NasmJle inst){
        addEdgeJump(inst);
        addEdgeSuivant(inst);
        return null;
    }
    public Void visit(NasmJne inst){
        addEdgeJump(inst);
        addEdgeSuivant(inst);
        return null;
    }
    public Void visit(NasmMul inst){
        addEdgeSuivant(inst);
        return null;
    }
    public Void visit(NasmOr inst){
        addEdgeSuivant(inst);
        return null;
    }
    public Void visit(NasmCmp inst){
        addEdgeSuivant(inst);
        return null;
    }
    public Void visit(NasmInst inst){
        addEdgeSuivant(inst);
        return null;
    }
    public Void visit(NasmJge inst){
        addEdgeJump(inst);
        addEdgeSuivant(inst);
        return null;
    }
    public Void visit(NasmJl inst){
        addEdgeJump(inst);
        addEdgeSuivant(inst);
        return null;
    }
    public Void visit(NasmNot inst){
        addEdgeSuivant(inst);
        return null;
    }
    public Void visit(NasmPop inst){
        addEdgeSuivant(inst);
        return null;
    }
    public Void visit(NasmRet inst){
        addEdgeSuivant(inst);
        return null;
    }
    public Void visit(NasmXor inst){
        addEdgeSuivant(inst);
        return null;
    }
    public Void visit(NasmAnd inst){
        addEdgeSuivant(inst);
        return null;
    }
    public Void visit(NasmJg inst){
        addEdgeJump(inst);
        addEdgeSuivant(inst);
        return null;
    }
    public Void visit(NasmJmp inst){
        addEdgeJump(inst);
        return null;
    }
    public Void visit(NasmMov inst){
        addEdgeSuivant(inst);
        return null;
    }
    public Void visit(NasmPush inst){
        addEdgeSuivant(inst);
        return null;
    }
    public Void visit(NasmSub inst){
        addEdgeSuivant(inst);
        return null;
    }
    public Void visit(NasmEmpty inst){
        addEdgeSuivant(inst);
        return null;
    }

    public Void visit(NasmAddress operand){return null;}
    public Void visit(NasmConstant operand){return null;}
    public Void visit(NasmLabel operand){return null;}
    public Void visit(NasmRegister operand){return null;}


}
