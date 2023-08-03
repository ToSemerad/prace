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

public class ICCTCAEGeometryItem extends ICCTCAEItem {
  public ICCTCAEGeometryItem(Connection connection) {
    super(connection);
  }

  public ICCTCAEGeometryItem(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void createCAEGeometryItem(String caeItemId, String caeRevId, String caeGeometryType, String caeGeometryName, String caeGeometryDesc, String masterForm, String[] propertyNamesIM, propertyData_u[] propDataIM, String revMasterForm, String[] propertyNamesIRM, propertyData_u[] propDataIRM, StringHolder caeGeometryItemUid, StringHolder componentTypeUid, StringHolder caeGeometryItemRevUid, StringHolder caeGeometryItemRevTypeUid) throws Exception {
    Arg[] args_ = new Arg[13];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(caeItemId);
    args_[3] = TcUtility.createArgStringUnion(caeRevId);
    args_[4] = TcUtility.createArgStringUnion(caeGeometryType);
    args_[5] = TcUtility.createArgStringUnion(caeGeometryName);
    args_[6] = TcUtility.createArgStringUnion(caeGeometryDesc);
    args_[7] = TcUtility.createArgStringUnion(masterForm);
    args_[8] = TcUtility.createArg(propertyNamesIM);
    args_[9] = TcUtility.createArg(propDataIM);
    args_[10] = TcUtility.createArgStringUnion(revMasterForm);
    args_[11] = TcUtility.createArg(propertyNamesIRM);
    args_[12] = TcUtility.createArg(propDataIRM);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTCAEGeometryItem", "createCAEGeometryItem", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    caeGeometryItemUid.value = TcUtility.queryArg(response.output[0], caeGeometryItemUid.value);
    componentTypeUid.value = TcUtility.queryArg(response.output[1], componentTypeUid.value);
    caeGeometryItemRevUid.value = TcUtility.queryArg(response.output[2], caeGeometryItemRevUid.value);
    caeGeometryItemRevTypeUid.value = TcUtility.queryArg(response.output[3], caeGeometryItemRevTypeUid.value);
  }

}
