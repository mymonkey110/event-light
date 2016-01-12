package com.haocai.infrastructure.email;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by Michael Jiang on 16/1/12.
 */
@Component
public class EmailSender {
    private static Logger LOG = LoggerFactory.getLogger(EmailSender.class);

    public void send(String name, String content) {
        LOG.info("sending email to {},content:{}.", name, content);
    }
}
