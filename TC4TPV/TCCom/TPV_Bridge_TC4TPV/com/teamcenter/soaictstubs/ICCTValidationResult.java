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

public class ICCTValidationResult extends ICCT {
  public ICCTValidationResult(Connection connection) {
    super(connection);
  }

  public ICCTValidationResult(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void updateResultObject(String item_rev_tag, String v_data_tag, boolean v_result, int v_status, String v_comments, String target_tag, String validation_user, String validation_date, String validation_report, boolean v_is_adhoc) throws Exception {
    Arg[] args_ = new Arg[12];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(item_rev_tag);
    args_[3] = TcUtility.createArg(v_data_tag);
    args_[4] = TcUtility.createArg(v_result);
    args_[5] = TcUtility.createArg(v_status);
    args_[6] = TcUtility.createArgStringUnion(v_comments);
    args_[7] = TcUtility.createArg(target_tag);
    args_[8] = TcUtility.createArg(validation_user);
    args_[9] = TcUtility.createArgStringUnion(validation_date);
    args_[10] = TcUtility.createArgStringUnion(validation_report);
    args_[11] = TcUtility.createArg(v_is_adhoc);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTValidationResult", "updateResultObject", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

}
