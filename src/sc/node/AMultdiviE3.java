/* This file was generated by SableCC (http://www.sablecc.org/). */

package sc.node;

import sc.analysis.*;

@SuppressWarnings("nls")
public final class AMultdiviE3 extends PE3
{
    private PE4 _e4_;

    public AMultdiviE3()
    {
        // Constructor
    }

    public AMultdiviE3(
        @SuppressWarnings("hiding") PE4 _e4_)
    {
        // Constructor
        setE4(_e4_);

    }

    @Override
    public Object clone()
    {
        return new AMultdiviE3(
            cloneNode(this._e4_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAMultdiviE3(this);
    }

    public PE4 getE4()
    {
        return this._e4_;
    }

    public void setE4(PE4 node)
    {
        if(this._e4_ != null)
        {
            this._e4_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._e4_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._e4_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._e4_ == child)
        {
            this._e4_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._e4_ == oldChild)
        {
            setE4((PE4) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
