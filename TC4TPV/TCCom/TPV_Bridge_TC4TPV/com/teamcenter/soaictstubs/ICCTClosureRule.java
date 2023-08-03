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

public class ICCTClosureRule extends ICCT {
  public ICCTClosureRule(Connection connection) {
    super(connection);
  }

  public ICCTClosureRule(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void create(String name, String type, String desc, StringHolder comp, StringHolder componentType) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(name);
    args_[3] = TcUtility.createArgStringUnion(type);
    args_[4] = TcUtility.createArgStringUnion(desc);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTClosureRule", "create", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    comp.value = TcUtility.queryArg(response.output[0], comp.value);
    componentType.value = TcUtility.queryArg(response.output[1], componentType.value);
  }

  public void addRule(String thisUid, String appTag) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(thisUid);
    args_[3] = TcUtility.createArg(appTag);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTClosureRule", "addRule", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void removeRule(String thisUid, String appTag) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(thisUid);
    args_[3] = TcUtility.createArg(appTag);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTClosureRule", "removeRule", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

}
