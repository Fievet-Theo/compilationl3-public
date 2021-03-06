/* This file was generated by SableCC (http://www.sablecc.org/). */

package src.node;

import src.analysis.*;

@SuppressWarnings("nls")
public final class ADecvar2Ldvb extends PLdvb
{
    private TVirgule _virgule_;
    private PDv _dv_;
    private PLdvb _ldvb_;

    public ADecvar2Ldvb()
    {
        // Constructor
    }

    public ADecvar2Ldvb(
        @SuppressWarnings("hiding") TVirgule _virgule_,
        @SuppressWarnings("hiding") PDv _dv_,
        @SuppressWarnings("hiding") PLdvb _ldvb_)
    {
        // Constructor
        setVirgule(_virgule_);

        setDv(_dv_);

        setLdvb(_ldvb_);

    }

    @Override
    public Object clone()
    {
        return new ADecvar2Ldvb(
            cloneNode(this._virgule_),
            cloneNode(this._dv_),
            cloneNode(this._ldvb_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseADecvar2Ldvb(this);
    }

    public TVirgule getVirgule()
    {
        return this._virgule_;
    }

    public void setVirgule(TVirgule node)
    {
        if(this._virgule_ != null)
        {
            this._virgule_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._virgule_ = node;
    }

    public PDv getDv()
    {
        return this._dv_;
    }

    public void setDv(PDv node)
    {
        if(this._dv_ != null)
        {
            this._dv_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._dv_ = node;
    }

    public PLdvb getLdvb()
    {
        return this._ldvb_;
    }

    public void setLdvb(PLdvb node)
    {
        if(this._ldvb_ != null)
        {
            this._ldvb_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._ldvb_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._virgule_)
            + toString(this._dv_)
            + toString(this._ldvb_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._virgule_ == child)
        {
            this._virgule_ = null;
            return;
        }

        if(this._dv_ == child)
        {
            this._dv_ = null;
            return;
        }

        if(this._ldvb_ == child)
        {
            this._ldvb_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._virgule_ == oldChild)
        {
            setVirgule((TVirgule) newChild);
            return;
        }

        if(this._dv_ == oldChild)
        {
            setDv((PDv) newChild);
            return;
        }

        if(this._ldvb_ == oldChild)
        {
            setLdvb((PLdvb) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
