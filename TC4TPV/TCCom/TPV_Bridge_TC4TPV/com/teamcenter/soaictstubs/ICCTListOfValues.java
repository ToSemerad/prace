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

public class ICCTListOfValues extends ICCT {
  public ICCTListOfValues(Connection connection) {
    super(connection);
  }

  public ICCTListOfValues(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void create(String name, String description, String lovType, int lovValueType, int usageType, String className, String attrName, String basedOnLOVUid, boolean allShown, int[] shown_values_indexes, StringHolder lovObj, StringHolder typeObj) throws Exception {
    Arg[] args_ = new Arg[12];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(name);
    args_[3] = TcUtility.createArgStringUnion(description);
    args_[4] = TcUtility.createArgStringUnion(lovType);
    args_[5] = TcUtility.createArg(lovValueType);
    args_[6] = TcUtility.createArg(usageType);
    args_[7] = TcUtility.createArgStringUnion(className);
    args_[8] = TcUtility.createArgStringUnion(attrName);
    args_[9] = TcUtility.createArgStringUnion(basedOnLOVUid);
    args_[10] = TcUtility.createArg(allShown);
    args_[11] = TcUtility.createArg(shown_values_indexes);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTListOfValues", "create", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    lovObj.value = TcUtility.queryArg(response.output[0], lovObj.value);
    typeObj.value = TcUtility.queryArg(response.output[1], typeObj.value);
  }

  public void find(String name, uidSeqValue_uHolder lovObjs, uidSeqValue_uHolder typeObjs) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(name);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTListOfValues", "find", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    lovObjs.value = TcUtility.queryArg(response.output[0], lovObjs.value);
    typeObjs.value = TcUtility.queryArg(response.output[1], typeObjs.value);
  }

  public void addValues(String lovObj, lovData_u[] values) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(lovObj);
    args_[3] = TcUtility.createArg(values);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTListOfValues", "addValues", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setLowerRange(String lovObj, lovData_u value) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(lovObj);
    args_[3] = TcUtility.createArg(value);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTListOfValues", "setLowerRange", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setUpperRange(String lovObj, lovData_u value) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(lovObj);
    args_[3] = TcUtility.createArg(value);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTListOfValues", "setUpperRange", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getListOfValuesInfo(String lovObj, boolean loadChildren, lovDataInfoSeq_tHolder lovInfo) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(lovObj);
    args_[3] = TcUtility.createArg(loadChildren);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTListOfValues", "getListOfValuesInfo", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    lovInfo.value = TcUtility.queryArg(response.output[0], lovInfo.value);
  }

  public void attachProperty(String lovObj, String typeName, String propName) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(lovObj);
    args_[3] = TcUtility.createArg(typeName);
    args_[4] = TcUtility.createArg(propName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTListOfValues", "attachProperty", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void detachProperty(String typeName, String propName) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(typeName);
    args_[3] = TcUtility.createArg(propName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTListOfValues", "detachProperty", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setUsage(String lovObj, int usageValue) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(lovObj);
    args_[3] = TcUtility.createArg(usageValue);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTListOfValues", "setUsage", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setName(String lovObj, String name) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(lovObj);
    args_[3] = TcUtility.createArg(name);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTListOfValues", "setName", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setDescription(String lovObj, String desc) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(lovObj);
    args_[3] = TcUtility.createArg(desc);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTListOfValues", "setDescription", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void askLovLength(String lovObj, IntHolder lovLength) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(lovObj);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTListOfValues", "askLovLength", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    lovLength.value = TcUtility.queryArg(response.output[0], lovLength.value);
  }

  public void getMappedAttrnamesandQuery(String lovObj, IntHolder lovValueType, IntHolder lovUsage, stringSeqValue_uHolder attrNames, stringSeqValue_uHolder primaryAttrNames, StringHolder query, StringHolder queryType, stringSeqValue_uHolder dependentPropNames) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(lovObj);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTListOfValues", "getMappedAttrnamesandQuery", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    lovValueType.value = TcUtility.queryArg(response.output[0], lovValueType.value);
    lovUsage.value = TcUtility.queryArg(response.output[1], lovUsage.value);
    attrNames.value = TcUtility.queryArg(response.output[2], attrNames.value);
    primaryAttrNames.value = TcUtility.queryArg(response.output[3], primaryAttrNames.value);
    query.value = TcUtility.queryArg(response.output[4], query.value);
    queryType.value = TcUtility.queryArg(response.output[5], queryType.value);
    dependentPropNames.value = TcUtility.queryArg(response.output[6], dependentPropNames.value);
  }

  public void copy(String name, String description, int usageType, String srcLOVUid, StringHolder lovObj, StringHolder typeObj) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(name);
    args_[3] = TcUtility.createArgStringUnion(description);
    args_[4] = TcUtility.createArg(usageType);
    args_[5] = TcUtility.createArg(srcLOVUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTListOfValues", "copy", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    lovObj.value = TcUtility.queryArg(response.output[0], lovObj.value);
    typeObj.value = TcUtility.queryArg(response.output[1], typeObj.value);
  }

  public void setLOVFilters(String lovUid, int[] indexes, String[] filters) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(lovUid);
    args_[3] = TcUtility.createArg(indexes);
    args_[4] = TcUtility.createArg(filters);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTListOfValues", "setLOVFilters", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setAttachedProperties(String lovUid, String[] typeNames, String[] propNames, int[] levels, int[] parents, boolean[] attachToDescriptions) throws Exception {
    Arg[] args_ = new Arg[8];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(lovUid);
    args_[3] = TcUtility.createArg(typeNames);
    args_[4] = TcUtility.createArg(propNames);
    args_[5] = TcUtility.createArg(levels);
    args_[6] = TcUtility.createArg(parents);
    args_[7] = TcUtility.createArg(attachToDescriptions);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTListOfValues", "setAttachedProperties", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void detachProperties(String lovUid, String[] typeNames, String[] propNames) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(lovUid);
    args_[3] = TcUtility.createArg(typeNames);
    args_[4] = TcUtility.createArg(propNames);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTListOfValues", "detachProperties", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setValueDescriptions(String lovUid, String[] valueDescriptions) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(lovUid);
    args_[3] = TcUtility.createArgStringUnion(valueDescriptions);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTListOfValues", "setValueDescriptions", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setBasedOnLovShownIndexes(String lovUid, String basedOnLOVUid, boolean allShown, int[] shown_values_indexes) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(lovUid);
    args_[3] = TcUtility.createArgStringUnion(basedOnLOVUid);
    args_[4] = TcUtility.createArg(allShown);
    args_[5] = TcUtility.createArg(shown_values_indexes);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTListOfValues", "setBasedOnLovShownIndexes", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setValueClassifications(String hLovUid, String classification, String[] bLovUids, int[] values_indexes) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(hLovUid);
    args_[3] = TcUtility.createArgStringUnion(classification);
    args_[4] = TcUtility.createArg(bLovUids);
    args_[5] = TcUtility.createArg(values_indexes);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTListOfValues", "setValueClassifications", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void searchListOfValuesInfo(String lovObj, String childLovUid, int parentOrder, lovData_u parentValue, int searchedOrder, lovData_u searchedValue, boolean flatListSearch, lovDataInfoSeq_tHolder lovInfo) throws Exception {
    Arg[] args_ = new Arg[9];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(lovObj);
    args_[3] = TcUtility.createArgStringUnion(childLovUid);
    args_[4] = TcUtility.createArg(parentOrder);
    args_[5] = TcUtility.createArg(parentValue);
    args_[6] = TcUtility.createArg(searchedOrder);
    args_[7] = TcUtility.createArg(searchedValue);
    args_[8] = TcUtility.createArg(flatListSearch);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTListOfValues", "searchListOfValuesInfo", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    lovInfo.value = TcUtility.queryArg(response.output[0], lovInfo.value);
  }

  public void deleteValueFilter(String lovObj, String filterLov) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(lovObj);
    args_[3] = TcUtility.createArg(filterLov);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTListOfValues", "deleteValueFilter", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

}
