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

public class ICCTVariantRule extends ICCT {
  public ICCTVariantRule(Connection connection) {
    super(connection);
  }

  public ICCTVariantRule(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void apply(String rule) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(rule);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantRule", "apply", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void copy(String sourceRule, String bomWindow, StringHolder destinationRule, StringHolder destinationRuleType) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(sourceRule);
    args_[3] = TcUtility.createArgStringUnion(bomWindow);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantRule", "copy", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    destinationRule.value = TcUtility.queryArg(response.output[0], destinationRule.value);
    destinationRuleType.value = TcUtility.queryArg(response.output[1], destinationRuleType.value);
  }

  public void destroyRule(String rule) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(rule);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantRule", "destroyRule", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getCompleteOptionsData(String rule, uidSeq_tHolder options, uidSeq_tHolder optionTypes, uidSeq_tHolder optionRevs, uidSeq_tHolder optionRevTypes, stringSeq_tHolder itemID, stringSeq_tHolder optionName, stringSeq_tHolder optionDescription, stringValueSeq_tHolder value, stringSeq_tHolder howSet, stringSeq_tHolder whereSet, longSeq_tHolder howSetInt) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(rule);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantRule", "getCompleteOptionsData", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    options.value = TcUtility.queryArg(response.output[0], options.value);
    optionTypes.value = TcUtility.queryArg(response.output[1], optionTypes.value);
    optionRevs.value = TcUtility.queryArg(response.output[2], optionRevs.value);
    optionRevTypes.value = TcUtility.queryArg(response.output[3], optionRevTypes.value);
    itemID.value = TcUtility.queryArg(response.output[4], itemID.value);
    optionName.value = TcUtility.queryArg(response.output[5], optionName.value);
    optionDescription.value = TcUtility.queryArg(response.output[6], optionDescription.value);
    value.value = TcUtility.queryArgStringUnion(response.output[7], value.value);
    howSet.value = TcUtility.queryArg(response.output[8], howSet.value);
    whereSet.value = TcUtility.queryArg(response.output[9], whereSet.value);
    howSetInt.value = TcUtility.queryArg(response.output[10], howSetInt.value);
  }

  public void askVRule(String rule, StringHolder vRule, StringHolder vRuleType, BooleanHolder modified) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(rule);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantRule", "askVRule", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    vRule.value = TcUtility.queryArg(response.output[0], vRule.value);
    vRuleType.value = TcUtility.queryArg(response.output[1], vRuleType.value);
    modified.value = TcUtility.queryArg(response.output[2], modified.value);
  }

  public void askOptions(String rule, uidSeq_tHolder options, uidSeq_tHolder optionTypes, uidSeq_tHolder optionRevs, uidSeq_tHolder optionRevTypes) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(rule);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantRule", "askOptions", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    options.value = TcUtility.queryArg(response.output[0], options.value);
    optionTypes.value = TcUtility.queryArg(response.output[1], optionTypes.value);
    optionRevs.value = TcUtility.queryArg(response.output[2], optionRevs.value);
    optionRevTypes.value = TcUtility.queryArg(response.output[3], optionRevTypes.value);
  }

  public void setOptionValue(String rule, String option, String value) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(rule);
    args_[3] = TcUtility.createArg(option);
    args_[4] = TcUtility.createArgStringUnion(value);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantRule", "setOptionValue", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void askOptionValue(String rule, String option, StringHolder optionRev, StringHolder optionRevType, StringHolder value, IntHolder howSetValue, StringHolder howSet, StringHolder whereSet) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(rule);
    args_[3] = TcUtility.createArg(option);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantRule", "askOptionValue", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    optionRev.value = TcUtility.queryArg(response.output[0], optionRev.value);
    optionRevType.value = TcUtility.queryArg(response.output[1], optionRevType.value);
    value.value = TcUtility.queryArgStringUnion(response.output[2], value.value);
    howSetValue.value = TcUtility.queryArg(response.output[3], howSetValue.value);
    howSet.value = TcUtility.queryArgStringUnion(response.output[4], howSet.value);
    whereSet.value = TcUtility.queryArgStringUnion(response.output[5], whereSet.value);
  }

  public void unsetOptionValue(String rule, String option) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(rule);
    args_[3] = TcUtility.createArg(option);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantRule", "unsetOptionValue", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void clearOptionValues(String rule) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(rule);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantRule", "clearOptionValues", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void askOptionValueIndex(String rule, String option, String value, IntHolder index) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(rule);
    args_[3] = TcUtility.createArg(option);
    args_[4] = TcUtility.createArgStringUnion(value);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantRule", "askOptionValueIndex", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    index.value = TcUtility.queryArg(response.output[0], index.value);
  }

  public void askOptionIndexValue(String rule, String option, int index, StringHolder value) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(rule);
    args_[3] = TcUtility.createArg(option);
    args_[4] = TcUtility.createArg(index);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantRule", "askOptionIndexValue", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    value.value = TcUtility.queryArgStringUnion(response.output[0], value.value);
  }

  public void saveExistingRule(String rule, String vRule, boolean updateOnly, uidSeqValue_u options) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(rule);
    args_[3] = TcUtility.createArg(vRule);
    args_[4] = TcUtility.createArg(updateOnly);
    args_[5] = TcUtility.createArg(options);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantRule", "saveExistingRule", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void saveNewRule(String rule, String name, String description, uidSeqValue_u options, String itemRev, String relationType) throws Exception {
    Arg[] args_ = new Arg[8];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(rule);
    args_[3] = TcUtility.createArgStringUnion(name);
    args_[4] = TcUtility.createArgStringUnion(description);
    args_[5] = TcUtility.createArg(options);
    args_[6] = TcUtility.createArg(itemRev);
    args_[7] = TcUtility.createArgStringUnion(relationType);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantRule", "saveNewRule", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void applyFullVRule(String rule, String vRule, BooleanHolder changed) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(rule);
    args_[3] = TcUtility.createArg(vRule);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantRule", "applyFullVRule", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    changed.value = TcUtility.queryArg(response.output[0], changed.value);
  }

  public void applyPartialVRule(String rule, String vRule, BooleanHolder changed) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(rule);
    args_[3] = TcUtility.createArg(vRule);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantRule", "applyPartialVRule", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    changed.value = TcUtility.queryArg(response.output[0], changed.value);
  }

  public void listOptionRevValues(String optionRev, stringSeqValue_uHolder values) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(optionRev);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantRule", "listOptionRevValues", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    values.value = TcUtility.queryArg(response.output[0], values.value);
  }

  public void listVRules(String itemRev, uidSeq_tHolder vRules, uidSeq_tHolder vRuleTypes) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(itemRev);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantRule", "listVRules", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    vRules.value = TcUtility.queryArg(response.output[0], vRules.value);
    vRuleTypes.value = TcUtility.queryArg(response.output[1], vRuleTypes.value);
  }

  public void askVRuleText(String vRule, String bomWindow, stringSeqValue_uHolder items, stringSeqValue_uHolder options, stringSeqValue_uHolder descriptions, stringSeqValue_uHolder values) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(vRule);
    args_[3] = TcUtility.createArg(bomWindow);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantRule", "askVRuleText", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    items.value = TcUtility.queryArg(response.output[0], items.value);
    options.value = TcUtility.queryArg(response.output[1], options.value);
    descriptions.value = TcUtility.queryArg(response.output[2], descriptions.value);
    values.value = TcUtility.queryArg(response.output[3], values.value);
  }

}
