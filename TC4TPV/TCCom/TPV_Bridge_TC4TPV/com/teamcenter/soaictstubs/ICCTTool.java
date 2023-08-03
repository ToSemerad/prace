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

public class ICCTTool extends ICCT {
  public ICCTTool(Connection connection) {
    super(connection);
  }

  public ICCTTool(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void create(String symbol, String name, String version, String description, StringHolder bomViewUid, StringHolder bomViewTypeUid) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(symbol);
    args_[3] = TcUtility.createArg(name);
    args_[4] = TcUtility.createArg(version);
    args_[5] = TcUtility.createArg(description);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTool", "create", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    bomViewUid.value = TcUtility.queryArg(response.output[0], bomViewUid.value);
    bomViewTypeUid.value = TcUtility.queryArg(response.output[1], bomViewTypeUid.value);
  }

  public void setName(String toolUid, String name) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(toolUid);
    args_[3] = TcUtility.createArg(name);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTool", "setName", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setVendorName(String toolUid, String name) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(toolUid);
    args_[3] = TcUtility.createArgStringUnion(name);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTool", "setVendorName", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setClassification(String toolUid, String siteClass) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(toolUid);
    args_[3] = TcUtility.createArgStringUnion(siteClass);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTool", "setClassification", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setReleaseDate(String toolUid, String date) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(toolUid);
    args_[3] = TcUtility.createArg(date);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTool", "setReleaseDate", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void addInputFormat(String toolUid, String format) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(toolUid);
    args_[3] = TcUtility.createArg(format);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTool", "addInputFormat", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void addOutputFormat(String toolUid, String format) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(toolUid);
    args_[3] = TcUtility.createArg(format);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTool", "addOutputFormat", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setDescription(String toolUid, String desc) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(toolUid);
    args_[3] = TcUtility.createArgStringUnion(desc);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTool", "setDescription", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setRevision(String toolUid, String revision) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(toolUid);
    args_[3] = TcUtility.createArgStringUnion(revision);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTool", "setRevision", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setSymbol(String toolUid, String symbol) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(toolUid);
    args_[3] = TcUtility.createArg(symbol);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTTool", "setSymbol", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

}
