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

public class ICCTAllocation extends ICCT {
  public ICCTAllocation(Connection connection) {
    super(connection);
  }

  public ICCTAllocation(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void createAllocation(String name, String type, String sourceLineUid, String targetLineUid, String mapRevUid, StringHolder newAllocationUid, StringHolder typeUid) throws Exception {
    Arg[] args_ = new Arg[7];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(name);
    args_[3] = TcUtility.createArg(type);
    args_[4] = TcUtility.createArg(sourceLineUid);
    args_[5] = TcUtility.createArg(targetLineUid);
    args_[6] = TcUtility.createArg(mapRevUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAllocation", "createAllocation", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    newAllocationUid.value = TcUtility.queryArg(response.output[0], newAllocationUid.value);
    typeUid.value = TcUtility.queryArg(response.output[1], typeUid.value);
  }

  public void setReason(String allocationUid, String allocReason) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(allocationUid);
    args_[3] = TcUtility.createArg(allocReason);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAllocation", "setReason", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void askReason(String allocationUid, StringHolder allocReason) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(allocationUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAllocation", "askReason", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    allocReason.value = TcUtility.queryArgStringUnion(response.output[0], allocReason.value);
  }

  public void findAllocationsForSource(String sourceLineUid, String mapRevUid, uidSeq_tHolder allocUids, uidSeq_tHolder typeUids) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(sourceLineUid);
    args_[3] = TcUtility.createArg(mapRevUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAllocation", "findAllocationsForSource", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    allocUids.value = TcUtility.queryArg(response.output[0], allocUids.value);
    typeUids.value = TcUtility.queryArg(response.output[1], typeUids.value);
  }

  public void findAllocationsForTarget(String targetLineUid, String mapRevUid, uidSeq_tHolder allocUids, uidSeq_tHolder typeUids) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(targetLineUid);
    args_[3] = TcUtility.createArg(mapRevUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAllocation", "findAllocationsForTarget", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    allocUids.value = TcUtility.queryArg(response.output[0], allocUids.value);
    typeUids.value = TcUtility.queryArg(response.output[1], typeUids.value);
  }

  public void findAllocationsOfMapRev(String mapRevUid, uidSeqValue_uHolder allocUids, uidSeqValue_uHolder typeUids) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(mapRevUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAllocation", "findAllocationsOfMapRev", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    allocUids.value = TcUtility.queryArg(response.output[0], allocUids.value);
    typeUids.value = TcUtility.queryArg(response.output[1], typeUids.value);
  }

  public void findConfiguredAllocation(String mapRevUid, String revRuleUid, uidSeqValue_uHolder configuredAllocationUids, uidSeqValue_uHolder typeUids) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(mapRevUid);
    args_[3] = TcUtility.createArg(revRuleUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAllocation", "findConfiguredAllocation", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    configuredAllocationUids.value = TcUtility.queryArg(response.output[0], configuredAllocationUids.value);
    typeUids.value = TcUtility.queryArg(response.output[1], typeUids.value);
  }

  public void askSource(String allocationUid, String srcBomWindowUid, StringHolder sourceLineUid, StringHolder typeUid) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(allocationUid);
    args_[3] = TcUtility.createArg(srcBomWindowUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAllocation", "askSource", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    sourceLineUid.value = TcUtility.queryArg(response.output[0], sourceLineUid.value);
    typeUid.value = TcUtility.queryArg(response.output[1], typeUid.value);
  }

  public void setSource(String allocationUid, String sourceLineUid) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(allocationUid);
    args_[3] = TcUtility.createArg(sourceLineUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAllocation", "setSource", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void askTarget(String allocationUid, String targetBomWindowUid, StringHolder targetLineUid, StringHolder typeUid) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(allocationUid);
    args_[3] = TcUtility.createArg(targetBomWindowUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAllocation", "askTarget", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    targetLineUid.value = TcUtility.queryArg(response.output[0], targetLineUid.value);
    typeUid.value = TcUtility.queryArg(response.output[1], typeUid.value);
  }

  public void setTarget(String allocationUid, String targetLineUid) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(allocationUid);
    args_[3] = TcUtility.createArg(targetLineUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAllocation", "setTarget", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void askAllocationMapRev(String allocationUid, StringHolder mapRevUid, StringHolder typeUid) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(allocationUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAllocation", "askAllocationMapRev", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    mapRevUid.value = TcUtility.queryArg(response.output[0], mapRevUid.value);
    typeUid.value = TcUtility.queryArg(response.output[1], typeUid.value);
  }

  public void changeTargetUsingIC(String allocationUid, String targetBomLineUid, String IC_revUid) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(allocationUid);
    args_[3] = TcUtility.createArg(targetBomLineUid);
    args_[4] = TcUtility.createArg(IC_revUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAllocation", "changeTargetUsingIC", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void changeConditionUsingIC(String allocationUid, String conditionUid, String IC_revUid) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(allocationUid);
    args_[3] = TcUtility.createArg(conditionUid);
    args_[4] = TcUtility.createArg(IC_revUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAllocation", "changeConditionUsingIC", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void askConfiguredTarget(String allocationUid, String revRuleUid, String targetBomWindowUid, StringHolder targetBomLineUid, StringHolder typeUid) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(allocationUid);
    args_[3] = TcUtility.createArg(revRuleUid);
    args_[4] = TcUtility.createArg(targetBomWindowUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAllocation", "askConfiguredTarget", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    targetBomLineUid.value = TcUtility.queryArgStringUnion(response.output[0], targetBomLineUid.value);
    typeUid.value = TcUtility.queryArgStringUnion(response.output[1], typeUid.value);
  }

  public void isConfiguredByEffectivity(String allocationUid, String revRuleUid, BooleanHolder isConfigured) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(allocationUid);
    args_[3] = TcUtility.createArg(revRuleUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAllocation", "isConfiguredByEffectivity", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    isConfigured.value = TcUtility.queryArg(response.output[0], isConfigured.value);
  }

  public void isConfigured(String allocationUid, String revRuleUid, BooleanHolder configured) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(allocationUid);
    args_[3] = TcUtility.createArg(revRuleUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAllocation", "isConfigured", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    configured.value = TcUtility.queryArg(response.output[0], configured.value);
  }

  public void askCondition(String allocationUid, StringHolder conditionUid, StringHolder typeUid) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(allocationUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAllocation", "askCondition", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    conditionUid.value = TcUtility.queryArgStringUnion(response.output[0], conditionUid.value);
    typeUid.value = TcUtility.queryArgStringUnion(response.output[1], typeUid.value);
  }

  public void setCondition(String allocationUid, String conditionUid) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(allocationUid);
    args_[3] = TcUtility.createArg(conditionUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAllocation", "setCondition", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void findAllocatedTo(String srcBomLineUid, String mapRevUid, String targetBomWindowUid, String revRuleUid, uidSeqValue_uHolder bomLineUids, uidSeqValue_uHolder typeUids) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(srcBomLineUid);
    args_[3] = TcUtility.createArg(mapRevUid);
    args_[4] = TcUtility.createArg(targetBomWindowUid);
    args_[5] = TcUtility.createArg(revRuleUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAllocation", "findAllocatedTo", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    bomLineUids.value = TcUtility.queryArg(response.output[0], bomLineUids.value);
    typeUids.value = TcUtility.queryArg(response.output[1], typeUids.value);
  }

  public void findAllocatedFrom(String targetBomLineUid, String mapRevUid, String srcBomWindowUid, String revRuleUid, uidSeqValue_uHolder bomLineUids, uidSeqValue_uHolder typeUids) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(targetBomLineUid);
    args_[3] = TcUtility.createArg(mapRevUid);
    args_[4] = TcUtility.createArg(srcBomWindowUid);
    args_[5] = TcUtility.createArg(revRuleUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAllocation", "findAllocatedFrom", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    bomLineUids.value = TcUtility.queryArg(response.output[0], bomLineUids.value);
    typeUids.value = TcUtility.queryArg(response.output[1], typeUids.value);
  }

}
