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

public class ICCTEintService {
  ICTService m_service;

  Connection m_connection;


  public ICCTEintService(Connection connection) {
    m_service = ICTService.getService( connection );
    m_connection = connection;
  }

  public void initEintModule() throws Exception {
    Arg[] args_ = new Arg[0];
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTEintService", "initEintModule", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getConnection(String adapterName, String url, String user, String passwd) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(adapterName);
    args_[1] = TcUtility.createArg(url);
    args_[2] = TcUtility.createArg(user);
    args_[3] = TcUtility.createArg(passwd);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTEintService", "getConnection", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void closeConnection(String adapterName, String url, String user, String passwd) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(adapterName);
    args_[1] = TcUtility.createArg(url);
    args_[2] = TcUtility.createArg(user);
    args_[3] = TcUtility.createArg(passwd);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTEintService", "closeConnection", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getDataSourceNames(String adapterName, stringSeq_tHolder dsNames) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(adapterName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTEintService", "getDataSourceNames", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    dsNames.value = TcUtility.queryArg(response.output[0], dsNames.value);
  }

  public void getDsAdapter(String adapterName) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(adapterName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTEintService", "getDsAdapter", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getMetaData(String adapterName, String url, String user, String passwd) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(adapterName);
    args_[1] = TcUtility.createArg(url);
    args_[2] = TcUtility.createArg(user);
    args_[3] = TcUtility.createArg(passwd);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTEintService", "getMetaData", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getTables(String adapterName, String url, String user, String passwd, String catalog, String schema, String tableName, String[] types, stringSeq_tHolder tableNames) throws Exception {
    Arg[] args_ = new Arg[8];
    args_[0] = TcUtility.createArg(adapterName);
    args_[1] = TcUtility.createArg(url);
    args_[2] = TcUtility.createArg(user);
    args_[3] = TcUtility.createArg(passwd);
    args_[4] = TcUtility.createArg(catalog);
    args_[5] = TcUtility.createArg(schema);
    args_[6] = TcUtility.createArg(tableName);
    args_[7] = TcUtility.createArg(types);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTEintService", "getTables", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    tableNames.value = TcUtility.queryArg(response.output[0], tableNames.value);
  }

  public void getIndexInfo(String adapterName, String url, String user, String passwd, String catalog, String schema, String tableName, boolean unique, boolean approximate, stringSeq_tHolder columnNames) throws Exception {
    Arg[] args_ = new Arg[9];
    args_[0] = TcUtility.createArg(adapterName);
    args_[1] = TcUtility.createArg(url);
    args_[2] = TcUtility.createArg(user);
    args_[3] = TcUtility.createArg(passwd);
    args_[4] = TcUtility.createArg(catalog);
    args_[5] = TcUtility.createArg(schema);
    args_[6] = TcUtility.createArg(tableName);
    args_[7] = TcUtility.createArg(unique);
    args_[8] = TcUtility.createArg(approximate);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTEintService", "getIndexInfo", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    columnNames.value = TcUtility.queryArg(response.output[0], columnNames.value);
  }

  public void getColumns(String adapterName, String url, String user, String passwd, String catalog, String schema, String tableName, String columnName, stringSeq_tHolder columnNames, longSeqValue_uHolder columnTypes, longSeqValue_uHolder columnSizes) throws Exception {
    Arg[] args_ = new Arg[8];
    args_[0] = TcUtility.createArg(adapterName);
    args_[1] = TcUtility.createArg(url);
    args_[2] = TcUtility.createArg(user);
    args_[3] = TcUtility.createArg(passwd);
    args_[4] = TcUtility.createArg(catalog);
    args_[5] = TcUtility.createArg(schema);
    args_[6] = TcUtility.createArg(tableName);
    args_[7] = TcUtility.createArg(columnName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTEintService", "getColumns", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    columnNames.value = TcUtility.queryArg(response.output[0], columnNames.value);
    columnTypes.value = TcUtility.queryArg(response.output[1], columnTypes.value);
    columnSizes.value = TcUtility.queryArg(response.output[2], columnSizes.value);
  }

  public void closeStatement(String adapterName, String url, String user, String passwd) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(adapterName);
    args_[1] = TcUtility.createArg(url);
    args_[2] = TcUtility.createArg(user);
    args_[3] = TcUtility.createArg(passwd);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTEintService", "closeStatement", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void executeQuery(String adapterName, String url, String user, String passwd, String sqlStatement) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(adapterName);
    args_[1] = TcUtility.createArg(url);
    args_[2] = TcUtility.createArg(user);
    args_[3] = TcUtility.createArg(passwd);
    args_[4] = TcUtility.createArg(sqlStatement);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTEintService", "executeQuery", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void closeQueryResultSet(String adapterName, String url, String user, String passwd) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(adapterName);
    args_[1] = TcUtility.createArg(url);
    args_[2] = TcUtility.createArg(user);
    args_[3] = TcUtility.createArg(passwd);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTEintService", "closeQueryResultSet", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getRowDataAsString(String adapterName, String url, String user, String passwd, stringSeq_tHolder rowData) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(adapterName);
    args_[1] = TcUtility.createArg(url);
    args_[2] = TcUtility.createArg(user);
    args_[3] = TcUtility.createArg(passwd);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTEintService", "getRowDataAsString", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    rowData.value = TcUtility.queryArg(response.output[0], rowData.value);
  }

  public void getQrsMetaData(String adapterName, String url, String user, String passwd, stringSeq_tHolder tableNames, stringSeq_tHolder columnNames, longSeqValue_uHolder columnTypes, longSeqValue_uHolder columnSizes) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(adapterName);
    args_[1] = TcUtility.createArg(url);
    args_[2] = TcUtility.createArg(user);
    args_[3] = TcUtility.createArg(passwd);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTEintService", "getQrsMetaData", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    tableNames.value = TcUtility.queryArg(response.output[0], tableNames.value);
    columnNames.value = TcUtility.queryArg(response.output[1], columnNames.value);
    columnTypes.value = TcUtility.queryArg(response.output[2], columnTypes.value);
    columnSizes.value = TcUtility.queryArg(response.output[3], columnSizes.value);
  }

  public void createEintForm(String formName, String formDesc, String formType, String[] keyUids, String[] keyValues, String[] propNames, String[] propValues, boolean[] keyFlags, StringHolder newEintForm, StringHolder newEintFormType) throws Exception {
    Arg[] args_ = new Arg[8];
    args_[0] = TcUtility.createArg(formName);
    args_[1] = TcUtility.createArg(formDesc);
    args_[2] = TcUtility.createArg(formType);
    args_[3] = TcUtility.createArg(keyUids);
    args_[4] = TcUtility.createArg(keyValues);
    args_[5] = TcUtility.createArg(propNames);
    args_[6] = TcUtility.createArg(propValues);
    args_[7] = TcUtility.createArg(keyFlags);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTEintService", "createEintForm", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    newEintForm.value = TcUtility.queryArgStringUnion(response.output[0], newEintForm.value);
    newEintFormType.value = TcUtility.queryArgStringUnion(response.output[1], newEintFormType.value);
  }

  public void getEintFormTypes(uidSeqValue_uHolder uids, uidSeqValue_uHolder typeUids) throws Exception {
    Arg[] args_ = new Arg[0];
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTEintService", "getEintFormTypes", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    uids.value = TcUtility.queryArg(response.output[0], uids.value);
    typeUids.value = TcUtility.queryArg(response.output[1], typeUids.value);
  }

  public void getObjectMappings(String formTypeUid, uidSeqValue_uHolder objectMappingUids, uidSeqValue_uHolder objectMappingTypeUids) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(formTypeUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTEintService", "getObjectMappings", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    objectMappingUids.value = TcUtility.queryArg(response.output[0], objectMappingUids.value);
    objectMappingTypeUids.value = TcUtility.queryArg(response.output[1], objectMappingTypeUids.value);
  }

  public void getObjMapFromTypeName(String formTypeName, StringHolder objectMappingUid, StringHolder objectMappingTypeUid) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(formTypeName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTEintService", "getObjMapFromTypeName", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    objectMappingUid.value = TcUtility.queryArgStringUnion(response.output[0], objectMappingUid.value);
    objectMappingTypeUid.value = TcUtility.queryArgStringUnion(response.output[1], objectMappingTypeUid.value);
  }

  public void getSavedQuery(String formTypeUid, StringHolder savedQryUid, StringHolder savedQryTypeUid) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(formTypeUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTEintService", "getSavedQuery", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    savedQryUid.value = TcUtility.queryArgStringUnion(response.output[0], savedQryUid.value);
    savedQryTypeUid.value = TcUtility.queryArgStringUnion(response.output[1], savedQryTypeUid.value);
  }

  public void relateSavedQueryToFormType(String formTypeUid, String savedQryUid, StringHolder relationUid, StringHolder relationTypeUid) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(formTypeUid);
    args_[1] = TcUtility.createArg(savedQryUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTEintService", "relateSavedQueryToFormType", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    relationUid.value = TcUtility.queryArgStringUnion(response.output[0], relationUid.value);
    relationTypeUid.value = TcUtility.queryArgStringUnion(response.output[1], relationTypeUid.value);
  }

  public void importExternalData(String formType, String[] propNames, String[] propValues, uidSeqValue_uHolder objectUids, uidSeqValue_uHolder objectTypeUids, stringSeqValue_uHolder errors) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(formType);
    args_[1] = TcUtility.createArg(propNames);
    args_[2] = TcUtility.createArg(propValues);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTEintService", "importExternalData", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    objectUids.value = TcUtility.queryArg(response.output[0], objectUids.value);
    objectTypeUids.value = TcUtility.queryArg(response.output[1], objectTypeUids.value);
    errors.value = TcUtility.queryArg(response.output[2], errors.value);
  }

}
