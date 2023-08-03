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

public class ICCTVariantOption extends ICCT {
  public ICCTVariantOption(Connection connection) {
    super(connection);
  }

  public ICCTVariantOption(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void listValues(String option, String window, stringSeqValue_uHolder values) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(option);
    args_[3] = TcUtility.createArg(window);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantOption", "listValues", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    values.value = TcUtility.queryArg(response.output[0], values.value);
  }

  public void askOptionData(String option, StringHolder owningItem, StringHolder owningItemType, StringHolder optionName, StringHolder optionDescription) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(option);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantOption", "askOptionData", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    owningItem.value = TcUtility.queryArg(response.output[0], owningItem.value);
    owningItemType.value = TcUtility.queryArg(response.output[1], owningItemType.value);
    optionName.value = TcUtility.queryArgStringUnion(response.output[2], optionName.value);
    optionDescription.value = TcUtility.queryArgStringUnion(response.output[3], optionDescription.value);
  }

  public void findOption(String optionName, String itemID, String bomWindow, StringHolder option, StringHolder optionType) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(optionName);
    args_[3] = TcUtility.createArgStringUnion(itemID);
    args_[4] = TcUtility.createArg(bomWindow);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantOption", "findOption", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    option.value = TcUtility.queryArg(response.output[0], option.value);
    optionType.value = TcUtility.queryArg(response.output[1], optionType.value);
  }

  public void findItems(String optionName, String bomWindow, uidSeq_tHolder items, uidSeq_tHolder itemTypes) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(optionName);
    args_[3] = TcUtility.createArg(bomWindow);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantOption", "findItems", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    items.value = TcUtility.queryArg(response.output[0], items.value);
    itemTypes.value = TcUtility.queryArg(response.output[1], itemTypes.value);
  }

  public void findOptionsInItem(String item, String bomWindow, uidSeq_tHolder options, uidSeq_tHolder optionTypes) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(item);
    args_[3] = TcUtility.createArg(bomWindow);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTVariantOption", "findOptionsInItem", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    options.value = TcUtility.queryArg(response.output[0], options.value);
    optionTypes.value = TcUtility.queryArg(response.output[1], optionTypes.value);
  }

}
