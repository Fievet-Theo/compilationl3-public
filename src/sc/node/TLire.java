/* This file was generated by SableCC (http://www.sablecc.org/). */

package sc.node;

import sc.analysis.*;

@SuppressWarnings("nls")
public final class TLire extends Token
{
    public TLire()
    {
        super.setText("lire()");
    }

    public TLire(int line, int pos)
    {
        super.setText("lire()");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TLire(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTLire(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TLire text.");
    }
}
