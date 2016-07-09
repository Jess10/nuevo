package clases2;

import clases2.util.MobilePageController;
import clases.Factura;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "facturaController")
@ViewScoped
public class FacturaController extends AbstractController<Factura> {

    @Inject
    private MobilePageController mobilePageController;

    public FacturaController() {
        // Inform the Abstract parent controller of the concrete Factura Entity
        super(Factura.class);
    }

    /**
     * Sets the "items" attribute with a collection of Detalle entities that are
     * retrieved from Factura?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Detalle page
     */
    public String navigateDetalleCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Detalle_items", this.getSelected().getDetalleCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/detalle/index";
    }

}
