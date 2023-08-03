package com.teamcenter.soaictstubs;

import com.teamcenter.services.internal.loose.core._2011_06.ICT.Arg;
import com.teamcenter.services.internal.loose.core._2011_06.ICT.Array;
import com.teamcenter.services.internal.loose.core._2011_06.ICT.Entry;
import com.teamcenter.services.internal.loose.core._2011_06.ICT.Structure;


/** 
 * ***********************************************************
 * *                                                         *
 * *      THE FOLLOWING SOURCE FILE HAS BEEN AUTOMATICALLY   *
 * *      GENERATED.  ANY HAND CRAFTED CHANGES WILL BE LOST! *
 * *                                                         *
 * ***********************************************************
 * 
 */

public class TcUtility {
  public static Arg createArg(ICSProperty_s[] argValue) {
    Arg arg = new Arg();
    arg.array = new Array[1];
    arg.array[0] = new Array();
    arg.array[0].entries = new Entry[argValue.length];
    for(int ii=0; ii<argValue.length; ii++)
    {
      arg.array[0].entries[ii] = TcUtility.createEntry(argValue[ii]);
    }
    return arg;
  }

  public static int queryArg(Arg arg, int argValue) {
    return Integer.parseInt(arg.val);
  }

  public static Arg createArg(int argValue) {
    Arg arg = new Arg();
    arg.val = Integer.toString(argValue);
    return arg;
  }

  public static Arg createArg(String argValue) {
    Arg arg = new Arg();
    arg.val = argValue;
    return arg;
  }

  public static Arg createArg(ICSProperty_s argValue) {
    Arg arg = new Arg();
    arg.structure = new Structure[1];
    arg.structure[0] = new Structure();
    arg.structure[0].args = new Arg[2];
    arg.structure[0].args[0] = TcUtility.createArg(argValue.iccs_ddid);
    arg.structure[0].args[1] = TcUtility.createArg(argValue.values);
    return arg;
  }

  public static ICSProperty_s[] queryArg(Arg arg, ICSProperty_s[] argValue) {
    if(arg.array == null || arg.array.length == 0 || arg.array[0] == null) return null;
    if(arg.array[0].entries == null) return null;
    argValue = new ICSProperty_s[arg.array[0].entries.length];
    for(int ii=0; ii<arg.array[0].entries.length; ii++)
    {
      argValue[ii] = (ICSProperty_s)TcUtility.queryEntry(arg.array[0].entries[ii], argValue[ii]);
    }
    return argValue;
  }

  public static Arg createArg(String[] argValue) {
    Arg arg = new Arg();
    arg.array = new Array[1];
    arg.array[0] = new Array();
    arg.array[0].entries = new Entry[argValue.length];
    for(int ii=0; ii<argValue.length; ii++)
    {
      arg.array[0].entries[ii] = TcUtility.createEntry(argValue[ii]);
    }
    return arg;
  }

  public static boolean[] queryArg(Arg arg, boolean[] argValue) {
    if(arg.array == null || arg.array.length == 0 || arg.array[0] == null) return null;
    if(arg.array[0].entries == null) return null;
    argValue = new boolean[arg.array[0].entries.length];
    for(int ii=0; ii<arg.array[0].entries.length; ii++)
    {
      argValue[ii] = (boolean)TcUtility.queryEntry(arg.array[0].entries[ii], argValue[ii]);
    }
    return argValue;
  }

  public static String[] queryArg(Arg arg, String[] argValue) {
    if(arg.array == null || arg.array.length == 0 || arg.array[0] == null) return null;
    if(arg.array[0].entries == null) return null;
    argValue = new String[arg.array[0].entries.length];
    for(int ii=0; ii<arg.array[0].entries.length; ii++)
    {
      argValue[ii] = (String)TcUtility.queryEntry(arg.array[0].entries[ii], argValue[ii]);
    }
    return argValue;
  }

  public static ICSViewHeader_s queryArg(Arg arg, ICSViewHeader_s argValue) {
    if ( argValue == null )  argValue = new ICSViewHeader_s();
    if(arg.structure == null || arg.structure[0] == null) return null;
    if(arg.structure[0].args==null) return null;
    for(int ii=0; ii<arg.structure[0].args.length; ii++)
    {
      argValue.classId = TcUtility.queryArg(arg.structure[0].args[0], argValue.classId);
      argValue.className = TcUtility.queryArg(arg.structure[0].args[1], argValue.className);
      argValue.classShortname = TcUtility.queryArg(arg.structure[0].args[2], argValue.classShortname);
      argValue.classGraphic = TcUtility.queryArg(arg.structure[0].args[3], argValue.classGraphic);
      argValue.classFlags = TcUtility.queryArg(arg.structure[0].args[4], argValue.classFlags);
      argValue.classMultiInst = TcUtility.queryArg(arg.structure[0].args[5], argValue.classMultiInst);
      argValue.classExt1 = TcUtility.queryArg(arg.structure[0].args[6], argValue.classExt1);
      argValue.classExt2 = TcUtility.queryArg(arg.structure[0].args[7], argValue.classExt2);
      argValue.viewId = TcUtility.queryArg(arg.structure[0].args[8], argValue.viewId);
      argValue.viewType = TcUtility.queryArg(arg.structure[0].args[9], argValue.viewType);
      argValue.viewName = TcUtility.queryArg(arg.structure[0].args[10], argValue.viewName);
      argValue.viewSNname = TcUtility.queryArg(arg.structure[0].args[11], argValue.viewSNname);
      argValue.viewGFile = TcUtility.queryArg(arg.structure[0].args[12], argValue.viewGFile);
      argValue.viewFlags = TcUtility.queryArg(arg.structure[0].args[13], argValue.viewFlags);
      argValue.viewExt1 = TcUtility.queryArg(arg.structure[0].args[14], argValue.viewExt1);
      argValue.viewExt2 = TcUtility.queryArg(arg.structure[0].args[15], argValue.viewExt2);
      argValue.writable = TcUtility.queryArg(arg.structure[0].args[16], argValue.writable);
      argValue.description = TcUtility.queryArg(arg.structure[0].args[17], argValue.description);
      argValue.comment = TcUtility.queryArg(arg.structure[0].args[18], argValue.comment);
    }
    return argValue;
  }

  public static ICSViewAttribute_s[] queryArg(Arg arg, ICSViewAttribute_s[] argValue) {
    if(arg.array == null || arg.array.length == 0 || arg.array[0] == null) return null;
    if(arg.array[0].entries == null) return null;
    argValue = new ICSViewAttribute_s[arg.array[0].entries.length];
    for(int ii=0; ii<arg.array[0].entries.length; ii++)
    {
      argValue[ii] = (ICSViewAttribute_s)TcUtility.queryEntry(arg.array[0].entries[ii], argValue[ii]);
    }
    return argValue;
  }

  public static ICSProperty_s queryArg(Arg arg, ICSProperty_s argValue) {
    if ( argValue == null )  argValue = new ICSProperty_s();
    if(arg.structure == null || arg.structure[0] == null) return null;
    if(arg.structure[0].args==null) return null;
    for(int ii=0; ii<arg.structure[0].args.length; ii++)
    {
      argValue.iccs_ddid = TcUtility.queryArg(arg.structure[0].args[0], argValue.iccs_ddid);
      argValue.values = TcUtility.queryArg(arg.structure[0].args[1], argValue.values);
    }
    return argValue;
  }

  public static pftMappingId_t[] queryArg(Arg arg, pftMappingId_t[] argValue) {
    if(arg.array == null || arg.array.length == 0 || arg.array[0] == null) return null;
    if(arg.array[0].entries == null) return null;
    argValue = new pftMappingId_t[arg.array[0].entries.length];
    for(int ii=0; ii<arg.array[0].entries.length; ii++)
    {
      argValue[ii] = (pftMappingId_t)TcUtility.queryEntry(arg.array[0].entries[ii], argValue[ii]);
    }
    return argValue;
  }

  public static boolean queryArg(Arg arg, boolean argValue) {
    return Boolean.parseBoolean(arg.val);
  }

  public static String queryArg(Arg arg, String argValue) {
    return arg.val;
  }

  public static Arg createArg(boolean argValue) {
    Arg arg = new Arg();
    arg.val = Boolean.toString(argValue);
    return arg;
  }

  public static ICSAdminAttr_s queryArg(Arg arg, ICSAdminAttr_s argValue) {
    if ( argValue == null )  argValue = new ICSAdminAttr_s();
    if(arg.structure == null || arg.structure[0] == null) return null;
    if(arg.structure[0].args==null) return null;
    for(int ii=0; ii<arg.structure[0].args.length; ii++)
    {
      argValue.pomUID = TcUtility.queryArg(arg.structure[0].args[0], argValue.pomUID);
      argValue.smindex = TcUtility.queryArg(arg.structure[0].args[1], argValue.smindex);
      argValue.dbindex = TcUtility.queryArg(arg.structure[0].args[2], argValue.dbindex);
      argValue.cid = TcUtility.queryArg(arg.structure[0].args[3], argValue.cid);
      argValue.unct = TcUtility.queryArg(arg.structure[0].args[4], argValue.unct);
      argValue.annotation = TcUtility.queryArg(arg.structure[0].args[5], argValue.annotation);
      argValue.minValue = TcUtility.queryArg(arg.structure[0].args[6], argValue.minValue);
      argValue.maxValue = TcUtility.queryArg(arg.structure[0].args[7], argValue.maxValue);
      argValue.minValue2 = TcUtility.queryArg(arg.structure[0].args[8], argValue.minValue2);
      argValue.maxValue2 = TcUtility.queryArg(arg.structure[0].args[9], argValue.maxValue2);
      argValue.defaultValue = TcUtility.queryArg(arg.structure[0].args[10], argValue.defaultValue);
      argValue.defaultValue2 = TcUtility.queryArg(arg.structure[0].args[11], argValue.defaultValue2);
      argValue.flags = TcUtility.queryArg(arg.structure[0].args[12], argValue.flags);
      argValue.ext1 = TcUtility.queryArg(arg.structure[0].args[13], argValue.ext1);
      argValue.ext2 = TcUtility.queryArg(arg.structure[0].args[14], argValue.ext2);
      argValue.arraySize = TcUtility.queryArg(arg.structure[0].args[15], argValue.arraySize);
      argValue.name = TcUtility.queryArg(arg.structure[0].args[16], argValue.name);
      argValue.sname = TcUtility.queryArg(arg.structure[0].args[17], argValue.sname);
      argValue.defaultAnnotation = TcUtility.queryArg(arg.structure[0].args[18], argValue.defaultAnnotation);
      argValue.format = TcUtility.queryArg(arg.structure[0].args[19], argValue.format);
      argValue.format2 = TcUtility.queryArg(arg.structure[0].args[20], argValue.format2);
      argValue.unit = TcUtility.queryArg(arg.structure[0].args[21], argValue.unit);
      argValue.unit2 = TcUtility.queryArg(arg.structure[0].args[22], argValue.unit2);
      argValue.refType = TcUtility.queryArg(arg.structure[0].args[23], argValue.refType);
      argValue.refObjectType = TcUtility.queryArg(arg.structure[0].args[24], argValue.refObjectType);
      argValue.refOptions = TcUtility.queryArg(arg.structure[0].args[25], argValue.refOptions);
      argValue.dictRefType = TcUtility.queryArg(arg.structure[0].args[26], argValue.dictRefType);
      argValue.dictRefObjectType = TcUtility.queryArg(arg.structure[0].args[27], argValue.dictRefObjectType);
      argValue.dictRefOptions = TcUtility.queryArg(arg.structure[0].args[28], argValue.dictRefOptions);
      argValue.dictFlags = TcUtility.queryArg(arg.structure[0].args[29], argValue.dictFlags);
      argValue.dictDefaultValue = TcUtility.queryArg(arg.structure[0].args[30], argValue.dictDefaultValue);
      argValue.dictDefaultValue2 = TcUtility.queryArg(arg.structure[0].args[31], argValue.dictDefaultValue2);
      argValue.dictMinValue = TcUtility.queryArg(arg.structure[0].args[32], argValue.dictMinValue);
      argValue.dictMaxValue = TcUtility.queryArg(arg.structure[0].args[33], argValue.dictMaxValue);
      argValue.dictMinValue2 = TcUtility.queryArg(arg.structure[0].args[34], argValue.dictMinValue2);
      argValue.dictMaxValue2 = TcUtility.queryArg(arg.structure[0].args[35], argValue.dictMaxValue2);
      argValue.dictExt1 = TcUtility.queryArg(arg.structure[0].args[36], argValue.dictExt1);
      argValue.dictExt2 = TcUtility.queryArg(arg.structure[0].args[37], argValue.dictExt2);
      argValue.fnd0DependencyAttribute = TcUtility.queryArg(arg.structure[0].args[38], argValue.fnd0DependencyAttribute);
      argValue.fnd0DependencyConfiguration = TcUtility.queryArg(arg.structure[0].args[39], argValue.fnd0DependencyConfiguration);
      argValue.dictDependencyConfiguration = TcUtility.queryArg(arg.structure[0].args[40], argValue.dictDependencyConfiguration);
    }
    return argValue;
  }

  public static Arg createArg(int[] argValue) {
    Arg arg = new Arg();
    arg.array = new Array[1];
    arg.array[0] = new Array();
    arg.array[0].entries = new Entry[argValue.length];
    for(int ii=0; ii<argValue.length; ii++)
    {
      arg.array[0].entries[ii] = TcUtility.createEntry(argValue[ii]);
    }
    return arg;
  }

  public static int[] queryArg(Arg arg, int[] argValue) {
    if(arg.array == null || arg.array.length == 0 || arg.array[0] == null) return null;
    if(arg.array[0].entries == null) return null;
    argValue = new int[arg.array[0].entries.length];
    for(int ii=0; ii<arg.array[0].entries.length; ii++)
    {
      argValue[ii] = (int)TcUtility.queryEntry(arg.array[0].entries[ii], argValue[ii]);
    }
    return argValue;
  }

  public static ICSAdminHeader_s queryArg(Arg arg, ICSAdminHeader_s argValue) {
    if ( argValue == null )  argValue = new ICSAdminHeader_s();
    if(arg.structure == null || arg.structure[0] == null) return null;
    if(arg.structure[0].args==null) return null;
    for(int ii=0; ii<arg.structure[0].args.length; ii++)
    {
      argValue.pomUID = TcUtility.queryArg(arg.structure[0].args[0], argValue.pomUID);
      argValue.classId = TcUtility.queryArg(arg.structure[0].args[1], argValue.classId);
      argValue.parent = TcUtility.queryArg(arg.structure[0].args[2], argValue.parent);
      argValue.type = TcUtility.queryArg(arg.structure[0].args[3], argValue.type);
      argValue.group = TcUtility.queryArg(arg.structure[0].args[4], argValue.group);
      argValue.name = TcUtility.queryArg(arg.structure[0].args[5], argValue.name);
      argValue.shortName = TcUtility.queryArg(arg.structure[0].args[6], argValue.shortName);
      argValue.graphic = TcUtility.queryArg(arg.structure[0].args[7], argValue.graphic);
      argValue.flags = TcUtility.queryArg(arg.structure[0].args[8], argValue.flags);
      argValue.inheritedFlags = TcUtility.queryArg(arg.structure[0].args[9], argValue.inheritedFlags);
      argValue.isMultiInst = TcUtility.queryArg(arg.structure[0].args[10], argValue.isMultiInst);
      argValue.user1 = TcUtility.queryArg(arg.structure[0].args[11], argValue.user1);
      argValue.user2 = TcUtility.queryArg(arg.structure[0].args[12], argValue.user2);
      argValue.nAttr = TcUtility.queryArg(arg.structure[0].args[13], argValue.nAttr);
      argValue.instanceCount = TcUtility.queryArg(arg.structure[0].args[14], argValue.instanceCount);
      argValue.subclassCount = TcUtility.queryArg(arg.structure[0].args[15], argValue.subclassCount);
      argValue.viewCount = TcUtility.queryArg(arg.structure[0].args[16], argValue.viewCount);
      argValue.owningSite = TcUtility.queryArg(arg.structure[0].args[17], argValue.owningSite);
      argValue.shareHierarchy = TcUtility.queryArg(arg.structure[0].args[18], argValue.shareHierarchy);
      argValue.fnd0library = TcUtility.queryArg(arg.structure[0].args[19], argValue.fnd0library);
      argValue.description = TcUtility.queryArg(arg.structure[0].args[20], argValue.description);
      argValue.comment = TcUtility.queryArg(arg.structure[0].args[21], argValue.comment);
      argValue.fnd0DependsOnConfig = TcUtility.queryArg(arg.structure[0].args[22], argValue.fnd0DependsOnConfig);
    }
    return argValue;
  }

  public static icsLabel_s[] queryArg(Arg arg, icsLabel_s[] argValue) {
    if(arg.array == null || arg.array.length == 0 || arg.array[0] == null) return null;
    if(arg.array[0].entries == null) return null;
    argValue = new icsLabel_s[arg.array[0].entries.length];
    for(int ii=0; ii<arg.array[0].entries.length; ii++)
    {
      argValue[ii] = (icsLabel_s)TcUtility.queryEntry(arg.array[0].entries[ii], argValue[ii]);
    }
    return argValue;
  }

  public static pftMappingId_t queryArg(Arg arg, pftMappingId_t argValue) {
    if ( argValue == null )  argValue = new pftMappingId_t();
    if(arg.structure == null || arg.structure[0] == null) return null;
    if(arg.structure[0].args==null) return null;
    for(int ii=0; ii<arg.structure[0].args.length; ii++)
    {
      argValue.itemOrRevUid = TcUtility.queryArg(arg.structure[0].args[0], argValue.itemOrRevUid);
      argValue.name = TcUtility.queryArg(arg.structure[0].args[1], argValue.name);
    }
    return argValue;
  }

  public static ICSAdminAttr_s[] queryArg(Arg arg, ICSAdminAttr_s[] argValue) {
    if(arg.array == null || arg.array.length == 0 || arg.array[0] == null) return null;
    if(arg.array[0].entries == null) return null;
    argValue = new ICSAdminAttr_s[arg.array[0].entries.length];
    for(int ii=0; ii<arg.array[0].entries.length; ii++)
    {
      argValue[ii] = (ICSAdminAttr_s)TcUtility.queryEntry(arg.array[0].entries[ii], argValue[ii]);
    }
    return argValue;
  }

  public static Arg createArg(ICSAdminHeader_s argValue) {
    Arg arg = new Arg();
    arg.structure = new Structure[1];
    arg.structure[0] = new Structure();
    arg.structure[0].args = new Arg[23];
    arg.structure[0].args[0] = TcUtility.createArg(argValue.pomUID);
    arg.structure[0].args[1] = TcUtility.createArg(argValue.classId);
    arg.structure[0].args[2] = TcUtility.createArg(argValue.parent);
    arg.structure[0].args[3] = TcUtility.createArg(argValue.type);
    arg.structure[0].args[4] = TcUtility.createArg(argValue.group);
    arg.structure[0].args[5] = TcUtility.createArg(argValue.name);
    arg.structure[0].args[6] = TcUtility.createArg(argValue.shortName);
    arg.structure[0].args[7] = TcUtility.createArg(argValue.graphic);
    arg.structure[0].args[8] = TcUtility.createArg(argValue.flags);
    arg.structure[0].args[9] = TcUtility.createArg(argValue.inheritedFlags);
    arg.structure[0].args[10] = TcUtility.createArg(argValue.isMultiInst);
    arg.structure[0].args[11] = TcUtility.createArg(argValue.user1);
    arg.structure[0].args[12] = TcUtility.createArg(argValue.user2);
    arg.structure[0].args[13] = TcUtility.createArg(argValue.nAttr);
    arg.structure[0].args[14] = TcUtility.createArg(argValue.instanceCount);
    arg.structure[0].args[15] = TcUtility.createArg(argValue.subclassCount);
    arg.structure[0].args[16] = TcUtility.createArg(argValue.viewCount);
    arg.structure[0].args[17] = TcUtility.createArg(argValue.owningSite);
    arg.structure[0].args[18] = TcUtility.createArg(argValue.shareHierarchy);
    arg.structure[0].args[19] = TcUtility.createArg(argValue.fnd0library);
    arg.structure[0].args[20] = TcUtility.createArg(argValue.description);
    arg.structure[0].args[21] = TcUtility.createArg(argValue.comment);
    arg.structure[0].args[22] = TcUtility.createArg(argValue.fnd0DependsOnConfig);
    return arg;
  }

  public static Arg createArg(icsLabel_s[] argValue) {
    Arg arg = new Arg();
    arg.array = new Array[1];
    arg.array[0] = new Array();
    arg.array[0].entries = new Entry[argValue.length];
    for(int ii=0; ii<argValue.length; ii++)
    {
      arg.array[0].entries[ii] = TcUtility.createEntry(argValue[ii]);
    }
    return arg;
  }

  public static Arg createArg(ICSAdminAttr_s[] argValue) {
    Arg arg = new Arg();
    arg.array = new Array[1];
    arg.array[0] = new Array();
    arg.array[0].entries = new Entry[argValue.length];
    for(int ii=0; ii<argValue.length; ii++)
    {
      arg.array[0].entries[ii] = TcUtility.createEntry(argValue[ii]);
    }
    return arg;
  }

  public static ICSAttr_s queryArg(Arg arg, ICSAttr_s argValue) {
    if ( argValue == null )  argValue = new ICSAttr_s();
    if(arg.structure == null || arg.structure[0] == null) return null;
    if(arg.structure[0].args==null) return null;
    for(int ii=0; ii<arg.structure[0].args.length; ii++)
    {
      argValue.pomUID = TcUtility.queryArg(arg.structure[0].args[0], argValue.pomUID);
      argValue.unctNr = TcUtility.queryArg(arg.structure[0].args[1], argValue.unctNr);
      argValue.name = TcUtility.queryArg(arg.structure[0].args[2], argValue.name);
      argValue.sName = TcUtility.queryArg(arg.structure[0].args[3], argValue.sName);
      argValue.annotation = TcUtility.queryArg(arg.structure[0].args[4], argValue.annotation);
      argValue.unit1 = TcUtility.queryArg(arg.structure[0].args[5], argValue.unit1);
      argValue.unit2 = TcUtility.queryArg(arg.structure[0].args[6], argValue.unit2);
      argValue.format1 = TcUtility.queryArg(arg.structure[0].args[7], argValue.format1);
      argValue.format2 = TcUtility.queryArg(arg.structure[0].args[8], argValue.format2);
      argValue.flags = TcUtility.queryArg(arg.structure[0].args[9], argValue.flags);
      argValue.minValue = TcUtility.queryArg(arg.structure[0].args[10], argValue.minValue);
      argValue.maxValue = TcUtility.queryArg(arg.structure[0].args[11], argValue.maxValue);
      argValue.minValue2 = TcUtility.queryArg(arg.structure[0].args[12], argValue.minValue2);
      argValue.maxValue2 = TcUtility.queryArg(arg.structure[0].args[13], argValue.maxValue2);
      argValue.defaultValue1 = TcUtility.queryArg(arg.structure[0].args[14], argValue.defaultValue1);
      argValue.defaultValue2 = TcUtility.queryArg(arg.structure[0].args[15], argValue.defaultValue2);
      argValue.ext1 = TcUtility.queryArg(arg.structure[0].args[16], argValue.ext1);
      argValue.ext2 = TcUtility.queryArg(arg.structure[0].args[17], argValue.ext2);
      argValue.description = TcUtility.queryArg(arg.structure[0].args[18], argValue.description);
      argValue.comment = TcUtility.queryArg(arg.structure[0].args[19], argValue.comment);
      argValue.owningSite = TcUtility.queryArg(arg.structure[0].args[20], argValue.owningSite);
      argValue.refCount = TcUtility.queryArg(arg.structure[0].args[21], argValue.refCount);
      argValue.isFormatChangeable = TcUtility.queryArg(arg.structure[0].args[22], argValue.isFormatChangeable);
      argValue.refType = TcUtility.queryArg(arg.structure[0].args[23], argValue.refType);
      argValue.refObjectType = TcUtility.queryArg(arg.structure[0].args[24], argValue.refObjectType);
      argValue.refOptions = TcUtility.queryArg(arg.structure[0].args[25], argValue.refOptions);
      argValue.extendedProperties = TcUtility.queryArg(arg.structure[0].args[26], argValue.extendedProperties);
      argValue.fnd0DependencyConfiguration = TcUtility.queryArg(arg.structure[0].args[27], argValue.fnd0DependencyConfiguration);
    }
    return argValue;
  }

  public static Arg createArg(ICSAttr_s argValue) {
    Arg arg = new Arg();
    arg.structure = new Structure[1];
    arg.structure[0] = new Structure();
    arg.structure[0].args = new Arg[28];
    arg.structure[0].args[0] = TcUtility.createArg(argValue.pomUID);
    arg.structure[0].args[1] = TcUtility.createArg(argValue.unctNr);
    arg.structure[0].args[2] = TcUtility.createArg(argValue.name);
    arg.structure[0].args[3] = TcUtility.createArg(argValue.sName);
    arg.structure[0].args[4] = TcUtility.createArg(argValue.annotation);
    arg.structure[0].args[5] = TcUtility.createArg(argValue.unit1);
    arg.structure[0].args[6] = TcUtility.createArg(argValue.unit2);
    arg.structure[0].args[7] = TcUtility.createArg(argValue.format1);
    arg.structure[0].args[8] = TcUtility.createArg(argValue.format2);
    arg.structure[0].args[9] = TcUtility.createArg(argValue.flags);
    arg.structure[0].args[10] = TcUtility.createArg(argValue.minValue);
    arg.structure[0].args[11] = TcUtility.createArg(argValue.maxValue);
    arg.structure[0].args[12] = TcUtility.createArg(argValue.minValue2);
    arg.structure[0].args[13] = TcUtility.createArg(argValue.maxValue2);
    arg.structure[0].args[14] = TcUtility.createArg(argValue.defaultValue1);
    arg.structure[0].args[15] = TcUtility.createArg(argValue.defaultValue2);
    arg.structure[0].args[16] = TcUtility.createArg(argValue.ext1);
    arg.structure[0].args[17] = TcUtility.createArg(argValue.ext2);
    arg.structure[0].args[18] = TcUtility.createArg(argValue.description);
    arg.structure[0].args[19] = TcUtility.createArg(argValue.comment);
    arg.structure[0].args[20] = TcUtility.createArg(argValue.owningSite);
    arg.structure[0].args[21] = TcUtility.createArg(argValue.refCount);
    arg.structure[0].args[22] = TcUtility.createArg(argValue.isFormatChangeable);
    arg.structure[0].args[23] = TcUtility.createArg(argValue.refType);
    arg.structure[0].args[24] = TcUtility.createArg(argValue.refObjectType);
    arg.structure[0].args[25] = TcUtility.createArg(argValue.refOptions);
    arg.structure[0].args[26] = TcUtility.createArg(argValue.extendedProperties);
    arg.structure[0].args[27] = TcUtility.createArg(argValue.fnd0DependencyConfiguration);
    return arg;
  }

  public static String[] queryArgStringUnion(Arg arg, String[] argValue) {
    if(arg.array == null || arg.array.length == 0 || arg.array[0] == null) return null;
    if(arg.array[0].entries == null) return null;
    argValue = new String[arg.array[0].entries.length];
    for(int ii=0; ii<arg.array[0].entries.length; ii++)
    {
      argValue[ii] = (String)TcUtility.queryEntryStringUnion(arg.array[0].entries[ii], argValue[ii]);
    }
    return argValue;
  }

  public static pftMappingN_t[] queryArg(Arg arg, pftMappingN_t[] argValue) {
    if(arg.array == null || arg.array.length == 0 || arg.array[0] == null) return null;
    if(arg.array[0].entries == null) return null;
    argValue = new pftMappingN_t[arg.array[0].entries.length];
    for(int ii=0; ii<arg.array[0].entries.length; ii++)
    {
      argValue[ii] = (pftMappingN_t)TcUtility.queryEntry(arg.array[0].entries[ii], argValue[ii]);
    }
    return argValue;
  }

  public static Arg createArg(pftMappingW_t[] argValue) {
    Arg arg = new Arg();
    arg.array = new Array[1];
    arg.array[0] = new Array();
    arg.array[0].entries = new Entry[argValue.length];
    for(int ii=0; ii<argValue.length; ii++)
    {
      arg.array[0].entries[ii] = TcUtility.createEntry(argValue[ii]);
    }
    return arg;
  }

  public static pftMappingN_t queryArg(Arg arg, pftMappingN_t argValue) {
    if ( argValue == null )  argValue = new pftMappingN_t();
    if(arg.structure == null || arg.structure[0] == null) return null;
    if(arg.structure[0].args==null) return null;
    for(int ii=0; ii<arg.structure[0].args.length; ii++)
    {
      argValue.pftId = TcUtility.queryArg(arg.structure[0].args[0], argValue.pftId);
      argValue.pftMapping = TcUtility.queryArg(arg.structure[0].args[1], argValue.pftMapping);
    }
    return argValue;
  }

  public static Arg createArgStringUnion(String argValue) {
    Arg arg = new Arg();
    arg.structure = new Structure[1];
    arg.structure[0] = new Structure();
    if(argValue != null)
    {
      arg.structure[0].args = new Arg[2];
      arg.structure[0].args[0] = new Arg();
      arg.structure[0].args[0].val = "true";
      arg.structure[0].args[1] = new Arg();
      arg.structure[0].args[1].val = argValue;
    }
    else
    {
      arg.structure[0].args = new Arg[1];
      arg.structure[0].args[0] = new Arg();
      arg.structure[0].args[0].val = "false";
    }
    return arg;
  }

  public static pftColumnDescriptor_t[] queryArg(Arg arg, pftColumnDescriptor_t[] argValue) {
    if(arg.array == null || arg.array.length == 0 || arg.array[0] == null) return null;
    if(arg.array[0].entries == null) return null;
    argValue = new pftColumnDescriptor_t[arg.array[0].entries.length];
    for(int ii=0; ii<arg.array[0].entries.length; ii++)
    {
      argValue[ii] = (pftColumnDescriptor_t)TcUtility.queryEntry(arg.array[0].entries[ii], argValue[ii]);
    }
    return argValue;
  }

  public static iccsGraphicsInformationNode_t[] queryArg(Arg arg, iccsGraphicsInformationNode_t[] argValue) {
    if(arg.array == null || arg.array.length == 0 || arg.array[0] == null) return null;
    if(arg.array[0].entries == null) return null;
    argValue = new iccsGraphicsInformationNode_t[arg.array[0].entries.length];
    for(int ii=0; ii<arg.array[0].entries.length; ii++)
    {
      argValue[ii] = (iccsGraphicsInformationNode_t)TcUtility.queryEntry(arg.array[0].entries[ii], argValue[ii]);
    }
    return argValue;
  }

  public static ico_s[] queryArg(Arg arg, ico_s[] argValue) {
    if(arg.array == null || arg.array.length == 0 || arg.array[0] == null) return null;
    if(arg.array[0].entries == null) return null;
    argValue = new ico_s[arg.array[0].entries.length];
    for(int ii=0; ii<arg.array[0].entries.length; ii++)
    {
      argValue[ii] = (ico_s)TcUtility.queryEntry(arg.array[0].entries[ii], argValue[ii]);
    }
    return argValue;
  }

  public static ICSProperty_s[][] queryArg(Arg arg, ICSProperty_s[][] argValue) {
    if(arg.array == null || arg.array.length == 0 || arg.array[0] == null) return null;
    if(arg.array[0].entries == null) return null;
    argValue = new ICSProperty_s[arg.array[0].entries.length][];
    for(int ii=0; ii<arg.array[0].entries.length; ii++)
    {
      argValue[ii] = (ICSProperty_s[])TcUtility.queryEntry(arg.array[0].entries[ii], argValue[ii]);
    }
    return argValue;
  }

  public static ICSChildren_s[] queryArg(Arg arg, ICSChildren_s[] argValue) {
    if(arg.array == null || arg.array.length == 0 || arg.array[0] == null) return null;
    if(arg.array[0].entries == null) return null;
    argValue = new ICSChildren_s[arg.array[0].entries.length];
    for(int ii=0; ii<arg.array[0].entries.length; ii++)
    {
      argValue[ii] = (ICSChildren_s)TcUtility.queryEntry(arg.array[0].entries[ii], argValue[ii]);
    }
    return argValue;
  }

  public static ICSChildren_s queryArg(Arg arg, ICSChildren_s argValue) {
    if ( argValue == null )  argValue = new ICSChildren_s();
    if(arg.structure == null || arg.structure[0] == null) return null;
    if(arg.structure[0].args==null) return null;
    for(int ii=0; ii<arg.structure[0].args.length; ii++)
    {
      argValue.childtype = TcUtility.queryArg(arg.structure[0].args[0], argValue.childtype);
      argValue.childId = TcUtility.queryArg(arg.structure[0].args[1], argValue.childId);
      argValue.childName = TcUtility.queryArg(arg.structure[0].args[2], argValue.childName);
      argValue.childtag = TcUtility.queryArg(arg.structure[0].args[3], argValue.childtag);
      argValue.childInstanceCount = TcUtility.queryArg(arg.structure[0].args[4], argValue.childInstanceCount);
      argValue.childClassChildrenCount = TcUtility.queryArg(arg.structure[0].args[5], argValue.childClassChildrenCount);
      argValue.childViewCount = TcUtility.queryArg(arg.structure[0].args[6], argValue.childViewCount);
      argValue.childSubClassCount = TcUtility.queryArg(arg.structure[0].args[7], argValue.childSubClassCount);
      argValue.iconImageTicket = TcUtility.queryArg(arg.structure[0].args[8], argValue.iconImageTicket);
      argValue.classImageTicket = TcUtility.queryArg(arg.structure[0].args[9], argValue.classImageTicket);
    }
    return argValue;
  }

  public static ICSUNITDefinition_s[] queryArg(Arg arg, ICSUNITDefinition_s[] argValue) {
    if(arg.array == null || arg.array.length == 0 || arg.array[0] == null) return null;
    if(arg.array[0].entries == null) return null;
    argValue = new ICSUNITDefinition_s[arg.array[0].entries.length];
    for(int ii=0; ii<arg.array[0].entries.length; ii++)
    {
      argValue[ii] = (ICSUNITDefinition_s)TcUtility.queryEntry(arg.array[0].entries[ii], argValue[ii]);
    }
    return argValue;
  }

  public static ICSAdminViewHeader_s queryArg(Arg arg, ICSAdminViewHeader_s argValue) {
    if ( argValue == null )  argValue = new ICSAdminViewHeader_s();
    if(arg.structure == null || arg.structure[0] == null) return null;
    if(arg.structure[0].args==null) return null;
    for(int ii=0; ii<arg.structure[0].args.length; ii++)
    {
      argValue.pomUID = TcUtility.queryArg(arg.structure[0].args[0], argValue.pomUID);
      argValue.classId = TcUtility.queryArg(arg.structure[0].args[1], argValue.classId);
      argValue.viewId = TcUtility.queryArg(arg.structure[0].args[2], argValue.viewId);
      argValue.type = TcUtility.queryArg(arg.structure[0].args[3], argValue.type);
      argValue.name = TcUtility.queryArg(arg.structure[0].args[4], argValue.name);
      argValue.shortName = TcUtility.queryArg(arg.structure[0].args[5], argValue.shortName);
      argValue.graphic = TcUtility.queryArg(arg.structure[0].args[6], argValue.graphic);
      argValue.flags = TcUtility.queryArg(arg.structure[0].args[7], argValue.flags);
      argValue.user1 = TcUtility.queryArg(arg.structure[0].args[8], argValue.user1);
      argValue.user2 = TcUtility.queryArg(arg.structure[0].args[9], argValue.user2);
      argValue.nAttr = TcUtility.queryArg(arg.structure[0].args[10], argValue.nAttr);
      argValue.instCount = TcUtility.queryArg(arg.structure[0].args[11], argValue.instCount);
      argValue.owningSite = TcUtility.queryArg(arg.structure[0].args[12], argValue.owningSite);
      argValue.shareHierarchy = TcUtility.queryArg(arg.structure[0].args[13], argValue.shareHierarchy);
      argValue.description = TcUtility.queryArg(arg.structure[0].args[14], argValue.description);
      argValue.comment = TcUtility.queryArg(arg.structure[0].args[15], argValue.comment);
    }
    return argValue;
  }

  public static ICSAdminViewAttr_s[] queryArg(Arg arg, ICSAdminViewAttr_s[] argValue) {
    if(arg.array == null || arg.array.length == 0 || arg.array[0] == null) return null;
    if(arg.array[0].entries == null) return null;
    argValue = new ICSAdminViewAttr_s[arg.array[0].entries.length];
    for(int ii=0; ii<arg.array[0].entries.length; ii++)
    {
      argValue[ii] = (ICSAdminViewAttr_s)TcUtility.queryEntry(arg.array[0].entries[ii], argValue[ii]);
    }
    return argValue;
  }

  public static Arg createArg(ICSAdminViewHeader_s argValue) {
    Arg arg = new Arg();
    arg.structure = new Structure[1];
    arg.structure[0] = new Structure();
    arg.structure[0].args = new Arg[16];
    arg.structure[0].args[0] = TcUtility.createArg(argValue.pomUID);
    arg.structure[0].args[1] = TcUtility.createArg(argValue.classId);
    arg.structure[0].args[2] = TcUtility.createArg(argValue.viewId);
    arg.structure[0].args[3] = TcUtility.createArg(argValue.type);
    arg.structure[0].args[4] = TcUtility.createArg(argValue.name);
    arg.structure[0].args[5] = TcUtility.createArg(argValue.shortName);
    arg.structure[0].args[6] = TcUtility.createArg(argValue.graphic);
    arg.structure[0].args[7] = TcUtility.createArg(argValue.flags);
    arg.structure[0].args[8] = TcUtility.createArg(argValue.user1);
    arg.structure[0].args[9] = TcUtility.createArg(argValue.user2);
    arg.structure[0].args[10] = TcUtility.createArg(argValue.nAttr);
    arg.structure[0].args[11] = TcUtility.createArg(argValue.instCount);
    arg.structure[0].args[12] = TcUtility.createArg(argValue.owningSite);
    arg.structure[0].args[13] = TcUtility.createArg(argValue.shareHierarchy);
    arg.structure[0].args[14] = TcUtility.createArg(argValue.description);
    arg.structure[0].args[15] = TcUtility.createArg(argValue.comment);
    return arg;
  }

  public static Arg createArg(ICSAdminViewAttr_s[] argValue) {
    Arg arg = new Arg();
    arg.array = new Array[1];
    arg.array[0] = new Array();
    arg.array[0].entries = new Entry[argValue.length];
    for(int ii=0; ii<argValue.length; ii++)
    {
      arg.array[0].entries[ii] = TcUtility.createEntry(argValue[ii]);
    }
    return arg;
  }

  public static String[][] queryArgStringUnion(Arg arg, String[][] argValue) {
    if(arg.array == null || arg.array.length == 0 || arg.array[0] == null) return null;
    if(arg.array[0].entries == null) return null;
    argValue = new String[arg.array[0].entries.length][];
    for(int ii=0; ii<arg.array[0].entries.length; ii++)
    {
      argValue[ii] = (String[])TcUtility.queryEntryStringUnion(arg.array[0].entries[ii], argValue[ii]);
    }
    return argValue;
  }

  public static propertyData_u[] queryArg(Arg arg, propertyData_u[] argValue) {
    if(arg.array == null || arg.array.length == 0 || arg.array[0] == null) return null;
    if(arg.array[0].entries == null) return null;
    argValue = new propertyData_u[arg.array[0].entries.length];
    for(int ii=0; ii<arg.array[0].entries.length; ii++)
    {
      argValue[ii] = (propertyData_u)TcUtility.queryEntry(arg.array[0].entries[ii], argValue[ii]);
    }
    return argValue;
  }

  public static errorInfoValue_u[] queryArg(Arg arg, errorInfoValue_u[] argValue) {
    if(arg.array == null || arg.array.length == 0 || arg.array[0] == null) return null;
    if(arg.array[0].entries == null) return null;
    argValue = new errorInfoValue_u[arg.array[0].entries.length];
    for(int ii=0; ii<arg.array[0].entries.length; ii++)
    {
      argValue[ii] = (errorInfoValue_u)TcUtility.queryEntry(arg.array[0].entries[ii], argValue[ii]);
    }
    return argValue;
  }

  public static propertyData_u[][] queryArg(Arg arg, propertyData_u[][] argValue) {
    if(arg.array == null || arg.array.length == 0 || arg.array[0] == null) return null;
    if(arg.array[0].entries == null) return null;
    argValue = new propertyData_u[arg.array[0].entries.length][];
    for(int ii=0; ii<arg.array[0].entries.length; ii++)
    {
      argValue[ii] = (propertyData_u[])TcUtility.queryEntry(arg.array[0].entries[ii], argValue[ii]);
    }
    return argValue;
  }

  public static boolean[][] queryArg(Arg arg, boolean[][] argValue) {
    if(arg.array == null || arg.array.length == 0 || arg.array[0] == null) return null;
    if(arg.array[0].entries == null) return null;
    argValue = new boolean[arg.array[0].entries.length][];
    for(int ii=0; ii<arg.array[0].entries.length; ii++)
    {
      argValue[ii] = (boolean[])TcUtility.queryEntry(arg.array[0].entries[ii], argValue[ii]);
    }
    return argValue;
  }

  public static errorInfoValue_u[][] queryArg(Arg arg, errorInfoValue_u[][] argValue) {
    if(arg.array == null || arg.array.length == 0 || arg.array[0] == null) return null;
    if(arg.array[0].entries == null) return null;
    argValue = new errorInfoValue_u[arg.array[0].entries.length][];
    for(int ii=0; ii<arg.array[0].entries.length; ii++)
    {
      argValue[ii] = (errorInfoValue_u[])TcUtility.queryEntry(arg.array[0].entries[ii], argValue[ii]);
    }
    return argValue;
  }

  public static Arg createArg(String[][] argValue) {
    Arg arg = new Arg();
    arg.array = new Array[1];
    arg.array[0] = new Array();
    arg.array[0].entries = new Entry[argValue.length];
    for(int ii=0; ii<argValue.length; ii++)
    {
      arg.array[0].entries[ii] = TcUtility.createEntry(argValue[ii]);
    }
    return arg;
  }

  public static Arg createArg(propertyData_u[][] argValue) {
    Arg arg = new Arg();
    arg.array = new Array[1];
    arg.array[0] = new Array();
    arg.array[0].entries = new Entry[argValue.length];
    for(int ii=0; ii<argValue.length; ii++)
    {
      arg.array[0].entries[ii] = TcUtility.createEntry(argValue[ii]);
    }
    return arg;
  }

  public static Arg createArgStringUnion(String[] argValue) {
    Arg arg = new Arg();
    arg.array = new Array[1];
    arg.array[0] = new Array();
    arg.array[0].entries = new Entry[argValue.length];
    for(int ii=0; ii<argValue.length; ii++)
    {
      arg.array[0].entries[ii] = TcUtility.createEntryStringUnion(argValue[ii]);
    }
    return arg;
  }

  public static Arg createArg(propertyData_u[] argValue) {
    Arg arg = new Arg();
    arg.array = new Array[1];
    arg.array[0] = new Array();
    arg.array[0].entries = new Entry[argValue.length];
    for(int ii=0; ii<argValue.length; ii++)
    {
      arg.array[0].entries[ii] = TcUtility.createEntry(argValue[ii]);
    }
    return arg;
  }

  public static double[] queryArg(Arg arg, double[] argValue) {
    if(arg.array == null || arg.array.length == 0 || arg.array[0] == null) return null;
    if(arg.array[0].entries == null) return null;
    argValue = new double[arg.array[0].entries.length];
    for(int ii=0; ii<arg.array[0].entries.length; ii++)
    {
      argValue[ii] = (double)TcUtility.queryEntry(arg.array[0].entries[ii], argValue[ii]);
    }
    return argValue;
  }

  public static Arg createArg(double[] argValue) {
    Arg arg = new Arg();
    arg.array = new Array[1];
    arg.array[0] = new Array();
    arg.array[0].entries = new Entry[argValue.length];
    for(int ii=0; ii<argValue.length; ii++)
    {
      arg.array[0].entries[ii] = TcUtility.createEntry(argValue[ii]);
    }
    return arg;
  }

  public static float[] queryArg(Arg arg, float[] argValue) {
    if(arg.array == null || arg.array.length == 0 || arg.array[0] == null) return null;
    if(arg.array[0].entries == null) return null;
    argValue = new float[arg.array[0].entries.length];
    for(int ii=0; ii<arg.array[0].entries.length; ii++)
    {
      argValue[ii] = (float)TcUtility.queryEntry(arg.array[0].entries[ii], argValue[ii]);
    }
    return argValue;
  }

  public static Arg createArg(float[] argValue) {
    Arg arg = new Arg();
    arg.array = new Array[1];
    arg.array[0] = new Array();
    arg.array[0].entries = new Entry[argValue.length];
    for(int ii=0; ii<argValue.length; ii++)
    {
      arg.array[0].entries[ii] = TcUtility.createEntry(argValue[ii]);
    }
    return arg;
  }

  public static Arg createArg(boolean[] argValue) {
    Arg arg = new Arg();
    arg.array = new Array[1];
    arg.array[0] = new Array();
    arg.array[0].entries = new Entry[argValue.length];
    for(int ii=0; ii<argValue.length; ii++)
    {
      arg.array[0].entries[ii] = TcUtility.createEntry(argValue[ii]);
    }
    return arg;
  }

  public static propertyDescriptor_s[] queryArg(Arg arg, propertyDescriptor_s[] argValue) {
    if(arg.array == null || arg.array.length == 0 || arg.array[0] == null) return null;
    if(arg.array[0].entries == null) return null;
    argValue = new propertyDescriptor_s[arg.array[0].entries.length];
    for(int ii=0; ii<arg.array[0].entries.length; ii++)
    {
      argValue[ii] = (propertyDescriptor_s)TcUtility.queryEntry(arg.array[0].entries[ii], argValue[ii]);
    }
    return argValue;
  }

  public static availableRelInfo_s[] queryArg(Arg arg, availableRelInfo_s[] argValue) {
    if(arg.array == null || arg.array.length == 0 || arg.array[0] == null) return null;
    if(arg.array[0].entries == null) return null;
    argValue = new availableRelInfo_s[arg.array[0].entries.length];
    for(int ii=0; ii<arg.array[0].entries.length; ii++)
    {
      argValue[ii] = (availableRelInfo_s)TcUtility.queryEntry(arg.array[0].entries[ii], argValue[ii]);
    }
    return argValue;
  }

  public static TypeInfo_s[] queryArg(Arg arg, TypeInfo_s[] argValue) {
    if(arg.array == null || arg.array.length == 0 || arg.array[0] == null) return null;
    if(arg.array[0].entries == null) return null;
    argValue = new TypeInfo_s[arg.array[0].entries.length];
    for(int ii=0; ii<arg.array[0].entries.length; ii++)
    {
      argValue[ii] = (TypeInfo_s)TcUtility.queryEntry(arg.array[0].entries[ii], argValue[ii]);
    }
    return argValue;
  }

  public static aclInfo_s[] queryArg(Arg arg, aclInfo_s[] argValue) {
    if(arg.array == null || arg.array.length == 0 || arg.array[0] == null) return null;
    if(arg.array[0].entries == null) return null;
    argValue = new aclInfo_s[arg.array[0].entries.length];
    for(int ii=0; ii<arg.array[0].entries.length; ii++)
    {
      argValue[ii] = (aclInfo_s)TcUtility.queryEntry(arg.array[0].entries[ii], argValue[ii]);
    }
    return argValue;
  }

  public static EPReport_s[] queryArg(Arg arg, EPReport_s[] argValue) {
    if(arg.array == null || arg.array.length == 0 || arg.array[0] == null) return null;
    if(arg.array[0].entries == null) return null;
    argValue = new EPReport_s[arg.array[0].entries.length];
    for(int ii=0; ii<arg.array[0].entries.length; ii++)
    {
      argValue[ii] = (EPReport_s)TcUtility.queryEntry(arg.array[0].entries[ii], argValue[ii]);
    }
    return argValue;
  }

  public static Arg createArg(short argValue) {
    Arg arg = new Arg();
    arg.val = Short.toString(argValue);
    return arg;
  }

  public static Arg createArg(DeepCopyInfo_s[] argValue) {
    Arg arg = new Arg();
    arg.array = new Array[1];
    arg.array[0] = new Array();
    arg.array[0].entries = new Entry[argValue.length];
    for(int ii=0; ii<argValue.length; ii++)
    {
      arg.array[0].entries[ii] = TcUtility.createEntry(argValue[ii]);
    }
    return arg;
  }

  public static Arg createArg(resourceListInfo_s[] argValue) {
    Arg arg = new Arg();
    arg.array = new Array[1];
    arg.array[0] = new Array();
    arg.array[0].entries = new Entry[argValue.length];
    for(int ii=0; ii<argValue.length; ii++)
    {
      arg.array[0].entries[ii] = TcUtility.createEntry(argValue[ii]);
    }
    return arg;
  }

  public static resourceListInfo_s[] queryArg(Arg arg, resourceListInfo_s[] argValue) {
    if(arg.array == null || arg.array.length == 0 || arg.array[0] == null) return null;
    if(arg.array[0].entries == null) return null;
    argValue = new resourceListInfo_s[arg.array[0].entries.length];
    for(int ii=0; ii<arg.array[0].entries.length; ii++)
    {
      argValue[ii] = (resourceListInfo_s)TcUtility.queryEntry(arg.array[0].entries[ii], argValue[ii]);
    }
    return argValue;
  }

  public static rdvAuditData_s[] queryArg(Arg arg, rdvAuditData_s[] argValue) {
    if(arg.array == null || arg.array.length == 0 || arg.array[0] == null) return null;
    if(arg.array[0].entries == null) return null;
    argValue = new rdvAuditData_s[arg.array[0].entries.length];
    for(int ii=0; ii<arg.array[0].entries.length; ii++)
    {
      argValue[ii] = (rdvAuditData_s)TcUtility.queryEntry(arg.array[0].entries[ii], argValue[ii]);
    }
    return argValue;
  }

  public static Arg createArg(bmfExtensionDescDetail_s[] argValue) {
    Arg arg = new Arg();
    arg.array = new Array[1];
    arg.array[0] = new Array();
    arg.array[0].entries = new Entry[argValue.length];
    for(int ii=0; ii<argValue.length; ii++)
    {
      arg.array[0].entries[ii] = TcUtility.createEntry(argValue[ii]);
    }
    return arg;
  }

  public static bmfExtensionDescDetail_s[] queryArg(Arg arg, bmfExtensionDescDetail_s[] argValue) {
    if(arg.array == null || arg.array.length == 0 || arg.array[0] == null) return null;
    if(arg.array[0].entries == null) return null;
    argValue = new bmfExtensionDescDetail_s[arg.array[0].entries.length];
    for(int ii=0; ii<arg.array[0].entries.length; ii++)
    {
      argValue[ii] = (bmfExtensionDescDetail_s)TcUtility.queryEntry(arg.array[0].entries[ii], argValue[ii]);
    }
    return argValue;
  }

  public static NoteChangeInfo_s[] queryArg(Arg arg, NoteChangeInfo_s[] argValue) {
    if(arg.array == null || arg.array.length == 0 || arg.array[0] == null) return null;
    if(arg.array[0].entries == null) return null;
    argValue = new NoteChangeInfo_s[arg.array[0].entries.length];
    for(int ii=0; ii<arg.array[0].entries.length; ii++)
    {
      argValue[ii] = (NoteChangeInfo_s)TcUtility.queryEntry(arg.array[0].entries[ii], argValue[ii]);
    }
    return argValue;
  }

  public static VariantChangeInfo_s[] queryArg(Arg arg, VariantChangeInfo_s[] argValue) {
    if(arg.array == null || arg.array.length == 0 || arg.array[0] == null) return null;
    if(arg.array[0].entries == null) return null;
    argValue = new VariantChangeInfo_s[arg.array[0].entries.length];
    for(int ii=0; ii<arg.array[0].entries.length; ii++)
    {
      argValue[ii] = (VariantChangeInfo_s)TcUtility.queryEntry(arg.array[0].entries[ii], argValue[ii]);
    }
    return argValue;
  }

  public static Arg createArg(double argValue) {
    Arg arg = new Arg();
    arg.val = Double.toString(argValue);
    return arg;
  }

  public static double queryArg(Arg arg, double argValue) {
    return Double.parseDouble(arg.val);
  }

  public static cannedMethodInfo_s[] queryArg(Arg arg, cannedMethodInfo_s[] argValue) {
    if(arg.array == null || arg.array.length == 0 || arg.array[0] == null) return null;
    if(arg.array[0].entries == null) return null;
    argValue = new cannedMethodInfo_s[arg.array[0].entries.length];
    for(int ii=0; ii<arg.array[0].entries.length; ii++)
    {
      argValue[ii] = (cannedMethodInfo_s)TcUtility.queryEntry(arg.array[0].entries[ii], argValue[ii]);
    }
    return argValue;
  }

  public static Arg createArgStringUnion(String[][] argValue) {
    Arg arg = new Arg();
    arg.array = new Array[1];
    arg.array[0] = new Array();
    arg.array[0].entries = new Entry[argValue.length];
    for(int ii=0; ii<argValue.length; ii++)
    {
      arg.array[0].entries[ii] = TcUtility.createEntryStringUnion(argValue[ii]);
    }
    return arg;
  }

  public static String[][] queryArg(Arg arg, String[][] argValue) {
    if(arg.array == null || arg.array.length == 0 || arg.array[0] == null) return null;
    if(arg.array[0].entries == null) return null;
    argValue = new String[arg.array[0].entries.length][];
    for(int ii=0; ii<arg.array[0].entries.length; ii++)
    {
      argValue[ii] = (String[])TcUtility.queryEntry(arg.array[0].entries[ii], argValue[ii]);
    }
    return argValue;
  }

  public static Arg createArg(int[][] argValue) {
    Arg arg = new Arg();
    arg.array = new Array[1];
    arg.array[0] = new Array();
    arg.array[0].entries = new Entry[argValue.length];
    for(int ii=0; ii<argValue.length; ii++)
    {
      arg.array[0].entries[ii] = TcUtility.createEntry(argValue[ii]);
    }
    return arg;
  }

  public static int[][] queryArg(Arg arg, int[][] argValue) {
    if(arg.array == null || arg.array.length == 0 || arg.array[0] == null) return null;
    if(arg.array[0].entries == null) return null;
    argValue = new int[arg.array[0].entries.length][];
    for(int ii=0; ii<arg.array[0].entries.length; ii++)
    {
      argValue[ii] = (int[])TcUtility.queryEntry(arg.array[0].entries[ii], argValue[ii]);
    }
    return argValue;
  }

  public static Arg createArg(boolean[][] argValue) {
    Arg arg = new Arg();
    arg.array = new Array[1];
    arg.array[0] = new Array();
    arg.array[0].entries = new Entry[argValue.length];
    for(int ii=0; ii<argValue.length; ii++)
    {
      arg.array[0].entries[ii] = TcUtility.createEntry(argValue[ii]);
    }
    return arg;
  }

  public static Arg createArg(propertyDescriptor_s[] argValue) {
    Arg arg = new Arg();
    arg.array = new Array[1];
    arg.array[0] = new Array();
    arg.array[0].entries = new Entry[argValue.length];
    for(int ii=0; ii<argValue.length; ii++)
    {
      arg.array[0].entries[ii] = TcUtility.createEntry(argValue[ii]);
    }
    return arg;
  }

  public static Arg createArg(lovData_u[] argValue) {
    Arg arg = new Arg();
    arg.array = new Array[1];
    arg.array[0] = new Array();
    arg.array[0].entries = new Entry[argValue.length];
    for(int ii=0; ii<argValue.length; ii++)
    {
      arg.array[0].entries[ii] = TcUtility.createEntry(argValue[ii]);
    }
    return arg;
  }

  public static lovData_u[] queryArg(Arg arg, lovData_u[] argValue) {
    if(arg.array == null || arg.array.length == 0 || arg.array[0] == null) return null;
    if(arg.array[0].entries == null) return null;
    argValue = new lovData_u[arg.array[0].entries.length];
    for(int ii=0; ii<arg.array[0].entries.length; ii++)
    {
      argValue[ii] = (lovData_u)TcUtility.queryEntry(arg.array[0].entries[ii], argValue[ii]);
    }
    return argValue;
  }

  public static Arg createArg(aclInfo_s[] argValue) {
    Arg arg = new Arg();
    arg.array = new Array[1];
    arg.array[0] = new Array();
    arg.array[0].entries = new Entry[argValue.length];
    for(int ii=0; ii<argValue.length; ii++)
    {
      arg.array[0].entries[ii] = TcUtility.createEntry(argValue[ii]);
    }
    return arg;
  }

  public static Arg createArg(cannedMethodInfo_s[] argValue) {
    Arg arg = new Arg();
    arg.array = new Array[1];
    arg.array[0] = new Array();
    arg.array[0].entries = new Entry[argValue.length];
    for(int ii=0; ii<argValue.length; ii++)
    {
      arg.array[0].entries[ii] = TcUtility.createEntry(argValue[ii]);
    }
    return arg;
  }

  public static deepcopyruleInfo_s[][] queryArg(Arg arg, deepcopyruleInfo_s[][] argValue) {
    if(arg.array == null || arg.array.length == 0 || arg.array[0] == null) return null;
    if(arg.array[0].entries == null) return null;
    argValue = new deepcopyruleInfo_s[arg.array[0].entries.length][];
    for(int ii=0; ii<arg.array[0].entries.length; ii++)
    {
      argValue[ii] = (deepcopyruleInfo_s[])TcUtility.queryEntry(arg.array[0].entries[ii], argValue[ii]);
    }
    return argValue;
  }

  public static Arg createArg(deepcopyruleInfo_s[][] argValue) {
    Arg arg = new Arg();
    arg.array = new Array[1];
    arg.array[0] = new Array();
    arg.array[0].entries = new Entry[argValue.length];
    for(int ii=0; ii<argValue.length; ii++)
    {
      arg.array[0].entries[ii] = TcUtility.createEntry(argValue[ii]);
    }
    return arg;
  }

  public static lovDataInfo_s[] queryArg(Arg arg, lovDataInfo_s[] argValue) {
    if(arg.array == null || arg.array.length == 0 || arg.array[0] == null) return null;
    if(arg.array[0].entries == null) return null;
    argValue = new lovDataInfo_s[arg.array[0].entries.length];
    for(int ii=0; ii<arg.array[0].entries.length; ii++)
    {
      argValue[ii] = (lovDataInfo_s)TcUtility.queryEntry(arg.array[0].entries[ii], argValue[ii]);
    }
    return argValue;
  }

  public static Arg createArg(MappingInfo argValue) {
    Arg arg = new Arg();
    arg.structure = new Structure[1];
    arg.structure[0] = new Structure();
    arg.structure[0].args = new Arg[10];
    arg.structure[0].args[0] = TcUtility.createArg(argValue.sqlStmt);
    arg.structure[0].args[1] = TcUtility.createArg(argValue.persistentFlag);
    arg.structure[0].args[2] = TcUtility.createArg(argValue.relatedToItemFlag);
    arg.structure[0].args[3] = TcUtility.createArg(argValue.updateOnSaveFlag);
    arg.structure[0].args[4] = TcUtility.createArg(argValue.dataSource);
    arg.structure[0].args[5] = TcUtility.createArgStringUnion(argValue.extAttrItem);
    arg.structure[0].args[6] = TcUtility.createArgStringUnion(argValue.extAttrItemRev);
    arg.structure[0].args[7] = TcUtility.createArgStringUnion(argValue.extAttrItemName);
    arg.structure[0].args[8] = TcUtility.createArgStringUnion(argValue.extAttrItemDesc);
    arg.structure[0].args[9] = TcUtility.createArgStringUnion(argValue.itemType);
    return arg;
  }

  public static pieRulesInfo_s[] queryArg(Arg arg, pieRulesInfo_s[] argValue) {
    if(arg.array == null || arg.array.length == 0 || arg.array[0] == null) return null;
    if(arg.array[0].entries == null) return null;
    argValue = new pieRulesInfo_s[arg.array[0].entries.length];
    for(int ii=0; ii<arg.array[0].entries.length; ii++)
    {
      argValue[ii] = (pieRulesInfo_s)TcUtility.queryEntry(arg.array[0].entries[ii], argValue[ii]);
    }
    return argValue;
  }

  public static pieActionInfo_s[] queryArg(Arg arg, pieActionInfo_s[] argValue) {
    if(arg.array == null || arg.array.length == 0 || arg.array[0] == null) return null;
    if(arg.array[0].entries == null) return null;
    argValue = new pieActionInfo_s[arg.array[0].entries.length];
    for(int ii=0; ii<arg.array[0].entries.length; ii++)
    {
      argValue[ii] = (pieActionInfo_s)TcUtility.queryEntry(arg.array[0].entries[ii], argValue[ii]);
    }
    return argValue;
  }

  public static pieTransferModeInfo_s[] queryArg(Arg arg, pieTransferModeInfo_s[] argValue) {
    if(arg.array == null || arg.array.length == 0 || arg.array[0] == null) return null;
    if(arg.array[0].entries == null) return null;
    argValue = new pieTransferModeInfo_s[arg.array[0].entries.length];
    for(int ii=0; ii<arg.array[0].entries.length; ii++)
    {
      argValue[ii] = (pieTransferModeInfo_s)TcUtility.queryEntry(arg.array[0].entries[ii], argValue[ii]);
    }
    return argValue;
  }

  public static preferenceObject_s[] queryArg(Arg arg, preferenceObject_s[] argValue) {
    if(arg.array == null || arg.array.length == 0 || arg.array[0] == null) return null;
    if(arg.array[0].entries == null) return null;
    argValue = new preferenceObject_s[arg.array[0].entries.length];
    for(int ii=0; ii<arg.array[0].entries.length; ii++)
    {
      argValue[ii] = (preferenceObject_s)TcUtility.queryEntry(arg.array[0].entries[ii], argValue[ii]);
    }
    return argValue;
  }

  public static Arg createArg(preferenceObject_s[] argValue) {
    Arg arg = new Arg();
    arg.array = new Array[1];
    arg.array[0] = new Array();
    arg.array[0].entries = new Entry[argValue.length];
    for(int ii=0; ii<argValue.length; ii++)
    {
      arg.array[0].entries[ii] = TcUtility.createEntry(argValue[ii]);
    }
    return arg;
  }

  public static rdvInstallationAssembliesData_s[] queryArg(Arg arg, rdvInstallationAssembliesData_s[] argValue) {
    if(arg.array == null || arg.array.length == 0 || arg.array[0] == null) return null;
    if(arg.array[0].entries == null) return null;
    argValue = new rdvInstallationAssembliesData_s[arg.array[0].entries.length];
    for(int ii=0; ii<arg.array[0].entries.length; ii++)
    {
      argValue[ii] = (rdvInstallationAssembliesData_s)TcUtility.queryEntry(arg.array[0].entries[ii], argValue[ii]);
    }
    return argValue;
  }

  public static rdvCompositePropObjectInfo_s[] queryArg(Arg arg, rdvCompositePropObjectInfo_s[] argValue) {
    if(arg.array == null || arg.array.length == 0 || arg.array[0] == null) return null;
    if(arg.array[0].entries == null) return null;
    argValue = new rdvCompositePropObjectInfo_s[arg.array[0].entries.length];
    for(int ii=0; ii<arg.array[0].entries.length; ii++)
    {
      argValue[ii] = (rdvCompositePropObjectInfo_s)TcUtility.queryEntry(arg.array[0].entries[ii], argValue[ii]);
    }
    return argValue;
  }

  public static rdvProductItemsData_s[] queryArg(Arg arg, rdvProductItemsData_s[] argValue) {
    if(arg.array == null || arg.array.length == 0 || arg.array[0] == null) return null;
    if(arg.array[0].entries == null) return null;
    argValue = new rdvProductItemsData_s[arg.array[0].entries.length];
    for(int ii=0; ii<arg.array[0].entries.length; ii++)
    {
      argValue[ii] = (rdvProductItemsData_s)TcUtility.queryEntry(arg.array[0].entries[ii], argValue[ii]);
    }
    return argValue;
  }

  public static rdvGOIOptionData_s[] queryArg(Arg arg, rdvGOIOptionData_s[] argValue) {
    if(arg.array == null || arg.array.length == 0 || arg.array[0] == null) return null;
    if(arg.array[0].entries == null) return null;
    argValue = new rdvGOIOptionData_s[arg.array[0].entries.length];
    for(int ii=0; ii<arg.array[0].entries.length; ii++)
    {
      argValue[ii] = (rdvGOIOptionData_s)TcUtility.queryEntry(arg.array[0].entries[ii], argValue[ii]);
    }
    return argValue;
  }

  public static Arg createArg(stringSeqValue_u[] argValue) {
    Arg arg = new Arg();
    arg.array = new Array[1];
    arg.array[0] = new Array();
    arg.array[0].entries = new Entry[argValue.length];
    for(int ii=0; ii<argValue.length; ii++)
    {
      arg.array[0].entries[ii] = TcUtility.createEntry(argValue[ii]);
    }
    return arg;
  }

  public static ListUsers_s[] queryArg(Arg arg, ListUsers_s[] argValue) {
    if(arg.array == null || arg.array.length == 0 || arg.array[0] == null) return null;
    if(arg.array[0].entries == null) return null;
    argValue = new ListUsers_s[arg.array[0].entries.length];
    for(int ii=0; ii<arg.array[0].entries.length; ii++)
    {
      argValue[ii] = (ListUsers_s)TcUtility.queryEntry(arg.array[0].entries[ii], argValue[ii]);
    }
    return argValue;
  }

  public static Arg createArg(writeTicketInfo_s[] argValue) {
    Arg arg = new Arg();
    arg.array = new Array[1];
    arg.array[0] = new Array();
    arg.array[0].entries = new Entry[argValue.length];
    for(int ii=0; ii<argValue.length; ii++)
    {
      arg.array[0].entries[ii] = TcUtility.createEntry(argValue[ii]);
    }
    return arg;
  }

  public static Arg createArg(commitDatasetFileInfo_s[] argValue) {
    Arg arg = new Arg();
    arg.array = new Array[1];
    arg.array[0] = new Array();
    arg.array[0].entries = new Entry[argValue.length];
    for(int ii=0; ii<argValue.length; ii++)
    {
      arg.array[0].entries[ii] = TcUtility.createEntry(argValue[ii]);
    }
    return arg;
  }

  public static Arg createArg(transientTicketInfo_s[] argValue) {
    Arg arg = new Arg();
    arg.array = new Array[1];
    arg.array[0] = new Array();
    arg.array[0].entries = new Entry[argValue.length];
    for(int ii=0; ii<argValue.length; ii++)
    {
      arg.array[0].entries[ii] = TcUtility.createEntry(argValue[ii]);
    }
    return arg;
  }

  public static Arg createArg(commitFileInfo_s[] argValue) {
    Arg arg = new Arg();
    arg.array = new Array[1];
    arg.array[0] = new Array();
    arg.array[0].entries = new Entry[argValue.length];
    for(int ii=0; ii<argValue.length; ii++)
    {
      arg.array[0].entries[ii] = TcUtility.createEntry(argValue[ii]);
    }
    return arg;
  }

  public static TypeInfoHierarchy_s[] queryArg(Arg arg, TypeInfoHierarchy_s[] argValue) {
    if(arg.array == null || arg.array.length == 0 || arg.array[0] == null) return null;
    if(arg.array[0].entries == null) return null;
    argValue = new TypeInfoHierarchy_s[arg.array[0].entries.length];
    for(int ii=0; ii<arg.array[0].entries.length; ii++)
    {
      argValue[ii] = (TypeInfoHierarchy_s)TcUtility.queryEntry(arg.array[0].entries[ii], argValue[ii]);
    }
    return argValue;
  }

  public static Entry createEntry(ICSProperty_s argValue) {
    Entry arg = new Entry();
    arg.structure = new Structure[1];
    arg.structure[0] = new Structure();
    arg.structure[0].args = new Arg[2];
    arg.structure[0].args[0] = TcUtility.createArg(argValue.iccs_ddid);
    arg.structure[0].args[1] = TcUtility.createArg(argValue.values);
    return arg;
  }

  public static stringSeqValue_u queryArg(Arg arg, stringSeqValue_u argValue) {
    if ( argValue == null )  argValue = new stringSeqValue_u();
    argValue.__default();
    if( arg.structure == null || arg.structure[0] == null) return null;
    if( arg.structure[0].args == null ) return argValue;
    String dicVal = "0";
    if(argValue.discriminator()) dicVal = "1";
    if( arg.structure[0].args[0].val.equals(dicVal))
    {
      return argValue;
    }
    if( arg.structure[0].args[0].val.equalsIgnoreCase("TRUE"))
    {
      argValue.seqValue(TcUtility.queryArg(arg.structure[0].args[1], argValue.seqValue()));
    }
    else
    {
      argValue.seqValue( new String[0]);
    }
    return argValue;
  }

  public static ICSProperty_s queryEntry(Entry arg, ICSProperty_s argValue) {
    if ( argValue == null )  argValue = new ICSProperty_s();
    if(arg.structure == null || arg.structure[0] == null) return null;
    if(arg.structure[0].args==null) return null;
    for(int ii=0; ii<arg.structure[0].args.length; ii++)
    {
      argValue.iccs_ddid = TcUtility.queryArg(arg.structure[0].args[0], argValue.iccs_ddid);
      argValue.values = TcUtility.queryArg(arg.structure[0].args[1], argValue.values);
    }
    return argValue;
  }

  public static Entry createEntry(String argValue) {
    Entry arg = new Entry();
    arg.val = argValue;
    return arg;
  }

  public static boolean queryEntry(Entry arg, boolean argValue) {
    return Boolean.parseBoolean(arg.val);
  }

  public static String queryArgStringUnion(Arg arg, String argValue) {
    argValue = null;
    if( arg.structure != null && arg.structure[0] != null && arg.structure[0].args != null  && arg.structure[0].args[0].val.equalsIgnoreCase("TRUE"))
    {
      argValue = arg.structure[0].args[1].val;
    }
    return argValue;
  }

  public static String queryEntry(Entry arg, String argValue) {
    return arg.val;
  }

  public static uidSeqValue_u queryArg(Arg arg, uidSeqValue_u argValue) {
    if ( argValue == null )  argValue = new uidSeqValue_u();
    argValue.__default();
    if( arg.structure == null || arg.structure[0] == null) return null;
    if( arg.structure[0].args == null ) return argValue;
    String dicVal = "0";
    if(argValue.discriminator()) dicVal = "1";
    if( arg.structure[0].args[0].val.equals(dicVal))
    {
      return argValue;
    }
    if( arg.structure[0].args[0].val.equalsIgnoreCase("TRUE"))
    {
      argValue.seqValue(TcUtility.queryArg(arg.structure[0].args[1], argValue.seqValue()));
    }
    else
    {
      argValue.seqValue( new String[0]);
    }
    return argValue;
  }

  public static Arg createArg(uidSeqValue_u argValue) {
    Arg arg = new Arg();
    String discValue = Boolean.toString(argValue.discriminator());
    arg.structure = new Structure[1];
    arg.structure[0] = new Structure();
    if(discValue.equalsIgnoreCase("TRUE"))
    {
      arg.structure[0].args = new Arg[2];
    }
    else
    {
      arg.structure[0].args = new Arg[1];
    }
    arg.structure[0].args[0]= new Arg();
    arg.structure[0].args[0].val=discValue;
    
//process union members
    if(discValue.equalsIgnoreCase("TRUE"))
    {
      arg.structure[0].args[1] = TcUtility.createArg(argValue.seqValue());
    }
    return arg;
  }

  public static ICSViewAttribute_s queryEntry(Entry arg, ICSViewAttribute_s argValue) {
    if ( argValue == null )  argValue = new ICSViewAttribute_s();
    if(arg.structure == null || arg.structure[0] == null) return null;
    if(arg.structure[0].args==null) return null;
    for(int ii=0; ii<arg.structure[0].args.length; ii++)
    {
      argValue.classAttrDBIndex = TcUtility.queryArg(arg.structure[0].args[0], argValue.classAttrDBIndex);
      argValue.classAttrUnct = TcUtility.queryArg(arg.structure[0].args[1], argValue.classAttrUnct);
      argValue.classAttrClassId = TcUtility.queryArg(arg.structure[0].args[2], argValue.classAttrClassId);
      argValue.classAttrAnnotation = TcUtility.queryArg(arg.structure[0].args[3], argValue.classAttrAnnotation);
      argValue.classAttrName = TcUtility.queryArg(arg.structure[0].args[4], argValue.classAttrName);
      argValue.classAttrShortName = TcUtility.queryArg(arg.structure[0].args[5], argValue.classAttrShortName);
      argValue.classAttrDefaultAnnotation = TcUtility.queryArg(arg.structure[0].args[6], argValue.classAttrDefaultAnnotation);
      argValue.classAttrFormat = TcUtility.queryArg(arg.structure[0].args[7], argValue.classAttrFormat);
      argValue.classAttrFormat2 = TcUtility.queryArg(arg.structure[0].args[8], argValue.classAttrFormat2);
      argValue.defaultValue = TcUtility.queryArg(arg.structure[0].args[9], argValue.defaultValue);
      argValue.defaultValue2 = TcUtility.queryArg(arg.structure[0].args[10], argValue.defaultValue2);
      argValue.classAttrUnit = TcUtility.queryArg(arg.structure[0].args[11], argValue.classAttrUnit);
      argValue.classAttrUnit2 = TcUtility.queryArg(arg.structure[0].args[12], argValue.classAttrUnit2);
      argValue.classAttrMin = TcUtility.queryArg(arg.structure[0].args[13], argValue.classAttrMin);
      argValue.classAttrMax = TcUtility.queryArg(arg.structure[0].args[14], argValue.classAttrMax);
      argValue.classAttrMin2 = TcUtility.queryArg(arg.structure[0].args[15], argValue.classAttrMin2);
      argValue.classAttrMax2 = TcUtility.queryArg(arg.structure[0].args[16], argValue.classAttrMax2);
      argValue.classAttrFlags = TcUtility.queryArg(arg.structure[0].args[17], argValue.classAttrFlags);
      argValue.classAttrArraySize = TcUtility.queryArg(arg.structure[0].args[18], argValue.classAttrArraySize);
      argValue.classAttrExt1 = TcUtility.queryArg(arg.structure[0].args[19], argValue.classAttrExt1);
      argValue.classAttrExt2 = TcUtility.queryArg(arg.structure[0].args[20], argValue.classAttrExt2);
      argValue.text = TcUtility.queryArg(arg.structure[0].args[21], argValue.text);
      argValue.text1 = TcUtility.queryArg(arg.structure[0].args[22], argValue.text1);
      argValue.text2 = TcUtility.queryArg(arg.structure[0].args[23], argValue.text2);
      argValue.description = TcUtility.queryArg(arg.structure[0].args[24], argValue.description);
      argValue.classAttrIsReference = TcUtility.queryArg(arg.structure[0].args[25], argValue.classAttrIsReference);
      argValue.classAttrRefType = TcUtility.queryArg(arg.structure[0].args[26], argValue.classAttrRefType);
      argValue.classAttrRefObjectType = TcUtility.queryArg(arg.structure[0].args[27], argValue.classAttrRefObjectType);
      argValue.classAttrRefOptions = TcUtility.queryArg(arg.structure[0].args[28], argValue.classAttrRefOptions);
      argValue.displayableAttProperties = TcUtility.queryArg(arg.structure[0].args[29], argValue.displayableAttProperties);
      argValue.fnd0DependencyAttribute = TcUtility.queryArg(arg.structure[0].args[30], argValue.fnd0DependencyAttribute);
      argValue.fnd0DependencyConfiguration = TcUtility.queryArg(arg.structure[0].args[31], argValue.fnd0DependencyConfiguration);
    }
    return argValue;
  }

  public static longSeqValue_u queryArg(Arg arg, longSeqValue_u argValue) {
    if ( argValue == null )  argValue = new longSeqValue_u();
    argValue.__default();
    if( arg.structure == null || arg.structure[0] == null) return null;
    if( arg.structure[0].args == null ) return argValue;
    String dicVal = "0";
    if(argValue.discriminator()) dicVal = "1";
    if( arg.structure[0].args[0].val.equals(dicVal))
    {
      return argValue;
    }
    if( arg.structure[0].args[0].val.equalsIgnoreCase("TRUE"))
    {
      argValue.seqValue(TcUtility.queryArg(arg.structure[0].args[1], argValue.seqValue()));
    }
    else
    {
      argValue.seqValue( new int[0]);
    }
    return argValue;
  }

  public static pftMappingId_t queryEntry(Entry arg, pftMappingId_t argValue) {
    if ( argValue == null )  argValue = new pftMappingId_t();
    if(arg.structure == null || arg.structure[0] == null) return null;
    if(arg.structure[0].args==null) return null;
    for(int ii=0; ii<arg.structure[0].args.length; ii++)
    {
      argValue.itemOrRevUid = TcUtility.queryArg(arg.structure[0].args[0], argValue.itemOrRevUid);
      argValue.name = TcUtility.queryArg(arg.structure[0].args[1], argValue.name);
    }
    return argValue;
  }

  public static pftMappingIdValue_u queryArg(Arg arg, pftMappingIdValue_u argValue) {
    if ( argValue == null )  argValue = new pftMappingIdValue_u();
    argValue.__default();
    if( arg.structure == null || arg.structure[0] == null) return null;
    if( arg.structure[0].args == null ) return argValue;
    String dicVal = "0";
    if(argValue.discriminator()) dicVal = "1";
    if( arg.structure[0].args[0].val.equals(dicVal))
    {
      return argValue;
    }
    if( arg.structure[0].args[0].val.equalsIgnoreCase("TRUE"))
    {
      argValue.pftMappingId_value(TcUtility.queryArg(arg.structure[0].args[1], argValue.pftMappingId_value()));
    }
    return argValue;
  }

  public static Entry createEntry(int argValue) {
    Entry arg = new Entry();
    arg.val = Integer.toString(argValue);
    return arg;
  }

  public static Arg createArg(longSeqValue_u argValue) {
    Arg arg = new Arg();
    String discValue = Boolean.toString(argValue.discriminator());
    arg.structure = new Structure[1];
    arg.structure[0] = new Structure();
    if(discValue.equalsIgnoreCase("TRUE"))
    {
      arg.structure[0].args = new Arg[2];
    }
    else
    {
      arg.structure[0].args = new Arg[1];
    }
    arg.structure[0].args[0]= new Arg();
    arg.structure[0].args[0].val=discValue;
    
//process union members
    if(discValue.equalsIgnoreCase("TRUE"))
    {
      arg.structure[0].args[1] = TcUtility.createArg(argValue.seqValue());
    }
    return arg;
  }

  public static Arg createArg(stringSeqValue_u argValue) {
    Arg arg = new Arg();
    String discValue = Boolean.toString(argValue.discriminator());
    arg.structure = new Structure[1];
    arg.structure[0] = new Structure();
    if(discValue.equalsIgnoreCase("TRUE"))
    {
      arg.structure[0].args = new Arg[2];
    }
    else
    {
      arg.structure[0].args = new Arg[1];
    }
    arg.structure[0].args[0]= new Arg();
    arg.structure[0].args[0].val=discValue;
    
//process union members
    if(discValue.equalsIgnoreCase("TRUE"))
    {
      arg.structure[0].args[1] = TcUtility.createArg(argValue.seqValue());
    }
    return arg;
  }

  public static short queryArg(Arg arg, short argValue) {
    return Short.parseShort(arg.val);
  }

  public static ICSAdminAttr_s queryEntry(Entry arg, ICSAdminAttr_s argValue) {
    if ( argValue == null )  argValue = new ICSAdminAttr_s();
    if(arg.structure == null || arg.structure[0] == null) return null;
    if(arg.structure[0].args==null) return null;
    for(int ii=0; ii<arg.structure[0].args.length; ii++)
    {
      argValue.pomUID = TcUtility.queryArg(arg.structure[0].args[0], argValue.pomUID);
      argValue.smindex = TcUtility.queryArg(arg.structure[0].args[1], argValue.smindex);
      argValue.dbindex = TcUtility.queryArg(arg.structure[0].args[2], argValue.dbindex);
      argValue.cid = TcUtility.queryArg(arg.structure[0].args[3], argValue.cid);
      argValue.unct = TcUtility.queryArg(arg.structure[0].args[4], argValue.unct);
      argValue.annotation = TcUtility.queryArg(arg.structure[0].args[5], argValue.annotation);
      argValue.minValue = TcUtility.queryArg(arg.structure[0].args[6], argValue.minValue);
      argValue.maxValue = TcUtility.queryArg(arg.structure[0].args[7], argValue.maxValue);
      argValue.minValue2 = TcUtility.queryArg(arg.structure[0].args[8], argValue.minValue2);
      argValue.maxValue2 = TcUtility.queryArg(arg.structure[0].args[9], argValue.maxValue2);
      argValue.defaultValue = TcUtility.queryArg(arg.structure[0].args[10], argValue.defaultValue);
      argValue.defaultValue2 = TcUtility.queryArg(arg.structure[0].args[11], argValue.defaultValue2);
      argValue.flags = TcUtility.queryArg(arg.structure[0].args[12], argValue.flags);
      argValue.ext1 = TcUtility.queryArg(arg.structure[0].args[13], argValue.ext1);
      argValue.ext2 = TcUtility.queryArg(arg.structure[0].args[14], argValue.ext2);
      argValue.arraySize = TcUtility.queryArg(arg.structure[0].args[15], argValue.arraySize);
      argValue.name = TcUtility.queryArg(arg.structure[0].args[16], argValue.name);
      argValue.sname = TcUtility.queryArg(arg.structure[0].args[17], argValue.sname);
      argValue.defaultAnnotation = TcUtility.queryArg(arg.structure[0].args[18], argValue.defaultAnnotation);
      argValue.format = TcUtility.queryArg(arg.structure[0].args[19], argValue.format);
      argValue.format2 = TcUtility.queryArg(arg.structure[0].args[20], argValue.format2);
      argValue.unit = TcUtility.queryArg(arg.structure[0].args[21], argValue.unit);
      argValue.unit2 = TcUtility.queryArg(arg.structure[0].args[22], argValue.unit2);
      argValue.refType = TcUtility.queryArg(arg.structure[0].args[23], argValue.refType);
      argValue.refObjectType = TcUtility.queryArg(arg.structure[0].args[24], argValue.refObjectType);
      argValue.refOptions = TcUtility.queryArg(arg.structure[0].args[25], argValue.refOptions);
      argValue.dictRefType = TcUtility.queryArg(arg.structure[0].args[26], argValue.dictRefType);
      argValue.dictRefObjectType = TcUtility.queryArg(arg.structure[0].args[27], argValue.dictRefObjectType);
      argValue.dictRefOptions = TcUtility.queryArg(arg.structure[0].args[28], argValue.dictRefOptions);
      argValue.dictFlags = TcUtility.queryArg(arg.structure[0].args[29], argValue.dictFlags);
      argValue.dictDefaultValue = TcUtility.queryArg(arg.structure[0].args[30], argValue.dictDefaultValue);
      argValue.dictDefaultValue2 = TcUtility.queryArg(arg.structure[0].args[31], argValue.dictDefaultValue2);
      argValue.dictMinValue = TcUtility.queryArg(arg.structure[0].args[32], argValue.dictMinValue);
      argValue.dictMaxValue = TcUtility.queryArg(arg.structure[0].args[33], argValue.dictMaxValue);
      argValue.dictMinValue2 = TcUtility.queryArg(arg.structure[0].args[34], argValue.dictMinValue2);
      argValue.dictMaxValue2 = TcUtility.queryArg(arg.structure[0].args[35], argValue.dictMaxValue2);
      argValue.dictExt1 = TcUtility.queryArg(arg.structure[0].args[36], argValue.dictExt1);
      argValue.dictExt2 = TcUtility.queryArg(arg.structure[0].args[37], argValue.dictExt2);
      argValue.fnd0DependencyAttribute = TcUtility.queryArg(arg.structure[0].args[38], argValue.fnd0DependencyAttribute);
      argValue.fnd0DependencyConfiguration = TcUtility.queryArg(arg.structure[0].args[39], argValue.fnd0DependencyConfiguration);
      argValue.dictDependencyConfiguration = TcUtility.queryArg(arg.structure[0].args[40], argValue.dictDependencyConfiguration);
    }
    return argValue;
  }

  public static Entry createEntry(ICSAdminAttr_s argValue) {
    Entry arg = new Entry();
    arg.structure = new Structure[1];
    arg.structure[0] = new Structure();
    arg.structure[0].args = new Arg[41];
    arg.structure[0].args[0] = TcUtility.createArg(argValue.pomUID);
    arg.structure[0].args[1] = TcUtility.createArg(argValue.smindex);
    arg.structure[0].args[2] = TcUtility.createArg(argValue.dbindex);
    arg.structure[0].args[3] = TcUtility.createArg(argValue.cid);
    arg.structure[0].args[4] = TcUtility.createArg(argValue.unct);
    arg.structure[0].args[5] = TcUtility.createArg(argValue.annotation);
    arg.structure[0].args[6] = TcUtility.createArg(argValue.minValue);
    arg.structure[0].args[7] = TcUtility.createArg(argValue.maxValue);
    arg.structure[0].args[8] = TcUtility.createArg(argValue.minValue2);
    arg.structure[0].args[9] = TcUtility.createArg(argValue.maxValue2);
    arg.structure[0].args[10] = TcUtility.createArg(argValue.defaultValue);
    arg.structure[0].args[11] = TcUtility.createArg(argValue.defaultValue2);
    arg.structure[0].args[12] = TcUtility.createArg(argValue.flags);
    arg.structure[0].args[13] = TcUtility.createArg(argValue.ext1);
    arg.structure[0].args[14] = TcUtility.createArg(argValue.ext2);
    arg.structure[0].args[15] = TcUtility.createArg(argValue.arraySize);
    arg.structure[0].args[16] = TcUtility.createArg(argValue.name);
    arg.structure[0].args[17] = TcUtility.createArg(argValue.sname);
    arg.structure[0].args[18] = TcUtility.createArg(argValue.defaultAnnotation);
    arg.structure[0].args[19] = TcUtility.createArg(argValue.format);
    arg.structure[0].args[20] = TcUtility.createArg(argValue.format2);
    arg.structure[0].args[21] = TcUtility.createArg(argValue.unit);
    arg.structure[0].args[22] = TcUtility.createArg(argValue.unit2);
    arg.structure[0].args[23] = TcUtility.createArg(argValue.refType);
    arg.structure[0].args[24] = TcUtility.createArg(argValue.refObjectType);
    arg.structure[0].args[25] = TcUtility.createArg(argValue.refOptions);
    arg.structure[0].args[26] = TcUtility.createArg(argValue.dictRefType);
    arg.structure[0].args[27] = TcUtility.createArg(argValue.dictRefObjectType);
    arg.structure[0].args[28] = TcUtility.createArg(argValue.dictRefOptions);
    arg.structure[0].args[29] = TcUtility.createArg(argValue.dictFlags);
    arg.structure[0].args[30] = TcUtility.createArg(argValue.dictDefaultValue);
    arg.structure[0].args[31] = TcUtility.createArg(argValue.dictDefaultValue2);
    arg.structure[0].args[32] = TcUtility.createArg(argValue.dictMinValue);
    arg.structure[0].args[33] = TcUtility.createArg(argValue.dictMaxValue);
    arg.structure[0].args[34] = TcUtility.createArg(argValue.dictMinValue2);
    arg.structure[0].args[35] = TcUtility.createArg(argValue.dictMaxValue2);
    arg.structure[0].args[36] = TcUtility.createArg(argValue.dictExt1);
    arg.structure[0].args[37] = TcUtility.createArg(argValue.dictExt2);
    arg.structure[0].args[38] = TcUtility.createArg(argValue.fnd0DependencyAttribute);
    arg.structure[0].args[39] = TcUtility.createArg(argValue.fnd0DependencyConfiguration);
    arg.structure[0].args[40] = TcUtility.createArg(argValue.dictDependencyConfiguration);
    return arg;
  }

  public static ExtendedProperty_s[] queryArg(Arg arg, ExtendedProperty_s[] argValue) {
    if(arg.array == null || arg.array.length == 0 || arg.array[0] == null) return null;
    if(arg.array[0].entries == null) return null;
    argValue = new ExtendedProperty_s[arg.array[0].entries.length];
    for(int ii=0; ii<arg.array[0].entries.length; ii++)
    {
      argValue[ii] = (ExtendedProperty_s)TcUtility.queryEntry(arg.array[0].entries[ii], argValue[ii]);
    }
    return argValue;
  }

  public static Arg createArg(ExtendedProperty_s[] argValue) {
    Arg arg = new Arg();
    arg.array = new Array[1];
    arg.array[0] = new Array();
    arg.array[0].entries = new Entry[argValue.length];
    for(int ii=0; ii<argValue.length; ii++)
    {
      arg.array[0].entries[ii] = TcUtility.createEntry(argValue[ii]);
    }
    return arg;
  }

  public static pftMappingN_t queryEntry(Entry arg, pftMappingN_t argValue) {
    if ( argValue == null )  argValue = new pftMappingN_t();
    if(arg.structure == null || arg.structure[0] == null) return null;
    if(arg.structure[0].args==null) return null;
    for(int ii=0; ii<arg.structure[0].args.length; ii++)
    {
      argValue.pftId = TcUtility.queryArg(arg.structure[0].args[0], argValue.pftId);
      argValue.pftMapping = TcUtility.queryArg(arg.structure[0].args[1], argValue.pftMapping);
    }
    return argValue;
  }

  public static Entry createEntry(pftMappingW_t argValue) {
    Entry arg = new Entry();
    arg.structure = new Structure[1];
    arg.structure[0] = new Structure();
    arg.structure[0].args = new Arg[2];
    arg.structure[0].args[0] = TcUtility.createArg(argValue.itemOrRevUid);
    arg.structure[0].args[1] = TcUtility.createArg(argValue.pftMapping);
    return arg;
  }

  public static pftMapping_t queryArg(Arg arg, pftMapping_t argValue) {
    if ( argValue == null )  argValue = new pftMapping_t();
    if(arg.structure == null || arg.structure[0] == null) return null;
    if(arg.structure[0].args==null) return null;
    for(int ii=0; ii<arg.structure[0].args.length; ii++)
    {
      argValue.typeName = TcUtility.queryArg(arg.structure[0].args[0], argValue.typeName);
      argValue.templateType = TcUtility.queryArg(arg.structure[0].args[1], argValue.templateType);
      argValue.enabled = TcUtility.queryArg(arg.structure[0].args[2], argValue.enabled);
      argValue.useForChildren = TcUtility.queryArg(arg.structure[0].args[3], argValue.useForChildren);
      argValue.attrMapping = TcUtility.queryArg(arg.structure[0].args[4], argValue.attrMapping);
    }
    return argValue;
  }

  public static pftColumnDescriptor_t queryEntry(Entry arg, pftColumnDescriptor_t argValue) {
    if ( argValue == null )  argValue = new pftColumnDescriptor_t();
    if(arg.structure == null || arg.structure[0] == null) return null;
    if(arg.structure[0].args==null) return null;
    for(int ii=0; ii<arg.structure[0].args.length; ii++)
    {
      argValue.name = TcUtility.queryArg(arg.structure[0].args[0], argValue.name);
      argValue.type = TcUtility.queryArg(arg.structure[0].args[1], argValue.type);
    }
    return argValue;
  }

  public static iccsGraphicsInformationNode_t queryEntry(Entry arg, iccsGraphicsInformationNode_t argValue) {
    if ( argValue == null )  argValue = new iccsGraphicsInformationNode_t();
    if(arg.structure == null || arg.structure[0] == null) return null;
    if(arg.structure[0].args==null) return null;
    for(int ii=0; ii<arg.structure[0].args.length; ii++)
    {
      argValue.classId = TcUtility.queryArg(arg.structure[0].args[0], argValue.classId);
      argValue.classType = TcUtility.queryArg(arg.structure[0].args[1], argValue.classType);
      argValue.notes = TcUtility.queryArg(arg.structure[0].args[2], argValue.notes);
      argValue.pftMappingInformations = TcUtility.queryArg(arg.structure[0].args[3], argValue.pftMappingInformations);
    }
    return argValue;
  }

  public static ico_s queryEntry(Entry arg, ico_s argValue) {
    if ( argValue == null )  argValue = new ico_s();
    if(arg.structure == null || arg.structure[0] == null) return null;
    if(arg.structure[0].args==null) return null;
    for(int ii=0; ii<arg.structure[0].args.length; ii++)
    {
      argValue.uid = TcUtility.queryArg(arg.structure[0].args[0], argValue.uid);
      argValue.id = TcUtility.queryArg(arg.structure[0].args[1], argValue.id);
      argValue.cid = TcUtility.queryArg(arg.structure[0].args[2], argValue.cid);
      argValue.wso = TcUtility.queryArg(arg.structure[0].args[3], argValue.wso);
      argValue.iref = TcUtility.queryArg(arg.structure[0].args[4], argValue.iref);
      argValue.systemProperties = TcUtility.queryArg(arg.structure[0].args[5], argValue.systemProperties);
      argValue.userProperties = TcUtility.queryArg(arg.structure[0].args[6], argValue.userProperties);
    }
    return argValue;
  }

  public static ICSProperty_s[] queryEntry(Entry arg, ICSProperty_s[] argValue) {
    if(arg.array == null || arg.array.length == 0 || arg.array[0] == null) return null;
    if(arg.array[0].entries == null) return null;
    argValue = new ICSProperty_s[arg.array[0].entries.length];
    for(int ii=0; ii<arg.array[0].entries.length; ii++)
    {
      argValue[ii] = (ICSProperty_s)TcUtility.queryEntry(arg.array[0].entries[ii], argValue[ii]);
    }
    return argValue;
  }

  public static ICSChildren_s queryEntry(Entry arg, ICSChildren_s argValue) {
    if ( argValue == null )  argValue = new ICSChildren_s();
    if(arg.structure == null || arg.structure[0] == null) return null;
    if(arg.structure[0].args==null) return null;
    for(int ii=0; ii<arg.structure[0].args.length; ii++)
    {
      argValue.childtype = TcUtility.queryArg(arg.structure[0].args[0], argValue.childtype);
      argValue.childId = TcUtility.queryArg(arg.structure[0].args[1], argValue.childId);
      argValue.childName = TcUtility.queryArg(arg.structure[0].args[2], argValue.childName);
      argValue.childtag = TcUtility.queryArg(arg.structure[0].args[3], argValue.childtag);
      argValue.childInstanceCount = TcUtility.queryArg(arg.structure[0].args[4], argValue.childInstanceCount);
      argValue.childClassChildrenCount = TcUtility.queryArg(arg.structure[0].args[5], argValue.childClassChildrenCount);
      argValue.childViewCount = TcUtility.queryArg(arg.structure[0].args[6], argValue.childViewCount);
      argValue.childSubClassCount = TcUtility.queryArg(arg.structure[0].args[7], argValue.childSubClassCount);
      argValue.iconImageTicket = TcUtility.queryArg(arg.structure[0].args[8], argValue.iconImageTicket);
      argValue.classImageTicket = TcUtility.queryArg(arg.structure[0].args[9], argValue.classImageTicket);
    }
    return argValue;
  }

  public static ICSUNITDefinition_s queryEntry(Entry arg, ICSUNITDefinition_s argValue) {
    if ( argValue == null )  argValue = new ICSUNITDefinition_s();
    if(arg.structure == null || arg.structure[0] == null) return null;
    if(arg.structure[0].args==null) return null;
    for(int ii=0; ii<arg.structure[0].args.length; ii++)
    {
      argValue.id = TcUtility.queryArg(arg.structure[0].args[0], argValue.id);
      argValue.measure = TcUtility.queryArg(arg.structure[0].args[1], argValue.measure);
      argValue.name = TcUtility.queryArg(arg.structure[0].args[2], argValue.name);
      argValue.label = TcUtility.queryArg(arg.structure[0].args[3], argValue.label);
      argValue.system = TcUtility.queryArg(arg.structure[0].args[4], argValue.system);
      argValue.base = TcUtility.queryArg(arg.structure[0].args[5], argValue.base);
      argValue.multfact = TcUtility.queryArg(arg.structure[0].args[6], argValue.multfact);
      argValue.addfact = TcUtility.queryArg(arg.structure[0].args[7], argValue.addfact);
      argValue.decimalPlaces = TcUtility.queryArg(arg.structure[0].args[8], argValue.decimalPlaces);
      argValue.inputUnitOnly = TcUtility.queryArg(arg.structure[0].args[9], argValue.inputUnitOnly);
    }
    return argValue;
  }

  public static ICSAdminViewAttr_s queryEntry(Entry arg, ICSAdminViewAttr_s argValue) {
    if ( argValue == null )  argValue = new ICSAdminViewAttr_s();
    if(arg.structure == null || arg.structure[0] == null) return null;
    if(arg.structure[0].args==null) return null;
    for(int ii=0; ii<arg.structure[0].args.length; ii++)
    {
      argValue.pomUID = TcUtility.queryArg(arg.structure[0].args[0], argValue.pomUID);
      argValue.smindex = TcUtility.queryArg(arg.structure[0].args[1], argValue.smindex);
      argValue.minValue = TcUtility.queryArg(arg.structure[0].args[2], argValue.minValue);
      argValue.maxValue = TcUtility.queryArg(arg.structure[0].args[3], argValue.maxValue);
      argValue.minValue2 = TcUtility.queryArg(arg.structure[0].args[4], argValue.minValue2);
      argValue.maxValue2 = TcUtility.queryArg(arg.structure[0].args[5], argValue.maxValue2);
      argValue.flags = TcUtility.queryArg(arg.structure[0].args[6], argValue.flags);
      argValue.flags1 = TcUtility.queryArg(arg.structure[0].args[7], argValue.flags1);
      argValue.flags2 = TcUtility.queryArg(arg.structure[0].args[8], argValue.flags2);
      argValue.text = TcUtility.queryArg(arg.structure[0].args[9], argValue.text);
      argValue.text1 = TcUtility.queryArg(arg.structure[0].args[10], argValue.text1);
      argValue.text2 = TcUtility.queryArg(arg.structure[0].args[11], argValue.text2);
      argValue.ext1 = TcUtility.queryArg(arg.structure[0].args[12], argValue.ext1);
      argValue.ext2 = TcUtility.queryArg(arg.structure[0].args[13], argValue.ext2);
      argValue.defaultValue = TcUtility.queryArg(arg.structure[0].args[14], argValue.defaultValue);
      argValue.classDefaultValue = TcUtility.queryArg(arg.structure[0].args[15], argValue.classDefaultValue);
      argValue.defaultValue2 = TcUtility.queryArg(arg.structure[0].args[16], argValue.defaultValue2);
      argValue.classDefaultValue2 = TcUtility.queryArg(arg.structure[0].args[17], argValue.classDefaultValue2);
      argValue.fnd0DependencyAttribute = TcUtility.queryArg(arg.structure[0].args[18], argValue.fnd0DependencyAttribute);
      argValue.fnd0DependencyConfiguration = TcUtility.queryArg(arg.structure[0].args[19], argValue.fnd0DependencyConfiguration);
    }
    return argValue;
  }

  public static Entry createEntry(ICSAdminViewAttr_s argValue) {
    Entry arg = new Entry();
    arg.structure = new Structure[1];
    arg.structure[0] = new Structure();
    arg.structure[0].args = new Arg[20];
    arg.structure[0].args[0] = TcUtility.createArg(argValue.pomUID);
    arg.structure[0].args[1] = TcUtility.createArg(argValue.smindex);
    arg.structure[0].args[2] = TcUtility.createArg(argValue.minValue);
    arg.structure[0].args[3] = TcUtility.createArg(argValue.maxValue);
    arg.structure[0].args[4] = TcUtility.createArg(argValue.minValue2);
    arg.structure[0].args[5] = TcUtility.createArg(argValue.maxValue2);
    arg.structure[0].args[6] = TcUtility.createArg(argValue.flags);
    arg.structure[0].args[7] = TcUtility.createArg(argValue.flags1);
    arg.structure[0].args[8] = TcUtility.createArg(argValue.flags2);
    arg.structure[0].args[9] = TcUtility.createArg(argValue.text);
    arg.structure[0].args[10] = TcUtility.createArg(argValue.text1);
    arg.structure[0].args[11] = TcUtility.createArg(argValue.text2);
    arg.structure[0].args[12] = TcUtility.createArg(argValue.ext1);
    arg.structure[0].args[13] = TcUtility.createArg(argValue.ext2);
    arg.structure[0].args[14] = TcUtility.createArg(argValue.defaultValue);
    arg.structure[0].args[15] = TcUtility.createArg(argValue.classDefaultValue);
    arg.structure[0].args[16] = TcUtility.createArg(argValue.defaultValue2);
    arg.structure[0].args[17] = TcUtility.createArg(argValue.classDefaultValue2);
    arg.structure[0].args[18] = TcUtility.createArg(argValue.fnd0DependencyAttribute);
    arg.structure[0].args[19] = TcUtility.createArg(argValue.fnd0DependencyConfiguration);
    return arg;
  }

  public static String[] queryEntryStringUnion(Entry arg, String[] argValue) {
    if(arg.array == null || arg.array.length == 0 || arg.array[0] == null) return null;
    if(arg.array[0].entries == null) return null;
    argValue = new String[arg.array[0].entries.length];
    for(int ii=0; ii<arg.array[0].entries.length; ii++)
    {
      argValue[ii] = (String)TcUtility.queryEntryStringUnion(arg.array[0].entries[ii], argValue[ii]);
    }
    return argValue;
  }

  public static propertyData_u queryArg(Arg arg, propertyData_u argValue) {
    if ( argValue == null )  argValue = new propertyData_u();
    argValue.__default();
    if( arg.structure == null || arg.structure[0] == null) return null;
    if( arg.structure[0].args == null ) return argValue;
    if( arg.structure[0].args[0].val.equals(Integer.toString(argValue.discriminator())))
    {
      return argValue;
    }
    if( arg.structure[0].args[0].val.equalsIgnoreCase("1"))
    {
      argValue.char_value(TcUtility.queryArg(arg.structure[0].args[1], argValue.char_value()));
    }
    else if( arg.structure[0].args[0].val.equalsIgnoreCase("8"))
    {
      argValue.string_value(TcUtility.queryArgStringUnion(arg.structure[0].args[1], argValue.string_value()));
    }
    else if( arg.structure[0].args[0].val.equalsIgnoreCase("7"))
    {
      argValue.short_value(TcUtility.queryArg(arg.structure[0].args[1], argValue.short_value()));
    }
    else if( arg.structure[0].args[0].val.equalsIgnoreCase("6"))
    {
      argValue.boolean_value(TcUtility.queryArg(arg.structure[0].args[1], argValue.boolean_value()));
    }
    else if( arg.structure[0].args[0].val.equalsIgnoreCase("4"))
    {
      argValue.float_value(TcUtility.queryArg(arg.structure[0].args[1], argValue.float_value()));
    }
    else if( arg.structure[0].args[0].val.equalsIgnoreCase("3"))
    {
      argValue.double_value(TcUtility.queryArg(arg.structure[0].args[1], argValue.double_value()));
    }
    else if( arg.structure[0].args[0].val.equalsIgnoreCase("5"))
    {
      argValue.long_value(TcUtility.queryArg(arg.structure[0].args[1], argValue.long_value()));
    }
    else if( arg.structure[0].args[0].val.equalsIgnoreCase("2"))
    {
      argValue.date_value(TcUtility.queryArgStringUnion(arg.structure[0].args[1], argValue.date_value()));
    }
    else if( arg.structure[0].args[0].val.equalsIgnoreCase("9"))
    {
      argValue.typedRef_value(TcUtility.queryArgStringUnion(arg.structure[0].args[1], argValue.typedRef_value()));
    }
    else if( arg.structure[0].args[0].val.equalsIgnoreCase("10"))
    {
      argValue.untypedRef_value(TcUtility.queryArgStringUnion(arg.structure[0].args[1], argValue.untypedRef_value()));
    }
    else if( arg.structure[0].args[0].val.equalsIgnoreCase("11"))
    {
      argValue.externalRef_value(TcUtility.queryArgStringUnion(arg.structure[0].args[1], argValue.externalRef_value()));
    }
    else if( arg.structure[0].args[0].val.equalsIgnoreCase("12"))
    {
      argValue.note_value(TcUtility.queryArgStringUnion(arg.structure[0].args[1], argValue.note_value()));
    }
    else if( arg.structure[0].args[0].val.equalsIgnoreCase("13"))
    {
      argValue.typedRelation_value(TcUtility.queryArgStringUnion(arg.structure[0].args[1], argValue.typedRelation_value()));
    }
    else if( arg.structure[0].args[0].val.equalsIgnoreCase("14"))
    {
      argValue.untypedRelation_value(TcUtility.queryArgStringUnion(arg.structure[0].args[1], argValue.untypedRelation_value()));
    }
    else if( arg.structure[0].args[0].val.equalsIgnoreCase("101"))
    {
      argValue.char_value_array(TcUtility.queryArg(arg.structure[0].args[1], argValue.char_value_array()));
    }
    else if( arg.structure[0].args[0].val.equalsIgnoreCase("102"))
    {
      argValue.date_value_array(TcUtility.queryArgStringUnion(arg.structure[0].args[1], argValue.date_value_array()));
    }
    else if( arg.structure[0].args[0].val.equalsIgnoreCase("103"))
    {
      argValue.double_value_array(TcUtility.queryArg(arg.structure[0].args[1], argValue.double_value_array()));
    }
    else if( arg.structure[0].args[0].val.equalsIgnoreCase("104"))
    {
      argValue.float_value_array(TcUtility.queryArg(arg.structure[0].args[1], argValue.float_value_array()));
    }
    else if( arg.structure[0].args[0].val.equalsIgnoreCase("105"))
    {
      argValue.long_value_array(TcUtility.queryArg(arg.structure[0].args[1], argValue.long_value_array()));
    }
    else if( arg.structure[0].args[0].val.equalsIgnoreCase("106"))
    {
      argValue.boolean_value_array(TcUtility.queryArg(arg.structure[0].args[1], argValue.boolean_value_array()));
    }
    else if( arg.structure[0].args[0].val.equalsIgnoreCase("107"))
    {
      argValue.short_value_array(TcUtility.queryArg(arg.structure[0].args[1], argValue.short_value_array()));
    }
    else if( arg.structure[0].args[0].val.equalsIgnoreCase("108"))
    {
      argValue.string_value_array(TcUtility.queryArgStringUnion(arg.structure[0].args[1], argValue.string_value_array()));
    }
    else if( arg.structure[0].args[0].val.equalsIgnoreCase("109"))
    {
      argValue.typedRef_value_array(TcUtility.queryArgStringUnion(arg.structure[0].args[1], argValue.typedRef_value_array()));
    }
    else if( arg.structure[0].args[0].val.equalsIgnoreCase("110"))
    {
      argValue.untypedRef_value_array(TcUtility.queryArgStringUnion(arg.structure[0].args[1], argValue.untypedRef_value_array()));
    }
    else if( arg.structure[0].args[0].val.equalsIgnoreCase("111"))
    {
      argValue.externalRef_value_array(TcUtility.queryArgStringUnion(arg.structure[0].args[1], argValue.externalRef_value_array()));
    }
    else if( arg.structure[0].args[0].val.equalsIgnoreCase("112"))
    {
      argValue.note_value_array(TcUtility.queryArgStringUnion(arg.structure[0].args[1], argValue.note_value_array()));
    }
    else if( arg.structure[0].args[0].val.equalsIgnoreCase("113"))
    {
      argValue.typedRelation_value_array(TcUtility.queryArgStringUnion(arg.structure[0].args[1], argValue.typedRelation_value_array()));
    }
    else if( arg.structure[0].args[0].val.equalsIgnoreCase("114"))
    {
      argValue.untypedRelation_value_array(TcUtility.queryArgStringUnion(arg.structure[0].args[1], argValue.untypedRelation_value_array()));
    }
    return argValue;
  }

  public static propertyData_u[] queryEntry(Entry arg, propertyData_u[] argValue) {
    if(arg.array == null || arg.array.length == 0 || arg.array[0] == null) return null;
    if(arg.array[0].entries == null) return null;
    argValue = new propertyData_u[arg.array[0].entries.length];
    for(int ii=0; ii<arg.array[0].entries.length; ii++)
    {
      argValue[ii] = (propertyData_u)TcUtility.queryEntry(arg.array[0].entries[ii], argValue[ii]);
    }
    return argValue;
  }

  public static boolean[] queryEntry(Entry arg, boolean[] argValue) {
    if(arg.array == null || arg.array.length == 0 || arg.array[0] == null) return null;
    if(arg.array[0].entries == null) return null;
    argValue = new boolean[arg.array[0].entries.length];
    for(int ii=0; ii<arg.array[0].entries.length; ii++)
    {
      argValue[ii] = (boolean)TcUtility.queryEntry(arg.array[0].entries[ii], argValue[ii]);
    }
    return argValue;
  }

  public static errorInfoValue_u[] queryEntry(Entry arg, errorInfoValue_u[] argValue) {
    if(arg.array == null || arg.array.length == 0 || arg.array[0] == null) return null;
    if(arg.array[0].entries == null) return null;
    argValue = new errorInfoValue_u[arg.array[0].entries.length];
    for(int ii=0; ii<arg.array[0].entries.length; ii++)
    {
      argValue[ii] = (errorInfoValue_u)TcUtility.queryEntry(arg.array[0].entries[ii], argValue[ii]);
    }
    return argValue;
  }

  public static Entry createEntry(String[] argValue) {
    Entry arg = new Entry();
    arg.array = new Array[1];
    arg.array[0] = new Array();
    arg.array[0].entries = new Entry[argValue.length];
    for(int ii=0; ii<argValue.length; ii++)
    {
      arg.array[0].entries[ii] = TcUtility.createEntry(argValue[ii]);
    }
    return arg;
  }

  public static Entry createEntry(propertyData_u[] argValue) {
    Entry arg = new Entry();
    arg.array = new Array[1];
    arg.array[0] = new Array();
    arg.array[0].entries = new Entry[argValue.length];
    for(int ii=0; ii<argValue.length; ii++)
    {
      arg.array[0].entries[ii] = TcUtility.createEntry(argValue[ii]);
    }
    return arg;
  }

  public static Arg createArg(propertyData_u argValue) {
    Arg arg = new Arg();
    String discValue = Integer.toString(argValue.discriminator());
    arg.structure = new Structure[1];
    arg.structure[0] = new Structure();
    arg.structure[0].args = new Arg[2];
    arg.structure[0].args[0]= new Arg();
    arg.structure[0].args[0].val=discValue;
    
//process union members
    if(discValue.equalsIgnoreCase("1"))
    {
      arg.structure[0].args[1] = TcUtility.createArg(argValue.char_value());
    }
    if(discValue.equalsIgnoreCase("8"))
    {
      arg.structure[0].args[1] = TcUtility.createArgStringUnion(argValue.string_value());
    }
    if(discValue.equalsIgnoreCase("7"))
    {
      arg.structure[0].args[1] = TcUtility.createArg(argValue.short_value());
    }
    if(discValue.equalsIgnoreCase("6"))
    {
      arg.structure[0].args[1] = TcUtility.createArg(argValue.boolean_value());
    }
    if(discValue.equalsIgnoreCase("4"))
    {
      arg.structure[0].args[1] = TcUtility.createArg(argValue.float_value());
    }
    if(discValue.equalsIgnoreCase("3"))
    {
      arg.structure[0].args[1] = TcUtility.createArg(argValue.double_value());
    }
    if(discValue.equalsIgnoreCase("5"))
    {
      arg.structure[0].args[1] = TcUtility.createArg(argValue.long_value());
    }
    if(discValue.equalsIgnoreCase("2"))
    {
      arg.structure[0].args[1] = TcUtility.createArgStringUnion(argValue.date_value());
    }
    if(discValue.equalsIgnoreCase("9"))
    {
      arg.structure[0].args[1] = TcUtility.createArgStringUnion(argValue.typedRef_value());
    }
    if(discValue.equalsIgnoreCase("10"))
    {
      arg.structure[0].args[1] = TcUtility.createArgStringUnion(argValue.untypedRef_value());
    }
    if(discValue.equalsIgnoreCase("11"))
    {
      arg.structure[0].args[1] = TcUtility.createArgStringUnion(argValue.externalRef_value());
    }
    if(discValue.equalsIgnoreCase("12"))
    {
      arg.structure[0].args[1] = TcUtility.createArgStringUnion(argValue.note_value());
    }
    if(discValue.equalsIgnoreCase("13"))
    {
      arg.structure[0].args[1] = TcUtility.createArgStringUnion(argValue.typedRelation_value());
    }
    if(discValue.equalsIgnoreCase("14"))
    {
      arg.structure[0].args[1] = TcUtility.createArgStringUnion(argValue.untypedRelation_value());
    }
    if(discValue.equalsIgnoreCase("101"))
    {
      arg.structure[0].args[1] = TcUtility.createArg(argValue.char_value_array());
    }
    if(discValue.equalsIgnoreCase("102"))
    {
      arg.structure[0].args[1] = TcUtility.createArgStringUnion(argValue.date_value_array());
    }
    if(discValue.equalsIgnoreCase("103"))
    {
      arg.structure[0].args[1] = TcUtility.createArg(argValue.double_value_array());
    }
    if(discValue.equalsIgnoreCase("104"))
    {
      arg.structure[0].args[1] = TcUtility.createArg(argValue.float_value_array());
    }
    if(discValue.equalsIgnoreCase("105"))
    {
      arg.structure[0].args[1] = TcUtility.createArg(argValue.long_value_array());
    }
    if(discValue.equalsIgnoreCase("106"))
    {
      arg.structure[0].args[1] = TcUtility.createArg(argValue.boolean_value_array());
    }
    if(discValue.equalsIgnoreCase("107"))
    {
      arg.structure[0].args[1] = TcUtility.createArg(argValue.short_value_array());
    }
    if(discValue.equalsIgnoreCase("108"))
    {
      arg.structure[0].args[1] = TcUtility.createArgStringUnion(argValue.string_value_array());
    }
    if(discValue.equalsIgnoreCase("109"))
    {
      arg.structure[0].args[1] = TcUtility.createArgStringUnion(argValue.typedRef_value_array());
    }
    if(discValue.equalsIgnoreCase("110"))
    {
      arg.structure[0].args[1] = TcUtility.createArgStringUnion(argValue.untypedRef_value_array());
    }
    if(discValue.equalsIgnoreCase("111"))
    {
      arg.structure[0].args[1] = TcUtility.createArgStringUnion(argValue.externalRef_value_array());
    }
    if(discValue.equalsIgnoreCase("112"))
    {
      arg.structure[0].args[1] = TcUtility.createArgStringUnion(argValue.note_value_array());
    }
    if(discValue.equalsIgnoreCase("113"))
    {
      arg.structure[0].args[1] = TcUtility.createArgStringUnion(argValue.typedRelation_value_array());
    }
    if(discValue.equalsIgnoreCase("114"))
    {
      arg.structure[0].args[1] = TcUtility.createArgStringUnion(argValue.untypedRelation_value_array());
    }
    return arg;
  }

  public static errorInfoSeqValue_u queryArg(Arg arg, errorInfoSeqValue_u argValue) {
    if ( argValue == null )  argValue = new errorInfoSeqValue_u();
    argValue.__default();
    if( arg.structure == null || arg.structure[0] == null) return null;
    if( arg.structure[0].args == null ) return argValue;
    String dicVal = "0";
    if(argValue.discriminator()) dicVal = "1";
    if( arg.structure[0].args[0].val.equals(dicVal))
    {
      return argValue;
    }
    if( arg.structure[0].args[0].val.equalsIgnoreCase("TRUE"))
    {
      argValue.seqValue(TcUtility.queryArg(arg.structure[0].args[1], argValue.seqValue()));
    }
    else
    {
      argValue.seqValue( new errorInfo_s[0]);
    }
    return argValue;
  }

  public static booleanSeqValue_u queryArg(Arg arg, booleanSeqValue_u argValue) {
    if ( argValue == null )  argValue = new booleanSeqValue_u();
    argValue.__default();
    if( arg.structure == null || arg.structure[0] == null) return null;
    if( arg.structure[0].args == null ) return argValue;
    String dicVal = "0";
    if(argValue.discriminator()) dicVal = "1";
    if( arg.structure[0].args[0].val.equals(dicVal))
    {
      return argValue;
    }
    if( arg.structure[0].args[0].val.equalsIgnoreCase("TRUE"))
    {
      argValue.seqValue(TcUtility.queryArg(arg.structure[0].args[1], argValue.seqValue()));
    }
    else
    {
      argValue.seqValue( new boolean[0]);
    }
    return argValue;
  }

  public static bmfExtensionDescDetail_s queryArg(Arg arg, bmfExtensionDescDetail_s argValue) {
    if ( argValue == null )  argValue = new bmfExtensionDescDetail_s();
    if(arg.structure == null || arg.structure[0] == null) return null;
    if(arg.structure[0].args==null) return null;
    for(int ii=0; ii<arg.structure[0].args.length; ii++)
    {
      argValue.extntag = TcUtility.queryArgStringUnion(arg.structure[0].args[0], argValue.extntag);
      argValue.params = TcUtility.queryArg(arg.structure[0].args[1], argValue.params);
      argValue.condition = TcUtility.queryArgStringUnion(arg.structure[0].args[2], argValue.condition);
      argValue.parentClasstag = TcUtility.queryArgStringUnion(arg.structure[0].args[3], argValue.parentClasstag);
      argValue.priority = TcUtility.queryArg(arg.structure[0].args[4], argValue.priority);
      argValue.desctag = TcUtility.queryArgStringUnion(arg.structure[0].args[5], argValue.desctag);
    }
    return argValue;
  }

  public static Arg createArg(bmfExtensionDescDetail_s argValue) {
    Arg arg = new Arg();
    arg.structure = new Structure[1];
    arg.structure[0] = new Structure();
    arg.structure[0].args = new Arg[6];
    arg.structure[0].args[0] = TcUtility.createArgStringUnion(argValue.extntag);
    arg.structure[0].args[1] = TcUtility.createArg(argValue.params);
    arg.structure[0].args[2] = TcUtility.createArgStringUnion(argValue.condition);
    arg.structure[0].args[3] = TcUtility.createArgStringUnion(argValue.parentClasstag);
    arg.structure[0].args[4] = TcUtility.createArg(argValue.priority);
    arg.structure[0].args[5] = TcUtility.createArgStringUnion(argValue.desctag);
    return arg;
  }

  public static NoteChangeInfo_s queryArg(Arg arg, NoteChangeInfo_s argValue) {
    if ( argValue == null )  argValue = new NoteChangeInfo_s();
    if(arg.structure == null || arg.structure[0] == null) return null;
    if(arg.structure[0].args==null) return null;
    for(int ii=0; ii<arg.structure[0].args.length; ii++)
    {
      argValue.noteChangeObj = TcUtility.queryArg(arg.structure[0].args[0], argValue.noteChangeObj);
      argValue.noteChangeTypeObj = TcUtility.queryArg(arg.structure[0].args[1], argValue.noteChangeTypeObj);
      argValue.ecRevStr = TcUtility.queryArg(arg.structure[0].args[2], argValue.ecRevStr);
      argValue.ecTypeStr = TcUtility.queryArg(arg.structure[0].args[3], argValue.ecTypeStr);
      argValue.affRevStr = TcUtility.queryArg(arg.structure[0].args[4], argValue.affRevStr);
      argValue.probRevStr = TcUtility.queryArg(arg.structure[0].args[5], argValue.probRevStr);
      argValue.noteTypeNames = TcUtility.queryArg(arg.structure[0].args[6], argValue.noteTypeNames);
      argValue.beforeValues = TcUtility.queryArg(arg.structure[0].args[7], argValue.beforeValues);
      argValue.afterValues = TcUtility.queryArg(arg.structure[0].args[8], argValue.afterValues);
      argValue.formFldNames = TcUtility.queryArg(arg.structure[0].args[9], argValue.formFldNames);
      argValue.formFldValues = TcUtility.queryArg(arg.structure[0].args[10], argValue.formFldValues);
    }
    return argValue;
  }

  public static VariantChangeInfo_s queryArg(Arg arg, VariantChangeInfo_s argValue) {
    if ( argValue == null )  argValue = new VariantChangeInfo_s();
    if(arg.structure == null || arg.structure[0] == null) return null;
    if(arg.structure[0].args==null) return null;
    for(int ii=0; ii<arg.structure[0].args.length; ii++)
    {
      argValue.variantChangeObj = TcUtility.queryArg(arg.structure[0].args[0], argValue.variantChangeObj);
      argValue.variantChangeTypeObj = TcUtility.queryArg(arg.structure[0].args[1], argValue.variantChangeTypeObj);
      argValue.ecRevStr = TcUtility.queryArg(arg.structure[0].args[2], argValue.ecRevStr);
      argValue.ecTypeStr = TcUtility.queryArg(arg.structure[0].args[3], argValue.ecTypeStr);
      argValue.affRevStr = TcUtility.queryArg(arg.structure[0].args[4], argValue.affRevStr);
      argValue.probRevStr = TcUtility.queryArg(arg.structure[0].args[5], argValue.probRevStr);
      argValue.beforeValue = TcUtility.queryArg(arg.structure[0].args[6], argValue.beforeValue);
      argValue.afterValue = TcUtility.queryArg(arg.structure[0].args[7], argValue.afterValue);
      argValue.formFldNames = TcUtility.queryArg(arg.structure[0].args[8], argValue.formFldNames);
      argValue.formFldValues = TcUtility.queryArg(arg.structure[0].args[9], argValue.formFldValues);
    }
    return argValue;
  }

  public static Entry createEntryStringUnion(String[] argValue) {
    Entry arg = new Entry();
    arg.array = new Array[1];
    arg.array[0] = new Array();
    arg.array[0].entries = new Entry[argValue.length];
    for(int ii=0; ii<argValue.length; ii++)
    {
      arg.array[0].entries[ii] = TcUtility.createEntryStringUnion(argValue[ii]);
    }
    return arg;
  }

  public static Arg createArg(float argValue) {
    Arg arg = new Arg();
    arg.val = Float.toString(argValue);
    return arg;
  }

  public static float queryArg(Arg arg, float argValue) {
    return Float.parseFloat(arg.val);
  }

  public static String[] queryEntry(Entry arg, String[] argValue) {
    if(arg.array == null || arg.array.length == 0 || arg.array[0] == null) return null;
    if(arg.array[0].entries == null) return null;
    argValue = new String[arg.array[0].entries.length];
    for(int ii=0; ii<arg.array[0].entries.length; ii++)
    {
      argValue[ii] = (String)TcUtility.queryEntry(arg.array[0].entries[ii], argValue[ii]);
    }
    return argValue;
  }

  public static Arg createArg(tagSeqValue_u argValue) {
    Arg arg = new Arg();
    String discValue = Boolean.toString(argValue.discriminator());
    arg.structure = new Structure[1];
    arg.structure[0] = new Structure();
    if(discValue.equalsIgnoreCase("TRUE"))
    {
      arg.structure[0].args = new Arg[2];
    }
    else
    {
      arg.structure[0].args = new Arg[1];
    }
    arg.structure[0].args[0]= new Arg();
    arg.structure[0].args[0].val=discValue;
    
//process union members
    if(discValue.equalsIgnoreCase("TRUE"))
    {
      arg.structure[0].args[1] = TcUtility.createArg(argValue.seqValue());
    }
    return arg;
  }

  public static tagSeqValue_u queryArg(Arg arg, tagSeqValue_u argValue) {
    if ( argValue == null )  argValue = new tagSeqValue_u();
    argValue.__default();
    if( arg.structure == null || arg.structure[0] == null) return null;
    if( arg.structure[0].args == null ) return argValue;
    String dicVal = "0";
    if(argValue.discriminator()) dicVal = "1";
    if( arg.structure[0].args[0].val.equals(dicVal))
    {
      return argValue;
    }
    if( arg.structure[0].args[0].val.equalsIgnoreCase("TRUE"))
    {
      argValue.seqValue(TcUtility.queryArg(arg.structure[0].args[1], argValue.seqValue()));
    }
    else
    {
      argValue.seqValue( new int[0]);
    }
    return argValue;
  }

  public static Entry createEntry(int[] argValue) {
    Entry arg = new Entry();
    arg.array = new Array[1];
    arg.array[0] = new Array();
    arg.array[0].entries = new Entry[argValue.length];
    for(int ii=0; ii<argValue.length; ii++)
    {
      arg.array[0].entries[ii] = TcUtility.createEntry(argValue[ii]);
    }
    return arg;
  }

  public static int[] queryEntry(Entry arg, int[] argValue) {
    if(arg.array == null || arg.array.length == 0 || arg.array[0] == null) return null;
    if(arg.array[0].entries == null) return null;
    argValue = new int[arg.array[0].entries.length];
    for(int ii=0; ii<arg.array[0].entries.length; ii++)
    {
      argValue[ii] = (int)TcUtility.queryEntry(arg.array[0].entries[ii], argValue[ii]);
    }
    return argValue;
  }

  public static Arg createArg(booleanSeqValue_u argValue) {
    Arg arg = new Arg();
    String discValue = Boolean.toString(argValue.discriminator());
    arg.structure = new Structure[1];
    arg.structure[0] = new Structure();
    if(discValue.equalsIgnoreCase("TRUE"))
    {
      arg.structure[0].args = new Arg[2];
    }
    else
    {
      arg.structure[0].args = new Arg[1];
    }
    arg.structure[0].args[0]= new Arg();
    arg.structure[0].args[0].val=discValue;
    
//process union members
    if(discValue.equalsIgnoreCase("TRUE"))
    {
      arg.structure[0].args[1] = TcUtility.createArg(argValue.seqValue());
    }
    return arg;
  }

  public static Entry createEntry(boolean[] argValue) {
    Entry arg = new Entry();
    arg.array = new Array[1];
    arg.array[0] = new Array();
    arg.array[0].entries = new Entry[argValue.length];
    for(int ii=0; ii<argValue.length; ii++)
    {
      arg.array[0].entries[ii] = TcUtility.createEntry(argValue[ii]);
    }
    return arg;
  }

  public static Arg createArg(propertyDescriptor_s argValue) {
    Arg arg = new Arg();
    arg.structure = new Structure[1];
    arg.structure[0] = new Structure();
    arg.structure[0].args = new Arg[13];
    arg.structure[0].args[0] = TcUtility.createArg(argValue.propertyName);
    arg.structure[0].args[1] = TcUtility.createArg(argValue.displayName);
    arg.structure[0].args[2] = TcUtility.createArg(argValue.propertyType);
    arg.structure[0].args[3] = TcUtility.createArg(argValue.propertyType2);
    arg.structure[0].args[4] = TcUtility.createArgStringUnion(argValue.lov);
    arg.structure[0].args[5] = TcUtility.createArg(argValue.attachedSpecifier);
    arg.structure[0].args[6] = TcUtility.createArg(argValue.modifiable);
    arg.structure[0].args[7] = TcUtility.createArg(argValue.isDisplayable);
    arg.structure[0].args[8] = TcUtility.createArg(argValue.isEnabled);
    arg.structure[0].args[9] = TcUtility.createArg(argValue.isRequired);
    arg.structure[0].args[10] = TcUtility.createArg(argValue.array);
    arg.structure[0].args[11] = TcUtility.createArg(argValue.maxStringLength);
    arg.structure[0].args[12] = TcUtility.createArg(argValue.interdependentProps);
    return arg;
  }

  public static propertyDescriptor_s queryArg(Arg arg, propertyDescriptor_s argValue) {
    if ( argValue == null )  argValue = new propertyDescriptor_s();
    if(arg.structure == null || arg.structure[0] == null) return null;
    if(arg.structure[0].args==null) return null;
    for(int ii=0; ii<arg.structure[0].args.length; ii++)
    {
      argValue.propertyName = TcUtility.queryArg(arg.structure[0].args[0], argValue.propertyName);
      argValue.displayName = TcUtility.queryArg(arg.structure[0].args[1], argValue.displayName);
      argValue.propertyType = TcUtility.queryArg(arg.structure[0].args[2], argValue.propertyType);
      argValue.propertyType2 = TcUtility.queryArg(arg.structure[0].args[3], argValue.propertyType2);
      argValue.lov = TcUtility.queryArgStringUnion(arg.structure[0].args[4], argValue.lov);
      argValue.attachedSpecifier = TcUtility.queryArg(arg.structure[0].args[5], argValue.attachedSpecifier);
      argValue.modifiable = TcUtility.queryArg(arg.structure[0].args[6], argValue.modifiable);
      argValue.isDisplayable = TcUtility.queryArg(arg.structure[0].args[7], argValue.isDisplayable);
      argValue.isEnabled = TcUtility.queryArg(arg.structure[0].args[8], argValue.isEnabled);
      argValue.isRequired = TcUtility.queryArg(arg.structure[0].args[9], argValue.isRequired);
      argValue.array = TcUtility.queryArg(arg.structure[0].args[10], argValue.array);
      argValue.maxStringLength = TcUtility.queryArg(arg.structure[0].args[11], argValue.maxStringLength);
      argValue.interdependentProps = TcUtility.queryArg(arg.structure[0].args[12], argValue.interdependentProps);
    }
    return argValue;
  }

  public static Arg createArg(lovData_u argValue) {
    Arg arg = new Arg();
    String discValue = Integer.toString(argValue.discriminator());
    arg.structure = new Structure[1];
    arg.structure[0] = new Structure();
    arg.structure[0].args = new Arg[2];
    arg.structure[0].args[0]= new Arg();
    arg.structure[0].args[0].val=discValue;
    
//process union members
    if(discValue.equalsIgnoreCase("1"))
    {
      arg.structure[0].args[1] = TcUtility.createArg(argValue.char_value());
    }
    if(discValue.equalsIgnoreCase("8"))
    {
      arg.structure[0].args[1] = TcUtility.createArg(argValue.string_value());
    }
    if(discValue.equalsIgnoreCase("10"))
    {
      arg.structure[0].args[1] = TcUtility.createArg(argValue.uid_value());
    }
    if(discValue.equalsIgnoreCase("3"))
    {
      arg.structure[0].args[1] = TcUtility.createArg(argValue.double_value());
    }
    if(discValue.equalsIgnoreCase("5"))
    {
      arg.structure[0].args[1] = TcUtility.createArg(argValue.long_value());
    }
    if(discValue.equalsIgnoreCase("2"))
    {
      arg.structure[0].args[1] = TcUtility.createArg(argValue.date_value());
    }
    return arg;
  }

  public static lovData_u queryArg(Arg arg, lovData_u argValue) {
    if ( argValue == null )  argValue = new lovData_u();
    argValue.__default();
    if( arg.structure == null || arg.structure[0] == null) return null;
    if( arg.structure[0].args == null ) return argValue;
    if( arg.structure[0].args[0].val.equals(Integer.toString(argValue.discriminator())))
    {
      return argValue;
    }
    if( arg.structure[0].args[0].val.equalsIgnoreCase("1"))
    {
      argValue.char_value(TcUtility.queryArg(arg.structure[0].args[1], argValue.char_value()));
    }
    else if( arg.structure[0].args[0].val.equalsIgnoreCase("8"))
    {
      argValue.string_value(TcUtility.queryArg(arg.structure[0].args[1], argValue.string_value()));
    }
    else if( arg.structure[0].args[0].val.equalsIgnoreCase("10"))
    {
      argValue.uid_value(TcUtility.queryArg(arg.structure[0].args[1], argValue.uid_value()));
    }
    else if( arg.structure[0].args[0].val.equalsIgnoreCase("3"))
    {
      argValue.double_value(TcUtility.queryArg(arg.structure[0].args[1], argValue.double_value()));
    }
    else if( arg.structure[0].args[0].val.equalsIgnoreCase("5"))
    {
      argValue.long_value(TcUtility.queryArg(arg.structure[0].args[1], argValue.long_value()));
    }
    else if( arg.structure[0].args[0].val.equalsIgnoreCase("2"))
    {
      argValue.date_value(TcUtility.queryArg(arg.structure[0].args[1], argValue.date_value()));
    }
    return argValue;
  }

  public static Arg createArg(aclInfo_s argValue) {
    Arg arg = new Arg();
    arg.structure = new Structure[1];
    arg.structure[0] = new Structure();
    arg.structure[0].args = new Arg[12];
    arg.structure[0].args[0] = TcUtility.createArg(argValue.accessorUid);
    arg.structure[0].args[1] = TcUtility.createArg(argValue.accessorTypeUid);
    arg.structure[0].args[2] = TcUtility.createArg(argValue.aclUid);
    arg.structure[0].args[3] = TcUtility.createArg(argValue.aclTypeUid);
    arg.structure[0].args[4] = TcUtility.createArg(argValue.grantedNull);
    arg.structure[0].args[5] = TcUtility.createArg(argValue.revokedNull);
    arg.structure[0].args[6] = TcUtility.createArg(argValue.grantedPrivileges);
    arg.structure[0].args[7] = TcUtility.createArg(argValue.revokedPrivileges);
    arg.structure[0].args[8] = TcUtility.createArg(argValue.grantedPrivilegeUids);
    arg.structure[0].args[9] = TcUtility.createArg(argValue.grantedTypeUids);
    arg.structure[0].args[10] = TcUtility.createArg(argValue.revokedPrivilegeUids);
    arg.structure[0].args[11] = TcUtility.createArg(argValue.revokedTypeUids);
    return arg;
  }

  public static aclInfo_s queryArg(Arg arg, aclInfo_s argValue) {
    if ( argValue == null )  argValue = new aclInfo_s();
    if(arg.structure == null || arg.structure[0] == null) return null;
    if(arg.structure[0].args==null) return null;
    for(int ii=0; ii<arg.structure[0].args.length; ii++)
    {
      argValue.accessorUid = TcUtility.queryArg(arg.structure[0].args[0], argValue.accessorUid);
      argValue.accessorTypeUid = TcUtility.queryArg(arg.structure[0].args[1], argValue.accessorTypeUid);
      argValue.aclUid = TcUtility.queryArg(arg.structure[0].args[2], argValue.aclUid);
      argValue.aclTypeUid = TcUtility.queryArg(arg.structure[0].args[3], argValue.aclTypeUid);
      argValue.grantedNull = TcUtility.queryArg(arg.structure[0].args[4], argValue.grantedNull);
      argValue.revokedNull = TcUtility.queryArg(arg.structure[0].args[5], argValue.revokedNull);
      argValue.grantedPrivileges = TcUtility.queryArg(arg.structure[0].args[6], argValue.grantedPrivileges);
      argValue.revokedPrivileges = TcUtility.queryArg(arg.structure[0].args[7], argValue.revokedPrivileges);
      argValue.grantedPrivilegeUids = TcUtility.queryArg(arg.structure[0].args[8], argValue.grantedPrivilegeUids);
      argValue.grantedTypeUids = TcUtility.queryArg(arg.structure[0].args[9], argValue.grantedTypeUids);
      argValue.revokedPrivilegeUids = TcUtility.queryArg(arg.structure[0].args[10], argValue.revokedPrivilegeUids);
      argValue.revokedTypeUids = TcUtility.queryArg(arg.structure[0].args[11], argValue.revokedTypeUids);
    }
    return argValue;
  }

  public static deepcopyruleInfo_s[] queryEntry(Entry arg, deepcopyruleInfo_s[] argValue) {
    if(arg.array == null || arg.array.length == 0 || arg.array[0] == null) return null;
    if(arg.array[0].entries == null) return null;
    argValue = new deepcopyruleInfo_s[arg.array[0].entries.length];
    for(int ii=0; ii<arg.array[0].entries.length; ii++)
    {
      argValue[ii] = (deepcopyruleInfo_s)TcUtility.queryEntry(arg.array[0].entries[ii], argValue[ii]);
    }
    return argValue;
  }

  public static Entry createEntry(deepcopyruleInfo_s[] argValue) {
    Entry arg = new Entry();
    arg.array = new Array[1];
    arg.array[0] = new Array();
    arg.array[0].entries = new Entry[argValue.length];
    for(int ii=0; ii<argValue.length; ii++)
    {
      arg.array[0].entries[ii] = TcUtility.createEntry(argValue[ii]);
    }
    return arg;
  }

  public static Arg createArg(deepcopyruleInfo_s argValue) {
    Arg arg = new Arg();
    arg.structure = new Structure[1];
    arg.structure[0] = new Structure();
    arg.structure[0].args = new Arg[3];
    arg.structure[0].args[0] = TcUtility.createArg(argValue.relType);
    arg.structure[0].args[1] = TcUtility.createArg(argValue.attachType);
    arg.structure[0].args[2] = TcUtility.createArg(argValue.isReq);
    return arg;
  }

  public static pieRulesInfo_s queryArg(Arg arg, pieRulesInfo_s argValue) {
    if ( argValue == null )  argValue = new pieRulesInfo_s();
    if(arg.structure == null || arg.structure[0] == null) return null;
    if(arg.structure[0].args==null) return null;
    for(int ii=0; ii<arg.structure[0].args.length; ii++)
    {
      argValue.name = TcUtility.queryArg(arg.structure[0].args[0], argValue.name);
      argValue.desc = TcUtility.queryArgStringUnion(arg.structure[0].args[1], argValue.desc);
      argValue.scope = TcUtility.queryArg(arg.structure[0].args[2], argValue.scope);
      argValue.ruleObj = TcUtility.queryArg(arg.structure[0].args[3], argValue.ruleObj);
      argValue.ruleClauses = TcUtility.queryArg(arg.structure[0].args[4], argValue.ruleClauses);
    }
    return argValue;
  }

  public static pieActionInfo_s queryArg(Arg arg, pieActionInfo_s argValue) {
    if ( argValue == null )  argValue = new pieActionInfo_s();
    if(arg.structure == null || arg.structure[0] == null) return null;
    if(arg.structure[0].args==null) return null;
    for(int ii=0; ii<arg.structure[0].args.length; ii++)
    {
      argValue.name = TcUtility.queryArg(arg.structure[0].args[0], argValue.name);
      argValue.desc = TcUtility.queryArgStringUnion(arg.structure[0].args[1], argValue.desc);
      argValue.scope = TcUtility.queryArg(arg.structure[0].args[2], argValue.scope);
      argValue.location = TcUtility.queryArg(arg.structure[0].args[3], argValue.location);
      argValue.funcName = TcUtility.queryArg(arg.structure[0].args[4], argValue.funcName);
      argValue.actionObj = TcUtility.queryArg(arg.structure[0].args[5], argValue.actionObj);
    }
    return argValue;
  }

  public static pieTransferModeInfo_s queryArg(Arg arg, pieTransferModeInfo_s argValue) {
    if ( argValue == null )  argValue = new pieTransferModeInfo_s();
    if(arg.structure == null || arg.structure[0] == null) return null;
    if(arg.structure[0].args==null) return null;
    for(int ii=0; ii<arg.structure[0].args.length; ii++)
    {
      argValue.name = TcUtility.queryArgStringUnion(arg.structure[0].args[0], argValue.name);
      argValue.desc = TcUtility.queryArgStringUnion(arg.structure[0].args[1], argValue.desc);
      argValue.contextStr = TcUtility.queryArg(arg.structure[0].args[2], argValue.contextStr);
      argValue.closureRuleStr = TcUtility.queryArgStringUnion(arg.structure[0].args[3], argValue.closureRuleStr);
      argValue.filterRuleStr = TcUtility.queryArgStringUnion(arg.structure[0].args[4], argValue.filterRuleStr);
      argValue.propertySetStr = TcUtility.queryArgStringUnion(arg.structure[0].args[5], argValue.propertySetStr);
      argValue.direction = TcUtility.queryArg(arg.structure[0].args[6], argValue.direction);
      argValue.incremental = TcUtility.queryArg(arg.structure[0].args[7], argValue.incremental);
      argValue.tmObj = TcUtility.queryArg(arg.structure[0].args[8], argValue.tmObj);
      argValue.configObjs = TcUtility.queryArg(arg.structure[0].args[9], argValue.configObjs);
      argValue.xsltFileObjs = TcUtility.queryArg(arg.structure[0].args[10], argValue.xsltFileObjs);
      argValue.actionList = TcUtility.queryArg(arg.structure[0].args[11], argValue.actionList);
    }
    return argValue;
  }

  public static doubleSeqValue_u queryArg(Arg arg, doubleSeqValue_u argValue) {
    if ( argValue == null )  argValue = new doubleSeqValue_u();
    argValue.__default();
    if( arg.structure == null || arg.structure[0] == null) return null;
    if( arg.structure[0].args == null ) return argValue;
    String dicVal = "0";
    if(argValue.discriminator()) dicVal = "1";
    if( arg.structure[0].args[0].val.equals(dicVal))
    {
      return argValue;
    }
    if( arg.structure[0].args[0].val.equalsIgnoreCase("TRUE"))
    {
      argValue.seqValue(TcUtility.queryArg(arg.structure[0].args[1], argValue.seqValue()));
    }
    else
    {
      argValue.seqValue( new double[0]);
    }
    return argValue;
  }

  public static preferenceObjectSeqValue_u queryArg(Arg arg, preferenceObjectSeqValue_u argValue) {
    if ( argValue == null )  argValue = new preferenceObjectSeqValue_u();
    argValue.__default();
    if( arg.structure == null || arg.structure[0] == null) return null;
    if( arg.structure[0].args == null ) return argValue;
    String dicVal = "0";
    if(argValue.discriminator()) dicVal = "1";
    if( arg.structure[0].args[0].val.equals(dicVal))
    {
      return argValue;
    }
    if( arg.structure[0].args[0].val.equalsIgnoreCase("TRUE"))
    {
      argValue.seqValue(TcUtility.queryArg(arg.structure[0].args[1], argValue.seqValue()));
    }
    else
    {
      argValue.seqValue( new preferenceObject_s[0]);
    }
    return argValue;
  }

  public static Arg createArg(preferenceObject_s argValue) {
    Arg arg = new Arg();
    arg.structure = new Structure[1];
    arg.structure[0] = new Structure();
    arg.structure[0].args = new Arg[2];
    arg.structure[0].args[0] = TcUtility.createArg(argValue.preferenceDefinition);
    arg.structure[0].args[1] = TcUtility.createArg(argValue.preferenceContexts);
    return arg;
  }

  public static rdvVariantExprXOChartData_s queryArg(Arg arg, rdvVariantExprXOChartData_s argValue) {
    if ( argValue == null )  argValue = new rdvVariantExprXOChartData_s();
    if(arg.structure == null || arg.structure[0] == null) return null;
    if(arg.structure[0].args==null) return null;
    for(int ii=0; ii<arg.structure[0].args.length; ii++)
    {
      argValue.varExpr = TcUtility.queryArgStringUnion(arg.structure[0].args[0], argValue.varExpr);
      argValue.noOfColHeaders = TcUtility.queryArg(arg.structure[0].args[1], argValue.noOfColHeaders);
      argValue.colHeaderExprs = TcUtility.queryArgStringUnion(arg.structure[0].args[2], argValue.colHeaderExprs);
      argValue.colHeaderExprTypes = TcUtility.queryArgStringUnion(arg.structure[0].args[3], argValue.colHeaderExprTypes);
      argValue.noOfRows = TcUtility.queryArg(arg.structure[0].args[4], argValue.noOfRows);
      argValue.noOfCols = TcUtility.queryArg(arg.structure[0].args[5], argValue.noOfCols);
      argValue.noOfTableChars = TcUtility.queryArg(arg.structure[0].args[6], argValue.noOfTableChars);
      argValue.tableChars = TcUtility.queryArgStringUnion(arg.structure[0].args[7], argValue.tableChars);
      argValue.colHeaderExprStrs = TcUtility.queryArg(arg.structure[0].args[8], argValue.colHeaderExprStrs);
    }
    return argValue;
  }

  public static userSessionInfo_s queryArg(Arg arg, userSessionInfo_s argValue) {
    if ( argValue == null )  argValue = new userSessionInfo_s();
    if(arg.structure == null || arg.structure[0] == null) return null;
    if(arg.structure[0].args==null) return null;
    for(int ii=0; ii<arg.structure[0].args.length; ii++)
    {
      argValue.group = TcUtility.queryArg(arg.structure[0].args[0], argValue.group);
      argValue.groupType = TcUtility.queryArg(arg.structure[0].args[1], argValue.groupType);
      argValue.role = TcUtility.queryArg(arg.structure[0].args[2], argValue.role);
      argValue.roleType = TcUtility.queryArg(arg.structure[0].args[3], argValue.roleType);
      argValue.volume = TcUtility.queryArg(arg.structure[0].args[4], argValue.volume);
      argValue.volumeType = TcUtility.queryArg(arg.structure[0].args[5], argValue.volumeType);
      argValue.bypass = TcUtility.queryArg(arg.structure[0].args[6], argValue.bypass);
      argValue.journaling = TcUtility.queryArg(arg.structure[0].args[7], argValue.journaling);
      argValue.appJournaling = TcUtility.queryArg(arg.structure[0].args[8], argValue.appJournaling);
      argValue.secJournaling = TcUtility.queryArg(arg.structure[0].args[9], argValue.secJournaling);
      argValue.admJournaling = TcUtility.queryArg(arg.structure[0].args[10], argValue.admJournaling);
      argValue.priviledged = TcUtility.queryArg(arg.structure[0].args[11], argValue.priviledged);
      argValue.workContext = TcUtility.queryArg(arg.structure[0].args[12], argValue.workContext);
      argValue.workContextType = TcUtility.queryArg(arg.structure[0].args[13], argValue.workContextType);
      argValue.project = TcUtility.queryArg(arg.structure[0].args[14], argValue.project);
      argValue.projectType = TcUtility.queryArg(arg.structure[0].args[15], argValue.projectType);
    }
    return argValue;
  }

  public static propRuleInfoSeqValue_u queryArg(Arg arg, propRuleInfoSeqValue_u argValue) {
    if ( argValue == null )  argValue = new propRuleInfoSeqValue_u();
    argValue.__default();
    if( arg.structure == null || arg.structure[0] == null) return null;
    if( arg.structure[0].args == null ) return argValue;
    String dicVal = "0";
    if(argValue.discriminator()) dicVal = "1";
    if( arg.structure[0].args[0].val.equals(dicVal))
    {
      return argValue;
    }
    if( arg.structure[0].args[0].val.equalsIgnoreCase("TRUE"))
    {
      argValue.proprule_seq_value(TcUtility.queryArg(arg.structure[0].args[1], argValue.proprule_seq_value()));
    }
    else
    {
      argValue.proprule_seq_value( new propRuleInfo_s[0]);
    }
    return argValue;
  }

  public static Arg createArg(propRuleInfo_s argValue) {
    Arg arg = new Arg();
    arg.structure = new Structure[1];
    arg.structure[0] = new Structure();
    arg.structure[0].args = new Arg[8];
    arg.structure[0].args[0] = TcUtility.createArg(argValue.typeName);
    arg.structure[0].args[1] = TcUtility.createArg(argValue.propertyName);
    arg.structure[0].args[2] = TcUtility.createArgStringUnion(argValue.complexProp);
    arg.structure[0].args[3] = TcUtility.createArg(argValue.initialValue);
    arg.structure[0].args[4] = TcUtility.createArg(argValue.modifiable);
    arg.structure[0].args[5] = TcUtility.createArg(argValue.isEnabled);
    arg.structure[0].args[6] = TcUtility.createArg(argValue.isRequired);
    arg.structure[0].args[7] = TcUtility.createArg(argValue.isVisible);
    return arg;
  }

  public static int queryEntry(Entry arg, int argValue) {
    return Integer.parseInt(arg.val);
  }

  public static icsLabel_s queryEntry(Entry arg, icsLabel_s argValue) {
    if ( argValue == null )  argValue = new icsLabel_s();
    if(arg.structure == null || arg.structure[0] == null) return null;
    if(arg.structure[0].args==null) return null;
    for(int ii=0; ii<arg.structure[0].args.length; ii++)
    {
      argValue.type = TcUtility.queryArgStringUnion(arg.structure[0].args[0], argValue.type);
      argValue.subtype = TcUtility.queryArgStringUnion(arg.structure[0].args[1], argValue.subtype);
      argValue.language = TcUtility.queryArgStringUnion(arg.structure[0].args[2], argValue.language);
      argValue.label = TcUtility.queryArgStringUnion(arg.structure[0].args[3], argValue.label);
    }
    return argValue;
  }

  public static Entry createEntry(icsLabel_s argValue) {
    Entry arg = new Entry();
    arg.structure = new Structure[1];
    arg.structure[0] = new Structure();
    arg.structure[0].args = new Arg[4];
    arg.structure[0].args[0] = TcUtility.createArgStringUnion(argValue.type);
    arg.structure[0].args[1] = TcUtility.createArgStringUnion(argValue.subtype);
    arg.structure[0].args[2] = TcUtility.createArgStringUnion(argValue.language);
    arg.structure[0].args[3] = TcUtility.createArgStringUnion(argValue.label);
    return arg;
  }

  public static ExtendedProperty_s queryEntry(Entry arg, ExtendedProperty_s argValue) {
    if ( argValue == null )  argValue = new ExtendedProperty_s();
    if(arg.structure == null || arg.structure[0] == null) return null;
    if(arg.structure[0].args==null) return null;
    for(int ii=0; ii<arg.structure[0].args.length; ii++)
    {
      argValue.propertyName = TcUtility.queryArg(arg.structure[0].args[0], argValue.propertyName);
      argValue.propertyValues = TcUtility.queryArg(arg.structure[0].args[1], argValue.propertyValues);
    }
    return argValue;
  }

  public static Entry createEntry(ExtendedProperty_s argValue) {
    Entry arg = new Entry();
    arg.structure = new Structure[1];
    arg.structure[0] = new Structure();
    arg.structure[0].args = new Arg[2];
    arg.structure[0].args[0] = TcUtility.createArg(argValue.propertyName);
    arg.structure[0].args[1] = TcUtility.createArg(argValue.propertyValues);
    return arg;
  }

  public static String queryEntryStringUnion(Entry arg, String argValue) {
    argValue = null;
    if( arg.structure != null && arg.structure[0] != null && arg.structure[0].args != null  && arg.structure[0].args[0].val.equalsIgnoreCase("TRUE"))
    {
      argValue = arg.structure[0].args[1].val;
    }
    return argValue;
  }

  public static Arg createArg(pftMappingValue_u argValue) {
    Arg arg = new Arg();
    String discValue = Boolean.toString(argValue.discriminator());
    arg.structure = new Structure[1];
    arg.structure[0] = new Structure();
    if(discValue.equalsIgnoreCase("TRUE"))
    {
      arg.structure[0].args = new Arg[2];
    }
    else
    {
      arg.structure[0].args = new Arg[1];
    }
    arg.structure[0].args[0]= new Arg();
    arg.structure[0].args[0].val=discValue;
    
//process union members
    if(discValue.equalsIgnoreCase("TRUE"))
    {
      arg.structure[0].args[1] = TcUtility.createArg(argValue.pftMapping_value());
    }
    return arg;
  }

  public static attrMapping_t[] queryArg(Arg arg, attrMapping_t[] argValue) {
    if(arg.array == null || arg.array.length == 0 || arg.array[0] == null) return null;
    if(arg.array[0].entries == null) return null;
    argValue = new attrMapping_t[arg.array[0].entries.length];
    for(int ii=0; ii<arg.array[0].entries.length; ii++)
    {
      argValue[ii] = (attrMapping_t)TcUtility.queryEntry(arg.array[0].entries[ii], argValue[ii]);
    }
    return argValue;
  }

  public static pftMappingInformation_t[] queryArg(Arg arg, pftMappingInformation_t[] argValue) {
    if(arg.array == null || arg.array.length == 0 || arg.array[0] == null) return null;
    if(arg.array[0].entries == null) return null;
    argValue = new pftMappingInformation_t[arg.array[0].entries.length];
    for(int ii=0; ii<arg.array[0].entries.length; ii++)
    {
      argValue[ii] = (pftMappingInformation_t)TcUtility.queryEntry(arg.array[0].entries[ii], argValue[ii]);
    }
    return argValue;
  }

  public static char queryArg(Arg arg, char argValue) {
    return arg.val.charAt(0);
  }

  public static char[] queryArg(Arg arg, char[] argValue) {
    if(arg.array == null || arg.array.length == 0 || arg.array[0] == null) return null;
    if(arg.array[0].entries == null) return null;
    argValue = new char[arg.array[0].entries.length];
    for(int ii=0; ii<arg.array[0].entries.length; ii++)
    {
      argValue[ii] = (char)TcUtility.queryEntry(arg.array[0].entries[ii], argValue[ii]);
    }
    return argValue;
  }

  public static propertyData_u queryEntry(Entry arg, propertyData_u argValue) {
    if ( argValue == null )  argValue = new propertyData_u();
    argValue.__default();
    if( arg.structure == null || arg.structure[0] == null) return null;
    if( arg.structure[0].args == null ) return argValue;
    if( arg.structure[0].args[0].val.equals(Integer.toString(argValue.discriminator())))
    {
      return argValue;
    }
    if( arg.structure[0].args[0].val.equalsIgnoreCase("1"))
    {
      argValue.char_value(TcUtility.queryArg(arg.structure[0].args[1], argValue.char_value()));
    }
    else if( arg.structure[0].args[0].val.equalsIgnoreCase("8"))
    {
      argValue.string_value(TcUtility.queryArgStringUnion(arg.structure[0].args[1], argValue.string_value()));
    }
    else if( arg.structure[0].args[0].val.equalsIgnoreCase("7"))
    {
      argValue.short_value(TcUtility.queryArg(arg.structure[0].args[1], argValue.short_value()));
    }
    else if( arg.structure[0].args[0].val.equalsIgnoreCase("6"))
    {
      argValue.boolean_value(TcUtility.queryArg(arg.structure[0].args[1], argValue.boolean_value()));
    }
    else if( arg.structure[0].args[0].val.equalsIgnoreCase("4"))
    {
      argValue.float_value(TcUtility.queryArg(arg.structure[0].args[1], argValue.float_value()));
    }
    else if( arg.structure[0].args[0].val.equalsIgnoreCase("3"))
    {
      argValue.double_value(TcUtility.queryArg(arg.structure[0].args[1], argValue.double_value()));
    }
    else if( arg.structure[0].args[0].val.equalsIgnoreCase("5"))
    {
      argValue.long_value(TcUtility.queryArg(arg.structure[0].args[1], argValue.long_value()));
    }
    else if( arg.structure[0].args[0].val.equalsIgnoreCase("2"))
    {
      argValue.date_value(TcUtility.queryArgStringUnion(arg.structure[0].args[1], argValue.date_value()));
    }
    else if( arg.structure[0].args[0].val.equalsIgnoreCase("9"))
    {
      argValue.typedRef_value(TcUtility.queryArgStringUnion(arg.structure[0].args[1], argValue.typedRef_value()));
    }
    else if( arg.structure[0].args[0].val.equalsIgnoreCase("10"))
    {
      argValue.untypedRef_value(TcUtility.queryArgStringUnion(arg.structure[0].args[1], argValue.untypedRef_value()));
    }
    else if( arg.structure[0].args[0].val.equalsIgnoreCase("11"))
    {
      argValue.externalRef_value(TcUtility.queryArgStringUnion(arg.structure[0].args[1], argValue.externalRef_value()));
    }
    else if( arg.structure[0].args[0].val.equalsIgnoreCase("12"))
    {
      argValue.note_value(TcUtility.queryArgStringUnion(arg.structure[0].args[1], argValue.note_value()));
    }
    else if( arg.structure[0].args[0].val.equalsIgnoreCase("13"))
    {
      argValue.typedRelation_value(TcUtility.queryArgStringUnion(arg.structure[0].args[1], argValue.typedRelation_value()));
    }
    else if( arg.structure[0].args[0].val.equalsIgnoreCase("14"))
    {
      argValue.untypedRelation_value(TcUtility.queryArgStringUnion(arg.structure[0].args[1], argValue.untypedRelation_value()));
    }
    else if( arg.structure[0].args[0].val.equalsIgnoreCase("101"))
    {
      argValue.char_value_array(TcUtility.queryArg(arg.structure[0].args[1], argValue.char_value_array()));
    }
    else if( arg.structure[0].args[0].val.equalsIgnoreCase("102"))
    {
      argValue.date_value_array(TcUtility.queryArgStringUnion(arg.structure[0].args[1], argValue.date_value_array()));
    }
    else if( arg.structure[0].args[0].val.equalsIgnoreCase("103"))
    {
      argValue.double_value_array(TcUtility.queryArg(arg.structure[0].args[1], argValue.double_value_array()));
    }
    else if( arg.structure[0].args[0].val.equalsIgnoreCase("104"))
    {
      argValue.float_value_array(TcUtility.queryArg(arg.structure[0].args[1], argValue.float_value_array()));
    }
    else if( arg.structure[0].args[0].val.equalsIgnoreCase("105"))
    {
      argValue.long_value_array(TcUtility.queryArg(arg.structure[0].args[1], argValue.long_value_array()));
    }
    else if( arg.structure[0].args[0].val.equalsIgnoreCase("106"))
    {
      argValue.boolean_value_array(TcUtility.queryArg(arg.structure[0].args[1], argValue.boolean_value_array()));
    }
    else if( arg.structure[0].args[0].val.equalsIgnoreCase("107"))
    {
      argValue.short_value_array(TcUtility.queryArg(arg.structure[0].args[1], argValue.short_value_array()));
    }
    else if( arg.structure[0].args[0].val.equalsIgnoreCase("108"))
    {
      argValue.string_value_array(TcUtility.queryArgStringUnion(arg.structure[0].args[1], argValue.string_value_array()));
    }
    else if( arg.structure[0].args[0].val.equalsIgnoreCase("109"))
    {
      argValue.typedRef_value_array(TcUtility.queryArgStringUnion(arg.structure[0].args[1], argValue.typedRef_value_array()));
    }
    else if( arg.structure[0].args[0].val.equalsIgnoreCase("110"))
    {
      argValue.untypedRef_value_array(TcUtility.queryArgStringUnion(arg.structure[0].args[1], argValue.untypedRef_value_array()));
    }
    else if( arg.structure[0].args[0].val.equalsIgnoreCase("111"))
    {
      argValue.externalRef_value_array(TcUtility.queryArgStringUnion(arg.structure[0].args[1], argValue.externalRef_value_array()));
    }
    else if( arg.structure[0].args[0].val.equalsIgnoreCase("112"))
    {
      argValue.note_value_array(TcUtility.queryArgStringUnion(arg.structure[0].args[1], argValue.note_value_array()));
    }
    else if( arg.structure[0].args[0].val.equalsIgnoreCase("113"))
    {
      argValue.typedRelation_value_array(TcUtility.queryArgStringUnion(arg.structure[0].args[1], argValue.typedRelation_value_array()));
    }
    else if( arg.structure[0].args[0].val.equalsIgnoreCase("114"))
    {
      argValue.untypedRelation_value_array(TcUtility.queryArgStringUnion(arg.structure[0].args[1], argValue.untypedRelation_value_array()));
    }
    return argValue;
  }

  public static errorInfoValue_u queryEntry(Entry arg, errorInfoValue_u argValue) {
    if ( argValue == null )  argValue = new errorInfoValue_u();
    argValue.__default();
    if( arg.structure == null || arg.structure[0] == null) return null;
    if( arg.structure[0].args == null ) return argValue;
    String dicVal = "0";
    if(argValue.discriminator()) dicVal = "1";
    if( arg.structure[0].args[0].val.equals(dicVal))
    {
      return argValue;
    }
    if( arg.structure[0].args[0].val.equalsIgnoreCase("TRUE"))
    {
      argValue.errorvalues(TcUtility.queryArg(arg.structure[0].args[1], argValue.errorvalues()));
    }
    return argValue;
  }

  public static Entry createEntryStringUnion(String argValue) {
    Entry arg = new Entry();
    arg.structure = new Structure[1];
    arg.structure[0] = new Structure();
    if(argValue != null)
    {
      arg.structure[0].args = new Arg[2];
      arg.structure[0].args[0] = new Arg();
      arg.structure[0].args[0].val = "true";
      arg.structure[0].args[1] = new Arg();
      arg.structure[0].args[1].val = argValue;
    }
    else
    {
      arg.structure[0].args = new Arg[1];
      arg.structure[0].args[0] = new Arg();
      arg.structure[0].args[0].val = "false";
    }
    return arg;
  }

  public static Arg createArg(char argValue) {
    Arg arg = new Arg();
    arg.val = Character.toString(argValue);
    return arg;
  }

  public static Arg createArg(char[] argValue) {
    Arg arg = new Arg();
    arg.array = new Array[1];
    arg.array[0] = new Array();
    arg.array[0].entries = new Entry[argValue.length];
    for(int ii=0; ii<argValue.length; ii++)
    {
      arg.array[0].entries[ii] = TcUtility.createEntry(argValue[ii]);
    }
    return arg;
  }

  public static Entry createEntry(propertyData_u argValue) {
    Entry arg = new Entry();
    String discValue = Integer.toString(argValue.discriminator());
    arg.structure = new Structure[1];
    arg.structure[0] = new Structure();
    arg.structure[0].args = new Arg[2];
    arg.structure[0].args[0]= new Arg();
    arg.structure[0].args[0].val=discValue;
    
//process union members
    if(discValue.equalsIgnoreCase("1"))
    {
      arg.structure[0].args[1] = TcUtility.createArg(argValue.char_value());
    }
    if(discValue.equalsIgnoreCase("8"))
    {
      arg.structure[0].args[1] = TcUtility.createArgStringUnion(argValue.string_value());
    }
    if(discValue.equalsIgnoreCase("7"))
    {
      arg.structure[0].args[1] = TcUtility.createArg(argValue.short_value());
    }
    if(discValue.equalsIgnoreCase("6"))
    {
      arg.structure[0].args[1] = TcUtility.createArg(argValue.boolean_value());
    }
    if(discValue.equalsIgnoreCase("4"))
    {
      arg.structure[0].args[1] = TcUtility.createArg(argValue.float_value());
    }
    if(discValue.equalsIgnoreCase("3"))
    {
      arg.structure[0].args[1] = TcUtility.createArg(argValue.double_value());
    }
    if(discValue.equalsIgnoreCase("5"))
    {
      arg.structure[0].args[1] = TcUtility.createArg(argValue.long_value());
    }
    if(discValue.equalsIgnoreCase("2"))
    {
      arg.structure[0].args[1] = TcUtility.createArgStringUnion(argValue.date_value());
    }
    if(discValue.equalsIgnoreCase("9"))
    {
      arg.structure[0].args[1] = TcUtility.createArgStringUnion(argValue.typedRef_value());
    }
    if(discValue.equalsIgnoreCase("10"))
    {
      arg.structure[0].args[1] = TcUtility.createArgStringUnion(argValue.untypedRef_value());
    }
    if(discValue.equalsIgnoreCase("11"))
    {
      arg.structure[0].args[1] = TcUtility.createArgStringUnion(argValue.externalRef_value());
    }
    if(discValue.equalsIgnoreCase("12"))
    {
      arg.structure[0].args[1] = TcUtility.createArgStringUnion(argValue.note_value());
    }
    if(discValue.equalsIgnoreCase("13"))
    {
      arg.structure[0].args[1] = TcUtility.createArgStringUnion(argValue.typedRelation_value());
    }
    if(discValue.equalsIgnoreCase("14"))
    {
      arg.structure[0].args[1] = TcUtility.createArgStringUnion(argValue.untypedRelation_value());
    }
    if(discValue.equalsIgnoreCase("101"))
    {
      arg.structure[0].args[1] = TcUtility.createArg(argValue.char_value_array());
    }
    if(discValue.equalsIgnoreCase("102"))
    {
      arg.structure[0].args[1] = TcUtility.createArgStringUnion(argValue.date_value_array());
    }
    if(discValue.equalsIgnoreCase("103"))
    {
      arg.structure[0].args[1] = TcUtility.createArg(argValue.double_value_array());
    }
    if(discValue.equalsIgnoreCase("104"))
    {
      arg.structure[0].args[1] = TcUtility.createArg(argValue.float_value_array());
    }
    if(discValue.equalsIgnoreCase("105"))
    {
      arg.structure[0].args[1] = TcUtility.createArg(argValue.long_value_array());
    }
    if(discValue.equalsIgnoreCase("106"))
    {
      arg.structure[0].args[1] = TcUtility.createArg(argValue.boolean_value_array());
    }
    if(discValue.equalsIgnoreCase("107"))
    {
      arg.structure[0].args[1] = TcUtility.createArg(argValue.short_value_array());
    }
    if(discValue.equalsIgnoreCase("108"))
    {
      arg.structure[0].args[1] = TcUtility.createArgStringUnion(argValue.string_value_array());
    }
    if(discValue.equalsIgnoreCase("109"))
    {
      arg.structure[0].args[1] = TcUtility.createArgStringUnion(argValue.typedRef_value_array());
    }
    if(discValue.equalsIgnoreCase("110"))
    {
      arg.structure[0].args[1] = TcUtility.createArgStringUnion(argValue.untypedRef_value_array());
    }
    if(discValue.equalsIgnoreCase("111"))
    {
      arg.structure[0].args[1] = TcUtility.createArgStringUnion(argValue.externalRef_value_array());
    }
    if(discValue.equalsIgnoreCase("112"))
    {
      arg.structure[0].args[1] = TcUtility.createArgStringUnion(argValue.note_value_array());
    }
    if(discValue.equalsIgnoreCase("113"))
    {
      arg.structure[0].args[1] = TcUtility.createArgStringUnion(argValue.typedRelation_value_array());
    }
    if(discValue.equalsIgnoreCase("114"))
    {
      arg.structure[0].args[1] = TcUtility.createArgStringUnion(argValue.untypedRelation_value_array());
    }
    return arg;
  }

  public static double queryEntry(Entry arg, double argValue) {
    return Double.parseDouble(arg.val);
  }

  public static Entry createEntry(double argValue) {
    Entry arg = new Entry();
    arg.val = Double.toString(argValue);
    return arg;
  }

  public static float queryEntry(Entry arg, float argValue) {
    return Float.parseFloat(arg.val);
  }

  public static Entry createEntry(float argValue) {
    Entry arg = new Entry();
    arg.val = Float.toString(argValue);
    return arg;
  }

  public static Entry createEntry(boolean argValue) {
    Entry arg = new Entry();
    arg.val = Boolean.toString(argValue);
    return arg;
  }

  public static propertyDescriptor_s queryEntry(Entry arg, propertyDescriptor_s argValue) {
    if ( argValue == null )  argValue = new propertyDescriptor_s();
    if(arg.structure == null || arg.structure[0] == null) return null;
    if(arg.structure[0].args==null) return null;
    for(int ii=0; ii<arg.structure[0].args.length; ii++)
    {
      argValue.propertyName = TcUtility.queryArg(arg.structure[0].args[0], argValue.propertyName);
      argValue.displayName = TcUtility.queryArg(arg.structure[0].args[1], argValue.displayName);
      argValue.propertyType = TcUtility.queryArg(arg.structure[0].args[2], argValue.propertyType);
      argValue.propertyType2 = TcUtility.queryArg(arg.structure[0].args[3], argValue.propertyType2);
      argValue.lov = TcUtility.queryArgStringUnion(arg.structure[0].args[4], argValue.lov);
      argValue.attachedSpecifier = TcUtility.queryArg(arg.structure[0].args[5], argValue.attachedSpecifier);
      argValue.modifiable = TcUtility.queryArg(arg.structure[0].args[6], argValue.modifiable);
      argValue.isDisplayable = TcUtility.queryArg(arg.structure[0].args[7], argValue.isDisplayable);
      argValue.isEnabled = TcUtility.queryArg(arg.structure[0].args[8], argValue.isEnabled);
      argValue.isRequired = TcUtility.queryArg(arg.structure[0].args[9], argValue.isRequired);
      argValue.array = TcUtility.queryArg(arg.structure[0].args[10], argValue.array);
      argValue.maxStringLength = TcUtility.queryArg(arg.structure[0].args[11], argValue.maxStringLength);
      argValue.interdependentProps = TcUtility.queryArg(arg.structure[0].args[12], argValue.interdependentProps);
    }
    return argValue;
  }

  public static availableRelInfo_s queryEntry(Entry arg, availableRelInfo_s argValue) {
    if ( argValue == null )  argValue = new availableRelInfo_s();
    if(arg.structure == null || arg.structure[0] == null) return null;
    if(arg.structure[0].args==null) return null;
    for(int ii=0; ii<arg.structure[0].args.length; ii++)
    {
      argValue.realName = TcUtility.queryArg(arg.structure[0].args[0], argValue.realName);
      argValue.displayName = TcUtility.queryArg(arg.structure[0].args[1], argValue.displayName);
    }
    return argValue;
  }

  public static errorInfo_s[] queryArg(Arg arg, errorInfo_s[] argValue) {
    if(arg.array == null || arg.array.length == 0 || arg.array[0] == null) return null;
    if(arg.array[0].entries == null) return null;
    argValue = new errorInfo_s[arg.array[0].entries.length];
    for(int ii=0; ii<arg.array[0].entries.length; ii++)
    {
      argValue[ii] = (errorInfo_s)TcUtility.queryEntry(arg.array[0].entries[ii], argValue[ii]);
    }
    return argValue;
  }

  public static TypeInfo_s queryEntry(Entry arg, TypeInfo_s argValue) {
    if ( argValue == null )  argValue = new TypeInfo_s();
    if(arg.structure == null || arg.structure[0] == null) return null;
    if(arg.structure[0].args==null) return null;
    for(int ii=0; ii<arg.structure[0].args.length; ii++)
    {
      argValue.typeNames = TcUtility.queryArg(arg.structure[0].args[0], argValue.typeNames);
      argValue.types = TcUtility.queryArg(arg.structure[0].args[1], argValue.types);
      argValue.typeTypes = TcUtility.queryArg(arg.structure[0].args[2], argValue.typeTypes);
    }
    return argValue;
  }

  public static aclInfo_s queryEntry(Entry arg, aclInfo_s argValue) {
    if ( argValue == null )  argValue = new aclInfo_s();
    if(arg.structure == null || arg.structure[0] == null) return null;
    if(arg.structure[0].args==null) return null;
    for(int ii=0; ii<arg.structure[0].args.length; ii++)
    {
      argValue.accessorUid = TcUtility.queryArg(arg.structure[0].args[0], argValue.accessorUid);
      argValue.accessorTypeUid = TcUtility.queryArg(arg.structure[0].args[1], argValue.accessorTypeUid);
      argValue.aclUid = TcUtility.queryArg(arg.structure[0].args[2], argValue.aclUid);
      argValue.aclTypeUid = TcUtility.queryArg(arg.structure[0].args[3], argValue.aclTypeUid);
      argValue.grantedNull = TcUtility.queryArg(arg.structure[0].args[4], argValue.grantedNull);
      argValue.revokedNull = TcUtility.queryArg(arg.structure[0].args[5], argValue.revokedNull);
      argValue.grantedPrivileges = TcUtility.queryArg(arg.structure[0].args[6], argValue.grantedPrivileges);
      argValue.revokedPrivileges = TcUtility.queryArg(arg.structure[0].args[7], argValue.revokedPrivileges);
      argValue.grantedPrivilegeUids = TcUtility.queryArg(arg.structure[0].args[8], argValue.grantedPrivilegeUids);
      argValue.grantedTypeUids = TcUtility.queryArg(arg.structure[0].args[9], argValue.grantedTypeUids);
      argValue.revokedPrivilegeUids = TcUtility.queryArg(arg.structure[0].args[10], argValue.revokedPrivilegeUids);
      argValue.revokedTypeUids = TcUtility.queryArg(arg.structure[0].args[11], argValue.revokedTypeUids);
    }
    return argValue;
  }

  public static EPReport_s queryEntry(Entry arg, EPReport_s argValue) {
    if ( argValue == null )  argValue = new EPReport_s();
    if(arg.structure == null || arg.structure[0] == null) return null;
    if(arg.structure[0].args==null) return null;
    for(int ii=0; ii<arg.structure[0].args.length; ii++)
    {
      argValue.privilege = TcUtility.queryArg(arg.structure[0].args[0], argValue.privilege);
      argValue.verdict = TcUtility.queryArg(arg.structure[0].args[1], argValue.verdict);
      argValue.rules = TcUtility.queryArg(arg.structure[0].args[2], argValue.rules);
      argValue.args = TcUtility.queryArg(arg.structure[0].args[3], argValue.args);
      argValue.acl = TcUtility.queryArg(arg.structure[0].args[4], argValue.acl);
      argValue.accessor = TcUtility.queryArg(arg.structure[0].args[5], argValue.accessor);
    }
    return argValue;
  }

  public static Entry createEntry(DeepCopyInfo_s argValue) {
    Entry arg = new Entry();
    arg.structure = new Structure[1];
    arg.structure[0] = new Structure();
    arg.structure[0].args = new Arg[4];
    arg.structure[0].args[0] = TcUtility.createArgStringUnion(argValue.objectComp);
    arg.structure[0].args[1] = TcUtility.createArgStringUnion(argValue.NoCopyComp);
    arg.structure[0].args[2] = TcUtility.createArgStringUnion(argValue.objName);
    arg.structure[0].args[3] = TcUtility.createArgStringUnion(argValue.relation);
    return arg;
  }

  public static Entry createEntry(resourceListInfo_s argValue) {
    Entry arg = new Entry();
    arg.structure = new Structure[1];
    arg.structure[0] = new Structure();
    arg.structure[0].args = new Arg[11];
    arg.structure[0].args[0] = TcUtility.createArg(argValue.taskTemplate);
    arg.structure[0].args[1] = TcUtility.createArg(argValue.taskTemplateType);
    arg.structure[0].args[2] = TcUtility.createArg(argValue.noOfResources);
    arg.structure[0].args[3] = TcUtility.createArg(argValue.resourceActions);
    arg.structure[0].args[4] = TcUtility.createArgStringUnion(argValue.resourceMembers);
    arg.structure[0].args[5] = TcUtility.createArgStringUnion(argValue.resourceMemberTypes);
    arg.structure[0].args[6] = TcUtility.createArgStringUnion(argValue.resourceProfiles);
    arg.structure[0].args[7] = TcUtility.createArgStringUnion(argValue.resourceProfileTypes);
    arg.structure[0].args[8] = TcUtility.createArg(argValue.revQuorum);
    arg.structure[0].args[9] = TcUtility.createArg(argValue.ackQuorum);
    arg.structure[0].args[10] = TcUtility.createArg(argValue.waitForUndecidedReviewers);
    return arg;
  }

  public static resourceListInfo_s queryEntry(Entry arg, resourceListInfo_s argValue) {
    if ( argValue == null )  argValue = new resourceListInfo_s();
    if(arg.structure == null || arg.structure[0] == null) return null;
    if(arg.structure[0].args==null) return null;
    for(int ii=0; ii<arg.structure[0].args.length; ii++)
    {
      argValue.taskTemplate = TcUtility.queryArg(arg.structure[0].args[0], argValue.taskTemplate);
      argValue.taskTemplateType = TcUtility.queryArg(arg.structure[0].args[1], argValue.taskTemplateType);
      argValue.noOfResources = TcUtility.queryArg(arg.structure[0].args[2], argValue.noOfResources);
      argValue.resourceActions = TcUtility.queryArg(arg.structure[0].args[3], argValue.resourceActions);
      argValue.resourceMembers = TcUtility.queryArgStringUnion(arg.structure[0].args[4], argValue.resourceMembers);
      argValue.resourceMemberTypes = TcUtility.queryArgStringUnion(arg.structure[0].args[5], argValue.resourceMemberTypes);
      argValue.resourceProfiles = TcUtility.queryArgStringUnion(arg.structure[0].args[6], argValue.resourceProfiles);
      argValue.resourceProfileTypes = TcUtility.queryArgStringUnion(arg.structure[0].args[7], argValue.resourceProfileTypes);
      argValue.revQuorum = TcUtility.queryArg(arg.structure[0].args[8], argValue.revQuorum);
      argValue.ackQuorum = TcUtility.queryArg(arg.structure[0].args[9], argValue.ackQuorum);
      argValue.waitForUndecidedReviewers = TcUtility.queryArg(arg.structure[0].args[10], argValue.waitForUndecidedReviewers);
    }
    return argValue;
  }

  public static rdvAuditData_s queryEntry(Entry arg, rdvAuditData_s argValue) {
    if ( argValue == null )  argValue = new rdvAuditData_s();
    if(arg.structure == null || arg.structure[0] == null) return null;
    if(arg.structure[0].args==null) return null;
    for(int ii=0; ii<arg.structure[0].args.length; ii++)
    {
      argValue.bom_line = TcUtility.queryArgStringUnion(arg.structure[0].args[0], argValue.bom_line);
      argValue.bomLineType = TcUtility.queryArgStringUnion(arg.structure[0].args[1], argValue.bomLineType);
      argValue.n_occurrences = TcUtility.queryArg(arg.structure[0].args[2], argValue.n_occurrences);
      argValue.occurrences = TcUtility.queryArgStringUnion(arg.structure[0].args[3], argValue.occurrences);
      argValue.occurrence_types = TcUtility.queryArgStringUnion(arg.structure[0].args[4], argValue.occurrence_types);
      argValue.occmatch_type = TcUtility.queryArg(arg.structure[0].args[5], argValue.occmatch_type);
      argValue.occurrence_match_info = TcUtility.queryArg(arg.structure[0].args[6], argValue.occurrence_match_info);
      argValue.occ_nve_match_desc = TcUtility.queryArgStringUnion(arg.structure[0].args[7], argValue.occ_nve_match_desc);
      argValue.occ_pnum_match_desc = TcUtility.queryArgStringUnion(arg.structure[0].args[8], argValue.occ_pnum_match_desc);
      argValue.occ_qty_match_desc = TcUtility.queryArgStringUnion(arg.structure[0].args[9], argValue.occ_qty_match_desc);
      argValue.overall_match_info = TcUtility.queryArg(arg.structure[0].args[10], argValue.overall_match_info);
      argValue.nve_match_desc = TcUtility.queryArgStringUnion(arg.structure[0].args[11], argValue.nve_match_desc);
      argValue.pnum_match_desc = TcUtility.queryArgStringUnion(arg.structure[0].args[12], argValue.pnum_match_desc);
      argValue.qty_match_desc = TcUtility.queryArgStringUnion(arg.structure[0].args[13], argValue.qty_match_desc);
      argValue.audit_line_summary = TcUtility.queryArgStringUnion(arg.structure[0].args[14], argValue.audit_line_summary);
      argValue.audit_score = TcUtility.queryArgStringUnion(arg.structure[0].args[15], argValue.audit_score);
    }
    return argValue;
  }

  public static Entry createEntry(bmfExtensionDescDetail_s argValue) {
    Entry arg = new Entry();
    arg.structure = new Structure[1];
    arg.structure[0] = new Structure();
    arg.structure[0].args = new Arg[6];
    arg.structure[0].args[0] = TcUtility.createArgStringUnion(argValue.extntag);
    arg.structure[0].args[1] = TcUtility.createArg(argValue.params);
    arg.structure[0].args[2] = TcUtility.createArgStringUnion(argValue.condition);
    arg.structure[0].args[3] = TcUtility.createArgStringUnion(argValue.parentClasstag);
    arg.structure[0].args[4] = TcUtility.createArg(argValue.priority);
    arg.structure[0].args[5] = TcUtility.createArgStringUnion(argValue.desctag);
    return arg;
  }

  public static bmfExtensionDescDetail_s queryEntry(Entry arg, bmfExtensionDescDetail_s argValue) {
    if ( argValue == null )  argValue = new bmfExtensionDescDetail_s();
    if(arg.structure == null || arg.structure[0] == null) return null;
    if(arg.structure[0].args==null) return null;
    for(int ii=0; ii<arg.structure[0].args.length; ii++)
    {
      argValue.extntag = TcUtility.queryArgStringUnion(arg.structure[0].args[0], argValue.extntag);
      argValue.params = TcUtility.queryArg(arg.structure[0].args[1], argValue.params);
      argValue.condition = TcUtility.queryArgStringUnion(arg.structure[0].args[2], argValue.condition);
      argValue.parentClasstag = TcUtility.queryArgStringUnion(arg.structure[0].args[3], argValue.parentClasstag);
      argValue.priority = TcUtility.queryArg(arg.structure[0].args[4], argValue.priority);
      argValue.desctag = TcUtility.queryArgStringUnion(arg.structure[0].args[5], argValue.desctag);
    }
    return argValue;
  }

  public static NoteChangeInfo_s queryEntry(Entry arg, NoteChangeInfo_s argValue) {
    if ( argValue == null )  argValue = new NoteChangeInfo_s();
    if(arg.structure == null || arg.structure[0] == null) return null;
    if(arg.structure[0].args==null) return null;
    for(int ii=0; ii<arg.structure[0].args.length; ii++)
    {
      argValue.noteChangeObj = TcUtility.queryArg(arg.structure[0].args[0], argValue.noteChangeObj);
      argValue.noteChangeTypeObj = TcUtility.queryArg(arg.structure[0].args[1], argValue.noteChangeTypeObj);
      argValue.ecRevStr = TcUtility.queryArg(arg.structure[0].args[2], argValue.ecRevStr);
      argValue.ecTypeStr = TcUtility.queryArg(arg.structure[0].args[3], argValue.ecTypeStr);
      argValue.affRevStr = TcUtility.queryArg(arg.structure[0].args[4], argValue.affRevStr);
      argValue.probRevStr = TcUtility.queryArg(arg.structure[0].args[5], argValue.probRevStr);
      argValue.noteTypeNames = TcUtility.queryArg(arg.structure[0].args[6], argValue.noteTypeNames);
      argValue.beforeValues = TcUtility.queryArg(arg.structure[0].args[7], argValue.beforeValues);
      argValue.afterValues = TcUtility.queryArg(arg.structure[0].args[8], argValue.afterValues);
      argValue.formFldNames = TcUtility.queryArg(arg.structure[0].args[9], argValue.formFldNames);
      argValue.formFldValues = TcUtility.queryArg(arg.structure[0].args[10], argValue.formFldValues);
    }
    return argValue;
  }

  public static VariantChangeInfo_s queryEntry(Entry arg, VariantChangeInfo_s argValue) {
    if ( argValue == null )  argValue = new VariantChangeInfo_s();
    if(arg.structure == null || arg.structure[0] == null) return null;
    if(arg.structure[0].args==null) return null;
    for(int ii=0; ii<arg.structure[0].args.length; ii++)
    {
      argValue.variantChangeObj = TcUtility.queryArg(arg.structure[0].args[0], argValue.variantChangeObj);
      argValue.variantChangeTypeObj = TcUtility.queryArg(arg.structure[0].args[1], argValue.variantChangeTypeObj);
      argValue.ecRevStr = TcUtility.queryArg(arg.structure[0].args[2], argValue.ecRevStr);
      argValue.ecTypeStr = TcUtility.queryArg(arg.structure[0].args[3], argValue.ecTypeStr);
      argValue.affRevStr = TcUtility.queryArg(arg.structure[0].args[4], argValue.affRevStr);
      argValue.probRevStr = TcUtility.queryArg(arg.structure[0].args[5], argValue.probRevStr);
      argValue.beforeValue = TcUtility.queryArg(arg.structure[0].args[6], argValue.beforeValue);
      argValue.afterValue = TcUtility.queryArg(arg.structure[0].args[7], argValue.afterValue);
      argValue.formFldNames = TcUtility.queryArg(arg.structure[0].args[8], argValue.formFldNames);
      argValue.formFldValues = TcUtility.queryArg(arg.structure[0].args[9], argValue.formFldValues);
    }
    return argValue;
  }

  public static cannedMethodInfo_s queryEntry(Entry arg, cannedMethodInfo_s argValue) {
    if ( argValue == null )  argValue = new cannedMethodInfo_s();
    if(arg.structure == null || arg.structure[0] == null) return null;
    if(arg.structure[0].args==null) return null;
    for(int ii=0; ii<arg.structure[0].args.length; ii++)
    {
      argValue.typeName = TcUtility.queryArg(arg.structure[0].args[0], argValue.typeName);
      argValue.msgName = TcUtility.queryArg(arg.structure[0].args[1], argValue.msgName);
      argValue.actionType = TcUtility.queryArg(arg.structure[0].args[2], argValue.actionType);
      argValue.funcName = TcUtility.queryArg(arg.structure[0].args[3], argValue.funcName);
      argValue.method_options = TcUtility.queryArg(arg.structure[0].args[4], argValue.method_options);
      argValue.optionIsMandatory = TcUtility.queryArg(arg.structure[0].args[5], argValue.optionIsMandatory);
      argValue.optionQueryNames = TcUtility.queryArg(arg.structure[0].args[6], argValue.optionQueryNames);
      argValue.queryAttrNames = TcUtility.queryArg(arg.structure[0].args[7], argValue.queryAttrNames);
      argValue.configured = TcUtility.queryArg(arg.structure[0].args[8], argValue.configured);
      argValue.cmUid = TcUtility.queryArg(arg.structure[0].args[9], argValue.cmUid);
      argValue.exec_seq = TcUtility.queryArg(arg.structure[0].args[10], argValue.exec_seq);
      argValue.optionValues = TcUtility.queryArgStringUnion(arg.structure[0].args[11], argValue.optionValues);
    }
    return argValue;
  }

  public static Entry createEntry(propertyDescriptor_s argValue) {
    Entry arg = new Entry();
    arg.structure = new Structure[1];
    arg.structure[0] = new Structure();
    arg.structure[0].args = new Arg[13];
    arg.structure[0].args[0] = TcUtility.createArg(argValue.propertyName);
    arg.structure[0].args[1] = TcUtility.createArg(argValue.displayName);
    arg.structure[0].args[2] = TcUtility.createArg(argValue.propertyType);
    arg.structure[0].args[3] = TcUtility.createArg(argValue.propertyType2);
    arg.structure[0].args[4] = TcUtility.createArgStringUnion(argValue.lov);
    arg.structure[0].args[5] = TcUtility.createArg(argValue.attachedSpecifier);
    arg.structure[0].args[6] = TcUtility.createArg(argValue.modifiable);
    arg.structure[0].args[7] = TcUtility.createArg(argValue.isDisplayable);
    arg.structure[0].args[8] = TcUtility.createArg(argValue.isEnabled);
    arg.structure[0].args[9] = TcUtility.createArg(argValue.isRequired);
    arg.structure[0].args[10] = TcUtility.createArg(argValue.array);
    arg.structure[0].args[11] = TcUtility.createArg(argValue.maxStringLength);
    arg.structure[0].args[12] = TcUtility.createArg(argValue.interdependentProps);
    return arg;
  }

  public static Entry createEntry(lovData_u argValue) {
    Entry arg = new Entry();
    String discValue = Integer.toString(argValue.discriminator());
    arg.structure = new Structure[1];
    arg.structure[0] = new Structure();
    arg.structure[0].args = new Arg[2];
    arg.structure[0].args[0]= new Arg();
    arg.structure[0].args[0].val=discValue;
    
//process union members
    if(discValue.equalsIgnoreCase("1"))
    {
      arg.structure[0].args[1] = TcUtility.createArg(argValue.char_value());
    }
    if(discValue.equalsIgnoreCase("8"))
    {
      arg.structure[0].args[1] = TcUtility.createArg(argValue.string_value());
    }
    if(discValue.equalsIgnoreCase("10"))
    {
      arg.structure[0].args[1] = TcUtility.createArg(argValue.uid_value());
    }
    if(discValue.equalsIgnoreCase("3"))
    {
      arg.structure[0].args[1] = TcUtility.createArg(argValue.double_value());
    }
    if(discValue.equalsIgnoreCase("5"))
    {
      arg.structure[0].args[1] = TcUtility.createArg(argValue.long_value());
    }
    if(discValue.equalsIgnoreCase("2"))
    {
      arg.structure[0].args[1] = TcUtility.createArg(argValue.date_value());
    }
    return arg;
  }

  public static lovData_u queryEntry(Entry arg, lovData_u argValue) {
    if ( argValue == null )  argValue = new lovData_u();
    argValue.__default();
    if( arg.structure == null || arg.structure[0] == null) return null;
    if( arg.structure[0].args == null ) return argValue;
    if( arg.structure[0].args[0].val.equals(Integer.toString(argValue.discriminator())))
    {
      return argValue;
    }
    if( arg.structure[0].args[0].val.equalsIgnoreCase("1"))
    {
      argValue.char_value(TcUtility.queryArg(arg.structure[0].args[1], argValue.char_value()));
    }
    else if( arg.structure[0].args[0].val.equalsIgnoreCase("8"))
    {
      argValue.string_value(TcUtility.queryArg(arg.structure[0].args[1], argValue.string_value()));
    }
    else if( arg.structure[0].args[0].val.equalsIgnoreCase("10"))
    {
      argValue.uid_value(TcUtility.queryArg(arg.structure[0].args[1], argValue.uid_value()));
    }
    else if( arg.structure[0].args[0].val.equalsIgnoreCase("3"))
    {
      argValue.double_value(TcUtility.queryArg(arg.structure[0].args[1], argValue.double_value()));
    }
    else if( arg.structure[0].args[0].val.equalsIgnoreCase("5"))
    {
      argValue.long_value(TcUtility.queryArg(arg.structure[0].args[1], argValue.long_value()));
    }
    else if( arg.structure[0].args[0].val.equalsIgnoreCase("2"))
    {
      argValue.date_value(TcUtility.queryArg(arg.structure[0].args[1], argValue.date_value()));
    }
    return argValue;
  }

  public static Entry createEntry(aclInfo_s argValue) {
    Entry arg = new Entry();
    arg.structure = new Structure[1];
    arg.structure[0] = new Structure();
    arg.structure[0].args = new Arg[12];
    arg.structure[0].args[0] = TcUtility.createArg(argValue.accessorUid);
    arg.structure[0].args[1] = TcUtility.createArg(argValue.accessorTypeUid);
    arg.structure[0].args[2] = TcUtility.createArg(argValue.aclUid);
    arg.structure[0].args[3] = TcUtility.createArg(argValue.aclTypeUid);
    arg.structure[0].args[4] = TcUtility.createArg(argValue.grantedNull);
    arg.structure[0].args[5] = TcUtility.createArg(argValue.revokedNull);
    arg.structure[0].args[6] = TcUtility.createArg(argValue.grantedPrivileges);
    arg.structure[0].args[7] = TcUtility.createArg(argValue.revokedPrivileges);
    arg.structure[0].args[8] = TcUtility.createArg(argValue.grantedPrivilegeUids);
    arg.structure[0].args[9] = TcUtility.createArg(argValue.grantedTypeUids);
    arg.structure[0].args[10] = TcUtility.createArg(argValue.revokedPrivilegeUids);
    arg.structure[0].args[11] = TcUtility.createArg(argValue.revokedTypeUids);
    return arg;
  }

  public static Entry createEntry(cannedMethodInfo_s argValue) {
    Entry arg = new Entry();
    arg.structure = new Structure[1];
    arg.structure[0] = new Structure();
    arg.structure[0].args = new Arg[12];
    arg.structure[0].args[0] = TcUtility.createArg(argValue.typeName);
    arg.structure[0].args[1] = TcUtility.createArg(argValue.msgName);
    arg.structure[0].args[2] = TcUtility.createArg(argValue.actionType);
    arg.structure[0].args[3] = TcUtility.createArg(argValue.funcName);
    arg.structure[0].args[4] = TcUtility.createArg(argValue.method_options);
    arg.structure[0].args[5] = TcUtility.createArg(argValue.optionIsMandatory);
    arg.structure[0].args[6] = TcUtility.createArg(argValue.optionQueryNames);
    arg.structure[0].args[7] = TcUtility.createArg(argValue.queryAttrNames);
    arg.structure[0].args[8] = TcUtility.createArg(argValue.configured);
    arg.structure[0].args[9] = TcUtility.createArg(argValue.cmUid);
    arg.structure[0].args[10] = TcUtility.createArg(argValue.exec_seq);
    arg.structure[0].args[11] = TcUtility.createArgStringUnion(argValue.optionValues);
    return arg;
  }

  public static lovDataInfo_s queryEntry(Entry arg, lovDataInfo_s argValue) {
    if ( argValue == null )  argValue = new lovDataInfo_s();
    if(arg.structure == null || arg.structure[0] == null) return null;
    if(arg.structure[0].args==null) return null;
    for(int ii=0; ii<arg.structure[0].args.length; ii++)
    {
      argValue.lovUid = TcUtility.queryArg(arg.structure[0].args[0], argValue.lovUid);
      argValue.lovTypeUid = TcUtility.queryArg(arg.structure[0].args[1], argValue.lovTypeUid);
      argValue.lovValueType = TcUtility.queryArg(arg.structure[0].args[2], argValue.lovValueType);
      argValue.lovUsage = TcUtility.queryArg(arg.structure[0].args[3], argValue.lovUsage);
      argValue.order = TcUtility.queryArg(arg.structure[0].args[4], argValue.order);
      argValue.partiallyLoaded = TcUtility.queryArg(arg.structure[0].args[5], argValue.partiallyLoaded);
      argValue.isCoordinated = TcUtility.queryArg(arg.structure[0].args[6], argValue.isCoordinated);
      argValue.listCount = TcUtility.queryArg(arg.structure[0].args[7], argValue.listCount);
      argValue.lowerRange = TcUtility.queryArg(arg.structure[0].args[8], argValue.lowerRange);
      argValue.upperRange = TcUtility.queryArg(arg.structure[0].args[9], argValue.upperRange);
      argValue.listOfValues = TcUtility.queryArg(arg.structure[0].args[10], argValue.listOfValues);
      argValue.descValues = TcUtility.queryArg(arg.structure[0].args[11], argValue.descValues);
      argValue.descDisplayValues = TcUtility.queryArg(arg.structure[0].args[12], argValue.descDisplayValues);
      argValue.displayValues = TcUtility.queryArg(arg.structure[0].args[13], argValue.displayValues);
      argValue.columnNames = TcUtility.queryArg(arg.structure[0].args[14], argValue.columnNames);
      argValue.valueClassifications = TcUtility.queryArg(arg.structure[0].args[15], argValue.valueClassifications);
      argValue.classificationNames = TcUtility.queryArg(arg.structure[0].args[16], argValue.classificationNames);
      argValue.typeUids = TcUtility.queryArg(arg.structure[0].args[17], argValue.typeUids);
      argValue.attachedTypes = TcUtility.queryArg(arg.structure[0].args[18], argValue.attachedTypes);
      argValue.attachedProps = TcUtility.queryArg(arg.structure[0].args[19], argValue.attachedProps);
      argValue.attachedSpecifiers = TcUtility.queryArg(arg.structure[0].args[20], argValue.attachedSpecifiers);
      argValue.listOfFiltersIndexes = TcUtility.queryArg(arg.structure[0].args[21], argValue.listOfFiltersIndexes);
      argValue.listOfFilters = TcUtility.queryArg(arg.structure[0].args[22], argValue.listOfFilters);
      argValue.listOfFilterTypes = TcUtility.queryArg(arg.structure[0].args[23], argValue.listOfFilterTypes);
    }
    return argValue;
  }

  public static pieRulesInfo_s queryEntry(Entry arg, pieRulesInfo_s argValue) {
    if ( argValue == null )  argValue = new pieRulesInfo_s();
    if(arg.structure == null || arg.structure[0] == null) return null;
    if(arg.structure[0].args==null) return null;
    for(int ii=0; ii<arg.structure[0].args.length; ii++)
    {
      argValue.name = TcUtility.queryArg(arg.structure[0].args[0], argValue.name);
      argValue.desc = TcUtility.queryArgStringUnion(arg.structure[0].args[1], argValue.desc);
      argValue.scope = TcUtility.queryArg(arg.structure[0].args[2], argValue.scope);
      argValue.ruleObj = TcUtility.queryArg(arg.structure[0].args[3], argValue.ruleObj);
      argValue.ruleClauses = TcUtility.queryArg(arg.structure[0].args[4], argValue.ruleClauses);
    }
    return argValue;
  }

  public static pieActionInfo_s queryEntry(Entry arg, pieActionInfo_s argValue) {
    if ( argValue == null )  argValue = new pieActionInfo_s();
    if(arg.structure == null || arg.structure[0] == null) return null;
    if(arg.structure[0].args==null) return null;
    for(int ii=0; ii<arg.structure[0].args.length; ii++)
    {
      argValue.name = TcUtility.queryArg(arg.structure[0].args[0], argValue.name);
      argValue.desc = TcUtility.queryArgStringUnion(arg.structure[0].args[1], argValue.desc);
      argValue.scope = TcUtility.queryArg(arg.structure[0].args[2], argValue.scope);
      argValue.location = TcUtility.queryArg(arg.structure[0].args[3], argValue.location);
      argValue.funcName = TcUtility.queryArg(arg.structure[0].args[4], argValue.funcName);
      argValue.actionObj = TcUtility.queryArg(arg.structure[0].args[5], argValue.actionObj);
    }
    return argValue;
  }

  public static pieTransferModeInfo_s queryEntry(Entry arg, pieTransferModeInfo_s argValue) {
    if ( argValue == null )  argValue = new pieTransferModeInfo_s();
    if(arg.structure == null || arg.structure[0] == null) return null;
    if(arg.structure[0].args==null) return null;
    for(int ii=0; ii<arg.structure[0].args.length; ii++)
    {
      argValue.name = TcUtility.queryArgStringUnion(arg.structure[0].args[0], argValue.name);
      argValue.desc = TcUtility.queryArgStringUnion(arg.structure[0].args[1], argValue.desc);
      argValue.contextStr = TcUtility.queryArg(arg.structure[0].args[2], argValue.contextStr);
      argValue.closureRuleStr = TcUtility.queryArgStringUnion(arg.structure[0].args[3], argValue.closureRuleStr);
      argValue.filterRuleStr = TcUtility.queryArgStringUnion(arg.structure[0].args[4], argValue.filterRuleStr);
      argValue.propertySetStr = TcUtility.queryArgStringUnion(arg.structure[0].args[5], argValue.propertySetStr);
      argValue.direction = TcUtility.queryArg(arg.structure[0].args[6], argValue.direction);
      argValue.incremental = TcUtility.queryArg(arg.structure[0].args[7], argValue.incremental);
      argValue.tmObj = TcUtility.queryArg(arg.structure[0].args[8], argValue.tmObj);
      argValue.configObjs = TcUtility.queryArg(arg.structure[0].args[9], argValue.configObjs);
      argValue.xsltFileObjs = TcUtility.queryArg(arg.structure[0].args[10], argValue.xsltFileObjs);
      argValue.actionList = TcUtility.queryArg(arg.structure[0].args[11], argValue.actionList);
    }
    return argValue;
  }

  public static preferenceObject_s queryEntry(Entry arg, preferenceObject_s argValue) {
    if ( argValue == null )  argValue = new preferenceObject_s();
    if(arg.structure == null || arg.structure[0] == null) return null;
    if(arg.structure[0].args==null) return null;
    for(int ii=0; ii<arg.structure[0].args.length; ii++)
    {
      argValue.preferenceDefinition = TcUtility.queryArg(arg.structure[0].args[0], argValue.preferenceDefinition);
      argValue.preferenceContexts = TcUtility.queryArg(arg.structure[0].args[1], argValue.preferenceContexts);
    }
    return argValue;
  }

  public static Entry createEntry(preferenceObject_s argValue) {
    Entry arg = new Entry();
    arg.structure = new Structure[1];
    arg.structure[0] = new Structure();
    arg.structure[0].args = new Arg[2];
    arg.structure[0].args[0] = TcUtility.createArg(argValue.preferenceDefinition);
    arg.structure[0].args[1] = TcUtility.createArg(argValue.preferenceContexts);
    return arg;
  }

  public static Arg createArg(preferenceContext_s[] argValue) {
    Arg arg = new Arg();
    arg.array = new Array[1];
    arg.array[0] = new Array();
    arg.array[0].entries = new Entry[argValue.length];
    for(int ii=0; ii<argValue.length; ii++)
    {
      arg.array[0].entries[ii] = TcUtility.createEntry(argValue[ii]);
    }
    return arg;
  }

  public static rdvInstallationAssembliesData_s queryEntry(Entry arg, rdvInstallationAssembliesData_s argValue) {
    if ( argValue == null )  argValue = new rdvInstallationAssembliesData_s();
    if(arg.structure == null || arg.structure[0] == null) return null;
    if(arg.structure[0].args==null) return null;
    for(int ii=0; ii<arg.structure[0].args.length; ii++)
    {
      argValue.inputBOMLine = TcUtility.queryArgStringUnion(arg.structure[0].args[0], argValue.inputBOMLine);
      argValue.inputBOMLineType = TcUtility.queryArgStringUnion(arg.structure[0].args[1], argValue.inputBOMLineType);
      argValue.ia = TcUtility.queryArgStringUnion(arg.structure[0].args[2], argValue.ia);
      argValue.iaType = TcUtility.queryArgStringUnion(arg.structure[0].args[3], argValue.iaType);
    }
    return argValue;
  }

  public static rdvCompositePropObjectInfo_s queryEntry(Entry arg, rdvCompositePropObjectInfo_s argValue) {
    if ( argValue == null )  argValue = new rdvCompositePropObjectInfo_s();
    if(arg.structure == null || arg.structure[0] == null) return null;
    if(arg.structure[0].args==null) return null;
    for(int ii=0; ii<arg.structure[0].args.length; ii++)
    {
      argValue.noOfObjects = TcUtility.queryArg(arg.structure[0].args[0], argValue.noOfObjects);
      argValue.objects = TcUtility.queryArgStringUnion(arg.structure[0].args[1], argValue.objects);
      argValue.objectTypes = TcUtility.queryArgStringUnion(arg.structure[0].args[2], argValue.objectTypes);
    }
    return argValue;
  }

  public static rdvProductItemsData_s queryEntry(Entry arg, rdvProductItemsData_s argValue) {
    if ( argValue == null )  argValue = new rdvProductItemsData_s();
    if(arg.structure == null || arg.structure[0] == null) return null;
    if(arg.structure[0].args==null) return null;
    for(int ii=0; ii<arg.structure[0].args.length; ii++)
    {
      argValue.inputComp = TcUtility.queryArgStringUnion(arg.structure[0].args[0], argValue.inputComp);
      argValue.inputCompType = TcUtility.queryArgStringUnion(arg.structure[0].args[1], argValue.inputCompType);
      argValue.isProdItem = TcUtility.queryArg(arg.structure[0].args[2], argValue.isProdItem);
    }
    return argValue;
  }

  public static rdvGOIOptionData_s queryEntry(Entry arg, rdvGOIOptionData_s argValue) {
    if ( argValue == null )  argValue = new rdvGOIOptionData_s();
    if(arg.structure == null || arg.structure[0] == null) return null;
    if(arg.structure[0].args==null) return null;
    for(int ii=0; ii<arg.structure[0].args.length; ii++)
    {
      argValue.item_tag = TcUtility.queryArgStringUnion(arg.structure[0].args[0], argValue.item_tag);
      argValue.item_type = TcUtility.queryArgStringUnion(arg.structure[0].args[1], argValue.item_type);
      argValue.item_name = TcUtility.queryArgStringUnion(arg.structure[0].args[2], argValue.item_name);
      argValue.option_tag = TcUtility.queryArgStringUnion(arg.structure[0].args[3], argValue.option_tag);
      argValue.option_type = TcUtility.queryArgStringUnion(arg.structure[0].args[4], argValue.option_type);
      argValue.option_name = TcUtility.queryArgStringUnion(arg.structure[0].args[5], argValue.option_name);
      argValue.n_option_values = TcUtility.queryArg(arg.structure[0].args[6], argValue.n_option_values);
      argValue.option_values = TcUtility.queryArg(arg.structure[0].args[7], argValue.option_values);
    }
    return argValue;
  }

  public static Entry createEntry(stringSeqValue_u argValue) {
    Entry arg = new Entry();
    String discValue = Boolean.toString(argValue.discriminator());
    arg.structure = new Structure[1];
    arg.structure[0] = new Structure();
    if(discValue.equalsIgnoreCase("TRUE"))
    {
      arg.structure[0].args = new Arg[2];
    }
    else
    {
      arg.structure[0].args = new Arg[1];
    }
    arg.structure[0].args[0]= new Arg();
    arg.structure[0].args[0].val=discValue;
    
//process union members
    if(discValue.equalsIgnoreCase("TRUE"))
    {
      arg.structure[0].args[1] = TcUtility.createArg(argValue.seqValue());
    }
    return arg;
  }

  public static ListUsers_s queryEntry(Entry arg, ListUsers_s argValue) {
    if ( argValue == null )  argValue = new ListUsers_s();
    if(arg.structure == null || arg.structure[0] == null) return null;
    if(arg.structure[0].args==null) return null;
    for(int ii=0; ii<arg.structure[0].args.length; ii++)
    {
      argValue.userName = TcUtility.queryArg(arg.structure[0].args[0], argValue.userName);
      argValue.personName = TcUtility.queryArg(arg.structure[0].args[1], argValue.personName);
      argValue.nodeName = TcUtility.queryArg(arg.structure[0].args[2], argValue.nodeName);
      argValue.loginDate = TcUtility.queryArg(arg.structure[0].args[3], argValue.loginDate);
    }
    return argValue;
  }

  public static Entry createEntry(writeTicketInfo_s argValue) {
    Entry arg = new Entry();
    arg.structure = new Structure[1];
    arg.structure[0] = new Structure();
    arg.structure[0].args = new Arg[5];
    arg.structure[0].args[0] = TcUtility.createArg(argValue.fileType);
    arg.structure[0].args[1] = TcUtility.createArg(argValue.fileName);
    arg.structure[0].args[2] = TcUtility.createArg(argValue.baseName);
    arg.structure[0].args[3] = TcUtility.createArg(argValue.referenceTypeName);
    arg.structure[0].args[4] = TcUtility.createArg(argValue.extension);
    return arg;
  }

  public static Entry createEntry(commitDatasetFileInfo_s argValue) {
    Entry arg = new Entry();
    arg.structure = new Structure[1];
    arg.structure[0] = new Structure();
    arg.structure[0].args = new Arg[4];
    arg.structure[0].args[0] = TcUtility.createArg(argValue.referenceTypeName);
    arg.structure[0].args[1] = TcUtility.createArg(argValue.fileName);
    arg.structure[0].args[2] = TcUtility.createArg(argValue.replace_allowed);
    arg.structure[0].args[3] = TcUtility.createArg(argValue.ticket_info);
    return arg;
  }

  public static Entry createEntry(transientTicketInfo_s argValue) {
    Entry arg = new Entry();
    arg.structure = new Structure[1];
    arg.structure[0] = new Structure();
    arg.structure[0].args = new Arg[6];
    arg.structure[0].args[0] = TcUtility.createArg(argValue.access_method);
    arg.structure[0].args[1] = TcUtility.createArg(argValue.file_type);
    arg.structure[0].args[2] = TcUtility.createArg(argValue.server_mode);
    arg.structure[0].args[3] = TcUtility.createArg(argValue.deleteSW);
    arg.structure[0].args[4] = TcUtility.createArg(argValue.absolute_file_path);
    arg.structure[0].args[5] = TcUtility.createArg(argValue.url);
    return arg;
  }

  public static Entry createEntry(commitFileInfo_s argValue) {
    Entry arg = new Entry();
    arg.structure = new Structure[1];
    arg.structure[0] = new Structure();
    arg.structure[0].args = new Arg[2];
    arg.structure[0].args[0] = TcUtility.createArg(argValue.fileName);
    arg.structure[0].args[1] = TcUtility.createArg(argValue.ticket_info);
    return arg;
  }

  public static TypeInfoHierarchy_s queryEntry(Entry arg, TypeInfoHierarchy_s argValue) {
    if ( argValue == null )  argValue = new TypeInfoHierarchy_s();
    if(arg.structure == null || arg.structure[0] == null) return null;
    if(arg.structure[0].args==null) return null;
    for(int ii=0; ii<arg.structure[0].args.length; ii++)
    {
      argValue.typeName = TcUtility.queryArgStringUnion(arg.structure[0].args[0], argValue.typeName);
      argValue.type = TcUtility.queryArgStringUnion(arg.structure[0].args[1], argValue.type);
      argValue.typeType = TcUtility.queryArgStringUnion(arg.structure[0].args[2], argValue.typeType);
      argValue.className = TcUtility.queryArgStringUnion(arg.structure[0].args[3], argValue.className);
      argValue.classUid = TcUtility.queryArgStringUnion(arg.structure[0].args[4], argValue.classUid);
      argValue.childrenIndex = TcUtility.queryArg(arg.structure[0].args[5], argValue.childrenIndex);
    }
    return argValue;
  }

  public static propRuleInfo_s[] queryArg(Arg arg, propRuleInfo_s[] argValue) {
    if(arg.array == null || arg.array.length == 0 || arg.array[0] == null) return null;
    if(arg.array[0].entries == null) return null;
    argValue = new propRuleInfo_s[arg.array[0].entries.length];
    for(int ii=0; ii<arg.array[0].entries.length; ii++)
    {
      argValue[ii] = (propRuleInfo_s)TcUtility.queryEntry(arg.array[0].entries[ii], argValue[ii]);
    }
    return argValue;
  }

  public static Arg createArg(pftMapping_t argValue) {
    Arg arg = new Arg();
    arg.structure = new Structure[1];
    arg.structure[0] = new Structure();
    arg.structure[0].args = new Arg[5];
    arg.structure[0].args[0] = TcUtility.createArg(argValue.typeName);
    arg.structure[0].args[1] = TcUtility.createArg(argValue.templateType);
    arg.structure[0].args[2] = TcUtility.createArg(argValue.enabled);
    arg.structure[0].args[3] = TcUtility.createArg(argValue.useForChildren);
    arg.structure[0].args[4] = TcUtility.createArg(argValue.attrMapping);
    return arg;
  }

  public static attrMapping_t queryEntry(Entry arg, attrMapping_t argValue) {
    if ( argValue == null )  argValue = new attrMapping_t();
    if(arg.structure == null || arg.structure[0] == null) return null;
    if(arg.structure[0].args==null) return null;
    for(int ii=0; ii<arg.structure[0].args.length; ii++)
    {
      argValue.attrId = TcUtility.queryArg(arg.structure[0].args[0], argValue.attrId);
      argValue.columnDescriptor = TcUtility.queryArg(arg.structure[0].args[1], argValue.columnDescriptor);
    }
    return argValue;
  }

  public static pftMappingInformation_t queryEntry(Entry arg, pftMappingInformation_t argValue) {
    if ( argValue == null )  argValue = new pftMappingInformation_t();
    if(arg.structure == null || arg.structure[0] == null) return null;
    if(arg.structure[0].args==null) return null;
    for(int ii=0; ii<arg.structure[0].args.length; ii++)
    {
      argValue.isDefault = TcUtility.queryArg(arg.structure[0].args[0], argValue.isDefault);
      argValue.notes = TcUtility.queryArg(arg.structure[0].args[1], argValue.notes);
      argValue.typeName = TcUtility.queryArg(arg.structure[0].args[2], argValue.typeName);
      argValue.itemOrRevIdName = TcUtility.queryArg(arg.structure[0].args[3], argValue.itemOrRevIdName);
    }
    return argValue;
  }

  public static deepcopyruleInfo_s queryEntry(Entry arg, deepcopyruleInfo_s argValue) {
    if ( argValue == null )  argValue = new deepcopyruleInfo_s();
    if(arg.structure == null || arg.structure[0] == null) return null;
    if(arg.structure[0].args==null) return null;
    for(int ii=0; ii<arg.structure[0].args.length; ii++)
    {
      argValue.relType = TcUtility.queryArg(arg.structure[0].args[0], argValue.relType);
      argValue.attachType = TcUtility.queryArg(arg.structure[0].args[1], argValue.attachType);
      argValue.isReq = TcUtility.queryArg(arg.structure[0].args[2], argValue.isReq);
    }
    return argValue;
  }

  public static Entry createEntry(deepcopyruleInfo_s argValue) {
    Entry arg = new Entry();
    arg.structure = new Structure[1];
    arg.structure[0] = new Structure();
    arg.structure[0].args = new Arg[3];
    arg.structure[0].args[0] = TcUtility.createArg(argValue.relType);
    arg.structure[0].args[1] = TcUtility.createArg(argValue.attachType);
    arg.structure[0].args[2] = TcUtility.createArg(argValue.isReq);
    return arg;
  }

  public static preferenceContext_s[] queryArg(Arg arg, preferenceContext_s[] argValue) {
    if(arg.array == null || arg.array.length == 0 || arg.array[0] == null) return null;
    if(arg.array[0].entries == null) return null;
    argValue = new preferenceContext_s[arg.array[0].entries.length];
    for(int ii=0; ii<arg.array[0].entries.length; ii++)
    {
      argValue[ii] = (preferenceContext_s)TcUtility.queryEntry(arg.array[0].entries[ii], argValue[ii]);
    }
    return argValue;
  }

  public static Arg createArg(preferenceDefinition_s argValue) {
    Arg arg = new Arg();
    arg.structure = new Structure[1];
    arg.structure[0] = new Structure();
    arg.structure[0].args = new Arg[7];
    arg.structure[0].args[0] = TcUtility.createArg(argValue.preferenceName);
    arg.structure[0].args[1] = TcUtility.createArg(argValue.preferenceCategory);
    arg.structure[0].args[2] = TcUtility.createArgStringUnion(argValue.preferenceDescription);
    arg.structure[0].args[3] = TcUtility.createArg(argValue.preferenceScope);
    arg.structure[0].args[4] = TcUtility.createArg(argValue.preferenceType);
    arg.structure[0].args[5] = TcUtility.createArg(argValue.isArray);
    arg.structure[0].args[6] = TcUtility.createArg(argValue.isDisabled);
    return arg;
  }

  public static Arg createArg(attrMapping_t[] argValue) {
    Arg arg = new Arg();
    arg.array = new Array[1];
    arg.array[0] = new Array();
    arg.array[0].entries = new Entry[argValue.length];
    for(int ii=0; ii<argValue.length; ii++)
    {
      arg.array[0].entries[ii] = TcUtility.createEntry(argValue[ii]);
    }
    return arg;
  }

  public static pftColumnDescriptor_t queryArg(Arg arg, pftColumnDescriptor_t argValue) {
    if ( argValue == null )  argValue = new pftColumnDescriptor_t();
    if(arg.structure == null || arg.structure[0] == null) return null;
    if(arg.structure[0].args==null) return null;
    for(int ii=0; ii<arg.structure[0].args.length; ii++)
    {
      argValue.name = TcUtility.queryArg(arg.structure[0].args[0], argValue.name);
      argValue.type = TcUtility.queryArg(arg.structure[0].args[1], argValue.type);
    }
    return argValue;
  }

  public static char queryEntry(Entry arg, char argValue) {
    return arg.val.charAt(0);
  }

  public static errorInfo_s queryArg(Arg arg, errorInfo_s argValue) {
    if ( argValue == null )  argValue = new errorInfo_s();
    if(arg.structure == null || arg.structure[0] == null) return null;
    if(arg.structure[0].args==null) return null;
    for(int ii=0; ii<arg.structure[0].args.length; ii++)
    {
      argValue.objUid = TcUtility.queryArg(arg.structure[0].args[0], argValue.objUid);
      argValue.errorSeverities = TcUtility.queryArg(arg.structure[0].args[1], argValue.errorSeverities);
      argValue.errorCodes = TcUtility.queryArg(arg.structure[0].args[2], argValue.errorCodes);
      argValue.errorStrings = TcUtility.queryArg(arg.structure[0].args[3], argValue.errorStrings);
    }
    return argValue;
  }

  public static Entry createEntry(char argValue) {
    Entry arg = new Entry();
    arg.val = Character.toString(argValue);
    return arg;
  }

  public static errorInfo_s queryEntry(Entry arg, errorInfo_s argValue) {
    if ( argValue == null )  argValue = new errorInfo_s();
    if(arg.structure == null || arg.structure[0] == null) return null;
    if(arg.structure[0].args==null) return null;
    for(int ii=0; ii<arg.structure[0].args.length; ii++)
    {
      argValue.objUid = TcUtility.queryArg(arg.structure[0].args[0], argValue.objUid);
      argValue.errorSeverities = TcUtility.queryArg(arg.structure[0].args[1], argValue.errorSeverities);
      argValue.errorCodes = TcUtility.queryArg(arg.structure[0].args[2], argValue.errorCodes);
      argValue.errorStrings = TcUtility.queryArg(arg.structure[0].args[3], argValue.errorStrings);
    }
    return argValue;
  }

  public static stringValueSeqValue_u queryArg(Arg arg, stringValueSeqValue_u argValue) {
    if ( argValue == null )  argValue = new stringValueSeqValue_u();
    argValue.__default();
    if( arg.structure == null || arg.structure[0] == null) return null;
    if( arg.structure[0].args == null ) return argValue;
    String dicVal = "0";
    if(argValue.discriminator()) dicVal = "1";
    if( arg.structure[0].args[0].val.equals(dicVal))
    {
      return argValue;
    }
    if( arg.structure[0].args[0].val.equalsIgnoreCase("TRUE"))
    {
      argValue.seqValue(TcUtility.queryArgStringUnion(arg.structure[0].args[1], argValue.seqValue()));
    }
    else
    {
      argValue.seqValue( new String[0]);
    }
    return argValue;
  }

  public static Arg createArg(stringValueSeqValue_u argValue) {
    Arg arg = new Arg();
    String discValue = Boolean.toString(argValue.discriminator());
    arg.structure = new Structure[1];
    arg.structure[0] = new Structure();
    if(discValue.equalsIgnoreCase("TRUE"))
    {
      arg.structure[0].args = new Arg[2];
    }
    else
    {
      arg.structure[0].args = new Arg[1];
    }
    arg.structure[0].args[0]= new Arg();
    arg.structure[0].args[0].val=discValue;
    
//process union members
    if(discValue.equalsIgnoreCase("TRUE"))
    {
      arg.structure[0].args[1] = TcUtility.createArgStringUnion(argValue.seqValue());
    }
    return arg;
  }

  public static preferenceDefinition_s queryArg(Arg arg, preferenceDefinition_s argValue) {
    if ( argValue == null )  argValue = new preferenceDefinition_s();
    if(arg.structure == null || arg.structure[0] == null) return null;
    if(arg.structure[0].args==null) return null;
    for(int ii=0; ii<arg.structure[0].args.length; ii++)
    {
      argValue.preferenceName = TcUtility.queryArg(arg.structure[0].args[0], argValue.preferenceName);
      argValue.preferenceCategory = TcUtility.queryArg(arg.structure[0].args[1], argValue.preferenceCategory);
      argValue.preferenceDescription = TcUtility.queryArgStringUnion(arg.structure[0].args[2], argValue.preferenceDescription);
      argValue.preferenceScope = TcUtility.queryArg(arg.structure[0].args[3], argValue.preferenceScope);
      argValue.preferenceType = TcUtility.queryArg(arg.structure[0].args[4], argValue.preferenceType);
      argValue.isArray = TcUtility.queryArg(arg.structure[0].args[5], argValue.isArray);
      argValue.isDisabled = TcUtility.queryArg(arg.structure[0].args[6], argValue.isDisabled);
    }
    return argValue;
  }

  public static Entry createEntry(preferenceContext_s argValue) {
    Entry arg = new Entry();
    arg.structure = new Structure[1];
    arg.structure[0] = new Structure();
    arg.structure[0].args = new Arg[2];
    arg.structure[0].args[0] = TcUtility.createArg(argValue.contextName);
    arg.structure[0].args[1] = TcUtility.createArg(argValue.values);
    return arg;
  }

  public static propRuleInfo_s queryEntry(Entry arg, propRuleInfo_s argValue) {
    if ( argValue == null )  argValue = new propRuleInfo_s();
    if(arg.structure == null || arg.structure[0] == null) return null;
    if(arg.structure[0].args==null) return null;
    for(int ii=0; ii<arg.structure[0].args.length; ii++)
    {
      argValue.typeName = TcUtility.queryArg(arg.structure[0].args[0], argValue.typeName);
      argValue.propertyName = TcUtility.queryArg(arg.structure[0].args[1], argValue.propertyName);
      argValue.complexProp = TcUtility.queryArgStringUnion(arg.structure[0].args[2], argValue.complexProp);
      argValue.initialValue = TcUtility.queryArg(arg.structure[0].args[3], argValue.initialValue);
      argValue.modifiable = TcUtility.queryArg(arg.structure[0].args[4], argValue.modifiable);
      argValue.isEnabled = TcUtility.queryArg(arg.structure[0].args[5], argValue.isEnabled);
      argValue.isRequired = TcUtility.queryArg(arg.structure[0].args[6], argValue.isRequired);
      argValue.isVisible = TcUtility.queryArg(arg.structure[0].args[7], argValue.isVisible);
    }
    return argValue;
  }

  public static Entry createEntry(attrMapping_t argValue) {
    Entry arg = new Entry();
    arg.structure = new Structure[1];
    arg.structure[0] = new Structure();
    arg.structure[0].args = new Arg[2];
    arg.structure[0].args[0] = TcUtility.createArg(argValue.attrId);
    arg.structure[0].args[1] = TcUtility.createArg(argValue.columnDescriptor);
    return arg;
  }

  public static preferenceContext_s queryEntry(Entry arg, preferenceContext_s argValue) {
    if ( argValue == null )  argValue = new preferenceContext_s();
    if(arg.structure == null || arg.structure[0] == null) return null;
    if(arg.structure[0].args==null) return null;
    for(int ii=0; ii<arg.structure[0].args.length; ii++)
    {
      argValue.contextName = TcUtility.queryArg(arg.structure[0].args[0], argValue.contextName);
      argValue.values = TcUtility.queryArg(arg.structure[0].args[1], argValue.values);
    }
    return argValue;
  }

  public static Arg createArg(pftColumnDescriptor_t argValue) {
    Arg arg = new Arg();
    arg.structure = new Structure[1];
    arg.structure[0] = new Structure();
    arg.structure[0].args = new Arg[2];
    arg.structure[0].args[0] = TcUtility.createArg(argValue.name);
    arg.structure[0].args[1] = TcUtility.createArg(argValue.type);
    return arg;
  }

}
