// @<COPYRIGHT>@
// ==================================================
// Copyright 2014
// Siemens Product Lifecycle Management Software Inc.
// All Rights Reserved.
// ==================================================
// @<COPYRIGHT>@
package com.teamcenter.soaictstubs;

import com.teamcenter.soa.client.model.ErrorStack;
import com.teamcenter.soa.client.model.ServiceData;

public class ICCTException
    extends Exception
    implements java.lang.Cloneable
{
    public int errorCodeCount;

    public int[] errorSeverities;

    public int[] errorCodes;

    public String[] errorStrings;

    public ICCTException()
    {
        super();
    }

    public ICCTException( int errorCodeCount, int[] errorSeverities,
            int[] errorCodes, String[] errorStrings )
    {
        super(errorStrings[0]);
        this.errorCodeCount = errorCodeCount;
        this.errorSeverities = errorSeverities;
        this.errorCodes = errorCodes;
        this.errorStrings = errorStrings;
    }

    public ICCTException( ServiceData serviceData )
    {
        super( serviceData.getPartialError( 0 ).getMessages()[0]);

        errorCodeCount = 0;
        for( int i = 0; i < serviceData.sizeOfPartialErrors(); i++ )
        {
            ErrorStack errorStack = serviceData.getPartialError( i );
            int[] codes = errorStack.getCodes();
            errorCodeCount += codes.length;
        }

        errorSeverities = new int[errorCodeCount];
        errorCodes = new int[errorCodeCount];
        errorStrings = new String[errorCodeCount];
        int k = 0;
        for( int i = 0; i < serviceData.sizeOfPartialErrors(); i++ )
        {
            ErrorStack errorStack = serviceData.getPartialError( i );
            int[] levels = errorStack.getLevels();
            int[] codes = errorStack.getCodes();
            String[] messages = errorStack.getMessages();
            for( int j = 0; j <  messages.length; j++ )
            {
                errorSeverities[k] = levels[j];
                errorCodes[k] = codes[j];
                errorStrings[k] = messages[j];
                k++;
            }
        }
    }

    @Override
    public java.lang.Object clone()
    {
        ICCTException _dest;
        try
        {
            _dest = (ICCTException) super.clone();
            if( errorSeverities != null )
            {
                _dest.errorSeverities = errorSeverities.clone();
            }
            if( errorCodes != null )
            {
                _dest.errorCodes = errorCodes.clone();
            }
            if( errorStrings != null )
            {
                _dest.errorStrings = errorStrings.clone();
            }
        }
        catch( java.lang.CloneNotSupportedException _ex )
        {
            throw new java.lang.Error( _ex.getMessage() );
        }
        return _dest;
    }
}
