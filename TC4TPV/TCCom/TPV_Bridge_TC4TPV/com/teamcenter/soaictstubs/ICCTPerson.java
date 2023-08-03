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

public class ICCTPerson extends ICCT {
  public ICCTPerson(Connection connection) {
    super(connection);
  }

  public ICCTPerson(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void create(String personName, StringHolder person, StringHolder personType) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(personName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPerson", "create", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    person.value = TcUtility.queryArg(response.output[0], person.value);
    personType.value = TcUtility.queryArg(response.output[1], personType.value);
  }

  public void find(String personName, StringHolder uid, StringHolder type) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(personName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPerson", "find", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    uid.value = TcUtility.queryArgStringUnion(response.output[0], uid.value);
    type.value = TcUtility.queryArgStringUnion(response.output[1], type.value);
  }

  public void getPersonNames(stringSeqValue_uHolder personList) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPerson", "getPersonNames", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    personList.value = TcUtility.queryArg(response.output[0], personList.value);
  }

  public void getPersonAndIconIdList(stringSeqValue_uHolder personList, stringSeqValue_uHolder personSiteList, longSeqValue_uHolder personIconIdList) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPerson", "getPersonAndIconIdList", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    personList.value = TcUtility.queryArg(response.output[0], personList.value);
    personSiteList.value = TcUtility.queryArg(response.output[1], personSiteList.value);
    personIconIdList.value = TcUtility.queryArg(response.output[2], personIconIdList.value);
  }

  public void getMappedPersonAttrList(stringSeqValue_uHolder mapped_person_attr_list) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPerson", "getMappedPersonAttrList", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    mapped_person_attr_list.value = TcUtility.queryArg(response.output[0], mapped_person_attr_list.value);
  }

  public void setPersonName(String person, String name) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(person);
    args_[3] = TcUtility.createArg(name);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPerson", "setPersonName", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setPA1(String person, String value) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(person);
    args_[3] = TcUtility.createArgStringUnion(value);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPerson", "setPA1", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setPA2(String person, String value) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(person);
    args_[3] = TcUtility.createArgStringUnion(value);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPerson", "setPA2", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setPA3(String person, String value) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(person);
    args_[3] = TcUtility.createArgStringUnion(value);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPerson", "setPA3", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setPA4(String person, String value) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(person);
    args_[3] = TcUtility.createArgStringUnion(value);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPerson", "setPA4", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setPA5(String person, String value) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(person);
    args_[3] = TcUtility.createArgStringUnion(value);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPerson", "setPA5", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setPA6(String person, String value) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(person);
    args_[3] = TcUtility.createArgStringUnion(value);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPerson", "setPA6", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setPA7(String person, String value) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(person);
    args_[3] = TcUtility.createArgStringUnion(value);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPerson", "setPA7", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setPA8(String person, String value) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(person);
    args_[3] = TcUtility.createArgStringUnion(value);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPerson", "setPA8", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setPA9(String person, String value) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(person);
    args_[3] = TcUtility.createArgStringUnion(value);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPerson", "setPA9", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setPA10(String person, String value) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(person);
    args_[3] = TcUtility.createArgStringUnion(value);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTPerson", "setPA10", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

}
