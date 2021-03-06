/* This file was generated by SableCC (http://www.sablecc.org/). */

package sc.analysis;

import java.util.*;
import sc.node.*;

public class ReversedDepthFirstAdapter extends AnalysisAdapter
{
    public void inStart(Start node)
    {
        defaultIn(node);
    }

    public void outStart(Start node)
    {
        defaultOut(node);
    }

    public void defaultIn(@SuppressWarnings("unused") Node node)
    {
        // Do nothing
    }

    public void defaultOut(@SuppressWarnings("unused") Node node)
    {
        // Do nothing
    }

    @Override
    public void caseStart(Start node)
    {
        inStart(node);
        node.getEOF().apply(this);
        node.getPP().apply(this);
        outStart(node);
    }

    public void inAP(AP node)
    {
        defaultIn(node);
    }

    public void outAP(AP node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAP(AP node)
    {
        inAP(node);
        if(node.getLdf() != null)
        {
            node.getLdf().apply(this);
        }
        if(node.getLdvo() != null)
        {
            node.getLdvo().apply(this);
        }
        outAP(node);
    }

    public void inAEntierDv(AEntierDv node)
    {
        defaultIn(node);
    }

    public void outAEntierDv(AEntierDv node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAEntierDv(AEntierDv node)
    {
        inAEntierDv(node);
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        if(node.getEntier() != null)
        {
            node.getEntier().apply(this);
        }
        outAEntierDv(node);
    }

    public void inATabDv(ATabDv node)
    {
        defaultIn(node);
    }

    public void outATabDv(ATabDv node)
    {
        defaultOut(node);
    }

    @Override
    public void caseATabDv(ATabDv node)
    {
        inATabDv(node);
        if(node.getCf() != null)
        {
            node.getCf().apply(this);
        }
        if(node.getNb() != null)
        {
            node.getNb().apply(this);
        }
        if(node.getCo() != null)
        {
            node.getCo().apply(this);
        }
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        if(node.getEntier() != null)
        {
            node.getEntier().apply(this);
        }
        outATabDv(node);
    }

    public void inADecfoncLdf(ADecfoncLdf node)
    {
        defaultIn(node);
    }

    public void outADecfoncLdf(ADecfoncLdf node)
    {
        defaultOut(node);
    }

    @Override
    public void caseADecfoncLdf(ADecfoncLdf node)
    {
        inADecfoncLdf(node);
        if(node.getLdf() != null)
        {
            node.getLdf().apply(this);
        }
        if(node.getDf() != null)
        {
            node.getDf().apply(this);
        }
        outADecfoncLdf(node);
    }

    public void inAVideLdf(AVideLdf node)
    {
        defaultIn(node);
    }

    public void outAVideLdf(AVideLdf node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAVideLdf(AVideLdf node)
    {
        inAVideLdf(node);
        outAVideLdf(node);
    }

    public void inADf(ADf node)
    {
        defaultIn(node);
    }

    public void outADf(ADf node)
    {
        defaultOut(node);
    }

    @Override
    public void caseADf(ADf node)
    {
        inADf(node);
        if(node.getIbloc() != null)
        {
            node.getIbloc().apply(this);
        }
        if(node.getLdvo() != null)
        {
            node.getLdvo().apply(this);
        }
        if(node.getPf() != null)
        {
            node.getPf().apply(this);
        }
        if(node.getLd() != null)
        {
            node.getLd().apply(this);
        }
        if(node.getPo() != null)
        {
            node.getPo().apply(this);
        }
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        outADf(node);
    }

    public void inALisdecLdvo(ALisdecLdvo node)
    {
        defaultIn(node);
    }

    public void outALisdecLdvo(ALisdecLdvo node)
    {
        defaultOut(node);
    }

    @Override
    public void caseALisdecLdvo(ALisdecLdvo node)
    {
        inALisdecLdvo(node);
        if(node.getPv() != null)
        {
            node.getPv().apply(this);
        }
        if(node.getLd() != null)
        {
            node.getLd().apply(this);
        }
        outALisdecLdvo(node);
    }

    public void inAVideLdvo(AVideLdvo node)
    {
        defaultIn(node);
    }

    public void outAVideLdvo(AVideLdvo node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAVideLdvo(AVideLdvo node)
    {
        inAVideLdvo(node);
        outAVideLdvo(node);
    }

    public void inADecvarLd(ADecvarLd node)
    {
        defaultIn(node);
    }

    public void outADecvarLd(ADecvarLd node)
    {
        defaultOut(node);
    }

    @Override
    public void caseADecvarLd(ADecvarLd node)
    {
        inADecvarLd(node);
        if(node.getLdvb() != null)
        {
            node.getLdvb().apply(this);
        }
        if(node.getDv() != null)
        {
            node.getDv().apply(this);
        }
        outADecvarLd(node);
    }

    public void inAVideLd(AVideLd node)
    {
        defaultIn(node);
    }

    public void outAVideLd(AVideLd node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAVideLd(AVideLd node)
    {
        inAVideLd(node);
        outAVideLd(node);
    }

    public void inADecvar2Ldvb(ADecvar2Ldvb node)
    {
        defaultIn(node);
    }

    public void outADecvar2Ldvb(ADecvar2Ldvb node)
    {
        defaultOut(node);
    }

    @Override
    public void caseADecvar2Ldvb(ADecvar2Ldvb node)
    {
        inADecvar2Ldvb(node);
        if(node.getLdvb() != null)
        {
            node.getLdvb().apply(this);
        }
        if(node.getDv() != null)
        {
            node.getDv().apply(this);
        }
        if(node.getVirgule() != null)
        {
            node.getVirgule().apply(this);
        }
        outADecvar2Ldvb(node);
    }

    public void inAVideLdvb(AVideLdvb node)
    {
        defaultIn(node);
    }

    public void outAVideLdvb(AVideLdvb node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAVideLdvb(AVideLdvb node)
    {
        inAVideLdvb(node);
        outAVideLdvb(node);
    }

    public void inAApp(AApp node)
    {
        defaultIn(node);
    }

    public void outAApp(AApp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAApp(AApp node)
    {
        inAApp(node);
        if(node.getPf() != null)
        {
            node.getPf().apply(this);
        }
        if(node.getLe() != null)
        {
            node.getLe().apply(this);
        }
        if(node.getPo() != null)
        {
            node.getPo().apply(this);
        }
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        outAApp(node);
    }

    public void inAIdVar(AIdVar node)
    {
        defaultIn(node);
    }

    public void outAIdVar(AIdVar node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAIdVar(AIdVar node)
    {
        inAIdVar(node);
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        outAIdVar(node);
    }

    public void inAIdexprVar(AIdexprVar node)
    {
        defaultIn(node);
    }

    public void outAIdexprVar(AIdexprVar node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAIdexprVar(AIdexprVar node)
    {
        inAIdexprVar(node);
        if(node.getCf() != null)
        {
            node.getCf().apply(this);
        }
        if(node.getExpr() != null)
        {
            node.getExpr().apply(this);
        }
        if(node.getCo() != null)
        {
            node.getCo().apply(this);
        }
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        outAIdexprVar(node);
    }

    public void inAExprLe(AExprLe node)
    {
        defaultIn(node);
    }

    public void outAExprLe(AExprLe node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAExprLe(AExprLe node)
    {
        inAExprLe(node);
        if(node.getLe1() != null)
        {
            node.getLe1().apply(this);
        }
        if(node.getExpr() != null)
        {
            node.getExpr().apply(this);
        }
        outAExprLe(node);
    }

    public void inAVideLe(AVideLe node)
    {
        defaultIn(node);
    }

    public void outAVideLe(AVideLe node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAVideLe(AVideLe node)
    {
        inAVideLe(node);
        outAVideLe(node);
    }

    public void inAVirguleLe1(AVirguleLe1 node)
    {
        defaultIn(node);
    }

    public void outAVirguleLe1(AVirguleLe1 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAVirguleLe1(AVirguleLe1 node)
    {
        inAVirguleLe1(node);
        if(node.getExpr() != null)
        {
            node.getExpr().apply(this);
        }
        if(node.getVirgule() != null)
        {
            node.getVirgule().apply(this);
        }
        outAVirguleLe1(node);
    }

    public void inAVideLe1(AVideLe1 node)
    {
        defaultIn(node);
    }

    public void outAVideLe1(AVideLe1 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAVideLe1(AVideLe1 node)
    {
        inAVideLe1(node);
        outAVideLe1(node);
    }

    public void inALiLi(ALiLi node)
    {
        defaultIn(node);
    }

    public void outALiLi(ALiLi node)
    {
        defaultOut(node);
    }

    @Override
    public void caseALiLi(ALiLi node)
    {
        inALiLi(node);
        if(node.getLi() != null)
        {
            node.getLi().apply(this);
        }
        if(node.getI() != null)
        {
            node.getI().apply(this);
        }
        outALiLi(node);
    }

    public void inAVideLi(AVideLi node)
    {
        defaultIn(node);
    }

    public void outAVideLi(AVideLi node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAVideLi(AVideLi node)
    {
        inAVideLi(node);
        outAVideLi(node);
    }

    public void inAAffectationI(AAffectationI node)
    {
        defaultIn(node);
    }

    public void outAAffectationI(AAffectationI node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAAffectationI(AAffectationI node)
    {
        inAAffectationI(node);
        if(node.getIa() != null)
        {
            node.getIa().apply(this);
        }
        outAAffectationI(node);
    }

    public void inASiI(ASiI node)
    {
        defaultIn(node);
    }

    public void outASiI(ASiI node)
    {
        defaultOut(node);
    }

    @Override
    public void caseASiI(ASiI node)
    {
        inASiI(node);
        if(node.getIsi() != null)
        {
            node.getIsi().apply(this);
        }
        outASiI(node);
    }

    public void inATantqueI(ATantqueI node)
    {
        defaultIn(node);
    }

    public void outATantqueI(ATantqueI node)
    {
        defaultOut(node);
    }

    @Override
    public void caseATantqueI(ATantqueI node)
    {
        inATantqueI(node);
        if(node.getItq() != null)
        {
            node.getItq().apply(this);
        }
        outATantqueI(node);
    }

    public void inAAppfoncI(AAppfoncI node)
    {
        defaultIn(node);
    }

    public void outAAppfoncI(AAppfoncI node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAAppfoncI(AAppfoncI node)
    {
        inAAppfoncI(node);
        if(node.getIaf() != null)
        {
            node.getIaf().apply(this);
        }
        outAAppfoncI(node);
    }

    public void inARetourI(ARetourI node)
    {
        defaultIn(node);
    }

    public void outARetourI(ARetourI node)
    {
        defaultOut(node);
    }

    @Override
    public void caseARetourI(ARetourI node)
    {
        inARetourI(node);
        if(node.getIr() != null)
        {
            node.getIr().apply(this);
        }
        outARetourI(node);
    }

    public void inABlocI(ABlocI node)
    {
        defaultIn(node);
    }

    public void outABlocI(ABlocI node)
    {
        defaultOut(node);
    }

    @Override
    public void caseABlocI(ABlocI node)
    {
        inABlocI(node);
        if(node.getIbloc() != null)
        {
            node.getIbloc().apply(this);
        }
        outABlocI(node);
    }

    public void inAFoncecrireI(AFoncecrireI node)
    {
        defaultIn(node);
    }

    public void outAFoncecrireI(AFoncecrireI node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAFoncecrireI(AFoncecrireI node)
    {
        inAFoncecrireI(node);
        if(node.getIecrire() != null)
        {
            node.getIecrire().apply(this);
        }
        outAFoncecrireI(node);
    }

    public void inAIa(AIa node)
    {
        defaultIn(node);
    }

    public void outAIa(AIa node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAIa(AIa node)
    {
        inAIa(node);
        if(node.getPv() != null)
        {
            node.getPv().apply(this);
        }
        if(node.getExpr() != null)
        {
            node.getExpr().apply(this);
        }
        if(node.getEgal() != null)
        {
            node.getEgal().apply(this);
        }
        if(node.getVar() != null)
        {
            node.getVar().apply(this);
        }
        outAIa(node);
    }

    public void inAIaf(AIaf node)
    {
        defaultIn(node);
    }

    public void outAIaf(AIaf node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAIaf(AIaf node)
    {
        inAIaf(node);
        if(node.getPv() != null)
        {
            node.getPv().apply(this);
        }
        if(node.getApp() != null)
        {
            node.getApp().apply(this);
        }
        outAIaf(node);
    }

    public void inAIbloc(AIbloc node)
    {
        defaultIn(node);
    }

    public void outAIbloc(AIbloc node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAIbloc(AIbloc node)
    {
        inAIbloc(node);
        if(node.getAf() != null)
        {
            node.getAf().apply(this);
        }
        if(node.getLi() != null)
        {
            node.getLi().apply(this);
        }
        if(node.getAo() != null)
        {
            node.getAo().apply(this);
        }
        outAIbloc(node);
    }

    public void inASialorsIsi(ASialorsIsi node)
    {
        defaultIn(node);
    }

    public void outASialorsIsi(ASialorsIsi node)
    {
        defaultOut(node);
    }

    @Override
    public void caseASialorsIsi(ASialorsIsi node)
    {
        inASialorsIsi(node);
        if(node.getIbloc() != null)
        {
            node.getIbloc().apply(this);
        }
        if(node.getAlors() != null)
        {
            node.getAlors().apply(this);
        }
        if(node.getExpr() != null)
        {
            node.getExpr().apply(this);
        }
        if(node.getSi() != null)
        {
            node.getSi().apply(this);
        }
        outASialorsIsi(node);
    }

    public void inASinonIsi(ASinonIsi node)
    {
        defaultIn(node);
    }

    public void outASinonIsi(ASinonIsi node)
    {
        defaultOut(node);
    }

    @Override
    public void caseASinonIsi(ASinonIsi node)
    {
        inASinonIsi(node);
        if(node.getL2() != null)
        {
            node.getL2().apply(this);
        }
        if(node.getSinon() != null)
        {
            node.getSinon().apply(this);
        }
        if(node.getL1() != null)
        {
            node.getL1().apply(this);
        }
        if(node.getAlors() != null)
        {
            node.getAlors().apply(this);
        }
        if(node.getExpr() != null)
        {
            node.getExpr().apply(this);
        }
        if(node.getSi() != null)
        {
            node.getSi().apply(this);
        }
        outASinonIsi(node);
    }

    public void inAItq(AItq node)
    {
        defaultIn(node);
    }

    public void outAItq(AItq node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAItq(AItq node)
    {
        inAItq(node);
        if(node.getIbloc() != null)
        {
            node.getIbloc().apply(this);
        }
        if(node.getFaire() != null)
        {
            node.getFaire().apply(this);
        }
        if(node.getExpr() != null)
        {
            node.getExpr().apply(this);
        }
        if(node.getTantque() != null)
        {
            node.getTantque().apply(this);
        }
        outAItq(node);
    }

    public void inAIr(AIr node)
    {
        defaultIn(node);
    }

    public void outAIr(AIr node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAIr(AIr node)
    {
        inAIr(node);
        if(node.getPv() != null)
        {
            node.getPv().apply(this);
        }
        if(node.getExpr() != null)
        {
            node.getExpr().apply(this);
        }
        if(node.getRetour() != null)
        {
            node.getRetour().apply(this);
        }
        outAIr(node);
    }

    public void inAIecrire(AIecrire node)
    {
        defaultIn(node);
    }

    public void outAIecrire(AIecrire node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAIecrire(AIecrire node)
    {
        inAIecrire(node);
        if(node.getPv() != null)
        {
            node.getPv().apply(this);
        }
        if(node.getPf() != null)
        {
            node.getPf().apply(this);
        }
        if(node.getExpr() != null)
        {
            node.getExpr().apply(this);
        }
        if(node.getPo() != null)
        {
            node.getPo().apply(this);
        }
        if(node.getEcrire() != null)
        {
            node.getEcrire().apply(this);
        }
        outAIecrire(node);
    }

    public void inAOuExpr(AOuExpr node)
    {
        defaultIn(node);
    }

    public void outAOuExpr(AOuExpr node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAOuExpr(AOuExpr node)
    {
        inAOuExpr(node);
        if(node.getExpr1() != null)
        {
            node.getExpr1().apply(this);
        }
        if(node.getOu() != null)
        {
            node.getOu().apply(this);
        }
        if(node.getExpr() != null)
        {
            node.getExpr().apply(this);
        }
        outAOuExpr(node);
    }

    public void inAExpr1Expr(AExpr1Expr node)
    {
        defaultIn(node);
    }

    public void outAExpr1Expr(AExpr1Expr node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAExpr1Expr(AExpr1Expr node)
    {
        inAExpr1Expr(node);
        if(node.getExpr1() != null)
        {
            node.getExpr1().apply(this);
        }
        outAExpr1Expr(node);
    }

    public void inAEtExpr1(AEtExpr1 node)
    {
        defaultIn(node);
    }

    public void outAEtExpr1(AEtExpr1 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAEtExpr1(AEtExpr1 node)
    {
        inAEtExpr1(node);
        if(node.getExpr2() != null)
        {
            node.getExpr2().apply(this);
        }
        if(node.getEt() != null)
        {
            node.getEt().apply(this);
        }
        if(node.getExpr1() != null)
        {
            node.getExpr1().apply(this);
        }
        outAEtExpr1(node);
    }

    public void inAExpr2Expr1(AExpr2Expr1 node)
    {
        defaultIn(node);
    }

    public void outAExpr2Expr1(AExpr2Expr1 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAExpr2Expr1(AExpr2Expr1 node)
    {
        inAExpr2Expr1(node);
        if(node.getExpr2() != null)
        {
            node.getExpr2().apply(this);
        }
        outAExpr2Expr1(node);
    }

    public void inAEgalExpr2(AEgalExpr2 node)
    {
        defaultIn(node);
    }

    public void outAEgalExpr2(AEgalExpr2 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAEgalExpr2(AEgalExpr2 node)
    {
        inAEgalExpr2(node);
        if(node.getExpr3() != null)
        {
            node.getExpr3().apply(this);
        }
        if(node.getEgal() != null)
        {
            node.getEgal().apply(this);
        }
        if(node.getExpr2() != null)
        {
            node.getExpr2().apply(this);
        }
        outAEgalExpr2(node);
    }

    public void inAInfExpr2(AInfExpr2 node)
    {
        defaultIn(node);
    }

    public void outAInfExpr2(AInfExpr2 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAInfExpr2(AInfExpr2 node)
    {
        inAInfExpr2(node);
        if(node.getExpr3() != null)
        {
            node.getExpr3().apply(this);
        }
        if(node.getInf() != null)
        {
            node.getInf().apply(this);
        }
        if(node.getExpr2() != null)
        {
            node.getExpr2().apply(this);
        }
        outAInfExpr2(node);
    }

    public void inAExpr3Expr2(AExpr3Expr2 node)
    {
        defaultIn(node);
    }

    public void outAExpr3Expr2(AExpr3Expr2 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAExpr3Expr2(AExpr3Expr2 node)
    {
        inAExpr3Expr2(node);
        if(node.getExpr3() != null)
        {
            node.getExpr3().apply(this);
        }
        outAExpr3Expr2(node);
    }

    public void inAPlusExpr3(APlusExpr3 node)
    {
        defaultIn(node);
    }

    public void outAPlusExpr3(APlusExpr3 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAPlusExpr3(APlusExpr3 node)
    {
        inAPlusExpr3(node);
        if(node.getExpr4() != null)
        {
            node.getExpr4().apply(this);
        }
        if(node.getPlus() != null)
        {
            node.getPlus().apply(this);
        }
        if(node.getExpr3() != null)
        {
            node.getExpr3().apply(this);
        }
        outAPlusExpr3(node);
    }

    public void inAMinusExpr3(AMinusExpr3 node)
    {
        defaultIn(node);
    }

    public void outAMinusExpr3(AMinusExpr3 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAMinusExpr3(AMinusExpr3 node)
    {
        inAMinusExpr3(node);
        if(node.getExpr4() != null)
        {
            node.getExpr4().apply(this);
        }
        if(node.getMinus() != null)
        {
            node.getMinus().apply(this);
        }
        if(node.getExpr3() != null)
        {
            node.getExpr3().apply(this);
        }
        outAMinusExpr3(node);
    }

    public void inAExpr4Expr3(AExpr4Expr3 node)
    {
        defaultIn(node);
    }

    public void outAExpr4Expr3(AExpr4Expr3 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAExpr4Expr3(AExpr4Expr3 node)
    {
        inAExpr4Expr3(node);
        if(node.getExpr4() != null)
        {
            node.getExpr4().apply(this);
        }
        outAExpr4Expr3(node);
    }

    public void inAMultExpr4(AMultExpr4 node)
    {
        defaultIn(node);
    }

    public void outAMultExpr4(AMultExpr4 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAMultExpr4(AMultExpr4 node)
    {
        inAMultExpr4(node);
        if(node.getExpr5() != null)
        {
            node.getExpr5().apply(this);
        }
        if(node.getMult() != null)
        {
            node.getMult().apply(this);
        }
        if(node.getExpr4() != null)
        {
            node.getExpr4().apply(this);
        }
        outAMultExpr4(node);
    }

    public void inADivExpr4(ADivExpr4 node)
    {
        defaultIn(node);
    }

    public void outADivExpr4(ADivExpr4 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseADivExpr4(ADivExpr4 node)
    {
        inADivExpr4(node);
        if(node.getExpr5() != null)
        {
            node.getExpr5().apply(this);
        }
        if(node.getDiv() != null)
        {
            node.getDiv().apply(this);
        }
        if(node.getExpr4() != null)
        {
            node.getExpr4().apply(this);
        }
        outADivExpr4(node);
    }

    public void inAExpr5Expr4(AExpr5Expr4 node)
    {
        defaultIn(node);
    }

    public void outAExpr5Expr4(AExpr5Expr4 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAExpr5Expr4(AExpr5Expr4 node)
    {
        inAExpr5Expr4(node);
        if(node.getExpr5() != null)
        {
            node.getExpr5().apply(this);
        }
        outAExpr5Expr4(node);
    }

    public void inANegationExpr5(ANegationExpr5 node)
    {
        defaultIn(node);
    }

    public void outANegationExpr5(ANegationExpr5 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseANegationExpr5(ANegationExpr5 node)
    {
        inANegationExpr5(node);
        if(node.getExpr5() != null)
        {
            node.getExpr5().apply(this);
        }
        if(node.getNegation() != null)
        {
            node.getNegation().apply(this);
        }
        outANegationExpr5(node);
    }

    public void inAExpr6Expr5(AExpr6Expr5 node)
    {
        defaultIn(node);
    }

    public void outAExpr6Expr5(AExpr6Expr5 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAExpr6Expr5(AExpr6Expr5 node)
    {
        inAExpr6Expr5(node);
        if(node.getExpr6() != null)
        {
            node.getExpr6().apply(this);
        }
        outAExpr6Expr5(node);
    }

    public void inAExprExpr6(AExprExpr6 node)
    {
        defaultIn(node);
    }

    public void outAExprExpr6(AExprExpr6 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAExprExpr6(AExprExpr6 node)
    {
        inAExprExpr6(node);
        if(node.getPf() != null)
        {
            node.getPf().apply(this);
        }
        if(node.getExpr() != null)
        {
            node.getExpr().apply(this);
        }
        if(node.getPo() != null)
        {
            node.getPo().apply(this);
        }
        outAExprExpr6(node);
    }

    public void inANbExpr6(ANbExpr6 node)
    {
        defaultIn(node);
    }

    public void outANbExpr6(ANbExpr6 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseANbExpr6(ANbExpr6 node)
    {
        inANbExpr6(node);
        if(node.getNb() != null)
        {
            node.getNb().apply(this);
        }
        outANbExpr6(node);
    }

    public void inAAppExpr6(AAppExpr6 node)
    {
        defaultIn(node);
    }

    public void outAAppExpr6(AAppExpr6 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAAppExpr6(AAppExpr6 node)
    {
        inAAppExpr6(node);
        if(node.getApp() != null)
        {
            node.getApp().apply(this);
        }
        outAAppExpr6(node);
    }

    public void inAVarExpr6(AVarExpr6 node)
    {
        defaultIn(node);
    }

    public void outAVarExpr6(AVarExpr6 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAVarExpr6(AVarExpr6 node)
    {
        inAVarExpr6(node);
        if(node.getVar() != null)
        {
            node.getVar().apply(this);
        }
        outAVarExpr6(node);
    }

    public void inALireExpr6(ALireExpr6 node)
    {
        defaultIn(node);
    }

    public void outALireExpr6(ALireExpr6 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseALireExpr6(ALireExpr6 node)
    {
        inALireExpr6(node);
        if(node.getLire() != null)
        {
            node.getLire().apply(this);
        }
        outALireExpr6(node);
    }
}
