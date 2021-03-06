/* This file was generated by SableCC (http://www.sablecc.org/). */

package src.node;

import src.analysis.*;

@SuppressWarnings("nls")
public final class ATabDv1 extends PDv1
{
    private TCo _co_;
    private TNb _nb_;
    private TCf _cf_;

    public ATabDv1()
    {
        // Constructor
    }

    public ATabDv1(
        @SuppressWarnings("hiding") TCo _co_,
        @SuppressWarnings("hiding") TNb _nb_,
        @SuppressWarnings("hiding") TCf _cf_)
    {
        // Constructor
        setCo(_co_);

        setNb(_nb_);

        setCf(_cf_);

    }

    @Override
    public Object clone()
    {
        return new ATabDv1(
            cloneNode(this._co_),
            cloneNode(this._nb_),
            cloneNode(this._cf_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseATabDv1(this);
    }

    public TCo getCo()
    {
        return this._co_;
    }

    public void setCo(TCo node)
    {
        if(this._co_ != null)
        {
            this._co_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._co_ = node;
    }

    public TNb getNb()
    {
        return this._nb_;
    }

    public void setNb(TNb node)
    {
        if(this._nb_ != null)
        {
            this._nb_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._nb_ = node;
    }

    public TCf getCf()
    {
        return this._cf_;
    }

    public void setCf(TCf node)
    {
        if(this._cf_ != null)
        {
            this._cf_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._cf_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._co_)
            + toString(this._nb_)
            + toString(this._cf_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._co_ == child)
        {
            this._co_ = null;
            return;
        }

        if(this._nb_ == child)
        {
            this._nb_ = null;
            return;
        }

        if(this._cf_ == child)
        {
            this._cf_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._co_ == oldChild)
        {
            setCo((TCo) newChild);
            return;
        }

        if(this._nb_ == oldChild)
        {
            setNb((TNb) newChild);
            return;
        }

        if(this._cf_ == oldChild)
        {
            setCf((TCf) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
