/* This file was generated by SableCC (http://www.sablecc.org/). */

package sc.node;

import sc.analysis.*;

@SuppressWarnings("nls")
public final class TPv extends Token
{
    public TPv()
    {
        super.setText(";");
    }

    public TPv(int line, int pos)
    {
        super.setText(";");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TPv(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTPv(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TPv text.");
    }
}
