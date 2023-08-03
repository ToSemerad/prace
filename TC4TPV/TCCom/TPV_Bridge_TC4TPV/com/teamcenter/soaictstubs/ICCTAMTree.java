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

public class ICCTAMTree extends ICCT {
  public ICCTAMTree(Connection connection) {
    super(connection);
  }

  public ICCTAMTree(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void create(String ruleName, String ruleArgument, String parentNode, String previousNode, String acl, StringHolder newNode, StringHolder typeUid) throws Exception {
    Arg[] args_ = new Arg[7];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(ruleName);
    args_[3] = TcUtility.createArg(ruleArgument);
    args_[4] = TcUtility.createArgStringUnion(parentNode);
    args_[5] = TcUtility.createArgStringUnion(previousNode);
    args_[6] = TcUtility.createArgStringUnion(acl);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAMTree", "create", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    newNode.value = TcUtility.queryArg(response.output[0], newNode.value);
    typeUid.value = TcUtility.queryArg(response.output[1], typeUid.value);
  }

  public void add(String node, String parent, String previousNode) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(node);
    args_[3] = TcUtility.createArgStringUnion(parent);
    args_[4] = TcUtility.createArgStringUnion(previousNode);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAMTree", "add", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void remove(String node) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(node);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAMTree", "remove", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void moveUp(String node) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(node);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAMTree", "moveUp", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void moveDown(String node) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(node);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAMTree", "moveDown", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getParentNode(String node, StringHolder parent, StringHolder typeUid) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(node);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAMTree", "getParentNode", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    parent.value = TcUtility.queryArg(response.output[0], parent.value);
    typeUid.value = TcUtility.queryArg(response.output[1], typeUid.value);
  }

  public void getRootNode(StringHolder rootNode, StringHolder typeUid) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAMTree", "getRootNode", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    rootNode.value = TcUtility.queryArg(response.output[0], rootNode.value);
    typeUid.value = TcUtility.queryArg(response.output[1], typeUid.value);
  }

  public void getChildren(String nodeUid, uidSeqValue_uHolder children, uidSeqValue_uHolder typeUids) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(nodeUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAMTree", "getChildren", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    children.value = TcUtility.queryArg(response.output[0], children.value);
    typeUids.value = TcUtility.queryArg(response.output[1], typeUids.value);
  }

  public void getRuleInfo(String nodeUid, StringHolder rule, StringHolder ruleArg, StringHolder aclUid, StringHolder typeUid) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(nodeUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAMTree", "getRuleInfo", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    rule.value = TcUtility.queryArgStringUnion(response.output[0], rule.value);
    ruleArg.value = TcUtility.queryArgStringUnion(response.output[1], ruleArg.value);
    aclUid.value = TcUtility.queryArg(response.output[2], aclUid.value);
    typeUid.value = TcUtility.queryArg(response.output[3], typeUid.value);
  }

  public void setRuleInfo(String nodeUid, String rule, String ruleArg, String aclUid) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(nodeUid);
    args_[3] = TcUtility.createArgStringUnion(rule);
    args_[4] = TcUtility.createArgStringUnion(ruleArg);
    args_[5] = TcUtility.createArgStringUnion(aclUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAMTree", "setRuleInfo", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void findNodes(String parent, String rule, String ruleArg, uidSeqValue_uHolder nodeUids, uidSeqValue_uHolder nodeTypeUids) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(parent);
    args_[3] = TcUtility.createArgStringUnion(rule);
    args_[4] = TcUtility.createArgStringUnion(ruleArg);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTAMTree", "findNodes", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    nodeUids.value = TcUtility.queryArg(response.output[0], nodeUids.value);
    nodeTypeUids.value = TcUtility.queryArg(response.output[1], nodeTypeUids.value);
  }

}
