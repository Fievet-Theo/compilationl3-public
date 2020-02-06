/* This file was generated by SableCC (http://www.sablecc.org/). */

package src.node;

import src.analysis.*;

@SuppressWarnings("nls")
public final class AMultExpr4 extends PExpr4
{
    private PExpr4 _expr4_;
    private TMult _mult_;
    private PExpr5 _expr5_;

    public AMultExpr4()
    {
        // Constructor
    }

    public AMultExpr4(
        @SuppressWarnings("hiding") PExpr4 _expr4_,
        @SuppressWarnings("hiding") TMult _mult_,
        @SuppressWarnings("hiding") PExpr5 _expr5_)
    {
        // Constructor
        setExpr4(_expr4_);

        setMult(_mult_);

        setExpr5(_expr5_);

    }

    @Override
    public Object clone()
    {
        return new AMultExpr4(
            cloneNode(this._expr4_),
            cloneNode(this._mult_),
            cloneNode(this._expr5_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAMultExpr4(this);
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

    public TMult getMult()
    {
        return this._mult_;
    }

    public void setMult(TMult node)
    {
        if(this._mult_ != null)
        {
            this._mult_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._mult_ = node;
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
            + toString(this._expr4_)
            + toString(this._mult_)
            + toString(this._expr5_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._expr4_ == child)
        {
            this._expr4_ = null;
            return;
        }

        if(this._mult_ == child)
        {
            this._mult_ = null;
            return;
        }

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
        if(this._expr4_ == oldChild)
        {
            setExpr4((PExpr4) newChild);
            return;
        }

        if(this._mult_ == oldChild)
        {
            setMult((TMult) newChild);
            return;
        }

        if(this._expr5_ == oldChild)
        {
            setExpr5((PExpr5) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
