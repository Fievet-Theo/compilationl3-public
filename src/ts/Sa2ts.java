package ts;

import sa.*;

public class Sa2ts extends SaDepthFirstVisitor<Void> {
    enum Context {GLOBAL, LOCAL, PARAM};
    private Ts table;
    private Ts tableLocale;
    private Context context;


    public Sa2ts(SaNode saRoot) {
        this.table = new Ts();
        context = Context.GLOBAL;

        saRoot.accept(this);
    }

    public Ts getTableGlobale() {
        return table;
    }

    @Override
    public Void visit(SaDecVar node) {
        String nom = node.getNom();
        if (context == Context.GLOBAL) {
            table.addVar(nom,1);
        }
        else if (context == Context.LOCAL) {
            tableLocale.addVar(nom,1);
        }
        else {
            tableLocale.addParam(nom);
        }
        return null;
    }

    @Override
    public Void visit(SaDecTab node) {
        String nom = node.getNom();
        if (context == Context.GLOBAL) {
            table.addVar(nom,node.getTaille());
        }
        else if (context == Context.LOCAL) {
            tableLocale.addVar(nom,node.getTaille());
        }
        else {
            tableLocale.addParam(nom);
        }
        return null;
    }

    @Override
    public Void visit(SaDecFonc node)
    {
        tableLocale = new Ts();

        context = Context.PARAM;
        if(node.getParametres() != null) node.getParametres().accept(this);
        context = Context.LOCAL;
        if(node.getVariable() != null) node.getVariable().accept(this);
        node.getCorps().accept(this);
        defaultOut(node);
        context = Context.LOCAL;
        return null;
    }

    @Override
    public Void visit(SaVarSimple node) {
        TsItemVar var = this.table.getVar(node.getNom());
        TsItemVar varLocale = this.tableLocale.getVar(node.getNom());

        if (var == null && varLocale == null) {
            System.err.println("variable non definie");
            System.exit(1);
        }

        return null;
    }

    @Override
    public Void visit(SaVarIndicee node) {
        TsItemVar var = this.table.getVar(node.getNom());
        TsItemVar varLocale = this.tableLocale.getVar(node.getNom());

        if (var == null && varLocale == null) {
            System.err.println("variable non definie");
            System.exit(1);
        }

        return null;
    }

    @Override
    public Void visit(SaAppel node) {
        TsItemFct fct = this.table.getFct(node.getNom());

        if (fct == null) {
            System.err.println("fonction non definie");
            System.exit(1);
        }

        return null;
    }
}
