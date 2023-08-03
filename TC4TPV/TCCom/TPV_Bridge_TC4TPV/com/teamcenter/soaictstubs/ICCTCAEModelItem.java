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

public class ICCTCAEModelItem extends ICCTCAEItem {
  public ICCTCAEModelItem(Connection connection) {
    super(connection);
  }

  public ICCTCAEModelItem(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void createCAEModelItem(String caeItemId, String caeRevId, String caeModelType, String caeModelName, String caeModelDesc, String masterForm, String[] propertyNamesIM, propertyData_u[] propDataIM, String revMasterForm, String[] propertyNamesIRM, propertyData_u[] propDataIRM, StringHolder caeModelItemUid, StringHolder componentTypeUid, StringHolder caeModelItemRevUid, StringHolder caeModelItemRevTypeUid) throws Exception {
    Arg[] args_ = new Arg[13];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(caeItemId);
    args_[3] = TcUtility.createArgStringUnion(caeRevId);
    args_[4] = TcUtility.createArgStringUnion(caeModelType);
    args_[5] = TcUtility.createArgStringUnion(caeModelName);
    args_[6] = TcUtility.createArgStringUnion(caeModelDesc);
    args_[7] = TcUtility.createArgStringUnion(masterForm);
    args_[8] = TcUtility.createArg(propertyNamesIM);
    args_[9] = TcUtility.createArg(propDataIM);
    args_[10] = TcUtility.createArgStringUnion(revMasterForm);
    args_[11] = TcUtility.createArg(propertyNamesIRM);
    args_[12] = TcUtility.createArg(propDataIRM);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTCAEModelItem", "createCAEModelItem", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    caeModelItemUid.value = TcUtility.queryArg(response.output[0], caeModelItemUid.value);
    componentTypeUid.value = TcUtility.queryArg(response.output[1], componentTypeUid.value);
    caeModelItemRevUid.value = TcUtility.queryArg(response.output[2], caeModelItemRevUid.value);
    caeModelItemRevTypeUid.value = TcUtility.queryArg(response.output[3], caeModelItemRevTypeUid.value);
  }

  public void executeBatchMeshing(String toolName, String meshScript, String workingDir, int numCADParts, String[] cadPartIDs, String[] cadPartRevIDs, String[] paramItemIDs, String[] paramItemRevIDs, String[] paramDatasetNames, String[] criteriaItemIDs, String[] criteriaItemRevIDs, String[] criteriaDatasetNames, boolean reMesh, boolean createModel, boolean async) throws Exception {
    Arg[] args_ = new Arg[17];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(toolName);
    args_[3] = TcUtility.createArgStringUnion(meshScript);
    args_[4] = TcUtility.createArgStringUnion(workingDir);
    args_[5] = TcUtility.createArg(numCADParts);
    args_[6] = TcUtility.createArg(cadPartIDs);
    args_[7] = TcUtility.createArg(cadPartRevIDs);
    args_[8] = TcUtility.createArg(paramItemIDs);
    args_[9] = TcUtility.createArg(paramItemRevIDs);
    args_[10] = TcUtility.createArg(paramDatasetNames);
    args_[11] = TcUtility.createArg(criteriaItemIDs);
    args_[12] = TcUtility.createArg(criteriaItemRevIDs);
    args_[13] = TcUtility.createArg(criteriaDatasetNames);
    args_[14] = TcUtility.createArg(reMesh);
    args_[15] = TcUtility.createArg(createModel);
    args_[16] = TcUtility.createArg(async);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTCAEModelItem", "executeBatchMeshing", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

}
