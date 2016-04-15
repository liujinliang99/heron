// Copyright 2016 Twitter. All rights reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//    http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.twitter.heron.api.topology;

import com.twitter.heron.api.Config;
import java.util.HashMap;
import java.util.Map;

public abstract class BaseConfigurationDeclarer<T extends ComponentConfigurationDeclarer> implements ComponentConfigurationDeclarer<T> {
    @Override
    public T addConfiguration(String config, Object value) {
        Map configMap = new HashMap();
        configMap.put(config, value);
        return addConfigurations(configMap);
    }

    @Override
    public T setDebug(boolean debug) {
        return addConfiguration(Config.TOPOLOGY_DEBUG, debug);
    }

    @Override
    public T setMaxSpoutPending(Number val) {
        if(val!=null) val = val.intValue();
        return addConfiguration(Config.TOPOLOGY_MAX_SPOUT_PENDING, val);
    }
}