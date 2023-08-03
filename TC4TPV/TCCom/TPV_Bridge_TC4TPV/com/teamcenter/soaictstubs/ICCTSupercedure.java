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

public class ICCTSupercedure extends ICCT {
  public ICCTSupercedure(Connection connection) {
    super(connection);
  }

  public ICCTSupercedure(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void getAffectedBvr(String supUid, StringHolder bvrUid, StringHolder type) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(supUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSupercedure", "getAffectedBvr", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    bvrUid.value = TcUtility.queryArg(response.output[0], bvrUid.value);
    type.value = TcUtility.queryArg(response.output[1], type.value);
  }

  public void getBomAdds(String supUid, uidSeqValue_uHolder bomAdds, uidSeqValue_uHolder typeUids) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(supUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSupercedure", "getBomAdds", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    bomAdds.value = TcUtility.queryArg(response.output[0], bomAdds.value);
    typeUids.value = TcUtility.queryArg(response.output[1], typeUids.value);
  }

  public void getBomLineAdds(String supUid, uidSeqValue_uHolder bomLineAdds, uidSeqValue_uHolder typeUids) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(supUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSupercedure", "getBomLineAdds", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    bomLineAdds.value = TcUtility.queryArg(response.output[0], bomLineAdds.value);
    typeUids.value = TcUtility.queryArg(response.output[1], typeUids.value);
  }

  public void getBomCancels(String supUid, uidSeqValue_uHolder bomCancels, uidSeqValue_uHolder typeUids) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(supUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSupercedure", "getBomCancels", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    bomCancels.value = TcUtility.queryArg(response.output[0], bomCancels.value);
    typeUids.value = TcUtility.queryArg(response.output[1], typeUids.value);
  }

  public void getBomLineCancels(String supUid, uidSeqValue_uHolder bomLineCancels, uidSeqValue_uHolder typeUids) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(supUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSupercedure", "getBomLineCancels", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    bomLineCancels.value = TcUtility.queryArg(response.output[0], bomLineCancels.value);
    typeUids.value = TcUtility.queryArg(response.output[1], typeUids.value);
  }

  public void getWatchBoxProperties(String supUid, stringValueSeq_tHolder propNames, stringValueSeq_tHolder propValues) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(supUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSupercedure", "getWatchBoxProperties", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    propNames.value = TcUtility.queryArgStringUnion(response.output[0], propNames.value);
    propValues.value = TcUtility.queryArgStringUnion(response.output[1], propValues.value);
  }

  public void isTransfer(String supUid, BooleanHolder isTrans) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(supUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSupercedure", "isTransfer", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    isTrans.value = TcUtility.queryArg(response.output[0], isTrans.value);
  }

  public void isAdd(String supUid, String lineUid, BooleanHolder isAdded) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(supUid);
    args_[3] = TcUtility.createArg(lineUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSupercedure", "isAdd", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    isAdded.value = TcUtility.queryArg(response.output[0], isAdded.value);
  }

  public void isCancel(String supUid, String lineUid, BooleanHolder isCanceled) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(supUid);
    args_[3] = TcUtility.createArg(lineUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSupercedure", "isCancel", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    isCanceled.value = TcUtility.queryArg(response.output[0], isCanceled.value);
  }

  public void findAll(String bvrUid, uidSeqValue_uHolder supUids, uidSeqValue_uHolder typeUids) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(bvrUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSupercedure", "findAll", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    supUids.value = TcUtility.queryArg(response.output[0], supUids.value);
    typeUids.value = TcUtility.queryArg(response.output[1], typeUids.value);
  }

  public void find(String bcUid, StringHolder supUid, StringHolder type) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(bcUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSupercedure", "find", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    supUid.value = TcUtility.queryArg(response.output[0], supUid.value);
    type.value = TcUtility.queryArg(response.output[1], type.value);
  }

  public void create(String bvrUid, boolean isTrans, String[] adds, String[] cancels, StringHolder supUid, StringHolder type) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(bvrUid);
    args_[3] = TcUtility.createArg(isTrans);
    args_[4] = TcUtility.createArg(adds);
    args_[5] = TcUtility.createArg(cancels);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSupercedure", "create", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    supUid.value = TcUtility.queryArg(response.output[0], supUid.value);
    type.value = TcUtility.queryArg(response.output[1], type.value);
  }

  public void appendAdd(String supUid, String addUid) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(supUid);
    args_[3] = TcUtility.createArg(addUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSupercedure", "appendAdd", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void appendCancel(String supUid, String cancelUid) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(supUid);
    args_[3] = TcUtility.createArg(cancelUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSupercedure", "appendCancel", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void removeAdd(String supUid, String addUid) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(supUid);
    args_[3] = TcUtility.createArg(addUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSupercedure", "removeAdd", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void removeCancel(String supUid, String cancelUid) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(supUid);
    args_[3] = TcUtility.createArg(cancelUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSupercedure", "removeCancel", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void deleteSupercedure(String supUid) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(supUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSupercedure", "deleteSupercedure", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getEC(String supUid, StringHolder ecUid, StringHolder type) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(supUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSupercedure", "getEC", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    ecUid.value = TcUtility.queryArg(response.output[0], ecUid.value);
    type.value = TcUtility.queryArg(response.output[1], type.value);
  }

  public void getFirstSupercedure(String lineUid, StringHolder supUid, StringHolder type) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(lineUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSupercedure", "getFirstSupercedure", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    supUid.value = TcUtility.queryArg(response.output[0], supUid.value);
    type.value = TcUtility.queryArg(response.output[1], type.value);
  }

  public void getSupercedureForWU(String lineUid, String wuBvrUid, StringHolder supUid, StringHolder type) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(lineUid);
    args_[3] = TcUtility.createArg(wuBvrUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSupercedure", "getSupercedureForWU", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    supUid.value = TcUtility.queryArg(response.output[0], supUid.value);
    type.value = TcUtility.queryArg(response.output[1], type.value);
  }

  public void getProblemBvr(String bcUid, StringHolder prevBvrUid, StringHolder type) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(bcUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSupercedure", "getProblemBvr", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    prevBvrUid.value = TcUtility.queryArg(response.output[0], prevBvrUid.value);
    type.value = TcUtility.queryArg(response.output[1], type.value);
  }

  public void getCancelSupercedures(String bcUid, uidSeqValue_uHolder supUids, uidSeqValue_uHolder typeUids) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(bcUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSupercedure", "getCancelSupercedures", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    supUids.value = TcUtility.queryArg(response.output[0], supUids.value);
    typeUids.value = TcUtility.queryArg(response.output[1], typeUids.value);
  }

  public void getAddSupercedures(String bcUid, uidSeqValue_uHolder supUids, uidSeqValue_uHolder typeUids) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(bcUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSupercedure", "getAddSupercedures", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    supUids.value = TcUtility.queryArg(response.output[0], supUids.value);
    typeUids.value = TcUtility.queryArg(response.output[1], typeUids.value);
  }

  public void getPureAddsCancels(String lineUid, uidSeqValue_uHolder adds, uidSeqValue_uHolder cancels, uidSeqValue_uHolder addTypeUids, uidSeqValue_uHolder cancelTypeUids) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(lineUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSupercedure", "getPureAddsCancels", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    adds.value = TcUtility.queryArg(response.output[0], adds.value);
    cancels.value = TcUtility.queryArg(response.output[1], cancels.value);
    addTypeUids.value = TcUtility.queryArg(response.output[2], addTypeUids.value);
    cancelTypeUids.value = TcUtility.queryArg(response.output[3], cancelTypeUids.value);
  }

  public void getPureAddsCancelsForWU(String lineUid, String wuBvrUid, uidSeqValue_uHolder adds, uidSeqValue_uHolder cancels, uidSeqValue_uHolder addTypeUids, uidSeqValue_uHolder cancelTypeUids) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(lineUid);
    args_[3] = TcUtility.createArg(wuBvrUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTSupercedure", "getPureAddsCancelsForWU", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    adds.value = TcUtility.queryArg(response.output[0], adds.value);
    cancels.value = TcUtility.queryArg(response.output[1], cancels.value);
    addTypeUids.value = TcUtility.queryArg(response.output[2], addTypeUids.value);
    cancelTypeUids.value = TcUtility.queryArg(response.output[3], cancelTypeUids.value);
  }

}
