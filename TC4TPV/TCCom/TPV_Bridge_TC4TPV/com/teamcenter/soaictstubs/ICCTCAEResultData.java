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

public class ICCTCAEResultData extends ICCT {
  public ICCTCAEResultData(Connection connection) {
    super(connection);
  }

  public ICCTCAEResultData(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void create(String dataset, String resultName, String resultType, String resultDesc, String plmxmlPath, boolean external, stringSeqValue_u dataFilePaths) throws Exception {
    Arg[] args_ = new Arg[9];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(dataset);
    args_[3] = TcUtility.createArg(resultName);
    args_[4] = TcUtility.createArgStringUnion(resultType);
    args_[5] = TcUtility.createArgStringUnion(resultDesc);
    args_[6] = TcUtility.createArgStringUnion(plmxmlPath);
    args_[7] = TcUtility.createArg(external);
    args_[8] = TcUtility.createArg(dataFilePaths);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTCAEResultData", "create", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void remove(String dataset, String result, boolean deleteExternalFiles) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(dataset);
    args_[3] = TcUtility.createArg(result);
    args_[4] = TcUtility.createArg(deleteExternalFiles);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTCAEResultData", "remove", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void importFiles(String result, boolean deleteExternalFiles) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(result);
    args_[3] = TcUtility.createArg(deleteExternalFiles);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTCAEResultData", "importFiles", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setStringAttr(String dataset, String result, String attrName, String attrValue, boolean mustBeUnique) throws Exception {
    Arg[] args_ = new Arg[7];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(dataset);
    args_[3] = TcUtility.createArg(result);
    args_[4] = TcUtility.createArg(attrName);
    args_[5] = TcUtility.createArgStringUnion(attrValue);
    args_[6] = TcUtility.createArg(mustBeUnique);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTCAEResultData", "setStringAttr", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

}
