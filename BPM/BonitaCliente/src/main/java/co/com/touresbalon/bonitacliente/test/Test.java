/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.bonitacliente.test;

import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bonitasoft.engine.api.ApiAccessType;
import org.bonitasoft.engine.api.LoginAPI;
import org.bonitasoft.engine.api.ProcessAPI;
import org.bonitasoft.engine.api.TenantAPIAccessor;
import org.bonitasoft.engine.bpm.process.DesignProcessDefinition;
import org.bonitasoft.engine.bpm.process.ProcessActivationException;
import org.bonitasoft.engine.bpm.process.ProcessDefinition;
import org.bonitasoft.engine.bpm.process.ProcessDefinitionNotFoundException;
import org.bonitasoft.engine.bpm.process.ProcessExecutionException;
import org.bonitasoft.engine.bpm.process.ProcessInstance;
import org.bonitasoft.engine.bpm.process.impl.internal.DesignProcessDefinitionImpl;
import org.bonitasoft.engine.exception.BonitaHomeNotSetException;
import org.bonitasoft.engine.exception.ServerAPIException;
import org.bonitasoft.engine.exception.UnknownAPITypeException;
import org.bonitasoft.engine.platform.LoginException;
import org.bonitasoft.engine.session.APISession;
import org.bonitasoft.engine.util.APITypeManager;

/**
 *
 * @author rchicangana
 */
public class Test {

    public static void main(String[] args) {

        try {
            HashMap<String, String> parameters = new HashMap<>();
            parameters.put("server.url", "http://localhost:8080");
            parameters.put("application.name", "bonita");
            APITypeManager.setAPITypeAndParams(ApiAccessType.HTTP, parameters);
            LoginAPI loginAPI = TenantAPIAccessor.getLoginAPI();
            // log in to the tenant to create a session
            APISession apiSession = loginAPI.login("walter.bates", "123");
            ProcessAPI processAPI = TenantAPIAccessor.getProcessAPI(apiSession);
            ProcessDefinition processDefinition = new DesignProcessDefinitionImpl();
            
            ProcessInstance processInstance = processAPI.startProcess(7508066091791909002L);
            
        } catch (BonitaHomeNotSetException | ServerAPIException | UnknownAPITypeException | LoginException | ProcessDefinitionNotFoundException | ProcessActivationException | ProcessExecutionException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    

}
