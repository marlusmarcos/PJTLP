import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfFloat;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.HOGDescriptor;

public class Redimencionar extends Caracteristica {
	Path caminho = Paths.get("teste_2019_1.csv");	
	static ArrayList <Caracteristica> imagens = new ArrayList();

	
	public static void main(String[] args) {
		/*
		 * Processo no qual faz leitura de arquivos
		 * lerArq é o obj no qual contém o arquivo
		 */
		try {
		      FileReader arq = new FileReader("teste_2019_1.csv");
		      BufferedReader lerArq = new BufferedReader(arq);
		 
		      String linha = lerArq.readLine(); // lê a primeira linha
		// a variável "linha" recebe o valor "null" quando o processo
		// de repetição atingir o final do arquivo texto
		      int k = 0;
		      while (k  <= 2) {
		        /*
		         * Inicializa a váriável aux com uma linha do dataset  para poder usar o método split
		         */
		    	String aux = lerArq.readLine(); // lê da segunda até a última linha
		    	int i = 0;
		    	String cc = null;
		    	Caracteristica c1 = new Caracteristica();
		    	while (i < 1001) {
		    		cc = aux.split(",")[i];
		    		if (i == 1000 ) {
		    			if (cc.equals("person")) {
		    			c1.setTipo("person");
		    			break;
		    			}
		    				c1.setTipo("noPerson");
		    			
		    			break;
		    			
		    		}
		    		
		    		//System.out.println(c1.getTipo());
		    		float f = Float.parseFloat(cc);
		    		c1.setInformacao(f);
		    		
		    		cc = "";
		    		i++;
		    	}
		    	imagens.add(c1);
		    	k++;
		      }
		      arq.close();
	    } catch (IOException e) {
	        System.err.printf("Erro na abertura do arquivo: %s.\n",
	          e.getMessage());
	    }
	//System.out.print ("\n");
				
	System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
	
		HOGDescriptor hog = new HOGDescriptor();
		Mat img = new Mat();
		MatOfFloat features = new MatOfFloat();
		img = Imgcodecs.imread("C:\\Users\\Marlus\\Desktop\\imgs.png", Imgcodecs.IMREAD_GRAYSCALE);
		Imgproc.resize(img, img, new Size(64,128), 0.5, 0.5, Imgproc.INTER_LINEAR);
		hog.compute(img,features);
		
		List<Float> arrayOfFeatures = features.toList();
		//for (float kj : arrayOfFeatures) {
			//System.out.print(kj + " ");
			
		//}
	//	System.out.println (arrayOfFeatures.size());
		for (int i = 0; i < 1; i ++) {
			for (int k = 0; k < 1000; k++) {
				System.out.print (imagens.get(i).getInformacao(k) + ", ");
			}
			System.out.print (imagens.get(i).getTipo());
			System.out.println();
			
		}
	}
}


