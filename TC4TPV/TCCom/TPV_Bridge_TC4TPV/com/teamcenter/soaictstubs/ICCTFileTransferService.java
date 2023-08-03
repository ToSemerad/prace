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

public class ICCTFileTransferService {
  ICTService m_service;

  Connection m_connection;


  public ICCTFileTransferService(Connection connection) {
    m_service = ICTService.getService( connection );
    m_connection = connection;
  }

  public void generateNewFile(String serverDirectory, String serverFilename, String fileType, StringHolder newFileLocation) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(serverDirectory);
    args_[1] = TcUtility.createArg(serverFilename);
    args_[2] = TcUtility.createArg(fileType);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTFileTransferService", "generateNewFile", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    newFileLocation.value = TcUtility.queryArg(response.output[0], newFileLocation.value);
  }

  public void generateTempFile(String fileType, StringHolder newFileLocation) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(fileType);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTFileTransferService", "generateTempFile", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    newFileLocation.value = TcUtility.queryArg(response.output[0], newFileLocation.value);
  }

  public void removeTempFile(String fileFile) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(fileFile);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTFileTransferService", "removeTempFile", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void createTempSubDir(String parentDir, String subDir, StringHolder subDirPath) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(parentDir);
    args_[1] = TcUtility.createArg(subDir);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTFileTransferService", "createTempSubDir", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    subDirPath.value = TcUtility.queryArg(response.output[0], subDirPath.value);
  }

  public void copyFile(String src, String dest) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(src);
    args_[1] = TcUtility.createArg(dest);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTFileTransferService", "copyFile", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

}
