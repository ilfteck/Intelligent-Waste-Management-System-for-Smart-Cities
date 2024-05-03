
package com.utils;

import org.apache.commons.lang3.StringUtils;

import com.entity.EIException;

/**
 * SQL filtering
 */
public class SQLFilter {

    /**
     * SQL injection filtering
     * @param str  The character string to be verified
     */
    public static String sqlInject(String str){
        if(StringUtils.isBlank(str)){
            return null;
        }
        //Get rid of '|"|; |\ character
        str = StringUtils.replace(str, "'", "");
        str = StringUtils.replace(str, "\"", "");
        str = StringUtils.replace(str, ";", "");
        str = StringUtils.replace(str, "\\", "");

        //Convert to lower case
        str = str.toLowerCase();

        //Illegal character
        String[] keywords = {"master", "truncate", "insert", "select", "delete", "update", "declare", "alter", "drop"};

        //Determines whether illegal characters are contained
        for(String keyword : keywords){
            if(str.indexOf(keyword) != -1){
                throw new EIException("Contain illegal character");
            }
        }

        return str;
    }
}
