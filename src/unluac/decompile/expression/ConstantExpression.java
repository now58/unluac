package unluac.decompile.expression;

import unluac.decompile.Constant;
import unluac.decompile.Decompiler;
import unluac.decompile.Output;
import unluac.decompile.Walker;

public class ConstantExpression extends Expression {

  private final Constant constant;
  private final int index;
  
  public ConstantExpression(Constant constant, int index) {
    super(PRECEDENCE_ATOMIC);
    this.constant = constant;
    this.index = index;
  }

  @Override
  public void walk(Walker w) {
    w.visitExpression(this);
  }
  
  public int getConstantIndex() {
    return index;
  }
  
  @Override
  public void print(Decompiler d, Output out) {
    constant.print(d, out, false);
  }
  
  @Override
  public void printBraced(Decompiler d, Output out) {
    constant.print(d, out, true);
  }
  
  @Override
  public boolean isConstant() {
    return true;
  }
  
  @Override
  public boolean isUngrouped() {
    return true;
  }
  
  @Override
  public boolean isNil() {
    return constant.isNil();
  }
  
  @Override
  public boolean isBoolean() {
    return constant.isBoolean();
  }
  
  @Override
  public boolean isInteger() {
    return constant.isInteger();
  }
  
  @Override
  public int asInteger() {
    return constant.asInteger();
  }
  
  @Override
  public boolean isString() {
    return constant.isString();
  }
  
  @Override
  public boolean isIdentifier() {
    return constant.isIdentifier();
  }
    
  @Override
  public String asName() {
    return constant.asName();
  }
  
  @Override
  public boolean isBrief() {
    return !constant.isString() || constant.asName().length() <= 10;
  }
  
}
