/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saaspass.websocket;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import javax.websocket.Session;

/**
 *
 * @author borahan.ilgar
 */
public class SessionManager {
   	private static final Map<String, Session>  SESSIONS = new HashMap<>();


    public static void publish(String message, final String sessionID) throws IOException {
        assert !Objects.isNull(message) && !Objects.isNull(sessionID);
		
	Session session = SESSIONS.get(sessionID);
        session.getBasicRemote().sendText(message);
    }

    static void register(String sessionID, final Session session) {
	SESSIONS.put(sessionID, session);
	System.out.println(sessionID);
	System.out.println(SESSIONS.size());
    }
}
    	
	
