package c3a;

import sa.*;
import ts.Ts;
import ts.TsItemFct;
import ts.TsItemVar;

public class Sa2c3a extends SaDepthFirstVisitor<C3aOperand> {
    private C3a c3a;
    private Ts table;
    private Ts tableLocale;

    public Sa2c3a(SaNode root, Ts table) {
        this.table = table;
        c3a = new C3a();
        root.accept(this);
    }

    public C3a getC3a() {
        return c3a;
    }

    public C3aOperand visit(SaExpInt node){
        return new C3aConstant(node.getVal());
    }

    public C3aOperand visit(SaExpVar node) {
        return node.getVar().accept(this);
    }

    public C3aOperand visit(SaVarSimple node){
        TsItemVar var = getVar(node.getNom());
        return new C3aVar(var, null);
    }

    public C3aOperand visit(SaVarIndicee node){
        TsItemVar var = getVar(node.getNom());
        return new C3aVar(var, node.getIndice().accept(this));
    }


    public TsItemVar getVar(String name){
        if (this.table.getVar(name) != null)
            return this.table.getVar(name);
        else
            return this.tableLocale.getVar(name);
    }

    public C3aOperand visit(SaProg node){
        node.getFonctions().accept(this);
        return null;
    }

    public C3aOperand visit(SaDecTab node){
        return null;
    }

    public C3aOperand visit(SaDecVar node) {
        return null;
    }

    public C3aOperand visit(SaDecFonc node) {
        TsItemFct fct = table.getFct(node.getNom());
        C3aInstFBegin inst = new C3aInstFBegin(fct, "entree fonction");
        c3a.ajouteInst(inst);
        tableLocale = table.getTableLocale(node.getNom());
        node.getCorps().accept(this);
        C3aInstFEnd end = new C3aInstFEnd("fonction end");
        c3a.ajouteInst(end);
        return null;
    }

    public C3aOperand visit(SaExpAdd node) {
        C3aOperand result = c3a.newTemp();
        C3aInstAdd add = new C3aInstAdd(node.getOp1().accept(this), node.getOp2().accept(this), result, "");
        c3a.ajouteInst(add);
        return result;
    }

    public C3aOperand visit(SaExpDiv node) {
        C3aOperand result = c3a.newTemp();
        C3aInstDiv div = new C3aInstDiv(node.getOp1().accept(this), node.getOp2().accept(this), result, "");
        c3a.ajouteInst(div);
        return result;
    }

    public C3aOperand visit(SaExpMult node) {
        C3aOperand result = c3a.newTemp();
        C3aInstMult mult = new C3aInstMult(node.getOp1().accept(this), node.getOp2().accept(this), result, "");
        c3a.ajouteInst(mult);
        return result;
    }

    public C3aOperand visit(SaExpSub node) {
        C3aOperand result = c3a.newTemp();
        C3aInstSub sub = new C3aInstSub(node.getOp1().accept(this), node.getOp2().accept(this), result, "");
        c3a.ajouteInst(sub);
        return result;
    }

    public C3aOperand visit(SaExpEqual node) {
        C3aTemp temp = c3a.newTemp();
        C3aInstAffect affect = new C3aInstAffect(c3a.True, temp, "");
        c3a.ajouteInst(affect);

        C3aLabel label = c3a.newAutoLabel();
        C3aInstJumpIfEqual jumpIE = new C3aInstJumpIfEqual(node.getOp1().accept(this), node.getOp2().accept(this), label, "");
        c3a.ajouteInst(jumpIE);

        C3aInstAffect affect2 = new C3aInstAffect(c3a.False, temp, "");
        c3a.ajouteInst(affect2);

        c3a.addLabelToNextInst(label);
        return temp;
    }

    public C3aOperand visit(SaExpAnd node) {
        C3aLabel label = c3a.newAutoLabel();
        C3aInstJumpIfEqual jumpIE = new C3aInstJumpIfEqual(node.getOp1().accept(this), c3a.False, label, "");
        C3aInstJumpIfEqual jumpIE2 = new C3aInstJumpIfEqual(node.getOp2().accept(this), c3a.False, label, "");
        c3a.ajouteInst(jumpIE);
        c3a.ajouteInst(jumpIE2);

        C3aTemp temp = c3a.newTemp();
        C3aInstAffect affect = new C3aInstAffect(c3a.True, temp, "");
        c3a.ajouteInst(affect);

        C3aLabel label2 = c3a.newAutoLabel();
        C3aInstJump jump = new C3aInstJump(label2, "");
        c3a.ajouteInst(jump);
        c3a.addLabelToNextInst(label);

        C3aInstAffect affect2 = new C3aInstAffect(c3a.False, temp, "");
        c3a.ajouteInst(affect2);
        c3a.addLabelToNextInst(label2);

        return temp;
    }

    public C3aOperand visit(SaExpOr node) {
        C3aLabel label = c3a.newAutoLabel();
        C3aInstJumpIfNotEqual jumpINE = new C3aInstJumpIfNotEqual(node.getOp1().accept(this), c3a.False, label, "");
        C3aInstJumpIfNotEqual jumpINE2 = new C3aInstJumpIfNotEqual(node.getOp2().accept(this), c3a.False, label, "");
        c3a.ajouteInst(jumpINE);
        c3a.ajouteInst(jumpINE2);

        C3aTemp temp = c3a.newTemp();
        C3aInstAffect affect = new C3aInstAffect(c3a.False, temp, "");
        c3a.ajouteInst(affect);

        C3aLabel label2 = c3a.newAutoLabel();
        C3aInstJump jump = new C3aInstJump(label2, "");
        c3a.ajouteInst(jump);
        c3a.addLabelToNextInst(label);

        C3aInstAffect affect2 = new C3aInstAffect(c3a.True, temp, "");
        c3a.ajouteInst(affect2);
        c3a.addLabelToNextInst(label2);

        return temp;
    }

    public C3aOperand visit(SaExpInf node) {
        C3aTemp temp = c3a.newTemp();
        C3aInstAffect affect = new C3aInstAffect(c3a.True, temp, "");
        c3a.ajouteInst(affect);

        C3aLabel label = c3a.newAutoLabel();
        C3aInstJumpIfLess jumpIL = new C3aInstJumpIfLess(node.getOp1().accept(this), node.getOp2().accept(this), label, "");
        c3a.ajouteInst(jumpIL);

        C3aInstAffect affect2 = new C3aInstAffect(c3a.False, temp, "");
        c3a.ajouteInst(affect2);
        c3a.addLabelToNextInst(label);

        return temp;
    }

    public C3aOperand visit(SaExpNot node) {
        node.getOp1().accept(this);
        return null;
    }


    public C3aOperand visit(SaInstEcriture node) {
        C3aInstWrite write = new C3aInstWrite(node.getArg().accept(this), "");
        c3a.ajouteInst(write);
        return null;
    }

    public C3aOperand visit(SaExpLire node) {
        C3aTemp temp = c3a.newTemp();
        C3aInstRead read = new C3aInstRead(temp, "");
        c3a.ajouteInst(read);
        return temp;
    }

    public C3aOperand visit(SaInstAffect node) {
        C3aInstAffect affect = new C3aInstAffect(node.getRhs().accept(this), node.getLhs().accept(this), "");
        c3a.ajouteInst(affect);
        return null;
    }

    public C3aOperand visit(SaAppel node) {
        if (node.getArguments() != null) {
            SaLExp arg = node.getArguments();
            for (int i = 0; i < node.getArguments().length(); i++) {
                C3aInstParam param = new C3aInstParam(arg.getTete().accept(this), "");
                c3a.ajouteInst(param);
                arg = node.getArguments().getQueue();
            }
        }

        C3aFunction function = new C3aFunction(table.getFct(node.getNom()));
        C3aOperand temp = c3a.newTemp();
        C3aInstCall call = new C3aInstCall(function, temp, "");
        c3a.ajouteInst(call);
        return temp;
    }

    public C3aOperand visit(SaInstRetour node) {
        C3aInstReturn retour = new C3aInstReturn(node.getVal().accept(this), "");
        c3a.ajouteInst(retour);
        return null;
    }

    public C3aOperand visit(SaExpAppel node) {
        return node.getVal().accept(this);
    }

    public C3aOperand visit(SaInstSi node) {
        C3aLabel label = c3a.newAutoLabel();
        C3aInstJumpIfEqual jumpIE = new C3aInstJumpIfEqual(node.getTest().accept(this), c3a.False, label, "");
        c3a.ajouteInst(jumpIE);

        node.getAlors().accept(this);

        if (node.getSinon() != null) {
            C3aLabel label2 = c3a.newAutoLabel();
            C3aInstJump jump = new C3aInstJump(label2, "");
            c3a.ajouteInst(jump);
            c3a.addLabelToNextInst(label);
            node.getSinon().accept(this);
            c3a.addLabelToNextInst(label2);
        } else {
            c3a.addLabelToNextInst(label);
        }
        return null;
    }

    public C3aOperand visit(SaInstTantQue node) {
        C3aLabel label = c3a.newAutoLabel();
        c3a.addLabelToNextInst(label);

        C3aLabel label2 = c3a.newAutoLabel();
        C3aInstJumpIfEqual jumpIE = new C3aInstJumpIfEqual(node.getTest().accept(this), c3a.False, label2, "");
        c3a.ajouteInst(jumpIE);

        node.getFaire().accept(this);

        C3aInstJump jump = new C3aInstJump(label, "");
        c3a.ajouteInst(jump);
        c3a.addLabelToNextInst(label2);

        return null;
    }
}
