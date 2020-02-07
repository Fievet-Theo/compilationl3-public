package sc.analysis;

import sc.node.*;
import sa.*;

public class Sc2sa extends DepthFirstAdapter {
    private SaNode returnValue;

    public void caseAP(AP node)
    {
        SaLDec listeVar = null;
        node.getLdvo().apply(this);
        listeVar = (SaLDec) this.returnValue;

        node.getLdf().apply(this);
        SaLDec listeFonc = (SaLDec) this.returnValue;

        this.returnValue = new SaProg(listeVar, listeFonc);
    }

    public void caseAEntierDv(AEntierDv node)
    {
        String nom;
        node.getId().apply(this);
        nom = this.returnValue.toString();

        this.returnValue = new SaDecVar(nom);
    }

    public void caseATabDv(ATabDv node)
    {
        String nom;
        node.getId().apply(this);
        nom = this.returnValue.toString();

        int taille;
        node.getNb().apply(this);
        taille = Integer.parseInt(this.returnValue.toString());

        this.returnValue = new SaDecTab(nom, taille);
    }

    public void caseADf(ADf node)
    {
        String nom;
        node.getId().apply(this);
        nom = this.returnValue.toString();

        SaLDec parametres = null;
        node.getLd().apply(this);
        parametres = (SaLDec) this.returnValue;

        SaLDec variables = null;
        node.getLdvo().apply(this);
        variables = (SaLDec) this.returnValue;

        SaInst inst = null;
        node.getIbloc().apply(this);
        inst = (SaInst) this.returnValue;

        this.returnValue = new SaDecFonc(nom, parametres, variables, inst);
    }

//    public void caseADecfoncLdf(ADecfoncLdf node)
//    {
//        SaDecFonc df = null;
//        node.getDf().apply(this);
//        df = (SaDecFonc) this.returnValue;
//
//        this.returnValue = df;
//    }
//
//    public void caseADecvarLd(ADecvarLd node)
//    {
//        SaDecVar decVar = null;
//        node.getDv().apply(this);
//        decVar = (SaDecVar) this.returnValue;
//
//        this.returnValue = decVar;
//    }

    public void caseAPlusExpr3(APlusExpr3 node)
    {
        SaExp op1 =null;
        SaExp op2 =null;
        node.getExpr3().apply(this);
        op1 = (SaExp)this.returnValue;
        node.getExpr4().apply(this);
        op2 = (SaExp)this.returnValue;
        this.returnValue = new SaExpAdd(op1, op2);
    }

    public void caseAOuExpr(AOuExpr node)
    {
        SaExp op1 =null;
        SaExp op2 =null;
        node.getExpr().apply(this);
        op1 = (SaExp)this.returnValue;
        node.getExpr1().apply(this);
        op2 = (SaExp)this.returnValue;
        this.returnValue = new SaExpOr(op1, op2);
    }

    public void caseAEtExpr1(AEtExpr1 node)
    {
        SaExp op1 =null;
        SaExp op2 =null;
        node.getExpr1().apply(this);
        op1 = (SaExp)this.returnValue;
        node.getExpr2().apply(this);
        op2 = (SaExp)this.returnValue;
        this.returnValue = new SaExpAnd(op1, op2);
    }

    public void caseAEgalExpr2(AEgalExpr2 node)
    {
        SaExp op1 =null;
        SaExp op2 =null;
        node.getExpr2().apply(this);
        op1 = (SaExp)this.returnValue;
        node.getExpr3().apply(this);
        op2 = (SaExp)this.returnValue;
        this.returnValue = new SaExpEqual(op1, op2);
    }

    public void caseAInfExpr2(AInfExpr2 node)
    {
        SaExp op1 =null;
        SaExp op2 =null;
        node.getExpr2().apply(this);
        op1 = (SaExp)this.returnValue;
        node.getExpr3().apply(this);
        op2 = (SaExp)this.returnValue;
        this.returnValue = new SaExpInf(op1, op2);
    }

    public void caseAMinusExpr3(AMinusExpr3 node)
    {
        SaExp op1 =null;
        SaExp op2 =null;
        node.getExpr3().apply(this);
        op1 = (SaExp)this.returnValue;
        node.getExpr4().apply(this);
        op2 = (SaExp)this.returnValue;
        this.returnValue = new SaExpSub(op1, op2);
    }

    public void caseAMultExpr4(AMultExpr4 node)
    {
        SaExp op1 =null;
        SaExp op2 =null;
        node.getExpr4().apply(this);
        op1 = (SaExp)this.returnValue;
        node.getExpr5().apply(this);
        op2 = (SaExp)this.returnValue;
        this.returnValue = new SaExpMult(op1, op2);
    }

    public void caseADivExpr4(ADivExpr4 node)
    {
        SaExp op1 =null;
        SaExp op2 =null;
        node.getExpr4().apply(this);
        op1 = (SaExp)this.returnValue;

        node.getExpr5().apply(this);
        op2 = (SaExp)this.returnValue;
        this.returnValue = new SaExpDiv(op1, op2);
    }

    public void caseANegationExpr5(ANegationExpr5 node)
    {
        SaExp op1 =null;
        node.getExpr5().apply(this);
        op1 = (SaExp)this.returnValue;
        this.returnValue = new SaExpNot(op1);
    }

    public void caseAIbloc(AIbloc node)
    {
        SaLInst sa = null;
        node.getLi().apply(this);
        sa = (SaLInst) this.returnValue;
        this.returnValue = new SaInstBloc(sa);
    }

    public void caseAIa(AIa node)
    {
        SaExp expr = null;
        node.getExpr().apply(this);
        expr= (SaExp) this.returnValue;

        SaVar var = null;
        node.getVar().apply(this);
        var= (SaVar) this.returnValue;
        this.returnValue = new SaInstAffect(var, expr);
    }

//    public void caseAIaf(AIaf node)
//    {
//        SaAppel app = null;
//        node.getApp().apply(this);
//        app = (SaAppel) this.returnValue;
//        this.returnValue = app;
//    }

    public void caseAApp(AApp node)
    {
        String nom;
        node.getId().apply(this);
        nom = this.returnValue.toString();

        SaLExp le = null;

        node.getLe().apply(this);
        le = (SaLExp) this.returnValue;
        this.returnValue = new SaAppel(nom, le);
    }

    public void caseASialorsIsi(ASialorsIsi node)
    {
        SaExp expr = null;
        node.getExpr().apply(this);
        expr = (SaExp) this.returnValue;

        SaInst alors = null;
        node.getAlors().apply(this);
        alors = (SaInst) this.returnValue;

        this.returnValue = new SaInstSi(expr, alors, null);
    }

    public void caseASinonIsi(ASinonIsi node)
    {
        SaExp expr = null;
        node.getExpr().apply(this);
        expr = (SaExp) this.returnValue;

        SaInst alors = null;
        node.getAlors().apply(this);
        alors = (SaInst) this.returnValue;

        SaInst sinon = null;
        node.getSinon().apply(this);
        sinon = (SaInst) this.returnValue;

        this.returnValue = new SaInstSi(expr, alors, sinon);
    }

    public void caseAItq(AItq node)
    {
        SaExp expr = null;
        node.getExpr().apply(this);
        expr = (SaExp) this.returnValue;

        SaInst faire = null;
        node.getFaire().apply(this);
        faire = (SaInst) this.returnValue;

        this.returnValue = new SaInstTantQue(expr, faire);
    }

    public void caseAIr(AIr node)
    {
        SaExp expr = null;
        node.getExpr().apply(this);
        expr = (SaExp) this.returnValue;

        this.returnValue = new SaInstRetour(expr);
    }

    public void caseAIdexprVar(AIdexprVar node)
    {
        String nom;
        node.getId().apply(this);
        nom = this.returnValue.toString();

        SaExp expr = null;
        node.getExpr().apply(this);
        expr = (SaExp) this.returnValue;

        this.returnValue = new SaVarIndicee(nom, expr);
    }


    public SaNode getRoot() {
        return returnValue;
    }
}