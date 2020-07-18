/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Johan López
 */
public class ListaSimple {

    private Nodo inicio;
    private Nodo fin;
    public Nodo EstadoActual;
    int band, cont;

    public ListaSimple() {
        this.inicio = null;
        this.fin = null;
        this.EstadoActual = null;
        this.band = 0;
        this.cont = 0;
    }

    public Nodo getInicio() {
        return inicio;
    }

    public void setInicio(Nodo inicio) {
        this.inicio = inicio;
    }

    public Nodo getFin() {
        return fin;
    }

    public void setFin(Nodo fin) {
        this.fin = fin;
    }

    public Nodo getEstadoActual() {
        return EstadoActual;
    }

    public void setEstadoActual(Nodo EstadoActual) {
        this.EstadoActual = EstadoActual;
    }

    public int getBand() {
        return band;
    }

    public void setBand(int band) {
        this.band = band;
    }

    public int getCont() {
        return cont;
    }

    public void setCont(int cont) {
        this.cont = cont;
    }

    public boolean Vacia() {
        boolean resp;
        if (this.inicio == null && this.fin == null) {
            resp = true;
        } else {
            resp = false;
        }
        return resp;
    }


    public void Insertar(String Nombre, String Marca, String porcientoAlcohol, String Precio,  String Tamano, String tipoCerveza, String Presentacion) {
        Nodo nuevo_N = new Nodo();
         this.Contador++;
         nuevo_N.setNum(Contador);
        nuevo_N.setNombre(Nombre);
        nuevo_N.setMarca(Apellido);
        nuevo_N.setPorcientoAlcohol(porcientoAlcohol);
        nuevo_N.setPrecio(Precio);
        nuevo_N.setTamano(Tamano);
        nuevo_N.setTipoCerveza(tipoCerveza);
        nuevo_N.setPresentacion(Presentacion);
        

        if (Vacia()) {
            this.inicio = nuevo_N;
            this.fin = nuevo_N;
            this.EstadoActual = inicio;
        } else {
            this.fin.setSiguiente(nuevo_N);
            nuevo_N.setAnterior(this.fin);
            this.fin = nuevo_N;
        }
    }

    public Nodo mostrarLista() {
        Nodo aux = new Nodo();
        aux = EstadoActual;
        if (Vacia()) {
            JOptionPane.showMessageDialog(null, "No hay ningun registro por mostrar");

        } else {
            if (aux != null) {
                aux.getNombre();
                aux.getMarca();
                aux.getPorcientoAlcohol();
                aux.getPrecio();
                aux.getTamano();
                aux.getTipoCerveza();
                aux.getPresentacion()
                
            }
        }

        this.EstadoActual = aux.getSiguiente();
        return aux;
    }


    public void Enumerar(){
        Nodo aux =this.inicio;
        
       //Contador=Contador-1;
        if (Vacia()==false){
            do{
                aux.setNum(Contador);
                aux=aux.getSiguiente();               
            }while(aux!=null);
        }
    }

    public boolean Buscar(int num){
        Nodo aux = this.inicio;
        boolean r;
        r=false;
        if (Vacia()!=false){
            JOptionPane.showMessageDialog(null,"No hay ningún registro");
        }
        else{
            do{
               if(aux.getNum()==num) {
                   r=true;                    
               }
               aux=aux.getSiguiente();
            }while(aux!=null);
        }
        return r;
    }



    public void Eliminar(int n){
        
         
        if (Vacia()==false){
           Nodo Actual= this.inicio;
           Nodo ActBorrar = Actual.getSiguiente();
           if(Actual.getNum()==n&&this.inicio==this.fin){
               this.inicio=null;
               this.fin=null;
               EstadoActual=null;
               Contador=0;
           }
           else{
               if(Actual.getNum()==n && Actual==inicio &&Actual.getSiguiente()==this.fin){
                   this.inicio=this.inicio.getSiguiente();
                   Contador=Contador-1;
               }
               else{
                   if(ActBorrar.getNum()==n && Actual==inicio && Actual.getSiguiente()==this.fin && ActBorrar.getSiguiente()==null){
                       Actual.setSiguiente(null);
                       this.fin=this.inicio;
                       Contador--;
                   }
                   else{
                       while(Actual.getSiguiente()!=null){
                        if(ActBorrar.getNum()==n){
                           Nodo BorrarSig = ActBorrar.getSiguiente();
                           Actual.setSiguiente(BorrarSig);
                           Contador--;
                           //break;
                        }
                        Actual=Actual.getSiguiente();
                        if(Actual.getSiguiente()!=null){
                           ActBorrar= Actual.getSiguiente();
                           Contador--;
                        }
                       }
                       
                   }
               }
           }
        }
    }


    public void ModificarRegistro(String Nombre, String Marca, String porcientoAlcohol, String Precio,  String Tamano, String tipoCerveza, String Presentacion){
        Nodo Aux=this.inicio;
        if (Vacia()){
            JOptionPane.showMessageDialog(null,"No hay ningún registro");
        }
        else{
            do{
                if(Aux.getNum()==Num){
                    Aux.setNombre(Nombre);
                    Aux.setMarca(Marca);
                    Aux.setPorcientoAlcohol(porcientoAlcohol);
                    Aux.setPrecio(Precio);
                    Aux.setTamano(Tamano);
                    Aux.setTipoCerveza(tipoCerveza);
                    Aux.setPresentacion(Presentacion);
                    
                }
                Aux=Aux.getSiguiente();
            }while (Aux!=null);
        }
    }    




    public void GuardarArchivo(){
        try{
            Nodo auxiliar = this.inicio;
            FileWriter fw = new FileWriter("Datos.txt",false);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            do{
                pw.print(auxiliar.getNum()+"|");
                pw.print(auxiliar.getNombre()+"|");
                pw.print(auxiliar.getMarca()+"|");
                pw.print(auxiliar.getPorcientoAlcohol()+"|");
                pw.print(auxiliar.getPrecio()+"|");
                pw.print(auxiliar.getTamano()+"|");
                pw.print(auxiliar.getTipoCerveza()+"|");
                pw.print(auxiliar.getPresentacion()+"|");
                
                pw.println();
                auxiliar=auxiliar.getSiguiente();
            }while(auxiliar!=null);
            JOptionPane.showMessageDialog(null, "Los datos han sido almacenados correctamente.");
            pw.close();
            bw.close();
            fw.close();
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "No se ha podido completar la operación. \nIntente de nuevo más tarde");
        }
    }




    public void CargarArchivos(){
        try{
            FileReader fr = new FileReader("Datos.txt");
            BufferedReader br = new BufferedReader(fr);
            String line;
            Nodo auxiliar = new Nodo();
            while((line=br.readLine())!=null){
                StringTokenizer data = new StringTokenizer(line,"|");
                int token=0;
                while(data.hasMoreTokens()){
                    switch(token){
                        case 0:
                            auxiliar.setNum(Integer.parseInt(String.valueOf(data.nextToken())));
                            token++;
                            break;
                        case 1: 
                            auxiliar.setNombre(String.valueOf(data.nextToken()));
                            token++;
                            break;
                        case 2:
                            auxiliar.setMarca(String.valueOf(data.nextToken()));
                            token++;
                            break;
                        case 3:
                            auxiliar.setPorcientoAlcohol(String.valueOf(data.nextToken()));
                            token++;
                            break;
                        case 4:
                            auxiliar.setPrecio(String.valueOf(data.nextToken()));
                            token++;
                            break;
                        case 5:
                            auxiliar.setTamano(String.valueOf(data.nextToken()));
                            token++;
                            break;
                        case 6:
                            auxiliar.setTipoCerveza(String.valueOf(data.nextToken()));
                            token++;
                            break;
                        case 7:
                            auxiliar.setPresentacion(String.valueOf(data.nextToken()));
                            token++;
                            break;
                      
                    }
                }
                this.Insertar(auxiliar);
                Contador=auxiliar.getNum();
            }
            JOptionPane.showMessageDialog(null, "Los datos han sigo cargados.");
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "No se ha podido completar la operación. \nIntente de nuevo más tarde");
        }
        }


        public void Insertar(Nodo aux){
            Nodo nvoNodo = new Nodo();
            nvoNodo.setNum(aux.getNum());
            nvoNodo.setNombre(aux.getNombre());
            nvoNodo.setMarca(aux.getMarca());
            nvoNodo.setPorcientoAlcohol(aux.getPorcientoAlcohol());
            nvoNodo.setPrecio(aux.getPrecio());
            nvoNodo.setTamano(aux.getTamano());
            nvoNodo.setTipoCerveza(aux.getTipoCerveza());
            nvoNodo.setPresentacion(aux.getPresentacion());
            if(Vacia()){
                this.inicio=nvoNodo;
                this.fin=nvoNodo;
                this.EstadoActual=inicio;
            } else{
               this.fin.setSiguiente(nvoNodo);
               this.fin=nvoNodo;
               
            }
            
        }
}
