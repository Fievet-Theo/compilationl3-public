/* This file was generated by SableCC (http://www.sablecc.org/). */

package sc.node;

import sc.analysis.*;

@SuppressWarnings("nls")
public final class ADv extends PDv
{
    private TEntier _entier_;
    private TId _id_;
    private PDv1 _dv1_;

    public ADv()
    {
        // Constructor
    }

    public ADv(
        @SuppressWarnings("hiding") TEntier _entier_,
        @SuppressWarnings("hiding") TId _id_,
        @SuppressWarnings("hiding") PDv1 _dv1_)
    {
        // Constructor
        setEntier(_entier_);

        setId(_id_);

        setDv1(_dv1_);

    }

    @Override
    public Object clone()
    {
        return new ADv(
            cloneNode(this._entier_),
            cloneNode(this._id_),
            cloneNode(this._dv1_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseADv(this);
    }

    public TEntier getEntier()
    {
        return this._entier_;
    }

    public void setEntier(TEntier node)
    {
        if(this._entier_ != null)
        {
            this._entier_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._entier_ = node;
    }

    public TId getId()
    {
        return this._id_;
    }

    public void setId(TId node)
    {
        if(this._id_ != null)
        {
            this._id_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._id_ = node;
    }

    public PDv1 getDv1()
    {
        return this._dv1_;
    }

    public void setDv1(PDv1 node)
    {
        if(this._dv1_ != null)
        {
            this._dv1_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._dv1_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._entier_)
            + toString(this._id_)
            + toString(this._dv1_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._entier_ == child)
        {
            this._entier_ = null;
            return;
        }

        if(this._id_ == child)
        {
            this._id_ = null;
            return;
        }

        if(this._dv1_ == child)
        {
            this._dv1_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._entier_ == oldChild)
        {
            setEntier((TEntier) newChild);
            return;
        }

        if(this._id_ == oldChild)
        {
            setId((TId) newChild);
            return;
        }

        if(this._dv1_ == oldChild)
        {
            setDv1((PDv1) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
