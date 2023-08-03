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

public class ICCTValidationData extends ICCT {
  public ICCTValidationData(Connection connection) {
    super(connection);
  }

  public ICCTValidationData(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void invokeValidationProcess(String[] selected_objects, String[] selected_v_data_objects) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(selected_objects);
    args_[3] = TcUtility.createArg(selected_v_data_objects);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTValidationData", "invokeValidationProcess", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void createValidationData(String v_name, String v_desc, String v_app_name, String v_category, String closure_rule, String v_args, String[] v_pnames, String[] v_pvalues, String[] v_ops, String v_ext_rule, String v_requirement, StringHolder v_data_tag) throws Exception {
    Arg[] args_ = new Arg[13];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArgStringUnion(v_name);
    args_[3] = TcUtility.createArgStringUnion(v_desc);
    args_[4] = TcUtility.createArgStringUnion(v_app_name);
    args_[5] = TcUtility.createArgStringUnion(v_category);
    args_[6] = TcUtility.createArg(closure_rule);
    args_[7] = TcUtility.createArgStringUnion(v_args);
    args_[8] = TcUtility.createArg(v_pnames);
    args_[9] = TcUtility.createArg(v_pvalues);
    args_[10] = TcUtility.createArg(v_ops);
    args_[11] = TcUtility.createArg(v_ext_rule);
    args_[12] = TcUtility.createArg(v_requirement);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTValidationData", "createValidationData", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    v_data_tag.value = TcUtility.queryArg(response.output[0], v_data_tag.value);
  }

  public void modifyValidationData(String v_data_tag, String v_desc, String v_category, String v_args, String[] v_pnames, String[] v_pvalues, String[] v_ops, String v_requirement, String v_ext_rule) throws Exception {
    Arg[] args_ = new Arg[11];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(v_data_tag);
    args_[3] = TcUtility.createArgStringUnion(v_desc);
    args_[4] = TcUtility.createArgStringUnion(v_category);
    args_[5] = TcUtility.createArgStringUnion(v_args);
    args_[6] = TcUtility.createArg(v_pnames);
    args_[7] = TcUtility.createArg(v_pvalues);
    args_[8] = TcUtility.createArg(v_ops);
    args_[9] = TcUtility.createArg(v_requirement);
    args_[10] = TcUtility.createArg(v_ext_rule);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTValidationData", "modifyValidationData", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void deleteValidationData(String v_data_tag, boolean is_deactivate, boolean is_delete) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(v_data_tag);
    args_[3] = TcUtility.createArg(is_deactivate);
    args_[4] = TcUtility.createArg(is_delete);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTValidationData", "deleteValidationData", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

}
