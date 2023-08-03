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

public class ICCTObjectMapping extends ICCT {
  public ICCTObjectMapping(Connection connection) {
    super(connection);
  }

  public ICCTObjectMapping(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void create(MappingInfo objInfo, StringHolder objectMappingUid, StringHolder objectMappingTypeUid) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(objInfo);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTObjectMapping", "create", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    objectMappingUid.value = TcUtility.queryArg(response.output[0], objectMappingUid.value);
    objectMappingTypeUid.value = TcUtility.queryArg(response.output[1], objectMappingTypeUid.value);
  }

  public void find(String dataSourceUid, uidSeqValue_uHolder objectMappingUids, uidSeqValue_uHolder objectMappingTypeUids) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(dataSourceUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTObjectMapping", "find", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    objectMappingUids.value = TcUtility.queryArg(response.output[0], objectMappingUids.value);
    objectMappingTypeUids.value = TcUtility.queryArg(response.output[1], objectMappingTypeUids.value);
  }

  public void setQueryStmt(String objectMappingUid, String sqlStmt) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(objectMappingUid);
    args_[3] = TcUtility.createArg(sqlStmt);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTObjectMapping", "setQueryStmt", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getQueryStmt(String objectMappingUid, StringHolder sqlStmt) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(objectMappingUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTObjectMapping", "getQueryStmt", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    sqlStmt.value = TcUtility.queryArgStringUnion(response.output[0], sqlStmt.value);
  }

  public void relateToFormType(String objectMappingUid, String formTypeUid) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(objectMappingUid);
    args_[3] = TcUtility.createArg(formTypeUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTObjectMapping", "relateToFormType", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setKeysInfo(String objectMappingUid, String formUid, String[] extAttrUids, String[] values) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(objectMappingUid);
    args_[3] = TcUtility.createArg(formUid);
    args_[4] = TcUtility.createArg(extAttrUids);
    args_[5] = TcUtility.createArg(values);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTObjectMapping", "setKeysInfo", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getKeysInfo(String objectMappingUid, String formUid, uidSeqValue_uHolder extAttrUids, uidSeqValue_uHolder extAttrTypeUids, stringSeqValue_uHolder values) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(objectMappingUid);
    args_[3] = TcUtility.createArg(formUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTObjectMapping", "getKeysInfo", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    extAttrUids.value = TcUtility.queryArg(response.output[0], extAttrUids.value);
    extAttrTypeUids.value = TcUtility.queryArg(response.output[1], extAttrTypeUids.value);
    values.value = TcUtility.queryArg(response.output[2], values.value);
  }

  public void createEintForm(String objectMappingUid, String formName, String formDesc, String formType, String[] keyUids, String[] keyValues, String[] propNames, String[] propValues, boolean[] keyFlags, StringHolder newEintForm, StringHolder typeUid) throws Exception {
    Arg[] args_ = new Arg[11];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(objectMappingUid);
    args_[3] = TcUtility.createArg(formName);
    args_[4] = TcUtility.createArg(formDesc);
    args_[5] = TcUtility.createArg(formType);
    args_[6] = TcUtility.createArg(keyUids);
    args_[7] = TcUtility.createArg(keyValues);
    args_[8] = TcUtility.createArg(propNames);
    args_[9] = TcUtility.createArg(propValues);
    args_[10] = TcUtility.createArg(keyFlags);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTObjectMapping", "createEintForm", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    newEintForm.value = TcUtility.queryArgStringUnion(response.output[0], newEintForm.value);
    typeUid.value = TcUtility.queryArgStringUnion(response.output[1], typeUid.value);
  }

}
