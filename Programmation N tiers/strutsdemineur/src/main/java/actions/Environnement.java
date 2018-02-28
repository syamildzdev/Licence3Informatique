package actions;

import com.opensymphony.xwork2.ActionSupport;
import modele.GestionDemineur;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

public class Environnement extends ActionSupport implements ApplicationAware, SessionAware {

    protected Map<String, Object> variablesSession;

    protected GestionDemineur demineur;

    @Override // ApplicationAware
    public void setApplication(Map<String, Object> map) {
        if(!map.containsKey("demineur")){
            map.put("domineur",new GestionDemineur());
        }

        demineur = (GestionDemineur) map.get("demineur");
    }

    @Override // SessionAware
    public void setSession(Map<String, Object> map) {
        //variablesSession = map;

    }

    // Getters

    public Map<String, Object> getVariablesSession() {
        return variablesSession;
    }

    public GestionDemineur getDemineur() {
        return demineur;
    }

}
