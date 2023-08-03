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

public class ICCTAccessControlService {
  ICTService m_service;

  Connection m_connection;


  public ICCTAccessControlService(Connection connection) {
    m_service = ICTService.getService( connection );
    m_connection = connection;
  }

  public void getEffectiveACLInfo(String obj, aclInfoSeq_tHolder aclInformation) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(obj);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAccessControlService", "getEffectiveACLInfo", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    aclInformation.value = TcUtility.queryArg(response.output[0], aclInformation.value);
  }

  public void checkPrivilege(String obj, String privliege, BooleanHolder verdict) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(obj);
    args_[1] = TcUtility.createArg(privliege);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAccessControlService", "checkPrivilege", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    verdict.value = TcUtility.queryArg(response.output[0], verdict.value);
  }

  public void checkPrivileges(String obj, String[] privlieges, booleanSeq_tHolder verdicts) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(obj);
    args_[1] = TcUtility.createArg(privlieges);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAccessControlService", "checkPrivileges", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    verdicts.value = TcUtility.queryArg(response.output[0], verdicts.value);
  }

  public void checkUsersPrivilege(String user, String obj, String privilege, BooleanHolder verdict) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(user);
    args_[1] = TcUtility.createArg(obj);
    args_[2] = TcUtility.createArg(privilege);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAccessControlService", "checkUsersPrivilege", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    verdict.value = TcUtility.queryArg(response.output[0], verdict.value);
  }

  public void checkAccessorsPrivilege(String[] accessors, String obj, String privilege, BooleanHolder verdict) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArgStringUnion(accessors);
    args_[1] = TcUtility.createArg(obj);
    args_[2] = TcUtility.createArg(privilege);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAccessControlService", "checkAccessorsPrivilege", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    verdict.value = TcUtility.queryArg(response.output[0], verdict.value);
  }

  public void checkAccessorsPrivileges(String[] accessors, String obj, String[] privileges, booleanSeq_tHolder verdicts) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArgStringUnion(accessors);
    args_[1] = TcUtility.createArg(obj);
    args_[2] = TcUtility.createArg(privileges);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAccessControlService", "checkAccessorsPrivileges", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    verdicts.value = TcUtility.queryArg(response.output[0], verdicts.value);
  }

  public void checkSitesPrivilege(String site, String obj, String privilege, BooleanHolder verdict) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(site);
    args_[1] = TcUtility.createArg(obj);
    args_[2] = TcUtility.createArg(privilege);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAccessControlService", "checkSitesPrivilege", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    verdict.value = TcUtility.queryArg(response.output[0], verdict.value);
  }

  public void grantPrivilege(String acl, String accessor, String[] privileges) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(acl);
    args_[1] = TcUtility.createArg(accessor);
    args_[2] = TcUtility.createArg(privileges);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAccessControlService", "grantPrivilege", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void revokePrivilege(String acl, String accessor, String[] privileges) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(acl);
    args_[1] = TcUtility.createArg(accessor);
    args_[2] = TcUtility.createArg(privileges);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAccessControlService", "revokePrivilege", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void unsetPrivileges(String aclUid, String accessorUid, String[] privileges) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(aclUid);
    args_[1] = TcUtility.createArg(accessorUid);
    args_[2] = TcUtility.createArg(privileges);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAccessControlService", "unsetPrivileges", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void saveAcl(String aclUid) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(aclUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAccessControlService", "saveAcl", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void evaluatePrivilege(String userUid, String objectUid, String privilege, BooleanHolder verdict, stringSeq_tHolder rules, stringSeq_tHolder args, StringHolder aclUid, StringHolder accessorUid) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(userUid);
    args_[1] = TcUtility.createArg(objectUid);
    args_[2] = TcUtility.createArg(privilege);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAccessControlService", "evaluatePrivilege", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    verdict.value = TcUtility.queryArg(response.output[0], verdict.value);
    rules.value = TcUtility.queryArg(response.output[1], rules.value);
    args.value = TcUtility.queryArg(response.output[2], args.value);
    aclUid.value = TcUtility.queryArg(response.output[3], aclUid.value);
    accessorUid.value = TcUtility.queryArg(response.output[4], accessorUid.value);
  }

  public void getPrivilegeNames(String[] privilegeUids, stringSeq_tHolder privilegeNames) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(privilegeUids);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAccessControlService", "getPrivilegeNames", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    privilegeNames.value = TcUtility.queryArg(response.output[0], privilegeNames.value);
  }

  public void getExtraProtectionReport(String userUid, String objectUid, String[] privileges, EPReportSeq_tHolder report) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(userUid);
    args_[1] = TcUtility.createArg(objectUid);
    args_[2] = TcUtility.createArg(privileges);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAccessControlService", "getExtraProtectionReport", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    report.value = TcUtility.queryArg(response.output[0], report.value);
  }

  public void getSessionAccessors(uidSeq_tHolder accessors, uidSeq_tHolder accessorTypes) throws Exception {
    Arg[] args_ = new Arg[0];
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAccessControlService", "getSessionAccessors", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    accessors.value = TcUtility.queryArg(response.output[0], accessors.value);
    accessorTypes.value = TcUtility.queryArg(response.output[1], accessorTypes.value);
  }

  public void getAccessorInfo(String accessor, StringHolder type, StringHolder name) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(accessor);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAccessControlService", "getAccessorInfo", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    type.value = TcUtility.queryArgStringUnion(response.output[0], type.value);
    name.value = TcUtility.queryArgStringUnion(response.output[1], name.value);
  }

  public void getAccessorTypes(stringSeqValue_uHolder accessorTypes) throws Exception {
    Arg[] args_ = new Arg[0];
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAccessControlService", "getAccessorTypes", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    accessorTypes.value = TcUtility.queryArg(response.output[0], accessorTypes.value);
  }

  public void findAccessor(String type, String name, StringHolder accessor, StringHolder typeUid) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArgStringUnion(type);
    args_[1] = TcUtility.createArgStringUnion(name);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAccessControlService", "findAccessor", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    accessor.value = TcUtility.queryArg(response.output[0], accessor.value);
    typeUid.value = TcUtility.queryArg(response.output[1], typeUid.value);
  }

  public void getAccessorsByType(String accessorType, uidSeqValue_uHolder accessors, uidSeqValue_uHolder types) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(accessorType);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAccessControlService", "getAccessorsByType", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    accessors.value = TcUtility.queryArg(response.output[0], accessors.value);
    types.value = TcUtility.queryArg(response.output[1], types.value);
  }

  public void removeAccessor(String acl, String accessor) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(acl);
    args_[1] = TcUtility.createArg(accessor);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAccessControlService", "removeAccessor", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void findNamedUid(String name, StringHolder namedUid, StringHolder typeUid) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(name);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAccessControlService", "findNamedUid", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    namedUid.value = TcUtility.queryArg(response.output[0], namedUid.value);
    typeUid.value = TcUtility.queryArg(response.output[1], typeUid.value);
  }

  public void getNamedUidTypes(uidSeq_tHolder namedUids, uidSeq_tHolder typeUids) throws Exception {
    Arg[] args_ = new Arg[0];
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAccessControlService", "getNamedUidTypes", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    namedUids.value = TcUtility.queryArg(response.output[0], namedUids.value);
    typeUids.value = TcUtility.queryArg(response.output[1], typeUids.value);
  }

  public void getNamedUidName(String namedUid, StringHolder name) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(namedUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAccessControlService", "getNamedUidName", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    name.value = TcUtility.queryArg(response.output[0], name.value);
  }

  public void getAMTree(StringHolder rootNode, StringHolder typeUid) throws Exception {
    Arg[] args_ = new Arg[0];
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAccessControlService", "getAMTree", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    rootNode.value = TcUtility.queryArg(response.output[0], rootNode.value);
    typeUid.value = TcUtility.queryArg(response.output[1], typeUid.value);
  }

  public void getRuleNames(stringSeq_tHolder rules) throws Exception {
    Arg[] args_ = new Arg[0];
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAccessControlService", "getRuleNames", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    rules.value = TcUtility.queryArg(response.output[0], rules.value);
  }

  public void getRuleArguments(String ruleName, stringSeqValue_uHolder ruleArguments) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(ruleName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAccessControlService", "getRuleArguments", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    ruleArguments.value = TcUtility.queryArg(response.output[0], ruleArguments.value);
  }

  public void validateRuleArgument(String ruleName, String ruleArgument, BooleanHolder isValid) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(ruleName);
    args_[1] = TcUtility.createArgStringUnion(ruleArgument);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAccessControlService", "validateRuleArgument", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    isValid.value = TcUtility.queryArg(response.output[0], isValid.value);
  }

  public void saveAMTree() throws Exception {
    Arg[] args_ = new Arg[0];
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAccessControlService", "saveAMTree", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void unloadAMTree() throws Exception {
    Arg[] args_ = new Arg[0];
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAccessControlService", "unloadAMTree", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getNewFile(StringHolder newFileLocation) throws Exception {
    Arg[] args_ = new Arg[0];
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAccessControlService", "getNewFile", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    newFileLocation.value = TcUtility.queryArg(response.output[0], newFileLocation.value);
  }

  public void importAMTree(String pathName, boolean replaceAcls) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(pathName);
    args_[1] = TcUtility.createArg(replaceAcls);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAccessControlService", "importAMTree", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getSecuredFile(StringHolder fileLocation, StringHolder fileType) throws Exception {
    Arg[] args_ = new Arg[0];
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAccessControlService", "getSecuredFile", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    fileLocation.value = TcUtility.queryArg(response.output[0], fileLocation.value);
    fileType.value = TcUtility.queryArg(response.output[1], fileType.value);
  }

  public void removeTempDir(String dirPathName) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(dirPathName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAccessControlService", "removeTempDir", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

}
