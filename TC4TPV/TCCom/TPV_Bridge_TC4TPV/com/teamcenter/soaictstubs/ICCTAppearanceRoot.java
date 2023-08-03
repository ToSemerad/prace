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

public class ICCTAppearanceRoot extends ICCT {
  public ICCTAppearanceRoot(Connection connection) {
    super(connection);
  }

  public ICCTAppearanceRoot(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void create(String appearanceTrackedItemInfo, String appearanceConfigContext, StringHolder newAppearanceRoot, StringHolder newType) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(appearanceTrackedItemInfo);
    args_[3] = TcUtility.createArg(appearanceConfigContext);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAppearanceRoot", "create", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    newAppearanceRoot.value = TcUtility.queryArg(response.output[0], newAppearanceRoot.value);
    newType.value = TcUtility.queryArg(response.output[1], newType.value);
  }

  public void find(String trackedItem, String bomView, String appearanceConfigContext, uidSeq_tHolder foundAppearanceRoots, uidSeq_tHolder foundTypes) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(trackedItem);
    args_[3] = TcUtility.createArgStringUnion(bomView);
    args_[4] = TcUtility.createArgStringUnion(appearanceConfigContext);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAppearanceRoot", "find", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    foundAppearanceRoots.value = TcUtility.queryArg(response.output[0], foundAppearanceRoots.value);
    foundTypes.value = TcUtility.queryArg(response.output[1], foundTypes.value);
  }

  public void destroyEverything(String appearanceRoot) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(appearanceRoot);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAppearanceRoot", "destroyEverything", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

}
