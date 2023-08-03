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

public class ICCTStructureMapItemRevision extends ICCTCAEItemRevision {
  public ICCTStructureMapItemRevision(Connection connection) {
    super(connection);
  }

  public ICCTStructureMapItemRevision(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void getDomain(String structureMIRTag, StringHolder domain) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(structureMIRTag);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTStructureMapItemRevision", "getDomain", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    domain.value = TcUtility.queryArg(response.output[0], domain.value);
  }

  public void setDomain(String structureMIRTag, String domain) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(structureMIRTag);
    args_[3] = TcUtility.createArgStringUnion(domain);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTStructureMapItemRevision", "setDomain", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getLastValidationDate(String structureMIRTag, StringHolder lastValidationDate) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(structureMIRTag);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTStructureMapItemRevision", "getLastValidationDate", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    lastValidationDate.value = TcUtility.queryArg(response.output[0], lastValidationDate.value);
  }

  public void setLastValidationDate(String structureMIRTag) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(structureMIRTag);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTStructureMapItemRevision", "setLastValidationDate", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getRuleNames(String structureMIRTag, stringSeq_tHolder ruleNames) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(structureMIRTag);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTStructureMapItemRevision", "getRuleNames", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    ruleNames.value = TcUtility.queryArg(response.output[0], ruleNames.value);
  }

  public void setRuleNames(String structureMIRTag, int numRuleNames, String[] ruleNames) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(structureMIRTag);
    args_[3] = TcUtility.createArg(numRuleNames);
    args_[4] = TcUtility.createArg(ruleNames);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTStructureMapItemRevision", "setRuleNames", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getSchemaVersion(String structureMIRTag, StringHolder schemaVersion) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(structureMIRTag);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTStructureMapItemRevision", "getSchemaVersion", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    schemaVersion.value = TcUtility.queryArg(response.output[0], schemaVersion.value);
  }

  public void setSchemaVersion(String structureMIRTag, String schemaVersion) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(structureMIRTag);
    args_[3] = TcUtility.createArgStringUnion(schemaVersion);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTStructureMapItemRevision", "setSchemaVersion", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void validateStructureMap(String structureMIRTag, StringHolder validationLog, BooleanHolder isValid) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(structureMIRTag);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTStructureMapItemRevision", "validateStructureMap", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    validationLog.value = TcUtility.queryArgStringUnion(response.output[0], validationLog.value);
    isValid.value = TcUtility.queryArg(response.output[1], isValid.value);
  }

}
