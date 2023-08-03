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

public class ICCTCAEResultItem extends ICCTCAEItem {
  public ICCTCAEResultItem(Connection connection) {
    super(connection);
  }

  public ICCTCAEResultItem(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void createCAEResultItem(String caeItemId, String caeRevId, String caeResultType, String caeResultName, String caeResultDesc, String masterForm, String[] propertyNamesIM, propertyData_u[] propDataIM, String revMasterForm, String[] propertyNamesIRM, propertyData_u[] propDataIRM, StringHolder caeResultItemUid, StringHolder componentTypeUid, StringHolder caeResultItemRevUid, StringHolder caeResultItemRevTypeUid) throws Exception {
    Arg[] args_ = new Arg[13];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(caeItemId);
    args_[3] = TcUtility.createArgStringUnion(caeRevId);
    args_[4] = TcUtility.createArgStringUnion(caeResultType);
    args_[5] = TcUtility.createArgStringUnion(caeResultName);
    args_[6] = TcUtility.createArgStringUnion(caeResultDesc);
    args_[7] = TcUtility.createArgStringUnion(masterForm);
    args_[8] = TcUtility.createArg(propertyNamesIM);
    args_[9] = TcUtility.createArg(propDataIM);
    args_[10] = TcUtility.createArgStringUnion(revMasterForm);
    args_[11] = TcUtility.createArg(propertyNamesIRM);
    args_[12] = TcUtility.createArg(propDataIRM);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTCAEResultItem", "createCAEResultItem", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    caeResultItemUid.value = TcUtility.queryArg(response.output[0], caeResultItemUid.value);
    componentTypeUid.value = TcUtility.queryArg(response.output[1], componentTypeUid.value);
    caeResultItemRevUid.value = TcUtility.queryArg(response.output[2], caeResultItemRevUid.value);
    caeResultItemRevTypeUid.value = TcUtility.queryArg(response.output[3], caeResultItemRevTypeUid.value);
  }

}
