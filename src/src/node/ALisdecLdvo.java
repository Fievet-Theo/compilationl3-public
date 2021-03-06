/* This file was generated by SableCC (http://www.sablecc.org/). */

package src.node;

import src.analysis.*;

@SuppressWarnings("nls")
public final class ALisdecLdvo extends PLdvo
{
    private PLd _ld_;
    private TPv _pv_;

    public ALisdecLdvo()
    {
        // Constructor
    }

    public ALisdecLdvo(
        @SuppressWarnings("hiding") PLd _ld_,
        @SuppressWarnings("hiding") TPv _pv_)
    {
        // Constructor
        setLd(_ld_);

        setPv(_pv_);

    }

    @Override
    public Object clone()
    {
        return new ALisdecLdvo(
            cloneNode(this._ld_),
            cloneNode(this._pv_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseALisdecLdvo(this);
    }

    public PLd getLd()
    {
        return this._ld_;
    }

    public void setLd(PLd node)
    {
        if(this._ld_ != null)
        {
            this._ld_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._ld_ = node;
    }

    public TPv getPv()
    {
        return this._pv_;
    }

    public void setPv(TPv node)
    {
        if(this._pv_ != null)
        {
            this._pv_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._pv_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._ld_)
            + toString(this._pv_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._ld_ == child)
        {
            this._ld_ = null;
            return;
        }

        if(this._pv_ == child)
        {
            this._pv_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._ld_ == oldChild)
        {
            setLd((PLd) newChild);
            return;
        }

        if(this._pv_ == oldChild)
        {
            setPv((TPv) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
