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

public class ICCTCAEConnItem extends ICCTItem {
  public ICCTCAEConnItem(Connection connection) {
    super(connection);
  }

  public ICCTCAEConnItem(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void createCAEConnItem(String id, String revid, String Name, String Desc, String Type, String uom, String masterForm, String[] propertyNamesIM, propertyData_u[] propDataIM, String revMasterForm, String[] propertyNamesIRM, propertyData_u[] propDataIRM, StringHolder CAEConnItemUid, StringHolder componentTypeUid) throws Exception {
    Arg[] args_ = new Arg[14];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(id);
    args_[3] = TcUtility.createArgStringUnion(revid);
    args_[4] = TcUtility.createArgStringUnion(Name);
    args_[5] = TcUtility.createArgStringUnion(Desc);
    args_[6] = TcUtility.createArgStringUnion(Type);
    args_[7] = TcUtility.createArgStringUnion(uom);
    args_[8] = TcUtility.createArgStringUnion(masterForm);
    args_[9] = TcUtility.createArg(propertyNamesIM);
    args_[10] = TcUtility.createArg(propDataIM);
    args_[11] = TcUtility.createArgStringUnion(revMasterForm);
    args_[12] = TcUtility.createArg(propertyNamesIRM);
    args_[13] = TcUtility.createArg(propDataIRM);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTCAEConnItem", "createCAEConnItem", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    CAEConnItemUid.value = TcUtility.queryArg(response.output[0], CAEConnItemUid.value);
    componentTypeUid.value = TcUtility.queryArg(response.output[1], componentTypeUid.value);
  }

}
