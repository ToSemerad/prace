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

public class ICCSView extends ICCSHeader {
  public ICCSView(Connection connection) {
    super(connection);
  }

  public ICCSView(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void load(String classId, String viewId) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(classId);
    args_[3] = TcUtility.createArg(viewId);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSView", "load", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void create(String classId, String viewId) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(classId);
    args_[3] = TcUtility.createArg(viewId);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSView", "create", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void saveAs(String newClassId, String newViewId) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(newClassId);
    args_[3] = TcUtility.createArg(newViewId);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSView", "saveAs", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void rename(String newViewId) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(newViewId);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSView", "rename", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void move(String newClassId) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(newClassId);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSView", "move", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void copy(String classId, String viewId, String newParentId, String newViewId, int newViewType, int options) throws Exception {
    Arg[] args_ = new Arg[8];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(classId);
    args_[3] = TcUtility.createArg(viewId);
    args_[4] = TcUtility.createArg(newParentId);
    args_[5] = TcUtility.createArg(newViewId);
    args_[6] = TcUtility.createArg(newViewType);
    args_[7] = TcUtility.createArg(options);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSView", "copy", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void ICS_describe_view_attrs(String view_id, int n_attrs, int[] attr_ids, stringSeqValue_uHolder names, longValueSeq_tHolder types, longValueSeq_tHolder max_string_lengths, longValueSeq_tHolder referenced_classes, longValueSeq_tHolder lengths, longValueSeq_tHolder descriptors, longValueSeq_tHolder attr_failures) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(view_id);
    args_[3] = TcUtility.createArg(n_attrs);
    args_[4] = TcUtility.createArg(attr_ids);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSView", "ICS_describe_view_attrs", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    names.value = TcUtility.queryArg(response.output[0], names.value);
    types.value = TcUtility.queryArg(response.output[1], types.value);
    max_string_lengths.value = TcUtility.queryArg(response.output[2], max_string_lengths.value);
    referenced_classes.value = TcUtility.queryArg(response.output[3], referenced_classes.value);
    lengths.value = TcUtility.queryArg(response.output[4], lengths.value);
    descriptors.value = TcUtility.queryArg(response.output[5], descriptors.value);
    attr_failures.value = TcUtility.queryArg(response.output[6], attr_failures.value);
  }

  public void ICS_integer_descriptor(String view_id, int Attr_id, IntHolder discriptor) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(view_id);
    args_[3] = TcUtility.createArg(Attr_id);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSView", "ICS_integer_descriptor", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    discriptor.value = TcUtility.queryArg(response.output[0], discriptor.value);
  }

  public void askViewUid(String view_id, StringHolder viewUid) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(view_id);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSView", "askViewUid", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    viewUid.value = TcUtility.queryArg(response.output[0], viewUid.value);
  }

  public void askAdminView(ICSAdminViewHeader_sHolder viewHeader, IntHolder accessFlags, stringSeq_tHolder sharedSites, pftMappingId_tHolder defaultMapping, icsadminviewattrSeqHolder viewAttributes) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSView", "askAdminView", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    viewHeader.value = TcUtility.queryArg(response.output[0], viewHeader.value);
    accessFlags.value = TcUtility.queryArg(response.output[1], accessFlags.value);
    sharedSites.value = TcUtility.queryArg(response.output[2], sharedSites.value);
    defaultMapping.value = TcUtility.queryArg(response.output[3], defaultMapping.value);
    viewAttributes.value = TcUtility.queryArg(response.output[4], viewAttributes.value);
  }

  public void setValues(ICSAdminViewHeader_s viewHeader, String[] sharedSites, String defaultMapping, ICSAdminViewAttr_s[] viewAttributes) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(viewHeader);
    args_[3] = TcUtility.createArg(sharedSites);
    args_[4] = TcUtility.createArg(defaultMapping);
    args_[5] = TcUtility.createArg(viewAttributes);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSView", "setValues", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getICSAdminClass(ICCSClassHolder iccsClasses) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSView", "getICSAdminClass", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    iccsClasses.value = new ICCSClass( m_connection, "ICCSClass", response.output[0].val);
  }

}
