/* This file was generated by SableCC (http://www.sablecc.org/). */

package src.node;

import src.analysis.*;

@SuppressWarnings("nls")
public final class AVideLe extends PLe
{

    public AVideLe()
    {
        // Constructor
    }

    @Override
    public Object clone()
    {
        return new AVideLe();
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAVideLe(this);
    }

    @Override
    public String toString()
    {
        return "";
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        throw new RuntimeException("Not a child.");
    }
}
