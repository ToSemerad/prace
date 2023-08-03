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

public class ICCTEffectivity extends ICCT {
  public ICCTEffectivity(Connection connection) {
    super(connection);
  }

  public ICCTEffectivity(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void create(String releaseStatus, String endItem, StringHolder effectivity, StringHolder effectivityType) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(releaseStatus);
    args_[3] = TcUtility.createArgStringUnion(endItem);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTEffectivity", "create", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    effectivity.value = TcUtility.queryArg(response.output[0], effectivity.value);
    effectivityType.value = TcUtility.queryArg(response.output[1], effectivityType.value);
  }

  public void createFromText(String releaseStatus, String endItem, String rangeText, StringHolder effectivity, StringHolder effectivityType) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(releaseStatus);
    args_[3] = TcUtility.createArg(endItem);
    args_[4] = TcUtility.createArgStringUnion(rangeText);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTEffectivity", "createFromText", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    effectivity.value = TcUtility.queryArg(response.output[0], effectivity.value);
    effectivityType.value = TcUtility.queryArg(response.output[1], effectivityType.value);
  }

  public void createFromDateText(String releaseStatus, String endItem, String rangeText, StringHolder effectivity, StringHolder effectivityType) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(releaseStatus);
    args_[3] = TcUtility.createArg(endItem);
    args_[4] = TcUtility.createArgStringUnion(rangeText);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTEffectivity", "createFromDateText", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    effectivity.value = TcUtility.queryArg(response.output[0], effectivity.value);
    effectivityType.value = TcUtility.queryArg(response.output[1], effectivityType.value);
  }

  public void createFromUnitText(String releaseStatus, String endItem, String rangeText, StringHolder effectivity, StringHolder effectivityType) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(releaseStatus);
    args_[3] = TcUtility.createArg(endItem);
    args_[4] = TcUtility.createArgStringUnion(rangeText);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTEffectivity", "createFromUnitText", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    effectivity.value = TcUtility.queryArg(response.output[0], effectivity.value);
    effectivityType.value = TcUtility.queryArg(response.output[1], effectivityType.value);
  }

  public void removeFromReleaseStatus(String releaseStatus, String effectivity) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(releaseStatus);
    args_[3] = TcUtility.createArg(effectivity);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTEffectivity", "removeFromReleaseStatus", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void clearAllFromReleaseStatus(String releaseStatus) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(releaseStatus);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTEffectivity", "clearAllFromReleaseStatus", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void askRangeType(String releaseStatus, String effectivity, IntHolder rangeType) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(releaseStatus);
    args_[3] = TcUtility.createArg(effectivity);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTEffectivity", "askRangeType", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    rangeType.value = TcUtility.queryArg(response.output[0], rangeType.value);
  }

  public void setRange(String releaseStatus, String effectivity, String rangeText) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(releaseStatus);
    args_[3] = TcUtility.createArg(effectivity);
    args_[4] = TcUtility.createArgStringUnion(rangeText);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTEffectivity", "setRange", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setDateRange(String releaseStatus, String effectivity, String rangeText) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(releaseStatus);
    args_[3] = TcUtility.createArg(effectivity);
    args_[4] = TcUtility.createArgStringUnion(rangeText);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTEffectivity", "setDateRange", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setUnitRange(String releaseStatus, String effectivity, String rangeText) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(releaseStatus);
    args_[3] = TcUtility.createArg(effectivity);
    args_[4] = TcUtility.createArgStringUnion(rangeText);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTEffectivity", "setUnitRange", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void askRange(String releaseStatus, String effectivity, StringHolder rangeText) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(releaseStatus);
    args_[3] = TcUtility.createArg(effectivity);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTEffectivity", "askRange", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    rangeText.value = TcUtility.queryArgStringUnion(response.output[0], rangeText.value);
  }

  public void askUnitRange(String releaseStatus, String effectivity, StringHolder rangeText) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(releaseStatus);
    args_[3] = TcUtility.createArg(effectivity);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTEffectivity", "askUnitRange", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    rangeText.value = TcUtility.queryArgStringUnion(response.output[0], rangeText.value);
  }

  public void askDateRange(String releaseStatus, String effectivity, StringHolder rangeText) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(releaseStatus);
    args_[3] = TcUtility.createArg(effectivity);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTEffectivity", "askDateRange", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    rangeText.value = TcUtility.queryArgStringUnion(response.output[0], rangeText.value);
  }

  public void setEndItem(String releaseStatus, String effectivity, String endItem) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(releaseStatus);
    args_[3] = TcUtility.createArg(effectivity);
    args_[4] = TcUtility.createArg(endItem);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTEffectivity", "setEndItem", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void askEndItem(String releaseStatus, String effectivity, StringHolder endItem, StringHolder endItemType) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(releaseStatus);
    args_[3] = TcUtility.createArg(effectivity);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTEffectivity", "askEndItem", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    endItem.value = TcUtility.queryArg(response.output[0], endItem.value);
    endItemType.value = TcUtility.queryArg(response.output[1], endItemType.value);
  }

  public void setProtection(String releaseStatus, String effectivity, boolean protection) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(releaseStatus);
    args_[3] = TcUtility.createArg(effectivity);
    args_[4] = TcUtility.createArg(protection);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTEffectivity", "setProtection", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void isProtected(String releaseStatus, String effectivity, BooleanHolder isProtected) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(releaseStatus);
    args_[3] = TcUtility.createArg(effectivity);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTEffectivity", "isProtected", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    isProtected.value = TcUtility.queryArg(response.output[0], isProtected.value);
  }

}
