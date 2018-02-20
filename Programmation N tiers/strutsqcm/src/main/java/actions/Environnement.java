package actions;

import com.opensymphony.xwork2.ActionSupport;
import facade.GestionQCM;
import facade.QCMImpl;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

public class Environnement extends ActionSupport implements ApplicationAware, SessionAware {

    private Map<String, Object> variablesSession;

    private GestionQCM facade;

    @Override // ApplicationAware
    public void setApplication(Map<String, Object> map) {
        facade = (GestionQCM) map.get("facade");
        if(facade == null) {
            facade = new QCMImpl();
            map.put("facade", facade);
        }
        // tout le monde aura le meme facade
    }

    @Override // SessionAware
    public void setSession(Map<String, Object> map) {
        variablesSession = map;

    }

    // Getters

    public Map<String, Object> getVariablesSession() {
        return variablesSession;
    }

    public GestionQCM getFacade() {
        return facade;
    }

}
