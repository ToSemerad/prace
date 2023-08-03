package com.teamcenter.soaictstubs;

/** 
 * ***********************************************************
 * *                                                         *
 * *      THE FOLLOWING SOURCE FILE HAS BEEN AUTOMATICALLY   *
 * *      GENERATED.  ANY HAND CRAFTED CHANGES WILL BE LOST! *
 * *                                                         *
 * ***********************************************************
 * 
 */

public class lovDataInfo_s {
  public String lovUid;

  public String lovTypeUid;

  public int lovValueType;

  public int lovUsage;

  public int order;

  public boolean partiallyLoaded;

  public boolean isCoordinated;

  public int listCount;

  public lovData_u lowerRange;

  public lovData_u upperRange;

  public lovData_u[] listOfValues;

  public stringSeqValue_u descValues;

  public stringSeqValue_u descDisplayValues;

  public stringSeqValue_u displayValues;

  public stringSeqValue_u columnNames;

  public stringSeqValue_u valueClassifications;

  public stringSeqValue_u classificationNames;

  public uidSeqValue_u typeUids;

  public stringSeqValue_u attachedTypes;

  public stringSeqValue_u attachedProps;

  public int[] attachedSpecifiers;

  public int[] listOfFiltersIndexes;

  public uidSeqValue_u listOfFilters;

  public uidSeqValue_u listOfFilterTypes;


  public lovDataInfo_s() {
  }

  public lovDataInfo_s(String lovUid, String lovTypeUid, int lovValueType, int lovUsage, int order, boolean partiallyLoaded, boolean isCoordinated, int listCount, lovData_u lowerRange, lovData_u upperRange, lovData_u[] listOfValues, stringSeqValue_u descValues, stringSeqValue_u descDisplayValues, stringSeqValue_u displayValues, stringSeqValue_u columnNames, stringSeqValue_u valueClassifications, stringSeqValue_u classificationNames, uidSeqValue_u typeUids, stringSeqValue_u attachedTypes, stringSeqValue_u attachedProps, int[] attachedSpecifiers, int[] listOfFiltersIndexes, uidSeqValue_u listOfFilters, uidSeqValue_u listOfFilterTypes) {
    this.lovUid=lovUid;
    this.lovTypeUid=lovTypeUid;
    this.lovValueType=lovValueType;
    this.lovUsage=lovUsage;
    this.order=order;
    this.partiallyLoaded=partiallyLoaded;
    this.isCoordinated=isCoordinated;
    this.listCount=listCount;
    this.lowerRange=lowerRange;
    this.upperRange=upperRange;
    this.listOfValues=listOfValues;
    this.descValues=descValues;
    this.descDisplayValues=descDisplayValues;
    this.displayValues=displayValues;
    this.columnNames=columnNames;
    this.valueClassifications=valueClassifications;
    this.classificationNames=classificationNames;
    this.typeUids=typeUids;
    this.attachedTypes=attachedTypes;
    this.attachedProps=attachedProps;
    this.attachedSpecifiers=attachedSpecifiers;
    this.listOfFiltersIndexes=listOfFiltersIndexes;
    this.listOfFilters=listOfFilters;
    this.listOfFilterTypes=listOfFilterTypes;
  }

}
