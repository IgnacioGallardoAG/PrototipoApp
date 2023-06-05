package info;

/**
 *
 * @author altra
 */
public class Info {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            InicioSesionInterfaz inicioSesionInterfaz = new InicioSesionInterfaz();
            inicioSesionInterfaz.setVisible(true);
        });
    }
}
