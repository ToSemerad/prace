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

public class ICCTIdentifier extends ICCT {
  public ICCTIdentifier(Connection connection) {
    super(connection);
  }

  public ICCTIdentifier(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void createAliasIdentifier(String identifierType, StringHolder newAliasIdentifier, StringHolder identifierAliasType) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(identifierType);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTIdentifier", "createAliasIdentifier", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    newAliasIdentifier.value = TcUtility.queryArg(response.output[0], newAliasIdentifier.value);
    identifierAliasType.value = TcUtility.queryArg(response.output[1], identifierAliasType.value);
  }

  public void createAltIdentifier(String identifierType, String idfbl, String idfblRev, String idContext, StringHolder newAltIdentifier, StringHolder identifierAltType, StringHolder newAltRevIdentifier, StringHolder identifierAltRevType) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(identifierType);
    args_[3] = TcUtility.createArgStringUnion(idfbl);
    args_[4] = TcUtility.createArgStringUnion(idfblRev);
    args_[5] = TcUtility.createArgStringUnion(idContext);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTIdentifier", "createAltIdentifier", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    newAltIdentifier.value = TcUtility.queryArg(response.output[0], newAltIdentifier.value);
    identifierAltType.value = TcUtility.queryArg(response.output[1], identifierAltType.value);
    newAltRevIdentifier.value = TcUtility.queryArg(response.output[2], newAltRevIdentifier.value);
    identifierAltRevType.value = TcUtility.queryArg(response.output[3], identifierAltRevType.value);
  }

  public void createAltRevIdentifier(String identifierAltRev, String idfblRev, StringHolder newAltRevIdentifier, StringHolder identifierAltRevType) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(identifierAltRev);
    args_[3] = TcUtility.createArgStringUnion(idfblRev);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTIdentifier", "createAltRevIdentifier", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    newAltRevIdentifier.value = TcUtility.queryArg(response.output[0], newAltRevIdentifier.value);
    identifierAltRevType.value = TcUtility.queryArg(response.output[1], identifierAltRevType.value);
  }

  public void getNewAltId(String idContext, String identifierType, StringHolder newAltId) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(idContext);
    args_[3] = TcUtility.createArgStringUnion(identifierType);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTIdentifier", "getNewAltId", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    newAltId.value = TcUtility.queryArgStringUnion(response.output[0], newAltId.value);
  }

  public void getNewAltIds(String idContext, String identifierType, StringHolder newAltId, StringHolder newAltRevId) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(idContext);
    args_[3] = TcUtility.createArgStringUnion(identifierType);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTIdentifier", "getNewAltIds", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    newAltId.value = TcUtility.queryArgStringUnion(response.output[0], newAltId.value);
    newAltRevId.value = TcUtility.queryArgStringUnion(response.output[1], newAltRevId.value);
  }

  public void getNewAltRevId(String identifierRev, StringHolder newAltRevId) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(identifierRev);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTIdentifier", "getNewAltRevId", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    newAltRevId.value = TcUtility.queryArgStringUnion(response.output[0], newAltRevId.value);
  }

}
