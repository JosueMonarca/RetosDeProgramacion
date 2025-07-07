package org.yourcompany.yourproject;

public class Matris {
    private final char[][] laberinto = {
        {'M', '#', '#', '#', '#', '#'},
        {' ', ' ', ' ', ' ', '#', '#'},
        {'#', ' ', '#', ' ', ' ', '#'},
        {'#', ' ', '#', '#', ' ', '#'},
        {'#', ' ', ' ', '#', ' ', '#'},
        {'#', '#', '#', '#', 'S', '#'},
    };
    
    private boolean haSalido = false;

    private final int[] raton = {0,0};

    public char[][] getLaberinto(){
        return laberinto;
    }

    public int[] getRaton(){
        return raton;
    }

    public int[] size(){
        int[] size = {laberinto.length, laberinto[0].length};
        return  size;
    }

    public int getHeight(){
        return laberinto.length;
    }

    public int getWidth(){
        return laberinto[0].length;
    }

    public boolean getHaSalido(){
        return haSalido;
    }

    public void moveRigth(){
        if(raton[1] + 1 < getWidth()){
            if(laberinto[raton[0]][raton[1] + 1] == 'S') haSalido = true;
            if(laberinto[raton[0]][raton[1] + 1] != '#'){
                laberinto[raton[0]][raton[1]] = ' ';
                raton[1]= raton[1] +1;
                laberinto[raton[0]][raton[1]] = 'M';
            }
        }
    }

    public void moveLeft(){
        if(raton[1] - 1 >= 0){
            if(laberinto[raton[0]][raton[1] - 1] == 'S') haSalido = true;
            if(laberinto[raton[0]][raton[1] - 1] != '#'){
                laberinto[raton[0]][raton[1]] = ' ';
                raton[1]= raton[1] - 1;
                laberinto[raton[0]][raton[1]] = 'M';
            }
        }
    }

    public void moveAbove(){
        if(raton[0] - 1 >= 0){
            if(laberinto[raton[0] - 1][raton[1]] == 'S') haSalido = true;
            if(laberinto[raton[0] - 1][raton[1]] != '#'){
                laberinto[raton[0]][raton[1]] = ' ';
                raton[0]= raton[0] - 1;
                laberinto[raton[0]][raton[1]] = 'M';
            }
        }
    }

    public void moveBelow(){
        if(raton[0] + 1 < getHeight()){
            if(laberinto[raton[0] + 1][raton[1]] == 'S') haSalido = true;
            if(laberinto[raton[0] + 1][raton[1]] != '#'){
                laberinto[raton[0]][raton[1]] = ' ';
                raton[0]= raton[0] + 1;
                laberinto[raton[0]][raton[1]] = 'M';
            }
        }
    }

    public void moverConTecla(char tecla){
        switch (tecla) {
            case 'w' -> moveAbove();
            case 's' -> moveBelow();
            case 'd' -> moveRigth();
            case 'a' -> moveLeft();
            default -> System.out.println("ERROR CLAVE DESCONOZIDA");
        }
    }
}
