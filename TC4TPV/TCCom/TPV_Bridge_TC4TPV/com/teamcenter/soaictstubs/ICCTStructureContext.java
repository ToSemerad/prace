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

public class ICCTStructureContext extends ICCT {
  public ICCTStructureContext(Connection connection) {
    super(connection);
  }

  public ICCTStructureContext(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void create(String name, String type, String desc, StringHolder comp, StringHolder componentType) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(name);
    args_[3] = TcUtility.createArgStringUnion(type);
    args_[4] = TcUtility.createArgStringUnion(desc);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTStructureContext", "create", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    comp.value = TcUtility.queryArg(response.output[0], comp.value);
    componentType.value = TcUtility.queryArg(response.output[1], componentType.value);
  }

  public void setIsComposition(String typeTag, boolean isComp) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(typeTag);
    args_[3] = TcUtility.createArg(isComp);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTStructureContext", "setIsComposition", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void askIsComposition(String typeTag, BooleanHolder isComp) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(typeTag);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTStructureContext", "askIsComposition", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    isComp.value = TcUtility.queryArg(response.output[0], isComp.value);
  }

  public void setIsSingleEndItem(String typeTag, boolean isComp) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(typeTag);
    args_[3] = TcUtility.createArg(isComp);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTStructureContext", "setIsSingleEndItem", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void askIsSingleEndItem(String typeTag, BooleanHolder isComp) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(typeTag);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTStructureContext", "askIsSingleEndItem", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    isComp.value = TcUtility.queryArg(response.output[0], isComp.value);
  }

  public void deleteScType(String typeTag) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(typeTag);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTStructureContext", "deleteScType", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void saveAs(String scTag, String name, String desc, StringHolder newSc) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(scTag);
    args_[3] = TcUtility.createArgStringUnion(name);
    args_[4] = TcUtility.createArgStringUnion(desc);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTStructureContext", "saveAs", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    newSc.value = TcUtility.queryArg(response.output[0], newSc.value);
  }

}
