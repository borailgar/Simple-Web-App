/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saaspass.websocket;

import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author borahan.ilgar
 */
@ServerEndpoint(value = "/websocket/{sessionID}")
public class EndPoint {

    @OnOpen
    public void onOpen(@PathParam("sessionID") final String userName, final Session session) {
            session.getUserProperties().put("sessionID", userName);
            SessionManager.register(userName, session);
	
    }
  
}
