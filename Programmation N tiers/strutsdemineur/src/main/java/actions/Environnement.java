package actions;

import com.opensymphony.xwork2.ActionSupport;
import modele.GestionDemineur;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

public class Environnement extends ActionSupport implements ApplicationAware, SessionAware {

    private Map<String, Object> variablesSession;

    private GestionDemineur facade;

    @Override // ApplicationAware
    public void setApplication(Map<String, Object> map) {
        facade = (GestionDemineur) map.get("facade");

        if(facade==null){
            facade = new GestionDemineur();
            map.put("facade", facade);
        }
    }

    @Override // SessionAware
    public void setSession(Map<String, Object> map) {
        //variablesSession = map;

    }

    // Getters

    public Map<String, Object> getVariablesSession() {
        return variablesSession;
    }

    public GestionDemineur getFacade() {
        return facade;
    }

}
