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

public class ICCTMEActivity extends ICCTFolder {
  public ICCTMEActivity(Connection connection) {
    super(connection);
  }

  public ICCTMEActivity(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void createMEActivity(String activityName, String activityType, String activityDesc, double activityTime, StringHolder activityUid, StringHolder componentTypeUid) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(activityName);
    args_[3] = TcUtility.createArgStringUnion(activityType);
    args_[4] = TcUtility.createArgStringUnion(activityDesc);
    args_[5] = TcUtility.createArg(activityTime);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTMEActivity", "createMEActivity", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    activityUid.value = TcUtility.queryArg(response.output[0], activityUid.value);
    componentTypeUid.value = TcUtility.queryArg(response.output[1], componentTypeUid.value);
  }

  public void createMEActivityWithList(String activityName, String activityType, String activityDesc, double activityTime, String[] activityPredList, StringHolder activityUid, StringHolder componentTypeUid) throws Exception {
    Arg[] args_ = new Arg[7];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(activityName);
    args_[3] = TcUtility.createArgStringUnion(activityType);
    args_[4] = TcUtility.createArgStringUnion(activityDesc);
    args_[5] = TcUtility.createArg(activityTime);
    args_[6] = TcUtility.createArg(activityPredList);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTMEActivity", "createMEActivityWithList", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    activityUid.value = TcUtility.queryArg(response.output[0], activityUid.value);
    componentTypeUid.value = TcUtility.queryArg(response.output[1], componentTypeUid.value);
  }

  public void addPredecessor(String succUid, String predUid) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(succUid);
    args_[3] = TcUtility.createArg(predUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTMEActivity", "addPredecessor", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void removePredecessor(String succUid, String predUid) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(succUid);
    args_[3] = TcUtility.createArg(predUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTMEActivity", "removePredecessor", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void listPredecessors(String succUid, uidSeq_tHolder activityPredList, uidSeq_tHolder componentList) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(succUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTMEActivity", "listPredecessors", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    activityPredList.value = TcUtility.queryArg(response.output[0], activityPredList.value);
    componentList.value = TcUtility.queryArg(response.output[1], componentList.value);
  }

  public void addTool(String actUid, String toolName, String resLineUid, String opLineUid) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(actUid);
    args_[3] = TcUtility.createArgStringUnion(toolName);
    args_[4] = TcUtility.createArg(resLineUid);
    args_[5] = TcUtility.createArg(opLineUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTMEActivity", "addTool", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void removeTool(String actUid, String toolName) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(actUid);
    args_[3] = TcUtility.createArgStringUnion(toolName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTMEActivity", "removeTool", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void listAllActivities(String actUid, uidSeq_tHolder actList, uidSeq_tHolder componentList) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(actUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTMEActivity", "listAllActivities", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    actList.value = TcUtility.queryArg(response.output[0], actList.value);
    componentList.value = TcUtility.queryArg(response.output[1], componentList.value);
  }

  public void getToolList(String actUid, stringSeq_tHolder toolList) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(actUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTMEActivity", "getToolList", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    toolList.value = TcUtility.queryArg(response.output[0], toolList.value);
  }

  public void getReferenceToolList(String actUid, String opLineUid, stringSeq_tHolder toolList) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(actUid);
    args_[3] = TcUtility.createArg(opLineUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTMEActivity", "getReferenceToolList", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    toolList.value = TcUtility.queryArg(response.output[0], toolList.value);
  }

  public void listSuccessors(String predUid, uidSeq_tHolder activitySuccList, uidSeq_tHolder componentList) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(predUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTMEActivity", "listSuccessors", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    activitySuccList.value = TcUtility.queryArg(response.output[0], activitySuccList.value);
    componentList.value = TcUtility.queryArg(response.output[1], componentList.value);
  }

  public void getResourceLines(String actUid, String opLineUid, uidSeq_tHolder toolList, uidSeq_tHolder componentList) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(actUid);
    args_[3] = TcUtility.createArg(opLineUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTMEActivity", "getResourceLines", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    toolList.value = TcUtility.queryArg(response.output[0], toolList.value);
    componentList.value = TcUtility.queryArg(response.output[1], componentList.value);
  }

  public void addResourceLines(String actUid, String[] resLineUid, String opLineUid) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(actUid);
    args_[3] = TcUtility.createArg(resLineUid);
    args_[4] = TcUtility.createArg(opLineUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTMEActivity", "addResourceLines", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void removeResourceLines(String actUid, String[] resLineUid) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(actUid);
    args_[3] = TcUtility.createArg(resLineUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTMEActivity", "removeResourceLines", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

}
