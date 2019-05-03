package arboles;

public class nodo
{
    private String valor;
    private int contador;
 
    public String getValor(){
         return this.valor;}
 
    public void setValor(String valor){
        this.valor = valor;}
    
    public int getContador() {
         return this.contador;}
 
    public void setContador(int contador){
         this.contador = contador;}
   
    public nodo(String valor, int contador){
        this.valor = valor;
        this.contador = contador;}
 }