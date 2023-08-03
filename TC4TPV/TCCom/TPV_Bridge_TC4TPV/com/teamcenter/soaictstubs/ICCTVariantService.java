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

public class ICCTVariantService {
  ICTService m_service;

  Connection m_connection;


  public ICCTVariantService(Connection connection) {
    m_service = ICTService.getService( connection );
    m_connection = connection;
  }

  public void editItemRevVeb(String itemRevision, String bomWindow, StringHolder bomVeb, StringHolder bomVebType) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(itemRevision);
    args_[1] = TcUtility.createArg(bomWindow);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "editItemRevVeb", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    bomVeb.value = TcUtility.queryArg(response.output[0], bomVeb.value);
    bomVebType.value = TcUtility.queryArg(response.output[1], bomVebType.value);
  }

  public void commitVebEdits(String bomVeb) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(bomVeb);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "commitVebEdits", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void abandonVebEdits(String bomVeb) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(bomVeb);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "abandonVebEdits", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void listOptions(String bomVeb, uidSeq_tHolder options, uidSeq_tHolder optionTypes) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(bomVeb);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "listOptions", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    options.value = TcUtility.queryArg(response.output[0], options.value);
    optionTypes.value = TcUtility.queryArg(response.output[1], optionTypes.value);
  }

  public void listFixedDefaults(String bomVeb, uidSeq_tHolder fixedDefaults, uidSeq_tHolder fixedDefaultTypes) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(bomVeb);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "listFixedDefaults", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    fixedDefaults.value = TcUtility.queryArg(response.output[0], fixedDefaults.value);
    fixedDefaultTypes.value = TcUtility.queryArg(response.output[1], fixedDefaultTypes.value);
  }

  public void listDerivedDefaults(String bomVeb, uidSeq_tHolder derivedDefaults, uidSeq_tHolder derivedDefaultTypes) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(bomVeb);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "listDerivedDefaults", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    derivedDefaults.value = TcUtility.queryArg(response.output[0], derivedDefaults.value);
    derivedDefaultTypes.value = TcUtility.queryArg(response.output[1], derivedDefaultTypes.value);
  }

  public void listRuleChecks(String bomVeb, uidSeq_tHolder ruleChecks, uidSeq_tHolder ruleCheckTypes) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(bomVeb);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "listRuleChecks", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    ruleChecks.value = TcUtility.queryArg(response.output[0], ruleChecks.value);
    ruleCheckTypes.value = TcUtility.queryArg(response.output[1], ruleCheckTypes.value);
  }

  public void isModified(String bomVeb, BooleanHolder modified) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(bomVeb);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "isModified", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    modified.value = TcUtility.queryArg(response.output[0], modified.value);
  }

  public void listOptionsInWindow(String bomVeb, uidSeq_tHolder options, uidSeq_tHolder optionTypes) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(bomVeb);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "listOptionsInWindow", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    options.value = TcUtility.queryArg(response.output[0], options.value);
    optionTypes.value = TcUtility.queryArg(response.output[1], optionTypes.value);
  }

  public void listOptionRevisionsByNameInWindow(String bomVeb, String optionName, String itemId, String item, uidSeq_tHolder optionRevisions, uidSeq_tHolder optionRevisionTypes) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(bomVeb);
    args_[1] = TcUtility.createArgStringUnion(optionName);
    args_[2] = TcUtility.createArgStringUnion(itemId);
    args_[3] = TcUtility.createArgStringUnion(item);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "listOptionRevisionsByNameInWindow", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    optionRevisions.value = TcUtility.queryArg(response.output[0], optionRevisions.value);
    optionRevisionTypes.value = TcUtility.queryArg(response.output[1], optionRevisionTypes.value);
  }

  public void listOptionRevisionValuesInWindow(String bomVeb, String optionRevision, stringSeqValue_uHolder optionRevisionValues) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(bomVeb);
    args_[1] = TcUtility.createArg(optionRevision);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "listOptionRevisionValuesInWindow", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    optionRevisionValues.value = TcUtility.queryArg(response.output[0], optionRevisionValues.value);
  }

  public void listOptionRevisionsInWindow(String bomVeb, uidSeq_tHolder optionRevisions, uidSeq_tHolder optionRevisionTypes) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(bomVeb);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "listOptionRevisionsInWindow", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    optionRevisions.value = TcUtility.queryArg(response.output[0], optionRevisions.value);
    optionRevisionTypes.value = TcUtility.queryArg(response.output[1], optionRevisionTypes.value);
  }

  public void listOptionValuesInWindow(String bomVeb, String option, stringSeqValue_uHolder values) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(bomVeb);
    args_[1] = TcUtility.createArg(option);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "listOptionValuesInWindow", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    values.value = TcUtility.queryArg(response.output[0], values.value);
  }

  public void findOptionsInItemInWindow(String bomVeb, String optionName, String item, uidSeq_tHolder options, uidSeq_tHolder optionTypes) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(bomVeb);
    args_[1] = TcUtility.createArgStringUnion(optionName);
    args_[2] = TcUtility.createArg(item);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "findOptionsInItemInWindow", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    options.value = TcUtility.queryArg(response.output[0], options.value);
    optionTypes.value = TcUtility.queryArg(response.output[1], optionTypes.value);
  }

  public void createOption(String bomVeb, String name, String description, StringHolder option, StringHolder optionType) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(bomVeb);
    args_[1] = TcUtility.createArgStringUnion(name);
    args_[2] = TcUtility.createArgStringUnion(description);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "createOption", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    option.value = TcUtility.queryArg(response.output[0], option.value);
    optionType.value = TcUtility.queryArg(response.output[1], optionType.value);
  }

  public void askOptionName(String option, StringHolder name) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(option);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "askOptionName", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    name.value = TcUtility.queryArgStringUnion(response.output[0], name.value);
  }

  public void askOptionDescription(String option, StringHolder description) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(option);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "askOptionDescription", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    description.value = TcUtility.queryArgStringUnion(response.output[0], description.value);
  }

  public void setOptionName(String option, String name) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(option);
    args_[1] = TcUtility.createArgStringUnion(name);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "setOptionName", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setOptionDescription(String option, String description) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(option);
    args_[1] = TcUtility.createArgStringUnion(description);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "setOptionDescription", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void listOptionValues(String option, stringSeqValue_uHolder values) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(option);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "listOptionValues", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    values.value = TcUtility.queryArg(response.output[0], values.value);
  }

  public void addOptionValue(String option, String newValue) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(option);
    args_[1] = TcUtility.createArgStringUnion(newValue);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "addOptionValue", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void renameOptionValue(String option, String oldName, String newName) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(option);
    args_[1] = TcUtility.createArgStringUnion(oldName);
    args_[2] = TcUtility.createArgStringUnion(newName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "renameOptionValue", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void removeOptionValue(String option, String oldValue) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(option);
    args_[1] = TcUtility.createArgStringUnion(oldValue);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "removeOptionValue", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void deleteOption(String option, String bomVeb) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(option);
    args_[1] = TcUtility.createArg(bomVeb);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "deleteOption", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void createFixedDefault(String bomVeb, String option, String value, StringHolder fixedDefault, StringHolder fixedDefaultType) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(bomVeb);
    args_[1] = TcUtility.createArg(option);
    args_[2] = TcUtility.createArgStringUnion(value);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "createFixedDefault", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    fixedDefault.value = TcUtility.queryArg(response.output[0], fixedDefault.value);
    fixedDefaultType.value = TcUtility.queryArg(response.output[1], fixedDefaultType.value);
  }

  public void setFixedDefaultOption(String fixedDefault, String option, String value) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(fixedDefault);
    args_[1] = TcUtility.createArg(option);
    args_[2] = TcUtility.createArgStringUnion(value);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "setFixedDefaultOption", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void askFixedDefaultOption(String fixedDefault, StringHolder option, StringHolder optionType, StringHolder value) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(fixedDefault);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "askFixedDefaultOption", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    option.value = TcUtility.queryArg(response.output[0], option.value);
    optionType.value = TcUtility.queryArg(response.output[1], optionType.value);
    value.value = TcUtility.queryArgStringUnion(response.output[2], value.value);
  }

  public void setFixedDefaultValue(String fixedDefault, String value) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(fixedDefault);
    args_[1] = TcUtility.createArgStringUnion(value);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "setFixedDefaultValue", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void deleteFixedDefault(String fixedDefault, String bomVeb) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(fixedDefault);
    args_[1] = TcUtility.createArg(bomVeb);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "deleteFixedDefault", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void createDerivedDefault(String bomVeb, String option, String value, String condition, StringHolder derivedDefault, StringHolder derivedDefaultType) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(bomVeb);
    args_[1] = TcUtility.createArg(option);
    args_[2] = TcUtility.createArgStringUnion(value);
    args_[3] = TcUtility.createArg(condition);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "createDerivedDefault", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    derivedDefault.value = TcUtility.queryArg(response.output[0], derivedDefault.value);
    derivedDefaultType.value = TcUtility.queryArg(response.output[1], derivedDefaultType.value);
  }

  public void setDerivedDefaultCondition(String derivedDefault, String condition) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(derivedDefault);
    args_[1] = TcUtility.createArg(condition);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "setDerivedDefaultCondition", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void askDerivedDefaultCondition(String derivedDefault, StringHolder condition, StringHolder conditionType) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(derivedDefault);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "askDerivedDefaultCondition", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    condition.value = TcUtility.queryArg(response.output[0], condition.value);
    conditionType.value = TcUtility.queryArg(response.output[1], conditionType.value);
  }

  public void setDerivedDefaultOption(String derivedDefault, String option, String value) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(derivedDefault);
    args_[1] = TcUtility.createArg(option);
    args_[2] = TcUtility.createArgStringUnion(value);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "setDerivedDefaultOption", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void askDerivedDefaultOption(String derivedDefault, StringHolder option, StringHolder optionType, StringHolder value) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(derivedDefault);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "askDerivedDefaultOption", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    option.value = TcUtility.queryArg(response.output[0], option.value);
    optionType.value = TcUtility.queryArg(response.output[1], optionType.value);
    value.value = TcUtility.queryArgStringUnion(response.output[2], value.value);
  }

  public void setDerivedDefaultValue(String derivedDefault, String value) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(derivedDefault);
    args_[1] = TcUtility.createArgStringUnion(value);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "setDerivedDefaultValue", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void deleteDerivedDefault(String derivedDefault, String bomVeb) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(derivedDefault);
    args_[1] = TcUtility.createArg(bomVeb);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "deleteDerivedDefault", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void createRuleCheck(String bomVeb, String errorText, String condition, StringHolder ruleCheck, StringHolder ruleCheckType) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(bomVeb);
    args_[1] = TcUtility.createArgStringUnion(errorText);
    args_[2] = TcUtility.createArg(condition);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "createRuleCheck", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    ruleCheck.value = TcUtility.queryArg(response.output[0], ruleCheck.value);
    ruleCheckType.value = TcUtility.queryArg(response.output[1], ruleCheckType.value);
  }

  public void setRuleCheckCondition(String ruleCheck, String condition) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(ruleCheck);
    args_[1] = TcUtility.createArg(condition);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "setRuleCheckCondition", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void askRuleCheckCondition(String ruleCheck, StringHolder condition, StringHolder conditionType) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(ruleCheck);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "askRuleCheckCondition", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    condition.value = TcUtility.queryArg(response.output[0], condition.value);
    conditionType.value = TcUtility.queryArg(response.output[1], conditionType.value);
  }

  public void setRuleCheckText(String ruleCheck, String errorText) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(ruleCheck);
    args_[1] = TcUtility.createArgStringUnion(errorText);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "setRuleCheckText", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void askRuleCheckText(String ruleCheck, StringHolder errorText) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(ruleCheck);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "askRuleCheckText", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    errorText.value = TcUtility.queryArgStringUnion(response.output[0], errorText.value);
  }

  public void deleteRuleCheck(String ruleCheck, String bomVeb) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(ruleCheck);
    args_[1] = TcUtility.createArg(bomVeb);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "deleteRuleCheck", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void createClauseList(String bomWindow, StringHolder clauseList, StringHolder clauseListType) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(bomWindow);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "createClauseList", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    clauseList.value = TcUtility.queryArg(response.output[0], clauseList.value);
    clauseListType.value = TcUtility.queryArg(response.output[1], clauseListType.value);
  }

  public void conditionToClauseList(String bomWindow, String condition, StringHolder clauseList, StringHolder clauseListType) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(bomWindow);
    args_[1] = TcUtility.createArg(condition);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "conditionToClauseList", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    clauseList.value = TcUtility.queryArg(response.output[0], clauseList.value);
    clauseListType.value = TcUtility.queryArg(response.output[1], clauseListType.value);
  }

  public void clauseListToCondition(String clauseList, StringHolder condition, StringHolder conditionType) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(clauseList);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "clauseListToCondition", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    condition.value = TcUtility.queryArg(response.output[0], condition.value);
    conditionType.value = TcUtility.queryArg(response.output[1], conditionType.value);
  }

  public void deleteClauseList(String clauseList) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(clauseList);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "deleteClauseList", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void editConditionToClauseList(String bomVeb, String condition, StringHolder clauseList, StringHolder clauseListType) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(bomVeb);
    args_[1] = TcUtility.createArg(condition);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "editConditionToClauseList", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    clauseList.value = TcUtility.queryArg(response.output[0], clauseList.value);
    clauseListType.value = TcUtility.queryArg(response.output[1], clauseListType.value);
  }

  public void setClauseListVebContext(String clauseList, String bomVeb) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(clauseList);
    args_[1] = TcUtility.createArgStringUnion(bomVeb);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "setClauseListVebContext", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void clauseListSize(String clauseList, IntHolder nClauses) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(clauseList);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "clauseListSize", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    nClauses.value = TcUtility.queryArg(response.output[0], nClauses.value);
  }

  public void clauseListText(String clauseList, stringSeqValue_uHolder text) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(clauseList);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "clauseListText", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    text.value = TcUtility.queryArg(response.output[0], text.value);
  }

  public void askClauseDetails(String clauseList, int position, IntHolder join, StringHolder option, StringHolder optionType, IntHolder op, StringHolder value) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(clauseList);
    args_[1] = TcUtility.createArg(position);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "askClauseDetails", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    join.value = TcUtility.queryArg(response.output[0], join.value);
    option.value = TcUtility.queryArg(response.output[1], option.value);
    optionType.value = TcUtility.queryArg(response.output[2], optionType.value);
    op.value = TcUtility.queryArg(response.output[3], op.value);
    value.value = TcUtility.queryArgStringUnion(response.output[4], value.value);
  }

  public void appendClause(String clauseList, int join, String option, int op, String value) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(clauseList);
    args_[1] = TcUtility.createArg(join);
    args_[2] = TcUtility.createArg(option);
    args_[3] = TcUtility.createArg(op);
    args_[4] = TcUtility.createArgStringUnion(value);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "appendClause", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void insertClause(String clauseList, int position, int join, String option, int op, String value) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(clauseList);
    args_[1] = TcUtility.createArg(position);
    args_[2] = TcUtility.createArg(join);
    args_[3] = TcUtility.createArg(option);
    args_[4] = TcUtility.createArg(op);
    args_[5] = TcUtility.createArgStringUnion(value);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "insertClause", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void replaceClause(String clauseList, int position, int join, String option, int op, String value) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(clauseList);
    args_[1] = TcUtility.createArg(position);
    args_[2] = TcUtility.createArg(join);
    args_[3] = TcUtility.createArg(option);
    args_[4] = TcUtility.createArg(op);
    args_[5] = TcUtility.createArgStringUnion(value);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "replaceClause", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void deleteClause(String clauseList, int nClauses, int[] positions) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(clauseList);
    args_[1] = TcUtility.createArg(nClauses);
    args_[2] = TcUtility.createArg(positions);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "deleteClause", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void moveClauseUp(String clauseList, int nClauses, int[] positions) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(clauseList);
    args_[1] = TcUtility.createArg(nClauses);
    args_[2] = TcUtility.createArg(positions);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "moveClauseUp", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void moveClauseDown(String clauseList, int nClauses, int[] positions) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(clauseList);
    args_[1] = TcUtility.createArg(nClauses);
    args_[2] = TcUtility.createArg(positions);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "moveClauseDown", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void toggleClauseBrackets(String clauseList, int nClauses, int[] positions) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(clauseList);
    args_[1] = TcUtility.createArg(nClauses);
    args_[2] = TcUtility.createArg(positions);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "toggleClauseBrackets", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void bracketsCanBeAdded(String clauseList, int nClauses, int[] positions, BooleanHolder canBeAdded) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(clauseList);
    args_[1] = TcUtility.createArg(nClauses);
    args_[2] = TcUtility.createArg(positions);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "bracketsCanBeAdded", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    canBeAdded.value = TcUtility.queryArg(response.output[0], canBeAdded.value);
  }

  public void bracketsCanBeRemoved(String clauseList, int nClauses, int[] positions, BooleanHolder canBeRemoved) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(clauseList);
    args_[1] = TcUtility.createArg(nClauses);
    args_[2] = TcUtility.createArg(positions);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "bracketsCanBeRemoved", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    canBeRemoved.value = TcUtility.queryArg(response.output[0], canBeRemoved.value);
  }

  public void getSos(String bomLine, StringHolder sos) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(bomLine);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "getSos", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    sos.value = TcUtility.queryArg(response.output[0], sos.value);
  }

  public void clearSos(String bomLine) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(bomLine);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "clearSos", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void applySos(String sos, boolean doUpdates) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(sos);
    args_[1] = TcUtility.createArg(doUpdates);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "applySos", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getWindowMessages(String bomWindow, longSeq_tHolder severities, stringSeq_tHolder messages, uidSeq_tHolder lines) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(bomWindow);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "getWindowMessages", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    severities.value = TcUtility.queryArg(response.output[0], severities.value);
    messages.value = TcUtility.queryArg(response.output[1], messages.value);
    lines.value = TcUtility.queryArg(response.output[2], lines.value);
  }

  public void oveValidateBomLine(String line, boolean recurse, longSeq_tHolder error_types, uidSeq_tHolder lines, longSeq_tHolder options) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(line);
    args_[1] = TcUtility.createArg(recurse);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "oveValidateBomLine", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    error_types.value = TcUtility.queryArg(response.output[0], error_types.value);
    lines.value = TcUtility.queryArg(response.output[1], lines.value);
    options.value = TcUtility.queryArg(response.output[2], options.value);
  }

  public void decomposeOvePath(String path, stringSeq_tHolder pathElements) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArgStringUnion(path);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "decomposeOvePath", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    pathElements.value = TcUtility.queryArg(response.output[0], pathElements.value);
  }

  public void getSosEntries(String sos, longSeq_tHolder options, stringValueSeq_tHolder paths) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(sos);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "getSosEntries", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    options.value = TcUtility.queryArg(response.output[0], options.value);
    paths.value = TcUtility.queryArgStringUnion(response.output[1], paths.value);
  }

  public void sosAskEntryInt(String sos, int option, String path, IntHolder value, IntHolder howSet) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(sos);
    args_[1] = TcUtility.createArg(option);
    args_[2] = TcUtility.createArgStringUnion(path);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "sosAskEntryInt", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    value.value = TcUtility.queryArg(response.output[0], value.value);
    howSet.value = TcUtility.queryArg(response.output[1], howSet.value);
  }

  public void sosAskEntryDouble(String sos, int option, String path, DoubleHolder value, IntHolder howSet) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(sos);
    args_[1] = TcUtility.createArg(option);
    args_[2] = TcUtility.createArgStringUnion(path);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "sosAskEntryDouble", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    value.value = TcUtility.queryArg(response.output[0], value.value);
    howSet.value = TcUtility.queryArg(response.output[1], howSet.value);
  }

  public void sosAskEntryLogical(String sos, int option, String path, BooleanHolder value, IntHolder howSet) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(sos);
    args_[1] = TcUtility.createArg(option);
    args_[2] = TcUtility.createArgStringUnion(path);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "sosAskEntryLogical", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    value.value = TcUtility.queryArg(response.output[0], value.value);
    howSet.value = TcUtility.queryArg(response.output[1], howSet.value);
  }

  public void sosAskEntryDisplay(String sos, int option, String path, StringHolder value, IntHolder howSet) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(sos);
    args_[1] = TcUtility.createArg(option);
    args_[2] = TcUtility.createArgStringUnion(path);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "sosAskEntryDisplay", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    value.value = TcUtility.queryArgStringUnion(response.output[0], value.value);
    howSet.value = TcUtility.queryArg(response.output[1], howSet.value);
  }

  public void sosSetEntryInt(String sos, int option, String path, int value, int howSet) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(sos);
    args_[1] = TcUtility.createArg(option);
    args_[2] = TcUtility.createArgStringUnion(path);
    args_[3] = TcUtility.createArg(value);
    args_[4] = TcUtility.createArg(howSet);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "sosSetEntryInt", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void sosSetEntryDouble(String sos, int option, String path, double value, int howSet) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(sos);
    args_[1] = TcUtility.createArg(option);
    args_[2] = TcUtility.createArgStringUnion(path);
    args_[3] = TcUtility.createArg(value);
    args_[4] = TcUtility.createArg(howSet);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "sosSetEntryDouble", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void sosSetEntryLogical(String sos, int option, String path, boolean value, int howSet) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(sos);
    args_[1] = TcUtility.createArg(option);
    args_[2] = TcUtility.createArgStringUnion(path);
    args_[3] = TcUtility.createArg(value);
    args_[4] = TcUtility.createArg(howSet);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "sosSetEntryLogical", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void sosSetEntryString(String sos, int option, String path, String value, int howSet) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(sos);
    args_[1] = TcUtility.createArg(option);
    args_[2] = TcUtility.createArgStringUnion(path);
    args_[3] = TcUtility.createArg(value);
    args_[4] = TcUtility.createArg(howSet);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "sosSetEntryString", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void sosUnsetEntry(String sos, int option, String path) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(sos);
    args_[1] = TcUtility.createArg(option);
    args_[2] = TcUtility.createArgStringUnion(path);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "sosUnsetEntry", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void describeOption(int option, StringHolder item, StringHolder option_name, StringHolder desc, IntHolder visibility, IntHolder option_type, IntHolder value_type, IntHolder based_on, BooleanHolder hasDefault) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(option);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "describeOption", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    item.value = TcUtility.queryArgStringUnion(response.output[0], item.value);
    option_name.value = TcUtility.queryArgStringUnion(response.output[1], option_name.value);
    desc.value = TcUtility.queryArgStringUnion(response.output[2], desc.value);
    visibility.value = TcUtility.queryArg(response.output[3], visibility.value);
    option_type.value = TcUtility.queryArg(response.output[4], option_type.value);
    value_type.value = TcUtility.queryArg(response.output[5], value_type.value);
    based_on.value = TcUtility.queryArg(response.output[6], based_on.value);
    hasDefault.value = TcUtility.queryArg(response.output[7], hasDefault.value);
  }

  public void askOptionPath(int option, StringHolder path) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(option);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "askOptionPath", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    path.value = TcUtility.queryArgStringUnion(response.output[0], path.value);
  }

  public void askOptionAllowedStrings(int option, stringSeq_tHolder values, StringHolder defaultVal) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(option);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "askOptionAllowedStrings", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    values.value = TcUtility.queryArg(response.output[0], values.value);
    defaultVal.value = TcUtility.queryArgStringUnion(response.output[1], defaultVal.value);
  }

  public void askOptionAllowedInts(int option, longSeq_tHolder mins, longSeq_tHolder maxs, longSeq_tHolder rangeTypes, IntHolder defaultVal) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(option);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "askOptionAllowedInts", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    mins.value = TcUtility.queryArg(response.output[0], mins.value);
    maxs.value = TcUtility.queryArg(response.output[1], maxs.value);
    rangeTypes.value = TcUtility.queryArg(response.output[2], rangeTypes.value);
    defaultVal.value = TcUtility.queryArg(response.output[3], defaultVal.value);
  }

  public void askOptionAllowedReals(int option, doubleSeq_tHolder mins, doubleSeq_tHolder maxs, longSeq_tHolder rangeTypes, DoubleHolder defaultVal) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(option);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "askOptionAllowedReals", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    mins.value = TcUtility.queryArg(response.output[0], mins.value);
    maxs.value = TcUtility.queryArg(response.output[1], maxs.value);
    rangeTypes.value = TcUtility.queryArg(response.output[2], rangeTypes.value);
    defaultVal.value = TcUtility.queryArg(response.output[3], defaultVal.value);
  }

  public void askOptionDefaultLogical(int option, BooleanHolder defaultVal) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(option);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "askOptionDefaultLogical", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    defaultVal.value = TcUtility.queryArg(response.output[0], defaultVal.value);
  }

  public void askLineMvlCondition(String line, StringHolder condition) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(line);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "askLineMvlCondition", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    condition.value = TcUtility.queryArgStringUnion(response.output[0], condition.value);
  }

  public void setLineMvlCondition(String line, String condition) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(line);
    args_[1] = TcUtility.createArg(condition);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "setLineMvlCondition", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void askLineMvl(String line, StringHolder condition) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(line);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "askLineMvl", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    condition.value = TcUtility.queryArgStringUnion(response.output[0], condition.value);
  }

  public void setLineMvl(String line, String condition) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(line);
    args_[1] = TcUtility.createArg(condition);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "setLineMvl", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void listModuleOptions(String window, String moduleid, longSeq_tHolder options) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(window);
    args_[1] = TcUtility.createArg(moduleid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "listModuleOptions", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    options.value = TcUtility.queryArg(response.output[0], options.value);
  }

  public void askOptionText(int option, StringHolder text) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(option);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "askOptionText", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    text.value = TcUtility.queryArgStringUnion(response.output[0], text.value);
  }

  public void lineDefineOption(String line, String text) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(line);
    args_[1] = TcUtility.createArg(text);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "lineDefineOption", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void lineDeleteOption(String line, int option) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(line);
    args_[1] = TcUtility.createArg(option);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "lineDeleteOption", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void lineChangeOption(String line, int option, String text) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(line);
    args_[1] = TcUtility.createArg(option);
    args_[2] = TcUtility.createArg(text);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "lineChangeOption", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void createVariantConfig(String bom_vrule, String[] bomsoslist, StringHolder bom_variant_config) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(bom_vrule);
    args_[1] = TcUtility.createArg(bomsoslist);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "createVariantConfig", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    bom_variant_config.value = TcUtility.queryArg(response.output[0], bom_variant_config.value);
  }

  public void createWindowVariantConfig(String bom_window, int mode, StringHolder bom_variant_config) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(bom_window);
    args_[1] = TcUtility.createArg(mode);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "createWindowVariantConfig", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    bom_variant_config.value = TcUtility.queryArg(response.output[0], bom_variant_config.value);
  }

  public void createBomlineVariantConfig(String bom_line, int mode, StringHolder bom_variant_config) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(bom_line);
    args_[1] = TcUtility.createArg(mode);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "createBomlineVariantConfig", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    bom_variant_config.value = TcUtility.queryArg(response.output[0], bom_variant_config.value);
  }

  public void deleteVariantConfig(String bom_variant_config) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(bom_variant_config);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "deleteVariantConfig", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void applyVariantConfig(String bom_variant_config) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(bom_variant_config);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "applyVariantConfig", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void clearVariantConfig(String bom_variant_config) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(bom_variant_config);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "clearVariantConfig", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void evaluateVariantConfig(String bom_variant_config) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(bom_variant_config);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "evaluateVariantConfig", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void copyVariantConfig(String source_config, boolean deepCopy, StringHolder new_config) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(source_config);
    args_[1] = TcUtility.createArg(deepCopy);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "copyVariantConfig", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    new_config.value = TcUtility.queryArg(response.output[0], new_config.value);
  }

  public void setVariantConfigBomVRule(String bom_variant_config, String bom_vrule, int mode) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(bom_variant_config);
    args_[1] = TcUtility.createArg(bom_vrule);
    args_[2] = TcUtility.createArg(mode);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "setVariantConfigBomVRule", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setVariantConfigBomSos(String bom_variant_config, String bom_line, String bom_sos, int mode) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(bom_variant_config);
    args_[1] = TcUtility.createArg(bom_line);
    args_[2] = TcUtility.createArg(bom_sos);
    args_[3] = TcUtility.createArg(mode);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "setVariantConfigBomSos", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void askVariantConfig(String bom_variant_config, StringHolder bom_vrule, uidSeq_tHolder bomsoslist) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(bom_variant_config);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "askVariantConfig", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    bom_vrule.value = TcUtility.queryArg(response.output[0], bom_vrule.value);
    bomsoslist.value = TcUtility.queryArg(response.output[1], bomsoslist.value);
  }

  public void askVariantConfigContext(String bom_variant_config, StringHolder bom_window, StringHolder root_bom_line) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(bom_variant_config);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "askVariantConfigContext", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    bom_window.value = TcUtility.queryArg(response.output[0], bom_window.value);
    root_bom_line.value = TcUtility.queryArg(response.output[1], root_bom_line.value);
  }

  public void readVariantConfiguration(String db_sos, String bom_variant_config) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(db_sos);
    args_[1] = TcUtility.createArg(bom_variant_config);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "readVariantConfiguration", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void writeVariantConfiguration(String db_sos_name, String bom_variant_config, StringHolder db_sos) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(db_sos_name);
    args_[1] = TcUtility.createArg(bom_variant_config);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "writeVariantConfiguration", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    db_sos.value = TcUtility.queryArg(response.output[0], db_sos.value);
  }

  public void overwriteVariantConfiguration(String db_sos, String bom_variant_config) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(db_sos);
    args_[1] = TcUtility.createArg(bom_variant_config);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "overwriteVariantConfiguration", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void askVariantConfiguration(String db_sos, stringSeq_tHolder items, stringSeq_tHolder options, longSeq_tHolder optionTypes, longSeq_tHolder valueTypes, longSeq_tHolder howSet, stringSeq_tHolder values) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(db_sos);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "askVariantConfiguration", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    items.value = TcUtility.queryArg(response.output[0], items.value);
    options.value = TcUtility.queryArg(response.output[1], options.value);
    optionTypes.value = TcUtility.queryArg(response.output[2], optionTypes.value);
    valueTypes.value = TcUtility.queryArg(response.output[3], valueTypes.value);
    howSet.value = TcUtility.queryArg(response.output[4], howSet.value);
    values.value = TcUtility.queryArg(response.output[5], values.value);
  }

  public void askVariantConfigurationValues(String db_sos, stringSeq_tHolder items, stringSeq_tHolder options, longSeq_tHolder optionTypes, longSeq_tHolder valueTypes, longSeq_tHolder howSet, stringSeq_tHolder values) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(db_sos);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "askVariantConfigurationValues", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    items.value = TcUtility.queryArg(response.output[0], items.value);
    options.value = TcUtility.queryArg(response.output[1], options.value);
    optionTypes.value = TcUtility.queryArg(response.output[2], optionTypes.value);
    valueTypes.value = TcUtility.queryArg(response.output[3], valueTypes.value);
    howSet.value = TcUtility.queryArg(response.output[4], howSet.value);
    values.value = TcUtility.queryArg(response.output[5], values.value);
  }

  public void askOptionComponent(String option, StringHolder optionComp, StringHolder optionCompType) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(option);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantService", "askOptionComponent", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    optionComp.value = TcUtility.queryArg(response.output[0], optionComp.value);
    optionCompType.value = TcUtility.queryArg(response.output[1], optionCompType.value);
  }

}
