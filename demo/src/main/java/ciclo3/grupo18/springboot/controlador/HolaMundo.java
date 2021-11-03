Pakage controlador


/**
 * @author USer
 */
@RestController
@RequestMapping("/Saludar")
public class HolaMundo {
    @GetMapping("/hola")
    public String saluda(){
        return "<h1>Hola mundo"
    }
}