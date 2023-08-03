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

public class ICCTAppearanceGroup extends ICCT {
  public ICCTAppearanceGroup(Connection connection) {
    super(connection);
  }

  public ICCTAppearanceGroup(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void createAppearanceGroup(String appRoot, String type, String name, String desc, StringHolder appGroupUid, StringHolder componentTypeUid) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(appRoot);
    args_[3] = TcUtility.createArgStringUnion(type);
    args_[4] = TcUtility.createArgStringUnion(name);
    args_[5] = TcUtility.createArgStringUnion(desc);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAppearanceGroup", "createAppearanceGroup", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    appGroupUid.value = TcUtility.queryArg(response.output[0], appGroupUid.value);
    componentTypeUid.value = TcUtility.queryArg(response.output[1], componentTypeUid.value);
  }

  public void createAppGroupForSearchCriteria(String appRoot, String inputSearchCriteriaUid, String type, String name, String desc, StringHolder appGroupUid, StringHolder componentTypeUid) throws Exception {
    Arg[] args_ = new Arg[7];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(appRoot);
    args_[3] = TcUtility.createArg(inputSearchCriteriaUid);
    args_[4] = TcUtility.createArgStringUnion(type);
    args_[5] = TcUtility.createArgStringUnion(name);
    args_[6] = TcUtility.createArgStringUnion(desc);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAppearanceGroup", "createAppGroupForSearchCriteria", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    appGroupUid.value = TcUtility.queryArg(response.output[0], appGroupUid.value);
    componentTypeUid.value = TcUtility.queryArg(response.output[1], componentTypeUid.value);
  }

  public void setSearchCriteria(String thisUid, String inputSearchCriteriaUid) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(thisUid);
    args_[3] = TcUtility.createArg(inputSearchCriteriaUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAppearanceGroup", "setSearchCriteria", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getSearchCriteria(String thisUid, StringHolder inputSearchCriteriaUid, StringHolder inputSearchCriteriaTypeUid) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(thisUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAppearanceGroup", "getSearchCriteria", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    inputSearchCriteriaUid.value = TcUtility.queryArgStringUnion(response.output[0], inputSearchCriteriaUid.value);
    inputSearchCriteriaTypeUid.value = TcUtility.queryArgStringUnion(response.output[1], inputSearchCriteriaTypeUid.value);
  }

  public void removeAppearance(String thisUid, String appUid) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(thisUid);
    args_[3] = TcUtility.createArg(appUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAppearanceGroup", "removeAppearance", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void removeAppGroup(String thisUid, String appGroupUid) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(thisUid);
    args_[3] = TcUtility.createArg(appGroupUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAppearanceGroup", "removeAppGroup", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void addAppearance(String thisUid, String appUid) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(thisUid);
    args_[3] = TcUtility.createArg(appUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAppearanceGroup", "addAppearance", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void addAppGroup(String thisUid, String appGroupUid) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(thisUid);
    args_[3] = TcUtility.createArg(appGroupUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAppearanceGroup", "addAppGroup", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

}
