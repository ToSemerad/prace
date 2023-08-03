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

public class ICCTForm extends ICCT {
  public ICCTForm(Connection connection) {
    super(connection);
  }

  public ICCTForm(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void create(String name, String description, String type, boolean save, StringHolder typeObj, StringHolder newForm) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(name);
    args_[3] = TcUtility.createArgStringUnion(description);
    args_[4] = TcUtility.createArg(type);
    args_[5] = TcUtility.createArg(save);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTForm", "create", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    typeObj.value = TcUtility.queryArg(response.output[0], typeObj.value);
    newForm.value = TcUtility.queryArg(response.output[1], newForm.value);
  }

  public void getAllFormProperties(String form, StringHolder formTitle, stringSeqValue_uHolder propertyNames, stringValueSeq_tHolder displayNames, propertyDataSeq_tHolder propertyData, stringValueSeq_tHolder propertyUifValues, uidSeqValue_uHolder lovs, longSeq_tHolder maxStringLengths) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(form);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTForm", "getAllFormProperties", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    formTitle.value = TcUtility.queryArg(response.output[0], formTitle.value);
    propertyNames.value = TcUtility.queryArg(response.output[1], propertyNames.value);
    displayNames.value = TcUtility.queryArgStringUnion(response.output[2], displayNames.value);
    propertyData.value = TcUtility.queryArg(response.output[3], propertyData.value);
    propertyUifValues.value = TcUtility.queryArgStringUnion(response.output[4], propertyUifValues.value);
    lovs.value = TcUtility.queryArg(response.output[5], lovs.value);
    maxStringLengths.value = TcUtility.queryArg(response.output[6], maxStringLengths.value);
  }

  public void getFormProperties(String form, String[] thePropertyNames, stringValueSeq_tHolder displayNames, propertyDataSeq_tHolder propertyData, stringValueSeq_tHolder propertyUifValues, uidSeqValue_uHolder lovs, longSeq_tHolder maxStringLengths) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(form);
    args_[3] = TcUtility.createArg(thePropertyNames);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTForm", "getFormProperties", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    displayNames.value = TcUtility.queryArgStringUnion(response.output[0], displayNames.value);
    propertyData.value = TcUtility.queryArg(response.output[1], propertyData.value);
    propertyUifValues.value = TcUtility.queryArgStringUnion(response.output[2], propertyUifValues.value);
    lovs.value = TcUtility.queryArg(response.output[3], lovs.value);
    maxStringLengths.value = TcUtility.queryArg(response.output[4], maxStringLengths.value);
  }

  public void setFormProperty(String form, String propertyName, propertyData_u propertyUIFValue) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(form);
    args_[3] = TcUtility.createArg(propertyName);
    args_[4] = TcUtility.createArg(propertyUIFValue);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTForm", "setFormProperty", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setFormProperties(String form, String[] propertyNames, propertyData_u[] propertyUIFValues) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(form);
    args_[3] = TcUtility.createArg(propertyNames);
    args_[4] = TcUtility.createArg(propertyUIFValues);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTForm", "setFormProperties", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void saveAs(String form, String name, StringHolder newForm) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(form);
    args_[3] = TcUtility.createArgStringUnion(name);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTForm", "saveAs", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    newForm.value = TcUtility.queryArg(response.output[0], newForm.value);
  }

  public void getTypes(uidSeqValue_uHolder formTypes, uidSeqValue_uHolder typeObjs) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTForm", "getTypes", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    formTypes.value = TcUtility.queryArg(response.output[0], formTypes.value);
    typeObjs.value = TcUtility.queryArg(response.output[1], typeObjs.value);
  }

  public void createType(String typeName, String displayFileName, String className, StringHolder type, StringHolder typeTypeObj) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(typeName);
    args_[3] = TcUtility.createArgStringUnion(displayFileName);
    args_[4] = TcUtility.createArgStringUnion(className);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTForm", "createType", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    type.value = TcUtility.queryArg(response.output[0], type.value);
    typeTypeObj.value = TcUtility.queryArg(response.output[1], typeTypeObj.value);
  }

  public void removeType(String formType) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(formType);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTForm", "removeType", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getFormDefinitionInfo(String typeObj, StringHolder displayFileName, StringHolder defClassName) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(typeObj);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTForm", "getFormDefinitionInfo", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    displayFileName.value = TcUtility.queryArgStringUnion(response.output[0], displayFileName.value);
    defClassName.value = TcUtility.queryArgStringUnion(response.output[1], defClassName.value);
  }

  public void setDisplayFileName(String typeObj, String displayFileName) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(typeObj);
    args_[3] = TcUtility.createArgStringUnion(displayFileName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTForm", "setDisplayFileName", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setDefClassName(String typeObj, String defClassName) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(typeObj);
    args_[3] = TcUtility.createArgStringUnion(defClassName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTForm", "setDefClassName", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setFormDefinitionInfo(String typeObj, String displayFileName, String defClassName) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(typeObj);
    args_[3] = TcUtility.createArgStringUnion(displayFileName);
    args_[4] = TcUtility.createArgStringUnion(defClassName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTForm", "setFormDefinitionInfo", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setTCFormProperty(String form, String propertyname, propertyData_u value, StringHolder uifValue) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(form);
    args_[3] = TcUtility.createArg(propertyname);
    args_[4] = TcUtility.createArg(value);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTForm", "setTCFormProperty", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    uifValue.value = TcUtility.queryArgStringUnion(response.output[0], uifValue.value);
  }

  public void getTCFormProperty(String form, String propertyname, StringHolder uifValue, propertyData_uHolder value) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(form);
    args_[3] = TcUtility.createArg(propertyname);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTForm", "getTCFormProperty", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    uifValue.value = TcUtility.queryArgStringUnion(response.output[0], uifValue.value);
    value.value = TcUtility.queryArg(response.output[1], value.value);
  }

  public void getAllFormPropertyDescriptors(String form, propertyDescriptorSeq_tHolder propDescriptors) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(form);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTForm", "getAllFormPropertyDescriptors", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    propDescriptors.value = TcUtility.queryArg(response.output[0], propDescriptors.value);
  }

  public void getItemMasterFormType(String itemtype, StringHolder formtype) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(itemtype);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTForm", "getItemMasterFormType", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    formtype.value = TcUtility.queryArgStringUnion(response.output[0], formtype.value);
  }

  public void getItemRevMasterFormType(String itemtype, StringHolder formtype) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(itemtype);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTForm", "getItemRevMasterFormType", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    formtype.value = TcUtility.queryArgStringUnion(response.output[0], formtype.value);
  }

  public void setInIcContext(String form) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(form);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTForm", "setInIcContext", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void resetInIcContext(String form) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(form);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTForm", "resetInIcContext", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

}
