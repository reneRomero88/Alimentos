package com.mx.jr.cendi.cocina.jsf;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.inject.Named;

import com.mx.jr.cendi.cocina.model.Personal;
import com.mx.jr.cendi.cocina.util.JsfUtil;
import com.mx.jr.cendi.cocina.util.JsfUtil.PersistAction;

@Named
public class PersonalController implements Serializable {

//    @EJB
    @Inject
    private PersonalFacade ejbFacade;
    private List<Personal> items = null;
    private Personal selected;

    public PersonalController() {
    }

    public Personal getSelected() {
        return selected;
    }

    public void setSelected(Personal selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private PersonalFacade getFacade() {
        return ejbFacade;
    }

    public Personal prepareCreate() {
        selected = new Personal();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, //ResourceBundle.getBundle("/Bundle").getString(
                "PersonalCreated"
                //)
                );
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, //ResourceBundle.getBundle("/Bundle").getString(
                "PersonalUpdated"
             //   )
                );
    }

    public void destroy() {
        persist(PersistAction.DELETE, //ResourceBundle.getBundle("/Bundle").getString(
                "PersonalDeleted"
             //   )
                );
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Personal> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
//            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().save(selected);
                } else {
                    getFacade().delete(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
//            } catch (EJBException ex) {
//                String msg = "";
//                Throwable cause = ex.getCause();
//                if (cause != null) {
//                    msg = cause.getLocalizedMessage();
//                }
//                if (msg.length() > 0) {
//                    JsfUtil.addErrorMessage(msg);
//                } else {
//                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
//                }
//            } catch (Exception ex) {
//                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
//                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
//            }
        }
    }

    public List<Personal> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Personal> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Personal.class)
    public static class PersonalControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            PersonalController controller = (PersonalController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "personalController");
            return controller.getFacade().findById(value);
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Personal) {
                Personal o = (Personal) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Personal.class.getName()});
                return null;
            }
        }

    }

}