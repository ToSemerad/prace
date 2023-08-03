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

public class TCClass {
  ICTService m_service;

  String m_typeName;

  String m_objectUid;

  Connection m_connection;


  public TCClass(Connection connection) {
    m_service = ICTService.getService( connection );
    m_connection = connection;
  }

  public TCClass(Connection connection, String typeName, String objectUid) {
    m_service = ICTService.getService( connection );
    m_typeName = typeName;
    m_objectUid = objectUid;
    m_connection = connection;
  }

  public void setObjectUid(String objectUid) {
    m_objectUid= objectUid;
  }

  public String getObjectUid() {
    return m_objectUid;
  }

  public void setTypeName(String typeName) {
    m_typeName = typeName;
  }

  public String getTypeName() {
    return m_typeName;
  }

  public void getClassName(StringHolder className) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("TCClass", "getClassName", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    className.value = TcUtility.queryArg(response.output[0], className.value);
  }

  public void getSuperClass(StringHolder classObj) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("TCClass", "getSuperClass", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    classObj.value = TcUtility.queryArgStringUnion(response.output[0], classObj.value);
  }

  public void getSubClasses(uidSeqValue_uHolder classObjs) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("TCClass", "getSubClasses", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    classObjs.value = TcUtility.queryArg(response.output[0], classObjs.value);
  }

  public void getTypes(uidSeqValue_uHolder typeObjs) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("TCClass", "getTypes", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    typeObjs.value = TcUtility.queryArg(response.output[0], typeObjs.value);
  }

  public void getAttributes(stringSeqValue_uHolder attributeNames) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("TCClass", "getAttributes", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    attributeNames.value = TcUtility.queryArg(response.output[0], attributeNames.value);
  }

  public void getClassAttributesInfo(String[] attributeNamesIn, stringSeq_tHolder attributeNames, stringSeq_tHolder attributeDisplayNames, longSeq_tHolder attributeTypes, longSeq_tHolder maxStringLengths, uidValueSeq_tHolder referenceClassObjs, uidValueSeq_tHolder logicalReferenceClassObjs, longSeq_tHolder lengths, longSeq_tHolder descriptors) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(attributeNamesIn);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("TCClass", "getClassAttributesInfo", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    attributeNames.value = TcUtility.queryArg(response.output[0], attributeNames.value);
    attributeDisplayNames.value = TcUtility.queryArg(response.output[1], attributeDisplayNames.value);
    attributeTypes.value = TcUtility.queryArg(response.output[2], attributeTypes.value);
    maxStringLengths.value = TcUtility.queryArg(response.output[3], maxStringLengths.value);
    referenceClassObjs.value = TcUtility.queryArgStringUnion(response.output[4], referenceClassObjs.value);
    logicalReferenceClassObjs.value = TcUtility.queryArgStringUnion(response.output[5], logicalReferenceClassObjs.value);
    lengths.value = TcUtility.queryArg(response.output[6], lengths.value);
    descriptors.value = TcUtility.queryArg(response.output[7], descriptors.value);
  }

  public void getAllClassAttributesInfo(stringSeq_tHolder attributeNames, stringSeq_tHolder attributeDisplayNames, longSeq_tHolder attributeTypes, longSeq_tHolder maxStringLengths, uidValueSeq_tHolder referenceClassObjs, uidValueSeq_tHolder logicalReferenceClassObjs, longSeq_tHolder lengths, longSeq_tHolder descriptors) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("TCClass", "getAllClassAttributesInfo", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    attributeNames.value = TcUtility.queryArg(response.output[0], attributeNames.value);
    attributeDisplayNames.value = TcUtility.queryArg(response.output[1], attributeDisplayNames.value);
    attributeTypes.value = TcUtility.queryArg(response.output[2], attributeTypes.value);
    maxStringLengths.value = TcUtility.queryArg(response.output[3], maxStringLengths.value);
    referenceClassObjs.value = TcUtility.queryArgStringUnion(response.output[4], referenceClassObjs.value);
    logicalReferenceClassObjs.value = TcUtility.queryArgStringUnion(response.output[5], logicalReferenceClassObjs.value);
    lengths.value = TcUtility.queryArg(response.output[6], lengths.value);
    descriptors.value = TcUtility.queryArg(response.output[7], descriptors.value);
  }

  public void getAllDisplayableClassAttributes(stringSeq_tHolder attributeNames, stringSeq_tHolder attributeDisplayNames, longSeq_tHolder attributeTypes, longSeq_tHolder maxStringLengths, uidSeq_tHolder referenceClassObjs, uidSeq_tHolder logicalReferenceClassObjs, longSeq_tHolder lengths, longSeq_tHolder descriptors) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("TCClass", "getAllDisplayableClassAttributes", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    attributeNames.value = TcUtility.queryArg(response.output[0], attributeNames.value);
    attributeDisplayNames.value = TcUtility.queryArg(response.output[1], attributeDisplayNames.value);
    attributeTypes.value = TcUtility.queryArg(response.output[2], attributeTypes.value);
    maxStringLengths.value = TcUtility.queryArg(response.output[3], maxStringLengths.value);
    referenceClassObjs.value = TcUtility.queryArg(response.output[4], referenceClassObjs.value);
    logicalReferenceClassObjs.value = TcUtility.queryArg(response.output[5], logicalReferenceClassObjs.value);
    lengths.value = TcUtility.queryArg(response.output[6], lengths.value);
    descriptors.value = TcUtility.queryArg(response.output[7], descriptors.value);
  }

  public void getAttributeInitialValue(String attrName, StringHolder initialValue) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(attrName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("TCClass", "getAttributeInitialValue", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    initialValue.value = TcUtility.queryArgStringUnion(response.output[0], initialValue.value);
  }

  public void getAttributeBounds(String attrName, StringHolder lowerBound, StringHolder upperBound) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(attrName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("TCClass", "getAttributeBounds", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    lowerBound.value = TcUtility.queryArgStringUnion(response.output[0], lowerBound.value);
    upperBound.value = TcUtility.queryArgStringUnion(response.output[1], upperBound.value);
  }

  public void createSubClass(String newClassName, StringHolder newClassObj, TCClassHolder newClass) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(newClassName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("TCClass", "createSubClass", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    newClassObj.value = TcUtility.queryArg(response.output[0], newClassObj.value);
    newClass.value = new TCClass( m_connection, "TCClass", response.output[1].val);
  }

  public void createSubClassWithAttrs(String newClassName, String[] attributeNames, int[] attributeTypes, int[] maxStringLengths, String[] refClassUids, int[] lengths, int[] descriptors, String[] initialValues, String[] lowerBounds, String[] upperBounds, StringHolder newClassUid) throws Exception {
    Arg[] args_ = new Arg[12];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(newClassName);
    args_[3] = TcUtility.createArg(attributeNames);
    args_[4] = TcUtility.createArg(attributeTypes);
    args_[5] = TcUtility.createArg(maxStringLengths);
    args_[6] = TcUtility.createArgStringUnion(refClassUids);
    args_[7] = TcUtility.createArg(lengths);
    args_[8] = TcUtility.createArg(descriptors);
    args_[9] = TcUtility.createArg(initialValues);
    args_[10] = TcUtility.createArg(lowerBounds);
    args_[11] = TcUtility.createArg(upperBounds);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("TCClass", "createSubClassWithAttrs", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    newClassUid.value = TcUtility.queryArg(response.output[0], newClassUid.value);
  }

  public void addAttribute(String attributeName, int attributeType, int maxStringLength, String referenceClassUid, int length, int descriptor) throws Exception {
    Arg[] args_ = new Arg[8];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(attributeName);
    args_[3] = TcUtility.createArg(attributeType);
    args_[4] = TcUtility.createArg(maxStringLength);
    args_[5] = TcUtility.createArgStringUnion(referenceClassUid);
    args_[6] = TcUtility.createArg(length);
    args_[7] = TcUtility.createArg(descriptor);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("TCClass", "addAttribute", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void removeAttribute(String attrName) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(attrName);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("TCClass", "removeAttribute", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setAttributeInitialValue(String attrName, String initialValue) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(attrName);
    args_[3] = TcUtility.createArgStringUnion(initialValue);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("TCClass", "setAttributeInitialValue", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setAttributeBounds(String attrName, String lowerBound, String upperBound) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(attrName);
    args_[3] = TcUtility.createArgStringUnion(lowerBound);
    args_[4] = TcUtility.createArgStringUnion(upperBound);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("TCClass", "setAttributeBounds", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setAttributeFlattening(String attrName, int flattening) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(attrName);
    args_[3] = TcUtility.createArg(flattening);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("TCClass", "setAttributeFlattening", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void setAttributeProperty(String attrName, int property) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(attrName);
    args_[3] = TcUtility.createArg(property);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("TCClass", "setAttributeProperty", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void resetAttributeProperty(String attrName, int property) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    args_[2] = TcUtility.createArg(attrName);
    args_[3] = TcUtility.createArg(property);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("TCClass", "resetAttributeProperty", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void save() throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("TCClass", "save", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void destroy() throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(m_typeName);
    args_[1] = TcUtility.createArg(m_objectUid);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("TCClass", "destroy", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

}
