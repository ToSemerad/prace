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

public class ICCTStructureMapItem extends ICCTCAEItem {
  public ICCTStructureMapItem(Connection connection) {
    super(connection);
  }

  public ICCTStructureMapItem(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void createStructureMapItem(String structureMItemId, String structureMRevId, String structureMType, String structureMName, String structureMDomain, String structureMDesc, String masterForm, String[] propertyNamesIM, propertyData_u[] propDataIM, String revMasterForm, String[] propertyNamesIRM, propertyData_u[] propDataIRM, StringHolder structureMItemUid, StringHolder structureMItemTypeUid, StringHolder structureMItemRevUid, StringHolder structureMItemRevTypeUid) throws Exception {
    Arg[] args_ = new Arg[14];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(structureMItemId);
    args_[3] = TcUtility.createArgStringUnion(structureMRevId);
    args_[4] = TcUtility.createArgStringUnion(structureMType);
    args_[5] = TcUtility.createArgStringUnion(structureMName);
    args_[6] = TcUtility.createArgStringUnion(structureMDomain);
    args_[7] = TcUtility.createArgStringUnion(structureMDesc);
    args_[8] = TcUtility.createArgStringUnion(masterForm);
    args_[9] = TcUtility.createArg(propertyNamesIM);
    args_[10] = TcUtility.createArg(propDataIM);
    args_[11] = TcUtility.createArgStringUnion(revMasterForm);
    args_[12] = TcUtility.createArg(propertyNamesIRM);
    args_[13] = TcUtility.createArg(propDataIRM);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTStructureMapItem", "createStructureMapItem", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    structureMItemUid.value = TcUtility.queryArg(response.output[0], structureMItemUid.value);
    structureMItemTypeUid.value = TcUtility.queryArg(response.output[1], structureMItemTypeUid.value);
    structureMItemRevUid.value = TcUtility.queryArg(response.output[2], structureMItemRevUid.value);
    structureMItemRevTypeUid.value = TcUtility.queryArg(response.output[3], structureMItemRevTypeUid.value);
  }

}
