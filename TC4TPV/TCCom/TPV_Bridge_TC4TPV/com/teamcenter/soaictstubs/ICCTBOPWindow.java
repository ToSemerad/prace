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

public class ICCTBOPWindow extends ICCTBOMWindow {
  public ICCTBOPWindow(Connection connection) {
    super(connection);
  }

  public ICCTBOPWindow(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void configureProcessBasedonProduct(String window) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(window);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOPWindow", "configureProcessBasedonProduct", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void findRefUsageInWindow(String win_uid, String refAppr, uidSeq_tHolder lines, uidSeq_tHolder lineTypes) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(win_uid);
    args_[3] = TcUtility.createArg(refAppr);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOPWindow", "findRefUsageInWindow", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    lines.value = TcUtility.queryArg(response.output[0], lines.value);
    lineTypes.value = TcUtility.queryArg(response.output[1], lineTypes.value);
  }

  public void addControlOccType(String bopWindow, String occType) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(bopWindow);
    args_[3] = TcUtility.createArgStringUnion(occType);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOPWindow", "addControlOccType", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void removeControlOccType(String bopWindow, String occType) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(bopWindow);
    args_[3] = TcUtility.createArgStringUnion(occType);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOPWindow", "removeControlOccType", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void addReferenceWindow(String bopWindow, String window, String winName) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(bopWindow);
    args_[3] = TcUtility.createArg(window);
    args_[4] = TcUtility.createArgStringUnion(winName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOPWindow", "addReferenceWindow", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void removeReferenceWindow(String bopWindow, String winToRemove) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(bopWindow);
    args_[3] = TcUtility.createArg(winToRemove);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOPWindow", "removeReferenceWindow", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void showOrHideOccTypeFilter(String bopWindow, boolean isShown) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(bopWindow);
    args_[3] = TcUtility.createArg(isShown);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOPWindow", "showOrHideOccTypeFilter", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setOccTypeFilter(String bopWindow, String[] nameList) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(bopWindow);
    args_[3] = TcUtility.createArg(nameList);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOPWindow", "setOccTypeFilter", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getOccTypeFilter(String bopWindow, stringSeq_tHolder nameList) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(bopWindow);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOPWindow", "getOccTypeFilter", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    nameList.value = TcUtility.queryArg(response.output[0], nameList.value);
  }

  public void genrateIPATree(String bopWindow, String ipaName, String occGrpType, String[] selectedProcessTypes, String[] selectedConsumptionOcc, String attachmentName, boolean isLogFileNeeded, String[] ToReceivers, String[] CCReceivers, String MailSubject, String MailMessage, String EffectivityEndItem, String EffectivityEndRev, String EffUnitRange, String EffDateRange, StringHolder prdctWinAPR, StringHolder APRType) throws Exception {
    Arg[] args_ = new Arg[17];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(bopWindow);
    args_[3] = TcUtility.createArgStringUnion(ipaName);
    args_[4] = TcUtility.createArgStringUnion(occGrpType);
    args_[5] = TcUtility.createArg(selectedProcessTypes);
    args_[6] = TcUtility.createArg(selectedConsumptionOcc);
    args_[7] = TcUtility.createArgStringUnion(attachmentName);
    args_[8] = TcUtility.createArg(isLogFileNeeded);
    args_[9] = TcUtility.createArg(ToReceivers);
    args_[10] = TcUtility.createArg(CCReceivers);
    args_[11] = TcUtility.createArgStringUnion(MailSubject);
    args_[12] = TcUtility.createArgStringUnion(MailMessage);
    args_[13] = TcUtility.createArg(EffectivityEndItem);
    args_[14] = TcUtility.createArg(EffectivityEndRev);
    args_[15] = TcUtility.createArgStringUnion(EffUnitRange);
    args_[16] = TcUtility.createArgStringUnion(EffDateRange);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOPWindow", "genrateIPATree", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    prdctWinAPR.value = TcUtility.queryArg(response.output[0], prdctWinAPR.value);
    APRType.value = TcUtility.queryArg(response.output[1], APRType.value);
  }

  public void isIPAExists(String bopWindow, BooleanHolder isExists) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(bopWindow);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOPWindow", "isIPAExists", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    isExists.value = TcUtility.queryArg(response.output[0], isExists.value);
  }

  public void updateIPATree(String bopWindow) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(bopWindow);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOPWindow", "updateIPATree", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void isLogFileNeeded(String bopWindow, BooleanHolder isNeeded) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(bopWindow);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOPWindow", "isLogFileNeeded", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    isNeeded.value = TcUtility.queryArg(response.output[0], isNeeded.value);
  }

  public void localUpdate(String bopLine) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(bopLine);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOPWindow", "localUpdate", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void cleanIPATree(String bopWindow, StringHolder prdctWinAPR, StringHolder APRType) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(bopWindow);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOPWindow", "cleanIPATree", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    prdctWinAPR.value = TcUtility.queryArg(response.output[0], prdctWinAPR.value);
    APRType.value = TcUtility.queryArg(response.output[1], APRType.value);
  }

  public void showAssignedOccurrences(String window) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(window);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOPWindow", "showAssignedOccurrences", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void hideAssignedOccurrences(String window) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(window);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBOPWindow", "hideAssignedOccurrences", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

}
