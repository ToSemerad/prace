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

public class ICCTBOPLine extends ICCTBOMLine {
  public ICCTBOPLine(Connection connection) {
    super(connection);
  }

  public ICCTBOPLine(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void addAppearanceGroup(String bomline, boolean asSubstitute, String occType, String appgroup, StringHolder newLine, StringHolder typeUid) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(bomline);
    args_[3] = TcUtility.createArg(asSubstitute);
    args_[4] = TcUtility.createArgStringUnion(occType);
    args_[5] = TcUtility.createArg(appgroup);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOPLine", "addAppearanceGroup", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    newLine.value = TcUtility.queryArg(response.output[0], newLine.value);
    typeUid.value = TcUtility.queryArg(response.output[1], typeUid.value);
  }

  public void createAssemblyTree(String bopline, boolean onOperation, boolean updateOnly, String viewObj) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(bopline);
    args_[3] = TcUtility.createArg(onOperation);
    args_[4] = TcUtility.createArg(updateOnly);
    args_[5] = TcUtility.createArgStringUnion(viewObj);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOPLine", "createAssemblyTree", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void updateWorkpiece(String bopline, boolean selfOnly) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(bopline);
    args_[3] = TcUtility.createArg(selfOnly);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOPLine", "updateWorkpiece", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void reSequenceProcess(String bopline, int startNum, int incrNum) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(bopline);
    args_[3] = TcUtility.createArg(startNum);
    args_[4] = TcUtility.createArg(incrNum);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOPLine", "reSequenceProcess", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void askActiveRefWindowName(String bopline, StringHolder windowName) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(bopline);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOPLine", "askActiveRefWindowName", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    windowName.value = TcUtility.queryArgStringUnion(response.output[0], windowName.value);
  }

  public void askRefWindowName(String bopline, int winNum, StringHolder windowName) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(bopline);
    args_[3] = TcUtility.createArg(winNum);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOPLine", "askRefWindowName", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    windowName.value = TcUtility.queryArgStringUnion(response.output[0], windowName.value);
  }

  public void askNumRefWindows(String bopline, IntHolder windowCount) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(bopline);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOPLine", "askNumRefWindows", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    windowCount.value = TcUtility.queryArg(response.output[0], windowCount.value);
  }

  public void setRefWindowActive(String bopline, int windowNumber) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(bopline);
    args_[3] = TcUtility.createArg(windowNumber);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOPLine", "setRefWindowActive", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void switchOccGrpViewMode(String bopline, boolean viewModeInBase) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(bopline);
    args_[3] = TcUtility.createArg(viewModeInBase);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOPLine", "switchOccGrpViewMode", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

}
