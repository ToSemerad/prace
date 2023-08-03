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

public class ICCTAppInterface extends ICCT {
  public ICCTAppInterface(Connection connection) {
    super(connection);
  }

  public ICCTAppInterface(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void create(String name, String type, String desc, StringHolder compTag, StringHolder componentTypeTag) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(name);
    args_[3] = TcUtility.createArgStringUnion(type);
    args_[4] = TcUtility.createArgStringUnion(desc);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAppInterface", "create", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    compTag.value = TcUtility.queryArg(response.output[0], compTag.value);
    componentTypeTag.value = TcUtility.queryArg(response.output[1], componentTypeTag.value);
  }

  public void setTransferMode(String thisTag, String tmTag, short tmType) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(thisTag);
    args_[3] = TcUtility.createArg(tmTag);
    args_[4] = TcUtility.createArg(tmType);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAppInterface", "setTransferMode", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void exportObjects(String ai, String[] exportObjectUids, boolean partial, boolean incrementalUpdate) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(ai);
    args_[3] = TcUtility.createArg(exportObjectUids);
    args_[4] = TcUtility.createArg(partial);
    args_[5] = TcUtility.createArg(incrementalUpdate);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAppInterface", "exportObjects", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void createSyncRequest(String ai, String name, String desc, StringHolder req) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(ai);
    args_[3] = TcUtility.createArgStringUnion(name);
    args_[4] = TcUtility.createArgStringUnion(desc);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAppInterface", "createSyncRequest", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    req.value = TcUtility.queryArg(response.output[0], req.value);
  }

  public void createPublishRequest(String ai, String name, String desc, String fileName, StringHolder req) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(ai);
    args_[3] = TcUtility.createArgStringUnion(name);
    args_[4] = TcUtility.createArgStringUnion(desc);
    args_[5] = TcUtility.createArgStringUnion(fileName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAppInterface", "createPublishRequest", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    req.value = TcUtility.queryArg(response.output[0], req.value);
  }

  public void deleteRequest(String ai, String req) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(ai);
    args_[3] = TcUtility.createArg(req);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAppInterface", "deleteRequest", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void refreshImportCache(String ai) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(ai);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAppInterface", "refreshImportCache", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void generatePortfolio(String ai, String[] selectedObjectUids, String transferMode, String portfolioDataset, boolean isTemplate) throws Exception {
    Arg[] args_ = new Arg[7];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(ai);
    args_[3] = TcUtility.createArg(selectedObjectUids);
    args_[4] = TcUtility.createArgStringUnion(transferMode);
    args_[5] = TcUtility.createArg(portfolioDataset);
    args_[6] = TcUtility.createArg(isTemplate);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAppInterface", "generatePortfolio", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void updatePortfolio(String ai, String portfolioDataset, boolean isTemplate) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(ai);
    args_[3] = TcUtility.createArg(portfolioDataset);
    args_[4] = TcUtility.createArg(isTemplate);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAppInterface", "updatePortfolio", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getPortfolioChildPages(String ai, String portfolioDataset, uidSeq_tHolder childPages) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(ai);
    args_[3] = TcUtility.createArg(portfolioDataset);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAppInterface", "getPortfolioChildPages", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    childPages.value = TcUtility.queryArg(response.output[0], childPages.value);
  }

}
