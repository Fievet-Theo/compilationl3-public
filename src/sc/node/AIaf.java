/* This file was generated by SableCC (http://www.sablecc.org/). */

package sc.node;

import sc.analysis.*;

@SuppressWarnings("nls")
public final class AIaf extends PIaf
{
    private PApp _app_;
    private TPv _pv_;

    public AIaf()
    {
        // Constructor
    }

    public AIaf(
        @SuppressWarnings("hiding") PApp _app_,
        @SuppressWarnings("hiding") TPv _pv_)
    {
        // Constructor
        setApp(_app_);

        setPv(_pv_);

    }

    @Override
    public Object clone()
    {
        return new AIaf(
            cloneNode(this._app_),
            cloneNode(this._pv_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAIaf(this);
    }

    public PApp getApp()
    {
        return this._app_;
    }

    public void setApp(PApp node)
    {
        if(this._app_ != null)
        {
            this._app_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._app_ = node;
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
            + toString(this._app_)
            + toString(this._pv_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._app_ == child)
        {
            this._app_ = null;
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
        if(this._app_ == oldChild)
        {
            setApp((PApp) newChild);
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
