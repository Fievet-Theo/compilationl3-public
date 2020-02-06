/* This file was generated by SableCC (http://www.sablecc.org/). */

package sc.node;

import sc.analysis.*;

@SuppressWarnings("nls")
public final class TNb extends Token
{
    public TNb(String text)
    {
        setText(text);
    }

    public TNb(String text, int line, int pos)
    {
        setText(text);
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TNb(getText(), getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTNb(this);
    }
}