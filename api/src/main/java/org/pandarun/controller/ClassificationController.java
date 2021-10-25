/*
 * Copyright 2021 Panda Run Organization All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific
 * language governing permissions and limitations under the License.
 */
package org.pandarun.controller;

import org.pandarun.service.Classification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: ClassificationController
 * Description: 分类控制层
 * Author: James Zow
 * Date: 2021/10/24
 * Version:
 **/
@RestController
@RequestMapping("/classification")
@CrossOrigin
public class ClassificationController {

    public Logger log = LoggerFactory.getLogger(ClassificationController.class);

    @Autowired
    private Classification classification;

    @PostMapping(value = "/v1/simple")
    public String animalClassification(String imagePath) {
        log.info("请求分类接口Start...");
        log.info("请求图片地址:" + imagePath);
        String result = classification.ImageClassification(imagePath);
        if(result != null){
            return result;
        } else {
            return "请求接口没有数据";
        }
    }
}
