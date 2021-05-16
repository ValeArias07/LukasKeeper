package config;

import services.*;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("api")
public class ApplicationConfig extends Application {

////Registro de servicios
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> recursos = new HashSet<>();
        recursos.add(UserServices.class);
        recursos.add(DashServices.class);
        recursos.add(IncomeServices.class);
        recursos.add(SavingServices.class);
        recursos.add(DebtsServices.class);
        recursos.add(ExpensesServices.class);
        recursos.add(EchoServices.class);
        return super.getClasses();
    }
}
