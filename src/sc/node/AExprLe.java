/* This file was generated by SableCC (http://www.sablecc.org/). */

package sc.node;

import sc.analysis.*;

@SuppressWarnings("nls")
public final class AExprLe extends PLe
{
    private PExpr _expr_;
    private PLe1 _le1_;

    public AExprLe()
    {
        // Constructor
    }

    public AExprLe(
        @SuppressWarnings("hiding") PExpr _expr_,
        @SuppressWarnings("hiding") PLe1 _le1_)
    {
        // Constructor
        setExpr(_expr_);

        setLe1(_le1_);

    }

    @Override
    public Object clone()
    {
        return new AExprLe(
            cloneNode(this._expr_),
            cloneNode(this._le1_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAExprLe(this);
    }

    public PExpr getExpr()
    {
        return this._expr_;
    }

    public void setExpr(PExpr node)
    {
        if(this._expr_ != null)
        {
            this._expr_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._expr_ = node;
    }

    public PLe1 getLe1()
    {
        return this._le1_;
    }

    public void setLe1(PLe1 node)
    {
        if(this._le1_ != null)
        {
            this._le1_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._le1_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._expr_)
            + toString(this._le1_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._expr_ == child)
        {
            this._expr_ = null;
            return;
        }

        if(this._le1_ == child)
        {
            this._le1_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._expr_ == oldChild)
        {
            setExpr((PExpr) newChild);
            return;
        }

        if(this._le1_ == oldChild)
        {
            setLe1((PLe1) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
