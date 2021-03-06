/* This file was generated by SableCC (http://www.sablecc.org/). */

package sc.node;

import sc.analysis.*;

@SuppressWarnings("nls")
public final class AFctApp extends PApp
{
    private TId _id_;
    private TLPar _lPar_;
    private PE _e_;
    private TRPar _rPar_;
    private TPvir _pvir_;

    public AFctApp()
    {
        // Constructor
    }

    public AFctApp(
        @SuppressWarnings("hiding") TId _id_,
        @SuppressWarnings("hiding") TLPar _lPar_,
        @SuppressWarnings("hiding") PE _e_,
        @SuppressWarnings("hiding") TRPar _rPar_,
        @SuppressWarnings("hiding") TPvir _pvir_)
    {
        // Constructor
        setId(_id_);

        setLPar(_lPar_);

        setE(_e_);

        setRPar(_rPar_);

        setPvir(_pvir_);

    }

    @Override
    public Object clone()
    {
        return new AFctApp(
            cloneNode(this._id_),
            cloneNode(this._lPar_),
            cloneNode(this._e_),
            cloneNode(this._rPar_),
            cloneNode(this._pvir_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAFctApp(this);
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

    public TLPar getLPar()
    {
        return this._lPar_;
    }

    public void setLPar(TLPar node)
    {
        if(this._lPar_ != null)
        {
            this._lPar_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._lPar_ = node;
    }

    public PE getE()
    {
        return this._e_;
    }

    public void setE(PE node)
    {
        if(this._e_ != null)
        {
            this._e_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._e_ = node;
    }

    public TRPar getRPar()
    {
        return this._rPar_;
    }

    public void setRPar(TRPar node)
    {
        if(this._rPar_ != null)
        {
            this._rPar_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._rPar_ = node;
    }

    public TPvir getPvir()
    {
        return this._pvir_;
    }

    public void setPvir(TPvir node)
    {
        if(this._pvir_ != null)
        {
            this._pvir_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._pvir_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._id_)
            + toString(this._lPar_)
            + toString(this._e_)
            + toString(this._rPar_)
            + toString(this._pvir_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._id_ == child)
        {
            this._id_ = null;
            return;
        }

        if(this._lPar_ == child)
        {
            this._lPar_ = null;
            return;
        }

        if(this._e_ == child)
        {
            this._e_ = null;
            return;
        }

        if(this._rPar_ == child)
        {
            this._rPar_ = null;
            return;
        }

        if(this._pvir_ == child)
        {
            this._pvir_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._id_ == oldChild)
        {
            setId((TId) newChild);
            return;
        }

        if(this._lPar_ == oldChild)
        {
            setLPar((TLPar) newChild);
            return;
        }

        if(this._e_ == oldChild)
        {
            setE((PE) newChild);
            return;
        }

        if(this._rPar_ == oldChild)
        {
            setRPar((TRPar) newChild);
            return;
        }

        if(this._pvir_ == oldChild)
        {
            setPvir((TPvir) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
