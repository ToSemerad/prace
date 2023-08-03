package com.teamcenter.soaictstubs;

import com.teamcenter.services.internal.loose.core.ICTService;
import com.teamcenter.services.internal.loose.core._2011_06.ICT.Arg;
import com.teamcenter.services.internal.loose.core._2011_06.ICT.InvokeICTMethodResponse;
import com.teamcenter.soa.client.Connection;


/** 
 * ***********************************************************
 * *                                                         *
 * *      THE FOLLOWING SOURCE FILE HAS BEEN AUTOMATICALLY   *
 * *      GENERATED.  ANY HAND CRAFTED CHANGES WILL BE LOST! *
 * *                                                         *
 * ***********************************************************
 * 
 */

public class ICCTNamedVariantExpression extends ICCT {
  public ICCTNamedVariantExpression(Connection connection) {
    super(connection);
  }

  public ICCTNamedVariantExpression(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void create(String name, String desc, String var1, String var2, int op, String comment, StringHolder newNamedVariantExpression, StringHolder namedVariantExpressionTypeUid) throws Exception {
    Arg[] args_ = new Arg[8];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(name);
    args_[3] = TcUtility.createArgStringUnion(desc);
    args_[4] = TcUtility.createArg(var1);
    args_[5] = TcUtility.createArg(var2);
    args_[6] = TcUtility.createArg(op);
    args_[7] = TcUtility.createArgStringUnion(comment);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTNamedVariantExpression", "create", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    newNamedVariantExpression.value = TcUtility.queryArg(response.output[0], newNamedVariantExpression.value);
    namedVariantExpressionTypeUid.value = TcUtility.queryArg(response.output[1], namedVariantExpressionTypeUid.value);
  }

  public void getCode(String namedVariantExprUid, StringHolder code) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(namedVariantExprUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTNamedVariantExpression", "getCode", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    code.value = TcUtility.queryArgStringUnion(response.output[0], code.value);
  }

  public void setCode(String namedVariantExprUid, String code) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(namedVariantExprUid);
    args_[3] = TcUtility.createArgStringUnion(code);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTNamedVariantExpression", "setCode", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getDescription(String namedVariantExprUid, StringHolder desc) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(namedVariantExprUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTNamedVariantExpression", "getDescription", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    desc.value = TcUtility.queryArgStringUnion(response.output[0], desc.value);
  }

  public void setDescription(String namedVariantExprUid, String desc) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(namedVariantExprUid);
    args_[3] = TcUtility.createArgStringUnion(desc);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTNamedVariantExpression", "setDescription", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getFingerPrint(String namedVariantExprUid, IntHolder fp) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(namedVariantExprUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTNamedVariantExpression", "getFingerPrint", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    fp.value = TcUtility.queryArg(response.output[0], fp.value);
  }

  public void setFingerPrint(String namedVariantExprUid, int fp) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(namedVariantExprUid);
    args_[3] = TcUtility.createArg(fp);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTNamedVariantExpression", "setFingerPrint", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getVariableOne(String namedVariantExprUid, StringHolder var1, StringHolder var1TypeUid) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(namedVariantExprUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTNamedVariantExpression", "getVariableOne", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    var1.value = TcUtility.queryArg(response.output[0], var1.value);
    var1TypeUid.value = TcUtility.queryArg(response.output[1], var1TypeUid.value);
  }

  public void setVariableOne(String namedVariantExprUid, String var1Uid) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(namedVariantExprUid);
    args_[3] = TcUtility.createArg(var1Uid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTNamedVariantExpression", "setVariableOne", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getVariableTwo(String namedVariantExprUid, StringHolder var2, StringHolder var2TypeUid) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(namedVariantExprUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTNamedVariantExpression", "getVariableTwo", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    var2.value = TcUtility.queryArg(response.output[0], var2.value);
    var2TypeUid.value = TcUtility.queryArg(response.output[1], var2TypeUid.value);
  }

  public void setVariableTwo(String namedVariantExprUid, String var2Uid) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(namedVariantExprUid);
    args_[3] = TcUtility.createArg(var2Uid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTNamedVariantExpression", "setVariableTwo", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getOpCode(String namedVariantExprUid, IntHolder op) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(namedVariantExprUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTNamedVariantExpression", "getOpCode", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    op.value = TcUtility.queryArg(response.output[0], op.value);
  }

  public void setOpCode(String namedVariantExprUid, int op) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(namedVariantExprUid);
    args_[3] = TcUtility.createArg(op);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTNamedVariantExpression", "setOpCode", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getLiterals(String nveTag, IntHolder noOfLiterals, uidValueSeq_tHolder literals, uidValueSeq_tHolder literalTypes) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(nveTag);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTNamedVariantExpression", "getLiterals", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    noOfLiterals.value = TcUtility.queryArg(response.output[0], noOfLiterals.value);
    literals.value = TcUtility.queryArgStringUnion(response.output[1], literals.value);
    literalTypes.value = TcUtility.queryArgStringUnion(response.output[2], literalTypes.value);
  }

  public void setLiterals(String nveTag, int noOfLiterals, String[] literals) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(nveTag);
    args_[3] = TcUtility.createArg(noOfLiterals);
    args_[4] = TcUtility.createArgStringUnion(literals);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTNamedVariantExpression", "setLiterals", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

}
