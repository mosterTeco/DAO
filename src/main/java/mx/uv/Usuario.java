package mx.uv;

public class Usuario {
String id;
String nombre;
String password;

public Usuario(String id,String nombre, String password){
    this.id=id;
    this.nombre=nombre;
    this.password=password;

}
public void setID(String id){
    this.id=id;
}
public void setNombre(String nombre){
    this.nombre=nombre;
}
public void setPassword(String password){
    this.password=password;
}

public String getNombre(){
    return nombre;
}

public String getId(){
    return id;
}

    public String getPassword(){
    return password;
}
}