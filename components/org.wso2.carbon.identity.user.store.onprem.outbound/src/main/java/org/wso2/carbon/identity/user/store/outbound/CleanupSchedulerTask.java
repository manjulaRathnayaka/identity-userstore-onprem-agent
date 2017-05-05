/*
*  Copyright (c) 2017, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
*  WSO2 Inc. licenses this file to you under the Apache License,
*  Version 2.0 (the "License"); you may not use this file except
*  in compliance with the License.
*  You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing,
* software distributed under the License is distributed on an
* "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
* KIND, either express or implied.  See the License for the
* specific language governing permissions and limitations
* under the License.
*/
package org.wso2.carbon.identity.user.store.outbound;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.wso2.carbon.identity.user.store.outbound.util.FileUtil;
import org.wso2.carbon.utils.CarbonUtils;

import java.io.File;
import java.io.IOException;
import java.util.TimerTask;

public class CleanupSchedulerTask extends TimerTask{

    private static Log LOGGER = LogFactory.getLog(CleanupSchedulerTask.class);

    public void run() {
        cleanTmpFolder();
    }

    private void cleanTmpFolder(){
        try {
            LOGGER.info("Cleaning temporary agent files.");
            FileUtils.cleanDirectory(new File(CarbonUtils.getCarbonHome() + FileUtil.AGENT_TEMP_PATH));
        } catch (IOException e) {
            LOGGER.error("Error occurred while cleaning temp directory", e);
        }
    }
}