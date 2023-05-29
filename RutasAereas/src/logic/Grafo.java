package logic;

import java.awt.*;
import java.awt.geom.*;
import java.util.*;


public class Grafo {
    private int orden; //orden del grafo (cantidad de vertices)
    private ArrayList <Vertice> vertices; //Grafo de Etiquetas
    private ArrayList <Vertice> recorrido; //Lista de etiquetas
    private ArrayList <Arista> recorridoAristas; 
    private Arista [][] M;  //matriz de adyacencia
	
    //Constructores
    public Grafo(){
	    this(20);
        vertices = new ArrayList<>();
        recorrido = new ArrayList<>();
        M = new Arista[20][20];
    }
    public Grafo(int orden){
        this.orden = orden;
        vertices = new ArrayList<> ();
        recorrido = new ArrayList<>();
        M = new Arista[orden][orden];
    }

    //Metodos ------------------------------------------
    
    //Sobrecarga de metodo agregar vertice
    public void agregarVertice(int x, int y){		
        Vertice v = new Vertice(x, y);
        vertices.add(v);
    }
    public void agregarVertice(int x, int y, String nombre, int index, int visa, String clima, String atracciones, String costo){		
        // Por hacer:
        Vertice v = new Vertice(x, y, nombre, index, visa, clima, atracciones, costo);
        vertices.add(v);
    }
    
	//obtiene el primer Vertice que contenga el punto p
    // public Vertice getVertice(Point2D p){
	//     for(Vertice v: vertices){
    //         if(v.getCirculo().contains(p)) 
    //             return v;
    //     }
    //     return null;
    // }

    public void agregarArista(Point2D po, Point2D pd, int peso){
        //indices
        int x = 0;
        int y = 0;

        
        for(Vertice v: vertices){
            if(v.getOrigen() == po){
                po = v.getOrigen();
                x = vertices.indexOf(v);
            }
            else if (v.getOrigen() == pd){
                pd = v.getOrigen();
                y = vertices.indexOf(v);
            }
        }

        if(po != null && pd != null){
            Arista a = new Arista(po, pd, peso);
            //a.setPeso();

            M[x][y] = a;
            M[y][x] = a;
        }
    }
	
    //mostrar la lista de vertices
    public String mostrarVertices(){
        String cad = " ";

        for(Vertice v: vertices) 
            cad += v.getNombre()+", ";
        return cad;
    }

    public String mostrarRecorrido(){
        String cad = "";
        for(Vertice v: recorrido){
            cad += v.getNombre() + " > ";
        }
        return cad;
    }

	public void dibujar(Graphics2D g2){
		//Todo: pintar aristas
        for(int i = 0; i < orden; i++){
            for(int j = 0; j < orden; j++){
                if(M[i][j] != null){
                    //M[i][j].dibujar(g2);
                    M[i][j].pintar(g2);
                }
            }
        }

        // //pintamos los vertices
	 	// for(Vertice v: vertices){
        //     v.dibujar(g2);
        // }

	}

    /*public void dibujar(Graphics2D graphics){
		//Todo: pintar aristas
       for (Arista arista : recorridoAristas) {
            arista.pintar(graphics);
       }


	}*/

    public void resetRecorrido(){
        for (Vertice v : vertices) {
            v.setVisitado(false);
        }
    }

    //Colorea los vertices
    // public void colorearVertices(Color color) {           
    //     for(Vertice v: vertices)
    //         v.setColor(color);
    // }

    /* RECORIDOS ----------------------------------------------------------------------------- */
	public void DFS(String nombre_vi) {
        Vertice v_aux = null;

        v_aux = buscarVi(nombre_vi);

        // Marcar el vértice actual como visitado y mostrarlo
        v_aux.setVisitado(true);
        System.out.print(v_aux.getNombre() + " ");

        recorrido.add(v_aux); //Llena el ArrayList recorrido

        // Recorrer todos los vértices adyacentes 
        for (int i = 0; i < orden; i++) {
            if (M[vertices.indexOf(v_aux)][i] != null && !vertices.get(i).isVisitado()) {
                DFS(vertices.get(i).getNombre());
            }
        }
	}

    /* RECORRIDO POR ARNCHURA ------------------------------------------------------------ */
	public void BFS(String nombre_vi) {
        Vertice v_aux = null;
        //Vertice inicial
        v_aux = buscarVi(nombre_vi);
        
        Queue<Vertice> cola = new LinkedList<Vertice>();
        
        v_aux.setVisitado(true);
        cola.add(v_aux);
        //recorrido.add(v_aux);

        while(!cola.isEmpty()){
            Vertice v = cola.poll();
            recorrido.add(v);

            for(int i = 0;  i < orden; i++){
                if (M[vertices.indexOf(v)][i] != null && !vertices.get(i).isVisitado()) {
                    vertices.get(i).setVisitado(true);
                    cola.add(vertices.get(i));
                    //recorrido.add(vertices.get(i));
                }
            }
        }
	}

    /*Camino mas corto  */
    public void caminoCorto(String nombre_vi){
        
        Vertice vk;

        Vertice vi = buscarVi(nombre_vi);
        //inicializacion del vertice inicial
        //vi.setVisitado(true);
        vi.setDv(0);
        vi.setPv(null);

        while(vi.isVisitado() == false){

            vi.setVisitado(true);
            //Buscamos los adyacentes de vi
            for(int i = 0;  i < orden; i++){
                if (M[vertices.indexOf(vi)][i] != null) { //vk -> vertices.get(i)
                    //conseguimos vk
                    vk = vertices.get(i);
                    //Si vk no esta visitado entonces
                    if(vk.isVisitado() == false){
                        //comparamos si el nuevo costo es menor que el ya asignado en vk
                        if(vk.getDv() == 0 && vk.getPv() == null){
                            vk.setDv((int) (vi.getDv() + M[vertices.indexOf(vi)][i].getPeso()));
                            vk.setPv(vi);
                        }
                        else if(vi.getDv() + M[vertices.indexOf(vi)][i].getPeso() < vk.getDv()){
                            //si si actualizamos el costo y el vertice proveniente
                            vk.setDv((int) (vi.getDv() + M[vertices.indexOf(vi)][i].getPeso()));
                            vk.setPv(vi);
                        }
                    }
                }
            }
            vi = verticeMenorDv(vertices);
            if(vi == null){
                break;
            }
        }
    }

    public void dijkstra(String nombre_vi, String nombre_vf){
        Stack <Vertice> pila = new Stack<>();
        //buscamos los vertices correspondientes al los nombres
        Vertice vi = buscarVi(nombre_vi);
        Vertice vf = buscarVi(nombre_vf);
        Vertice aux_1, aux_2;
        
        pila.add(vf);
        aux_1 = vf;
        
        do{
            aux_2 = aux_1.getPv();
            for (Vertice vertice : vertices) {
                if(vertice == aux_2){
                    pila.push(vertice);
                    //vertice = vertices.get(0);
                    aux_1 = vertice;
                    break;
                }
            }
        }while(aux_2 != vi);
        //pila.push(vi);

        int k = pila.size();
        //pasar los vertices de la pila al array recorrido
        for (int i = 0; i < k; i++){
            Vertice aux_3 = pila.pop();
            recorrido.add(aux_3);
        }
    }

    //busca el vertice no visitado con menor dv
    public Vertice verticeMenorDv(ArrayList <Vertice> vertices){
        Vertice minimo = buscarNoVisitado();

        if(minimo != null){
            for (int i = 1; i < vertices.size(); i++) {
                if (vertices.get(i).getDv() < minimo.getDv() && vertices.get(i).getPv() != null && vertices.get(i).isVisitado() == false) {
                    minimo = vertices.get(i);
                }
            }
            return minimo;
        }
        return null;
    }

    public Vertice buscarVi(String nombre_vi){
        //buscar el vertice con el nombre ingresado
        for (Vertice vi : vertices) {
            if(vi.getNombre().equals(nombre_vi)){
                return vi;
            }
        }
        return null;
    }

    public Vertice buscarNoVisitado(){
        for (Vertice  noVisit: vertices) {
            if(!noVisit.isVisitado()){
                return noVisit;
            }
        }
        return null;
    }

    public void checar_dvpv() {
        for (Vertice v : vertices) {
            if(v.getPv() != null){
                System.out.println("Nodo: " + v.getNombre() + " dv: " + v.getDv() + " di: " + v.getPv().getNombre());
            }
            else {
                System.out.println("Nodo: " + v.getNombre() + " dv: " + v.getDv() + " di: ninguno");
            }
        }
    }

    /*METODOS SET - / - GET ------------------------------------------------------------------------------ */

    public int getOrden() {
        return this.orden;
    }
    public void setOrden(int orden) {
        this.orden = orden;
    }
    public ArrayList<Vertice> getVertices() {
        return this.vertices;
    }
    public void setVertices(ArrayList<Vertice> vertices) {
        this.vertices = vertices;
    }
    public Arista[][] getM() {
        return this.M;
    }
    public void setM(Arista[][] M) {
        this.M = M;
    }
    public ArrayList<Vertice> getRecorrido() {
        return this.recorrido;
    }
    public ArrayList<Arista> getRecorridoAristas(){
        return this.recorridoAristas;
    }
    public Vertice buscaVertice(int index){
        return vertices.get(index);
    }
} // Fin clase