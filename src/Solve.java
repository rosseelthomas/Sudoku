import java.util.ArrayList;


public class Solve {

	 public static int[][] solve(int[][] sudokumatrix){
    
    for (int x=0;x<5;x++){
            for (int i=0;i<9;i++){
                    for (int j=0;j<9;j++){
                            ArrayList<Integer> hor=getMogelijkhedenHorizontaal(sudokumatrix,i,j);
                            ArrayList<Integer> ver=getMogelijkhedenVerticaal(sudokumatrix,i,j);
                            ArrayList<Integer> vier=getMogelijkhedenVierkant(sudokumatrix,i,j);
                            ArrayList<Integer> com=new ArrayList<Integer>();
                            if(hor.size()==1){
                                    sudokumatrix[i][j]=hor.get(0);
                            }
                            else if(ver.size()==1){
                                    sudokumatrix[i][j]=ver.get(0);
                            }else if(vier.size()==1){
                                    sudokumatrix[i][j]=vier.get(0);
                           
                            }else {
                                   
                                    for(int z:hor){
                                           
                                            if (ver.contains(z)&&vier.contains(z)){
                                                    com.add(z);
                                                   
                                            }
                                    }
                                    if(com.size()==1){
                                            
                                            sudokumatrix[i][j]=com.get(0);
                                    }
                            }
                    }
            }
    }
   /**
    for (int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                    System.out.print(sudokumatrix[i][j]);
                    System.out.print(" ");
            }
            System.out.print("\n");
    }
    */
   return sudokumatrix;
}


public static ArrayList<Integer> getMogelijkhedenVerticaal(int [][] matrix,int rij, int kolom){
   
    ArrayList<Integer> mogelijkheden=new ArrayList<Integer>();
    for(int i=1;i<=9;i++){
            mogelijkheden.add(i);
    }
    for (int i=0;i<9;i++){
            if(matrix[i][kolom]!=-1 && i!=rij && mogelijkheden.contains(matrix[i][kolom])){
                   
                   
                    mogelijkheden.remove(mogelijkheden.indexOf(matrix[i][kolom]));
            }
    }
    return mogelijkheden;
}

public static ArrayList<Integer> getMogelijkhedenHorizontaal(int [][] matrix,int rij, int kolom){
           
    ArrayList<Integer> mogelijkheden=new ArrayList<Integer>();
    for(int i=1;i<=9;i++){
            mogelijkheden.add(i);
    }
    for (int i=0;i<9;i++){
           
            if(matrix[rij][i]!=-1 && i!=kolom && mogelijkheden.contains(matrix[rij][i])){
                    mogelijkheden.remove(mogelijkheden.indexOf(matrix[rij][i]));
            }
    }
    return mogelijkheden;
}
   

public static ArrayList<Integer> getMogelijkhedenVierkant(int [][] matrix,int rij, int kolom){
    ArrayList<Integer> mogelijkheden=new ArrayList<Integer>();
    for(int i=1;i<=9;i++){
            mogelijkheden.add(i);
    }
    int deelrij=(rij%3);
    int deelkolom=(kolom%3);
   
   
    int[] tr={-1,-1,-1};
    int[] trr={-1,-1,-1};
    int[] trrr={-1,-1,-1};
    int[][] deelmatrix={tr,trr,trrr};
    for(int u=rij-deelrij;u<=rij-deelrij+2;u++){
            for(int v=kolom-deelkolom;v<=kolom-deelkolom+2;v++){
                    int nr=(u%3);
                    int nk=(v%3);
                    deelmatrix[nr][nk]=matrix[u][v];
                    
            }
    }
   
    for(int d=0;d<3;d++){
            for(int f=0;f<3;f++){
                    if(d!=deelrij && f!=deelkolom && deelmatrix[d][f]!=-1 && mogelijkheden.contains(deelmatrix[d][f])){
                            mogelijkheden.remove(mogelijkheden.indexOf(deelmatrix[d][f]));
                    }
            }
    }
    return mogelijkheden;
}

}

	

