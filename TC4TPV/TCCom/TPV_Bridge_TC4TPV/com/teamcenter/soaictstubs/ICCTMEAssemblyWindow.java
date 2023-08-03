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

public class ICCTMEAssemblyWindow extends ICCTMECfgWindow {
  public ICCTMEAssemblyWindow(Connection connection) {
    super(connection);
  }

  public ICCTMEAssemblyWindow(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void createAssyWindow(String revRule, String bomWin, StringHolder window, StringHolder type) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(revRule);
    args_[3] = TcUtility.createArgStringUnion(bomWin);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTMEAssemblyWindow", "createAssyWindow", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    window.value = TcUtility.queryArg(response.output[0], window.value);
    type.value = TcUtility.queryArg(response.output[1], type.value);
  }

  public void showVariantUnconfigured(String winUid, boolean show) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(winUid);
    args_[3] = TcUtility.createArg(show);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTMEAssemblyWindow", "showVariantUnconfigured", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void findLinesForAPNorAbsOcc(String win_uid, String key, boolean byAbsOccID, uidSeq_tHolder lines, uidSeq_tHolder lineTypes) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(win_uid);
    args_[3] = TcUtility.createArgStringUnion(key);
    args_[4] = TcUtility.createArg(byAbsOccID);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTMEAssemblyWindow", "findLinesForAPNorAbsOcc", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    lines.value = TcUtility.queryArg(response.output[0], lines.value);
    lineTypes.value = TcUtility.queryArg(response.output[1], lineTypes.value);
  }

  public void loadAllObjectsToWindowForAbsOccID(String win_uid, String ID, uidSeq_tHolder lines, uidSeq_tHolder lineTypes) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(win_uid);
    args_[3] = TcUtility.createArgStringUnion(ID);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTMEAssemblyWindow", "loadAllObjectsToWindowForAbsOccID", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    lines.value = TcUtility.queryArg(response.output[0], lines.value);
    lineTypes.value = TcUtility.queryArg(response.output[1], lineTypes.value);
  }

}
