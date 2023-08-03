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

public class ICCTAssemblyArrangement extends ICCT {
  public ICCTAssemblyArrangement(Connection connection) {
    super(connection);
  }

  public ICCTAssemblyArrangement(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void create(String bvr, String arrName, String arrDesc, boolean isDefaultArrangement, StringHolder arragement) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(bvr);
    args_[3] = TcUtility.createArgStringUnion(arrName);
    args_[4] = TcUtility.createArgStringUnion(arrDesc);
    args_[5] = TcUtility.createArg(isDefaultArrangement);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAssemblyArrangement", "create", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    arragement.value = TcUtility.queryArg(response.output[0], arragement.value);
  }

  public void getParentBomViewRevision(StringHolder bvr) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAssemblyArrangement", "getParentBomViewRevision", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    bvr.value = TcUtility.queryArg(response.output[0], bvr.value);
  }

}
