package com.example.controller;

/*
 * Copyright 2016 bmcstdio
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rx.functions.Action0;
import rx.functions.Func1;

/**
 * A hook which can be registered with {@link rx.plugins.RxJavaHooks#setOnScheduleAction(Func1)} in
 * order to enable {@link org.slf4j.MDC} propagation.
 */
public final class MdcPropagatingOnScheduleAction implements Func1<Action0, Action0> {
    private static Logger logger = LoggerFactory.getLogger(MdcPropagatingOnScheduleAction.class);

    @Override
    public Action0 call(final Action0 action0) {
        logger.info("MdcPropagatingOnScheduleAction::call " + action0);
        return new MdcPropagatingAction(action0);
    }
}