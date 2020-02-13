/* This file was generated by SableCC (http://www.sablecc.org/). */

package sc.node;

import sc.analysis.*;

@SuppressWarnings("nls")
public final class ALLdf extends PLdf
{
    private PDf _df_;
    private PLdf _ldf_;

    public ALLdf()
    {
        // Constructor
    }

    public ALLdf(
        @SuppressWarnings("hiding") PDf _df_,
        @SuppressWarnings("hiding") PLdf _ldf_)
    {
        // Constructor
        setDf(_df_);

        setLdf(_ldf_);

    }

    @Override
    public Object clone()
    {
        return new ALLdf(
            cloneNode(this._df_),
            cloneNode(this._ldf_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseALLdf(this);
    }

    public PDf getDf()
    {
        return this._df_;
    }

    public void setDf(PDf node)
    {
        if(this._df_ != null)
        {
            this._df_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._df_ = node;
    }

    public PLdf getLdf()
    {
        return this._ldf_;
    }

    public void setLdf(PLdf node)
    {
        if(this._ldf_ != null)
        {
            this._ldf_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._ldf_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._df_)
            + toString(this._ldf_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._df_ == child)
        {
            this._df_ = null;
            return;
        }

        if(this._ldf_ == child)
        {
            this._ldf_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._df_ == oldChild)
        {
            setDf((PDf) newChild);
            return;
        }

        if(this._ldf_ == oldChild)
        {
            setLdf((PLdf) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}