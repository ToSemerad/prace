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

public class ICCTWorkContext extends ICCT {
  public ICCTWorkContext(Connection connection) {
    super(connection);
  }

  public ICCTWorkContext(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void create(String name, String desc, String group, String role, String user, String project, boolean allowSubgroups, boolean settingModifiable, StringHolder componentUid, StringHolder componentTypeUid) throws Exception {
    Arg[] args_ = new Arg[10];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(name);
    args_[3] = TcUtility.createArgStringUnion(desc);
    args_[4] = TcUtility.createArgStringUnion(group);
    args_[5] = TcUtility.createArgStringUnion(role);
    args_[6] = TcUtility.createArgStringUnion(user);
    args_[7] = TcUtility.createArgStringUnion(project);
    args_[8] = TcUtility.createArg(allowSubgroups);
    args_[9] = TcUtility.createArg(settingModifiable);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTWorkContext", "create", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    componentUid.value = TcUtility.queryArg(response.output[0], componentUid.value);
    componentTypeUid.value = TcUtility.queryArg(response.output[1], componentTypeUid.value);
  }

}
