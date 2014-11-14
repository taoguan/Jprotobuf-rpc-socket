/**
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Baidu company (the "License");
 * you may not use this file except in compliance with the License.
 *
 */
package com.baidu.jprotobuf.pbrpc;

import com.baidu.jprotobuf.pbrpc.ProtobufPRCService;

/**
 * Echo service 
 * 
 * @author xiemalin
 * @since 1.0
 */
public class EchoServiceImpl {

    @ProtobufPRCService(serviceName = "echoService", methodName = "echo")
    public EchoInfo doEcho(EchoInfo info) {
        EchoInfo ret = new EchoInfo();
        ret.setMessage("hello:" + info.getMessage());

        return ret;
    }

    @ProtobufPRCService(serviceName = "echoService", methodName = "echoWithAttachement", 
            attachmentHandler = EchoServerAttachmentHandler.class)
    public EchoInfo dealWithAttachement(EchoInfo info) {
        return doEcho(info);
    }
    
    @ProtobufPRCService(serviceName = "echoService", methodName = "echoGzip", 
            attachmentHandler = EchoServerAttachmentHandler.class)
    public EchoInfo dealWithGzipEnable(EchoInfo info) {
        return doEcho(info);
    }
}
