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

public class ICCTReservationService {
  ICTService m_service;

  Connection m_connection;


  public ICCTReservationService(Connection connection) {
    m_service = ICTService.getService( connection );
    m_connection = connection;
  }

  public void reserve(String[] objectUids, String reason, String changeID, short reservationType) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(objectUids);
    args_[1] = TcUtility.createArgStringUnion(reason);
    args_[2] = TcUtility.createArgStringUnion(changeID);
    args_[3] = TcUtility.createArg(reservationType);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTReservationService", "reserve", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void exportReserve(String[] objectUids, String reason, String changeID, String clientHost, String exportPath, String[] tcFileUids, int[] modTimes) throws Exception {
    Arg[] args_ = new Arg[7];
    args_[0] = TcUtility.createArg(objectUids);
    args_[1] = TcUtility.createArgStringUnion(reason);
    args_[2] = TcUtility.createArgStringUnion(changeID);
    args_[3] = TcUtility.createArgStringUnion(clientHost);
    args_[4] = TcUtility.createArgStringUnion(exportPath);
    args_[5] = TcUtility.createArg(tcFileUids);
    args_[6] = TcUtility.createArg(modTimes);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTReservationService", "exportReserve", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void exportOnly(String[] objectUids, String reason, String changeID, String clientHost, String exportPath, String[] tcFileUids, int[] modTimes) throws Exception {
    Arg[] args_ = new Arg[7];
    args_[0] = TcUtility.createArg(objectUids);
    args_[1] = TcUtility.createArgStringUnion(reason);
    args_[2] = TcUtility.createArgStringUnion(changeID);
    args_[3] = TcUtility.createArgStringUnion(clientHost);
    args_[4] = TcUtility.createArgStringUnion(exportPath);
    args_[5] = TcUtility.createArg(tcFileUids);
    args_[6] = TcUtility.createArg(modTimes);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTReservationService", "exportOnly", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getExportFilesInfo(String objectUids, StringHolder dirName, stringSeqValue_uHolder fileNames, stringSeqValue_uHolder fileNamedRefs, stringSeqValue_uHolder fileRefFormats, longSeqValue_uHolder createdTimes) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(objectUids);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTReservationService", "getExportFilesInfo", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    dirName.value = TcUtility.queryArgStringUnion(response.output[0], dirName.value);
    fileNames.value = TcUtility.queryArg(response.output[1], fileNames.value);
    fileNamedRefs.value = TcUtility.queryArg(response.output[2], fileNamedRefs.value);
    fileRefFormats.value = TcUtility.queryArg(response.output[3], fileRefFormats.value);
    createdTimes.value = TcUtility.queryArg(response.output[4], createdTimes.value);
  }

  public void unReserve(String[] objectUids, boolean backgroundMode) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(objectUids);
    args_[1] = TcUtility.createArg(backgroundMode);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTReservationService", "unReserve", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void cancelReservation(String[] objectUids) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(objectUids);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTReservationService", "cancelReservation", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void transferReservation(String[] objectUids, String userUid) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(objectUids);
    args_[1] = TcUtility.createArg(userUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTReservationService", "transferReservation", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void addToNotifyList(String objectUid, String userUid) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(objectUid);
    args_[1] = TcUtility.createArg(userUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTReservationService", "addToNotifyList", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void removeFromNotifyList(String objectUid, String userUid) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(objectUid);
    args_[1] = TcUtility.createArg(userUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTReservationService", "removeFromNotifyList", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getNotificationList(String objectUid, uidSeqValue_uHolder userUids) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(objectUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTReservationService", "getNotificationList", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    userUids.value = TcUtility.queryArg(response.output[0], userUids.value);
  }

  public void getReservation(String objectUid, StringHolder reservationUid, StringHolder reservationTypeUid) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(objectUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTReservationService", "getReservation", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    reservationUid.value = TcUtility.queryArgStringUnion(response.output[0], reservationUid.value);
    reservationTypeUid.value = TcUtility.queryArgStringUnion(response.output[1], reservationTypeUid.value);
  }

  public void getReserved(String userUid, uidSeqValue_uHolder reservedObjects, uidSeqValue_uHolder reservedObjectsTypes) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(userUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTReservationService", "getReserved", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    reservedObjects.value = TcUtility.queryArg(response.output[0], reservedObjects.value);
    reservedObjectsTypes.value = TcUtility.queryArg(response.output[1], reservedObjectsTypes.value);
  }

  public void isReserved(String[] objectUids, booleanSeq_tHolder verdict) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(objectUids);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTReservationService", "isReserved", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    verdict.value = TcUtility.queryArg(response.output[0], verdict.value);
  }

  public void isReservedReplica(String[] objectUids, booleanSeq_tHolder verdict) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(objectUids);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTReservationService", "isReservedReplica", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    verdict.value = TcUtility.queryArg(response.output[0], verdict.value);
  }

  public void getCheckOutHistory(String objectUid, stringSeqValue_uHolder historyText) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(objectUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTReservationService", "getCheckOutHistory", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    historyText.value = TcUtility.queryArg(response.output[0], historyText.value);
  }

}
