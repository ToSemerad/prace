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

public class ICCTBomChange extends ICCT {
  public ICCTBomChange(Connection connection) {
    super(connection);
  }

  public ICCTBomChange(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void getOccurrence(String changeUid, StringHolder occUid, StringHolder type) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(changeUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBomChange", "getOccurrence", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    occUid.value = TcUtility.queryArg(response.output[0], occUid.value);
    type.value = TcUtility.queryArg(response.output[1], type.value);
  }

  public void getAffectedBvr(String changeUid, StringHolder bvrUid, StringHolder type) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(changeUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBomChange", "getAffectedBvr", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    bvrUid.value = TcUtility.queryArg(response.output[0], bvrUid.value);
    type.value = TcUtility.queryArg(response.output[1], type.value);
  }

  public void getECUid(String changeUid, StringHolder ecUid, StringHolder type) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(changeUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBomChange", "getECUid", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    ecUid.value = TcUtility.queryArg(response.output[0], ecUid.value);
    type.value = TcUtility.queryArg(response.output[1], type.value);
  }

  public void getChangeType(String changeUid, IntHolder changeType) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(changeUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBomChange", "getChangeType", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    changeType.value = TcUtility.queryArg(response.output[0], changeType.value);
  }

  public void getChangeCategory(String changeUid, IntHolder changeCateg) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(changeUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBomChange", "getChangeCategory", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    changeCateg.value = TcUtility.queryArg(response.output[0], changeCateg.value);
  }

  public void find(String occUid, uidSeqValue_uHolder componentUids, uidSeqValue_uHolder componentTypeUids) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(occUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBomChange", "find", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    componentUids.value = TcUtility.queryArg(response.output[0], componentUids.value);
    componentTypeUids.value = TcUtility.queryArg(response.output[1], componentTypeUids.value);
  }

  public void getWatchBoxProperties(String bcUid, stringValueSeq_tHolder propNames, stringValueSeq_tHolder propValues) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(bcUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBomChange", "getWatchBoxProperties", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    propNames.value = TcUtility.queryArgStringUnion(response.output[0], propNames.value);
    propValues.value = TcUtility.queryArgStringUnion(response.output[1], propValues.value);
  }

  public void getNoteChangeDetails(String noteChangeUid, NoteChangeInfo_sHolder details) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(noteChangeUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBomChange", "getNoteChangeDetails", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    details.value = TcUtility.queryArg(response.output[0], details.value);
  }

  public void getNoteChangeHistoryInfo(String bomLineUid, NoteChangeInfoSeq_tHolder details) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(bomLineUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBomChange", "getNoteChangeHistoryInfo", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    details.value = TcUtility.queryArg(response.output[0], details.value);
  }

  public void getVariantChangeDetails(String variantChangeUid, VariantChangeInfo_sHolder details) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(variantChangeUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBomChange", "getVariantChangeDetails", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    details.value = TcUtility.queryArg(response.output[0], details.value);
  }

  public void getVariantChangeHistoryInfo(String bomLineUid, VariantChangeInfoSeq_tHolder details) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(bomLineUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBomChange", "getVariantChangeHistoryInfo", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    details.value = TcUtility.queryArg(response.output[0], details.value);
  }

}
