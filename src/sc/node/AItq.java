/* This file was generated by SableCC (http://www.sablecc.org/). */

package sc.node;

import sc.analysis.*;

@SuppressWarnings("nls")
public final class AItq extends PItq
{
    private TTantque _tantque_;
    private PExpr _expr_;
    private TFaire _faire_;
    private PIbloc _ibloc_;

    public AItq()
    {
        // Constructor
    }

    public AItq(
        @SuppressWarnings("hiding") TTantque _tantque_,
        @SuppressWarnings("hiding") PExpr _expr_,
        @SuppressWarnings("hiding") TFaire _faire_,
        @SuppressWarnings("hiding") PIbloc _ibloc_)
    {
        // Constructor
        setTantque(_tantque_);

        setExpr(_expr_);

        setFaire(_faire_);

        setIbloc(_ibloc_);

    }

    @Override
    public Object clone()
    {
        return new AItq(
            cloneNode(this._tantque_),
            cloneNode(this._expr_),
            cloneNode(this._faire_),
            cloneNode(this._ibloc_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAItq(this);
    }

    public TTantque getTantque()
    {
        return this._tantque_;
    }

    public void setTantque(TTantque node)
    {
        if(this._tantque_ != null)
        {
            this._tantque_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._tantque_ = node;
    }

    public PExpr getExpr()
    {
        return this._expr_;
    }

    public void setExpr(PExpr node)
    {
        if(this._expr_ != null)
        {
            this._expr_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._expr_ = node;
    }

    public TFaire getFaire()
    {
        return this._faire_;
    }

    public void setFaire(TFaire node)
    {
        if(this._faire_ != null)
        {
            this._faire_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._faire_ = node;
    }

    public PIbloc getIbloc()
    {
        return this._ibloc_;
    }

    public void setIbloc(PIbloc node)
    {
        if(this._ibloc_ != null)
        {
            this._ibloc_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._ibloc_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._tantque_)
            + toString(this._expr_)
            + toString(this._faire_)
            + toString(this._ibloc_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._tantque_ == child)
        {
            this._tantque_ = null;
            return;
        }

        if(this._expr_ == child)
        {
            this._expr_ = null;
            return;
        }

        if(this._faire_ == child)
        {
            this._faire_ = null;
            return;
        }

        if(this._ibloc_ == child)
        {
            this._ibloc_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._tantque_ == oldChild)
        {
            setTantque((TTantque) newChild);
            return;
        }

        if(this._expr_ == oldChild)
        {
            setExpr((PExpr) newChild);
            return;
        }

        if(this._faire_ == oldChild)
        {
            setFaire((TFaire) newChild);
            return;
        }

        if(this._ibloc_ == oldChild)
        {
            setIbloc((PIbloc) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}