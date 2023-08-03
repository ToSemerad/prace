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

public class ICCTAppDataModelDefinition extends ICCT {
  public ICCTAppDataModelDefinition(Connection connection) {
    super(connection);
  }

  public ICCTAppDataModelDefinition(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void askAllDMSObjects(uidSeq_tHolder dmsObjects) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAppDataModelDefinition", "askAllDMSObjects", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    dmsObjects.value = TcUtility.queryArg(response.output[0], dmsObjects.value);
  }

  public void askDatasettypeRelations(String datasettype, stringSeqValue_uHolder relations) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(datasettype);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAppDataModelDefinition", "askDatasettypeRelations", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    relations.value = TcUtility.queryArg(response.output[0], relations.value);
  }

  public void askQualifyingDatasetsUnderItemrev(String datasettypeName, String itemrev, uidSeqValue_uHolder datasets) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(datasettypeName);
    args_[3] = TcUtility.createArg(itemrev);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAppDataModelDefinition", "askQualifyingDatasetsUnderItemrev", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    datasets.value = TcUtility.queryArg(response.output[0], datasets.value);
  }

  public void askDatasettypeItemtypes(String datasettypeName, String relationName, stringSeqValue_uHolder itemtypeNames) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(datasettypeName);
    args_[3] = TcUtility.createArgStringUnion(relationName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAppDataModelDefinition", "askDatasettypeItemtypes", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    itemtypeNames.value = TcUtility.queryArg(response.output[0], itemtypeNames.value);
  }

  public void askRelatedDatasetsUnderItemrev(String connection, String itemrev, String primaryDataset, uidSeqValue_uHolder datasets) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(connection);
    args_[3] = TcUtility.createArg(itemrev);
    args_[4] = TcUtility.createArg(primaryDataset);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAppDataModelDefinition", "askRelatedDatasetsUnderItemrev", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    datasets.value = TcUtility.queryArg(response.output[0], datasets.value);
  }

  public void askSupportedNRsUnderDataset(String dataset, uidSeqValue_uHolder tcFiles) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(dataset);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAppDataModelDefinition", "askSupportedNRsUnderDataset", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    tcFiles.value = TcUtility.queryArg(response.output[0], tcFiles.value);
  }

}
