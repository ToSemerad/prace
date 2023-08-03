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

public class ICCTAIEPersistentConnection extends ICCT {
  public ICCTAIEPersistentConnection(Connection connection) {
    super(connection);
  }

  public ICCTAIEPersistentConnection(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void createConn(String connName, String connDesc, String connRootDir, StringHolder newConn, StringHolder newConnType, StringHolder newConnDir) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(connName);
    args_[3] = TcUtility.createArgStringUnion(connDesc);
    args_[4] = TcUtility.createArg(connRootDir);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAIEPersistentConnection", "createConn", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    newConn.value = TcUtility.queryArg(response.output[0], newConn.value);
    newConnType.value = TcUtility.queryArg(response.output[1], newConnType.value);
    newConnDir.value = TcUtility.queryArgStringUnion(response.output[2], newConnDir.value);
  }

  public void destroyConn(String conn, boolean deleteDir) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(conn);
    args_[3] = TcUtility.createArg(deleteDir);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAIEPersistentConnection", "destroyConn", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void askLogFilePath(String conn, StringHolder logFilePath) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(conn);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAIEPersistentConnection", "askLogFilePath", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    logFilePath.value = TcUtility.queryArgStringUnion(response.output[0], logFilePath.value);
  }

}
