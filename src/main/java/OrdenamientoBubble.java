public class OrdenamientoBubble {
    public OrdenamientoBubble(){

    }
    public static void ordenandoBubble(int[] b){

        int aux;
        boolean cambia = false;
        while (true){
            cambia=false;
            for (int i=1;i<b.length;i++){
                if (b[i]<b[i-1]){
                    aux = b[i];
                    b[i]=b[i-1];
                    b[i-1]=aux;
                    cambia=true;
                }
            }
            if (cambia==false){
                break;
            }
        }

    }
}
