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

public class ICCTPublicationService {
  ICTService m_service;

  Connection m_connection;


  public ICCTPublicationService(Connection connection) {
    m_service = ICTService.getService( connection );
    m_connection = connection;
  }

  public void publish(int siteID, String[] objectUids) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(siteID);
    args_[1] = TcUtility.createArg(objectUids);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPublicationService", "publish", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void unpublish(int siteID, String[] objectUid) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(siteID);
    args_[1] = TcUtility.createArg(objectUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPublicationService", "unpublish", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getPublicationRecord(int siteId, String objectUid, StringHolder publicationRecord, StringHolder publicationRecordTypes) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(siteId);
    args_[1] = TcUtility.createArg(objectUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPublicationService", "getPublicationRecord", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    publicationRecord.value = TcUtility.queryArgStringUnion(response.output[0], publicationRecord.value);
    publicationRecordTypes.value = TcUtility.queryArgStringUnion(response.output[1], publicationRecordTypes.value);
  }

  public void getUnpublished(String objectUid, StringHolder descriptionObjuid, StringHolder descriptionObjType) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(objectUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPublicationService", "getUnpublished", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    descriptionObjuid.value = TcUtility.queryArgStringUnion(response.output[0], descriptionObjuid.value);
    descriptionObjType.value = TcUtility.queryArgStringUnion(response.output[1], descriptionObjType.value);
  }

  public void registerItemId(stringSeqValue_u itemIdStr_seq) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(itemIdStr_seq);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPublicationService", "registerItemId", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void unregisterItemId(stringSeqValue_u itemIdStr_seq) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(itemIdStr_seq);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPublicationService", "unregisterItemId", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

}
