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

public class ICCTFolder extends ICCT {
  public ICCTFolder(Connection connection) {
    super(connection);
  }

  public ICCTFolder(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void create(String name, String description, String type, StringHolder newFolder, StringHolder typeUid) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(name);
    args_[3] = TcUtility.createArgStringUnion(description);
    args_[4] = TcUtility.createArg(type);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTFolder", "create", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    newFolder.value = TcUtility.queryArg(response.output[0], newFolder.value);
    typeUid.value = TcUtility.queryArg(response.output[1], typeUid.value);
  }

  public void saveAs(String folderUid, String name, StringHolder newFolderUid) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(folderUid);
    args_[3] = TcUtility.createArgStringUnion(name);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTFolder", "saveAs", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    newFolderUid.value = TcUtility.queryArg(response.output[0], newFolderUid.value);
  }

  public void getTypes(uidSeqValue_uHolder folderTypeUids, uidSeqValue_uHolder typeUids) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTFolder", "getTypes", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    folderTypeUids.value = TcUtility.queryArg(response.output[0], folderTypeUids.value);
    typeUids.value = TcUtility.queryArg(response.output[1], typeUids.value);
  }

  public void moveUp(String comp, String[] componentsToMove) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(comp);
    args_[3] = TcUtility.createArg(componentsToMove);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTFolder", "moveUp", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void moveDown(String comp, String[] componentsToMove) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(comp);
    args_[3] = TcUtility.createArg(componentsToMove);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTFolder", "moveDown", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void moveTop(String comp, String[] componentsToMove) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(comp);
    args_[3] = TcUtility.createArg(componentsToMove);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTFolder", "moveTop", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void moveBottom(String components, String[] componentsToMove) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(components);
    args_[3] = TcUtility.createArg(componentsToMove);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTFolder", "moveBottom", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

}
