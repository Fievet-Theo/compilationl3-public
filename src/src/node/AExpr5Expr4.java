/* This file was generated by SableCC (http://www.sablecc.org/). */

package src.node;

import src.analysis.*;

@SuppressWarnings("nls")
public final class AExpr5Expr4 extends PExpr4
{
    private PExpr5 _expr5_;

    public AExpr5Expr4()
    {
        // Constructor
    }

    public AExpr5Expr4(
        @SuppressWarnings("hiding") PExpr5 _expr5_)
    {
        // Constructor
        setExpr5(_expr5_);

    }

    @Override
    public Object clone()
    {
        return new AExpr5Expr4(
            cloneNode(this._expr5_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAExpr5Expr4(this);
    }

    public PExpr5 getExpr5()
    {
        return this._expr5_;
    }

    public void setExpr5(PExpr5 node)
    {
        if(this._expr5_ != null)
        {
            this._expr5_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._expr5_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._expr5_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._expr5_ == child)
        {
            this._expr5_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._expr5_ == oldChild)
        {
            setExpr5((PExpr5) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}