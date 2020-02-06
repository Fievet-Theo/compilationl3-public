/* This file was generated by SableCC (http://www.sablecc.org/). */

package sc.node;

import sc.analysis.*;

@SuppressWarnings("nls")
public final class AEgalafIa extends PIa
{
    private PVar _var_;
    private TEgal _egal_;
    private TAf _af_;

    public AEgalafIa()
    {
        // Constructor
    }

    public AEgalafIa(
        @SuppressWarnings("hiding") PVar _var_,
        @SuppressWarnings("hiding") TEgal _egal_,
        @SuppressWarnings("hiding") TAf _af_)
    {
        // Constructor
        setVar(_var_);

        setEgal(_egal_);

        setAf(_af_);

    }

    @Override
    public Object clone()
    {
        return new AEgalafIa(
            cloneNode(this._var_),
            cloneNode(this._egal_),
            cloneNode(this._af_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAEgalafIa(this);
    }

    public PVar getVar()
    {
        return this._var_;
    }

    public void setVar(PVar node)
    {
        if(this._var_ != null)
        {
            this._var_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._var_ = node;
    }

    public TEgal getEgal()
    {
        return this._egal_;
    }

    public void setEgal(TEgal node)
    {
        if(this._egal_ != null)
        {
            this._egal_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._egal_ = node;
    }

    public TAf getAf()
    {
        return this._af_;
    }

    public void setAf(TAf node)
    {
        if(this._af_ != null)
        {
            this._af_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._af_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._var_)
            + toString(this._egal_)
            + toString(this._af_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._var_ == child)
        {
            this._var_ = null;
            return;
        }

        if(this._egal_ == child)
        {
            this._egal_ = null;
            return;
        }

        if(this._af_ == child)
        {
            this._af_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._var_ == oldChild)
        {
            setVar((PVar) newChild);
            return;
        }

        if(this._egal_ == oldChild)
        {
            setEgal((TEgal) newChild);
            return;
        }

        if(this._af_ == oldChild)
        {
            setAf((TAf) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
