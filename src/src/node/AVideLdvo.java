/* This file was generated by SableCC (http://www.sablecc.org/). */

package src.node;

import src.analysis.*;

@SuppressWarnings("nls")
public final class AVideLdvo extends PLdvo
{

    public AVideLdvo()
    {
        // Constructor
    }

    @Override
    public Object clone()
    {
        return new AVideLdvo();
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAVideLdvo(this);
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