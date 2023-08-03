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

public class ICCTAppearanceTrackedItemInfo extends ICCT {
  public ICCTAppearanceTrackedItemInfo(Connection connection) {
    super(connection);
  }

  public ICCTAppearanceTrackedItemInfo(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void create(String trackedItem, String bomView, StringHolder newAppearanceTrackedItemInfo, StringHolder newType) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(trackedItem);
    args_[3] = TcUtility.createArg(bomView);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAppearanceTrackedItemInfo", "create", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    newAppearanceTrackedItemInfo.value = TcUtility.queryArg(response.output[0], newAppearanceTrackedItemInfo.value);
    newType.value = TcUtility.queryArg(response.output[1], newType.value);
  }

  public void find(String trackedItem, String bomView, uidSeq_tHolder foundAppearanceTrackedItemInfos, uidSeq_tHolder foundTypes) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(trackedItem);
    args_[3] = TcUtility.createArgStringUnion(bomView);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAppearanceTrackedItemInfo", "find", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    foundAppearanceTrackedItemInfos.value = TcUtility.queryArg(response.output[0], foundAppearanceTrackedItemInfos.value);
    foundTypes.value = TcUtility.queryArg(response.output[1], foundTypes.value);
  }

}
