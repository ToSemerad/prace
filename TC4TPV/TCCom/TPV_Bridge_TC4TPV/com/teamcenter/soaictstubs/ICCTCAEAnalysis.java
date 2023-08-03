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

public class ICCTCAEAnalysis extends ICCTCAEItem {
  public ICCTCAEAnalysis(Connection connection) {
    super(connection);
  }

  public ICCTCAEAnalysis(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void createCAEAnalysis(String id, String revid, String caeAnalysisType, String caeAnalysisName, String caeAnalysisDesc, String masterForm, String[] propertyNamesIM, propertyData_u[] propDataIM, String revMasterForm, String[] propertyNamesIRM, propertyData_u[] propDataIRM, StringHolder caeAnalysisUid, StringHolder componentTypeUid, StringHolder caeAnalysisRevUid, StringHolder caeAnalysisRevTypeUid) throws Exception {
    Arg[] args_ = new Arg[13];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(id);
    args_[3] = TcUtility.createArgStringUnion(revid);
    args_[4] = TcUtility.createArgStringUnion(caeAnalysisType);
    args_[5] = TcUtility.createArgStringUnion(caeAnalysisName);
    args_[6] = TcUtility.createArgStringUnion(caeAnalysisDesc);
    args_[7] = TcUtility.createArgStringUnion(masterForm);
    args_[8] = TcUtility.createArg(propertyNamesIM);
    args_[9] = TcUtility.createArg(propDataIM);
    args_[10] = TcUtility.createArgStringUnion(revMasterForm);
    args_[11] = TcUtility.createArg(propertyNamesIRM);
    args_[12] = TcUtility.createArg(propDataIRM);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTCAEAnalysis", "createCAEAnalysis", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    caeAnalysisUid.value = TcUtility.queryArg(response.output[0], caeAnalysisUid.value);
    componentTypeUid.value = TcUtility.queryArg(response.output[1], componentTypeUid.value);
    caeAnalysisRevUid.value = TcUtility.queryArg(response.output[2], caeAnalysisRevUid.value);
    caeAnalysisRevTypeUid.value = TcUtility.queryArg(response.output[3], caeAnalysisRevTypeUid.value);
  }

}
