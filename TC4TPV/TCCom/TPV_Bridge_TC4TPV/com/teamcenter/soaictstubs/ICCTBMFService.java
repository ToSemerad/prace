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

public class ICCTBMFService {
  ICTService m_service;

  Connection m_connection;


  public ICCTBMFService(Connection connection) {
    m_service = ICTService.getService( connection );
    m_connection = connection;
  }

  public void getBMOperationsForType(String type_name, uidSeqValue_uHolder bmoptags, stringSeqValue_uHolder bmopnames, stringSeqValue_uHolder typenames) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(type_name);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBMFService", "getBMOperationsForType", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    bmoptags.value = TcUtility.queryArg(response.output[0], bmoptags.value);
    bmopnames.value = TcUtility.queryArg(response.output[1], bmopnames.value);
    typenames.value = TcUtility.queryArg(response.output[2], typenames.value);
  }

  public void getBMOperationsForProperty(String type_name, String prop_name, uidSeqValue_uHolder bmoptags, stringSeqValue_uHolder bmopnames, stringSeqValue_uHolder typenames) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(type_name);
    args_[1] = TcUtility.createArg(prop_name);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBMFService", "getBMOperationsForProperty", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    bmoptags.value = TcUtility.queryArg(response.output[0], bmoptags.value);
    bmopnames.value = TcUtility.queryArg(response.output[1], bmopnames.value);
    typenames.value = TcUtility.queryArg(response.output[2], typenames.value);
  }

  public void createBMOperationsForType(String type_name, String op_msg_name, int extpnttype, bmfExtensionDescDetail_s[] extdesc, StringHolder newbmoptag) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(type_name);
    args_[1] = TcUtility.createArg(op_msg_name);
    args_[2] = TcUtility.createArg(extpnttype);
    args_[3] = TcUtility.createArg(extdesc);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBMFService", "createBMOperationsForType", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    newbmoptag.value = TcUtility.queryArg(response.output[0], newbmoptag.value);
  }

  public void createBMOperationsForProperty(String type_name, String prop_name, String op_msg_name, int extpnttype, bmfExtensionDescDetail_s[] extdesc, StringHolder newbmoptag) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(type_name);
    args_[1] = TcUtility.createArg(prop_name);
    args_[2] = TcUtility.createArg(op_msg_name);
    args_[3] = TcUtility.createArg(extpnttype);
    args_[4] = TcUtility.createArg(extdesc);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBMFService", "createBMOperationsForProperty", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    newbmoptag.value = TcUtility.queryArg(response.output[0], newbmoptag.value);
  }

  public void deleteBMOperation(String bmoptag) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(bmoptag);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBMFService", "deleteBMOperation", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getExtensionPointsForOperation(String bmoptag, uidSeqValue_uHolder extpnttags, stringSeqValue_uHolder extpntnames, stringSeqValue_uHolder typenames, longSeqValue_uHolder extpnttypes) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(bmoptag);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBMFService", "getExtensionPointsForOperation", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    extpnttags.value = TcUtility.queryArg(response.output[0], extpnttags.value);
    extpntnames.value = TcUtility.queryArg(response.output[1], extpntnames.value);
    typenames.value = TcUtility.queryArg(response.output[2], typenames.value);
    extpnttypes.value = TcUtility.queryArg(response.output[3], extpnttypes.value);
  }

  public void getExtensionPointDetails(String extpnttag, StringHolder extpntname, IntHolder extpnttype, BooleanHolder isoverridable, StringHolder extpnttype_name, bmfExtensionDescDetailSeq_tHolder extdesc, BooleanHolder singleextonly) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(extpnttag);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBMFService", "getExtensionPointDetails", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    extpntname.value = TcUtility.queryArgStringUnion(response.output[0], extpntname.value);
    extpnttype.value = TcUtility.queryArg(response.output[1], extpnttype.value);
    isoverridable.value = TcUtility.queryArg(response.output[2], isoverridable.value);
    extpnttype_name.value = TcUtility.queryArgStringUnion(response.output[3], extpnttype_name.value);
    extdesc.value = TcUtility.queryArg(response.output[4], extdesc.value);
    singleextonly.value = TcUtility.queryArg(response.output[5], singleextonly.value);
  }

  public void getExtensionDescDetails(String extpnttag, String exttag, bmfExtensionDescDetail_sHolder extdesc) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(extpnttag);
    args_[1] = TcUtility.createArg(exttag);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBMFService", "getExtensionDescDetails", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    extdesc.value = TcUtility.queryArg(response.output[0], extdesc.value);
  }

  public void updateExtensionPoint(String extpnttag, boolean isoverridable, boolean singleextonly) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(extpnttag);
    args_[1] = TcUtility.createArg(isoverridable);
    args_[2] = TcUtility.createArg(singleextonly);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBMFService", "updateExtensionPoint", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void updateExtensionPointWithExtDesc(String extpnttag, boolean isoverridable, boolean singleextonly, bmfExtensionDescDetail_s[] extdesc) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(extpnttag);
    args_[1] = TcUtility.createArg(isoverridable);
    args_[2] = TcUtility.createArg(singleextonly);
    args_[3] = TcUtility.createArg(extdesc);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBMFService", "updateExtensionPointWithExtDesc", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void updateExtensionPointDesc(String optag, String extpnttag, bmfExtensionDescDetail_s extdesc) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(optag);
    args_[1] = TcUtility.createArg(extpnttag);
    args_[2] = TcUtility.createArg(extdesc);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBMFService", "updateExtensionPointDesc", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getSubtypesToPropagateExtensionAdd(String type_name, String extpnttag, uidSeqValue_uHolder extpnttags, stringSeqValue_uHolder subtypenames) throws Exception {
    Arg[] args_ = new Arg[2];
    args_[0] = TcUtility.createArg(type_name);
    args_[1] = TcUtility.createArg(extpnttag);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBMFService", "getSubtypesToPropagateExtensionAdd", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    extpnttags.value = TcUtility.queryArg(response.output[0], extpnttags.value);
    subtypenames.value = TcUtility.queryArg(response.output[1], subtypenames.value);
  }

  public void getSubtypesToPropagateExtensionMod(String type_name, String extpnttag, bmfExtensionDescDetail_s extdesc, uidSeqValue_uHolder extpnttags, bmfExtensionDescDetailSeq_tHolder extdescsinextpnt, stringSeqValue_uHolder subtypenames) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(type_name);
    args_[1] = TcUtility.createArg(extpnttag);
    args_[2] = TcUtility.createArg(extdesc);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBMFService", "getSubtypesToPropagateExtensionMod", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    extpnttags.value = TcUtility.queryArg(response.output[0], extpnttags.value);
    extdescsinextpnt.value = TcUtility.queryArg(response.output[1], extdescsinextpnt.value);
    subtypenames.value = TcUtility.queryArg(response.output[2], subtypenames.value);
  }

  public void removeExtensionFromExtenPnt(String optag, String extpnttag, bmfExtensionDescDetail_s extdesc) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(optag);
    args_[1] = TcUtility.createArg(extpnttag);
    args_[2] = TcUtility.createArg(extdesc);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBMFService", "removeExtensionFromExtenPnt", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void insertExtension(String optag, String extpnttag, bmfExtensionDescDetail_s extdesc, int index) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(optag);
    args_[1] = TcUtility.createArg(extpnttag);
    args_[2] = TcUtility.createArg(extdesc);
    args_[3] = TcUtility.createArg(index);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBMFService", "insertExtension", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void removeExtensionPoint(String extpnttag) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(extpnttag);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBMFService", "removeExtensionPoint", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getAvailableExtensForType(String type_name, String op_name, int extType, uidSeqValue_uHolder extntags, stringSeqValue_uHolder extnnames) throws Exception {
    Arg[] args_ = new Arg[3];
    args_[0] = TcUtility.createArg(type_name);
    args_[1] = TcUtility.createArg(op_name);
    args_[2] = TcUtility.createArg(extType);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBMFService", "getAvailableExtensForType", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    extntags.value = TcUtility.queryArg(response.output[0], extntags.value);
    extnnames.value = TcUtility.queryArg(response.output[1], extnnames.value);
  }

  public void getAvailableExtensForProperty(String type_name, String prop_name, String op_name, int extType, uidSeqValue_uHolder extntags, stringSeqValue_uHolder extnnames) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(type_name);
    args_[1] = TcUtility.createArg(prop_name);
    args_[2] = TcUtility.createArg(op_name);
    args_[3] = TcUtility.createArg(extType);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBMFService", "getAvailableExtensForProperty", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    extntags.value = TcUtility.queryArg(response.output[0], extntags.value);
    extnnames.value = TcUtility.queryArg(response.output[1], extnnames.value);
  }

  public void deleteExtension(String extntag) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(extntag);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBMFService", "deleteExtension", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void getExtensionDetails(String extntag, StringHolder name, StringHolder libname, IntHolder langtype, BooleanHolder isExternal, stringSeqValue_uHolder argdefs, stringSeqValue_uHolder validity) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(extntag);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBMFService", "getExtensionDetails", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    name.value = TcUtility.queryArgStringUnion(response.output[0], name.value);
    libname.value = TcUtility.queryArgStringUnion(response.output[1], libname.value);
    langtype.value = TcUtility.queryArg(response.output[2], langtype.value);
    isExternal.value = TcUtility.queryArg(response.output[3], isExternal.value);
    argdefs.value = TcUtility.queryArg(response.output[4], argdefs.value);
    validity.value = TcUtility.queryArg(response.output[5], validity.value);
  }

  public void createExtension(String name, String libname, int langtype, stringSeqValue_u argdefs, stringSeqValue_u validity, StringHolder extntag) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(name);
    args_[1] = TcUtility.createArg(libname);
    args_[2] = TcUtility.createArg(langtype);
    args_[3] = TcUtility.createArg(argdefs);
    args_[4] = TcUtility.createArg(validity);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBMFService", "createExtension", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    extntag.value = TcUtility.queryArg(response.output[0], extntag.value);
  }

  public void getAllExtensions(int exttype, uidSeqValue_uHolder extntags, stringSeqValue_uHolder extnames) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(exttype);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBMFService", "getAllExtensions", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    extntags.value = TcUtility.queryArg(response.output[0], extntags.value);
    extnames.value = TcUtility.queryArg(response.output[1], extnames.value);
  }

  public void updateExtensionDetails(String extntag, String name, String libname, int langtype, stringSeqValue_u argdefs, stringSeqValue_u validity) throws Exception {
    Arg[] args_ = new Arg[6];
    args_[0] = TcUtility.createArg(extntag);
    args_[1] = TcUtility.createArg(name);
    args_[2] = TcUtility.createArg(libname);
    args_[3] = TcUtility.createArg(langtype);
    args_[4] = TcUtility.createArg(argdefs);
    args_[5] = TcUtility.createArg(validity);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBMFService", "updateExtensionDetails", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
  }

  public void findExtensionReferencers(String extntag, stringSeqValue_uHolder typeNames, stringSeqValue_uHolder propNames, stringSeqValue_uHolder opNames, longSeq_tHolder extpntTypes) throws Exception {
    Arg[] args_ = new Arg[1];
    args_[0] = TcUtility.createArg(extntag);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBMFService", "findExtensionReferencers", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    typeNames.value = TcUtility.queryArg(response.output[0], typeNames.value);
    propNames.value = TcUtility.queryArg(response.output[1], propNames.value);
    opNames.value = TcUtility.queryArg(response.output[2], opNames.value);
    extpntTypes.value = TcUtility.queryArg(response.output[3], extpntTypes.value);
  }

  public void getDescsOwners(String type_name, String prop_name, String op_msg_name, int extpnttype, bmfExtensionDescDetail_s[] extdesc, stringSeqValue_uHolder owning_type_names) throws Exception {
    Arg[] args_ = new Arg[5];
    args_[0] = TcUtility.createArg(type_name);
    args_[1] = TcUtility.createArg(prop_name);
    args_[2] = TcUtility.createArg(op_msg_name);
    args_[3] = TcUtility.createArg(extpnttype);
    args_[4] = TcUtility.createArg(extdesc);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBMFService", "getDescsOwners", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    owning_type_names.value = TcUtility.queryArg(response.output[0], owning_type_names.value);
  }

  public void getOverriddenSubTypes(String type_name, String prop_name, String op_msg_name, int extpnttype, stringSeqValue_uHolder type_names) throws Exception {
    Arg[] args_ = new Arg[4];
    args_[0] = TcUtility.createArg(type_name);
    args_[1] = TcUtility.createArg(prop_name);
    args_[2] = TcUtility.createArg(op_msg_name);
    args_[3] = TcUtility.createArg(extpnttype);
    InvokeICTMethodResponse response = m_service.invokeICTMethod("ICCTBMFService", "getOverriddenSubTypes", args_);
    if( response.serviceData.sizeOfPartialErrors() > 0)
    {
      throw new ICCTException( response.serviceData);
    }
    type_names.value = TcUtility.queryArg(response.output[0], type_names.value);
  }

}
