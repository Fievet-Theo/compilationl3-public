/* This file was generated by SableCC (http://www.sablecc.org/). */

package src.node;

import src.analysis.*;

@SuppressWarnings("nls")
public final class APlusExpr3 extends PExpr3
{
    private PExpr3 _expr3_;
    private TPlus _plus_;
    private PExpr4 _expr4_;

    public APlusExpr3()
    {
        // Constructor
    }

    public APlusExpr3(
        @SuppressWarnings("hiding") PExpr3 _expr3_,
        @SuppressWarnings("hiding") TPlus _plus_,
        @SuppressWarnings("hiding") PExpr4 _expr4_)
    {
        // Constructor
        setExpr3(_expr3_);

        setPlus(_plus_);

        setExpr4(_expr4_);

    }

    @Override
    public Object clone()
    {
        return new APlusExpr3(
            cloneNode(this._expr3_),
            cloneNode(this._plus_),
            cloneNode(this._expr4_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAPlusExpr3(this);
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

    public TPlus getPlus()
    {
        return this._plus_;
    }

    public void setPlus(TPlus node)
    {
        if(this._plus_ != null)
        {
            this._plus_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._plus_ = node;
    }

    public PExpr4 getExpr4()
    {
        return this._expr4_;
    }

    public void setExpr4(PExpr4 node)
    {
        if(this._expr4_ != null)
        {
            this._expr4_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._expr4_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._expr3_)
            + toString(this._plus_)
            + toString(this._expr4_);
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

        if(this._plus_ == child)
        {
            this._plus_ = null;
            return;
        }

        if(this._expr4_ == child)
        {
            this._expr4_ = null;
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

        if(this._plus_ == oldChild)
        {
            setPlus((TPlus) newChild);
            return;
        }

        if(this._expr4_ == oldChild)
        {
            setExpr4((PExpr4) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
