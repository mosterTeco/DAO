package mx.uv;
import static spark.Spark.*;
import com.google.gson.*;

import java.util.*;

/**
 * Hello world!
 *
 */
public class App 
{
    static Gson gson=new Gson();
    static HashMap<String, Usuario> usuarios=new HashMap<>();
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        port(80);

        get("/usuarios", (request,response)->{
            // return "get";
            // response.type("application/json");
            // return gson.toJson(usuarios);
            return gson.toJson(DAO.dameUsuarios());
        });

        post("/usuarios", (request, response)->{
            response.type("application/json");
            String payload = request.body();
            Usuario usuario = gson.fromJson(payload, Usuario.class);
            System.out.println("payload "+payload);
            String id = UUID.randomUUID().toString();
            usuario.setID(id);
            usuarios.put(id, usuario);
            DAO.crearUsuario(usuario);
            // System.out.println("n "+usuario.getNombre());
            // System.out.println("p "+usuario.getPassword());
            // System.out.println("i "+usuario.getId());

            JsonObject respuesta = new JsonObject();
            respuesta.addProperty("msj", "Se creo el usuario");
            respuesta.addProperty("id", id);
            return gson.toJson(usuario);
        });


    }
}
