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

public class ICCSClass extends ICCSHeader {
  public ICCSClass(Connection connection) {
    super(connection);
  }

  public ICCSClass(Connection connection, String typeName, String objectUid) {
    super(connection, typeName, objectUid);
  }

  public void load(String classId) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(classId);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSClass", "load", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void create(String classId, String parentId) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(classId);
    args_[3] = TcUtility.createArg(parentId);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSClass", "create", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void saveAs(String newClassId, String newParentId) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(newClassId);
    args_[3] = TcUtility.createArg(newParentId);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSClass", "saveAs", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void rename(String newClassId) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(newClassId);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSClass", "rename", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void move(String newParentId) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(newParentId);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSClass", "move", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void copy(String sourceId, String newClassId, String newParentId, int options, String[] oldCids, String[] newCids, StringHolder theNewClassId) throws Exception {
    Arg[] args_ = new Arg[8];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(sourceId);
    args_[3] = TcUtility.createArg(newClassId);
    args_[4] = TcUtility.createArg(newParentId);
    args_[5] = TcUtility.createArg(options);
    args_[6] = TcUtility.createArg(oldCids);
    args_[7] = TcUtility.createArg(newCids);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSClass", "copy", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    theNewClassId.value = TcUtility.queryArgStringUnion(response.output[0], theNewClassId.value);
  }

  public void copySubclassesToStorageClasses(String smlClassId, String newClassId, int options, String[] oldSids, String[] newCids) throws Exception {
    Arg[] args_ = new Arg[7];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(smlClassId);
    args_[3] = TcUtility.createArg(newClassId);
    args_[4] = TcUtility.createArg(options);
    args_[5] = TcUtility.createArg(oldSids);
    args_[6] = TcUtility.createArg(newCids);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSClass", "copySubclassesToStorageClasses", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void askNewAttribute(int attrId, int options, ICSAdminAttr_sHolder newAttr) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(attrId);
    args_[3] = TcUtility.createArg(options);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSClass", "askNewAttribute", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    newAttr.value = TcUtility.queryArg(response.output[0], newAttr.value);
  }

  public void removeAttribute(int theAttrId) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(theAttrId);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSClass", "removeAttribute", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void askAttributeProperty(int attrId, String propName, StringHolder propValue) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(attrId);
    args_[3] = TcUtility.createArg(propName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSClass", "askAttributeProperty", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    propValue.value = TcUtility.queryArgStringUnion(response.output[0], propValue.value);
  }

  public void setAttributeProperty(int attrId, String propName, String propValue) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(attrId);
    args_[3] = TcUtility.createArg(propName);
    args_[4] = TcUtility.createArg(propValue);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSClass", "setAttributeProperty", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void ICS_describe_class_attrs(String class_id, int n_attrs, int[] attr_ids, stringSeqValue_uHolder names, longValueSeq_tHolder types, longValueSeq_tHolder max_string_lengths, longValueSeq_tHolder referenced_classes, longValueSeq_tHolder lengths, longValueSeq_tHolder descriptors, longValueSeq_tHolder attr_failures) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(class_id);
    args_[3] = TcUtility.createArg(n_attrs);
    args_[4] = TcUtility.createArg(attr_ids);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSClass", "ICS_describe_class_attrs", args_);
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

  public void ICS_integer_descriptor(String class_id, int Attr_id, IntHolder discriptor) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(class_id);
    args_[3] = TcUtility.createArg(Attr_id);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSClass", "ICS_integer_descriptor", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    discriptor.value = TcUtility.queryArg(response.output[0], discriptor.value);
  }

  public void askAttributeLength(String class_id, int Attr_id, IntHolder arraySize) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(class_id);
    args_[3] = TcUtility.createArg(Attr_id);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSClass", "askAttributeLength", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    arraySize.value = TcUtility.queryArg(response.output[0], arraySize.value);
  }

  public void askClassUid(String class_id, StringHolder classUid) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(class_id);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSClass", "askClassUid", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    classUid.value = TcUtility.queryArg(response.output[0], classUid.value);
  }

  public void askMaxStringLength(String class_id, int Attr_id, IntHolder maxStringLength) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(class_id);
    args_[3] = TcUtility.createArg(Attr_id);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSClass", "askMaxStringLength", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    maxStringLength.value = TcUtility.queryArg(response.output[0], maxStringLength.value);
  }

  public void searchAttributeInHierarchy(String theClassId, int theAttributeId, IntHolder theClassCount, stringSeqValue_uHolder theClasses) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(theClassId);
    args_[3] = TcUtility.createArg(theAttributeId);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSClass", "searchAttributeInHierarchy", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    theClassCount.value = TcUtility.queryArg(response.output[0], theClassCount.value);
    theClasses.value = TcUtility.queryArg(response.output[1], theClasses.value);
  }

  public void listPFAttrMappings(uidSeqValue_uHolder mappingUids, stringSeqValue_uHolder mappingNames) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSClass", "listPFAttrMappings", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    mappingUids.value = TcUtility.queryArg(response.output[0], mappingUids.value);
    mappingNames.value = TcUtility.queryArg(response.output[1], mappingNames.value);
  }

  public void loadPFAttrMapping(String mappingUid, IntHolder status, longSeqValue_uHolder attrIds, stringSeqValue_uHolder mpfattrs, stringSeqValue_uHolder pfAttrFormats) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(mappingUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSClass", "loadPFAttrMapping", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    status.value = TcUtility.queryArg(response.output[0], status.value);
    attrIds.value = TcUtility.queryArg(response.output[1], attrIds.value);
    mpfattrs.value = TcUtility.queryArg(response.output[2], mpfattrs.value);
    pfAttrFormats.value = TcUtility.queryArg(response.output[3], pfAttrFormats.value);
  }

  public void setPFAttrMapping(String mappingUid, int status, longSeqValue_u attrIds, stringSeqValue_u mpfAttrs, stringSeqValue_u pfAttrFormats, int options) throws Exception {
    Arg[] args_ = new Arg[8];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(mappingUid);
    args_[3] = TcUtility.createArg(status);
    args_[4] = TcUtility.createArg(attrIds);
    args_[5] = TcUtility.createArg(mpfAttrs);
    args_[6] = TcUtility.createArg(pfAttrFormats);
    args_[7] = TcUtility.createArg(options);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSClass", "setPFAttrMapping", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void verifyPFAttrMapping(String mappingUid, longSeqValue_u attrIds, stringSeqValue_u mpfAttrs, stringSeqValue_u pfAttrFormats, longSeqValue_uHolder errors) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(mappingUid);
    args_[3] = TcUtility.createArg(attrIds);
    args_[4] = TcUtility.createArg(mpfAttrs);
    args_[5] = TcUtility.createArg(pfAttrFormats);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSClass", "verifyPFAttrMapping", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    errors.value = TcUtility.queryArg(response.output[0], errors.value);
  }

  public void askPFAttributes(String mappingUid, int options, stringSeqValue_uHolder pfAttrs, stringSeqValue_uHolder pfAttrFormats) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(mappingUid);
    args_[3] = TcUtility.createArg(options);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSClass", "askPFAttributes", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    pfAttrs.value = TcUtility.queryArg(response.output[0], pfAttrs.value);
    pfAttrFormats.value = TcUtility.queryArg(response.output[1], pfAttrFormats.value);
  }

  public void askAdminValues(ICSAdminHeader_sHolder adminHeader, icsLabelSeq_tHolder classLabels, IntHolder accessFlags, stringSeq_tHolder sharedSites, pftMappingId_tHolder defaultMapping, icsadminattrSeqHolder adminProperties) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSClass", "askAdminValues", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    adminHeader.value = TcUtility.queryArg(response.output[0], adminHeader.value);
    classLabels.value = TcUtility.queryArg(response.output[1], classLabels.value);
    accessFlags.value = TcUtility.queryArg(response.output[2], accessFlags.value);
    sharedSites.value = TcUtility.queryArg(response.output[3], sharedSites.value);
    defaultMapping.value = TcUtility.queryArg(response.output[4], defaultMapping.value);
    adminProperties.value = TcUtility.queryArg(response.output[5], adminProperties.value);
  }

  public void setAdminValues(ICSAdminHeader_s adminHeader, icsLabel_s[] classLabels, String[] theSharedSites, String defaultMapping, ICSAdminAttr_s[] adminProperties) throws Exception {
    Arg[] args_ = new Arg[7];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(adminHeader);
    args_[3] = TcUtility.createArg(classLabels);
    args_[4] = TcUtility.createArg(theSharedSites);
    args_[5] = TcUtility.createArg(defaultMapping);
    args_[6] = TcUtility.createArg(adminProperties);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSClass", "setAdminValues", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void createMapping(String sourceClassID, String targetClassID, int viewType, longSeqValue_u attributeIDs, stringSeqValue_u attributeMappings) throws Exception {
    Arg[] args_ = new Arg[7];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(sourceClassID);
    args_[3] = TcUtility.createArg(targetClassID);
    args_[4] = TcUtility.createArg(viewType);
    args_[5] = TcUtility.createArg(attributeIDs);
    args_[6] = TcUtility.createArg(attributeMappings);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSClass", "createMapping", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void describeMapping(String sourceClassID, String targetClassID, int viewType, longSeqValue_uHolder attributeIDs, stringSeqValue_uHolder attributeMappings) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(sourceClassID);
    args_[3] = TcUtility.createArg(targetClassID);
    args_[4] = TcUtility.createArg(viewType);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSClass", "describeMapping", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    attributeIDs.value = TcUtility.queryArg(response.output[0], attributeIDs.value);
    attributeMappings.value = TcUtility.queryArg(response.output[1], attributeMappings.value);
  }

  public void deleteMapping(String sourceClassID, String targetClassID, int viewType) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(sourceClassID);
    args_[3] = TcUtility.createArg(targetClassID);
    args_[4] = TcUtility.createArg(viewType);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCSClass", "deleteMapping", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

}
