package sc.analysis;


public class Sc2sa extends DepthfirsAdapter {
    private SaNode returnValue;

    public void caseAP(AP node)
    {

    }

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



}