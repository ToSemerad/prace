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

public class ICCTSubscriptionActionHandler extends ICCT {
  public ICCTSubscriptionActionHandler(Connection connection) {
    super(connection);
  }

  public ICCTSubscriptionActionHandler(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void create(String theHandlerId, String theFunctionName, int theFunctionType, int theHandlerExecMode, String theHandlerDesc, String[] theParamDesc, int theRetryCount, boolean overrideFlag, String theExecutionTime, int theRetryInterval, StringHolder actionUid, StringHolder actionTypeUid) throws Exception {
    Arg[] args_ = new Arg[12];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(theHandlerId);
    args_[3] = TcUtility.createArg(theFunctionName);
    args_[4] = TcUtility.createArg(theFunctionType);
    args_[5] = TcUtility.createArg(theHandlerExecMode);
    args_[6] = TcUtility.createArgStringUnion(theHandlerDesc);
    args_[7] = TcUtility.createArgStringUnion(theParamDesc);
    args_[8] = TcUtility.createArg(theRetryCount);
    args_[9] = TcUtility.createArg(overrideFlag);
    args_[10] = TcUtility.createArgStringUnion(theExecutionTime);
    args_[11] = TcUtility.createArg(theRetryInterval);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSubscriptionActionHandler", "create", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    actionUid.value = TcUtility.queryArg(response.output[0], actionUid.value);
    actionTypeUid.value = TcUtility.queryArg(response.output[1], actionTypeUid.value);
  }

  public void setHandlerId(String actionUid, String id) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(actionUid);
    args_[3] = TcUtility.createArg(id);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSubscriptionActionHandler", "setHandlerId", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void askHandlerId(String actionUid, StringHolder id) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(actionUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSubscriptionActionHandler", "askHandlerId", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    id.value = TcUtility.queryArg(response.output[0], id.value);
  }

  public void setHandlerStaticArgs(String actionUid, String[] args) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(actionUid);
    args_[3] = TcUtility.createArgStringUnion(args);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSubscriptionActionHandler", "setHandlerStaticArgs", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void askHandlerStaticArgs(String actionUid, stringValueSeq_tHolder args) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(actionUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSubscriptionActionHandler", "askHandlerStaticArgs", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    args.value = TcUtility.queryArgStringUnion(response.output[0], args.value);
  }

  public void setHandlerDescription(String actionUid, String desc) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(actionUid);
    args_[3] = TcUtility.createArgStringUnion(desc);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSubscriptionActionHandler", "setHandlerDescription", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void askHandlerDescription(String actionUid, StringHolder desc) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(actionUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSubscriptionActionHandler", "askHandlerDescription", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    desc.value = TcUtility.queryArgStringUnion(response.output[0], desc.value);
  }

  public void setRetryCount(String actionUid, int count) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(actionUid);
    args_[3] = TcUtility.createArg(count);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSubscriptionActionHandler", "setRetryCount", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void askRetryCount(String actionUid, IntHolder count) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(actionUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSubscriptionActionHandler", "askRetryCount", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    count.value = TcUtility.queryArg(response.output[0], count.value);
  }

  public void setExecutionTime(String actionUid, String exeTime) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(actionUid);
    args_[3] = TcUtility.createArgStringUnion(exeTime);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSubscriptionActionHandler", "setExecutionTime", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void askExecutionTime(String actionUid, StringHolder exeTime) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(actionUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSubscriptionActionHandler", "askExecutionTime", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    exeTime.value = TcUtility.queryArgStringUnion(response.output[0], exeTime.value);
  }

  public void setRetryInterval(String actionUid, int exeTime) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(actionUid);
    args_[3] = TcUtility.createArg(exeTime);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSubscriptionActionHandler", "setRetryInterval", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void askRetryInterval(String actionUid, IntHolder exeTime) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(actionUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSubscriptionActionHandler", "askRetryInterval", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    exeTime.value = TcUtility.queryArg(response.output[0], exeTime.value);
  }

  public void setFunctionName(String actionUid, String fName) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(actionUid);
    args_[3] = TcUtility.createArg(fName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSubscriptionActionHandler", "setFunctionName", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void askFunctionName(String actionUid, StringHolder fName) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(actionUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSubscriptionActionHandler", "askFunctionName", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    fName.value = TcUtility.queryArg(response.output[0], fName.value);
  }

  public void setFunctionType(String actionUid, int fType) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(actionUid);
    args_[3] = TcUtility.createArg(fType);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSubscriptionActionHandler", "setFunctionType", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void askFunctionType(String actionUid, IntHolder fType) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(actionUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSubscriptionActionHandler", "askFunctionType", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    fType.value = TcUtility.queryArg(response.output[0], fType.value);
  }

  public void setHandlerExecutionMode(String actionUid, int mode) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(actionUid);
    args_[3] = TcUtility.createArg(mode);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSubscriptionActionHandler", "setHandlerExecutionMode", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void askHandlerExecutionMode(String actionUid, IntHolder mode) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(actionUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSubscriptionActionHandler", "askHandlerExecutionMode", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    mode.value = TcUtility.queryArg(response.output[0], mode.value);
  }

  public void setOverrideFlag(String actionUid, boolean override) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(actionUid);
    args_[3] = TcUtility.createArg(override);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSubscriptionActionHandler", "setOverrideFlag", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void askOverrideFlag(String actionUid, BooleanHolder override) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(actionUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSubscriptionActionHandler", "askOverrideFlag", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    override.value = TcUtility.queryArg(response.output[0], override.value);
  }

  public void find(String handlerId, StringHolder handlerUid, StringHolder handlerTypeUid) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(handlerId);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSubscriptionActionHandler", "find", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    handlerUid.value = TcUtility.queryArgStringUnion(response.output[0], handlerUid.value);
    handlerTypeUid.value = TcUtility.queryArgStringUnion(response.output[1], handlerTypeUid.value);
  }

}
