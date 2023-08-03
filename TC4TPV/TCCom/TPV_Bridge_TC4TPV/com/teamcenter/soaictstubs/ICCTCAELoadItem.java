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

public class ICCTCAELoadItem extends ICCTItem {
  public ICCTCAELoadItem(Connection connection) {
    super(connection);
  }

  public ICCTCAELoadItem(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void createCAELoadItem(String id, String revid, String Type, String Name, String Desc, String uom, String vaultMode, String eIntType, String[] criteriaNames, String[] criteriaValues, String linkPath, String masterForm, String[] propertyNamesIM, propertyData_u[] propDataIM, String revMasterForm, String[] propertyNamesIRM, propertyData_u[] propDataIRM, StringHolder CAELoadItemUid, StringHolder componentTypeUid) throws Exception {
    Arg[] args_ = new Arg[19];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(id);
    args_[3] = TcUtility.createArgStringUnion(revid);
    args_[4] = TcUtility.createArgStringUnion(Type);
    args_[5] = TcUtility.createArgStringUnion(Name);
    args_[6] = TcUtility.createArgStringUnion(Desc);
    args_[7] = TcUtility.createArgStringUnion(uom);
    args_[8] = TcUtility.createArgStringUnion(vaultMode);
    args_[9] = TcUtility.createArgStringUnion(eIntType);
    args_[10] = TcUtility.createArg(criteriaNames);
    args_[11] = TcUtility.createArgStringUnion(criteriaValues);
    args_[12] = TcUtility.createArgStringUnion(linkPath);
    args_[13] = TcUtility.createArgStringUnion(masterForm);
    args_[14] = TcUtility.createArg(propertyNamesIM);
    args_[15] = TcUtility.createArg(propDataIM);
    args_[16] = TcUtility.createArgStringUnion(revMasterForm);
    args_[17] = TcUtility.createArg(propertyNamesIRM);
    args_[18] = TcUtility.createArg(propDataIRM);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTCAELoadItem", "createCAELoadItem", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    CAELoadItemUid.value = TcUtility.queryArg(response.output[0], CAELoadItemUid.value);
    componentTypeUid.value = TcUtility.queryArg(response.output[1], componentTypeUid.value);
  }

}
