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

public class ICCTTcId extends ICCT {
  public ICCTTcId(Connection connection) {
    super(connection);
  }

  public ICCTTcId(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void create(int numberOfDigits, StringHolder tcid_uid, StringHolder tcid_type_uid) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(numberOfDigits);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTcId", "create", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    tcid_uid.value = TcUtility.queryArg(response.output[0], tcid_uid.value);
    tcid_type_uid.value = TcUtility.queryArg(response.output[1], tcid_type_uid.value);
  }

  public void addSequence(String tcid_uid, String digSeq, String start, int type) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(tcid_uid);
    args_[3] = TcUtility.createArg(digSeq);
    args_[4] = TcUtility.createArg(start);
    args_[5] = TcUtility.createArg(type);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTcId", "addSequence", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void numberOfSequences(String tcid_uid, IntHolder nSequences) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(tcid_uid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTcId", "numberOfSequences", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    nSequences.value = TcUtility.queryArg(response.output[0], nSequences.value);
  }

  public void getNextValue(String tcid_uid, StringHolder nextValue) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(tcid_uid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTcId", "getNextValue", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    nextValue.value = TcUtility.queryArgStringUnion(response.output[0], nextValue.value);
  }

  public void getSucceedingValue(String tcid_uid, String value, StringHolder newValue) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(tcid_uid);
    args_[3] = TcUtility.createArg(value);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTcId", "getSucceedingValue", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    newValue.value = TcUtility.queryArgStringUnion(response.output[0], newValue.value);
  }

  public void getInitialValue(String tcid_uid, StringHolder initialValue) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(tcid_uid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTcId", "getInitialValue", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    initialValue.value = TcUtility.queryArgStringUnion(response.output[0], initialValue.value);
  }

  public void askSequence(String tcid_uid, int index, StringHolder digSeq, StringHolder start, IntHolder type) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(tcid_uid);
    args_[3] = TcUtility.createArg(index);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTcId", "askSequence", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    digSeq.value = TcUtility.queryArgStringUnion(response.output[0], digSeq.value);
    start.value = TcUtility.queryArgStringUnion(response.output[1], start.value);
    type.value = TcUtility.queryArg(response.output[2], type.value);
  }

  public void clearAll(String tcid_uid) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(tcid_uid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTcId", "clearAll", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setDig(String tcid_uid, int newVal) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(tcid_uid);
    args_[3] = TcUtility.createArg(newVal);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTcId", "setDig", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

}
