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

public class ICCTGDE extends ICCTForm {
  public ICCTGDE(Connection connection) {
    super(connection);
  }

  public ICCTGDE(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void createGDE(String name, String description, String type, StringHolder gde, StringHolder gdeType) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(name);
    args_[3] = TcUtility.createArgStringUnion(description);
    args_[4] = TcUtility.createArg(type);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTGDE", "createGDE", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    gde.value = TcUtility.queryArg(response.output[0], gde.value);
    gdeType.value = TcUtility.queryArg(response.output[1], gdeType.value);
  }

  public void getGDETypes(uidSeqValue_uHolder gdeTypes, uidSeqValue_uHolder types) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTGDE", "getGDETypes", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    gdeTypes.value = TcUtility.queryArg(response.output[0], gdeTypes.value);
    types.value = TcUtility.queryArg(response.output[1], types.value);
  }

  public void createGDEType(String typeName, String className, int cardinality, String[] allowableViewTypes, StringHolder gdeType, StringHolder typeType) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(typeName);
    args_[3] = TcUtility.createArgStringUnion(className);
    args_[4] = TcUtility.createArg(cardinality);
    args_[5] = TcUtility.createArg(allowableViewTypes);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTGDE", "createGDEType", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    gdeType.value = TcUtility.queryArg(response.output[0], gdeType.value);
    typeType.value = TcUtility.queryArg(response.output[1], typeType.value);
  }

  public void removeGDEType(String gdeType) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(gdeType);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTGDE", "removeGDEType", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

}
