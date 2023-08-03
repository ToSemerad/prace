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

public class ICCTRevisionRule extends ICCT {
  public ICCTRevisionRule(Connection connection) {
    super(connection);
  }

  public ICCTRevisionRule(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void create(String revisionRuleName, String revisionRuleDesc, StringHolder revisionRule, StringHolder revisionRuleType) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(revisionRuleName);
    args_[3] = TcUtility.createArgStringUnion(revisionRuleDesc);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRevisionRule", "create", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    revisionRule.value = TcUtility.queryArg(response.output[0], revisionRule.value);
    revisionRuleType.value = TcUtility.queryArg(response.output[1], revisionRuleType.value);
  }

  public void copy(String revisionRule, String newName, StringHolder newRule, StringHolder newRuleType) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(revisionRule);
    args_[3] = TcUtility.createArgStringUnion(newName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRevisionRule", "copy", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    newRule.value = TcUtility.queryArg(response.output[0], newRule.value);
    newRuleType.value = TcUtility.queryArg(response.output[1], newRuleType.value);
  }

  public void cloneInstance(String ruleToClone, String wannabeClone) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(ruleToClone);
    args_[3] = TcUtility.createArg(wannabeClone);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRevisionRule", "cloneInstance", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void isEquivalentPlusDateAndOrUnitNo(String revisionRule, String otherRevisionRule, BooleanHolder verdict, BooleanHolder hasDateEntry, BooleanHolder today, StringHolder dateAsString, BooleanHolder hasUnitNoEntry, IntHolder unitNo) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(revisionRule);
    args_[3] = TcUtility.createArg(otherRevisionRule);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRevisionRule", "isEquivalentPlusDateAndOrUnitNo", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    verdict.value = TcUtility.queryArg(response.output[0], verdict.value);
    hasDateEntry.value = TcUtility.queryArg(response.output[1], hasDateEntry.value);
    today.value = TcUtility.queryArg(response.output[2], today.value);
    dateAsString.value = TcUtility.queryArgStringUnion(response.output[3], dateAsString.value);
    hasUnitNoEntry.value = TcUtility.queryArg(response.output[4], hasUnitNoEntry.value);
    unitNo.value = TcUtility.queryArg(response.output[5], unitNo.value);
  }

  public void configuredRevision(String revisionRule, String item, StringHolder revision, StringHolder revisionType, StringHolder howConfigured) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(revisionRule);
    args_[3] = TcUtility.createArg(item);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRevisionRule", "configuredRevision", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    revision.value = TcUtility.queryArg(response.output[0], revision.value);
    revisionType.value = TcUtility.queryArg(response.output[1], revisionType.value);
    howConfigured.value = TcUtility.queryArgStringUnion(response.output[2], howConfigured.value);
  }

  public void defaultRule(StringHolder rule, StringHolder ruleType) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRevisionRule", "defaultRule", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    rule.value = TcUtility.queryArg(response.output[0], rule.value);
    ruleType.value = TcUtility.queryArg(response.output[1], ruleType.value);
  }

  public void getEntries(String revisionRule, uidSeq_tHolder ruleEntries, uidSeq_tHolder ruleEntriesTypes, longSeq_tHolder ruleEntryInts) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(revisionRule);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRevisionRule", "getEntries", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    ruleEntries.value = TcUtility.queryArg(response.output[0], ruleEntries.value);
    ruleEntriesTypes.value = TcUtility.queryArg(response.output[1], ruleEntriesTypes.value);
    ruleEntryInts.value = TcUtility.queryArg(response.output[2], ruleEntryInts.value);
  }

  public void createEntry(int ruleEntryInt, StringHolder ruleEntry, StringHolder ruleEntryType) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(ruleEntryInt);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRevisionRule", "createEntry", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    ruleEntry.value = TcUtility.queryArg(response.output[0], ruleEntry.value);
    ruleEntryType.value = TcUtility.queryArg(response.output[1], ruleEntryType.value);
  }

  public void add(String revisionRule, String ruleEntry) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(revisionRule);
    args_[3] = TcUtility.createArg(ruleEntry);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRevisionRule", "add", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void replace(String revisionRule, String oldEntry, String newEntry) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(revisionRule);
    args_[3] = TcUtility.createArg(oldEntry);
    args_[4] = TcUtility.createArg(newEntry);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRevisionRule", "replace", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void insert(String revisionRule, String newEntry, String atEntry) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(revisionRule);
    args_[3] = TcUtility.createArg(newEntry);
    args_[4] = TcUtility.createArg(atEntry);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRevisionRule", "insert", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void remove(String revisionRule, String ruleEntry) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(revisionRule);
    args_[3] = TcUtility.createArg(ruleEntry);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRevisionRule", "remove", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void moveUp(String revisionRule, String ruleEntry) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(revisionRule);
    args_[3] = TcUtility.createArg(ruleEntry);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRevisionRule", "moveUp", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void moveDown(String revisionRule, String ruleEntry) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(revisionRule);
    args_[3] = TcUtility.createArg(ruleEntry);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRevisionRule", "moveDown", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void groupAskEntries(String groupEntry, uidSeq_tHolder ruleEntries, uidSeq_tHolder ruleEntriesTypes, longSeq_tHolder ruleEntryInts) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(groupEntry);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRevisionRule", "groupAskEntries", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    ruleEntries.value = TcUtility.queryArg(response.output[0], ruleEntries.value);
    ruleEntriesTypes.value = TcUtility.queryArg(response.output[1], ruleEntriesTypes.value);
    ruleEntryInts.value = TcUtility.queryArg(response.output[2], ruleEntryInts.value);
  }

  public void groupAddEntry(String groupEntry, String entryToAdd) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(groupEntry);
    args_[3] = TcUtility.createArg(entryToAdd);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRevisionRule", "groupAddEntry", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void groupRemoveEntry(String groupEntry, String entryToRemove) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(groupEntry);
    args_[3] = TcUtility.createArg(entryToRemove);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRevisionRule", "groupRemoveEntry", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void createIntent(String name, String desc, StringHolder newIntent, StringHolder newIntentType) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(name);
    args_[3] = TcUtility.createArgStringUnion(desc);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRevisionRule", "createIntent", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    newIntent.value = TcUtility.queryArg(response.output[0], newIntent.value);
    newIntentType.value = TcUtility.queryArg(response.output[1], newIntentType.value);
  }

  public void setIntents(String rule, String[] intents) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(rule);
    args_[3] = TcUtility.createArg(intents);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTRevisionRule", "setIntents", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

}
