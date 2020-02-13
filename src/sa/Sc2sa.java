package sa;

import sc.analysis.DepthFirstAdapter;
import sc.node.*;

import javax.swing.*;

public class Sc2sa extends DepthFirstAdapter {
    private SaNode returnValue;

    @Override
    public void caseAP(AP node)
    {
        SaLDec listeVar = null;
        node.getLdvo().apply(this);
        listeVar = (SaLDec) this.returnValue;

        node.getLdf().apply(this);
        SaLDec listeFonc = (SaLDec) this.returnValue;

        this.returnValue = new SaProg(listeVar, listeFonc);
    }

    @Override
    public void caseAEntierDv(AEntierDv node)
    {
        String nom;
        nom = node.getId().getText();

        this.returnValue = new SaDecVar(nom);
    }

    @Override
    public void caseATabDv(ATabDv node)
    {
        String nom;
        nom = node.getId().getText();

        int taille;
        taille = Integer.parseInt(node.getNb().getText());

        this.returnValue = new SaDecTab(nom, taille);
    }

    @Override
    public void caseADf(ADf node)
    {
        String nom;
        nom = node.getId().getText();

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

    @Override
    public void caseADecfoncLdf(ADecfoncLdf node)
    {
        SaDecFonc df = null;
        node.getDf().apply(this);
        df = (SaDecFonc) this.returnValue;

        SaLDec lDec = null;
        node.getLdf().apply(this);
        lDec = (SaLDec) this.returnValue;

        this.returnValue = new SaLDec(df, lDec);
    }

    @Override
    public void caseAVideLdf(AVideLdf node)
    {
        this.returnValue = null;
    }

    @Override
    public void caseALisdecLdvo(ALisdecLdvo node)
    {
        SaLDec listdec = null;
        node.getLd().apply(this);
        listdec = (SaLDec) this.returnValue;

        this.returnValue = new SaLDec(listdec.getTete(),listdec.getQueue());
    }

    @Override
    public void caseADecvarLd(ADecvarLd node)
    {
        SaDecVar decVar = null;
        node.getDv().apply(this);
        decVar = (SaDecVar) this.returnValue;

        SaLDec listdec = null;
        node.getLdvb().apply(this);
        listdec = (SaLDec) this.returnValue;

        this.returnValue = new SaLDec(decVar, listdec);
    }

    @Override
    public void caseAVideLdvo(AVideLdvo node)
    {
        this.returnValue = null;
    }

    @Override
    public void caseAVideLd(AVideLd node)
    {
        this.returnValue = null;
    }

    @Override
    public void caseADecvar2Ldvb(ADecvar2Ldvb node)
    {
        SaDecVar decVar = null;
        node.getDv().apply(this);
        decVar = (SaDecVar) this.returnValue;

        SaLDec listdec = null;
        node.getLdvb().apply(this);
        listdec = (SaLDec) this.returnValue;

        this.returnValue = new SaLDec(decVar, listdec);
    }

    @Override
    public void caseAVideLdvb(AVideLdvb node)
    {
        this.returnValue = null;
    }

    @Override
    public void caseAIdVar(AIdVar node)
    {
        String id = null;
        id = node.getId().getText();

        this.returnValue = new SaVarSimple(id);
    }

    @Override
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

    @Override
    public void caseAExprExpr6(AExprExpr6 node)
    {
        SaExp expr = null;
        node.getExpr().apply(this);
        expr = (SaExp) this.returnValue;

        this.returnValue = expr;
    }

    @Override
    public void caseANbExpr6(ANbExpr6 node)
    {
        Integer number = null;
        number = Integer.parseInt(node.getNb().getText());

        this.returnValue = new SaExpInt(number);
    }

    @Override
    public void caseAAppExpr6(AAppExpr6 node)
    {
        SaAppel appel = null;
        node.getApp().apply(this);
        appel = (SaAppel) this.returnValue;

        this.returnValue = new SaExpAppel(appel);
    }

    @Override
    public void caseAVarExpr6(AVarExpr6 node)
    {
        SaVar var = null;
        node.getVar().apply(this);
        var = (SaVar) this.returnValue;

        this.returnValue = new SaExpVar(var);
    }

    @Override
    public void caseALireExpr6(ALireExpr6 node)
    {
        this.returnValue = new SaExpLire();
    }

    @Override
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

    @Override
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

    @Override
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

    @Override
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

    @Override
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

    @Override
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

    @Override
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

    @Override
    public void caseANegationExpr5(ANegationExpr5 node)
    {
        SaExp op1 =null;
        node.getExpr5().apply(this);
        op1 = (SaExp)this.returnValue;
        this.returnValue = new SaExpNot(op1);
    }

    @Override
    public void caseAExpr1Expr(AExpr1Expr node)
    {
        SaExp expr = null;
        node.getExpr1().apply(this);
        expr = (SaExp) this.returnValue;

        this.returnValue = expr;
    }

    @Override
    public void caseAExpr2Expr1(AExpr2Expr1 node)
    {
        SaExp expr = null;
        node.getExpr2().apply(this);
        expr = (SaExp) this.returnValue;

        this.returnValue = expr;
    }

    @Override
    public void caseAExpr3Expr2(AExpr3Expr2 node)
    {
        SaExp expr = null;
        node.getExpr3().apply(this);
        expr = (SaExp) this.returnValue;

        this.returnValue = expr;
    }

    @Override
    public void caseAExpr4Expr3(AExpr4Expr3 node)
    {
        SaExp expr = null;
        node.getExpr4().apply(this);
        expr = (SaExp) this.returnValue;

        this.returnValue = expr;
    }

    @Override
    public void caseAExpr5Expr4(AExpr5Expr4 node)
    {
        SaExp expr = null;
        node.getExpr5().apply(this);
        expr = (SaExp) this.returnValue;

        this.returnValue = expr;
    }

    @Override
    public void caseAExpr6Expr5(AExpr6Expr5 node)
    {
        SaExp expr = null;
        node.getExpr6().apply(this);
        expr = (SaExp) this.returnValue;

        this.returnValue = expr;
    }

    @Override
    public void caseAIbloc(AIbloc node)
    {
        SaLInst sa = null;
        node.getLi().apply(this);
        sa = (SaLInst) this.returnValue;
        this.returnValue = new SaInstBloc(sa);
    }

    @Override
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

    @Override
    public void caseAApp(AApp node)
    {
        String nom;
        nom = node.getId().getText();

        SaLExp le = null;

        node.getLe().apply(this);
        le = (SaLExp) this.returnValue;
        this.returnValue = new SaAppel(nom, le);
    }

    @Override
    public void caseALiLi(ALiLi node)
    {
        SaInst inst = null;
        node.getI().apply(this);
        inst = (SaInst) this.returnValue;

        SaLInst lInst = null;
        node.getLi().apply(this);
        lInst = (SaLInst) this.returnValue;

        this.returnValue = new SaLInst(inst, lInst);
    }

    @Override
    public void caseAVideLi(AVideLi node)
    {
        this.returnValue = null;
    }

    @Override
    public void caseAExprLe(AExprLe node)
    {
        SaExp expr = null;
        node .getExpr().apply(this);
        expr = (SaExp) this.returnValue;

        SaLExp le1 = null;
        node.getLe1().apply(this);
        le1 = (SaLExp) this.returnValue;

        this.returnValue = new SaLExp(expr, le1);
    }

    @Override
    public void caseAVirguleLe1(AVirguleLe1 node)
    {
        SaExp expr = null;
        node.getExpr().apply(this);
        expr = (SaExp) this.returnValue;

        this.returnValue = new SaLExp(expr, null);
    }

    @Override
    public void caseAIecrire(AIecrire node)
    {
        SaExp expr = null;
        node.getExpr().apply(this);
        expr = (SaExp) this.returnValue;

        this.returnValue = new SaInstEcriture(expr);
    }

    @Override
    public void caseASialorsIsi(ASialorsIsi node)
    {
        SaExp expr = null;
        node.getExpr().apply(this);
        expr = (SaExp) this.returnValue;

        SaInst inst = null;
        node.getIbloc().apply(this);
        inst = (SaInst) this.returnValue;

        this.returnValue = new SaInstSi(expr, inst, null);
    }

    @Override
    public void caseASinonIsi(ASinonIsi node)
    {
        SaExp expr = null;
        node.getExpr().apply(this);
        expr = (SaExp) this.returnValue;

        SaInst inst1 = null;
        node.getL1().apply(this);
        inst1 = (SaInst) this.returnValue;

        SaInst inst2 = null;
        node.getL2().apply(this);
        inst2 = (SaInst) this.returnValue;

        this.returnValue = new SaInstSi(expr, inst1, inst2);
    }

    @Override
    public void caseAItq(AItq node)
    {
        SaExp expr = null;
        node.getExpr().apply(this);
        expr = (SaExp) this.returnValue;

        SaInst inst = null;
        node.getIbloc().apply(this);
        inst = (SaInst) this.returnValue;

        this.returnValue = new SaInstTantQue(expr, inst);
    }

    @Override
    public void caseAIr(AIr node)
    {
        SaExp expr = null;
        node.getExpr().apply(this);
        expr = (SaExp) this.returnValue;

        this.returnValue = new SaInstRetour(expr);
    }

    @Override
    public void caseAIdexprVar(AIdexprVar node)
    {
        String nom;
        nom = node.getId().getText();

        SaExp expr = null;
        node.getExpr().apply(this);
        expr = (SaExp) this.returnValue;

        this.returnValue = new SaVarIndicee(nom, expr);
    }

    public SaNode getRoot() {
        return returnValue;
    }
}