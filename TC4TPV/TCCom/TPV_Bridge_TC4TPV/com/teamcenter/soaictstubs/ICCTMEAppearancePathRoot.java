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

public class ICCTMEAppearancePathRoot extends ICCT {
  public ICCTMEAppearancePathRoot(Connection connection) {
    super(connection);
  }

  public ICCTMEAppearancePathRoot(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void getMEAppearancePathRoot(String itemUid, String bvUid, StringHolder pathRootUid, StringHolder componentTypeUid) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(itemUid);
    args_[3] = TcUtility.createArg(bvUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTMEAppearancePathRoot", "getMEAppearancePathRoot", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    pathRootUid.value = TcUtility.queryArg(response.output[0], pathRootUid.value);
    componentTypeUid.value = TcUtility.queryArg(response.output[1], componentTypeUid.value);
  }

  public void findOrCreatePathRoot(String apprRootUid, StringHolder pathRootUid, StringHolder componentTypeUid) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(apprRootUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTMEAppearancePathRoot", "findOrCreatePathRoot", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    pathRootUid.value = TcUtility.queryArg(response.output[0], pathRootUid.value);
    componentTypeUid.value = TcUtility.queryArg(response.output[1], componentTypeUid.value);
  }

  public void findOrCreatePathRootFromEndItem(String itemUid, String bvUid, StringHolder pathRootUid, StringHolder componentTypeUid) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(itemUid);
    args_[3] = TcUtility.createArg(bvUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTMEAppearancePathRoot", "findOrCreatePathRootFromEndItem", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    pathRootUid.value = TcUtility.queryArg(response.output[0], pathRootUid.value);
    componentTypeUid.value = TcUtility.queryArg(response.output[1], componentTypeUid.value);
  }

}
