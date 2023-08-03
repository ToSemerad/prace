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

public class ICCTArch extends ICCTItem {
  public ICCTArch(Connection connection) {
    super(connection);
  }

  public ICCTArch(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void createArch(String id, String revid, String archType, String archName, String archDesc, String gcId, StringHolder archUid, StringHolder componentTypeUid) throws Exception {
    Arg[] args_ = new Arg[8];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(id);
    args_[3] = TcUtility.createArgStringUnion(revid);
    args_[4] = TcUtility.createArgStringUnion(archType);
    args_[5] = TcUtility.createArgStringUnion(archName);
    args_[6] = TcUtility.createArgStringUnion(archDesc);
    args_[7] = TcUtility.createArgStringUnion(gcId);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTArch", "createArch", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    archUid.value = TcUtility.queryArg(response.output[0], archUid.value);
    componentTypeUid.value = TcUtility.queryArg(response.output[1], componentTypeUid.value);
  }

  public void createGenericObject(String id, String revid, String archType, String archName, String gcId, String archDesc, boolean has_consistent_nves, boolean has_heirarchical_variability, boolean has_partial_breakdown, boolean has_shared_nves, boolean has_based_on_preexist_elements, String instantiating_arch, StringHolder archUid, StringHolder componentTypeUid) throws Exception {
    Arg[] args_ = new Arg[14];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(id);
    args_[3] = TcUtility.createArgStringUnion(revid);
    args_[4] = TcUtility.createArgStringUnion(archType);
    args_[5] = TcUtility.createArgStringUnion(archName);
    args_[6] = TcUtility.createArgStringUnion(gcId);
    args_[7] = TcUtility.createArgStringUnion(archDesc);
    args_[8] = TcUtility.createArg(has_consistent_nves);
    args_[9] = TcUtility.createArg(has_heirarchical_variability);
    args_[10] = TcUtility.createArg(has_partial_breakdown);
    args_[11] = TcUtility.createArg(has_shared_nves);
    args_[12] = TcUtility.createArg(has_based_on_preexist_elements);
    args_[13] = TcUtility.createArgStringUnion(instantiating_arch);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTArch", "createGenericObject", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    archUid.value = TcUtility.queryArg(response.output[0], archUid.value);
    componentTypeUid.value = TcUtility.queryArg(response.output[1], componentTypeUid.value);
  }

  public void createArchWithStructInfo(String id, String revid, String archType, String archName, String gcId, String archDesc, boolean has_consistent_nves, boolean has_heirarchical_variability, boolean has_partial_breakdown, boolean has_shared_nves, StringHolder archUid, StringHolder componentTypeUid) throws Exception {
    Arg[] args_ = new Arg[12];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(id);
    args_[3] = TcUtility.createArgStringUnion(revid);
    args_[4] = TcUtility.createArgStringUnion(archType);
    args_[5] = TcUtility.createArgStringUnion(archName);
    args_[6] = TcUtility.createArgStringUnion(gcId);
    args_[7] = TcUtility.createArgStringUnion(archDesc);
    args_[8] = TcUtility.createArg(has_consistent_nves);
    args_[9] = TcUtility.createArg(has_heirarchical_variability);
    args_[10] = TcUtility.createArg(has_partial_breakdown);
    args_[11] = TcUtility.createArg(has_shared_nves);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTArch", "createArchWithStructInfo", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    archUid.value = TcUtility.queryArg(response.output[0], archUid.value);
    componentTypeUid.value = TcUtility.queryArg(response.output[1], componentTypeUid.value);
  }

  public void findArch(String gcid, String type, uidSeqValue_uHolder archItems, uidSeqValue_uHolder archItemTypes) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(gcid);
    args_[3] = TcUtility.createArgStringUnion(type);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTArch", "findArch", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    archItems.value = TcUtility.queryArg(response.output[0], archItems.value);
    archItemTypes.value = TcUtility.queryArg(response.output[1], archItemTypes.value);
  }

  public void isTopLevel(String archUid, BooleanHolder isTop) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(archUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTArch", "isTopLevel", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    isTop.value = TcUtility.queryArg(response.output[0], isTop.value);
  }

  public void findApn(String archUid, String topUid, uidSeqValue_uHolder apnUids, uidSeqValue_uHolder apnTypeUids) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(archUid);
    args_[3] = TcUtility.createArg(topUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTArch", "findApn", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    apnUids.value = TcUtility.queryArg(response.output[0], apnUids.value);
    apnTypeUids.value = TcUtility.queryArg(response.output[1], apnTypeUids.value);
  }

  public void getInstallAssemblies(String archApn, uidSeqValue_uHolder installRevUids, uidSeqValue_uHolder installItemTypes) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(archApn);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTArch", "getInstallAssemblies", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    installRevUids.value = TcUtility.queryArg(response.output[0], installRevUids.value);
    installItemTypes.value = TcUtility.queryArg(response.output[1], installItemTypes.value);
  }

  public void findNamedVariantExpressions(String archRevUid, String code, String desc, int noOfOpts, String[] opts, int noOfVals, int[] opCodes, String[] values, uidValueSeq_tHolder nveUids, uidValueSeq_tHolder nveTypeUids) throws Exception {
    Arg[] args_ = new Arg[10];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(archRevUid);
    args_[3] = TcUtility.createArgStringUnion(code);
    args_[4] = TcUtility.createArgStringUnion(desc);
    args_[5] = TcUtility.createArg(noOfOpts);
    args_[6] = TcUtility.createArgStringUnion(opts);
    args_[7] = TcUtility.createArg(noOfVals);
    args_[8] = TcUtility.createArg(opCodes);
    args_[9] = TcUtility.createArgStringUnion(values);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTArch", "findNamedVariantExpressions", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    nveUids.value = TcUtility.queryArgStringUnion(response.output[0], nveUids.value);
    nveTypeUids.value = TcUtility.queryArgStringUnion(response.output[1], nveTypeUids.value);
  }

  public void askUsageNVEs(int noOfUsages, String[] usages, IntHolder noOfMatchedNVEs, uidValueSeq_tHolder matchedNVEsUid, uidValueSeq_tHolder matchedNVEsTypeUid) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(noOfUsages);
    args_[3] = TcUtility.createArgStringUnion(usages);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTArch", "askUsageNVEs", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    noOfMatchedNVEs.value = TcUtility.queryArg(response.output[0], noOfMatchedNVEs.value);
    matchedNVEsUid.value = TcUtility.queryArgStringUnion(response.output[1], matchedNVEsUid.value);
    matchedNVEsTypeUid.value = TcUtility.queryArgStringUnion(response.output[2], matchedNVEsTypeUid.value);
  }

  public void askUsageLines(String winUid, String archAPNUid, int noOfDesignSolutions, String[] designSolutions, IntHolder noOfMatchedUsages, uidValueSeq_tHolder matchedUsagesUid, uidValueSeq_tHolder matchedUsagesTypeUid, IntHolder noOfTotalUsages, uidValueSeq_tHolder totalUsagesUid, uidValueSeq_tHolder totalUsagesTypeUid) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(winUid);
    args_[3] = TcUtility.createArg(archAPNUid);
    args_[4] = TcUtility.createArg(noOfDesignSolutions);
    args_[5] = TcUtility.createArgStringUnion(designSolutions);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTArch", "askUsageLines", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    noOfMatchedUsages.value = TcUtility.queryArg(response.output[0], noOfMatchedUsages.value);
    matchedUsagesUid.value = TcUtility.queryArgStringUnion(response.output[1], matchedUsagesUid.value);
    matchedUsagesTypeUid.value = TcUtility.queryArgStringUnion(response.output[2], matchedUsagesTypeUid.value);
    noOfTotalUsages.value = TcUtility.queryArg(response.output[3], noOfTotalUsages.value);
    totalUsagesUid.value = TcUtility.queryArgStringUnion(response.output[4], totalUsagesUid.value);
    totalUsagesTypeUid.value = TcUtility.queryArgStringUnion(response.output[5], totalUsagesTypeUid.value);
  }

  public void getAssociatedData(String archUid, String topUid, uidSeqValue_uHolder apnUids, uidSeqValue_uHolder apnTypeUids, uidSeqValue_uHolder installRevUids, uidSeqValue_uHolder installItemTypes, uidSeqValue_uHolder nveUids, uidSeqValue_uHolder nveTypeUids) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(archUid);
    args_[3] = TcUtility.createArg(topUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTArch", "getAssociatedData", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    apnUids.value = TcUtility.queryArg(response.output[0], apnUids.value);
    apnTypeUids.value = TcUtility.queryArg(response.output[1], apnTypeUids.value);
    installRevUids.value = TcUtility.queryArg(response.output[2], installRevUids.value);
    installItemTypes.value = TcUtility.queryArg(response.output[3], installItemTypes.value);
    nveUids.value = TcUtility.queryArg(response.output[4], nveUids.value);
    nveTypeUids.value = TcUtility.queryArg(response.output[5], nveTypeUids.value);
  }

  public void saveAs(String GO, String GO_rev, String newItemId, String newItemRev, String gcid, String name, String description, StringHolder new_GO, StringHolder new_GO_type) throws Exception {
    Arg[] args_ = new Arg[9];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(GO);
    args_[3] = TcUtility.createArg(GO_rev);
    args_[4] = TcUtility.createArgStringUnion(newItemId);
    args_[5] = TcUtility.createArgStringUnion(newItemRev);
    args_[6] = TcUtility.createArgStringUnion(gcid);
    args_[7] = TcUtility.createArgStringUnion(name);
    args_[8] = TcUtility.createArgStringUnion(description);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTArch", "saveAs", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    new_GO.value = TcUtility.queryArg(response.output[0], new_GO.value);
    new_GO_type.value = TcUtility.queryArg(response.output[1], new_GO_type.value);
  }

  public void isArchitecture(String archUid, BooleanHolder isArch) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(archUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTArch", "isArchitecture", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    isArch.value = TcUtility.queryArg(response.output[0], isArch.value);
  }

}
