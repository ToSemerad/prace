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

public class ICCTEnvelope extends ICCTFolder {
  public ICCTEnvelope(Connection connection) {
    super(connection);
  }

  public ICCTEnvelope(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void createEnvelope(String envelopeName, String envelopeComments, StringHolder envelopeUid, StringHolder envelopeUidType) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(envelopeName);
    args_[3] = TcUtility.createArgStringUnion(envelopeComments);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTEnvelope", "createEnvelope", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    envelopeUid.value = TcUtility.queryArg(response.output[0], envelopeUid.value);
    envelopeUidType.value = TcUtility.queryArg(response.output[1], envelopeUidType.value);
  }

  public void send(String envelopeUid) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(envelopeUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTEnvelope", "send", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void addReceivers(String envelopeUid, String[] receivers) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(envelopeUid);
    args_[3] = TcUtility.createArg(receivers);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTEnvelope", "addReceivers", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void addAttachments(String envelopeUid, String[] attachmentsToAdd) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(envelopeUid);
    args_[3] = TcUtility.createArg(attachmentsToAdd);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTEnvelope", "addAttachments", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void removeAttachments(String envelopeUid, String[] attachmentsToRemove) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(envelopeUid);
    args_[3] = TcUtility.createArg(attachmentsToRemove);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTEnvelope", "removeAttachments", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void addExternalReceiver(String envelopeUid, boolean[] isCC, String[] receiver) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(envelopeUid);
    args_[3] = TcUtility.createArg(isCC);
    args_[4] = TcUtility.createArg(receiver);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTEnvelope", "addExternalReceiver", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

}
