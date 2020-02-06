/* This file was generated by SableCC (http://www.sablecc.org/). */

package src.node;

import src.analysis.*;

@SuppressWarnings("nls")
public final class AExpr3Expr2 extends PExpr2
{
    private PExpr3 _expr3_;

    public AExpr3Expr2()
    {
        // Constructor
    }

    public AExpr3Expr2(
        @SuppressWarnings("hiding") PExpr3 _expr3_)
    {
        // Constructor
        setExpr3(_expr3_);

    }

    @Override
    public Object clone()
    {
        return new AExpr3Expr2(
            cloneNode(this._expr3_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAExpr3Expr2(this);
    }

    public PExpr3 getExpr3()
    {
        return this._expr3_;
    }

    public void setExpr3(PExpr3 node)
    {
        if(this._expr3_ != null)
        {
            this._expr3_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._expr3_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._expr3_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._expr3_ == child)
        {
            this._expr3_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._expr3_ == oldChild)
        {
            setExpr3((PExpr3) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
