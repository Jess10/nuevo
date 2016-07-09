package clases2;

import clases2.util.MobilePageController;
import clases.Detalle;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "detalleController")
@ViewScoped
public class DetalleController extends AbstractController<Detalle> {

    @Inject
    private FacturaController idfController;
    @Inject
    private MobilePageController mobilePageController;

    public DetalleController() {
        // Inform the Abstract parent controller of the concrete Detalle Entity
        super(Detalle.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idfController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Factura controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdf(ActionEvent event) {
        if (this.getSelected() != null && idfController.getSelected() == null) {
            idfController.setSelected(this.getSelected().getIdf());
        }
    }
}
