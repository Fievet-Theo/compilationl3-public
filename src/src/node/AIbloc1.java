/* This file was generated by SableCC (http://www.sablecc.org/). */

package src.node;

import src.analysis.*;

@SuppressWarnings("nls")
public final class AIbloc1 extends PIbloc1
{
    private TAo _ao_;
    private PLi _li_;
    private TAf _af_;

    public AIbloc1()
    {
        // Constructor
    }

    public AIbloc1(
        @SuppressWarnings("hiding") TAo _ao_,
        @SuppressWarnings("hiding") PLi _li_,
        @SuppressWarnings("hiding") TAf _af_)
    {
        // Constructor
        setAo(_ao_);

        setLi(_li_);

        setAf(_af_);

    }

    @Override
    public Object clone()
    {
        return new AIbloc1(
            cloneNode(this._ao_),
            cloneNode(this._li_),
            cloneNode(this._af_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAIbloc1(this);
    }

    public TAo getAo()
    {
        return this._ao_;
    }

    public void setAo(TAo node)
    {
        if(this._ao_ != null)
        {
            this._ao_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._ao_ = node;
    }

    public PLi getLi()
    {
        return this._li_;
    }

    public void setLi(PLi node)
    {
        if(this._li_ != null)
        {
            this._li_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._li_ = node;
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
            + toString(this._ao_)
            + toString(this._li_)
            + toString(this._af_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._ao_ == child)
        {
            this._ao_ = null;
            return;
        }

        if(this._li_ == child)
        {
            this._li_ = null;
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
        if(this._ao_ == oldChild)
        {
            setAo((TAo) newChild);
            return;
        }

        if(this._li_ == oldChild)
        {
            setLi((PLi) newChild);
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