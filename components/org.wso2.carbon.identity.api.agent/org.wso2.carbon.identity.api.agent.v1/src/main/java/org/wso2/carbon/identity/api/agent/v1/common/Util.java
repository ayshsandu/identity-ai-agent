/*
* Copyright (c) 2025, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package org.wso2.carbon.identity.api.agent.v1.common;

import org.slf4j.MDC;

import java.util.UUID;

/**
* Common util class
*/
public class Util {

   public static final String CORRELATION_ID_MDC = "Correlation-ID";

   /**
    * Get correlation id of current thread
    *
    * @return correlation-id
    */
   public static String getCorrelation() {
       String ref;
       if (isCorrelationIDPresent()) {
           ref = MDC.get(CORRELATION_ID_MDC);
       } else {
           ref = UUID.randomUUID().toString();

       }
       return ref;
   }

   /**
    * Check whether correlation id present in the log MDC
    *
    * @return whether the correlation id is present
    */
   public static boolean isCorrelationIDPresent() {
       return MDC.get(CORRELATION_ID_MDC) != null;
   }  
}
