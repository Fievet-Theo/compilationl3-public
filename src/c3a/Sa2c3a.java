package c3a;

import sa.*;
import ts.Ts;
import ts.TsItemFct;
import ts.TsItemVar;

public class Sa2c3a extends SaDepthFirstVisitor<C3aOperand> {
    private C3a c3a;
    private Ts table;
    private Ts tableLocale;

    public Sa2c3a(SaNode root) {
        c3a = new C3a();
        root.accept(this);
    }

    public C3aOperand visit(SaExpInt node){
        C3aConstant constant = new C3aConstant(node.getVal());
        C3aInstAffect affect = new C3aInstAffect(constant, constant, "constante");
        c3a.ajouteInst(affect);
        return null;
    }

    public C3aOperand visit(SaVarSimple node){
        TsItemVar var = table.getVar(node.getNom());

        C3aVar varSimple = new C3aVar(var);
        return null;
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

    public C3aOperand visit(SaDecFonc node) {
        TsItemFct fct = table.getFct(node.getNom());
        C3aInstFBegin inst = new C3aInstFBegin(fct, "fonction");
        c3a.ajouteInst(inst);
        tableLocale = table.getTableLocale(node.getNom());
        node.getCorps().accept(this);
        C3aInstFEnd end = new C3aInstFEnd("fonction end");
        c3a.ajouteInst(end);
        return null;
    }
}
