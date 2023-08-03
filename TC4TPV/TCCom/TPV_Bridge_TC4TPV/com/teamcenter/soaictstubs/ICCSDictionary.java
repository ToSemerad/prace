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

public class ICCSDictionary extends ICCSAdmin {
  public ICCSDictionary(Connection connection) {
    super(connection);
  }

  public ICCSDictionary(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void load(int attrId) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(attrId);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSDictionary", "load", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void create(int attrId) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(attrId);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSDictionary", "create", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void saveAs(int newAttrId) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(newAttrId);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSDictionary", "saveAs", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void rename(int newAttrId) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(newAttrId);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSDictionary", "rename", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void askDefinition(ICSAttr_sHolder definition, IntHolder siteCount, stringSeqValue_uHolder sharedSites) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSDictionary", "askDefinition", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    definition.value = TcUtility.queryArg(response.output[0], definition.value);
    siteCount.value = TcUtility.queryArg(response.output[1], siteCount.value);
    sharedSites.value = TcUtility.queryArg(response.output[2], sharedSites.value);
  }

  public void setDefinition(ICSAttr_s definition, int sharedSitesCount, stringSeqValue_u sharedSites) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(definition);
    args_[3] = TcUtility.createArg(sharedSitesCount);
    args_[4] = TcUtility.createArg(sharedSites);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSDictionary", "setDefinition", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getFreeId(IntHolder freeId) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSDictionary", "getFreeId", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    freeId.value = TcUtility.queryArg(response.output[0], freeId.value);
  }

}
