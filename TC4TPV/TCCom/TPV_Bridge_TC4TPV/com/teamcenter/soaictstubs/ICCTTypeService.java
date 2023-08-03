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

public class ICCTTypeService {
  ICTService m_service;

  Connection m_connection;


  public ICCTTypeService(Connection connection) {
    m_service = ICTService.getService( connection );
    m_connection = connection;
  }

  public boolean isTypeOf(String typeObj, String[] types) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(typeObj);
    args_[1] = TcUtility.createArgStringUnion(types);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTypeService", "isTypeOf", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    boolean argValue_ =false;
    return (boolean) TcUtility.queryArg(response.output[0], argValue_);
  }

  public void find(String typeName, StringHolder typeObj) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(typeName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTypeService", "find", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    typeObj.value = TcUtility.queryArg(response.output[0], typeObj.value);
  }

  public void getObjectType(String obj, StringHolder objType) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(obj);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTypeService", "getObjectType", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    objType.value = TcUtility.queryArg(response.output[0], objType.value);
  }

  public void getObjectTypes(String[] objs, uidSeqValue_uHolder objTypes) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(objs);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTypeService", "getObjectTypes", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    objTypes.value = TcUtility.queryArg(response.output[0], objTypes.value);
  }

  public void getObjectTypesForQueryResult(String[] objs, String query_uid, uidValueSeq_tHolder objTypes) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(objs);
    args_[1] = TcUtility.createArg(query_uid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTypeService", "getObjectTypesForQueryResult", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    objTypes.value = TcUtility.queryArgStringUnion(response.output[0], objTypes.value);
  }

  public void getTypeName(String objType, StringHolder objTypeName) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(objType);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTypeService", "getTypeName", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    objTypeName.value = TcUtility.queryArg(response.output[0], objTypeName.value);
  }

  public void getTypes(String className, uidSeqValue_uHolder objs, uidSeqValue_uHolder objTypes) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(className);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTypeService", "getTypes", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    objs.value = TcUtility.queryArg(response.output[0], objs.value);
    objTypes.value = TcUtility.queryArg(response.output[1], objTypes.value);
  }

  public void createType(String typeName, String className, StringHolder type, StringHolder typeType) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(typeName);
    args_[1] = TcUtility.createArg(className);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTypeService", "createType", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    type.value = TcUtility.queryArg(response.output[0], type.value);
    typeType.value = TcUtility.queryArg(response.output[1], typeType.value);
  }

  public void removeType(String type) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(type);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTypeService", "removeType", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getTypeNames(stringSeq_tHolder typeNames) throws Exception {
    Arg[] args_ = new Arg[0];
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTypeService", "getTypeNames", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    typeNames.value = TcUtility.queryArg(response.output[0], typeNames.value);
  }

  public void createCompoundPropertyDef(String displayTypeName, String cpName, String sourceTypeName, String sourcePropName, String objHierarchy, boolean isReadOnly, StringHolder cpdefObj, StringHolder cpdefTypeObj) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(displayTypeName);
    args_[1] = TcUtility.createArg(cpName);
    args_[2] = TcUtility.createArg(sourceTypeName);
    args_[3] = TcUtility.createArg(sourcePropName);
    args_[4] = TcUtility.createArg(objHierarchy);
    args_[5] = TcUtility.createArg(isReadOnly);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTypeService", "createCompoundPropertyDef", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    cpdefObj.value = TcUtility.queryArg(response.output[0], cpdefObj.value);
    cpdefTypeObj.value = TcUtility.queryArg(response.output[1], cpdefTypeObj.value);
  }

  public void modifyCompoundPropertyDef(String cpdefObj, String newdisplayTypeName, String newcpName, String newsourceTypeName, String newsourcePropName, String newobjHierarchy, boolean isReadOnly) throws Exception {
    Arg[] args_ = new Arg[7];
    args_[0] = TcUtility.createArg(cpdefObj);
    args_[1] = TcUtility.createArg(newdisplayTypeName);
    args_[2] = TcUtility.createArg(newcpName);
    args_[3] = TcUtility.createArg(newsourceTypeName);
    args_[4] = TcUtility.createArg(newsourcePropName);
    args_[5] = TcUtility.createArg(newobjHierarchy);
    args_[6] = TcUtility.createArg(isReadOnly);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTypeService", "modifyCompoundPropertyDef", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getCompoundPropertyDefs(String displayTypeName, uidSeqValue_uHolder cpdefObjs, uidSeqValue_uHolder cpdefTypeObjs) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(displayTypeName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTypeService", "getCompoundPropertyDefs", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    cpdefObjs.value = TcUtility.queryArg(response.output[0], cpdefObjs.value);
    cpdefTypeObjs.value = TcUtility.queryArg(response.output[1], cpdefTypeObjs.value);
  }

  public void hideTypes(String targetGroup, String[] typesToBeHidden) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArgStringUnion(targetGroup);
    args_[1] = TcUtility.createArg(typesToBeHidden);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTypeService", "hideTypes", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void showTypes(String targetGroup, String[] typesToBeShown) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArgStringUnion(targetGroup);
    args_[1] = TcUtility.createArg(typesToBeShown);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTypeService", "showTypes", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void showAndHideTypes(String accessor, String className, stringSeqValue_u typesToBeShown, stringSeqValue_u typesToBeHidden) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArgStringUnion(accessor);
    args_[1] = TcUtility.createArg(className);
    args_[2] = TcUtility.createArg(typesToBeShown);
    args_[3] = TcUtility.createArg(typesToBeHidden);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTypeService", "showAndHideTypes", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getDisplayableTypesForClassAndAccessor(String className, String accessor, boolean includeSubclasses, stringSeqValue_uHolder displayableTypeNames) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(className);
    args_[1] = TcUtility.createArgStringUnion(accessor);
    args_[2] = TcUtility.createArg(includeSubclasses);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTypeService", "getDisplayableTypesForClassAndAccessor", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    displayableTypeNames.value = TcUtility.queryArg(response.output[0], displayableTypeNames.value);
  }

  public void getHiddenTypesForClassAndAccessor(String className, String accessor, boolean includeSubclasses, stringSeqValue_uHolder hiddenTypeNames, longSeqValue_uHolder displayDetails) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(className);
    args_[1] = TcUtility.createArgStringUnion(accessor);
    args_[2] = TcUtility.createArg(includeSubclasses);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTypeService", "getHiddenTypesForClassAndAccessor", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    hiddenTypeNames.value = TcUtility.queryArg(response.output[0], hiddenTypeNames.value);
    displayDetails.value = TcUtility.queryArg(response.output[1], displayDetails.value);
  }

  public void getTypeDisplaySummaryForAccessors(String[] acessors, stringValueSeq_tHolder shownTypes) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArgStringUnion(acessors);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTypeService", "getTypeDisplaySummaryForAccessors", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    shownTypes.value = TcUtility.queryArgStringUnion(response.output[0], shownTypes.value);
  }

  public void getTypeDisplaySummaryForTypes(String[] typeNames, stringValueSeq_tHolder accessors) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(typeNames);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTypeService", "getTypeDisplaySummaryForTypes", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    accessors.value = TcUtility.queryArgStringUnion(response.output[0], accessors.value);
  }

  public void getTypeNameAndFactoryName(String type, StringHolder typeName, StringHolder factoryName) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(type);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTypeService", "getTypeNameAndFactoryName", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    typeName.value = TcUtility.queryArg(response.output[0], typeName.value);
    factoryName.value = TcUtility.queryArg(response.output[1], factoryName.value);
  }

  public void getCreateProperties(String typeName, stringSeq_tHolder propDescriptors, booleanSeq_tHolder required, booleanSeq_tHolder enabled) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(typeName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTypeService", "getCreateProperties", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    propDescriptors.value = TcUtility.queryArg(response.output[0], propDescriptors.value);
    required.value = TcUtility.queryArg(response.output[1], required.value);
    enabled.value = TcUtility.queryArg(response.output[2], enabled.value);
  }

  public void getViewerProperties(String typeName, stringSeq_tHolder propDescriptors, booleanSeq_tHolder required, booleanSeq_tHolder enabled) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(typeName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTypeService", "getViewerProperties", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    propDescriptors.value = TcUtility.queryArg(response.output[0], propDescriptors.value);
    required.value = TcUtility.queryArg(response.output[1], required.value);
    enabled.value = TcUtility.queryArg(response.output[2], enabled.value);
  }

  public void getTypeInfoHierarchy(String className, boolean includeType, TypeInfoHierarchySeq_tHolder typeHierarchy) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArgStringUnion(className);
    args_[1] = TcUtility.createArg(includeType);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTypeService", "getTypeInfoHierarchy", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    typeHierarchy.value = TcUtility.queryArg(response.output[0], typeHierarchy.value);
  }

  public void getPropertyRules(String typeName, propRuleInfoSeqValue_uHolder propRules) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(typeName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTypeService", "getPropertyRules", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    propRules.value = TcUtility.queryArg(response.output[0], propRules.value);
  }

  public void createPropRule(propRuleInfo_s propRule) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(propRule);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTypeService", "createPropRule", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void modifyPropRule(String typeName, String propertyName, propRuleInfo_s propRule) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(typeName);
    args_[1] = TcUtility.createArg(propertyName);
    args_[2] = TcUtility.createArg(propRule);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTypeService", "modifyPropRule", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void deletePropRule(String typeName, String propertyName) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(typeName);
    args_[1] = TcUtility.createArg(propertyName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTypeService", "deletePropRule", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void isPropRuleInherited(String typeName, String propertyName, BooleanHolder isInherited) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(typeName);
    args_[1] = TcUtility.createArg(propertyName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTypeService", "isPropRuleInherited", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    isInherited.value = TcUtility.queryArg(response.output[0], isInherited.value);
  }

  public void getChildTypeNames(String typeName, String childTypeOptions, stringSeqValue_uHolder childTypes) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(typeName);
    args_[1] = TcUtility.createArg(childTypeOptions);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTypeService", "getChildTypeNames", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    childTypes.value = TcUtility.queryArg(response.output[0], childTypes.value);
  }

  public void loadAllDelayedTypes() throws Exception {
    Arg[] args_ = new Arg[0];
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTypeService", "loadAllDelayedTypes", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

}
