package org.nettoall.orca.messagingjms.receiver;

import org.nettoall.orca.messagingjms.entity.Email;
import org.springframework.jms.annotation.JmsListener;

/**
 * message-driven POJO class - JMS 관련된 어떤 라이브러리도 import 하지 않음
 * @JmsListener(destination=) 만 annotation 정의됨
 */
//@Component
public class JmsReceiver {

    /**
     * JmsListener 를 annotation-driven 으로 정의
     * destination 정의, containerFactory는 설정 없으면 default 찾음
     *
     * Tip: 동일한 메소드에 @JmsListener를 추가함으로써 여러 JMS destination을 연결 가능
     *
     * @param email
     */
    @JmsListener(destination = "mailbox", containerFactory = "myFactory")
    public void receiveMessage(Email email) {
        System.out.println("Received <" + email + ">");
    }
}
