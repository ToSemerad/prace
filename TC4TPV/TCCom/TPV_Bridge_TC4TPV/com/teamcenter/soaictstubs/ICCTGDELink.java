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

public class ICCTGDELink extends ICCTGDE {
  public ICCTGDELink(Connection connection) {
    super(connection);
  }

  public ICCTGDELink(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void createGDELink(String name, String description, String type, StringHolder gdelinkUid, StringHolder gdelinkTypeUid) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(name);
    args_[3] = TcUtility.createArgStringUnion(description);
    args_[4] = TcUtility.createArg(type);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTGDELink", "createGDELink", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    gdelinkUid.value = TcUtility.queryArg(response.output[0], gdelinkUid.value);
    gdelinkTypeUid.value = TcUtility.queryArg(response.output[1], gdelinkTypeUid.value);
  }

  public void getGDELinkTypes(uidSeqValue_uHolder gdelinkTypeUids, uidSeqValue_uHolder typeUids) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTGDELink", "getGDELinkTypes", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    gdelinkTypeUids.value = TcUtility.queryArg(response.output[0], gdelinkTypeUids.value);
    typeUids.value = TcUtility.queryArg(response.output[1], typeUids.value);
  }

  public void createGDELinkType(String typeName, String className, StringHolder gdelinkTypeUid, StringHolder typeTypeUid) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(typeName);
    args_[3] = TcUtility.createArgStringUnion(className);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTGDELink", "createGDELinkType", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    gdelinkTypeUid.value = TcUtility.queryArg(response.output[0], gdelinkTypeUid.value);
    typeTypeUid.value = TcUtility.queryArg(response.output[1], typeTypeUid.value);
  }

  public void removeGDELinkType(String gdelinkTypeUid) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(gdelinkTypeUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTGDELink", "removeGDELinkType", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

}
