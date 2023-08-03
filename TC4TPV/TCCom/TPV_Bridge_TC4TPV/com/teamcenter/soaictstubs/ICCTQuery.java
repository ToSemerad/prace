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

public class ICCTQuery extends ICCT {
  public ICCTQuery(Connection connection) {
    super(connection);
  }

  public ICCTQuery(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void create(String name, String description, String searchClass, String clauses, int domain, StringHolder query, StringHolder qryType) throws Exception {
    Arg[] args_ = new Arg[7];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(name);
    args_[3] = TcUtility.createArgStringUnion(description);
    args_[4] = TcUtility.createArg(searchClass);
    args_[5] = TcUtility.createArg(clauses);
    args_[6] = TcUtility.createArg(domain);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTQuery", "create", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    query.value = TcUtility.queryArg(response.output[0], query.value);
    qryType.value = TcUtility.queryArg(response.output[1], qryType.value);
  }

  public void find(String name, StringHolder query, StringHolder queryType) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(name);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTQuery", "find", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    query.value = TcUtility.queryArgStringUnion(response.output[0], query.value);
    queryType.value = TcUtility.queryArgStringUnion(response.output[1], queryType.value);
  }

  public void execute(String query, String[] entryNames, String[] entryValues, uidSeqValue_uHolder components) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(query);
    args_[3] = TcUtility.createArg(entryNames);
    args_[4] = TcUtility.createArgStringUnion(entryValues);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTQuery", "execute", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    components.value = TcUtility.queryArg(response.output[0], components.value);
  }

  public void execute_on_list(String query, String[] entryNames, String[] entryValues, uidSeqValue_u limits, uidSeqValue_uHolder components) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(query);
    args_[3] = TcUtility.createArg(entryNames);
    args_[4] = TcUtility.createArgStringUnion(entryValues);
    args_[5] = TcUtility.createArg(limits);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTQuery", "execute_on_list", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    components.value = TcUtility.queryArg(response.output[0], components.value);
  }

  public void execute_tuples(String query, String[] entryNames, String[] entryValues, uidSeqValue_u limits, IntHolder rows, IntHolder cols, uidSeqValue_uHolder components) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(query);
    args_[3] = TcUtility.createArg(entryNames);
    args_[4] = TcUtility.createArgStringUnion(entryValues);
    args_[5] = TcUtility.createArg(limits);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTQuery", "execute_tuples", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    rows.value = TcUtility.queryArg(response.output[0], rows.value);
    cols.value = TcUtility.queryArg(response.output[1], cols.value);
    components.value = TcUtility.queryArg(response.output[2], components.value);
  }

  public void set_up_bom_window(String query, String window) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(query);
    args_[3] = TcUtility.createArg(window);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTQuery", "set_up_bom_window", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void set_top_line(String query, String itemRev, String viewType) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(query);
    args_[3] = TcUtility.createArg(itemRev);
    args_[4] = TcUtility.createArgStringUnion(viewType);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTQuery", "set_top_line", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void get_search_elements(String query, int returnLimit, String type, uidSeqValue_uHolder components, BooleanHolder more) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(query);
    args_[3] = TcUtility.createArg(returnLimit);
    args_[4] = TcUtility.createArgStringUnion(type);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTQuery", "get_search_elements", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    components.value = TcUtility.queryArg(response.output[0], components.value);
    more.value = TcUtility.queryArg(response.output[1], more.value);
  }

  public void put_away_bom_window(String query) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(query);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTQuery", "put_away_bom_window", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void details(String query, boolean substituteKeyword, stringValueSeq_tHolder attrNames, stringValueSeq_tHolder entryNames, stringValueSeq_tHolder entryNamesDisplay, stringValueSeq_tHolder logicalOps, stringValueSeq_tHolder mathOps, stringValueSeq_tHolder defaultValues, uidValueSeq_tHolder lovs, longValueSeq_tHolder attachedLevels, longSeqSeq_tHolder dependentIndexes, longValueSeq_tHolder keyLOVIds, longValueSeq_tHolder attrTypes) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(query);
    args_[3] = TcUtility.createArg(substituteKeyword);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTQuery", "details", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    attrNames.value = TcUtility.queryArgStringUnion(response.output[0], attrNames.value);
    entryNames.value = TcUtility.queryArgStringUnion(response.output[1], entryNames.value);
    entryNamesDisplay.value = TcUtility.queryArgStringUnion(response.output[2], entryNamesDisplay.value);
    logicalOps.value = TcUtility.queryArgStringUnion(response.output[3], logicalOps.value);
    mathOps.value = TcUtility.queryArgStringUnion(response.output[4], mathOps.value);
    defaultValues.value = TcUtility.queryArgStringUnion(response.output[5], defaultValues.value);
    lovs.value = TcUtility.queryArgStringUnion(response.output[6], lovs.value);
    attachedLevels.value = TcUtility.queryArg(response.output[7], attachedLevels.value);
    dependentIndexes.value = TcUtility.queryArg(response.output[8], dependentIndexes.value);
    keyLOVIds.value = TcUtility.queryArg(response.output[9], keyLOVIds.value);
    attrTypes.value = TcUtility.queryArg(response.output[10], attrTypes.value);
  }

  public void count(String query, String[] entryNames, String[] entryValues, IntHolder resultsCount) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(query);
    args_[3] = TcUtility.createArg(entryNames);
    args_[4] = TcUtility.createArgStringUnion(entryValues);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTQuery", "count", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    resultsCount.value = TcUtility.queryArg(response.output[0], resultsCount.value);
  }

  public void getSortPrefNames(String query, StringHolder sortKeyPrefName, StringHolder sortOrderPrefName) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(query);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTQuery", "getSortPrefNames", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    sortKeyPrefName.value = TcUtility.queryArgStringUnion(response.output[0], sortKeyPrefName.value);
    sortOrderPrefName.value = TcUtility.queryArgStringUnion(response.output[1], sortOrderPrefName.value);
  }

  public void askWhereRun(String query, IntHolder where) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(query);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTQuery", "askWhereRun", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    where.value = TcUtility.queryArg(response.output[0], where.value);
  }

  public void setWhereRun(String query, int where) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(query);
    args_[3] = TcUtility.createArg(where);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTQuery", "setWhereRun", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void updateFTSIndex(String wso, boolean deleteIndex) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(wso);
    args_[3] = TcUtility.createArg(deleteIndex);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTQuery", "updateFTSIndex", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getFTSIndexStatus(String wso, IntHolder status) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(wso);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTQuery", "getFTSIndexStatus", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    status.value = TcUtility.queryArg(response.output[0], status.value);
  }

}
