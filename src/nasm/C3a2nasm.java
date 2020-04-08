package nasm;

import c3a.*;
import sa.SaLDec;
import ts.Ts;
import ts.TsItemFct;

public class C3a2nasm implements C3aVisitor<NasmOperand> {
    private C3a c3a;
    private Nasm nasm;
    private Ts table;
    private TsItemFct currentFct;

    public C3a2nasm(C3a c3a, Ts table) {
        this.c3a = c3a;
        this.table = table;
        this.nasm = new Nasm(table);

        //Init code
        NasmLabel label = new NasmLabel("main");
        nasm.ajouteInst(new NasmCall(null, label, ""));
        NasmRegister reg_ebx = nasm.newRegister();
        reg_ebx.colorRegister(Nasm.REG_EBX);
        nasm.ajouteInst(new NasmMov(null, reg_ebx, new NasmConstant(0), " valeur de retour du programme"));
        NasmRegister reg_eax = nasm.newRegister();
        reg_eax.colorRegister(Nasm.REG_EAX);
        nasm.ajouteInst(new NasmMov(null, reg_eax, new NasmConstant(1), ""));
        nasm.ajouteInst(new NasmInt(null, ""));

        for (int i = 0; i < c3a.listeInst.size(); ++i) {
            c3a.listeInst.get(i).accept(this);
        }
    }

    public Nasm getNasm() {
        return nasm;
    }

    @Override
    public NasmOperand visit(C3aInstAdd inst) {
        NasmOperand label = (inst.label != null) ? inst.label.accept(this) : null;
        NasmOperand oper1 = inst.op1.accept(this);
        NasmOperand oper2 = inst.op2.accept(this);
        NasmOperand dest = inst.result.accept(this);
        nasm.ajouteInst(new NasmMov(label, dest, oper1, ""));
        nasm.ajouteInst(new NasmAdd(null, dest, oper2, ""));
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstCall inst) {
        NasmOperand label = (inst.label != null) ? inst.label.accept(this) : null;
        NasmRegister reg_esp = nasm.newRegister();
        reg_esp.colorRegister(Nasm.REG_ESP);
        nasm.ajouteInst(new NasmSub(label, reg_esp, new NasmConstant(4), "allocation mémoire pour la valeur de retour"));

        NasmOperand labelFonc = new NasmLabel(inst.op1.val.identif);
        nasm.ajouteInst(new NasmCall(null, labelFonc, ""));

        NasmOperand result = inst.result.accept(this);
        nasm.ajouteInst(new NasmPop(null, result, "récupération de la valeur de retour"));

        if (inst.op1.val.getNbArgs() != 0) {
            nasm.ajouteInst(new NasmAdd(null, reg_esp, new NasmConstant(inst.op1.val.getNbArgs()*4), "désallocation des arguments"));
        }
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstFBegin inst) {
        NasmRegister reg_ebp = nasm.newRegister();
        reg_ebp.colorRegister(Nasm.REG_EBP);

        NasmRegister reg_esp = nasm.newRegister();
        reg_esp.colorRegister(Nasm.REG_ESP);
        NasmLabel label = new NasmLabel(inst.val.identif);

        nasm.ajouteInst(new NasmPush(label, reg_ebp, "sauvegarde la valeur de ebp"));
        nasm.ajouteInst(new NasmMov(null, reg_ebp, reg_esp, "nouvelle valeur de ebp"));

        currentFct = inst.val;
        SaLDec dec = currentFct.saDecFonc.getVariable();
        NasmConstant constant;
        if (dec != null) {
            constant = new NasmConstant(4*dec.length());
        } else {
            constant = new NasmConstant(0);
        }
        nasm.ajouteInst(new NasmSub(null, reg_esp, constant, "allocation des variables locales"));

        return null;
    }

    @Override
    public NasmOperand visit(C3aInst inst) {
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstJumpIfLess inst) {
        NasmOperand label = (inst.label != null) ? inst.label.accept(this) : null;
        NasmOperand op1 = inst.op1.accept(this);
        NasmOperand op2 = inst.op2.accept(this);

        if (op1.isGeneralRegister()) {
            nasm.ajouteInst(new NasmCmp(label, op1, op2, "JumpIfLess 1"));
        } else {
            NasmRegister reg = nasm.newRegister();
            nasm.ajouteInst(new NasmMov(label, reg, op1, "JumpIfLess 1"));
            nasm.ajouteInst(new NasmCmp(null, reg, op2, "on passe par un registre temporaire"));
        }
        NasmOperand result = inst.result.accept(this);
        nasm.ajouteInst(new NasmJl(null, result, "JumpIfLess 2"));
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstMult inst) {
        NasmOperand label = (inst.label != null) ? inst.label.accept(this) : null;
        NasmOperand oper1 = inst.op1.accept(this);
        NasmOperand oper2 = inst.op2.accept(this);
        NasmOperand dest = inst.result.accept(this);
        nasm.ajouteInst(new NasmMov(label, dest, oper1, ""));
        nasm.ajouteInst(new NasmMul(null, dest, oper2, ""));
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstRead inst) {
        NasmOperand label = (inst.label != null) ? inst.label.accept(this) : null;
        NasmRegister reg_eax = nasm.newRegister();
        reg_eax.colorRegister(Nasm.REG_EAX);

        NasmOperand sinput = new NasmLabel("sinput");
        NasmOperand readline = new NasmLabel("readline");
        NasmOperand atoi = new NasmLabel("atoi");

        nasm.ajouteInst(new NasmMov(label, reg_eax, sinput, ""));
        nasm.ajouteInst(new NasmCall(null, readline, ""));
        nasm.ajouteInst(new NasmCall(null, atoi, ""));

        NasmRegister reg = nasm.newRegister();
        nasm.ajouteInst(new NasmMov(null, reg, reg_eax, ""));
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstSub inst) {
        NasmOperand label = (inst.label != null) ? inst.label.accept(this) : null;
        NasmOperand oper1 = inst.op1.accept(this);
        NasmOperand oper2 = inst.op2.accept(this);
        NasmOperand dest = inst.result.accept(this);
        nasm.ajouteInst(new NasmMov(label, dest, oper1, ""));
        nasm.ajouteInst(new NasmSub(null, dest, oper2, ""));
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstAffect inst) {
        NasmOperand label = (inst.label != null) ? inst.label.accept(this) : null;
        NasmOperand result = inst.result.accept(this);
        NasmOperand op1 = inst.op1.accept(this);
        nasm.ajouteInst(new NasmMov(label, result, op1, "Affect"));
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstDiv inst) {
        NasmOperand label = (inst.label != null) ? inst.label.accept(this) : null;
        NasmOperand oper1 = inst.op1.accept(this);
        NasmOperand oper2 = inst.op2.accept(this);
        NasmOperand dest = inst.result.accept(this);
        NasmRegister reg_eax = nasm.newRegister();
        reg_eax.colorRegister(Nasm.REG_EAX);
        NasmRegister reg = nasm.newRegister();

        nasm.ajouteInst(new NasmMov(label, reg_eax, oper1, ""));
        nasm.ajouteInst(new NasmMov(null, reg, oper2, ""));
        nasm.ajouteInst(new NasmDiv(null, reg, ""));
        nasm.ajouteInst(new NasmMov(null, dest, reg_eax, ""));
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstFEnd inst) {
        NasmOperand label = (inst.label != null) ? inst.label.accept(this) : null;
        SaLDec dec = currentFct.saDecFonc.getVariable();
        NasmRegister reg_esp = nasm.newRegister();
        reg_esp.colorRegister(Nasm.REG_ESP);
        NasmConstant constant;
        if (dec != null) {
            constant = new NasmConstant(4*dec.length());
        } else {
            constant = new NasmConstant(0);
        }
        nasm.ajouteInst(new NasmAdd(label, reg_esp, constant, "désallocation des variables locales"));

        NasmRegister reg_ebp = nasm.newRegister();
        reg_ebp.colorRegister(Nasm.REG_EBP);

        nasm.ajouteInst(new NasmPop(null, reg_ebp, "restaure la valeur de ebp"));
        nasm.ajouteInst(new NasmRet(null, ""));
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstJumpIfEqual inst) {
        NasmOperand label = (inst.label != null) ? inst.label.accept(this) : null;
        NasmOperand op1 = inst.op1.accept(this);
        NasmOperand op2 = inst.op2.accept(this);

        if (op1.isGeneralRegister()) {
            nasm.ajouteInst(new NasmCmp(label, op1, op2, "JumpIfEqual 1"));
        } else {
            NasmRegister reg = nasm.newRegister();
            nasm.ajouteInst(new NasmMov(label, reg, op1, "JumpIfEqual 1"));
            nasm.ajouteInst(new NasmCmp(null, reg, op2, "on passe par un registre temporaire"));
        }
        NasmOperand result = inst.result.accept(this);
        nasm.ajouteInst(new NasmJe(null, result, "JumpIfEqual 2"));
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstJumpIfNotEqual inst) {
        NasmOperand label = (inst.label != null) ? inst.label.accept(this) : null;
        NasmOperand op1 = inst.op1.accept(this);
        NasmOperand op2 = inst.op2.accept(this);

        if (op1.isGeneralRegister()) {
            nasm.ajouteInst(new NasmCmp(label, op1, op2, "jumpIfNotEqual 1"));
        } else {
            NasmRegister reg = nasm.newRegister();
            nasm.ajouteInst(new NasmMov(label, reg, op1, "jumpIfNotEqual 1"));
            nasm.ajouteInst(new NasmCmp(null, reg, op2, "on passe par un registre temporaire"));
        }
        NasmOperand result = inst.result.accept(this);
        nasm.ajouteInst(new NasmJne(null, result, "jumpIfNotEqual 2"));
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstJump inst) {
        NasmOperand label = (inst.label != null) ? inst.label.accept(this) : null;
        NasmOperand result;
        if (inst.result != null) {
            result = inst.result.accept(this);
        } else {
            result = null;
        }
        nasm.ajouteInst(new NasmJmp(label, result, "Jump"));
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstParam inst) {
        NasmOperand label = (inst.label != null) ? inst.label.accept(this) : null;
        NasmOperand op1 = inst.op1.accept(this);
        nasm.ajouteInst(new NasmPush(label, op1, "Param"));
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstReturn inst) {
        NasmOperand label = (inst.label != null) ? inst.label.accept(this) : null;
        NasmRegister reg_ebp = nasm.newRegister();
        reg_ebp.colorRegister(Nasm.REG_EBP);
        NasmOperand op1 = inst.op1.accept(this);
        NasmAddress address = new NasmAddress(reg_ebp, '+', new NasmConstant(2));
        nasm.ajouteInst(new NasmMov(label, address, op1, "ecriture de la valeur de retour"));
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstWrite inst) {
        NasmOperand label = (inst.label != null) ? inst.label.accept(this) : null;
        NasmRegister reg_eax = nasm.newRegister();
        reg_eax.colorRegister(Nasm.REG_EAX);
        NasmOperand operand = inst.op1.accept(this);

        nasm.ajouteInst(new NasmMov(label, reg_eax, operand, "Write 1"));
        nasm.ajouteInst(new NasmCall(null, new NasmLabel("iprintLF"), "Write 2"));

        return null;
    }

    @Override
    public NasmOperand visit(C3aConstant oper) {
        return new NasmConstant(oper.val);
    }

    @Override
    public NasmOperand visit(C3aLabel oper) {
        return new NasmLabel(oper.toString());
    }

    @Override
    public NasmOperand visit(C3aTemp oper) {
        return new NasmRegister(oper.num);
    }

    @Override
    public NasmOperand visit(C3aVar oper) {
        if (oper.index != null) {
            return new NasmAddress(new NasmLabel(oper.item.getIdentif()), '+', oper.index.accept(this));
        } else if (oper.item.isParam) { //parametre
            NasmRegister reg_ebp = nasm.newRegister();
            reg_ebp.colorRegister(Nasm.REG_EBP);
            NasmOperand offset = new NasmConstant(2 + currentFct.getNbArgs() - oper.item.adresse);
            return new NasmAddress(reg_ebp, '+', offset);
        } else if (currentFct.getTable().getVar(oper.item.getIdentif()) != null) { //local
            NasmRegister reg_ebp = nasm.newRegister();
            reg_ebp.colorRegister(Nasm.REG_EBP);
            NasmOperand offset = new NasmConstant(oper.item.adresse+1);
            return new NasmAddress(reg_ebp, '-', offset);
        }
        NasmOperand base = new NasmLabel(oper.item.getIdentif());
        return new NasmAddress(base, ' ', null);
    }

    @Override
    public NasmOperand visit(C3aFunction oper) {
        return new NasmLabel(oper.val.identif);
    }
}
