/* This file was generated by SableCC (http://www.sablecc.org/). */

package sc.node;

import sc.analysis.*;

@SuppressWarnings("nls")
public final class AExpr1Expr extends PExpr
{
    private PExpr1 _expr1_;

    public AExpr1Expr()
    {
        // Constructor
    }

    public AExpr1Expr(
        @SuppressWarnings("hiding") PExpr1 _expr1_)
    {
        // Constructor
        setExpr1(_expr1_);

    }

    @Override
    public Object clone()
    {
        return new AExpr1Expr(
            cloneNode(this._expr1_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAExpr1Expr(this);
    }

    public PExpr1 getExpr1()
    {
        return this._expr1_;
    }

    public void setExpr1(PExpr1 node)
    {
        if(this._expr1_ != null)
        {
            this._expr1_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._expr1_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._expr1_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._expr1_ == child)
        {
            this._expr1_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._expr1_ == oldChild)
        {
            setExpr1((PExpr1) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
