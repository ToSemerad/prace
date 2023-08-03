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

public class ICCTProject extends ICCT {
  public ICCTProject(Connection connection) {
    super(connection);
  }

  public ICCTProject(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void create(String projectID, String projectName, String projectDesc, String[] members, String admin, String[] privUsers, StringHolder newProject, StringHolder newProjectType) throws Exception {
    Arg[] args_ = new Arg[8];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(projectID);
    args_[3] = TcUtility.createArg(projectName);
    args_[4] = TcUtility.createArgStringUnion(projectDesc);
    args_[5] = TcUtility.createArg(members);
    args_[6] = TcUtility.createArg(admin);
    args_[7] = TcUtility.createArg(privUsers);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTProject", "create", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    newProject.value = TcUtility.queryArg(response.output[0], newProject.value);
    newProjectType.value = TcUtility.queryArg(response.output[1], newProjectType.value);
  }

  public void copy(String proj, String projectID, String projectName, String projectDesc, String[] members, String admin, String[] privUsers, StringHolder newProject, StringHolder newProjectType) throws Exception {
    Arg[] args_ = new Arg[9];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(proj);
    args_[3] = TcUtility.createArg(projectID);
    args_[4] = TcUtility.createArg(projectName);
    args_[5] = TcUtility.createArgStringUnion(projectDesc);
    args_[6] = TcUtility.createArg(members);
    args_[7] = TcUtility.createArg(admin);
    args_[8] = TcUtility.createArg(privUsers);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTProject", "copy", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    newProject.value = TcUtility.queryArg(response.output[0], newProject.value);
    newProjectType.value = TcUtility.queryArg(response.output[1], newProjectType.value);
  }

  public void findProjects(String user, boolean includeInactive, String asRole, uidSeqValue_uHolder projects, uidSeqValue_uHolder projectTypes) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(user);
    args_[3] = TcUtility.createArg(includeInactive);
    args_[4] = TcUtility.createArgStringUnion(asRole);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTProject", "findProjects", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    projects.value = TcUtility.queryArg(response.output[0], projects.value);
    projectTypes.value = TcUtility.queryArg(response.output[1], projectTypes.value);
  }

  public void assignToProjects(String[] projects, String[] components, int folderOption, stringValueSeq_tHolder errorStrings) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(projects);
    args_[3] = TcUtility.createArg(components);
    args_[4] = TcUtility.createArg(folderOption);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTProject", "assignToProjects", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    errorStrings.value = TcUtility.queryArgStringUnion(response.output[0], errorStrings.value);
  }

  public void removeFromProjects(String[] projects, String[] components, int folderOption, stringValueSeq_tHolder errorStrings) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(projects);
    args_[3] = TcUtility.createArg(components);
    args_[4] = TcUtility.createArg(folderOption);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTProject", "removeFromProjects", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    errorStrings.value = TcUtility.queryArgStringUnion(response.output[0], errorStrings.value);
  }

  public void assignBOMLinesToProjects(String[] projects, String[] components, int typeOption, int level, stringValueSeq_tHolder errorStrings) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(projects);
    args_[3] = TcUtility.createArg(components);
    args_[4] = TcUtility.createArg(typeOption);
    args_[5] = TcUtility.createArg(level);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTProject", "assignBOMLinesToProjects", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    errorStrings.value = TcUtility.queryArgStringUnion(response.output[0], errorStrings.value);
  }

  public void removeBOMLinesFromProjects(String[] projects, String[] components, int typeOption, int level, stringValueSeq_tHolder errorStrings) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(projects);
    args_[3] = TcUtility.createArg(components);
    args_[4] = TcUtility.createArg(typeOption);
    args_[5] = TcUtility.createArg(level);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTProject", "removeBOMLinesFromProjects", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    errorStrings.value = TcUtility.queryArgStringUnion(response.output[0], errorStrings.value);
  }

  public void find(String projectID, StringHolder project, StringHolder projectType) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(projectID);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTProject", "find", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    project.value = TcUtility.queryArgStringUnion(response.output[0], project.value);
    projectType.value = TcUtility.queryArgStringUnion(response.output[1], projectType.value);
  }

  public void getTeam(String proj, uidSeqValue_uHolder members, uidSeqValue_uHolder memberTypes, StringHolder teamAdmin, StringHolder teamAdminType, uidSeqValue_uHolder privUsers, uidSeqValue_uHolder privUserTypes) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(proj);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTProject", "getTeam", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    members.value = TcUtility.queryArg(response.output[0], members.value);
    memberTypes.value = TcUtility.queryArg(response.output[1], memberTypes.value);
    teamAdmin.value = TcUtility.queryArgStringUnion(response.output[2], teamAdmin.value);
    teamAdminType.value = TcUtility.queryArgStringUnion(response.output[3], teamAdminType.value);
    privUsers.value = TcUtility.queryArg(response.output[4], privUsers.value);
    privUserTypes.value = TcUtility.queryArg(response.output[5], privUserTypes.value);
  }

  public void modifyTeam(String proj, String[] members, String admin, String[] privUsers) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(proj);
    args_[3] = TcUtility.createArg(members);
    args_[4] = TcUtility.createArg(admin);
    args_[5] = TcUtility.createArg(privUsers);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTProject", "modifyTeam", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

}
